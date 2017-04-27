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
@Description("通讯录成员信息")
public class AddBookPerson implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(AddBookPerson.class);
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
    public static final String DbTableName = "addbookperson";
    private String TNAME = "addbookperson";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","userAccount","groupid","myNums","personName","personAccount","personId","workDepartment","officeTel","mobileTel","homeTel","email","othersInfo","addTime"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","useraccount","groupid","mynums","personname","personaccount","personid","workdepartment","officetel","mobiletel","hometel","email","othersinfo","addtime"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"UserAccount","useraccount","String"},{"Groupid","groupid","String"},{"MyNums","mynums","String"},{"PersonName","personname","String"},{"PersonAccount","personaccount","String"},{"PersonId","personid","String"},{"WorkDepartment","workdepartment","String"},{"OfficeTel","officetel","String"},{"MobileTel","mobiletel","String"},{"HomeTel","hometel","String"},{"Email","email","String"},{"OthersInfo","othersinfo","String"},{"AddTime","addtime","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"userAccount","useraccount"},{"groupid","groupid"},{"myNums","mynums"},{"personName","personname"},{"personAccount","personaccount"},{"personId","personid"},{"workDepartment","workdepartment"},{"officeTel","officetel"},{"mobileTel","mobiletel"},{"homeTel","hometel"},{"email","email"},{"othersInfo","othersinfo"},{"addTime","addtime"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {};
    public String[] getDateFields () {return _dateFields;};
    // id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 账号
    protected String userAccount = "";
    public String getUserAccount() {  return SqlTool.getDbString(userAccount);  }
    public String getUserAccount(int size) { return SqlTool.subString(getUserAccount(), size); }
    public void setUserAccount(String aUserAccount) { userAccount = aUserAccount; modifiedFields.add("UserAccount"); }
    public void assignUserAccount(String aUserAccount) { userAccount = aUserAccount; }
    public void paramUserAccount(HttpServletRequest request) { paramUserAccount(request, "UserAccount"); }
    public void paramUserAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUserAccount()); if (!tmp.equals(getUserAccount())) { setUserAccount(tmp); } }
    // 分组id
    protected String groupid = "";
    public String getGroupid() {  return SqlTool.getDbString(groupid);  }
    public String getGroupid(int size) { return SqlTool.subString(getGroupid(), size); }
    public void setGroupid(String aGroupid) { groupid = aGroupid; modifiedFields.add("Groupid"); }
    public void assignGroupid(String aGroupid) { groupid = aGroupid; }
    public void paramGroupid(HttpServletRequest request) { paramGroupid(request, "Groupid"); }
    public void paramGroupid(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGroupid()); if (!tmp.equals(getGroupid())) { setGroupid(tmp); } }
    // 成员数目
    protected String myNums = "";
    public String getMyNums() {  return SqlTool.getDbString(myNums);  }
    public String getMyNums(int size) { return SqlTool.subString(getMyNums(), size); }
    public void setMyNums(String aMyNums) { myNums = aMyNums; modifiedFields.add("MyNums"); }
    public void assignMyNums(String aMyNums) { myNums = aMyNums; }
    public void paramMyNums(HttpServletRequest request) { paramMyNums(request, "MyNums"); }
    public void paramMyNums(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMyNums()); if (!tmp.equals(getMyNums())) { setMyNums(tmp); } }
    // 姓名
    protected String personName = "";
    public String getPersonName() {  return SqlTool.getDbString(personName);  }
    public String getPersonName(int size) { return SqlTool.subString(getPersonName(), size); }
    public void setPersonName(String aPersonName) { personName = aPersonName; modifiedFields.add("PersonName"); }
    public void assignPersonName(String aPersonName) { personName = aPersonName; }
    public void paramPersonName(HttpServletRequest request) { paramPersonName(request, "PersonName"); }
    public void paramPersonName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPersonName()); if (!tmp.equals(getPersonName())) { setPersonName(tmp); } }
    // 账号
    protected String personAccount = "";
    public String getPersonAccount() {  return SqlTool.getDbString(personAccount);  }
    public String getPersonAccount(int size) { return SqlTool.subString(getPersonAccount(), size); }
    public void setPersonAccount(String aPersonAccount) { personAccount = aPersonAccount; modifiedFields.add("PersonAccount"); }
    public void assignPersonAccount(String aPersonAccount) { personAccount = aPersonAccount; }
    public void paramPersonAccount(HttpServletRequest request) { paramPersonAccount(request, "PersonAccount"); }
    public void paramPersonAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPersonAccount()); if (!tmp.equals(getPersonAccount())) { setPersonAccount(tmp); } }
    // 用户id
    protected String personId = "";
    public String getPersonId() {  return SqlTool.getDbString(personId);  }
    public String getPersonId(int size) { return SqlTool.subString(getPersonId(), size); }
    public void setPersonId(String aPersonId) { personId = aPersonId; modifiedFields.add("PersonId"); }
    public void assignPersonId(String aPersonId) { personId = aPersonId; }
    public void paramPersonId(HttpServletRequest request) { paramPersonId(request, "PersonId"); }
    public void paramPersonId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPersonId()); if (!tmp.equals(getPersonId())) { setPersonId(tmp); } }
    // 工作单位
    protected String workDepartment = "";
    public String getWorkDepartment() {  return SqlTool.getDbString(workDepartment);  }
    public String getWorkDepartment(int size) { return SqlTool.subString(getWorkDepartment(), size); }
    public void setWorkDepartment(String aWorkDepartment) { workDepartment = aWorkDepartment; modifiedFields.add("WorkDepartment"); }
    public void assignWorkDepartment(String aWorkDepartment) { workDepartment = aWorkDepartment; }
    public void paramWorkDepartment(HttpServletRequest request) { paramWorkDepartment(request, "WorkDepartment"); }
    public void paramWorkDepartment(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getWorkDepartment()); if (!tmp.equals(getWorkDepartment())) { setWorkDepartment(tmp); } }
    // 办公电话
    protected String officeTel = "";
    public String getOfficeTel() {  return SqlTool.getDbString(officeTel);  }
    public String getOfficeTel(int size) { return SqlTool.subString(getOfficeTel(), size); }
    public void setOfficeTel(String aOfficeTel) { officeTel = aOfficeTel; modifiedFields.add("OfficeTel"); }
    public void assignOfficeTel(String aOfficeTel) { officeTel = aOfficeTel; }
    public void paramOfficeTel(HttpServletRequest request) { paramOfficeTel(request, "OfficeTel"); }
    public void paramOfficeTel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOfficeTel()); if (!tmp.equals(getOfficeTel())) { setOfficeTel(tmp); } }
    // 手机
    protected String mobileTel = "";
    public String getMobileTel() {  return SqlTool.getDbString(mobileTel);  }
    public String getMobileTel(int size) { return SqlTool.subString(getMobileTel(), size); }
    public void setMobileTel(String aMobileTel) { mobileTel = aMobileTel; modifiedFields.add("MobileTel"); }
    public void assignMobileTel(String aMobileTel) { mobileTel = aMobileTel; }
    public void paramMobileTel(HttpServletRequest request) { paramMobileTel(request, "MobileTel"); }
    public void paramMobileTel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMobileTel()); if (!tmp.equals(getMobileTel())) { setMobileTel(tmp); } }
    // 家庭电话
    protected String homeTel = "";
    public String getHomeTel() {  return SqlTool.getDbString(homeTel);  }
    public String getHomeTel(int size) { return SqlTool.subString(getHomeTel(), size); }
    public void setHomeTel(String aHomeTel) { homeTel = aHomeTel; modifiedFields.add("HomeTel"); }
    public void assignHomeTel(String aHomeTel) { homeTel = aHomeTel; }
    public void paramHomeTel(HttpServletRequest request) { paramHomeTel(request, "HomeTel"); }
    public void paramHomeTel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHomeTel()); if (!tmp.equals(getHomeTel())) { setHomeTel(tmp); } }
    // 邮箱
    protected String email = "";
    public String getEmail() {  return SqlTool.getDbString(email);  }
    public String getEmail(int size) { return SqlTool.subString(getEmail(), size); }
    public void setEmail(String aEmail) { email = aEmail; modifiedFields.add("Email"); }
    public void assignEmail(String aEmail) { email = aEmail; }
    public void paramEmail(HttpServletRequest request) { paramEmail(request, "Email"); }
    public void paramEmail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getEmail()); if (!tmp.equals(getEmail())) { setEmail(tmp); } }
    // 其他信息
    protected String othersInfo = "";
    public String getOthersInfo() {  return SqlTool.getDbString(othersInfo);  }
    public String getOthersInfo(int size) { return SqlTool.subString(getOthersInfo(), size); }
    public void setOthersInfo(String aOthersInfo) { othersInfo = aOthersInfo; modifiedFields.add("OthersInfo"); }
    public void assignOthersInfo(String aOthersInfo) { othersInfo = aOthersInfo; }
    public void paramOthersInfo(HttpServletRequest request) { paramOthersInfo(request, "OthersInfo"); }
    public void paramOthersInfo(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOthersInfo()); if (!tmp.equals(getOthersInfo())) { setOthersInfo(tmp); } }
    // 添加时间
    protected String addTime = "";
    public String getAddTime() {  return SqlTool.getDbString(addTime);  }
    public String getAddTime(int size) { return SqlTool.subString(getAddTime(), size); }
    public void setAddTime(String aAddTime) { addTime = aAddTime; modifiedFields.add("AddTime"); }
    public void assignAddTime(String aAddTime) { addTime = aAddTime; }
    public void paramAddTime(HttpServletRequest request) { paramAddTime(request, "AddTime"); }
    public void paramAddTime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddTime()); if (!tmp.equals(getAddTime())) { setAddTime(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public AddBookPerson (String db) {
        DBNAME = db;
    }
    public AddBookPerson (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public AddBookPerson (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public AddBookPerson () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return AddBookPerson类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public AddBookPerson getByParameter(HttpServletRequest request) {
        AddBookPerson v = new AddBookPerson(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramUserAccount(request);
        paramGroupid(request);
        paramMyNums(request);
        paramPersonName(request);
        paramPersonAccount(request);
        paramPersonId(request);
        paramWorkDepartment(request);
        paramOfficeTel(request);
        paramMobileTel(request);
        paramHomeTel(request);
        paramEmail(request);
        paramOthersInfo(request);
        paramAddTime(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(AddBookPerson bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("userAccount")) { setUserAccount(bean.getUserAccount()); }
        if (!ncl.contains("groupid")) { setGroupid(bean.getGroupid()); }
        if (!ncl.contains("myNums")) { setMyNums(bean.getMyNums()); }
        if (!ncl.contains("personName")) { setPersonName(bean.getPersonName()); }
        if (!ncl.contains("personAccount")) { setPersonAccount(bean.getPersonAccount()); }
        if (!ncl.contains("personId")) { setPersonId(bean.getPersonId()); }
        if (!ncl.contains("workDepartment")) { setWorkDepartment(bean.getWorkDepartment()); }
        if (!ncl.contains("officeTel")) { setOfficeTel(bean.getOfficeTel()); }
        if (!ncl.contains("mobileTel")) { setMobileTel(bean.getMobileTel()); }
        if (!ncl.contains("homeTel")) { setHomeTel(bean.getHomeTel()); }
        if (!ncl.contains("email")) { setEmail(bean.getEmail()); }
        if (!ncl.contains("othersInfo")) { setOthersInfo(bean.getOthersInfo()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
    }
    public AddBookPerson getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        AddBookPerson[] rslt= queryByCondition(cdt);
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
     * @return AddBookPerson类的实例列表。
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
                AddBookPerson ve = new AddBookPerson(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignUserAccount(fromDbCh(rs.getString(2)));
                ve.assignGroupid(fromDbCh(rs.getString(3)));
                ve.assignMyNums(fromDbCh(rs.getString(4)));
                ve.assignPersonName(fromDbCh(rs.getString(5)));
                ve.assignPersonAccount(fromDbCh(rs.getString(6)));
                ve.assignPersonId(fromDbCh(rs.getString(7)));
                ve.assignWorkDepartment(fromDbCh(rs.getString(8)));
                ve.assignOfficeTel(fromDbCh(rs.getString(9)));
                ve.assignMobileTel(fromDbCh(rs.getString(10)));
                ve.assignHomeTel(fromDbCh(rs.getString(11)));
                ve.assignEmail(fromDbCh(rs.getString(12)));
                ve.assignOthersInfo(fromDbCh(rs.getString(13)));
                ve.assignAddTime(fromDbCh(rs.getString(14)));
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
    public AddBookPerson[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (AddBookPerson[])vrs.toArray(new AddBookPerson[vrs.size()]);
    }
    public AddBookPerson[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (AddBookPerson[])vrs.toArray(new AddBookPerson[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (useraccount,groupid,mynums,personname,personaccount,personid,workdepartment,officetel,mobiletel,hometel,email,othersinfo,addtime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(userAccount));
            pstmt.setString(2, toDbCh(groupid));
            pstmt.setString(3, toDbCh(myNums));
            pstmt.setString(4, toDbCh(personName));
            pstmt.setString(5, toDbCh(personAccount));
            pstmt.setString(6, toDbCh(personId));
            pstmt.setString(7, toDbCh(workDepartment));
            pstmt.setString(8, toDbCh(officeTel));
            pstmt.setString(9, toDbCh(mobileTel));
            pstmt.setString(10, toDbCh(homeTel));
            pstmt.setString(11, toDbCh(email));
            pstmt.setString(12, toDbCh(othersInfo));
            pstmt.setString(13, toDbCh(addTime));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,useraccount,groupid,mynums,personname,personaccount,personid,workdepartment,officetel,mobiletel,hometel,email,othersinfo,addtime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(userAccount));
            pstmt.setString(3, toDbCh(groupid));
            pstmt.setString(4, toDbCh(myNums));
            pstmt.setString(5, toDbCh(personName));
            pstmt.setString(6, toDbCh(personAccount));
            pstmt.setString(7, toDbCh(personId));
            pstmt.setString(8, toDbCh(workDepartment));
            pstmt.setString(9, toDbCh(officeTel));
            pstmt.setString(10, toDbCh(mobileTel));
            pstmt.setString(11, toDbCh(homeTel));
            pstmt.setString(12, toDbCh(email));
            pstmt.setString(13, toDbCh(othersInfo));
            pstmt.setString(14, toDbCh(addTime));
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
            AddBookPerson item = (AddBookPerson)it.next();
            AddBookPerson v = new AddBookPerson(dbname);
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
                if (modifiedFields.contains("Groupid")) { pstmt.setString(pi ++, toDbCh(groupid)); }
                if (modifiedFields.contains("MyNums")) { pstmt.setString(pi ++, toDbCh(myNums)); }
                if (modifiedFields.contains("PersonName")) { pstmt.setString(pi ++, toDbCh(personName)); }
                if (modifiedFields.contains("PersonAccount")) { pstmt.setString(pi ++, toDbCh(personAccount)); }
                if (modifiedFields.contains("PersonId")) { pstmt.setString(pi ++, toDbCh(personId)); }
                if (modifiedFields.contains("WorkDepartment")) { pstmt.setString(pi ++, toDbCh(workDepartment)); }
                if (modifiedFields.contains("OfficeTel")) { pstmt.setString(pi ++, toDbCh(officeTel)); }
                if (modifiedFields.contains("MobileTel")) { pstmt.setString(pi ++, toDbCh(mobileTel)); }
                if (modifiedFields.contains("HomeTel")) { pstmt.setString(pi ++, toDbCh(homeTel)); }
                if (modifiedFields.contains("Email")) { pstmt.setString(pi ++, toDbCh(email)); }
                if (modifiedFields.contains("OthersInfo")) { pstmt.setString(pi ++, toDbCh(othersInfo)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setString(pi ++, toDbCh(addTime)); }
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
                if (modifiedFields.contains("Groupid")) { pstmt.setString(pi ++, toDbCh(groupid)); }
                if (modifiedFields.contains("MyNums")) { pstmt.setString(pi ++, toDbCh(myNums)); }
                if (modifiedFields.contains("PersonName")) { pstmt.setString(pi ++, toDbCh(personName)); }
                if (modifiedFields.contains("PersonAccount")) { pstmt.setString(pi ++, toDbCh(personAccount)); }
                if (modifiedFields.contains("PersonId")) { pstmt.setString(pi ++, toDbCh(personId)); }
                if (modifiedFields.contains("WorkDepartment")) { pstmt.setString(pi ++, toDbCh(workDepartment)); }
                if (modifiedFields.contains("OfficeTel")) { pstmt.setString(pi ++, toDbCh(officeTel)); }
                if (modifiedFields.contains("MobileTel")) { pstmt.setString(pi ++, toDbCh(mobileTel)); }
                if (modifiedFields.contains("HomeTel")) { pstmt.setString(pi ++, toDbCh(homeTel)); }
                if (modifiedFields.contains("Email")) { pstmt.setString(pi ++, toDbCh(email)); }
                if (modifiedFields.contains("OthersInfo")) { pstmt.setString(pi ++, toDbCh(othersInfo)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setString(pi ++, toDbCh(addTime)); }
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
        map.put("Groupid", getGroupid());
        map.put("MyNums", getMyNums());
        map.put("PersonName", getPersonName());
        map.put("PersonAccount", getPersonAccount());
        map.put("PersonId", getPersonId());
        map.put("WorkDepartment", getWorkDepartment());
        map.put("OfficeTel", getOfficeTel());
        map.put("MobileTel", getMobileTel());
        map.put("HomeTel", getHomeTel());
        map.put("Email", getEmail());
        map.put("OthersInfo", getOthersInfo());
        map.put("AddTime", getAddTime());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("UserAccount:\"" + Tool.jsSpecialChars(getUserAccount()) + "\"");
        row.add("Groupid:\"" + Tool.jsSpecialChars(getGroupid()) + "\"");
        row.add("MyNums:\"" + Tool.jsSpecialChars(getMyNums()) + "\"");
        row.add("PersonName:\"" + Tool.jsSpecialChars(getPersonName()) + "\"");
        row.add("PersonAccount:\"" + Tool.jsSpecialChars(getPersonAccount()) + "\"");
        row.add("PersonId:\"" + Tool.jsSpecialChars(getPersonId()) + "\"");
        row.add("WorkDepartment:\"" + Tool.jsSpecialChars(getWorkDepartment()) + "\"");
        row.add("OfficeTel:\"" + Tool.jsSpecialChars(getOfficeTel()) + "\"");
        row.add("MobileTel:\"" + Tool.jsSpecialChars(getMobileTel()) + "\"");
        row.add("HomeTel:\"" + Tool.jsSpecialChars(getHomeTel()) + "\"");
        row.add("Email:\"" + Tool.jsSpecialChars(getEmail()) + "\"");
        row.add("OthersInfo:\"" + Tool.jsSpecialChars(getOthersInfo()) + "\"");
        row.add("AddTime:\"" + Tool.jsSpecialChars(getAddTime()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,useraccount varchar2(45) not null,groupid varchar2(45),mynums varchar2(45),personname varchar2(45),personaccount varchar2(45),personid varchar2(45),workdepartment varchar2(45),officetel varchar2(45),mobiletel varchar2(45),hometel varchar2(45),email varchar2(45),othersinfo varchar2(45),addtime varchar2(45))"});
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
        AddBookPerson v = new AddBookPerson(sourceDb, sourceTb);
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
        AddBookPerson v = new AddBookPerson(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(AddBookPerson obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getUserAccount().compareTo(obj.getUserAccount()); if (rtn != 0) return rtn;
        rtn = getGroupid().compareTo(obj.getGroupid()); if (rtn != 0) return rtn;
        rtn = getMyNums().compareTo(obj.getMyNums()); if (rtn != 0) return rtn;
        rtn = getPersonName().compareTo(obj.getPersonName()); if (rtn != 0) return rtn;
        rtn = getPersonAccount().compareTo(obj.getPersonAccount()); if (rtn != 0) return rtn;
        rtn = getPersonId().compareTo(obj.getPersonId()); if (rtn != 0) return rtn;
        rtn = getWorkDepartment().compareTo(obj.getWorkDepartment()); if (rtn != 0) return rtn;
        rtn = getOfficeTel().compareTo(obj.getOfficeTel()); if (rtn != 0) return rtn;
        rtn = getMobileTel().compareTo(obj.getMobileTel()); if (rtn != 0) return rtn;
        rtn = getHomeTel().compareTo(obj.getHomeTel()); if (rtn != 0) return rtn;
        rtn = getEmail().compareTo(obj.getEmail()); if (rtn != 0) return rtn;
        rtn = getOthersInfo().compareTo(obj.getOthersInfo()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        return rtn;
    }
}
