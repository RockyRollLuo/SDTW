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
@Description("志愿活动")
public class VolunteerActivity implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(VolunteerActivity.class);
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
    public static final String DbTableName = "volunteer_activity";
    private String TNAME = "volunteer_activity";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","addFilelist","activityname","activityKind","activityLevel","activityPrincipal","activityPlace","endtime","starttime","deadline","personNumber","contact","guideTeacher","activityExplain","applicationRangeType","applicationRange","launchAcademy","honourList","checkFlag","addtime","addAccount","modifyTime","modifyAccount","checkTime","checkAccount","academy","settop"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","addfilelist","activityname","activitykind","activitylevel","activityprincipal","activityplace","endtime","starttime","deadline","personnumber","contact","guideteacher","activityexplain","applicationrangetype","applicationrange","launchacademy","honourlist","checkflag","addtime","addaccount","modifytime","modifyaccount","checktime","checkaccount","academy","settop"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"AddFilelist","addfilelist","String"},{"Activityname","activityname","String"},{"ActivityKind","activitykind","String"},{"ActivityLevel","activitylevel","String"},{"ActivityPrincipal","activityprincipal","String"},{"ActivityPlace","activityplace","String"},{"Endtime","endtime","java.util.Date"},{"Starttime","starttime","java.util.Date"},{"Deadline","deadline","java.util.Date"},{"PersonNumber","personnumber","int"},{"Contact","contact","String"},{"GuideTeacher","guideteacher","String"},{"ActivityExplain","activityexplain","String"},{"ApplicationRangeType","applicationrangetype","String"},{"ApplicationRange","applicationrange","String"},{"LaunchAcademy","launchacademy","String"},{"HonourList","honourlist","String"},{"CheckFlag","checkflag","int"},{"Addtime","addtime","java.util.Date"},{"AddAccount","addaccount","String"},{"ModifyTime","modifytime","java.util.Date"},{"ModifyAccount","modifyaccount","String"},{"CheckTime","checktime","java.util.Date"},{"CheckAccount","checkaccount","String"},{"Academy","academy","String"},{"Settop","settop","int"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"addFilelist","addfilelist"},{"activityname","activityname"},{"activityKind","activitykind"},{"activityLevel","activitylevel"},{"activityPrincipal","activityprincipal"},{"activityPlace","activityplace"},{"endtime","endtime"},{"starttime","starttime"},{"deadline","deadline"},{"personNumber","personnumber"},{"contact","contact"},{"guideTeacher","guideteacher"},{"activityExplain","activityexplain"},{"applicationRangeType","applicationrangetype"},{"applicationRange","applicationrange"},{"launchAcademy","launchacademy"},{"honourList","honourlist"},{"checkFlag","checkflag"},{"addtime","addtime"},{"addAccount","addaccount"},{"modifyTime","modifytime"},{"modifyAccount","modifyaccount"},{"checkTime","checktime"},{"checkAccount","checkaccount"},{"academy","academy"},{"settop","settop"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ENDTIME","STARTTIME","DEADLINE","ADDTIME","MODIFYTIME","CHECKTIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 上传文件列表
    protected String addFilelist = "";
    public String getAddFilelist() {  return SqlTool.getDbString(addFilelist);  }
    public String getAddFilelist(int size) { return SqlTool.subString(getAddFilelist(), size); }
    public void setAddFilelist(String aAddFilelist) { addFilelist = aAddFilelist; modifiedFields.add("AddFilelist"); }
    public void assignAddFilelist(String aAddFilelist) { addFilelist = aAddFilelist; }
    public void paramAddFilelist(HttpServletRequest request) { paramAddFilelist(request, "AddFilelist"); }
    public void paramAddFilelist(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddFilelist()); if (!tmp.equals(getAddFilelist())) { setAddFilelist(tmp); } }
    // 活动名称
    protected String activityname = "";
    public String getActivityname() {  return SqlTool.getDbString(activityname);  }
    public String getActivityname(int size) { return SqlTool.subString(getActivityname(), size); }
    public void setActivityname(String aActivityname) { activityname = aActivityname; modifiedFields.add("Activityname"); refreshFlag = true; }
    public void assignActivityname(String aActivityname) { activityname = aActivityname; }
    public void paramActivityname(HttpServletRequest request) { paramActivityname(request, "Activityname"); }
    public void paramActivityname(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityname()); if (!tmp.equals(getActivityname())) { setActivityname(tmp); } }
    // 活动类别
    protected String activityKind = "";
    public String getActivityKind() {  return SqlTool.getDbString(activityKind);  }
    public String getActivityKind(int size) { return SqlTool.subString(getActivityKind(), size); }
    public void setActivityKind(String aActivityKind) { activityKind = aActivityKind; modifiedFields.add("ActivityKind"); }
    public void assignActivityKind(String aActivityKind) { activityKind = aActivityKind; }
    public void paramActivityKind(HttpServletRequest request) { paramActivityKind(request, "ActivityKind"); }
    public void paramActivityKind(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityKind()); if (!tmp.equals(getActivityKind())) { setActivityKind(tmp); } }
    // 活动级别
    protected String activityLevel = "";
    public String getActivityLevel() {  return SqlTool.getDbString(activityLevel);  }
    public String getActivityLevel(int size) { return SqlTool.subString(getActivityLevel(), size); }
    public void setActivityLevel(String aActivityLevel) { activityLevel = aActivityLevel; modifiedFields.add("ActivityLevel"); }
    public void assignActivityLevel(String aActivityLevel) { activityLevel = aActivityLevel; }
    public void paramActivityLevel(HttpServletRequest request) { paramActivityLevel(request, "ActivityLevel"); }
    public void paramActivityLevel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityLevel()); if (!tmp.equals(getActivityLevel())) { setActivityLevel(tmp); } }
    // 负责人
    protected String activityPrincipal = "";
    public String getActivityPrincipal() {  return SqlTool.getDbString(activityPrincipal);  }
    public String getActivityPrincipal(int size) { return SqlTool.subString(getActivityPrincipal(), size); }
    public void setActivityPrincipal(String aActivityPrincipal) { activityPrincipal = aActivityPrincipal; modifiedFields.add("ActivityPrincipal"); }
    public void assignActivityPrincipal(String aActivityPrincipal) { activityPrincipal = aActivityPrincipal; }
    public void paramActivityPrincipal(HttpServletRequest request) { paramActivityPrincipal(request, "ActivityPrincipal"); }
    public void paramActivityPrincipal(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityPrincipal()); if (!tmp.equals(getActivityPrincipal())) { setActivityPrincipal(tmp); } }
    // 活动地点
    protected String activityPlace = "";
    public String getActivityPlace() {  return SqlTool.getDbString(activityPlace);  }
    public String getActivityPlace(int size) { return SqlTool.subString(getActivityPlace(), size); }
    public void setActivityPlace(String aActivityPlace) { activityPlace = aActivityPlace; modifiedFields.add("ActivityPlace"); }
    public void assignActivityPlace(String aActivityPlace) { activityPlace = aActivityPlace; }
    public void paramActivityPlace(HttpServletRequest request) { paramActivityPlace(request, "ActivityPlace"); }
    public void paramActivityPlace(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityPlace()); if (!tmp.equals(getActivityPlace())) { setActivityPlace(tmp); } }
    // 活动结束日期
    protected java.util.Date endtime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getEndtime() { return endtime; }
    public void setEndtime(java.util.Date aEndtime) { endtime = aEndtime; modifiedFields.add("Endtime"); }
    public void assignEndtime(java.util.Date aEndtime) { endtime = aEndtime; }
    public void paramEndtime(HttpServletRequest request) { paramEndtime(request, "Endtime"); }
    public void paramEndtime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getEndtime()); if (tmp.compareTo(getEndtime()) != 0) { setEndtime(tmp); } }
    // 活动开始日期
    protected java.util.Date starttime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getStarttime() { return starttime; }
    public void setStarttime(java.util.Date aStarttime) { starttime = aStarttime; modifiedFields.add("Starttime"); }
    public void assignStarttime(java.util.Date aStarttime) { starttime = aStarttime; }
    public void paramStarttime(HttpServletRequest request) { paramStarttime(request, "Starttime"); }
    public void paramStarttime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getStarttime()); if (tmp.compareTo(getStarttime()) != 0) { setStarttime(tmp); } }
    // 报名截止日期
    protected java.util.Date deadline = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getDeadline() { return deadline; }
    public void setDeadline(java.util.Date aDeadline) { deadline = aDeadline; modifiedFields.add("Deadline"); }
    public void assignDeadline(java.util.Date aDeadline) { deadline = aDeadline; }
    public void paramDeadline(HttpServletRequest request) { paramDeadline(request, "Deadline"); }
    public void paramDeadline(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getDeadline()); if (tmp.compareTo(getDeadline()) != 0) { setDeadline(tmp); } }
    // 所需人数
    protected int personNumber = -1;
    public int getPersonNumber() { return personNumber; }
    public void setPersonNumber(int aPersonNumber) { personNumber = aPersonNumber; modifiedFields.add("PersonNumber"); }
    public void assignPersonNumber(int aPersonNumber) { personNumber = aPersonNumber; }
    public void paramPersonNumber(HttpServletRequest request) { paramPersonNumber(request, "PersonNumber"); }
    public void paramPersonNumber(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getPersonNumber()); if (tmp != getPersonNumber()) { setPersonNumber(tmp); } }
    // 联系方式
    protected String contact = "";
    public String getContact() {  return SqlTool.getDbString(contact);  }
    public String getContact(int size) { return SqlTool.subString(getContact(), size); }
    public void setContact(String aContact) { contact = aContact; modifiedFields.add("Contact"); }
    public void assignContact(String aContact) { contact = aContact; }
    public void paramContact(HttpServletRequest request) { paramContact(request, "Contact"); }
    public void paramContact(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getContact()); if (!tmp.equals(getContact())) { setContact(tmp); } }
    // 指导教师
    protected String guideTeacher = "";
    public String getGuideTeacher() {  return SqlTool.getDbString(guideTeacher);  }
    public String getGuideTeacher(int size) { return SqlTool.subString(getGuideTeacher(), size); }
    public void setGuideTeacher(String aGuideTeacher) { guideTeacher = aGuideTeacher; modifiedFields.add("GuideTeacher"); }
    public void assignGuideTeacher(String aGuideTeacher) { guideTeacher = aGuideTeacher; }
    public void paramGuideTeacher(HttpServletRequest request) { paramGuideTeacher(request, "GuideTeacher"); }
    public void paramGuideTeacher(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGuideTeacher()); if (!tmp.equals(getGuideTeacher())) { setGuideTeacher(tmp); } }
    // 详细信息
    protected String activityExplain = "";
    public String getActivityExplain() {  return SqlTool.getDbString(activityExplain);  }
    public String getActivityExplain(int size) { return SqlTool.subString(getActivityExplain(), size); }
    public void setActivityExplain(String aActivityExplain) { activityExplain = aActivityExplain; modifiedFields.add("ActivityExplain"); }
    public void assignActivityExplain(String aActivityExplain) { activityExplain = aActivityExplain; }
    public void paramActivityExplain(HttpServletRequest request) { paramActivityExplain(request, "ActivityExplain"); }
    public void paramActivityExplain(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityExplain()); if (!tmp.equals(getActivityExplain())) { setActivityExplain(tmp); } }
    // 申请范围分类
    protected String applicationRangeType = "";
    public String getApplicationRangeType() {  return SqlTool.getDbString(applicationRangeType);  }
    public String getApplicationRangeType(int size) { return SqlTool.subString(getApplicationRangeType(), size); }
    public void setApplicationRangeType(String aApplicationRangeType) { applicationRangeType = aApplicationRangeType; modifiedFields.add("ApplicationRangeType"); }
    public void assignApplicationRangeType(String aApplicationRangeType) { applicationRangeType = aApplicationRangeType; }
    public void paramApplicationRangeType(HttpServletRequest request) { paramApplicationRangeType(request, "ApplicationRangeType"); }
    public void paramApplicationRangeType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getApplicationRangeType()); if (!tmp.equals(getApplicationRangeType())) { setApplicationRangeType(tmp); } }
    // 申请范围
    protected String applicationRange = "";
    public String getApplicationRange() {  return SqlTool.getDbString(applicationRange);  }
    public String getApplicationRange(int size) { return SqlTool.subString(getApplicationRange(), size); }
    public void setApplicationRange(String aApplicationRange) { applicationRange = aApplicationRange; modifiedFields.add("ApplicationRange"); }
    public void assignApplicationRange(String aApplicationRange) { applicationRange = aApplicationRange; }
    public void paramApplicationRange(HttpServletRequest request) { paramApplicationRange(request, "ApplicationRange"); }
    public void paramApplicationRange(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getApplicationRange()); if (!tmp.equals(getApplicationRange())) { setApplicationRange(tmp); } }
    // 申办单位
    protected String launchAcademy = "";
    public String getLaunchAcademy() {  return SqlTool.getDbString(launchAcademy);  }
    public String getLaunchAcademy(int size) { return SqlTool.subString(getLaunchAcademy(), size); }
    public void setLaunchAcademy(String aLaunchAcademy) { launchAcademy = aLaunchAcademy; modifiedFields.add("LaunchAcademy"); }
    public void assignLaunchAcademy(String aLaunchAcademy) { launchAcademy = aLaunchAcademy; }
    public void paramLaunchAcademy(HttpServletRequest request) { paramLaunchAcademy(request, "LaunchAcademy"); }
    public void paramLaunchAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getLaunchAcademy()); if (!tmp.equals(getLaunchAcademy())) { setLaunchAcademy(tmp); } }
    // 荣誉列表
    protected String honourList = "";
    public String getHonourList() {  return SqlTool.getDbString(honourList);  }
    public String getHonourList(int size) { return SqlTool.subString(getHonourList(), size); }
    public void setHonourList(String aHonourList) { honourList = aHonourList; modifiedFields.add("HonourList"); }
    public void assignHonourList(String aHonourList) { honourList = aHonourList; }
    public void paramHonourList(HttpServletRequest request) { paramHonourList(request, "HonourList"); }
    public void paramHonourList(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHonourList()); if (!tmp.equals(getHonourList())) { setHonourList(tmp); } }
    // 审核标志
    protected int checkFlag = -1;
    public int getCheckFlag() { return checkFlag; }
    public void setCheckFlag(int aCheckFlag) { checkFlag = aCheckFlag; modifiedFields.add("CheckFlag"); }
    public void assignCheckFlag(int aCheckFlag) { checkFlag = aCheckFlag; }
    public void paramCheckFlag(HttpServletRequest request) { paramCheckFlag(request, "CheckFlag"); }
    public void paramCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckFlag()); if (tmp != getCheckFlag()) { setCheckFlag(tmp); } }
    // 添加时间
    protected java.util.Date addtime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddtime() { return addtime; }
    public void setAddtime(java.util.Date aAddtime) { addtime = aAddtime; modifiedFields.add("Addtime"); }
    public void assignAddtime(java.util.Date aAddtime) { addtime = aAddtime; }
    public void paramAddtime(HttpServletRequest request) { paramAddtime(request, "Addtime"); }
    public void paramAddtime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddtime()); if (tmp.compareTo(getAddtime()) != 0) { setAddtime(tmp); } }
    // 添加账号
    protected String addAccount = "";
    public String getAddAccount() {  return SqlTool.getDbString(addAccount);  }
    public String getAddAccount(int size) { return SqlTool.subString(getAddAccount(), size); }
    public void setAddAccount(String aAddAccount) { addAccount = aAddAccount; modifiedFields.add("AddAccount"); }
    public void assignAddAccount(String aAddAccount) { addAccount = aAddAccount; }
    public void paramAddAccount(HttpServletRequest request) { paramAddAccount(request, "AddAccount"); }
    public void paramAddAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddAccount()); if (!tmp.equals(getAddAccount())) { setAddAccount(tmp); } }
    // 修改时间
    protected java.util.Date modifyTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getModifyTime() { return modifyTime; }
    public void setModifyTime(java.util.Date aModifyTime) { modifyTime = aModifyTime; modifiedFields.add("ModifyTime"); }
    public void assignModifyTime(java.util.Date aModifyTime) { modifyTime = aModifyTime; }
    public void paramModifyTime(HttpServletRequest request) { paramModifyTime(request, "ModifyTime"); }
    public void paramModifyTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getModifyTime()); if (tmp.compareTo(getModifyTime()) != 0) { setModifyTime(tmp); } }
    // 修改账号
    protected String modifyAccount = "";
    public String getModifyAccount() {  return SqlTool.getDbString(modifyAccount);  }
    public String getModifyAccount(int size) { return SqlTool.subString(getModifyAccount(), size); }
    public void setModifyAccount(String aModifyAccount) { modifyAccount = aModifyAccount; modifiedFields.add("ModifyAccount"); }
    public void assignModifyAccount(String aModifyAccount) { modifyAccount = aModifyAccount; }
    public void paramModifyAccount(HttpServletRequest request) { paramModifyAccount(request, "ModifyAccount"); }
    public void paramModifyAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getModifyAccount()); if (!tmp.equals(getModifyAccount())) { setModifyAccount(tmp); } }
    // 审核时间
    protected java.util.Date checkTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getCheckTime() { return checkTime; }
    public void setCheckTime(java.util.Date aCheckTime) { checkTime = aCheckTime; modifiedFields.add("CheckTime"); }
    public void assignCheckTime(java.util.Date aCheckTime) { checkTime = aCheckTime; }
    public void paramCheckTime(HttpServletRequest request) { paramCheckTime(request, "CheckTime"); }
    public void paramCheckTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getCheckTime()); if (tmp.compareTo(getCheckTime()) != 0) { setCheckTime(tmp); } }
    // 审核账号
    protected String checkAccount = "";
    public String getCheckAccount() {  return SqlTool.getDbString(checkAccount);  }
    public String getCheckAccount(int size) { return SqlTool.subString(getCheckAccount(), size); }
    public void setCheckAccount(String aCheckAccount) { checkAccount = aCheckAccount; modifiedFields.add("CheckAccount"); }
    public void assignCheckAccount(String aCheckAccount) { checkAccount = aCheckAccount; }
    public void paramCheckAccount(HttpServletRequest request) { paramCheckAccount(request, "CheckAccount"); }
    public void paramCheckAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCheckAccount()); if (!tmp.equals(getCheckAccount())) { setCheckAccount(tmp); } }
    // 所属学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 置顶标志
    protected int settop = -1;
    public int getSettop() { return settop; }
    public void setSettop(int aSettop) { settop = aSettop; modifiedFields.add("Settop"); }
    public void assignSettop(int aSettop) { settop = aSettop; }
    public void paramSettop(HttpServletRequest request) { paramSettop(request, "Settop"); }
    public void paramSettop(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getSettop()); if (tmp != getSettop()) { setSettop(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public VolunteerActivity (String db) {
        DBNAME = db;
    }
    public VolunteerActivity (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public VolunteerActivity (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public VolunteerActivity () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return VolunteerActivity类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public VolunteerActivity getByParameter(HttpServletRequest request) {
        VolunteerActivity v = new VolunteerActivity(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramAddFilelist(request);
        paramActivityname(request);
        paramActivityKind(request);
        paramActivityLevel(request);
        paramActivityPrincipal(request);
        paramActivityPlace(request);
        paramEndtime(request);
        paramStarttime(request);
        paramDeadline(request);
        paramPersonNumber(request);
        paramContact(request);
        paramGuideTeacher(request);
        paramActivityExplain(request);
        paramApplicationRangeType(request);
        paramApplicationRange(request);
        paramLaunchAcademy(request);
        paramHonourList(request);
        paramCheckFlag(request);
        paramAddtime(request);
        paramAddAccount(request);
        paramModifyTime(request);
        paramModifyAccount(request);
        paramCheckTime(request);
        paramCheckAccount(request);
        paramAcademy(request);
        paramSettop(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(VolunteerActivity bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("addFilelist")) { setAddFilelist(bean.getAddFilelist()); }
        if (!ncl.contains("activityname")) { setActivityname(bean.getActivityname()); }
        if (!ncl.contains("activityKind")) { setActivityKind(bean.getActivityKind()); }
        if (!ncl.contains("activityLevel")) { setActivityLevel(bean.getActivityLevel()); }
        if (!ncl.contains("activityPrincipal")) { setActivityPrincipal(bean.getActivityPrincipal()); }
        if (!ncl.contains("activityPlace")) { setActivityPlace(bean.getActivityPlace()); }
        if (!ncl.contains("endtime")) { setEndtime(bean.getEndtime()); }
        if (!ncl.contains("starttime")) { setStarttime(bean.getStarttime()); }
        if (!ncl.contains("deadline")) { setDeadline(bean.getDeadline()); }
        if (!ncl.contains("personNumber")) { setPersonNumber(bean.getPersonNumber()); }
        if (!ncl.contains("contact")) { setContact(bean.getContact()); }
        if (!ncl.contains("guideTeacher")) { setGuideTeacher(bean.getGuideTeacher()); }
        if (!ncl.contains("activityExplain")) { setActivityExplain(bean.getActivityExplain()); }
        if (!ncl.contains("applicationRangeType")) { setApplicationRangeType(bean.getApplicationRangeType()); }
        if (!ncl.contains("applicationRange")) { setApplicationRange(bean.getApplicationRange()); }
        if (!ncl.contains("launchAcademy")) { setLaunchAcademy(bean.getLaunchAcademy()); }
        if (!ncl.contains("honourList")) { setHonourList(bean.getHonourList()); }
        if (!ncl.contains("checkFlag")) { setCheckFlag(bean.getCheckFlag()); }
        if (!ncl.contains("addtime")) { setAddtime(bean.getAddtime()); }
        if (!ncl.contains("addAccount")) { setAddAccount(bean.getAddAccount()); }
        if (!ncl.contains("modifyTime")) { setModifyTime(bean.getModifyTime()); }
        if (!ncl.contains("modifyAccount")) { setModifyAccount(bean.getModifyAccount()); }
        if (!ncl.contains("checkTime")) { setCheckTime(bean.getCheckTime()); }
        if (!ncl.contains("checkAccount")) { setCheckAccount(bean.getCheckAccount()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("settop")) { setSettop(bean.getSettop()); }
    }
    public VolunteerActivity getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        VolunteerActivity[] rslt= queryByCondition(cdt);
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
     * @return VolunteerActivity类的实例列表。
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
                VolunteerActivity ve = new VolunteerActivity(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignAddFilelist(fromDbCh(rs.getString(2)));
                ve.assignActivityname(fromDbCh(rs.getString(3)));
                ve.assignActivityKind(fromDbCh(rs.getString(4)));
                ve.assignActivityLevel(fromDbCh(rs.getString(5)));
                ve.assignActivityPrincipal(fromDbCh(rs.getString(6)));
                ve.assignActivityPlace(fromDbCh(rs.getString(7)));
                tmpDate = rs.getTimestamp(8); if (tmpDate != null) { ve.assignEndtime(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(9); if (tmpDate != null) { ve.assignStarttime(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(10); if (tmpDate != null) { ve.assignDeadline(new java.util.Date(tmpDate.getTime())); }
                ve.assignPersonNumber(rs.getInt(11));
                ve.assignContact(fromDbCh(rs.getString(12)));
                ve.assignGuideTeacher(fromDbCh(rs.getString(13)));
                ve.assignActivityExplain(fromDbCh(rs.getString(14)));
                ve.assignApplicationRangeType(fromDbCh(rs.getString(15)));
                ve.assignApplicationRange(fromDbCh(rs.getString(16)));
                ve.assignLaunchAcademy(fromDbCh(rs.getString(17)));
                ve.assignHonourList(fromDbCh(rs.getString(18)));
                ve.assignCheckFlag(rs.getInt(19));
                tmpDate = rs.getTimestamp(20); if (tmpDate != null) { ve.assignAddtime(new java.util.Date(tmpDate.getTime())); }
                ve.assignAddAccount(fromDbCh(rs.getString(21)));
                tmpDate = rs.getTimestamp(22); if (tmpDate != null) { ve.assignModifyTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignModifyAccount(fromDbCh(rs.getString(23)));
                tmpDate = rs.getTimestamp(24); if (tmpDate != null) { ve.assignCheckTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignCheckAccount(fromDbCh(rs.getString(25)));
                ve.assignAcademy(fromDbCh(rs.getString(26)));
                ve.assignSettop(rs.getInt(27));
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
    public VolunteerActivity[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (VolunteerActivity[])vrs.toArray(new VolunteerActivity[vrs.size()]);
    }
    public VolunteerActivity[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (VolunteerActivity[])vrs.toArray(new VolunteerActivity[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (addfilelist,activityname,activitykind,activitylevel,activityprincipal,activityplace,endtime,starttime,deadline,personnumber,contact,guideteacher,activityexplain,applicationrangetype,applicationrange,launchacademy,honourlist,checkflag,addtime,addaccount,modifytime,modifyaccount,checktime,checkaccount,academy,settop) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(addFilelist));
            pstmt.setString(2, toDbCh(activityname));
            pstmt.setString(3, toDbCh(activityKind));
            pstmt.setString(4, toDbCh(activityLevel));
            pstmt.setString(5, toDbCh(activityPrincipal));
            pstmt.setString(6, toDbCh(activityPlace));
            pstmt.setTimestamp(7, new java.sql.Timestamp(endtime.getTime()));
            pstmt.setTimestamp(8, new java.sql.Timestamp(starttime.getTime()));
            pstmt.setTimestamp(9, new java.sql.Timestamp(deadline.getTime()));
            pstmt.setInt(10, personNumber);
            pstmt.setString(11, toDbCh(contact));
            pstmt.setString(12, toDbCh(guideTeacher));
            pstmt.setString(13, toDbCh(activityExplain));
            pstmt.setString(14, toDbCh(applicationRangeType));
            pstmt.setString(15, toDbCh(applicationRange));
            pstmt.setString(16, toDbCh(launchAcademy));
            pstmt.setString(17, toDbCh(honourList));
            pstmt.setInt(18, checkFlag);
            pstmt.setTimestamp(19, new java.sql.Timestamp(addtime.getTime()));
            pstmt.setString(20, toDbCh(addAccount));
            pstmt.setTimestamp(21, new java.sql.Timestamp(modifyTime.getTime()));
            pstmt.setString(22, toDbCh(modifyAccount));
            pstmt.setTimestamp(23, new java.sql.Timestamp(checkTime.getTime()));
            pstmt.setString(24, toDbCh(checkAccount));
            pstmt.setString(25, toDbCh(academy));
            pstmt.setInt(26, settop);
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.VolunteerActivity");
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,addfilelist,activityname,activitykind,activitylevel,activityprincipal,activityplace,endtime,starttime,deadline,personnumber,contact,guideteacher,activityexplain,applicationrangetype,applicationrange,launchacademy,honourlist,checkflag,addtime,addaccount,modifytime,modifyaccount,checktime,checkaccount,academy,settop) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(addFilelist));
            pstmt.setString(3, toDbCh(activityname));
            pstmt.setString(4, toDbCh(activityKind));
            pstmt.setString(5, toDbCh(activityLevel));
            pstmt.setString(6, toDbCh(activityPrincipal));
            pstmt.setString(7, toDbCh(activityPlace));
            pstmt.setTimestamp(8, new java.sql.Timestamp(endtime.getTime()));
            pstmt.setTimestamp(9, new java.sql.Timestamp(starttime.getTime()));
            pstmt.setTimestamp(10, new java.sql.Timestamp(deadline.getTime()));
            pstmt.setInt(11, personNumber);
            pstmt.setString(12, toDbCh(contact));
            pstmt.setString(13, toDbCh(guideTeacher));
            pstmt.setString(14, toDbCh(activityExplain));
            pstmt.setString(15, toDbCh(applicationRangeType));
            pstmt.setString(16, toDbCh(applicationRange));
            pstmt.setString(17, toDbCh(launchAcademy));
            pstmt.setString(18, toDbCh(honourList));
            pstmt.setInt(19, checkFlag);
            pstmt.setTimestamp(20, new java.sql.Timestamp(addtime.getTime()));
            pstmt.setString(21, toDbCh(addAccount));
            pstmt.setTimestamp(22, new java.sql.Timestamp(modifyTime.getTime()));
            pstmt.setString(23, toDbCh(modifyAccount));
            pstmt.setTimestamp(24, new java.sql.Timestamp(checkTime.getTime()));
            pstmt.setString(25, toDbCh(checkAccount));
            pstmt.setString(26, toDbCh(academy));
            pstmt.setInt(27, settop);
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.VolunteerActivity");
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
            VolunteerActivity item = (VolunteerActivity)it.next();
            VolunteerActivity v = new VolunteerActivity(dbname);
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
                if (modifiedFields.contains("AddFilelist")) { pstmt.setString(pi ++, toDbCh(addFilelist)); }
                if (modifiedFields.contains("Activityname")) { pstmt.setString(pi ++, toDbCh(activityname)); }
                if (modifiedFields.contains("ActivityKind")) { pstmt.setString(pi ++, toDbCh(activityKind)); }
                if (modifiedFields.contains("ActivityLevel")) { pstmt.setString(pi ++, toDbCh(activityLevel)); }
                if (modifiedFields.contains("ActivityPrincipal")) { pstmt.setString(pi ++, toDbCh(activityPrincipal)); }
                if (modifiedFields.contains("ActivityPlace")) { pstmt.setString(pi ++, toDbCh(activityPlace)); }
                if (modifiedFields.contains("Endtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(endtime.getTime())); }
                if (modifiedFields.contains("Starttime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(starttime.getTime())); }
                if (modifiedFields.contains("Deadline")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(deadline.getTime())); }
                if (modifiedFields.contains("PersonNumber")) { pstmt.setInt(pi ++, personNumber); }
                if (modifiedFields.contains("Contact")) { pstmt.setString(pi ++, toDbCh(contact)); }
                if (modifiedFields.contains("GuideTeacher")) { pstmt.setString(pi ++, toDbCh(guideTeacher)); }
                if (modifiedFields.contains("ActivityExplain")) { pstmt.setString(pi ++, toDbCh(activityExplain)); }
                if (modifiedFields.contains("ApplicationRangeType")) { pstmt.setString(pi ++, toDbCh(applicationRangeType)); }
                if (modifiedFields.contains("ApplicationRange")) { pstmt.setString(pi ++, toDbCh(applicationRange)); }
                if (modifiedFields.contains("LaunchAcademy")) { pstmt.setString(pi ++, toDbCh(launchAcademy)); }
                if (modifiedFields.contains("HonourList")) { pstmt.setString(pi ++, toDbCh(honourList)); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("Addtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addtime.getTime())); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("ModifyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modifyTime.getTime())); }
                if (modifiedFields.contains("ModifyAccount")) { pstmt.setString(pi ++, toDbCh(modifyAccount)); }
                if (modifiedFields.contains("CheckTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(checkTime.getTime())); }
                if (modifiedFields.contains("CheckAccount")) { pstmt.setString(pi ++, toDbCh(checkAccount)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Settop")) { pstmt.setInt(pi ++, settop); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.VolunteerActivity");
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
                if (modifiedFields.contains("AddFilelist")) { pstmt.setString(pi ++, toDbCh(addFilelist)); }
                if (modifiedFields.contains("Activityname")) { pstmt.setString(pi ++, toDbCh(activityname)); }
                if (modifiedFields.contains("ActivityKind")) { pstmt.setString(pi ++, toDbCh(activityKind)); }
                if (modifiedFields.contains("ActivityLevel")) { pstmt.setString(pi ++, toDbCh(activityLevel)); }
                if (modifiedFields.contains("ActivityPrincipal")) { pstmt.setString(pi ++, toDbCh(activityPrincipal)); }
                if (modifiedFields.contains("ActivityPlace")) { pstmt.setString(pi ++, toDbCh(activityPlace)); }
                if (modifiedFields.contains("Endtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(endtime.getTime())); }
                if (modifiedFields.contains("Starttime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(starttime.getTime())); }
                if (modifiedFields.contains("Deadline")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(deadline.getTime())); }
                if (modifiedFields.contains("PersonNumber")) { pstmt.setInt(pi ++, personNumber); }
                if (modifiedFields.contains("Contact")) { pstmt.setString(pi ++, toDbCh(contact)); }
                if (modifiedFields.contains("GuideTeacher")) { pstmt.setString(pi ++, toDbCh(guideTeacher)); }
                if (modifiedFields.contains("ActivityExplain")) { pstmt.setString(pi ++, toDbCh(activityExplain)); }
                if (modifiedFields.contains("ApplicationRangeType")) { pstmt.setString(pi ++, toDbCh(applicationRangeType)); }
                if (modifiedFields.contains("ApplicationRange")) { pstmt.setString(pi ++, toDbCh(applicationRange)); }
                if (modifiedFields.contains("LaunchAcademy")) { pstmt.setString(pi ++, toDbCh(launchAcademy)); }
                if (modifiedFields.contains("HonourList")) { pstmt.setString(pi ++, toDbCh(honourList)); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("Addtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addtime.getTime())); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("ModifyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modifyTime.getTime())); }
                if (modifiedFields.contains("ModifyAccount")) { pstmt.setString(pi ++, toDbCh(modifyAccount)); }
                if (modifiedFields.contains("CheckTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(checkTime.getTime())); }
                if (modifiedFields.contains("CheckAccount")) { pstmt.setString(pi ++, toDbCh(checkAccount)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Settop")) { pstmt.setInt(pi ++, settop); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.VolunteerActivity");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.VolunteerActivity");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.VolunteerActivity");
        return iResult;
    }
    public Map toMap() {
        Map map = new HashMap();
        map.put("Id", getId() + "");
        map.put("AddFilelist", getAddFilelist());
        map.put("Activityname", getActivityname());
        map.put("ActivityKind", getActivityKind());
        map.put("ActivityLevel", getActivityLevel());
        map.put("ActivityPrincipal", getActivityPrincipal());
        map.put("ActivityPlace", getActivityPlace());
        map.put("Endtime", Tool.stringOfDateTime(getEndtime()));
        map.put("Starttime", Tool.stringOfDateTime(getStarttime()));
        map.put("Deadline", Tool.stringOfDateTime(getDeadline()));
        map.put("PersonNumber", getPersonNumber() + "");
        map.put("Contact", getContact());
        map.put("GuideTeacher", getGuideTeacher());
        map.put("ActivityExplain", getActivityExplain());
        map.put("ApplicationRangeType", getApplicationRangeType());
        map.put("ApplicationRange", getApplicationRange());
        map.put("LaunchAcademy", getLaunchAcademy());
        map.put("HonourList", getHonourList());
        map.put("CheckFlag", getCheckFlag() + "");
        map.put("Addtime", Tool.stringOfDateTime(getAddtime()));
        map.put("AddAccount", getAddAccount());
        map.put("ModifyTime", Tool.stringOfDateTime(getModifyTime()));
        map.put("ModifyAccount", getModifyAccount());
        map.put("CheckTime", Tool.stringOfDateTime(getCheckTime()));
        map.put("CheckAccount", getCheckAccount());
        map.put("Academy", getAcademy());
        map.put("Settop", getSettop() + "");
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("AddFilelist:\"" + Tool.jsSpecialChars(getAddFilelist()) + "\"");
        row.add("Activityname:\"" + Tool.jsSpecialChars(getActivityname()) + "\"");
        row.add("ActivityKind:\"" + Tool.jsSpecialChars(getActivityKind()) + "\"");
        row.add("ActivityLevel:\"" + Tool.jsSpecialChars(getActivityLevel()) + "\"");
        row.add("ActivityPrincipal:\"" + Tool.jsSpecialChars(getActivityPrincipal()) + "\"");
        row.add("ActivityPlace:\"" + Tool.jsSpecialChars(getActivityPlace()) + "\"");
        row.add("Endtime:\"" + Tool.stringOfDateTime(getEndtime()) + "\"");
        row.add("Starttime:\"" + Tool.stringOfDateTime(getStarttime()) + "\"");
        row.add("Deadline:\"" + Tool.stringOfDateTime(getDeadline()) + "\"");
        row.add("PersonNumber:\"" + getPersonNumber() + "\"");
        row.add("Contact:\"" + Tool.jsSpecialChars(getContact()) + "\"");
        row.add("GuideTeacher:\"" + Tool.jsSpecialChars(getGuideTeacher()) + "\"");
        row.add("ActivityExplain:\"" + Tool.jsSpecialChars(getActivityExplain()) + "\"");
        row.add("ApplicationRangeType:\"" + Tool.jsSpecialChars(getApplicationRangeType()) + "\"");
        row.add("ApplicationRange:\"" + Tool.jsSpecialChars(getApplicationRange()) + "\"");
        row.add("LaunchAcademy:\"" + Tool.jsSpecialChars(getLaunchAcademy()) + "\"");
        row.add("HonourList:\"" + Tool.jsSpecialChars(getHonourList()) + "\"");
        row.add("CheckFlag:\"" + getCheckFlag() + "\"");
        row.add("Addtime:\"" + Tool.stringOfDateTime(getAddtime()) + "\"");
        row.add("AddAccount:\"" + Tool.jsSpecialChars(getAddAccount()) + "\"");
        row.add("ModifyTime:\"" + Tool.stringOfDateTime(getModifyTime()) + "\"");
        row.add("ModifyAccount:\"" + Tool.jsSpecialChars(getModifyAccount()) + "\"");
        row.add("CheckTime:\"" + Tool.stringOfDateTime(getCheckTime()) + "\"");
        row.add("CheckAccount:\"" + Tool.jsSpecialChars(getCheckAccount()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("Settop:\"" + getSettop() + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,addfilelist varchar2(500),activityname varchar2(45),activitykind varchar2(45),activitylevel varchar2(45),activityprincipal varchar2(45),activityplace varchar2(45),endtime date,starttime date,deadline date,personnumber number(*,0),contact varchar2(45),guideteacher varchar2(45),activityexplain varchar2(255),applicationrangetype varchar2(45),applicationrange varchar2(255),launchacademy varchar2(45),honourlist varchar2(255),checkflag number(*,0),addtime date,addaccount varchar2(45),modifytime date,modifyaccount varchar2(45),checktime date,checkaccount varchar2(45),academy varchar2(45),settop number(*,0))"});
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
        VolunteerActivity v = new VolunteerActivity(sourceDb, sourceTb);
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
        VolunteerActivity v = new VolunteerActivity(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(VolunteerActivity obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getAddFilelist().compareTo(obj.getAddFilelist()); if (rtn != 0) return rtn;
        rtn = getActivityname().compareTo(obj.getActivityname()); if (rtn != 0) return rtn;
        rtn = getActivityKind().compareTo(obj.getActivityKind()); if (rtn != 0) return rtn;
        rtn = getActivityLevel().compareTo(obj.getActivityLevel()); if (rtn != 0) return rtn;
        rtn = getActivityPrincipal().compareTo(obj.getActivityPrincipal()); if (rtn != 0) return rtn;
        rtn = getActivityPlace().compareTo(obj.getActivityPlace()); if (rtn != 0) return rtn;
        rtn = getEndtime().compareTo(obj.getEndtime()); if (rtn != 0) return rtn;
        rtn = getStarttime().compareTo(obj.getStarttime()); if (rtn != 0) return rtn;
        rtn = getDeadline().compareTo(obj.getDeadline()); if (rtn != 0) return rtn;
        rtn = ("" + getPersonNumber()).compareTo("" + obj.getPersonNumber()); if (rtn != 0) return rtn;
        rtn = getContact().compareTo(obj.getContact()); if (rtn != 0) return rtn;
        rtn = getGuideTeacher().compareTo(obj.getGuideTeacher()); if (rtn != 0) return rtn;
        rtn = getActivityExplain().compareTo(obj.getActivityExplain()); if (rtn != 0) return rtn;
        rtn = getApplicationRangeType().compareTo(obj.getApplicationRangeType()); if (rtn != 0) return rtn;
        rtn = getApplicationRange().compareTo(obj.getApplicationRange()); if (rtn != 0) return rtn;
        rtn = getLaunchAcademy().compareTo(obj.getLaunchAcademy()); if (rtn != 0) return rtn;
        rtn = getHonourList().compareTo(obj.getHonourList()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckFlag()).compareTo("" + obj.getCheckFlag()); if (rtn != 0) return rtn;
        rtn = getAddtime().compareTo(obj.getAddtime()); if (rtn != 0) return rtn;
        rtn = getAddAccount().compareTo(obj.getAddAccount()); if (rtn != 0) return rtn;
        rtn = getModifyTime().compareTo(obj.getModifyTime()); if (rtn != 0) return rtn;
        rtn = getModifyAccount().compareTo(obj.getModifyAccount()); if (rtn != 0) return rtn;
        rtn = getCheckTime().compareTo(obj.getCheckTime()); if (rtn != 0) return rtn;
        rtn = getCheckAccount().compareTo(obj.getCheckAccount()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = ("" + getSettop()).compareTo("" + obj.getSettop()); if (rtn != 0) return rtn;
        return rtn;
    }
}
