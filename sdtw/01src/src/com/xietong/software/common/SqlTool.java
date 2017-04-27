package com.xietong.software.common;
import java.sql.*;
import java.io.*;
import java.util.*;

import com.xietong.software.system.*;
import com.xietong.software.util.*;
import oracle.sql.*;
import oracle.jdbc.driver.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.regexp.*;

public class SqlTool {

    public static final int ORACLE = 0;
    public static final int MYSQL = 1;
    public static final int DB2 = 2;
    public static final int SQLSERVER = 3;

    private static Log log = LogFactory.getLog(SqlTool.class);
    private int dbType;
    private String db;
    private String table;
    private String blobColumn;
    private String keyColumn;
    private static final boolean CANUPDATE = true;

    public void setTable(String table) { this.table = table; }
    public void setDb(String db) { this.db = db; }
    public void setBlobColumn(String blobColumn) { this.blobColumn = blobColumn; }
    public void setKeyColumn(String keyColumn) { this.keyColumn = keyColumn; }

    public static String getDbString(String str)
    {
        if((str==null)||(str.trim().length() == 0))
            return "";
        else
            return (str.trim()); 
    }

    public static String subString(String str, int size)
    {
        if (str.trim().length() <= size) {
            return (str).trim();
        } else {
            return (str).trim().substring(0, size) + "...";
        }
    }

    public static void setDateFromDb(java.util.Date aDate, java.sql.Timestamp dbDate)
    {
        if (dbDate != null) {
            aDate = new java.util.Date(dbDate.getTime());
        }
    }

