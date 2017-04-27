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
@Description("团建课题各学院上传资料")
public class SubjectFile implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(SubjectFile.class);
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
    public static final String DbTableName = "subject_file";
    private String TNAME = "subject_file";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","subjectCode","academy","principal","contact","checkflag","addtime","checkAccount","checkTime","addFileList","addAcount"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","subjectcode","academy","principal","contact","checkflag","addtime","checkaccount","checktime","addfilelist","addacount"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"SubjectCode","subjectcode","String"},{"Academy","academy","String"},{"Principal","principal","String"},{"Contact","contact","String"},{"Checkflag","checkflag","int"},{"Addtime","addtime","java.util.Date"},{"CheckAccount","checkaccount","String"},{"CheckTime","checktime","java.util.Date"},{"AddFileList","addfilelist","String"},{"AddAcount","addacount","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"subjectCode","subjectcode"},{"academy","academy"},{"principal","principal"},{"contact","contact"},{"checkflag","checkflag"},{"addtime","addtime"},{"checkAccount","checkaccount"},{"checkTime","checktime"},{"addFileList","addfilelist"},{"addAcount","addacount"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME","CHECKTIME"};
    public String[] getDateFields () {return _dateFields;};
    // id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 课题编码
    protected String subjectCode = "";
    public String getSubjectCode() {  return SqlTool.getDbString(subjectCode);  }
    public String getSubjectCode(int size) { return SqlTool.subString(getSubjectCode(), size); }
    public void setSubjectCode(String aSubjectCode) { subjectCode = aSubjectCode; modifiedFields.add("SubjectCode"); }
    public void assignSubjectCode(String aSubjectCode) { subjectCode = aSubjectCode; }
    public void paramSubjectCode(HttpServletRequest request) { paramSubjectCode(request, "SubjectCode"); }
    public void paramSubjectCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSubjectCode()); if (!tmp.equals(getSubjectCode())) { setSubjectCode(tmp); } }
    // 学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 负责人
    protected String principal = "";
    public String getPrincipal() {  return SqlTool.getDbString(principal);  }
    public String getPrincipal(int size) { return SqlTool.subString(getPrincipal(), size); }
    public void setPrincipal(String aPrincipal) { principal = aPrincipal; modifiedFields.add("Principal"); }
    public void assignPrincipal(String aPrincipal) { principal = aPrincipal; }
    public void paramPrincipal(HttpServletRequest request) { paramPrincipal(request, "Principal"); }
    public void paramPrincipal(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPrincipal()); if (!tmp.equals(getPrincipal())) { setPrincipal(tmp); } }
    // 联系方式
    protected String contact = "";
    public String getContact() {  return SqlTool.getDbString(contact);  }
    public String getContact(int size) { return SqlTool.subString(getContact(), size); }
    public void setContact(String aContact) { contact = aContact; modifiedFields.add("Contact"); }
    public void assignContact(String aContact) { contact = aContact; }
    public void paramContact(HttpServletRequest request) { paramContact(request, "Contact"); }
    public void paramContact(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getContact()); if (!tmp.equals(getContact())) { setContact(tmp); } }
    // 审核状态
    protected int checkflag = 1;
    public int getCheckflag() { return checkflag; }
    public void setCheckflag(int aCheckflag) { checkflag = aCheckflag; modifiedFields.add("Checkflag"); }
    public void assignCheckflag(int aCheckflag) { checkflag = aCheckflag; }
    public void paramCheckflag(HttpServletRequest request) { paramCheckflag(request, "Checkflag"); }
    public void paramCheckflag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckflag()); if (tmp != getCheckflag()) { setCheckflag(tmp); } }
    // 添加时间
    protected java.util.Date addtime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddtime() { return addtime; }
    public void setAddtime(java.util.Date aAddtime) { addtime = aAddtime; modifiedFields.add("Addtime"); }
    public void assignAddtime(java.util.Date aAddtime) { addtime = aAddtime; }
    public void paramAddtime(HttpServletRequest request) { paramAddtime(request, "Addtime"); }
    public void paramAddtime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddtime()); if (tmp.compareTo(getAddtime()) != 0) { setAddtime(tmp); } }
    // 添加账号
    protected String checkAccount = "";
    public String getCheckAccount() {  return SqlTool.getDbString(checkAccount);  }
    public String getCheckAccount(int size) { return SqlTool.subString(getCheckAccount(), size); }
    public void setCheckAccount(String aCheckAccount) { checkAccount = aCheckAccount; modifiedFields.add("CheckAccount"); }
    public void assignCheckAccount(String aCheckAccount) { checkAccount = aCheckAccount; }
    public void paramCheckAccount(HttpServletRequest request) { paramCheckAccount(request, "CheckAccount"); }
    public void paramCheckAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCheckAccount()); if (!tmp.equals(getCheckAccount())) { setCheckAccount(tmp); } }
    // 审核时间
    protected java.util.Date checkTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getCheckTime() { return checkTime; }
    public void setCheckTime(java.util.Date aCheckTime) { checkTime = aCheckTime; modifiedFields.add("CheckTime"); }
    public void assignCheckTime(java.util.Date aCheckTime) { checkTime = aCheckTime; }
    public void paramCheckTime(HttpServletRequest request) { paramCheckTime(request, "CheckTime"); }
    public void paramCheckTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getCheckTime()); if (tmp.compareTo(getCheckTime()) != 0) { setCheckTime(tmp); } }
    // 附件
    protected String addFileList = "";
    public String getAddFileList() {  return SqlTool.getDbString(addFileList);  }
    public String getAddFileList(int size) { return SqlTool.subString(getAddFileList(), size); }
    public void setAddFileList(String aAddFileList) { addFileList = aAddFileList; modifiedFields.add("AddFileList"); }
    public void assignAddFileList(String aAddFileList) { addFileList = aAddFileList; }
    public void paramAddFileList(HttpServletRequest request) { paramAddFileList(request, "AddFileList"); }
    public void paramAddFileList(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddFileList()); if (!tmp.equals(getAddFileList())) { setAddFileList(tmp); } }
    // 添加人
    protected String addAcount = "";
    public String getAddAcount() {  return SqlTool.getDbString(addAcount);  }
    public String getAddAcount(int size) { return SqlTool.subString(getAddAcount(), size); }
    public void setAddAcount(String aAddAcount) { addAcount = aAddAcount; modifiedFields.add("AddAcount"); }
    public void assignAddAcount(String aAddAcount) { addAcount = aAddAcount; }
    public void paramAddAcount(HttpServletRequest request) { paramAddAcount(request, "AddAcount"); }
    public void paramAddAcount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddAcount()); if (!tmp.equals(getAddAcount())) { setAddAcount(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public SubjectFile (String db) {
        DBNAME = db;
    }
    public SubjectFile (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public SubjectFile (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public SubjectFile () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return SubjectFile类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public SubjectFile getByParameter(HttpServletRequest request) {
        SubjectFile v = new SubjectFile(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramSubjectCode(request);
        paramAcademy(request);
        paramPrincipal(request);
        paramContact(request);
        paramCheckflag(request);
        paramAddtime(request);
        paramCheckAccount(request);
        paramCheckTime(request);
        paramAddFileList(request);
        paramAddAcount(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(SubjectFile bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("subjectCode")) { setSubjectCode(bean.getSubjectCode()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("principal")) { setPrincipal(bean.getPrincipal()); }
        if (!ncl.contains("contact")) { setContact(bean.getContact()); }
        if (!ncl.contains("checkflag")) { setCheckflag(bean.getCheckflag()); }
        if (!ncl.contains("addtime")) { setAddtime(bean.getAddtime()); }
        if (!ncl.contains("checkAccount")) { setCheckAccount(bean.getCheckAccount()); }
        if (!ncl.contains("checkTime")) { setCheckTime(bean.getCheckTime()); }
        if (!ncl.contains("addFileList")) { setAddFileList(bean.getAddFileList()); }
        if (!ncl.contains("addAcount")) { setAddAcount(bean.getAddAcount()); }
    }
    public SubjectFile getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        SubjectFile[] rslt= queryByCondition(cdt);
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
     * @return SubjectFile类的实例列表。
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
                SubjectFile ve = new SubjectFile(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignSubjectCode(fromDbCh(rs.getString(2)));
                ve.assignAcademy(fromDbCh(rs.getString(3)));
                ve.assignPrincipal(fromDbCh(rs.getString(4)));
                ve.assignContact(fromDbCh(rs.getString(5)));
                ve.assignCheckflag(rs.getInt(6));
                tmpDate = rs.getTimestamp(7); if (tmpDate != null) { ve.assignAddtime(new java.util.Date(tmpDate.getTime())); }
                ve.assignCheckAccount(fromDbCh(rs.getString(8)));
                tmpDate = rs.getTimestamp(9); if (tmpDate != null) { ve.assignCheckTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignAddFileList(fromDbCh(rs.getString(10)));
                ve.assignAddAcount(fromDbCh(rs.getString(11)));
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
    public SubjectFile[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (SubjectFile[])vrs.toArray(new SubjectFile[vrs.size()]);
    }
    public SubjectFile[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (SubjectFile[])vrs.toArray(new SubjectFile[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (subjectcode,academy,principal,contact,checkflag,addtime,checkaccount,checktime,addfilelist,addacount) VALUES (?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(subjectCode));
            pstmt.setString(2, toDbCh(academy));
            pstmt.setString(3, toDbCh(principal));
            pstmt.setString(4, toDbCh(contact));
            pstmt.setInt(5, checkflag);
            pstmt.setTimestamp(6, new java.sql.Timestamp(addtime.getTime()));
            pstmt.setString(7, toDbCh(checkAccount));
            pstmt.setTimestamp(8, new java.sql.Timestamp(checkTime.getTime()));
            pstmt.setString(9, toDbCh(addFileList));
            pstmt.setString(10, toDbCh(addAcount));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,subjectcode,academy,principal,contact,checkflag,addtime,checkaccount,checktime,addfilelist,addacount) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(subjectCode));
            pstmt.setString(3, toDbCh(academy));
            pstmt.setString(4, toDbCh(principal));
            pstmt.setString(5, toDbCh(contact));
            pstmt.setInt(6, checkflag);
            pstmt.setTimestamp(7, new java.sql.Timestamp(addtime.getTime()));
            pstmt.setString(8, toDbCh(checkAccount));
            pstmt.setTimestamp(9, new java.sql.Timestamp(checkTime.getTime()));
            pstmt.setString(10, toDbCh(addFileList));
            pstmt.setString(11, toDbCh(addAcount));
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
            SubjectFile item = (SubjectFile)it.next();
            SubjectFile v = new SubjectFile(dbname);
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
                if (modifiedFields.contains("SubjectCode")) { pstmt.setString(pi ++, toDbCh(subjectCode)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Principal")) { pstmt.setString(pi ++, toDbCh(principal)); }
                if (modifiedFields.contains("Contact")) { pstmt.setString(pi ++, toDbCh(contact)); }
                if (modifiedFields.contains("Checkflag")) { pstmt.setInt(pi ++, checkflag); }
                if (modifiedFields.contains("Addtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addtime.getTime())); }
                if (modifiedFields.contains("CheckAccount")) { pstmt.setString(pi ++, toDbCh(checkAccount)); }
                if (modifiedFields.contains("CheckTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(checkTime.getTime())); }
                if (modifiedFields.contains("AddFileList")) { pstmt.setString(pi ++, toDbCh(addFileList)); }
                if (modifiedFields.contains("AddAcount")) { pstmt.setString(pi ++, toDbCh(addAcount)); }
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
                if (modifiedFields.contains("SubjectCode")) { pstmt.setString(pi ++, toDbCh(subjectCode)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Principal")) { pstmt.setString(pi ++, toDbCh(principal)); }
                if (modifiedFields.contains("Contact")) { pstmt.setString(pi ++, toDbCh(contact)); }
                if (modifiedFields.contains("Checkflag")) { pstmt.setInt(pi ++, checkflag); }
                if (modifiedFields.contains("Addtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addtime.getTime())); }
                if (modifiedFields.contains("CheckAccount")) { pstmt.setString(pi ++, toDbCh(checkAccount)); }
                if (modifiedFields.contains("CheckTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(checkTime.getTime())); }
                if (modifiedFields.contains("AddFileList")) { pstmt.setString(pi ++, toDbCh(addFileList)); }
                if (modifiedFields.contains("AddAcount")) { pstmt.setString(pi ++, toDbCh(addAcount)); }
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
        map.put("SubjectCode", getSubjectCode());
        map.put("Academy", getAcademy());
        map.put("Principal", getPrincipal());
        map.put("Contact", getContact());
        map.put("Checkflag", getCheckflag() + "");
        map.put("Addtime", Tool.stringOfDateTime(getAddtime()));
        map.put("CheckAccount", getCheckAccount());
        map.put("CheckTime", Tool.stringOfDateTime(getCheckTime()));
        map.put("AddFileList", getAddFileList());
        map.put("AddAcount", getAddAcount());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("SubjectCode:\"" + Tool.jsSpecialChars(getSubjectCode()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("Principal:\"" + Tool.jsSpecialChars(getPrincipal()) + "\"");
        row.add("Contact:\"" + Tool.jsSpecialChars(getContact()) + "\"");
        row.add("Checkflag:\"" + getCheckflag() + "\"");
        row.add("Addtime:\"" + Tool.stringOfDateTime(getAddtime()) + "\"");
        row.add("CheckAccount:\"" + Tool.jsSpecialChars(getCheckAccount()) + "\"");
        row.add("CheckTime:\"" + Tool.stringOfDateTime(getCheckTime()) + "\"");
        row.add("AddFileList:\"" + Tool.jsSpecialChars(getAddFileList()) + "\"");
        row.add("AddAcount:\"" + Tool.jsSpecialChars(getAddAcount()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,subjectcode varchar2(50),academy varchar2(50),principal varchar2(50),contact varchar2(50),checkflag number(*,0),addtime date,checkaccount varchar2(50),checktime date,addfilelist varchar2(50),addacount varchar2(50))"});
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
        SubjectFile v = new SubjectFile(sourceDb, sourceTb);
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
        SubjectFile v = new SubjectFile(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(SubjectFile obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getSubjectCode().compareTo(obj.getSubjectCode()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getPrincipal().compareTo(obj.getPrincipal()); if (rtn != 0) return rtn;
        rtn = getContact().compareTo(obj.getContact()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckflag()).compareTo("" + obj.getCheckflag()); if (rtn != 0) return rtn;
        rtn = getAddtime().compareTo(obj.getAddtime()); if (rtn != 0) return rtn;
        rtn = getCheckAccount().compareTo(obj.getCheckAccount()); if (rtn != 0) return rtn;
        rtn = getCheckTime().compareTo(obj.getCheckTime()); if (rtn != 0) return rtn;
        rtn = getAddFileList().compareTo(obj.getAddFileList()); if (rtn != 0) return rtn;
        rtn = getAddAcount().compareTo(obj.getAddAcount()); if (rtn != 0) return rtn;
        return rtn;
    }
}
