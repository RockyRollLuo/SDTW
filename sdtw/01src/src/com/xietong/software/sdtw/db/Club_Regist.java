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
@Description("社团注册信息")
public class Club_Regist implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(Club_Regist.class);
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
    public static final String DbTableName = "club_regist";
    private String TNAME = "club_regist";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","clubId","clubName","clubType","clubTimeSetup","clubAcademy","clubQQ","clubEmail","clubPubAccount","registSponsor","registTime","tenet","memberCount","memberUndergra","memberGra","menberLeague","menberParty","memberMale","memberFemale","clubManager","clubTea","registSummary","registPlan","commentAcademy","commentUnion","checkFlag","addPerson","addTime","modiPerson","modiTime","checkXy","checkTw"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","clubid","clubname","clubtype","clubtimesetup","clubacademy","clubqq","clubemail","clubpubaccount","registsponsor","registtime","tenet","membercount","memberundergra","membergra","menberleague","menberparty","membermale","memberfemale","clubmanager","clubtea","registsummary","registplan","commentacademy","commentunion","checkflag","addperson","addtime","modiperson","moditime","checkxy","checktw"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"ClubId","clubid","String"},{"ClubName","clubname","String"},{"ClubType","clubtype","String"},{"ClubTimeSetup","clubtimesetup","String"},{"ClubAcademy","clubacademy","String"},{"ClubQQ","clubqq","String"},{"ClubEmail","clubemail","String"},{"ClubPubAccount","clubpubaccount","String"},{"RegistSponsor","registsponsor","String"},{"RegistTime","registtime","java.util.Date"},{"Tenet","tenet","String"},{"MemberCount","membercount","int"},{"MemberUndergra","memberundergra","int"},{"MemberGra","membergra","int"},{"MenberLeague","menberleague","int"},{"MenberParty","menberparty","int"},{"MemberMale","membermale","int"},{"MemberFemale","memberfemale","int"},{"ClubManager","clubmanager","String"},{"ClubTea","clubtea","String"},{"RegistSummary","registsummary","String"},{"RegistPlan","registplan","String"},{"CommentAcademy","commentacademy","String"},{"CommentUnion","commentunion","String"},{"CheckFlag","checkflag","int"},{"AddPerson","addperson","String"},{"AddTime","addtime","java.util.Date"},{"ModiPerson","modiperson","String"},{"ModiTime","moditime","java.util.Date"},{"CheckXy","checkxy","int"},{"CheckTw","checktw","int"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"clubId","clubid"},{"clubName","clubname"},{"clubType","clubtype"},{"clubTimeSetup","clubtimesetup"},{"clubAcademy","clubacademy"},{"clubQQ","clubqq"},{"clubEmail","clubemail"},{"clubPubAccount","clubpubaccount"},{"registSponsor","registsponsor"},{"registTime","registtime"},{"tenet","tenet"},{"memberCount","membercount"},{"memberUndergra","memberundergra"},{"memberGra","membergra"},{"menberLeague","menberleague"},{"menberParty","menberparty"},{"memberMale","membermale"},{"memberFemale","memberfemale"},{"clubManager","clubmanager"},{"clubTea","clubtea"},{"registSummary","registsummary"},{"registPlan","registplan"},{"commentAcademy","commentacademy"},{"commentUnion","commentunion"},{"checkFlag","checkflag"},{"addPerson","addperson"},{"addTime","addtime"},{"modiPerson","modiperson"},{"modiTime","moditime"},{"checkXy","checkxy"},{"checkTw","checktw"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"REGISTTIME","ADDTIME","MODITIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 登录账号
    protected String clubId = "";
    public String getClubId() {  return SqlTool.getDbString(clubId);  }
    public String getClubId(int size) { return SqlTool.subString(getClubId(), size); }
    public void setClubId(String aClubId) { clubId = aClubId; modifiedFields.add("ClubId"); }
    public void assignClubId(String aClubId) { clubId = aClubId; }
    public void paramClubId(HttpServletRequest request) { paramClubId(request, "ClubId"); }
    public void paramClubId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubId()); if (!tmp.equals(getClubId())) { setClubId(tmp); } }
    // 社团名称
    protected String clubName = "";
    public String getClubName() {  return SqlTool.getDbString(clubName);  }
    public String getClubName(int size) { return SqlTool.subString(getClubName(), size); }
    public void setClubName(String aClubName) { clubName = aClubName; modifiedFields.add("ClubName"); }
    public void assignClubName(String aClubName) { clubName = aClubName; }
    public void paramClubName(HttpServletRequest request) { paramClubName(request, "ClubName"); }
    public void paramClubName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubName()); if (!tmp.equals(getClubName())) { setClubName(tmp); } }
    // 社团类别
    protected String clubType = "";
    public String getClubType() {  return SqlTool.getDbString(clubType);  }
    public String getClubType(int size) { return SqlTool.subString(getClubType(), size); }
    public void setClubType(String aClubType) { clubType = aClubType; modifiedFields.add("ClubType"); }
    public void assignClubType(String aClubType) { clubType = aClubType; }
    public void paramClubType(HttpServletRequest request) { paramClubType(request, "ClubType"); }
    public void paramClubType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubType()); if (!tmp.equals(getClubType())) { setClubType(tmp); } }
    // 社团成立时间
    protected String clubTimeSetup = "";
    public String getClubTimeSetup() {  return SqlTool.getDbString(clubTimeSetup);  }
    public String getClubTimeSetup(int size) { return SqlTool.subString(getClubTimeSetup(), size); }
    public void setClubTimeSetup(String aClubTimeSetup) { clubTimeSetup = aClubTimeSetup; modifiedFields.add("ClubTimeSetup"); }
    public void assignClubTimeSetup(String aClubTimeSetup) { clubTimeSetup = aClubTimeSetup; }
    public void paramClubTimeSetup(HttpServletRequest request) { paramClubTimeSetup(request, "ClubTimeSetup"); }
    public void paramClubTimeSetup(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubTimeSetup()); if (!tmp.equals(getClubTimeSetup())) { setClubTimeSetup(tmp); } }
    // 指导单位
    protected String clubAcademy = "";
    public String getClubAcademy() {  return SqlTool.getDbString(clubAcademy);  }
    public String getClubAcademy(int size) { return SqlTool.subString(getClubAcademy(), size); }
    public void setClubAcademy(String aClubAcademy) { clubAcademy = aClubAcademy; modifiedFields.add("ClubAcademy"); }
    public void assignClubAcademy(String aClubAcademy) { clubAcademy = aClubAcademy; }
    public void paramClubAcademy(HttpServletRequest request) { paramClubAcademy(request, "ClubAcademy"); }
    public void paramClubAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubAcademy()); if (!tmp.equals(getClubAcademy())) { setClubAcademy(tmp); } }
    // QQ
    protected String clubQQ = "";
    public String getClubQQ() {  return SqlTool.getDbString(clubQQ);  }
    public String getClubQQ(int size) { return SqlTool.subString(getClubQQ(), size); }
    public void setClubQQ(String aClubQQ) { clubQQ = aClubQQ; modifiedFields.add("ClubQQ"); }
    public void assignClubQQ(String aClubQQ) { clubQQ = aClubQQ; }
    public void paramClubQQ(HttpServletRequest request) { paramClubQQ(request, "ClubQQ"); }
    public void paramClubQQ(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubQQ()); if (!tmp.equals(getClubQQ())) { setClubQQ(tmp); } }
    // 邮箱
    protected String clubEmail = "";
    public String getClubEmail() {  return SqlTool.getDbString(clubEmail);  }
    public String getClubEmail(int size) { return SqlTool.subString(getClubEmail(), size); }
    public void setClubEmail(String aClubEmail) { clubEmail = aClubEmail; modifiedFields.add("ClubEmail"); }
    public void assignClubEmail(String aClubEmail) { clubEmail = aClubEmail; }
    public void paramClubEmail(HttpServletRequest request) { paramClubEmail(request, "ClubEmail"); }
    public void paramClubEmail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubEmail()); if (!tmp.equals(getClubEmail())) { setClubEmail(tmp); } }
    // 公众号
    protected String clubPubAccount = "";
    public String getClubPubAccount() {  return SqlTool.getDbString(clubPubAccount);  }
    public String getClubPubAccount(int size) { return SqlTool.subString(getClubPubAccount(), size); }
    public void setClubPubAccount(String aClubPubAccount) { clubPubAccount = aClubPubAccount; modifiedFields.add("ClubPubAccount"); }
    public void assignClubPubAccount(String aClubPubAccount) { clubPubAccount = aClubPubAccount; }
    public void paramClubPubAccount(HttpServletRequest request) { paramClubPubAccount(request, "ClubPubAccount"); }
    public void paramClubPubAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubPubAccount()); if (!tmp.equals(getClubPubAccount())) { setClubPubAccount(tmp); } }
    // 注册联系人
    protected String registSponsor = "";
    public String getRegistSponsor() {  return SqlTool.getDbString(registSponsor);  }
    public String getRegistSponsor(int size) { return SqlTool.subString(getRegistSponsor(), size); }
    public void setRegistSponsor(String aRegistSponsor) { registSponsor = aRegistSponsor; modifiedFields.add("RegistSponsor"); }
    public void assignRegistSponsor(String aRegistSponsor) { registSponsor = aRegistSponsor; }
    public void paramRegistSponsor(HttpServletRequest request) { paramRegistSponsor(request, "RegistSponsor"); }
    public void paramRegistSponsor(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRegistSponsor()); if (!tmp.equals(getRegistSponsor())) { setRegistSponsor(tmp); } }
    // 本期注册时间
    protected java.util.Date registTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getRegistTime() { return registTime; }
    public void setRegistTime(java.util.Date aRegistTime) { registTime = aRegistTime; modifiedFields.add("RegistTime"); }
    public void assignRegistTime(java.util.Date aRegistTime) { registTime = aRegistTime; }
    public void paramRegistTime(HttpServletRequest request) { paramRegistTime(request, "RegistTime"); }
    public void paramRegistTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getRegistTime()); if (tmp.compareTo(getRegistTime()) != 0) { setRegistTime(tmp); } }
    // 社团宗旨
    protected String tenet = "";
    public String getTenet() {  return SqlTool.getDbString(tenet);  }
    public String getTenet(int size) { return SqlTool.subString(getTenet(), size); }
    public void setTenet(String aTenet) { tenet = aTenet; modifiedFields.add("Tenet"); }
    public void assignTenet(String aTenet) { tenet = aTenet; }
    public void paramTenet(HttpServletRequest request) { paramTenet(request, "Tenet"); }
    public void paramTenet(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTenet()); if (!tmp.equals(getTenet())) { setTenet(tmp); } }
    // 现有人数
    protected int memberCount = -1;
    public int getMemberCount() { return memberCount; }
    public void setMemberCount(int aMemberCount) { memberCount = aMemberCount; modifiedFields.add("MemberCount"); }
    public void assignMemberCount(int aMemberCount) { memberCount = aMemberCount; }
    public void paramMemberCount(HttpServletRequest request) { paramMemberCount(request, "MemberCount"); }
    public void paramMemberCount(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getMemberCount()); if (tmp != getMemberCount()) { setMemberCount(tmp); } }
    // 本科人数
    protected int memberUndergra = -1;
    public int getMemberUndergra() { return memberUndergra; }
    public void setMemberUndergra(int aMemberUndergra) { memberUndergra = aMemberUndergra; modifiedFields.add("MemberUndergra"); }
    public void assignMemberUndergra(int aMemberUndergra) { memberUndergra = aMemberUndergra; }
    public void paramMemberUndergra(HttpServletRequest request) { paramMemberUndergra(request, "MemberUndergra"); }
    public void paramMemberUndergra(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getMemberUndergra()); if (tmp != getMemberUndergra()) { setMemberUndergra(tmp); } }
    // 本科生人数
    protected int memberGra = -1;
    public int getMemberGra() { return memberGra; }
    public void setMemberGra(int aMemberGra) { memberGra = aMemberGra; modifiedFields.add("MemberGra"); }
    public void assignMemberGra(int aMemberGra) { memberGra = aMemberGra; }
    public void paramMemberGra(HttpServletRequest request) { paramMemberGra(request, "MemberGra"); }
    public void paramMemberGra(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getMemberGra()); if (tmp != getMemberGra()) { setMemberGra(tmp); } }
    // 团员人数
    protected int menberLeague = -1;
    public int getMenberLeague() { return menberLeague; }
    public void setMenberLeague(int aMenberLeague) { menberLeague = aMenberLeague; modifiedFields.add("MenberLeague"); }
    public void assignMenberLeague(int aMenberLeague) { menberLeague = aMenberLeague; }
    public void paramMenberLeague(HttpServletRequest request) { paramMenberLeague(request, "MenberLeague"); }
    public void paramMenberLeague(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getMenberLeague()); if (tmp != getMenberLeague()) { setMenberLeague(tmp); } }
    // 党员人数
    protected int menberParty = -1;
    public int getMenberParty() { return menberParty; }
    public void setMenberParty(int aMenberParty) { menberParty = aMenberParty; modifiedFields.add("MenberParty"); }
    public void assignMenberParty(int aMenberParty) { menberParty = aMenberParty; }
    public void paramMenberParty(HttpServletRequest request) { paramMenberParty(request, "MenberParty"); }
    public void paramMenberParty(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getMenberParty()); if (tmp != getMenberParty()) { setMenberParty(tmp); } }
    // 男生人数
    protected int memberMale = -1;
    public int getMemberMale() { return memberMale; }
    public void setMemberMale(int aMemberMale) { memberMale = aMemberMale; modifiedFields.add("MemberMale"); }
    public void assignMemberMale(int aMemberMale) { memberMale = aMemberMale; }
    public void paramMemberMale(HttpServletRequest request) { paramMemberMale(request, "MemberMale"); }
    public void paramMemberMale(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getMemberMale()); if (tmp != getMemberMale()) { setMemberMale(tmp); } }
    // 女生人数
    protected int memberFemale = -1;
    public int getMemberFemale() { return memberFemale; }
    public void setMemberFemale(int aMemberFemale) { memberFemale = aMemberFemale; modifiedFields.add("MemberFemale"); }
    public void assignMemberFemale(int aMemberFemale) { memberFemale = aMemberFemale; }
    public void paramMemberFemale(HttpServletRequest request) { paramMemberFemale(request, "MemberFemale"); }
    public void paramMemberFemale(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getMemberFemale()); if (tmp != getMemberFemale()) { setMemberFemale(tmp); } }
    // 社团负责人情况
    protected String clubManager = "";
    public String getClubManager() {  return SqlTool.getDbString(clubManager);  }
    public String getClubManager(int size) { return SqlTool.subString(getClubManager(), size); }
    public void setClubManager(String aClubManager) { clubManager = aClubManager; modifiedFields.add("ClubManager"); }
    public void assignClubManager(String aClubManager) { clubManager = aClubManager; }
    public void paramClubManager(HttpServletRequest request) { paramClubManager(request, "ClubManager"); }
    public void paramClubManager(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubManager()); if (!tmp.equals(getClubManager())) { setClubManager(tmp); } }
    // 社团指导教师情况
    protected String clubTea = "";
    public String getClubTea() {  return SqlTool.getDbString(clubTea);  }
    public String getClubTea(int size) { return SqlTool.subString(getClubTea(), size); }
    public void setClubTea(String aClubTea) { clubTea = aClubTea; modifiedFields.add("ClubTea"); }
    public void assignClubTea(String aClubTea) { clubTea = aClubTea; }
    public void paramClubTea(HttpServletRequest request) { paramClubTea(request, "ClubTea"); }
    public void paramClubTea(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubTea()); if (!tmp.equals(getClubTea())) { setClubTea(tmp); } }
    // 上学期工作总结（要点）
    protected String registSummary = "";
    public String getRegistSummary() {  return SqlTool.getDbString(registSummary);  }
    public String getRegistSummary(int size) { return SqlTool.subString(getRegistSummary(), size); }
    public void setRegistSummary(String aRegistSummary) { registSummary = aRegistSummary; modifiedFields.add("RegistSummary"); }
    public void assignRegistSummary(String aRegistSummary) { registSummary = aRegistSummary; }
    public void paramRegistSummary(HttpServletRequest request) { paramRegistSummary(request, "RegistSummary"); }
    public void paramRegistSummary(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRegistSummary()); if (!tmp.equals(getRegistSummary())) { setRegistSummary(tmp); } }
    // 本学期工作计划（要点）
    protected String registPlan = "";
    public String getRegistPlan() {  return SqlTool.getDbString(registPlan);  }
    public String getRegistPlan(int size) { return SqlTool.subString(getRegistPlan(), size); }
    public void setRegistPlan(String aRegistPlan) { registPlan = aRegistPlan; modifiedFields.add("RegistPlan"); }
    public void assignRegistPlan(String aRegistPlan) { registPlan = aRegistPlan; }
    public void paramRegistPlan(HttpServletRequest request) { paramRegistPlan(request, "RegistPlan"); }
    public void paramRegistPlan(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRegistPlan()); if (!tmp.equals(getRegistPlan())) { setRegistPlan(tmp); } }
    // 学院审核意见
    protected String commentAcademy = "";
    public String getCommentAcademy() {  return SqlTool.getDbString(commentAcademy);  }
    public String getCommentAcademy(int size) { return SqlTool.subString(getCommentAcademy(), size); }
    public void setCommentAcademy(String aCommentAcademy) { commentAcademy = aCommentAcademy; modifiedFields.add("CommentAcademy"); }
    public void assignCommentAcademy(String aCommentAcademy) { commentAcademy = aCommentAcademy; }
    public void paramCommentAcademy(HttpServletRequest request) { paramCommentAcademy(request, "CommentAcademy"); }
    public void paramCommentAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentAcademy()); if (!tmp.equals(getCommentAcademy())) { setCommentAcademy(tmp); } }
    // 学校审核意见
    protected String commentUnion = "";
    public String getCommentUnion() {  return SqlTool.getDbString(commentUnion);  }
    public String getCommentUnion(int size) { return SqlTool.subString(getCommentUnion(), size); }
    public void setCommentUnion(String aCommentUnion) { commentUnion = aCommentUnion; modifiedFields.add("CommentUnion"); }
    public void assignCommentUnion(String aCommentUnion) { commentUnion = aCommentUnion; }
    public void paramCommentUnion(HttpServletRequest request) { paramCommentUnion(request, "CommentUnion"); }
    public void paramCommentUnion(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentUnion()); if (!tmp.equals(getCommentUnion())) { setCommentUnion(tmp); } }
    // 审核状态
    protected int checkFlag = -1;
    public int getCheckFlag() { return checkFlag; }
    public void setCheckFlag(int aCheckFlag) { checkFlag = aCheckFlag; modifiedFields.add("CheckFlag"); }
    public void assignCheckFlag(int aCheckFlag) { checkFlag = aCheckFlag; }
    public void paramCheckFlag(HttpServletRequest request) { paramCheckFlag(request, "CheckFlag"); }
    public void paramCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckFlag()); if (tmp != getCheckFlag()) { setCheckFlag(tmp); } }
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
    // 学院审核人
    protected int checkXy = -1;
    public int getCheckXy() { return checkXy; }
    public void setCheckXy(int aCheckXy) { checkXy = aCheckXy; modifiedFields.add("CheckXy"); }
    public void assignCheckXy(int aCheckXy) { checkXy = aCheckXy; }
    public void paramCheckXy(HttpServletRequest request) { paramCheckXy(request, "CheckXy"); }
    public void paramCheckXy(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckXy()); if (tmp != getCheckXy()) { setCheckXy(tmp); } }
    // 团委审核人
    protected int checkTw = -1;
    public int getCheckTw() { return checkTw; }
    public void setCheckTw(int aCheckTw) { checkTw = aCheckTw; modifiedFields.add("CheckTw"); }
    public void assignCheckTw(int aCheckTw) { checkTw = aCheckTw; }
    public void paramCheckTw(HttpServletRequest request) { paramCheckTw(request, "CheckTw"); }
    public void paramCheckTw(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckTw()); if (tmp != getCheckTw()) { setCheckTw(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public Club_Regist (String db) {
        DBNAME = db;
    }
    public Club_Regist (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public Club_Regist (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public Club_Regist () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return Club_Regist类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public Club_Regist getByParameter(HttpServletRequest request) {
        Club_Regist v = new Club_Regist(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramClubId(request);
        paramClubName(request);
        paramClubType(request);
        paramClubTimeSetup(request);
        paramClubAcademy(request);
        paramClubQQ(request);
        paramClubEmail(request);
        paramClubPubAccount(request);
        paramRegistSponsor(request);
        paramRegistTime(request);
        paramTenet(request);
        paramMemberCount(request);
        paramMemberUndergra(request);
        paramMemberGra(request);
        paramMenberLeague(request);
        paramMenberParty(request);
        paramMemberMale(request);
        paramMemberFemale(request);
        paramClubManager(request);
        paramClubTea(request);
        paramRegistSummary(request);
        paramRegistPlan(request);
        paramCommentAcademy(request);
        paramCommentUnion(request);
        paramCheckFlag(request);
        paramAddPerson(request);
        paramAddTime(request);
        paramModiPerson(request);
        paramModiTime(request);
        paramCheckXy(request);
        paramCheckTw(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(Club_Regist bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("clubId")) { setClubId(bean.getClubId()); }
        if (!ncl.contains("clubName")) { setClubName(bean.getClubName()); }
        if (!ncl.contains("clubType")) { setClubType(bean.getClubType()); }
        if (!ncl.contains("clubTimeSetup")) { setClubTimeSetup(bean.getClubTimeSetup()); }
        if (!ncl.contains("clubAcademy")) { setClubAcademy(bean.getClubAcademy()); }
        if (!ncl.contains("clubQQ")) { setClubQQ(bean.getClubQQ()); }
        if (!ncl.contains("clubEmail")) { setClubEmail(bean.getClubEmail()); }
        if (!ncl.contains("clubPubAccount")) { setClubPubAccount(bean.getClubPubAccount()); }
        if (!ncl.contains("registSponsor")) { setRegistSponsor(bean.getRegistSponsor()); }
        if (!ncl.contains("registTime")) { setRegistTime(bean.getRegistTime()); }
        if (!ncl.contains("tenet")) { setTenet(bean.getTenet()); }
        if (!ncl.contains("memberCount")) { setMemberCount(bean.getMemberCount()); }
        if (!ncl.contains("memberUndergra")) { setMemberUndergra(bean.getMemberUndergra()); }
        if (!ncl.contains("memberGra")) { setMemberGra(bean.getMemberGra()); }
        if (!ncl.contains("menberLeague")) { setMenberLeague(bean.getMenberLeague()); }
        if (!ncl.contains("menberParty")) { setMenberParty(bean.getMenberParty()); }
        if (!ncl.contains("memberMale")) { setMemberMale(bean.getMemberMale()); }
        if (!ncl.contains("memberFemale")) { setMemberFemale(bean.getMemberFemale()); }
        if (!ncl.contains("clubManager")) { setClubManager(bean.getClubManager()); }
        if (!ncl.contains("clubTea")) { setClubTea(bean.getClubTea()); }
        if (!ncl.contains("registSummary")) { setRegistSummary(bean.getRegistSummary()); }
        if (!ncl.contains("registPlan")) { setRegistPlan(bean.getRegistPlan()); }
        if (!ncl.contains("commentAcademy")) { setCommentAcademy(bean.getCommentAcademy()); }
        if (!ncl.contains("commentUnion")) { setCommentUnion(bean.getCommentUnion()); }
        if (!ncl.contains("checkFlag")) { setCheckFlag(bean.getCheckFlag()); }
        if (!ncl.contains("addPerson")) { setAddPerson(bean.getAddPerson()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("modiPerson")) { setModiPerson(bean.getModiPerson()); }
        if (!ncl.contains("modiTime")) { setModiTime(bean.getModiTime()); }
        if (!ncl.contains("checkXy")) { setCheckXy(bean.getCheckXy()); }
        if (!ncl.contains("checkTw")) { setCheckTw(bean.getCheckTw()); }
    }
    public Club_Regist getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        Club_Regist[] rslt= queryByCondition(cdt);
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
     * @return Club_Regist类的实例列表。
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
                Club_Regist ve = new Club_Regist(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignClubId(fromDbCh(rs.getString(2)));
                ve.assignClubName(fromDbCh(rs.getString(3)));
                ve.assignClubType(fromDbCh(rs.getString(4)));
                ve.assignClubTimeSetup(fromDbCh(rs.getString(5)));
                ve.assignClubAcademy(fromDbCh(rs.getString(6)));
                ve.assignClubQQ(fromDbCh(rs.getString(7)));
                ve.assignClubEmail(fromDbCh(rs.getString(8)));
                ve.assignClubPubAccount(fromDbCh(rs.getString(9)));
                ve.assignRegistSponsor(fromDbCh(rs.getString(10)));
                tmpDate = rs.getTimestamp(11); if (tmpDate != null) { ve.assignRegistTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignTenet(fromDbCh(rs.getString(12)));
                ve.assignMemberCount(rs.getInt(13));
                ve.assignMemberUndergra(rs.getInt(14));
                ve.assignMemberGra(rs.getInt(15));
                ve.assignMenberLeague(rs.getInt(16));
                ve.assignMenberParty(rs.getInt(17));
                ve.assignMemberMale(rs.getInt(18));
                ve.assignMemberFemale(rs.getInt(19));
                ve.assignClubManager(fromDbCh(rs.getString(20)));
                ve.assignClubTea(fromDbCh(rs.getString(21)));
                ve.assignRegistSummary(fromDbCh(rs.getString(22)));
                ve.assignRegistPlan(fromDbCh(rs.getString(23)));
                ve.assignCommentAcademy(fromDbCh(rs.getString(24)));
                ve.assignCommentUnion(fromDbCh(rs.getString(25)));
                ve.assignCheckFlag(rs.getInt(26));
                ve.assignAddPerson(fromDbCh(rs.getString(27)));
                tmpDate = rs.getTimestamp(28); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignModiPerson(fromDbCh(rs.getString(29)));
                tmpDate = rs.getTimestamp(30); if (tmpDate != null) { ve.assignModiTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignCheckXy(rs.getInt(31));
                ve.assignCheckTw(rs.getInt(32));
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
    public Club_Regist[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (Club_Regist[])vrs.toArray(new Club_Regist[vrs.size()]);
    }
    public Club_Regist[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (Club_Regist[])vrs.toArray(new Club_Regist[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (clubid,clubname,clubtype,clubtimesetup,clubacademy,clubqq,clubemail,clubpubaccount,registsponsor,registtime,tenet,membercount,memberundergra,membergra,menberleague,menberparty,membermale,memberfemale,clubmanager,clubtea,registsummary,registplan,commentacademy,commentunion,checkflag,addperson,addtime,modiperson,moditime,checkxy,checktw) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(clubId));
            pstmt.setString(2, toDbCh(clubName));
            pstmt.setString(3, toDbCh(clubType));
            pstmt.setString(4, toDbCh(clubTimeSetup));
            pstmt.setString(5, toDbCh(clubAcademy));
            pstmt.setString(6, toDbCh(clubQQ));
            pstmt.setString(7, toDbCh(clubEmail));
            pstmt.setString(8, toDbCh(clubPubAccount));
            pstmt.setString(9, toDbCh(registSponsor));
            pstmt.setTimestamp(10, new java.sql.Timestamp(registTime.getTime()));
            pstmt.setString(11, toDbCh(tenet));
            pstmt.setInt(12, memberCount);
            pstmt.setInt(13, memberUndergra);
            pstmt.setInt(14, memberGra);
            pstmt.setInt(15, menberLeague);
            pstmt.setInt(16, menberParty);
            pstmt.setInt(17, memberMale);
            pstmt.setInt(18, memberFemale);
            pstmt.setString(19, toDbCh(clubManager));
            pstmt.setString(20, toDbCh(clubTea));
            pstmt.setString(21, toDbCh(registSummary));
            pstmt.setString(22, toDbCh(registPlan));
            pstmt.setString(23, toDbCh(commentAcademy));
            pstmt.setString(24, toDbCh(commentUnion));
            pstmt.setInt(25, checkFlag);
            pstmt.setString(26, toDbCh(addPerson));
            pstmt.setTimestamp(27, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(28, toDbCh(modiPerson));
            pstmt.setTimestamp(29, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setInt(30, checkXy);
            pstmt.setInt(31, checkTw);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,clubid,clubname,clubtype,clubtimesetup,clubacademy,clubqq,clubemail,clubpubaccount,registsponsor,registtime,tenet,membercount,memberundergra,membergra,menberleague,menberparty,membermale,memberfemale,clubmanager,clubtea,registsummary,registplan,commentacademy,commentunion,checkflag,addperson,addtime,modiperson,moditime,checkxy,checktw) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(clubId));
            pstmt.setString(3, toDbCh(clubName));
            pstmt.setString(4, toDbCh(clubType));
            pstmt.setString(5, toDbCh(clubTimeSetup));
            pstmt.setString(6, toDbCh(clubAcademy));
            pstmt.setString(7, toDbCh(clubQQ));
            pstmt.setString(8, toDbCh(clubEmail));
            pstmt.setString(9, toDbCh(clubPubAccount));
            pstmt.setString(10, toDbCh(registSponsor));
            pstmt.setTimestamp(11, new java.sql.Timestamp(registTime.getTime()));
            pstmt.setString(12, toDbCh(tenet));
            pstmt.setInt(13, memberCount);
            pstmt.setInt(14, memberUndergra);
            pstmt.setInt(15, memberGra);
            pstmt.setInt(16, menberLeague);
            pstmt.setInt(17, menberParty);
            pstmt.setInt(18, memberMale);
            pstmt.setInt(19, memberFemale);
            pstmt.setString(20, toDbCh(clubManager));
            pstmt.setString(21, toDbCh(clubTea));
            pstmt.setString(22, toDbCh(registSummary));
            pstmt.setString(23, toDbCh(registPlan));
            pstmt.setString(24, toDbCh(commentAcademy));
            pstmt.setString(25, toDbCh(commentUnion));
            pstmt.setInt(26, checkFlag);
            pstmt.setString(27, toDbCh(addPerson));
            pstmt.setTimestamp(28, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(29, toDbCh(modiPerson));
            pstmt.setTimestamp(30, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setInt(31, checkXy);
            pstmt.setInt(32, checkTw);
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
            Club_Regist item = (Club_Regist)it.next();
            Club_Regist v = new Club_Regist(dbname);
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
                if (modifiedFields.contains("ClubId")) { pstmt.setString(pi ++, toDbCh(clubId)); }
                if (modifiedFields.contains("ClubName")) { pstmt.setString(pi ++, toDbCh(clubName)); }
                if (modifiedFields.contains("ClubType")) { pstmt.setString(pi ++, toDbCh(clubType)); }
                if (modifiedFields.contains("ClubTimeSetup")) { pstmt.setString(pi ++, toDbCh(clubTimeSetup)); }
                if (modifiedFields.contains("ClubAcademy")) { pstmt.setString(pi ++, toDbCh(clubAcademy)); }
                if (modifiedFields.contains("ClubQQ")) { pstmt.setString(pi ++, toDbCh(clubQQ)); }
                if (modifiedFields.contains("ClubEmail")) { pstmt.setString(pi ++, toDbCh(clubEmail)); }
                if (modifiedFields.contains("ClubPubAccount")) { pstmt.setString(pi ++, toDbCh(clubPubAccount)); }
                if (modifiedFields.contains("RegistSponsor")) { pstmt.setString(pi ++, toDbCh(registSponsor)); }
                if (modifiedFields.contains("RegistTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(registTime.getTime())); }
                if (modifiedFields.contains("Tenet")) { pstmt.setString(pi ++, toDbCh(tenet)); }
                if (modifiedFields.contains("MemberCount")) { pstmt.setInt(pi ++, memberCount); }
                if (modifiedFields.contains("MemberUndergra")) { pstmt.setInt(pi ++, memberUndergra); }
                if (modifiedFields.contains("MemberGra")) { pstmt.setInt(pi ++, memberGra); }
                if (modifiedFields.contains("MenberLeague")) { pstmt.setInt(pi ++, menberLeague); }
                if (modifiedFields.contains("MenberParty")) { pstmt.setInt(pi ++, menberParty); }
                if (modifiedFields.contains("MemberMale")) { pstmt.setInt(pi ++, memberMale); }
                if (modifiedFields.contains("MemberFemale")) { pstmt.setInt(pi ++, memberFemale); }
                if (modifiedFields.contains("ClubManager")) { pstmt.setString(pi ++, toDbCh(clubManager)); }
                if (modifiedFields.contains("ClubTea")) { pstmt.setString(pi ++, toDbCh(clubTea)); }
                if (modifiedFields.contains("RegistSummary")) { pstmt.setString(pi ++, toDbCh(registSummary)); }
                if (modifiedFields.contains("RegistPlan")) { pstmt.setString(pi ++, toDbCh(registPlan)); }
                if (modifiedFields.contains("CommentAcademy")) { pstmt.setString(pi ++, toDbCh(commentAcademy)); }
                if (modifiedFields.contains("CommentUnion")) { pstmt.setString(pi ++, toDbCh(commentUnion)); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("CheckXy")) { pstmt.setInt(pi ++, checkXy); }
                if (modifiedFields.contains("CheckTw")) { pstmt.setInt(pi ++, checkTw); }
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
                if (modifiedFields.contains("ClubId")) { pstmt.setString(pi ++, toDbCh(clubId)); }
                if (modifiedFields.contains("ClubName")) { pstmt.setString(pi ++, toDbCh(clubName)); }
                if (modifiedFields.contains("ClubType")) { pstmt.setString(pi ++, toDbCh(clubType)); }
                if (modifiedFields.contains("ClubTimeSetup")) { pstmt.setString(pi ++, toDbCh(clubTimeSetup)); }
                if (modifiedFields.contains("ClubAcademy")) { pstmt.setString(pi ++, toDbCh(clubAcademy)); }
                if (modifiedFields.contains("ClubQQ")) { pstmt.setString(pi ++, toDbCh(clubQQ)); }
                if (modifiedFields.contains("ClubEmail")) { pstmt.setString(pi ++, toDbCh(clubEmail)); }
                if (modifiedFields.contains("ClubPubAccount")) { pstmt.setString(pi ++, toDbCh(clubPubAccount)); }
                if (modifiedFields.contains("RegistSponsor")) { pstmt.setString(pi ++, toDbCh(registSponsor)); }
                if (modifiedFields.contains("RegistTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(registTime.getTime())); }
                if (modifiedFields.contains("Tenet")) { pstmt.setString(pi ++, toDbCh(tenet)); }
                if (modifiedFields.contains("MemberCount")) { pstmt.setInt(pi ++, memberCount); }
                if (modifiedFields.contains("MemberUndergra")) { pstmt.setInt(pi ++, memberUndergra); }
                if (modifiedFields.contains("MemberGra")) { pstmt.setInt(pi ++, memberGra); }
                if (modifiedFields.contains("MenberLeague")) { pstmt.setInt(pi ++, menberLeague); }
                if (modifiedFields.contains("MenberParty")) { pstmt.setInt(pi ++, menberParty); }
                if (modifiedFields.contains("MemberMale")) { pstmt.setInt(pi ++, memberMale); }
                if (modifiedFields.contains("MemberFemale")) { pstmt.setInt(pi ++, memberFemale); }
                if (modifiedFields.contains("ClubManager")) { pstmt.setString(pi ++, toDbCh(clubManager)); }
                if (modifiedFields.contains("ClubTea")) { pstmt.setString(pi ++, toDbCh(clubTea)); }
                if (modifiedFields.contains("RegistSummary")) { pstmt.setString(pi ++, toDbCh(registSummary)); }
                if (modifiedFields.contains("RegistPlan")) { pstmt.setString(pi ++, toDbCh(registPlan)); }
                if (modifiedFields.contains("CommentAcademy")) { pstmt.setString(pi ++, toDbCh(commentAcademy)); }
                if (modifiedFields.contains("CommentUnion")) { pstmt.setString(pi ++, toDbCh(commentUnion)); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("CheckXy")) { pstmt.setInt(pi ++, checkXy); }
                if (modifiedFields.contains("CheckTw")) { pstmt.setInt(pi ++, checkTw); }
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
        map.put("ClubId", getClubId());
        map.put("ClubName", getClubName());
        map.put("ClubType", getClubType());
        map.put("ClubTimeSetup", getClubTimeSetup());
        map.put("ClubAcademy", getClubAcademy());
        map.put("ClubQQ", getClubQQ());
        map.put("ClubEmail", getClubEmail());
        map.put("ClubPubAccount", getClubPubAccount());
        map.put("RegistSponsor", getRegistSponsor());
        map.put("RegistTime", Tool.stringOfDateTime(getRegistTime()));
        map.put("Tenet", getTenet());
        map.put("MemberCount", getMemberCount() + "");
        map.put("MemberUndergra", getMemberUndergra() + "");
        map.put("MemberGra", getMemberGra() + "");
        map.put("MenberLeague", getMenberLeague() + "");
        map.put("MenberParty", getMenberParty() + "");
        map.put("MemberMale", getMemberMale() + "");
        map.put("MemberFemale", getMemberFemale() + "");
        map.put("ClubManager", getClubManager());
        map.put("ClubTea", getClubTea());
        map.put("RegistSummary", getRegistSummary());
        map.put("RegistPlan", getRegistPlan());
        map.put("CommentAcademy", getCommentAcademy());
        map.put("CommentUnion", getCommentUnion());
        map.put("CheckFlag", getCheckFlag() + "");
        map.put("AddPerson", getAddPerson());
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("ModiPerson", getModiPerson());
        map.put("ModiTime", Tool.stringOfDateTime(getModiTime()));
        map.put("CheckXy", getCheckXy() + "");
        map.put("CheckTw", getCheckTw() + "");
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("ClubId:\"" + Tool.jsSpecialChars(getClubId()) + "\"");
        row.add("ClubName:\"" + Tool.jsSpecialChars(getClubName()) + "\"");
        row.add("ClubType:\"" + Tool.jsSpecialChars(getClubType()) + "\"");
        row.add("ClubTimeSetup:\"" + Tool.jsSpecialChars(getClubTimeSetup()) + "\"");
        row.add("ClubAcademy:\"" + Tool.jsSpecialChars(getClubAcademy()) + "\"");
        row.add("ClubQQ:\"" + Tool.jsSpecialChars(getClubQQ()) + "\"");
        row.add("ClubEmail:\"" + Tool.jsSpecialChars(getClubEmail()) + "\"");
        row.add("ClubPubAccount:\"" + Tool.jsSpecialChars(getClubPubAccount()) + "\"");
        row.add("RegistSponsor:\"" + Tool.jsSpecialChars(getRegistSponsor()) + "\"");
        row.add("RegistTime:\"" + Tool.stringOfDateTime(getRegistTime()) + "\"");
        row.add("Tenet:\"" + Tool.jsSpecialChars(getTenet()) + "\"");
        row.add("MemberCount:\"" + getMemberCount() + "\"");
        row.add("MemberUndergra:\"" + getMemberUndergra() + "\"");
        row.add("MemberGra:\"" + getMemberGra() + "\"");
        row.add("MenberLeague:\"" + getMenberLeague() + "\"");
        row.add("MenberParty:\"" + getMenberParty() + "\"");
        row.add("MemberMale:\"" + getMemberMale() + "\"");
        row.add("MemberFemale:\"" + getMemberFemale() + "\"");
        row.add("ClubManager:\"" + Tool.jsSpecialChars(getClubManager()) + "\"");
        row.add("ClubTea:\"" + Tool.jsSpecialChars(getClubTea()) + "\"");
        row.add("RegistSummary:\"" + Tool.jsSpecialChars(getRegistSummary()) + "\"");
        row.add("RegistPlan:\"" + Tool.jsSpecialChars(getRegistPlan()) + "\"");
        row.add("CommentAcademy:\"" + Tool.jsSpecialChars(getCommentAcademy()) + "\"");
        row.add("CommentUnion:\"" + Tool.jsSpecialChars(getCommentUnion()) + "\"");
        row.add("CheckFlag:\"" + getCheckFlag() + "\"");
        row.add("AddPerson:\"" + Tool.jsSpecialChars(getAddPerson()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("ModiPerson:\"" + Tool.jsSpecialChars(getModiPerson()) + "\"");
        row.add("ModiTime:\"" + Tool.stringOfDateTime(getModiTime()) + "\"");
        row.add("CheckXy:\"" + getCheckXy() + "\"");
        row.add("CheckTw:\"" + getCheckTw() + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,clubid varchar2(45),clubname varchar2(45),clubtype varchar2(45),clubtimesetup varchar2(45),clubacademy varchar2(45),clubqq varchar2(45),clubemail varchar2(45),clubpubaccount varchar2(45),registsponsor varchar2(45),registtime date,tenet varchar2(45),membercount number(*,0),memberundergra number(*,0),membergra number(*,0),menberleague number(*,0),menberparty number(*,0),membermale number(*,0),memberfemale number(*,0),clubmanager varchar2(500),clubtea varchar2(500),registsummary varchar2(1000),registplan varchar2(1000),commentacademy varchar2(500),commentunion varchar2(500),checkflag number(*,0),addperson varchar2(50),addtime date,modiperson varchar2(50),moditime date,checkxy number(*,0),checktw number(*,0))"});
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
        Club_Regist v = new Club_Regist(sourceDb, sourceTb);
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
        Club_Regist v = new Club_Regist(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(Club_Regist obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getClubId().compareTo(obj.getClubId()); if (rtn != 0) return rtn;
        rtn = getClubName().compareTo(obj.getClubName()); if (rtn != 0) return rtn;
        rtn = getClubType().compareTo(obj.getClubType()); if (rtn != 0) return rtn;
        rtn = getClubTimeSetup().compareTo(obj.getClubTimeSetup()); if (rtn != 0) return rtn;
        rtn = getClubAcademy().compareTo(obj.getClubAcademy()); if (rtn != 0) return rtn;
        rtn = getClubQQ().compareTo(obj.getClubQQ()); if (rtn != 0) return rtn;
        rtn = getClubEmail().compareTo(obj.getClubEmail()); if (rtn != 0) return rtn;
        rtn = getClubPubAccount().compareTo(obj.getClubPubAccount()); if (rtn != 0) return rtn;
        rtn = getRegistSponsor().compareTo(obj.getRegistSponsor()); if (rtn != 0) return rtn;
        rtn = getRegistTime().compareTo(obj.getRegistTime()); if (rtn != 0) return rtn;
        rtn = getTenet().compareTo(obj.getTenet()); if (rtn != 0) return rtn;
        rtn = ("" + getMemberCount()).compareTo("" + obj.getMemberCount()); if (rtn != 0) return rtn;
        rtn = ("" + getMemberUndergra()).compareTo("" + obj.getMemberUndergra()); if (rtn != 0) return rtn;
        rtn = ("" + getMemberGra()).compareTo("" + obj.getMemberGra()); if (rtn != 0) return rtn;
        rtn = ("" + getMenberLeague()).compareTo("" + obj.getMenberLeague()); if (rtn != 0) return rtn;
        rtn = ("" + getMenberParty()).compareTo("" + obj.getMenberParty()); if (rtn != 0) return rtn;
        rtn = ("" + getMemberMale()).compareTo("" + obj.getMemberMale()); if (rtn != 0) return rtn;
        rtn = ("" + getMemberFemale()).compareTo("" + obj.getMemberFemale()); if (rtn != 0) return rtn;
        rtn = getClubManager().compareTo(obj.getClubManager()); if (rtn != 0) return rtn;
        rtn = getClubTea().compareTo(obj.getClubTea()); if (rtn != 0) return rtn;
        rtn = getRegistSummary().compareTo(obj.getRegistSummary()); if (rtn != 0) return rtn;
        rtn = getRegistPlan().compareTo(obj.getRegistPlan()); if (rtn != 0) return rtn;
        rtn = getCommentAcademy().compareTo(obj.getCommentAcademy()); if (rtn != 0) return rtn;
        rtn = getCommentUnion().compareTo(obj.getCommentUnion()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckFlag()).compareTo("" + obj.getCheckFlag()); if (rtn != 0) return rtn;
        rtn = getAddPerson().compareTo(obj.getAddPerson()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = getModiPerson().compareTo(obj.getModiPerson()); if (rtn != 0) return rtn;
        rtn = getModiTime().compareTo(obj.getModiTime()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckXy()).compareTo("" + obj.getCheckXy()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckTw()).compareTo("" + obj.getCheckTw()); if (rtn != 0) return rtn;
        return rtn;
    }
}
