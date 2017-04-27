//自动生成的程序，请不要修改，下次生成的时候会覆盖
package com.xietong.software.sdtw.db;
import java.sql.*;
import java.io.*;
import java.util.*;
import com.xietong.software.common.*;
import com.xietong.software.system.*;
import com.xietong.software.util.*;
import javax.servlet.http.*;
import java.math.BigDecimal;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.dom.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.StringWriter;
import org.apache.commons.betwixt.io.BeanWriter;
@Description("附件下载")
public class ClientAttach implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(ClientAttach.class);
    // 包含所有被修改属性的集合，在setXXX()的时候调用
    private boolean refreshFlag = false;
    private Set modifiedFields = Collections.synchronizedSet(new HashSet());
    public Set getModifiedFields(){return modifiedFields;}
    // 清除被修改属性集合的内容，在将修改保存到数据库后调用
    public void clearModifiedFields() { modifiedFields.clear(); refreshFlag = false; }
    // 设定在调用clone方法的时候，包含在这个列表中的属性将不被复制
    private String[] noChangeList = {"id"};
    private String[] getNoChangeList() { return noChangeList; }
    public void setNoChangeList(String[] aNoChangeList) { noChangeList = aNoChangeList; }
    // 保存当前连接的数据库名，对应mysql中的dbname，oracle中的用户名
    private String DBNAME = "tuanwei";
    public void setDataBase(String val) { DBNAME = val; }
    public String getDataBase() { return DBNAME; }
    public String getDBNAME() { if (DBNAME.length() > 0) return DBNAME + "." + TNAME; else return TNAME; }
    public static final String _DbType = "mysql";
    public String getDbType() { return _DbType; }
    // 保存当前连接的数据表名
    public static final String DbTableName = "clientattach";
    private String TNAME = "clientattach";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","attachType","content","uploadDate","uploadType","uploadName","attachSize","generateName","oplog","relationId","fromClass","fromTable"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","attachtype","content","uploaddate","uploadtype","uploadname","attachsize","generatename","oplog","relationid","fromclass","fromtable"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"AttachType","attachtype","int"},{"Content","content","String"},{"UploadDate","uploaddate","java.util.Date"},{"UploadType","uploadtype","String"},{"UploadName","uploadname","String"},{"AttachSize","attachsize","int"},{"GenerateName","generatename","String"},{"Oplog","oplog","String"},{"RelationId","relationid","int"},{"FromClass","fromclass","String"},{"FromTable","fromtable","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"attachType","attachtype"},{"content","content"},{"uploadDate","uploaddate"},{"uploadType","uploadtype"},{"uploadName","uploadname"},{"attachSize","attachsize"},{"generateName","generatename"},{"oplog","oplog"},{"relationId","relationid"},{"fromClass","fromclass"},{"fromTable","fromtable"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"UPLOADDATE"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 附件种类
    protected int attachType = -1;
    public int getAttachType() { return attachType; }
    public void setAttachType(int aAttachType) { attachType = aAttachType; modifiedFields.add("AttachType"); }
    public void assignAttachType(int aAttachType) { attachType = aAttachType; }
    public void paramAttachType(HttpServletRequest request) { paramAttachType(request, "AttachType"); }
    public void paramAttachType(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getAttachType()); if (tmp != getAttachType()) { setAttachType(tmp); } }
    // 内容
    protected String content = "";
    public String getContent() {  return SqlTool.getDbString(content);  }
    public String getContent(int size) { return SqlTool.subString(getContent(), size); }
    public void setContent(String aContent) { content = aContent; modifiedFields.add("Content"); }
    public void assignContent(String aContent) { content = aContent; }
    public void paramContent(HttpServletRequest request) { paramContent(request, "Content"); }
    public void paramContent(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getContent()); if (!tmp.equals(getContent())) { setContent(tmp); } }
    // 上传时间
    protected java.util.Date uploadDate = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getUploadDate() { return uploadDate; }
    public void setUploadDate(java.util.Date aUploadDate) { uploadDate = aUploadDate; modifiedFields.add("UploadDate"); }
    public void assignUploadDate(java.util.Date aUploadDate) { uploadDate = aUploadDate; }
    public void paramUploadDate(HttpServletRequest request) { paramUploadDate(request, "UploadDate"); }
    public void paramUploadDate(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getUploadDate()); if (tmp.compareTo(getUploadDate()) != 0) { setUploadDate(tmp); } }
    // 附件类型
    protected String uploadType = "";
    public String getUploadType() {  return SqlTool.getDbString(uploadType);  }
    public String getUploadType(int size) { return SqlTool.subString(getUploadType(), size); }
    public void setUploadType(String aUploadType) { uploadType = aUploadType; modifiedFields.add("UploadType"); }
    public void assignUploadType(String aUploadType) { uploadType = aUploadType; }
    public void paramUploadType(HttpServletRequest request) { paramUploadType(request, "UploadType"); }
    public void paramUploadType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUploadType()); if (!tmp.equals(getUploadType())) { setUploadType(tmp); } }
    // 上传名称
    protected String uploadName = "";
    public String getUploadName() {  return SqlTool.getDbString(uploadName);  }
    public String getUploadName(int size) { return SqlTool.subString(getUploadName(), size); }
    public void setUploadName(String aUploadName) { uploadName = aUploadName; modifiedFields.add("UploadName"); }
    public void assignUploadName(String aUploadName) { uploadName = aUploadName; }
    public void paramUploadName(HttpServletRequest request) { paramUploadName(request, "UploadName"); }
    public void paramUploadName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUploadName()); if (!tmp.equals(getUploadName())) { setUploadName(tmp); } }
    // 附件尺寸
    protected int attachSize = -1;
    public int getAttachSize() { return attachSize; }
    public void setAttachSize(int aAttachSize) { attachSize = aAttachSize; modifiedFields.add("AttachSize"); }
    public void assignAttachSize(int aAttachSize) { attachSize = aAttachSize; }
    public void paramAttachSize(HttpServletRequest request) { paramAttachSize(request, "AttachSize"); }
    public void paramAttachSize(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getAttachSize()); if (tmp != getAttachSize()) { setAttachSize(tmp); } }
    // 生成名称
    protected String generateName = "";
    public String getGenerateName() {  return SqlTool.getDbString(generateName);  }
    public String getGenerateName(int size) { return SqlTool.subString(getGenerateName(), size); }
    public void setGenerateName(String aGenerateName) { generateName = aGenerateName; modifiedFields.add("GenerateName"); }
    public void assignGenerateName(String aGenerateName) { generateName = aGenerateName; }
    public void paramGenerateName(HttpServletRequest request) { paramGenerateName(request, "GenerateName"); }
    public void paramGenerateName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGenerateName()); if (!tmp.equals(getGenerateName())) { setGenerateName(tmp); } }
    // 操作日志
    protected String oplog = "";
    public String getOplog() {  return SqlTool.getDbString(oplog);  }
    public String getOplog(int size) { return SqlTool.subString(getOplog(), size); }
    public void setOplog(String aOplog) { oplog = aOplog; modifiedFields.add("Oplog"); }
    public void assignOplog(String aOplog) { oplog = aOplog; }
    public void paramOplog(HttpServletRequest request) { paramOplog(request, "Oplog"); }
    public void paramOplog(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOplog()); if (!tmp.equals(getOplog())) { setOplog(tmp); } }
    // 相关Id
    protected int relationId = -1;
    public int getRelationId() { return relationId; }
    public void setRelationId(int aRelationId) { relationId = aRelationId; modifiedFields.add("RelationId"); }
    public void assignRelationId(int aRelationId) { relationId = aRelationId; }
    public void paramRelationId(HttpServletRequest request) { paramRelationId(request, "RelationId"); }
    public void paramRelationId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getRelationId()); if (tmp != getRelationId()) { setRelationId(tmp); } }
    // 所属类
    protected String fromClass = "";
    public String getFromClass() {  return SqlTool.getDbString(fromClass);  }
    public String getFromClass(int size) { return SqlTool.subString(getFromClass(), size); }
    public void setFromClass(String aFromClass) { fromClass = aFromClass; modifiedFields.add("FromClass"); }
    public void assignFromClass(String aFromClass) { fromClass = aFromClass; }
    public void paramFromClass(HttpServletRequest request) { paramFromClass(request, "FromClass"); }
    public void paramFromClass(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFromClass()); if (!tmp.equals(getFromClass())) { setFromClass(tmp); } }
    // 所属表名
    protected String fromTable = "";
    public String getFromTable() {  return SqlTool.getDbString(fromTable);  }
    public String getFromTable(int size) { return SqlTool.subString(getFromTable(), size); }
    public void setFromTable(String aFromTable) { fromTable = aFromTable; modifiedFields.add("FromTable"); }
    public void assignFromTable(String aFromTable) { fromTable = aFromTable; }
    public void paramFromTable(HttpServletRequest request) { paramFromTable(request, "FromTable"); }
    public void paramFromTable(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFromTable()); if (!tmp.equals(getFromTable())) { setFromTable(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public ClientAttach (String db) {
        DBNAME = db;
    }
    public ClientAttach (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public ClientAttach (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public ClientAttach () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return ClientAttach类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public ClientAttach getByParameter(HttpServletRequest request) {
        ClientAttach v = new ClientAttach(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramAttachType(request);
        paramContent(request);
        paramUploadDate(request);
        paramUploadType(request);
        paramUploadName(request);
        paramAttachSize(request);
        paramGenerateName(request);
        paramOplog(request);
        paramRelationId(request);
        paramFromClass(request);
        paramFromTable(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(ClientAttach bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("attachType")) { setAttachType(bean.getAttachType()); }
        if (!ncl.contains("content")) { setContent(bean.getContent()); }
        if (!ncl.contains("uploadDate")) { setUploadDate(bean.getUploadDate()); }
        if (!ncl.contains("uploadType")) { setUploadType(bean.getUploadType()); }
        if (!ncl.contains("uploadName")) { setUploadName(bean.getUploadName()); }
        if (!ncl.contains("attachSize")) { setAttachSize(bean.getAttachSize()); }
        if (!ncl.contains("generateName")) { setGenerateName(bean.getGenerateName()); }
        if (!ncl.contains("oplog")) { setOplog(bean.getOplog()); }
        if (!ncl.contains("relationId")) { setRelationId(bean.getRelationId()); }
        if (!ncl.contains("fromClass")) { setFromClass(bean.getFromClass()); }
        if (!ncl.contains("fromTable")) { setFromTable(bean.getFromTable()); }
    }
    public ClientAttach getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        ClientAttach[] rslt= queryByCondition(cdt);
        if (rslt.length == 1) {
            return rslt[0];
        }
        else {
            return null;
        }
    }
    /**
     * 根据存放在condition List中的条件，得到符合查询的记录数。
     * @param 包含查询条件的列表，各个条件之间的关系是并且(and)的关系，有两个特殊的关键字：
     * limit &lt;起始位置&gt;, &lt;限制数&gt;
     * order by &lt;字段列表&gt;，排序字段
     * 在这里将被忽略，不影响返回结果。
     * @return 记录数。
    */
    public int getCount(List cdt) {
        int iResult = -1;
        Connection con = null;
        try {
            con = DbConnectionManager.getConnection("jdbc/ds");
            iResult = getCount(con, cdt);
            con.close();
            con = null;
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (con != null) {
                try { con.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return iResult;
    }
    public int getCount(Connection con, List cdt) {
        String SELECT = "SELECT count(" + getPKey() + ") num FROM " + getDBNAME();
        SELECT = SqlTool.getSql(this, SELECT, cdt, false);
        return SqlTool.queryNumber(con, SELECT);
    }
    public List query(String SELECT, int intnum, int doublenum,int strnum, int datenum) {
        List vrs = new ArrayList();
        Connection con = null;
        try {
            con = DbConnectionManager.getConnection("jdbc/ds");
            vrs = query(con, SELECT,intnum,doublenum,strnum, datenum);
            con.close();
            con = null;
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (con != null) {
                try { con.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return vrs;
    }
    public List query(Connection con, String SELECT, int intnum, int doublenum,int strnum, int datenum) {
        Statement pstmt = null;
        ResultSet rs = null;
        List vrs = new ArrayList();
        try {
            pstmt = con.createStatement();
            rs = pstmt.executeQuery(SELECT);
            java.sql.Timestamp tmpDate = null;
            while (rs.next()) {
                List ve = new ArrayList();
                int i = 1;
                for (; i<=intnum; i++){
                    ve.add(rs.getInt(i) + "");
                }
                for (; i<=intnum+doublenum; i++){
                    ve.add(rs.getDouble(i) + "");
                }
                for (; i<=intnum+doublenum+strnum; i++){
                    ve.add(fromDbCh(rs.getString(i)));
                }
                for (; i<=intnum+doublenum+strnum+datenum; i++){
                    ve.add(rs.getTimestamp(i));
                }
                vrs.add(ve);
            }
            }catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (pstmt != null) {
                try { pstmt.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return  vrs;
    }
    /**
     * 根据存放在condition List中的条件，得到查询结果，每条记录放到当前类的一个实例中，
     * 多个实例放到一个List中返回。
     * @param 包含查询条件的列表，各个条件之间的关系是并且(and)的关系，有两个特殊的关键字：
     * limit &lt;起始位置&gt;, &lt;限制数&gt;，指定从结果集的起始位置开始，返回限制数的记录，
     *     无伦何种数据库，都是这个语法，下面自动翻译对应的语法。
     * order by &lt;字段列表&gt;，排序字段，符合标准SQL语法的排序语句。
     * 这两个不与其他的条件组合，只影响输出结果。
     * @return ClientAttach类的实例列表。
    */
    public List query(List cdt) {
        List vrs = new ArrayList();
        Connection con = null;
        try {
            con = DbConnectionManager.getConnection("jdbc/ds");
            vrs = query(con, cdt);
            con.close();
            con = null;
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (con != null) {
                try { con.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return vrs;
    }
    public List query(Connection con, List cdt) {
        String SELECT = "SELECT " + Tool.join(",", _allFields) + " FROM " + getDBNAME();
        SELECT = SqlTool.getSql(this, SELECT, cdt, true);
        Statement pstmt = null;
        ResultSet rs = null;
        List vrs = new ArrayList();
        try {
            pstmt = con.createStatement();
            rs = pstmt.executeQuery(SELECT);
            //Now read in desired number of results
            java.sql.Timestamp tmpDate = null;
            while (rs.next()) {
                ClientAttach ve = new ClientAttach(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignAttachType(rs.getInt(2));
                ve.assignContent(fromDbCh(rs.getString(3)));
                tmpDate = rs.getTimestamp(4); if (tmpDate != null) { ve.assignUploadDate(new java.util.Date(tmpDate.getTime())); }
                ve.assignUploadType(fromDbCh(rs.getString(5)));
                ve.assignUploadName(fromDbCh(rs.getString(6)));
                ve.assignAttachSize(rs.getInt(7));
                ve.assignGenerateName(fromDbCh(rs.getString(8)));
                ve.assignOplog(fromDbCh(rs.getString(9)));
                ve.assignRelationId(rs.getInt(10));
                ve.assignFromClass(fromDbCh(rs.getString(11)));
                ve.assignFromTable(fromDbCh(rs.getString(12)));
                vrs.add(ve);
            }
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (rs != null) {
                try { rs.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (pstmt != null) {
                try { pstmt.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return vrs;
    }
    public ClientAttach[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (ClientAttach[])vrs.toArray(new ClientAttach[vrs.size()]);
    }
    public ClientAttach[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (ClientAttach[])vrs.toArray(new ClientAttach[vrs.size()]);
    }
    /**
     * 获得当前数据表中的下一个主键的值。
     * @return 下一个主键的值
    */
    public int getNextSn() {
        int iResult = -1;
        Connection con = null;
        try {
            con = DbConnectionManager.getConnection("jdbc/ds");
            iResult = SqlTool.getNextSn(this, con);
            con.close();
            con = null;
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (con != null) {
                try { con.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return iResult;
    }
    /**
     * 将当前的实例插入到数据库中，主键从序列中获得。
     * @return 插入结果：== 1 成功； != 1 失败
    */
    public int insert() {
        int iResult = -1;
        Connection con = null;
        try {
            con = DbConnectionManager.getConnection("jdbc/ds");
            iResult = insert(con);
            con.close();
            con = null;
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (con != null) {
                try { con.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return iResult;
    }
    public int insert(Connection con) {
        String INSERT = "INSERT INTO " + getDBNAME() + " (attachtype,content,uploaddate,uploadtype,uploadname,attachsize,generatename,oplog,relationid,fromclass,fromtable) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, attachType);
            pstmt.setString(2, toDbCh(content));
            pstmt.setTimestamp(3, new java.sql.Timestamp(uploadDate.getTime()));
            pstmt.setString(4, toDbCh(uploadType));
            pstmt.setString(5, toDbCh(uploadName));
            pstmt.setInt(6, attachSize);
            pstmt.setString(7, toDbCh(generateName));
            pstmt.setString(8, toDbCh(oplog));
            pstmt.setInt(9, relationId);
            pstmt.setString(10, toDbCh(fromClass));
            pstmt.setString(11, toDbCh(fromTable));
            iResult = pstmt.executeUpdate();
            rs = pstmt.executeQuery(SELECT);
            if (rs.next()) {
                id = rs.getInt("id");
            }
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            try { rs.close(); }
            catch (Exception e) { e.printStackTrace(); }
            try { stmt.close(); }
            catch (Exception e) { e.printStackTrace(); }
            try { pstmt.close(); }
            catch (Exception e) { e.printStackTrace(); }
        }
        log.debug("insert(" + getDBNAME() + "):" + iResult);
        clearModifiedFields();
        return iResult;
    }
    /**
     * 将当前的实例插入到数据库中，主键事先指定。
     * @return 插入结果：== 1 成功； != 1 失败
    */
    public int insertByKey() {
        int iResult = -1;
        Connection con = null;
        try {
            con = DbConnectionManager.getConnection("jdbc/ds");
            iResult = insertByKey(con);
            con.close();
            con = null;
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (con != null) {
                try { con.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return iResult;
    }
    public int insertByKey(Connection con) {
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,attachtype,content,uploaddate,uploadtype,uploadname,attachsize,generatename,oplog,relationid,fromclass,fromtable) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, attachType);
            pstmt.setString(3, toDbCh(content));
            pstmt.setTimestamp(4, new java.sql.Timestamp(uploadDate.getTime()));
            pstmt.setString(5, toDbCh(uploadType));
            pstmt.setString(6, toDbCh(uploadName));
            pstmt.setInt(7, attachSize);
            pstmt.setString(8, toDbCh(generateName));
            pstmt.setString(9, toDbCh(oplog));
            pstmt.setInt(10, relationId);
            pstmt.setString(11, toDbCh(fromClass));
            pstmt.setString(12, toDbCh(fromTable));
            iResult = pstmt.executeUpdate();
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            try { stmt.close(); }
            catch (Exception e) { e.printStackTrace(); }
            try { pstmt.close(); }
            catch (Exception e) { e.printStackTrace(); }
        }
        log.debug("insertByKey(" + getDBNAME() + "):" + iResult);
        clearModifiedFields();
        return iResult;
    }
    /**
     * 将存放在列表中的实例插入到数据库中，通常用于复制数据。
     * @param 包含实例的列表。
     * @return 插入结果：true 成功； false 失败
    */
    public boolean batchInsertByKey(List list) {
        return batchInsertByKey(list, DBNAME);
    }
    public boolean batchInsertByKey(List list, String dbname) {
        int iResult = 0;
        String[] noChangeList = {};
        for (Iterator it = list.iterator(); it.hasNext();) {
            ClientAttach item = (ClientAttach)it.next();
            ClientAttach v = new ClientAttach(dbname);
            v.setNoChangeList(noChangeList);
            v.clone(item);
            iResult += v.insertByKey();
        }
        return (iResult == list.size());
    }
    /**
     * 将当前的实例中的所有属性更新到数据库，主键指定的记录。
     * @return 更新结果：!= -1 成功； == -1 失败
    */
    public int updateAllFields() {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (!_arrayPF[i][1].equals("Id")) {
                modifiedFields.add(_arrayPF[i][0]);
            }
        }
        return update();
    }
    /**
     * 将当前的实例中被改变的属性更新到数据库，主键指定的记录。
     * @return 更新结果：!= -1 成功； == -1 失败
    */
    public int update() {
        int iResult = -1;
        Connection con = null;
        try {
            con = DbConnectionManager.getConnection("jdbc/ds");
            iResult = update(con);
            con.close();
            con = null;
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (con != null) {
                try { con.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return iResult;
    }
    public int update(Connection con) {
        StringBuffer updateSql = new StringBuffer();
        List updateFields = new ArrayList();
        int iResult = -1;
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (modifiedFields.contains(_arrayPF[i][0])) {
                updateFields.add(_arrayPF[i][1] + "=?");
            }
        }
        if (updateFields.size() > 0) {
            updateSql.append("UPDATE " + getDBNAME() + " SET ");
            updateSql.append(Tool.join(",", updateFields));
            updateSql.append(" WHERE id=?");
            PreparedStatement pstmt = null;
            try {
                pstmt = con.prepareStatement(updateSql.toString());
                int pi = 1;
                if (modifiedFields.contains("AttachType")) { pstmt.setInt(pi ++, attachType); }
                if (modifiedFields.contains("Content")) { pstmt.setString(pi ++, toDbCh(content)); }
                if (modifiedFields.contains("UploadDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(uploadDate.getTime())); }
                if (modifiedFields.contains("UploadType")) { pstmt.setString(pi ++, toDbCh(uploadType)); }
                if (modifiedFields.contains("UploadName")) { pstmt.setString(pi ++, toDbCh(uploadName)); }
                if (modifiedFields.contains("AttachSize")) { pstmt.setInt(pi ++, attachSize); }
                if (modifiedFields.contains("GenerateName")) { pstmt.setString(pi ++, toDbCh(generateName)); }
                if (modifiedFields.contains("Oplog")) { pstmt.setString(pi ++, toDbCh(oplog)); }
                if (modifiedFields.contains("RelationId")) { pstmt.setInt(pi ++, relationId); }
                if (modifiedFields.contains("FromClass")) { pstmt.setString(pi ++, toDbCh(fromClass)); }
                if (modifiedFields.contains("FromTable")) { pstmt.setString(pi ++, toDbCh(fromTable)); }
                pstmt.setInt(pi, id);
                iResult = pstmt.executeUpdate();
            }
            catch( SQLException sqle ) {
                sqle.printStackTrace();
            }
            finally {
                if (pstmt != null) {
                    try { pstmt.close(); }
                    catch (Exception e) { e.printStackTrace(); }
                }
            }
        }
        log.debug("update(" + getDBNAME() + "):" + Tool.join(",", updateFields) + ":" + iResult);
        clearModifiedFields();
        return iResult;
    }
    /**
     * 将当前的实例中被改变的属性更新到数据库，按照条件指定的记录。
     * @return 更新结果：!= -1 成功； == -1 失败
    */
    public int updateByCondition(List cdt) {
        int iResult = -1;
        Connection con = null;
        try {
            con = DbConnectionManager.getConnection("jdbc/ds");
            iResult = updateByCondition(con, cdt);
            con.close();
            con = null;
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (con != null) {
                try { con.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return iResult;
    }
    public int updateByCondition(Connection con, List cdt) {
        StringBuffer updateSql = new StringBuffer();
        List updateFields = new ArrayList();
        int iResult = -1;
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (modifiedFields.contains(_arrayPF[i][0])) {
                updateFields.add(_arrayPF[i][1] + "=?");
            }
        }
        if (updateFields.size() > 0) {
            updateSql.append("UPDATE " + getDBNAME() + " SET ");
            updateSql.append(Tool.join(",", updateFields));
            String UPDATE = SqlTool.getSql(this, updateSql.toString(), cdt, false);
            PreparedStatement pstmt = null;
            try {
                pstmt = con.prepareStatement(UPDATE);
                int pi = 1;
                if (modifiedFields.contains("AttachType")) { pstmt.setInt(pi ++, attachType); }
                if (modifiedFields.contains("Content")) { pstmt.setString(pi ++, toDbCh(content)); }
                if (modifiedFields.contains("UploadDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(uploadDate.getTime())); }
                if (modifiedFields.contains("UploadType")) { pstmt.setString(pi ++, toDbCh(uploadType)); }
                if (modifiedFields.contains("UploadName")) { pstmt.setString(pi ++, toDbCh(uploadName)); }
                if (modifiedFields.contains("AttachSize")) { pstmt.setInt(pi ++, attachSize); }
                if (modifiedFields.contains("GenerateName")) { pstmt.setString(pi ++, toDbCh(generateName)); }
                if (modifiedFields.contains("Oplog")) { pstmt.setString(pi ++, toDbCh(oplog)); }
                if (modifiedFields.contains("RelationId")) { pstmt.setInt(pi ++, relationId); }
                if (modifiedFields.contains("FromClass")) { pstmt.setString(pi ++, toDbCh(fromClass)); }
                if (modifiedFields.contains("FromTable")) { pstmt.setString(pi ++, toDbCh(fromTable)); }
                iResult = pstmt.executeUpdate();
            }
            catch( SQLException sqle ) {
                sqle.printStackTrace();
            }
            finally {
                if (pstmt != null) {
                    try { pstmt.close(); }
                    catch (Exception e) { e.printStackTrace(); }
                }
            }
            log.debug("update(" + getDBNAME() + "):" + Tool.join("&&", cdt) + ":" + Tool.join(",", updateFields) + ":" + iResult);
        }
        clearModifiedFields();
        return iResult;
    }
    /**
     * 将当前的实例中的所有属性更新到数据库，主键指定的记录。
     * @param 要删除记录的主键
     * @return 删除结果：== 1 成功； != 1 失败
    */
    public int delete(int aId) {
        int iResult = -1;
        Connection con = null;
        try {
            con = DbConnectionManager.getConnection("jdbc/ds");
            iResult = delete(aId, con);
            con.close();
            con = null;
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (con != null) {
                try { con.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return iResult;
    }
    public int delete(int aId, Connection con) {
        String DELETE = "DELETE FROM " + getDBNAME() + " WHERE id=?";
        int iResult = -1;
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(DELETE);
            pstmt.setInt(1, aId);
            iResult = pstmt.executeUpdate();
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (pstmt != null) {
                try { pstmt.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        log.debug("delete(" + getDBNAME() + "):" + aId + ":" + iResult);
        return iResult;
    }
    /**
     * 根据存放在condition List中的条件，删除符合条件的记录
     * @param 包含查询条件的列表，各个条件之间的关系是并且(and)的关系，有两个特殊的关键字：
     * limit &lt;起始位置&gt;, &lt;限制数&gt;
     * order by &lt;字段列表&gt;，排序字段
     * 在这里将被忽略，不影响结果。
     * @return 删除结果：&gt;= 0 成功； &lt; 0 失败
    */
    public int deleteByCondition(List cdt) {
        String DELETE = "DELETE FROM " + getDBNAME();
        int iResult = -1;
        Connection con = null;
        PreparedStatement pstmt = null;
        DELETE = SqlTool.getSql(this, DELETE, cdt, false);
        try {
            con = DbConnectionManager.getConnection("jdbc/ds");
            pstmt = con.prepareStatement(DELETE);
            iResult = pstmt.executeUpdate();
        }
        catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        finally {
            if (pstmt != null) {
                try { pstmt.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (con != null) {
                try { con.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return iResult;
    }
    public Map toMap() {
        Map map = new HashMap();
        map.put("Id", getId() + "");
        map.put("AttachType", getAttachType() + "");
        map.put("Content", getContent());
        map.put("UploadDate", Tool.stringOfDateTime(getUploadDate()));
        map.put("UploadType", getUploadType());
        map.put("UploadName", getUploadName());
        map.put("AttachSize", getAttachSize() + "");
        map.put("GenerateName", getGenerateName());
        map.put("Oplog", getOplog());
        map.put("RelationId", getRelationId() + "");
        map.put("FromClass", getFromClass());
        map.put("FromTable", getFromTable());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("AttachType:\"" + getAttachType() + "\"");
        row.add("Content:\"" + Tool.jsSpecialChars(getContent()) + "\"");
        row.add("UploadDate:\"" + Tool.stringOfDateTime(getUploadDate()) + "\"");
        row.add("UploadType:\"" + Tool.jsSpecialChars(getUploadType()) + "\"");
        row.add("UploadName:\"" + Tool.jsSpecialChars(getUploadName()) + "\"");
        row.add("AttachSize:\"" + getAttachSize() + "\"");
        row.add("GenerateName:\"" + Tool.jsSpecialChars(getGenerateName()) + "\"");
        row.add("Oplog:\"" + Tool.jsSpecialChars(getOplog()) + "\"");
        row.add("RelationId:\"" + getRelationId() + "\"");
        row.add("FromClass:\"" + Tool.jsSpecialChars(getFromClass()) + "\"");
        row.add("FromTable:\"" + Tool.jsSpecialChars(getFromTable()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,attachtype number(*,0),content varchar2(200),uploaddate date,uploadtype varchar2(200),uploadname varchar2(500),attachsize number(*,0),generatename varchar2(500),oplog varchar2(1000),relationid number(*,0),fromclass varchar2(20),fromtable varchar2(20))"});
        sqlList.add(new String[]{"index", "create unique index :DBNAME:.:TNAME:_key on :DBNAME:.:TNAME: (id)"});
        sqlList.add(new String[]{"index", "alter table :DBNAME:.:TNAME: add constraint :TNAME:_key primary key (id) using index"});
        int iResult = -1;
        for (Iterator it = sqlList.iterator(); it.hasNext();) {
            String[] item = (String[])it.next();
            String sql = item[1].replaceAll(":DBNAME:", DBNAME).replaceAll(":TNAME:", TNAME);
            iResult = SqlTool.executeSql("jdbc/ds", sql);
            log.debug("init(" + item[0] + ":" + sql + "):" + iResult);
        }
        return iResult;
    }
    public void duplicate(String sourceDb, String sourceTb, List cdt) {
        ClientAttach v = new ClientAttach(sourceDb, sourceTb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public void duplicate(String sourceDb, List cdt) {
        ClientAttach v = new ClientAttach(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(ClientAttach obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getAttachType()).compareTo("" + obj.getAttachType()); if (rtn != 0) return rtn;
        rtn = getContent().compareTo(obj.getContent()); if (rtn != 0) return rtn;
        rtn = getUploadDate().compareTo(obj.getUploadDate()); if (rtn != 0) return rtn;
        rtn = getUploadType().compareTo(obj.getUploadType()); if (rtn != 0) return rtn;
        rtn = getUploadName().compareTo(obj.getUploadName()); if (rtn != 0) return rtn;
        rtn = ("" + getAttachSize()).compareTo("" + obj.getAttachSize()); if (rtn != 0) return rtn;
        rtn = getGenerateName().compareTo(obj.getGenerateName()); if (rtn != 0) return rtn;
        rtn = getOplog().compareTo(obj.getOplog()); if (rtn != 0) return rtn;
        rtn = ("" + getRelationId()).compareTo("" + obj.getRelationId()); if (rtn != 0) return rtn;
        rtn = getFromClass().compareTo(obj.getFromClass()); if (rtn != 0) return rtn;
        rtn = getFromTable().compareTo(obj.getFromTable()); if (rtn != 0) return rtn;
        return rtn;
    }
}
