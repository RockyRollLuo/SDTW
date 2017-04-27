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
@Description("社团成员")
public class ClubMembers implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(ClubMembers.class);
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
    public static final String DbTableName = "club_members";
    private String TNAME = "club_members";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","memberName","memberSex","memberBrith","memberPolitics","memberBirthplace","memberClubname","memberclubcode","memberDuty","memberAcademy","memberMajor","memberGrade","memberEmail","memberPhone","memberqq","memberwx","mProfile","mExperience","mCommentAcademy","mCommentAcatw","addPerson","addTime","modiPerson","modiTime","memberSno","isManager","checkFlag","remark","applyTime","checkTime","identity","applyContent","startDate","stopDate","managerGeneration","commentXy"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","membername","membersex","memberbrith","memberpolitics","memberbirthplace","memberclubname","memberclubcode","memberduty","memberacademy","membermajor","membergrade","memberemail","memberphone","memberqq","memberwx","mprofile","mexperience","mcommentacademy","mcommentacatw","addperson","addtime","modiperson","moditime","membersno","ismanager","checkflag","remark","applytime","checktime","identity","applycontent","startdate","stopdate","managergeneration","commentxy"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"MemberName","membername","String"},{"MemberSex","membersex","String"},{"MemberBrith","memberbrith","String"},{"MemberPolitics","memberpolitics","String"},{"MemberBirthplace","memberbirthplace","String"},{"MemberClubname","memberclubname","String"},{"Memberclubcode","memberclubcode","String"},{"MemberDuty","memberduty","String"},{"MemberAcademy","memberacademy","String"},{"MemberMajor","membermajor","String"},{"MemberGrade","membergrade","String"},{"MemberEmail","memberemail","String"},{"MemberPhone","memberphone","String"},{"Memberqq","memberqq","String"},{"Memberwx","memberwx","String"},{"MProfile","mprofile","String"},{"MExperience","mexperience","String"},{"MCommentAcademy","mcommentacademy","String"},{"MCommentAcatw","mcommentacatw","String"},{"AddPerson","addperson","String"},{"AddTime","addtime","java.util.Date"},{"ModiPerson","modiperson","String"},{"ModiTime","moditime","java.util.Date"},{"MemberSno","membersno","String"},{"IsManager","ismanager","String"},{"CheckFlag","checkflag","int"},{"Remark","remark","String"},{"ApplyTime","applytime","java.util.Date"},{"CheckTime","checktime","java.util.Date"},{"Identity","identity","String"},{"ApplyContent","applycontent","String"},{"StartDate","startdate","java.util.Date"},{"StopDate","stopdate","java.util.Date"},{"ManagerGeneration","managergeneration","int"},{"CommentXy","commentxy","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"memberName","membername"},{"memberSex","membersex"},{"memberBrith","memberbrith"},{"memberPolitics","memberpolitics"},{"memberBirthplace","memberbirthplace"},{"memberClubname","memberclubname"},{"memberclubcode","memberclubcode"},{"memberDuty","memberduty"},{"memberAcademy","memberacademy"},{"memberMajor","membermajor"},{"memberGrade","membergrade"},{"memberEmail","memberemail"},{"memberPhone","memberphone"},{"memberqq","memberqq"},{"memberwx","memberwx"},{"mProfile","mprofile"},{"mExperience","mexperience"},{"mCommentAcademy","mcommentacademy"},{"mCommentAcatw","mcommentacatw"},{"addPerson","addperson"},{"addTime","addtime"},{"modiPerson","modiperson"},{"modiTime","moditime"},{"memberSno","membersno"},{"isManager","ismanager"},{"checkFlag","checkflag"},{"remark","remark"},{"applyTime","applytime"},{"checkTime","checktime"},{"identity","identity"},{"applyContent","applycontent"},{"startDate","startdate"},{"stopDate","stopdate"},{"managerGeneration","managergeneration"},{"commentXy","commentxy"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME","MODITIME","APPLYTIME","CHECKTIME","STARTDATE","STOPDATE"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 姓名
    protected String memberName = "";
    public String getMemberName() {  return SqlTool.getDbString(memberName);  }
    public String getMemberName(int size) { return SqlTool.subString(getMemberName(), size); }
    public void setMemberName(String aMemberName) { memberName = aMemberName; modifiedFields.add("MemberName"); }
    public void assignMemberName(String aMemberName) { memberName = aMemberName; }
    public void paramMemberName(HttpServletRequest request) { paramMemberName(request, "MemberName"); }
    public void paramMemberName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberName()); if (!tmp.equals(getMemberName())) { setMemberName(tmp); } }
    // 性别
    protected String memberSex = "";
    public String getMemberSex() {  return SqlTool.getDbString(memberSex);  }
    public String getMemberSex(int size) { return SqlTool.subString(getMemberSex(), size); }
    public void setMemberSex(String aMemberSex) { memberSex = aMemberSex; modifiedFields.add("MemberSex"); }
    public void assignMemberSex(String aMemberSex) { memberSex = aMemberSex; }
    public void paramMemberSex(HttpServletRequest request) { paramMemberSex(request, "MemberSex"); }
    public void paramMemberSex(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberSex()); if (!tmp.equals(getMemberSex())) { setMemberSex(tmp); } }
    // 生日
    protected String memberBrith = "";
    public String getMemberBrith() {  return SqlTool.getDbString(memberBrith);  }
    public String getMemberBrith(int size) { return SqlTool.subString(getMemberBrith(), size); }
    public void setMemberBrith(String aMemberBrith) { memberBrith = aMemberBrith; modifiedFields.add("MemberBrith"); }
    public void assignMemberBrith(String aMemberBrith) { memberBrith = aMemberBrith; }
    public void paramMemberBrith(HttpServletRequest request) { paramMemberBrith(request, "MemberBrith"); }
    public void paramMemberBrith(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberBrith()); if (!tmp.equals(getMemberBrith())) { setMemberBrith(tmp); } }
    // 政治面貌
    protected String memberPolitics = "";
    public String getMemberPolitics() {  return SqlTool.getDbString(memberPolitics);  }
    public String getMemberPolitics(int size) { return SqlTool.subString(getMemberPolitics(), size); }
    public void setMemberPolitics(String aMemberPolitics) { memberPolitics = aMemberPolitics; modifiedFields.add("MemberPolitics"); }
    public void assignMemberPolitics(String aMemberPolitics) { memberPolitics = aMemberPolitics; }
    public void paramMemberPolitics(HttpServletRequest request) { paramMemberPolitics(request, "MemberPolitics"); }
    public void paramMemberPolitics(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberPolitics()); if (!tmp.equals(getMemberPolitics())) { setMemberPolitics(tmp); } }
    // 籍贯
    protected String memberBirthplace = "";
    public String getMemberBirthplace() {  return SqlTool.getDbString(memberBirthplace);  }
    public String getMemberBirthplace(int size) { return SqlTool.subString(getMemberBirthplace(), size); }
    public void setMemberBirthplace(String aMemberBirthplace) { memberBirthplace = aMemberBirthplace; modifiedFields.add("MemberBirthplace"); }
    public void assignMemberBirthplace(String aMemberBirthplace) { memberBirthplace = aMemberBirthplace; }
    public void paramMemberBirthplace(HttpServletRequest request) { paramMemberBirthplace(request, "MemberBirthplace"); }
    public void paramMemberBirthplace(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberBirthplace()); if (!tmp.equals(getMemberBirthplace())) { setMemberBirthplace(tmp); } }
    // 社团名称
    protected String memberClubname = "";
    public String getMemberClubname() {  return SqlTool.getDbString(memberClubname);  }
    public String getMemberClubname(int size) { return SqlTool.subString(getMemberClubname(), size); }
    public void setMemberClubname(String aMemberClubname) { memberClubname = aMemberClubname; modifiedFields.add("MemberClubname"); }
    public void assignMemberClubname(String aMemberClubname) { memberClubname = aMemberClubname; }
    public void paramMemberClubname(HttpServletRequest request) { paramMemberClubname(request, "MemberClubname"); }
    public void paramMemberClubname(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberClubname()); if (!tmp.equals(getMemberClubname())) { setMemberClubname(tmp); } }
    // 社团code
    protected String memberclubcode = "";
    public String getMemberclubcode() {  return SqlTool.getDbString(memberclubcode);  }
    public String getMemberclubcode(int size) { return SqlTool.subString(getMemberclubcode(), size); }
    public void setMemberclubcode(String aMemberclubcode) { memberclubcode = aMemberclubcode; modifiedFields.add("Memberclubcode"); }
    public void assignMemberclubcode(String aMemberclubcode) { memberclubcode = aMemberclubcode; }
    public void paramMemberclubcode(HttpServletRequest request) { paramMemberclubcode(request, "Memberclubcode"); }
    public void paramMemberclubcode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberclubcode()); if (!tmp.equals(getMemberclubcode())) { setMemberclubcode(tmp); } }
    // 职责
    protected String memberDuty = "";
    public String getMemberDuty() {  return SqlTool.getDbString(memberDuty);  }
    public String getMemberDuty(int size) { return SqlTool.subString(getMemberDuty(), size); }
    public void setMemberDuty(String aMemberDuty) { memberDuty = aMemberDuty; modifiedFields.add("MemberDuty"); }
    public void assignMemberDuty(String aMemberDuty) { memberDuty = aMemberDuty; }
    public void paramMemberDuty(HttpServletRequest request) { paramMemberDuty(request, "MemberDuty"); }
    public void paramMemberDuty(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberDuty()); if (!tmp.equals(getMemberDuty())) { setMemberDuty(tmp); } }
    // 学院
    protected String memberAcademy = "";
    public String getMemberAcademy() {  return SqlTool.getDbString(memberAcademy);  }
    public String getMemberAcademy(int size) { return SqlTool.subString(getMemberAcademy(), size); }
    public void setMemberAcademy(String aMemberAcademy) { memberAcademy = aMemberAcademy; modifiedFields.add("MemberAcademy"); }
    public void assignMemberAcademy(String aMemberAcademy) { memberAcademy = aMemberAcademy; }
    public void paramMemberAcademy(HttpServletRequest request) { paramMemberAcademy(request, "MemberAcademy"); }
    public void paramMemberAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberAcademy()); if (!tmp.equals(getMemberAcademy())) { setMemberAcademy(tmp); } }
    // 专业
    protected String memberMajor = "";
    public String getMemberMajor() {  return SqlTool.getDbString(memberMajor);  }
    public String getMemberMajor(int size) { return SqlTool.subString(getMemberMajor(), size); }
    public void setMemberMajor(String aMemberMajor) { memberMajor = aMemberMajor; modifiedFields.add("MemberMajor"); }
    public void assignMemberMajor(String aMemberMajor) { memberMajor = aMemberMajor; }
    public void paramMemberMajor(HttpServletRequest request) { paramMemberMajor(request, "MemberMajor"); }
    public void paramMemberMajor(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberMajor()); if (!tmp.equals(getMemberMajor())) { setMemberMajor(tmp); } }
    // 年级
    protected String memberGrade = "";
    public String getMemberGrade() {  return SqlTool.getDbString(memberGrade);  }
    public String getMemberGrade(int size) { return SqlTool.subString(getMemberGrade(), size); }
    public void setMemberGrade(String aMemberGrade) { memberGrade = aMemberGrade; modifiedFields.add("MemberGrade"); }
    public void assignMemberGrade(String aMemberGrade) { memberGrade = aMemberGrade; }
    public void paramMemberGrade(HttpServletRequest request) { paramMemberGrade(request, "MemberGrade"); }
    public void paramMemberGrade(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberGrade()); if (!tmp.equals(getMemberGrade())) { setMemberGrade(tmp); } }
    // 邮箱
    protected String memberEmail = "";
    public String getMemberEmail() {  return SqlTool.getDbString(memberEmail);  }
    public String getMemberEmail(int size) { return SqlTool.subString(getMemberEmail(), size); }
    public void setMemberEmail(String aMemberEmail) { memberEmail = aMemberEmail; modifiedFields.add("MemberEmail"); }
    public void assignMemberEmail(String aMemberEmail) { memberEmail = aMemberEmail; }
    public void paramMemberEmail(HttpServletRequest request) { paramMemberEmail(request, "MemberEmail"); }
    public void paramMemberEmail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberEmail()); if (!tmp.equals(getMemberEmail())) { setMemberEmail(tmp); } }
    // 手机
    protected String memberPhone = "";
    public String getMemberPhone() {  return SqlTool.getDbString(memberPhone);  }
    public String getMemberPhone(int size) { return SqlTool.subString(getMemberPhone(), size); }
    public void setMemberPhone(String aMemberPhone) { memberPhone = aMemberPhone; modifiedFields.add("MemberPhone"); }
    public void assignMemberPhone(String aMemberPhone) { memberPhone = aMemberPhone; }
    public void paramMemberPhone(HttpServletRequest request) { paramMemberPhone(request, "MemberPhone"); }
    public void paramMemberPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberPhone()); if (!tmp.equals(getMemberPhone())) { setMemberPhone(tmp); } }
    // QQ
    protected String memberqq = "";
    public String getMemberqq() {  return SqlTool.getDbString(memberqq);  }
    public String getMemberqq(int size) { return SqlTool.subString(getMemberqq(), size); }
    public void setMemberqq(String aMemberqq) { memberqq = aMemberqq; modifiedFields.add("Memberqq"); }
    public void assignMemberqq(String aMemberqq) { memberqq = aMemberqq; }
    public void paramMemberqq(HttpServletRequest request) { paramMemberqq(request, "Memberqq"); }
    public void paramMemberqq(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberqq()); if (!tmp.equals(getMemberqq())) { setMemberqq(tmp); } }
    // 微信
    protected String memberwx = "";
    public String getMemberwx() {  return SqlTool.getDbString(memberwx);  }
    public String getMemberwx(int size) { return SqlTool.subString(getMemberwx(), size); }
    public void setMemberwx(String aMemberwx) { memberwx = aMemberwx; modifiedFields.add("Memberwx"); }
    public void assignMemberwx(String aMemberwx) { memberwx = aMemberwx; }
    public void paramMemberwx(HttpServletRequest request) { paramMemberwx(request, "Memberwx"); }
    public void paramMemberwx(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberwx()); if (!tmp.equals(getMemberwx())) { setMemberwx(tmp); } }
    // 个人简介
    protected String mProfile = "";
    public String getMProfile() {  return SqlTool.getDbString(mProfile);  }
    public String getMProfile(int size) { return SqlTool.subString(getMProfile(), size); }
    public void setMProfile(String aMProfile) { mProfile = aMProfile; modifiedFields.add("MProfile"); }
    public void assignMProfile(String aMProfile) { mProfile = aMProfile; }
    public void paramMProfile(HttpServletRequest request) { paramMProfile(request, "MProfile"); }
    public void paramMProfile(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMProfile()); if (!tmp.equals(getMProfile())) { setMProfile(tmp); } }
    // 社团工作经历
    protected String mExperience = "";
    public String getMExperience() {  return SqlTool.getDbString(mExperience);  }
    public String getMExperience(int size) { return SqlTool.subString(getMExperience(), size); }
    public void setMExperience(String aMExperience) { mExperience = aMExperience; modifiedFields.add("MExperience"); }
    public void assignMExperience(String aMExperience) { mExperience = aMExperience; }
    public void paramMExperience(HttpServletRequest request) { paramMExperience(request, "MExperience"); }
    public void paramMExperience(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMExperience()); if (!tmp.equals(getMExperience())) { setMExperience(tmp); } }
    // 学院意见
    protected String mCommentAcademy = "";
    public String getMCommentAcademy() {  return SqlTool.getDbString(mCommentAcademy);  }
    public String getMCommentAcademy(int size) { return SqlTool.subString(getMCommentAcademy(), size); }
    public void setMCommentAcademy(String aMCommentAcademy) { mCommentAcademy = aMCommentAcademy; modifiedFields.add("MCommentAcademy"); }
    public void assignMCommentAcademy(String aMCommentAcademy) { mCommentAcademy = aMCommentAcademy; }
    public void paramMCommentAcademy(HttpServletRequest request) { paramMCommentAcademy(request, "MCommentAcademy"); }
    public void paramMCommentAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMCommentAcademy()); if (!tmp.equals(getMCommentAcademy())) { setMCommentAcademy(tmp); } }
    // 团委意见
    protected String mCommentAcatw = "";
    public String getMCommentAcatw() {  return SqlTool.getDbString(mCommentAcatw);  }
    public String getMCommentAcatw(int size) { return SqlTool.subString(getMCommentAcatw(), size); }
    public void setMCommentAcatw(String aMCommentAcatw) { mCommentAcatw = aMCommentAcatw; modifiedFields.add("MCommentAcatw"); }
    public void assignMCommentAcatw(String aMCommentAcatw) { mCommentAcatw = aMCommentAcatw; }
    public void paramMCommentAcatw(HttpServletRequest request) { paramMCommentAcatw(request, "MCommentAcatw"); }
    public void paramMCommentAcatw(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMCommentAcatw()); if (!tmp.equals(getMCommentAcatw())) { setMCommentAcatw(tmp); } }
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
    // 学号
    protected String memberSno = "";
    public String getMemberSno() {  return SqlTool.getDbString(memberSno);  }
    public String getMemberSno(int size) { return SqlTool.subString(getMemberSno(), size); }
    public void setMemberSno(String aMemberSno) { memberSno = aMemberSno; modifiedFields.add("MemberSno"); }
    public void assignMemberSno(String aMemberSno) { memberSno = aMemberSno; }
    public void paramMemberSno(HttpServletRequest request) { paramMemberSno(request, "MemberSno"); }
    public void paramMemberSno(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMemberSno()); if (!tmp.equals(getMemberSno())) { setMemberSno(tmp); } }
    // 是否团长
    protected String isManager = "";
    public String getIsManager() {  return SqlTool.getDbString(isManager);  }
    public String getIsManager(int size) { return SqlTool.subString(getIsManager(), size); }
    public void setIsManager(String aIsManager) { isManager = aIsManager; modifiedFields.add("IsManager"); }
    public void assignIsManager(String aIsManager) { isManager = aIsManager; }
    public void paramIsManager(HttpServletRequest request) { paramIsManager(request, "IsManager"); }
    public void paramIsManager(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIsManager()); if (!tmp.equals(getIsManager())) { setIsManager(tmp); } }
    // 是否审核
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
    // 学历
    protected String identity = "";
    public String getIdentity() {  return SqlTool.getDbString(identity);  }
    public String getIdentity(int size) { return SqlTool.subString(getIdentity(), size); }
    public void setIdentity(String aIdentity) { identity = aIdentity; modifiedFields.add("Identity"); }
    public void assignIdentity(String aIdentity) { identity = aIdentity; }
    public void paramIdentity(HttpServletRequest request) { paramIdentity(request, "Identity"); }
    public void paramIdentity(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIdentity()); if (!tmp.equals(getIdentity())) { setIdentity(tmp); } }
    // 个人简介1
    protected String applyContent = "";
    public String getApplyContent() {  return SqlTool.getDbString(applyContent);  }
    public String getApplyContent(int size) { return SqlTool.subString(getApplyContent(), size); }
    public void setApplyContent(String aApplyContent) { applyContent = aApplyContent; modifiedFields.add("ApplyContent"); }
    public void assignApplyContent(String aApplyContent) { applyContent = aApplyContent; }
    public void paramApplyContent(HttpServletRequest request) { paramApplyContent(request, "ApplyContent"); }
    public void paramApplyContent(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getApplyContent()); if (!tmp.equals(getApplyContent())) { setApplyContent(tmp); } }
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
    // 是否元老
    protected int managerGeneration = -1;
    public int getManagerGeneration() { return managerGeneration; }
    public void setManagerGeneration(int aManagerGeneration) { managerGeneration = aManagerGeneration; modifiedFields.add("ManagerGeneration"); }
    public void assignManagerGeneration(int aManagerGeneration) { managerGeneration = aManagerGeneration; }
    public void paramManagerGeneration(HttpServletRequest request) { paramManagerGeneration(request, "ManagerGeneration"); }
    public void paramManagerGeneration(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getManagerGeneration()); if (tmp != getManagerGeneration()) { setManagerGeneration(tmp); } }
    // 指导单位审核意见
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
    public ClubMembers (String db) {
        DBNAME = db;
    }
    public ClubMembers (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public ClubMembers (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public ClubMembers () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return ClubMembers类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public ClubMembers getByParameter(HttpServletRequest request) {
        ClubMembers v = new ClubMembers(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramMemberName(request);
        paramMemberSex(request);
        paramMemberBrith(request);
        paramMemberPolitics(request);
        paramMemberBirthplace(request);
        paramMemberClubname(request);
        paramMemberclubcode(request);
        paramMemberDuty(request);
        paramMemberAcademy(request);
        paramMemberMajor(request);
        paramMemberGrade(request);
        paramMemberEmail(request);
        paramMemberPhone(request);
        paramMemberqq(request);
        paramMemberwx(request);
        paramMProfile(request);
        paramMExperience(request);
        paramMCommentAcademy(request);
        paramMCommentAcatw(request);
        paramAddPerson(request);
        paramAddTime(request);
        paramModiPerson(request);
        paramModiTime(request);
        paramMemberSno(request);
        paramIsManager(request);
        paramCheckFlag(request);
        paramRemark(request);
        paramApplyTime(request);
        paramCheckTime(request);
        paramIdentity(request);
        paramApplyContent(request);
        paramStartDate(request);
        paramStopDate(request);
        paramManagerGeneration(request);
        paramCommentXy(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(ClubMembers bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("memberName")) { setMemberName(bean.getMemberName()); }
        if (!ncl.contains("memberSex")) { setMemberSex(bean.getMemberSex()); }
        if (!ncl.contains("memberBrith")) { setMemberBrith(bean.getMemberBrith()); }
        if (!ncl.contains("memberPolitics")) { setMemberPolitics(bean.getMemberPolitics()); }
        if (!ncl.contains("memberBirthplace")) { setMemberBirthplace(bean.getMemberBirthplace()); }
        if (!ncl.contains("memberClubname")) { setMemberClubname(bean.getMemberClubname()); }
        if (!ncl.contains("memberclubcode")) { setMemberclubcode(bean.getMemberclubcode()); }
        if (!ncl.contains("memberDuty")) { setMemberDuty(bean.getMemberDuty()); }
        if (!ncl.contains("memberAcademy")) { setMemberAcademy(bean.getMemberAcademy()); }
        if (!ncl.contains("memberMajor")) { setMemberMajor(bean.getMemberMajor()); }
        if (!ncl.contains("memberGrade")) { setMemberGrade(bean.getMemberGrade()); }
        if (!ncl.contains("memberEmail")) { setMemberEmail(bean.getMemberEmail()); }
        if (!ncl.contains("memberPhone")) { setMemberPhone(bean.getMemberPhone()); }
        if (!ncl.contains("memberqq")) { setMemberqq(bean.getMemberqq()); }
        if (!ncl.contains("memberwx")) { setMemberwx(bean.getMemberwx()); }
        if (!ncl.contains("mProfile")) { setMProfile(bean.getMProfile()); }
        if (!ncl.contains("mExperience")) { setMExperience(bean.getMExperience()); }
        if (!ncl.contains("mCommentAcademy")) { setMCommentAcademy(bean.getMCommentAcademy()); }
        if (!ncl.contains("mCommentAcatw")) { setMCommentAcatw(bean.getMCommentAcatw()); }
        if (!ncl.contains("addPerson")) { setAddPerson(bean.getAddPerson()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("modiPerson")) { setModiPerson(bean.getModiPerson()); }
        if (!ncl.contains("modiTime")) { setModiTime(bean.getModiTime()); }
        if (!ncl.contains("memberSno")) { setMemberSno(bean.getMemberSno()); }
        if (!ncl.contains("isManager")) { setIsManager(bean.getIsManager()); }
        if (!ncl.contains("checkFlag")) { setCheckFlag(bean.getCheckFlag()); }
        if (!ncl.contains("remark")) { setRemark(bean.getRemark()); }
        if (!ncl.contains("applyTime")) { setApplyTime(bean.getApplyTime()); }
        if (!ncl.contains("checkTime")) { setCheckTime(bean.getCheckTime()); }
        if (!ncl.contains("identity")) { setIdentity(bean.getIdentity()); }
        if (!ncl.contains("applyContent")) { setApplyContent(bean.getApplyContent()); }
        if (!ncl.contains("startDate")) { setStartDate(bean.getStartDate()); }
        if (!ncl.contains("stopDate")) { setStopDate(bean.getStopDate()); }
        if (!ncl.contains("managerGeneration")) { setManagerGeneration(bean.getManagerGeneration()); }
        if (!ncl.contains("commentXy")) { setCommentXy(bean.getCommentXy()); }
    }
    public ClubMembers getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        ClubMembers[] rslt= queryByCondition(cdt);
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
     * @return ClubMembers类的实例列表。
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
                ClubMembers ve = new ClubMembers(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignMemberName(fromDbCh(rs.getString(2)));
                ve.assignMemberSex(fromDbCh(rs.getString(3)));
                ve.assignMemberBrith(fromDbCh(rs.getString(4)));
                ve.assignMemberPolitics(fromDbCh(rs.getString(5)));
                ve.assignMemberBirthplace(fromDbCh(rs.getString(6)));
                ve.assignMemberClubname(fromDbCh(rs.getString(7)));
                ve.assignMemberclubcode(fromDbCh(rs.getString(8)));
                ve.assignMemberDuty(fromDbCh(rs.getString(9)));
                ve.assignMemberAcademy(fromDbCh(rs.getString(10)));
                ve.assignMemberMajor(fromDbCh(rs.getString(11)));
                ve.assignMemberGrade(fromDbCh(rs.getString(12)));
                ve.assignMemberEmail(fromDbCh(rs.getString(13)));
                ve.assignMemberPhone(fromDbCh(rs.getString(14)));
                ve.assignMemberqq(fromDbCh(rs.getString(15)));
                ve.assignMemberwx(fromDbCh(rs.getString(16)));
                ve.assignMProfile(fromDbCh(rs.getString(17)));
                ve.assignMExperience(fromDbCh(rs.getString(18)));
                ve.assignMCommentAcademy(fromDbCh(rs.getString(19)));
                ve.assignMCommentAcatw(fromDbCh(rs.getString(20)));
                ve.assignAddPerson(fromDbCh(rs.getString(21)));
                tmpDate = rs.getTimestamp(22); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignModiPerson(fromDbCh(rs.getString(23)));
                tmpDate = rs.getTimestamp(24); if (tmpDate != null) { ve.assignModiTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignMemberSno(fromDbCh(rs.getString(25)));
                ve.assignIsManager(fromDbCh(rs.getString(26)));
                ve.assignCheckFlag(rs.getInt(27));
                ve.assignRemark(fromDbCh(rs.getString(28)));
                tmpDate = rs.getTimestamp(29); if (tmpDate != null) { ve.assignApplyTime(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(30); if (tmpDate != null) { ve.assignCheckTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignIdentity(fromDbCh(rs.getString(31)));
                ve.assignApplyContent(fromDbCh(rs.getString(32)));
                tmpDate = rs.getTimestamp(33); if (tmpDate != null) { ve.assignStartDate(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(34); if (tmpDate != null) { ve.assignStopDate(new java.util.Date(tmpDate.getTime())); }
                ve.assignManagerGeneration(rs.getInt(35));
                ve.assignCommentXy(fromDbCh(rs.getString(36)));
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
    public ClubMembers[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (ClubMembers[])vrs.toArray(new ClubMembers[vrs.size()]);
    }
    public ClubMembers[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (ClubMembers[])vrs.toArray(new ClubMembers[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (membername,membersex,memberbrith,memberpolitics,memberbirthplace,memberclubname,memberclubcode,memberduty,memberacademy,membermajor,membergrade,memberemail,memberphone,memberqq,memberwx,mprofile,mexperience,mcommentacademy,mcommentacatw,addperson,addtime,modiperson,moditime,membersno,ismanager,checkflag,remark,applytime,checktime,identity,applycontent,startdate,stopdate,managergeneration,commentxy) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(memberName));
            pstmt.setString(2, toDbCh(memberSex));
            pstmt.setString(3, toDbCh(memberBrith));
            pstmt.setString(4, toDbCh(memberPolitics));
            pstmt.setString(5, toDbCh(memberBirthplace));
            pstmt.setString(6, toDbCh(memberClubname));
            pstmt.setString(7, toDbCh(memberclubcode));
            pstmt.setString(8, toDbCh(memberDuty));
            pstmt.setString(9, toDbCh(memberAcademy));
            pstmt.setString(10, toDbCh(memberMajor));
            pstmt.setString(11, toDbCh(memberGrade));
            pstmt.setString(12, toDbCh(memberEmail));
            pstmt.setString(13, toDbCh(memberPhone));
            pstmt.setString(14, toDbCh(memberqq));
            pstmt.setString(15, toDbCh(memberwx));
            pstmt.setString(16, toDbCh(mProfile));
            pstmt.setString(17, toDbCh(mExperience));
            pstmt.setString(18, toDbCh(mCommentAcademy));
            pstmt.setString(19, toDbCh(mCommentAcatw));
            pstmt.setString(20, toDbCh(addPerson));
            pstmt.setTimestamp(21, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(22, toDbCh(modiPerson));
            pstmt.setTimestamp(23, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setString(24, toDbCh(memberSno));
            pstmt.setString(25, toDbCh(isManager));
            pstmt.setInt(26, checkFlag);
            pstmt.setString(27, toDbCh(remark));
            pstmt.setTimestamp(28, new java.sql.Timestamp(applyTime.getTime()));
            pstmt.setTimestamp(29, new java.sql.Timestamp(checkTime.getTime()));
            pstmt.setString(30, toDbCh(identity));
            pstmt.setString(31, toDbCh(applyContent));
            pstmt.setTimestamp(32, new java.sql.Timestamp(startDate.getTime()));
            pstmt.setTimestamp(33, new java.sql.Timestamp(stopDate.getTime()));
            pstmt.setInt(34, managerGeneration);
            pstmt.setString(35, toDbCh(commentXy));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,membername,membersex,memberbrith,memberpolitics,memberbirthplace,memberclubname,memberclubcode,memberduty,memberacademy,membermajor,membergrade,memberemail,memberphone,memberqq,memberwx,mprofile,mexperience,mcommentacademy,mcommentacatw,addperson,addtime,modiperson,moditime,membersno,ismanager,checkflag,remark,applytime,checktime,identity,applycontent,startdate,stopdate,managergeneration,commentxy) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(memberName));
            pstmt.setString(3, toDbCh(memberSex));
            pstmt.setString(4, toDbCh(memberBrith));
            pstmt.setString(5, toDbCh(memberPolitics));
            pstmt.setString(6, toDbCh(memberBirthplace));
            pstmt.setString(7, toDbCh(memberClubname));
            pstmt.setString(8, toDbCh(memberclubcode));
            pstmt.setString(9, toDbCh(memberDuty));
            pstmt.setString(10, toDbCh(memberAcademy));
            pstmt.setString(11, toDbCh(memberMajor));
            pstmt.setString(12, toDbCh(memberGrade));
            pstmt.setString(13, toDbCh(memberEmail));
            pstmt.setString(14, toDbCh(memberPhone));
            pstmt.setString(15, toDbCh(memberqq));
            pstmt.setString(16, toDbCh(memberwx));
            pstmt.setString(17, toDbCh(mProfile));
            pstmt.setString(18, toDbCh(mExperience));
            pstmt.setString(19, toDbCh(mCommentAcademy));
            pstmt.setString(20, toDbCh(mCommentAcatw));
            pstmt.setString(21, toDbCh(addPerson));
            pstmt.setTimestamp(22, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(23, toDbCh(modiPerson));
            pstmt.setTimestamp(24, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setString(25, toDbCh(memberSno));
            pstmt.setString(26, toDbCh(isManager));
            pstmt.setInt(27, checkFlag);
            pstmt.setString(28, toDbCh(remark));
            pstmt.setTimestamp(29, new java.sql.Timestamp(applyTime.getTime()));
            pstmt.setTimestamp(30, new java.sql.Timestamp(checkTime.getTime()));
            pstmt.setString(31, toDbCh(identity));
            pstmt.setString(32, toDbCh(applyContent));
            pstmt.setTimestamp(33, new java.sql.Timestamp(startDate.getTime()));
            pstmt.setTimestamp(34, new java.sql.Timestamp(stopDate.getTime()));
            pstmt.setInt(35, managerGeneration);
            pstmt.setString(36, toDbCh(commentXy));
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
            ClubMembers item = (ClubMembers)it.next();
            ClubMembers v = new ClubMembers(dbname);
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
                if (modifiedFields.contains("MemberName")) { pstmt.setString(pi ++, toDbCh(memberName)); }
                if (modifiedFields.contains("MemberSex")) { pstmt.setString(pi ++, toDbCh(memberSex)); }
                if (modifiedFields.contains("MemberBrith")) { pstmt.setString(pi ++, toDbCh(memberBrith)); }
                if (modifiedFields.contains("MemberPolitics")) { pstmt.setString(pi ++, toDbCh(memberPolitics)); }
                if (modifiedFields.contains("MemberBirthplace")) { pstmt.setString(pi ++, toDbCh(memberBirthplace)); }
                if (modifiedFields.contains("MemberClubname")) { pstmt.setString(pi ++, toDbCh(memberClubname)); }
                if (modifiedFields.contains("Memberclubcode")) { pstmt.setString(pi ++, toDbCh(memberclubcode)); }
                if (modifiedFields.contains("MemberDuty")) { pstmt.setString(pi ++, toDbCh(memberDuty)); }
                if (modifiedFields.contains("MemberAcademy")) { pstmt.setString(pi ++, toDbCh(memberAcademy)); }
                if (modifiedFields.contains("MemberMajor")) { pstmt.setString(pi ++, toDbCh(memberMajor)); }
                if (modifiedFields.contains("MemberGrade")) { pstmt.setString(pi ++, toDbCh(memberGrade)); }
                if (modifiedFields.contains("MemberEmail")) { pstmt.setString(pi ++, toDbCh(memberEmail)); }
                if (modifiedFields.contains("MemberPhone")) { pstmt.setString(pi ++, toDbCh(memberPhone)); }
                if (modifiedFields.contains("Memberqq")) { pstmt.setString(pi ++, toDbCh(memberqq)); }
                if (modifiedFields.contains("Memberwx")) { pstmt.setString(pi ++, toDbCh(memberwx)); }
                if (modifiedFields.contains("MProfile")) { pstmt.setString(pi ++, toDbCh(mProfile)); }
                if (modifiedFields.contains("MExperience")) { pstmt.setString(pi ++, toDbCh(mExperience)); }
                if (modifiedFields.contains("MCommentAcademy")) { pstmt.setString(pi ++, toDbCh(mCommentAcademy)); }
                if (modifiedFields.contains("MCommentAcatw")) { pstmt.setString(pi ++, toDbCh(mCommentAcatw)); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("MemberSno")) { pstmt.setString(pi ++, toDbCh(memberSno)); }
                if (modifiedFields.contains("IsManager")) { pstmt.setString(pi ++, toDbCh(isManager)); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("ApplyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(applyTime.getTime())); }
                if (modifiedFields.contains("CheckTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(checkTime.getTime())); }
                if (modifiedFields.contains("Identity")) { pstmt.setString(pi ++, toDbCh(identity)); }
                if (modifiedFields.contains("ApplyContent")) { pstmt.setString(pi ++, toDbCh(applyContent)); }
                if (modifiedFields.contains("StartDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(startDate.getTime())); }
                if (modifiedFields.contains("StopDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(stopDate.getTime())); }
                if (modifiedFields.contains("ManagerGeneration")) { pstmt.setInt(pi ++, managerGeneration); }
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
                if (modifiedFields.contains("MemberName")) { pstmt.setString(pi ++, toDbCh(memberName)); }
                if (modifiedFields.contains("MemberSex")) { pstmt.setString(pi ++, toDbCh(memberSex)); }
                if (modifiedFields.contains("MemberBrith")) { pstmt.setString(pi ++, toDbCh(memberBrith)); }
                if (modifiedFields.contains("MemberPolitics")) { pstmt.setString(pi ++, toDbCh(memberPolitics)); }
                if (modifiedFields.contains("MemberBirthplace")) { pstmt.setString(pi ++, toDbCh(memberBirthplace)); }
                if (modifiedFields.contains("MemberClubname")) { pstmt.setString(pi ++, toDbCh(memberClubname)); }
                if (modifiedFields.contains("Memberclubcode")) { pstmt.setString(pi ++, toDbCh(memberclubcode)); }
                if (modifiedFields.contains("MemberDuty")) { pstmt.setString(pi ++, toDbCh(memberDuty)); }
                if (modifiedFields.contains("MemberAcademy")) { pstmt.setString(pi ++, toDbCh(memberAcademy)); }
                if (modifiedFields.contains("MemberMajor")) { pstmt.setString(pi ++, toDbCh(memberMajor)); }
                if (modifiedFields.contains("MemberGrade")) { pstmt.setString(pi ++, toDbCh(memberGrade)); }
                if (modifiedFields.contains("MemberEmail")) { pstmt.setString(pi ++, toDbCh(memberEmail)); }
                if (modifiedFields.contains("MemberPhone")) { pstmt.setString(pi ++, toDbCh(memberPhone)); }
                if (modifiedFields.contains("Memberqq")) { pstmt.setString(pi ++, toDbCh(memberqq)); }
                if (modifiedFields.contains("Memberwx")) { pstmt.setString(pi ++, toDbCh(memberwx)); }
                if (modifiedFields.contains("MProfile")) { pstmt.setString(pi ++, toDbCh(mProfile)); }
                if (modifiedFields.contains("MExperience")) { pstmt.setString(pi ++, toDbCh(mExperience)); }
                if (modifiedFields.contains("MCommentAcademy")) { pstmt.setString(pi ++, toDbCh(mCommentAcademy)); }
                if (modifiedFields.contains("MCommentAcatw")) { pstmt.setString(pi ++, toDbCh(mCommentAcatw)); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("MemberSno")) { pstmt.setString(pi ++, toDbCh(memberSno)); }
                if (modifiedFields.contains("IsManager")) { pstmt.setString(pi ++, toDbCh(isManager)); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("ApplyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(applyTime.getTime())); }
                if (modifiedFields.contains("CheckTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(checkTime.getTime())); }
                if (modifiedFields.contains("Identity")) { pstmt.setString(pi ++, toDbCh(identity)); }
                if (modifiedFields.contains("ApplyContent")) { pstmt.setString(pi ++, toDbCh(applyContent)); }
                if (modifiedFields.contains("StartDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(startDate.getTime())); }
                if (modifiedFields.contains("StopDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(stopDate.getTime())); }
                if (modifiedFields.contains("ManagerGeneration")) { pstmt.setInt(pi ++, managerGeneration); }
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
        map.put("MemberName", getMemberName());
        map.put("MemberSex", getMemberSex());
        map.put("MemberBrith", getMemberBrith());
        map.put("MemberPolitics", getMemberPolitics());
        map.put("MemberBirthplace", getMemberBirthplace());
        map.put("MemberClubname", getMemberClubname());
        map.put("Memberclubcode", getMemberclubcode());
        map.put("MemberDuty", getMemberDuty());
        map.put("MemberAcademy", getMemberAcademy());
        map.put("MemberMajor", getMemberMajor());
        map.put("MemberGrade", getMemberGrade());
        map.put("MemberEmail", getMemberEmail());
        map.put("MemberPhone", getMemberPhone());
        map.put("Memberqq", getMemberqq());
        map.put("Memberwx", getMemberwx());
        map.put("MProfile", getMProfile());
        map.put("MExperience", getMExperience());
        map.put("MCommentAcademy", getMCommentAcademy());
        map.put("MCommentAcatw", getMCommentAcatw());
        map.put("AddPerson", getAddPerson());
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("ModiPerson", getModiPerson());
        map.put("ModiTime", Tool.stringOfDateTime(getModiTime()));
        map.put("MemberSno", getMemberSno());
        map.put("IsManager", getIsManager());
        map.put("CheckFlag", getCheckFlag() + "");
        map.put("Remark", getRemark());
        map.put("ApplyTime", Tool.stringOfDateTime(getApplyTime()));
        map.put("CheckTime", Tool.stringOfDateTime(getCheckTime()));
        map.put("Identity", getIdentity());
        map.put("ApplyContent", getApplyContent());
        map.put("StartDate", Tool.stringOfDateTime(getStartDate()));
        map.put("StopDate", Tool.stringOfDateTime(getStopDate()));
        map.put("ManagerGeneration", getManagerGeneration() + "");
        map.put("CommentXy", getCommentXy());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("MemberName:\"" + Tool.jsSpecialChars(getMemberName()) + "\"");
        row.add("MemberSex:\"" + Tool.jsSpecialChars(getMemberSex()) + "\"");
        row.add("MemberBrith:\"" + Tool.jsSpecialChars(getMemberBrith()) + "\"");
        row.add("MemberPolitics:\"" + Tool.jsSpecialChars(getMemberPolitics()) + "\"");
        row.add("MemberBirthplace:\"" + Tool.jsSpecialChars(getMemberBirthplace()) + "\"");
        row.add("MemberClubname:\"" + Tool.jsSpecialChars(getMemberClubname()) + "\"");
        row.add("Memberclubcode:\"" + Tool.jsSpecialChars(getMemberclubcode()) + "\"");
        row.add("MemberDuty:\"" + Tool.jsSpecialChars(getMemberDuty()) + "\"");
        row.add("MemberAcademy:\"" + Tool.jsSpecialChars(getMemberAcademy()) + "\"");
        row.add("MemberMajor:\"" + Tool.jsSpecialChars(getMemberMajor()) + "\"");
        row.add("MemberGrade:\"" + Tool.jsSpecialChars(getMemberGrade()) + "\"");
        row.add("MemberEmail:\"" + Tool.jsSpecialChars(getMemberEmail()) + "\"");
        row.add("MemberPhone:\"" + Tool.jsSpecialChars(getMemberPhone()) + "\"");
        row.add("Memberqq:\"" + Tool.jsSpecialChars(getMemberqq()) + "\"");
        row.add("Memberwx:\"" + Tool.jsSpecialChars(getMemberwx()) + "\"");
        row.add("MProfile:\"" + Tool.jsSpecialChars(getMProfile()) + "\"");
        row.add("MExperience:\"" + Tool.jsSpecialChars(getMExperience()) + "\"");
        row.add("MCommentAcademy:\"" + Tool.jsSpecialChars(getMCommentAcademy()) + "\"");
        row.add("MCommentAcatw:\"" + Tool.jsSpecialChars(getMCommentAcatw()) + "\"");
        row.add("AddPerson:\"" + Tool.jsSpecialChars(getAddPerson()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("ModiPerson:\"" + Tool.jsSpecialChars(getModiPerson()) + "\"");
        row.add("ModiTime:\"" + Tool.stringOfDateTime(getModiTime()) + "\"");
        row.add("MemberSno:\"" + Tool.jsSpecialChars(getMemberSno()) + "\"");
        row.add("IsManager:\"" + Tool.jsSpecialChars(getIsManager()) + "\"");
        row.add("CheckFlag:\"" + getCheckFlag() + "\"");
        row.add("Remark:\"" + Tool.jsSpecialChars(getRemark()) + "\"");
        row.add("ApplyTime:\"" + Tool.stringOfDateTime(getApplyTime()) + "\"");
        row.add("CheckTime:\"" + Tool.stringOfDateTime(getCheckTime()) + "\"");
        row.add("Identity:\"" + Tool.jsSpecialChars(getIdentity()) + "\"");
        row.add("ApplyContent:\"" + Tool.jsSpecialChars(getApplyContent()) + "\"");
        row.add("StartDate:\"" + Tool.stringOfDateTime(getStartDate()) + "\"");
        row.add("StopDate:\"" + Tool.stringOfDateTime(getStopDate()) + "\"");
        row.add("ManagerGeneration:\"" + getManagerGeneration() + "\"");
        row.add("CommentXy:\"" + Tool.jsSpecialChars(getCommentXy()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,membername varchar2(45),membersex varchar2(10),memberbrith varchar2(10),memberpolitics varchar2(45),memberbirthplace varchar2(50),memberclubname varchar2(45),memberclubcode varchar2(10),memberduty varchar2(50),memberacademy varchar2(45),membermajor varchar2(45),membergrade varchar2(10),memberemail varchar2(45),memberphone varchar2(45),memberqq varchar2(45),memberwx varchar2(45),mprofile varchar2(500),mexperience varchar2(500),mcommentacademy varchar2(500),mcommentacatw varchar2(500),addperson varchar2(50),addtime date,modiperson varchar2(50),moditime date,membersno varchar2(45),ismanager varchar2(45),checkflag number(*,0),remark varchar2(500),applytime date,checktime date,identity varchar2(45),applycontent varchar2(500),startdate date,stopdate date,managergeneration number(*,0),commentxy varchar2(500))"});
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
        ClubMembers v = new ClubMembers(sourceDb, sourceTb);
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
        ClubMembers v = new ClubMembers(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(ClubMembers obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getMemberName().compareTo(obj.getMemberName()); if (rtn != 0) return rtn;
        rtn = getMemberSex().compareTo(obj.getMemberSex()); if (rtn != 0) return rtn;
        rtn = getMemberBrith().compareTo(obj.getMemberBrith()); if (rtn != 0) return rtn;
        rtn = getMemberPolitics().compareTo(obj.getMemberPolitics()); if (rtn != 0) return rtn;
        rtn = getMemberBirthplace().compareTo(obj.getMemberBirthplace()); if (rtn != 0) return rtn;
        rtn = getMemberClubname().compareTo(obj.getMemberClubname()); if (rtn != 0) return rtn;
        rtn = getMemberclubcode().compareTo(obj.getMemberclubcode()); if (rtn != 0) return rtn;
        rtn = getMemberDuty().compareTo(obj.getMemberDuty()); if (rtn != 0) return rtn;
        rtn = getMemberAcademy().compareTo(obj.getMemberAcademy()); if (rtn != 0) return rtn;
        rtn = getMemberMajor().compareTo(obj.getMemberMajor()); if (rtn != 0) return rtn;
        rtn = getMemberGrade().compareTo(obj.getMemberGrade()); if (rtn != 0) return rtn;
        rtn = getMemberEmail().compareTo(obj.getMemberEmail()); if (rtn != 0) return rtn;
        rtn = getMemberPhone().compareTo(obj.getMemberPhone()); if (rtn != 0) return rtn;
        rtn = getMemberqq().compareTo(obj.getMemberqq()); if (rtn != 0) return rtn;
        rtn = getMemberwx().compareTo(obj.getMemberwx()); if (rtn != 0) return rtn;
        rtn = getMProfile().compareTo(obj.getMProfile()); if (rtn != 0) return rtn;
        rtn = getMExperience().compareTo(obj.getMExperience()); if (rtn != 0) return rtn;
        rtn = getMCommentAcademy().compareTo(obj.getMCommentAcademy()); if (rtn != 0) return rtn;
        rtn = getMCommentAcatw().compareTo(obj.getMCommentAcatw()); if (rtn != 0) return rtn;
        rtn = getAddPerson().compareTo(obj.getAddPerson()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = getModiPerson().compareTo(obj.getModiPerson()); if (rtn != 0) return rtn;
        rtn = getModiTime().compareTo(obj.getModiTime()); if (rtn != 0) return rtn;
        rtn = getMemberSno().compareTo(obj.getMemberSno()); if (rtn != 0) return rtn;
        rtn = getIsManager().compareTo(obj.getIsManager()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckFlag()).compareTo("" + obj.getCheckFlag()); if (rtn != 0) return rtn;
        rtn = getRemark().compareTo(obj.getRemark()); if (rtn != 0) return rtn;
        rtn = getApplyTime().compareTo(obj.getApplyTime()); if (rtn != 0) return rtn;
        rtn = getCheckTime().compareTo(obj.getCheckTime()); if (rtn != 0) return rtn;
        rtn = getIdentity().compareTo(obj.getIdentity()); if (rtn != 0) return rtn;
        rtn = getApplyContent().compareTo(obj.getApplyContent()); if (rtn != 0) return rtn;
        rtn = getStartDate().compareTo(obj.getStartDate()); if (rtn != 0) return rtn;
        rtn = getStopDate().compareTo(obj.getStopDate()); if (rtn != 0) return rtn;
        rtn = ("" + getManagerGeneration()).compareTo("" + obj.getManagerGeneration()); if (rtn != 0) return rtn;
        rtn = getCommentXy().compareTo(obj.getCommentXy()); if (rtn != 0) return rtn;
        return rtn;
    }
}
