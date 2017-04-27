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
@Description("学生社团基本信息")
public class Club implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(Club.class);
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
    public static final String DbTableName = "club";
    private String TNAME = "club";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","clubName","clubCode","clubId","clubType","tenet","clubProfile","academy","teacher","chairman","sponsor","feasibility","commentTea","commentAcademy","addPerson","addTime","modiPerson","modiTime","applyRecruitment","managerFlag","teaFlag","checkFlag","commenttw","clubqq","clubeMail","clubPubAccount","clubTimeSetup","clubTimeCheck","addPersonName","teacherModifyFlag","addFileList","recruitmentStart","recruitmentStop","recruitmentCheckflag","iscancle","cancleReason","cancleCheckFlag","cancleCommentXy","cancleCommentTw","city"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","clubname","clubcode","clubid","clubtype","tenet","clubprofile","academy","teacher","chairman","sponsor","feasibility","commenttea","commentacademy","addperson","addtime","modiperson","moditime","applyrecruitment","managerflag","teaflag","checkflag","commenttw","clubqq","clubemail","clubpubaccount","clubtimesetup","clubtimecheck","addpersonname","teachermodifyflag","addfilelist","recruitmentstart","recruitmentstop","recruitmentcheckflag","iscancle","canclereason","canclecheckflag","canclecommentxy","canclecommenttw","city"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"ClubName","clubname","String"},{"ClubCode","clubcode","String"},{"ClubId","clubid","String"},{"ClubType","clubtype","String"},{"Tenet","tenet","String"},{"ClubProfile","clubprofile","String"},{"Academy","academy","String"},{"Teacher","teacher","String"},{"Chairman","chairman","String"},{"Sponsor","sponsor","String"},{"Feasibility","feasibility","String"},{"CommentTea","commenttea","String"},{"CommentAcademy","commentacademy","String"},{"AddPerson","addperson","String"},{"AddTime","addtime","java.util.Date"},{"ModiPerson","modiperson","String"},{"ModiTime","moditime","java.util.Date"},{"ApplyRecruitment","applyrecruitment","int"},{"ManagerFlag","managerflag","int"},{"TeaFlag","teaflag","int"},{"CheckFlag","checkflag","String"},{"Commenttw","commenttw","String"},{"Clubqq","clubqq","String"},{"ClubeMail","clubemail","String"},{"ClubPubAccount","clubpubaccount","String"},{"ClubTimeSetup","clubtimesetup","String"},{"ClubTimeCheck","clubtimecheck","java.util.Date"},{"AddPersonName","addpersonname","String"},{"TeacherModifyFlag","teachermodifyflag","int"},{"AddFileList","addfilelist","String"},{"RecruitmentStart","recruitmentstart","java.util.Date"},{"RecruitmentStop","recruitmentstop","java.util.Date"},{"RecruitmentCheckflag","recruitmentcheckflag","int"},{"Iscancle","iscancle","int"},{"CancleReason","canclereason","String"},{"CancleCheckFlag","canclecheckflag","int"},{"CancleCommentXy","canclecommentxy","String"},{"CancleCommentTw","canclecommenttw","String"},{"City","city","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"clubName","clubname"},{"clubCode","clubcode"},{"clubId","clubid"},{"clubType","clubtype"},{"tenet","tenet"},{"clubProfile","clubprofile"},{"academy","academy"},{"teacher","teacher"},{"chairman","chairman"},{"sponsor","sponsor"},{"feasibility","feasibility"},{"commentTea","commenttea"},{"commentAcademy","commentacademy"},{"addPerson","addperson"},{"addTime","addtime"},{"modiPerson","modiperson"},{"modiTime","moditime"},{"applyRecruitment","applyrecruitment"},{"managerFlag","managerflag"},{"teaFlag","teaflag"},{"checkFlag","checkflag"},{"commenttw","commenttw"},{"clubqq","clubqq"},{"clubeMail","clubemail"},{"clubPubAccount","clubpubaccount"},{"clubTimeSetup","clubtimesetup"},{"clubTimeCheck","clubtimecheck"},{"addPersonName","addpersonname"},{"teacherModifyFlag","teachermodifyflag"},{"addFileList","addfilelist"},{"recruitmentStart","recruitmentstart"},{"recruitmentStop","recruitmentstop"},{"recruitmentCheckflag","recruitmentcheckflag"},{"iscancle","iscancle"},{"cancleReason","canclereason"},{"cancleCheckFlag","canclecheckflag"},{"cancleCommentXy","canclecommentxy"},{"cancleCommentTw","canclecommenttw"},{"city","city"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME","MODITIME","CLUBTIMECHECK","RECRUITMENTSTART","RECRUITMENTSTOP"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 社团名称
    protected String clubName = "";
    public String getClubName() {  return SqlTool.getDbString(clubName);  }
    public String getClubName(int size) { return SqlTool.subString(getClubName(), size); }
    public void setClubName(String aClubName) { clubName = aClubName; modifiedFields.add("ClubName"); refreshFlag = true; }
    public void assignClubName(String aClubName) { clubName = aClubName; }
    public void paramClubName(HttpServletRequest request) { paramClubName(request, "ClubName"); }
    public void paramClubName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubName()); if (!tmp.equals(getClubName())) { setClubName(tmp); } }
    // 社团编码
    protected String clubCode = "";
    public String getClubCode() {  return SqlTool.getDbString(clubCode);  }
    public String getClubCode(int size) { return SqlTool.subString(getClubCode(), size); }
    public void setClubCode(String aClubCode) { clubCode = aClubCode; modifiedFields.add("ClubCode"); }
    public void assignClubCode(String aClubCode) { clubCode = aClubCode; }
    public void paramClubCode(HttpServletRequest request) { paramClubCode(request, "ClubCode"); }
    public void paramClubCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubCode()); if (!tmp.equals(getClubCode())) { setClubCode(tmp); } }
    // 登录账号
    protected String clubId = "";
    public String getClubId() {  return SqlTool.getDbString(clubId);  }
    public String getClubId(int size) { return SqlTool.subString(getClubId(), size); }
    public void setClubId(String aClubId) { clubId = aClubId; modifiedFields.add("ClubId"); }
    public void assignClubId(String aClubId) { clubId = aClubId; }
    public void paramClubId(HttpServletRequest request) { paramClubId(request, "ClubId"); }
    public void paramClubId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubId()); if (!tmp.equals(getClubId())) { setClubId(tmp); } }
    // 社团类别
    protected String clubType = "";
    public String getClubType() {  return SqlTool.getDbString(clubType);  }
    public String getClubType(int size) { return SqlTool.subString(getClubType(), size); }
    public void setClubType(String aClubType) { clubType = aClubType; modifiedFields.add("ClubType"); }
    public void assignClubType(String aClubType) { clubType = aClubType; }
    public void paramClubType(HttpServletRequest request) { paramClubType(request, "ClubType"); }
    public void paramClubType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubType()); if (!tmp.equals(getClubType())) { setClubType(tmp); } }
    // 宗旨
    protected String tenet = "";
    public String getTenet() {  return SqlTool.getDbString(tenet);  }
    public String getTenet(int size) { return SqlTool.subString(getTenet(), size); }
    public void setTenet(String aTenet) { tenet = aTenet; modifiedFields.add("Tenet"); }
    public void assignTenet(String aTenet) { tenet = aTenet; }
    public void paramTenet(HttpServletRequest request) { paramTenet(request, "Tenet"); }
    public void paramTenet(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTenet()); if (!tmp.equals(getTenet())) { setTenet(tmp); } }
    // 简介
    protected String clubProfile = "";
    public String getClubProfile() {  return SqlTool.getDbString(clubProfile);  }
    public String getClubProfile(int size) { return SqlTool.subString(getClubProfile(), size); }
    public void setClubProfile(String aClubProfile) { clubProfile = aClubProfile; modifiedFields.add("ClubProfile"); }
    public void assignClubProfile(String aClubProfile) { clubProfile = aClubProfile; }
    public void paramClubProfile(HttpServletRequest request) { paramClubProfile(request, "ClubProfile"); }
    public void paramClubProfile(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubProfile()); if (!tmp.equals(getClubProfile())) { setClubProfile(tmp); } }
    // 学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 教师
    protected String teacher = "";
    public String getTeacher() {  return SqlTool.getDbString(teacher);  }
    public String getTeacher(int size) { return SqlTool.subString(getTeacher(), size); }
    public void setTeacher(String aTeacher) { teacher = aTeacher; modifiedFields.add("Teacher"); }
    public void assignTeacher(String aTeacher) { teacher = aTeacher; }
    public void paramTeacher(HttpServletRequest request) { paramTeacher(request, "Teacher"); }
    public void paramTeacher(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeacher()); if (!tmp.equals(getTeacher())) { setTeacher(tmp); } }
    // 拟负责人
    protected String chairman = "";
    public String getChairman() {  return SqlTool.getDbString(chairman);  }
    public String getChairman(int size) { return SqlTool.subString(getChairman(), size); }
    public void setChairman(String aChairman) { chairman = aChairman; modifiedFields.add("Chairman"); }
    public void assignChairman(String aChairman) { chairman = aChairman; }
    public void paramChairman(HttpServletRequest request) { paramChairman(request, "Chairman"); }
    public void paramChairman(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getChairman()); if (!tmp.equals(getChairman())) { setChairman(tmp); } }
    // 发起人情况
    protected String sponsor = "";
    public String getSponsor() {  return SqlTool.getDbString(sponsor);  }
    public String getSponsor(int size) { return SqlTool.subString(getSponsor(), size); }
    public void setSponsor(String aSponsor) { sponsor = aSponsor; modifiedFields.add("Sponsor"); }
    public void assignSponsor(String aSponsor) { sponsor = aSponsor; }
    public void paramSponsor(HttpServletRequest request) { paramSponsor(request, "Sponsor"); }
    public void paramSponsor(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSponsor()); if (!tmp.equals(getSponsor())) { setSponsor(tmp); } }
    // 成立原因
    protected String feasibility = "";
    public String getFeasibility() {  return SqlTool.getDbString(feasibility);  }
    public String getFeasibility(int size) { return SqlTool.subString(getFeasibility(), size); }
    public void setFeasibility(String aFeasibility) { feasibility = aFeasibility; modifiedFields.add("Feasibility"); }
    public void assignFeasibility(String aFeasibility) { feasibility = aFeasibility; }
    public void paramFeasibility(HttpServletRequest request) { paramFeasibility(request, "Feasibility"); }
    public void paramFeasibility(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFeasibility()); if (!tmp.equals(getFeasibility())) { setFeasibility(tmp); } }
    // 指导教师意见
    protected String commentTea = "";
    public String getCommentTea() {  return SqlTool.getDbString(commentTea);  }
    public String getCommentTea(int size) { return SqlTool.subString(getCommentTea(), size); }
    public void setCommentTea(String aCommentTea) { commentTea = aCommentTea; modifiedFields.add("CommentTea"); }
    public void assignCommentTea(String aCommentTea) { commentTea = aCommentTea; }
    public void paramCommentTea(HttpServletRequest request) { paramCommentTea(request, "CommentTea"); }
    public void paramCommentTea(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentTea()); if (!tmp.equals(getCommentTea())) { setCommentTea(tmp); } }
    // 学院审核意见
    protected String commentAcademy = "";
    public String getCommentAcademy() {  return SqlTool.getDbString(commentAcademy);  }
    public String getCommentAcademy(int size) { return SqlTool.subString(getCommentAcademy(), size); }
    public void setCommentAcademy(String aCommentAcademy) { commentAcademy = aCommentAcademy; modifiedFields.add("CommentAcademy"); }
    public void assignCommentAcademy(String aCommentAcademy) { commentAcademy = aCommentAcademy; }
    public void paramCommentAcademy(HttpServletRequest request) { paramCommentAcademy(request, "CommentAcademy"); }
    public void paramCommentAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentAcademy()); if (!tmp.equals(getCommentAcademy())) { setCommentAcademy(tmp); } }
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
    protected String modiPerson = "";
    public String getModiPerson() {  return SqlTool.getDbString(modiPerson);  }
    public String getModiPerson(int size) { return SqlTool.subString(getModiPerson(), size); }
    public void setModiPerson(String aModiPerson) { modiPerson = aModiPerson; modifiedFields.add("ModiPerson"); }
    public void assignModiPerson(String aModiPerson) { modiPerson = aModiPerson; }
    public void paramModiPerson(HttpServletRequest request) { paramModiPerson(request, "ModiPerson"); }
    public void paramModiPerson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getModiPerson()); if (!tmp.equals(getModiPerson())) { setModiPerson(tmp); } }
    // 修改时间
    protected java.util.Date modiTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getModiTime() { return modiTime; }
    public void setModiTime(java.util.Date aModiTime) { modiTime = aModiTime; modifiedFields.add("ModiTime"); }
    public void assignModiTime(java.util.Date aModiTime) { modiTime = aModiTime; }
    public void paramModiTime(HttpServletRequest request) { paramModiTime(request, "ModiTime"); }
    public void paramModiTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getModiTime()); if (tmp.compareTo(getModiTime()) != 0) { setModiTime(tmp); } }
    // 申请纳新
    protected int applyRecruitment = -1;
    public int getApplyRecruitment() { return applyRecruitment; }
    public void setApplyRecruitment(int aApplyRecruitment) { applyRecruitment = aApplyRecruitment; modifiedFields.add("ApplyRecruitment"); }
    public void assignApplyRecruitment(int aApplyRecruitment) { applyRecruitment = aApplyRecruitment; }
    public void paramApplyRecruitment(HttpServletRequest request) { paramApplyRecruitment(request, "ApplyRecruitment"); }
    public void paramApplyRecruitment(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getApplyRecruitment()); if (tmp != getApplyRecruitment()) { setApplyRecruitment(tmp); } }
    // 是否添加负责人
    protected int managerFlag = 0;
    public int getManagerFlag() { return managerFlag; }
    public void setManagerFlag(int aManagerFlag) { managerFlag = aManagerFlag; modifiedFields.add("ManagerFlag"); }
    public void assignManagerFlag(int aManagerFlag) { managerFlag = aManagerFlag; }
    public void paramManagerFlag(HttpServletRequest request) { paramManagerFlag(request, "ManagerFlag"); }
    public void paramManagerFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getManagerFlag()); if (tmp != getManagerFlag()) { setManagerFlag(tmp); } }
    // 是否添加指导教师
    protected int teaFlag = 0;
    public int getTeaFlag() { return teaFlag; }
    public void setTeaFlag(int aTeaFlag) { teaFlag = aTeaFlag; modifiedFields.add("TeaFlag"); }
    public void assignTeaFlag(int aTeaFlag) { teaFlag = aTeaFlag; }
    public void paramTeaFlag(HttpServletRequest request) { paramTeaFlag(request, "TeaFlag"); }
    public void paramTeaFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getTeaFlag()); if (tmp != getTeaFlag()) { setTeaFlag(tmp); } }
    // 审核
    protected String checkFlag = "";
    public String getCheckFlag() {  return SqlTool.getDbString(checkFlag);  }
    public String getCheckFlag(int size) { return SqlTool.subString(getCheckFlag(), size); }
    public void setCheckFlag(String aCheckFlag) { checkFlag = aCheckFlag; modifiedFields.add("CheckFlag"); }
    public void assignCheckFlag(String aCheckFlag) { checkFlag = aCheckFlag; }
    public void paramCheckFlag(HttpServletRequest request) { paramCheckFlag(request, "CheckFlag"); }
    public void paramCheckFlag(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCheckFlag()); if (!tmp.equals(getCheckFlag())) { setCheckFlag(tmp); } }
    // 团委审核意见
    protected String commenttw = "";
    public String getCommenttw() {  return SqlTool.getDbString(commenttw);  }
    public String getCommenttw(int size) { return SqlTool.subString(getCommenttw(), size); }
    public void setCommenttw(String aCommenttw) { commenttw = aCommenttw; modifiedFields.add("Commenttw"); }
    public void assignCommenttw(String aCommenttw) { commenttw = aCommenttw; }
    public void paramCommenttw(HttpServletRequest request) { paramCommenttw(request, "Commenttw"); }
    public void paramCommenttw(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommenttw()); if (!tmp.equals(getCommenttw())) { setCommenttw(tmp); } }
    // 联系方式QQ
    protected String clubqq = "";
    public String getClubqq() {  return SqlTool.getDbString(clubqq);  }
    public String getClubqq(int size) { return SqlTool.subString(getClubqq(), size); }
    public void setClubqq(String aClubqq) { clubqq = aClubqq; modifiedFields.add("Clubqq"); }
    public void assignClubqq(String aClubqq) { clubqq = aClubqq; }
    public void paramClubqq(HttpServletRequest request) { paramClubqq(request, "Clubqq"); }
    public void paramClubqq(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubqq()); if (!tmp.equals(getClubqq())) { setClubqq(tmp); } }
    // 邮箱
    protected String clubeMail = "";
    public String getClubeMail() {  return SqlTool.getDbString(clubeMail);  }
    public String getClubeMail(int size) { return SqlTool.subString(getClubeMail(), size); }
    public void setClubeMail(String aClubeMail) { clubeMail = aClubeMail; modifiedFields.add("ClubeMail"); }
    public void assignClubeMail(String aClubeMail) { clubeMail = aClubeMail; }
    public void paramClubeMail(HttpServletRequest request) { paramClubeMail(request, "ClubeMail"); }
    public void paramClubeMail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubeMail()); if (!tmp.equals(getClubeMail())) { setClubeMail(tmp); } }
    // 公众号
    protected String clubPubAccount = "";
    public String getClubPubAccount() {  return SqlTool.getDbString(clubPubAccount);  }
    public String getClubPubAccount(int size) { return SqlTool.subString(getClubPubAccount(), size); }
    public void setClubPubAccount(String aClubPubAccount) { clubPubAccount = aClubPubAccount; modifiedFields.add("ClubPubAccount"); }
    public void assignClubPubAccount(String aClubPubAccount) { clubPubAccount = aClubPubAccount; }
    public void paramClubPubAccount(HttpServletRequest request) { paramClubPubAccount(request, "ClubPubAccount"); }
    public void paramClubPubAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubPubAccount()); if (!tmp.equals(getClubPubAccount())) { setClubPubAccount(tmp); } }
    // 成立时间
    protected String clubTimeSetup = "";
    public String getClubTimeSetup() {  return SqlTool.getDbString(clubTimeSetup);  }
    public String getClubTimeSetup(int size) { return SqlTool.subString(getClubTimeSetup(), size); }
    public void setClubTimeSetup(String aClubTimeSetup) { clubTimeSetup = aClubTimeSetup; modifiedFields.add("ClubTimeSetup"); }
    public void assignClubTimeSetup(String aClubTimeSetup) { clubTimeSetup = aClubTimeSetup; }
    public void paramClubTimeSetup(HttpServletRequest request) { paramClubTimeSetup(request, "ClubTimeSetup"); }
    public void paramClubTimeSetup(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubTimeSetup()); if (!tmp.equals(getClubTimeSetup())) { setClubTimeSetup(tmp); } }
    // 批准时间
    protected java.util.Date clubTimeCheck = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getClubTimeCheck() { return clubTimeCheck; }
    public void setClubTimeCheck(java.util.Date aClubTimeCheck) { clubTimeCheck = aClubTimeCheck; modifiedFields.add("ClubTimeCheck"); }
    public void assignClubTimeCheck(java.util.Date aClubTimeCheck) { clubTimeCheck = aClubTimeCheck; }
    public void paramClubTimeCheck(HttpServletRequest request) { paramClubTimeCheck(request, "ClubTimeCheck"); }
    public void paramClubTimeCheck(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getClubTimeCheck()); if (tmp.compareTo(getClubTimeCheck()) != 0) { setClubTimeCheck(tmp); } }
    // 添加人姓名
    protected String addPersonName = "";
    public String getAddPersonName() {  return SqlTool.getDbString(addPersonName);  }
    public String getAddPersonName(int size) { return SqlTool.subString(getAddPersonName(), size); }
    public void setAddPersonName(String aAddPersonName) { addPersonName = aAddPersonName; modifiedFields.add("AddPersonName"); }
    public void assignAddPersonName(String aAddPersonName) { addPersonName = aAddPersonName; }
    public void paramAddPersonName(HttpServletRequest request) { paramAddPersonName(request, "AddPersonName"); }
    public void paramAddPersonName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddPersonName()); if (!tmp.equals(getAddPersonName())) { setAddPersonName(tmp); } }
    // 指导教师是否更换
    protected int teacherModifyFlag = -1;
    public int getTeacherModifyFlag() { return teacherModifyFlag; }
    public void setTeacherModifyFlag(int aTeacherModifyFlag) { teacherModifyFlag = aTeacherModifyFlag; modifiedFields.add("TeacherModifyFlag"); }
    public void assignTeacherModifyFlag(int aTeacherModifyFlag) { teacherModifyFlag = aTeacherModifyFlag; }
    public void paramTeacherModifyFlag(HttpServletRequest request) { paramTeacherModifyFlag(request, "TeacherModifyFlag"); }
    public void paramTeacherModifyFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getTeacherModifyFlag()); if (tmp != getTeacherModifyFlag()) { setTeacherModifyFlag(tmp); } }
    // 附件
    protected String addFileList = "";
    public String getAddFileList() {  return SqlTool.getDbString(addFileList);  }
    public String getAddFileList(int size) { return SqlTool.subString(getAddFileList(), size); }
    public void setAddFileList(String aAddFileList) { addFileList = aAddFileList; modifiedFields.add("AddFileList"); }
    public void assignAddFileList(String aAddFileList) { addFileList = aAddFileList; }
    public void paramAddFileList(HttpServletRequest request) { paramAddFileList(request, "AddFileList"); }
    public void paramAddFileList(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddFileList()); if (!tmp.equals(getAddFileList())) { setAddFileList(tmp); } }
    // 社团招新开始日期
    protected java.util.Date recruitmentStart = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getRecruitmentStart() { return recruitmentStart; }
    public void setRecruitmentStart(java.util.Date aRecruitmentStart) { recruitmentStart = aRecruitmentStart; modifiedFields.add("RecruitmentStart"); }
    public void assignRecruitmentStart(java.util.Date aRecruitmentStart) { recruitmentStart = aRecruitmentStart; }
    public void paramRecruitmentStart(HttpServletRequest request) { paramRecruitmentStart(request, "RecruitmentStart"); }
    public void paramRecruitmentStart(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getRecruitmentStart()); if (tmp.compareTo(getRecruitmentStart()) != 0) { setRecruitmentStart(tmp); } }
    // 社团招新结束日期
    protected java.util.Date recruitmentStop = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getRecruitmentStop() { return recruitmentStop; }
    public void setRecruitmentStop(java.util.Date aRecruitmentStop) { recruitmentStop = aRecruitmentStop; modifiedFields.add("RecruitmentStop"); }
    public void assignRecruitmentStop(java.util.Date aRecruitmentStop) { recruitmentStop = aRecruitmentStop; }
    public void paramRecruitmentStop(HttpServletRequest request) { paramRecruitmentStop(request, "RecruitmentStop"); }
    public void paramRecruitmentStop(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getRecruitmentStop()); if (tmp.compareTo(getRecruitmentStop()) != 0) { setRecruitmentStop(tmp); } }
    // 社团是否招新标志
    protected int recruitmentCheckflag = -1;
    public int getRecruitmentCheckflag() { return recruitmentCheckflag; }
    public void setRecruitmentCheckflag(int aRecruitmentCheckflag) { recruitmentCheckflag = aRecruitmentCheckflag; modifiedFields.add("RecruitmentCheckflag"); }
    public void assignRecruitmentCheckflag(int aRecruitmentCheckflag) { recruitmentCheckflag = aRecruitmentCheckflag; }
    public void paramRecruitmentCheckflag(HttpServletRequest request) { paramRecruitmentCheckflag(request, "RecruitmentCheckflag"); }
    public void paramRecruitmentCheckflag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getRecruitmentCheckflag()); if (tmp != getRecruitmentCheckflag()) { setRecruitmentCheckflag(tmp); } }
    // 是否注销
    protected int iscancle = 0;
    public int getIscancle() { return iscancle; }
    public void setIscancle(int aIscancle) { iscancle = aIscancle; modifiedFields.add("Iscancle"); }
    public void assignIscancle(int aIscancle) { iscancle = aIscancle; }
    public void paramIscancle(HttpServletRequest request) { paramIscancle(request, "Iscancle"); }
    public void paramIscancle(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getIscancle()); if (tmp != getIscancle()) { setIscancle(tmp); } }
    // 注销原因
    protected String cancleReason = "";
    public String getCancleReason() {  return SqlTool.getDbString(cancleReason);  }
    public String getCancleReason(int size) { return SqlTool.subString(getCancleReason(), size); }
    public void setCancleReason(String aCancleReason) { cancleReason = aCancleReason; modifiedFields.add("CancleReason"); }
    public void assignCancleReason(String aCancleReason) { cancleReason = aCancleReason; }
    public void paramCancleReason(HttpServletRequest request) { paramCancleReason(request, "CancleReason"); }
    public void paramCancleReason(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCancleReason()); if (!tmp.equals(getCancleReason())) { setCancleReason(tmp); } }
    // 注销状态
    protected int cancleCheckFlag = -1;
    public int getCancleCheckFlag() { return cancleCheckFlag; }
    public void setCancleCheckFlag(int aCancleCheckFlag) { cancleCheckFlag = aCancleCheckFlag; modifiedFields.add("CancleCheckFlag"); }
    public void assignCancleCheckFlag(int aCancleCheckFlag) { cancleCheckFlag = aCancleCheckFlag; }
    public void paramCancleCheckFlag(HttpServletRequest request) { paramCancleCheckFlag(request, "CancleCheckFlag"); }
    public void paramCancleCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCancleCheckFlag()); if (tmp != getCancleCheckFlag()) { setCancleCheckFlag(tmp); } }
    // 注销原因学院
    protected String cancleCommentXy = "";
    public String getCancleCommentXy() {  return SqlTool.getDbString(cancleCommentXy);  }
    public String getCancleCommentXy(int size) { return SqlTool.subString(getCancleCommentXy(), size); }
    public void setCancleCommentXy(String aCancleCommentXy) { cancleCommentXy = aCancleCommentXy; modifiedFields.add("CancleCommentXy"); }
    public void assignCancleCommentXy(String aCancleCommentXy) { cancleCommentXy = aCancleCommentXy; }
    public void paramCancleCommentXy(HttpServletRequest request) { paramCancleCommentXy(request, "CancleCommentXy"); }
    public void paramCancleCommentXy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCancleCommentXy()); if (!tmp.equals(getCancleCommentXy())) { setCancleCommentXy(tmp); } }
    // 注销原因团委
    protected String cancleCommentTw = "";
    public String getCancleCommentTw() {  return SqlTool.getDbString(cancleCommentTw);  }
    public String getCancleCommentTw(int size) { return SqlTool.subString(getCancleCommentTw(), size); }
    public void setCancleCommentTw(String aCancleCommentTw) { cancleCommentTw = aCancleCommentTw; modifiedFields.add("CancleCommentTw"); }
    public void assignCancleCommentTw(String aCancleCommentTw) { cancleCommentTw = aCancleCommentTw; }
    public void paramCancleCommentTw(HttpServletRequest request) { paramCancleCommentTw(request, "CancleCommentTw"); }
    public void paramCancleCommentTw(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCancleCommentTw()); if (!tmp.equals(getCancleCommentTw())) { setCancleCommentTw(tmp); } }
    // 城市
    protected String city = "";
    public String getCity() {  return SqlTool.getDbString(city);  }
    public String getCity(int size) { return SqlTool.subString(getCity(), size); }
    public void setCity(String aCity) { city = aCity; modifiedFields.add("City"); }
    public void assignCity(String aCity) { city = aCity; }
    public void paramCity(HttpServletRequest request) { paramCity(request, "City"); }
    public void paramCity(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCity()); if (!tmp.equals(getCity())) { setCity(tmp); } }
    protected InputStream isapplyIdLists = new ByteArrayInputStream(new byte[0]);
    private int stateOfapplyIdLists = 0;
    public InputStream getApplyIdLists() {
        if (id <= 0||stateOfapplyIdLists == 2) {
            return isapplyIdLists;
        }
        if(stateOfapplyIdLists == 0) {
            SqlTool applyIdLists = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "applyidlists", "id");
            isapplyIdLists = applyIdLists.getBlob("jdbc/ds", getId());
            stateOfapplyIdLists = 1;
        }
        if(isapplyIdLists == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        else {
            return isapplyIdLists;
        }
    }
    public void setApplyIdLists(InputStream aApplyIdLists) {
        isapplyIdLists = aApplyIdLists;
        modifiedFields.add("ApplyIdLists");
        stateOfapplyIdLists = 2;
    }
    protected InputStream ismenberIdLists = new ByteArrayInputStream(new byte[0]);
    private int stateOfmenberIdLists = 0;
    public InputStream getMenberIdLists() {
        if (id <= 0||stateOfmenberIdLists == 2) {
            return ismenberIdLists;
        }
        if(stateOfmenberIdLists == 0) {
            SqlTool menberIdLists = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "menberidlists", "id");
            ismenberIdLists = menberIdLists.getBlob("jdbc/ds", getId());
            stateOfmenberIdLists = 1;
        }
        if(ismenberIdLists == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        else {
            return ismenberIdLists;
        }
    }
    public void setMenberIdLists(InputStream aMenberIdLists) {
        ismenberIdLists = aMenberIdLists;
        modifiedFields.add("MenberIdLists");
        stateOfmenberIdLists = 2;
    }
    protected InputStream ismemberNames = new ByteArrayInputStream(new byte[0]);
    private int stateOfmemberNames = 0;
    public InputStream getMemberNames() {
        if (id <= 0||stateOfmemberNames == 2) {
            return ismemberNames;
        }
        if(stateOfmemberNames == 0) {
            SqlTool memberNames = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "membernames", "id");
            ismemberNames = memberNames.getBlob("jdbc/ds", getId());
            stateOfmemberNames = 1;
        }
        if(ismemberNames == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        else {
            return ismemberNames;
        }
    }
    public void setMemberNames(InputStream aMemberNames) {
        ismemberNames = aMemberNames;
        modifiedFields.add("MemberNames");
        stateOfmemberNames = 2;
    }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public Club (String db) {
        DBNAME = db;
    }
    public Club (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public Club (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public Club () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return Club类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public Club getByParameter(HttpServletRequest request) {
        Club v = new Club(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramClubName(request);
        paramClubCode(request);
        paramClubId(request);
        paramClubType(request);
        paramTenet(request);
        paramClubProfile(request);
        paramAcademy(request);
        paramTeacher(request);
        paramChairman(request);
        paramSponsor(request);
        paramFeasibility(request);
        paramCommentTea(request);
        paramCommentAcademy(request);
        paramAddPerson(request);
        paramAddTime(request);
        paramModiPerson(request);
        paramModiTime(request);
        paramApplyRecruitment(request);
        paramManagerFlag(request);
        paramTeaFlag(request);
        paramCheckFlag(request);
        paramCommenttw(request);
        paramClubqq(request);
        paramClubeMail(request);
        paramClubPubAccount(request);
        paramClubTimeSetup(request);
        paramClubTimeCheck(request);
        paramAddPersonName(request);
        paramTeacherModifyFlag(request);
        paramAddFileList(request);
        paramRecruitmentStart(request);
        paramRecruitmentStop(request);
        paramRecruitmentCheckflag(request);
        paramIscancle(request);
        paramCancleReason(request);
        paramCancleCheckFlag(request);
        paramCancleCommentXy(request);
        paramCancleCommentTw(request);
        paramCity(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(Club bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("clubName")) { setClubName(bean.getClubName()); }
        if (!ncl.contains("clubCode")) { setClubCode(bean.getClubCode()); }
        if (!ncl.contains("clubId")) { setClubId(bean.getClubId()); }
        if (!ncl.contains("clubType")) { setClubType(bean.getClubType()); }
        if (!ncl.contains("tenet")) { setTenet(bean.getTenet()); }
        if (!ncl.contains("clubProfile")) { setClubProfile(bean.getClubProfile()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("teacher")) { setTeacher(bean.getTeacher()); }
        if (!ncl.contains("chairman")) { setChairman(bean.getChairman()); }
        if (!ncl.contains("sponsor")) { setSponsor(bean.getSponsor()); }
        if (!ncl.contains("feasibility")) { setFeasibility(bean.getFeasibility()); }
        if (!ncl.contains("commentTea")) { setCommentTea(bean.getCommentTea()); }
        if (!ncl.contains("commentAcademy")) { setCommentAcademy(bean.getCommentAcademy()); }
        if (!ncl.contains("addPerson")) { setAddPerson(bean.getAddPerson()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("modiPerson")) { setModiPerson(bean.getModiPerson()); }
        if (!ncl.contains("modiTime")) { setModiTime(bean.getModiTime()); }
        if (!ncl.contains("applyRecruitment")) { setApplyRecruitment(bean.getApplyRecruitment()); }
        if (!ncl.contains("managerFlag")) { setManagerFlag(bean.getManagerFlag()); }
        if (!ncl.contains("teaFlag")) { setTeaFlag(bean.getTeaFlag()); }
        if (!ncl.contains("checkFlag")) { setCheckFlag(bean.getCheckFlag()); }
        if (!ncl.contains("commenttw")) { setCommenttw(bean.getCommenttw()); }
        if (!ncl.contains("clubqq")) { setClubqq(bean.getClubqq()); }
        if (!ncl.contains("clubeMail")) { setClubeMail(bean.getClubeMail()); }
        if (!ncl.contains("clubPubAccount")) { setClubPubAccount(bean.getClubPubAccount()); }
        if (!ncl.contains("clubTimeSetup")) { setClubTimeSetup(bean.getClubTimeSetup()); }
        if (!ncl.contains("clubTimeCheck")) { setClubTimeCheck(bean.getClubTimeCheck()); }
        if (!ncl.contains("addPersonName")) { setAddPersonName(bean.getAddPersonName()); }
        if (!ncl.contains("teacherModifyFlag")) { setTeacherModifyFlag(bean.getTeacherModifyFlag()); }
        if (!ncl.contains("addFileList")) { setAddFileList(bean.getAddFileList()); }
        if (!ncl.contains("recruitmentStart")) { setRecruitmentStart(bean.getRecruitmentStart()); }
        if (!ncl.contains("recruitmentStop")) { setRecruitmentStop(bean.getRecruitmentStop()); }
        if (!ncl.contains("recruitmentCheckflag")) { setRecruitmentCheckflag(bean.getRecruitmentCheckflag()); }
        if (!ncl.contains("iscancle")) { setIscancle(bean.getIscancle()); }
        if (!ncl.contains("cancleReason")) { setCancleReason(bean.getCancleReason()); }
        if (!ncl.contains("cancleCheckFlag")) { setCancleCheckFlag(bean.getCancleCheckFlag()); }
        if (!ncl.contains("cancleCommentXy")) { setCancleCommentXy(bean.getCancleCommentXy()); }
        if (!ncl.contains("cancleCommentTw")) { setCancleCommentTw(bean.getCancleCommentTw()); }
        if (!ncl.contains("city")) { setCity(bean.getCity()); }
    }
    public Club getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        Club[] rslt= queryByCondition(cdt);
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
     * @return Club类的实例列表。
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
                Club ve = new Club(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignClubName(fromDbCh(rs.getString(2)));
                ve.assignClubCode(fromDbCh(rs.getString(3)));
                ve.assignClubId(fromDbCh(rs.getString(4)));
                ve.assignClubType(fromDbCh(rs.getString(5)));
                ve.assignTenet(fromDbCh(rs.getString(6)));
                ve.assignClubProfile(fromDbCh(rs.getString(7)));
                ve.assignAcademy(fromDbCh(rs.getString(8)));
                ve.assignTeacher(fromDbCh(rs.getString(9)));
                ve.assignChairman(fromDbCh(rs.getString(10)));
                ve.assignSponsor(fromDbCh(rs.getString(11)));
                ve.assignFeasibility(fromDbCh(rs.getString(12)));
                ve.assignCommentTea(fromDbCh(rs.getString(13)));
                ve.assignCommentAcademy(fromDbCh(rs.getString(14)));
                ve.assignAddPerson(fromDbCh(rs.getString(15)));
                tmpDate = rs.getTimestamp(16); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignModiPerson(fromDbCh(rs.getString(17)));
                tmpDate = rs.getTimestamp(18); if (tmpDate != null) { ve.assignModiTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignApplyRecruitment(rs.getInt(19));
                ve.assignManagerFlag(rs.getInt(20));
                ve.assignTeaFlag(rs.getInt(21));
                ve.assignCheckFlag(fromDbCh(rs.getString(22)));
                ve.assignCommenttw(fromDbCh(rs.getString(23)));
                ve.assignClubqq(fromDbCh(rs.getString(24)));
                ve.assignClubeMail(fromDbCh(rs.getString(25)));
                ve.assignClubPubAccount(fromDbCh(rs.getString(26)));
                ve.assignClubTimeSetup(fromDbCh(rs.getString(27)));
                tmpDate = rs.getTimestamp(28); if (tmpDate != null) { ve.assignClubTimeCheck(new java.util.Date(tmpDate.getTime())); }
                ve.assignAddPersonName(fromDbCh(rs.getString(29)));
                ve.assignTeacherModifyFlag(rs.getInt(30));
                ve.assignAddFileList(fromDbCh(rs.getString(31)));
                tmpDate = rs.getTimestamp(32); if (tmpDate != null) { ve.assignRecruitmentStart(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(33); if (tmpDate != null) { ve.assignRecruitmentStop(new java.util.Date(tmpDate.getTime())); }
                ve.assignRecruitmentCheckflag(rs.getInt(34));
                ve.assignIscancle(rs.getInt(35));
                ve.assignCancleReason(fromDbCh(rs.getString(36)));
                ve.assignCancleCheckFlag(rs.getInt(37));
                ve.assignCancleCommentXy(fromDbCh(rs.getString(38)));
                ve.assignCancleCommentTw(fromDbCh(rs.getString(39)));
                ve.assignCity(fromDbCh(rs.getString(40)));
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
    public Club[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (Club[])vrs.toArray(new Club[vrs.size()]);
    }
    public Club[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (Club[])vrs.toArray(new Club[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (clubname,clubcode,clubid,clubtype,tenet,clubprofile,academy,teacher,chairman,sponsor,feasibility,commenttea,commentacademy,addperson,addtime,modiperson,moditime,applyrecruitment,managerflag,teaflag,checkflag,commenttw,clubqq,clubemail,clubpubaccount,clubtimesetup,clubtimecheck,addpersonname,teachermodifyflag,addfilelist,recruitmentstart,recruitmentstop,recruitmentcheckflag,iscancle,canclereason,canclecheckflag,canclecommentxy,canclecommenttw,city) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        SqlTool applyIdLists = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "applyidlists", "id");
        SqlTool menberIdLists = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "menberidlists", "id");
        SqlTool memberNames = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "membernames", "id");
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(clubName));
            pstmt.setString(2, toDbCh(clubCode));
            pstmt.setString(3, toDbCh(clubId));
            pstmt.setString(4, toDbCh(clubType));
            pstmt.setString(5, toDbCh(tenet));
            pstmt.setString(6, toDbCh(clubProfile));
            pstmt.setString(7, toDbCh(academy));
            pstmt.setString(8, toDbCh(teacher));
            pstmt.setString(9, toDbCh(chairman));
            pstmt.setString(10, toDbCh(sponsor));
            pstmt.setString(11, toDbCh(feasibility));
            pstmt.setString(12, toDbCh(commentTea));
            pstmt.setString(13, toDbCh(commentAcademy));
            pstmt.setString(14, toDbCh(addPerson));
            pstmt.setTimestamp(15, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(16, toDbCh(modiPerson));
            pstmt.setTimestamp(17, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setInt(18, applyRecruitment);
            pstmt.setInt(19, managerFlag);
            pstmt.setInt(20, teaFlag);
            pstmt.setString(21, toDbCh(checkFlag));
            pstmt.setString(22, toDbCh(commenttw));
            pstmt.setString(23, toDbCh(clubqq));
            pstmt.setString(24, toDbCh(clubeMail));
            pstmt.setString(25, toDbCh(clubPubAccount));
            pstmt.setString(26, toDbCh(clubTimeSetup));
            pstmt.setTimestamp(27, new java.sql.Timestamp(clubTimeCheck.getTime()));
            pstmt.setString(28, toDbCh(addPersonName));
            pstmt.setInt(29, teacherModifyFlag);
            pstmt.setString(30, toDbCh(addFileList));
            pstmt.setTimestamp(31, new java.sql.Timestamp(recruitmentStart.getTime()));
            pstmt.setTimestamp(32, new java.sql.Timestamp(recruitmentStop.getTime()));
            pstmt.setInt(33, recruitmentCheckflag);
            pstmt.setInt(34, iscancle);
            pstmt.setString(35, toDbCh(cancleReason));
            pstmt.setInt(36, cancleCheckFlag);
            pstmt.setString(37, toDbCh(cancleCommentXy));
            pstmt.setString(38, toDbCh(cancleCommentTw));
            pstmt.setString(39, toDbCh(city));
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
        applyIdLists.setBlob("jdbc/ds", getApplyIdLists(), id);
        menberIdLists.setBlob("jdbc/ds", getMenberIdLists(), id);
        memberNames.setBlob("jdbc/ds", getMemberNames(), id);
        log.debug("insert(" + getDBNAME() + "):" + iResult);
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.Club");
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,clubname,clubcode,clubid,clubtype,tenet,clubprofile,academy,teacher,chairman,sponsor,feasibility,commenttea,commentacademy,addperson,addtime,modiperson,moditime,applyrecruitment,managerflag,teaflag,checkflag,commenttw,clubqq,clubemail,clubpubaccount,clubtimesetup,clubtimecheck,addpersonname,teachermodifyflag,addfilelist,recruitmentstart,recruitmentstop,recruitmentcheckflag,iscancle,canclereason,canclecheckflag,canclecommentxy,canclecommenttw,city) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        SqlTool applyIdLists = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "applyidlists", "id");
        SqlTool menberIdLists = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "menberidlists", "id");
        SqlTool memberNames = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "membernames", "id");
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(clubName));
            pstmt.setString(3, toDbCh(clubCode));
            pstmt.setString(4, toDbCh(clubId));
            pstmt.setString(5, toDbCh(clubType));
            pstmt.setString(6, toDbCh(tenet));
            pstmt.setString(7, toDbCh(clubProfile));
            pstmt.setString(8, toDbCh(academy));
            pstmt.setString(9, toDbCh(teacher));
            pstmt.setString(10, toDbCh(chairman));
            pstmt.setString(11, toDbCh(sponsor));
            pstmt.setString(12, toDbCh(feasibility));
            pstmt.setString(13, toDbCh(commentTea));
            pstmt.setString(14, toDbCh(commentAcademy));
            pstmt.setString(15, toDbCh(addPerson));
            pstmt.setTimestamp(16, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(17, toDbCh(modiPerson));
            pstmt.setTimestamp(18, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setInt(19, applyRecruitment);
            pstmt.setInt(20, managerFlag);
            pstmt.setInt(21, teaFlag);
            pstmt.setString(22, toDbCh(checkFlag));
            pstmt.setString(23, toDbCh(commenttw));
            pstmt.setString(24, toDbCh(clubqq));
            pstmt.setString(25, toDbCh(clubeMail));
            pstmt.setString(26, toDbCh(clubPubAccount));
            pstmt.setString(27, toDbCh(clubTimeSetup));
            pstmt.setTimestamp(28, new java.sql.Timestamp(clubTimeCheck.getTime()));
            pstmt.setString(29, toDbCh(addPersonName));
            pstmt.setInt(30, teacherModifyFlag);
            pstmt.setString(31, toDbCh(addFileList));
            pstmt.setTimestamp(32, new java.sql.Timestamp(recruitmentStart.getTime()));
            pstmt.setTimestamp(33, new java.sql.Timestamp(recruitmentStop.getTime()));
            pstmt.setInt(34, recruitmentCheckflag);
            pstmt.setInt(35, iscancle);
            pstmt.setString(36, toDbCh(cancleReason));
            pstmt.setInt(37, cancleCheckFlag);
            pstmt.setString(38, toDbCh(cancleCommentXy));
            pstmt.setString(39, toDbCh(cancleCommentTw));
            pstmt.setString(40, toDbCh(city));
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
        applyIdLists.setBlob("jdbc/ds", getApplyIdLists(), id);
        menberIdLists.setBlob("jdbc/ds", getMenberIdLists(), id);
        memberNames.setBlob("jdbc/ds", getMemberNames(), id);
        log.debug("insertByKey(" + getDBNAME() + "):" + iResult);
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.Club");
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
            Club item = (Club)it.next();
            Club v = new Club(dbname);
            v.setNoChangeList(noChangeList);
            v.clone(item);
            v.setApplyIdLists(item.getApplyIdLists());
            v.setMenberIdLists(item.getMenberIdLists());
            v.setMemberNames(item.getMemberNames());
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
                if (modifiedFields.contains("ClubName")) { pstmt.setString(pi ++, toDbCh(clubName)); }
                if (modifiedFields.contains("ClubCode")) { pstmt.setString(pi ++, toDbCh(clubCode)); }
                if (modifiedFields.contains("ClubId")) { pstmt.setString(pi ++, toDbCh(clubId)); }
                if (modifiedFields.contains("ClubType")) { pstmt.setString(pi ++, toDbCh(clubType)); }
                if (modifiedFields.contains("Tenet")) { pstmt.setString(pi ++, toDbCh(tenet)); }
                if (modifiedFields.contains("ClubProfile")) { pstmt.setString(pi ++, toDbCh(clubProfile)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Teacher")) { pstmt.setString(pi ++, toDbCh(teacher)); }
                if (modifiedFields.contains("Chairman")) { pstmt.setString(pi ++, toDbCh(chairman)); }
                if (modifiedFields.contains("Sponsor")) { pstmt.setString(pi ++, toDbCh(sponsor)); }
                if (modifiedFields.contains("Feasibility")) { pstmt.setString(pi ++, toDbCh(feasibility)); }
                if (modifiedFields.contains("CommentTea")) { pstmt.setString(pi ++, toDbCh(commentTea)); }
                if (modifiedFields.contains("CommentAcademy")) { pstmt.setString(pi ++, toDbCh(commentAcademy)); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("ApplyRecruitment")) { pstmt.setInt(pi ++, applyRecruitment); }
                if (modifiedFields.contains("ManagerFlag")) { pstmt.setInt(pi ++, managerFlag); }
                if (modifiedFields.contains("TeaFlag")) { pstmt.setInt(pi ++, teaFlag); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setString(pi ++, toDbCh(checkFlag)); }
                if (modifiedFields.contains("Commenttw")) { pstmt.setString(pi ++, toDbCh(commenttw)); }
                if (modifiedFields.contains("Clubqq")) { pstmt.setString(pi ++, toDbCh(clubqq)); }
                if (modifiedFields.contains("ClubeMail")) { pstmt.setString(pi ++, toDbCh(clubeMail)); }
                if (modifiedFields.contains("ClubPubAccount")) { pstmt.setString(pi ++, toDbCh(clubPubAccount)); }
                if (modifiedFields.contains("ClubTimeSetup")) { pstmt.setString(pi ++, toDbCh(clubTimeSetup)); }
                if (modifiedFields.contains("ClubTimeCheck")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(clubTimeCheck.getTime())); }
                if (modifiedFields.contains("AddPersonName")) { pstmt.setString(pi ++, toDbCh(addPersonName)); }
                if (modifiedFields.contains("TeacherModifyFlag")) { pstmt.setInt(pi ++, teacherModifyFlag); }
                if (modifiedFields.contains("AddFileList")) { pstmt.setString(pi ++, toDbCh(addFileList)); }
                if (modifiedFields.contains("RecruitmentStart")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(recruitmentStart.getTime())); }
                if (modifiedFields.contains("RecruitmentStop")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(recruitmentStop.getTime())); }
                if (modifiedFields.contains("RecruitmentCheckflag")) { pstmt.setInt(pi ++, recruitmentCheckflag); }
                if (modifiedFields.contains("Iscancle")) { pstmt.setInt(pi ++, iscancle); }
                if (modifiedFields.contains("CancleReason")) { pstmt.setString(pi ++, toDbCh(cancleReason)); }
                if (modifiedFields.contains("CancleCheckFlag")) { pstmt.setInt(pi ++, cancleCheckFlag); }
                if (modifiedFields.contains("CancleCommentXy")) { pstmt.setString(pi ++, toDbCh(cancleCommentXy)); }
                if (modifiedFields.contains("CancleCommentTw")) { pstmt.setString(pi ++, toDbCh(cancleCommentTw)); }
                if (modifiedFields.contains("City")) { pstmt.setString(pi ++, toDbCh(city)); }
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
        if (modifiedFields.contains("ApplyIdLists")) {
            SqlTool applyIdLists = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "applyidlists", "id");
            applyIdLists.setBlob("jdbc/ds", getApplyIdLists(), id);
        }
        if (modifiedFields.contains("MenberIdLists")) {
            SqlTool menberIdLists = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "menberidlists", "id");
            menberIdLists.setBlob("jdbc/ds", getMenberIdLists(), id);
        }
        if (modifiedFields.contains("MemberNames")) {
            SqlTool memberNames = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "membernames", "id");
            memberNames.setBlob("jdbc/ds", getMemberNames(), id);
        }
        log.debug("update(" + getDBNAME() + "):" + Tool.join(",", updateFields) + ":" + iResult);
        if (refreshFlag) {
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.Club");
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
                if (modifiedFields.contains("ClubName")) { pstmt.setString(pi ++, toDbCh(clubName)); }
                if (modifiedFields.contains("ClubCode")) { pstmt.setString(pi ++, toDbCh(clubCode)); }
                if (modifiedFields.contains("ClubId")) { pstmt.setString(pi ++, toDbCh(clubId)); }
                if (modifiedFields.contains("ClubType")) { pstmt.setString(pi ++, toDbCh(clubType)); }
                if (modifiedFields.contains("Tenet")) { pstmt.setString(pi ++, toDbCh(tenet)); }
                if (modifiedFields.contains("ClubProfile")) { pstmt.setString(pi ++, toDbCh(clubProfile)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Teacher")) { pstmt.setString(pi ++, toDbCh(teacher)); }
                if (modifiedFields.contains("Chairman")) { pstmt.setString(pi ++, toDbCh(chairman)); }
                if (modifiedFields.contains("Sponsor")) { pstmt.setString(pi ++, toDbCh(sponsor)); }
                if (modifiedFields.contains("Feasibility")) { pstmt.setString(pi ++, toDbCh(feasibility)); }
                if (modifiedFields.contains("CommentTea")) { pstmt.setString(pi ++, toDbCh(commentTea)); }
                if (modifiedFields.contains("CommentAcademy")) { pstmt.setString(pi ++, toDbCh(commentAcademy)); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("ApplyRecruitment")) { pstmt.setInt(pi ++, applyRecruitment); }
                if (modifiedFields.contains("ManagerFlag")) { pstmt.setInt(pi ++, managerFlag); }
                if (modifiedFields.contains("TeaFlag")) { pstmt.setInt(pi ++, teaFlag); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setString(pi ++, toDbCh(checkFlag)); }
                if (modifiedFields.contains("Commenttw")) { pstmt.setString(pi ++, toDbCh(commenttw)); }
                if (modifiedFields.contains("Clubqq")) { pstmt.setString(pi ++, toDbCh(clubqq)); }
                if (modifiedFields.contains("ClubeMail")) { pstmt.setString(pi ++, toDbCh(clubeMail)); }
                if (modifiedFields.contains("ClubPubAccount")) { pstmt.setString(pi ++, toDbCh(clubPubAccount)); }
                if (modifiedFields.contains("ClubTimeSetup")) { pstmt.setString(pi ++, toDbCh(clubTimeSetup)); }
                if (modifiedFields.contains("ClubTimeCheck")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(clubTimeCheck.getTime())); }
                if (modifiedFields.contains("AddPersonName")) { pstmt.setString(pi ++, toDbCh(addPersonName)); }
                if (modifiedFields.contains("TeacherModifyFlag")) { pstmt.setInt(pi ++, teacherModifyFlag); }
                if (modifiedFields.contains("AddFileList")) { pstmt.setString(pi ++, toDbCh(addFileList)); }
                if (modifiedFields.contains("RecruitmentStart")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(recruitmentStart.getTime())); }
                if (modifiedFields.contains("RecruitmentStop")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(recruitmentStop.getTime())); }
                if (modifiedFields.contains("RecruitmentCheckflag")) { pstmt.setInt(pi ++, recruitmentCheckflag); }
                if (modifiedFields.contains("Iscancle")) { pstmt.setInt(pi ++, iscancle); }
                if (modifiedFields.contains("CancleReason")) { pstmt.setString(pi ++, toDbCh(cancleReason)); }
                if (modifiedFields.contains("CancleCheckFlag")) { pstmt.setInt(pi ++, cancleCheckFlag); }
                if (modifiedFields.contains("CancleCommentXy")) { pstmt.setString(pi ++, toDbCh(cancleCommentXy)); }
                if (modifiedFields.contains("CancleCommentTw")) { pstmt.setString(pi ++, toDbCh(cancleCommentTw)); }
                if (modifiedFields.contains("City")) { pstmt.setString(pi ++, toDbCh(city)); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.Club");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.Club");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.Club");
        return iResult;
    }
    public Map toMap() {
        Map map = new HashMap();
        map.put("Id", getId() + "");
        map.put("ClubName", getClubName());
        map.put("ClubCode", getClubCode());
        map.put("ClubId", getClubId());
        map.put("ClubType", getClubType());
        map.put("Tenet", getTenet());
        map.put("ClubProfile", getClubProfile());
        map.put("Academy", getAcademy());
        map.put("Teacher", getTeacher());
        map.put("Chairman", getChairman());
        map.put("Sponsor", getSponsor());
        map.put("Feasibility", getFeasibility());
        map.put("CommentTea", getCommentTea());
        map.put("CommentAcademy", getCommentAcademy());
        map.put("AddPerson", getAddPerson());
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("ModiPerson", getModiPerson());
        map.put("ModiTime", Tool.stringOfDateTime(getModiTime()));
        map.put("ApplyRecruitment", getApplyRecruitment() + "");
        map.put("ManagerFlag", getManagerFlag() + "");
        map.put("TeaFlag", getTeaFlag() + "");
        map.put("CheckFlag", getCheckFlag());
        map.put("Commenttw", getCommenttw());
        map.put("Clubqq", getClubqq());
        map.put("ClubeMail", getClubeMail());
        map.put("ClubPubAccount", getClubPubAccount());
        map.put("ClubTimeSetup", getClubTimeSetup());
        map.put("ClubTimeCheck", Tool.stringOfDateTime(getClubTimeCheck()));
        map.put("AddPersonName", getAddPersonName());
        map.put("ApplyIdLists", StrTool.base64Encode(getApplyIdLists()));
        map.put("MenberIdLists", StrTool.base64Encode(getMenberIdLists()));
        map.put("MemberNames", StrTool.base64Encode(getMemberNames()));
        map.put("TeacherModifyFlag", getTeacherModifyFlag() + "");
        map.put("AddFileList", getAddFileList());
        map.put("RecruitmentStart", Tool.stringOfDateTime(getRecruitmentStart()));
        map.put("RecruitmentStop", Tool.stringOfDateTime(getRecruitmentStop()));
        map.put("RecruitmentCheckflag", getRecruitmentCheckflag() + "");
        map.put("Iscancle", getIscancle() + "");
        map.put("CancleReason", getCancleReason());
        map.put("CancleCheckFlag", getCancleCheckFlag() + "");
        map.put("CancleCommentXy", getCancleCommentXy());
        map.put("CancleCommentTw", getCancleCommentTw());
        map.put("City", getCity());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("ClubName:\"" + Tool.jsSpecialChars(getClubName()) + "\"");
        row.add("ClubCode:\"" + Tool.jsSpecialChars(getClubCode()) + "\"");
        row.add("ClubId:\"" + Tool.jsSpecialChars(getClubId()) + "\"");
        row.add("ClubType:\"" + Tool.jsSpecialChars(getClubType()) + "\"");
        row.add("Tenet:\"" + Tool.jsSpecialChars(getTenet()) + "\"");
        row.add("ClubProfile:\"" + Tool.jsSpecialChars(getClubProfile()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("Teacher:\"" + Tool.jsSpecialChars(getTeacher()) + "\"");
        row.add("Chairman:\"" + Tool.jsSpecialChars(getChairman()) + "\"");
        row.add("Sponsor:\"" + Tool.jsSpecialChars(getSponsor()) + "\"");
        row.add("Feasibility:\"" + Tool.jsSpecialChars(getFeasibility()) + "\"");
        row.add("CommentTea:\"" + Tool.jsSpecialChars(getCommentTea()) + "\"");
        row.add("CommentAcademy:\"" + Tool.jsSpecialChars(getCommentAcademy()) + "\"");
        row.add("AddPerson:\"" + Tool.jsSpecialChars(getAddPerson()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("ModiPerson:\"" + Tool.jsSpecialChars(getModiPerson()) + "\"");
        row.add("ModiTime:\"" + Tool.stringOfDateTime(getModiTime()) + "\"");
        row.add("ApplyRecruitment:\"" + getApplyRecruitment() + "\"");
        row.add("ManagerFlag:\"" + getManagerFlag() + "\"");
        row.add("TeaFlag:\"" + getTeaFlag() + "\"");
        row.add("CheckFlag:\"" + Tool.jsSpecialChars(getCheckFlag()) + "\"");
        row.add("Commenttw:\"" + Tool.jsSpecialChars(getCommenttw()) + "\"");
        row.add("Clubqq:\"" + Tool.jsSpecialChars(getClubqq()) + "\"");
        row.add("ClubeMail:\"" + Tool.jsSpecialChars(getClubeMail()) + "\"");
        row.add("ClubPubAccount:\"" + Tool.jsSpecialChars(getClubPubAccount()) + "\"");
        row.add("ClubTimeSetup:\"" + Tool.jsSpecialChars(getClubTimeSetup()) + "\"");
        row.add("ClubTimeCheck:\"" + Tool.stringOfDateTime(getClubTimeCheck()) + "\"");
        row.add("AddPersonName:\"" + Tool.jsSpecialChars(getAddPersonName()) + "\"");
        row.add("ApplyIdLists:\"" + StrTool.base64Encode(getApplyIdLists()) + "\"");
        row.add("MenberIdLists:\"" + StrTool.base64Encode(getMenberIdLists()) + "\"");
        row.add("MemberNames:\"" + StrTool.base64Encode(getMemberNames()) + "\"");
        row.add("TeacherModifyFlag:\"" + getTeacherModifyFlag() + "\"");
        row.add("AddFileList:\"" + Tool.jsSpecialChars(getAddFileList()) + "\"");
        row.add("RecruitmentStart:\"" + Tool.stringOfDateTime(getRecruitmentStart()) + "\"");
        row.add("RecruitmentStop:\"" + Tool.stringOfDateTime(getRecruitmentStop()) + "\"");
        row.add("RecruitmentCheckflag:\"" + getRecruitmentCheckflag() + "\"");
        row.add("Iscancle:\"" + getIscancle() + "\"");
        row.add("CancleReason:\"" + Tool.jsSpecialChars(getCancleReason()) + "\"");
        row.add("CancleCheckFlag:\"" + getCancleCheckFlag() + "\"");
        row.add("CancleCommentXy:\"" + Tool.jsSpecialChars(getCancleCommentXy()) + "\"");
        row.add("CancleCommentTw:\"" + Tool.jsSpecialChars(getCancleCommentTw()) + "\"");
        row.add("City:\"" + Tool.jsSpecialChars(getCity()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,clubname varchar2(45),clubcode varchar2(45),clubid varchar2(20),clubtype varchar2(20),tenet varchar2(100),clubprofile varchar2(2000),academy varchar2(45),teacher varchar2(45),chairman varchar2(45),sponsor varchar2(2000),feasibility varchar2(2000),commenttea varchar2(500),commentacademy varchar2(500),addperson varchar2(45),addtime date,modiperson varchar2(45),moditime date,applyrecruitment number(*,0),managerflag number(*,0),teaflag number(*,0),checkflag varchar2(20),commenttw varchar2(500),clubqq varchar2(45),clubemail varchar2(45),clubpubaccount varchar2(45),clubtimesetup varchar2(45),clubtimecheck date,addpersonname varchar2(50),applyidlists blob,menberidlists blob,membernames blob,teachermodifyflag number(*,0),addfilelist varchar2(2000),recruitmentstart date,recruitmentstop date,recruitmentcheckflag number(*,0),iscancle number(*,0),canclereason varchar2(500),canclecheckflag number(*,0),canclecommentxy varchar2(500),canclecommenttw varchar2(45),city varchar2(50))"});
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
        Club v = new Club(sourceDb, sourceTb);
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
        Club v = new Club(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(Club obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getClubName().compareTo(obj.getClubName()); if (rtn != 0) return rtn;
        rtn = getClubCode().compareTo(obj.getClubCode()); if (rtn != 0) return rtn;
        rtn = getClubId().compareTo(obj.getClubId()); if (rtn != 0) return rtn;
        rtn = getClubType().compareTo(obj.getClubType()); if (rtn != 0) return rtn;
        rtn = getTenet().compareTo(obj.getTenet()); if (rtn != 0) return rtn;
        rtn = getClubProfile().compareTo(obj.getClubProfile()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getTeacher().compareTo(obj.getTeacher()); if (rtn != 0) return rtn;
        rtn = getChairman().compareTo(obj.getChairman()); if (rtn != 0) return rtn;
        rtn = getSponsor().compareTo(obj.getSponsor()); if (rtn != 0) return rtn;
        rtn = getFeasibility().compareTo(obj.getFeasibility()); if (rtn != 0) return rtn;
        rtn = getCommentTea().compareTo(obj.getCommentTea()); if (rtn != 0) return rtn;
        rtn = getCommentAcademy().compareTo(obj.getCommentAcademy()); if (rtn != 0) return rtn;
        rtn = getAddPerson().compareTo(obj.getAddPerson()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = getModiPerson().compareTo(obj.getModiPerson()); if (rtn != 0) return rtn;
        rtn = getModiTime().compareTo(obj.getModiTime()); if (rtn != 0) return rtn;
        rtn = ("" + getApplyRecruitment()).compareTo("" + obj.getApplyRecruitment()); if (rtn != 0) return rtn;
        rtn = ("" + getManagerFlag()).compareTo("" + obj.getManagerFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getTeaFlag()).compareTo("" + obj.getTeaFlag()); if (rtn != 0) return rtn;
        rtn = getCheckFlag().compareTo(obj.getCheckFlag()); if (rtn != 0) return rtn;
        rtn = getCommenttw().compareTo(obj.getCommenttw()); if (rtn != 0) return rtn;
        rtn = getClubqq().compareTo(obj.getClubqq()); if (rtn != 0) return rtn;
        rtn = getClubeMail().compareTo(obj.getClubeMail()); if (rtn != 0) return rtn;
        rtn = getClubPubAccount().compareTo(obj.getClubPubAccount()); if (rtn != 0) return rtn;
        rtn = getClubTimeSetup().compareTo(obj.getClubTimeSetup()); if (rtn != 0) return rtn;
        rtn = getClubTimeCheck().compareTo(obj.getClubTimeCheck()); if (rtn != 0) return rtn;
        rtn = getAddPersonName().compareTo(obj.getAddPersonName()); if (rtn != 0) return rtn;
        rtn = StrTool.base64Encode(getApplyIdLists()).compareTo(StrTool.base64Encode(obj.getApplyIdLists())); if (rtn != 0) return rtn;
        rtn = StrTool.base64Encode(getMenberIdLists()).compareTo(StrTool.base64Encode(obj.getMenberIdLists())); if (rtn != 0) return rtn;
        rtn = StrTool.base64Encode(getMemberNames()).compareTo(StrTool.base64Encode(obj.getMemberNames())); if (rtn != 0) return rtn;
        rtn = ("" + getTeacherModifyFlag()).compareTo("" + obj.getTeacherModifyFlag()); if (rtn != 0) return rtn;
        rtn = getAddFileList().compareTo(obj.getAddFileList()); if (rtn != 0) return rtn;
        rtn = getRecruitmentStart().compareTo(obj.getRecruitmentStart()); if (rtn != 0) return rtn;
        rtn = getRecruitmentStop().compareTo(obj.getRecruitmentStop()); if (rtn != 0) return rtn;
        rtn = ("" + getRecruitmentCheckflag()).compareTo("" + obj.getRecruitmentCheckflag()); if (rtn != 0) return rtn;
        rtn = ("" + getIscancle()).compareTo("" + obj.getIscancle()); if (rtn != 0) return rtn;
        rtn = getCancleReason().compareTo(obj.getCancleReason()); if (rtn != 0) return rtn;
        rtn = ("" + getCancleCheckFlag()).compareTo("" + obj.getCancleCheckFlag()); if (rtn != 0) return rtn;
        rtn = getCancleCommentXy().compareTo(obj.getCancleCommentXy()); if (rtn != 0) return rtn;
        rtn = getCancleCommentTw().compareTo(obj.getCancleCommentTw()); if (rtn != 0) return rtn;
        rtn = getCity().compareTo(obj.getCity()); if (rtn != 0) return rtn;
        return rtn;
    }
}
