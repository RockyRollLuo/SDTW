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
@Description("调查问卷回答items")
public class SurveyAnswer implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(SurveyAnswer.class);
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
    public static final String DbTableName = "survey_answer";
    private String TNAME = "survey_answer";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","userAccount","surveyCode","head_1ID","item_ID","item_Type","item_Submition","item_Score","submit_Time","submit_Ip"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","useraccount","surveycode","head_1id","item_id","item_type","item_submition","item_score","submit_time","submit_ip"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"UserAccount","useraccount","String"},{"SurveyCode","surveycode","String"},{"Head_1ID","head_1id","String"},{"Item_ID","item_id","String"},{"Item_Type","item_type","String"},{"Item_Submition","item_submition","String"},{"Item_Score","item_score","int"},{"Submit_Time","submit_time","java.util.Date"},{"Submit_Ip","submit_ip","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"userAccount","useraccount"},{"surveyCode","surveycode"},{"head_1ID","head_1id"},{"item_ID","item_id"},{"item_Type","item_type"},{"item_Submition","item_submition"},{"item_Score","item_score"},{"submit_Time","submit_time"},{"submit_Ip","submit_ip"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"SUBMIT_TIME"};
    public String[] getDateFields () {return _dateFields;};
    // id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 用户账号
    protected String userAccount = "";
    public String getUserAccount() {  return SqlTool.getDbString(userAccount);  }
    public String getUserAccount(int size) { return SqlTool.subString(getUserAccount(), size); }
    public void setUserAccount(String aUserAccount) { userAccount = aUserAccount; modifiedFields.add("UserAccount"); }
    public void assignUserAccount(String aUserAccount) { userAccount = aUserAccount; }
    public void paramUserAccount(HttpServletRequest request) { paramUserAccount(request, "UserAccount"); }
    public void paramUserAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUserAccount()); if (!tmp.equals(getUserAccount())) { setUserAccount(tmp); } }
    // 问卷编码
    protected String surveyCode = "";
    public String getSurveyCode() {  return SqlTool.getDbString(surveyCode);  }
    public String getSurveyCode(int size) { return SqlTool.subString(getSurveyCode(), size); }
    public void setSurveyCode(String aSurveyCode) { surveyCode = aSurveyCode; modifiedFields.add("SurveyCode"); }
    public void assignSurveyCode(String aSurveyCode) { surveyCode = aSurveyCode; }
    public void paramSurveyCode(HttpServletRequest request) { paramSurveyCode(request, "SurveyCode"); }
    public void paramSurveyCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSurveyCode()); if (!tmp.equals(getSurveyCode())) { setSurveyCode(tmp); } }
    // Head_1ID
    protected String head_1ID = "";
    public String getHead_1ID() {  return SqlTool.getDbString(head_1ID);  }
    public String getHead_1ID(int size) { return SqlTool.subString(getHead_1ID(), size); }
    public void setHead_1ID(String aHead_1ID) { head_1ID = aHead_1ID; modifiedFields.add("Head_1ID"); }
    public void assignHead_1ID(String aHead_1ID) { head_1ID = aHead_1ID; }
    public void paramHead_1ID(HttpServletRequest request) { paramHead_1ID(request, "Head_1ID"); }
    public void paramHead_1ID(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHead_1ID()); if (!tmp.equals(getHead_1ID())) { setHead_1ID(tmp); } }
    // Item_ID
    protected String item_ID = "";
    public String getItem_ID() {  return SqlTool.getDbString(item_ID);  }
    public String getItem_ID(int size) { return SqlTool.subString(getItem_ID(), size); }
    public void setItem_ID(String aItem_ID) { item_ID = aItem_ID; modifiedFields.add("Item_ID"); }
    public void assignItem_ID(String aItem_ID) { item_ID = aItem_ID; }
    public void paramItem_ID(HttpServletRequest request) { paramItem_ID(request, "Item_ID"); }
    public void paramItem_ID(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getItem_ID()); if (!tmp.equals(getItem_ID())) { setItem_ID(tmp); } }
    // Item_Type
    protected String item_Type = "";
    public String getItem_Type() {  return SqlTool.getDbString(item_Type);  }
    public String getItem_Type(int size) { return SqlTool.subString(getItem_Type(), size); }
    public void setItem_Type(String aItem_Type) { item_Type = aItem_Type; modifiedFields.add("Item_Type"); }
    public void assignItem_Type(String aItem_Type) { item_Type = aItem_Type; }
    public void paramItem_Type(HttpServletRequest request) { paramItem_Type(request, "Item_Type"); }
    public void paramItem_Type(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getItem_Type()); if (!tmp.equals(getItem_Type())) { setItem_Type(tmp); } }
    // Item_Submition
    protected String item_Submition = "";
    public String getItem_Submition() {  return SqlTool.getDbString(item_Submition);  }
    public String getItem_Submition(int size) { return SqlTool.subString(getItem_Submition(), size); }
    public void setItem_Submition(String aItem_Submition) { item_Submition = aItem_Submition; modifiedFields.add("Item_Submition"); }
    public void assignItem_Submition(String aItem_Submition) { item_Submition = aItem_Submition; }
    public void paramItem_Submition(HttpServletRequest request) { paramItem_Submition(request, "Item_Submition"); }
    public void paramItem_Submition(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getItem_Submition()); if (!tmp.equals(getItem_Submition())) { setItem_Submition(tmp); } }
    // Item_Score
    protected int item_Score = 0;
    public int getItem_Score() { return item_Score; }
    public void setItem_Score(int aItem_Score) { item_Score = aItem_Score; modifiedFields.add("Item_Score"); }
    public void assignItem_Score(int aItem_Score) { item_Score = aItem_Score; }
    public void paramItem_Score(HttpServletRequest request) { paramItem_Score(request, "Item_Score"); }
    public void paramItem_Score(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getItem_Score()); if (tmp != getItem_Score()) { setItem_Score(tmp); } }
    // Submit_Time
    protected java.util.Date submit_Time = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getSubmit_Time() { return submit_Time; }
    public void setSubmit_Time(java.util.Date aSubmit_Time) { submit_Time = aSubmit_Time; modifiedFields.add("Submit_Time"); }
    public void assignSubmit_Time(java.util.Date aSubmit_Time) { submit_Time = aSubmit_Time; }
    public void paramSubmit_Time(HttpServletRequest request) { paramSubmit_Time(request, "Submit_Time"); }
    public void paramSubmit_Time(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getSubmit_Time()); if (tmp.compareTo(getSubmit_Time()) != 0) { setSubmit_Time(tmp); } }
    // Submit_Ip
    protected String submit_Ip = "";
    public String getSubmit_Ip() {  return SqlTool.getDbString(submit_Ip);  }
    public String getSubmit_Ip(int size) { return SqlTool.subString(getSubmit_Ip(), size); }
    public void setSubmit_Ip(String aSubmit_Ip) { submit_Ip = aSubmit_Ip; modifiedFields.add("Submit_Ip"); }
    public void assignSubmit_Ip(String aSubmit_Ip) { submit_Ip = aSubmit_Ip; }
    public void paramSubmit_Ip(HttpServletRequest request) { paramSubmit_Ip(request, "Submit_Ip"); }
    public void paramSubmit_Ip(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSubmit_Ip()); if (!tmp.equals(getSubmit_Ip())) { setSubmit_Ip(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public SurveyAnswer (String db) {
        DBNAME = db;
    }
    public SurveyAnswer (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public SurveyAnswer (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public SurveyAnswer () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return SurveyAnswer类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public SurveyAnswer getByParameter(HttpServletRequest request) {
        SurveyAnswer v = new SurveyAnswer(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramUserAccount(request);
        paramSurveyCode(request);
        paramHead_1ID(request);
        paramItem_ID(request);
        paramItem_Type(request);
        paramItem_Submition(request);
        paramItem_Score(request);
        paramSubmit_Time(request);
        paramSubmit_Ip(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(SurveyAnswer bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("userAccount")) { setUserAccount(bean.getUserAccount()); }
        if (!ncl.contains("surveyCode")) { setSurveyCode(bean.getSurveyCode()); }
        if (!ncl.contains("head_1ID")) { setHead_1ID(bean.getHead_1ID()); }
        if (!ncl.contains("item_ID")) { setItem_ID(bean.getItem_ID()); }
        if (!ncl.contains("item_Type")) { setItem_Type(bean.getItem_Type()); }
        if (!ncl.contains("item_Submition")) { setItem_Submition(bean.getItem_Submition()); }
        if (!ncl.contains("item_Score")) { setItem_Score(bean.getItem_Score()); }
        if (!ncl.contains("submit_Time")) { setSubmit_Time(bean.getSubmit_Time()); }
        if (!ncl.contains("submit_Ip")) { setSubmit_Ip(bean.getSubmit_Ip()); }
    }
    public SurveyAnswer getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        SurveyAnswer[] rslt= queryByCondition(cdt);
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
     * @return SurveyAnswer类的实例列表。
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
                SurveyAnswer ve = new SurveyAnswer(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignUserAccount(fromDbCh(rs.getString(2)));
                ve.assignSurveyCode(fromDbCh(rs.getString(3)));
                ve.assignHead_1ID(fromDbCh(rs.getString(4)));
                ve.assignItem_ID(fromDbCh(rs.getString(5)));
                ve.assignItem_Type(fromDbCh(rs.getString(6)));
                ve.assignItem_Submition(fromDbCh(rs.getString(7)));
                ve.assignItem_Score(rs.getInt(8));
                tmpDate = rs.getTimestamp(9); if (tmpDate != null) { ve.assignSubmit_Time(new java.util.Date(tmpDate.getTime())); }
                ve.assignSubmit_Ip(fromDbCh(rs.getString(10)));
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
    public SurveyAnswer[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (SurveyAnswer[])vrs.toArray(new SurveyAnswer[vrs.size()]);
    }
    public SurveyAnswer[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (SurveyAnswer[])vrs.toArray(new SurveyAnswer[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (useraccount,surveycode,head_1id,item_id,item_type,item_submition,item_score,submit_time,submit_ip) VALUES (?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(userAccount));
            pstmt.setString(2, toDbCh(surveyCode));
            pstmt.setString(3, toDbCh(head_1ID));
            pstmt.setString(4, toDbCh(item_ID));
            pstmt.setString(5, toDbCh(item_Type));
            pstmt.setString(6, toDbCh(item_Submition));
            pstmt.setInt(7, item_Score);
            pstmt.setTimestamp(8, new java.sql.Timestamp(submit_Time.getTime()));
            pstmt.setString(9, toDbCh(submit_Ip));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,useraccount,surveycode,head_1id,item_id,item_type,item_submition,item_score,submit_time,submit_ip) VALUES (?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(userAccount));
            pstmt.setString(3, toDbCh(surveyCode));
            pstmt.setString(4, toDbCh(head_1ID));
            pstmt.setString(5, toDbCh(item_ID));
            pstmt.setString(6, toDbCh(item_Type));
            pstmt.setString(7, toDbCh(item_Submition));
            pstmt.setInt(8, item_Score);
            pstmt.setTimestamp(9, new java.sql.Timestamp(submit_Time.getTime()));
            pstmt.setString(10, toDbCh(submit_Ip));
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
            SurveyAnswer item = (SurveyAnswer)it.next();
            SurveyAnswer v = new SurveyAnswer(dbname);
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
                if (modifiedFields.contains("UserAccount")) { pstmt.setString(pi ++, toDbCh(userAccount)); }
                if (modifiedFields.contains("SurveyCode")) { pstmt.setString(pi ++, toDbCh(surveyCode)); }
                if (modifiedFields.contains("Head_1ID")) { pstmt.setString(pi ++, toDbCh(head_1ID)); }
                if (modifiedFields.contains("Item_ID")) { pstmt.setString(pi ++, toDbCh(item_ID)); }
                if (modifiedFields.contains("Item_Type")) { pstmt.setString(pi ++, toDbCh(item_Type)); }
                if (modifiedFields.contains("Item_Submition")) { pstmt.setString(pi ++, toDbCh(item_Submition)); }
                if (modifiedFields.contains("Item_Score")) { pstmt.setInt(pi ++, item_Score); }
                if (modifiedFields.contains("Submit_Time")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(submit_Time.getTime())); }
                if (modifiedFields.contains("Submit_Ip")) { pstmt.setString(pi ++, toDbCh(submit_Ip)); }
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
                if (modifiedFields.contains("UserAccount")) { pstmt.setString(pi ++, toDbCh(userAccount)); }
                if (modifiedFields.contains("SurveyCode")) { pstmt.setString(pi ++, toDbCh(surveyCode)); }
                if (modifiedFields.contains("Head_1ID")) { pstmt.setString(pi ++, toDbCh(head_1ID)); }
                if (modifiedFields.contains("Item_ID")) { pstmt.setString(pi ++, toDbCh(item_ID)); }
                if (modifiedFields.contains("Item_Type")) { pstmt.setString(pi ++, toDbCh(item_Type)); }
                if (modifiedFields.contains("Item_Submition")) { pstmt.setString(pi ++, toDbCh(item_Submition)); }
                if (modifiedFields.contains("Item_Score")) { pstmt.setInt(pi ++, item_Score); }
                if (modifiedFields.contains("Submit_Time")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(submit_Time.getTime())); }
                if (modifiedFields.contains("Submit_Ip")) { pstmt.setString(pi ++, toDbCh(submit_Ip)); }
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
        map.put("UserAccount", getUserAccount());
        map.put("SurveyCode", getSurveyCode());
        map.put("Head_1ID", getHead_1ID());
        map.put("Item_ID", getItem_ID());
        map.put("Item_Type", getItem_Type());
        map.put("Item_Submition", getItem_Submition());
        map.put("Item_Score", getItem_Score() + "");
        map.put("Submit_Time", Tool.stringOfDateTime(getSubmit_Time()));
        map.put("Submit_Ip", getSubmit_Ip());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("UserAccount:\"" + Tool.jsSpecialChars(getUserAccount()) + "\"");
        row.add("SurveyCode:\"" + Tool.jsSpecialChars(getSurveyCode()) + "\"");
        row.add("Head_1ID:\"" + Tool.jsSpecialChars(getHead_1ID()) + "\"");
        row.add("Item_ID:\"" + Tool.jsSpecialChars(getItem_ID()) + "\"");
        row.add("Item_Type:\"" + Tool.jsSpecialChars(getItem_Type()) + "\"");
        row.add("Item_Submition:\"" + Tool.jsSpecialChars(getItem_Submition()) + "\"");
        row.add("Item_Score:\"" + getItem_Score() + "\"");
        row.add("Submit_Time:\"" + Tool.stringOfDateTime(getSubmit_Time()) + "\"");
        row.add("Submit_Ip:\"" + Tool.jsSpecialChars(getSubmit_Ip()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,useraccount varchar2(45) not null,surveycode varchar2(45) not null,head_1id varchar2(45) not null,item_id varchar2(45),item_type varchar2(45),item_submition varchar2(2000),item_score number(*,0),submit_time date,submit_ip varchar2(45))"});
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
        SurveyAnswer v = new SurveyAnswer(sourceDb, sourceTb);
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
        SurveyAnswer v = new SurveyAnswer(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(SurveyAnswer obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getUserAccount().compareTo(obj.getUserAccount()); if (rtn != 0) return rtn;
        rtn = getSurveyCode().compareTo(obj.getSurveyCode()); if (rtn != 0) return rtn;
        rtn = getHead_1ID().compareTo(obj.getHead_1ID()); if (rtn != 0) return rtn;
        rtn = getItem_ID().compareTo(obj.getItem_ID()); if (rtn != 0) return rtn;
        rtn = getItem_Type().compareTo(obj.getItem_Type()); if (rtn != 0) return rtn;
        rtn = getItem_Submition().compareTo(obj.getItem_Submition()); if (rtn != 0) return rtn;
        rtn = ("" + getItem_Score()).compareTo("" + obj.getItem_Score()); if (rtn != 0) return rtn;
        rtn = getSubmit_Time().compareTo(obj.getSubmit_Time()); if (rtn != 0) return rtn;
        rtn = getSubmit_Ip().compareTo(obj.getSubmit_Ip()); if (rtn != 0) return rtn;
        return rtn;
    }
}
