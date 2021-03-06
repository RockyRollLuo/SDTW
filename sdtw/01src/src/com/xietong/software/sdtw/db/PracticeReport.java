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
@Description("社会实践结题书表")
public class PracticeReport implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(PracticeReport.class);
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
    public static final String DbTableName = "practice_report";
    private String TNAME = "practice_report";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","declareId","type","teamId","memberid","practiceId","academy","addFilelist","xyCheckFlag","twCheckFlag","submitFlag","xyHonour","report1","report2","report3","report4","report5","report6","report12","report13","report14","report15","startTime","endTime","report17","report18","report19","report20","report23","report24","report25","report26","report27","report28","report29","report30","addaccount","addtime","remark","remark2","remark3","remark4","remark5","remark6"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","declareid","type","teamid","memberid","practiceid","academy","addfilelist","xycheckflag","twcheckflag","submitflag","xyhonour","report1","report2","report3","report4","report5","report6","report12","report13","report14","report15","starttime","endtime","report17","report18","report19","report20","report23","report24","report25","report26","report27","report28","report29","report30","addaccount","addtime","remark","remark2","remark3","remark4","remark5","remark6"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"DeclareId","declareid","int"},{"Type","type","int"},{"TeamId","teamid","String"},{"Memberid","memberid","String"},{"PracticeId","practiceid","int"},{"Academy","academy","String"},{"AddFilelist","addfilelist","String"},{"XyCheckFlag","xycheckflag","int"},{"TwCheckFlag","twcheckflag","int"},{"SubmitFlag","submitflag","int"},{"XyHonour","xyhonour","String"},{"Report1","report1","String"},{"Report2","report2","String"},{"Report3","report3","String"},{"Report4","report4","String"},{"Report5","report5","String"},{"Report6","report6","String"},{"Report12","report12","String"},{"Report13","report13","String"},{"Report14","report14","String"},{"Report15","report15","String"},{"StartTime","starttime","String"},{"EndTime","endtime","String"},{"Report17","report17","String"},{"Report18","report18","String"},{"Report19","report19","String"},{"Report20","report20","String"},{"Report23","report23","String"},{"Report24","report24","String"},{"Report25","report25","String"},{"Report26","report26","String"},{"Report27","report27","String"},{"Report28","report28","String"},{"Report29","report29","String"},{"Report30","report30","String"},{"Addaccount","addaccount","String"},{"Addtime","addtime","String"},{"Remark","remark","String"},{"Remark2","remark2","String"},{"Remark3","remark3","String"},{"Remark4","remark4","String"},{"Remark5","remark5","String"},{"Remark6","remark6","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"declareId","declareid"},{"type","type"},{"teamId","teamid"},{"memberid","memberid"},{"practiceId","practiceid"},{"academy","academy"},{"addFilelist","addfilelist"},{"xyCheckFlag","xycheckflag"},{"twCheckFlag","twcheckflag"},{"submitFlag","submitflag"},{"xyHonour","xyhonour"},{"report1","report1"},{"report2","report2"},{"report3","report3"},{"report4","report4"},{"report5","report5"},{"report6","report6"},{"report12","report12"},{"report13","report13"},{"report14","report14"},{"report15","report15"},{"startTime","starttime"},{"endTime","endtime"},{"report17","report17"},{"report18","report18"},{"report19","report19"},{"report20","report20"},{"report23","report23"},{"report24","report24"},{"report25","report25"},{"report26","report26"},{"report27","report27"},{"report28","report28"},{"report29","report29"},{"report30","report30"},{"addaccount","addaccount"},{"addtime","addtime"},{"remark","remark"},{"remark2","remark2"},{"remark3","remark3"},{"remark4","remark4"},{"remark5","remark5"},{"remark6","remark6"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 立项表id
    protected int declareId = -1;
    public int getDeclareId() { return declareId; }
    public void setDeclareId(int aDeclareId) { declareId = aDeclareId; modifiedFields.add("DeclareId"); }
    public void assignDeclareId(int aDeclareId) { declareId = aDeclareId; }
    public void paramDeclareId(HttpServletRequest request) { paramDeclareId(request, "DeclareId"); }
    public void paramDeclareId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getDeclareId()); if (tmp != getDeclareId()) { setDeclareId(tmp); } }
    // 类别
    protected int type = -1;
    public int getType() { return type; }
    public void setType(int aType) { type = aType; modifiedFields.add("Type"); }
    public void assignType(int aType) { type = aType; }
    public void paramType(HttpServletRequest request) { paramType(request, "Type"); }
    public void paramType(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getType()); if (tmp != getType()) { setType(tmp); } }
    // 团队id
    protected String teamId = "";
    public String getTeamId() {  return SqlTool.getDbString(teamId);  }
    public String getTeamId(int size) { return SqlTool.subString(getTeamId(), size); }
    public void setTeamId(String aTeamId) { teamId = aTeamId; modifiedFields.add("TeamId"); }
    public void assignTeamId(String aTeamId) { teamId = aTeamId; }
    public void paramTeamId(HttpServletRequest request) { paramTeamId(request, "TeamId"); }
    public void paramTeamId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeamId()); if (!tmp.equals(getTeamId())) { setTeamId(tmp); } }
    // 成员id
    protected String memberid = "";
    public String getMemberid() {  return SqlTool.getDbString(memberid);  }
    public String getMemberid(int size) { return SqlTool.subString(getMemberid(), size); }
    public void setMemberid(String aMemberid) { memberid = aMemberid; modifiedFields.add("Memberid"); }
    public void assignMemberid(String aMemberid) { memberid = aMemberid; }
    public void paramMemberid(HttpServletRequest request) { paramMemberid(request, "Memberid"); }
    public void paramMemberid(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberid()); if (!tmp.equals(getMemberid())) { setMemberid(tmp); } }
    // 所参加实践ID
    protected int practiceId = -1;
    public int getPracticeId() { return practiceId; }
    public void setPracticeId(int aPracticeId) { practiceId = aPracticeId; modifiedFields.add("PracticeId"); }
    public void assignPracticeId(int aPracticeId) { practiceId = aPracticeId; }
    public void paramPracticeId(HttpServletRequest request) { paramPracticeId(request, "PracticeId"); }
    public void paramPracticeId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getPracticeId()); if (tmp != getPracticeId()) { setPracticeId(tmp); } }
    // 学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 添加文件列表
    protected String addFilelist = "";
    public String getAddFilelist() {  return SqlTool.getDbString(addFilelist);  }
    public String getAddFilelist(int size) { return SqlTool.subString(getAddFilelist(), size); }
    public void setAddFilelist(String aAddFilelist) { addFilelist = aAddFilelist; modifiedFields.add("AddFilelist"); }
    public void assignAddFilelist(String aAddFilelist) { addFilelist = aAddFilelist; }
    public void paramAddFilelist(HttpServletRequest request) { paramAddFilelist(request, "AddFilelist"); }
    public void paramAddFilelist(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddFilelist()); if (!tmp.equals(getAddFilelist())) { setAddFilelist(tmp); } }
    // 学院审核状态
    protected int xyCheckFlag = -1;
    public int getXyCheckFlag() { return xyCheckFlag; }
    public void setXyCheckFlag(int aXyCheckFlag) { xyCheckFlag = aXyCheckFlag; modifiedFields.add("XyCheckFlag"); }
    public void assignXyCheckFlag(int aXyCheckFlag) { xyCheckFlag = aXyCheckFlag; }
    public void paramXyCheckFlag(HttpServletRequest request) { paramXyCheckFlag(request, "XyCheckFlag"); }
    public void paramXyCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getXyCheckFlag()); if (tmp != getXyCheckFlag()) { setXyCheckFlag(tmp); } }
    // 团委审核状态
    protected int twCheckFlag = -1;
    public int getTwCheckFlag() { return twCheckFlag; }
    public void setTwCheckFlag(int aTwCheckFlag) { twCheckFlag = aTwCheckFlag; modifiedFields.add("TwCheckFlag"); }
    public void assignTwCheckFlag(int aTwCheckFlag) { twCheckFlag = aTwCheckFlag; }
    public void paramTwCheckFlag(HttpServletRequest request) { paramTwCheckFlag(request, "TwCheckFlag"); }
    public void paramTwCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getTwCheckFlag()); if (tmp != getTwCheckFlag()) { setTwCheckFlag(tmp); } }
    // 提交状态
    protected int submitFlag = -1;
    public int getSubmitFlag() { return submitFlag; }
    public void setSubmitFlag(int aSubmitFlag) { submitFlag = aSubmitFlag; modifiedFields.add("SubmitFlag"); }
    public void assignSubmitFlag(int aSubmitFlag) { submitFlag = aSubmitFlag; }
    public void paramSubmitFlag(HttpServletRequest request) { paramSubmitFlag(request, "SubmitFlag"); }
    public void paramSubmitFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getSubmitFlag()); if (tmp != getSubmitFlag()) { setSubmitFlag(tmp); } }
    // 学院设置荣誉
    protected String xyHonour = "";
    public String getXyHonour() {  return SqlTool.getDbString(xyHonour);  }
    public String getXyHonour(int size) { return SqlTool.subString(getXyHonour(), size); }
    public void setXyHonour(String aXyHonour) { xyHonour = aXyHonour; modifiedFields.add("XyHonour"); }
    public void assignXyHonour(String aXyHonour) { xyHonour = aXyHonour; }
    public void paramXyHonour(HttpServletRequest request) { paramXyHonour(request, "XyHonour"); }
    public void paramXyHonour(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getXyHonour()); if (!tmp.equals(getXyHonour())) { setXyHonour(tmp); } }
    // 团队名称
    protected String report1 = "";
    public String getReport1() {  return SqlTool.getDbString(report1);  }
    public String getReport1(int size) { return SqlTool.subString(getReport1(), size); }
    public void setReport1(String aReport1) { report1 = aReport1; modifiedFields.add("Report1"); }
    public void assignReport1(String aReport1) { report1 = aReport1; }
    public void paramReport1(HttpServletRequest request) { paramReport1(request, "Report1"); }
    public void paramReport1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport1()); if (!tmp.equals(getReport1())) { setReport1(tmp); } }
    // 所属学院
    protected String report2 = "";
    public String getReport2() {  return SqlTool.getDbString(report2);  }
    public String getReport2(int size) { return SqlTool.subString(getReport2(), size); }
    public void setReport2(String aReport2) { report2 = aReport2; modifiedFields.add("Report2"); }
    public void assignReport2(String aReport2) { report2 = aReport2; }
    public void paramReport2(HttpServletRequest request) { paramReport2(request, "Report2"); }
    public void paramReport2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport2()); if (!tmp.equals(getReport2())) { setReport2(tmp); } }
    // 课题名称
    protected String report3 = "";
    public String getReport3() {  return SqlTool.getDbString(report3);  }
    public String getReport3(int size) { return SqlTool.subString(getReport3(), size); }
    public void setReport3(String aReport3) { report3 = aReport3; modifiedFields.add("Report3"); }
    public void assignReport3(String aReport3) { report3 = aReport3; }
    public void paramReport3(HttpServletRequest request) { paramReport3(request, "Report3"); }
    public void paramReport3(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport3()); if (!tmp.equals(getReport3())) { setReport3(tmp); } }
    // 团队类别
    protected String report4 = "";
    public String getReport4() {  return SqlTool.getDbString(report4);  }
    public String getReport4(int size) { return SqlTool.subString(getReport4(), size); }
    public void setReport4(String aReport4) { report4 = aReport4; modifiedFields.add("Report4"); }
    public void assignReport4(String aReport4) { report4 = aReport4; }
    public void paramReport4(HttpServletRequest request) { paramReport4(request, "Report4"); }
    public void paramReport4(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport4()); if (!tmp.equals(getReport4())) { setReport4(tmp); } }
    // 实践主题
    protected String report5 = "";
    public String getReport5() {  return SqlTool.getDbString(report5);  }
    public String getReport5(int size) { return SqlTool.subString(getReport5(), size); }
    public void setReport5(String aReport5) { report5 = aReport5; modifiedFields.add("Report5"); }
    public void assignReport5(String aReport5) { report5 = aReport5; }
    public void paramReport5(HttpServletRequest request) { paramReport5(request, "Report5"); }
    public void paramReport5(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport5()); if (!tmp.equals(getReport5())) { setReport5(tmp); } }
    // 立项类别
    protected String report6 = "";
    public String getReport6() {  return SqlTool.getDbString(report6);  }
    public String getReport6(int size) { return SqlTool.subString(getReport6(), size); }
    public void setReport6(String aReport6) { report6 = aReport6; modifiedFields.add("Report6"); }
    public void assignReport6(String aReport6) { report6 = aReport6; }
    public void paramReport6(HttpServletRequest request) { paramReport6(request, "Report6"); }
    public void paramReport6(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport6()); if (!tmp.equals(getReport6())) { setReport6(tmp); } }
    // 活动地点、路线
    protected String report12 = "";
    public String getReport12() {  return SqlTool.getDbString(report12);  }
    public String getReport12(int size) { return SqlTool.subString(getReport12(), size); }
    public void setReport12(String aReport12) { report12 = aReport12; modifiedFields.add("Report12"); }
    public void assignReport12(String aReport12) { report12 = aReport12; }
    public void paramReport12(HttpServletRequest request) { paramReport12(request, "Report12"); }
    public void paramReport12(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport12()); if (!tmp.equals(getReport12())) { setReport12(tmp); } }
    // 本科学生
    protected String report13 = "";
    public String getReport13() {  return SqlTool.getDbString(report13);  }
    public String getReport13(int size) { return SqlTool.subString(getReport13(), size); }
    public void setReport13(String aReport13) { report13 = aReport13; modifiedFields.add("Report13"); }
    public void assignReport13(String aReport13) { report13 = aReport13; }
    public void paramReport13(HttpServletRequest request) { paramReport13(request, "Report13"); }
    public void paramReport13(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport13()); if (!tmp.equals(getReport13())) { setReport13(tmp); } }
    // 硕士研究生
    protected String report14 = "";
    public String getReport14() {  return SqlTool.getDbString(report14);  }
    public String getReport14(int size) { return SqlTool.subString(getReport14(), size); }
    public void setReport14(String aReport14) { report14 = aReport14; modifiedFields.add("Report14"); }
    public void assignReport14(String aReport14) { report14 = aReport14; }
    public void paramReport14(HttpServletRequest request) { paramReport14(request, "Report14"); }
    public void paramReport14(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport14()); if (!tmp.equals(getReport14())) { setReport14(tmp); } }
    // 博士研究生
    protected String report15 = "";
    public String getReport15() {  return SqlTool.getDbString(report15);  }
    public String getReport15(int size) { return SqlTool.subString(getReport15(), size); }
    public void setReport15(String aReport15) { report15 = aReport15; modifiedFields.add("Report15"); }
    public void assignReport15(String aReport15) { report15 = aReport15; }
    public void paramReport15(HttpServletRequest request) { paramReport15(request, "Report15"); }
    public void paramReport15(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport15()); if (!tmp.equals(getReport15())) { setReport15(tmp); } }
    // 活动开始时间
    protected String startTime = "";
    public String getStartTime() {  return SqlTool.getDbString(startTime);  }
    public String getStartTime(int size) { return SqlTool.subString(getStartTime(), size); }
    public void setStartTime(String aStartTime) { startTime = aStartTime; modifiedFields.add("StartTime"); }
    public void assignStartTime(String aStartTime) { startTime = aStartTime; }
    public void paramStartTime(HttpServletRequest request) { paramStartTime(request, "StartTime"); }
    public void paramStartTime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getStartTime()); if (!tmp.equals(getStartTime())) { setStartTime(tmp); } }
    // 活动结束时间
    protected String endTime = "";
    public String getEndTime() {  return SqlTool.getDbString(endTime);  }
    public String getEndTime(int size) { return SqlTool.subString(getEndTime(), size); }
    public void setEndTime(String aEndTime) { endTime = aEndTime; modifiedFields.add("EndTime"); }
    public void assignEndTime(String aEndTime) { endTime = aEndTime; }
    public void paramEndTime(HttpServletRequest request) { paramEndTime(request, "EndTime"); }
    public void paramEndTime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getEndTime()); if (!tmp.equals(getEndTime())) { setEndTime(tmp); } }
    // 活动天数
    protected String report17 = "";
    public String getReport17() {  return SqlTool.getDbString(report17);  }
    public String getReport17(int size) { return SqlTool.subString(getReport17(), size); }
    public void setReport17(String aReport17) { report17 = aReport17; modifiedFields.add("Report17"); }
    public void assignReport17(String aReport17) { report17 = aReport17; }
    public void paramReport17(HttpServletRequest request) { paramReport17(request, "Report17"); }
    public void paramReport17(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport17()); if (!tmp.equals(getReport17())) { setReport17(tmp); } }
    // 接收单位对团队活动的评价
    protected String report18 = "";
    public String getReport18() {  return SqlTool.getDbString(report18);  }
    public String getReport18(int size) { return SqlTool.subString(getReport18(), size); }
    public void setReport18(String aReport18) { report18 = aReport18; modifiedFields.add("Report18"); }
    public void assignReport18(String aReport18) { report18 = aReport18; }
    public void paramReport18(HttpServletRequest request) { paramReport18(request, "Report18"); }
    public void paramReport18(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport18()); if (!tmp.equals(getReport18())) { setReport18(tmp); } }
    // 回访联系人
    protected String report19 = "";
    public String getReport19() {  return SqlTool.getDbString(report19);  }
    public String getReport19(int size) { return SqlTool.subString(getReport19(), size); }
    public void setReport19(String aReport19) { report19 = aReport19; modifiedFields.add("Report19"); }
    public void assignReport19(String aReport19) { report19 = aReport19; }
    public void paramReport19(HttpServletRequest request) { paramReport19(request, "Report19"); }
    public void paramReport19(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport19()); if (!tmp.equals(getReport19())) { setReport19(tmp); } }
    // 回访电话
    protected String report20 = "";
    public String getReport20() {  return SqlTool.getDbString(report20);  }
    public String getReport20(int size) { return SqlTool.subString(getReport20(), size); }
    public void setReport20(String aReport20) { report20 = aReport20; modifiedFields.add("Report20"); }
    public void assignReport20(String aReport20) { report20 = aReport20; }
    public void paramReport20(HttpServletRequest request) { paramReport20(request, "Report20"); }
    public void paramReport20(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport20()); if (!tmp.equals(getReport20())) { setReport20(tmp); } }
    // 报告题目
    protected String report23 = "";
    public String getReport23() {  return SqlTool.getDbString(report23);  }
    public String getReport23(int size) { return SqlTool.subString(getReport23(), size); }
    public void setReport23(String aReport23) { report23 = aReport23; modifiedFields.add("Report23"); }
    public void assignReport23(String aReport23) { report23 = aReport23; }
    public void paramReport23(HttpServletRequest request) { paramReport23(request, "Report23"); }
    public void paramReport23(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport23()); if (!tmp.equals(getReport23())) { setReport23(tmp); } }
    // 报告类别
    protected String report24 = "";
    public String getReport24() {  return SqlTool.getDbString(report24);  }
    public String getReport24(int size) { return SqlTool.subString(getReport24(), size); }
    public void setReport24(String aReport24) { report24 = aReport24; modifiedFields.add("Report24"); }
    public void assignReport24(String aReport24) { report24 = aReport24; }
    public void paramReport24(HttpServletRequest request) { paramReport24(request, "Report24"); }
    public void paramReport24(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport24()); if (!tmp.equals(getReport24())) { setReport24(tmp); } }
    // 报告字数
    protected String report25 = "";
    public String getReport25() {  return SqlTool.getDbString(report25);  }
    public String getReport25(int size) { return SqlTool.subString(getReport25(), size); }
    public void setReport25(String aReport25) { report25 = aReport25; modifiedFields.add("Report25"); }
    public void assignReport25(String aReport25) { report25 = aReport25; }
    public void paramReport25(HttpServletRequest request) { paramReport25(request, "Report25"); }
    public void paramReport25(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport25()); if (!tmp.equals(getReport25())) { setReport25(tmp); } }
    // 对地方经济、社会和文化发展或企业成长的实际作用
    protected String report26 = "";
    public String getReport26() {  return SqlTool.getDbString(report26);  }
    public String getReport26(int size) { return SqlTool.subString(getReport26(), size); }
    public void setReport26(String aReport26) { report26 = aReport26; modifiedFields.add("Report26"); }
    public void assignReport26(String aReport26) { report26 = aReport26; }
    public void paramReport26(HttpServletRequest request) { paramReport26(request, "Report26"); }
    public void paramReport26(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport26()); if (!tmp.equals(getReport26())) { setReport26(tmp); } }
    // 指导教师工作总结
    protected String report27 = "";
    public String getReport27() {  return SqlTool.getDbString(report27);  }
    public String getReport27(int size) { return SqlTool.subString(getReport27(), size); }
    public void setReport27(String aReport27) { report27 = aReport27; modifiedFields.add("Report27"); }
    public void assignReport27(String aReport27) { report27 = aReport27; }
    public void paramReport27(HttpServletRequest request) { paramReport27(request, "Report27"); }
    public void paramReport27(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport27()); if (!tmp.equals(getReport27())) { setReport27(tmp); } }
    // 主要宣传报道情况
    protected String report28 = "";
    public String getReport28() {  return SqlTool.getDbString(report28);  }
    public String getReport28(int size) { return SqlTool.subString(getReport28(), size); }
    public void setReport28(String aReport28) { report28 = aReport28; modifiedFields.add("Report28"); }
    public void assignReport28(String aReport28) { report28 = aReport28; }
    public void paramReport28(HttpServletRequest request) { paramReport28(request, "Report28"); }
    public void paramReport28(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport28()); if (!tmp.equals(getReport28())) { setReport28(tmp); } }
    // 宣传报道数量
    protected String report29 = "";
    public String getReport29() {  return SqlTool.getDbString(report29);  }
    public String getReport29(int size) { return SqlTool.subString(getReport29(), size); }
    public void setReport29(String aReport29) { report29 = aReport29; modifiedFields.add("Report29"); }
    public void assignReport29(String aReport29) { report29 = aReport29; }
    public void paramReport29(HttpServletRequest request) { paramReport29(request, "Report29"); }
    public void paramReport29(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport29()); if (!tmp.equals(getReport29())) { setReport29(tmp); } }
    // 安全工作落实情况总结
    protected String report30 = "";
    public String getReport30() {  return SqlTool.getDbString(report30);  }
    public String getReport30(int size) { return SqlTool.subString(getReport30(), size); }
    public void setReport30(String aReport30) { report30 = aReport30; modifiedFields.add("Report30"); }
    public void assignReport30(String aReport30) { report30 = aReport30; }
    public void paramReport30(HttpServletRequest request) { paramReport30(request, "Report30"); }
    public void paramReport30(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport30()); if (!tmp.equals(getReport30())) { setReport30(tmp); } }
    // 添加人
    protected String addaccount = "";
    public String getAddaccount() {  return SqlTool.getDbString(addaccount);  }
    public String getAddaccount(int size) { return SqlTool.subString(getAddaccount(), size); }
    public void setAddaccount(String aAddaccount) { addaccount = aAddaccount; modifiedFields.add("Addaccount"); }
    public void assignAddaccount(String aAddaccount) { addaccount = aAddaccount; }
    public void paramAddaccount(HttpServletRequest request) { paramAddaccount(request, "Addaccount"); }
    public void paramAddaccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddaccount()); if (!tmp.equals(getAddaccount())) { setAddaccount(tmp); } }
    // 添加时间
    protected String addtime = "";
    public String getAddtime() {  return SqlTool.getDbString(addtime);  }
    public String getAddtime(int size) { return SqlTool.subString(getAddtime(), size); }
    public void setAddtime(String aAddtime) { addtime = aAddtime; modifiedFields.add("Addtime"); }
    public void assignAddtime(String aAddtime) { addtime = aAddtime; }
    public void paramAddtime(HttpServletRequest request) { paramAddtime(request, "Addtime"); }
    public void paramAddtime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddtime()); if (!tmp.equals(getAddtime())) { setAddtime(tmp); } }
    // 备用
    protected String remark = "";
    public String getRemark() {  return SqlTool.getDbString(remark);  }
    public String getRemark(int size) { return SqlTool.subString(getRemark(), size); }
    public void setRemark(String aRemark) { remark = aRemark; modifiedFields.add("Remark"); }
    public void assignRemark(String aRemark) { remark = aRemark; }
    public void paramRemark(HttpServletRequest request) { paramRemark(request, "Remark"); }
    public void paramRemark(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark()); if (!tmp.equals(getRemark())) { setRemark(tmp); } }
    // 备用
    protected String remark2 = "";
    public String getRemark2() {  return SqlTool.getDbString(remark2);  }
    public String getRemark2(int size) { return SqlTool.subString(getRemark2(), size); }
    public void setRemark2(String aRemark2) { remark2 = aRemark2; modifiedFields.add("Remark2"); }
    public void assignRemark2(String aRemark2) { remark2 = aRemark2; }
    public void paramRemark2(HttpServletRequest request) { paramRemark2(request, "Remark2"); }
    public void paramRemark2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark2()); if (!tmp.equals(getRemark2())) { setRemark2(tmp); } }
    // 备用
    protected String remark3 = "";
    public String getRemark3() {  return SqlTool.getDbString(remark3);  }
    public String getRemark3(int size) { return SqlTool.subString(getRemark3(), size); }
    public void setRemark3(String aRemark3) { remark3 = aRemark3; modifiedFields.add("Remark3"); }
    public void assignRemark3(String aRemark3) { remark3 = aRemark3; }
    public void paramRemark3(HttpServletRequest request) { paramRemark3(request, "Remark3"); }
    public void paramRemark3(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark3()); if (!tmp.equals(getRemark3())) { setRemark3(tmp); } }
    // 备用
    protected String remark4 = "";
    public String getRemark4() {  return SqlTool.getDbString(remark4);  }
    public String getRemark4(int size) { return SqlTool.subString(getRemark4(), size); }
    public void setRemark4(String aRemark4) { remark4 = aRemark4; modifiedFields.add("Remark4"); }
    public void assignRemark4(String aRemark4) { remark4 = aRemark4; }
    public void paramRemark4(HttpServletRequest request) { paramRemark4(request, "Remark4"); }
    public void paramRemark4(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark4()); if (!tmp.equals(getRemark4())) { setRemark4(tmp); } }
    // 备用
    protected String remark5 = "";
    public String getRemark5() {  return SqlTool.getDbString(remark5);  }
    public String getRemark5(int size) { return SqlTool.subString(getRemark5(), size); }
    public void setRemark5(String aRemark5) { remark5 = aRemark5; modifiedFields.add("Remark5"); }
    public void assignRemark5(String aRemark5) { remark5 = aRemark5; }
    public void paramRemark5(HttpServletRequest request) { paramRemark5(request, "Remark5"); }
    public void paramRemark5(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark5()); if (!tmp.equals(getRemark5())) { setRemark5(tmp); } }
    // 备用
    protected String remark6 = "";
    public String getRemark6() {  return SqlTool.getDbString(remark6);  }
    public String getRemark6(int size) { return SqlTool.subString(getRemark6(), size); }
    public void setRemark6(String aRemark6) { remark6 = aRemark6; modifiedFields.add("Remark6"); }
    public void assignRemark6(String aRemark6) { remark6 = aRemark6; }
    public void paramRemark6(HttpServletRequest request) { paramRemark6(request, "Remark6"); }
    public void paramRemark6(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark6()); if (!tmp.equals(getRemark6())) { setRemark6(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public PracticeReport (String db) {
        DBNAME = db;
    }
    public PracticeReport (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public PracticeReport (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public PracticeReport () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return PracticeReport类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public PracticeReport getByParameter(HttpServletRequest request) {
        PracticeReport v = new PracticeReport(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramDeclareId(request);
        paramType(request);
        paramTeamId(request);
        paramMemberid(request);
        paramPracticeId(request);
        paramAcademy(request);
        paramAddFilelist(request);
        paramXyCheckFlag(request);
        paramTwCheckFlag(request);
        paramSubmitFlag(request);
        paramXyHonour(request);
        paramReport1(request);
        paramReport2(request);
        paramReport3(request);
        paramReport4(request);
        paramReport5(request);
        paramReport6(request);
        paramReport12(request);
        paramReport13(request);
        paramReport14(request);
        paramReport15(request);
        paramStartTime(request);
        paramEndTime(request);
        paramReport17(request);
        paramReport18(request);
        paramReport19(request);
        paramReport20(request);
        paramReport23(request);
        paramReport24(request);
        paramReport25(request);
        paramReport26(request);
        paramReport27(request);
        paramReport28(request);
        paramReport29(request);
        paramReport30(request);
        paramAddaccount(request);
        paramAddtime(request);
        paramRemark(request);
        paramRemark2(request);
        paramRemark3(request);
        paramRemark4(request);
        paramRemark5(request);
        paramRemark6(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(PracticeReport bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("declareId")) { setDeclareId(bean.getDeclareId()); }
        if (!ncl.contains("type")) { setType(bean.getType()); }
        if (!ncl.contains("teamId")) { setTeamId(bean.getTeamId()); }
        if (!ncl.contains("memberid")) { setMemberid(bean.getMemberid()); }
        if (!ncl.contains("practiceId")) { setPracticeId(bean.getPracticeId()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("addFilelist")) { setAddFilelist(bean.getAddFilelist()); }
        if (!ncl.contains("xyCheckFlag")) { setXyCheckFlag(bean.getXyCheckFlag()); }
        if (!ncl.contains("twCheckFlag")) { setTwCheckFlag(bean.getTwCheckFlag()); }
        if (!ncl.contains("submitFlag")) { setSubmitFlag(bean.getSubmitFlag()); }
        if (!ncl.contains("xyHonour")) { setXyHonour(bean.getXyHonour()); }
        if (!ncl.contains("report1")) { setReport1(bean.getReport1()); }
        if (!ncl.contains("report2")) { setReport2(bean.getReport2()); }
        if (!ncl.contains("report3")) { setReport3(bean.getReport3()); }
        if (!ncl.contains("report4")) { setReport4(bean.getReport4()); }
        if (!ncl.contains("report5")) { setReport5(bean.getReport5()); }
        if (!ncl.contains("report6")) { setReport6(bean.getReport6()); }
        if (!ncl.contains("report12")) { setReport12(bean.getReport12()); }
        if (!ncl.contains("report13")) { setReport13(bean.getReport13()); }
        if (!ncl.contains("report14")) { setReport14(bean.getReport14()); }
        if (!ncl.contains("report15")) { setReport15(bean.getReport15()); }
        if (!ncl.contains("startTime")) { setStartTime(bean.getStartTime()); }
        if (!ncl.contains("endTime")) { setEndTime(bean.getEndTime()); }
        if (!ncl.contains("report17")) { setReport17(bean.getReport17()); }
        if (!ncl.contains("report18")) { setReport18(bean.getReport18()); }
        if (!ncl.contains("report19")) { setReport19(bean.getReport19()); }
        if (!ncl.contains("report20")) { setReport20(bean.getReport20()); }
        if (!ncl.contains("report23")) { setReport23(bean.getReport23()); }
        if (!ncl.contains("report24")) { setReport24(bean.getReport24()); }
        if (!ncl.contains("report25")) { setReport25(bean.getReport25()); }
        if (!ncl.contains("report26")) { setReport26(bean.getReport26()); }
        if (!ncl.contains("report27")) { setReport27(bean.getReport27()); }
        if (!ncl.contains("report28")) { setReport28(bean.getReport28()); }
        if (!ncl.contains("report29")) { setReport29(bean.getReport29()); }
        if (!ncl.contains("report30")) { setReport30(bean.getReport30()); }
        if (!ncl.contains("addaccount")) { setAddaccount(bean.getAddaccount()); }
        if (!ncl.contains("addtime")) { setAddtime(bean.getAddtime()); }
        if (!ncl.contains("remark")) { setRemark(bean.getRemark()); }
        if (!ncl.contains("remark2")) { setRemark2(bean.getRemark2()); }
        if (!ncl.contains("remark3")) { setRemark3(bean.getRemark3()); }
        if (!ncl.contains("remark4")) { setRemark4(bean.getRemark4()); }
        if (!ncl.contains("remark5")) { setRemark5(bean.getRemark5()); }
        if (!ncl.contains("remark6")) { setRemark6(bean.getRemark6()); }
    }
    public PracticeReport getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        PracticeReport[] rslt= queryByCondition(cdt);
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
     * @return PracticeReport类的实例列表。
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
                PracticeReport ve = new PracticeReport(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignDeclareId(rs.getInt(2));
                ve.assignType(rs.getInt(3));
                ve.assignTeamId(fromDbCh(rs.getString(4)));
                ve.assignMemberid(fromDbCh(rs.getString(5)));
                ve.assignPracticeId(rs.getInt(6));
                ve.assignAcademy(fromDbCh(rs.getString(7)));
                ve.assignAddFilelist(fromDbCh(rs.getString(8)));
                ve.assignXyCheckFlag(rs.getInt(9));
                ve.assignTwCheckFlag(rs.getInt(10));
                ve.assignSubmitFlag(rs.getInt(11));
                ve.assignXyHonour(fromDbCh(rs.getString(12)));
                ve.assignReport1(fromDbCh(rs.getString(13)));
                ve.assignReport2(fromDbCh(rs.getString(14)));
                ve.assignReport3(fromDbCh(rs.getString(15)));
                ve.assignReport4(fromDbCh(rs.getString(16)));
                ve.assignReport5(fromDbCh(rs.getString(17)));
                ve.assignReport6(fromDbCh(rs.getString(18)));
                ve.assignReport12(fromDbCh(rs.getString(19)));
                ve.assignReport13(fromDbCh(rs.getString(20)));
                ve.assignReport14(fromDbCh(rs.getString(21)));
                ve.assignReport15(fromDbCh(rs.getString(22)));
                ve.assignStartTime(fromDbCh(rs.getString(23)));
                ve.assignEndTime(fromDbCh(rs.getString(24)));
                ve.assignReport17(fromDbCh(rs.getString(25)));
                ve.assignReport18(fromDbCh(rs.getString(26)));
                ve.assignReport19(fromDbCh(rs.getString(27)));
                ve.assignReport20(fromDbCh(rs.getString(28)));
                ve.assignReport23(fromDbCh(rs.getString(29)));
                ve.assignReport24(fromDbCh(rs.getString(30)));
                ve.assignReport25(fromDbCh(rs.getString(31)));
                ve.assignReport26(fromDbCh(rs.getString(32)));
                ve.assignReport27(fromDbCh(rs.getString(33)));
                ve.assignReport28(fromDbCh(rs.getString(34)));
                ve.assignReport29(fromDbCh(rs.getString(35)));
                ve.assignReport30(fromDbCh(rs.getString(36)));
                ve.assignAddaccount(fromDbCh(rs.getString(37)));
                ve.assignAddtime(fromDbCh(rs.getString(38)));
                ve.assignRemark(fromDbCh(rs.getString(39)));
                ve.assignRemark2(fromDbCh(rs.getString(40)));
                ve.assignRemark3(fromDbCh(rs.getString(41)));
                ve.assignRemark4(fromDbCh(rs.getString(42)));
                ve.assignRemark5(fromDbCh(rs.getString(43)));
                ve.assignRemark6(fromDbCh(rs.getString(44)));
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
    public PracticeReport[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (PracticeReport[])vrs.toArray(new PracticeReport[vrs.size()]);
    }
    public PracticeReport[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (PracticeReport[])vrs.toArray(new PracticeReport[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (declareid,type,teamid,memberid,practiceid,academy,addfilelist,xycheckflag,twcheckflag,submitflag,xyhonour,report1,report2,report3,report4,report5,report6,report12,report13,report14,report15,starttime,endtime,report17,report18,report19,report20,report23,report24,report25,report26,report27,report28,report29,report30,addaccount,addtime,remark,remark2,remark3,remark4,remark5,remark6) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, declareId);
            pstmt.setInt(2, type);
            pstmt.setString(3, toDbCh(teamId));
            pstmt.setString(4, toDbCh(memberid));
            pstmt.setInt(5, practiceId);
            pstmt.setString(6, toDbCh(academy));
            pstmt.setString(7, toDbCh(addFilelist));
            pstmt.setInt(8, xyCheckFlag);
            pstmt.setInt(9, twCheckFlag);
            pstmt.setInt(10, submitFlag);
            pstmt.setString(11, toDbCh(xyHonour));
            pstmt.setString(12, toDbCh(report1));
            pstmt.setString(13, toDbCh(report2));
            pstmt.setString(14, toDbCh(report3));
            pstmt.setString(15, toDbCh(report4));
            pstmt.setString(16, toDbCh(report5));
            pstmt.setString(17, toDbCh(report6));
            pstmt.setString(18, toDbCh(report12));
            pstmt.setString(19, toDbCh(report13));
            pstmt.setString(20, toDbCh(report14));
            pstmt.setString(21, toDbCh(report15));
            pstmt.setString(22, toDbCh(startTime));
            pstmt.setString(23, toDbCh(endTime));
            pstmt.setString(24, toDbCh(report17));
            pstmt.setString(25, toDbCh(report18));
            pstmt.setString(26, toDbCh(report19));
            pstmt.setString(27, toDbCh(report20));
            pstmt.setString(28, toDbCh(report23));
            pstmt.setString(29, toDbCh(report24));
            pstmt.setString(30, toDbCh(report25));
            pstmt.setString(31, toDbCh(report26));
            pstmt.setString(32, toDbCh(report27));
            pstmt.setString(33, toDbCh(report28));
            pstmt.setString(34, toDbCh(report29));
            pstmt.setString(35, toDbCh(report30));
            pstmt.setString(36, toDbCh(addaccount));
            pstmt.setString(37, toDbCh(addtime));
            pstmt.setString(38, toDbCh(remark));
            pstmt.setString(39, toDbCh(remark2));
            pstmt.setString(40, toDbCh(remark3));
            pstmt.setString(41, toDbCh(remark4));
            pstmt.setString(42, toDbCh(remark5));
            pstmt.setString(43, toDbCh(remark6));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,declareid,type,teamid,memberid,practiceid,academy,addfilelist,xycheckflag,twcheckflag,submitflag,xyhonour,report1,report2,report3,report4,report5,report6,report12,report13,report14,report15,starttime,endtime,report17,report18,report19,report20,report23,report24,report25,report26,report27,report28,report29,report30,addaccount,addtime,remark,remark2,remark3,remark4,remark5,remark6) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, declareId);
            pstmt.setInt(3, type);
            pstmt.setString(4, toDbCh(teamId));
            pstmt.setString(5, toDbCh(memberid));
            pstmt.setInt(6, practiceId);
            pstmt.setString(7, toDbCh(academy));
            pstmt.setString(8, toDbCh(addFilelist));
            pstmt.setInt(9, xyCheckFlag);
            pstmt.setInt(10, twCheckFlag);
            pstmt.setInt(11, submitFlag);
            pstmt.setString(12, toDbCh(xyHonour));
            pstmt.setString(13, toDbCh(report1));
            pstmt.setString(14, toDbCh(report2));
            pstmt.setString(15, toDbCh(report3));
            pstmt.setString(16, toDbCh(report4));
            pstmt.setString(17, toDbCh(report5));
            pstmt.setString(18, toDbCh(report6));
            pstmt.setString(19, toDbCh(report12));
            pstmt.setString(20, toDbCh(report13));
            pstmt.setString(21, toDbCh(report14));
            pstmt.setString(22, toDbCh(report15));
            pstmt.setString(23, toDbCh(startTime));
            pstmt.setString(24, toDbCh(endTime));
            pstmt.setString(25, toDbCh(report17));
            pstmt.setString(26, toDbCh(report18));
            pstmt.setString(27, toDbCh(report19));
            pstmt.setString(28, toDbCh(report20));
            pstmt.setString(29, toDbCh(report23));
            pstmt.setString(30, toDbCh(report24));
            pstmt.setString(31, toDbCh(report25));
            pstmt.setString(32, toDbCh(report26));
            pstmt.setString(33, toDbCh(report27));
            pstmt.setString(34, toDbCh(report28));
            pstmt.setString(35, toDbCh(report29));
            pstmt.setString(36, toDbCh(report30));
            pstmt.setString(37, toDbCh(addaccount));
            pstmt.setString(38, toDbCh(addtime));
            pstmt.setString(39, toDbCh(remark));
            pstmt.setString(40, toDbCh(remark2));
            pstmt.setString(41, toDbCh(remark3));
            pstmt.setString(42, toDbCh(remark4));
            pstmt.setString(43, toDbCh(remark5));
            pstmt.setString(44, toDbCh(remark6));
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
            PracticeReport item = (PracticeReport)it.next();
            PracticeReport v = new PracticeReport(dbname);
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
                if (modifiedFields.contains("DeclareId")) { pstmt.setInt(pi ++, declareId); }
                if (modifiedFields.contains("Type")) { pstmt.setInt(pi ++, type); }
                if (modifiedFields.contains("TeamId")) { pstmt.setString(pi ++, toDbCh(teamId)); }
                if (modifiedFields.contains("Memberid")) { pstmt.setString(pi ++, toDbCh(memberid)); }
                if (modifiedFields.contains("PracticeId")) { pstmt.setInt(pi ++, practiceId); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("AddFilelist")) { pstmt.setString(pi ++, toDbCh(addFilelist)); }
                if (modifiedFields.contains("XyCheckFlag")) { pstmt.setInt(pi ++, xyCheckFlag); }
                if (modifiedFields.contains("TwCheckFlag")) { pstmt.setInt(pi ++, twCheckFlag); }
                if (modifiedFields.contains("SubmitFlag")) { pstmt.setInt(pi ++, submitFlag); }
                if (modifiedFields.contains("XyHonour")) { pstmt.setString(pi ++, toDbCh(xyHonour)); }
                if (modifiedFields.contains("Report1")) { pstmt.setString(pi ++, toDbCh(report1)); }
                if (modifiedFields.contains("Report2")) { pstmt.setString(pi ++, toDbCh(report2)); }
                if (modifiedFields.contains("Report3")) { pstmt.setString(pi ++, toDbCh(report3)); }
                if (modifiedFields.contains("Report4")) { pstmt.setString(pi ++, toDbCh(report4)); }
                if (modifiedFields.contains("Report5")) { pstmt.setString(pi ++, toDbCh(report5)); }
                if (modifiedFields.contains("Report6")) { pstmt.setString(pi ++, toDbCh(report6)); }
                if (modifiedFields.contains("Report12")) { pstmt.setString(pi ++, toDbCh(report12)); }
                if (modifiedFields.contains("Report13")) { pstmt.setString(pi ++, toDbCh(report13)); }
                if (modifiedFields.contains("Report14")) { pstmt.setString(pi ++, toDbCh(report14)); }
                if (modifiedFields.contains("Report15")) { pstmt.setString(pi ++, toDbCh(report15)); }
                if (modifiedFields.contains("StartTime")) { pstmt.setString(pi ++, toDbCh(startTime)); }
                if (modifiedFields.contains("EndTime")) { pstmt.setString(pi ++, toDbCh(endTime)); }
                if (modifiedFields.contains("Report17")) { pstmt.setString(pi ++, toDbCh(report17)); }
                if (modifiedFields.contains("Report18")) { pstmt.setString(pi ++, toDbCh(report18)); }
                if (modifiedFields.contains("Report19")) { pstmt.setString(pi ++, toDbCh(report19)); }
                if (modifiedFields.contains("Report20")) { pstmt.setString(pi ++, toDbCh(report20)); }
                if (modifiedFields.contains("Report23")) { pstmt.setString(pi ++, toDbCh(report23)); }
                if (modifiedFields.contains("Report24")) { pstmt.setString(pi ++, toDbCh(report24)); }
                if (modifiedFields.contains("Report25")) { pstmt.setString(pi ++, toDbCh(report25)); }
                if (modifiedFields.contains("Report26")) { pstmt.setString(pi ++, toDbCh(report26)); }
                if (modifiedFields.contains("Report27")) { pstmt.setString(pi ++, toDbCh(report27)); }
                if (modifiedFields.contains("Report28")) { pstmt.setString(pi ++, toDbCh(report28)); }
                if (modifiedFields.contains("Report29")) { pstmt.setString(pi ++, toDbCh(report29)); }
                if (modifiedFields.contains("Report30")) { pstmt.setString(pi ++, toDbCh(report30)); }
                if (modifiedFields.contains("Addaccount")) { pstmt.setString(pi ++, toDbCh(addaccount)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setString(pi ++, toDbCh(addtime)); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("Remark2")) { pstmt.setString(pi ++, toDbCh(remark2)); }
                if (modifiedFields.contains("Remark3")) { pstmt.setString(pi ++, toDbCh(remark3)); }
                if (modifiedFields.contains("Remark4")) { pstmt.setString(pi ++, toDbCh(remark4)); }
                if (modifiedFields.contains("Remark5")) { pstmt.setString(pi ++, toDbCh(remark5)); }
                if (modifiedFields.contains("Remark6")) { pstmt.setString(pi ++, toDbCh(remark6)); }
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
                if (modifiedFields.contains("DeclareId")) { pstmt.setInt(pi ++, declareId); }
                if (modifiedFields.contains("Type")) { pstmt.setInt(pi ++, type); }
                if (modifiedFields.contains("TeamId")) { pstmt.setString(pi ++, toDbCh(teamId)); }
                if (modifiedFields.contains("Memberid")) { pstmt.setString(pi ++, toDbCh(memberid)); }
                if (modifiedFields.contains("PracticeId")) { pstmt.setInt(pi ++, practiceId); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("AddFilelist")) { pstmt.setString(pi ++, toDbCh(addFilelist)); }
                if (modifiedFields.contains("XyCheckFlag")) { pstmt.setInt(pi ++, xyCheckFlag); }
                if (modifiedFields.contains("TwCheckFlag")) { pstmt.setInt(pi ++, twCheckFlag); }
                if (modifiedFields.contains("SubmitFlag")) { pstmt.setInt(pi ++, submitFlag); }
                if (modifiedFields.contains("XyHonour")) { pstmt.setString(pi ++, toDbCh(xyHonour)); }
                if (modifiedFields.contains("Report1")) { pstmt.setString(pi ++, toDbCh(report1)); }
                if (modifiedFields.contains("Report2")) { pstmt.setString(pi ++, toDbCh(report2)); }
                if (modifiedFields.contains("Report3")) { pstmt.setString(pi ++, toDbCh(report3)); }
                if (modifiedFields.contains("Report4")) { pstmt.setString(pi ++, toDbCh(report4)); }
                if (modifiedFields.contains("Report5")) { pstmt.setString(pi ++, toDbCh(report5)); }
                if (modifiedFields.contains("Report6")) { pstmt.setString(pi ++, toDbCh(report6)); }
                if (modifiedFields.contains("Report12")) { pstmt.setString(pi ++, toDbCh(report12)); }
                if (modifiedFields.contains("Report13")) { pstmt.setString(pi ++, toDbCh(report13)); }
                if (modifiedFields.contains("Report14")) { pstmt.setString(pi ++, toDbCh(report14)); }
                if (modifiedFields.contains("Report15")) { pstmt.setString(pi ++, toDbCh(report15)); }
                if (modifiedFields.contains("StartTime")) { pstmt.setString(pi ++, toDbCh(startTime)); }
                if (modifiedFields.contains("EndTime")) { pstmt.setString(pi ++, toDbCh(endTime)); }
                if (modifiedFields.contains("Report17")) { pstmt.setString(pi ++, toDbCh(report17)); }
                if (modifiedFields.contains("Report18")) { pstmt.setString(pi ++, toDbCh(report18)); }
                if (modifiedFields.contains("Report19")) { pstmt.setString(pi ++, toDbCh(report19)); }
                if (modifiedFields.contains("Report20")) { pstmt.setString(pi ++, toDbCh(report20)); }
                if (modifiedFields.contains("Report23")) { pstmt.setString(pi ++, toDbCh(report23)); }
                if (modifiedFields.contains("Report24")) { pstmt.setString(pi ++, toDbCh(report24)); }
                if (modifiedFields.contains("Report25")) { pstmt.setString(pi ++, toDbCh(report25)); }
                if (modifiedFields.contains("Report26")) { pstmt.setString(pi ++, toDbCh(report26)); }
                if (modifiedFields.contains("Report27")) { pstmt.setString(pi ++, toDbCh(report27)); }
                if (modifiedFields.contains("Report28")) { pstmt.setString(pi ++, toDbCh(report28)); }
                if (modifiedFields.contains("Report29")) { pstmt.setString(pi ++, toDbCh(report29)); }
                if (modifiedFields.contains("Report30")) { pstmt.setString(pi ++, toDbCh(report30)); }
                if (modifiedFields.contains("Addaccount")) { pstmt.setString(pi ++, toDbCh(addaccount)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setString(pi ++, toDbCh(addtime)); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("Remark2")) { pstmt.setString(pi ++, toDbCh(remark2)); }
                if (modifiedFields.contains("Remark3")) { pstmt.setString(pi ++, toDbCh(remark3)); }
                if (modifiedFields.contains("Remark4")) { pstmt.setString(pi ++, toDbCh(remark4)); }
                if (modifiedFields.contains("Remark5")) { pstmt.setString(pi ++, toDbCh(remark5)); }
                if (modifiedFields.contains("Remark6")) { pstmt.setString(pi ++, toDbCh(remark6)); }
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
        map.put("DeclareId", getDeclareId() + "");
        map.put("Type", getType() + "");
        map.put("TeamId", getTeamId());
        map.put("Memberid", getMemberid());
        map.put("PracticeId", getPracticeId() + "");
        map.put("Academy", getAcademy());
        map.put("AddFilelist", getAddFilelist());
        map.put("XyCheckFlag", getXyCheckFlag() + "");
        map.put("TwCheckFlag", getTwCheckFlag() + "");
        map.put("SubmitFlag", getSubmitFlag() + "");
        map.put("XyHonour", getXyHonour());
        map.put("Report1", getReport1());
        map.put("Report2", getReport2());
        map.put("Report3", getReport3());
        map.put("Report4", getReport4());
        map.put("Report5", getReport5());
        map.put("Report6", getReport6());
        map.put("Report12", getReport12());
        map.put("Report13", getReport13());
        map.put("Report14", getReport14());
        map.put("Report15", getReport15());
        map.put("StartTime", getStartTime());
        map.put("EndTime", getEndTime());
        map.put("Report17", getReport17());
        map.put("Report18", getReport18());
        map.put("Report19", getReport19());
        map.put("Report20", getReport20());
        map.put("Report23", getReport23());
        map.put("Report24", getReport24());
        map.put("Report25", getReport25());
        map.put("Report26", getReport26());
        map.put("Report27", getReport27());
        map.put("Report28", getReport28());
        map.put("Report29", getReport29());
        map.put("Report30", getReport30());
        map.put("Addaccount", getAddaccount());
        map.put("Addtime", getAddtime());
        map.put("Remark", getRemark());
        map.put("Remark2", getRemark2());
        map.put("Remark3", getRemark3());
        map.put("Remark4", getRemark4());
        map.put("Remark5", getRemark5());
        map.put("Remark6", getRemark6());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("DeclareId:\"" + getDeclareId() + "\"");
        row.add("Type:\"" + getType() + "\"");
        row.add("TeamId:\"" + Tool.jsSpecialChars(getTeamId()) + "\"");
        row.add("Memberid:\"" + Tool.jsSpecialChars(getMemberid()) + "\"");
        row.add("PracticeId:\"" + getPracticeId() + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("AddFilelist:\"" + Tool.jsSpecialChars(getAddFilelist()) + "\"");
        row.add("XyCheckFlag:\"" + getXyCheckFlag() + "\"");
        row.add("TwCheckFlag:\"" + getTwCheckFlag() + "\"");
        row.add("SubmitFlag:\"" + getSubmitFlag() + "\"");
        row.add("XyHonour:\"" + Tool.jsSpecialChars(getXyHonour()) + "\"");
        row.add("Report1:\"" + Tool.jsSpecialChars(getReport1()) + "\"");
        row.add("Report2:\"" + Tool.jsSpecialChars(getReport2()) + "\"");
        row.add("Report3:\"" + Tool.jsSpecialChars(getReport3()) + "\"");
        row.add("Report4:\"" + Tool.jsSpecialChars(getReport4()) + "\"");
        row.add("Report5:\"" + Tool.jsSpecialChars(getReport5()) + "\"");
        row.add("Report6:\"" + Tool.jsSpecialChars(getReport6()) + "\"");
        row.add("Report12:\"" + Tool.jsSpecialChars(getReport12()) + "\"");
        row.add("Report13:\"" + Tool.jsSpecialChars(getReport13()) + "\"");
        row.add("Report14:\"" + Tool.jsSpecialChars(getReport14()) + "\"");
        row.add("Report15:\"" + Tool.jsSpecialChars(getReport15()) + "\"");
        row.add("StartTime:\"" + Tool.jsSpecialChars(getStartTime()) + "\"");
        row.add("EndTime:\"" + Tool.jsSpecialChars(getEndTime()) + "\"");
        row.add("Report17:\"" + Tool.jsSpecialChars(getReport17()) + "\"");
        row.add("Report18:\"" + Tool.jsSpecialChars(getReport18()) + "\"");
        row.add("Report19:\"" + Tool.jsSpecialChars(getReport19()) + "\"");
        row.add("Report20:\"" + Tool.jsSpecialChars(getReport20()) + "\"");
        row.add("Report23:\"" + Tool.jsSpecialChars(getReport23()) + "\"");
        row.add("Report24:\"" + Tool.jsSpecialChars(getReport24()) + "\"");
        row.add("Report25:\"" + Tool.jsSpecialChars(getReport25()) + "\"");
        row.add("Report26:\"" + Tool.jsSpecialChars(getReport26()) + "\"");
        row.add("Report27:\"" + Tool.jsSpecialChars(getReport27()) + "\"");
        row.add("Report28:\"" + Tool.jsSpecialChars(getReport28()) + "\"");
        row.add("Report29:\"" + Tool.jsSpecialChars(getReport29()) + "\"");
        row.add("Report30:\"" + Tool.jsSpecialChars(getReport30()) + "\"");
        row.add("Addaccount:\"" + Tool.jsSpecialChars(getAddaccount()) + "\"");
        row.add("Addtime:\"" + Tool.jsSpecialChars(getAddtime()) + "\"");
        row.add("Remark:\"" + Tool.jsSpecialChars(getRemark()) + "\"");
        row.add("Remark2:\"" + Tool.jsSpecialChars(getRemark2()) + "\"");
        row.add("Remark3:\"" + Tool.jsSpecialChars(getRemark3()) + "\"");
        row.add("Remark4:\"" + Tool.jsSpecialChars(getRemark4()) + "\"");
        row.add("Remark5:\"" + Tool.jsSpecialChars(getRemark5()) + "\"");
        row.add("Remark6:\"" + Tool.jsSpecialChars(getRemark6()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,declareid number(*,0),type number(*,0),teamid varchar2(45),memberid varchar2(45),practiceid number(*,0),academy varchar2(45),addfilelist varchar2(255),xycheckflag number(*,0),twcheckflag number(*,0),submitflag number(*,0),xyhonour varchar2(45),report1 varchar2(45),report2 varchar2(45),report3 varchar2(45),report4 varchar2(45),report5 varchar2(45),report6 varchar2(45),report12 varchar2(45),report13 varchar2(45),report14 varchar2(45),report15 varchar2(45),starttime varchar2(45),endtime varchar2(45),report17 varchar2(45),report18 varchar2(45),report19 varchar2(255),report20 varchar2(45),report23 varchar2(45),report24 varchar2(45),report25 varchar2(45),report26 varchar2(1000),report27 varchar2(1000),report28 varchar2(1000),report29 varchar2(45),report30 varchar2(1000),addaccount varchar2(45),addtime varchar2(45),remark varchar2(45),remark2 varchar2(45),remark3 varchar2(45),remark4 varchar2(45),remark5 varchar2(45),remark6 varchar2(45))"});
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
        PracticeReport v = new PracticeReport(sourceDb, sourceTb);
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
        PracticeReport v = new PracticeReport(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(PracticeReport obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getDeclareId()).compareTo("" + obj.getDeclareId()); if (rtn != 0) return rtn;
        rtn = ("" + getType()).compareTo("" + obj.getType()); if (rtn != 0) return rtn;
        rtn = getTeamId().compareTo(obj.getTeamId()); if (rtn != 0) return rtn;
        rtn = getMemberid().compareTo(obj.getMemberid()); if (rtn != 0) return rtn;
        rtn = ("" + getPracticeId()).compareTo("" + obj.getPracticeId()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getAddFilelist().compareTo(obj.getAddFilelist()); if (rtn != 0) return rtn;
        rtn = ("" + getXyCheckFlag()).compareTo("" + obj.getXyCheckFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getTwCheckFlag()).compareTo("" + obj.getTwCheckFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getSubmitFlag()).compareTo("" + obj.getSubmitFlag()); if (rtn != 0) return rtn;
        rtn = getXyHonour().compareTo(obj.getXyHonour()); if (rtn != 0) return rtn;
        rtn = getReport1().compareTo(obj.getReport1()); if (rtn != 0) return rtn;
        rtn = getReport2().compareTo(obj.getReport2()); if (rtn != 0) return rtn;
        rtn = getReport3().compareTo(obj.getReport3()); if (rtn != 0) return rtn;
        rtn = getReport4().compareTo(obj.getReport4()); if (rtn != 0) return rtn;
        rtn = getReport5().compareTo(obj.getReport5()); if (rtn != 0) return rtn;
        rtn = getReport6().compareTo(obj.getReport6()); if (rtn != 0) return rtn;
        rtn = getReport12().compareTo(obj.getReport12()); if (rtn != 0) return rtn;
        rtn = getReport13().compareTo(obj.getReport13()); if (rtn != 0) return rtn;
        rtn = getReport14().compareTo(obj.getReport14()); if (rtn != 0) return rtn;
        rtn = getReport15().compareTo(obj.getReport15()); if (rtn != 0) return rtn;
        rtn = getStartTime().compareTo(obj.getStartTime()); if (rtn != 0) return rtn;
        rtn = getEndTime().compareTo(obj.getEndTime()); if (rtn != 0) return rtn;
        rtn = getReport17().compareTo(obj.getReport17()); if (rtn != 0) return rtn;
        rtn = getReport18().compareTo(obj.getReport18()); if (rtn != 0) return rtn;
        rtn = getReport19().compareTo(obj.getReport19()); if (rtn != 0) return rtn;
        rtn = getReport20().compareTo(obj.getReport20()); if (rtn != 0) return rtn;
        rtn = getReport23().compareTo(obj.getReport23()); if (rtn != 0) return rtn;
        rtn = getReport24().compareTo(obj.getReport24()); if (rtn != 0) return rtn;
        rtn = getReport25().compareTo(obj.getReport25()); if (rtn != 0) return rtn;
        rtn = getReport26().compareTo(obj.getReport26()); if (rtn != 0) return rtn;
        rtn = getReport27().compareTo(obj.getReport27()); if (rtn != 0) return rtn;
        rtn = getReport28().compareTo(obj.getReport28()); if (rtn != 0) return rtn;
        rtn = getReport29().compareTo(obj.getReport29()); if (rtn != 0) return rtn;
        rtn = getReport30().compareTo(obj.getReport30()); if (rtn != 0) return rtn;
        rtn = getAddaccount().compareTo(obj.getAddaccount()); if (rtn != 0) return rtn;
        rtn = getAddtime().compareTo(obj.getAddtime()); if (rtn != 0) return rtn;
        rtn = getRemark().compareTo(obj.getRemark()); if (rtn != 0) return rtn;
        rtn = getRemark2().compareTo(obj.getRemark2()); if (rtn != 0) return rtn;
        rtn = getRemark3().compareTo(obj.getRemark3()); if (rtn != 0) return rtn;
        rtn = getRemark4().compareTo(obj.getRemark4()); if (rtn != 0) return rtn;
        rtn = getRemark5().compareTo(obj.getRemark5()); if (rtn != 0) return rtn;
        rtn = getRemark6().compareTo(obj.getRemark6()); if (rtn != 0) return rtn;
        return rtn;
    }
}
