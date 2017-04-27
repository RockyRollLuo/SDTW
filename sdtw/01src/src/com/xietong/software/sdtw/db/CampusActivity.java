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
@Description("校园文化信息")
public class CampusActivity implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(CampusActivity.class);
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
    public static final String DbTableName = "campus_activity";
    private String TNAME = "campus_activity";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","activityName","activitykindType","orgacadeMy","activityLevel","totalRounds","activityDate1","activityPlace1","activityDate2","activityPlace2","activityDate3","activityPlace3","deadline","personNumber","activityPrincipal","contact","activityExplain","applicationRange","campus","academy","addtime","addperson","modifyTime","modifyPerson","honor"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","activityname","activitykindtype","orgacademy","activitylevel","totalrounds","activitydate1","activityplace1","activitydate2","activityplace2","activitydate3","activityplace3","deadline","personnumber","activityprincipal","contact","activityexplain","applicationrange","campus","academy","addtime","addperson","modifytime","modifyperson","honor"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"ActivityName","activityname","String"},{"ActivitykindType","activitykindtype","String"},{"OrgacadeMy","orgacademy","String"},{"ActivityLevel","activitylevel","String"},{"TotalRounds","totalrounds","String"},{"ActivityDate1","activitydate1","String"},{"ActivityPlace1","activityplace1","String"},{"ActivityDate2","activitydate2","String"},{"ActivityPlace2","activityplace2","String"},{"ActivityDate3","activitydate3","String"},{"ActivityPlace3","activityplace3","String"},{"Deadline","deadline","String"},{"PersonNumber","personnumber","String"},{"ActivityPrincipal","activityprincipal","String"},{"Contact","contact","String"},{"ActivityExplain","activityexplain","String"},{"ApplicationRange","applicationrange","String"},{"Campus","campus","String"},{"Academy","academy","String"},{"Addtime","addtime","java.util.Date"},{"Addperson","addperson","String"},{"ModifyTime","modifytime","java.util.Date"},{"ModifyPerson","modifyperson","String"},{"Honor","honor","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"activityName","activityname"},{"activitykindType","activitykindtype"},{"orgacadeMy","orgacademy"},{"activityLevel","activitylevel"},{"totalRounds","totalrounds"},{"activityDate1","activitydate1"},{"activityPlace1","activityplace1"},{"activityDate2","activitydate2"},{"activityPlace2","activityplace2"},{"activityDate3","activitydate3"},{"activityPlace3","activityplace3"},{"deadline","deadline"},{"personNumber","personnumber"},{"activityPrincipal","activityprincipal"},{"contact","contact"},{"activityExplain","activityexplain"},{"applicationRange","applicationrange"},{"campus","campus"},{"academy","academy"},{"addtime","addtime"},{"addperson","addperson"},{"modifyTime","modifytime"},{"modifyPerson","modifyperson"},{"honor","honor"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME","MODIFYTIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 活动名称
    protected String activityName = "";
    public String getActivityName() {  return SqlTool.getDbString(activityName);  }
    public String getActivityName(int size) { return SqlTool.subString(getActivityName(), size); }
    public void setActivityName(String aActivityName) { activityName = aActivityName; modifiedFields.add("ActivityName"); }
    public void assignActivityName(String aActivityName) { activityName = aActivityName; }
    public void paramActivityName(HttpServletRequest request) { paramActivityName(request, "ActivityName"); }
    public void paramActivityName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityName()); if (!tmp.equals(getActivityName())) { setActivityName(tmp); } }
    // 活动类别
    protected String activitykindType = "";
    public String getActivitykindType() {  return SqlTool.getDbString(activitykindType);  }
    public String getActivitykindType(int size) { return SqlTool.subString(getActivitykindType(), size); }
    public void setActivitykindType(String aActivitykindType) { activitykindType = aActivitykindType; modifiedFields.add("ActivitykindType"); }
    public void assignActivitykindType(String aActivitykindType) { activitykindType = aActivitykindType; }
    public void paramActivitykindType(HttpServletRequest request) { paramActivitykindType(request, "ActivitykindType"); }
    public void paramActivitykindType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivitykindType()); if (!tmp.equals(getActivitykindType())) { setActivitykindType(tmp); } }
    // 活动组织单位
    protected String orgacadeMy = "";
    public String getOrgacadeMy() {  return SqlTool.getDbString(orgacadeMy);  }
    public String getOrgacadeMy(int size) { return SqlTool.subString(getOrgacadeMy(), size); }
    public void setOrgacadeMy(String aOrgacadeMy) { orgacadeMy = aOrgacadeMy; modifiedFields.add("OrgacadeMy"); }
    public void assignOrgacadeMy(String aOrgacadeMy) { orgacadeMy = aOrgacadeMy; }
    public void paramOrgacadeMy(HttpServletRequest request) { paramOrgacadeMy(request, "OrgacadeMy"); }
    public void paramOrgacadeMy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOrgacadeMy()); if (!tmp.equals(getOrgacadeMy())) { setOrgacadeMy(tmp); } }
    // 活动级别
    protected String activityLevel = "";
    public String getActivityLevel() {  return SqlTool.getDbString(activityLevel);  }
    public String getActivityLevel(int size) { return SqlTool.subString(getActivityLevel(), size); }
    public void setActivityLevel(String aActivityLevel) { activityLevel = aActivityLevel; modifiedFields.add("ActivityLevel"); }
    public void assignActivityLevel(String aActivityLevel) { activityLevel = aActivityLevel; }
    public void paramActivityLevel(HttpServletRequest request) { paramActivityLevel(request, "ActivityLevel"); }
    public void paramActivityLevel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityLevel()); if (!tmp.equals(getActivityLevel())) { setActivityLevel(tmp); } }
    // 活动轮次
    protected String totalRounds = "";
    public String getTotalRounds() {  return SqlTool.getDbString(totalRounds);  }
    public String getTotalRounds(int size) { return SqlTool.subString(getTotalRounds(), size); }
    public void setTotalRounds(String aTotalRounds) { totalRounds = aTotalRounds; modifiedFields.add("TotalRounds"); }
    public void assignTotalRounds(String aTotalRounds) { totalRounds = aTotalRounds; }
    public void paramTotalRounds(HttpServletRequest request) { paramTotalRounds(request, "TotalRounds"); }
    public void paramTotalRounds(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTotalRounds()); if (!tmp.equals(getTotalRounds())) { setTotalRounds(tmp); } }
    // 第一轮活动日期
    protected String activityDate1 = "";
    public String getActivityDate1() {  return SqlTool.getDbString(activityDate1);  }
    public String getActivityDate1(int size) { return SqlTool.subString(getActivityDate1(), size); }
    public void setActivityDate1(String aActivityDate1) { activityDate1 = aActivityDate1; modifiedFields.add("ActivityDate1"); }
    public void assignActivityDate1(String aActivityDate1) { activityDate1 = aActivityDate1; }
    public void paramActivityDate1(HttpServletRequest request) { paramActivityDate1(request, "ActivityDate1"); }
    public void paramActivityDate1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityDate1()); if (!tmp.equals(getActivityDate1())) { setActivityDate1(tmp); } }
    // 第一轮活动地点
    protected String activityPlace1 = "";
    public String getActivityPlace1() {  return SqlTool.getDbString(activityPlace1);  }
    public String getActivityPlace1(int size) { return SqlTool.subString(getActivityPlace1(), size); }
    public void setActivityPlace1(String aActivityPlace1) { activityPlace1 = aActivityPlace1; modifiedFields.add("ActivityPlace1"); }
    public void assignActivityPlace1(String aActivityPlace1) { activityPlace1 = aActivityPlace1; }
    public void paramActivityPlace1(HttpServletRequest request) { paramActivityPlace1(request, "ActivityPlace1"); }
    public void paramActivityPlace1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityPlace1()); if (!tmp.equals(getActivityPlace1())) { setActivityPlace1(tmp); } }
    // 第二轮活动日期
    protected String activityDate2 = "";
    public String getActivityDate2() {  return SqlTool.getDbString(activityDate2);  }
    public String getActivityDate2(int size) { return SqlTool.subString(getActivityDate2(), size); }
    public void setActivityDate2(String aActivityDate2) { activityDate2 = aActivityDate2; modifiedFields.add("ActivityDate2"); }
    public void assignActivityDate2(String aActivityDate2) { activityDate2 = aActivityDate2; }
    public void paramActivityDate2(HttpServletRequest request) { paramActivityDate2(request, "ActivityDate2"); }
    public void paramActivityDate2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityDate2()); if (!tmp.equals(getActivityDate2())) { setActivityDate2(tmp); } }
    // 第二轮活动地点
    protected String activityPlace2 = "";
    public String getActivityPlace2() {  return SqlTool.getDbString(activityPlace2);  }
    public String getActivityPlace2(int size) { return SqlTool.subString(getActivityPlace2(), size); }
    public void setActivityPlace2(String aActivityPlace2) { activityPlace2 = aActivityPlace2; modifiedFields.add("ActivityPlace2"); }
    public void assignActivityPlace2(String aActivityPlace2) { activityPlace2 = aActivityPlace2; }
    public void paramActivityPlace2(HttpServletRequest request) { paramActivityPlace2(request, "ActivityPlace2"); }
    public void paramActivityPlace2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityPlace2()); if (!tmp.equals(getActivityPlace2())) { setActivityPlace2(tmp); } }
    // 第三轮活动日期
    protected String activityDate3 = "";
    public String getActivityDate3() {  return SqlTool.getDbString(activityDate3);  }
    public String getActivityDate3(int size) { return SqlTool.subString(getActivityDate3(), size); }
    public void setActivityDate3(String aActivityDate3) { activityDate3 = aActivityDate3; modifiedFields.add("ActivityDate3"); }
    public void assignActivityDate3(String aActivityDate3) { activityDate3 = aActivityDate3; }
    public void paramActivityDate3(HttpServletRequest request) { paramActivityDate3(request, "ActivityDate3"); }
    public void paramActivityDate3(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityDate3()); if (!tmp.equals(getActivityDate3())) { setActivityDate3(tmp); } }
    // 第三轮活动地点
    protected String activityPlace3 = "";
    public String getActivityPlace3() {  return SqlTool.getDbString(activityPlace3);  }
    public String getActivityPlace3(int size) { return SqlTool.subString(getActivityPlace3(), size); }
    public void setActivityPlace3(String aActivityPlace3) { activityPlace3 = aActivityPlace3; modifiedFields.add("ActivityPlace3"); }
    public void assignActivityPlace3(String aActivityPlace3) { activityPlace3 = aActivityPlace3; }
    public void paramActivityPlace3(HttpServletRequest request) { paramActivityPlace3(request, "ActivityPlace3"); }
    public void paramActivityPlace3(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityPlace3()); if (!tmp.equals(getActivityPlace3())) { setActivityPlace3(tmp); } }
    // 报名截止日期
    protected String deadline = "";
    public String getDeadline() {  return SqlTool.getDbString(deadline);  }
    public String getDeadline(int size) { return SqlTool.subString(getDeadline(), size); }
    public void setDeadline(String aDeadline) { deadline = aDeadline; modifiedFields.add("Deadline"); }
    public void assignDeadline(String aDeadline) { deadline = aDeadline; }
    public void paramDeadline(HttpServletRequest request) { paramDeadline(request, "Deadline"); }
    public void paramDeadline(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeadline()); if (!tmp.equals(getDeadline())) { setDeadline(tmp); } }
    // 所需人数
    protected String personNumber = "";
    public String getPersonNumber() {  return SqlTool.getDbString(personNumber);  }
    public String getPersonNumber(int size) { return SqlTool.subString(getPersonNumber(), size); }
    public void setPersonNumber(String aPersonNumber) { personNumber = aPersonNumber; modifiedFields.add("PersonNumber"); }
    public void assignPersonNumber(String aPersonNumber) { personNumber = aPersonNumber; }
    public void paramPersonNumber(HttpServletRequest request) { paramPersonNumber(request, "PersonNumber"); }
    public void paramPersonNumber(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPersonNumber()); if (!tmp.equals(getPersonNumber())) { setPersonNumber(tmp); } }
    // 负责人
    protected String activityPrincipal = "";
    public String getActivityPrincipal() {  return SqlTool.getDbString(activityPrincipal);  }
    public String getActivityPrincipal(int size) { return SqlTool.subString(getActivityPrincipal(), size); }
    public void setActivityPrincipal(String aActivityPrincipal) { activityPrincipal = aActivityPrincipal; modifiedFields.add("ActivityPrincipal"); }
    public void assignActivityPrincipal(String aActivityPrincipal) { activityPrincipal = aActivityPrincipal; }
    public void paramActivityPrincipal(HttpServletRequest request) { paramActivityPrincipal(request, "ActivityPrincipal"); }
    public void paramActivityPrincipal(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityPrincipal()); if (!tmp.equals(getActivityPrincipal())) { setActivityPrincipal(tmp); } }
    // 联系方式
    protected String contact = "";
    public String getContact() {  return SqlTool.getDbString(contact);  }
    public String getContact(int size) { return SqlTool.subString(getContact(), size); }
    public void setContact(String aContact) { contact = aContact; modifiedFields.add("Contact"); }
    public void assignContact(String aContact) { contact = aContact; }
    public void paramContact(HttpServletRequest request) { paramContact(request, "Contact"); }
    public void paramContact(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getContact()); if (!tmp.equals(getContact())) { setContact(tmp); } }
    // 详细介绍
    protected String activityExplain = "";
    public String getActivityExplain() {  return SqlTool.getDbString(activityExplain);  }
    public String getActivityExplain(int size) { return SqlTool.subString(getActivityExplain(), size); }
    public void setActivityExplain(String aActivityExplain) { activityExplain = aActivityExplain; modifiedFields.add("ActivityExplain"); }
    public void assignActivityExplain(String aActivityExplain) { activityExplain = aActivityExplain; }
    public void paramActivityExplain(HttpServletRequest request) { paramActivityExplain(request, "ActivityExplain"); }
    public void paramActivityExplain(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityExplain()); if (!tmp.equals(getActivityExplain())) { setActivityExplain(tmp); } }
    // 申请范围
    protected String applicationRange = "";
    public String getApplicationRange() {  return SqlTool.getDbString(applicationRange);  }
    public String getApplicationRange(int size) { return SqlTool.subString(getApplicationRange(), size); }
    public void setApplicationRange(String aApplicationRange) { applicationRange = aApplicationRange; modifiedFields.add("ApplicationRange"); }
    public void assignApplicationRange(String aApplicationRange) { applicationRange = aApplicationRange; }
    public void paramApplicationRange(HttpServletRequest request) { paramApplicationRange(request, "ApplicationRange"); }
    public void paramApplicationRange(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getApplicationRange()); if (!tmp.equals(getApplicationRange())) { setApplicationRange(tmp); } }
    // 参与校区
    protected String campus = "";
    public String getCampus() {  return SqlTool.getDbString(campus);  }
    public String getCampus(int size) { return SqlTool.subString(getCampus(), size); }
    public void setCampus(String aCampus) { campus = aCampus; modifiedFields.add("Campus"); }
    public void assignCampus(String aCampus) { campus = aCampus; }
    public void paramCampus(HttpServletRequest request) { paramCampus(request, "Campus"); }
    public void paramCampus(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCampus()); if (!tmp.equals(getCampus())) { setCampus(tmp); } }
    // 学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 添加时间
    protected java.util.Date addtime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddtime() { return addtime; }
    public void setAddtime(java.util.Date aAddtime) { addtime = aAddtime; modifiedFields.add("Addtime"); }
    public void assignAddtime(java.util.Date aAddtime) { addtime = aAddtime; }
    public void paramAddtime(HttpServletRequest request) { paramAddtime(request, "Addtime"); }
    public void paramAddtime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddtime()); if (tmp.compareTo(getAddtime()) != 0) { setAddtime(tmp); } }
    // 添加人
    protected String addperson = "";
    public String getAddperson() {  return SqlTool.getDbString(addperson);  }
    public String getAddperson(int size) { return SqlTool.subString(getAddperson(), size); }
    public void setAddperson(String aAddperson) { addperson = aAddperson; modifiedFields.add("Addperson"); }
    public void assignAddperson(String aAddperson) { addperson = aAddperson; }
    public void paramAddperson(HttpServletRequest request) { paramAddperson(request, "Addperson"); }
    public void paramAddperson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddperson()); if (!tmp.equals(getAddperson())) { setAddperson(tmp); } }
    // 修改时间
    protected java.util.Date modifyTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getModifyTime() { return modifyTime; }
    public void setModifyTime(java.util.Date aModifyTime) { modifyTime = aModifyTime; modifiedFields.add("ModifyTime"); }
    public void assignModifyTime(java.util.Date aModifyTime) { modifyTime = aModifyTime; }
    public void paramModifyTime(HttpServletRequest request) { paramModifyTime(request, "ModifyTime"); }
    public void paramModifyTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getModifyTime()); if (tmp.compareTo(getModifyTime()) != 0) { setModifyTime(tmp); } }
    // 修改人
    protected String modifyPerson = "";
    public String getModifyPerson() {  return SqlTool.getDbString(modifyPerson);  }
    public String getModifyPerson(int size) { return SqlTool.subString(getModifyPerson(), size); }
    public void setModifyPerson(String aModifyPerson) { modifyPerson = aModifyPerson; modifiedFields.add("ModifyPerson"); }
    public void assignModifyPerson(String aModifyPerson) { modifyPerson = aModifyPerson; }
    public void paramModifyPerson(HttpServletRequest request) { paramModifyPerson(request, "ModifyPerson"); }
    public void paramModifyPerson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getModifyPerson()); if (!tmp.equals(getModifyPerson())) { setModifyPerson(tmp); } }
    // 荣誉
    protected String honor = "";
    public String getHonor() {  return SqlTool.getDbString(honor);  }
    public String getHonor(int size) { return SqlTool.subString(getHonor(), size); }
    public void setHonor(String aHonor) { honor = aHonor; modifiedFields.add("Honor"); }
    public void assignHonor(String aHonor) { honor = aHonor; }
    public void paramHonor(HttpServletRequest request) { paramHonor(request, "Honor"); }
    public void paramHonor(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHonor()); if (!tmp.equals(getHonor())) { setHonor(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public CampusActivity (String db) {
        DBNAME = db;
    }
    public CampusActivity (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public CampusActivity (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public CampusActivity () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return CampusActivity类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public CampusActivity getByParameter(HttpServletRequest request) {
        CampusActivity v = new CampusActivity(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramActivityName(request);
        paramActivitykindType(request);
        paramOrgacadeMy(request);
        paramActivityLevel(request);
        paramTotalRounds(request);
        paramActivityDate1(request);
        paramActivityPlace1(request);
        paramActivityDate2(request);
        paramActivityPlace2(request);
        paramActivityDate3(request);
        paramActivityPlace3(request);
        paramDeadline(request);
        paramPersonNumber(request);
        paramActivityPrincipal(request);
        paramContact(request);
        paramActivityExplain(request);
        paramApplicationRange(request);
        paramCampus(request);
        paramAcademy(request);
        paramAddtime(request);
        paramAddperson(request);
        paramModifyTime(request);
        paramModifyPerson(request);
        paramHonor(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(CampusActivity bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("activityName")) { setActivityName(bean.getActivityName()); }
        if (!ncl.contains("activitykindType")) { setActivitykindType(bean.getActivitykindType()); }
        if (!ncl.contains("orgacadeMy")) { setOrgacadeMy(bean.getOrgacadeMy()); }
        if (!ncl.contains("activityLevel")) { setActivityLevel(bean.getActivityLevel()); }
        if (!ncl.contains("totalRounds")) { setTotalRounds(bean.getTotalRounds()); }
        if (!ncl.contains("activityDate1")) { setActivityDate1(bean.getActivityDate1()); }
        if (!ncl.contains("activityPlace1")) { setActivityPlace1(bean.getActivityPlace1()); }
        if (!ncl.contains("activityDate2")) { setActivityDate2(bean.getActivityDate2()); }
        if (!ncl.contains("activityPlace2")) { setActivityPlace2(bean.getActivityPlace2()); }
        if (!ncl.contains("activityDate3")) { setActivityDate3(bean.getActivityDate3()); }
        if (!ncl.contains("activityPlace3")) { setActivityPlace3(bean.getActivityPlace3()); }
        if (!ncl.contains("deadline")) { setDeadline(bean.getDeadline()); }
        if (!ncl.contains("personNumber")) { setPersonNumber(bean.getPersonNumber()); }
        if (!ncl.contains("activityPrincipal")) { setActivityPrincipal(bean.getActivityPrincipal()); }
        if (!ncl.contains("contact")) { setContact(bean.getContact()); }
        if (!ncl.contains("activityExplain")) { setActivityExplain(bean.getActivityExplain()); }
        if (!ncl.contains("applicationRange")) { setApplicationRange(bean.getApplicationRange()); }
        if (!ncl.contains("campus")) { setCampus(bean.getCampus()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("addtime")) { setAddtime(bean.getAddtime()); }
        if (!ncl.contains("addperson")) { setAddperson(bean.getAddperson()); }
        if (!ncl.contains("modifyTime")) { setModifyTime(bean.getModifyTime()); }
        if (!ncl.contains("modifyPerson")) { setModifyPerson(bean.getModifyPerson()); }
        if (!ncl.contains("honor")) { setHonor(bean.getHonor()); }
    }
    public CampusActivity getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        CampusActivity[] rslt= queryByCondition(cdt);
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
     * @return CampusActivity类的实例列表。
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
                CampusActivity ve = new CampusActivity(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignActivityName(fromDbCh(rs.getString(2)));
                ve.assignActivitykindType(fromDbCh(rs.getString(3)));
                ve.assignOrgacadeMy(fromDbCh(rs.getString(4)));
                ve.assignActivityLevel(fromDbCh(rs.getString(5)));
                ve.assignTotalRounds(fromDbCh(rs.getString(6)));
                ve.assignActivityDate1(fromDbCh(rs.getString(7)));
                ve.assignActivityPlace1(fromDbCh(rs.getString(8)));
                ve.assignActivityDate2(fromDbCh(rs.getString(9)));
                ve.assignActivityPlace2(fromDbCh(rs.getString(10)));
                ve.assignActivityDate3(fromDbCh(rs.getString(11)));
                ve.assignActivityPlace3(fromDbCh(rs.getString(12)));
                ve.assignDeadline(fromDbCh(rs.getString(13)));
                ve.assignPersonNumber(fromDbCh(rs.getString(14)));
                ve.assignActivityPrincipal(fromDbCh(rs.getString(15)));
                ve.assignContact(fromDbCh(rs.getString(16)));
                ve.assignActivityExplain(fromDbCh(rs.getString(17)));
                ve.assignApplicationRange(fromDbCh(rs.getString(18)));
                ve.assignCampus(fromDbCh(rs.getString(19)));
                ve.assignAcademy(fromDbCh(rs.getString(20)));
                tmpDate = rs.getTimestamp(21); if (tmpDate != null) { ve.assignAddtime(new java.util.Date(tmpDate.getTime())); }
                ve.assignAddperson(fromDbCh(rs.getString(22)));
                tmpDate = rs.getTimestamp(23); if (tmpDate != null) { ve.assignModifyTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignModifyPerson(fromDbCh(rs.getString(24)));
                ve.assignHonor(fromDbCh(rs.getString(25)));
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
    public CampusActivity[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (CampusActivity[])vrs.toArray(new CampusActivity[vrs.size()]);
    }
    public CampusActivity[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (CampusActivity[])vrs.toArray(new CampusActivity[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (activityname,activitykindtype,orgacademy,activitylevel,totalrounds,activitydate1,activityplace1,activitydate2,activityplace2,activitydate3,activityplace3,deadline,personnumber,activityprincipal,contact,activityexplain,applicationrange,campus,academy,addtime,addperson,modifytime,modifyperson,honor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(activityName));
            pstmt.setString(2, toDbCh(activitykindType));
            pstmt.setString(3, toDbCh(orgacadeMy));
            pstmt.setString(4, toDbCh(activityLevel));
            pstmt.setString(5, toDbCh(totalRounds));
            pstmt.setString(6, toDbCh(activityDate1));
            pstmt.setString(7, toDbCh(activityPlace1));
            pstmt.setString(8, toDbCh(activityDate2));
            pstmt.setString(9, toDbCh(activityPlace2));
            pstmt.setString(10, toDbCh(activityDate3));
            pstmt.setString(11, toDbCh(activityPlace3));
            pstmt.setString(12, toDbCh(deadline));
            pstmt.setString(13, toDbCh(personNumber));
            pstmt.setString(14, toDbCh(activityPrincipal));
            pstmt.setString(15, toDbCh(contact));
            pstmt.setString(16, toDbCh(activityExplain));
            pstmt.setString(17, toDbCh(applicationRange));
            pstmt.setString(18, toDbCh(campus));
            pstmt.setString(19, toDbCh(academy));
            pstmt.setTimestamp(20, new java.sql.Timestamp(addtime.getTime()));
            pstmt.setString(21, toDbCh(addperson));
            pstmt.setTimestamp(22, new java.sql.Timestamp(modifyTime.getTime()));
            pstmt.setString(23, toDbCh(modifyPerson));
            pstmt.setString(24, toDbCh(honor));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,activityname,activitykindtype,orgacademy,activitylevel,totalrounds,activitydate1,activityplace1,activitydate2,activityplace2,activitydate3,activityplace3,deadline,personnumber,activityprincipal,contact,activityexplain,applicationrange,campus,academy,addtime,addperson,modifytime,modifyperson,honor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(activityName));
            pstmt.setString(3, toDbCh(activitykindType));
            pstmt.setString(4, toDbCh(orgacadeMy));
            pstmt.setString(5, toDbCh(activityLevel));
            pstmt.setString(6, toDbCh(totalRounds));
            pstmt.setString(7, toDbCh(activityDate1));
            pstmt.setString(8, toDbCh(activityPlace1));
            pstmt.setString(9, toDbCh(activityDate2));
            pstmt.setString(10, toDbCh(activityPlace2));
            pstmt.setString(11, toDbCh(activityDate3));
            pstmt.setString(12, toDbCh(activityPlace3));
            pstmt.setString(13, toDbCh(deadline));
            pstmt.setString(14, toDbCh(personNumber));
            pstmt.setString(15, toDbCh(activityPrincipal));
            pstmt.setString(16, toDbCh(contact));
            pstmt.setString(17, toDbCh(activityExplain));
            pstmt.setString(18, toDbCh(applicationRange));
            pstmt.setString(19, toDbCh(campus));
            pstmt.setString(20, toDbCh(academy));
            pstmt.setTimestamp(21, new java.sql.Timestamp(addtime.getTime()));
            pstmt.setString(22, toDbCh(addperson));
            pstmt.setTimestamp(23, new java.sql.Timestamp(modifyTime.getTime()));
            pstmt.setString(24, toDbCh(modifyPerson));
            pstmt.setString(25, toDbCh(honor));
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
            CampusActivity item = (CampusActivity)it.next();
            CampusActivity v = new CampusActivity(dbname);
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
                if (modifiedFields.contains("ActivityName")) { pstmt.setString(pi ++, toDbCh(activityName)); }
                if (modifiedFields.contains("ActivitykindType")) { pstmt.setString(pi ++, toDbCh(activitykindType)); }
                if (modifiedFields.contains("OrgacadeMy")) { pstmt.setString(pi ++, toDbCh(orgacadeMy)); }
                if (modifiedFields.contains("ActivityLevel")) { pstmt.setString(pi ++, toDbCh(activityLevel)); }
                if (modifiedFields.contains("TotalRounds")) { pstmt.setString(pi ++, toDbCh(totalRounds)); }
                if (modifiedFields.contains("ActivityDate1")) { pstmt.setString(pi ++, toDbCh(activityDate1)); }
                if (modifiedFields.contains("ActivityPlace1")) { pstmt.setString(pi ++, toDbCh(activityPlace1)); }
                if (modifiedFields.contains("ActivityDate2")) { pstmt.setString(pi ++, toDbCh(activityDate2)); }
                if (modifiedFields.contains("ActivityPlace2")) { pstmt.setString(pi ++, toDbCh(activityPlace2)); }
                if (modifiedFields.contains("ActivityDate3")) { pstmt.setString(pi ++, toDbCh(activityDate3)); }
                if (modifiedFields.contains("ActivityPlace3")) { pstmt.setString(pi ++, toDbCh(activityPlace3)); }
                if (modifiedFields.contains("Deadline")) { pstmt.setString(pi ++, toDbCh(deadline)); }
                if (modifiedFields.contains("PersonNumber")) { pstmt.setString(pi ++, toDbCh(personNumber)); }
                if (modifiedFields.contains("ActivityPrincipal")) { pstmt.setString(pi ++, toDbCh(activityPrincipal)); }
                if (modifiedFields.contains("Contact")) { pstmt.setString(pi ++, toDbCh(contact)); }
                if (modifiedFields.contains("ActivityExplain")) { pstmt.setString(pi ++, toDbCh(activityExplain)); }
                if (modifiedFields.contains("ApplicationRange")) { pstmt.setString(pi ++, toDbCh(applicationRange)); }
                if (modifiedFields.contains("Campus")) { pstmt.setString(pi ++, toDbCh(campus)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addtime.getTime())); }
                if (modifiedFields.contains("Addperson")) { pstmt.setString(pi ++, toDbCh(addperson)); }
                if (modifiedFields.contains("ModifyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modifyTime.getTime())); }
                if (modifiedFields.contains("ModifyPerson")) { pstmt.setString(pi ++, toDbCh(modifyPerson)); }
                if (modifiedFields.contains("Honor")) { pstmt.setString(pi ++, toDbCh(honor)); }
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
                if (modifiedFields.contains("ActivityName")) { pstmt.setString(pi ++, toDbCh(activityName)); }
                if (modifiedFields.contains("ActivitykindType")) { pstmt.setString(pi ++, toDbCh(activitykindType)); }
                if (modifiedFields.contains("OrgacadeMy")) { pstmt.setString(pi ++, toDbCh(orgacadeMy)); }
                if (modifiedFields.contains("ActivityLevel")) { pstmt.setString(pi ++, toDbCh(activityLevel)); }
                if (modifiedFields.contains("TotalRounds")) { pstmt.setString(pi ++, toDbCh(totalRounds)); }
                if (modifiedFields.contains("ActivityDate1")) { pstmt.setString(pi ++, toDbCh(activityDate1)); }
                if (modifiedFields.contains("ActivityPlace1")) { pstmt.setString(pi ++, toDbCh(activityPlace1)); }
                if (modifiedFields.contains("ActivityDate2")) { pstmt.setString(pi ++, toDbCh(activityDate2)); }
                if (modifiedFields.contains("ActivityPlace2")) { pstmt.setString(pi ++, toDbCh(activityPlace2)); }
                if (modifiedFields.contains("ActivityDate3")) { pstmt.setString(pi ++, toDbCh(activityDate3)); }
                if (modifiedFields.contains("ActivityPlace3")) { pstmt.setString(pi ++, toDbCh(activityPlace3)); }
                if (modifiedFields.contains("Deadline")) { pstmt.setString(pi ++, toDbCh(deadline)); }
                if (modifiedFields.contains("PersonNumber")) { pstmt.setString(pi ++, toDbCh(personNumber)); }
                if (modifiedFields.contains("ActivityPrincipal")) { pstmt.setString(pi ++, toDbCh(activityPrincipal)); }
                if (modifiedFields.contains("Contact")) { pstmt.setString(pi ++, toDbCh(contact)); }
                if (modifiedFields.contains("ActivityExplain")) { pstmt.setString(pi ++, toDbCh(activityExplain)); }
                if (modifiedFields.contains("ApplicationRange")) { pstmt.setString(pi ++, toDbCh(applicationRange)); }
                if (modifiedFields.contains("Campus")) { pstmt.setString(pi ++, toDbCh(campus)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addtime.getTime())); }
                if (modifiedFields.contains("Addperson")) { pstmt.setString(pi ++, toDbCh(addperson)); }
                if (modifiedFields.contains("ModifyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modifyTime.getTime())); }
                if (modifiedFields.contains("ModifyPerson")) { pstmt.setString(pi ++, toDbCh(modifyPerson)); }
                if (modifiedFields.contains("Honor")) { pstmt.setString(pi ++, toDbCh(honor)); }
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
        map.put("ActivityName", getActivityName());
        map.put("ActivitykindType", getActivitykindType());
        map.put("OrgacadeMy", getOrgacadeMy());
        map.put("ActivityLevel", getActivityLevel());
        map.put("TotalRounds", getTotalRounds());
        map.put("ActivityDate1", getActivityDate1());
        map.put("ActivityPlace1", getActivityPlace1());
        map.put("ActivityDate2", getActivityDate2());
        map.put("ActivityPlace2", getActivityPlace2());
        map.put("ActivityDate3", getActivityDate3());
        map.put("ActivityPlace3", getActivityPlace3());
        map.put("Deadline", getDeadline());
        map.put("PersonNumber", getPersonNumber());
        map.put("ActivityPrincipal", getActivityPrincipal());
        map.put("Contact", getContact());
        map.put("ActivityExplain", getActivityExplain());
        map.put("ApplicationRange", getApplicationRange());
        map.put("Campus", getCampus());
        map.put("Academy", getAcademy());
        map.put("Addtime", Tool.stringOfDateTime(getAddtime()));
        map.put("Addperson", getAddperson());
        map.put("ModifyTime", Tool.stringOfDateTime(getModifyTime()));
        map.put("ModifyPerson", getModifyPerson());
        map.put("Honor", getHonor());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("ActivityName:\"" + Tool.jsSpecialChars(getActivityName()) + "\"");
        row.add("ActivitykindType:\"" + Tool.jsSpecialChars(getActivitykindType()) + "\"");
        row.add("OrgacadeMy:\"" + Tool.jsSpecialChars(getOrgacadeMy()) + "\"");
        row.add("ActivityLevel:\"" + Tool.jsSpecialChars(getActivityLevel()) + "\"");
        row.add("TotalRounds:\"" + Tool.jsSpecialChars(getTotalRounds()) + "\"");
        row.add("ActivityDate1:\"" + Tool.jsSpecialChars(getActivityDate1()) + "\"");
        row.add("ActivityPlace1:\"" + Tool.jsSpecialChars(getActivityPlace1()) + "\"");
        row.add("ActivityDate2:\"" + Tool.jsSpecialChars(getActivityDate2()) + "\"");
        row.add("ActivityPlace2:\"" + Tool.jsSpecialChars(getActivityPlace2()) + "\"");
        row.add("ActivityDate3:\"" + Tool.jsSpecialChars(getActivityDate3()) + "\"");
        row.add("ActivityPlace3:\"" + Tool.jsSpecialChars(getActivityPlace3()) + "\"");
        row.add("Deadline:\"" + Tool.jsSpecialChars(getDeadline()) + "\"");
        row.add("PersonNumber:\"" + Tool.jsSpecialChars(getPersonNumber()) + "\"");
        row.add("ActivityPrincipal:\"" + Tool.jsSpecialChars(getActivityPrincipal()) + "\"");
        row.add("Contact:\"" + Tool.jsSpecialChars(getContact()) + "\"");
        row.add("ActivityExplain:\"" + Tool.jsSpecialChars(getActivityExplain()) + "\"");
        row.add("ApplicationRange:\"" + Tool.jsSpecialChars(getApplicationRange()) + "\"");
        row.add("Campus:\"" + Tool.jsSpecialChars(getCampus()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("Addtime:\"" + Tool.stringOfDateTime(getAddtime()) + "\"");
        row.add("Addperson:\"" + Tool.jsSpecialChars(getAddperson()) + "\"");
        row.add("ModifyTime:\"" + Tool.stringOfDateTime(getModifyTime()) + "\"");
        row.add("ModifyPerson:\"" + Tool.jsSpecialChars(getModifyPerson()) + "\"");
        row.add("Honor:\"" + Tool.jsSpecialChars(getHonor()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,activityname varchar2(100),activitykindtype varchar2(45),orgacademy varchar2(100),activitylevel varchar2(45),totalrounds varchar2(45),activitydate1 varchar2(10),activityplace1 varchar2(200),activitydate2 varchar2(10),activityplace2 varchar2(200),activitydate3 varchar2(10),activityplace3 varchar2(200),deadline varchar2(10),personnumber varchar2(10),activityprincipal varchar2(50),contact varchar2(20),activityexplain varchar2(2000),applicationrange varchar2(200),campus varchar2(100),academy varchar2(1000),addtime date,addperson varchar2(45),modifytime date,modifyperson varchar2(45),honor varchar2(500))"});
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
        CampusActivity v = new CampusActivity(sourceDb, sourceTb);
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
        CampusActivity v = new CampusActivity(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(CampusActivity obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getActivityName().compareTo(obj.getActivityName()); if (rtn != 0) return rtn;
        rtn = getActivitykindType().compareTo(obj.getActivitykindType()); if (rtn != 0) return rtn;
        rtn = getOrgacadeMy().compareTo(obj.getOrgacadeMy()); if (rtn != 0) return rtn;
        rtn = getActivityLevel().compareTo(obj.getActivityLevel()); if (rtn != 0) return rtn;
        rtn = getTotalRounds().compareTo(obj.getTotalRounds()); if (rtn != 0) return rtn;
        rtn = getActivityDate1().compareTo(obj.getActivityDate1()); if (rtn != 0) return rtn;
        rtn = getActivityPlace1().compareTo(obj.getActivityPlace1()); if (rtn != 0) return rtn;
        rtn = getActivityDate2().compareTo(obj.getActivityDate2()); if (rtn != 0) return rtn;
        rtn = getActivityPlace2().compareTo(obj.getActivityPlace2()); if (rtn != 0) return rtn;
        rtn = getActivityDate3().compareTo(obj.getActivityDate3()); if (rtn != 0) return rtn;
        rtn = getActivityPlace3().compareTo(obj.getActivityPlace3()); if (rtn != 0) return rtn;
        rtn = getDeadline().compareTo(obj.getDeadline()); if (rtn != 0) return rtn;
        rtn = getPersonNumber().compareTo(obj.getPersonNumber()); if (rtn != 0) return rtn;
        rtn = getActivityPrincipal().compareTo(obj.getActivityPrincipal()); if (rtn != 0) return rtn;
        rtn = getContact().compareTo(obj.getContact()); if (rtn != 0) return rtn;
        rtn = getActivityExplain().compareTo(obj.getActivityExplain()); if (rtn != 0) return rtn;
        rtn = getApplicationRange().compareTo(obj.getApplicationRange()); if (rtn != 0) return rtn;
        rtn = getCampus().compareTo(obj.getCampus()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getAddtime().compareTo(obj.getAddtime()); if (rtn != 0) return rtn;
        rtn = getAddperson().compareTo(obj.getAddperson()); if (rtn != 0) return rtn;
        rtn = getModifyTime().compareTo(obj.getModifyTime()); if (rtn != 0) return rtn;
        rtn = getModifyPerson().compareTo(obj.getModifyPerson()); if (rtn != 0) return rtn;
        rtn = getHonor().compareTo(obj.getHonor()); if (rtn != 0) return rtn;
        return rtn;
    }
}
