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
@Description("社团活动信息")
public class ClubActivities implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(ClubActivities.class);
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
    public static final String DbTableName = "club_activities";
    private String TNAME = "club_activities";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","activityName","orgacadeMy","clubName","clubId","timeStart","timeEnd","activityPlace","organizer","predictNumber","isSupported","contant","contacts","contactsPhone","forecast","commentTeacher","commentAcademy","commentShelian","checkFlag","remark","addPerson","addTime","modiperson","modiTime","checkPerson","projectId","projectName","module","isatSchool","applyTime","checkTime","belongId","budgetList","budgetAmountAll","conclusionCheckFlag","conclusionApplyTime","conclusionCommentAcademy","conclusionCommentShelian","conclusionGeneral","conclusionManuscript","conclusionCommentClub","conclusionCommentcTuanwei","conclusionPlanNums","conclusionPlanNames","conclusionBroadcastNums","conclusionBroadcastNames","conclusionelseNums","conclusionelseNames","conclusionCost","conclusionIsSupport","conclusionSupportDetail","conclusionSummary","conclusionRemark","activityLevel"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","activityname","orgacademy","clubname","clubid","timestart","timeend","activityplace","organizer","predictnumber","issupported","contant","contacts","contactsphone","forecast","commentteacher","commentacademy","commentshelian","checkflag","remark","addperson","addtime","modiperson","moditime","checkperson","projectid","projectname","module","isatschool","applytime","checktime","belongid","budgetlist","budgetamountall","conclusioncheckflag","conclusionapplytime","conclusioncommentacademy","conclusioncommentshelian","conclusiongeneral","conclusionmanuscript","conclusioncommentclub","conclusioncommentctuanwei","conclusionplannums","conclusionplannames","conclusionbroadcastnums","conclusionbroadcastnames","conclusionelsenums","conclusionelsenames","conclusioncost","conclusionissupport","conclusionsupportdetail","conclusionsummary","conclusionremark","activitylevel"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"ActivityName","activityname","String"},{"OrgacadeMy","orgacademy","String"},{"ClubName","clubname","String"},{"ClubId","clubid","String"},{"TimeStart","timestart","String"},{"TimeEnd","timeend","String"},{"ActivityPlace","activityplace","String"},{"Organizer","organizer","String"},{"PredictNumber","predictnumber","String"},{"IsSupported","issupported","String"},{"Contant","contant","String"},{"Contacts","contacts","String"},{"ContactsPhone","contactsphone","String"},{"Forecast","forecast","String"},{"CommentTeacher","commentteacher","String"},{"CommentAcademy","commentacademy","String"},{"CommentShelian","commentshelian","String"},{"CheckFlag","checkflag","int"},{"Remark","remark","String"},{"AddPerson","addperson","String"},{"AddTime","addtime","java.util.Date"},{"Modiperson","modiperson","String"},{"ModiTime","moditime","java.util.Date"},{"CheckPerson","checkperson","String"},{"ProjectId","projectid","String"},{"ProjectName","projectname","String"},{"Module","module","String"},{"IsatSchool","isatschool","String"},{"ApplyTime","applytime","java.util.Date"},{"CheckTime","checktime","java.util.Date"},{"BelongId","belongid","String"},{"BudgetList","budgetlist","String"},{"BudgetAmountAll","budgetamountall","String"},{"ConclusionCheckFlag","conclusioncheckflag","int"},{"ConclusionApplyTime","conclusionapplytime","java.util.Date"},{"ConclusionCommentAcademy","conclusioncommentacademy","String"},{"ConclusionCommentShelian","conclusioncommentshelian","String"},{"ConclusionGeneral","conclusiongeneral","String"},{"ConclusionManuscript","conclusionmanuscript","String"},{"ConclusionCommentClub","conclusioncommentclub","String"},{"ConclusionCommentcTuanwei","conclusioncommentctuanwei","String"},{"ConclusionPlanNums","conclusionplannums","String"},{"ConclusionPlanNames","conclusionplannames","String"},{"ConclusionBroadcastNums","conclusionbroadcastnums","String"},{"ConclusionBroadcastNames","conclusionbroadcastnames","String"},{"ConclusionelseNums","conclusionelsenums","String"},{"ConclusionelseNames","conclusionelsenames","String"},{"ConclusionCost","conclusioncost","String"},{"ConclusionIsSupport","conclusionissupport","String"},{"ConclusionSupportDetail","conclusionsupportdetail","String"},{"ConclusionSummary","conclusionsummary","String"},{"ConclusionRemark","conclusionremark","String"},{"ActivityLevel","activitylevel","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"activityName","activityname"},{"orgacadeMy","orgacademy"},{"clubName","clubname"},{"clubId","clubid"},{"timeStart","timestart"},{"timeEnd","timeend"},{"activityPlace","activityplace"},{"organizer","organizer"},{"predictNumber","predictnumber"},{"isSupported","issupported"},{"contant","contant"},{"contacts","contacts"},{"contactsPhone","contactsphone"},{"forecast","forecast"},{"commentTeacher","commentteacher"},{"commentAcademy","commentacademy"},{"commentShelian","commentshelian"},{"checkFlag","checkflag"},{"remark","remark"},{"addPerson","addperson"},{"addTime","addtime"},{"modiperson","modiperson"},{"modiTime","moditime"},{"checkPerson","checkperson"},{"projectId","projectid"},{"projectName","projectname"},{"module","module"},{"isatSchool","isatschool"},{"applyTime","applytime"},{"checkTime","checktime"},{"belongId","belongid"},{"budgetList","budgetlist"},{"budgetAmountAll","budgetamountall"},{"conclusionCheckFlag","conclusioncheckflag"},{"conclusionApplyTime","conclusionapplytime"},{"conclusionCommentAcademy","conclusioncommentacademy"},{"conclusionCommentShelian","conclusioncommentshelian"},{"conclusionGeneral","conclusiongeneral"},{"conclusionManuscript","conclusionmanuscript"},{"conclusionCommentClub","conclusioncommentclub"},{"conclusionCommentcTuanwei","conclusioncommentctuanwei"},{"conclusionPlanNums","conclusionplannums"},{"conclusionPlanNames","conclusionplannames"},{"conclusionBroadcastNums","conclusionbroadcastnums"},{"conclusionBroadcastNames","conclusionbroadcastnames"},{"conclusionelseNums","conclusionelsenums"},{"conclusionelseNames","conclusionelsenames"},{"conclusionCost","conclusioncost"},{"conclusionIsSupport","conclusionissupport"},{"conclusionSupportDetail","conclusionsupportdetail"},{"conclusionSummary","conclusionsummary"},{"conclusionRemark","conclusionremark"},{"activityLevel","activitylevel"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME","MODITIME","APPLYTIME","CHECKTIME","CONCLUSIONAPPLYTIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 活动主题
    protected String activityName = "";
    public String getActivityName() {  return SqlTool.getDbString(activityName);  }
    public String getActivityName(int size) { return SqlTool.subString(getActivityName(), size); }
    public void setActivityName(String aActivityName) { activityName = aActivityName; modifiedFields.add("ActivityName"); }
    public void assignActivityName(String aActivityName) { activityName = aActivityName; }
    public void paramActivityName(HttpServletRequest request) { paramActivityName(request, "ActivityName"); }
    public void paramActivityName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityName()); if (!tmp.equals(getActivityName())) { setActivityName(tmp); } }
    // 组织单位
    protected String orgacadeMy = "";
    public String getOrgacadeMy() {  return SqlTool.getDbString(orgacadeMy);  }
    public String getOrgacadeMy(int size) { return SqlTool.subString(getOrgacadeMy(), size); }
    public void setOrgacadeMy(String aOrgacadeMy) { orgacadeMy = aOrgacadeMy; modifiedFields.add("OrgacadeMy"); }
    public void assignOrgacadeMy(String aOrgacadeMy) { orgacadeMy = aOrgacadeMy; }
    public void paramOrgacadeMy(HttpServletRequest request) { paramOrgacadeMy(request, "OrgacadeMy"); }
    public void paramOrgacadeMy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOrgacadeMy()); if (!tmp.equals(getOrgacadeMy())) { setOrgacadeMy(tmp); } }
    // 社团名称
    protected String clubName = "";
    public String getClubName() {  return SqlTool.getDbString(clubName);  }
    public String getClubName(int size) { return SqlTool.subString(getClubName(), size); }
    public void setClubName(String aClubName) { clubName = aClubName; modifiedFields.add("ClubName"); }
    public void assignClubName(String aClubName) { clubName = aClubName; }
    public void paramClubName(HttpServletRequest request) { paramClubName(request, "ClubName"); }
    public void paramClubName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubName()); if (!tmp.equals(getClubName())) { setClubName(tmp); } }
    // 登录账号
    protected String clubId = "";
    public String getClubId() {  return SqlTool.getDbString(clubId);  }
    public String getClubId(int size) { return SqlTool.subString(getClubId(), size); }
    public void setClubId(String aClubId) { clubId = aClubId; modifiedFields.add("ClubId"); }
    public void assignClubId(String aClubId) { clubId = aClubId; }
    public void paramClubId(HttpServletRequest request) { paramClubId(request, "ClubId"); }
    public void paramClubId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubId()); if (!tmp.equals(getClubId())) { setClubId(tmp); } }
    // 活动开始时间
    protected String timeStart = "";
    public String getTimeStart() {  return SqlTool.getDbString(timeStart);  }
    public String getTimeStart(int size) { return SqlTool.subString(getTimeStart(), size); }
    public void setTimeStart(String aTimeStart) { timeStart = aTimeStart; modifiedFields.add("TimeStart"); }
    public void assignTimeStart(String aTimeStart) { timeStart = aTimeStart; }
    public void paramTimeStart(HttpServletRequest request) { paramTimeStart(request, "TimeStart"); }
    public void paramTimeStart(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTimeStart()); if (!tmp.equals(getTimeStart())) { setTimeStart(tmp); } }
    // 活动结束时间
    protected String timeEnd = "";
    public String getTimeEnd() {  return SqlTool.getDbString(timeEnd);  }
    public String getTimeEnd(int size) { return SqlTool.subString(getTimeEnd(), size); }
    public void setTimeEnd(String aTimeEnd) { timeEnd = aTimeEnd; modifiedFields.add("TimeEnd"); }
    public void assignTimeEnd(String aTimeEnd) { timeEnd = aTimeEnd; }
    public void paramTimeEnd(HttpServletRequest request) { paramTimeEnd(request, "TimeEnd"); }
    public void paramTimeEnd(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTimeEnd()); if (!tmp.equals(getTimeEnd())) { setTimeEnd(tmp); } }
    // 活动地点
    protected String activityPlace = "";
    public String getActivityPlace() {  return SqlTool.getDbString(activityPlace);  }
    public String getActivityPlace(int size) { return SqlTool.subString(getActivityPlace(), size); }
    public void setActivityPlace(String aActivityPlace) { activityPlace = aActivityPlace; modifiedFields.add("ActivityPlace"); }
    public void assignActivityPlace(String aActivityPlace) { activityPlace = aActivityPlace; }
    public void paramActivityPlace(HttpServletRequest request) { paramActivityPlace(request, "ActivityPlace"); }
    public void paramActivityPlace(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityPlace()); if (!tmp.equals(getActivityPlace())) { setActivityPlace(tmp); } }
    // 组织者
    protected String organizer = "";
    public String getOrganizer() {  return SqlTool.getDbString(organizer);  }
    public String getOrganizer(int size) { return SqlTool.subString(getOrganizer(), size); }
    public void setOrganizer(String aOrganizer) { organizer = aOrganizer; modifiedFields.add("Organizer"); }
    public void assignOrganizer(String aOrganizer) { organizer = aOrganizer; }
    public void paramOrganizer(HttpServletRequest request) { paramOrganizer(request, "Organizer"); }
    public void paramOrganizer(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOrganizer()); if (!tmp.equals(getOrganizer())) { setOrganizer(tmp); } }
    // 预计参加人数
    protected String predictNumber = "";
    public String getPredictNumber() {  return SqlTool.getDbString(predictNumber);  }
    public String getPredictNumber(int size) { return SqlTool.subString(getPredictNumber(), size); }
    public void setPredictNumber(String aPredictNumber) { predictNumber = aPredictNumber; modifiedFields.add("PredictNumber"); }
    public void assignPredictNumber(String aPredictNumber) { predictNumber = aPredictNumber; }
    public void paramPredictNumber(HttpServletRequest request) { paramPredictNumber(request, "PredictNumber"); }
    public void paramPredictNumber(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPredictNumber()); if (!tmp.equals(getPredictNumber())) { setPredictNumber(tmp); } }
    // 申请时是否有赞助
    protected String isSupported = "";
    public String getIsSupported() {  return SqlTool.getDbString(isSupported);  }
    public String getIsSupported(int size) { return SqlTool.subString(getIsSupported(), size); }
    public void setIsSupported(String aIsSupported) { isSupported = aIsSupported; modifiedFields.add("IsSupported"); }
    public void assignIsSupported(String aIsSupported) { isSupported = aIsSupported; }
    public void paramIsSupported(HttpServletRequest request) { paramIsSupported(request, "IsSupported"); }
    public void paramIsSupported(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIsSupported()); if (!tmp.equals(getIsSupported())) { setIsSupported(tmp); } }
    // 活动具体内容及活动经费使用情况
    protected String contant = "";
    public String getContant() {  return SqlTool.getDbString(contant);  }
    public String getContant(int size) { return SqlTool.subString(getContant(), size); }
    public void setContant(String aContant) { contant = aContant; modifiedFields.add("Contant"); }
    public void assignContant(String aContant) { contant = aContant; }
    public void paramContant(HttpServletRequest request) { paramContant(request, "Contant"); }
    public void paramContant(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getContant()); if (!tmp.equals(getContant())) { setContant(tmp); } }
    // 第一负责人
    protected String contacts = "";
    public String getContacts() {  return SqlTool.getDbString(contacts);  }
    public String getContacts(int size) { return SqlTool.subString(getContacts(), size); }
    public void setContacts(String aContacts) { contacts = aContacts; modifiedFields.add("Contacts"); }
    public void assignContacts(String aContacts) { contacts = aContacts; }
    public void paramContacts(HttpServletRequest request) { paramContacts(request, "Contacts"); }
    public void paramContacts(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getContacts()); if (!tmp.equals(getContacts())) { setContacts(tmp); } }
    // 第一负责人电话
    protected String contactsPhone = "";
    public String getContactsPhone() {  return SqlTool.getDbString(contactsPhone);  }
    public String getContactsPhone(int size) { return SqlTool.subString(getContactsPhone(), size); }
    public void setContactsPhone(String aContactsPhone) { contactsPhone = aContactsPhone; modifiedFields.add("ContactsPhone"); }
    public void assignContactsPhone(String aContactsPhone) { contactsPhone = aContactsPhone; }
    public void paramContactsPhone(HttpServletRequest request) { paramContactsPhone(request, "ContactsPhone"); }
    public void paramContactsPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getContactsPhone()); if (!tmp.equals(getContactsPhone())) { setContactsPhone(tmp); } }
    // 活动预告
    protected String forecast = "";
    public String getForecast() {  return SqlTool.getDbString(forecast);  }
    public String getForecast(int size) { return SqlTool.subString(getForecast(), size); }
    public void setForecast(String aForecast) { forecast = aForecast; modifiedFields.add("Forecast"); }
    public void assignForecast(String aForecast) { forecast = aForecast; }
    public void paramForecast(HttpServletRequest request) { paramForecast(request, "Forecast"); }
    public void paramForecast(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getForecast()); if (!tmp.equals(getForecast())) { setForecast(tmp); } }
    // 指导教师意见
    protected String commentTeacher = "";
    public String getCommentTeacher() {  return SqlTool.getDbString(commentTeacher);  }
    public String getCommentTeacher(int size) { return SqlTool.subString(getCommentTeacher(), size); }
    public void setCommentTeacher(String aCommentTeacher) { commentTeacher = aCommentTeacher; modifiedFields.add("CommentTeacher"); }
    public void assignCommentTeacher(String aCommentTeacher) { commentTeacher = aCommentTeacher; }
    public void paramCommentTeacher(HttpServletRequest request) { paramCommentTeacher(request, "CommentTeacher"); }
    public void paramCommentTeacher(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentTeacher()); if (!tmp.equals(getCommentTeacher())) { setCommentTeacher(tmp); } }
    // 指导单位意见
    protected String commentAcademy = "";
    public String getCommentAcademy() {  return SqlTool.getDbString(commentAcademy);  }
    public String getCommentAcademy(int size) { return SqlTool.subString(getCommentAcademy(), size); }
    public void setCommentAcademy(String aCommentAcademy) { commentAcademy = aCommentAcademy; modifiedFields.add("CommentAcademy"); }
    public void assignCommentAcademy(String aCommentAcademy) { commentAcademy = aCommentAcademy; }
    public void paramCommentAcademy(HttpServletRequest request) { paramCommentAcademy(request, "CommentAcademy"); }
    public void paramCommentAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentAcademy()); if (!tmp.equals(getCommentAcademy())) { setCommentAcademy(tmp); } }
    // 社团联合会意见
    protected String commentShelian = "";
    public String getCommentShelian() {  return SqlTool.getDbString(commentShelian);  }
    public String getCommentShelian(int size) { return SqlTool.subString(getCommentShelian(), size); }
    public void setCommentShelian(String aCommentShelian) { commentShelian = aCommentShelian; modifiedFields.add("CommentShelian"); }
    public void assignCommentShelian(String aCommentShelian) { commentShelian = aCommentShelian; }
    public void paramCommentShelian(HttpServletRequest request) { paramCommentShelian(request, "CommentShelian"); }
    public void paramCommentShelian(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentShelian()); if (!tmp.equals(getCommentShelian())) { setCommentShelian(tmp); } }
    // 审核
    protected int checkFlag = -1;
    public int getCheckFlag() { return checkFlag; }
    public void setCheckFlag(int aCheckFlag) { checkFlag = aCheckFlag; modifiedFields.add("CheckFlag"); }
    public void assignCheckFlag(int aCheckFlag) { checkFlag = aCheckFlag; }
    public void paramCheckFlag(HttpServletRequest request) { paramCheckFlag(request, "CheckFlag"); }
    public void paramCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckFlag()); if (tmp != getCheckFlag()) { setCheckFlag(tmp); } }
    // 备注
    protected String remark = "";
    public String getRemark() {  return SqlTool.getDbString(remark);  }
    public String getRemark(int size) { return SqlTool.subString(getRemark(), size); }
    public void setRemark(String aRemark) { remark = aRemark; modifiedFields.add("Remark"); }
    public void assignRemark(String aRemark) { remark = aRemark; }
    public void paramRemark(HttpServletRequest request) { paramRemark(request, "Remark"); }
    public void paramRemark(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark()); if (!tmp.equals(getRemark())) { setRemark(tmp); } }
    // 添加人
    protected String addPerson = "";
    public String getAddPerson() {  return SqlTool.getDbString(addPerson);  }
    public String getAddPerson(int size) { return SqlTool.subString(getAddPerson(), size); }
    public void setAddPerson(String aAddPerson) { addPerson = aAddPerson; modifiedFields.add("AddPerson"); }
    public void assignAddPerson(String aAddPerson) { addPerson = aAddPerson; }
    public void paramAddPerson(HttpServletRequest request) { paramAddPerson(request, "AddPerson"); }
    public void paramAddPerson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddPerson()); if (!tmp.equals(getAddPerson())) { setAddPerson(tmp); } }
    // 添加时间
    protected java.util.Date addTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddTime() { return addTime; }
    public void setAddTime(java.util.Date aAddTime) { addTime = aAddTime; modifiedFields.add("AddTime"); }
    public void assignAddTime(java.util.Date aAddTime) { addTime = aAddTime; }
    public void paramAddTime(HttpServletRequest request) { paramAddTime(request, "AddTime"); }
    public void paramAddTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddTime()); if (tmp.compareTo(getAddTime()) != 0) { setAddTime(tmp); } }
    // 修改人
    protected String modiperson = "";
    public String getModiperson() {  return SqlTool.getDbString(modiperson);  }
    public String getModiperson(int size) { return SqlTool.subString(getModiperson(), size); }
    public void setModiperson(String aModiperson) { modiperson = aModiperson; modifiedFields.add("Modiperson"); }
    public void assignModiperson(String aModiperson) { modiperson = aModiperson; }
    public void paramModiperson(HttpServletRequest request) { paramModiperson(request, "Modiperson"); }
    public void paramModiperson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getModiperson()); if (!tmp.equals(getModiperson())) { setModiperson(tmp); } }
    // 修改时间
    protected java.util.Date modiTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getModiTime() { return modiTime; }
    public void setModiTime(java.util.Date aModiTime) { modiTime = aModiTime; modifiedFields.add("ModiTime"); }
    public void assignModiTime(java.util.Date aModiTime) { modiTime = aModiTime; }
    public void paramModiTime(HttpServletRequest request) { paramModiTime(request, "ModiTime"); }
    public void paramModiTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getModiTime()); if (tmp.compareTo(getModiTime()) != 0) { setModiTime(tmp); } }
    // 活动审批老师
    protected String checkPerson = "";
    public String getCheckPerson() {  return SqlTool.getDbString(checkPerson);  }
    public String getCheckPerson(int size) { return SqlTool.subString(getCheckPerson(), size); }
    public void setCheckPerson(String aCheckPerson) { checkPerson = aCheckPerson; modifiedFields.add("CheckPerson"); }
    public void assignCheckPerson(String aCheckPerson) { checkPerson = aCheckPerson; }
    public void paramCheckPerson(HttpServletRequest request) { paramCheckPerson(request, "CheckPerson"); }
    public void paramCheckPerson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCheckPerson()); if (!tmp.equals(getCheckPerson())) { setCheckPerson(tmp); } }
    // 项目id
    protected String projectId = "";
    public String getProjectId() {  return SqlTool.getDbString(projectId);  }
    public String getProjectId(int size) { return SqlTool.subString(getProjectId(), size); }
    public void setProjectId(String aProjectId) { projectId = aProjectId; modifiedFields.add("ProjectId"); }
    public void assignProjectId(String aProjectId) { projectId = aProjectId; }
    public void paramProjectId(HttpServletRequest request) { paramProjectId(request, "ProjectId"); }
    public void paramProjectId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectId()); if (!tmp.equals(getProjectId())) { setProjectId(tmp); } }
    // 项目名称
    protected String projectName = "";
    public String getProjectName() {  return SqlTool.getDbString(projectName);  }
    public String getProjectName(int size) { return SqlTool.subString(getProjectName(), size); }
    public void setProjectName(String aProjectName) { projectName = aProjectName; modifiedFields.add("ProjectName"); }
    public void assignProjectName(String aProjectName) { projectName = aProjectName; }
    public void paramProjectName(HttpServletRequest request) { paramProjectName(request, "ProjectName"); }
    public void paramProjectName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectName()); if (!tmp.equals(getProjectName())) { setProjectName(tmp); } }
    // 社团创立(club)或团委立项(club-project)
    protected String module = "";
    public String getModule() {  return SqlTool.getDbString(module);  }
    public String getModule(int size) { return SqlTool.subString(getModule(), size); }
    public void setModule(String aModule) { module = aModule; modifiedFields.add("Module"); }
    public void assignModule(String aModule) { module = aModule; }
    public void paramModule(HttpServletRequest request) { paramModule(request, "Module"); }
    public void paramModule(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getModule()); if (!tmp.equals(getModule())) { setModule(tmp); } }
    // 是否校内活动
    protected String isatSchool = "";
    public String getIsatSchool() {  return SqlTool.getDbString(isatSchool);  }
    public String getIsatSchool(int size) { return SqlTool.subString(getIsatSchool(), size); }
    public void setIsatSchool(String aIsatSchool) { isatSchool = aIsatSchool; modifiedFields.add("IsatSchool"); }
    public void assignIsatSchool(String aIsatSchool) { isatSchool = aIsatSchool; }
    public void paramIsatSchool(HttpServletRequest request) { paramIsatSchool(request, "IsatSchool"); }
    public void paramIsatSchool(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIsatSchool()); if (!tmp.equals(getIsatSchool())) { setIsatSchool(tmp); } }
    // 申请时间
    protected java.util.Date applyTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getApplyTime() { return applyTime; }
    public void setApplyTime(java.util.Date aApplyTime) { applyTime = aApplyTime; modifiedFields.add("ApplyTime"); }
    public void assignApplyTime(java.util.Date aApplyTime) { applyTime = aApplyTime; }
    public void paramApplyTime(HttpServletRequest request) { paramApplyTime(request, "ApplyTime"); }
    public void paramApplyTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getApplyTime()); if (tmp.compareTo(getApplyTime()) != 0) { setApplyTime(tmp); } }
    // 审核时间
    protected java.util.Date checkTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getCheckTime() { return checkTime; }
    public void setCheckTime(java.util.Date aCheckTime) { checkTime = aCheckTime; modifiedFields.add("CheckTime"); }
    public void assignCheckTime(java.util.Date aCheckTime) { checkTime = aCheckTime; }
    public void paramCheckTime(HttpServletRequest request) { paramCheckTime(request, "CheckTime"); }
    public void paramCheckTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getCheckTime()); if (tmp.compareTo(getCheckTime()) != 0) { setCheckTime(tmp); } }
    // 立项0为社团创建
    protected String belongId = "";
    public String getBelongId() {  return SqlTool.getDbString(belongId);  }
    public String getBelongId(int size) { return SqlTool.subString(getBelongId(), size); }
    public void setBelongId(String aBelongId) { belongId = aBelongId; modifiedFields.add("BelongId"); }
    public void assignBelongId(String aBelongId) { belongId = aBelongId; }
    public void paramBelongId(HttpServletRequest request) { paramBelongId(request, "BelongId"); }
    public void paramBelongId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getBelongId()); if (!tmp.equals(getBelongId())) { setBelongId(tmp); } }
    // 预算清单
    protected String budgetList = "";
    public String getBudgetList() {  return SqlTool.getDbString(budgetList);  }
    public String getBudgetList(int size) { return SqlTool.subString(getBudgetList(), size); }
    public void setBudgetList(String aBudgetList) { budgetList = aBudgetList; modifiedFields.add("BudgetList"); }
    public void assignBudgetList(String aBudgetList) { budgetList = aBudgetList; }
    public void paramBudgetList(HttpServletRequest request) { paramBudgetList(request, "BudgetList"); }
    public void paramBudgetList(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getBudgetList()); if (!tmp.equals(getBudgetList())) { setBudgetList(tmp); } }
    // 所有预算
    protected String budgetAmountAll = "";
    public String getBudgetAmountAll() {  return SqlTool.getDbString(budgetAmountAll);  }
    public String getBudgetAmountAll(int size) { return SqlTool.subString(getBudgetAmountAll(), size); }
    public void setBudgetAmountAll(String aBudgetAmountAll) { budgetAmountAll = aBudgetAmountAll; modifiedFields.add("BudgetAmountAll"); }
    public void assignBudgetAmountAll(String aBudgetAmountAll) { budgetAmountAll = aBudgetAmountAll; }
    public void paramBudgetAmountAll(HttpServletRequest request) { paramBudgetAmountAll(request, "BudgetAmountAll"); }
    public void paramBudgetAmountAll(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getBudgetAmountAll()); if (!tmp.equals(getBudgetAmountAll())) { setBudgetAmountAll(tmp); } }
    // 项目结题：检查
    protected int conclusionCheckFlag = 0;
    public int getConclusionCheckFlag() { return conclusionCheckFlag; }
    public void setConclusionCheckFlag(int aConclusionCheckFlag) { conclusionCheckFlag = aConclusionCheckFlag; modifiedFields.add("ConclusionCheckFlag"); }
    public void assignConclusionCheckFlag(int aConclusionCheckFlag) { conclusionCheckFlag = aConclusionCheckFlag; }
    public void paramConclusionCheckFlag(HttpServletRequest request) { paramConclusionCheckFlag(request, "ConclusionCheckFlag"); }
    public void paramConclusionCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getConclusionCheckFlag()); if (tmp != getConclusionCheckFlag()) { setConclusionCheckFlag(tmp); } }
    // 项目结题：申请时间
    protected java.util.Date conclusionApplyTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getConclusionApplyTime() { return conclusionApplyTime; }
    public void setConclusionApplyTime(java.util.Date aConclusionApplyTime) { conclusionApplyTime = aConclusionApplyTime; modifiedFields.add("ConclusionApplyTime"); }
    public void assignConclusionApplyTime(java.util.Date aConclusionApplyTime) { conclusionApplyTime = aConclusionApplyTime; }
    public void paramConclusionApplyTime(HttpServletRequest request) { paramConclusionApplyTime(request, "ConclusionApplyTime"); }
    public void paramConclusionApplyTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getConclusionApplyTime()); if (tmp.compareTo(getConclusionApplyTime()) != 0) { setConclusionApplyTime(tmp); } }
    // 学院审核意见
    protected String conclusionCommentAcademy = "";
    public String getConclusionCommentAcademy() {  return SqlTool.getDbString(conclusionCommentAcademy);  }
    public String getConclusionCommentAcademy(int size) { return SqlTool.subString(getConclusionCommentAcademy(), size); }
    public void setConclusionCommentAcademy(String aConclusionCommentAcademy) { conclusionCommentAcademy = aConclusionCommentAcademy; modifiedFields.add("ConclusionCommentAcademy"); }
    public void assignConclusionCommentAcademy(String aConclusionCommentAcademy) { conclusionCommentAcademy = aConclusionCommentAcademy; }
    public void paramConclusionCommentAcademy(HttpServletRequest request) { paramConclusionCommentAcademy(request, "ConclusionCommentAcademy"); }
    public void paramConclusionCommentAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionCommentAcademy()); if (!tmp.equals(getConclusionCommentAcademy())) { setConclusionCommentAcademy(tmp); } }
    // 社团的审核意见
    protected String conclusionCommentShelian = "";
    public String getConclusionCommentShelian() {  return SqlTool.getDbString(conclusionCommentShelian);  }
    public String getConclusionCommentShelian(int size) { return SqlTool.subString(getConclusionCommentShelian(), size); }
    public void setConclusionCommentShelian(String aConclusionCommentShelian) { conclusionCommentShelian = aConclusionCommentShelian; modifiedFields.add("ConclusionCommentShelian"); }
    public void assignConclusionCommentShelian(String aConclusionCommentShelian) { conclusionCommentShelian = aConclusionCommentShelian; }
    public void paramConclusionCommentShelian(HttpServletRequest request) { paramConclusionCommentShelian(request, "ConclusionCommentShelian"); }
    public void paramConclusionCommentShelian(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionCommentShelian()); if (!tmp.equals(getConclusionCommentShelian())) { setConclusionCommentShelian(tmp); } }
    // 项目结题:活动概要
    protected String conclusionGeneral = "";
    public String getConclusionGeneral() {  return SqlTool.getDbString(conclusionGeneral);  }
    public String getConclusionGeneral(int size) { return SqlTool.subString(getConclusionGeneral(), size); }
    public void setConclusionGeneral(String aConclusionGeneral) { conclusionGeneral = aConclusionGeneral; modifiedFields.add("ConclusionGeneral"); }
    public void assignConclusionGeneral(String aConclusionGeneral) { conclusionGeneral = aConclusionGeneral; }
    public void paramConclusionGeneral(HttpServletRequest request) { paramConclusionGeneral(request, "ConclusionGeneral"); }
    public void paramConclusionGeneral(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionGeneral()); if (!tmp.equals(getConclusionGeneral())) { setConclusionGeneral(tmp); } }
    // 项目结题:稿件情况
    protected String conclusionManuscript = "";
    public String getConclusionManuscript() {  return SqlTool.getDbString(conclusionManuscript);  }
    public String getConclusionManuscript(int size) { return SqlTool.subString(getConclusionManuscript(), size); }
    public void setConclusionManuscript(String aConclusionManuscript) { conclusionManuscript = aConclusionManuscript; modifiedFields.add("ConclusionManuscript"); }
    public void assignConclusionManuscript(String aConclusionManuscript) { conclusionManuscript = aConclusionManuscript; }
    public void paramConclusionManuscript(HttpServletRequest request) { paramConclusionManuscript(request, "ConclusionManuscript"); }
    public void paramConclusionManuscript(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionManuscript()); if (!tmp.equals(getConclusionManuscript())) { setConclusionManuscript(tmp); } }
    // 社团意见
    protected String conclusionCommentClub = "";
    public String getConclusionCommentClub() {  return SqlTool.getDbString(conclusionCommentClub);  }
    public String getConclusionCommentClub(int size) { return SqlTool.subString(getConclusionCommentClub(), size); }
    public void setConclusionCommentClub(String aConclusionCommentClub) { conclusionCommentClub = aConclusionCommentClub; modifiedFields.add("ConclusionCommentClub"); }
    public void assignConclusionCommentClub(String aConclusionCommentClub) { conclusionCommentClub = aConclusionCommentClub; }
    public void paramConclusionCommentClub(HttpServletRequest request) { paramConclusionCommentClub(request, "ConclusionCommentClub"); }
    public void paramConclusionCommentClub(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionCommentClub()); if (!tmp.equals(getConclusionCommentClub())) { setConclusionCommentClub(tmp); } }
    // 团委意见
    protected String conclusionCommentcTuanwei = "";
    public String getConclusionCommentcTuanwei() {  return SqlTool.getDbString(conclusionCommentcTuanwei);  }
    public String getConclusionCommentcTuanwei(int size) { return SqlTool.subString(getConclusionCommentcTuanwei(), size); }
    public void setConclusionCommentcTuanwei(String aConclusionCommentcTuanwei) { conclusionCommentcTuanwei = aConclusionCommentcTuanwei; modifiedFields.add("ConclusionCommentcTuanwei"); }
    public void assignConclusionCommentcTuanwei(String aConclusionCommentcTuanwei) { conclusionCommentcTuanwei = aConclusionCommentcTuanwei; }
    public void paramConclusionCommentcTuanwei(HttpServletRequest request) { paramConclusionCommentcTuanwei(request, "ConclusionCommentcTuanwei"); }
    public void paramConclusionCommentcTuanwei(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionCommentcTuanwei()); if (!tmp.equals(getConclusionCommentcTuanwei())) { setConclusionCommentcTuanwei(tmp); } }
    // 活动前期策划和组织人数
    protected String conclusionPlanNums = "";
    public String getConclusionPlanNums() {  return SqlTool.getDbString(conclusionPlanNums);  }
    public String getConclusionPlanNums(int size) { return SqlTool.subString(getConclusionPlanNums(), size); }
    public void setConclusionPlanNums(String aConclusionPlanNums) { conclusionPlanNums = aConclusionPlanNums; modifiedFields.add("ConclusionPlanNums"); }
    public void assignConclusionPlanNums(String aConclusionPlanNums) { conclusionPlanNums = aConclusionPlanNums; }
    public void paramConclusionPlanNums(HttpServletRequest request) { paramConclusionPlanNums(request, "ConclusionPlanNums"); }
    public void paramConclusionPlanNums(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionPlanNums()); if (!tmp.equals(getConclusionPlanNums())) { setConclusionPlanNums(tmp); } }
    // 活动前期策划和组织参与人员
    protected String conclusionPlanNames = "";
    public String getConclusionPlanNames() {  return SqlTool.getDbString(conclusionPlanNames);  }
    public String getConclusionPlanNames(int size) { return SqlTool.subString(getConclusionPlanNames(), size); }
    public void setConclusionPlanNames(String aConclusionPlanNames) { conclusionPlanNames = aConclusionPlanNames; modifiedFields.add("ConclusionPlanNames"); }
    public void assignConclusionPlanNames(String aConclusionPlanNames) { conclusionPlanNames = aConclusionPlanNames; }
    public void paramConclusionPlanNames(HttpServletRequest request) { paramConclusionPlanNames(request, "ConclusionPlanNames"); }
    public void paramConclusionPlanNames(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionPlanNames()); if (!tmp.equals(getConclusionPlanNames())) { setConclusionPlanNames(tmp); } }
    // 活动材料制作、宣传、表演人数
    protected String conclusionBroadcastNums = "";
    public String getConclusionBroadcastNums() {  return SqlTool.getDbString(conclusionBroadcastNums);  }
    public String getConclusionBroadcastNums(int size) { return SqlTool.subString(getConclusionBroadcastNums(), size); }
    public void setConclusionBroadcastNums(String aConclusionBroadcastNums) { conclusionBroadcastNums = aConclusionBroadcastNums; modifiedFields.add("ConclusionBroadcastNums"); }
    public void assignConclusionBroadcastNums(String aConclusionBroadcastNums) { conclusionBroadcastNums = aConclusionBroadcastNums; }
    public void paramConclusionBroadcastNums(HttpServletRequest request) { paramConclusionBroadcastNums(request, "ConclusionBroadcastNums"); }
    public void paramConclusionBroadcastNums(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionBroadcastNums()); if (!tmp.equals(getConclusionBroadcastNums())) { setConclusionBroadcastNums(tmp); } }
    // 活动材料制作、宣传、表演人参与人员
    protected String conclusionBroadcastNames = "";
    public String getConclusionBroadcastNames() {  return SqlTool.getDbString(conclusionBroadcastNames);  }
    public String getConclusionBroadcastNames(int size) { return SqlTool.subString(getConclusionBroadcastNames(), size); }
    public void setConclusionBroadcastNames(String aConclusionBroadcastNames) { conclusionBroadcastNames = aConclusionBroadcastNames; modifiedFields.add("ConclusionBroadcastNames"); }
    public void assignConclusionBroadcastNames(String aConclusionBroadcastNames) { conclusionBroadcastNames = aConclusionBroadcastNames; }
    public void paramConclusionBroadcastNames(HttpServletRequest request) { paramConclusionBroadcastNames(request, "ConclusionBroadcastNames"); }
    public void paramConclusionBroadcastNames(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionBroadcastNames()); if (!tmp.equals(getConclusionBroadcastNames())) { setConclusionBroadcastNames(tmp); } }
    // 活动其他参与人数
    protected String conclusionelseNums = "";
    public String getConclusionelseNums() {  return SqlTool.getDbString(conclusionelseNums);  }
    public String getConclusionelseNums(int size) { return SqlTool.subString(getConclusionelseNums(), size); }
    public void setConclusionelseNums(String aConclusionelseNums) { conclusionelseNums = aConclusionelseNums; modifiedFields.add("ConclusionelseNums"); }
    public void assignConclusionelseNums(String aConclusionelseNums) { conclusionelseNums = aConclusionelseNums; }
    public void paramConclusionelseNums(HttpServletRequest request) { paramConclusionelseNums(request, "ConclusionelseNums"); }
    public void paramConclusionelseNums(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionelseNums()); if (!tmp.equals(getConclusionelseNums())) { setConclusionelseNums(tmp); } }
    // 活动其他参与人员
    protected String conclusionelseNames = "";
    public String getConclusionelseNames() {  return SqlTool.getDbString(conclusionelseNames);  }
    public String getConclusionelseNames(int size) { return SqlTool.subString(getConclusionelseNames(), size); }
    public void setConclusionelseNames(String aConclusionelseNames) { conclusionelseNames = aConclusionelseNames; modifiedFields.add("ConclusionelseNames"); }
    public void assignConclusionelseNames(String aConclusionelseNames) { conclusionelseNames = aConclusionelseNames; }
    public void paramConclusionelseNames(HttpServletRequest request) { paramConclusionelseNames(request, "ConclusionelseNames"); }
    public void paramConclusionelseNames(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionelseNames()); if (!tmp.equals(getConclusionelseNames())) { setConclusionelseNames(tmp); } }
    // 活动总经费
    protected String conclusionCost = "";
    public String getConclusionCost() {  return SqlTool.getDbString(conclusionCost);  }
    public String getConclusionCost(int size) { return SqlTool.subString(getConclusionCost(), size); }
    public void setConclusionCost(String aConclusionCost) { conclusionCost = aConclusionCost; modifiedFields.add("ConclusionCost"); }
    public void assignConclusionCost(String aConclusionCost) { conclusionCost = aConclusionCost; }
    public void paramConclusionCost(HttpServletRequest request) { paramConclusionCost(request, "ConclusionCost"); }
    public void paramConclusionCost(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionCost()); if (!tmp.equals(getConclusionCost())) { setConclusionCost(tmp); } }
    // 结题时是否有赞助
    protected String conclusionIsSupport = "";
    public String getConclusionIsSupport() {  return SqlTool.getDbString(conclusionIsSupport);  }
    public String getConclusionIsSupport(int size) { return SqlTool.subString(getConclusionIsSupport(), size); }
    public void setConclusionIsSupport(String aConclusionIsSupport) { conclusionIsSupport = aConclusionIsSupport; modifiedFields.add("ConclusionIsSupport"); }
    public void assignConclusionIsSupport(String aConclusionIsSupport) { conclusionIsSupport = aConclusionIsSupport; }
    public void paramConclusionIsSupport(HttpServletRequest request) { paramConclusionIsSupport(request, "ConclusionIsSupport"); }
    public void paramConclusionIsSupport(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionIsSupport()); if (!tmp.equals(getConclusionIsSupport())) { setConclusionIsSupport(tmp); } }
    // 赞助情况
    protected String conclusionSupportDetail = "";
    public String getConclusionSupportDetail() {  return SqlTool.getDbString(conclusionSupportDetail);  }
    public String getConclusionSupportDetail(int size) { return SqlTool.subString(getConclusionSupportDetail(), size); }
    public void setConclusionSupportDetail(String aConclusionSupportDetail) { conclusionSupportDetail = aConclusionSupportDetail; modifiedFields.add("ConclusionSupportDetail"); }
    public void assignConclusionSupportDetail(String aConclusionSupportDetail) { conclusionSupportDetail = aConclusionSupportDetail; }
    public void paramConclusionSupportDetail(HttpServletRequest request) { paramConclusionSupportDetail(request, "ConclusionSupportDetail"); }
    public void paramConclusionSupportDetail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionSupportDetail()); if (!tmp.equals(getConclusionSupportDetail())) { setConclusionSupportDetail(tmp); } }
    // 结题总结
    protected String conclusionSummary = "";
    public String getConclusionSummary() {  return SqlTool.getDbString(conclusionSummary);  }
    public String getConclusionSummary(int size) { return SqlTool.subString(getConclusionSummary(), size); }
    public void setConclusionSummary(String aConclusionSummary) { conclusionSummary = aConclusionSummary; modifiedFields.add("ConclusionSummary"); }
    public void assignConclusionSummary(String aConclusionSummary) { conclusionSummary = aConclusionSummary; }
    public void paramConclusionSummary(HttpServletRequest request) { paramConclusionSummary(request, "ConclusionSummary"); }
    public void paramConclusionSummary(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionSummary()); if (!tmp.equals(getConclusionSummary())) { setConclusionSummary(tmp); } }
    // 其他必要说明人
    protected String conclusionRemark = "";
    public String getConclusionRemark() {  return SqlTool.getDbString(conclusionRemark);  }
    public String getConclusionRemark(int size) { return SqlTool.subString(getConclusionRemark(), size); }
    public void setConclusionRemark(String aConclusionRemark) { conclusionRemark = aConclusionRemark; modifiedFields.add("ConclusionRemark"); }
    public void assignConclusionRemark(String aConclusionRemark) { conclusionRemark = aConclusionRemark; }
    public void paramConclusionRemark(HttpServletRequest request) { paramConclusionRemark(request, "ConclusionRemark"); }
    public void paramConclusionRemark(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getConclusionRemark()); if (!tmp.equals(getConclusionRemark())) { setConclusionRemark(tmp); } }
    // 立项等级l
    protected String activityLevel = "";
    public String getActivityLevel() {  return SqlTool.getDbString(activityLevel);  }
    public String getActivityLevel(int size) { return SqlTool.subString(getActivityLevel(), size); }
    public void setActivityLevel(String aActivityLevel) { activityLevel = aActivityLevel; modifiedFields.add("ActivityLevel"); }
    public void assignActivityLevel(String aActivityLevel) { activityLevel = aActivityLevel; }
    public void paramActivityLevel(HttpServletRequest request) { paramActivityLevel(request, "ActivityLevel"); }
    public void paramActivityLevel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityLevel()); if (!tmp.equals(getActivityLevel())) { setActivityLevel(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public ClubActivities (String db) {
        DBNAME = db;
    }
    public ClubActivities (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public ClubActivities (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public ClubActivities () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return ClubActivities类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public ClubActivities getByParameter(HttpServletRequest request) {
        ClubActivities v = new ClubActivities(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramActivityName(request);
        paramOrgacadeMy(request);
        paramClubName(request);
        paramClubId(request);
        paramTimeStart(request);
        paramTimeEnd(request);
        paramActivityPlace(request);
        paramOrganizer(request);
        paramPredictNumber(request);
        paramIsSupported(request);
        paramContant(request);
        paramContacts(request);
        paramContactsPhone(request);
        paramForecast(request);
        paramCommentTeacher(request);
        paramCommentAcademy(request);
        paramCommentShelian(request);
        paramCheckFlag(request);
        paramRemark(request);
        paramAddPerson(request);
        paramAddTime(request);
        paramModiperson(request);
        paramModiTime(request);
        paramCheckPerson(request);
        paramProjectId(request);
        paramProjectName(request);
        paramModule(request);
        paramIsatSchool(request);
        paramApplyTime(request);
        paramCheckTime(request);
        paramBelongId(request);
        paramBudgetList(request);
        paramBudgetAmountAll(request);
        paramConclusionCheckFlag(request);
        paramConclusionApplyTime(request);
        paramConclusionCommentAcademy(request);
        paramConclusionCommentShelian(request);
        paramConclusionGeneral(request);
        paramConclusionManuscript(request);
        paramConclusionCommentClub(request);
        paramConclusionCommentcTuanwei(request);
        paramConclusionPlanNums(request);
        paramConclusionPlanNames(request);
        paramConclusionBroadcastNums(request);
        paramConclusionBroadcastNames(request);
        paramConclusionelseNums(request);
        paramConclusionelseNames(request);
        paramConclusionCost(request);
        paramConclusionIsSupport(request);
        paramConclusionSupportDetail(request);
        paramConclusionSummary(request);
        paramConclusionRemark(request);
        paramActivityLevel(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(ClubActivities bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("activityName")) { setActivityName(bean.getActivityName()); }
        if (!ncl.contains("orgacadeMy")) { setOrgacadeMy(bean.getOrgacadeMy()); }
        if (!ncl.contains("clubName")) { setClubName(bean.getClubName()); }
        if (!ncl.contains("clubId")) { setClubId(bean.getClubId()); }
        if (!ncl.contains("timeStart")) { setTimeStart(bean.getTimeStart()); }
        if (!ncl.contains("timeEnd")) { setTimeEnd(bean.getTimeEnd()); }
        if (!ncl.contains("activityPlace")) { setActivityPlace(bean.getActivityPlace()); }
        if (!ncl.contains("organizer")) { setOrganizer(bean.getOrganizer()); }
        if (!ncl.contains("predictNumber")) { setPredictNumber(bean.getPredictNumber()); }
        if (!ncl.contains("isSupported")) { setIsSupported(bean.getIsSupported()); }
        if (!ncl.contains("contant")) { setContant(bean.getContant()); }
        if (!ncl.contains("contacts")) { setContacts(bean.getContacts()); }
        if (!ncl.contains("contactsPhone")) { setContactsPhone(bean.getContactsPhone()); }
        if (!ncl.contains("forecast")) { setForecast(bean.getForecast()); }
        if (!ncl.contains("commentTeacher")) { setCommentTeacher(bean.getCommentTeacher()); }
        if (!ncl.contains("commentAcademy")) { setCommentAcademy(bean.getCommentAcademy()); }
        if (!ncl.contains("commentShelian")) { setCommentShelian(bean.getCommentShelian()); }
        if (!ncl.contains("checkFlag")) { setCheckFlag(bean.getCheckFlag()); }
        if (!ncl.contains("remark")) { setRemark(bean.getRemark()); }
        if (!ncl.contains("addPerson")) { setAddPerson(bean.getAddPerson()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("modiperson")) { setModiperson(bean.getModiperson()); }
        if (!ncl.contains("modiTime")) { setModiTime(bean.getModiTime()); }
        if (!ncl.contains("checkPerson")) { setCheckPerson(bean.getCheckPerson()); }
        if (!ncl.contains("projectId")) { setProjectId(bean.getProjectId()); }
        if (!ncl.contains("projectName")) { setProjectName(bean.getProjectName()); }
        if (!ncl.contains("module")) { setModule(bean.getModule()); }
        if (!ncl.contains("isatSchool")) { setIsatSchool(bean.getIsatSchool()); }
        if (!ncl.contains("applyTime")) { setApplyTime(bean.getApplyTime()); }
        if (!ncl.contains("checkTime")) { setCheckTime(bean.getCheckTime()); }
        if (!ncl.contains("belongId")) { setBelongId(bean.getBelongId()); }
        if (!ncl.contains("budgetList")) { setBudgetList(bean.getBudgetList()); }
        if (!ncl.contains("budgetAmountAll")) { setBudgetAmountAll(bean.getBudgetAmountAll()); }
        if (!ncl.contains("conclusionCheckFlag")) { setConclusionCheckFlag(bean.getConclusionCheckFlag()); }
        if (!ncl.contains("conclusionApplyTime")) { setConclusionApplyTime(bean.getConclusionApplyTime()); }
        if (!ncl.contains("conclusionCommentAcademy")) { setConclusionCommentAcademy(bean.getConclusionCommentAcademy()); }
        if (!ncl.contains("conclusionCommentShelian")) { setConclusionCommentShelian(bean.getConclusionCommentShelian()); }
        if (!ncl.contains("conclusionGeneral")) { setConclusionGeneral(bean.getConclusionGeneral()); }
        if (!ncl.contains("conclusionManuscript")) { setConclusionManuscript(bean.getConclusionManuscript()); }
        if (!ncl.contains("conclusionCommentClub")) { setConclusionCommentClub(bean.getConclusionCommentClub()); }
        if (!ncl.contains("conclusionCommentcTuanwei")) { setConclusionCommentcTuanwei(bean.getConclusionCommentcTuanwei()); }
        if (!ncl.contains("conclusionPlanNums")) { setConclusionPlanNums(bean.getConclusionPlanNums()); }
        if (!ncl.contains("conclusionPlanNames")) { setConclusionPlanNames(bean.getConclusionPlanNames()); }
        if (!ncl.contains("conclusionBroadcastNums")) { setConclusionBroadcastNums(bean.getConclusionBroadcastNums()); }
        if (!ncl.contains("conclusionBroadcastNames")) { setConclusionBroadcastNames(bean.getConclusionBroadcastNames()); }
        if (!ncl.contains("conclusionelseNums")) { setConclusionelseNums(bean.getConclusionelseNums()); }
        if (!ncl.contains("conclusionelseNames")) { setConclusionelseNames(bean.getConclusionelseNames()); }
        if (!ncl.contains("conclusionCost")) { setConclusionCost(bean.getConclusionCost()); }
        if (!ncl.contains("conclusionIsSupport")) { setConclusionIsSupport(bean.getConclusionIsSupport()); }
        if (!ncl.contains("conclusionSupportDetail")) { setConclusionSupportDetail(bean.getConclusionSupportDetail()); }
        if (!ncl.contains("conclusionSummary")) { setConclusionSummary(bean.getConclusionSummary()); }
        if (!ncl.contains("conclusionRemark")) { setConclusionRemark(bean.getConclusionRemark()); }
        if (!ncl.contains("activityLevel")) { setActivityLevel(bean.getActivityLevel()); }
    }
    public ClubActivities getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        ClubActivities[] rslt= queryByCondition(cdt);
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
     * @return ClubActivities类的实例列表。
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
                ClubActivities ve = new ClubActivities(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignActivityName(fromDbCh(rs.getString(2)));
                ve.assignOrgacadeMy(fromDbCh(rs.getString(3)));
                ve.assignClubName(fromDbCh(rs.getString(4)));
                ve.assignClubId(fromDbCh(rs.getString(5)));
                ve.assignTimeStart(fromDbCh(rs.getString(6)));
                ve.assignTimeEnd(fromDbCh(rs.getString(7)));
                ve.assignActivityPlace(fromDbCh(rs.getString(8)));
                ve.assignOrganizer(fromDbCh(rs.getString(9)));
                ve.assignPredictNumber(fromDbCh(rs.getString(10)));
                ve.assignIsSupported(fromDbCh(rs.getString(11)));
                ve.assignContant(fromDbCh(rs.getString(12)));
                ve.assignContacts(fromDbCh(rs.getString(13)));
                ve.assignContactsPhone(fromDbCh(rs.getString(14)));
                ve.assignForecast(fromDbCh(rs.getString(15)));
                ve.assignCommentTeacher(fromDbCh(rs.getString(16)));
                ve.assignCommentAcademy(fromDbCh(rs.getString(17)));
                ve.assignCommentShelian(fromDbCh(rs.getString(18)));
                ve.assignCheckFlag(rs.getInt(19));
                ve.assignRemark(fromDbCh(rs.getString(20)));
                ve.assignAddPerson(fromDbCh(rs.getString(21)));
                tmpDate = rs.getTimestamp(22); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignModiperson(fromDbCh(rs.getString(23)));
                tmpDate = rs.getTimestamp(24); if (tmpDate != null) { ve.assignModiTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignCheckPerson(fromDbCh(rs.getString(25)));
                ve.assignProjectId(fromDbCh(rs.getString(26)));
                ve.assignProjectName(fromDbCh(rs.getString(27)));
                ve.assignModule(fromDbCh(rs.getString(28)));
                ve.assignIsatSchool(fromDbCh(rs.getString(29)));
                tmpDate = rs.getTimestamp(30); if (tmpDate != null) { ve.assignApplyTime(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(31); if (tmpDate != null) { ve.assignCheckTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignBelongId(fromDbCh(rs.getString(32)));
                ve.assignBudgetList(fromDbCh(rs.getString(33)));
                ve.assignBudgetAmountAll(fromDbCh(rs.getString(34)));
                ve.assignConclusionCheckFlag(rs.getInt(35));
                tmpDate = rs.getTimestamp(36); if (tmpDate != null) { ve.assignConclusionApplyTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignConclusionCommentAcademy(fromDbCh(rs.getString(37)));
                ve.assignConclusionCommentShelian(fromDbCh(rs.getString(38)));
                ve.assignConclusionGeneral(fromDbCh(rs.getString(39)));
                ve.assignConclusionManuscript(fromDbCh(rs.getString(40)));
                ve.assignConclusionCommentClub(fromDbCh(rs.getString(41)));
                ve.assignConclusionCommentcTuanwei(fromDbCh(rs.getString(42)));
                ve.assignConclusionPlanNums(fromDbCh(rs.getString(43)));
                ve.assignConclusionPlanNames(fromDbCh(rs.getString(44)));
                ve.assignConclusionBroadcastNums(fromDbCh(rs.getString(45)));
                ve.assignConclusionBroadcastNames(fromDbCh(rs.getString(46)));
                ve.assignConclusionelseNums(fromDbCh(rs.getString(47)));
                ve.assignConclusionelseNames(fromDbCh(rs.getString(48)));
                ve.assignConclusionCost(fromDbCh(rs.getString(49)));
                ve.assignConclusionIsSupport(fromDbCh(rs.getString(50)));
                ve.assignConclusionSupportDetail(fromDbCh(rs.getString(51)));
                ve.assignConclusionSummary(fromDbCh(rs.getString(52)));
                ve.assignConclusionRemark(fromDbCh(rs.getString(53)));
                ve.assignActivityLevel(fromDbCh(rs.getString(54)));
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
    public ClubActivities[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (ClubActivities[])vrs.toArray(new ClubActivities[vrs.size()]);
    }
    public ClubActivities[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (ClubActivities[])vrs.toArray(new ClubActivities[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (activityname,orgacademy,clubname,clubid,timestart,timeend,activityplace,organizer,predictnumber,issupported,contant,contacts,contactsphone,forecast,commentteacher,commentacademy,commentshelian,checkflag,remark,addperson,addtime,modiperson,moditime,checkperson,projectid,projectname,module,isatschool,applytime,checktime,belongid,budgetlist,budgetamountall,conclusioncheckflag,conclusionapplytime,conclusioncommentacademy,conclusioncommentshelian,conclusiongeneral,conclusionmanuscript,conclusioncommentclub,conclusioncommentctuanwei,conclusionplannums,conclusionplannames,conclusionbroadcastnums,conclusionbroadcastnames,conclusionelsenums,conclusionelsenames,conclusioncost,conclusionissupport,conclusionsupportdetail,conclusionsummary,conclusionremark,activitylevel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(activityName));
            pstmt.setString(2, toDbCh(orgacadeMy));
            pstmt.setString(3, toDbCh(clubName));
            pstmt.setString(4, toDbCh(clubId));
            pstmt.setString(5, toDbCh(timeStart));
            pstmt.setString(6, toDbCh(timeEnd));
            pstmt.setString(7, toDbCh(activityPlace));
            pstmt.setString(8, toDbCh(organizer));
            pstmt.setString(9, toDbCh(predictNumber));
            pstmt.setString(10, toDbCh(isSupported));
            pstmt.setString(11, toDbCh(contant));
            pstmt.setString(12, toDbCh(contacts));
            pstmt.setString(13, toDbCh(contactsPhone));
            pstmt.setString(14, toDbCh(forecast));
            pstmt.setString(15, toDbCh(commentTeacher));
            pstmt.setString(16, toDbCh(commentAcademy));
            pstmt.setString(17, toDbCh(commentShelian));
            pstmt.setInt(18, checkFlag);
            pstmt.setString(19, toDbCh(remark));
            pstmt.setString(20, toDbCh(addPerson));
            pstmt.setTimestamp(21, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(22, toDbCh(modiperson));
            pstmt.setTimestamp(23, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setString(24, toDbCh(checkPerson));
            pstmt.setString(25, toDbCh(projectId));
            pstmt.setString(26, toDbCh(projectName));
            pstmt.setString(27, toDbCh(module));
            pstmt.setString(28, toDbCh(isatSchool));
            pstmt.setTimestamp(29, new java.sql.Timestamp(applyTime.getTime()));
            pstmt.setTimestamp(30, new java.sql.Timestamp(checkTime.getTime()));
            pstmt.setString(31, toDbCh(belongId));
            pstmt.setString(32, toDbCh(budgetList));
            pstmt.setString(33, toDbCh(budgetAmountAll));
            pstmt.setInt(34, conclusionCheckFlag);
            pstmt.setTimestamp(35, new java.sql.Timestamp(conclusionApplyTime.getTime()));
            pstmt.setString(36, toDbCh(conclusionCommentAcademy));
            pstmt.setString(37, toDbCh(conclusionCommentShelian));
            pstmt.setString(38, toDbCh(conclusionGeneral));
            pstmt.setString(39, toDbCh(conclusionManuscript));
            pstmt.setString(40, toDbCh(conclusionCommentClub));
            pstmt.setString(41, toDbCh(conclusionCommentcTuanwei));
            pstmt.setString(42, toDbCh(conclusionPlanNums));
            pstmt.setString(43, toDbCh(conclusionPlanNames));
            pstmt.setString(44, toDbCh(conclusionBroadcastNums));
            pstmt.setString(45, toDbCh(conclusionBroadcastNames));
            pstmt.setString(46, toDbCh(conclusionelseNums));
            pstmt.setString(47, toDbCh(conclusionelseNames));
            pstmt.setString(48, toDbCh(conclusionCost));
            pstmt.setString(49, toDbCh(conclusionIsSupport));
            pstmt.setString(50, toDbCh(conclusionSupportDetail));
            pstmt.setString(51, toDbCh(conclusionSummary));
            pstmt.setString(52, toDbCh(conclusionRemark));
            pstmt.setString(53, toDbCh(activityLevel));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,activityname,orgacademy,clubname,clubid,timestart,timeend,activityplace,organizer,predictnumber,issupported,contant,contacts,contactsphone,forecast,commentteacher,commentacademy,commentshelian,checkflag,remark,addperson,addtime,modiperson,moditime,checkperson,projectid,projectname,module,isatschool,applytime,checktime,belongid,budgetlist,budgetamountall,conclusioncheckflag,conclusionapplytime,conclusioncommentacademy,conclusioncommentshelian,conclusiongeneral,conclusionmanuscript,conclusioncommentclub,conclusioncommentctuanwei,conclusionplannums,conclusionplannames,conclusionbroadcastnums,conclusionbroadcastnames,conclusionelsenums,conclusionelsenames,conclusioncost,conclusionissupport,conclusionsupportdetail,conclusionsummary,conclusionremark,activitylevel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(activityName));
            pstmt.setString(3, toDbCh(orgacadeMy));
            pstmt.setString(4, toDbCh(clubName));
            pstmt.setString(5, toDbCh(clubId));
            pstmt.setString(6, toDbCh(timeStart));
            pstmt.setString(7, toDbCh(timeEnd));
            pstmt.setString(8, toDbCh(activityPlace));
            pstmt.setString(9, toDbCh(organizer));
            pstmt.setString(10, toDbCh(predictNumber));
            pstmt.setString(11, toDbCh(isSupported));
            pstmt.setString(12, toDbCh(contant));
            pstmt.setString(13, toDbCh(contacts));
            pstmt.setString(14, toDbCh(contactsPhone));
            pstmt.setString(15, toDbCh(forecast));
            pstmt.setString(16, toDbCh(commentTeacher));
            pstmt.setString(17, toDbCh(commentAcademy));
            pstmt.setString(18, toDbCh(commentShelian));
            pstmt.setInt(19, checkFlag);
            pstmt.setString(20, toDbCh(remark));
            pstmt.setString(21, toDbCh(addPerson));
            pstmt.setTimestamp(22, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(23, toDbCh(modiperson));
            pstmt.setTimestamp(24, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setString(25, toDbCh(checkPerson));
            pstmt.setString(26, toDbCh(projectId));
            pstmt.setString(27, toDbCh(projectName));
            pstmt.setString(28, toDbCh(module));
            pstmt.setString(29, toDbCh(isatSchool));
            pstmt.setTimestamp(30, new java.sql.Timestamp(applyTime.getTime()));
            pstmt.setTimestamp(31, new java.sql.Timestamp(checkTime.getTime()));
            pstmt.setString(32, toDbCh(belongId));
            pstmt.setString(33, toDbCh(budgetList));
            pstmt.setString(34, toDbCh(budgetAmountAll));
            pstmt.setInt(35, conclusionCheckFlag);
            pstmt.setTimestamp(36, new java.sql.Timestamp(conclusionApplyTime.getTime()));
            pstmt.setString(37, toDbCh(conclusionCommentAcademy));
            pstmt.setString(38, toDbCh(conclusionCommentShelian));
            pstmt.setString(39, toDbCh(conclusionGeneral));
            pstmt.setString(40, toDbCh(conclusionManuscript));
            pstmt.setString(41, toDbCh(conclusionCommentClub));
            pstmt.setString(42, toDbCh(conclusionCommentcTuanwei));
            pstmt.setString(43, toDbCh(conclusionPlanNums));
            pstmt.setString(44, toDbCh(conclusionPlanNames));
            pstmt.setString(45, toDbCh(conclusionBroadcastNums));
            pstmt.setString(46, toDbCh(conclusionBroadcastNames));
            pstmt.setString(47, toDbCh(conclusionelseNums));
            pstmt.setString(48, toDbCh(conclusionelseNames));
            pstmt.setString(49, toDbCh(conclusionCost));
            pstmt.setString(50, toDbCh(conclusionIsSupport));
            pstmt.setString(51, toDbCh(conclusionSupportDetail));
            pstmt.setString(52, toDbCh(conclusionSummary));
            pstmt.setString(53, toDbCh(conclusionRemark));
            pstmt.setString(54, toDbCh(activityLevel));
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
            ClubActivities item = (ClubActivities)it.next();
            ClubActivities v = new ClubActivities(dbname);
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
                if (modifiedFields.contains("OrgacadeMy")) { pstmt.setString(pi ++, toDbCh(orgacadeMy)); }
                if (modifiedFields.contains("ClubName")) { pstmt.setString(pi ++, toDbCh(clubName)); }
                if (modifiedFields.contains("ClubId")) { pstmt.setString(pi ++, toDbCh(clubId)); }
                if (modifiedFields.contains("TimeStart")) { pstmt.setString(pi ++, toDbCh(timeStart)); }
                if (modifiedFields.contains("TimeEnd")) { pstmt.setString(pi ++, toDbCh(timeEnd)); }
                if (modifiedFields.contains("ActivityPlace")) { pstmt.setString(pi ++, toDbCh(activityPlace)); }
                if (modifiedFields.contains("Organizer")) { pstmt.setString(pi ++, toDbCh(organizer)); }
                if (modifiedFields.contains("PredictNumber")) { pstmt.setString(pi ++, toDbCh(predictNumber)); }
                if (modifiedFields.contains("IsSupported")) { pstmt.setString(pi ++, toDbCh(isSupported)); }
                if (modifiedFields.contains("Contant")) { pstmt.setString(pi ++, toDbCh(contant)); }
                if (modifiedFields.contains("Contacts")) { pstmt.setString(pi ++, toDbCh(contacts)); }
                if (modifiedFields.contains("ContactsPhone")) { pstmt.setString(pi ++, toDbCh(contactsPhone)); }
                if (modifiedFields.contains("Forecast")) { pstmt.setString(pi ++, toDbCh(forecast)); }
                if (modifiedFields.contains("CommentTeacher")) { pstmt.setString(pi ++, toDbCh(commentTeacher)); }
                if (modifiedFields.contains("CommentAcademy")) { pstmt.setString(pi ++, toDbCh(commentAcademy)); }
                if (modifiedFields.contains("CommentShelian")) { pstmt.setString(pi ++, toDbCh(commentShelian)); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("Modiperson")) { pstmt.setString(pi ++, toDbCh(modiperson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("CheckPerson")) { pstmt.setString(pi ++, toDbCh(checkPerson)); }
                if (modifiedFields.contains("ProjectId")) { pstmt.setString(pi ++, toDbCh(projectId)); }
                if (modifiedFields.contains("ProjectName")) { pstmt.setString(pi ++, toDbCh(projectName)); }
                if (modifiedFields.contains("Module")) { pstmt.setString(pi ++, toDbCh(module)); }
                if (modifiedFields.contains("IsatSchool")) { pstmt.setString(pi ++, toDbCh(isatSchool)); }
                if (modifiedFields.contains("ApplyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(applyTime.getTime())); }
                if (modifiedFields.contains("CheckTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(checkTime.getTime())); }
                if (modifiedFields.contains("BelongId")) { pstmt.setString(pi ++, toDbCh(belongId)); }
                if (modifiedFields.contains("BudgetList")) { pstmt.setString(pi ++, toDbCh(budgetList)); }
                if (modifiedFields.contains("BudgetAmountAll")) { pstmt.setString(pi ++, toDbCh(budgetAmountAll)); }
                if (modifiedFields.contains("ConclusionCheckFlag")) { pstmt.setInt(pi ++, conclusionCheckFlag); }
                if (modifiedFields.contains("ConclusionApplyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(conclusionApplyTime.getTime())); }
                if (modifiedFields.contains("ConclusionCommentAcademy")) { pstmt.setString(pi ++, toDbCh(conclusionCommentAcademy)); }
                if (modifiedFields.contains("ConclusionCommentShelian")) { pstmt.setString(pi ++, toDbCh(conclusionCommentShelian)); }
                if (modifiedFields.contains("ConclusionGeneral")) { pstmt.setString(pi ++, toDbCh(conclusionGeneral)); }
                if (modifiedFields.contains("ConclusionManuscript")) { pstmt.setString(pi ++, toDbCh(conclusionManuscript)); }
                if (modifiedFields.contains("ConclusionCommentClub")) { pstmt.setString(pi ++, toDbCh(conclusionCommentClub)); }
                if (modifiedFields.contains("ConclusionCommentcTuanwei")) { pstmt.setString(pi ++, toDbCh(conclusionCommentcTuanwei)); }
                if (modifiedFields.contains("ConclusionPlanNums")) { pstmt.setString(pi ++, toDbCh(conclusionPlanNums)); }
                if (modifiedFields.contains("ConclusionPlanNames")) { pstmt.setString(pi ++, toDbCh(conclusionPlanNames)); }
                if (modifiedFields.contains("ConclusionBroadcastNums")) { pstmt.setString(pi ++, toDbCh(conclusionBroadcastNums)); }
                if (modifiedFields.contains("ConclusionBroadcastNames")) { pstmt.setString(pi ++, toDbCh(conclusionBroadcastNames)); }
                if (modifiedFields.contains("ConclusionelseNums")) { pstmt.setString(pi ++, toDbCh(conclusionelseNums)); }
                if (modifiedFields.contains("ConclusionelseNames")) { pstmt.setString(pi ++, toDbCh(conclusionelseNames)); }
                if (modifiedFields.contains("ConclusionCost")) { pstmt.setString(pi ++, toDbCh(conclusionCost)); }
                if (modifiedFields.contains("ConclusionIsSupport")) { pstmt.setString(pi ++, toDbCh(conclusionIsSupport)); }
                if (modifiedFields.contains("ConclusionSupportDetail")) { pstmt.setString(pi ++, toDbCh(conclusionSupportDetail)); }
                if (modifiedFields.contains("ConclusionSummary")) { pstmt.setString(pi ++, toDbCh(conclusionSummary)); }
                if (modifiedFields.contains("ConclusionRemark")) { pstmt.setString(pi ++, toDbCh(conclusionRemark)); }
                if (modifiedFields.contains("ActivityLevel")) { pstmt.setString(pi ++, toDbCh(activityLevel)); }
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
                if (modifiedFields.contains("OrgacadeMy")) { pstmt.setString(pi ++, toDbCh(orgacadeMy)); }
                if (modifiedFields.contains("ClubName")) { pstmt.setString(pi ++, toDbCh(clubName)); }
                if (modifiedFields.contains("ClubId")) { pstmt.setString(pi ++, toDbCh(clubId)); }
                if (modifiedFields.contains("TimeStart")) { pstmt.setString(pi ++, toDbCh(timeStart)); }
                if (modifiedFields.contains("TimeEnd")) { pstmt.setString(pi ++, toDbCh(timeEnd)); }
                if (modifiedFields.contains("ActivityPlace")) { pstmt.setString(pi ++, toDbCh(activityPlace)); }
                if (modifiedFields.contains("Organizer")) { pstmt.setString(pi ++, toDbCh(organizer)); }
                if (modifiedFields.contains("PredictNumber")) { pstmt.setString(pi ++, toDbCh(predictNumber)); }
                if (modifiedFields.contains("IsSupported")) { pstmt.setString(pi ++, toDbCh(isSupported)); }
                if (modifiedFields.contains("Contant")) { pstmt.setString(pi ++, toDbCh(contant)); }
                if (modifiedFields.contains("Contacts")) { pstmt.setString(pi ++, toDbCh(contacts)); }
                if (modifiedFields.contains("ContactsPhone")) { pstmt.setString(pi ++, toDbCh(contactsPhone)); }
                if (modifiedFields.contains("Forecast")) { pstmt.setString(pi ++, toDbCh(forecast)); }
                if (modifiedFields.contains("CommentTeacher")) { pstmt.setString(pi ++, toDbCh(commentTeacher)); }
                if (modifiedFields.contains("CommentAcademy")) { pstmt.setString(pi ++, toDbCh(commentAcademy)); }
                if (modifiedFields.contains("CommentShelian")) { pstmt.setString(pi ++, toDbCh(commentShelian)); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("Modiperson")) { pstmt.setString(pi ++, toDbCh(modiperson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("CheckPerson")) { pstmt.setString(pi ++, toDbCh(checkPerson)); }
                if (modifiedFields.contains("ProjectId")) { pstmt.setString(pi ++, toDbCh(projectId)); }
                if (modifiedFields.contains("ProjectName")) { pstmt.setString(pi ++, toDbCh(projectName)); }
                if (modifiedFields.contains("Module")) { pstmt.setString(pi ++, toDbCh(module)); }
                if (modifiedFields.contains("IsatSchool")) { pstmt.setString(pi ++, toDbCh(isatSchool)); }
                if (modifiedFields.contains("ApplyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(applyTime.getTime())); }
                if (modifiedFields.contains("CheckTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(checkTime.getTime())); }
                if (modifiedFields.contains("BelongId")) { pstmt.setString(pi ++, toDbCh(belongId)); }
                if (modifiedFields.contains("BudgetList")) { pstmt.setString(pi ++, toDbCh(budgetList)); }
                if (modifiedFields.contains("BudgetAmountAll")) { pstmt.setString(pi ++, toDbCh(budgetAmountAll)); }
                if (modifiedFields.contains("ConclusionCheckFlag")) { pstmt.setInt(pi ++, conclusionCheckFlag); }
                if (modifiedFields.contains("ConclusionApplyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(conclusionApplyTime.getTime())); }
                if (modifiedFields.contains("ConclusionCommentAcademy")) { pstmt.setString(pi ++, toDbCh(conclusionCommentAcademy)); }
                if (modifiedFields.contains("ConclusionCommentShelian")) { pstmt.setString(pi ++, toDbCh(conclusionCommentShelian)); }
                if (modifiedFields.contains("ConclusionGeneral")) { pstmt.setString(pi ++, toDbCh(conclusionGeneral)); }
                if (modifiedFields.contains("ConclusionManuscript")) { pstmt.setString(pi ++, toDbCh(conclusionManuscript)); }
                if (modifiedFields.contains("ConclusionCommentClub")) { pstmt.setString(pi ++, toDbCh(conclusionCommentClub)); }
                if (modifiedFields.contains("ConclusionCommentcTuanwei")) { pstmt.setString(pi ++, toDbCh(conclusionCommentcTuanwei)); }
                if (modifiedFields.contains("ConclusionPlanNums")) { pstmt.setString(pi ++, toDbCh(conclusionPlanNums)); }
                if (modifiedFields.contains("ConclusionPlanNames")) { pstmt.setString(pi ++, toDbCh(conclusionPlanNames)); }
                if (modifiedFields.contains("ConclusionBroadcastNums")) { pstmt.setString(pi ++, toDbCh(conclusionBroadcastNums)); }
                if (modifiedFields.contains("ConclusionBroadcastNames")) { pstmt.setString(pi ++, toDbCh(conclusionBroadcastNames)); }
                if (modifiedFields.contains("ConclusionelseNums")) { pstmt.setString(pi ++, toDbCh(conclusionelseNums)); }
                if (modifiedFields.contains("ConclusionelseNames")) { pstmt.setString(pi ++, toDbCh(conclusionelseNames)); }
                if (modifiedFields.contains("ConclusionCost")) { pstmt.setString(pi ++, toDbCh(conclusionCost)); }
                if (modifiedFields.contains("ConclusionIsSupport")) { pstmt.setString(pi ++, toDbCh(conclusionIsSupport)); }
                if (modifiedFields.contains("ConclusionSupportDetail")) { pstmt.setString(pi ++, toDbCh(conclusionSupportDetail)); }
                if (modifiedFields.contains("ConclusionSummary")) { pstmt.setString(pi ++, toDbCh(conclusionSummary)); }
                if (modifiedFields.contains("ConclusionRemark")) { pstmt.setString(pi ++, toDbCh(conclusionRemark)); }
                if (modifiedFields.contains("ActivityLevel")) { pstmt.setString(pi ++, toDbCh(activityLevel)); }
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
        map.put("OrgacadeMy", getOrgacadeMy());
        map.put("ClubName", getClubName());
        map.put("ClubId", getClubId());
        map.put("TimeStart", getTimeStart());
        map.put("TimeEnd", getTimeEnd());
        map.put("ActivityPlace", getActivityPlace());
        map.put("Organizer", getOrganizer());
        map.put("PredictNumber", getPredictNumber());
        map.put("IsSupported", getIsSupported());
        map.put("Contant", getContant());
        map.put("Contacts", getContacts());
        map.put("ContactsPhone", getContactsPhone());
        map.put("Forecast", getForecast());
        map.put("CommentTeacher", getCommentTeacher());
        map.put("CommentAcademy", getCommentAcademy());
        map.put("CommentShelian", getCommentShelian());
        map.put("CheckFlag", getCheckFlag() + "");
        map.put("Remark", getRemark());
        map.put("AddPerson", getAddPerson());
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("Modiperson", getModiperson());
        map.put("ModiTime", Tool.stringOfDateTime(getModiTime()));
        map.put("CheckPerson", getCheckPerson());
        map.put("ProjectId", getProjectId());
        map.put("ProjectName", getProjectName());
        map.put("Module", getModule());
        map.put("IsatSchool", getIsatSchool());
        map.put("ApplyTime", Tool.stringOfDateTime(getApplyTime()));
        map.put("CheckTime", Tool.stringOfDateTime(getCheckTime()));
        map.put("BelongId", getBelongId());
        map.put("BudgetList", getBudgetList());
        map.put("BudgetAmountAll", getBudgetAmountAll());
        map.put("ConclusionCheckFlag", getConclusionCheckFlag() + "");
        map.put("ConclusionApplyTime", Tool.stringOfDateTime(getConclusionApplyTime()));
        map.put("ConclusionCommentAcademy", getConclusionCommentAcademy());
        map.put("ConclusionCommentShelian", getConclusionCommentShelian());
        map.put("ConclusionGeneral", getConclusionGeneral());
        map.put("ConclusionManuscript", getConclusionManuscript());
        map.put("ConclusionCommentClub", getConclusionCommentClub());
        map.put("ConclusionCommentcTuanwei", getConclusionCommentcTuanwei());
        map.put("ConclusionPlanNums", getConclusionPlanNums());
        map.put("ConclusionPlanNames", getConclusionPlanNames());
        map.put("ConclusionBroadcastNums", getConclusionBroadcastNums());
        map.put("ConclusionBroadcastNames", getConclusionBroadcastNames());
        map.put("ConclusionelseNums", getConclusionelseNums());
        map.put("ConclusionelseNames", getConclusionelseNames());
        map.put("ConclusionCost", getConclusionCost());
        map.put("ConclusionIsSupport", getConclusionIsSupport());
        map.put("ConclusionSupportDetail", getConclusionSupportDetail());
        map.put("ConclusionSummary", getConclusionSummary());
        map.put("ConclusionRemark", getConclusionRemark());
        map.put("ActivityLevel", getActivityLevel());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("ActivityName:\"" + Tool.jsSpecialChars(getActivityName()) + "\"");
        row.add("OrgacadeMy:\"" + Tool.jsSpecialChars(getOrgacadeMy()) + "\"");
        row.add("ClubName:\"" + Tool.jsSpecialChars(getClubName()) + "\"");
        row.add("ClubId:\"" + Tool.jsSpecialChars(getClubId()) + "\"");
        row.add("TimeStart:\"" + Tool.jsSpecialChars(getTimeStart()) + "\"");
        row.add("TimeEnd:\"" + Tool.jsSpecialChars(getTimeEnd()) + "\"");
        row.add("ActivityPlace:\"" + Tool.jsSpecialChars(getActivityPlace()) + "\"");
        row.add("Organizer:\"" + Tool.jsSpecialChars(getOrganizer()) + "\"");
        row.add("PredictNumber:\"" + Tool.jsSpecialChars(getPredictNumber()) + "\"");
        row.add("IsSupported:\"" + Tool.jsSpecialChars(getIsSupported()) + "\"");
        row.add("Contant:\"" + Tool.jsSpecialChars(getContant()) + "\"");
        row.add("Contacts:\"" + Tool.jsSpecialChars(getContacts()) + "\"");
        row.add("ContactsPhone:\"" + Tool.jsSpecialChars(getContactsPhone()) + "\"");
        row.add("Forecast:\"" + Tool.jsSpecialChars(getForecast()) + "\"");
        row.add("CommentTeacher:\"" + Tool.jsSpecialChars(getCommentTeacher()) + "\"");
        row.add("CommentAcademy:\"" + Tool.jsSpecialChars(getCommentAcademy()) + "\"");
        row.add("CommentShelian:\"" + Tool.jsSpecialChars(getCommentShelian()) + "\"");
        row.add("CheckFlag:\"" + getCheckFlag() + "\"");
        row.add("Remark:\"" + Tool.jsSpecialChars(getRemark()) + "\"");
        row.add("AddPerson:\"" + Tool.jsSpecialChars(getAddPerson()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("Modiperson:\"" + Tool.jsSpecialChars(getModiperson()) + "\"");
        row.add("ModiTime:\"" + Tool.stringOfDateTime(getModiTime()) + "\"");
        row.add("CheckPerson:\"" + Tool.jsSpecialChars(getCheckPerson()) + "\"");
        row.add("ProjectId:\"" + Tool.jsSpecialChars(getProjectId()) + "\"");
        row.add("ProjectName:\"" + Tool.jsSpecialChars(getProjectName()) + "\"");
        row.add("Module:\"" + Tool.jsSpecialChars(getModule()) + "\"");
        row.add("IsatSchool:\"" + Tool.jsSpecialChars(getIsatSchool()) + "\"");
        row.add("ApplyTime:\"" + Tool.stringOfDateTime(getApplyTime()) + "\"");
        row.add("CheckTime:\"" + Tool.stringOfDateTime(getCheckTime()) + "\"");
        row.add("BelongId:\"" + Tool.jsSpecialChars(getBelongId()) + "\"");
        row.add("BudgetList:\"" + Tool.jsSpecialChars(getBudgetList()) + "\"");
        row.add("BudgetAmountAll:\"" + Tool.jsSpecialChars(getBudgetAmountAll()) + "\"");
        row.add("ConclusionCheckFlag:\"" + getConclusionCheckFlag() + "\"");
        row.add("ConclusionApplyTime:\"" + Tool.stringOfDateTime(getConclusionApplyTime()) + "\"");
        row.add("ConclusionCommentAcademy:\"" + Tool.jsSpecialChars(getConclusionCommentAcademy()) + "\"");
        row.add("ConclusionCommentShelian:\"" + Tool.jsSpecialChars(getConclusionCommentShelian()) + "\"");
        row.add("ConclusionGeneral:\"" + Tool.jsSpecialChars(getConclusionGeneral()) + "\"");
        row.add("ConclusionManuscript:\"" + Tool.jsSpecialChars(getConclusionManuscript()) + "\"");
        row.add("ConclusionCommentClub:\"" + Tool.jsSpecialChars(getConclusionCommentClub()) + "\"");
        row.add("ConclusionCommentcTuanwei:\"" + Tool.jsSpecialChars(getConclusionCommentcTuanwei()) + "\"");
        row.add("ConclusionPlanNums:\"" + Tool.jsSpecialChars(getConclusionPlanNums()) + "\"");
        row.add("ConclusionPlanNames:\"" + Tool.jsSpecialChars(getConclusionPlanNames()) + "\"");
        row.add("ConclusionBroadcastNums:\"" + Tool.jsSpecialChars(getConclusionBroadcastNums()) + "\"");
        row.add("ConclusionBroadcastNames:\"" + Tool.jsSpecialChars(getConclusionBroadcastNames()) + "\"");
        row.add("ConclusionelseNums:\"" + Tool.jsSpecialChars(getConclusionelseNums()) + "\"");
        row.add("ConclusionelseNames:\"" + Tool.jsSpecialChars(getConclusionelseNames()) + "\"");
        row.add("ConclusionCost:\"" + Tool.jsSpecialChars(getConclusionCost()) + "\"");
        row.add("ConclusionIsSupport:\"" + Tool.jsSpecialChars(getConclusionIsSupport()) + "\"");
        row.add("ConclusionSupportDetail:\"" + Tool.jsSpecialChars(getConclusionSupportDetail()) + "\"");
        row.add("ConclusionSummary:\"" + Tool.jsSpecialChars(getConclusionSummary()) + "\"");
        row.add("ConclusionRemark:\"" + Tool.jsSpecialChars(getConclusionRemark()) + "\"");
        row.add("ActivityLevel:\"" + Tool.jsSpecialChars(getActivityLevel()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,activityname varchar2(45),orgacademy varchar2(45),clubname varchar2(45),clubid varchar2(45),timestart varchar2(45),timeend varchar2(45),activityplace varchar2(45),organizer varchar2(45),predictnumber varchar2(10),issupported varchar2(5),contant varchar2(500),contacts varchar2(45),contactsphone varchar2(45),forecast varchar2(500),commentteacher varchar2(200),commentacademy varchar2(200),commentshelian varchar2(200),checkflag number(*,0),remark varchar2(500),addperson varchar2(45),addtime date,modiperson varchar2(45),moditime date,checkperson varchar2(45),projectid varchar2(45),projectname varchar2(45),module varchar2(45),isatschool varchar2(5),applytime date,checktime date,belongid varchar2(45),budgetlist varchar2(2000),budgetamountall varchar2(45),conclusioncheckflag number(*,0),conclusionapplytime date,conclusioncommentacademy varchar2(2000),conclusioncommentshelian varchar2(500),conclusiongeneral varchar2(1000),conclusionmanuscript varchar2(500),conclusioncommentclub varchar2(500),conclusioncommentctuanwei varchar2(500),conclusionplannums varchar2(5),conclusionplannames varchar2(500),conclusionbroadcastnums varchar2(5),conclusionbroadcastnames varchar2(500),conclusionelsenums varchar2(5),conclusionelsenames varchar2(2000),conclusioncost varchar2(20),conclusionissupport varchar2(5),conclusionsupportdetail varchar2(500),conclusionsummary varchar2(1000),conclusionremark varchar2(1000),activitylevel varchar2(15))"});
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
        ClubActivities v = new ClubActivities(sourceDb, sourceTb);
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
        ClubActivities v = new ClubActivities(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(ClubActivities obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getActivityName().compareTo(obj.getActivityName()); if (rtn != 0) return rtn;
        rtn = getOrgacadeMy().compareTo(obj.getOrgacadeMy()); if (rtn != 0) return rtn;
        rtn = getClubName().compareTo(obj.getClubName()); if (rtn != 0) return rtn;
        rtn = getClubId().compareTo(obj.getClubId()); if (rtn != 0) return rtn;
        rtn = getTimeStart().compareTo(obj.getTimeStart()); if (rtn != 0) return rtn;
        rtn = getTimeEnd().compareTo(obj.getTimeEnd()); if (rtn != 0) return rtn;
        rtn = getActivityPlace().compareTo(obj.getActivityPlace()); if (rtn != 0) return rtn;
        rtn = getOrganizer().compareTo(obj.getOrganizer()); if (rtn != 0) return rtn;
        rtn = getPredictNumber().compareTo(obj.getPredictNumber()); if (rtn != 0) return rtn;
        rtn = getIsSupported().compareTo(obj.getIsSupported()); if (rtn != 0) return rtn;
        rtn = getContant().compareTo(obj.getContant()); if (rtn != 0) return rtn;
        rtn = getContacts().compareTo(obj.getContacts()); if (rtn != 0) return rtn;
        rtn = getContactsPhone().compareTo(obj.getContactsPhone()); if (rtn != 0) return rtn;
        rtn = getForecast().compareTo(obj.getForecast()); if (rtn != 0) return rtn;
        rtn = getCommentTeacher().compareTo(obj.getCommentTeacher()); if (rtn != 0) return rtn;
        rtn = getCommentAcademy().compareTo(obj.getCommentAcademy()); if (rtn != 0) return rtn;
        rtn = getCommentShelian().compareTo(obj.getCommentShelian()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckFlag()).compareTo("" + obj.getCheckFlag()); if (rtn != 0) return rtn;
        rtn = getRemark().compareTo(obj.getRemark()); if (rtn != 0) return rtn;
        rtn = getAddPerson().compareTo(obj.getAddPerson()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = getModiperson().compareTo(obj.getModiperson()); if (rtn != 0) return rtn;
        rtn = getModiTime().compareTo(obj.getModiTime()); if (rtn != 0) return rtn;
        rtn = getCheckPerson().compareTo(obj.getCheckPerson()); if (rtn != 0) return rtn;
        rtn = getProjectId().compareTo(obj.getProjectId()); if (rtn != 0) return rtn;
        rtn = getProjectName().compareTo(obj.getProjectName()); if (rtn != 0) return rtn;
        rtn = getModule().compareTo(obj.getModule()); if (rtn != 0) return rtn;
        rtn = getIsatSchool().compareTo(obj.getIsatSchool()); if (rtn != 0) return rtn;
        rtn = getApplyTime().compareTo(obj.getApplyTime()); if (rtn != 0) return rtn;
        rtn = getCheckTime().compareTo(obj.getCheckTime()); if (rtn != 0) return rtn;
        rtn = getBelongId().compareTo(obj.getBelongId()); if (rtn != 0) return rtn;
        rtn = getBudgetList().compareTo(obj.getBudgetList()); if (rtn != 0) return rtn;
        rtn = getBudgetAmountAll().compareTo(obj.getBudgetAmountAll()); if (rtn != 0) return rtn;
        rtn = ("" + getConclusionCheckFlag()).compareTo("" + obj.getConclusionCheckFlag()); if (rtn != 0) return rtn;
        rtn = getConclusionApplyTime().compareTo(obj.getConclusionApplyTime()); if (rtn != 0) return rtn;
        rtn = getConclusionCommentAcademy().compareTo(obj.getConclusionCommentAcademy()); if (rtn != 0) return rtn;
        rtn = getConclusionCommentShelian().compareTo(obj.getConclusionCommentShelian()); if (rtn != 0) return rtn;
        rtn = getConclusionGeneral().compareTo(obj.getConclusionGeneral()); if (rtn != 0) return rtn;
        rtn = getConclusionManuscript().compareTo(obj.getConclusionManuscript()); if (rtn != 0) return rtn;
        rtn = getConclusionCommentClub().compareTo(obj.getConclusionCommentClub()); if (rtn != 0) return rtn;
        rtn = getConclusionCommentcTuanwei().compareTo(obj.getConclusionCommentcTuanwei()); if (rtn != 0) return rtn;
        rtn = getConclusionPlanNums().compareTo(obj.getConclusionPlanNums()); if (rtn != 0) return rtn;
        rtn = getConclusionPlanNames().compareTo(obj.getConclusionPlanNames()); if (rtn != 0) return rtn;
        rtn = getConclusionBroadcastNums().compareTo(obj.getConclusionBroadcastNums()); if (rtn != 0) return rtn;
        rtn = getConclusionBroadcastNames().compareTo(obj.getConclusionBroadcastNames()); if (rtn != 0) return rtn;
        rtn = getConclusionelseNums().compareTo(obj.getConclusionelseNums()); if (rtn != 0) return rtn;
        rtn = getConclusionelseNames().compareTo(obj.getConclusionelseNames()); if (rtn != 0) return rtn;
        rtn = getConclusionCost().compareTo(obj.getConclusionCost()); if (rtn != 0) return rtn;
        rtn = getConclusionIsSupport().compareTo(obj.getConclusionIsSupport()); if (rtn != 0) return rtn;
        rtn = getConclusionSupportDetail().compareTo(obj.getConclusionSupportDetail()); if (rtn != 0) return rtn;
        rtn = getConclusionSummary().compareTo(obj.getConclusionSummary()); if (rtn != 0) return rtn;
        rtn = getConclusionRemark().compareTo(obj.getConclusionRemark()); if (rtn != 0) return rtn;
        rtn = getActivityLevel().compareTo(obj.getActivityLevel()); if (rtn != 0) return rtn;
        return rtn;
    }
}
