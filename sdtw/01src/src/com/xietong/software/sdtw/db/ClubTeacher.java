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
@Description("社团指导教师")
public class ClubTeacher implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(ClubTeacher.class);
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
    public static final String DbTableName = "club_teacher";
    private String TNAME = "club_teacher";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","clubName","clubCode","teaName","teaSex","teaAge","teaNation","teaPolitics","teaBirthplace","teaDuty","teaAcademy","teaTel","teaPhone","teaEmail","teaAcademic","commentAcatw","commentClubunion","commentTw","addPerson","addTime","modiPerson","modiTime","startDate","stopDate","generation","applyDate","checkFlag","commentXy"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","clubname","clubcode","teaname","teasex","teaage","teanation","teapolitics","teabirthplace","teaduty","teaacademy","teatel","teaphone","teaemail","teaacademic","commentacatw","commentclubunion","commenttw","addperson","addtime","modiperson","moditime","startdate","stopdate","generation","applydate","checkflag","commentxy"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"ClubName","clubname","String"},{"ClubCode","clubcode","String"},{"TeaName","teaname","String"},{"TeaSex","teasex","String"},{"TeaAge","teaage","String"},{"TeaNation","teanation","String"},{"TeaPolitics","teapolitics","String"},{"TeaBirthplace","teabirthplace","String"},{"TeaDuty","teaduty","String"},{"TeaAcademy","teaacademy","String"},{"TeaTel","teatel","String"},{"TeaPhone","teaphone","String"},{"TeaEmail","teaemail","String"},{"TeaAcademic","teaacademic","String"},{"CommentAcatw","commentacatw","String"},{"CommentClubunion","commentclubunion","String"},{"CommentTw","commenttw","String"},{"AddPerson","addperson","String"},{"AddTime","addtime","java.util.Date"},{"ModiPerson","modiperson","String"},{"ModiTime","moditime","java.util.Date"},{"StartDate","startdate","java.util.Date"},{"StopDate","stopdate","java.util.Date"},{"Generation","generation","int"},{"ApplyDate","applydate","java.util.Date"},{"CheckFlag","checkflag","int"},{"CommentXy","commentxy","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"clubName","clubname"},{"clubCode","clubcode"},{"teaName","teaname"},{"teaSex","teasex"},{"teaAge","teaage"},{"teaNation","teanation"},{"teaPolitics","teapolitics"},{"teaBirthplace","teabirthplace"},{"teaDuty","teaduty"},{"teaAcademy","teaacademy"},{"teaTel","teatel"},{"teaPhone","teaphone"},{"teaEmail","teaemail"},{"teaAcademic","teaacademic"},{"commentAcatw","commentacatw"},{"commentClubunion","commentclubunion"},{"commentTw","commenttw"},{"addPerson","addperson"},{"addTime","addtime"},{"modiPerson","modiperson"},{"modiTime","moditime"},{"startDate","startdate"},{"stopDate","stopdate"},{"generation","generation"},{"applyDate","applydate"},{"checkFlag","checkflag"},{"commentXy","commentxy"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME","MODITIME","STARTDATE","STOPDATE","APPLYDATE"};
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
    public void setClubName(String aClubName) { clubName = aClubName; modifiedFields.add("ClubName"); }
    public void assignClubName(String aClubName) { clubName = aClubName; }
    public void paramClubName(HttpServletRequest request) { paramClubName(request, "ClubName"); }
    public void paramClubName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubName()); if (!tmp.equals(getClubName())) { setClubName(tmp); } }
    // 社团code
    protected String clubCode = "";
    public String getClubCode() {  return SqlTool.getDbString(clubCode);  }
    public String getClubCode(int size) { return SqlTool.subString(getClubCode(), size); }
    public void setClubCode(String aClubCode) { clubCode = aClubCode; modifiedFields.add("ClubCode"); }
    public void assignClubCode(String aClubCode) { clubCode = aClubCode; }
    public void paramClubCode(HttpServletRequest request) { paramClubCode(request, "ClubCode"); }
    public void paramClubCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubCode()); if (!tmp.equals(getClubCode())) { setClubCode(tmp); } }
    // 姓名
    protected String teaName = "";
    public String getTeaName() {  return SqlTool.getDbString(teaName);  }
    public String getTeaName(int size) { return SqlTool.subString(getTeaName(), size); }
    public void setTeaName(String aTeaName) { teaName = aTeaName; modifiedFields.add("TeaName"); }
    public void assignTeaName(String aTeaName) { teaName = aTeaName; }
    public void paramTeaName(HttpServletRequest request) { paramTeaName(request, "TeaName"); }
    public void paramTeaName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeaName()); if (!tmp.equals(getTeaName())) { setTeaName(tmp); } }
    // 性别
    protected String teaSex = "";
    public String getTeaSex() {  return SqlTool.getDbString(teaSex);  }
    public String getTeaSex(int size) { return SqlTool.subString(getTeaSex(), size); }
    public void setTeaSex(String aTeaSex) { teaSex = aTeaSex; modifiedFields.add("TeaSex"); }
    public void assignTeaSex(String aTeaSex) { teaSex = aTeaSex; }
    public void paramTeaSex(HttpServletRequest request) { paramTeaSex(request, "TeaSex"); }
    public void paramTeaSex(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeaSex()); if (!tmp.equals(getTeaSex())) { setTeaSex(tmp); } }
    // 年龄
    protected String teaAge = "";
    public String getTeaAge() {  return SqlTool.getDbString(teaAge);  }
    public String getTeaAge(int size) { return SqlTool.subString(getTeaAge(), size); }
    public void setTeaAge(String aTeaAge) { teaAge = aTeaAge; modifiedFields.add("TeaAge"); }
    public void assignTeaAge(String aTeaAge) { teaAge = aTeaAge; }
    public void paramTeaAge(HttpServletRequest request) { paramTeaAge(request, "TeaAge"); }
    public void paramTeaAge(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeaAge()); if (!tmp.equals(getTeaAge())) { setTeaAge(tmp); } }
    // 民族
    protected String teaNation = "";
    public String getTeaNation() {  return SqlTool.getDbString(teaNation);  }
    public String getTeaNation(int size) { return SqlTool.subString(getTeaNation(), size); }
    public void setTeaNation(String aTeaNation) { teaNation = aTeaNation; modifiedFields.add("TeaNation"); }
    public void assignTeaNation(String aTeaNation) { teaNation = aTeaNation; }
    public void paramTeaNation(HttpServletRequest request) { paramTeaNation(request, "TeaNation"); }
    public void paramTeaNation(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeaNation()); if (!tmp.equals(getTeaNation())) { setTeaNation(tmp); } }
    // 政治面貌
    protected String teaPolitics = "";
    public String getTeaPolitics() {  return SqlTool.getDbString(teaPolitics);  }
    public String getTeaPolitics(int size) { return SqlTool.subString(getTeaPolitics(), size); }
    public void setTeaPolitics(String aTeaPolitics) { teaPolitics = aTeaPolitics; modifiedFields.add("TeaPolitics"); }
    public void assignTeaPolitics(String aTeaPolitics) { teaPolitics = aTeaPolitics; }
    public void paramTeaPolitics(HttpServletRequest request) { paramTeaPolitics(request, "TeaPolitics"); }
    public void paramTeaPolitics(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeaPolitics()); if (!tmp.equals(getTeaPolitics())) { setTeaPolitics(tmp); } }
    // 籍贯
    protected String teaBirthplace = "";
    public String getTeaBirthplace() {  return SqlTool.getDbString(teaBirthplace);  }
    public String getTeaBirthplace(int size) { return SqlTool.subString(getTeaBirthplace(), size); }
    public void setTeaBirthplace(String aTeaBirthplace) { teaBirthplace = aTeaBirthplace; modifiedFields.add("TeaBirthplace"); }
    public void assignTeaBirthplace(String aTeaBirthplace) { teaBirthplace = aTeaBirthplace; }
    public void paramTeaBirthplace(HttpServletRequest request) { paramTeaBirthplace(request, "TeaBirthplace"); }
    public void paramTeaBirthplace(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeaBirthplace()); if (!tmp.equals(getTeaBirthplace())) { setTeaBirthplace(tmp); } }
    // 职位
    protected String teaDuty = "";
    public String getTeaDuty() {  return SqlTool.getDbString(teaDuty);  }
    public String getTeaDuty(int size) { return SqlTool.subString(getTeaDuty(), size); }
    public void setTeaDuty(String aTeaDuty) { teaDuty = aTeaDuty; modifiedFields.add("TeaDuty"); }
    public void assignTeaDuty(String aTeaDuty) { teaDuty = aTeaDuty; }
    public void paramTeaDuty(HttpServletRequest request) { paramTeaDuty(request, "TeaDuty"); }
    public void paramTeaDuty(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeaDuty()); if (!tmp.equals(getTeaDuty())) { setTeaDuty(tmp); } }
    // 所在学院（部门
    protected String teaAcademy = "";
    public String getTeaAcademy() {  return SqlTool.getDbString(teaAcademy);  }
    public String getTeaAcademy(int size) { return SqlTool.subString(getTeaAcademy(), size); }
    public void setTeaAcademy(String aTeaAcademy) { teaAcademy = aTeaAcademy; modifiedFields.add("TeaAcademy"); }
    public void assignTeaAcademy(String aTeaAcademy) { teaAcademy = aTeaAcademy; }
    public void paramTeaAcademy(HttpServletRequest request) { paramTeaAcademy(request, "TeaAcademy"); }
    public void paramTeaAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeaAcademy()); if (!tmp.equals(getTeaAcademy())) { setTeaAcademy(tmp); } }
    // 联系方式
    protected String teaTel = "";
    public String getTeaTel() {  return SqlTool.getDbString(teaTel);  }
    public String getTeaTel(int size) { return SqlTool.subString(getTeaTel(), size); }
    public void setTeaTel(String aTeaTel) { teaTel = aTeaTel; modifiedFields.add("TeaTel"); }
    public void assignTeaTel(String aTeaTel) { teaTel = aTeaTel; }
    public void paramTeaTel(HttpServletRequest request) { paramTeaTel(request, "TeaTel"); }
    public void paramTeaTel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeaTel()); if (!tmp.equals(getTeaTel())) { setTeaTel(tmp); } }
    // 手机
    protected String teaPhone = "";
    public String getTeaPhone() {  return SqlTool.getDbString(teaPhone);  }
    public String getTeaPhone(int size) { return SqlTool.subString(getTeaPhone(), size); }
    public void setTeaPhone(String aTeaPhone) { teaPhone = aTeaPhone; modifiedFields.add("TeaPhone"); }
    public void assignTeaPhone(String aTeaPhone) { teaPhone = aTeaPhone; }
    public void paramTeaPhone(HttpServletRequest request) { paramTeaPhone(request, "TeaPhone"); }
    public void paramTeaPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeaPhone()); if (!tmp.equals(getTeaPhone())) { setTeaPhone(tmp); } }
    // 邮箱
    protected String teaEmail = "";
    public String getTeaEmail() {  return SqlTool.getDbString(teaEmail);  }
    public String getTeaEmail(int size) { return SqlTool.subString(getTeaEmail(), size); }
    public void setTeaEmail(String aTeaEmail) { teaEmail = aTeaEmail; modifiedFields.add("TeaEmail"); }
    public void assignTeaEmail(String aTeaEmail) { teaEmail = aTeaEmail; }
    public void paramTeaEmail(HttpServletRequest request) { paramTeaEmail(request, "TeaEmail"); }
    public void paramTeaEmail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeaEmail()); if (!tmp.equals(getTeaEmail())) { setTeaEmail(tmp); } }
    // 个人情况简介
    protected String teaAcademic = "";
    public String getTeaAcademic() {  return SqlTool.getDbString(teaAcademic);  }
    public String getTeaAcademic(int size) { return SqlTool.subString(getTeaAcademic(), size); }
    public void setTeaAcademic(String aTeaAcademic) { teaAcademic = aTeaAcademic; modifiedFields.add("TeaAcademic"); }
    public void assignTeaAcademic(String aTeaAcademic) { teaAcademic = aTeaAcademic; }
    public void paramTeaAcademic(HttpServletRequest request) { paramTeaAcademic(request, "TeaAcademic"); }
    public void paramTeaAcademic(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeaAcademic()); if (!tmp.equals(getTeaAcademic())) { setTeaAcademic(tmp); } }
    // commentAcatw
    protected String commentAcatw = "";
    public String getCommentAcatw() {  return SqlTool.getDbString(commentAcatw);  }
    public String getCommentAcatw(int size) { return SqlTool.subString(getCommentAcatw(), size); }
    public void setCommentAcatw(String aCommentAcatw) { commentAcatw = aCommentAcatw; modifiedFields.add("CommentAcatw"); }
    public void assignCommentAcatw(String aCommentAcatw) { commentAcatw = aCommentAcatw; }
    public void paramCommentAcatw(HttpServletRequest request) { paramCommentAcatw(request, "CommentAcatw"); }
    public void paramCommentAcatw(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentAcatw()); if (!tmp.equals(getCommentAcatw())) { setCommentAcatw(tmp); } }
    // commentClubunion
    protected String commentClubunion = "";
    public String getCommentClubunion() {  return SqlTool.getDbString(commentClubunion);  }
    public String getCommentClubunion(int size) { return SqlTool.subString(getCommentClubunion(), size); }
    public void setCommentClubunion(String aCommentClubunion) { commentClubunion = aCommentClubunion; modifiedFields.add("CommentClubunion"); }
    public void assignCommentClubunion(String aCommentClubunion) { commentClubunion = aCommentClubunion; }
    public void paramCommentClubunion(HttpServletRequest request) { paramCommentClubunion(request, "CommentClubunion"); }
    public void paramCommentClubunion(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentClubunion()); if (!tmp.equals(getCommentClubunion())) { setCommentClubunion(tmp); } }
    // 团委评价
    protected String commentTw = "";
    public String getCommentTw() {  return SqlTool.getDbString(commentTw);  }
    public String getCommentTw(int size) { return SqlTool.subString(getCommentTw(), size); }
    public void setCommentTw(String aCommentTw) { commentTw = aCommentTw; modifiedFields.add("CommentTw"); }
    public void assignCommentTw(String aCommentTw) { commentTw = aCommentTw; }
    public void paramCommentTw(HttpServletRequest request) { paramCommentTw(request, "CommentTw"); }
    public void paramCommentTw(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentTw()); if (!tmp.equals(getCommentTw())) { setCommentTw(tmp); } }
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
    // 开始时间
    protected java.util.Date startDate = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getStartDate() { return startDate; }
    public void setStartDate(java.util.Date aStartDate) { startDate = aStartDate; modifiedFields.add("StartDate"); }
    public void assignStartDate(java.util.Date aStartDate) { startDate = aStartDate; }
    public void paramStartDate(HttpServletRequest request) { paramStartDate(request, "StartDate"); }
    public void paramStartDate(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getStartDate()); if (tmp.compareTo(getStartDate()) != 0) { setStartDate(tmp); } }
    // 结束时间
    protected java.util.Date stopDate = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getStopDate() { return stopDate; }
    public void setStopDate(java.util.Date aStopDate) { stopDate = aStopDate; modifiedFields.add("StopDate"); }
    public void assignStopDate(java.util.Date aStopDate) { stopDate = aStopDate; }
    public void paramStopDate(HttpServletRequest request) { paramStopDate(request, "StopDate"); }
    public void paramStopDate(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getStopDate()); if (tmp.compareTo(getStopDate()) != 0) { setStopDate(tmp); } }
    // 元老
    protected int generation = -1;
    public int getGeneration() { return generation; }
    public void setGeneration(int aGeneration) { generation = aGeneration; modifiedFields.add("Generation"); }
    public void assignGeneration(int aGeneration) { generation = aGeneration; }
    public void paramGeneration(HttpServletRequest request) { paramGeneration(request, "Generation"); }
    public void paramGeneration(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getGeneration()); if (tmp != getGeneration()) { setGeneration(tmp); } }
    // 提交申请日期
    protected java.util.Date applyDate = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getApplyDate() { return applyDate; }
    public void setApplyDate(java.util.Date aApplyDate) { applyDate = aApplyDate; modifiedFields.add("ApplyDate"); }
    public void assignApplyDate(java.util.Date aApplyDate) { applyDate = aApplyDate; }
    public void paramApplyDate(HttpServletRequest request) { paramApplyDate(request, "ApplyDate"); }
    public void paramApplyDate(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getApplyDate()); if (tmp.compareTo(getApplyDate()) != 0) { setApplyDate(tmp); } }
    // 是否可用
    protected int checkFlag = -1;
    public int getCheckFlag() { return checkFlag; }
    public void setCheckFlag(int aCheckFlag) { checkFlag = aCheckFlag; modifiedFields.add("CheckFlag"); }
    public void assignCheckFlag(int aCheckFlag) { checkFlag = aCheckFlag; }
    public void paramCheckFlag(HttpServletRequest request) { paramCheckFlag(request, "CheckFlag"); }
    public void paramCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckFlag()); if (tmp != getCheckFlag()) { setCheckFlag(tmp); } }
    // 学院意见
    protected String commentXy = "";
    public String getCommentXy() {  return SqlTool.getDbString(commentXy);  }
    public String getCommentXy(int size) { return SqlTool.subString(getCommentXy(), size); }
    public void setCommentXy(String aCommentXy) { commentXy = aCommentXy; modifiedFields.add("CommentXy"); }
    public void assignCommentXy(String aCommentXy) { commentXy = aCommentXy; }
    public void paramCommentXy(HttpServletRequest request) { paramCommentXy(request, "CommentXy"); }
    public void paramCommentXy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentXy()); if (!tmp.equals(getCommentXy())) { setCommentXy(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public ClubTeacher (String db) {
        DBNAME = db;
    }
    public ClubTeacher (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public ClubTeacher (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public ClubTeacher () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return ClubTeacher类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public ClubTeacher getByParameter(HttpServletRequest request) {
        ClubTeacher v = new ClubTeacher(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramClubName(request);
        paramClubCode(request);
        paramTeaName(request);
        paramTeaSex(request);
        paramTeaAge(request);
        paramTeaNation(request);
        paramTeaPolitics(request);
        paramTeaBirthplace(request);
        paramTeaDuty(request);
        paramTeaAcademy(request);
        paramTeaTel(request);
        paramTeaPhone(request);
        paramTeaEmail(request);
        paramTeaAcademic(request);
        paramCommentAcatw(request);
        paramCommentClubunion(request);
        paramCommentTw(request);
        paramAddPerson(request);
        paramAddTime(request);
        paramModiPerson(request);
        paramModiTime(request);
        paramStartDate(request);
        paramStopDate(request);
        paramGeneration(request);
        paramApplyDate(request);
        paramCheckFlag(request);
        paramCommentXy(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(ClubTeacher bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("clubName")) { setClubName(bean.getClubName()); }
        if (!ncl.contains("clubCode")) { setClubCode(bean.getClubCode()); }
        if (!ncl.contains("teaName")) { setTeaName(bean.getTeaName()); }
        if (!ncl.contains("teaSex")) { setTeaSex(bean.getTeaSex()); }
        if (!ncl.contains("teaAge")) { setTeaAge(bean.getTeaAge()); }
        if (!ncl.contains("teaNation")) { setTeaNation(bean.getTeaNation()); }
        if (!ncl.contains("teaPolitics")) { setTeaPolitics(bean.getTeaPolitics()); }
        if (!ncl.contains("teaBirthplace")) { setTeaBirthplace(bean.getTeaBirthplace()); }
        if (!ncl.contains("teaDuty")) { setTeaDuty(bean.getTeaDuty()); }
        if (!ncl.contains("teaAcademy")) { setTeaAcademy(bean.getTeaAcademy()); }
        if (!ncl.contains("teaTel")) { setTeaTel(bean.getTeaTel()); }
        if (!ncl.contains("teaPhone")) { setTeaPhone(bean.getTeaPhone()); }
        if (!ncl.contains("teaEmail")) { setTeaEmail(bean.getTeaEmail()); }
        if (!ncl.contains("teaAcademic")) { setTeaAcademic(bean.getTeaAcademic()); }
        if (!ncl.contains("commentAcatw")) { setCommentAcatw(bean.getCommentAcatw()); }
        if (!ncl.contains("commentClubunion")) { setCommentClubunion(bean.getCommentClubunion()); }
        if (!ncl.contains("commentTw")) { setCommentTw(bean.getCommentTw()); }
        if (!ncl.contains("addPerson")) { setAddPerson(bean.getAddPerson()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("modiPerson")) { setModiPerson(bean.getModiPerson()); }
        if (!ncl.contains("modiTime")) { setModiTime(bean.getModiTime()); }
        if (!ncl.contains("startDate")) { setStartDate(bean.getStartDate()); }
        if (!ncl.contains("stopDate")) { setStopDate(bean.getStopDate()); }
        if (!ncl.contains("generation")) { setGeneration(bean.getGeneration()); }
        if (!ncl.contains("applyDate")) { setApplyDate(bean.getApplyDate()); }
        if (!ncl.contains("checkFlag")) { setCheckFlag(bean.getCheckFlag()); }
        if (!ncl.contains("commentXy")) { setCommentXy(bean.getCommentXy()); }
    }
    public ClubTeacher getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        ClubTeacher[] rslt= queryByCondition(cdt);
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
     * @return ClubTeacher类的实例列表。
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
                ClubTeacher ve = new ClubTeacher(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignClubName(fromDbCh(rs.getString(2)));
                ve.assignClubCode(fromDbCh(rs.getString(3)));
                ve.assignTeaName(fromDbCh(rs.getString(4)));
                ve.assignTeaSex(fromDbCh(rs.getString(5)));
                ve.assignTeaAge(fromDbCh(rs.getString(6)));
                ve.assignTeaNation(fromDbCh(rs.getString(7)));
                ve.assignTeaPolitics(fromDbCh(rs.getString(8)));
                ve.assignTeaBirthplace(fromDbCh(rs.getString(9)));
                ve.assignTeaDuty(fromDbCh(rs.getString(10)));
                ve.assignTeaAcademy(fromDbCh(rs.getString(11)));
                ve.assignTeaTel(fromDbCh(rs.getString(12)));
                ve.assignTeaPhone(fromDbCh(rs.getString(13)));
                ve.assignTeaEmail(fromDbCh(rs.getString(14)));
                ve.assignTeaAcademic(fromDbCh(rs.getString(15)));
                ve.assignCommentAcatw(fromDbCh(rs.getString(16)));
                ve.assignCommentClubunion(fromDbCh(rs.getString(17)));
                ve.assignCommentTw(fromDbCh(rs.getString(18)));
                ve.assignAddPerson(fromDbCh(rs.getString(19)));
                tmpDate = rs.getTimestamp(20); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignModiPerson(fromDbCh(rs.getString(21)));
                tmpDate = rs.getTimestamp(22); if (tmpDate != null) { ve.assignModiTime(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(23); if (tmpDate != null) { ve.assignStartDate(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(24); if (tmpDate != null) { ve.assignStopDate(new java.util.Date(tmpDate.getTime())); }
                ve.assignGeneration(rs.getInt(25));
                tmpDate = rs.getTimestamp(26); if (tmpDate != null) { ve.assignApplyDate(new java.util.Date(tmpDate.getTime())); }
                ve.assignCheckFlag(rs.getInt(27));
                ve.assignCommentXy(fromDbCh(rs.getString(28)));
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
    public ClubTeacher[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (ClubTeacher[])vrs.toArray(new ClubTeacher[vrs.size()]);
    }
    public ClubTeacher[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (ClubTeacher[])vrs.toArray(new ClubTeacher[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (clubname,clubcode,teaname,teasex,teaage,teanation,teapolitics,teabirthplace,teaduty,teaacademy,teatel,teaphone,teaemail,teaacademic,commentacatw,commentclubunion,commenttw,addperson,addtime,modiperson,moditime,startdate,stopdate,generation,applydate,checkflag,commentxy) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(clubName));
            pstmt.setString(2, toDbCh(clubCode));
            pstmt.setString(3, toDbCh(teaName));
            pstmt.setString(4, toDbCh(teaSex));
            pstmt.setString(5, toDbCh(teaAge));
            pstmt.setString(6, toDbCh(teaNation));
            pstmt.setString(7, toDbCh(teaPolitics));
            pstmt.setString(8, toDbCh(teaBirthplace));
            pstmt.setString(9, toDbCh(teaDuty));
            pstmt.setString(10, toDbCh(teaAcademy));
            pstmt.setString(11, toDbCh(teaTel));
            pstmt.setString(12, toDbCh(teaPhone));
            pstmt.setString(13, toDbCh(teaEmail));
            pstmt.setString(14, toDbCh(teaAcademic));
            pstmt.setString(15, toDbCh(commentAcatw));
            pstmt.setString(16, toDbCh(commentClubunion));
            pstmt.setString(17, toDbCh(commentTw));
            pstmt.setString(18, toDbCh(addPerson));
            pstmt.setTimestamp(19, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(20, toDbCh(modiPerson));
            pstmt.setTimestamp(21, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setTimestamp(22, new java.sql.Timestamp(startDate.getTime()));
            pstmt.setTimestamp(23, new java.sql.Timestamp(stopDate.getTime()));
            pstmt.setInt(24, generation);
            pstmt.setTimestamp(25, new java.sql.Timestamp(applyDate.getTime()));
            pstmt.setInt(26, checkFlag);
            pstmt.setString(27, toDbCh(commentXy));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,clubname,clubcode,teaname,teasex,teaage,teanation,teapolitics,teabirthplace,teaduty,teaacademy,teatel,teaphone,teaemail,teaacademic,commentacatw,commentclubunion,commenttw,addperson,addtime,modiperson,moditime,startdate,stopdate,generation,applydate,checkflag,commentxy) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(clubName));
            pstmt.setString(3, toDbCh(clubCode));
            pstmt.setString(4, toDbCh(teaName));
            pstmt.setString(5, toDbCh(teaSex));
            pstmt.setString(6, toDbCh(teaAge));
            pstmt.setString(7, toDbCh(teaNation));
            pstmt.setString(8, toDbCh(teaPolitics));
            pstmt.setString(9, toDbCh(teaBirthplace));
            pstmt.setString(10, toDbCh(teaDuty));
            pstmt.setString(11, toDbCh(teaAcademy));
            pstmt.setString(12, toDbCh(teaTel));
            pstmt.setString(13, toDbCh(teaPhone));
            pstmt.setString(14, toDbCh(teaEmail));
            pstmt.setString(15, toDbCh(teaAcademic));
            pstmt.setString(16, toDbCh(commentAcatw));
            pstmt.setString(17, toDbCh(commentClubunion));
            pstmt.setString(18, toDbCh(commentTw));
            pstmt.setString(19, toDbCh(addPerson));
            pstmt.setTimestamp(20, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(21, toDbCh(modiPerson));
            pstmt.setTimestamp(22, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setTimestamp(23, new java.sql.Timestamp(startDate.getTime()));
            pstmt.setTimestamp(24, new java.sql.Timestamp(stopDate.getTime()));
            pstmt.setInt(25, generation);
            pstmt.setTimestamp(26, new java.sql.Timestamp(applyDate.getTime()));
            pstmt.setInt(27, checkFlag);
            pstmt.setString(28, toDbCh(commentXy));
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
            ClubTeacher item = (ClubTeacher)it.next();
            ClubTeacher v = new ClubTeacher(dbname);
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
                if (modifiedFields.contains("ClubName")) { pstmt.setString(pi ++, toDbCh(clubName)); }
                if (modifiedFields.contains("ClubCode")) { pstmt.setString(pi ++, toDbCh(clubCode)); }
                if (modifiedFields.contains("TeaName")) { pstmt.setString(pi ++, toDbCh(teaName)); }
                if (modifiedFields.contains("TeaSex")) { pstmt.setString(pi ++, toDbCh(teaSex)); }
                if (modifiedFields.contains("TeaAge")) { pstmt.setString(pi ++, toDbCh(teaAge)); }
                if (modifiedFields.contains("TeaNation")) { pstmt.setString(pi ++, toDbCh(teaNation)); }
                if (modifiedFields.contains("TeaPolitics")) { pstmt.setString(pi ++, toDbCh(teaPolitics)); }
                if (modifiedFields.contains("TeaBirthplace")) { pstmt.setString(pi ++, toDbCh(teaBirthplace)); }
                if (modifiedFields.contains("TeaDuty")) { pstmt.setString(pi ++, toDbCh(teaDuty)); }
                if (modifiedFields.contains("TeaAcademy")) { pstmt.setString(pi ++, toDbCh(teaAcademy)); }
                if (modifiedFields.contains("TeaTel")) { pstmt.setString(pi ++, toDbCh(teaTel)); }
                if (modifiedFields.contains("TeaPhone")) { pstmt.setString(pi ++, toDbCh(teaPhone)); }
                if (modifiedFields.contains("TeaEmail")) { pstmt.setString(pi ++, toDbCh(teaEmail)); }
                if (modifiedFields.contains("TeaAcademic")) { pstmt.setString(pi ++, toDbCh(teaAcademic)); }
                if (modifiedFields.contains("CommentAcatw")) { pstmt.setString(pi ++, toDbCh(commentAcatw)); }
                if (modifiedFields.contains("CommentClubunion")) { pstmt.setString(pi ++, toDbCh(commentClubunion)); }
                if (modifiedFields.contains("CommentTw")) { pstmt.setString(pi ++, toDbCh(commentTw)); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("StartDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(startDate.getTime())); }
                if (modifiedFields.contains("StopDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(stopDate.getTime())); }
                if (modifiedFields.contains("Generation")) { pstmt.setInt(pi ++, generation); }
                if (modifiedFields.contains("ApplyDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(applyDate.getTime())); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("CommentXy")) { pstmt.setString(pi ++, toDbCh(commentXy)); }
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
                if (modifiedFields.contains("ClubName")) { pstmt.setString(pi ++, toDbCh(clubName)); }
                if (modifiedFields.contains("ClubCode")) { pstmt.setString(pi ++, toDbCh(clubCode)); }
                if (modifiedFields.contains("TeaName")) { pstmt.setString(pi ++, toDbCh(teaName)); }
                if (modifiedFields.contains("TeaSex")) { pstmt.setString(pi ++, toDbCh(teaSex)); }
                if (modifiedFields.contains("TeaAge")) { pstmt.setString(pi ++, toDbCh(teaAge)); }
                if (modifiedFields.contains("TeaNation")) { pstmt.setString(pi ++, toDbCh(teaNation)); }
                if (modifiedFields.contains("TeaPolitics")) { pstmt.setString(pi ++, toDbCh(teaPolitics)); }
                if (modifiedFields.contains("TeaBirthplace")) { pstmt.setString(pi ++, toDbCh(teaBirthplace)); }
                if (modifiedFields.contains("TeaDuty")) { pstmt.setString(pi ++, toDbCh(teaDuty)); }
                if (modifiedFields.contains("TeaAcademy")) { pstmt.setString(pi ++, toDbCh(teaAcademy)); }
                if (modifiedFields.contains("TeaTel")) { pstmt.setString(pi ++, toDbCh(teaTel)); }
                if (modifiedFields.contains("TeaPhone")) { pstmt.setString(pi ++, toDbCh(teaPhone)); }
                if (modifiedFields.contains("TeaEmail")) { pstmt.setString(pi ++, toDbCh(teaEmail)); }
                if (modifiedFields.contains("TeaAcademic")) { pstmt.setString(pi ++, toDbCh(teaAcademic)); }
                if (modifiedFields.contains("CommentAcatw")) { pstmt.setString(pi ++, toDbCh(commentAcatw)); }
                if (modifiedFields.contains("CommentClubunion")) { pstmt.setString(pi ++, toDbCh(commentClubunion)); }
                if (modifiedFields.contains("CommentTw")) { pstmt.setString(pi ++, toDbCh(commentTw)); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("StartDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(startDate.getTime())); }
                if (modifiedFields.contains("StopDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(stopDate.getTime())); }
                if (modifiedFields.contains("Generation")) { pstmt.setInt(pi ++, generation); }
                if (modifiedFields.contains("ApplyDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(applyDate.getTime())); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("CommentXy")) { pstmt.setString(pi ++, toDbCh(commentXy)); }
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
        map.put("ClubName", getClubName());
        map.put("ClubCode", getClubCode());
        map.put("TeaName", getTeaName());
        map.put("TeaSex", getTeaSex());
        map.put("TeaAge", getTeaAge());
        map.put("TeaNation", getTeaNation());
        map.put("TeaPolitics", getTeaPolitics());
        map.put("TeaBirthplace", getTeaBirthplace());
        map.put("TeaDuty", getTeaDuty());
        map.put("TeaAcademy", getTeaAcademy());
        map.put("TeaTel", getTeaTel());
        map.put("TeaPhone", getTeaPhone());
        map.put("TeaEmail", getTeaEmail());
        map.put("TeaAcademic", getTeaAcademic());
        map.put("CommentAcatw", getCommentAcatw());
        map.put("CommentClubunion", getCommentClubunion());
        map.put("CommentTw", getCommentTw());
        map.put("AddPerson", getAddPerson());
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("ModiPerson", getModiPerson());
        map.put("ModiTime", Tool.stringOfDateTime(getModiTime()));
        map.put("StartDate", Tool.stringOfDateTime(getStartDate()));
        map.put("StopDate", Tool.stringOfDateTime(getStopDate()));
        map.put("Generation", getGeneration() + "");
        map.put("ApplyDate", Tool.stringOfDateTime(getApplyDate()));
        map.put("CheckFlag", getCheckFlag() + "");
        map.put("CommentXy", getCommentXy());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("ClubName:\"" + Tool.jsSpecialChars(getClubName()) + "\"");
        row.add("ClubCode:\"" + Tool.jsSpecialChars(getClubCode()) + "\"");
        row.add("TeaName:\"" + Tool.jsSpecialChars(getTeaName()) + "\"");
        row.add("TeaSex:\"" + Tool.jsSpecialChars(getTeaSex()) + "\"");
        row.add("TeaAge:\"" + Tool.jsSpecialChars(getTeaAge()) + "\"");
        row.add("TeaNation:\"" + Tool.jsSpecialChars(getTeaNation()) + "\"");
        row.add("TeaPolitics:\"" + Tool.jsSpecialChars(getTeaPolitics()) + "\"");
        row.add("TeaBirthplace:\"" + Tool.jsSpecialChars(getTeaBirthplace()) + "\"");
        row.add("TeaDuty:\"" + Tool.jsSpecialChars(getTeaDuty()) + "\"");
        row.add("TeaAcademy:\"" + Tool.jsSpecialChars(getTeaAcademy()) + "\"");
        row.add("TeaTel:\"" + Tool.jsSpecialChars(getTeaTel()) + "\"");
        row.add("TeaPhone:\"" + Tool.jsSpecialChars(getTeaPhone()) + "\"");
        row.add("TeaEmail:\"" + Tool.jsSpecialChars(getTeaEmail()) + "\"");
        row.add("TeaAcademic:\"" + Tool.jsSpecialChars(getTeaAcademic()) + "\"");
        row.add("CommentAcatw:\"" + Tool.jsSpecialChars(getCommentAcatw()) + "\"");
        row.add("CommentClubunion:\"" + Tool.jsSpecialChars(getCommentClubunion()) + "\"");
        row.add("CommentTw:\"" + Tool.jsSpecialChars(getCommentTw()) + "\"");
        row.add("AddPerson:\"" + Tool.jsSpecialChars(getAddPerson()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("ModiPerson:\"" + Tool.jsSpecialChars(getModiPerson()) + "\"");
        row.add("ModiTime:\"" + Tool.stringOfDateTime(getModiTime()) + "\"");
        row.add("StartDate:\"" + Tool.stringOfDateTime(getStartDate()) + "\"");
        row.add("StopDate:\"" + Tool.stringOfDateTime(getStopDate()) + "\"");
        row.add("Generation:\"" + getGeneration() + "\"");
        row.add("ApplyDate:\"" + Tool.stringOfDateTime(getApplyDate()) + "\"");
        row.add("CheckFlag:\"" + getCheckFlag() + "\"");
        row.add("CommentXy:\"" + Tool.jsSpecialChars(getCommentXy()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,clubname varchar2(45),clubcode varchar2(45),teaname varchar2(45),teasex varchar2(45),teaage varchar2(45),teanation varchar2(45),teapolitics varchar2(45),teabirthplace varchar2(45),teaduty varchar2(45),teaacademy varchar2(45),teatel varchar2(45),teaphone varchar2(45),teaemail varchar2(45),teaacademic varchar2(500),commentacatw varchar2(500),commentclubunion varchar2(500),commenttw varchar2(500),addperson varchar2(50),addtime date,modiperson varchar2(50),moditime date,startdate date,stopdate date,generation number(*,0),applydate date,checkflag number(*,0),commentxy varchar2(45))"});
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
        ClubTeacher v = new ClubTeacher(sourceDb, sourceTb);
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
        ClubTeacher v = new ClubTeacher(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(ClubTeacher obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getClubName().compareTo(obj.getClubName()); if (rtn != 0) return rtn;
        rtn = getClubCode().compareTo(obj.getClubCode()); if (rtn != 0) return rtn;
        rtn = getTeaName().compareTo(obj.getTeaName()); if (rtn != 0) return rtn;
        rtn = getTeaSex().compareTo(obj.getTeaSex()); if (rtn != 0) return rtn;
        rtn = getTeaAge().compareTo(obj.getTeaAge()); if (rtn != 0) return rtn;
        rtn = getTeaNation().compareTo(obj.getTeaNation()); if (rtn != 0) return rtn;
        rtn = getTeaPolitics().compareTo(obj.getTeaPolitics()); if (rtn != 0) return rtn;
        rtn = getTeaBirthplace().compareTo(obj.getTeaBirthplace()); if (rtn != 0) return rtn;
        rtn = getTeaDuty().compareTo(obj.getTeaDuty()); if (rtn != 0) return rtn;
        rtn = getTeaAcademy().compareTo(obj.getTeaAcademy()); if (rtn != 0) return rtn;
        rtn = getTeaTel().compareTo(obj.getTeaTel()); if (rtn != 0) return rtn;
        rtn = getTeaPhone().compareTo(obj.getTeaPhone()); if (rtn != 0) return rtn;
        rtn = getTeaEmail().compareTo(obj.getTeaEmail()); if (rtn != 0) return rtn;
        rtn = getTeaAcademic().compareTo(obj.getTeaAcademic()); if (rtn != 0) return rtn;
        rtn = getCommentAcatw().compareTo(obj.getCommentAcatw()); if (rtn != 0) return rtn;
        rtn = getCommentClubunion().compareTo(obj.getCommentClubunion()); if (rtn != 0) return rtn;
        rtn = getCommentTw().compareTo(obj.getCommentTw()); if (rtn != 0) return rtn;
        rtn = getAddPerson().compareTo(obj.getAddPerson()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = getModiPerson().compareTo(obj.getModiPerson()); if (rtn != 0) return rtn;
        rtn = getModiTime().compareTo(obj.getModiTime()); if (rtn != 0) return rtn;
        rtn = getStartDate().compareTo(obj.getStartDate()); if (rtn != 0) return rtn;
        rtn = getStopDate().compareTo(obj.getStopDate()); if (rtn != 0) return rtn;
        rtn = ("" + getGeneration()).compareTo("" + obj.getGeneration()); if (rtn != 0) return rtn;
        rtn = getApplyDate().compareTo(obj.getApplyDate()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckFlag()).compareTo("" + obj.getCheckFlag()); if (rtn != 0) return rtn;
        rtn = getCommentXy().compareTo(obj.getCommentXy()); if (rtn != 0) return rtn;
        return rtn;
    }
}
