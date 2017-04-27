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
@Description("用户表")
public class UserAccounts implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(UserAccounts.class);
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
    public static final String DbTableName = "useraccounts";
    private String TNAME = "useraccounts";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","userAccount","passWord","trueName","sex","nickName","userRole","userGroupList","accountState","workUnit","academy","myLastLoginIp","myLastLoginTime","birthday","email","mobiltel","homeAddress","homeTel","officeTel","fax","officeAddress","question1","answer1","city","addperson","addtime"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","useraccount","password","truename","sex","nickname","userrole","usergrouplist","accountstate","workunit","academy","mylastloginip","mylastlogintime","birthday","email","mobiltel","homeaddress","hometel","officetel","fax","officeaddress","question1","answer1","city","addperson","addtime"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"UserAccount","useraccount","int"},{"PassWord","password","String"},{"TrueName","truename","String"},{"Sex","sex","String"},{"NickName","nickname","String"},{"UserRole","userrole","String"},{"UserGroupList","usergrouplist","String"},{"AccountState","accountstate","String"},{"WorkUnit","workunit","String"},{"Academy","academy","String"},{"MyLastLoginIp","mylastloginip","String"},{"MyLastLoginTime","mylastlogintime","java.util.Date"},{"Birthday","birthday","java.util.Date"},{"Email","email","String"},{"Mobiltel","mobiltel","String"},{"HomeAddress","homeaddress","String"},{"HomeTel","hometel","String"},{"OfficeTel","officetel","String"},{"Fax","fax","String"},{"OfficeAddress","officeaddress","String"},{"Question1","question1","String"},{"Answer1","answer1","String"},{"City","city","String"},{"Addperson","addperson","String"},{"Addtime","addtime","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"userAccount","useraccount"},{"passWord","password"},{"trueName","truename"},{"sex","sex"},{"nickName","nickname"},{"userRole","userrole"},{"userGroupList","usergrouplist"},{"accountState","accountstate"},{"workUnit","workunit"},{"academy","academy"},{"myLastLoginIp","mylastloginip"},{"myLastLoginTime","mylastlogintime"},{"birthday","birthday"},{"email","email"},{"mobiltel","mobiltel"},{"homeAddress","homeaddress"},{"homeTel","hometel"},{"officeTel","officetel"},{"fax","fax"},{"officeAddress","officeaddress"},{"question1","question1"},{"answer1","answer1"},{"city","city"},{"addperson","addperson"},{"addtime","addtime"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"MYLASTLOGINTIME","BIRTHDAY"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 用户账号
    protected int userAccount = -1;
    public int getUserAccount() { return userAccount; }
    public void setUserAccount(int aUserAccount) { userAccount = aUserAccount; modifiedFields.add("UserAccount"); }
    public void assignUserAccount(int aUserAccount) { userAccount = aUserAccount; }
    public void paramUserAccount(HttpServletRequest request) { paramUserAccount(request, "UserAccount"); }
    public void paramUserAccount(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getUserAccount()); if (tmp != getUserAccount()) { setUserAccount(tmp); } }
    // 密码
    protected String passWord = "";
    public String getPassWord() {  return SqlTool.getDbString(passWord);  }
    public String getPassWord(int size) { return SqlTool.subString(getPassWord(), size); }
    public void setPassWord(String aPassWord) { passWord = aPassWord; modifiedFields.add("PassWord"); }
    public void assignPassWord(String aPassWord) { passWord = aPassWord; }
    public void paramPassWord(HttpServletRequest request) { paramPassWord(request, "PassWord"); }
    public void paramPassWord(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPassWord()); if (!tmp.equals(getPassWord())) { setPassWord(tmp); } }
    // 真实姓名
    protected String trueName = "";
    public String getTrueName() {  return SqlTool.getDbString(trueName);  }
    public String getTrueName(int size) { return SqlTool.subString(getTrueName(), size); }
    public void setTrueName(String aTrueName) { trueName = aTrueName; modifiedFields.add("TrueName"); }
    public void assignTrueName(String aTrueName) { trueName = aTrueName; }
    public void paramTrueName(HttpServletRequest request) { paramTrueName(request, "TrueName"); }
    public void paramTrueName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTrueName()); if (!tmp.equals(getTrueName())) { setTrueName(tmp); } }
    // 性别
    protected String sex = "";
    public String getSex() {  return SqlTool.getDbString(sex);  }
    public String getSex(int size) { return SqlTool.subString(getSex(), size); }
    public void setSex(String aSex) { sex = aSex; modifiedFields.add("Sex"); }
    public void assignSex(String aSex) { sex = aSex; }
    public void paramSex(HttpServletRequest request) { paramSex(request, "Sex"); }
    public void paramSex(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSex()); if (!tmp.equals(getSex())) { setSex(tmp); } }
    // 昵称
    protected String nickName = "";
    public String getNickName() {  return SqlTool.getDbString(nickName);  }
    public String getNickName(int size) { return SqlTool.subString(getNickName(), size); }
    public void setNickName(String aNickName) { nickName = aNickName; modifiedFields.add("NickName"); }
    public void assignNickName(String aNickName) { nickName = aNickName; }
    public void paramNickName(HttpServletRequest request) { paramNickName(request, "NickName"); }
    public void paramNickName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getNickName()); if (!tmp.equals(getNickName())) { setNickName(tmp); } }
    // 用户角色
    protected String userRole = "";
    public String getUserRole() {  return SqlTool.getDbString(userRole);  }
    public String getUserRole(int size) { return SqlTool.subString(getUserRole(), size); }
    public void setUserRole(String aUserRole) { userRole = aUserRole; modifiedFields.add("UserRole"); }
    public void assignUserRole(String aUserRole) { userRole = aUserRole; }
    public void paramUserRole(HttpServletRequest request) { paramUserRole(request, "UserRole"); }
    public void paramUserRole(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUserRole()); if (!tmp.equals(getUserRole())) { setUserRole(tmp); } }
    // 用户分组
    protected String userGroupList = "";
    public String getUserGroupList() {  return SqlTool.getDbString(userGroupList);  }
    public String getUserGroupList(int size) { return SqlTool.subString(getUserGroupList(), size); }
    public void setUserGroupList(String aUserGroupList) { userGroupList = aUserGroupList; modifiedFields.add("UserGroupList"); }
    public void assignUserGroupList(String aUserGroupList) { userGroupList = aUserGroupList; }
    public void paramUserGroupList(HttpServletRequest request) { paramUserGroupList(request, "UserGroupList"); }
    public void paramUserGroupList(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUserGroupList()); if (!tmp.equals(getUserGroupList())) { setUserGroupList(tmp); } }
    // 账号状态
    protected String accountState = "";
    public String getAccountState() {  return SqlTool.getDbString(accountState);  }
    public String getAccountState(int size) { return SqlTool.subString(getAccountState(), size); }
    public void setAccountState(String aAccountState) { accountState = aAccountState; modifiedFields.add("AccountState"); }
    public void assignAccountState(String aAccountState) { accountState = aAccountState; }
    public void paramAccountState(HttpServletRequest request) { paramAccountState(request, "AccountState"); }
    public void paramAccountState(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAccountState()); if (!tmp.equals(getAccountState())) { setAccountState(tmp); } }
    // 工作单位
    protected String workUnit = "";
    public String getWorkUnit() {  return SqlTool.getDbString(workUnit);  }
    public String getWorkUnit(int size) { return SqlTool.subString(getWorkUnit(), size); }
    public void setWorkUnit(String aWorkUnit) { workUnit = aWorkUnit; modifiedFields.add("WorkUnit"); }
    public void assignWorkUnit(String aWorkUnit) { workUnit = aWorkUnit; }
    public void paramWorkUnit(HttpServletRequest request) { paramWorkUnit(request, "WorkUnit"); }
    public void paramWorkUnit(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getWorkUnit()); if (!tmp.equals(getWorkUnit())) { setWorkUnit(tmp); } }
    // 学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 最后登录ip
    protected String myLastLoginIp = "";
    public String getMyLastLoginIp() {  return SqlTool.getDbString(myLastLoginIp);  }
    public String getMyLastLoginIp(int size) { return SqlTool.subString(getMyLastLoginIp(), size); }
    public void setMyLastLoginIp(String aMyLastLoginIp) { myLastLoginIp = aMyLastLoginIp; modifiedFields.add("MyLastLoginIp"); }
    public void assignMyLastLoginIp(String aMyLastLoginIp) { myLastLoginIp = aMyLastLoginIp; }
    public void paramMyLastLoginIp(HttpServletRequest request) { paramMyLastLoginIp(request, "MyLastLoginIp"); }
    public void paramMyLastLoginIp(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMyLastLoginIp()); if (!tmp.equals(getMyLastLoginIp())) { setMyLastLoginIp(tmp); } }
    // 最后登录时间
    protected java.util.Date myLastLoginTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getMyLastLoginTime() { return myLastLoginTime; }
    public void setMyLastLoginTime(java.util.Date aMyLastLoginTime) { myLastLoginTime = aMyLastLoginTime; modifiedFields.add("MyLastLoginTime"); }
    public void assignMyLastLoginTime(java.util.Date aMyLastLoginTime) { myLastLoginTime = aMyLastLoginTime; }
    public void paramMyLastLoginTime(HttpServletRequest request) { paramMyLastLoginTime(request, "MyLastLoginTime"); }
    public void paramMyLastLoginTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getMyLastLoginTime()); if (tmp.compareTo(getMyLastLoginTime()) != 0) { setMyLastLoginTime(tmp); } }
    // 生日
    protected java.util.Date birthday = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getBirthday() { return birthday; }
    public void setBirthday(java.util.Date aBirthday) { birthday = aBirthday; modifiedFields.add("Birthday"); }
    public void assignBirthday(java.util.Date aBirthday) { birthday = aBirthday; }
    public void paramBirthday(HttpServletRequest request) { paramBirthday(request, "Birthday"); }
    public void paramBirthday(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getBirthday()); if (tmp.compareTo(getBirthday()) != 0) { setBirthday(tmp); } }
    // 邮箱
    protected String email = "";
    public String getEmail() {  return SqlTool.getDbString(email);  }
    public String getEmail(int size) { return SqlTool.subString(getEmail(), size); }
    public void setEmail(String aEmail) { email = aEmail; modifiedFields.add("Email"); }
    public void assignEmail(String aEmail) { email = aEmail; }
    public void paramEmail(HttpServletRequest request) { paramEmail(request, "Email"); }
    public void paramEmail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getEmail()); if (!tmp.equals(getEmail())) { setEmail(tmp); } }
    // 手机
    protected String mobiltel = "";
    public String getMobiltel() {  return SqlTool.getDbString(mobiltel);  }
    public String getMobiltel(int size) { return SqlTool.subString(getMobiltel(), size); }
    public void setMobiltel(String aMobiltel) { mobiltel = aMobiltel; modifiedFields.add("Mobiltel"); }
    public void assignMobiltel(String aMobiltel) { mobiltel = aMobiltel; }
    public void paramMobiltel(HttpServletRequest request) { paramMobiltel(request, "Mobiltel"); }
    public void paramMobiltel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMobiltel()); if (!tmp.equals(getMobiltel())) { setMobiltel(tmp); } }
    // 家庭地址
    protected String homeAddress = "";
    public String getHomeAddress() {  return SqlTool.getDbString(homeAddress);  }
    public String getHomeAddress(int size) { return SqlTool.subString(getHomeAddress(), size); }
    public void setHomeAddress(String aHomeAddress) { homeAddress = aHomeAddress; modifiedFields.add("HomeAddress"); }
    public void assignHomeAddress(String aHomeAddress) { homeAddress = aHomeAddress; }
    public void paramHomeAddress(HttpServletRequest request) { paramHomeAddress(request, "HomeAddress"); }
    public void paramHomeAddress(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHomeAddress()); if (!tmp.equals(getHomeAddress())) { setHomeAddress(tmp); } }
    // 家庭电话
    protected String homeTel = "";
    public String getHomeTel() {  return SqlTool.getDbString(homeTel);  }
    public String getHomeTel(int size) { return SqlTool.subString(getHomeTel(), size); }
    public void setHomeTel(String aHomeTel) { homeTel = aHomeTel; modifiedFields.add("HomeTel"); }
    public void assignHomeTel(String aHomeTel) { homeTel = aHomeTel; }
    public void paramHomeTel(HttpServletRequest request) { paramHomeTel(request, "HomeTel"); }
    public void paramHomeTel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHomeTel()); if (!tmp.equals(getHomeTel())) { setHomeTel(tmp); } }
    // 办公电话
    protected String officeTel = "";
    public String getOfficeTel() {  return SqlTool.getDbString(officeTel);  }
    public String getOfficeTel(int size) { return SqlTool.subString(getOfficeTel(), size); }
    public void setOfficeTel(String aOfficeTel) { officeTel = aOfficeTel; modifiedFields.add("OfficeTel"); }
    public void assignOfficeTel(String aOfficeTel) { officeTel = aOfficeTel; }
    public void paramOfficeTel(HttpServletRequest request) { paramOfficeTel(request, "OfficeTel"); }
    public void paramOfficeTel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOfficeTel()); if (!tmp.equals(getOfficeTel())) { setOfficeTel(tmp); } }
    // 传真
    protected String fax = "";
    public String getFax() {  return SqlTool.getDbString(fax);  }
    public String getFax(int size) { return SqlTool.subString(getFax(), size); }
    public void setFax(String aFax) { fax = aFax; modifiedFields.add("Fax"); }
    public void assignFax(String aFax) { fax = aFax; }
    public void paramFax(HttpServletRequest request) { paramFax(request, "Fax"); }
    public void paramFax(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFax()); if (!tmp.equals(getFax())) { setFax(tmp); } }
    // 办公地址
    protected String officeAddress = "";
    public String getOfficeAddress() {  return SqlTool.getDbString(officeAddress);  }
    public String getOfficeAddress(int size) { return SqlTool.subString(getOfficeAddress(), size); }
    public void setOfficeAddress(String aOfficeAddress) { officeAddress = aOfficeAddress; modifiedFields.add("OfficeAddress"); }
    public void assignOfficeAddress(String aOfficeAddress) { officeAddress = aOfficeAddress; }
    public void paramOfficeAddress(HttpServletRequest request) { paramOfficeAddress(request, "OfficeAddress"); }
    public void paramOfficeAddress(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOfficeAddress()); if (!tmp.equals(getOfficeAddress())) { setOfficeAddress(tmp); } }
    // 问题1
    protected String question1 = "";
    public String getQuestion1() {  return SqlTool.getDbString(question1);  }
    public String getQuestion1(int size) { return SqlTool.subString(getQuestion1(), size); }
    public void setQuestion1(String aQuestion1) { question1 = aQuestion1; modifiedFields.add("Question1"); }
    public void assignQuestion1(String aQuestion1) { question1 = aQuestion1; }
    public void paramQuestion1(HttpServletRequest request) { paramQuestion1(request, "Question1"); }
    public void paramQuestion1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getQuestion1()); if (!tmp.equals(getQuestion1())) { setQuestion1(tmp); } }
    // 回答1
    protected String answer1 = "";
    public String getAnswer1() {  return SqlTool.getDbString(answer1);  }
    public String getAnswer1(int size) { return SqlTool.subString(getAnswer1(), size); }
    public void setAnswer1(String aAnswer1) { answer1 = aAnswer1; modifiedFields.add("Answer1"); }
    public void assignAnswer1(String aAnswer1) { answer1 = aAnswer1; }
    public void paramAnswer1(HttpServletRequest request) { paramAnswer1(request, "Answer1"); }
    public void paramAnswer1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAnswer1()); if (!tmp.equals(getAnswer1())) { setAnswer1(tmp); } }
    // 城市
    protected String city = "";
    public String getCity() {  return SqlTool.getDbString(city);  }
    public String getCity(int size) { return SqlTool.subString(getCity(), size); }
    public void setCity(String aCity) { city = aCity; modifiedFields.add("City"); }
    public void assignCity(String aCity) { city = aCity; }
    public void paramCity(HttpServletRequest request) { paramCity(request, "City"); }
    public void paramCity(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCity()); if (!tmp.equals(getCity())) { setCity(tmp); } }
    // 添加人
    protected String addperson = "";
    public String getAddperson() {  return SqlTool.getDbString(addperson);  }
    public String getAddperson(int size) { return SqlTool.subString(getAddperson(), size); }
    public void setAddperson(String aAddperson) { addperson = aAddperson; modifiedFields.add("Addperson"); }
    public void assignAddperson(String aAddperson) { addperson = aAddperson; }
    public void paramAddperson(HttpServletRequest request) { paramAddperson(request, "Addperson"); }
    public void paramAddperson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddperson()); if (!tmp.equals(getAddperson())) { setAddperson(tmp); } }
    // 添加时间
    protected String addtime = "";
    public String getAddtime() {  return SqlTool.getDbString(addtime);  }
    public String getAddtime(int size) { return SqlTool.subString(getAddtime(), size); }
    public void setAddtime(String aAddtime) { addtime = aAddtime; modifiedFields.add("Addtime"); }
    public void assignAddtime(String aAddtime) { addtime = aAddtime; }
    public void paramAddtime(HttpServletRequest request) { paramAddtime(request, "Addtime"); }
    public void paramAddtime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddtime()); if (!tmp.equals(getAddtime())) { setAddtime(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public UserAccounts (String db) {
        DBNAME = db;
    }
    public UserAccounts (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public UserAccounts (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public UserAccounts () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return UserAccounts类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public UserAccounts getByParameter(HttpServletRequest request) {
        UserAccounts v = new UserAccounts(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramUserAccount(request);
        paramPassWord(request);
        paramTrueName(request);
        paramSex(request);
        paramNickName(request);
        paramUserRole(request);
        paramUserGroupList(request);
        paramAccountState(request);
        paramWorkUnit(request);
        paramAcademy(request);
        paramMyLastLoginIp(request);
        paramMyLastLoginTime(request);
        paramBirthday(request);
        paramEmail(request);
        paramMobiltel(request);
        paramHomeAddress(request);
        paramHomeTel(request);
        paramOfficeTel(request);
        paramFax(request);
        paramOfficeAddress(request);
        paramQuestion1(request);
        paramAnswer1(request);
        paramCity(request);
        paramAddperson(request);
        paramAddtime(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(UserAccounts bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("userAccount")) { setUserAccount(bean.getUserAccount()); }
        if (!ncl.contains("passWord")) { setPassWord(bean.getPassWord()); }
        if (!ncl.contains("trueName")) { setTrueName(bean.getTrueName()); }
        if (!ncl.contains("sex")) { setSex(bean.getSex()); }
        if (!ncl.contains("nickName")) { setNickName(bean.getNickName()); }
        if (!ncl.contains("userRole")) { setUserRole(bean.getUserRole()); }
        if (!ncl.contains("userGroupList")) { setUserGroupList(bean.getUserGroupList()); }
        if (!ncl.contains("accountState")) { setAccountState(bean.getAccountState()); }
        if (!ncl.contains("workUnit")) { setWorkUnit(bean.getWorkUnit()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("myLastLoginIp")) { setMyLastLoginIp(bean.getMyLastLoginIp()); }
        if (!ncl.contains("myLastLoginTime")) { setMyLastLoginTime(bean.getMyLastLoginTime()); }
        if (!ncl.contains("birthday")) { setBirthday(bean.getBirthday()); }
        if (!ncl.contains("email")) { setEmail(bean.getEmail()); }
        if (!ncl.contains("mobiltel")) { setMobiltel(bean.getMobiltel()); }
        if (!ncl.contains("homeAddress")) { setHomeAddress(bean.getHomeAddress()); }
        if (!ncl.contains("homeTel")) { setHomeTel(bean.getHomeTel()); }
        if (!ncl.contains("officeTel")) { setOfficeTel(bean.getOfficeTel()); }
        if (!ncl.contains("fax")) { setFax(bean.getFax()); }
        if (!ncl.contains("officeAddress")) { setOfficeAddress(bean.getOfficeAddress()); }
        if (!ncl.contains("question1")) { setQuestion1(bean.getQuestion1()); }
        if (!ncl.contains("answer1")) { setAnswer1(bean.getAnswer1()); }
        if (!ncl.contains("city")) { setCity(bean.getCity()); }
        if (!ncl.contains("addperson")) { setAddperson(bean.getAddperson()); }
        if (!ncl.contains("addtime")) { setAddtime(bean.getAddtime()); }
    }
    public UserAccounts getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        UserAccounts[] rslt= queryByCondition(cdt);
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
     * @return UserAccounts类的实例列表。
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
                UserAccounts ve = new UserAccounts(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignUserAccount(rs.getInt(2));
                ve.assignPassWord(fromDbCh(rs.getString(3)));
                ve.assignTrueName(fromDbCh(rs.getString(4)));
                ve.assignSex(fromDbCh(rs.getString(5)));
                ve.assignNickName(fromDbCh(rs.getString(6)));
                ve.assignUserRole(fromDbCh(rs.getString(7)));
                ve.assignUserGroupList(fromDbCh(rs.getString(8)));
                ve.assignAccountState(fromDbCh(rs.getString(9)));
                ve.assignWorkUnit(fromDbCh(rs.getString(10)));
                ve.assignAcademy(fromDbCh(rs.getString(11)));
                ve.assignMyLastLoginIp(fromDbCh(rs.getString(12)));
                tmpDate = rs.getTimestamp(13); if (tmpDate != null) { ve.assignMyLastLoginTime(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(14); if (tmpDate != null) { ve.assignBirthday(new java.util.Date(tmpDate.getTime())); }
                ve.assignEmail(fromDbCh(rs.getString(15)));
                ve.assignMobiltel(fromDbCh(rs.getString(16)));
                ve.assignHomeAddress(fromDbCh(rs.getString(17)));
                ve.assignHomeTel(fromDbCh(rs.getString(18)));
                ve.assignOfficeTel(fromDbCh(rs.getString(19)));
                ve.assignFax(fromDbCh(rs.getString(20)));
                ve.assignOfficeAddress(fromDbCh(rs.getString(21)));
                ve.assignQuestion1(fromDbCh(rs.getString(22)));
                ve.assignAnswer1(fromDbCh(rs.getString(23)));
                ve.assignCity(fromDbCh(rs.getString(24)));
                ve.assignAddperson(fromDbCh(rs.getString(25)));
                ve.assignAddtime(fromDbCh(rs.getString(26)));
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
    public UserAccounts[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (UserAccounts[])vrs.toArray(new UserAccounts[vrs.size()]);
    }
    public UserAccounts[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (UserAccounts[])vrs.toArray(new UserAccounts[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (useraccount,password,truename,sex,nickname,userrole,usergrouplist,accountstate,workunit,academy,mylastloginip,mylastlogintime,birthday,email,mobiltel,homeaddress,hometel,officetel,fax,officeaddress,question1,answer1,city,addperson,addtime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, userAccount);
            pstmt.setString(2, toDbCh(passWord));
            pstmt.setString(3, toDbCh(trueName));
            pstmt.setString(4, toDbCh(sex));
            pstmt.setString(5, toDbCh(nickName));
            pstmt.setString(6, toDbCh(userRole));
            pstmt.setString(7, toDbCh(userGroupList));
            pstmt.setString(8, toDbCh(accountState));
            pstmt.setString(9, toDbCh(workUnit));
            pstmt.setString(10, toDbCh(academy));
            pstmt.setString(11, toDbCh(myLastLoginIp));
            pstmt.setTimestamp(12, new java.sql.Timestamp(myLastLoginTime.getTime()));
            pstmt.setTimestamp(13, new java.sql.Timestamp(birthday.getTime()));
            pstmt.setString(14, toDbCh(email));
            pstmt.setString(15, toDbCh(mobiltel));
            pstmt.setString(16, toDbCh(homeAddress));
            pstmt.setString(17, toDbCh(homeTel));
            pstmt.setString(18, toDbCh(officeTel));
            pstmt.setString(19, toDbCh(fax));
            pstmt.setString(20, toDbCh(officeAddress));
            pstmt.setString(21, toDbCh(question1));
            pstmt.setString(22, toDbCh(answer1));
            pstmt.setString(23, toDbCh(city));
            pstmt.setString(24, toDbCh(addperson));
            pstmt.setString(25, toDbCh(addtime));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,useraccount,password,truename,sex,nickname,userrole,usergrouplist,accountstate,workunit,academy,mylastloginip,mylastlogintime,birthday,email,mobiltel,homeaddress,hometel,officetel,fax,officeaddress,question1,answer1,city,addperson,addtime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, userAccount);
            pstmt.setString(3, toDbCh(passWord));
            pstmt.setString(4, toDbCh(trueName));
            pstmt.setString(5, toDbCh(sex));
            pstmt.setString(6, toDbCh(nickName));
            pstmt.setString(7, toDbCh(userRole));
            pstmt.setString(8, toDbCh(userGroupList));
            pstmt.setString(9, toDbCh(accountState));
            pstmt.setString(10, toDbCh(workUnit));
            pstmt.setString(11, toDbCh(academy));
            pstmt.setString(12, toDbCh(myLastLoginIp));
            pstmt.setTimestamp(13, new java.sql.Timestamp(myLastLoginTime.getTime()));
            pstmt.setTimestamp(14, new java.sql.Timestamp(birthday.getTime()));
            pstmt.setString(15, toDbCh(email));
            pstmt.setString(16, toDbCh(mobiltel));
            pstmt.setString(17, toDbCh(homeAddress));
            pstmt.setString(18, toDbCh(homeTel));
            pstmt.setString(19, toDbCh(officeTel));
            pstmt.setString(20, toDbCh(fax));
            pstmt.setString(21, toDbCh(officeAddress));
            pstmt.setString(22, toDbCh(question1));
            pstmt.setString(23, toDbCh(answer1));
            pstmt.setString(24, toDbCh(city));
            pstmt.setString(25, toDbCh(addperson));
            pstmt.setString(26, toDbCh(addtime));
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
            UserAccounts item = (UserAccounts)it.next();
            UserAccounts v = new UserAccounts(dbname);
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
                if (modifiedFields.contains("UserAccount")) { pstmt.setInt(pi ++, userAccount); }
                if (modifiedFields.contains("PassWord")) { pstmt.setString(pi ++, toDbCh(passWord)); }
                if (modifiedFields.contains("TrueName")) { pstmt.setString(pi ++, toDbCh(trueName)); }
                if (modifiedFields.contains("Sex")) { pstmt.setString(pi ++, toDbCh(sex)); }
                if (modifiedFields.contains("NickName")) { pstmt.setString(pi ++, toDbCh(nickName)); }
                if (modifiedFields.contains("UserRole")) { pstmt.setString(pi ++, toDbCh(userRole)); }
                if (modifiedFields.contains("UserGroupList")) { pstmt.setString(pi ++, toDbCh(userGroupList)); }
                if (modifiedFields.contains("AccountState")) { pstmt.setString(pi ++, toDbCh(accountState)); }
                if (modifiedFields.contains("WorkUnit")) { pstmt.setString(pi ++, toDbCh(workUnit)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("MyLastLoginIp")) { pstmt.setString(pi ++, toDbCh(myLastLoginIp)); }
                if (modifiedFields.contains("MyLastLoginTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(myLastLoginTime.getTime())); }
                if (modifiedFields.contains("Birthday")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(birthday.getTime())); }
                if (modifiedFields.contains("Email")) { pstmt.setString(pi ++, toDbCh(email)); }
                if (modifiedFields.contains("Mobiltel")) { pstmt.setString(pi ++, toDbCh(mobiltel)); }
                if (modifiedFields.contains("HomeAddress")) { pstmt.setString(pi ++, toDbCh(homeAddress)); }
                if (modifiedFields.contains("HomeTel")) { pstmt.setString(pi ++, toDbCh(homeTel)); }
                if (modifiedFields.contains("OfficeTel")) { pstmt.setString(pi ++, toDbCh(officeTel)); }
                if (modifiedFields.contains("Fax")) { pstmt.setString(pi ++, toDbCh(fax)); }
                if (modifiedFields.contains("OfficeAddress")) { pstmt.setString(pi ++, toDbCh(officeAddress)); }
                if (modifiedFields.contains("Question1")) { pstmt.setString(pi ++, toDbCh(question1)); }
                if (modifiedFields.contains("Answer1")) { pstmt.setString(pi ++, toDbCh(answer1)); }
                if (modifiedFields.contains("City")) { pstmt.setString(pi ++, toDbCh(city)); }
                if (modifiedFields.contains("Addperson")) { pstmt.setString(pi ++, toDbCh(addperson)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setString(pi ++, toDbCh(addtime)); }
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
                if (modifiedFields.contains("UserAccount")) { pstmt.setInt(pi ++, userAccount); }
                if (modifiedFields.contains("PassWord")) { pstmt.setString(pi ++, toDbCh(passWord)); }
                if (modifiedFields.contains("TrueName")) { pstmt.setString(pi ++, toDbCh(trueName)); }
                if (modifiedFields.contains("Sex")) { pstmt.setString(pi ++, toDbCh(sex)); }
                if (modifiedFields.contains("NickName")) { pstmt.setString(pi ++, toDbCh(nickName)); }
                if (modifiedFields.contains("UserRole")) { pstmt.setString(pi ++, toDbCh(userRole)); }
                if (modifiedFields.contains("UserGroupList")) { pstmt.setString(pi ++, toDbCh(userGroupList)); }
                if (modifiedFields.contains("AccountState")) { pstmt.setString(pi ++, toDbCh(accountState)); }
                if (modifiedFields.contains("WorkUnit")) { pstmt.setString(pi ++, toDbCh(workUnit)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("MyLastLoginIp")) { pstmt.setString(pi ++, toDbCh(myLastLoginIp)); }
                if (modifiedFields.contains("MyLastLoginTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(myLastLoginTime.getTime())); }
                if (modifiedFields.contains("Birthday")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(birthday.getTime())); }
                if (modifiedFields.contains("Email")) { pstmt.setString(pi ++, toDbCh(email)); }
                if (modifiedFields.contains("Mobiltel")) { pstmt.setString(pi ++, toDbCh(mobiltel)); }
                if (modifiedFields.contains("HomeAddress")) { pstmt.setString(pi ++, toDbCh(homeAddress)); }
                if (modifiedFields.contains("HomeTel")) { pstmt.setString(pi ++, toDbCh(homeTel)); }
                if (modifiedFields.contains("OfficeTel")) { pstmt.setString(pi ++, toDbCh(officeTel)); }
                if (modifiedFields.contains("Fax")) { pstmt.setString(pi ++, toDbCh(fax)); }
                if (modifiedFields.contains("OfficeAddress")) { pstmt.setString(pi ++, toDbCh(officeAddress)); }
                if (modifiedFields.contains("Question1")) { pstmt.setString(pi ++, toDbCh(question1)); }
                if (modifiedFields.contains("Answer1")) { pstmt.setString(pi ++, toDbCh(answer1)); }
                if (modifiedFields.contains("City")) { pstmt.setString(pi ++, toDbCh(city)); }
                if (modifiedFields.contains("Addperson")) { pstmt.setString(pi ++, toDbCh(addperson)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setString(pi ++, toDbCh(addtime)); }
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
        map.put("UserAccount", getUserAccount() + "");
        map.put("PassWord", getPassWord());
        map.put("TrueName", getTrueName());
        map.put("Sex", getSex());
        map.put("NickName", getNickName());
        map.put("UserRole", getUserRole());
        map.put("UserGroupList", getUserGroupList());
        map.put("AccountState", getAccountState());
        map.put("WorkUnit", getWorkUnit());
        map.put("Academy", getAcademy());
        map.put("MyLastLoginIp", getMyLastLoginIp());
        map.put("MyLastLoginTime", Tool.stringOfDateTime(getMyLastLoginTime()));
        map.put("Birthday", Tool.stringOfDateTime(getBirthday()));
        map.put("Email", getEmail());
        map.put("Mobiltel", getMobiltel());
        map.put("HomeAddress", getHomeAddress());
        map.put("HomeTel", getHomeTel());
        map.put("OfficeTel", getOfficeTel());
        map.put("Fax", getFax());
        map.put("OfficeAddress", getOfficeAddress());
        map.put("Question1", getQuestion1());
        map.put("Answer1", getAnswer1());
        map.put("City", getCity());
        map.put("Addperson", getAddperson());
        map.put("Addtime", getAddtime());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("UserAccount:\"" + getUserAccount() + "\"");
        row.add("PassWord:\"" + Tool.jsSpecialChars(getPassWord()) + "\"");
        row.add("TrueName:\"" + Tool.jsSpecialChars(getTrueName()) + "\"");
        row.add("Sex:\"" + Tool.jsSpecialChars(getSex()) + "\"");
        row.add("NickName:\"" + Tool.jsSpecialChars(getNickName()) + "\"");
        row.add("UserRole:\"" + Tool.jsSpecialChars(getUserRole()) + "\"");
        row.add("UserGroupList:\"" + Tool.jsSpecialChars(getUserGroupList()) + "\"");
        row.add("AccountState:\"" + Tool.jsSpecialChars(getAccountState()) + "\"");
        row.add("WorkUnit:\"" + Tool.jsSpecialChars(getWorkUnit()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("MyLastLoginIp:\"" + Tool.jsSpecialChars(getMyLastLoginIp()) + "\"");
        row.add("MyLastLoginTime:\"" + Tool.stringOfDateTime(getMyLastLoginTime()) + "\"");
        row.add("Birthday:\"" + Tool.stringOfDateTime(getBirthday()) + "\"");
        row.add("Email:\"" + Tool.jsSpecialChars(getEmail()) + "\"");
        row.add("Mobiltel:\"" + Tool.jsSpecialChars(getMobiltel()) + "\"");
        row.add("HomeAddress:\"" + Tool.jsSpecialChars(getHomeAddress()) + "\"");
        row.add("HomeTel:\"" + Tool.jsSpecialChars(getHomeTel()) + "\"");
        row.add("OfficeTel:\"" + Tool.jsSpecialChars(getOfficeTel()) + "\"");
        row.add("Fax:\"" + Tool.jsSpecialChars(getFax()) + "\"");
        row.add("OfficeAddress:\"" + Tool.jsSpecialChars(getOfficeAddress()) + "\"");
        row.add("Question1:\"" + Tool.jsSpecialChars(getQuestion1()) + "\"");
        row.add("Answer1:\"" + Tool.jsSpecialChars(getAnswer1()) + "\"");
        row.add("City:\"" + Tool.jsSpecialChars(getCity()) + "\"");
        row.add("Addperson:\"" + Tool.jsSpecialChars(getAddperson()) + "\"");
        row.add("Addtime:\"" + Tool.jsSpecialChars(getAddtime()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,useraccount number(*,0),password varchar2(45),truename varchar2(45),sex varchar2(4),nickname varchar2(45),userrole varchar2(10),usergrouplist varchar2(45),accountstate varchar2(45),workunit varchar2(45),academy varchar2(45),mylastloginip varchar2(45),mylastlogintime date,birthday date,email varchar2(45),mobiltel varchar2(45),homeaddress varchar2(45),hometel varchar2(45),officetel varchar2(45),fax varchar2(45),officeaddress varchar2(45),question1 varchar2(45),answer1 varchar2(45),city varchar2(45),addperson varchar2(45),addtime varchar2(45))"});
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
        UserAccounts v = new UserAccounts(sourceDb, sourceTb);
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
        UserAccounts v = new UserAccounts(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(UserAccounts obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getUserAccount()).compareTo("" + obj.getUserAccount()); if (rtn != 0) return rtn;
        rtn = getPassWord().compareTo(obj.getPassWord()); if (rtn != 0) return rtn;
        rtn = getTrueName().compareTo(obj.getTrueName()); if (rtn != 0) return rtn;
        rtn = getSex().compareTo(obj.getSex()); if (rtn != 0) return rtn;
        rtn = getNickName().compareTo(obj.getNickName()); if (rtn != 0) return rtn;
        rtn = getUserRole().compareTo(obj.getUserRole()); if (rtn != 0) return rtn;
        rtn = getUserGroupList().compareTo(obj.getUserGroupList()); if (rtn != 0) return rtn;
        rtn = getAccountState().compareTo(obj.getAccountState()); if (rtn != 0) return rtn;
        rtn = getWorkUnit().compareTo(obj.getWorkUnit()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getMyLastLoginIp().compareTo(obj.getMyLastLoginIp()); if (rtn != 0) return rtn;
        rtn = getMyLastLoginTime().compareTo(obj.getMyLastLoginTime()); if (rtn != 0) return rtn;
        rtn = getBirthday().compareTo(obj.getBirthday()); if (rtn != 0) return rtn;
        rtn = getEmail().compareTo(obj.getEmail()); if (rtn != 0) return rtn;
        rtn = getMobiltel().compareTo(obj.getMobiltel()); if (rtn != 0) return rtn;
        rtn = getHomeAddress().compareTo(obj.getHomeAddress()); if (rtn != 0) return rtn;
        rtn = getHomeTel().compareTo(obj.getHomeTel()); if (rtn != 0) return rtn;
        rtn = getOfficeTel().compareTo(obj.getOfficeTel()); if (rtn != 0) return rtn;
        rtn = getFax().compareTo(obj.getFax()); if (rtn != 0) return rtn;
        rtn = getOfficeAddress().compareTo(obj.getOfficeAddress()); if (rtn != 0) return rtn;
        rtn = getQuestion1().compareTo(obj.getQuestion1()); if (rtn != 0) return rtn;
        rtn = getAnswer1().compareTo(obj.getAnswer1()); if (rtn != 0) return rtn;
        rtn = getCity().compareTo(obj.getCity()); if (rtn != 0) return rtn;
        rtn = getAddperson().compareTo(obj.getAddperson()); if (rtn != 0) return rtn;
        rtn = getAddtime().compareTo(obj.getAddtime()); if (rtn != 0) return rtn;
        return rtn;
    }
}
