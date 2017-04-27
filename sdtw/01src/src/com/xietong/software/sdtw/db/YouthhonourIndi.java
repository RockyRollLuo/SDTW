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
@Description("五四评比表彰个人申请表")
public class YouthhonourIndi implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(YouthhonourIndi.class);
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
    public static final String DbTableName = "youthhonourindi";
    private String TNAME = "youthhonourindi";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","schoolYear","type","addAccount","addTime","xyCheckFlag","twCheckFlag","modifyFlag","xyReport","twReport","xyCheckDate","twCheckDate","belongAcademy","sno","name","academy","grade","major","sex","nation","sNative","photo","birthday","polistatu","phone","zhibu","duty","workUnit","volstaTime","volservTime","clubName","clubType","joinClubInfo1","joinClubInfo2","clubInfo","education","workExp","resume","award"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","schoolyear","type","addaccount","addtime","xycheckflag","twcheckflag","modifyflag","xyreport","twreport","xycheckdate","twcheckdate","belongacademy","sno","name","academy","grade","major","sex","nation","snative","photo","birthday","polistatu","phone","zhibu","duty","workunit","volstatime","volservtime","clubname","clubtype","joinclubinfo1","joinclubinfo2","clubinfo","education","workexp","resume","award"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"SchoolYear","schoolyear","String"},{"Type","type","int"},{"AddAccount","addaccount","String"},{"AddTime","addtime","java.util.Date"},{"XyCheckFlag","xycheckflag","int"},{"TwCheckFlag","twcheckflag","int"},{"ModifyFlag","modifyflag","int"},{"XyReport","xyreport","int"},{"TwReport","twreport","int"},{"XyCheckDate","xycheckdate","java.util.Date"},{"TwCheckDate","twcheckdate","java.util.Date"},{"BelongAcademy","belongacademy","String"},{"Sno","sno","String"},{"Name","name","String"},{"Academy","academy","String"},{"Grade","grade","String"},{"Major","major","String"},{"Sex","sex","String"},{"Nation","nation","String"},{"SNative","snative","String"},{"Photo","photo","String"},{"Birthday","birthday","String"},{"Polistatu","polistatu","String"},{"Phone","phone","String"},{"Zhibu","zhibu","String"},{"Duty","duty","String"},{"WorkUnit","workunit","String"},{"VolstaTime","volstatime","String"},{"VolservTime","volservtime","String"},{"ClubName","clubname","String"},{"ClubType","clubtype","String"},{"JoinClubInfo1","joinclubinfo1","String"},{"JoinClubInfo2","joinclubinfo2","String"},{"ClubInfo","clubinfo","String"},{"Education","education","String"},{"WorkExp","workexp","String"},{"Resume","resume","String"},{"Award","award","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"schoolYear","schoolyear"},{"type","type"},{"addAccount","addaccount"},{"addTime","addtime"},{"xyCheckFlag","xycheckflag"},{"twCheckFlag","twcheckflag"},{"modifyFlag","modifyflag"},{"xyReport","xyreport"},{"twReport","twreport"},{"xyCheckDate","xycheckdate"},{"twCheckDate","twcheckdate"},{"belongAcademy","belongacademy"},{"sno","sno"},{"name","name"},{"academy","academy"},{"grade","grade"},{"major","major"},{"sex","sex"},{"nation","nation"},{"sNative","snative"},{"photo","photo"},{"birthday","birthday"},{"polistatu","polistatu"},{"phone","phone"},{"zhibu","zhibu"},{"duty","duty"},{"workUnit","workunit"},{"volstaTime","volstatime"},{"volservTime","volservtime"},{"clubName","clubname"},{"clubType","clubtype"},{"joinClubInfo1","joinclubinfo1"},{"joinClubInfo2","joinclubinfo2"},{"clubInfo","clubinfo"},{"education","education"},{"workExp","workexp"},{"resume","resume"},{"award","award"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME","XYCHECKDATE","TWCHECKDATE"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 学年
    protected String schoolYear = "";
    public String getSchoolYear() {  return SqlTool.getDbString(schoolYear);  }
    public String getSchoolYear(int size) { return SqlTool.subString(getSchoolYear(), size); }
    public void setSchoolYear(String aSchoolYear) { schoolYear = aSchoolYear; modifiedFields.add("SchoolYear"); }
    public void assignSchoolYear(String aSchoolYear) { schoolYear = aSchoolYear; }
    public void paramSchoolYear(HttpServletRequest request) { paramSchoolYear(request, "SchoolYear"); }
    public void paramSchoolYear(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSchoolYear()); if (!tmp.equals(getSchoolYear())) { setSchoolYear(tmp); } }
    // 申请表类型
    protected int type = -1;
    public int getType() { return type; }
    public void setType(int aType) { type = aType; modifiedFields.add("Type"); }
    public void assignType(int aType) { type = aType; }
    public void paramType(HttpServletRequest request) { paramType(request, "Type"); }
    public void paramType(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getType()); if (tmp != getType()) { setType(tmp); } }
    // 添加账号
    protected String addAccount = "";
    public String getAddAccount() {  return SqlTool.getDbString(addAccount);  }
    public String getAddAccount(int size) { return SqlTool.subString(getAddAccount(), size); }
    public void setAddAccount(String aAddAccount) { addAccount = aAddAccount; modifiedFields.add("AddAccount"); }
    public void assignAddAccount(String aAddAccount) { addAccount = aAddAccount; }
    public void paramAddAccount(HttpServletRequest request) { paramAddAccount(request, "AddAccount"); }
    public void paramAddAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddAccount()); if (!tmp.equals(getAddAccount())) { setAddAccount(tmp); } }
    // 添加时间
    protected java.util.Date addTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddTime() { return addTime; }
    public void setAddTime(java.util.Date aAddTime) { addTime = aAddTime; modifiedFields.add("AddTime"); }
    public void assignAddTime(java.util.Date aAddTime) { addTime = aAddTime; }
    public void paramAddTime(HttpServletRequest request) { paramAddTime(request, "AddTime"); }
    public void paramAddTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddTime()); if (tmp.compareTo(getAddTime()) != 0) { setAddTime(tmp); } }
    // 学院审核标志
    protected int xyCheckFlag = -1;
    public int getXyCheckFlag() { return xyCheckFlag; }
    public void setXyCheckFlag(int aXyCheckFlag) { xyCheckFlag = aXyCheckFlag; modifiedFields.add("XyCheckFlag"); }
    public void assignXyCheckFlag(int aXyCheckFlag) { xyCheckFlag = aXyCheckFlag; }
    public void paramXyCheckFlag(HttpServletRequest request) { paramXyCheckFlag(request, "XyCheckFlag"); }
    public void paramXyCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getXyCheckFlag()); if (tmp != getXyCheckFlag()) { setXyCheckFlag(tmp); } }
    // 团委审核标志
    protected int twCheckFlag = -1;
    public int getTwCheckFlag() { return twCheckFlag; }
    public void setTwCheckFlag(int aTwCheckFlag) { twCheckFlag = aTwCheckFlag; modifiedFields.add("TwCheckFlag"); }
    public void assignTwCheckFlag(int aTwCheckFlag) { twCheckFlag = aTwCheckFlag; }
    public void paramTwCheckFlag(HttpServletRequest request) { paramTwCheckFlag(request, "TwCheckFlag"); }
    public void paramTwCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getTwCheckFlag()); if (tmp != getTwCheckFlag()) { setTwCheckFlag(tmp); } }
    // 是否可修改标志
    protected int modifyFlag = -1;
    public int getModifyFlag() { return modifyFlag; }
    public void setModifyFlag(int aModifyFlag) { modifyFlag = aModifyFlag; modifiedFields.add("ModifyFlag"); }
    public void assignModifyFlag(int aModifyFlag) { modifyFlag = aModifyFlag; }
    public void paramModifyFlag(HttpServletRequest request) { paramModifyFlag(request, "ModifyFlag"); }
    public void paramModifyFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getModifyFlag()); if (tmp != getModifyFlag()) { setModifyFlag(tmp); } }
    // 学院提交标志
    protected int xyReport = -1;
    public int getXyReport() { return xyReport; }
    public void setXyReport(int aXyReport) { xyReport = aXyReport; modifiedFields.add("XyReport"); }
    public void assignXyReport(int aXyReport) { xyReport = aXyReport; }
    public void paramXyReport(HttpServletRequest request) { paramXyReport(request, "XyReport"); }
    public void paramXyReport(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getXyReport()); if (tmp != getXyReport()) { setXyReport(tmp); } }
    // 团委发布标志
    protected int twReport = -1;
    public int getTwReport() { return twReport; }
    public void setTwReport(int aTwReport) { twReport = aTwReport; modifiedFields.add("TwReport"); }
    public void assignTwReport(int aTwReport) { twReport = aTwReport; }
    public void paramTwReport(HttpServletRequest request) { paramTwReport(request, "TwReport"); }
    public void paramTwReport(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getTwReport()); if (tmp != getTwReport()) { setTwReport(tmp); } }
    // 学院审核时间
    protected java.util.Date xyCheckDate = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getXyCheckDate() { return xyCheckDate; }
    public void setXyCheckDate(java.util.Date aXyCheckDate) { xyCheckDate = aXyCheckDate; modifiedFields.add("XyCheckDate"); }
    public void assignXyCheckDate(java.util.Date aXyCheckDate) { xyCheckDate = aXyCheckDate; }
    public void paramXyCheckDate(HttpServletRequest request) { paramXyCheckDate(request, "XyCheckDate"); }
    public void paramXyCheckDate(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getXyCheckDate()); if (tmp.compareTo(getXyCheckDate()) != 0) { setXyCheckDate(tmp); } }
    // 团委审核时间
    protected java.util.Date twCheckDate = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getTwCheckDate() { return twCheckDate; }
    public void setTwCheckDate(java.util.Date aTwCheckDate) { twCheckDate = aTwCheckDate; modifiedFields.add("TwCheckDate"); }
    public void assignTwCheckDate(java.util.Date aTwCheckDate) { twCheckDate = aTwCheckDate; }
    public void paramTwCheckDate(HttpServletRequest request) { paramTwCheckDate(request, "TwCheckDate"); }
    public void paramTwCheckDate(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getTwCheckDate()); if (tmp.compareTo(getTwCheckDate()) != 0) { setTwCheckDate(tmp); } }
    // 所属单位
    protected String belongAcademy = "";
    public String getBelongAcademy() {  return SqlTool.getDbString(belongAcademy);  }
    public String getBelongAcademy(int size) { return SqlTool.subString(getBelongAcademy(), size); }
    public void setBelongAcademy(String aBelongAcademy) { belongAcademy = aBelongAcademy; modifiedFields.add("BelongAcademy"); }
    public void assignBelongAcademy(String aBelongAcademy) { belongAcademy = aBelongAcademy; }
    public void paramBelongAcademy(HttpServletRequest request) { paramBelongAcademy(request, "BelongAcademy"); }
    public void paramBelongAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getBelongAcademy()); if (!tmp.equals(getBelongAcademy())) { setBelongAcademy(tmp); } }
    // 学号
    protected String sno = "";
    public String getSno() {  return SqlTool.getDbString(sno);  }
    public String getSno(int size) { return SqlTool.subString(getSno(), size); }
    public void setSno(String aSno) { sno = aSno; modifiedFields.add("Sno"); }
    public void assignSno(String aSno) { sno = aSno; }
    public void paramSno(HttpServletRequest request) { paramSno(request, "Sno"); }
    public void paramSno(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSno()); if (!tmp.equals(getSno())) { setSno(tmp); } }
    // 姓名
    protected String name = "";
    public String getName() {  return SqlTool.getDbString(name);  }
    public String getName(int size) { return SqlTool.subString(getName(), size); }
    public void setName(String aName) { name = aName; modifiedFields.add("Name"); }
    public void assignName(String aName) { name = aName; }
    public void paramName(HttpServletRequest request) { paramName(request, "Name"); }
    public void paramName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getName()); if (!tmp.equals(getName())) { setName(tmp); } }
    // 学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 年级
    protected String grade = "";
    public String getGrade() {  return SqlTool.getDbString(grade);  }
    public String getGrade(int size) { return SqlTool.subString(getGrade(), size); }
    public void setGrade(String aGrade) { grade = aGrade; modifiedFields.add("Grade"); }
    public void assignGrade(String aGrade) { grade = aGrade; }
    public void paramGrade(HttpServletRequest request) { paramGrade(request, "Grade"); }
    public void paramGrade(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGrade()); if (!tmp.equals(getGrade())) { setGrade(tmp); } }
    // 专业
    protected String major = "";
    public String getMajor() {  return SqlTool.getDbString(major);  }
    public String getMajor(int size) { return SqlTool.subString(getMajor(), size); }
    public void setMajor(String aMajor) { major = aMajor; modifiedFields.add("Major"); }
    public void assignMajor(String aMajor) { major = aMajor; }
    public void paramMajor(HttpServletRequest request) { paramMajor(request, "Major"); }
    public void paramMajor(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMajor()); if (!tmp.equals(getMajor())) { setMajor(tmp); } }
    // 性别
    protected String sex = "";
    public String getSex() {  return SqlTool.getDbString(sex);  }
    public String getSex(int size) { return SqlTool.subString(getSex(), size); }
    public void setSex(String aSex) { sex = aSex; modifiedFields.add("Sex"); }
    public void assignSex(String aSex) { sex = aSex; }
    public void paramSex(HttpServletRequest request) { paramSex(request, "Sex"); }
    public void paramSex(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSex()); if (!tmp.equals(getSex())) { setSex(tmp); } }
    // 民族
    protected String nation = "";
    public String getNation() {  return SqlTool.getDbString(nation);  }
    public String getNation(int size) { return SqlTool.subString(getNation(), size); }
    public void setNation(String aNation) { nation = aNation; modifiedFields.add("Nation"); }
    public void assignNation(String aNation) { nation = aNation; }
    public void paramNation(HttpServletRequest request) { paramNation(request, "Nation"); }
    public void paramNation(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getNation()); if (!tmp.equals(getNation())) { setNation(tmp); } }
    // 籍贯
    protected String sNative = "";
    public String getSNative() {  return SqlTool.getDbString(sNative);  }
    public String getSNative(int size) { return SqlTool.subString(getSNative(), size); }
    public void setSNative(String aSNative) { sNative = aSNative; modifiedFields.add("SNative"); }
    public void assignSNative(String aSNative) { sNative = aSNative; }
    public void paramSNative(HttpServletRequest request) { paramSNative(request, "SNative"); }
    public void paramSNative(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSNative()); if (!tmp.equals(getSNative())) { setSNative(tmp); } }
    // 照片
    protected String photo = "";
    public String getPhoto() {  return SqlTool.getDbString(photo);  }
    public String getPhoto(int size) { return SqlTool.subString(getPhoto(), size); }
    public void setPhoto(String aPhoto) { photo = aPhoto; modifiedFields.add("Photo"); }
    public void assignPhoto(String aPhoto) { photo = aPhoto; }
    public void paramPhoto(HttpServletRequest request) { paramPhoto(request, "Photo"); }
    public void paramPhoto(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPhoto()); if (!tmp.equals(getPhoto())) { setPhoto(tmp); } }
    // 出生年月
    protected String birthday = "";
    public String getBirthday() {  return SqlTool.getDbString(birthday);  }
    public String getBirthday(int size) { return SqlTool.subString(getBirthday(), size); }
    public void setBirthday(String aBirthday) { birthday = aBirthday; modifiedFields.add("Birthday"); }
    public void assignBirthday(String aBirthday) { birthday = aBirthday; }
    public void paramBirthday(HttpServletRequest request) { paramBirthday(request, "Birthday"); }
    public void paramBirthday(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getBirthday()); if (!tmp.equals(getBirthday())) { setBirthday(tmp); } }
    // 政治面貌
    protected String polistatu = "";
    public String getPolistatu() {  return SqlTool.getDbString(polistatu);  }
    public String getPolistatu(int size) { return SqlTool.subString(getPolistatu(), size); }
    public void setPolistatu(String aPolistatu) { polistatu = aPolistatu; modifiedFields.add("Polistatu"); }
    public void assignPolistatu(String aPolistatu) { polistatu = aPolistatu; }
    public void paramPolistatu(HttpServletRequest request) { paramPolistatu(request, "Polistatu"); }
    public void paramPolistatu(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPolistatu()); if (!tmp.equals(getPolistatu())) { setPolistatu(tmp); } }
    // 联系电话
    protected String phone = "";
    public String getPhone() {  return SqlTool.getDbString(phone);  }
    public String getPhone(int size) { return SqlTool.subString(getPhone(), size); }
    public void setPhone(String aPhone) { phone = aPhone; modifiedFields.add("Phone"); }
    public void assignPhone(String aPhone) { phone = aPhone; }
    public void paramPhone(HttpServletRequest request) { paramPhone(request, "Phone"); }
    public void paramPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPhone()); if (!tmp.equals(getPhone())) { setPhone(tmp); } }
    // 支部
    protected String zhibu = "";
    public String getZhibu() {  return SqlTool.getDbString(zhibu);  }
    public String getZhibu(int size) { return SqlTool.subString(getZhibu(), size); }
    public void setZhibu(String aZhibu) { zhibu = aZhibu; modifiedFields.add("Zhibu"); }
    public void assignZhibu(String aZhibu) { zhibu = aZhibu; }
    public void paramZhibu(HttpServletRequest request) { paramZhibu(request, "Zhibu"); }
    public void paramZhibu(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getZhibu()); if (!tmp.equals(getZhibu())) { setZhibu(tmp); } }
    // 职务
    protected String duty = "";
    public String getDuty() {  return SqlTool.getDbString(duty);  }
    public String getDuty(int size) { return SqlTool.subString(getDuty(), size); }
    public void setDuty(String aDuty) { duty = aDuty; modifiedFields.add("Duty"); }
    public void assignDuty(String aDuty) { duty = aDuty; }
    public void paramDuty(HttpServletRequest request) { paramDuty(request, "Duty"); }
    public void paramDuty(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDuty()); if (!tmp.equals(getDuty())) { setDuty(tmp); } }
    // 所在组织（志愿）
    protected String workUnit = "";
    public String getWorkUnit() {  return SqlTool.getDbString(workUnit);  }
    public String getWorkUnit(int size) { return SqlTool.subString(getWorkUnit(), size); }
    public void setWorkUnit(String aWorkUnit) { workUnit = aWorkUnit; modifiedFields.add("WorkUnit"); }
    public void assignWorkUnit(String aWorkUnit) { workUnit = aWorkUnit; }
    public void paramWorkUnit(HttpServletRequest request) { paramWorkUnit(request, "WorkUnit"); }
    public void paramWorkUnit(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getWorkUnit()); if (!tmp.equals(getWorkUnit())) { setWorkUnit(tmp); } }
    // 何时起参加支援服务（志愿
    protected String volstaTime = "";
    public String getVolstaTime() {  return SqlTool.getDbString(volstaTime);  }
    public String getVolstaTime(int size) { return SqlTool.subString(getVolstaTime(), size); }
    public void setVolstaTime(String aVolstaTime) { volstaTime = aVolstaTime; modifiedFields.add("VolstaTime"); }
    public void assignVolstaTime(String aVolstaTime) { volstaTime = aVolstaTime; }
    public void paramVolstaTime(HttpServletRequest request) { paramVolstaTime(request, "VolstaTime"); }
    public void paramVolstaTime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVolstaTime()); if (!tmp.equals(getVolstaTime())) { setVolstaTime(tmp); } }
    // 总时长（志愿、社团
    protected String volservTime = "";
    public String getVolservTime() {  return SqlTool.getDbString(volservTime);  }
    public String getVolservTime(int size) { return SqlTool.subString(getVolservTime(), size); }
    public void setVolservTime(String aVolservTime) { volservTime = aVolservTime; modifiedFields.add("VolservTime"); }
    public void assignVolservTime(String aVolservTime) { volservTime = aVolservTime; }
    public void paramVolservTime(HttpServletRequest request) { paramVolservTime(request, "VolservTime"); }
    public void paramVolservTime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVolservTime()); if (!tmp.equals(getVolservTime())) { setVolservTime(tmp); } }
    // 社团名称（社团）
    protected String clubName = "";
    public String getClubName() {  return SqlTool.getDbString(clubName);  }
    public String getClubName(int size) { return SqlTool.subString(getClubName(), size); }
    public void setClubName(String aClubName) { clubName = aClubName; modifiedFields.add("ClubName"); }
    public void assignClubName(String aClubName) { clubName = aClubName; }
    public void paramClubName(HttpServletRequest request) { paramClubName(request, "ClubName"); }
    public void paramClubName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubName()); if (!tmp.equals(getClubName())) { setClubName(tmp); } }
    // 所在社团属于（社团）
    protected String clubType = "";
    public String getClubType() {  return SqlTool.getDbString(clubType);  }
    public String getClubType(int size) { return SqlTool.subString(getClubType(), size); }
    public void setClubType(String aClubType) { clubType = aClubType; modifiedFields.add("ClubType"); }
    public void assignClubType(String aClubType) { clubType = aClubType; }
    public void paramClubType(HttpServletRequest request) { paramClubType(request, "ClubType"); }
    public void paramClubType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubType()); if (!tmp.equals(getClubType())) { setClubType(tmp); } }
    // 参加校级社团活动情况（社团）
    protected String joinClubInfo1 = "";
    public String getJoinClubInfo1() {  return SqlTool.getDbString(joinClubInfo1);  }
    public String getJoinClubInfo1(int size) { return SqlTool.subString(getJoinClubInfo1(), size); }
    public void setJoinClubInfo1(String aJoinClubInfo1) { joinClubInfo1 = aJoinClubInfo1; modifiedFields.add("JoinClubInfo1"); }
    public void assignJoinClubInfo1(String aJoinClubInfo1) { joinClubInfo1 = aJoinClubInfo1; }
    public void paramJoinClubInfo1(HttpServletRequest request) { paramJoinClubInfo1(request, "JoinClubInfo1"); }
    public void paramJoinClubInfo1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getJoinClubInfo1()); if (!tmp.equals(getJoinClubInfo1())) { setJoinClubInfo1(tmp); } }
    // 参加院级社团活动情况（社团）
    protected String joinClubInfo2 = "";
    public String getJoinClubInfo2() {  return SqlTool.getDbString(joinClubInfo2);  }
    public String getJoinClubInfo2(int size) { return SqlTool.subString(getJoinClubInfo2(), size); }
    public void setJoinClubInfo2(String aJoinClubInfo2) { joinClubInfo2 = aJoinClubInfo2; modifiedFields.add("JoinClubInfo2"); }
    public void assignJoinClubInfo2(String aJoinClubInfo2) { joinClubInfo2 = aJoinClubInfo2; }
    public void paramJoinClubInfo2(HttpServletRequest request) { paramJoinClubInfo2(request, "JoinClubInfo2"); }
    public void paramJoinClubInfo2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getJoinClubInfo2()); if (!tmp.equals(getJoinClubInfo2())) { setJoinClubInfo2(tmp); } }
    // 社团简介（社团）
    protected String clubInfo = "";
    public String getClubInfo() {  return SqlTool.getDbString(clubInfo);  }
    public String getClubInfo(int size) { return SqlTool.subString(getClubInfo(), size); }
    public void setClubInfo(String aClubInfo) { clubInfo = aClubInfo; modifiedFields.add("ClubInfo"); }
    public void assignClubInfo(String aClubInfo) { clubInfo = aClubInfo; }
    public void paramClubInfo(HttpServletRequest request) { paramClubInfo(request, "ClubInfo"); }
    public void paramClubInfo(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubInfo()); if (!tmp.equals(getClubInfo())) { setClubInfo(tmp); } }
    // 教育程度
    protected String education = "";
    public String getEducation() {  return SqlTool.getDbString(education);  }
    public String getEducation(int size) { return SqlTool.subString(getEducation(), size); }
    public void setEducation(String aEducation) { education = aEducation; modifiedFields.add("Education"); }
    public void assignEducation(String aEducation) { education = aEducation; }
    public void paramEducation(HttpServletRequest request) { paramEducation(request, "Education"); }
    public void paramEducation(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getEducation()); if (!tmp.equals(getEducation())) { setEducation(tmp); } }
    // 工作经历
    protected String workExp = "";
    public String getWorkExp() {  return SqlTool.getDbString(workExp);  }
    public String getWorkExp(int size) { return SqlTool.subString(getWorkExp(), size); }
    public void setWorkExp(String aWorkExp) { workExp = aWorkExp; modifiedFields.add("WorkExp"); }
    public void assignWorkExp(String aWorkExp) { workExp = aWorkExp; }
    public void paramWorkExp(HttpServletRequest request) { paramWorkExp(request, "WorkExp"); }
    public void paramWorkExp(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getWorkExp()); if (!tmp.equals(getWorkExp())) { setWorkExp(tmp); } }
    // 个人简历
    protected String resume = "";
    public String getResume() {  return SqlTool.getDbString(resume);  }
    public String getResume(int size) { return SqlTool.subString(getResume(), size); }
    public void setResume(String aResume) { resume = aResume; modifiedFields.add("Resume"); }
    public void assignResume(String aResume) { resume = aResume; }
    public void paramResume(HttpServletRequest request) { paramResume(request, "Resume"); }
    public void paramResume(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getResume()); if (!tmp.equals(getResume())) { setResume(tmp); } }
    // 获奖情况
    protected String award = "";
    public String getAward() {  return SqlTool.getDbString(award);  }
    public String getAward(int size) { return SqlTool.subString(getAward(), size); }
    public void setAward(String aAward) { award = aAward; modifiedFields.add("Award"); }
    public void assignAward(String aAward) { award = aAward; }
    public void paramAward(HttpServletRequest request) { paramAward(request, "Award"); }
    public void paramAward(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAward()); if (!tmp.equals(getAward())) { setAward(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public YouthhonourIndi (String db) {
        DBNAME = db;
    }
    public YouthhonourIndi (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public YouthhonourIndi (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public YouthhonourIndi () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return YouthhonourIndi类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public YouthhonourIndi getByParameter(HttpServletRequest request) {
        YouthhonourIndi v = new YouthhonourIndi(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramSchoolYear(request);
        paramType(request);
        paramAddAccount(request);
        paramAddTime(request);
        paramXyCheckFlag(request);
        paramTwCheckFlag(request);
        paramModifyFlag(request);
        paramXyReport(request);
        paramTwReport(request);
        paramXyCheckDate(request);
        paramTwCheckDate(request);
        paramBelongAcademy(request);
        paramSno(request);
        paramName(request);
        paramAcademy(request);
        paramGrade(request);
        paramMajor(request);
        paramSex(request);
        paramNation(request);
        paramSNative(request);
        paramPhoto(request);
        paramBirthday(request);
        paramPolistatu(request);
        paramPhone(request);
        paramZhibu(request);
        paramDuty(request);
        paramWorkUnit(request);
        paramVolstaTime(request);
        paramVolservTime(request);
        paramClubName(request);
        paramClubType(request);
        paramJoinClubInfo1(request);
        paramJoinClubInfo2(request);
        paramClubInfo(request);
        paramEducation(request);
        paramWorkExp(request);
        paramResume(request);
        paramAward(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(YouthhonourIndi bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("schoolYear")) { setSchoolYear(bean.getSchoolYear()); }
        if (!ncl.contains("type")) { setType(bean.getType()); }
        if (!ncl.contains("addAccount")) { setAddAccount(bean.getAddAccount()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("xyCheckFlag")) { setXyCheckFlag(bean.getXyCheckFlag()); }
        if (!ncl.contains("twCheckFlag")) { setTwCheckFlag(bean.getTwCheckFlag()); }
        if (!ncl.contains("modifyFlag")) { setModifyFlag(bean.getModifyFlag()); }
        if (!ncl.contains("xyReport")) { setXyReport(bean.getXyReport()); }
        if (!ncl.contains("twReport")) { setTwReport(bean.getTwReport()); }
        if (!ncl.contains("xyCheckDate")) { setXyCheckDate(bean.getXyCheckDate()); }
        if (!ncl.contains("twCheckDate")) { setTwCheckDate(bean.getTwCheckDate()); }
        if (!ncl.contains("belongAcademy")) { setBelongAcademy(bean.getBelongAcademy()); }
        if (!ncl.contains("sno")) { setSno(bean.getSno()); }
        if (!ncl.contains("name")) { setName(bean.getName()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("grade")) { setGrade(bean.getGrade()); }
        if (!ncl.contains("major")) { setMajor(bean.getMajor()); }
        if (!ncl.contains("sex")) { setSex(bean.getSex()); }
        if (!ncl.contains("nation")) { setNation(bean.getNation()); }
        if (!ncl.contains("sNative")) { setSNative(bean.getSNative()); }
        if (!ncl.contains("photo")) { setPhoto(bean.getPhoto()); }
        if (!ncl.contains("birthday")) { setBirthday(bean.getBirthday()); }
        if (!ncl.contains("polistatu")) { setPolistatu(bean.getPolistatu()); }
        if (!ncl.contains("phone")) { setPhone(bean.getPhone()); }
        if (!ncl.contains("zhibu")) { setZhibu(bean.getZhibu()); }
        if (!ncl.contains("duty")) { setDuty(bean.getDuty()); }
        if (!ncl.contains("workUnit")) { setWorkUnit(bean.getWorkUnit()); }
        if (!ncl.contains("volstaTime")) { setVolstaTime(bean.getVolstaTime()); }
        if (!ncl.contains("volservTime")) { setVolservTime(bean.getVolservTime()); }
        if (!ncl.contains("clubName")) { setClubName(bean.getClubName()); }
        if (!ncl.contains("clubType")) { setClubType(bean.getClubType()); }
        if (!ncl.contains("joinClubInfo1")) { setJoinClubInfo1(bean.getJoinClubInfo1()); }
        if (!ncl.contains("joinClubInfo2")) { setJoinClubInfo2(bean.getJoinClubInfo2()); }
        if (!ncl.contains("clubInfo")) { setClubInfo(bean.getClubInfo()); }
        if (!ncl.contains("education")) { setEducation(bean.getEducation()); }
        if (!ncl.contains("workExp")) { setWorkExp(bean.getWorkExp()); }
        if (!ncl.contains("resume")) { setResume(bean.getResume()); }
        if (!ncl.contains("award")) { setAward(bean.getAward()); }
    }
    public YouthhonourIndi getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        YouthhonourIndi[] rslt= queryByCondition(cdt);
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
     * @return YouthhonourIndi类的实例列表。
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
                YouthhonourIndi ve = new YouthhonourIndi(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignSchoolYear(fromDbCh(rs.getString(2)));
                ve.assignType(rs.getInt(3));
                ve.assignAddAccount(fromDbCh(rs.getString(4)));
                tmpDate = rs.getTimestamp(5); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignXyCheckFlag(rs.getInt(6));
                ve.assignTwCheckFlag(rs.getInt(7));
                ve.assignModifyFlag(rs.getInt(8));
                ve.assignXyReport(rs.getInt(9));
                ve.assignTwReport(rs.getInt(10));
                tmpDate = rs.getTimestamp(11); if (tmpDate != null) { ve.assignXyCheckDate(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(12); if (tmpDate != null) { ve.assignTwCheckDate(new java.util.Date(tmpDate.getTime())); }
                ve.assignBelongAcademy(fromDbCh(rs.getString(13)));
                ve.assignSno(fromDbCh(rs.getString(14)));
                ve.assignName(fromDbCh(rs.getString(15)));
                ve.assignAcademy(fromDbCh(rs.getString(16)));
                ve.assignGrade(fromDbCh(rs.getString(17)));
                ve.assignMajor(fromDbCh(rs.getString(18)));
                ve.assignSex(fromDbCh(rs.getString(19)));
                ve.assignNation(fromDbCh(rs.getString(20)));
                ve.assignSNative(fromDbCh(rs.getString(21)));
                ve.assignPhoto(fromDbCh(rs.getString(22)));
                ve.assignBirthday(fromDbCh(rs.getString(23)));
                ve.assignPolistatu(fromDbCh(rs.getString(24)));
                ve.assignPhone(fromDbCh(rs.getString(25)));
                ve.assignZhibu(fromDbCh(rs.getString(26)));
                ve.assignDuty(fromDbCh(rs.getString(27)));
                ve.assignWorkUnit(fromDbCh(rs.getString(28)));
                ve.assignVolstaTime(fromDbCh(rs.getString(29)));
                ve.assignVolservTime(fromDbCh(rs.getString(30)));
                ve.assignClubName(fromDbCh(rs.getString(31)));
                ve.assignClubType(fromDbCh(rs.getString(32)));
                ve.assignJoinClubInfo1(fromDbCh(rs.getString(33)));
                ve.assignJoinClubInfo2(fromDbCh(rs.getString(34)));
                ve.assignClubInfo(fromDbCh(rs.getString(35)));
                ve.assignEducation(fromDbCh(rs.getString(36)));
                ve.assignWorkExp(fromDbCh(rs.getString(37)));
                ve.assignResume(fromDbCh(rs.getString(38)));
                ve.assignAward(fromDbCh(rs.getString(39)));
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
    public YouthhonourIndi[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (YouthhonourIndi[])vrs.toArray(new YouthhonourIndi[vrs.size()]);
    }
    public YouthhonourIndi[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (YouthhonourIndi[])vrs.toArray(new YouthhonourIndi[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (schoolyear,type,addaccount,addtime,xycheckflag,twcheckflag,modifyflag,xyreport,twreport,xycheckdate,twcheckdate,belongacademy,sno,name,academy,grade,major,sex,nation,snative,photo,birthday,polistatu,phone,zhibu,duty,workunit,volstatime,volservtime,clubname,clubtype,joinclubinfo1,joinclubinfo2,clubinfo,education,workexp,resume,award) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(schoolYear));
            pstmt.setInt(2, type);
            pstmt.setString(3, toDbCh(addAccount));
            pstmt.setTimestamp(4, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setInt(5, xyCheckFlag);
            pstmt.setInt(6, twCheckFlag);
            pstmt.setInt(7, modifyFlag);
            pstmt.setInt(8, xyReport);
            pstmt.setInt(9, twReport);
            pstmt.setTimestamp(10, new java.sql.Timestamp(xyCheckDate.getTime()));
            pstmt.setTimestamp(11, new java.sql.Timestamp(twCheckDate.getTime()));
            pstmt.setString(12, toDbCh(belongAcademy));
            pstmt.setString(13, toDbCh(sno));
            pstmt.setString(14, toDbCh(name));
            pstmt.setString(15, toDbCh(academy));
            pstmt.setString(16, toDbCh(grade));
            pstmt.setString(17, toDbCh(major));
            pstmt.setString(18, toDbCh(sex));
            pstmt.setString(19, toDbCh(nation));
            pstmt.setString(20, toDbCh(sNative));
            pstmt.setString(21, toDbCh(photo));
            pstmt.setString(22, toDbCh(birthday));
            pstmt.setString(23, toDbCh(polistatu));
            pstmt.setString(24, toDbCh(phone));
            pstmt.setString(25, toDbCh(zhibu));
            pstmt.setString(26, toDbCh(duty));
            pstmt.setString(27, toDbCh(workUnit));
            pstmt.setString(28, toDbCh(volstaTime));
            pstmt.setString(29, toDbCh(volservTime));
            pstmt.setString(30, toDbCh(clubName));
            pstmt.setString(31, toDbCh(clubType));
            pstmt.setString(32, toDbCh(joinClubInfo1));
            pstmt.setString(33, toDbCh(joinClubInfo2));
            pstmt.setString(34, toDbCh(clubInfo));
            pstmt.setString(35, toDbCh(education));
            pstmt.setString(36, toDbCh(workExp));
            pstmt.setString(37, toDbCh(resume));
            pstmt.setString(38, toDbCh(award));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,schoolyear,type,addaccount,addtime,xycheckflag,twcheckflag,modifyflag,xyreport,twreport,xycheckdate,twcheckdate,belongacademy,sno,name,academy,grade,major,sex,nation,snative,photo,birthday,polistatu,phone,zhibu,duty,workunit,volstatime,volservtime,clubname,clubtype,joinclubinfo1,joinclubinfo2,clubinfo,education,workexp,resume,award) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(schoolYear));
            pstmt.setInt(3, type);
            pstmt.setString(4, toDbCh(addAccount));
            pstmt.setTimestamp(5, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setInt(6, xyCheckFlag);
            pstmt.setInt(7, twCheckFlag);
            pstmt.setInt(8, modifyFlag);
            pstmt.setInt(9, xyReport);
            pstmt.setInt(10, twReport);
            pstmt.setTimestamp(11, new java.sql.Timestamp(xyCheckDate.getTime()));
            pstmt.setTimestamp(12, new java.sql.Timestamp(twCheckDate.getTime()));
            pstmt.setString(13, toDbCh(belongAcademy));
            pstmt.setString(14, toDbCh(sno));
            pstmt.setString(15, toDbCh(name));
            pstmt.setString(16, toDbCh(academy));
            pstmt.setString(17, toDbCh(grade));
            pstmt.setString(18, toDbCh(major));
            pstmt.setString(19, toDbCh(sex));
            pstmt.setString(20, toDbCh(nation));
            pstmt.setString(21, toDbCh(sNative));
            pstmt.setString(22, toDbCh(photo));
            pstmt.setString(23, toDbCh(birthday));
            pstmt.setString(24, toDbCh(polistatu));
            pstmt.setString(25, toDbCh(phone));
            pstmt.setString(26, toDbCh(zhibu));
            pstmt.setString(27, toDbCh(duty));
            pstmt.setString(28, toDbCh(workUnit));
            pstmt.setString(29, toDbCh(volstaTime));
            pstmt.setString(30, toDbCh(volservTime));
            pstmt.setString(31, toDbCh(clubName));
            pstmt.setString(32, toDbCh(clubType));
            pstmt.setString(33, toDbCh(joinClubInfo1));
            pstmt.setString(34, toDbCh(joinClubInfo2));
            pstmt.setString(35, toDbCh(clubInfo));
            pstmt.setString(36, toDbCh(education));
            pstmt.setString(37, toDbCh(workExp));
            pstmt.setString(38, toDbCh(resume));
            pstmt.setString(39, toDbCh(award));
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
            YouthhonourIndi item = (YouthhonourIndi)it.next();
            YouthhonourIndi v = new YouthhonourIndi(dbname);
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
                if (modifiedFields.contains("SchoolYear")) { pstmt.setString(pi ++, toDbCh(schoolYear)); }
                if (modifiedFields.contains("Type")) { pstmt.setInt(pi ++, type); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("XyCheckFlag")) { pstmt.setInt(pi ++, xyCheckFlag); }
                if (modifiedFields.contains("TwCheckFlag")) { pstmt.setInt(pi ++, twCheckFlag); }
                if (modifiedFields.contains("ModifyFlag")) { pstmt.setInt(pi ++, modifyFlag); }
                if (modifiedFields.contains("XyReport")) { pstmt.setInt(pi ++, xyReport); }
                if (modifiedFields.contains("TwReport")) { pstmt.setInt(pi ++, twReport); }
                if (modifiedFields.contains("XyCheckDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(xyCheckDate.getTime())); }
                if (modifiedFields.contains("TwCheckDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(twCheckDate.getTime())); }
                if (modifiedFields.contains("BelongAcademy")) { pstmt.setString(pi ++, toDbCh(belongAcademy)); }
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("Name")) { pstmt.setString(pi ++, toDbCh(name)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Grade")) { pstmt.setString(pi ++, toDbCh(grade)); }
                if (modifiedFields.contains("Major")) { pstmt.setString(pi ++, toDbCh(major)); }
                if (modifiedFields.contains("Sex")) { pstmt.setString(pi ++, toDbCh(sex)); }
                if (modifiedFields.contains("Nation")) { pstmt.setString(pi ++, toDbCh(nation)); }
                if (modifiedFields.contains("SNative")) { pstmt.setString(pi ++, toDbCh(sNative)); }
                if (modifiedFields.contains("Photo")) { pstmt.setString(pi ++, toDbCh(photo)); }
                if (modifiedFields.contains("Birthday")) { pstmt.setString(pi ++, toDbCh(birthday)); }
                if (modifiedFields.contains("Polistatu")) { pstmt.setString(pi ++, toDbCh(polistatu)); }
                if (modifiedFields.contains("Phone")) { pstmt.setString(pi ++, toDbCh(phone)); }
                if (modifiedFields.contains("Zhibu")) { pstmt.setString(pi ++, toDbCh(zhibu)); }
                if (modifiedFields.contains("Duty")) { pstmt.setString(pi ++, toDbCh(duty)); }
                if (modifiedFields.contains("WorkUnit")) { pstmt.setString(pi ++, toDbCh(workUnit)); }
                if (modifiedFields.contains("VolstaTime")) { pstmt.setString(pi ++, toDbCh(volstaTime)); }
                if (modifiedFields.contains("VolservTime")) { pstmt.setString(pi ++, toDbCh(volservTime)); }
                if (modifiedFields.contains("ClubName")) { pstmt.setString(pi ++, toDbCh(clubName)); }
                if (modifiedFields.contains("ClubType")) { pstmt.setString(pi ++, toDbCh(clubType)); }
                if (modifiedFields.contains("JoinClubInfo1")) { pstmt.setString(pi ++, toDbCh(joinClubInfo1)); }
                if (modifiedFields.contains("JoinClubInfo2")) { pstmt.setString(pi ++, toDbCh(joinClubInfo2)); }
                if (modifiedFields.contains("ClubInfo")) { pstmt.setString(pi ++, toDbCh(clubInfo)); }
                if (modifiedFields.contains("Education")) { pstmt.setString(pi ++, toDbCh(education)); }
                if (modifiedFields.contains("WorkExp")) { pstmt.setString(pi ++, toDbCh(workExp)); }
                if (modifiedFields.contains("Resume")) { pstmt.setString(pi ++, toDbCh(resume)); }
                if (modifiedFields.contains("Award")) { pstmt.setString(pi ++, toDbCh(award)); }
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
                if (modifiedFields.contains("SchoolYear")) { pstmt.setString(pi ++, toDbCh(schoolYear)); }
                if (modifiedFields.contains("Type")) { pstmt.setInt(pi ++, type); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("XyCheckFlag")) { pstmt.setInt(pi ++, xyCheckFlag); }
                if (modifiedFields.contains("TwCheckFlag")) { pstmt.setInt(pi ++, twCheckFlag); }
                if (modifiedFields.contains("ModifyFlag")) { pstmt.setInt(pi ++, modifyFlag); }
                if (modifiedFields.contains("XyReport")) { pstmt.setInt(pi ++, xyReport); }
                if (modifiedFields.contains("TwReport")) { pstmt.setInt(pi ++, twReport); }
                if (modifiedFields.contains("XyCheckDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(xyCheckDate.getTime())); }
                if (modifiedFields.contains("TwCheckDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(twCheckDate.getTime())); }
                if (modifiedFields.contains("BelongAcademy")) { pstmt.setString(pi ++, toDbCh(belongAcademy)); }
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("Name")) { pstmt.setString(pi ++, toDbCh(name)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Grade")) { pstmt.setString(pi ++, toDbCh(grade)); }
                if (modifiedFields.contains("Major")) { pstmt.setString(pi ++, toDbCh(major)); }
                if (modifiedFields.contains("Sex")) { pstmt.setString(pi ++, toDbCh(sex)); }
                if (modifiedFields.contains("Nation")) { pstmt.setString(pi ++, toDbCh(nation)); }
                if (modifiedFields.contains("SNative")) { pstmt.setString(pi ++, toDbCh(sNative)); }
                if (modifiedFields.contains("Photo")) { pstmt.setString(pi ++, toDbCh(photo)); }
                if (modifiedFields.contains("Birthday")) { pstmt.setString(pi ++, toDbCh(birthday)); }
                if (modifiedFields.contains("Polistatu")) { pstmt.setString(pi ++, toDbCh(polistatu)); }
                if (modifiedFields.contains("Phone")) { pstmt.setString(pi ++, toDbCh(phone)); }
                if (modifiedFields.contains("Zhibu")) { pstmt.setString(pi ++, toDbCh(zhibu)); }
                if (modifiedFields.contains("Duty")) { pstmt.setString(pi ++, toDbCh(duty)); }
                if (modifiedFields.contains("WorkUnit")) { pstmt.setString(pi ++, toDbCh(workUnit)); }
                if (modifiedFields.contains("VolstaTime")) { pstmt.setString(pi ++, toDbCh(volstaTime)); }
                if (modifiedFields.contains("VolservTime")) { pstmt.setString(pi ++, toDbCh(volservTime)); }
                if (modifiedFields.contains("ClubName")) { pstmt.setString(pi ++, toDbCh(clubName)); }
                if (modifiedFields.contains("ClubType")) { pstmt.setString(pi ++, toDbCh(clubType)); }
                if (modifiedFields.contains("JoinClubInfo1")) { pstmt.setString(pi ++, toDbCh(joinClubInfo1)); }
                if (modifiedFields.contains("JoinClubInfo2")) { pstmt.setString(pi ++, toDbCh(joinClubInfo2)); }
                if (modifiedFields.contains("ClubInfo")) { pstmt.setString(pi ++, toDbCh(clubInfo)); }
                if (modifiedFields.contains("Education")) { pstmt.setString(pi ++, toDbCh(education)); }
                if (modifiedFields.contains("WorkExp")) { pstmt.setString(pi ++, toDbCh(workExp)); }
                if (modifiedFields.contains("Resume")) { pstmt.setString(pi ++, toDbCh(resume)); }
                if (modifiedFields.contains("Award")) { pstmt.setString(pi ++, toDbCh(award)); }
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
        map.put("SchoolYear", getSchoolYear());
        map.put("Type", getType() + "");
        map.put("AddAccount", getAddAccount());
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("XyCheckFlag", getXyCheckFlag() + "");
        map.put("TwCheckFlag", getTwCheckFlag() + "");
        map.put("ModifyFlag", getModifyFlag() + "");
        map.put("XyReport", getXyReport() + "");
        map.put("TwReport", getTwReport() + "");
        map.put("XyCheckDate", Tool.stringOfDateTime(getXyCheckDate()));
        map.put("TwCheckDate", Tool.stringOfDateTime(getTwCheckDate()));
        map.put("BelongAcademy", getBelongAcademy());
        map.put("Sno", getSno());
        map.put("Name", getName());
        map.put("Academy", getAcademy());
        map.put("Grade", getGrade());
        map.put("Major", getMajor());
        map.put("Sex", getSex());
        map.put("Nation", getNation());
        map.put("SNative", getSNative());
        map.put("Photo", getPhoto());
        map.put("Birthday", getBirthday());
        map.put("Polistatu", getPolistatu());
        map.put("Phone", getPhone());
        map.put("Zhibu", getZhibu());
        map.put("Duty", getDuty());
        map.put("WorkUnit", getWorkUnit());
        map.put("VolstaTime", getVolstaTime());
        map.put("VolservTime", getVolservTime());
        map.put("ClubName", getClubName());
        map.put("ClubType", getClubType());
        map.put("JoinClubInfo1", getJoinClubInfo1());
        map.put("JoinClubInfo2", getJoinClubInfo2());
        map.put("ClubInfo", getClubInfo());
        map.put("Education", getEducation());
        map.put("WorkExp", getWorkExp());
        map.put("Resume", getResume());
        map.put("Award", getAward());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("SchoolYear:\"" + Tool.jsSpecialChars(getSchoolYear()) + "\"");
        row.add("Type:\"" + getType() + "\"");
        row.add("AddAccount:\"" + Tool.jsSpecialChars(getAddAccount()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("XyCheckFlag:\"" + getXyCheckFlag() + "\"");
        row.add("TwCheckFlag:\"" + getTwCheckFlag() + "\"");
        row.add("ModifyFlag:\"" + getModifyFlag() + "\"");
        row.add("XyReport:\"" + getXyReport() + "\"");
        row.add("TwReport:\"" + getTwReport() + "\"");
        row.add("XyCheckDate:\"" + Tool.stringOfDateTime(getXyCheckDate()) + "\"");
        row.add("TwCheckDate:\"" + Tool.stringOfDateTime(getTwCheckDate()) + "\"");
        row.add("BelongAcademy:\"" + Tool.jsSpecialChars(getBelongAcademy()) + "\"");
        row.add("Sno:\"" + Tool.jsSpecialChars(getSno()) + "\"");
        row.add("Name:\"" + Tool.jsSpecialChars(getName()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("Grade:\"" + Tool.jsSpecialChars(getGrade()) + "\"");
        row.add("Major:\"" + Tool.jsSpecialChars(getMajor()) + "\"");
        row.add("Sex:\"" + Tool.jsSpecialChars(getSex()) + "\"");
        row.add("Nation:\"" + Tool.jsSpecialChars(getNation()) + "\"");
        row.add("SNative:\"" + Tool.jsSpecialChars(getSNative()) + "\"");
        row.add("Photo:\"" + Tool.jsSpecialChars(getPhoto()) + "\"");
        row.add("Birthday:\"" + Tool.jsSpecialChars(getBirthday()) + "\"");
        row.add("Polistatu:\"" + Tool.jsSpecialChars(getPolistatu()) + "\"");
        row.add("Phone:\"" + Tool.jsSpecialChars(getPhone()) + "\"");
        row.add("Zhibu:\"" + Tool.jsSpecialChars(getZhibu()) + "\"");
        row.add("Duty:\"" + Tool.jsSpecialChars(getDuty()) + "\"");
        row.add("WorkUnit:\"" + Tool.jsSpecialChars(getWorkUnit()) + "\"");
        row.add("VolstaTime:\"" + Tool.jsSpecialChars(getVolstaTime()) + "\"");
        row.add("VolservTime:\"" + Tool.jsSpecialChars(getVolservTime()) + "\"");
        row.add("ClubName:\"" + Tool.jsSpecialChars(getClubName()) + "\"");
        row.add("ClubType:\"" + Tool.jsSpecialChars(getClubType()) + "\"");
        row.add("JoinClubInfo1:\"" + Tool.jsSpecialChars(getJoinClubInfo1()) + "\"");
        row.add("JoinClubInfo2:\"" + Tool.jsSpecialChars(getJoinClubInfo2()) + "\"");
        row.add("ClubInfo:\"" + Tool.jsSpecialChars(getClubInfo()) + "\"");
        row.add("Education:\"" + Tool.jsSpecialChars(getEducation()) + "\"");
        row.add("WorkExp:\"" + Tool.jsSpecialChars(getWorkExp()) + "\"");
        row.add("Resume:\"" + Tool.jsSpecialChars(getResume()) + "\"");
        row.add("Award:\"" + Tool.jsSpecialChars(getAward()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,schoolyear varchar2(45),type number(*,0),addaccount varchar2(45),addtime date,xycheckflag number(*,0),twcheckflag number(*,0),modifyflag number(*,0),xyreport number(*,0),twreport number(*,0),xycheckdate date,twcheckdate date,belongacademy varchar2(45),sno varchar2(45),name varchar2(45),academy varchar2(45),grade varchar2(45),major varchar2(45),sex varchar2(2),nation varchar2(45),snative varchar2(45),photo varchar2(45),birthday varchar2(45),polistatu varchar2(45),phone varchar2(45),zhibu varchar2(45),duty varchar2(45),workunit varchar2(45),volstatime varchar2(45),volservtime varchar2(45),clubname varchar2(45),clubtype varchar2(45),joinclubinfo1 varchar2(45),joinclubinfo2 varchar2(45),clubinfo varchar2(500),education varchar2(45),workexp varchar2(500),resume varchar2(500),award varchar2(500))"});
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
        YouthhonourIndi v = new YouthhonourIndi(sourceDb, sourceTb);
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
        YouthhonourIndi v = new YouthhonourIndi(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(YouthhonourIndi obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getSchoolYear().compareTo(obj.getSchoolYear()); if (rtn != 0) return rtn;
        rtn = ("" + getType()).compareTo("" + obj.getType()); if (rtn != 0) return rtn;
        rtn = getAddAccount().compareTo(obj.getAddAccount()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = ("" + getXyCheckFlag()).compareTo("" + obj.getXyCheckFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getTwCheckFlag()).compareTo("" + obj.getTwCheckFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getModifyFlag()).compareTo("" + obj.getModifyFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getXyReport()).compareTo("" + obj.getXyReport()); if (rtn != 0) return rtn;
        rtn = ("" + getTwReport()).compareTo("" + obj.getTwReport()); if (rtn != 0) return rtn;
        rtn = getXyCheckDate().compareTo(obj.getXyCheckDate()); if (rtn != 0) return rtn;
        rtn = getTwCheckDate().compareTo(obj.getTwCheckDate()); if (rtn != 0) return rtn;
        rtn = getBelongAcademy().compareTo(obj.getBelongAcademy()); if (rtn != 0) return rtn;
        rtn = getSno().compareTo(obj.getSno()); if (rtn != 0) return rtn;
        rtn = getName().compareTo(obj.getName()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getGrade().compareTo(obj.getGrade()); if (rtn != 0) return rtn;
        rtn = getMajor().compareTo(obj.getMajor()); if (rtn != 0) return rtn;
        rtn = getSex().compareTo(obj.getSex()); if (rtn != 0) return rtn;
        rtn = getNation().compareTo(obj.getNation()); if (rtn != 0) return rtn;
        rtn = getSNative().compareTo(obj.getSNative()); if (rtn != 0) return rtn;
        rtn = getPhoto().compareTo(obj.getPhoto()); if (rtn != 0) return rtn;
        rtn = getBirthday().compareTo(obj.getBirthday()); if (rtn != 0) return rtn;
        rtn = getPolistatu().compareTo(obj.getPolistatu()); if (rtn != 0) return rtn;
        rtn = getPhone().compareTo(obj.getPhone()); if (rtn != 0) return rtn;
        rtn = getZhibu().compareTo(obj.getZhibu()); if (rtn != 0) return rtn;
        rtn = getDuty().compareTo(obj.getDuty()); if (rtn != 0) return rtn;
        rtn = getWorkUnit().compareTo(obj.getWorkUnit()); if (rtn != 0) return rtn;
        rtn = getVolstaTime().compareTo(obj.getVolstaTime()); if (rtn != 0) return rtn;
        rtn = getVolservTime().compareTo(obj.getVolservTime()); if (rtn != 0) return rtn;
        rtn = getClubName().compareTo(obj.getClubName()); if (rtn != 0) return rtn;
        rtn = getClubType().compareTo(obj.getClubType()); if (rtn != 0) return rtn;
        rtn = getJoinClubInfo1().compareTo(obj.getJoinClubInfo1()); if (rtn != 0) return rtn;
        rtn = getJoinClubInfo2().compareTo(obj.getJoinClubInfo2()); if (rtn != 0) return rtn;
        rtn = getClubInfo().compareTo(obj.getClubInfo()); if (rtn != 0) return rtn;
        rtn = getEducation().compareTo(obj.getEducation()); if (rtn != 0) return rtn;
        rtn = getWorkExp().compareTo(obj.getWorkExp()); if (rtn != 0) return rtn;
        rtn = getResume().compareTo(obj.getResume()); if (rtn != 0) return rtn;
        rtn = getAward().compareTo(obj.getAward()); if (rtn != 0) return rtn;
        return rtn;
    }
}