    public static int getCount(String jndiName, String adb ,String awhere)
    {
        String SELECT = "SELECT count(*) num FROM " + adb + " where " + awhere;
        Connection con = null;
        Statement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try
        {
            con = DbConnectionManager.getConnection(jndiName);
            pstmt = con.createStatement();
            rs = pstmt.executeQuery(SELECT);
            if (rs.next())
            {
                count = rs.getInt("num");
            }
            rs.close();
            rs = null;
            pstmt.close();
            pstmt = null;
            con.close();
            con = null;
        }
        catch( SQLException sqle )
        {
            sqle.printStackTrace();
        }
        finally
        {
            if (rs != null) {
                try {  rs.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (pstmt != null) {
                try {  pstmt.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (con != null) {
                try {  con.close();   }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return count;
    }


    public static int executeSql(String jndiName, String aSql) {
        int iResult = 0;
        Connection con=null;
        PreparedStatement pstmt = null;
        try
        {
            con = DbConnectionManager.getConnection(jndiName);
            pstmt = con.prepareStatement(aSql);
            iResult = pstmt.executeUpdate();
            pstmt.close();
            pstmt = null;
            con.close();
            con = null;
        }
        catch( SQLException sqle )
        {
            System.out.print(aSql);
            sqle.printStackTrace();
            return iResult;
        }
        finally
        {
            try {  pstmt.close(); }
            catch (Exception e) { e.printStackTrace(); }
            try {  con.close();   }
            catch (Exception e) { e.printStackTrace(); }
        }
        return iResult;
    }

    public static synchronized int getNextSn(DaoBase db, Connection con) {
        if (db.getDbType().equals("oracle")) {
        	if(db.getDBNAME().equals("usashop.\"order\""))
        		return queryNumber(con, "SELECT usashop.order_seq.nextval FROM dual");
        	else if(db.getDBNAME().equals("usashop.\"add\""))
        		return queryNumber(con, "SELECT usashop.add_seq.nextval FROM dual");
        	else
        		return queryNumber(con, "SELECT " + db.getDBNAME() + "_seq.nextval FROM dual");
        }
        if (db.getDbType().equals("mysql")) {
            return (queryNumber(con, "SELECT max(" + db.getPKey() + ") FROM " + db.getDBNAME()) + 1);
        }
        if (db.getDbType().equals("db2")) {
            return queryNumber(con, "SELECT nextval for " + db.getDBNAME() + "_seq from " + db.getDBNAME());
        }
        return 0;
    }

    public static int queryNumber(Connection con, String sql) {
        int iResult = 0;
        Statement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.createStatement();
            rs = pstmt.executeQuery(sql);
            if (rs.next()) {
                iResult = rs.getInt(1);
            }
        } catch( SQLException sqle ) {
            sqle.printStackTrace();
        } finally {
            if (rs != null) {
                try {  rs.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (pstmt != null) {
                try {  pstmt.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return iResult;
    }

    public static List changeCondition(DaoBase db, List condition)
    {
        List cdt = new ArrayList();
        for (Iterator it = condition.iterator(); it.hasNext();) {
            String str = (String)it.next();
            cdt.add(new String(str));
        }
        if (db.getDbType().equals("mysql")) {
            return cdt;
        }
        for (int i = 0; i < cdt.size(); i ++) {
            String cstr = (String)cdt.get(i);
            if (cstr.toUpperCase().regionMatches(0, "LIMIT ", 0, 6)) {
            } else if (cstr.toUpperCase().regionMatches(0, "ORDER ", 0, 6)) {
            } else {
                String patternStr = "([^<>=!]*) *([<>!]=|[<>=]) *(.*)";
                String[] l = {"", "", "", ""};

                RE pattern = new RE(patternStr);

                if (pattern.match(cstr)) {
                    for (int j = 0; j < 4; j++) {
                        l[j] = pattern.getParen(j);
                    }
                    if (Tool.inArray(l[1].toUpperCase(), db.getDateFields())) {
                        if (db.getDbType().equals("oracle")) {
                            cdt.set(i ,l[1] + l[2] + "to_date(" + l[3] + ", 'yyyy-mm-dd hh24:mi:ss')");
                        } else if (db.getDbType().equals("db2")) {
                            cdt.set(i ,l[1] + l[2] + "timestamp(" + l[3] + ")");
                        }
                    }
                }
            }
        }
        return cdt;
    }
    public static String getSql(DaoBase db, String sql, List condition, boolean includeLimitOrder)
    {
        List cdt = changeCondition(db, condition);
        String limithead = "";
        String limitmiddle = "";
        String limittail = "";
        List wlist = new ArrayList();
        String order = "";
        for (Iterator it = cdt.iterator(); it.hasNext();) {
            String cstr = db.toDbCh((String)it.next());
            if (cstr.toUpperCase().regionMatches(0, "LIMIT ", 0, 6)) {
                if (includeLimitOrder) {
                    if (db.getDbType().equals("oracle")) {
                        cstr = cstr.substring(6);
                        int pos = cstr.indexOf(",");
                        int index = StrTool.toInt((cstr.substring(0, pos)).trim());
                        int size = StrTool.toInt((cstr.substring(pos + 1)).trim());
                        limithead = "SELECT * FROM (" + sql.substring(0, sql.indexOf("FROM")) + ", rownum qbcRownum FROM (";
                        limitmiddle = "";
                        limittail = ")) WHERE qbcRownum>" + index + " and qbcRownum<=" + (index + size);
                    } else if (db.getDbType().equals("db2")) {
                        cstr = cstr.substring(6);
                        int pos = cstr.indexOf(",");
                        int index = StrTool.toInt((cstr.substring(0, pos)).trim());
                        int size = StrTool.toInt((cstr.substring(pos + 1)).trim());
                        limithead = "SELECT * FROM (";
                        limitmiddle = ", row_number() over (order by " + db.getPKey() + ") as qbcRownum";
                        limittail = ") as rslt WHERE qbcRownum>=" + index + " and qbcRownum<=" + (index + size);
                    } else if (db.getDbType().equals("mysql")) {
                        limithead = "";
                        limitmiddle = "";
                        limittail= " " + cstr;
                    }else if(db.getDbType().equals("sqlserver")){//针对sqlserver2005
	                	 cstr = cstr.substring(6);
	                     int pos = cstr.indexOf(",");
	                     int index = StrTool.toInt((cstr.substring(0, pos)).trim());
	                     int size = StrTool.toInt((cstr.substring(pos + 1)).trim());
                    	limithead = "SELECT * FROM (";
                        limitmiddle = ", row_number() over (order by " + db.getPKey() + ") as qbcRownum";
                        limittail = ") as rslt WHERE qbcRownum>=" + index + " and qbcRownum<=" + ( size);
                    }
                }
            } else if (cstr.toUpperCase().regionMatches(0, "ORDER ", 0, 6)) {
                if (includeLimitOrder) {
                    order = " " + cstr;
                }
            } else {
                wlist.add(cstr);
            }
        }
        String rtn = limithead + sql;
        if (wlist.size() > 0) {
            if (limitmiddle.length() > 0) {
            	rtn = rtn.replaceAll(" FROM ", limitmiddle + " FROM ") ;
                rtn = rtn + " WHERE " + Tool.join(" AND ", wlist);
            } else {
                rtn = rtn.replaceAll(" FROM ", limitmiddle + " FROM ") + " WHERE " + Tool.join(" AND ", wlist);
            }
        }else if(wlist.size()==0&&limitmiddle.length()>0){//2012-10-10添加 针对sqlserver2005
        	rtn = rtn.replaceAll(" FROM ", limitmiddle + " FROM ") ;
        }
        rtn = rtn + order + limittail;
        //log.debug(db.getDBNAME() + ":" + rtn);
        log.debug(db.getDBNAME() + ":" + Tool.join(" && ", wlist));
        return rtn;
    }

    public SqlTool(int dbType, String db, String table, String blobColumn, String keyColumn)
    {
        this.dbType = dbType;
        this.db = db;
        this.table = table;
        this.blobColumn = blobColumn;
        this.keyColumn = keyColumn;
    }

    public SqlTool(String db, String table, String blobColumn, String keyColumn)
    {
        this.dbType = ORACLE;
        this.db = db;
        this.table = table;
        this.blobColumn = blobColumn;
        this.keyColumn = keyColumn;
    }

    public SqlTool(int dbType, String table, String blobColumn, String keyColumn)
    {
        this.dbType = dbType;
        this.table = table;
        this.blobColumn = blobColumn;
        this.keyColumn = keyColumn;
    }
    public SqlTool(String table, String blobColumn, String keyColumn)
    {
        this.dbType = ORACLE;
        this.table = table;
        this.blobColumn = blobColumn;
        this.keyColumn = keyColumn;
    }
    public void setClob(String jndiName, String content, int keyValue)
    {
        if (!CANUPDATE) {
            return;
        }
        if (dbType == ORACLE) {
            setClobOracle(jndiName, content, keyValue);
        } else if (dbType == MYSQL) {
            setClobMysql(jndiName, content, keyValue);
        } else if (dbType == DB2) {
            setClobDb2(jndiName, content, keyValue);
        }
    }
    public void setClobOracle(String jndiName, String content, int keyValue)
    {
        String SQL = "SELECT " + blobColumn + " FROM " + db + "." + table + " WHERE " + keyColumn +"=? FOR UPDATE ";
        Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "";
            String key ="";

            conn = DbConnectionManager.getConnection(jndiName);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, keyValue);
            rs= stmt.executeQuery();
            oracle.sql.CLOB clobtt = null;
            if(rs.next()){
                clobtt = (oracle.sql.CLOB)rs.getClob(1);
            }
            Writer wr = clobtt.getCharacterOutputStream();
            wr.write(content);
            wr.flush();
            wr.close();
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.commit();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void setClobMysql(String jndiName, String content, int keyValue)
    {
        String SQL = "SELECT " + blobColumn + " FROM " + db + "." + table + " WHERE " + keyColumn +"=? FOR UPDATE ";
        Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "";
            String key ="";

            conn = DbConnectionManager.getConnection(jndiName);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, keyValue);
            rs= stmt.executeQuery();
            Clob clobtt = null;
            if(rs.next()){
                clobtt = (Clob)rs.getClob(1);
            }
            Writer wr = clobtt.setCharacterStream(0);
            wr.write(content);
            wr.flush();
            wr.close();
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.commit();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void setClobDb2(String jndiName, String content, int keyValue)
    {
        String SQL = "SELECT " + blobColumn + " FROM " + db + "." + table + " WHERE " + keyColumn +"=? FOR UPDATE ";
        Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "";
            String key ="";

            conn = DbConnectionManager.getConnection(jndiName);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, keyValue);
            rs= stmt.executeQuery();
            Clob clobtt = null;
            if(rs.next()){
                clobtt = (Clob)rs.getClob(1);
            }
            Writer wr = clobtt.setCharacterStream(0);
            wr.write(content);
            wr.flush();
            wr.close();
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.commit();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void setBlob(String jndiName, InputStream inVal, int keyValue)
    {
        if (!CANUPDATE) {
            return;
        }
        if (dbType == ORACLE) {
            setBlobOracle(jndiName, inVal, keyValue);
        } else if (dbType == MYSQL) {
            setBlobMysql(jndiName, inVal, keyValue);
        } else if (dbType == DB2) {
            setBlobDb2(jndiName, inVal, keyValue);
        }
    }
    public void setBlobOracle(String jndiName, InputStream inVal, int keyValue)
    {
    	Connection conn = null;
        PreparedStatement stmt = null;
        
        /**
         * ����blobǰ�������
         * begin
         */
        PreparedStatement stmt2 = null;
        String sqlClearString = "UPDATE " + db + "." + table +" set "+blobColumn+"=EMPTY_BLOB() WHERE ID = ?";
        /**
         * end
         */
        String SQL = "SELECT " + blobColumn + " FROM " + db + "." + table + " WHERE " + keyColumn +"=? FOR UPDATE ";
        ResultSet rs = null;
        try {
            oracle.sql.BLOB blob = null;
            conn = DbConnectionManager.getConnection(jndiName);
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(SQL);
            stmt2 = conn.prepareStatement(sqlClearString);
            stmt2.setInt(1, keyValue);
            stmt2.executeUpdate();
            stmt.setInt(1,keyValue);
            rs = stmt.executeQuery();
            if (rs.next())
            {
                blob = (oracle.sql.BLOB)rs.getBlob(1);
                OutputStream outstream = blob.getBinaryOutputStream();
                int bufferSize = blob.getChunkSize();
                byte[] buffer = new byte[bufferSize];
                int readLength = -1;
                int totalLength = 0;
                while ((readLength = inVal.read(buffer)) != -1) {
                    outstream.write(buffer, 0, readLength);
                    totalLength += readLength;
                }
                outstream.close();
            }
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt2 != null) {
                try {
                    stmt2.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.commit();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void setBlobMysql(String jndiName, InputStream inVal, int keyValue)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        String SQL = "UPDATE " + db + "." + table + " SET " + blobColumn + "=? " + " WHERE " + keyColumn +"=?";
        try {
            Blob blob = null;
            Base64.InputStream b64in = new Base64.InputStream(inVal, Base64.ENCODE);
            conn = DbConnectionManager.getConnection(jndiName);
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(SQL);
            stmt.setBinaryStream(1, b64in, b64in.available());
            stmt.setInt(2,keyValue);
            stmt.executeUpdate();
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.commit();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void setBlobDb2(String jndiName, InputStream inVal, int keyValue)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        String SQL = "UPDATE " + db + "." + table + " SET " + blobColumn + "=? " + " WHERE " + keyColumn +"=?";
        try {
            Blob blob = null;
            conn = DbConnectionManager.getConnection(jndiName);
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(SQL);
            stmt.setBinaryStream(1, inVal, inVal.available());
            stmt.setInt(2,keyValue);
            stmt.executeUpdate();
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.commit();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String getClob(String jndiName, int keyValue)
    {
        String rtn = "";
        if (dbType == ORACLE) {
            rtn = getClobOracle(jndiName, keyValue);
        } else if (dbType == MYSQL) {
            rtn = getClobMysql(jndiName, keyValue);
        } else if (dbType == DB2) {
            rtn = getClobDb2(jndiName, keyValue);
        } 
        return rtn;
    }
    public String getClobOracle(String jndiName, int keyValue)
    {
        String SQL = "SELECT " + blobColumn + " FROM " + db + "." + table + " WHERE " + keyColumn +"=?";
        Connection conn = null;
        String buffer = "";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DbConnectionManager.getConnection(jndiName);
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, keyValue);
            rs = stmt.executeQuery();
            if(rs.next()) {
                oracle.sql.CLOB clobtmp = (oracle.sql.CLOB) rs.getClob(1);
                if(clobtmp==null || clobtmp.length()==0) {
                    buffer = "";
                } else {
                    buffer = clobtmp.getSubString((long)1,(int)clobtmp.length());
                }
            }
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }
    public String getClobMysql(String jndiName, int keyValue)
    {
        String SQL = "SELECT " + blobColumn + " FROM " + db + "." + table + " WHERE " + keyColumn +"=?";
        Connection conn = null;
        String buffer = "";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DbConnectionManager.getConnection(jndiName);
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, keyValue);
            rs = stmt.executeQuery();
            if(rs.next()) {
                Clob clobtmp = (Clob) rs.getClob(1);
                if(clobtmp==null || clobtmp.length()==0) {
                    buffer = "";
                } else {
                    buffer = clobtmp.getSubString((long)1,(int)clobtmp.length());
                }
            }
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }
    public String getClobDb2(String jndiName, int keyValue)
    {
        String SQL = "SELECT " + blobColumn + " FROM " + db + "." + table + " WHERE " + keyColumn +"=?";
        Connection conn = null;
        String buffer = "";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DbConnectionManager.getConnection(jndiName);
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, keyValue);
            rs = stmt.executeQuery();
            if(rs.next()) {
                Clob clobtmp = (Clob) rs.getClob(1);
                if(clobtmp==null || clobtmp.length()==0) {
                    buffer = "";
                } else {
                    buffer = clobtmp.getSubString((long)1,(int)clobtmp.length());
                }
            }
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }
   
    public InputStream getBlob(String jndiName, int keyValue)
    {
        InputStream rtn = new ByteArrayInputStream(new byte[0]);
        if (dbType == ORACLE) {
            rtn = getBlobOracle(jndiName, keyValue);
        } else if (dbType == MYSQL) {
            rtn = getBlobMysql(jndiName, keyValue);
        } else if (dbType == DB2) {
            rtn = getBlobDb2(jndiName, keyValue);
        }
        return rtn;
    }
    public InputStream getBlobOracle(String jndiName, int keyValue)
    {
        String SQL = "SELECT " + blobColumn + " FROM " + db + "." + table + " WHERE " + keyColumn +"=?";
        Connection conn = null;
        InputStream rtn = new ByteArrayInputStream(new byte[0]);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try
        {
            conn = DbConnectionManager.getConnection(jndiName);
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, keyValue);
            rs = stmt.executeQuery();
            if (rs.next()) {
                oracle.sql.BLOB blob2 = (oracle.sql.BLOB) rs.getBlob(1);
                rtn = blob2.getBinaryStream();
            }
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return rtn;
    }
    public InputStream getBlobMysql(String jndiName, int keyValue)
    {
        String SQL = "SELECT " + blobColumn + " FROM " + db + "." + table + " WHERE " + keyColumn +"=?";
        Connection conn = null;
        InputStream rtn = new ByteArrayInputStream(new byte[0]);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try
        {
            conn = DbConnectionManager.getConnection(jndiName);
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, keyValue);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Blob blob2 = (Blob) rs.getBlob(1);
                rtn = new Base64.InputStream(blob2.getBinaryStream(), Base64.DECODE);
                //rtn = blob2.getBinaryStream();
            }
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return rtn;
    }
    public InputStream getBlobDb2(String jndiName, int keyValue)
    {
        String SQL = "SELECT " + blobColumn + " FROM " + db + "." + table + " WHERE " + keyColumn +"=?";
        Connection conn = null;
        InputStream rtn = new ByteArrayInputStream(new byte[0]);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try
        {
            conn = DbConnectionManager.getConnection(jndiName);
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, keyValue);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Blob blob2 = (Blob) rs.getBlob(1);
                rtn = blob2.getBinaryStream();
            }
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return rtn;
    }
    
    public static List queryIdList(Connection con, String sql) {
        List listResult = new ArrayList();
        Statement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.createStatement();
            rs = pstmt.executeQuery(sql);
            while (rs.next()) {
            	listResult.add(rs.getInt(1) + "");
            }
        } catch( SQLException sqle ) {
            sqle.printStackTrace();
        } finally {
            if (rs != null) {
                try {  rs.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (pstmt != null) {
                try {  pstmt.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return listResult;
    }
}

