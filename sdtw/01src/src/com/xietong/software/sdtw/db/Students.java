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
@Description("学生表")
public class Students implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(Students.class);
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
    public static final String DbTableName = "students";
    private String TNAME = "students";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","sno","sName","sSex","sacademy","timeToSchool","timeToTuan","birthday","zhiBu","nation","major","lenOfSchool","grade","polista","nativePlace","iDNum","phone","email","addfilelist","yearToSchool","graduateTime","volunteerfFag"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","sno","sname","ssex","sacademy","timetoschool","timetotuan","birthday","zhibu","nation","major","lenofschool","grade","polista","nativeplace","idnum","phone","email","addfilelist","yeartoschool","graduatetime","volunteerffag"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"Sno","sno","String"},{"SName","sname","String"},{"SSex","ssex","String"},{"Sacademy","sacademy","String"},{"TimeToSchool","timetoschool","java.util.Date"},{"TimeToTuan","timetotuan","java.util.Date"},{"Birthday","birthday","java.util.Date"},{"ZhiBu","zhibu","String"},{"Nation","nation","String"},{"Major","major","String"},{"LenOfSchool","lenofschool","String"},{"Grade","grade","String"},{"Polista","polista","String"},{"NativePlace","nativeplace","String"},{"IDNum","idnum","String"},{"Phone","phone","String"},{"Email","email","String"},{"Addfilelist","addfilelist","String"},{"YearToSchool","yeartoschool","String"},{"GraduateTime","graduatetime","java.util.Date"},{"VolunteerfFag","volunteerffag","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"sno","sno"},{"sName","sname"},{"sSex","ssex"},{"sacademy","sacademy"},{"timeToSchool","timetoschool"},{"timeToTuan","timetotuan"},{"birthday","birthday"},{"zhiBu","zhibu"},{"nation","nation"},{"major","major"},{"lenOfSchool","lenofschool"},{"grade","grade"},{"polista","polista"},{"nativePlace","nativeplace"},{"iDNum","idnum"},{"phone","phone"},{"email","email"},{"addfilelist","addfilelist"},{"yearToSchool","yeartoschool"},{"graduateTime","graduatetime"},{"volunteerfFag","volunteerffag"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"TIMETOSCHOOL","TIMETOTUAN","BIRTHDAY","GRADUATETIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 学号
    protected String sno = "";
    public String getSno() {  return SqlTool.getDbString(sno);  }
    public String getSno(int size) { return SqlTool.subString(getSno(), size); }
    public void setSno(String aSno) { sno = aSno; modifiedFields.add("Sno"); }
    public void assignSno(String aSno) { sno = aSno; }
    public void paramSno(HttpServletRequest request) { paramSno(request, "Sno"); }
    public void paramSno(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSno()); if (!tmp.equals(getSno())) { setSno(tmp); } }
    // 姓名
    protected String sName = "";
    public String getSName() {  return SqlTool.getDbString(sName);  }
    public String getSName(int size) { return SqlTool.subString(getSName(), size); }
    public void setSName(String aSName) { sName = aSName; modifiedFields.add("SName"); }
    public void assignSName(String aSName) { sName = aSName; }
    public void paramSName(HttpServletRequest request) { paramSName(request, "SName"); }
    public void paramSName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSName()); if (!tmp.equals(getSName())) { setSName(tmp); } }
    // 性别
    protected String sSex = "";
    public String getSSex() {  return SqlTool.getDbString(sSex);  }
    public String getSSex(int size) { return SqlTool.subString(getSSex(), size); }
    public void setSSex(String aSSex) { sSex = aSSex; modifiedFields.add("SSex"); }
    public void assignSSex(String aSSex) { sSex = aSSex; }
    public void paramSSex(HttpServletRequest request) { paramSSex(request, "SSex"); }
    public void paramSSex(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSSex()); if (!tmp.equals(getSSex())) { setSSex(tmp); } }
    // 学院
    protected String sacademy = "";
    public String getSacademy() {  return SqlTool.getDbString(sacademy);  }
    public String getSacademy(int size) { return SqlTool.subString(getSacademy(), size); }
    public void setSacademy(String aSacademy) { sacademy = aSacademy; modifiedFields.add("Sacademy"); }
    public void assignSacademy(String aSacademy) { sacademy = aSacademy; }
    public void paramSacademy(HttpServletRequest request) { paramSacademy(request, "Sacademy"); }
    public void paramSacademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSacademy()); if (!tmp.equals(getSacademy())) { setSacademy(tmp); } }
    // 入校时间
    protected java.util.Date timeToSchool = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getTimeToSchool() { return timeToSchool; }
    public void setTimeToSchool(java.util.Date aTimeToSchool) { timeToSchool = aTimeToSchool; modifiedFields.add("TimeToSchool"); }
    public void assignTimeToSchool(java.util.Date aTimeToSchool) { timeToSchool = aTimeToSchool; }
    public void paramTimeToSchool(HttpServletRequest request) { paramTimeToSchool(request, "TimeToSchool"); }
    public void paramTimeToSchool(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getTimeToSchool()); if (tmp.compareTo(getTimeToSchool()) != 0) { setTimeToSchool(tmp); } }
    // 入团时间
    protected java.util.Date timeToTuan = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getTimeToTuan() { return timeToTuan; }
    public void setTimeToTuan(java.util.Date aTimeToTuan) { timeToTuan = aTimeToTuan; modifiedFields.add("TimeToTuan"); }
    public void assignTimeToTuan(java.util.Date aTimeToTuan) { timeToTuan = aTimeToTuan; }
    public void paramTimeToTuan(HttpServletRequest request) { paramTimeToTuan(request, "TimeToTuan"); }
    public void paramTimeToTuan(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getTimeToTuan()); if (tmp.compareTo(getTimeToTuan()) != 0) { setTimeToTuan(tmp); } }
    // 生日
    protected java.util.Date birthday = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getBirthday() { return birthday; }
    public void setBirthday(java.util.Date aBirthday) { birthday = aBirthday; modifiedFields.add("Birthday"); }
    public void assignBirthday(java.util.Date aBirthday) { birthday = aBirthday; }
    public void paramBirthday(HttpServletRequest request) { paramBirthday(request, "Birthday"); }
    public void paramBirthday(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getBirthday()); if (tmp.compareTo(getBirthday()) != 0) { setBirthday(tmp); } }
    // 支部
    protected String zhiBu = "";
    public String getZhiBu() {  return SqlTool.getDbString(zhiBu);  }
    public String getZhiBu(int size) { return SqlTool.subString(getZhiBu(), size); }
    public void setZhiBu(String aZhiBu) { zhiBu = aZhiBu; modifiedFields.add("ZhiBu"); }
    public void assignZhiBu(String aZhiBu) { zhiBu = aZhiBu; }
    public void paramZhiBu(HttpServletRequest request) { paramZhiBu(request, "ZhiBu"); }
    public void paramZhiBu(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getZhiBu()); if (!tmp.equals(getZhiBu())) { setZhiBu(tmp); } }
    // 民族
    protected String nation = "";
    public String getNation() {  return SqlTool.getDbString(nation);  }
    public String getNation(int size) { return SqlTool.subString(getNation(), size); }
    public void setNation(String aNation) { nation = aNation; modifiedFields.add("Nation"); }
    public void assignNation(String aNation) { nation = aNation; }
    public void paramNation(HttpServletRequest request) { paramNation(request, "Nation"); }
    public void paramNation(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getNation()); if (!tmp.equals(getNation())) { setNation(tmp); } }
    // 专业
    protected String major = "";
    public String getMajor() {  return SqlTool.getDbString(major);  }
    public String getMajor(int size) { return SqlTool.subString(getMajor(), size); }
    public void setMajor(String aMajor) { major = aMajor; modifiedFields.add("Major"); }
    public void assignMajor(String aMajor) { major = aMajor; }
    public void paramMajor(HttpServletRequest request) { paramMajor(request, "Major"); }
    public void paramMajor(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMajor()); if (!tmp.equals(getMajor())) { setMajor(tmp); } }
    // 学制
    protected String lenOfSchool = "";
    public String getLenOfSchool() {  return SqlTool.getDbString(lenOfSchool);  }
    public String getLenOfSchool(int size) { return SqlTool.subString(getLenOfSchool(), size); }
    public void setLenOfSchool(String aLenOfSchool) { lenOfSchool = aLenOfSchool; modifiedFields.add("LenOfSchool"); }
    public void assignLenOfSchool(String aLenOfSchool) { lenOfSchool = aLenOfSchool; }
    public void paramLenOfSchool(HttpServletRequest request) { paramLenOfSchool(request, "LenOfSchool"); }
    public void paramLenOfSchool(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getLenOfSchool()); if (!tmp.equals(getLenOfSchool())) { setLenOfSchool(tmp); } }
    // 年级
    protected String grade = "";
    public String getGrade() {  return SqlTool.getDbString(grade);  }
    public String getGrade(int size) { return SqlTool.subString(getGrade(), size); }
    public void setGrade(String aGrade) { grade = aGrade; modifiedFields.add("Grade"); }
    public void assignGrade(String aGrade) { grade = aGrade; }
    public void paramGrade(HttpServletRequest request) { paramGrade(request, "Grade"); }
    public void paramGrade(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGrade()); if (!tmp.equals(getGrade())) { setGrade(tmp); } }
    // 政治面貌
    protected String polista = "";
    public String getPolista() {  return SqlTool.getDbString(polista);  }
    public String getPolista(int size) { return SqlTool.subString(getPolista(), size); }
    public void setPolista(String aPolista) { polista = aPolista; modifiedFields.add("Polista"); }
    public void assignPolista(String aPolista) { polista = aPolista; }
    public void paramPolista(HttpServletRequest request) { paramPolista(request, "Polista"); }
    public void paramPolista(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPolista()); if (!tmp.equals(getPolista())) { setPolista(tmp); } }
    // 籍贯
    protected String nativePlace = "";
    public String getNativePlace() {  return SqlTool.getDbString(nativePlace);  }
    public String getNativePlace(int size) { return SqlTool.subString(getNativePlace(), size); }
    public void setNativePlace(String aNativePlace) { nativePlace = aNativePlace; modifiedFields.add("NativePlace"); }
    public void assignNativePlace(String aNativePlace) { nativePlace = aNativePlace; }
    public void paramNativePlace(HttpServletRequest request) { paramNativePlace(request, "NativePlace"); }
    public void paramNativePlace(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getNativePlace()); if (!tmp.equals(getNativePlace())) { setNativePlace(tmp); } }
    // 身份证号码
    protected String iDNum = "";
    public String getIDNum() {  return SqlTool.getDbString(iDNum);  }
    public String getIDNum(int size) { return SqlTool.subString(getIDNum(), size); }
    public void setIDNum(String aIDNum) { iDNum = aIDNum; modifiedFields.add("IDNum"); }
    public void assignIDNum(String aIDNum) { iDNum = aIDNum; }
    public void paramIDNum(HttpServletRequest request) { paramIDNum(request, "IDNum"); }
    public void paramIDNum(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIDNum()); if (!tmp.equals(getIDNum())) { setIDNum(tmp); } }
    // 手机
    protected String phone = "";
    public String getPhone() {  return SqlTool.getDbString(phone);  }
    public String getPhone(int size) { return SqlTool.subString(getPhone(), size); }
    public void setPhone(String aPhone) { phone = aPhone; modifiedFields.add("Phone"); }
    public void assignPhone(String aPhone) { phone = aPhone; }
    public void paramPhone(HttpServletRequest request) { paramPhone(request, "Phone"); }
    public void paramPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPhone()); if (!tmp.equals(getPhone())) { setPhone(tmp); } }
    // 邮箱
    protected String email = "";
    public String getEmail() {  return SqlTool.getDbString(email);  }
    public String getEmail(int size) { return SqlTool.subString(getEmail(), size); }
    public void setEmail(String aEmail) { email = aEmail; modifiedFields.add("Email"); }
    public void assignEmail(String aEmail) { email = aEmail; }
    public void paramEmail(HttpServletRequest request) { paramEmail(request, "Email"); }
    public void paramEmail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getEmail()); if (!tmp.equals(getEmail())) { setEmail(tmp); } }
    // 附件
    protected String addfilelist = "";
    public String getAddfilelist() {  return SqlTool.getDbString(addfilelist);  }
    public String getAddfilelist(int size) { return SqlTool.subString(getAddfilelist(), size); }
    public void setAddfilelist(String aAddfilelist) { addfilelist = aAddfilelist; modifiedFields.add("Addfilelist"); }
    public void assignAddfilelist(String aAddfilelist) { addfilelist = aAddfilelist; }
    public void paramAddfilelist(HttpServletRequest request) { paramAddfilelist(request, "Addfilelist"); }
    public void paramAddfilelist(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddfilelist()); if (!tmp.equals(getAddfilelist())) { setAddfilelist(tmp); } }
    // 学年
    protected String yearToSchool = "";
    public String getYearToSchool() {  return SqlTool.getDbString(yearToSchool);  }
    public String getYearToSchool(int size) { return SqlTool.subString(getYearToSchool(), size); }
    public void setYearToSchool(String aYearToSchool) { yearToSchool = aYearToSchool; modifiedFields.add("YearToSchool"); }
    public void assignYearToSchool(String aYearToSchool) { yearToSchool = aYearToSchool; }
    public void paramYearToSchool(HttpServletRequest request) { paramYearToSchool(request, "YearToSchool"); }
    public void paramYearToSchool(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getYearToSchool()); if (!tmp.equals(getYearToSchool())) { setYearToSchool(tmp); } }
    // 毕业时间
    protected java.util.Date graduateTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getGraduateTime() { return graduateTime; }
    public void setGraduateTime(java.util.Date aGraduateTime) { graduateTime = aGraduateTime; modifiedFields.add("GraduateTime"); }
    public void assignGraduateTime(java.util.Date aGraduateTime) { graduateTime = aGraduateTime; }
    public void paramGraduateTime(HttpServletRequest request) { paramGraduateTime(request, "GraduateTime"); }
    public void paramGraduateTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getGraduateTime()); if (tmp.compareTo(getGraduateTime()) != 0) { setGraduateTime(tmp); } }
    // 是否青年志愿者
    protected String volunteerfFag = "";
    public String getVolunteerfFag() {  return SqlTool.getDbString(volunteerfFag);  }
    public String getVolunteerfFag(int size) { return SqlTool.subString(getVolunteerfFag(), size); }
    public void setVolunteerfFag(String aVolunteerfFag) { volunteerfFag = aVolunteerfFag; modifiedFields.add("VolunteerfFag"); }
    public void assignVolunteerfFag(String aVolunteerfFag) { volunteerfFag = aVolunteerfFag; }
    public void paramVolunteerfFag(HttpServletRequest request) { paramVolunteerfFag(request, "VolunteerfFag"); }
    public void paramVolunteerfFag(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVolunteerfFag()); if (!tmp.equals(getVolunteerfFag())) { setVolunteerfFag(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public Students (String db) {
        DBNAME = db;
    }
    public Students (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public Students (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public Students () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return Students类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public Students getByParameter(HttpServletRequest request) {
        Students v = new Students(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramSno(request);
        paramSName(request);
        paramSSex(request);
        paramSacademy(request);
        paramTimeToSchool(request);
        paramTimeToTuan(request);
        paramBirthday(request);
        paramZhiBu(request);
        paramNation(request);
        paramMajor(request);
        paramLenOfSchool(request);
        paramGrade(request);
        paramPolista(request);
        paramNativePlace(request);
        paramIDNum(request);
        paramPhone(request);
        paramEmail(request);
        paramAddfilelist(request);
        paramYearToSchool(request);
        paramGraduateTime(request);
        paramVolunteerfFag(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(Students bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("sno")) { setSno(bean.getSno()); }
        if (!ncl.contains("sName")) { setSName(bean.getSName()); }
        if (!ncl.contains("sSex")) { setSSex(bean.getSSex()); }
        if (!ncl.contains("sacademy")) { setSacademy(bean.getSacademy()); }
        if (!ncl.contains("timeToSchool")) { setTimeToSchool(bean.getTimeToSchool()); }
        if (!ncl.contains("timeToTuan")) { setTimeToTuan(bean.getTimeToTuan()); }
        if (!ncl.contains("birthday")) { setBirthday(bean.getBirthday()); }
        if (!ncl.contains("zhiBu")) { setZhiBu(bean.getZhiBu()); }
        if (!ncl.contains("nation")) { setNation(bean.getNation()); }
        if (!ncl.contains("major")) { setMajor(bean.getMajor()); }
        if (!ncl.contains("lenOfSchool")) { setLenOfSchool(bean.getLenOfSchool()); }
        if (!ncl.contains("grade")) { setGrade(bean.getGrade()); }
        if (!ncl.contains("polista")) { setPolista(bean.getPolista()); }
        if (!ncl.contains("nativePlace")) { setNativePlace(bean.getNativePlace()); }
        if (!ncl.contains("iDNum")) { setIDNum(bean.getIDNum()); }
        if (!ncl.contains("phone")) { setPhone(bean.getPhone()); }
        if (!ncl.contains("email")) { setEmail(bean.getEmail()); }
        if (!ncl.contains("addfilelist")) { setAddfilelist(bean.getAddfilelist()); }
        if (!ncl.contains("yearToSchool")) { setYearToSchool(bean.getYearToSchool()); }
        if (!ncl.contains("graduateTime")) { setGraduateTime(bean.getGraduateTime()); }
        if (!ncl.contains("volunteerfFag")) { setVolunteerfFag(bean.getVolunteerfFag()); }
    }
    public Students getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        Students[] rslt= queryByCondition(cdt);
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
     * @return Students类的实例列表。
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
                Students ve = new Students(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignSno(fromDbCh(rs.getString(2)));
                ve.assignSName(fromDbCh(rs.getString(3)));
                ve.assignSSex(fromDbCh(rs.getString(4)));
                ve.assignSacademy(fromDbCh(rs.getString(5)));
                tmpDate = rs.getTimestamp(6); if (tmpDate != null) { ve.assignTimeToSchool(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(7); if (tmpDate != null) { ve.assignTimeToTuan(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(8); if (tmpDate != null) { ve.assignBirthday(new java.util.Date(tmpDate.getTime())); }
                ve.assignZhiBu(fromDbCh(rs.getString(9)));
                ve.assignNation(fromDbCh(rs.getString(10)));
                ve.assignMajor(fromDbCh(rs.getString(11)));
                ve.assignLenOfSchool(fromDbCh(rs.getString(12)));
                ve.assignGrade(fromDbCh(rs.getString(13)));
                ve.assignPolista(fromDbCh(rs.getString(14)));
                ve.assignNativePlace(fromDbCh(rs.getString(15)));
                ve.assignIDNum(fromDbCh(rs.getString(16)));
                ve.assignPhone(fromDbCh(rs.getString(17)));
                ve.assignEmail(fromDbCh(rs.getString(18)));
                ve.assignAddfilelist(fromDbCh(rs.getString(19)));
                ve.assignYearToSchool(fromDbCh(rs.getString(20)));
                tmpDate = rs.getTimestamp(21); if (tmpDate != null) { ve.assignGraduateTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignVolunteerfFag(fromDbCh(rs.getString(22)));
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
    public Students[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (Students[])vrs.toArray(new Students[vrs.size()]);
    }
    public Students[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (Students[])vrs.toArray(new Students[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (sno,sname,ssex,sacademy,timetoschool,timetotuan,birthday,zhibu,nation,major,lenofschool,grade,polista,nativeplace,idnum,phone,email,addfilelist,yeartoschool,graduatetime,volunteerffag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(sno));
            pstmt.setString(2, toDbCh(sName));
            pstmt.setString(3, toDbCh(sSex));
            pstmt.setString(4, toDbCh(sacademy));
            pstmt.setTimestamp(5, new java.sql.Timestamp(timeToSchool.getTime()));
            pstmt.setTimestamp(6, new java.sql.Timestamp(timeToTuan.getTime()));
            pstmt.setTimestamp(7, new java.sql.Timestamp(birthday.getTime()));
            pstmt.setString(8, toDbCh(zhiBu));
            pstmt.setString(9, toDbCh(nation));
            pstmt.setString(10, toDbCh(major));
            pstmt.setString(11, toDbCh(lenOfSchool));
            pstmt.setString(12, toDbCh(grade));
            pstmt.setString(13, toDbCh(polista));
            pstmt.setString(14, toDbCh(nativePlace));
            pstmt.setString(15, toDbCh(iDNum));
            pstmt.setString(16, toDbCh(phone));
            pstmt.setString(17, toDbCh(email));
            pstmt.setString(18, toDbCh(addfilelist));
            pstmt.setString(19, toDbCh(yearToSchool));
            pstmt.setTimestamp(20, new java.sql.Timestamp(graduateTime.getTime()));
            pstmt.setString(21, toDbCh(volunteerfFag));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,sno,sname,ssex,sacademy,timetoschool,timetotuan,birthday,zhibu,nation,major,lenofschool,grade,polista,nativeplace,idnum,phone,email,addfilelist,yeartoschool,graduatetime,volunteerffag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(sno));
            pstmt.setString(3, toDbCh(sName));
            pstmt.setString(4, toDbCh(sSex));
            pstmt.setString(5, toDbCh(sacademy));
            pstmt.setTimestamp(6, new java.sql.Timestamp(timeToSchool.getTime()));
            pstmt.setTimestamp(7, new java.sql.Timestamp(timeToTuan.getTime()));
            pstmt.setTimestamp(8, new java.sql.Timestamp(birthday.getTime()));
            pstmt.setString(9, toDbCh(zhiBu));
            pstmt.setString(10, toDbCh(nation));
            pstmt.setString(11, toDbCh(major));
            pstmt.setString(12, toDbCh(lenOfSchool));
            pstmt.setString(13, toDbCh(grade));
            pstmt.setString(14, toDbCh(polista));
            pstmt.setString(15, toDbCh(nativePlace));
            pstmt.setString(16, toDbCh(iDNum));
            pstmt.setString(17, toDbCh(phone));
            pstmt.setString(18, toDbCh(email));
            pstmt.setString(19, toDbCh(addfilelist));
            pstmt.setString(20, toDbCh(yearToSchool));
            pstmt.setTimestamp(21, new java.sql.Timestamp(graduateTime.getTime()));
            pstmt.setString(22, toDbCh(volunteerfFag));
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
            Students item = (Students)it.next();
            Students v = new Students(dbname);
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
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("SName")) { pstmt.setString(pi ++, toDbCh(sName)); }
                if (modifiedFields.contains("SSex")) { pstmt.setString(pi ++, toDbCh(sSex)); }
                if (modifiedFields.contains("Sacademy")) { pstmt.setString(pi ++, toDbCh(sacademy)); }
                if (modifiedFields.contains("TimeToSchool")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(timeToSchool.getTime())); }
                if (modifiedFields.contains("TimeToTuan")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(timeToTuan.getTime())); }
                if (modifiedFields.contains("Birthday")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(birthday.getTime())); }
                if (modifiedFields.contains("ZhiBu")) { pstmt.setString(pi ++, toDbCh(zhiBu)); }
                if (modifiedFields.contains("Nation")) { pstmt.setString(pi ++, toDbCh(nation)); }
                if (modifiedFields.contains("Major")) { pstmt.setString(pi ++, toDbCh(major)); }
                if (modifiedFields.contains("LenOfSchool")) { pstmt.setString(pi ++, toDbCh(lenOfSchool)); }
                if (modifiedFields.contains("Grade")) { pstmt.setString(pi ++, toDbCh(grade)); }
                if (modifiedFields.contains("Polista")) { pstmt.setString(pi ++, toDbCh(polista)); }
                if (modifiedFields.contains("NativePlace")) { pstmt.setString(pi ++, toDbCh(nativePlace)); }
                if (modifiedFields.contains("IDNum")) { pstmt.setString(pi ++, toDbCh(iDNum)); }
                if (modifiedFields.contains("Phone")) { pstmt.setString(pi ++, toDbCh(phone)); }
                if (modifiedFields.contains("Email")) { pstmt.setString(pi ++, toDbCh(email)); }
                if (modifiedFields.contains("Addfilelist")) { pstmt.setString(pi ++, toDbCh(addfilelist)); }
                if (modifiedFields.contains("YearToSchool")) { pstmt.setString(pi ++, toDbCh(yearToSchool)); }
                if (modifiedFields.contains("GraduateTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(graduateTime.getTime())); }
                if (modifiedFields.contains("VolunteerfFag")) { pstmt.setString(pi ++, toDbCh(volunteerfFag)); }
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
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("SName")) { pstmt.setString(pi ++, toDbCh(sName)); }
                if (modifiedFields.contains("SSex")) { pstmt.setString(pi ++, toDbCh(sSex)); }
                if (modifiedFields.contains("Sacademy")) { pstmt.setString(pi ++, toDbCh(sacademy)); }
                if (modifiedFields.contains("TimeToSchool")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(timeToSchool.getTime())); }
                if (modifiedFields.contains("TimeToTuan")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(timeToTuan.getTime())); }
                if (modifiedFields.contains("Birthday")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(birthday.getTime())); }
                if (modifiedFields.contains("ZhiBu")) { pstmt.setString(pi ++, toDbCh(zhiBu)); }
                if (modifiedFields.contains("Nation")) { pstmt.setString(pi ++, toDbCh(nation)); }
                if (modifiedFields.contains("Major")) { pstmt.setString(pi ++, toDbCh(major)); }
                if (modifiedFields.contains("LenOfSchool")) { pstmt.setString(pi ++, toDbCh(lenOfSchool)); }
                if (modifiedFields.contains("Grade")) { pstmt.setString(pi ++, toDbCh(grade)); }
                if (modifiedFields.contains("Polista")) { pstmt.setString(pi ++, toDbCh(polista)); }
                if (modifiedFields.contains("NativePlace")) { pstmt.setString(pi ++, toDbCh(nativePlace)); }
                if (modifiedFields.contains("IDNum")) { pstmt.setString(pi ++, toDbCh(iDNum)); }
                if (modifiedFields.contains("Phone")) { pstmt.setString(pi ++, toDbCh(phone)); }
                if (modifiedFields.contains("Email")) { pstmt.setString(pi ++, toDbCh(email)); }
                if (modifiedFields.contains("Addfilelist")) { pstmt.setString(pi ++, toDbCh(addfilelist)); }
                if (modifiedFields.contains("YearToSchool")) { pstmt.setString(pi ++, toDbCh(yearToSchool)); }
                if (modifiedFields.contains("GraduateTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(graduateTime.getTime())); }
                if (modifiedFields.contains("VolunteerfFag")) { pstmt.setString(pi ++, toDbCh(volunteerfFag)); }
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
        map.put("Sno", getSno());
        map.put("SName", getSName());
        map.put("SSex", getSSex());
        map.put("Sacademy", getSacademy());
        map.put("TimeToSchool", Tool.stringOfDateTime(getTimeToSchool()));
        map.put("TimeToTuan", Tool.stringOfDateTime(getTimeToTuan()));
        map.put("Birthday", Tool.stringOfDateTime(getBirthday()));
        map.put("ZhiBu", getZhiBu());
        map.put("Nation", getNation());
        map.put("Major", getMajor());
        map.put("LenOfSchool", getLenOfSchool());
        map.put("Grade", getGrade());
        map.put("Polista", getPolista());
        map.put("NativePlace", getNativePlace());
        map.put("IDNum", getIDNum());
        map.put("Phone", getPhone());
        map.put("Email", getEmail());
        map.put("Addfilelist", getAddfilelist());
        map.put("YearToSchool", getYearToSchool());
        map.put("GraduateTime", Tool.stringOfDateTime(getGraduateTime()));
        map.put("VolunteerfFag", getVolunteerfFag());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("Sno:\"" + Tool.jsSpecialChars(getSno()) + "\"");
        row.add("SName:\"" + Tool.jsSpecialChars(getSName()) + "\"");
        row.add("SSex:\"" + Tool.jsSpecialChars(getSSex()) + "\"");
        row.add("Sacademy:\"" + Tool.jsSpecialChars(getSacademy()) + "\"");
        row.add("TimeToSchool:\"" + Tool.stringOfDateTime(getTimeToSchool()) + "\"");
        row.add("TimeToTuan:\"" + Tool.stringOfDateTime(getTimeToTuan()) + "\"");
        row.add("Birthday:\"" + Tool.stringOfDateTime(getBirthday()) + "\"");
        row.add("ZhiBu:\"" + Tool.jsSpecialChars(getZhiBu()) + "\"");
        row.add("Nation:\"" + Tool.jsSpecialChars(getNation()) + "\"");
        row.add("Major:\"" + Tool.jsSpecialChars(getMajor()) + "\"");
        row.add("LenOfSchool:\"" + Tool.jsSpecialChars(getLenOfSchool()) + "\"");
        row.add("Grade:\"" + Tool.jsSpecialChars(getGrade()) + "\"");
        row.add("Polista:\"" + Tool.jsSpecialChars(getPolista()) + "\"");
        row.add("NativePlace:\"" + Tool.jsSpecialChars(getNativePlace()) + "\"");
        row.add("IDNum:\"" + Tool.jsSpecialChars(getIDNum()) + "\"");
        row.add("Phone:\"" + Tool.jsSpecialChars(getPhone()) + "\"");
        row.add("Email:\"" + Tool.jsSpecialChars(getEmail()) + "\"");
        row.add("Addfilelist:\"" + Tool.jsSpecialChars(getAddfilelist()) + "\"");
        row.add("YearToSchool:\"" + Tool.jsSpecialChars(getYearToSchool()) + "\"");
        row.add("GraduateTime:\"" + Tool.stringOfDateTime(getGraduateTime()) + "\"");
        row.add("VolunteerfFag:\"" + Tool.jsSpecialChars(getVolunteerfFag()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,sno varchar2(45) not null,sname varchar2(50),ssex varchar2(2),sacademy varchar2(50),timetoschool date,timetotuan date,birthday date,zhibu varchar2(50),nation varchar2(50),major varchar2(50),lenofschool varchar2(50),grade varchar2(50),polista varchar2(3),nativeplace varchar2(50),idnum varchar2(50),phone varchar2(50),email varchar2(50),addfilelist varchar2(50),yeartoschool varchar2(2000),graduatetime date,volunteerffag varchar2(2))"});
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
        Students v = new Students(sourceDb, sourceTb);
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
        Students v = new Students(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(Students obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getSno().compareTo(obj.getSno()); if (rtn != 0) return rtn;
        rtn = getSName().compareTo(obj.getSName()); if (rtn != 0) return rtn;
        rtn = getSSex().compareTo(obj.getSSex()); if (rtn != 0) return rtn;
        rtn = getSacademy().compareTo(obj.getSacademy()); if (rtn != 0) return rtn;
        rtn = getTimeToSchool().compareTo(obj.getTimeToSchool()); if (rtn != 0) return rtn;
        rtn = getTimeToTuan().compareTo(obj.getTimeToTuan()); if (rtn != 0) return rtn;
        rtn = getBirthday().compareTo(obj.getBirthday()); if (rtn != 0) return rtn;
        rtn = getZhiBu().compareTo(obj.getZhiBu()); if (rtn != 0) return rtn;
        rtn = getNation().compareTo(obj.getNation()); if (rtn != 0) return rtn;
        rtn = getMajor().compareTo(obj.getMajor()); if (rtn != 0) return rtn;
        rtn = getLenOfSchool().compareTo(obj.getLenOfSchool()); if (rtn != 0) return rtn;
        rtn = getGrade().compareTo(obj.getGrade()); if (rtn != 0) return rtn;
        rtn = getPolista().compareTo(obj.getPolista()); if (rtn != 0) return rtn;
        rtn = getNativePlace().compareTo(obj.getNativePlace()); if (rtn != 0) return rtn;
        rtn = getIDNum().compareTo(obj.getIDNum()); if (rtn != 0) return rtn;
        rtn = getPhone().compareTo(obj.getPhone()); if (rtn != 0) return rtn;
        rtn = getEmail().compareTo(obj.getEmail()); if (rtn != 0) return rtn;
        rtn = getAddfilelist().compareTo(obj.getAddfilelist()); if (rtn != 0) return rtn;
        rtn = getYearToSchool().compareTo(obj.getYearToSchool()); if (rtn != 0) return rtn;
        rtn = getGraduateTime().compareTo(obj.getGraduateTime()); if (rtn != 0) return rtn;
        rtn = getVolunteerfFag().compareTo(obj.getVolunteerfFag()); if (rtn != 0) return rtn;
        return rtn;
    }
}
