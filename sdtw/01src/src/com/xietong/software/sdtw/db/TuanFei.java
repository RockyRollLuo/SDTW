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
@Description("团费")
public class TuanFei implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(TuanFei.class);
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
    public static final String DbTableName = "tuanfei";
    private String TNAME = "tuanfei";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","fAcademy","fTocharge","fCharged","fAcademyPersonNum","fConfine"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","facademy","ftocharge","fcharged","facademypersonnum","fconfine"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"FAcademy","facademy","String"},{"FTocharge","ftocharge","String"},{"FCharged","fcharged","String"},{"FAcademyPersonNum","facademypersonnum","String"},{"FConfine","fconfine","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"fAcademy","facademy"},{"fTocharge","ftocharge"},{"fCharged","fcharged"},{"fAcademyPersonNum","facademypersonnum"},{"fConfine","fconfine"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; modifiedFields.add("Id"); }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 学院名称
    protected String fAcademy = "";
    public String getFAcademy() {  return SqlTool.getDbString(fAcademy);  }
    public String getFAcademy(int size) { return SqlTool.subString(getFAcademy(), size); }
    public void setFAcademy(String aFAcademy) { fAcademy = aFAcademy; modifiedFields.add("FAcademy"); }
    public void assignFAcademy(String aFAcademy) { fAcademy = aFAcademy; }
    public void paramFAcademy(HttpServletRequest request) { paramFAcademy(request, "FAcademy"); }
    public void paramFAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFAcademy()); if (!tmp.equals(getFAcademy())) { setFAcademy(tmp); } }
    // 应缴团费
    protected String fTocharge = "";
    public String getFTocharge() {  return SqlTool.getDbString(fTocharge);  }
    public String getFTocharge(int size) { return SqlTool.subString(getFTocharge(), size); }
    public void setFTocharge(String aFTocharge) { fTocharge = aFTocharge; modifiedFields.add("FTocharge"); }
    public void assignFTocharge(String aFTocharge) { fTocharge = aFTocharge; }
    public void paramFTocharge(HttpServletRequest request) { paramFTocharge(request, "FTocharge"); }
    public void paramFTocharge(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFTocharge()); if (!tmp.equals(getFTocharge())) { setFTocharge(tmp); } }
    // 已缴团费
    protected String fCharged = "";
    public String getFCharged() {  return SqlTool.getDbString(fCharged);  }
    public String getFCharged(int size) { return SqlTool.subString(getFCharged(), size); }
    public void setFCharged(String aFCharged) { fCharged = aFCharged; modifiedFields.add("FCharged"); }
    public void assignFCharged(String aFCharged) { fCharged = aFCharged; }
    public void paramFCharged(HttpServletRequest request) { paramFCharged(request, "FCharged"); }
    public void paramFCharged(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFCharged()); if (!tmp.equals(getFCharged())) { setFCharged(tmp); } }
    // 学院人数
    protected String fAcademyPersonNum = "";
    public String getFAcademyPersonNum() {  return SqlTool.getDbString(fAcademyPersonNum);  }
    public String getFAcademyPersonNum(int size) { return SqlTool.subString(getFAcademyPersonNum(), size); }
    public void setFAcademyPersonNum(String aFAcademyPersonNum) { fAcademyPersonNum = aFAcademyPersonNum; modifiedFields.add("FAcademyPersonNum"); }
    public void assignFAcademyPersonNum(String aFAcademyPersonNum) { fAcademyPersonNum = aFAcademyPersonNum; }
    public void paramFAcademyPersonNum(HttpServletRequest request) { paramFAcademyPersonNum(request, "FAcademyPersonNum"); }
    public void paramFAcademyPersonNum(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFAcademyPersonNum()); if (!tmp.equals(getFAcademyPersonNum())) { setFAcademyPersonNum(tmp); } }
    // 是否确认
    protected String fConfine = "";
    public String getFConfine() {  return SqlTool.getDbString(fConfine);  }
    public String getFConfine(int size) { return SqlTool.subString(getFConfine(), size); }
    public void setFConfine(String aFConfine) { fConfine = aFConfine; modifiedFields.add("FConfine"); }
    public void assignFConfine(String aFConfine) { fConfine = aFConfine; }
    public void paramFConfine(HttpServletRequest request) { paramFConfine(request, "FConfine"); }
    public void paramFConfine(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFConfine()); if (!tmp.equals(getFConfine())) { setFConfine(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public TuanFei (String db) {
        DBNAME = db;
    }
    public TuanFei (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public TuanFei (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public TuanFei () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return TuanFei类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public TuanFei getByParameter(HttpServletRequest request) {
        TuanFei v = new TuanFei(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramFAcademy(request);
        paramFTocharge(request);
        paramFCharged(request);
        paramFAcademyPersonNum(request);
        paramFConfine(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(TuanFei bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("fAcademy")) { setFAcademy(bean.getFAcademy()); }
        if (!ncl.contains("fTocharge")) { setFTocharge(bean.getFTocharge()); }
        if (!ncl.contains("fCharged")) { setFCharged(bean.getFCharged()); }
        if (!ncl.contains("fAcademyPersonNum")) { setFAcademyPersonNum(bean.getFAcademyPersonNum()); }
        if (!ncl.contains("fConfine")) { setFConfine(bean.getFConfine()); }
    }
    public TuanFei getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        TuanFei[] rslt= queryByCondition(cdt);
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
     * @return TuanFei类的实例列表。
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
                TuanFei ve = new TuanFei(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignFAcademy(fromDbCh(rs.getString(2)));
                ve.assignFTocharge(fromDbCh(rs.getString(3)));
                ve.assignFCharged(fromDbCh(rs.getString(4)));
                ve.assignFAcademyPersonNum(fromDbCh(rs.getString(5)));
                ve.assignFConfine(fromDbCh(rs.getString(6)));
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
    public TuanFei[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (TuanFei[])vrs.toArray(new TuanFei[vrs.size()]);
    }
    public TuanFei[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (TuanFei[])vrs.toArray(new TuanFei[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (facademy,ftocharge,fcharged,facademypersonnum,fconfine) VALUES (?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(fAcademy));
            pstmt.setString(2, toDbCh(fTocharge));
            pstmt.setString(3, toDbCh(fCharged));
            pstmt.setString(4, toDbCh(fAcademyPersonNum));
            pstmt.setString(5, toDbCh(fConfine));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,facademy,ftocharge,fcharged,facademypersonnum,fconfine) VALUES (?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(fAcademy));
            pstmt.setString(3, toDbCh(fTocharge));
            pstmt.setString(4, toDbCh(fCharged));
            pstmt.setString(5, toDbCh(fAcademyPersonNum));
            pstmt.setString(6, toDbCh(fConfine));
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
            TuanFei item = (TuanFei)it.next();
            TuanFei v = new TuanFei(dbname);
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
                if (modifiedFields.contains("FAcademy")) { pstmt.setString(pi ++, toDbCh(fAcademy)); }
                if (modifiedFields.contains("FTocharge")) { pstmt.setString(pi ++, toDbCh(fTocharge)); }
                if (modifiedFields.contains("FCharged")) { pstmt.setString(pi ++, toDbCh(fCharged)); }
                if (modifiedFields.contains("FAcademyPersonNum")) { pstmt.setString(pi ++, toDbCh(fAcademyPersonNum)); }
                if (modifiedFields.contains("FConfine")) { pstmt.setString(pi ++, toDbCh(fConfine)); }
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
                if (modifiedFields.contains("FAcademy")) { pstmt.setString(pi ++, toDbCh(fAcademy)); }
                if (modifiedFields.contains("FTocharge")) { pstmt.setString(pi ++, toDbCh(fTocharge)); }
                if (modifiedFields.contains("FCharged")) { pstmt.setString(pi ++, toDbCh(fCharged)); }
                if (modifiedFields.contains("FAcademyPersonNum")) { pstmt.setString(pi ++, toDbCh(fAcademyPersonNum)); }
                if (modifiedFields.contains("FConfine")) { pstmt.setString(pi ++, toDbCh(fConfine)); }
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
        map.put("FAcademy", getFAcademy());
        map.put("FTocharge", getFTocharge());
        map.put("FCharged", getFCharged());
        map.put("FAcademyPersonNum", getFAcademyPersonNum());
        map.put("FConfine", getFConfine());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("FAcademy:\"" + Tool.jsSpecialChars(getFAcademy()) + "\"");
        row.add("FTocharge:\"" + Tool.jsSpecialChars(getFTocharge()) + "\"");
        row.add("FCharged:\"" + Tool.jsSpecialChars(getFCharged()) + "\"");
        row.add("FAcademyPersonNum:\"" + Tool.jsSpecialChars(getFAcademyPersonNum()) + "\"");
        row.add("FConfine:\"" + Tool.jsSpecialChars(getFConfine()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,facademy varchar2(25),ftocharge varchar2(15),fcharged varchar2(10),facademypersonnum varchar2(10),fconfine varchar2(10))"});
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
        TuanFei v = new TuanFei(sourceDb, sourceTb);
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
        TuanFei v = new TuanFei(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(TuanFei obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getFAcademy().compareTo(obj.getFAcademy()); if (rtn != 0) return rtn;
        rtn = getFTocharge().compareTo(obj.getFTocharge()); if (rtn != 0) return rtn;
        rtn = getFCharged().compareTo(obj.getFCharged()); if (rtn != 0) return rtn;
        rtn = getFAcademyPersonNum().compareTo(obj.getFAcademyPersonNum()); if (rtn != 0) return rtn;
        rtn = getFConfine().compareTo(obj.getFConfine()); if (rtn != 0) return rtn;
        return rtn;
    }
}
