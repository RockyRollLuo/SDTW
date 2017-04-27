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
@Description("人员管理")
public class BaseUserCode implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(BaseUserCode.class);
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
    public static final String DbTableName = "base_usercode";
    private String TNAME = "base_usercode";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","orgId","orgCode","deptId","deptCode","name","cnName","code","gender","occupation","grade","dept","orderby","principal","phoneNum","mobilePhone","fax","officeAddress","email","pwd","homeAddress","homeZipcode","deptZipcode","userIpphome","lastTime","skinId","dispNum","orderbyField","orderStyle","roles","enable","isFirstLogon","operTime","operLog","operUser","locusCode","logonNum","curIp","curTime","isEnable","ip","identity","memberPolitics","timeToSchool","timeToTuan","birthday","zhiBu","nation","major","lenOfSchool","nativePlace","iDNum","phone","email2","addfilelist","yearToSchool","graduateTime","volunteerfFag"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","orgid","orgcode","deptid","deptcode","name","cnname","code","gender","occupation","grade","dept","orderby","principal","phonenum","mobilephone","fax","officeaddress","email","pwd","homeaddress","homezipcode","deptzipcode","useripphome","lasttime","skinid","dispnum","orderbyfield","orderstyle","roles","enable","isfirstlogon","opertime","operlog","operuser","locuscode","logonnum","curip","curtime","isenable","ip","identity","memberpolitics","timetoschool","timetotuan","birthday","zhibu","nation","major","lenofschool","nativeplace","idnum","phone","email2","addfilelist","yeartoschool","graduatetime","volunteerffag"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"OrgId","orgid","int"},{"OrgCode","orgcode","String"},{"DeptId","deptid","int"},{"DeptCode","deptcode","String"},{"Name","name","String"},{"CnName","cnname","String"},{"Code","code","String"},{"Gender","gender","int"},{"Occupation","occupation","String"},{"Grade","grade","String"},{"Dept","dept","String"},{"Orderby","orderby","int"},{"Principal","principal","String"},{"PhoneNum","phonenum","String"},{"MobilePhone","mobilephone","String"},{"Fax","fax","String"},{"OfficeAddress","officeaddress","String"},{"Email","email","String"},{"Pwd","pwd","String"},{"HomeAddress","homeaddress","String"},{"HomeZipcode","homezipcode","String"},{"DeptZipcode","deptzipcode","String"},{"UserIpphome","useripphome","String"},{"LastTime","lasttime","java.util.Date"},{"SkinId","skinid","String"},{"DispNum","dispnum","int"},{"OrderbyField","orderbyfield","String"},{"OrderStyle","orderstyle","String"},{"Roles","roles","String"},{"Enable","enable","int"},{"IsFirstLogon","isfirstlogon","int"},{"OperTime","opertime","java.util.Date"},{"OperLog","operlog","String"},{"OperUser","operuser","int"},{"LocusCode","locuscode","String"},{"LogonNum","logonnum","int"},{"CurIp","curip","String"},{"CurTime","curtime","java.util.Date"},{"IsEnable","isenable","int"},{"Ip","ip","String"},{"Identity","identity","String"},{"MemberPolitics","memberpolitics","String"},{"TimeToSchool","timetoschool","java.util.Date"},{"TimeToTuan","timetotuan","java.util.Date"},{"Birthday","birthday","java.util.Date"},{"ZhiBu","zhibu","String"},{"Nation","nation","String"},{"Major","major","String"},{"LenOfSchool","lenofschool","String"},{"NativePlace","nativeplace","String"},{"IDNum","idnum","String"},{"Phone","phone","String"},{"Email2","email2","String"},{"Addfilelist","addfilelist","String"},{"YearToSchool","yeartoschool","String"},{"GraduateTime","graduatetime","java.util.Date"},{"VolunteerfFag","volunteerffag","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"orgId","orgid"},{"orgCode","orgcode"},{"deptId","deptid"},{"deptCode","deptcode"},{"name","name"},{"cnName","cnname"},{"code","code"},{"gender","gender"},{"occupation","occupation"},{"grade","grade"},{"dept","dept"},{"orderby","orderby"},{"principal","principal"},{"phoneNum","phonenum"},{"mobilePhone","mobilephone"},{"fax","fax"},{"officeAddress","officeaddress"},{"email","email"},{"pwd","pwd"},{"homeAddress","homeaddress"},{"homeZipcode","homezipcode"},{"deptZipcode","deptzipcode"},{"userIpphome","useripphome"},{"lastTime","lasttime"},{"skinId","skinid"},{"dispNum","dispnum"},{"orderbyField","orderbyfield"},{"orderStyle","orderstyle"},{"roles","roles"},{"enable","enable"},{"isFirstLogon","isfirstlogon"},{"operTime","opertime"},{"operLog","operlog"},{"operUser","operuser"},{"locusCode","locuscode"},{"logonNum","logonnum"},{"curIp","curip"},{"curTime","curtime"},{"isEnable","isenable"},{"ip","ip"},{"identity","identity"},{"memberPolitics","memberpolitics"},{"timeToSchool","timetoschool"},{"timeToTuan","timetotuan"},{"birthday","birthday"},{"zhiBu","zhibu"},{"nation","nation"},{"major","major"},{"lenOfSchool","lenofschool"},{"nativePlace","nativeplace"},{"iDNum","idnum"},{"phone","phone"},{"email2","email2"},{"addfilelist","addfilelist"},{"yearToSchool","yeartoschool"},{"graduateTime","graduatetime"},{"volunteerfFag","volunteerffag"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"LASTTIME","OPERTIME","CURTIME","TIMETOSCHOOL","TIMETOTUAN","BIRTHDAY","GRADUATETIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 单位
    protected int orgId = -1;
    public int getOrgId() { return orgId; }
    public void setOrgId(int aOrgId) { orgId = aOrgId; modifiedFields.add("OrgId"); }
    public void assignOrgId(int aOrgId) { orgId = aOrgId; }
    public void paramOrgId(HttpServletRequest request) { paramOrgId(request, "OrgId"); }
    public void paramOrgId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getOrgId()); if (tmp != getOrgId()) { setOrgId(tmp); } }
    // 单位代码
    protected String orgCode = "";
    public String getOrgCode() {  return SqlTool.getDbString(orgCode);  }
    public String getOrgCode(int size) { return SqlTool.subString(getOrgCode(), size); }
    public void setOrgCode(String aOrgCode) { orgCode = aOrgCode; modifiedFields.add("OrgCode"); }
    public void assignOrgCode(String aOrgCode) { orgCode = aOrgCode; }
    public void paramOrgCode(HttpServletRequest request) { paramOrgCode(request, "OrgCode"); }
    public void paramOrgCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOrgCode()); if (!tmp.equals(getOrgCode())) { setOrgCode(tmp); } }
    // 部门
    protected int deptId = -1;
    public int getDeptId() { return deptId; }
    public void setDeptId(int aDeptId) { deptId = aDeptId; modifiedFields.add("DeptId"); }
    public void assignDeptId(int aDeptId) { deptId = aDeptId; }
    public void paramDeptId(HttpServletRequest request) { paramDeptId(request, "DeptId"); }
    public void paramDeptId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getDeptId()); if (tmp != getDeptId()) { setDeptId(tmp); } }
    // 部门代码
    protected String deptCode = "";
    public String getDeptCode() {  return SqlTool.getDbString(deptCode);  }
    public String getDeptCode(int size) { return SqlTool.subString(getDeptCode(), size); }
    public void setDeptCode(String aDeptCode) { deptCode = aDeptCode; modifiedFields.add("DeptCode"); }
    public void assignDeptCode(String aDeptCode) { deptCode = aDeptCode; }
    public void paramDeptCode(HttpServletRequest request) { paramDeptCode(request, "DeptCode"); }
    public void paramDeptCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeptCode()); if (!tmp.equals(getDeptCode())) { setDeptCode(tmp); } }
    // 用户帐号
    protected String name = "";
    public String getName() {  return SqlTool.getDbString(name);  }
    public String getName(int size) { return SqlTool.subString(getName(), size); }
    public void setName(String aName) { name = aName; modifiedFields.add("Name"); refreshFlag = true; }
    public void assignName(String aName) { name = aName; }
    public void paramName(HttpServletRequest request) { paramName(request, "Name"); }
    public void paramName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getName()); if (!tmp.equals(getName())) { setName(tmp); } }
    // 用户显示名
    protected String cnName = "";
    public String getCnName() {  return SqlTool.getDbString(cnName);  }
    public String getCnName(int size) { return SqlTool.subString(getCnName(), size); }
    public void setCnName(String aCnName) { cnName = aCnName; modifiedFields.add("CnName"); refreshFlag = true; }
    public void assignCnName(String aCnName) { cnName = aCnName; }
    public void paramCnName(HttpServletRequest request) { paramCnName(request, "CnName"); }
    public void paramCnName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCnName()); if (!tmp.equals(getCnName())) { setCnName(tmp); } }
    // 用户编码
    protected String code = "";
    public String getCode() {  return SqlTool.getDbString(code);  }
    public String getCode(int size) { return SqlTool.subString(getCode(), size); }
    public void setCode(String aCode) { code = aCode; modifiedFields.add("Code"); }
    public void assignCode(String aCode) { code = aCode; }
    public void paramCode(HttpServletRequest request) { paramCode(request, "Code"); }
    public void paramCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCode()); if (!tmp.equals(getCode())) { setCode(tmp); } }
    // 性别
    protected int gender = -1;
    public int getGender() { return gender; }
    public void setGender(int aGender) { gender = aGender; modifiedFields.add("Gender"); }
    public void assignGender(int aGender) { gender = aGender; }
    public void paramGender(HttpServletRequest request) { paramGender(request, "Gender"); }
    public void paramGender(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getGender()); if (tmp != getGender()) { setGender(tmp); } }
    // 用户职务
    protected String occupation = "";
    public String getOccupation() {  return SqlTool.getDbString(occupation);  }
    public String getOccupation(int size) { return SqlTool.subString(getOccupation(), size); }
    public void setOccupation(String aOccupation) { occupation = aOccupation; modifiedFields.add("Occupation"); }
    public void assignOccupation(String aOccupation) { occupation = aOccupation; }
    public void paramOccupation(HttpServletRequest request) { paramOccupation(request, "Occupation"); }
    public void paramOccupation(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOccupation()); if (!tmp.equals(getOccupation())) { setOccupation(tmp); } }
    // 用户职称
    protected String grade = "";
    public String getGrade() {  return SqlTool.getDbString(grade);  }
    public String getGrade(int size) { return SqlTool.subString(getGrade(), size); }
    public void setGrade(String aGrade) { grade = aGrade; modifiedFields.add("Grade"); }
    public void assignGrade(String aGrade) { grade = aGrade; }
    public void paramGrade(HttpServletRequest request) { paramGrade(request, "Grade"); }
    public void paramGrade(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGrade()); if (!tmp.equals(getGrade())) { setGrade(tmp); } }
    // 用户所属部门
    protected String dept = "";
    public String getDept() {  return SqlTool.getDbString(dept);  }
    public String getDept(int size) { return SqlTool.subString(getDept(), size); }
    public void setDept(String aDept) { dept = aDept; modifiedFields.add("Dept"); }
    public void assignDept(String aDept) { dept = aDept; }
    public void paramDept(HttpServletRequest request) { paramDept(request, "Dept"); }
    public void paramDept(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDept()); if (!tmp.equals(getDept())) { setDept(tmp); } }
    // 排序
    protected int orderby = -1;
    public int getOrderby() { return orderby; }
    public void setOrderby(int aOrderby) { orderby = aOrderby; modifiedFields.add("Orderby"); }
    public void assignOrderby(int aOrderby) { orderby = aOrderby; }
    public void paramOrderby(HttpServletRequest request) { paramOrderby(request, "Orderby"); }
    public void paramOrderby(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getOrderby()); if (tmp != getOrderby()) { setOrderby(tmp); } }
    // 主管领导
    protected String principal = "";
    public String getPrincipal() {  return SqlTool.getDbString(principal);  }
    public String getPrincipal(int size) { return SqlTool.subString(getPrincipal(), size); }
    public void setPrincipal(String aPrincipal) { principal = aPrincipal; modifiedFields.add("Principal"); }
    public void assignPrincipal(String aPrincipal) { principal = aPrincipal; }
    public void paramPrincipal(HttpServletRequest request) { paramPrincipal(request, "Principal"); }
    public void paramPrincipal(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPrincipal()); if (!tmp.equals(getPrincipal())) { setPrincipal(tmp); } }
    // 办公电话
    protected String phoneNum = "";
    public String getPhoneNum() {  return SqlTool.getDbString(phoneNum);  }
    public String getPhoneNum(int size) { return SqlTool.subString(getPhoneNum(), size); }
    public void setPhoneNum(String aPhoneNum) { phoneNum = aPhoneNum; modifiedFields.add("PhoneNum"); }
    public void assignPhoneNum(String aPhoneNum) { phoneNum = aPhoneNum; }
    public void paramPhoneNum(HttpServletRequest request) { paramPhoneNum(request, "PhoneNum"); }
    public void paramPhoneNum(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPhoneNum()); if (!tmp.equals(getPhoneNum())) { setPhoneNum(tmp); } }
    // 手机号码
    protected String mobilePhone = "";
    public String getMobilePhone() {  return SqlTool.getDbString(mobilePhone);  }
    public String getMobilePhone(int size) { return SqlTool.subString(getMobilePhone(), size); }
    public void setMobilePhone(String aMobilePhone) { mobilePhone = aMobilePhone; modifiedFields.add("MobilePhone"); }
    public void assignMobilePhone(String aMobilePhone) { mobilePhone = aMobilePhone; }
    public void paramMobilePhone(HttpServletRequest request) { paramMobilePhone(request, "MobilePhone"); }
    public void paramMobilePhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMobilePhone()); if (!tmp.equals(getMobilePhone())) { setMobilePhone(tmp); } }
    // 传真号码
    protected String fax = "";
    public String getFax() {  return SqlTool.getDbString(fax);  }
    public String getFax(int size) { return SqlTool.subString(getFax(), size); }
    public void setFax(String aFax) { fax = aFax; modifiedFields.add("Fax"); }
    public void assignFax(String aFax) { fax = aFax; }
    public void paramFax(HttpServletRequest request) { paramFax(request, "Fax"); }
    public void paramFax(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFax()); if (!tmp.equals(getFax())) { setFax(tmp); } }
    // 用户办公室地址
    protected String officeAddress = "";
    public String getOfficeAddress() {  return SqlTool.getDbString(officeAddress);  }
    public String getOfficeAddress(int size) { return SqlTool.subString(getOfficeAddress(), size); }
    public void setOfficeAddress(String aOfficeAddress) { officeAddress = aOfficeAddress; modifiedFields.add("OfficeAddress"); }
    public void assignOfficeAddress(String aOfficeAddress) { officeAddress = aOfficeAddress; }
    public void paramOfficeAddress(HttpServletRequest request) { paramOfficeAddress(request, "OfficeAddress"); }
    public void paramOfficeAddress(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOfficeAddress()); if (!tmp.equals(getOfficeAddress())) { setOfficeAddress(tmp); } }
    // 电子邮箱
    protected String email = "";
    public String getEmail() {  return SqlTool.getDbString(email);  }
    public String getEmail(int size) { return SqlTool.subString(getEmail(), size); }
    public void setEmail(String aEmail) { email = aEmail; modifiedFields.add("Email"); }
    public void assignEmail(String aEmail) { email = aEmail; }
    public void paramEmail(HttpServletRequest request) { paramEmail(request, "Email"); }
    public void paramEmail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getEmail()); if (!tmp.equals(getEmail())) { setEmail(tmp); } }
    // 用户登陆密码
    protected String pwd = "";
    public String getPwd() {  return SqlTool.getDbString(pwd);  }
    public String getPwd(int size) { return SqlTool.subString(getPwd(), size); }
    public void setPwd(String aPwd) { pwd = aPwd; modifiedFields.add("Pwd"); }
    public void assignPwd(String aPwd) { pwd = aPwd; }
    public void paramPwd(HttpServletRequest request) { paramPwd(request, "Pwd"); }
    public void paramPwd(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPwd()); if (!tmp.equals(getPwd())) { setPwd(tmp); } }
    // 家庭地址
    protected String homeAddress = "";
    public String getHomeAddress() {  return SqlTool.getDbString(homeAddress);  }
    public String getHomeAddress(int size) { return SqlTool.subString(getHomeAddress(), size); }
    public void setHomeAddress(String aHomeAddress) { homeAddress = aHomeAddress; modifiedFields.add("HomeAddress"); }
    public void assignHomeAddress(String aHomeAddress) { homeAddress = aHomeAddress; }
    public void paramHomeAddress(HttpServletRequest request) { paramHomeAddress(request, "HomeAddress"); }
    public void paramHomeAddress(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHomeAddress()); if (!tmp.equals(getHomeAddress())) { setHomeAddress(tmp); } }
    // 住址邮编
    protected String homeZipcode = "";
    public String getHomeZipcode() {  return SqlTool.getDbString(homeZipcode);  }
    public String getHomeZipcode(int size) { return SqlTool.subString(getHomeZipcode(), size); }
    public void setHomeZipcode(String aHomeZipcode) { homeZipcode = aHomeZipcode; modifiedFields.add("HomeZipcode"); }
    public void assignHomeZipcode(String aHomeZipcode) { homeZipcode = aHomeZipcode; }
    public void paramHomeZipcode(HttpServletRequest request) { paramHomeZipcode(request, "HomeZipcode"); }
    public void paramHomeZipcode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHomeZipcode()); if (!tmp.equals(getHomeZipcode())) { setHomeZipcode(tmp); } }
    // 单位邮编
    protected String deptZipcode = "";
    public String getDeptZipcode() {  return SqlTool.getDbString(deptZipcode);  }
    public String getDeptZipcode(int size) { return SqlTool.subString(getDeptZipcode(), size); }
    public void setDeptZipcode(String aDeptZipcode) { deptZipcode = aDeptZipcode; modifiedFields.add("DeptZipcode"); }
    public void assignDeptZipcode(String aDeptZipcode) { deptZipcode = aDeptZipcode; }
    public void paramDeptZipcode(HttpServletRequest request) { paramDeptZipcode(request, "DeptZipcode"); }
    public void paramDeptZipcode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeptZipcode()); if (!tmp.equals(getDeptZipcode())) { setDeptZipcode(tmp); } }
    // 用户Ip电话(代办改变否)
    protected String userIpphome = "";
    public String getUserIpphome() {  return SqlTool.getDbString(userIpphome);  }
    public String getUserIpphome(int size) { return SqlTool.subString(getUserIpphome(), size); }
    public void setUserIpphome(String aUserIpphome) { userIpphome = aUserIpphome; modifiedFields.add("UserIpphome"); }
    public void assignUserIpphome(String aUserIpphome) { userIpphome = aUserIpphome; }
    public void paramUserIpphome(HttpServletRequest request) { paramUserIpphome(request, "UserIpphome"); }
    public void paramUserIpphome(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUserIpphome()); if (!tmp.equals(getUserIpphome())) { setUserIpphome(tmp); } }
    // 最后访问时间
    protected java.util.Date lastTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getLastTime() { return lastTime; }
    public void setLastTime(java.util.Date aLastTime) { lastTime = aLastTime; modifiedFields.add("LastTime"); }
    public void assignLastTime(java.util.Date aLastTime) { lastTime = aLastTime; }
    public void paramLastTime(HttpServletRequest request) { paramLastTime(request, "LastTime"); }
    public void paramLastTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getLastTime()); if (tmp.compareTo(getLastTime()) != 0) { setLastTime(tmp); } }
    // 皮肤Id号
    protected String skinId = "";
    public String getSkinId() {  return SqlTool.getDbString(skinId);  }
    public String getSkinId(int size) { return SqlTool.subString(getSkinId(), size); }
    public void setSkinId(String aSkinId) { skinId = aSkinId; modifiedFields.add("SkinId"); }
    public void assignSkinId(String aSkinId) { skinId = aSkinId; }
    public void paramSkinId(HttpServletRequest request) { paramSkinId(request, "SkinId"); }
    public void paramSkinId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSkinId()); if (!tmp.equals(getSkinId())) { setSkinId(tmp); } }
    // 显示的条数
    protected int dispNum = -1;
    public int getDispNum() { return dispNum; }
    public void setDispNum(int aDispNum) { dispNum = aDispNum; modifiedFields.add("DispNum"); }
    public void assignDispNum(int aDispNum) { dispNum = aDispNum; }
    public void paramDispNum(HttpServletRequest request) { paramDispNum(request, "DispNum"); }
    public void paramDispNum(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getDispNum()); if (tmp != getDispNum()) { setDispNum(tmp); } }
    // 按字段排序
    protected String orderbyField = "";
    public String getOrderbyField() {  return SqlTool.getDbString(orderbyField);  }
    public String getOrderbyField(int size) { return SqlTool.subString(getOrderbyField(), size); }
    public void setOrderbyField(String aOrderbyField) { orderbyField = aOrderbyField; modifiedFields.add("OrderbyField"); }
    public void assignOrderbyField(String aOrderbyField) { orderbyField = aOrderbyField; }
    public void paramOrderbyField(HttpServletRequest request) { paramOrderbyField(request, "OrderbyField"); }
    public void paramOrderbyField(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOrderbyField()); if (!tmp.equals(getOrderbyField())) { setOrderbyField(tmp); } }
    // 排序方式
    protected String orderStyle = "";
    public String getOrderStyle() {  return SqlTool.getDbString(orderStyle);  }
    public String getOrderStyle(int size) { return SqlTool.subString(getOrderStyle(), size); }
    public void setOrderStyle(String aOrderStyle) { orderStyle = aOrderStyle; modifiedFields.add("OrderStyle"); }
    public void assignOrderStyle(String aOrderStyle) { orderStyle = aOrderStyle; }
    public void paramOrderStyle(HttpServletRequest request) { paramOrderStyle(request, "OrderStyle"); }
    public void paramOrderStyle(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOrderStyle()); if (!tmp.equals(getOrderStyle())) { setOrderStyle(tmp); } }
    // 用户角色
    protected String roles = "";
    public String getRoles() {  return SqlTool.getDbString(roles);  }
    public String getRoles(int size) { return SqlTool.subString(getRoles(), size); }
    public void setRoles(String aRoles) { roles = aRoles; modifiedFields.add("Roles"); }
    public void assignRoles(String aRoles) { roles = aRoles; }
    public void paramRoles(HttpServletRequest request) { paramRoles(request, "Roles"); }
    public void paramRoles(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRoles()); if (!tmp.equals(getRoles())) { setRoles(tmp); } }
    // 删除标记
    protected int enable = 1;
    public int getEnable() { return enable; }
    public void setEnable(int aEnable) { enable = aEnable; modifiedFields.add("Enable"); }
    public void assignEnable(int aEnable) { enable = aEnable; }
    public void paramEnable(HttpServletRequest request) { paramEnable(request, "Enable"); }
    public void paramEnable(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getEnable()); if (tmp != getEnable()) { setEnable(tmp); } }
    // 是否初次登录
    protected int isFirstLogon = -1;
    public int getIsFirstLogon() { return isFirstLogon; }
    public void setIsFirstLogon(int aIsFirstLogon) { isFirstLogon = aIsFirstLogon; modifiedFields.add("IsFirstLogon"); }
    public void assignIsFirstLogon(int aIsFirstLogon) { isFirstLogon = aIsFirstLogon; }
    public void paramIsFirstLogon(HttpServletRequest request) { paramIsFirstLogon(request, "IsFirstLogon"); }
    public void paramIsFirstLogon(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getIsFirstLogon()); if (tmp != getIsFirstLogon()) { setIsFirstLogon(tmp); } }
    // 操作时间
    protected java.util.Date operTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getOperTime() { return operTime; }
    public void setOperTime(java.util.Date aOperTime) { operTime = aOperTime; modifiedFields.add("OperTime"); }
    public void assignOperTime(java.util.Date aOperTime) { operTime = aOperTime; }
    public void paramOperTime(HttpServletRequest request) { paramOperTime(request, "OperTime"); }
    public void paramOperTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getOperTime()); if (tmp.compareTo(getOperTime()) != 0) { setOperTime(tmp); } }
    // 操作日志
    protected String operLog = "";
    public String getOperLog() {  return SqlTool.getDbString(operLog);  }
    public String getOperLog(int size) { return SqlTool.subString(getOperLog(), size); }
    public void setOperLog(String aOperLog) { operLog = aOperLog; modifiedFields.add("OperLog"); }
    public void assignOperLog(String aOperLog) { operLog = aOperLog; }
    public void paramOperLog(HttpServletRequest request) { paramOperLog(request, "OperLog"); }
    public void paramOperLog(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOperLog()); if (!tmp.equals(getOperLog())) { setOperLog(tmp); } }
    // 操作人
    protected int operUser = -1;
    public int getOperUser() { return operUser; }
    public void setOperUser(int aOperUser) { operUser = aOperUser; modifiedFields.add("OperUser"); }
    public void assignOperUser(int aOperUser) { operUser = aOperUser; }
    public void paramOperUser(HttpServletRequest request) { paramOperUser(request, "OperUser"); }
    public void paramOperUser(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getOperUser()); if (tmp != getOperUser()) { setOperUser(tmp); } }
    // 所在地编码
    protected String locusCode = "";
    public String getLocusCode() {  return SqlTool.getDbString(locusCode);  }
    public String getLocusCode(int size) { return SqlTool.subString(getLocusCode(), size); }
    public void setLocusCode(String aLocusCode) { locusCode = aLocusCode; modifiedFields.add("LocusCode"); }
    public void assignLocusCode(String aLocusCode) { locusCode = aLocusCode; }
    public void paramLocusCode(HttpServletRequest request) { paramLocusCode(request, "LocusCode"); }
    public void paramLocusCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getLocusCode()); if (!tmp.equals(getLocusCode())) { setLocusCode(tmp); } }
    // 登录次数
    protected int logonNum = -1;
    public int getLogonNum() { return logonNum; }
    public void setLogonNum(int aLogonNum) { logonNum = aLogonNum; modifiedFields.add("LogonNum"); }
    public void assignLogonNum(int aLogonNum) { logonNum = aLogonNum; }
    public void paramLogonNum(HttpServletRequest request) { paramLogonNum(request, "LogonNum"); }
    public void paramLogonNum(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getLogonNum()); if (tmp != getLogonNum()) { setLogonNum(tmp); } }
    // 本次Ip
    protected String curIp = "";
    public String getCurIp() {  return SqlTool.getDbString(curIp);  }
    public String getCurIp(int size) { return SqlTool.subString(getCurIp(), size); }
    public void setCurIp(String aCurIp) { curIp = aCurIp; modifiedFields.add("CurIp"); }
    public void assignCurIp(String aCurIp) { curIp = aCurIp; }
    public void paramCurIp(HttpServletRequest request) { paramCurIp(request, "CurIp"); }
    public void paramCurIp(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCurIp()); if (!tmp.equals(getCurIp())) { setCurIp(tmp); } }
    // 本次登录时间
    protected java.util.Date curTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getCurTime() { return curTime; }
    public void setCurTime(java.util.Date aCurTime) { curTime = aCurTime; modifiedFields.add("CurTime"); }
    public void assignCurTime(java.util.Date aCurTime) { curTime = aCurTime; }
    public void paramCurTime(HttpServletRequest request) { paramCurTime(request, "CurTime"); }
    public void paramCurTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getCurTime()); if (tmp.compareTo(getCurTime()) != 0) { setCurTime(tmp); } }
    // 是否可用
    protected int isEnable = -1;
    public int getIsEnable() { return isEnable; }
    public void setIsEnable(int aIsEnable) { isEnable = aIsEnable; modifiedFields.add("IsEnable"); }
    public void assignIsEnable(int aIsEnable) { isEnable = aIsEnable; }
    public void paramIsEnable(HttpServletRequest request) { paramIsEnable(request, "IsEnable"); }
    public void paramIsEnable(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getIsEnable()); if (tmp != getIsEnable()) { setIsEnable(tmp); } }
    // 登录Ip
    protected String ip = "";
    public String getIp() {  return SqlTool.getDbString(ip);  }
    public String getIp(int size) { return SqlTool.subString(getIp(), size); }
    public void setIp(String aIp) { ip = aIp; modifiedFields.add("Ip"); }
    public void assignIp(String aIp) { ip = aIp; }
    public void paramIp(HttpServletRequest request) { paramIp(request, "Ip"); }
    public void paramIp(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIp()); if (!tmp.equals(getIp())) { setIp(tmp); } }
    // 学历
    protected String identity = "";
    public String getIdentity() {  return SqlTool.getDbString(identity);  }
    public String getIdentity(int size) { return SqlTool.subString(getIdentity(), size); }
    public void setIdentity(String aIdentity) { identity = aIdentity; modifiedFields.add("Identity"); }
    public void assignIdentity(String aIdentity) { identity = aIdentity; }
    public void paramIdentity(HttpServletRequest request) { paramIdentity(request, "Identity"); }
    public void paramIdentity(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIdentity()); if (!tmp.equals(getIdentity())) { setIdentity(tmp); } }
    // 政治面貌
    protected String memberPolitics = "";
    public String getMemberPolitics() {  return SqlTool.getDbString(memberPolitics);  }
    public String getMemberPolitics(int size) { return SqlTool.subString(getMemberPolitics(), size); }
    public void setMemberPolitics(String aMemberPolitics) { memberPolitics = aMemberPolitics; modifiedFields.add("MemberPolitics"); }
    public void assignMemberPolitics(String aMemberPolitics) { memberPolitics = aMemberPolitics; }
    public void paramMemberPolitics(HttpServletRequest request) { paramMemberPolitics(request, "MemberPolitics"); }
    public void paramMemberPolitics(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberPolitics()); if (!tmp.equals(getMemberPolitics())) { setMemberPolitics(tmp); } }
    // 入校时间
    protected java.util.Date timeToSchool = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getTimeToSchool() { return timeToSchool; }
    public void setTimeToSchool(java.util.Date aTimeToSchool) { timeToSchool = aTimeToSchool; modifiedFields.add("TimeToSchool"); }
    public void assignTimeToSchool(java.util.Date aTimeToSchool) { timeToSchool = aTimeToSchool; }
    public void paramTimeToSchool(HttpServletRequest request) { paramTimeToSchool(request, "TimeToSchool"); }
    public void paramTimeToSchool(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getTimeToSchool()); if (tmp.compareTo(getTimeToSchool()) != 0) { setTimeToSchool(tmp); } }
    // 入团时间
    protected java.util.Date timeToTuan = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getTimeToTuan() { return timeToTuan; }
    public void setTimeToTuan(java.util.Date aTimeToTuan) { timeToTuan = aTimeToTuan; modifiedFields.add("TimeToTuan"); }
    public void assignTimeToTuan(java.util.Date aTimeToTuan) { timeToTuan = aTimeToTuan; }
    public void paramTimeToTuan(HttpServletRequest request) { paramTimeToTuan(request, "TimeToTuan"); }
    public void paramTimeToTuan(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getTimeToTuan()); if (tmp.compareTo(getTimeToTuan()) != 0) { setTimeToTuan(tmp); } }
    // 生日
    protected java.util.Date birthday = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getBirthday() { return birthday; }
    public void setBirthday(java.util.Date aBirthday) { birthday = aBirthday; modifiedFields.add("Birthday"); }
    public void assignBirthday(java.util.Date aBirthday) { birthday = aBirthday; }
    public void paramBirthday(HttpServletRequest request) { paramBirthday(request, "Birthday"); }
    public void paramBirthday(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getBirthday()); if (tmp.compareTo(getBirthday()) != 0) { setBirthday(tmp); } }
    // 支部
    protected String zhiBu = "";
    public String getZhiBu() {  return SqlTool.getDbString(zhiBu);  }
    public String getZhiBu(int size) { return SqlTool.subString(getZhiBu(), size); }
    public void setZhiBu(String aZhiBu) { zhiBu = aZhiBu; modifiedFields.add("ZhiBu"); }
    public void assignZhiBu(String aZhiBu) { zhiBu = aZhiBu; }
    public void paramZhiBu(HttpServletRequest request) { paramZhiBu(request, "ZhiBu"); }
    public void paramZhiBu(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getZhiBu()); if (!tmp.equals(getZhiBu())) { setZhiBu(tmp); } }
    // 民族
    protected String nation = "";
    public String getNation() {  return SqlTool.getDbString(nation);  }
    public String getNation(int size) { return SqlTool.subString(getNation(), size); }
    public void setNation(String aNation) { nation = aNation; modifiedFields.add("Nation"); }
    public void assignNation(String aNation) { nation = aNation; }
    public void paramNation(HttpServletRequest request) { paramNation(request, "Nation"); }
    public void paramNation(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getNation()); if (!tmp.equals(getNation())) { setNation(tmp); } }
    // 专业
    protected String major = "";
    public String getMajor() {  return SqlTool.getDbString(major);  }
    public String getMajor(int size) { return SqlTool.subString(getMajor(), size); }
    public void setMajor(String aMajor) { major = aMajor; modifiedFields.add("Major"); }
    public void assignMajor(String aMajor) { major = aMajor; }
    public void paramMajor(HttpServletRequest request) { paramMajor(request, "Major"); }
    public void paramMajor(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMajor()); if (!tmp.equals(getMajor())) { setMajor(tmp); } }
    // 学制
    protected String lenOfSchool = "";
    public String getLenOfSchool() {  return SqlTool.getDbString(lenOfSchool);  }
    public String getLenOfSchool(int size) { return SqlTool.subString(getLenOfSchool(), size); }
    public void setLenOfSchool(String aLenOfSchool) { lenOfSchool = aLenOfSchool; modifiedFields.add("LenOfSchool"); }
    public void assignLenOfSchool(String aLenOfSchool) { lenOfSchool = aLenOfSchool; }
    public void paramLenOfSchool(HttpServletRequest request) { paramLenOfSchool(request, "LenOfSchool"); }
    public void paramLenOfSchool(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getLenOfSchool()); if (!tmp.equals(getLenOfSchool())) { setLenOfSchool(tmp); } }
    // 籍贯
    protected String nativePlace = "";
    public String getNativePlace() {  return SqlTool.getDbString(nativePlace);  }
    public String getNativePlace(int size) { return SqlTool.subString(getNativePlace(), size); }
    public void setNativePlace(String aNativePlace) { nativePlace = aNativePlace; modifiedFields.add("NativePlace"); }
    public void assignNativePlace(String aNativePlace) { nativePlace = aNativePlace; }
    public void paramNativePlace(HttpServletRequest request) { paramNativePlace(request, "NativePlace"); }
    public void paramNativePlace(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getNativePlace()); if (!tmp.equals(getNativePlace())) { setNativePlace(tmp); } }
    // 身份证号码
    protected String iDNum = "";
    public String getIDNum() {  return SqlTool.getDbString(iDNum);  }
    public String getIDNum(int size) { return SqlTool.subString(getIDNum(), size); }
    public void setIDNum(String aIDNum) { iDNum = aIDNum; modifiedFields.add("IDNum"); }
    public void assignIDNum(String aIDNum) { iDNum = aIDNum; }
    public void paramIDNum(HttpServletRequest request) { paramIDNum(request, "IDNum"); }
    public void paramIDNum(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIDNum()); if (!tmp.equals(getIDNum())) { setIDNum(tmp); } }
    // 手机
    protected String phone = "";
    public String getPhone() {  return SqlTool.getDbString(phone);  }
    public String getPhone(int size) { return SqlTool.subString(getPhone(), size); }
    public void setPhone(String aPhone) { phone = aPhone; modifiedFields.add("Phone"); }
    public void assignPhone(String aPhone) { phone = aPhone; }
    public void paramPhone(HttpServletRequest request) { paramPhone(request, "Phone"); }
    public void paramPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPhone()); if (!tmp.equals(getPhone())) { setPhone(tmp); } }
    // 邮箱
    protected String email2 = "";
    public String getEmail2() {  return SqlTool.getDbString(email2);  }
    public String getEmail2(int size) { return SqlTool.subString(getEmail2(), size); }
    public void setEmail2(String aEmail2) { email2 = aEmail2; modifiedFields.add("Email2"); }
    public void assignEmail2(String aEmail2) { email2 = aEmail2; }
    public void paramEmail2(HttpServletRequest request) { paramEmail2(request, "Email2"); }
    public void paramEmail2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getEmail2()); if (!tmp.equals(getEmail2())) { setEmail2(tmp); } }
    // 附件
    protected String addfilelist = "";
    public String getAddfilelist() {  return SqlTool.getDbString(addfilelist);  }
    public String getAddfilelist(int size) { return SqlTool.subString(getAddfilelist(), size); }
    public void setAddfilelist(String aAddfilelist) { addfilelist = aAddfilelist; modifiedFields.add("Addfilelist"); }
    public void assignAddfilelist(String aAddfilelist) { addfilelist = aAddfilelist; }
    public void paramAddfilelist(HttpServletRequest request) { paramAddfilelist(request, "Addfilelist"); }
    public void paramAddfilelist(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddfilelist()); if (!tmp.equals(getAddfilelist())) { setAddfilelist(tmp); } }
    // 学年
    protected String yearToSchool = "";
    public String getYearToSchool() {  return SqlTool.getDbString(yearToSchool);  }
    public String getYearToSchool(int size) { return SqlTool.subString(getYearToSchool(), size); }
    public void setYearToSchool(String aYearToSchool) { yearToSchool = aYearToSchool; modifiedFields.add("YearToSchool"); }
    public void assignYearToSchool(String aYearToSchool) { yearToSchool = aYearToSchool; }
    public void paramYearToSchool(HttpServletRequest request) { paramYearToSchool(request, "YearToSchool"); }
    public void paramYearToSchool(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getYearToSchool()); if (!tmp.equals(getYearToSchool())) { setYearToSchool(tmp); } }
    // 毕业时间
    protected java.util.Date graduateTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getGraduateTime() { return graduateTime; }
    public void setGraduateTime(java.util.Date aGraduateTime) { graduateTime = aGraduateTime; modifiedFields.add("GraduateTime"); }
    public void assignGraduateTime(java.util.Date aGraduateTime) { graduateTime = aGraduateTime; }
    public void paramGraduateTime(HttpServletRequest request) { paramGraduateTime(request, "GraduateTime"); }
    public void paramGraduateTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getGraduateTime()); if (tmp.compareTo(getGraduateTime()) != 0) { setGraduateTime(tmp); } }
    // 是否青年志愿者
    protected String volunteerfFag = "";
    public String getVolunteerfFag() {  return SqlTool.getDbString(volunteerfFag);  }
    public String getVolunteerfFag(int size) { return SqlTool.subString(getVolunteerfFag(), size); }
    public void setVolunteerfFag(String aVolunteerfFag) { volunteerfFag = aVolunteerfFag; modifiedFields.add("VolunteerfFag"); }
    public void assignVolunteerfFag(String aVolunteerfFag) { volunteerfFag = aVolunteerfFag; }
    public void paramVolunteerfFag(HttpServletRequest request) { paramVolunteerfFag(request, "VolunteerfFag"); }
    public void paramVolunteerfFag(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVolunteerfFag()); if (!tmp.equals(getVolunteerfFag())) { setVolunteerfFag(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public BaseUserCode (String db) {
        DBNAME = db;
    }
    public BaseUserCode (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public BaseUserCode (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public BaseUserCode () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return BaseUserCode类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public BaseUserCode getByParameter(HttpServletRequest request) {
        BaseUserCode v = new BaseUserCode(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramOrgId(request);
        paramOrgCode(request);
        paramDeptId(request);
        paramDeptCode(request);
        paramName(request);
        paramCnName(request);
        paramCode(request);
        paramGender(request);
        paramOccupation(request);
        paramGrade(request);
        paramDept(request);
        paramOrderby(request);
        paramPrincipal(request);
        paramPhoneNum(request);
        paramMobilePhone(request);
        paramFax(request);
        paramOfficeAddress(request);
        paramEmail(request);
        paramPwd(request);
        paramHomeAddress(request);
        paramHomeZipcode(request);
        paramDeptZipcode(request);
        paramUserIpphome(request);
        paramLastTime(request);
        paramSkinId(request);
        paramDispNum(request);
        paramOrderbyField(request);
        paramOrderStyle(request);
        paramRoles(request);
        paramEnable(request);
        paramIsFirstLogon(request);
        paramOperTime(request);
        paramOperLog(request);
        paramOperUser(request);
        paramLocusCode(request);
        paramLogonNum(request);
        paramCurIp(request);
        paramCurTime(request);
        paramIsEnable(request);
        paramIp(request);
        paramIdentity(request);
        paramMemberPolitics(request);
        paramTimeToSchool(request);
        paramTimeToTuan(request);
        paramBirthday(request);
        paramZhiBu(request);
        paramNation(request);
        paramMajor(request);
        paramLenOfSchool(request);
        paramNativePlace(request);
        paramIDNum(request);
        paramPhone(request);
        paramEmail2(request);
        paramAddfilelist(request);
        paramYearToSchool(request);
        paramGraduateTime(request);
        paramVolunteerfFag(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(BaseUserCode bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("orgId")) { setOrgId(bean.getOrgId()); }
        if (!ncl.contains("orgCode")) { setOrgCode(bean.getOrgCode()); }
        if (!ncl.contains("deptId")) { setDeptId(bean.getDeptId()); }
        if (!ncl.contains("deptCode")) { setDeptCode(bean.getDeptCode()); }
        if (!ncl.contains("name")) { setName(bean.getName()); }
        if (!ncl.contains("cnName")) { setCnName(bean.getCnName()); }
        if (!ncl.contains("code")) { setCode(bean.getCode()); }
        if (!ncl.contains("gender")) { setGender(bean.getGender()); }
        if (!ncl.contains("occupation")) { setOccupation(bean.getOccupation()); }
        if (!ncl.contains("grade")) { setGrade(bean.getGrade()); }
        if (!ncl.contains("dept")) { setDept(bean.getDept()); }
        if (!ncl.contains("orderby")) { setOrderby(bean.getOrderby()); }
        if (!ncl.contains("principal")) { setPrincipal(bean.getPrincipal()); }
        if (!ncl.contains("phoneNum")) { setPhoneNum(bean.getPhoneNum()); }
        if (!ncl.contains("mobilePhone")) { setMobilePhone(bean.getMobilePhone()); }
        if (!ncl.contains("fax")) { setFax(bean.getFax()); }
        if (!ncl.contains("officeAddress")) { setOfficeAddress(bean.getOfficeAddress()); }
        if (!ncl.contains("email")) { setEmail(bean.getEmail()); }
        if (!ncl.contains("pwd")) { setPwd(bean.getPwd()); }
        if (!ncl.contains("homeAddress")) { setHomeAddress(bean.getHomeAddress()); }
        if (!ncl.contains("homeZipcode")) { setHomeZipcode(bean.getHomeZipcode()); }
        if (!ncl.contains("deptZipcode")) { setDeptZipcode(bean.getDeptZipcode()); }
        if (!ncl.contains("userIpphome")) { setUserIpphome(bean.getUserIpphome()); }
        if (!ncl.contains("lastTime")) { setLastTime(bean.getLastTime()); }
        if (!ncl.contains("skinId")) { setSkinId(bean.getSkinId()); }
        if (!ncl.contains("dispNum")) { setDispNum(bean.getDispNum()); }
        if (!ncl.contains("orderbyField")) { setOrderbyField(bean.getOrderbyField()); }
        if (!ncl.contains("orderStyle")) { setOrderStyle(bean.getOrderStyle()); }
        if (!ncl.contains("roles")) { setRoles(bean.getRoles()); }
        if (!ncl.contains("enable")) { setEnable(bean.getEnable()); }
        if (!ncl.contains("isFirstLogon")) { setIsFirstLogon(bean.getIsFirstLogon()); }
        if (!ncl.contains("operTime")) { setOperTime(bean.getOperTime()); }
        if (!ncl.contains("operLog")) { setOperLog(bean.getOperLog()); }
        if (!ncl.contains("operUser")) { setOperUser(bean.getOperUser()); }
        if (!ncl.contains("locusCode")) { setLocusCode(bean.getLocusCode()); }
        if (!ncl.contains("logonNum")) { setLogonNum(bean.getLogonNum()); }
        if (!ncl.contains("curIp")) { setCurIp(bean.getCurIp()); }
        if (!ncl.contains("curTime")) { setCurTime(bean.getCurTime()); }
        if (!ncl.contains("isEnable")) { setIsEnable(bean.getIsEnable()); }
        if (!ncl.contains("ip")) { setIp(bean.getIp()); }
        if (!ncl.contains("identity")) { setIdentity(bean.getIdentity()); }
        if (!ncl.contains("memberPolitics")) { setMemberPolitics(bean.getMemberPolitics()); }
        if (!ncl.contains("timeToSchool")) { setTimeToSchool(bean.getTimeToSchool()); }
        if (!ncl.contains("timeToTuan")) { setTimeToTuan(bean.getTimeToTuan()); }
        if (!ncl.contains("birthday")) { setBirthday(bean.getBirthday()); }
        if (!ncl.contains("zhiBu")) { setZhiBu(bean.getZhiBu()); }
        if (!ncl.contains("nation")) { setNation(bean.getNation()); }
        if (!ncl.contains("major")) { setMajor(bean.getMajor()); }
        if (!ncl.contains("lenOfSchool")) { setLenOfSchool(bean.getLenOfSchool()); }
        if (!ncl.contains("nativePlace")) { setNativePlace(bean.getNativePlace()); }
        if (!ncl.contains("iDNum")) { setIDNum(bean.getIDNum()); }
        if (!ncl.contains("phone")) { setPhone(bean.getPhone()); }
        if (!ncl.contains("email2")) { setEmail2(bean.getEmail2()); }
        if (!ncl.contains("addfilelist")) { setAddfilelist(bean.getAddfilelist()); }
        if (!ncl.contains("yearToSchool")) { setYearToSchool(bean.getYearToSchool()); }
        if (!ncl.contains("graduateTime")) { setGraduateTime(bean.getGraduateTime()); }
        if (!ncl.contains("volunteerfFag")) { setVolunteerfFag(bean.getVolunteerfFag()); }
    }
    public BaseUserCode getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        BaseUserCode[] rslt= queryByCondition(cdt);
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
     * @return BaseUserCode类的实例列表。
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
                BaseUserCode ve = new BaseUserCode(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignOrgId(rs.getInt(2));
                ve.assignOrgCode(fromDbCh(rs.getString(3)));
                ve.assignDeptId(rs.getInt(4));
                ve.assignDeptCode(fromDbCh(rs.getString(5)));
                ve.assignName(fromDbCh(rs.getString(6)));
                ve.assignCnName(fromDbCh(rs.getString(7)));
                ve.assignCode(fromDbCh(rs.getString(8)));
                ve.assignGender(rs.getInt(9));
                ve.assignOccupation(fromDbCh(rs.getString(10)));
                ve.assignGrade(fromDbCh(rs.getString(11)));
                ve.assignDept(fromDbCh(rs.getString(12)));
                ve.assignOrderby(rs.getInt(13));
                ve.assignPrincipal(fromDbCh(rs.getString(14)));
                ve.assignPhoneNum(fromDbCh(rs.getString(15)));
                ve.assignMobilePhone(fromDbCh(rs.getString(16)));
                ve.assignFax(fromDbCh(rs.getString(17)));
                ve.assignOfficeAddress(fromDbCh(rs.getString(18)));
                ve.assignEmail(fromDbCh(rs.getString(19)));
                ve.assignPwd(fromDbCh(rs.getString(20)));
                ve.assignHomeAddress(fromDbCh(rs.getString(21)));
                ve.assignHomeZipcode(fromDbCh(rs.getString(22)));
                ve.assignDeptZipcode(fromDbCh(rs.getString(23)));
                ve.assignUserIpphome(fromDbCh(rs.getString(24)));
                tmpDate = rs.getTimestamp(25); if (tmpDate != null) { ve.assignLastTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignSkinId(fromDbCh(rs.getString(26)));
                ve.assignDispNum(rs.getInt(27));
                ve.assignOrderbyField(fromDbCh(rs.getString(28)));
                ve.assignOrderStyle(fromDbCh(rs.getString(29)));
                ve.assignRoles(fromDbCh(rs.getString(30)));
                ve.assignEnable(rs.getInt(31));
                ve.assignIsFirstLogon(rs.getInt(32));
                tmpDate = rs.getTimestamp(33); if (tmpDate != null) { ve.assignOperTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignOperLog(fromDbCh(rs.getString(34)));
                ve.assignOperUser(rs.getInt(35));
                ve.assignLocusCode(fromDbCh(rs.getString(36)));
                ve.assignLogonNum(rs.getInt(37));
                ve.assignCurIp(fromDbCh(rs.getString(38)));
                tmpDate = rs.getTimestamp(39); if (tmpDate != null) { ve.assignCurTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignIsEnable(rs.getInt(40));
                ve.assignIp(fromDbCh(rs.getString(41)));
                ve.assignIdentity(fromDbCh(rs.getString(42)));
                ve.assignMemberPolitics(fromDbCh(rs.getString(43)));
                tmpDate = rs.getTimestamp(44); if (tmpDate != null) { ve.assignTimeToSchool(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(45); if (tmpDate != null) { ve.assignTimeToTuan(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(46); if (tmpDate != null) { ve.assignBirthday(new java.util.Date(tmpDate.getTime())); }
                ve.assignZhiBu(fromDbCh(rs.getString(47)));
                ve.assignNation(fromDbCh(rs.getString(48)));
                ve.assignMajor(fromDbCh(rs.getString(49)));
                ve.assignLenOfSchool(fromDbCh(rs.getString(50)));
                ve.assignNativePlace(fromDbCh(rs.getString(51)));
                ve.assignIDNum(fromDbCh(rs.getString(52)));
                ve.assignPhone(fromDbCh(rs.getString(53)));
                ve.assignEmail2(fromDbCh(rs.getString(54)));
                ve.assignAddfilelist(fromDbCh(rs.getString(55)));
                ve.assignYearToSchool(fromDbCh(rs.getString(56)));
                tmpDate = rs.getTimestamp(57); if (tmpDate != null) { ve.assignGraduateTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignVolunteerfFag(fromDbCh(rs.getString(58)));
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
    public BaseUserCode[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (BaseUserCode[])vrs.toArray(new BaseUserCode[vrs.size()]);
    }
    public BaseUserCode[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (BaseUserCode[])vrs.toArray(new BaseUserCode[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (orgid,orgcode,deptid,deptcode,name,cnname,code,gender,occupation,grade,dept,orderby,principal,phonenum,mobilephone,fax,officeaddress,email,pwd,homeaddress,homezipcode,deptzipcode,useripphome,lasttime,skinid,dispnum,orderbyfield,orderstyle,roles,enable,isfirstlogon,opertime,operlog,operuser,locuscode,logonnum,curip,curtime,isenable,ip,identity,memberpolitics,timetoschool,timetotuan,birthday,zhibu,nation,major,lenofschool,nativeplace,idnum,phone,email2,addfilelist,yeartoschool,graduatetime,volunteerffag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, orgId);
            pstmt.setString(2, toDbCh(orgCode));
            pstmt.setInt(3, deptId);
            pstmt.setString(4, toDbCh(deptCode));
            pstmt.setString(5, toDbCh(name));
            pstmt.setString(6, toDbCh(cnName));
            pstmt.setString(7, toDbCh(code));
            pstmt.setInt(8, gender);
            pstmt.setString(9, toDbCh(occupation));
            pstmt.setString(10, toDbCh(grade));
            pstmt.setString(11, toDbCh(dept));
            pstmt.setInt(12, orderby);
            pstmt.setString(13, toDbCh(principal));
            pstmt.setString(14, toDbCh(phoneNum));
            pstmt.setString(15, toDbCh(mobilePhone));
            pstmt.setString(16, toDbCh(fax));
            pstmt.setString(17, toDbCh(officeAddress));
            pstmt.setString(18, toDbCh(email));
            pstmt.setString(19, toDbCh(pwd));
            pstmt.setString(20, toDbCh(homeAddress));
            pstmt.setString(21, toDbCh(homeZipcode));
            pstmt.setString(22, toDbCh(deptZipcode));
            pstmt.setString(23, toDbCh(userIpphome));
            pstmt.setTimestamp(24, new java.sql.Timestamp(lastTime.getTime()));
            pstmt.setString(25, toDbCh(skinId));
            pstmt.setInt(26, dispNum);
            pstmt.setString(27, toDbCh(orderbyField));
            pstmt.setString(28, toDbCh(orderStyle));
            pstmt.setString(29, toDbCh(roles));
            pstmt.setInt(30, enable);
            pstmt.setInt(31, isFirstLogon);
            pstmt.setTimestamp(32, new java.sql.Timestamp(operTime.getTime()));
            pstmt.setString(33, toDbCh(operLog));
            pstmt.setInt(34, operUser);
            pstmt.setString(35, toDbCh(locusCode));
            pstmt.setInt(36, logonNum);
            pstmt.setString(37, toDbCh(curIp));
            pstmt.setTimestamp(38, new java.sql.Timestamp(curTime.getTime()));
            pstmt.setInt(39, isEnable);
            pstmt.setString(40, toDbCh(ip));
            pstmt.setString(41, toDbCh(identity));
            pstmt.setString(42, toDbCh(memberPolitics));
            pstmt.setTimestamp(43, new java.sql.Timestamp(timeToSchool.getTime()));
            pstmt.setTimestamp(44, new java.sql.Timestamp(timeToTuan.getTime()));
            pstmt.setTimestamp(45, new java.sql.Timestamp(birthday.getTime()));
            pstmt.setString(46, toDbCh(zhiBu));
            pstmt.setString(47, toDbCh(nation));
            pstmt.setString(48, toDbCh(major));
            pstmt.setString(49, toDbCh(lenOfSchool));
            pstmt.setString(50, toDbCh(nativePlace));
            pstmt.setString(51, toDbCh(iDNum));
            pstmt.setString(52, toDbCh(phone));
            pstmt.setString(53, toDbCh(email2));
            pstmt.setString(54, toDbCh(addfilelist));
            pstmt.setString(55, toDbCh(yearToSchool));
            pstmt.setTimestamp(56, new java.sql.Timestamp(graduateTime.getTime()));
            pstmt.setString(57, toDbCh(volunteerfFag));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseUserCode");
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,orgid,orgcode,deptid,deptcode,name,cnname,code,gender,occupation,grade,dept,orderby,principal,phonenum,mobilephone,fax,officeaddress,email,pwd,homeaddress,homezipcode,deptzipcode,useripphome,lasttime,skinid,dispnum,orderbyfield,orderstyle,roles,enable,isfirstlogon,opertime,operlog,operuser,locuscode,logonnum,curip,curtime,isenable,ip,identity,memberpolitics,timetoschool,timetotuan,birthday,zhibu,nation,major,lenofschool,nativeplace,idnum,phone,email2,addfilelist,yeartoschool,graduatetime,volunteerffag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, orgId);
            pstmt.setString(3, toDbCh(orgCode));
            pstmt.setInt(4, deptId);
            pstmt.setString(5, toDbCh(deptCode));
            pstmt.setString(6, toDbCh(name));
            pstmt.setString(7, toDbCh(cnName));
            pstmt.setString(8, toDbCh(code));
            pstmt.setInt(9, gender);
            pstmt.setString(10, toDbCh(occupation));
            pstmt.setString(11, toDbCh(grade));
            pstmt.setString(12, toDbCh(dept));
            pstmt.setInt(13, orderby);
            pstmt.setString(14, toDbCh(principal));
            pstmt.setString(15, toDbCh(phoneNum));
            pstmt.setString(16, toDbCh(mobilePhone));
            pstmt.setString(17, toDbCh(fax));
            pstmt.setString(18, toDbCh(officeAddress));
            pstmt.setString(19, toDbCh(email));
            pstmt.setString(20, toDbCh(pwd));
            pstmt.setString(21, toDbCh(homeAddress));
            pstmt.setString(22, toDbCh(homeZipcode));
            pstmt.setString(23, toDbCh(deptZipcode));
            pstmt.setString(24, toDbCh(userIpphome));
            pstmt.setTimestamp(25, new java.sql.Timestamp(lastTime.getTime()));
            pstmt.setString(26, toDbCh(skinId));
            pstmt.setInt(27, dispNum);
            pstmt.setString(28, toDbCh(orderbyField));
            pstmt.setString(29, toDbCh(orderStyle));
            pstmt.setString(30, toDbCh(roles));
            pstmt.setInt(31, enable);
            pstmt.setInt(32, isFirstLogon);
            pstmt.setTimestamp(33, new java.sql.Timestamp(operTime.getTime()));
            pstmt.setString(34, toDbCh(operLog));
            pstmt.setInt(35, operUser);
            pstmt.setString(36, toDbCh(locusCode));
            pstmt.setInt(37, logonNum);
            pstmt.setString(38, toDbCh(curIp));
            pstmt.setTimestamp(39, new java.sql.Timestamp(curTime.getTime()));
            pstmt.setInt(40, isEnable);
            pstmt.setString(41, toDbCh(ip));
            pstmt.setString(42, toDbCh(identity));
            pstmt.setString(43, toDbCh(memberPolitics));
            pstmt.setTimestamp(44, new java.sql.Timestamp(timeToSchool.getTime()));
            pstmt.setTimestamp(45, new java.sql.Timestamp(timeToTuan.getTime()));
            pstmt.setTimestamp(46, new java.sql.Timestamp(birthday.getTime()));
            pstmt.setString(47, toDbCh(zhiBu));
            pstmt.setString(48, toDbCh(nation));
            pstmt.setString(49, toDbCh(major));
            pstmt.setString(50, toDbCh(lenOfSchool));
            pstmt.setString(51, toDbCh(nativePlace));
            pstmt.setString(52, toDbCh(iDNum));
            pstmt.setString(53, toDbCh(phone));
            pstmt.setString(54, toDbCh(email2));
            pstmt.setString(55, toDbCh(addfilelist));
            pstmt.setString(56, toDbCh(yearToSchool));
            pstmt.setTimestamp(57, new java.sql.Timestamp(graduateTime.getTime()));
            pstmt.setString(58, toDbCh(volunteerfFag));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseUserCode");
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
            BaseUserCode item = (BaseUserCode)it.next();
            BaseUserCode v = new BaseUserCode(dbname);
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
                if (modifiedFields.contains("OrgId")) { pstmt.setInt(pi ++, orgId); }
                if (modifiedFields.contains("OrgCode")) { pstmt.setString(pi ++, toDbCh(orgCode)); }
                if (modifiedFields.contains("DeptId")) { pstmt.setInt(pi ++, deptId); }
                if (modifiedFields.contains("DeptCode")) { pstmt.setString(pi ++, toDbCh(deptCode)); }
                if (modifiedFields.contains("Name")) { pstmt.setString(pi ++, toDbCh(name)); }
                if (modifiedFields.contains("CnName")) { pstmt.setString(pi ++, toDbCh(cnName)); }
                if (modifiedFields.contains("Code")) { pstmt.setString(pi ++, toDbCh(code)); }
                if (modifiedFields.contains("Gender")) { pstmt.setInt(pi ++, gender); }
                if (modifiedFields.contains("Occupation")) { pstmt.setString(pi ++, toDbCh(occupation)); }
                if (modifiedFields.contains("Grade")) { pstmt.setString(pi ++, toDbCh(grade)); }
                if (modifiedFields.contains("Dept")) { pstmt.setString(pi ++, toDbCh(dept)); }
                if (modifiedFields.contains("Orderby")) { pstmt.setInt(pi ++, orderby); }
                if (modifiedFields.contains("Principal")) { pstmt.setString(pi ++, toDbCh(principal)); }
                if (modifiedFields.contains("PhoneNum")) { pstmt.setString(pi ++, toDbCh(phoneNum)); }
                if (modifiedFields.contains("MobilePhone")) { pstmt.setString(pi ++, toDbCh(mobilePhone)); }
                if (modifiedFields.contains("Fax")) { pstmt.setString(pi ++, toDbCh(fax)); }
                if (modifiedFields.contains("OfficeAddress")) { pstmt.setString(pi ++, toDbCh(officeAddress)); }
                if (modifiedFields.contains("Email")) { pstmt.setString(pi ++, toDbCh(email)); }
                if (modifiedFields.contains("Pwd")) { pstmt.setString(pi ++, toDbCh(pwd)); }
                if (modifiedFields.contains("HomeAddress")) { pstmt.setString(pi ++, toDbCh(homeAddress)); }
                if (modifiedFields.contains("HomeZipcode")) { pstmt.setString(pi ++, toDbCh(homeZipcode)); }
                if (modifiedFields.contains("DeptZipcode")) { pstmt.setString(pi ++, toDbCh(deptZipcode)); }
                if (modifiedFields.contains("UserIpphome")) { pstmt.setString(pi ++, toDbCh(userIpphome)); }
                if (modifiedFields.contains("LastTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(lastTime.getTime())); }
                if (modifiedFields.contains("SkinId")) { pstmt.setString(pi ++, toDbCh(skinId)); }
                if (modifiedFields.contains("DispNum")) { pstmt.setInt(pi ++, dispNum); }
                if (modifiedFields.contains("OrderbyField")) { pstmt.setString(pi ++, toDbCh(orderbyField)); }
                if (modifiedFields.contains("OrderStyle")) { pstmt.setString(pi ++, toDbCh(orderStyle)); }
                if (modifiedFields.contains("Roles")) { pstmt.setString(pi ++, toDbCh(roles)); }
                if (modifiedFields.contains("Enable")) { pstmt.setInt(pi ++, enable); }
                if (modifiedFields.contains("IsFirstLogon")) { pstmt.setInt(pi ++, isFirstLogon); }
                if (modifiedFields.contains("OperTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(operTime.getTime())); }
                if (modifiedFields.contains("OperLog")) { pstmt.setString(pi ++, toDbCh(operLog)); }
                if (modifiedFields.contains("OperUser")) { pstmt.setInt(pi ++, operUser); }
                if (modifiedFields.contains("LocusCode")) { pstmt.setString(pi ++, toDbCh(locusCode)); }
                if (modifiedFields.contains("LogonNum")) { pstmt.setInt(pi ++, logonNum); }
                if (modifiedFields.contains("CurIp")) { pstmt.setString(pi ++, toDbCh(curIp)); }
                if (modifiedFields.contains("CurTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(curTime.getTime())); }
                if (modifiedFields.contains("IsEnable")) { pstmt.setInt(pi ++, isEnable); }
                if (modifiedFields.contains("Ip")) { pstmt.setString(pi ++, toDbCh(ip)); }
                if (modifiedFields.contains("Identity")) { pstmt.setString(pi ++, toDbCh(identity)); }
                if (modifiedFields.contains("MemberPolitics")) { pstmt.setString(pi ++, toDbCh(memberPolitics)); }
                if (modifiedFields.contains("TimeToSchool")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(timeToSchool.getTime())); }
                if (modifiedFields.contains("TimeToTuan")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(timeToTuan.getTime())); }
                if (modifiedFields.contains("Birthday")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(birthday.getTime())); }
                if (modifiedFields.contains("ZhiBu")) { pstmt.setString(pi ++, toDbCh(zhiBu)); }
                if (modifiedFields.contains("Nation")) { pstmt.setString(pi ++, toDbCh(nation)); }
                if (modifiedFields.contains("Major")) { pstmt.setString(pi ++, toDbCh(major)); }
                if (modifiedFields.contains("LenOfSchool")) { pstmt.setString(pi ++, toDbCh(lenOfSchool)); }
                if (modifiedFields.contains("NativePlace")) { pstmt.setString(pi ++, toDbCh(nativePlace)); }
                if (modifiedFields.contains("IDNum")) { pstmt.setString(pi ++, toDbCh(iDNum)); }
                if (modifiedFields.contains("Phone")) { pstmt.setString(pi ++, toDbCh(phone)); }
                if (modifiedFields.contains("Email2")) { pstmt.setString(pi ++, toDbCh(email2)); }
                if (modifiedFields.contains("Addfilelist")) { pstmt.setString(pi ++, toDbCh(addfilelist)); }
                if (modifiedFields.contains("YearToSchool")) { pstmt.setString(pi ++, toDbCh(yearToSchool)); }
                if (modifiedFields.contains("GraduateTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(graduateTime.getTime())); }
                if (modifiedFields.contains("VolunteerfFag")) { pstmt.setString(pi ++, toDbCh(volunteerfFag)); }
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
        if (refreshFlag) {
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseUserCode");
        }
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
                if (modifiedFields.contains("OrgId")) { pstmt.setInt(pi ++, orgId); }
                if (modifiedFields.contains("OrgCode")) { pstmt.setString(pi ++, toDbCh(orgCode)); }
                if (modifiedFields.contains("DeptId")) { pstmt.setInt(pi ++, deptId); }
                if (modifiedFields.contains("DeptCode")) { pstmt.setString(pi ++, toDbCh(deptCode)); }
                if (modifiedFields.contains("Name")) { pstmt.setString(pi ++, toDbCh(name)); }
                if (modifiedFields.contains("CnName")) { pstmt.setString(pi ++, toDbCh(cnName)); }
                if (modifiedFields.contains("Code")) { pstmt.setString(pi ++, toDbCh(code)); }
                if (modifiedFields.contains("Gender")) { pstmt.setInt(pi ++, gender); }
                if (modifiedFields.contains("Occupation")) { pstmt.setString(pi ++, toDbCh(occupation)); }
                if (modifiedFields.contains("Grade")) { pstmt.setString(pi ++, toDbCh(grade)); }
                if (modifiedFields.contains("Dept")) { pstmt.setString(pi ++, toDbCh(dept)); }
                if (modifiedFields.contains("Orderby")) { pstmt.setInt(pi ++, orderby); }
                if (modifiedFields.contains("Principal")) { pstmt.setString(pi ++, toDbCh(principal)); }
                if (modifiedFields.contains("PhoneNum")) { pstmt.setString(pi ++, toDbCh(phoneNum)); }
                if (modifiedFields.contains("MobilePhone")) { pstmt.setString(pi ++, toDbCh(mobilePhone)); }
                if (modifiedFields.contains("Fax")) { pstmt.setString(pi ++, toDbCh(fax)); }
                if (modifiedFields.contains("OfficeAddress")) { pstmt.setString(pi ++, toDbCh(officeAddress)); }
                if (modifiedFields.contains("Email")) { pstmt.setString(pi ++, toDbCh(email)); }
                if (modifiedFields.contains("Pwd")) { pstmt.setString(pi ++, toDbCh(pwd)); }
                if (modifiedFields.contains("HomeAddress")) { pstmt.setString(pi ++, toDbCh(homeAddress)); }
                if (modifiedFields.contains("HomeZipcode")) { pstmt.setString(pi ++, toDbCh(homeZipcode)); }
                if (modifiedFields.contains("DeptZipcode")) { pstmt.setString(pi ++, toDbCh(deptZipcode)); }
                if (modifiedFields.contains("UserIpphome")) { pstmt.setString(pi ++, toDbCh(userIpphome)); }
                if (modifiedFields.contains("LastTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(lastTime.getTime())); }
                if (modifiedFields.contains("SkinId")) { pstmt.setString(pi ++, toDbCh(skinId)); }
                if (modifiedFields.contains("DispNum")) { pstmt.setInt(pi ++, dispNum); }
                if (modifiedFields.contains("OrderbyField")) { pstmt.setString(pi ++, toDbCh(orderbyField)); }
                if (modifiedFields.contains("OrderStyle")) { pstmt.setString(pi ++, toDbCh(orderStyle)); }
                if (modifiedFields.contains("Roles")) { pstmt.setString(pi ++, toDbCh(roles)); }
                if (modifiedFields.contains("Enable")) { pstmt.setInt(pi ++, enable); }
                if (modifiedFields.contains("IsFirstLogon")) { pstmt.setInt(pi ++, isFirstLogon); }
                if (modifiedFields.contains("OperTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(operTime.getTime())); }
                if (modifiedFields.contains("OperLog")) { pstmt.setString(pi ++, toDbCh(operLog)); }
                if (modifiedFields.contains("OperUser")) { pstmt.setInt(pi ++, operUser); }
                if (modifiedFields.contains("LocusCode")) { pstmt.setString(pi ++, toDbCh(locusCode)); }
                if (modifiedFields.contains("LogonNum")) { pstmt.setInt(pi ++, logonNum); }
                if (modifiedFields.contains("CurIp")) { pstmt.setString(pi ++, toDbCh(curIp)); }
                if (modifiedFields.contains("CurTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(curTime.getTime())); }
                if (modifiedFields.contains("IsEnable")) { pstmt.setInt(pi ++, isEnable); }
                if (modifiedFields.contains("Ip")) { pstmt.setString(pi ++, toDbCh(ip)); }
                if (modifiedFields.contains("Identity")) { pstmt.setString(pi ++, toDbCh(identity)); }
                if (modifiedFields.contains("MemberPolitics")) { pstmt.setString(pi ++, toDbCh(memberPolitics)); }
                if (modifiedFields.contains("TimeToSchool")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(timeToSchool.getTime())); }
                if (modifiedFields.contains("TimeToTuan")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(timeToTuan.getTime())); }
                if (modifiedFields.contains("Birthday")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(birthday.getTime())); }
                if (modifiedFields.contains("ZhiBu")) { pstmt.setString(pi ++, toDbCh(zhiBu)); }
                if (modifiedFields.contains("Nation")) { pstmt.setString(pi ++, toDbCh(nation)); }
                if (modifiedFields.contains("Major")) { pstmt.setString(pi ++, toDbCh(major)); }
                if (modifiedFields.contains("LenOfSchool")) { pstmt.setString(pi ++, toDbCh(lenOfSchool)); }
                if (modifiedFields.contains("NativePlace")) { pstmt.setString(pi ++, toDbCh(nativePlace)); }
                if (modifiedFields.contains("IDNum")) { pstmt.setString(pi ++, toDbCh(iDNum)); }
                if (modifiedFields.contains("Phone")) { pstmt.setString(pi ++, toDbCh(phone)); }
                if (modifiedFields.contains("Email2")) { pstmt.setString(pi ++, toDbCh(email2)); }
                if (modifiedFields.contains("Addfilelist")) { pstmt.setString(pi ++, toDbCh(addfilelist)); }
                if (modifiedFields.contains("YearToSchool")) { pstmt.setString(pi ++, toDbCh(yearToSchool)); }
                if (modifiedFields.contains("GraduateTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(graduateTime.getTime())); }
                if (modifiedFields.contains("VolunteerfFag")) { pstmt.setString(pi ++, toDbCh(volunteerfFag)); }
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
        if (refreshFlag) {
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseUserCode");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseUserCode");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseUserCode");
        return iResult;
    }
    public TreeItem cloneTi(BaseUserCode item) {
        TreeItem ti = new TreeItem();
        ti.setId(item.getId());
        ti.setCode(item.getCode());
        ti.setName(item.getName());
        ti.setOrders(item.getCode());
        return ti;
    }
    public String findRootKey(Map parent) {
        List allids = new ArrayList();
        for (Iterator mit = parent.keySet().iterator(); mit.hasNext();) {
            String key = (String)mit.next();
            List list = (List)parent.get(key);
            for (Iterator it = list.iterator(); it.hasNext();) {
                BaseUserCode v = (BaseUserCode)it.next();
                allids.add("" + v.getId());
            }
        }
        for (Iterator mit = parent.keySet().iterator(); mit.hasNext();) {
            String key = (String)mit.next();
            if (!allids.contains(key)) {
                return key;
            }
        }
        return "";
    }
    public TreeItem initTree(BaseUserCode item, Map parent) {
        TreeItem ti = cloneTi(item);
        List list = (List)parent.get("" + item.getId());
        if (list != null) {
            for (Iterator it = list.iterator(); it.hasNext(); ) {
                BaseUserCode v = (BaseUserCode)it.next();
                TreeItem nti = cloneTi(v);
                nti.setPid(ti.getId());
                nti.setPcode(ti.getCode());
                TreeItem sti = initTree(v, parent);
                sti.setPid(ti.getId());
                sti.setPcode(ti.getCode());
                if (sti.equals(nti)) {
                    ti.put(sti.getId(), sti);
                }
                else {
                    sti.put(nti.getId(), nti);
                }
            }
        }
        return ti;
    }
    public Map initParentMap(List cdt) {
        List vs = query(cdt);
        Map code2idmap = new HashMap();
        for (Iterator it = vs.iterator(); it.hasNext(); ) {
            BaseUserCode v = (BaseUserCode)it.next();
            code2idmap.put(v.getCode(), "" + v.getId());
        }
        CodeUtils codeutils = new CodeUtils(HeadConst.splitType);
        Map map = new HashMap();
        for (Iterator it = vs.iterator(); it.hasNext(); ) {
            BaseUserCode v = (BaseUserCode)it.next();
            String pid = (String)code2idmap.get(codeutils.getPcode(v.getCode()));
            if (pid == null) {
                pid = "0";
            }
            List child = (List)map.get(pid);
            if (child == null) {
                child = new ArrayList();
            }
            child.add(v);
            map.put(pid, child);
        }
        return map;
    }
    public Map toMap() {
        Map map = new HashMap();
        map.put("Id", getId() + "");
        map.put("OrgId", getOrgId() + "");
        map.put("OrgCode", getOrgCode());
        map.put("DeptId", getDeptId() + "");
        map.put("DeptCode", getDeptCode());
        map.put("Name", getName());
        map.put("CnName", getCnName());
        map.put("Code", getCode());
        map.put("Gender", getGender() + "");
        map.put("Occupation", getOccupation());
        map.put("Grade", getGrade());
        map.put("Dept", getDept());
        map.put("Orderby", getOrderby() + "");
        map.put("Principal", getPrincipal());
        map.put("PhoneNum", getPhoneNum());
        map.put("MobilePhone", getMobilePhone());
        map.put("Fax", getFax());
        map.put("OfficeAddress", getOfficeAddress());
        map.put("Email", getEmail());
        map.put("Pwd", getPwd());
        map.put("HomeAddress", getHomeAddress());
        map.put("HomeZipcode", getHomeZipcode());
        map.put("DeptZipcode", getDeptZipcode());
        map.put("UserIpphome", getUserIpphome());
        map.put("LastTime", Tool.stringOfDateTime(getLastTime()));
        map.put("SkinId", getSkinId());
        map.put("DispNum", getDispNum() + "");
        map.put("OrderbyField", getOrderbyField());
        map.put("OrderStyle", getOrderStyle());
        map.put("Roles", getRoles());
        map.put("Enable", getEnable() + "");
        map.put("IsFirstLogon", getIsFirstLogon() + "");
        map.put("OperTime", Tool.stringOfDateTime(getOperTime()));
        map.put("OperLog", getOperLog());
        map.put("OperUser", getOperUser() + "");
        map.put("LocusCode", getLocusCode());
        map.put("LogonNum", getLogonNum() + "");
        map.put("CurIp", getCurIp());
        map.put("CurTime", Tool.stringOfDateTime(getCurTime()));
        map.put("IsEnable", getIsEnable() + "");
        map.put("Ip", getIp());
        map.put("Identity", getIdentity());
        map.put("MemberPolitics", getMemberPolitics());
        map.put("TimeToSchool", Tool.stringOfDateTime(getTimeToSchool()));
        map.put("TimeToTuan", Tool.stringOfDateTime(getTimeToTuan()));
        map.put("Birthday", Tool.stringOfDateTime(getBirthday()));
        map.put("ZhiBu", getZhiBu());
        map.put("Nation", getNation());
        map.put("Major", getMajor());
        map.put("LenOfSchool", getLenOfSchool());
        map.put("NativePlace", getNativePlace());
        map.put("IDNum", getIDNum());
        map.put("Phone", getPhone());
        map.put("Email2", getEmail2());
        map.put("Addfilelist", getAddfilelist());
        map.put("YearToSchool", getYearToSchool());
        map.put("GraduateTime", Tool.stringOfDateTime(getGraduateTime()));
        map.put("VolunteerfFag", getVolunteerfFag());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("OrgId:\"" + getOrgId() + "\"");
        row.add("OrgCode:\"" + Tool.jsSpecialChars(getOrgCode()) + "\"");
        row.add("DeptId:\"" + getDeptId() + "\"");
        row.add("DeptCode:\"" + Tool.jsSpecialChars(getDeptCode()) + "\"");
        row.add("Name:\"" + Tool.jsSpecialChars(getName()) + "\"");
        row.add("CnName:\"" + Tool.jsSpecialChars(getCnName()) + "\"");
        row.add("Code:\"" + Tool.jsSpecialChars(getCode()) + "\"");
        row.add("Gender:\"" + getGender() + "\"");
        row.add("Occupation:\"" + Tool.jsSpecialChars(getOccupation()) + "\"");
        row.add("Grade:\"" + Tool.jsSpecialChars(getGrade()) + "\"");
        row.add("Dept:\"" + Tool.jsSpecialChars(getDept()) + "\"");
        row.add("Orderby:\"" + getOrderby() + "\"");
        row.add("Principal:\"" + Tool.jsSpecialChars(getPrincipal()) + "\"");
        row.add("PhoneNum:\"" + Tool.jsSpecialChars(getPhoneNum()) + "\"");
        row.add("MobilePhone:\"" + Tool.jsSpecialChars(getMobilePhone()) + "\"");
        row.add("Fax:\"" + Tool.jsSpecialChars(getFax()) + "\"");
        row.add("OfficeAddress:\"" + Tool.jsSpecialChars(getOfficeAddress()) + "\"");
        row.add("Email:\"" + Tool.jsSpecialChars(getEmail()) + "\"");
        row.add("Pwd:\"" + Tool.jsSpecialChars(getPwd()) + "\"");
        row.add("HomeAddress:\"" + Tool.jsSpecialChars(getHomeAddress()) + "\"");
        row.add("HomeZipcode:\"" + Tool.jsSpecialChars(getHomeZipcode()) + "\"");
        row.add("DeptZipcode:\"" + Tool.jsSpecialChars(getDeptZipcode()) + "\"");
        row.add("UserIpphome:\"" + Tool.jsSpecialChars(getUserIpphome()) + "\"");
        row.add("LastTime:\"" + Tool.stringOfDateTime(getLastTime()) + "\"");
        row.add("SkinId:\"" + Tool.jsSpecialChars(getSkinId()) + "\"");
        row.add("DispNum:\"" + getDispNum() + "\"");
        row.add("OrderbyField:\"" + Tool.jsSpecialChars(getOrderbyField()) + "\"");
        row.add("OrderStyle:\"" + Tool.jsSpecialChars(getOrderStyle()) + "\"");
        row.add("Roles:\"" + Tool.jsSpecialChars(getRoles()) + "\"");
        row.add("Enable:\"" + getEnable() + "\"");
        row.add("IsFirstLogon:\"" + getIsFirstLogon() + "\"");
        row.add("OperTime:\"" + Tool.stringOfDateTime(getOperTime()) + "\"");
        row.add("OperLog:\"" + Tool.jsSpecialChars(getOperLog()) + "\"");
        row.add("OperUser:\"" + getOperUser() + "\"");
        row.add("LocusCode:\"" + Tool.jsSpecialChars(getLocusCode()) + "\"");
        row.add("LogonNum:\"" + getLogonNum() + "\"");
        row.add("CurIp:\"" + Tool.jsSpecialChars(getCurIp()) + "\"");
        row.add("CurTime:\"" + Tool.stringOfDateTime(getCurTime()) + "\"");
        row.add("IsEnable:\"" + getIsEnable() + "\"");
        row.add("Ip:\"" + Tool.jsSpecialChars(getIp()) + "\"");
        row.add("Identity:\"" + Tool.jsSpecialChars(getIdentity()) + "\"");
        row.add("MemberPolitics:\"" + Tool.jsSpecialChars(getMemberPolitics()) + "\"");
        row.add("TimeToSchool:\"" + Tool.stringOfDateTime(getTimeToSchool()) + "\"");
        row.add("TimeToTuan:\"" + Tool.stringOfDateTime(getTimeToTuan()) + "\"");
        row.add("Birthday:\"" + Tool.stringOfDateTime(getBirthday()) + "\"");
        row.add("ZhiBu:\"" + Tool.jsSpecialChars(getZhiBu()) + "\"");
        row.add("Nation:\"" + Tool.jsSpecialChars(getNation()) + "\"");
        row.add("Major:\"" + Tool.jsSpecialChars(getMajor()) + "\"");
        row.add("LenOfSchool:\"" + Tool.jsSpecialChars(getLenOfSchool()) + "\"");
        row.add("NativePlace:\"" + Tool.jsSpecialChars(getNativePlace()) + "\"");
        row.add("IDNum:\"" + Tool.jsSpecialChars(getIDNum()) + "\"");
        row.add("Phone:\"" + Tool.jsSpecialChars(getPhone()) + "\"");
        row.add("Email2:\"" + Tool.jsSpecialChars(getEmail2()) + "\"");
        row.add("Addfilelist:\"" + Tool.jsSpecialChars(getAddfilelist()) + "\"");
        row.add("YearToSchool:\"" + Tool.jsSpecialChars(getYearToSchool()) + "\"");
        row.add("GraduateTime:\"" + Tool.stringOfDateTime(getGraduateTime()) + "\"");
        row.add("VolunteerfFag:\"" + Tool.jsSpecialChars(getVolunteerfFag()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,orgid number(*,0),orgcode varchar2(50),deptid number(*,0),deptcode varchar2(50),name varchar2(50),cnname varchar2(50),code varchar2(50),gender number(*,0),occupation varchar2(100),grade varchar2(100),dept varchar2(100),orderby number(*,0),principal varchar2(50),phonenum varchar2(50),mobilephone varchar2(50),fax varchar2(50),officeaddress varchar2(200),email varchar2(50),pwd varchar2(50),homeaddress varchar2(255),homezipcode varchar2(12),deptzipcode varchar2(12),useripphome varchar2(50),lasttime date,skinid varchar2(200),dispnum number(*,0),orderbyfield varchar2(20),orderstyle varchar2(11),roles varchar2(500),enable number(*,0),isfirstlogon number(*,0),opertime date,operlog varchar2(500),operuser number(*,0),locuscode varchar2(50),logonnum number(*,0),curip varchar2(50),curtime date,isenable number(*,0),ip varchar2(50),identity varchar2(45),memberpolitics varchar2(45),timetoschool date,timetotuan date,birthday date,zhibu varchar2(50),nation varchar2(50),major varchar2(50),lenofschool varchar2(50),nativeplace varchar2(50),idnum varchar2(50),phone varchar2(50),email2 varchar2(50),addfilelist varchar2(50),yeartoschool varchar2(2000),graduatetime date,volunteerffag varchar2(2))"});
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
        BaseUserCode v = new BaseUserCode(sourceDb, sourceTb);
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
        BaseUserCode v = new BaseUserCode(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(BaseUserCode obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getOrgId()).compareTo("" + obj.getOrgId()); if (rtn != 0) return rtn;
        rtn = getOrgCode().compareTo(obj.getOrgCode()); if (rtn != 0) return rtn;
        rtn = ("" + getDeptId()).compareTo("" + obj.getDeptId()); if (rtn != 0) return rtn;
        rtn = getDeptCode().compareTo(obj.getDeptCode()); if (rtn != 0) return rtn;
        rtn = getName().compareTo(obj.getName()); if (rtn != 0) return rtn;
        rtn = getCnName().compareTo(obj.getCnName()); if (rtn != 0) return rtn;
        rtn = getCode().compareTo(obj.getCode()); if (rtn != 0) return rtn;
        rtn = ("" + getGender()).compareTo("" + obj.getGender()); if (rtn != 0) return rtn;
        rtn = getOccupation().compareTo(obj.getOccupation()); if (rtn != 0) return rtn;
        rtn = getGrade().compareTo(obj.getGrade()); if (rtn != 0) return rtn;
        rtn = getDept().compareTo(obj.getDept()); if (rtn != 0) return rtn;
        rtn = ("" + getOrderby()).compareTo("" + obj.getOrderby()); if (rtn != 0) return rtn;
        rtn = getPrincipal().compareTo(obj.getPrincipal()); if (rtn != 0) return rtn;
        rtn = getPhoneNum().compareTo(obj.getPhoneNum()); if (rtn != 0) return rtn;
        rtn = getMobilePhone().compareTo(obj.getMobilePhone()); if (rtn != 0) return rtn;
        rtn = getFax().compareTo(obj.getFax()); if (rtn != 0) return rtn;
        rtn = getOfficeAddress().compareTo(obj.getOfficeAddress()); if (rtn != 0) return rtn;
        rtn = getEmail().compareTo(obj.getEmail()); if (rtn != 0) return rtn;
        rtn = getPwd().compareTo(obj.getPwd()); if (rtn != 0) return rtn;
        rtn = getHomeAddress().compareTo(obj.getHomeAddress()); if (rtn != 0) return rtn;
        rtn = getHomeZipcode().compareTo(obj.getHomeZipcode()); if (rtn != 0) return rtn;
        rtn = getDeptZipcode().compareTo(obj.getDeptZipcode()); if (rtn != 0) return rtn;
        rtn = getUserIpphome().compareTo(obj.getUserIpphome()); if (rtn != 0) return rtn;
        rtn = getLastTime().compareTo(obj.getLastTime()); if (rtn != 0) return rtn;
        rtn = getSkinId().compareTo(obj.getSkinId()); if (rtn != 0) return rtn;
        rtn = ("" + getDispNum()).compareTo("" + obj.getDispNum()); if (rtn != 0) return rtn;
        rtn = getOrderbyField().compareTo(obj.getOrderbyField()); if (rtn != 0) return rtn;
        rtn = getOrderStyle().compareTo(obj.getOrderStyle()); if (rtn != 0) return rtn;
        rtn = getRoles().compareTo(obj.getRoles()); if (rtn != 0) return rtn;
        rtn = ("" + getEnable()).compareTo("" + obj.getEnable()); if (rtn != 0) return rtn;
        rtn = ("" + getIsFirstLogon()).compareTo("" + obj.getIsFirstLogon()); if (rtn != 0) return rtn;
        rtn = getOperTime().compareTo(obj.getOperTime()); if (rtn != 0) return rtn;
        rtn = getOperLog().compareTo(obj.getOperLog()); if (rtn != 0) return rtn;
        rtn = ("" + getOperUser()).compareTo("" + obj.getOperUser()); if (rtn != 0) return rtn;
        rtn = getLocusCode().compareTo(obj.getLocusCode()); if (rtn != 0) return rtn;
        rtn = ("" + getLogonNum()).compareTo("" + obj.getLogonNum()); if (rtn != 0) return rtn;
        rtn = getCurIp().compareTo(obj.getCurIp()); if (rtn != 0) return rtn;
        rtn = getCurTime().compareTo(obj.getCurTime()); if (rtn != 0) return rtn;
        rtn = ("" + getIsEnable()).compareTo("" + obj.getIsEnable()); if (rtn != 0) return rtn;
        rtn = getIp().compareTo(obj.getIp()); if (rtn != 0) return rtn;
        rtn = getIdentity().compareTo(obj.getIdentity()); if (rtn != 0) return rtn;
        rtn = getMemberPolitics().compareTo(obj.getMemberPolitics()); if (rtn != 0) return rtn;
        rtn = getTimeToSchool().compareTo(obj.getTimeToSchool()); if (rtn != 0) return rtn;
        rtn = getTimeToTuan().compareTo(obj.getTimeToTuan()); if (rtn != 0) return rtn;
        rtn = getBirthday().compareTo(obj.getBirthday()); if (rtn != 0) return rtn;
        rtn = getZhiBu().compareTo(obj.getZhiBu()); if (rtn != 0) return rtn;
        rtn = getNation().compareTo(obj.getNation()); if (rtn != 0) return rtn;
        rtn = getMajor().compareTo(obj.getMajor()); if (rtn != 0) return rtn;
        rtn = getLenOfSchool().compareTo(obj.getLenOfSchool()); if (rtn != 0) return rtn;
        rtn = getNativePlace().compareTo(obj.getNativePlace()); if (rtn != 0) return rtn;
        rtn = getIDNum().compareTo(obj.getIDNum()); if (rtn != 0) return rtn;
        rtn = getPhone().compareTo(obj.getPhone()); if (rtn != 0) return rtn;
        rtn = getEmail2().compareTo(obj.getEmail2()); if (rtn != 0) return rtn;
        rtn = getAddfilelist().compareTo(obj.getAddfilelist()); if (rtn != 0) return rtn;
        rtn = getYearToSchool().compareTo(obj.getYearToSchool()); if (rtn != 0) return rtn;
        rtn = getGraduateTime().compareTo(obj.getGraduateTime()); if (rtn != 0) return rtn;
        rtn = getVolunteerfFag().compareTo(obj.getVolunteerfFag()); if (rtn != 0) return rtn;
        return rtn;
    }
}
