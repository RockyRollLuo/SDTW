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
@Description("志愿竞赛报名表")
public class VolunteerProjectParticipate implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(VolunteerProjectParticipate.class);
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
    public static final String DbTableName = "volunteer_project_participate";
    private String TNAME = "volunteer_project_participate";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","projectId","sno","honour","submitFlag","checkFlag","xycheckFalg","checkComments","addAccount","addtime","checkAccount","checkTime","academy","projectName","teamName","teamUnit","registerId","setupTime","zipCode","contactAddress","inspectionConclution","assLevel","dutyFree","startTime","projectArea","impleArea","participateNum","fulltimeNum","award","content","meanings","disiredResults","implePlace","promotion","specialist","beneFicaiaries","benenum","majorName","majorSex","majorBirth","majorDuty","majorPolista","majorPhone","majorPhone2","majorEmail","guideTeacherName","guideTeacherSex","guideTeacherBirth","guideTeacherDuty","guideTeacherPolista","guideTeacherPhone","guideTeacherPhone2","guiderTeacherEmail","addFileList"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","projectid","sno","honour","submitflag","checkflag","xycheckfalg","checkcomments","addaccount","addtime","checkaccount","checktime","academy","projectname","teamname","teamunit","registerid","setuptime","zipcode","contactaddress","inspectionconclution","asslevel","dutyfree","starttime","projectarea","implearea","participatenum","fulltimenum","award","content","meanings","disiredresults","impleplace","promotion","specialist","beneficaiaries","benenum","majorname","majorsex","majorbirth","majorduty","majorpolista","majorphone","majorphone2","majoremail","guideteachername","guideteachersex","guideteacherbirth","guideteacherduty","guideteacherpolista","guideteacherphone","guideteacherphone2","guiderteacheremail","addfilelist"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"ProjectId","projectid","int"},{"Sno","sno","String"},{"Honour","honour","String"},{"SubmitFlag","submitflag","int"},{"CheckFlag","checkflag","int"},{"XycheckFalg","xycheckfalg","int"},{"CheckComments","checkcomments","String"},{"AddAccount","addaccount","String"},{"Addtime","addtime","java.util.Date"},{"CheckAccount","checkaccount","String"},{"CheckTime","checktime","java.util.Date"},{"Academy","academy","String"},{"ProjectName","projectname","String"},{"TeamName","teamname","String"},{"TeamUnit","teamunit","String"},{"RegisterId","registerid","String"},{"SetupTime","setuptime","java.util.Date"},{"ZipCode","zipcode","String"},{"ContactAddress","contactaddress","String"},{"InspectionConclution","inspectionconclution","String"},{"AssLevel","asslevel","String"},{"DutyFree","dutyfree","String"},{"StartTime","starttime","java.util.Date"},{"ProjectArea","projectarea","String"},{"ImpleArea","implearea","String"},{"ParticipateNum","participatenum","int"},{"FulltimeNum","fulltimenum","int"},{"Award","award","String"},{"Content","content","String"},{"Meanings","meanings","String"},{"DisiredResults","disiredresults","String"},{"ImplePlace","impleplace","String"},{"Promotion","promotion","String"},{"Specialist","specialist","String"},{"BeneFicaiaries","beneficaiaries","String"},{"Benenum","benenum","int"},{"MajorName","majorname","String"},{"MajorSex","majorsex","String"},{"MajorBirth","majorbirth","String"},{"MajorDuty","majorduty","String"},{"MajorPolista","majorpolista","String"},{"MajorPhone","majorphone","String"},{"MajorPhone2","majorphone2","String"},{"MajorEmail","majoremail","String"},{"GuideTeacherName","guideteachername","String"},{"GuideTeacherSex","guideteachersex","String"},{"GuideTeacherBirth","guideteacherbirth","String"},{"GuideTeacherDuty","guideteacherduty","String"},{"GuideTeacherPolista","guideteacherpolista","String"},{"GuideTeacherPhone","guideteacherphone","String"},{"GuideTeacherPhone2","guideteacherphone2","String"},{"GuiderTeacherEmail","guiderteacheremail","String"},{"AddFileList","addfilelist","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"projectId","projectid"},{"sno","sno"},{"honour","honour"},{"submitFlag","submitflag"},{"checkFlag","checkflag"},{"xycheckFalg","xycheckfalg"},{"checkComments","checkcomments"},{"addAccount","addaccount"},{"addtime","addtime"},{"checkAccount","checkaccount"},{"checkTime","checktime"},{"academy","academy"},{"projectName","projectname"},{"teamName","teamname"},{"teamUnit","teamunit"},{"registerId","registerid"},{"setupTime","setuptime"},{"zipCode","zipcode"},{"contactAddress","contactaddress"},{"inspectionConclution","inspectionconclution"},{"assLevel","asslevel"},{"dutyFree","dutyfree"},{"startTime","starttime"},{"projectArea","projectarea"},{"impleArea","implearea"},{"participateNum","participatenum"},{"fulltimeNum","fulltimenum"},{"award","award"},{"content","content"},{"meanings","meanings"},{"disiredResults","disiredresults"},{"implePlace","impleplace"},{"promotion","promotion"},{"specialist","specialist"},{"beneFicaiaries","beneficaiaries"},{"benenum","benenum"},{"majorName","majorname"},{"majorSex","majorsex"},{"majorBirth","majorbirth"},{"majorDuty","majorduty"},{"majorPolista","majorpolista"},{"majorPhone","majorphone"},{"majorPhone2","majorphone2"},{"majorEmail","majoremail"},{"guideTeacherName","guideteachername"},{"guideTeacherSex","guideteachersex"},{"guideTeacherBirth","guideteacherbirth"},{"guideTeacherDuty","guideteacherduty"},{"guideTeacherPolista","guideteacherpolista"},{"guideTeacherPhone","guideteacherphone"},{"guideTeacherPhone2","guideteacherphone2"},{"guiderTeacherEmail","guiderteacheremail"},{"addFileList","addfilelist"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME","CHECKTIME","SETUPTIME","STARTTIME"};
    public String[] getDateFields () {return _dateFields;};
    // id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 志愿竞赛项目id
    protected int projectId = -1;
    public int getProjectId() { return projectId; }
    public void setProjectId(int aProjectId) { projectId = aProjectId; modifiedFields.add("ProjectId"); }
    public void assignProjectId(int aProjectId) { projectId = aProjectId; }
    public void paramProjectId(HttpServletRequest request) { paramProjectId(request, "ProjectId"); }
    public void paramProjectId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getProjectId()); if (tmp != getProjectId()) { setProjectId(tmp); } }
    // 学生学号
    protected String sno = "";
    public String getSno() {  return SqlTool.getDbString(sno);  }
    public String getSno(int size) { return SqlTool.subString(getSno(), size); }
    public void setSno(String aSno) { sno = aSno; modifiedFields.add("Sno"); }
    public void assignSno(String aSno) { sno = aSno; }
    public void paramSno(HttpServletRequest request) { paramSno(request, "Sno"); }
    public void paramSno(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSno()); if (!tmp.equals(getSno())) { setSno(tmp); } }
    // 荣誉名称
    protected String honour = "";
    public String getHonour() {  return SqlTool.getDbString(honour);  }
    public String getHonour(int size) { return SqlTool.subString(getHonour(), size); }
    public void setHonour(String aHonour) { honour = aHonour; modifiedFields.add("Honour"); }
    public void assignHonour(String aHonour) { honour = aHonour; }
    public void paramHonour(HttpServletRequest request) { paramHonour(request, "Honour"); }
    public void paramHonour(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHonour()); if (!tmp.equals(getHonour())) { setHonour(tmp); } }
    // 提交标志
    protected int submitFlag = -1;
    public int getSubmitFlag() { return submitFlag; }
    public void setSubmitFlag(int aSubmitFlag) { submitFlag = aSubmitFlag; modifiedFields.add("SubmitFlag"); }
    public void assignSubmitFlag(int aSubmitFlag) { submitFlag = aSubmitFlag; }
    public void paramSubmitFlag(HttpServletRequest request) { paramSubmitFlag(request, "SubmitFlag"); }
    public void paramSubmitFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getSubmitFlag()); if (tmp != getSubmitFlag()) { setSubmitFlag(tmp); } }
    // 团委审核标志
    protected int checkFlag = -1;
    public int getCheckFlag() { return checkFlag; }
    public void setCheckFlag(int aCheckFlag) { checkFlag = aCheckFlag; modifiedFields.add("CheckFlag"); }
    public void assignCheckFlag(int aCheckFlag) { checkFlag = aCheckFlag; }
    public void paramCheckFlag(HttpServletRequest request) { paramCheckFlag(request, "CheckFlag"); }
    public void paramCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckFlag()); if (tmp != getCheckFlag()) { setCheckFlag(tmp); } }
    // 学院审核标志
    protected int xycheckFalg = -1;
    public int getXycheckFalg() { return xycheckFalg; }
    public void setXycheckFalg(int aXycheckFalg) { xycheckFalg = aXycheckFalg; modifiedFields.add("XycheckFalg"); }
    public void assignXycheckFalg(int aXycheckFalg) { xycheckFalg = aXycheckFalg; }
    public void paramXycheckFalg(HttpServletRequest request) { paramXycheckFalg(request, "XycheckFalg"); }
    public void paramXycheckFalg(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getXycheckFalg()); if (tmp != getXycheckFalg()) { setXycheckFalg(tmp); } }
    // 审批意见
    protected String checkComments = "";
    public String getCheckComments() {  return SqlTool.getDbString(checkComments);  }
    public String getCheckComments(int size) { return SqlTool.subString(getCheckComments(), size); }
    public void setCheckComments(String aCheckComments) { checkComments = aCheckComments; modifiedFields.add("CheckComments"); }
    public void assignCheckComments(String aCheckComments) { checkComments = aCheckComments; }
    public void paramCheckComments(HttpServletRequest request) { paramCheckComments(request, "CheckComments"); }
    public void paramCheckComments(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCheckComments()); if (!tmp.equals(getCheckComments())) { setCheckComments(tmp); } }
    // 添加账号
    protected String addAccount = "";
    public String getAddAccount() {  return SqlTool.getDbString(addAccount);  }
    public String getAddAccount(int size) { return SqlTool.subString(getAddAccount(), size); }
    public void setAddAccount(String aAddAccount) { addAccount = aAddAccount; modifiedFields.add("AddAccount"); }
    public void assignAddAccount(String aAddAccount) { addAccount = aAddAccount; }
    public void paramAddAccount(HttpServletRequest request) { paramAddAccount(request, "AddAccount"); }
    public void paramAddAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddAccount()); if (!tmp.equals(getAddAccount())) { setAddAccount(tmp); } }
    // 添加时间
    protected java.util.Date addtime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddtime() { return addtime; }
    public void setAddtime(java.util.Date aAddtime) { addtime = aAddtime; modifiedFields.add("Addtime"); }
    public void assignAddtime(java.util.Date aAddtime) { addtime = aAddtime; }
    public void paramAddtime(HttpServletRequest request) { paramAddtime(request, "Addtime"); }
    public void paramAddtime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddtime()); if (tmp.compareTo(getAddtime()) != 0) { setAddtime(tmp); } }
    // 审核账号
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
    // 所属学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 项目名称
    protected String projectName = "";
    public String getProjectName() {  return SqlTool.getDbString(projectName);  }
    public String getProjectName(int size) { return SqlTool.subString(getProjectName(), size); }
    public void setProjectName(String aProjectName) { projectName = aProjectName; modifiedFields.add("ProjectName"); }
    public void assignProjectName(String aProjectName) { projectName = aProjectName; }
    public void paramProjectName(HttpServletRequest request) { paramProjectName(request, "ProjectName"); }
    public void paramProjectName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectName()); if (!tmp.equals(getProjectName())) { setProjectName(tmp); } }
    // 团队名称
    protected String teamName = "";
    public String getTeamName() {  return SqlTool.getDbString(teamName);  }
    public String getTeamName(int size) { return SqlTool.subString(getTeamName(), size); }
    public void setTeamName(String aTeamName) { teamName = aTeamName; modifiedFields.add("TeamName"); }
    public void assignTeamName(String aTeamName) { teamName = aTeamName; }
    public void paramTeamName(HttpServletRequest request) { paramTeamName(request, "TeamName"); }
    public void paramTeamName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeamName()); if (!tmp.equals(getTeamName())) { setTeamName(tmp); } }
    // 团队主管单位
    protected String teamUnit = "";
    public String getTeamUnit() {  return SqlTool.getDbString(teamUnit);  }
    public String getTeamUnit(int size) { return SqlTool.subString(getTeamUnit(), size); }
    public void setTeamUnit(String aTeamUnit) { teamUnit = aTeamUnit; modifiedFields.add("TeamUnit"); }
    public void assignTeamUnit(String aTeamUnit) { teamUnit = aTeamUnit; }
    public void paramTeamUnit(HttpServletRequest request) { paramTeamUnit(request, "TeamUnit"); }
    public void paramTeamUnit(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeamUnit()); if (!tmp.equals(getTeamUnit())) { setTeamUnit(tmp); } }
    // 登记时间
    protected String registerId = "";
    public String getRegisterId() {  return SqlTool.getDbString(registerId);  }
    public String getRegisterId(int size) { return SqlTool.subString(getRegisterId(), size); }
    public void setRegisterId(String aRegisterId) { registerId = aRegisterId; modifiedFields.add("RegisterId"); }
    public void assignRegisterId(String aRegisterId) { registerId = aRegisterId; }
    public void paramRegisterId(HttpServletRequest request) { paramRegisterId(request, "RegisterId"); }
    public void paramRegisterId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRegisterId()); if (!tmp.equals(getRegisterId())) { setRegisterId(tmp); } }
    // 成立时间
    protected java.util.Date setupTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getSetupTime() { return setupTime; }
    public void setSetupTime(java.util.Date aSetupTime) { setupTime = aSetupTime; modifiedFields.add("SetupTime"); }
    public void assignSetupTime(java.util.Date aSetupTime) { setupTime = aSetupTime; }
    public void paramSetupTime(HttpServletRequest request) { paramSetupTime(request, "SetupTime"); }
    public void paramSetupTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getSetupTime()); if (tmp.compareTo(getSetupTime()) != 0) { setSetupTime(tmp); } }
    // 邮政编码
    protected String zipCode = "";
    public String getZipCode() {  return SqlTool.getDbString(zipCode);  }
    public String getZipCode(int size) { return SqlTool.subString(getZipCode(), size); }
    public void setZipCode(String aZipCode) { zipCode = aZipCode; modifiedFields.add("ZipCode"); }
    public void assignZipCode(String aZipCode) { zipCode = aZipCode; }
    public void paramZipCode(HttpServletRequest request) { paramZipCode(request, "ZipCode"); }
    public void paramZipCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getZipCode()); if (!tmp.equals(getZipCode())) { setZipCode(tmp); } }
    // 通讯地址
    protected String contactAddress = "";
    public String getContactAddress() {  return SqlTool.getDbString(contactAddress);  }
    public String getContactAddress(int size) { return SqlTool.subString(getContactAddress(), size); }
    public void setContactAddress(String aContactAddress) { contactAddress = aContactAddress; modifiedFields.add("ContactAddress"); }
    public void assignContactAddress(String aContactAddress) { contactAddress = aContactAddress; }
    public void paramContactAddress(HttpServletRequest request) { paramContactAddress(request, "ContactAddress"); }
    public void paramContactAddress(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getContactAddress()); if (!tmp.equals(getContactAddress())) { setContactAddress(tmp); } }
    // 年度年检结论
    protected String inspectionConclution = "";
    public String getInspectionConclution() {  return SqlTool.getDbString(inspectionConclution);  }
    public String getInspectionConclution(int size) { return SqlTool.subString(getInspectionConclution(), size); }
    public void setInspectionConclution(String aInspectionConclution) { inspectionConclution = aInspectionConclution; modifiedFields.add("InspectionConclution"); }
    public void assignInspectionConclution(String aInspectionConclution) { inspectionConclution = aInspectionConclution; }
    public void paramInspectionConclution(HttpServletRequest request) { paramInspectionConclution(request, "InspectionConclution"); }
    public void paramInspectionConclution(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getInspectionConclution()); if (!tmp.equals(getInspectionConclution())) { setInspectionConclution(tmp); } }
    // 评估等级
    protected String assLevel = "";
    public String getAssLevel() {  return SqlTool.getDbString(assLevel);  }
    public String getAssLevel(int size) { return SqlTool.subString(getAssLevel(), size); }
    public void setAssLevel(String aAssLevel) { assLevel = aAssLevel; modifiedFields.add("AssLevel"); }
    public void assignAssLevel(String aAssLevel) { assLevel = aAssLevel; }
    public void paramAssLevel(HttpServletRequest request) { paramAssLevel(request, "AssLevel"); }
    public void paramAssLevel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAssLevel()); if (!tmp.equals(getAssLevel())) { setAssLevel(tmp); } }
    // 有无免税资格
    protected String dutyFree = "";
    public String getDutyFree() {  return SqlTool.getDbString(dutyFree);  }
    public String getDutyFree(int size) { return SqlTool.subString(getDutyFree(), size); }
    public void setDutyFree(String aDutyFree) { dutyFree = aDutyFree; modifiedFields.add("DutyFree"); }
    public void assignDutyFree(String aDutyFree) { dutyFree = aDutyFree; }
    public void paramDutyFree(HttpServletRequest request) { paramDutyFree(request, "DutyFree"); }
    public void paramDutyFree(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDutyFree()); if (!tmp.equals(getDutyFree())) { setDutyFree(tmp); } }
    // 项目实施时间
    protected java.util.Date startTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getStartTime() { return startTime; }
    public void setStartTime(java.util.Date aStartTime) { startTime = aStartTime; modifiedFields.add("StartTime"); }
    public void assignStartTime(java.util.Date aStartTime) { startTime = aStartTime; }
    public void paramStartTime(HttpServletRequest request) { paramStartTime(request, "StartTime"); }
    public void paramStartTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getStartTime()); if (tmp.compareTo(getStartTime()) != 0) { setStartTime(tmp); } }
    // 项目领域
    protected String projectArea = "";
    public String getProjectArea() {  return SqlTool.getDbString(projectArea);  }
    public String getProjectArea(int size) { return SqlTool.subString(getProjectArea(), size); }
    public void setProjectArea(String aProjectArea) { projectArea = aProjectArea; modifiedFields.add("ProjectArea"); }
    public void assignProjectArea(String aProjectArea) { projectArea = aProjectArea; }
    public void paramProjectArea(HttpServletRequest request) { paramProjectArea(request, "ProjectArea"); }
    public void paramProjectArea(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectArea()); if (!tmp.equals(getProjectArea())) { setProjectArea(tmp); } }
    // 实施领域
    protected String impleArea = "";
    public String getImpleArea() {  return SqlTool.getDbString(impleArea);  }
    public String getImpleArea(int size) { return SqlTool.subString(getImpleArea(), size); }
    public void setImpleArea(String aImpleArea) { impleArea = aImpleArea; modifiedFields.add("ImpleArea"); }
    public void assignImpleArea(String aImpleArea) { impleArea = aImpleArea; }
    public void paramImpleArea(HttpServletRequest request) { paramImpleArea(request, "ImpleArea"); }
    public void paramImpleArea(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getImpleArea()); if (!tmp.equals(getImpleArea())) { setImpleArea(tmp); } }
    // 参与项目运作人数
    protected int participateNum = -1;
    public int getParticipateNum() { return participateNum; }
    public void setParticipateNum(int aParticipateNum) { participateNum = aParticipateNum; modifiedFields.add("ParticipateNum"); }
    public void assignParticipateNum(int aParticipateNum) { participateNum = aParticipateNum; }
    public void paramParticipateNum(HttpServletRequest request) { paramParticipateNum(request, "ParticipateNum"); }
    public void paramParticipateNum(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getParticipateNum()); if (tmp != getParticipateNum()) { setParticipateNum(tmp); } }
    // 专职人员人数
    protected int fulltimeNum = -1;
    public int getFulltimeNum() { return fulltimeNum; }
    public void setFulltimeNum(int aFulltimeNum) { fulltimeNum = aFulltimeNum; modifiedFields.add("FulltimeNum"); }
    public void assignFulltimeNum(int aFulltimeNum) { fulltimeNum = aFulltimeNum; }
    public void paramFulltimeNum(HttpServletRequest request) { paramFulltimeNum(request, "FulltimeNum"); }
    public void paramFulltimeNum(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getFulltimeNum()); if (tmp != getFulltimeNum()) { setFulltimeNum(tmp); } }
    // 曾获何等奖励
    protected String award = "";
    public String getAward() {  return SqlTool.getDbString(award);  }
    public String getAward(int size) { return SqlTool.subString(getAward(), size); }
    public void setAward(String aAward) { award = aAward; modifiedFields.add("Award"); }
    public void assignAward(String aAward) { award = aAward; }
    public void paramAward(HttpServletRequest request) { paramAward(request, "Award"); }
    public void paramAward(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAward()); if (!tmp.equals(getAward())) { setAward(tmp); } }
    // 项目内容
    protected String content = "";
    public String getContent() {  return SqlTool.getDbString(content);  }
    public String getContent(int size) { return SqlTool.subString(getContent(), size); }
    public void setContent(String aContent) { content = aContent; modifiedFields.add("Content"); }
    public void assignContent(String aContent) { content = aContent; }
    public void paramContent(HttpServletRequest request) { paramContent(request, "Content"); }
    public void paramContent(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getContent()); if (!tmp.equals(getContent())) { setContent(tmp); } }
    // 项目背景意义
    protected String meanings = "";
    public String getMeanings() {  return SqlTool.getDbString(meanings);  }
    public String getMeanings(int size) { return SqlTool.subString(getMeanings(), size); }
    public void setMeanings(String aMeanings) { meanings = aMeanings; modifiedFields.add("Meanings"); }
    public void assignMeanings(String aMeanings) { meanings = aMeanings; }
    public void paramMeanings(HttpServletRequest request) { paramMeanings(request, "Meanings"); }
    public void paramMeanings(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMeanings()); if (!tmp.equals(getMeanings())) { setMeanings(tmp); } }
    // 项目预计效果
    protected String disiredResults = "";
    public String getDisiredResults() {  return SqlTool.getDbString(disiredResults);  }
    public String getDisiredResults(int size) { return SqlTool.subString(getDisiredResults(), size); }
    public void setDisiredResults(String aDisiredResults) { disiredResults = aDisiredResults; modifiedFields.add("DisiredResults"); }
    public void assignDisiredResults(String aDisiredResults) { disiredResults = aDisiredResults; }
    public void paramDisiredResults(HttpServletRequest request) { paramDisiredResults(request, "DisiredResults"); }
    public void paramDisiredResults(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDisiredResults()); if (!tmp.equals(getDisiredResults())) { setDisiredResults(tmp); } }
    // 项目实施地点
    protected String implePlace = "";
    public String getImplePlace() {  return SqlTool.getDbString(implePlace);  }
    public String getImplePlace(int size) { return SqlTool.subString(getImplePlace(), size); }
    public void setImplePlace(String aImplePlace) { implePlace = aImplePlace; modifiedFields.add("ImplePlace"); }
    public void assignImplePlace(String aImplePlace) { implePlace = aImplePlace; }
    public void paramImplePlace(HttpServletRequest request) { paramImplePlace(request, "ImplePlace"); }
    public void paramImplePlace(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getImplePlace()); if (!tmp.equals(getImplePlace())) { setImplePlace(tmp); } }
    // 项目实施地点
    protected String promotion = "";
    public String getPromotion() {  return SqlTool.getDbString(promotion);  }
    public String getPromotion(int size) { return SqlTool.subString(getPromotion(), size); }
    public void setPromotion(String aPromotion) { promotion = aPromotion; modifiedFields.add("Promotion"); }
    public void assignPromotion(String aPromotion) { promotion = aPromotion; }
    public void paramPromotion(HttpServletRequest request) { paramPromotion(request, "Promotion"); }
    public void paramPromotion(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPromotion()); if (!tmp.equals(getPromotion())) { setPromotion(tmp); } }
    // 项目特色
    protected String specialist = "";
    public String getSpecialist() {  return SqlTool.getDbString(specialist);  }
    public String getSpecialist(int size) { return SqlTool.subString(getSpecialist(), size); }
    public void setSpecialist(String aSpecialist) { specialist = aSpecialist; modifiedFields.add("Specialist"); }
    public void assignSpecialist(String aSpecialist) { specialist = aSpecialist; }
    public void paramSpecialist(HttpServletRequest request) { paramSpecialist(request, "Specialist"); }
    public void paramSpecialist(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSpecialist()); if (!tmp.equals(getSpecialist())) { setSpecialist(tmp); } }
    // 受益对象
    protected String beneFicaiaries = "";
    public String getBeneFicaiaries() {  return SqlTool.getDbString(beneFicaiaries);  }
    public String getBeneFicaiaries(int size) { return SqlTool.subString(getBeneFicaiaries(), size); }
    public void setBeneFicaiaries(String aBeneFicaiaries) { beneFicaiaries = aBeneFicaiaries; modifiedFields.add("BeneFicaiaries"); }
    public void assignBeneFicaiaries(String aBeneFicaiaries) { beneFicaiaries = aBeneFicaiaries; }
    public void paramBeneFicaiaries(HttpServletRequest request) { paramBeneFicaiaries(request, "BeneFicaiaries"); }
    public void paramBeneFicaiaries(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getBeneFicaiaries()); if (!tmp.equals(getBeneFicaiaries())) { setBeneFicaiaries(tmp); } }
    // 预计直接受益人数
    protected int benenum = -1;
    public int getBenenum() { return benenum; }
    public void setBenenum(int aBenenum) { benenum = aBenenum; modifiedFields.add("Benenum"); }
    public void assignBenenum(int aBenenum) { benenum = aBenenum; }
    public void paramBenenum(HttpServletRequest request) { paramBenenum(request, "Benenum"); }
    public void paramBenenum(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getBenenum()); if (tmp != getBenenum()) { setBenenum(tmp); } }
    // 项目负责人姓名
    protected String majorName = "";
    public String getMajorName() {  return SqlTool.getDbString(majorName);  }
    public String getMajorName(int size) { return SqlTool.subString(getMajorName(), size); }
    public void setMajorName(String aMajorName) { majorName = aMajorName; modifiedFields.add("MajorName"); }
    public void assignMajorName(String aMajorName) { majorName = aMajorName; }
    public void paramMajorName(HttpServletRequest request) { paramMajorName(request, "MajorName"); }
    public void paramMajorName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMajorName()); if (!tmp.equals(getMajorName())) { setMajorName(tmp); } }
    // 项目负责人性别
    protected String majorSex = "";
    public String getMajorSex() {  return SqlTool.getDbString(majorSex);  }
    public String getMajorSex(int size) { return SqlTool.subString(getMajorSex(), size); }
    public void setMajorSex(String aMajorSex) { majorSex = aMajorSex; modifiedFields.add("MajorSex"); }
    public void assignMajorSex(String aMajorSex) { majorSex = aMajorSex; }
    public void paramMajorSex(HttpServletRequest request) { paramMajorSex(request, "MajorSex"); }
    public void paramMajorSex(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMajorSex()); if (!tmp.equals(getMajorSex())) { setMajorSex(tmp); } }
    // 项目负责人出生年月
    protected String majorBirth = "";
    public String getMajorBirth() {  return SqlTool.getDbString(majorBirth);  }
    public String getMajorBirth(int size) { return SqlTool.subString(getMajorBirth(), size); }
    public void setMajorBirth(String aMajorBirth) { majorBirth = aMajorBirth; modifiedFields.add("MajorBirth"); }
    public void assignMajorBirth(String aMajorBirth) { majorBirth = aMajorBirth; }
    public void paramMajorBirth(HttpServletRequest request) { paramMajorBirth(request, "MajorBirth"); }
    public void paramMajorBirth(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMajorBirth()); if (!tmp.equals(getMajorBirth())) { setMajorBirth(tmp); } }
    // 项目负责人工作单位及职务
    protected String majorDuty = "";
    public String getMajorDuty() {  return SqlTool.getDbString(majorDuty);  }
    public String getMajorDuty(int size) { return SqlTool.subString(getMajorDuty(), size); }
    public void setMajorDuty(String aMajorDuty) { majorDuty = aMajorDuty; modifiedFields.add("MajorDuty"); }
    public void assignMajorDuty(String aMajorDuty) { majorDuty = aMajorDuty; }
    public void paramMajorDuty(HttpServletRequest request) { paramMajorDuty(request, "MajorDuty"); }
    public void paramMajorDuty(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMajorDuty()); if (!tmp.equals(getMajorDuty())) { setMajorDuty(tmp); } }
    // 项目负责人政治面貌
    protected String majorPolista = "";
    public String getMajorPolista() {  return SqlTool.getDbString(majorPolista);  }
    public String getMajorPolista(int size) { return SqlTool.subString(getMajorPolista(), size); }
    public void setMajorPolista(String aMajorPolista) { majorPolista = aMajorPolista; modifiedFields.add("MajorPolista"); }
    public void assignMajorPolista(String aMajorPolista) { majorPolista = aMajorPolista; }
    public void paramMajorPolista(HttpServletRequest request) { paramMajorPolista(request, "MajorPolista"); }
    public void paramMajorPolista(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMajorPolista()); if (!tmp.equals(getMajorPolista())) { setMajorPolista(tmp); } }
    // 项目负责人办公电话
    protected String majorPhone = "";
    public String getMajorPhone() {  return SqlTool.getDbString(majorPhone);  }
    public String getMajorPhone(int size) { return SqlTool.subString(getMajorPhone(), size); }
    public void setMajorPhone(String aMajorPhone) { majorPhone = aMajorPhone; modifiedFields.add("MajorPhone"); }
    public void assignMajorPhone(String aMajorPhone) { majorPhone = aMajorPhone; }
    public void paramMajorPhone(HttpServletRequest request) { paramMajorPhone(request, "MajorPhone"); }
    public void paramMajorPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMajorPhone()); if (!tmp.equals(getMajorPhone())) { setMajorPhone(tmp); } }
    // 项目负责人手机
    protected String majorPhone2 = "";
    public String getMajorPhone2() {  return SqlTool.getDbString(majorPhone2);  }
    public String getMajorPhone2(int size) { return SqlTool.subString(getMajorPhone2(), size); }
    public void setMajorPhone2(String aMajorPhone2) { majorPhone2 = aMajorPhone2; modifiedFields.add("MajorPhone2"); }
    public void assignMajorPhone2(String aMajorPhone2) { majorPhone2 = aMajorPhone2; }
    public void paramMajorPhone2(HttpServletRequest request) { paramMajorPhone2(request, "MajorPhone2"); }
    public void paramMajorPhone2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMajorPhone2()); if (!tmp.equals(getMajorPhone2())) { setMajorPhone2(tmp); } }
    // 项目负责人邮箱
    protected String majorEmail = "";
    public String getMajorEmail() {  return SqlTool.getDbString(majorEmail);  }
    public String getMajorEmail(int size) { return SqlTool.subString(getMajorEmail(), size); }
    public void setMajorEmail(String aMajorEmail) { majorEmail = aMajorEmail; modifiedFields.add("MajorEmail"); }
    public void assignMajorEmail(String aMajorEmail) { majorEmail = aMajorEmail; }
    public void paramMajorEmail(HttpServletRequest request) { paramMajorEmail(request, "MajorEmail"); }
    public void paramMajorEmail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMajorEmail()); if (!tmp.equals(getMajorEmail())) { setMajorEmail(tmp); } }
    // 项目指导教师姓名
    protected String guideTeacherName = "";
    public String getGuideTeacherName() {  return SqlTool.getDbString(guideTeacherName);  }
    public String getGuideTeacherName(int size) { return SqlTool.subString(getGuideTeacherName(), size); }
    public void setGuideTeacherName(String aGuideTeacherName) { guideTeacherName = aGuideTeacherName; modifiedFields.add("GuideTeacherName"); }
    public void assignGuideTeacherName(String aGuideTeacherName) { guideTeacherName = aGuideTeacherName; }
    public void paramGuideTeacherName(HttpServletRequest request) { paramGuideTeacherName(request, "GuideTeacherName"); }
    public void paramGuideTeacherName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGuideTeacherName()); if (!tmp.equals(getGuideTeacherName())) { setGuideTeacherName(tmp); } }
    // 项目指导教师性别
    protected String guideTeacherSex = "";
    public String getGuideTeacherSex() {  return SqlTool.getDbString(guideTeacherSex);  }
    public String getGuideTeacherSex(int size) { return SqlTool.subString(getGuideTeacherSex(), size); }
    public void setGuideTeacherSex(String aGuideTeacherSex) { guideTeacherSex = aGuideTeacherSex; modifiedFields.add("GuideTeacherSex"); }
    public void assignGuideTeacherSex(String aGuideTeacherSex) { guideTeacherSex = aGuideTeacherSex; }
    public void paramGuideTeacherSex(HttpServletRequest request) { paramGuideTeacherSex(request, "GuideTeacherSex"); }
    public void paramGuideTeacherSex(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGuideTeacherSex()); if (!tmp.equals(getGuideTeacherSex())) { setGuideTeacherSex(tmp); } }
    // 项目指导教师出生年月
    protected String guideTeacherBirth = "";
    public String getGuideTeacherBirth() {  return SqlTool.getDbString(guideTeacherBirth);  }
    public String getGuideTeacherBirth(int size) { return SqlTool.subString(getGuideTeacherBirth(), size); }
    public void setGuideTeacherBirth(String aGuideTeacherBirth) { guideTeacherBirth = aGuideTeacherBirth; modifiedFields.add("GuideTeacherBirth"); }
    public void assignGuideTeacherBirth(String aGuideTeacherBirth) { guideTeacherBirth = aGuideTeacherBirth; }
    public void paramGuideTeacherBirth(HttpServletRequest request) { paramGuideTeacherBirth(request, "GuideTeacherBirth"); }
    public void paramGuideTeacherBirth(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGuideTeacherBirth()); if (!tmp.equals(getGuideTeacherBirth())) { setGuideTeacherBirth(tmp); } }
    // 项目指导教师工作单位及职务
    protected String guideTeacherDuty = "";
    public String getGuideTeacherDuty() {  return SqlTool.getDbString(guideTeacherDuty);  }
    public String getGuideTeacherDuty(int size) { return SqlTool.subString(getGuideTeacherDuty(), size); }
    public void setGuideTeacherDuty(String aGuideTeacherDuty) { guideTeacherDuty = aGuideTeacherDuty; modifiedFields.add("GuideTeacherDuty"); }
    public void assignGuideTeacherDuty(String aGuideTeacherDuty) { guideTeacherDuty = aGuideTeacherDuty; }
    public void paramGuideTeacherDuty(HttpServletRequest request) { paramGuideTeacherDuty(request, "GuideTeacherDuty"); }
    public void paramGuideTeacherDuty(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGuideTeacherDuty()); if (!tmp.equals(getGuideTeacherDuty())) { setGuideTeacherDuty(tmp); } }
    // 项目指导教师政治面貌
    protected String guideTeacherPolista = "";
    public String getGuideTeacherPolista() {  return SqlTool.getDbString(guideTeacherPolista);  }
    public String getGuideTeacherPolista(int size) { return SqlTool.subString(getGuideTeacherPolista(), size); }
    public void setGuideTeacherPolista(String aGuideTeacherPolista) { guideTeacherPolista = aGuideTeacherPolista; modifiedFields.add("GuideTeacherPolista"); }
    public void assignGuideTeacherPolista(String aGuideTeacherPolista) { guideTeacherPolista = aGuideTeacherPolista; }
    public void paramGuideTeacherPolista(HttpServletRequest request) { paramGuideTeacherPolista(request, "GuideTeacherPolista"); }
    public void paramGuideTeacherPolista(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGuideTeacherPolista()); if (!tmp.equals(getGuideTeacherPolista())) { setGuideTeacherPolista(tmp); } }
    // 项目指导教师办公电话
    protected String guideTeacherPhone = "";
    public String getGuideTeacherPhone() {  return SqlTool.getDbString(guideTeacherPhone);  }
    public String getGuideTeacherPhone(int size) { return SqlTool.subString(getGuideTeacherPhone(), size); }
    public void setGuideTeacherPhone(String aGuideTeacherPhone) { guideTeacherPhone = aGuideTeacherPhone; modifiedFields.add("GuideTeacherPhone"); }
    public void assignGuideTeacherPhone(String aGuideTeacherPhone) { guideTeacherPhone = aGuideTeacherPhone; }
    public void paramGuideTeacherPhone(HttpServletRequest request) { paramGuideTeacherPhone(request, "GuideTeacherPhone"); }
    public void paramGuideTeacherPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGuideTeacherPhone()); if (!tmp.equals(getGuideTeacherPhone())) { setGuideTeacherPhone(tmp); } }
    // 项目指导教师手机
    protected String guideTeacherPhone2 = "";
    public String getGuideTeacherPhone2() {  return SqlTool.getDbString(guideTeacherPhone2);  }
    public String getGuideTeacherPhone2(int size) { return SqlTool.subString(getGuideTeacherPhone2(), size); }
    public void setGuideTeacherPhone2(String aGuideTeacherPhone2) { guideTeacherPhone2 = aGuideTeacherPhone2; modifiedFields.add("GuideTeacherPhone2"); }
    public void assignGuideTeacherPhone2(String aGuideTeacherPhone2) { guideTeacherPhone2 = aGuideTeacherPhone2; }
    public void paramGuideTeacherPhone2(HttpServletRequest request) { paramGuideTeacherPhone2(request, "GuideTeacherPhone2"); }
    public void paramGuideTeacherPhone2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGuideTeacherPhone2()); if (!tmp.equals(getGuideTeacherPhone2())) { setGuideTeacherPhone2(tmp); } }
    // 项目指导教师邮箱
    protected String guiderTeacherEmail = "";
    public String getGuiderTeacherEmail() {  return SqlTool.getDbString(guiderTeacherEmail);  }
    public String getGuiderTeacherEmail(int size) { return SqlTool.subString(getGuiderTeacherEmail(), size); }
    public void setGuiderTeacherEmail(String aGuiderTeacherEmail) { guiderTeacherEmail = aGuiderTeacherEmail; modifiedFields.add("GuiderTeacherEmail"); }
    public void assignGuiderTeacherEmail(String aGuiderTeacherEmail) { guiderTeacherEmail = aGuiderTeacherEmail; }
    public void paramGuiderTeacherEmail(HttpServletRequest request) { paramGuiderTeacherEmail(request, "GuiderTeacherEmail"); }
    public void paramGuiderTeacherEmail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGuiderTeacherEmail()); if (!tmp.equals(getGuiderTeacherEmail())) { setGuiderTeacherEmail(tmp); } }
    // 上传文件列表
    protected String addFileList = "";
    public String getAddFileList() {  return SqlTool.getDbString(addFileList);  }
    public String getAddFileList(int size) { return SqlTool.subString(getAddFileList(), size); }
    public void setAddFileList(String aAddFileList) { addFileList = aAddFileList; modifiedFields.add("AddFileList"); }
    public void assignAddFileList(String aAddFileList) { addFileList = aAddFileList; }
    public void paramAddFileList(HttpServletRequest request) { paramAddFileList(request, "AddFileList"); }
    public void paramAddFileList(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddFileList()); if (!tmp.equals(getAddFileList())) { setAddFileList(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public VolunteerProjectParticipate (String db) {
        DBNAME = db;
    }
    public VolunteerProjectParticipate (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public VolunteerProjectParticipate (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public VolunteerProjectParticipate () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return VolunteerProjectParticipate类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public VolunteerProjectParticipate getByParameter(HttpServletRequest request) {
        VolunteerProjectParticipate v = new VolunteerProjectParticipate(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramProjectId(request);
        paramSno(request);
        paramHonour(request);
        paramSubmitFlag(request);
        paramCheckFlag(request);
        paramXycheckFalg(request);
        paramCheckComments(request);
        paramAddAccount(request);
        paramAddtime(request);
        paramCheckAccount(request);
        paramCheckTime(request);
        paramAcademy(request);
        paramProjectName(request);
        paramTeamName(request);
        paramTeamUnit(request);
        paramRegisterId(request);
        paramSetupTime(request);
        paramZipCode(request);
        paramContactAddress(request);
        paramInspectionConclution(request);
        paramAssLevel(request);
        paramDutyFree(request);
        paramStartTime(request);
        paramProjectArea(request);
        paramImpleArea(request);
        paramParticipateNum(request);
        paramFulltimeNum(request);
        paramAward(request);
        paramContent(request);
        paramMeanings(request);
        paramDisiredResults(request);
        paramImplePlace(request);
        paramPromotion(request);
        paramSpecialist(request);
        paramBeneFicaiaries(request);
        paramBenenum(request);
        paramMajorName(request);
        paramMajorSex(request);
        paramMajorBirth(request);
        paramMajorDuty(request);
        paramMajorPolista(request);
        paramMajorPhone(request);
        paramMajorPhone2(request);
        paramMajorEmail(request);
        paramGuideTeacherName(request);
        paramGuideTeacherSex(request);
        paramGuideTeacherBirth(request);
        paramGuideTeacherDuty(request);
        paramGuideTeacherPolista(request);
        paramGuideTeacherPhone(request);
        paramGuideTeacherPhone2(request);
        paramGuiderTeacherEmail(request);
        paramAddFileList(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(VolunteerProjectParticipate bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("projectId")) { setProjectId(bean.getProjectId()); }
        if (!ncl.contains("sno")) { setSno(bean.getSno()); }
        if (!ncl.contains("honour")) { setHonour(bean.getHonour()); }
        if (!ncl.contains("submitFlag")) { setSubmitFlag(bean.getSubmitFlag()); }
        if (!ncl.contains("checkFlag")) { setCheckFlag(bean.getCheckFlag()); }
        if (!ncl.contains("xycheckFalg")) { setXycheckFalg(bean.getXycheckFalg()); }
        if (!ncl.contains("checkComments")) { setCheckComments(bean.getCheckComments()); }
        if (!ncl.contains("addAccount")) { setAddAccount(bean.getAddAccount()); }
        if (!ncl.contains("addtime")) { setAddtime(bean.getAddtime()); }
        if (!ncl.contains("checkAccount")) { setCheckAccount(bean.getCheckAccount()); }
        if (!ncl.contains("checkTime")) { setCheckTime(bean.getCheckTime()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("projectName")) { setProjectName(bean.getProjectName()); }
        if (!ncl.contains("teamName")) { setTeamName(bean.getTeamName()); }
        if (!ncl.contains("teamUnit")) { setTeamUnit(bean.getTeamUnit()); }
        if (!ncl.contains("registerId")) { setRegisterId(bean.getRegisterId()); }
        if (!ncl.contains("setupTime")) { setSetupTime(bean.getSetupTime()); }
        if (!ncl.contains("zipCode")) { setZipCode(bean.getZipCode()); }
        if (!ncl.contains("contactAddress")) { setContactAddress(bean.getContactAddress()); }
        if (!ncl.contains("inspectionConclution")) { setInspectionConclution(bean.getInspectionConclution()); }
        if (!ncl.contains("assLevel")) { setAssLevel(bean.getAssLevel()); }
        if (!ncl.contains("dutyFree")) { setDutyFree(bean.getDutyFree()); }
        if (!ncl.contains("startTime")) { setStartTime(bean.getStartTime()); }
        if (!ncl.contains("projectArea")) { setProjectArea(bean.getProjectArea()); }
        if (!ncl.contains("impleArea")) { setImpleArea(bean.getImpleArea()); }
        if (!ncl.contains("participateNum")) { setParticipateNum(bean.getParticipateNum()); }
        if (!ncl.contains("fulltimeNum")) { setFulltimeNum(bean.getFulltimeNum()); }
        if (!ncl.contains("award")) { setAward(bean.getAward()); }
        if (!ncl.contains("content")) { setContent(bean.getContent()); }
        if (!ncl.contains("meanings")) { setMeanings(bean.getMeanings()); }
        if (!ncl.contains("disiredResults")) { setDisiredResults(bean.getDisiredResults()); }
        if (!ncl.contains("implePlace")) { setImplePlace(bean.getImplePlace()); }
        if (!ncl.contains("promotion")) { setPromotion(bean.getPromotion()); }
        if (!ncl.contains("specialist")) { setSpecialist(bean.getSpecialist()); }
        if (!ncl.contains("beneFicaiaries")) { setBeneFicaiaries(bean.getBeneFicaiaries()); }
        if (!ncl.contains("benenum")) { setBenenum(bean.getBenenum()); }
        if (!ncl.contains("majorName")) { setMajorName(bean.getMajorName()); }
        if (!ncl.contains("majorSex")) { setMajorSex(bean.getMajorSex()); }
        if (!ncl.contains("majorBirth")) { setMajorBirth(bean.getMajorBirth()); }
        if (!ncl.contains("majorDuty")) { setMajorDuty(bean.getMajorDuty()); }
        if (!ncl.contains("majorPolista")) { setMajorPolista(bean.getMajorPolista()); }
        if (!ncl.contains("majorPhone")) { setMajorPhone(bean.getMajorPhone()); }
        if (!ncl.contains("majorPhone2")) { setMajorPhone2(bean.getMajorPhone2()); }
        if (!ncl.contains("majorEmail")) { setMajorEmail(bean.getMajorEmail()); }
        if (!ncl.contains("guideTeacherName")) { setGuideTeacherName(bean.getGuideTeacherName()); }
        if (!ncl.contains("guideTeacherSex")) { setGuideTeacherSex(bean.getGuideTeacherSex()); }
        if (!ncl.contains("guideTeacherBirth")) { setGuideTeacherBirth(bean.getGuideTeacherBirth()); }
        if (!ncl.contains("guideTeacherDuty")) { setGuideTeacherDuty(bean.getGuideTeacherDuty()); }
        if (!ncl.contains("guideTeacherPolista")) { setGuideTeacherPolista(bean.getGuideTeacherPolista()); }
        if (!ncl.contains("guideTeacherPhone")) { setGuideTeacherPhone(bean.getGuideTeacherPhone()); }
        if (!ncl.contains("guideTeacherPhone2")) { setGuideTeacherPhone2(bean.getGuideTeacherPhone2()); }
        if (!ncl.contains("guiderTeacherEmail")) { setGuiderTeacherEmail(bean.getGuiderTeacherEmail()); }
        if (!ncl.contains("addFileList")) { setAddFileList(bean.getAddFileList()); }
    }
    public VolunteerProjectParticipate getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        VolunteerProjectParticipate[] rslt= queryByCondition(cdt);
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
     * @return VolunteerProjectParticipate类的实例列表。
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
                VolunteerProjectParticipate ve = new VolunteerProjectParticipate(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignProjectId(rs.getInt(2));
                ve.assignSno(fromDbCh(rs.getString(3)));
                ve.assignHonour(fromDbCh(rs.getString(4)));
                ve.assignSubmitFlag(rs.getInt(5));
                ve.assignCheckFlag(rs.getInt(6));
                ve.assignXycheckFalg(rs.getInt(7));
                ve.assignCheckComments(fromDbCh(rs.getString(8)));
                ve.assignAddAccount(fromDbCh(rs.getString(9)));
                tmpDate = rs.getTimestamp(10); if (tmpDate != null) { ve.assignAddtime(new java.util.Date(tmpDate.getTime())); }
                ve.assignCheckAccount(fromDbCh(rs.getString(11)));
                tmpDate = rs.getTimestamp(12); if (tmpDate != null) { ve.assignCheckTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignAcademy(fromDbCh(rs.getString(13)));
                ve.assignProjectName(fromDbCh(rs.getString(14)));
                ve.assignTeamName(fromDbCh(rs.getString(15)));
                ve.assignTeamUnit(fromDbCh(rs.getString(16)));
                ve.assignRegisterId(fromDbCh(rs.getString(17)));
                tmpDate = rs.getTimestamp(18); if (tmpDate != null) { ve.assignSetupTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignZipCode(fromDbCh(rs.getString(19)));
                ve.assignContactAddress(fromDbCh(rs.getString(20)));
                ve.assignInspectionConclution(fromDbCh(rs.getString(21)));
                ve.assignAssLevel(fromDbCh(rs.getString(22)));
                ve.assignDutyFree(fromDbCh(rs.getString(23)));
                tmpDate = rs.getTimestamp(24); if (tmpDate != null) { ve.assignStartTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignProjectArea(fromDbCh(rs.getString(25)));
                ve.assignImpleArea(fromDbCh(rs.getString(26)));
                ve.assignParticipateNum(rs.getInt(27));
                ve.assignFulltimeNum(rs.getInt(28));
                ve.assignAward(fromDbCh(rs.getString(29)));
                ve.assignContent(fromDbCh(rs.getString(30)));
                ve.assignMeanings(fromDbCh(rs.getString(31)));
                ve.assignDisiredResults(fromDbCh(rs.getString(32)));
                ve.assignImplePlace(fromDbCh(rs.getString(33)));
                ve.assignPromotion(fromDbCh(rs.getString(34)));
                ve.assignSpecialist(fromDbCh(rs.getString(35)));
                ve.assignBeneFicaiaries(fromDbCh(rs.getString(36)));
                ve.assignBenenum(rs.getInt(37));
                ve.assignMajorName(fromDbCh(rs.getString(38)));
                ve.assignMajorSex(fromDbCh(rs.getString(39)));
                ve.assignMajorBirth(fromDbCh(rs.getString(40)));
                ve.assignMajorDuty(fromDbCh(rs.getString(41)));
                ve.assignMajorPolista(fromDbCh(rs.getString(42)));
                ve.assignMajorPhone(fromDbCh(rs.getString(43)));
                ve.assignMajorPhone2(fromDbCh(rs.getString(44)));
                ve.assignMajorEmail(fromDbCh(rs.getString(45)));
                ve.assignGuideTeacherName(fromDbCh(rs.getString(46)));
                ve.assignGuideTeacherSex(fromDbCh(rs.getString(47)));
                ve.assignGuideTeacherBirth(fromDbCh(rs.getString(48)));
                ve.assignGuideTeacherDuty(fromDbCh(rs.getString(49)));
                ve.assignGuideTeacherPolista(fromDbCh(rs.getString(50)));
                ve.assignGuideTeacherPhone(fromDbCh(rs.getString(51)));
                ve.assignGuideTeacherPhone2(fromDbCh(rs.getString(52)));
                ve.assignGuiderTeacherEmail(fromDbCh(rs.getString(53)));
                ve.assignAddFileList(fromDbCh(rs.getString(54)));
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
    public VolunteerProjectParticipate[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (VolunteerProjectParticipate[])vrs.toArray(new VolunteerProjectParticipate[vrs.size()]);
    }
    public VolunteerProjectParticipate[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (VolunteerProjectParticipate[])vrs.toArray(new VolunteerProjectParticipate[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (projectid,sno,honour,submitflag,checkflag,xycheckfalg,checkcomments,addaccount,addtime,checkaccount,checktime,academy,projectname,teamname,teamunit,registerid,setuptime,zipcode,contactaddress,inspectionconclution,asslevel,dutyfree,starttime,projectarea,implearea,participatenum,fulltimenum,award,content,meanings,disiredresults,impleplace,promotion,specialist,beneficaiaries,benenum,majorname,majorsex,majorbirth,majorduty,majorpolista,majorphone,majorphone2,majoremail,guideteachername,guideteachersex,guideteacherbirth,guideteacherduty,guideteacherpolista,guideteacherphone,guideteacherphone2,guiderteacheremail,addfilelist) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, projectId);
            pstmt.setString(2, toDbCh(sno));
            pstmt.setString(3, toDbCh(honour));
            pstmt.setInt(4, submitFlag);
            pstmt.setInt(5, checkFlag);
            pstmt.setInt(6, xycheckFalg);
            pstmt.setString(7, toDbCh(checkComments));
            pstmt.setString(8, toDbCh(addAccount));
            pstmt.setTimestamp(9, new java.sql.Timestamp(addtime.getTime()));
            pstmt.setString(10, toDbCh(checkAccount));
            pstmt.setTimestamp(11, new java.sql.Timestamp(checkTime.getTime()));
            pstmt.setString(12, toDbCh(academy));
            pstmt.setString(13, toDbCh(projectName));
            pstmt.setString(14, toDbCh(teamName));
            pstmt.setString(15, toDbCh(teamUnit));
            pstmt.setString(16, toDbCh(registerId));
            pstmt.setTimestamp(17, new java.sql.Timestamp(setupTime.getTime()));
            pstmt.setString(18, toDbCh(zipCode));
            pstmt.setString(19, toDbCh(contactAddress));
            pstmt.setString(20, toDbCh(inspectionConclution));
            pstmt.setString(21, toDbCh(assLevel));
            pstmt.setString(22, toDbCh(dutyFree));
            pstmt.setTimestamp(23, new java.sql.Timestamp(startTime.getTime()));
            pstmt.setString(24, toDbCh(projectArea));
            pstmt.setString(25, toDbCh(impleArea));
            pstmt.setInt(26, participateNum);
            pstmt.setInt(27, fulltimeNum);
            pstmt.setString(28, toDbCh(award));
            pstmt.setString(29, toDbCh(content));
            pstmt.setString(30, toDbCh(meanings));
            pstmt.setString(31, toDbCh(disiredResults));
            pstmt.setString(32, toDbCh(implePlace));
            pstmt.setString(33, toDbCh(promotion));
            pstmt.setString(34, toDbCh(specialist));
            pstmt.setString(35, toDbCh(beneFicaiaries));
            pstmt.setInt(36, benenum);
            pstmt.setString(37, toDbCh(majorName));
            pstmt.setString(38, toDbCh(majorSex));
            pstmt.setString(39, toDbCh(majorBirth));
            pstmt.setString(40, toDbCh(majorDuty));
            pstmt.setString(41, toDbCh(majorPolista));
            pstmt.setString(42, toDbCh(majorPhone));
            pstmt.setString(43, toDbCh(majorPhone2));
            pstmt.setString(44, toDbCh(majorEmail));
            pstmt.setString(45, toDbCh(guideTeacherName));
            pstmt.setString(46, toDbCh(guideTeacherSex));
            pstmt.setString(47, toDbCh(guideTeacherBirth));
            pstmt.setString(48, toDbCh(guideTeacherDuty));
            pstmt.setString(49, toDbCh(guideTeacherPolista));
            pstmt.setString(50, toDbCh(guideTeacherPhone));
            pstmt.setString(51, toDbCh(guideTeacherPhone2));
            pstmt.setString(52, toDbCh(guiderTeacherEmail));
            pstmt.setString(53, toDbCh(addFileList));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,projectid,sno,honour,submitflag,checkflag,xycheckfalg,checkcomments,addaccount,addtime,checkaccount,checktime,academy,projectname,teamname,teamunit,registerid,setuptime,zipcode,contactaddress,inspectionconclution,asslevel,dutyfree,starttime,projectarea,implearea,participatenum,fulltimenum,award,content,meanings,disiredresults,impleplace,promotion,specialist,beneficaiaries,benenum,majorname,majorsex,majorbirth,majorduty,majorpolista,majorphone,majorphone2,majoremail,guideteachername,guideteachersex,guideteacherbirth,guideteacherduty,guideteacherpolista,guideteacherphone,guideteacherphone2,guiderteacheremail,addfilelist) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, projectId);
            pstmt.setString(3, toDbCh(sno));
            pstmt.setString(4, toDbCh(honour));
            pstmt.setInt(5, submitFlag);
            pstmt.setInt(6, checkFlag);
            pstmt.setInt(7, xycheckFalg);
            pstmt.setString(8, toDbCh(checkComments));
            pstmt.setString(9, toDbCh(addAccount));
            pstmt.setTimestamp(10, new java.sql.Timestamp(addtime.getTime()));
            pstmt.setString(11, toDbCh(checkAccount));
            pstmt.setTimestamp(12, new java.sql.Timestamp(checkTime.getTime()));
            pstmt.setString(13, toDbCh(academy));
            pstmt.setString(14, toDbCh(projectName));
            pstmt.setString(15, toDbCh(teamName));
            pstmt.setString(16, toDbCh(teamUnit));
            pstmt.setString(17, toDbCh(registerId));
            pstmt.setTimestamp(18, new java.sql.Timestamp(setupTime.getTime()));
            pstmt.setString(19, toDbCh(zipCode));
            pstmt.setString(20, toDbCh(contactAddress));
            pstmt.setString(21, toDbCh(inspectionConclution));
            pstmt.setString(22, toDbCh(assLevel));
            pstmt.setString(23, toDbCh(dutyFree));
            pstmt.setTimestamp(24, new java.sql.Timestamp(startTime.getTime()));
            pstmt.setString(25, toDbCh(projectArea));
            pstmt.setString(26, toDbCh(impleArea));
            pstmt.setInt(27, participateNum);
            pstmt.setInt(28, fulltimeNum);
            pstmt.setString(29, toDbCh(award));
            pstmt.setString(30, toDbCh(content));
            pstmt.setString(31, toDbCh(meanings));
            pstmt.setString(32, toDbCh(disiredResults));
            pstmt.setString(33, toDbCh(implePlace));
            pstmt.setString(34, toDbCh(promotion));
            pstmt.setString(35, toDbCh(specialist));
            pstmt.setString(36, toDbCh(beneFicaiaries));
            pstmt.setInt(37, benenum);
            pstmt.setString(38, toDbCh(majorName));
            pstmt.setString(39, toDbCh(majorSex));
            pstmt.setString(40, toDbCh(majorBirth));
            pstmt.setString(41, toDbCh(majorDuty));
            pstmt.setString(42, toDbCh(majorPolista));
            pstmt.setString(43, toDbCh(majorPhone));
            pstmt.setString(44, toDbCh(majorPhone2));
            pstmt.setString(45, toDbCh(majorEmail));
            pstmt.setString(46, toDbCh(guideTeacherName));
            pstmt.setString(47, toDbCh(guideTeacherSex));
            pstmt.setString(48, toDbCh(guideTeacherBirth));
            pstmt.setString(49, toDbCh(guideTeacherDuty));
            pstmt.setString(50, toDbCh(guideTeacherPolista));
            pstmt.setString(51, toDbCh(guideTeacherPhone));
            pstmt.setString(52, toDbCh(guideTeacherPhone2));
            pstmt.setString(53, toDbCh(guiderTeacherEmail));
            pstmt.setString(54, toDbCh(addFileList));
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
            VolunteerProjectParticipate item = (VolunteerProjectParticipate)it.next();
            VolunteerProjectParticipate v = new VolunteerProjectParticipate(dbname);
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
                if (modifiedFields.contains("ProjectId")) { pstmt.setInt(pi ++, projectId); }
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("Honour")) { pstmt.setString(pi ++, toDbCh(honour)); }
                if (modifiedFields.contains("SubmitFlag")) { pstmt.setInt(pi ++, submitFlag); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("XycheckFalg")) { pstmt.setInt(pi ++, xycheckFalg); }
                if (modifiedFields.contains("CheckComments")) { pstmt.setString(pi ++, toDbCh(checkComments)); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addtime.getTime())); }
                if (modifiedFields.contains("CheckAccount")) { pstmt.setString(pi ++, toDbCh(checkAccount)); }
                if (modifiedFields.contains("CheckTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(checkTime.getTime())); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("ProjectName")) { pstmt.setString(pi ++, toDbCh(projectName)); }
                if (modifiedFields.contains("TeamName")) { pstmt.setString(pi ++, toDbCh(teamName)); }
                if (modifiedFields.contains("TeamUnit")) { pstmt.setString(pi ++, toDbCh(teamUnit)); }
                if (modifiedFields.contains("RegisterId")) { pstmt.setString(pi ++, toDbCh(registerId)); }
                if (modifiedFields.contains("SetupTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(setupTime.getTime())); }
                if (modifiedFields.contains("ZipCode")) { pstmt.setString(pi ++, toDbCh(zipCode)); }
                if (modifiedFields.contains("ContactAddress")) { pstmt.setString(pi ++, toDbCh(contactAddress)); }
                if (modifiedFields.contains("InspectionConclution")) { pstmt.setString(pi ++, toDbCh(inspectionConclution)); }
                if (modifiedFields.contains("AssLevel")) { pstmt.setString(pi ++, toDbCh(assLevel)); }
                if (modifiedFields.contains("DutyFree")) { pstmt.setString(pi ++, toDbCh(dutyFree)); }
                if (modifiedFields.contains("StartTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(startTime.getTime())); }
                if (modifiedFields.contains("ProjectArea")) { pstmt.setString(pi ++, toDbCh(projectArea)); }
                if (modifiedFields.contains("ImpleArea")) { pstmt.setString(pi ++, toDbCh(impleArea)); }
                if (modifiedFields.contains("ParticipateNum")) { pstmt.setInt(pi ++, participateNum); }
                if (modifiedFields.contains("FulltimeNum")) { pstmt.setInt(pi ++, fulltimeNum); }
                if (modifiedFields.contains("Award")) { pstmt.setString(pi ++, toDbCh(award)); }
                if (modifiedFields.contains("Content")) { pstmt.setString(pi ++, toDbCh(content)); }
                if (modifiedFields.contains("Meanings")) { pstmt.setString(pi ++, toDbCh(meanings)); }
                if (modifiedFields.contains("DisiredResults")) { pstmt.setString(pi ++, toDbCh(disiredResults)); }
                if (modifiedFields.contains("ImplePlace")) { pstmt.setString(pi ++, toDbCh(implePlace)); }
                if (modifiedFields.contains("Promotion")) { pstmt.setString(pi ++, toDbCh(promotion)); }
                if (modifiedFields.contains("Specialist")) { pstmt.setString(pi ++, toDbCh(specialist)); }
                if (modifiedFields.contains("BeneFicaiaries")) { pstmt.setString(pi ++, toDbCh(beneFicaiaries)); }
                if (modifiedFields.contains("Benenum")) { pstmt.setInt(pi ++, benenum); }
                if (modifiedFields.contains("MajorName")) { pstmt.setString(pi ++, toDbCh(majorName)); }
                if (modifiedFields.contains("MajorSex")) { pstmt.setString(pi ++, toDbCh(majorSex)); }
                if (modifiedFields.contains("MajorBirth")) { pstmt.setString(pi ++, toDbCh(majorBirth)); }
                if (modifiedFields.contains("MajorDuty")) { pstmt.setString(pi ++, toDbCh(majorDuty)); }
                if (modifiedFields.contains("MajorPolista")) { pstmt.setString(pi ++, toDbCh(majorPolista)); }
                if (modifiedFields.contains("MajorPhone")) { pstmt.setString(pi ++, toDbCh(majorPhone)); }
                if (modifiedFields.contains("MajorPhone2")) { pstmt.setString(pi ++, toDbCh(majorPhone2)); }
                if (modifiedFields.contains("MajorEmail")) { pstmt.setString(pi ++, toDbCh(majorEmail)); }
                if (modifiedFields.contains("GuideTeacherName")) { pstmt.setString(pi ++, toDbCh(guideTeacherName)); }
                if (modifiedFields.contains("GuideTeacherSex")) { pstmt.setString(pi ++, toDbCh(guideTeacherSex)); }
                if (modifiedFields.contains("GuideTeacherBirth")) { pstmt.setString(pi ++, toDbCh(guideTeacherBirth)); }
                if (modifiedFields.contains("GuideTeacherDuty")) { pstmt.setString(pi ++, toDbCh(guideTeacherDuty)); }
                if (modifiedFields.contains("GuideTeacherPolista")) { pstmt.setString(pi ++, toDbCh(guideTeacherPolista)); }
                if (modifiedFields.contains("GuideTeacherPhone")) { pstmt.setString(pi ++, toDbCh(guideTeacherPhone)); }
                if (modifiedFields.contains("GuideTeacherPhone2")) { pstmt.setString(pi ++, toDbCh(guideTeacherPhone2)); }
                if (modifiedFields.contains("GuiderTeacherEmail")) { pstmt.setString(pi ++, toDbCh(guiderTeacherEmail)); }
                if (modifiedFields.contains("AddFileList")) { pstmt.setString(pi ++, toDbCh(addFileList)); }
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
                if (modifiedFields.contains("ProjectId")) { pstmt.setInt(pi ++, projectId); }
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("Honour")) { pstmt.setString(pi ++, toDbCh(honour)); }
                if (modifiedFields.contains("SubmitFlag")) { pstmt.setInt(pi ++, submitFlag); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("XycheckFalg")) { pstmt.setInt(pi ++, xycheckFalg); }
                if (modifiedFields.contains("CheckComments")) { pstmt.setString(pi ++, toDbCh(checkComments)); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addtime.getTime())); }
                if (modifiedFields.contains("CheckAccount")) { pstmt.setString(pi ++, toDbCh(checkAccount)); }
                if (modifiedFields.contains("CheckTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(checkTime.getTime())); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("ProjectName")) { pstmt.setString(pi ++, toDbCh(projectName)); }
                if (modifiedFields.contains("TeamName")) { pstmt.setString(pi ++, toDbCh(teamName)); }
                if (modifiedFields.contains("TeamUnit")) { pstmt.setString(pi ++, toDbCh(teamUnit)); }
                if (modifiedFields.contains("RegisterId")) { pstmt.setString(pi ++, toDbCh(registerId)); }
                if (modifiedFields.contains("SetupTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(setupTime.getTime())); }
                if (modifiedFields.contains("ZipCode")) { pstmt.setString(pi ++, toDbCh(zipCode)); }
                if (modifiedFields.contains("ContactAddress")) { pstmt.setString(pi ++, toDbCh(contactAddress)); }
                if (modifiedFields.contains("InspectionConclution")) { pstmt.setString(pi ++, toDbCh(inspectionConclution)); }
                if (modifiedFields.contains("AssLevel")) { pstmt.setString(pi ++, toDbCh(assLevel)); }
                if (modifiedFields.contains("DutyFree")) { pstmt.setString(pi ++, toDbCh(dutyFree)); }
                if (modifiedFields.contains("StartTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(startTime.getTime())); }
                if (modifiedFields.contains("ProjectArea")) { pstmt.setString(pi ++, toDbCh(projectArea)); }
                if (modifiedFields.contains("ImpleArea")) { pstmt.setString(pi ++, toDbCh(impleArea)); }
                if (modifiedFields.contains("ParticipateNum")) { pstmt.setInt(pi ++, participateNum); }
                if (modifiedFields.contains("FulltimeNum")) { pstmt.setInt(pi ++, fulltimeNum); }
                if (modifiedFields.contains("Award")) { pstmt.setString(pi ++, toDbCh(award)); }
                if (modifiedFields.contains("Content")) { pstmt.setString(pi ++, toDbCh(content)); }
                if (modifiedFields.contains("Meanings")) { pstmt.setString(pi ++, toDbCh(meanings)); }
                if (modifiedFields.contains("DisiredResults")) { pstmt.setString(pi ++, toDbCh(disiredResults)); }
                if (modifiedFields.contains("ImplePlace")) { pstmt.setString(pi ++, toDbCh(implePlace)); }
                if (modifiedFields.contains("Promotion")) { pstmt.setString(pi ++, toDbCh(promotion)); }
                if (modifiedFields.contains("Specialist")) { pstmt.setString(pi ++, toDbCh(specialist)); }
                if (modifiedFields.contains("BeneFicaiaries")) { pstmt.setString(pi ++, toDbCh(beneFicaiaries)); }
                if (modifiedFields.contains("Benenum")) { pstmt.setInt(pi ++, benenum); }
                if (modifiedFields.contains("MajorName")) { pstmt.setString(pi ++, toDbCh(majorName)); }
                if (modifiedFields.contains("MajorSex")) { pstmt.setString(pi ++, toDbCh(majorSex)); }
                if (modifiedFields.contains("MajorBirth")) { pstmt.setString(pi ++, toDbCh(majorBirth)); }
                if (modifiedFields.contains("MajorDuty")) { pstmt.setString(pi ++, toDbCh(majorDuty)); }
                if (modifiedFields.contains("MajorPolista")) { pstmt.setString(pi ++, toDbCh(majorPolista)); }
                if (modifiedFields.contains("MajorPhone")) { pstmt.setString(pi ++, toDbCh(majorPhone)); }
                if (modifiedFields.contains("MajorPhone2")) { pstmt.setString(pi ++, toDbCh(majorPhone2)); }
                if (modifiedFields.contains("MajorEmail")) { pstmt.setString(pi ++, toDbCh(majorEmail)); }
                if (modifiedFields.contains("GuideTeacherName")) { pstmt.setString(pi ++, toDbCh(guideTeacherName)); }
                if (modifiedFields.contains("GuideTeacherSex")) { pstmt.setString(pi ++, toDbCh(guideTeacherSex)); }
                if (modifiedFields.contains("GuideTeacherBirth")) { pstmt.setString(pi ++, toDbCh(guideTeacherBirth)); }
                if (modifiedFields.contains("GuideTeacherDuty")) { pstmt.setString(pi ++, toDbCh(guideTeacherDuty)); }
                if (modifiedFields.contains("GuideTeacherPolista")) { pstmt.setString(pi ++, toDbCh(guideTeacherPolista)); }
                if (modifiedFields.contains("GuideTeacherPhone")) { pstmt.setString(pi ++, toDbCh(guideTeacherPhone)); }
                if (modifiedFields.contains("GuideTeacherPhone2")) { pstmt.setString(pi ++, toDbCh(guideTeacherPhone2)); }
                if (modifiedFields.contains("GuiderTeacherEmail")) { pstmt.setString(pi ++, toDbCh(guiderTeacherEmail)); }
                if (modifiedFields.contains("AddFileList")) { pstmt.setString(pi ++, toDbCh(addFileList)); }
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
        map.put("ProjectId", getProjectId() + "");
        map.put("Sno", getSno());
        map.put("Honour", getHonour());
        map.put("SubmitFlag", getSubmitFlag() + "");
        map.put("CheckFlag", getCheckFlag() + "");
        map.put("XycheckFalg", getXycheckFalg() + "");
        map.put("CheckComments", getCheckComments());
        map.put("AddAccount", getAddAccount());
        map.put("Addtime", Tool.stringOfDateTime(getAddtime()));
        map.put("CheckAccount", getCheckAccount());
        map.put("CheckTime", Tool.stringOfDateTime(getCheckTime()));
        map.put("Academy", getAcademy());
        map.put("ProjectName", getProjectName());
        map.put("TeamName", getTeamName());
        map.put("TeamUnit", getTeamUnit());
        map.put("RegisterId", getRegisterId());
        map.put("SetupTime", Tool.stringOfDateTime(getSetupTime()));
        map.put("ZipCode", getZipCode());
        map.put("ContactAddress", getContactAddress());
        map.put("InspectionConclution", getInspectionConclution());
        map.put("AssLevel", getAssLevel());
        map.put("DutyFree", getDutyFree());
        map.put("StartTime", Tool.stringOfDateTime(getStartTime()));
        map.put("ProjectArea", getProjectArea());
        map.put("ImpleArea", getImpleArea());
        map.put("ParticipateNum", getParticipateNum() + "");
        map.put("FulltimeNum", getFulltimeNum() + "");
        map.put("Award", getAward());
        map.put("Content", getContent());
        map.put("Meanings", getMeanings());
        map.put("DisiredResults", getDisiredResults());
        map.put("ImplePlace", getImplePlace());
        map.put("Promotion", getPromotion());
        map.put("Specialist", getSpecialist());
        map.put("BeneFicaiaries", getBeneFicaiaries());
        map.put("Benenum", getBenenum() + "");
        map.put("MajorName", getMajorName());
        map.put("MajorSex", getMajorSex());
        map.put("MajorBirth", getMajorBirth());
        map.put("MajorDuty", getMajorDuty());
        map.put("MajorPolista", getMajorPolista());
        map.put("MajorPhone", getMajorPhone());
        map.put("MajorPhone2", getMajorPhone2());
        map.put("MajorEmail", getMajorEmail());
        map.put("GuideTeacherName", getGuideTeacherName());
        map.put("GuideTeacherSex", getGuideTeacherSex());
        map.put("GuideTeacherBirth", getGuideTeacherBirth());
        map.put("GuideTeacherDuty", getGuideTeacherDuty());
        map.put("GuideTeacherPolista", getGuideTeacherPolista());
        map.put("GuideTeacherPhone", getGuideTeacherPhone());
        map.put("GuideTeacherPhone2", getGuideTeacherPhone2());
        map.put("GuiderTeacherEmail", getGuiderTeacherEmail());
        map.put("AddFileList", getAddFileList());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("ProjectId:\"" + getProjectId() + "\"");
        row.add("Sno:\"" + Tool.jsSpecialChars(getSno()) + "\"");
        row.add("Honour:\"" + Tool.jsSpecialChars(getHonour()) + "\"");
        row.add("SubmitFlag:\"" + getSubmitFlag() + "\"");
        row.add("CheckFlag:\"" + getCheckFlag() + "\"");
        row.add("XycheckFalg:\"" + getXycheckFalg() + "\"");
        row.add("CheckComments:\"" + Tool.jsSpecialChars(getCheckComments()) + "\"");
        row.add("AddAccount:\"" + Tool.jsSpecialChars(getAddAccount()) + "\"");
        row.add("Addtime:\"" + Tool.stringOfDateTime(getAddtime()) + "\"");
        row.add("CheckAccount:\"" + Tool.jsSpecialChars(getCheckAccount()) + "\"");
        row.add("CheckTime:\"" + Tool.stringOfDateTime(getCheckTime()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("ProjectName:\"" + Tool.jsSpecialChars(getProjectName()) + "\"");
        row.add("TeamName:\"" + Tool.jsSpecialChars(getTeamName()) + "\"");
        row.add("TeamUnit:\"" + Tool.jsSpecialChars(getTeamUnit()) + "\"");
        row.add("RegisterId:\"" + Tool.jsSpecialChars(getRegisterId()) + "\"");
        row.add("SetupTime:\"" + Tool.stringOfDateTime(getSetupTime()) + "\"");
        row.add("ZipCode:\"" + Tool.jsSpecialChars(getZipCode()) + "\"");
        row.add("ContactAddress:\"" + Tool.jsSpecialChars(getContactAddress()) + "\"");
        row.add("InspectionConclution:\"" + Tool.jsSpecialChars(getInspectionConclution()) + "\"");
        row.add("AssLevel:\"" + Tool.jsSpecialChars(getAssLevel()) + "\"");
        row.add("DutyFree:\"" + Tool.jsSpecialChars(getDutyFree()) + "\"");
        row.add("StartTime:\"" + Tool.stringOfDateTime(getStartTime()) + "\"");
        row.add("ProjectArea:\"" + Tool.jsSpecialChars(getProjectArea()) + "\"");
        row.add("ImpleArea:\"" + Tool.jsSpecialChars(getImpleArea()) + "\"");
        row.add("ParticipateNum:\"" + getParticipateNum() + "\"");
        row.add("FulltimeNum:\"" + getFulltimeNum() + "\"");
        row.add("Award:\"" + Tool.jsSpecialChars(getAward()) + "\"");
        row.add("Content:\"" + Tool.jsSpecialChars(getContent()) + "\"");
        row.add("Meanings:\"" + Tool.jsSpecialChars(getMeanings()) + "\"");
        row.add("DisiredResults:\"" + Tool.jsSpecialChars(getDisiredResults()) + "\"");
        row.add("ImplePlace:\"" + Tool.jsSpecialChars(getImplePlace()) + "\"");
        row.add("Promotion:\"" + Tool.jsSpecialChars(getPromotion()) + "\"");
        row.add("Specialist:\"" + Tool.jsSpecialChars(getSpecialist()) + "\"");
        row.add("BeneFicaiaries:\"" + Tool.jsSpecialChars(getBeneFicaiaries()) + "\"");
        row.add("Benenum:\"" + getBenenum() + "\"");
        row.add("MajorName:\"" + Tool.jsSpecialChars(getMajorName()) + "\"");
        row.add("MajorSex:\"" + Tool.jsSpecialChars(getMajorSex()) + "\"");
        row.add("MajorBirth:\"" + Tool.jsSpecialChars(getMajorBirth()) + "\"");
        row.add("MajorDuty:\"" + Tool.jsSpecialChars(getMajorDuty()) + "\"");
        row.add("MajorPolista:\"" + Tool.jsSpecialChars(getMajorPolista()) + "\"");
        row.add("MajorPhone:\"" + Tool.jsSpecialChars(getMajorPhone()) + "\"");
        row.add("MajorPhone2:\"" + Tool.jsSpecialChars(getMajorPhone2()) + "\"");
        row.add("MajorEmail:\"" + Tool.jsSpecialChars(getMajorEmail()) + "\"");
        row.add("GuideTeacherName:\"" + Tool.jsSpecialChars(getGuideTeacherName()) + "\"");
        row.add("GuideTeacherSex:\"" + Tool.jsSpecialChars(getGuideTeacherSex()) + "\"");
        row.add("GuideTeacherBirth:\"" + Tool.jsSpecialChars(getGuideTeacherBirth()) + "\"");
        row.add("GuideTeacherDuty:\"" + Tool.jsSpecialChars(getGuideTeacherDuty()) + "\"");
        row.add("GuideTeacherPolista:\"" + Tool.jsSpecialChars(getGuideTeacherPolista()) + "\"");
        row.add("GuideTeacherPhone:\"" + Tool.jsSpecialChars(getGuideTeacherPhone()) + "\"");
        row.add("GuideTeacherPhone2:\"" + Tool.jsSpecialChars(getGuideTeacherPhone2()) + "\"");
        row.add("GuiderTeacherEmail:\"" + Tool.jsSpecialChars(getGuiderTeacherEmail()) + "\"");
        row.add("AddFileList:\"" + Tool.jsSpecialChars(getAddFileList()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,projectid number(*,0),sno varchar2(20),honour varchar2(45),submitflag number(*,0),checkflag number(*,0),xycheckfalg number(*,0),checkcomments varchar2(255),addaccount varchar2(45),addtime date,checkaccount varchar2(45),checktime date,academy varchar2(45),projectname varchar2(45),teamname varchar2(45),teamunit varchar2(45),registerid varchar2(45),setuptime date,zipcode varchar2(45),contactaddress varchar2(100),inspectionconclution varchar2(255),asslevel varchar2(45),dutyfree varchar2(2),starttime date,projectarea varchar2(45),implearea varchar2(45),participatenum number(*,0),fulltimenum number(*,0),award varchar2(255),content varchar2(255),meanings varchar2(255),disiredresults varchar2(255),impleplace varchar2(255),promotion varchar2(255),specialist varchar2(255),beneficaiaries varchar2(255),benenum number(*,0),majorname varchar2(45),majorsex varchar2(45),majorbirth varchar2(45),majorduty varchar2(45),majorpolista varchar2(45),majorphone varchar2(45),majorphone2 varchar2(45),majoremail varchar2(45),guideteachername varchar2(45),guideteachersex varchar2(45),guideteacherbirth varchar2(45),guideteacherduty varchar2(45),guideteacherpolista varchar2(45),guideteacherphone varchar2(45),guideteacherphone2 varchar2(45),guiderteacheremail varchar2(45),addfilelist varchar2(500))"});
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
        VolunteerProjectParticipate v = new VolunteerProjectParticipate(sourceDb, sourceTb);
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
        VolunteerProjectParticipate v = new VolunteerProjectParticipate(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(VolunteerProjectParticipate obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getProjectId()).compareTo("" + obj.getProjectId()); if (rtn != 0) return rtn;
        rtn = getSno().compareTo(obj.getSno()); if (rtn != 0) return rtn;
        rtn = getHonour().compareTo(obj.getHonour()); if (rtn != 0) return rtn;
        rtn = ("" + getSubmitFlag()).compareTo("" + obj.getSubmitFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckFlag()).compareTo("" + obj.getCheckFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getXycheckFalg()).compareTo("" + obj.getXycheckFalg()); if (rtn != 0) return rtn;
        rtn = getCheckComments().compareTo(obj.getCheckComments()); if (rtn != 0) return rtn;
        rtn = getAddAccount().compareTo(obj.getAddAccount()); if (rtn != 0) return rtn;
        rtn = getAddtime().compareTo(obj.getAddtime()); if (rtn != 0) return rtn;
        rtn = getCheckAccount().compareTo(obj.getCheckAccount()); if (rtn != 0) return rtn;
        rtn = getCheckTime().compareTo(obj.getCheckTime()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getProjectName().compareTo(obj.getProjectName()); if (rtn != 0) return rtn;
        rtn = getTeamName().compareTo(obj.getTeamName()); if (rtn != 0) return rtn;
        rtn = getTeamUnit().compareTo(obj.getTeamUnit()); if (rtn != 0) return rtn;
        rtn = getRegisterId().compareTo(obj.getRegisterId()); if (rtn != 0) return rtn;
        rtn = getSetupTime().compareTo(obj.getSetupTime()); if (rtn != 0) return rtn;
        rtn = getZipCode().compareTo(obj.getZipCode()); if (rtn != 0) return rtn;
        rtn = getContactAddress().compareTo(obj.getContactAddress()); if (rtn != 0) return rtn;
        rtn = getInspectionConclution().compareTo(obj.getInspectionConclution()); if (rtn != 0) return rtn;
        rtn = getAssLevel().compareTo(obj.getAssLevel()); if (rtn != 0) return rtn;
        rtn = getDutyFree().compareTo(obj.getDutyFree()); if (rtn != 0) return rtn;
        rtn = getStartTime().compareTo(obj.getStartTime()); if (rtn != 0) return rtn;
        rtn = getProjectArea().compareTo(obj.getProjectArea()); if (rtn != 0) return rtn;
        rtn = getImpleArea().compareTo(obj.getImpleArea()); if (rtn != 0) return rtn;
        rtn = ("" + getParticipateNum()).compareTo("" + obj.getParticipateNum()); if (rtn != 0) return rtn;
        rtn = ("" + getFulltimeNum()).compareTo("" + obj.getFulltimeNum()); if (rtn != 0) return rtn;
        rtn = getAward().compareTo(obj.getAward()); if (rtn != 0) return rtn;
        rtn = getContent().compareTo(obj.getContent()); if (rtn != 0) return rtn;
        rtn = getMeanings().compareTo(obj.getMeanings()); if (rtn != 0) return rtn;
        rtn = getDisiredResults().compareTo(obj.getDisiredResults()); if (rtn != 0) return rtn;
        rtn = getImplePlace().compareTo(obj.getImplePlace()); if (rtn != 0) return rtn;
        rtn = getPromotion().compareTo(obj.getPromotion()); if (rtn != 0) return rtn;
        rtn = getSpecialist().compareTo(obj.getSpecialist()); if (rtn != 0) return rtn;
        rtn = getBeneFicaiaries().compareTo(obj.getBeneFicaiaries()); if (rtn != 0) return rtn;
        rtn = ("" + getBenenum()).compareTo("" + obj.getBenenum()); if (rtn != 0) return rtn;
        rtn = getMajorName().compareTo(obj.getMajorName()); if (rtn != 0) return rtn;
        rtn = getMajorSex().compareTo(obj.getMajorSex()); if (rtn != 0) return rtn;
        rtn = getMajorBirth().compareTo(obj.getMajorBirth()); if (rtn != 0) return rtn;
        rtn = getMajorDuty().compareTo(obj.getMajorDuty()); if (rtn != 0) return rtn;
        rtn = getMajorPolista().compareTo(obj.getMajorPolista()); if (rtn != 0) return rtn;
        rtn = getMajorPhone().compareTo(obj.getMajorPhone()); if (rtn != 0) return rtn;
        rtn = getMajorPhone2().compareTo(obj.getMajorPhone2()); if (rtn != 0) return rtn;
        rtn = getMajorEmail().compareTo(obj.getMajorEmail()); if (rtn != 0) return rtn;
        rtn = getGuideTeacherName().compareTo(obj.getGuideTeacherName()); if (rtn != 0) return rtn;
        rtn = getGuideTeacherSex().compareTo(obj.getGuideTeacherSex()); if (rtn != 0) return rtn;
        rtn = getGuideTeacherBirth().compareTo(obj.getGuideTeacherBirth()); if (rtn != 0) return rtn;
        rtn = getGuideTeacherDuty().compareTo(obj.getGuideTeacherDuty()); if (rtn != 0) return rtn;
        rtn = getGuideTeacherPolista().compareTo(obj.getGuideTeacherPolista()); if (rtn != 0) return rtn;
        rtn = getGuideTeacherPhone().compareTo(obj.getGuideTeacherPhone()); if (rtn != 0) return rtn;
        rtn = getGuideTeacherPhone2().compareTo(obj.getGuideTeacherPhone2()); if (rtn != 0) return rtn;
        rtn = getGuiderTeacherEmail().compareTo(obj.getGuiderTeacherEmail()); if (rtn != 0) return rtn;
        rtn = getAddFileList().compareTo(obj.getAddFileList()); if (rtn != 0) return rtn;
        return rtn;
    }
}
