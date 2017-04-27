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
@Description("团校培训管理资料")
public class Materialslist implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(Materialslist.class);
    // 包含所有被修改属性的集合，在setXXX()的时候调用
    private boolean refreshFlag = false;
    private Set modifiedFields = Collections.synchronizedSet(new HashSet());
    public Set getModifiedFields(){return modifiedFields;}
    // 清除被修改属性集合的内容，在将修改保存到数据库后调用
    public void clearModifiedFields() { modifiedFields.clear(); refreshFlag = false; }
    // 设定在调用clone方法的时候，包含在这个列表中的属性将不被复制
    private String[] noChangeList = {"fileID"};
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
    public static final String DbTableName = "materialslist";
    private String TNAME = "materialslist";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "fileid";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"fileID","userAccount","userName","fileTitle","fileSaveName","description","addTime","publicFlag","keyWordsList","projectName","foderCode"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"fileid","useraccount","username","filetitle","filesavename","description","addtime","publicflag","keywordslist","projectname","fodercode"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"FileID","fileid","int"},{"UserAccount","useraccount","String"},{"UserName","username","String"},{"FileTitle","filetitle","String"},{"FileSaveName","filesavename","String"},{"Description","description","String"},{"AddTime","addtime","java.util.Date"},{"PublicFlag","publicflag","int"},{"KeyWordsList","keywordslist","String"},{"ProjectName","projectname","String"},{"FoderCode","fodercode","String"}};
    private static final String[][] _allPropertiesAndFields = {{"fileID","fileid"},{"userAccount","useraccount"},{"userName","username"},{"fileTitle","filetitle"},{"fileSaveName","filesavename"},{"description","description"},{"addTime","addtime"},{"publicFlag","publicflag"},{"keyWordsList","keywordslist"},{"projectName","projectname"},{"foderCode","fodercode"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME"};
    public String[] getDateFields () {return _dateFields;};
    // FileID
    protected int fileID = -1;
    public int getFileID() { return fileID; }
    public void setFileID(int aFileID) { fileID = aFileID; }
    public void assignFileID(int aFileID) { fileID = aFileID; }
    public void paramFileID(HttpServletRequest request) { paramFileID(request, "FileID"); }
    public void paramFileID(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getFileID()); if (tmp != getFileID()) { setFileID(tmp); } }
    // 用户账号
    protected String userAccount = "";
    public String getUserAccount() {  return SqlTool.getDbString(userAccount);  }
    public String getUserAccount(int size) { return SqlTool.subString(getUserAccount(), size); }
    public void setUserAccount(String aUserAccount) { userAccount = aUserAccount; modifiedFields.add("UserAccount"); }
    public void assignUserAccount(String aUserAccount) { userAccount = aUserAccount; }
    public void paramUserAccount(HttpServletRequest request) { paramUserAccount(request, "UserAccount"); }
    public void paramUserAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUserAccount()); if (!tmp.equals(getUserAccount())) { setUserAccount(tmp); } }
    // 用户名称
    protected String userName = "";
    public String getUserName() {  return SqlTool.getDbString(userName);  }
    public String getUserName(int size) { return SqlTool.subString(getUserName(), size); }
    public void setUserName(String aUserName) { userName = aUserName; modifiedFields.add("UserName"); }
    public void assignUserName(String aUserName) { userName = aUserName; }
    public void paramUserName(HttpServletRequest request) { paramUserName(request, "UserName"); }
    public void paramUserName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUserName()); if (!tmp.equals(getUserName())) { setUserName(tmp); } }
    // 文件标题
    protected String fileTitle = "";
    public String getFileTitle() {  return SqlTool.getDbString(fileTitle);  }
    public String getFileTitle(int size) { return SqlTool.subString(getFileTitle(), size); }
    public void setFileTitle(String aFileTitle) { fileTitle = aFileTitle; modifiedFields.add("FileTitle"); }
    public void assignFileTitle(String aFileTitle) { fileTitle = aFileTitle; }
    public void paramFileTitle(HttpServletRequest request) { paramFileTitle(request, "FileTitle"); }
    public void paramFileTitle(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFileTitle()); if (!tmp.equals(getFileTitle())) { setFileTitle(tmp); } }
    // 文件名称
    protected String fileSaveName = "";
    public String getFileSaveName() {  return SqlTool.getDbString(fileSaveName);  }
    public String getFileSaveName(int size) { return SqlTool.subString(getFileSaveName(), size); }
    public void setFileSaveName(String aFileSaveName) { fileSaveName = aFileSaveName; modifiedFields.add("FileSaveName"); }
    public void assignFileSaveName(String aFileSaveName) { fileSaveName = aFileSaveName; }
    public void paramFileSaveName(HttpServletRequest request) { paramFileSaveName(request, "FileSaveName"); }
    public void paramFileSaveName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFileSaveName()); if (!tmp.equals(getFileSaveName())) { setFileSaveName(tmp); } }
    // 文件描述
    protected String description = "";
    public String getDescription() {  return SqlTool.getDbString(description);  }
    public String getDescription(int size) { return SqlTool.subString(getDescription(), size); }
    public void setDescription(String aDescription) { description = aDescription; modifiedFields.add("Description"); }
    public void assignDescription(String aDescription) { description = aDescription; }
    public void paramDescription(HttpServletRequest request) { paramDescription(request, "Description"); }
    public void paramDescription(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDescription()); if (!tmp.equals(getDescription())) { setDescription(tmp); } }
    // 添加时间
    protected java.util.Date addTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddTime() { return addTime; }
    public void setAddTime(java.util.Date aAddTime) { addTime = aAddTime; modifiedFields.add("AddTime"); }
    public void assignAddTime(java.util.Date aAddTime) { addTime = aAddTime; }
    public void paramAddTime(HttpServletRequest request) { paramAddTime(request, "AddTime"); }
    public void paramAddTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddTime()); if (tmp.compareTo(getAddTime()) != 0) { setAddTime(tmp); } }
    // 是否公开
    protected int publicFlag = -1;
    public int getPublicFlag() { return publicFlag; }
    public void setPublicFlag(int aPublicFlag) { publicFlag = aPublicFlag; modifiedFields.add("PublicFlag"); }
    public void assignPublicFlag(int aPublicFlag) { publicFlag = aPublicFlag; }
    public void paramPublicFlag(HttpServletRequest request) { paramPublicFlag(request, "PublicFlag"); }
    public void paramPublicFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getPublicFlag()); if (tmp != getPublicFlag()) { setPublicFlag(tmp); } }
    // 关键字
    protected String keyWordsList = "";
    public String getKeyWordsList() {  return SqlTool.getDbString(keyWordsList);  }
    public String getKeyWordsList(int size) { return SqlTool.subString(getKeyWordsList(), size); }
    public void setKeyWordsList(String aKeyWordsList) { keyWordsList = aKeyWordsList; modifiedFields.add("KeyWordsList"); }
    public void assignKeyWordsList(String aKeyWordsList) { keyWordsList = aKeyWordsList; }
    public void paramKeyWordsList(HttpServletRequest request) { paramKeyWordsList(request, "KeyWordsList"); }
    public void paramKeyWordsList(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getKeyWordsList()); if (!tmp.equals(getKeyWordsList())) { setKeyWordsList(tmp); } }
    // 项目名称
    protected String projectName = "";
    public String getProjectName() {  return SqlTool.getDbString(projectName);  }
    public String getProjectName(int size) { return SqlTool.subString(getProjectName(), size); }
    public void setProjectName(String aProjectName) { projectName = aProjectName; modifiedFields.add("ProjectName"); }
    public void assignProjectName(String aProjectName) { projectName = aProjectName; }
    public void paramProjectName(HttpServletRequest request) { paramProjectName(request, "ProjectName"); }
    public void paramProjectName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectName()); if (!tmp.equals(getProjectName())) { setProjectName(tmp); } }
    // 项目code
    protected String foderCode = "";
    public String getFoderCode() {  return SqlTool.getDbString(foderCode);  }
    public String getFoderCode(int size) { return SqlTool.subString(getFoderCode(), size); }
    public void setFoderCode(String aFoderCode) { foderCode = aFoderCode; modifiedFields.add("FoderCode"); }
    public void assignFoderCode(String aFoderCode) { foderCode = aFoderCode; }
    public void paramFoderCode(HttpServletRequest request) { paramFoderCode(request, "FoderCode"); }
    public void paramFoderCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFoderCode()); if (!tmp.equals(getFoderCode())) { setFoderCode(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public Materialslist (String db) {
        DBNAME = db;
    }
    public Materialslist (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public Materialslist (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public Materialslist () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return Materialslist类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public Materialslist getByParameter(HttpServletRequest request) {
        Materialslist v = new Materialslist(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramFileID(request);
        paramUserAccount(request);
        paramUserName(request);
        paramFileTitle(request);
        paramFileSaveName(request);
        paramDescription(request);
        paramAddTime(request);
        paramPublicFlag(request);
        paramKeyWordsList(request);
        paramProjectName(request);
        paramFoderCode(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(Materialslist bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("fileID")) { setFileID(bean.getFileID()); }
        if (!ncl.contains("userAccount")) { setUserAccount(bean.getUserAccount()); }
        if (!ncl.contains("userName")) { setUserName(bean.getUserName()); }
        if (!ncl.contains("fileTitle")) { setFileTitle(bean.getFileTitle()); }
        if (!ncl.contains("fileSaveName")) { setFileSaveName(bean.getFileSaveName()); }
        if (!ncl.contains("description")) { setDescription(bean.getDescription()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("publicFlag")) { setPublicFlag(bean.getPublicFlag()); }
        if (!ncl.contains("keyWordsList")) { setKeyWordsList(bean.getKeyWordsList()); }
        if (!ncl.contains("projectName")) { setProjectName(bean.getProjectName()); }
        if (!ncl.contains("foderCode")) { setFoderCode(bean.getFoderCode()); }
    }
    public Materialslist getByFileID(int aFileID) {
        List cdt = new ArrayList();
        cdt.add("fileid=" + aFileID);
        Materialslist[] rslt= queryByCondition(cdt);
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
     * @return Materialslist类的实例列表。
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
                Materialslist ve = new Materialslist(DBNAME, TNAME);
                ve.assignFileID(rs.getInt(1));
                ve.assignUserAccount(fromDbCh(rs.getString(2)));
                ve.assignUserName(fromDbCh(rs.getString(3)));
                ve.assignFileTitle(fromDbCh(rs.getString(4)));
                ve.assignFileSaveName(fromDbCh(rs.getString(5)));
                ve.assignDescription(fromDbCh(rs.getString(6)));
                tmpDate = rs.getTimestamp(7); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignPublicFlag(rs.getInt(8));
                ve.assignKeyWordsList(fromDbCh(rs.getString(9)));
                ve.assignProjectName(fromDbCh(rs.getString(10)));
                ve.assignFoderCode(fromDbCh(rs.getString(11)));
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
    public Materialslist[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (Materialslist[])vrs.toArray(new Materialslist[vrs.size()]);
    }
    public Materialslist[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (Materialslist[])vrs.toArray(new Materialslist[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (useraccount,username,filetitle,filesavename,description,addtime,publicflag,keywordslist,projectname,fodercode) VALUES (?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(userAccount));
            pstmt.setString(2, toDbCh(userName));
            pstmt.setString(3, toDbCh(fileTitle));
            pstmt.setString(4, toDbCh(fileSaveName));
            pstmt.setString(5, toDbCh(description));
            pstmt.setTimestamp(6, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setInt(7, publicFlag);
            pstmt.setString(8, toDbCh(keyWordsList));
            pstmt.setString(9, toDbCh(projectName));
            pstmt.setString(10, toDbCh(foderCode));
            iResult = pstmt.executeUpdate();
            rs = pstmt.executeQuery(SELECT);
            if (rs.next()) {
                fileID = rs.getInt("id");
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (fileid,useraccount,username,filetitle,filesavename,description,addtime,publicflag,keywordslist,projectname,fodercode) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, fileID);
            pstmt.setString(2, toDbCh(userAccount));
            pstmt.setString(3, toDbCh(userName));
            pstmt.setString(4, toDbCh(fileTitle));
            pstmt.setString(5, toDbCh(fileSaveName));
            pstmt.setString(6, toDbCh(description));
            pstmt.setTimestamp(7, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setInt(8, publicFlag);
            pstmt.setString(9, toDbCh(keyWordsList));
            pstmt.setString(10, toDbCh(projectName));
            pstmt.setString(11, toDbCh(foderCode));
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
            Materialslist item = (Materialslist)it.next();
            Materialslist v = new Materialslist(dbname);
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
            if (!_arrayPF[i][1].equals("FileID")) {
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
            updateSql.append(" WHERE fileid=?");
            PreparedStatement pstmt = null;
            try {
                pstmt = con.prepareStatement(updateSql.toString());
                int pi = 1;
                if (modifiedFields.contains("UserAccount")) { pstmt.setString(pi ++, toDbCh(userAccount)); }
                if (modifiedFields.contains("UserName")) { pstmt.setString(pi ++, toDbCh(userName)); }
                if (modifiedFields.contains("FileTitle")) { pstmt.setString(pi ++, toDbCh(fileTitle)); }
                if (modifiedFields.contains("FileSaveName")) { pstmt.setString(pi ++, toDbCh(fileSaveName)); }
                if (modifiedFields.contains("Description")) { pstmt.setString(pi ++, toDbCh(description)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("PublicFlag")) { pstmt.setInt(pi ++, publicFlag); }
                if (modifiedFields.contains("KeyWordsList")) { pstmt.setString(pi ++, toDbCh(keyWordsList)); }
                if (modifiedFields.contains("ProjectName")) { pstmt.setString(pi ++, toDbCh(projectName)); }
                if (modifiedFields.contains("FoderCode")) { pstmt.setString(pi ++, toDbCh(foderCode)); }
                pstmt.setInt(pi, fileID);
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
                if (modifiedFields.contains("UserAccount")) { pstmt.setString(pi ++, toDbCh(userAccount)); }
                if (modifiedFields.contains("UserName")) { pstmt.setString(pi ++, toDbCh(userName)); }
                if (modifiedFields.contains("FileTitle")) { pstmt.setString(pi ++, toDbCh(fileTitle)); }
                if (modifiedFields.contains("FileSaveName")) { pstmt.setString(pi ++, toDbCh(fileSaveName)); }
                if (modifiedFields.contains("Description")) { pstmt.setString(pi ++, toDbCh(description)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("PublicFlag")) { pstmt.setInt(pi ++, publicFlag); }
                if (modifiedFields.contains("KeyWordsList")) { pstmt.setString(pi ++, toDbCh(keyWordsList)); }
                if (modifiedFields.contains("ProjectName")) { pstmt.setString(pi ++, toDbCh(projectName)); }
                if (modifiedFields.contains("FoderCode")) { pstmt.setString(pi ++, toDbCh(foderCode)); }
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
    public int delete(int aFileID) {
        int iResult = -1;
        Connection con = null;
        try {
            con = DbConnectionManager.getConnection("jdbc/ds");
            iResult = delete(aFileID, con);
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
    public int delete(int aFileID, Connection con) {
        String DELETE = "DELETE FROM " + getDBNAME() + " WHERE fileid=?";
        int iResult = -1;
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(DELETE);
            pstmt.setInt(1, aFileID);
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
        log.debug("delete(" + getDBNAME() + "):" + aFileID + ":" + iResult);
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
        map.put("FileID", getFileID() + "");
        map.put("UserAccount", getUserAccount());
        map.put("UserName", getUserName());
        map.put("FileTitle", getFileTitle());
        map.put("FileSaveName", getFileSaveName());
        map.put("Description", getDescription());
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("PublicFlag", getPublicFlag() + "");
        map.put("KeyWordsList", getKeyWordsList());
        map.put("ProjectName", getProjectName());
        map.put("FoderCode", getFoderCode());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("FileID:\"" + getFileID() + "\"");
        row.add("UserAccount:\"" + Tool.jsSpecialChars(getUserAccount()) + "\"");
        row.add("UserName:\"" + Tool.jsSpecialChars(getUserName()) + "\"");
        row.add("FileTitle:\"" + Tool.jsSpecialChars(getFileTitle()) + "\"");
        row.add("FileSaveName:\"" + Tool.jsSpecialChars(getFileSaveName()) + "\"");
        row.add("Description:\"" + Tool.jsSpecialChars(getDescription()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("PublicFlag:\"" + getPublicFlag() + "\"");
        row.add("KeyWordsList:\"" + Tool.jsSpecialChars(getKeyWordsList()) + "\"");
        row.add("ProjectName:\"" + Tool.jsSpecialChars(getProjectName()) + "\"");
        row.add("FoderCode:\"" + Tool.jsSpecialChars(getFoderCode()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (fileid number(*,0) not null,useraccount varchar2(2000),username varchar2(2000),filetitle varchar2(2000),filesavename varchar2(2000),description varchar2(2000),addtime date,publicflag number(*,0),keywordslist varchar2(2000),projectname varchar2(2000),fodercode varchar2(2000))"});
        sqlList.add(new String[]{"index", "create unique index :DBNAME:.:TNAME:_key on :DBNAME:.:TNAME: (fileid)"});
        sqlList.add(new String[]{"index", "alter table :DBNAME:.:TNAME: add constraint :TNAME:_key primary key (fileid) using index"});
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
        Materialslist v = new Materialslist(sourceDb, sourceTb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by fileid asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public void duplicate(String sourceDb, List cdt) {
        Materialslist v = new Materialslist(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by fileid asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(Materialslist obj) {
        int rtn = 0;
        rtn = ("" + getFileID()).compareTo("" + obj.getFileID()); if (rtn != 0) return rtn;
        rtn = getUserAccount().compareTo(obj.getUserAccount()); if (rtn != 0) return rtn;
        rtn = getUserName().compareTo(obj.getUserName()); if (rtn != 0) return rtn;
        rtn = getFileTitle().compareTo(obj.getFileTitle()); if (rtn != 0) return rtn;
        rtn = getFileSaveName().compareTo(obj.getFileSaveName()); if (rtn != 0) return rtn;
        rtn = getDescription().compareTo(obj.getDescription()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = ("" + getPublicFlag()).compareTo("" + obj.getPublicFlag()); if (rtn != 0) return rtn;
        rtn = getKeyWordsList().compareTo(obj.getKeyWordsList()); if (rtn != 0) return rtn;
        rtn = getProjectName().compareTo(obj.getProjectName()); if (rtn != 0) return rtn;
        rtn = getFoderCode().compareTo(obj.getFoderCode()); if (rtn != 0) return rtn;
        return rtn;
    }
}
