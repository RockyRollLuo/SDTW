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
@Description("学院表")
public class Academy implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(Academy.class);
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
    public static final String DbTableName = "academy";
    private String TNAME = "academy";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","academyName","academyalias","listOrder","addPerson","addTime","modiPerson","modiTime","leaguecount","acadeMySecretary","acadePutySecretary","acaorgPerson","acapublicity","acadeMyLevel","acadeMyPhone","acadeMyPlace","acadeMyeMail","youthXyReport","youthXyReportTime","youthModifyFlag","youthModifyTime","youthSchoolYear","youthPeriodTime","flag"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","academyname","academyalias","listorder","addperson","addtime","modiperson","moditime","leaguecount","academysecretary","acadeputysecretary","acaorgperson","acapublicity","academylevel","academyphone","academyplace","academyemail","youthxyreport","youthxyreporttime","youthmodifyflag","youthmodifytime","youthschoolyear","youthperiodtime","flag"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"AcademyName","academyname","String"},{"Academyalias","academyalias","String"},{"ListOrder","listorder","int"},{"AddPerson","addperson","String"},{"AddTime","addtime","String"},{"ModiPerson","modiperson","String"},{"ModiTime","moditime","java.util.Date"},{"Leaguecount","leaguecount","int"},{"AcadeMySecretary","academysecretary","String"},{"AcadePutySecretary","acadeputysecretary","String"},{"AcaorgPerson","acaorgperson","String"},{"Acapublicity","acapublicity","String"},{"AcadeMyLevel","academylevel","String"},{"AcadeMyPhone","academyphone","String"},{"AcadeMyPlace","academyplace","String"},{"AcadeMyeMail","academyemail","String"},{"YouthXyReport","youthxyreport","String"},{"YouthXyReportTime","youthxyreporttime","java.util.Date"},{"YouthModifyFlag","youthmodifyflag","String"},{"YouthModifyTime","youthmodifytime","java.util.Date"},{"YouthSchoolYear","youthschoolyear","String"},{"YouthPeriodTime","youthperiodtime","String"},{"Flag","flag","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"academyName","academyname"},{"academyalias","academyalias"},{"listOrder","listorder"},{"addPerson","addperson"},{"addTime","addtime"},{"modiPerson","modiperson"},{"modiTime","moditime"},{"leaguecount","leaguecount"},{"acadeMySecretary","academysecretary"},{"acadePutySecretary","acadeputysecretary"},{"acaorgPerson","acaorgperson"},{"acapublicity","acapublicity"},{"acadeMyLevel","academylevel"},{"acadeMyPhone","academyphone"},{"acadeMyPlace","academyplace"},{"acadeMyeMail","academyemail"},{"youthXyReport","youthxyreport"},{"youthXyReportTime","youthxyreporttime"},{"youthModifyFlag","youthmodifyflag"},{"youthModifyTime","youthmodifytime"},{"youthSchoolYear","youthschoolyear"},{"youthPeriodTime","youthperiodtime"},{"flag","flag"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"MODITIME","YOUTHXYREPORTTIME","YOUTHMODIFYTIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 学院名称
    protected String academyName = "";
    public String getAcademyName() {  return SqlTool.getDbString(academyName);  }
    public String getAcademyName(int size) { return SqlTool.subString(getAcademyName(), size); }
    public void setAcademyName(String aAcademyName) { academyName = aAcademyName; modifiedFields.add("AcademyName"); refreshFlag = true; }
    public void assignAcademyName(String aAcademyName) { academyName = aAcademyName; }
    public void paramAcademyName(HttpServletRequest request) { paramAcademyName(request, "AcademyName"); }
    public void paramAcademyName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademyName()); if (!tmp.equals(getAcademyName())) { setAcademyName(tmp); } }
    // 别名
    protected String academyalias = "";
    public String getAcademyalias() {  return SqlTool.getDbString(academyalias);  }
    public String getAcademyalias(int size) { return SqlTool.subString(getAcademyalias(), size); }
    public void setAcademyalias(String aAcademyalias) { academyalias = aAcademyalias; modifiedFields.add("Academyalias"); refreshFlag = true; }
    public void assignAcademyalias(String aAcademyalias) { academyalias = aAcademyalias; }
    public void paramAcademyalias(HttpServletRequest request) { paramAcademyalias(request, "Academyalias"); }
    public void paramAcademyalias(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademyalias()); if (!tmp.equals(getAcademyalias())) { setAcademyalias(tmp); } }
    // 排序
    protected int listOrder = -1;
    public int getListOrder() { return listOrder; }
    public void setListOrder(int aListOrder) { listOrder = aListOrder; modifiedFields.add("ListOrder"); }
    public void assignListOrder(int aListOrder) { listOrder = aListOrder; }
    public void paramListOrder(HttpServletRequest request) { paramListOrder(request, "ListOrder"); }
    public void paramListOrder(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getListOrder()); if (tmp != getListOrder()) { setListOrder(tmp); } }
    // 添加人
    protected String addPerson = "";
    public String getAddPerson() {  return SqlTool.getDbString(addPerson);  }
    public String getAddPerson(int size) { return SqlTool.subString(getAddPerson(), size); }
    public void setAddPerson(String aAddPerson) { addPerson = aAddPerson; modifiedFields.add("AddPerson"); }
    public void assignAddPerson(String aAddPerson) { addPerson = aAddPerson; }
    public void paramAddPerson(HttpServletRequest request) { paramAddPerson(request, "AddPerson"); }
    public void paramAddPerson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddPerson()); if (!tmp.equals(getAddPerson())) { setAddPerson(tmp); } }
    // 添加时间
    protected String addTime = "";
    public String getAddTime() {  return SqlTool.getDbString(addTime);  }
    public String getAddTime(int size) { return SqlTool.subString(getAddTime(), size); }
    public void setAddTime(String aAddTime) { addTime = aAddTime; modifiedFields.add("AddTime"); }
    public void assignAddTime(String aAddTime) { addTime = aAddTime; }
    public void paramAddTime(HttpServletRequest request) { paramAddTime(request, "AddTime"); }
    public void paramAddTime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddTime()); if (!tmp.equals(getAddTime())) { setAddTime(tmp); } }
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
    // 学院名称
    protected int leaguecount = -1;
    public int getLeaguecount() { return leaguecount; }
    public void setLeaguecount(int aLeaguecount) { leaguecount = aLeaguecount; modifiedFields.add("Leaguecount"); }
    public void assignLeaguecount(int aLeaguecount) { leaguecount = aLeaguecount; }
    public void paramLeaguecount(HttpServletRequest request) { paramLeaguecount(request, "Leaguecount"); }
    public void paramLeaguecount(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getLeaguecount()); if (tmp != getLeaguecount()) { setLeaguecount(tmp); } }
    // 团支部数（班级数）
    protected String acadeMySecretary = "";
    public String getAcadeMySecretary() {  return SqlTool.getDbString(acadeMySecretary);  }
    public String getAcadeMySecretary(int size) { return SqlTool.subString(getAcadeMySecretary(), size); }
    public void setAcadeMySecretary(String aAcadeMySecretary) { acadeMySecretary = aAcadeMySecretary; modifiedFields.add("AcadeMySecretary"); }
    public void assignAcadeMySecretary(String aAcadeMySecretary) { acadeMySecretary = aAcadeMySecretary; }
    public void paramAcadeMySecretary(HttpServletRequest request) { paramAcadeMySecretary(request, "AcadeMySecretary"); }
    public void paramAcadeMySecretary(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcadeMySecretary()); if (!tmp.equals(getAcadeMySecretary())) { setAcadeMySecretary(tmp); } }
    // 团委副书记
    protected String acadePutySecretary = "";
    public String getAcadePutySecretary() {  return SqlTool.getDbString(acadePutySecretary);  }
    public String getAcadePutySecretary(int size) { return SqlTool.subString(getAcadePutySecretary(), size); }
    public void setAcadePutySecretary(String aAcadePutySecretary) { acadePutySecretary = aAcadePutySecretary; modifiedFields.add("AcadePutySecretary"); }
    public void assignAcadePutySecretary(String aAcadePutySecretary) { acadePutySecretary = aAcadePutySecretary; }
    public void paramAcadePutySecretary(HttpServletRequest request) { paramAcadePutySecretary(request, "AcadePutySecretary"); }
    public void paramAcadePutySecretary(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcadePutySecretary()); if (!tmp.equals(getAcadePutySecretary())) { setAcadePutySecretary(tmp); } }
    // 组织委员
    protected String acaorgPerson = "";
    public String getAcaorgPerson() {  return SqlTool.getDbString(acaorgPerson);  }
    public String getAcaorgPerson(int size) { return SqlTool.subString(getAcaorgPerson(), size); }
    public void setAcaorgPerson(String aAcaorgPerson) { acaorgPerson = aAcaorgPerson; modifiedFields.add("AcaorgPerson"); }
    public void assignAcaorgPerson(String aAcaorgPerson) { acaorgPerson = aAcaorgPerson; }
    public void paramAcaorgPerson(HttpServletRequest request) { paramAcaorgPerson(request, "AcaorgPerson"); }
    public void paramAcaorgPerson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcaorgPerson()); if (!tmp.equals(getAcaorgPerson())) { setAcaorgPerson(tmp); } }
    // 宣传委员
    protected String acapublicity = "";
    public String getAcapublicity() {  return SqlTool.getDbString(acapublicity);  }
    public String getAcapublicity(int size) { return SqlTool.subString(getAcapublicity(), size); }
    public void setAcapublicity(String aAcapublicity) { acapublicity = aAcapublicity; modifiedFields.add("Acapublicity"); }
    public void assignAcapublicity(String aAcapublicity) { acapublicity = aAcapublicity; }
    public void paramAcapublicity(HttpServletRequest request) { paramAcapublicity(request, "Acapublicity"); }
    public void paramAcapublicity(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcapublicity()); if (!tmp.equals(getAcapublicity())) { setAcapublicity(tmp); } }
    // 支部等级
    protected String acadeMyLevel = "";
    public String getAcadeMyLevel() {  return SqlTool.getDbString(acadeMyLevel);  }
    public String getAcadeMyLevel(int size) { return SqlTool.subString(getAcadeMyLevel(), size); }
    public void setAcadeMyLevel(String aAcadeMyLevel) { acadeMyLevel = aAcadeMyLevel; modifiedFields.add("AcadeMyLevel"); }
    public void assignAcadeMyLevel(String aAcadeMyLevel) { acadeMyLevel = aAcadeMyLevel; }
    public void paramAcadeMyLevel(HttpServletRequest request) { paramAcadeMyLevel(request, "AcadeMyLevel"); }
    public void paramAcadeMyLevel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcadeMyLevel()); if (!tmp.equals(getAcadeMyLevel())) { setAcadeMyLevel(tmp); } }
    // 办公电话
    protected String acadeMyPhone = "";
    public String getAcadeMyPhone() {  return SqlTool.getDbString(acadeMyPhone);  }
    public String getAcadeMyPhone(int size) { return SqlTool.subString(getAcadeMyPhone(), size); }
    public void setAcadeMyPhone(String aAcadeMyPhone) { acadeMyPhone = aAcadeMyPhone; modifiedFields.add("AcadeMyPhone"); }
    public void assignAcadeMyPhone(String aAcadeMyPhone) { acadeMyPhone = aAcadeMyPhone; }
    public void paramAcadeMyPhone(HttpServletRequest request) { paramAcadeMyPhone(request, "AcadeMyPhone"); }
    public void paramAcadeMyPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcadeMyPhone()); if (!tmp.equals(getAcadeMyPhone())) { setAcadeMyPhone(tmp); } }
    // 办公地点
    protected String acadeMyPlace = "";
    public String getAcadeMyPlace() {  return SqlTool.getDbString(acadeMyPlace);  }
    public String getAcadeMyPlace(int size) { return SqlTool.subString(getAcadeMyPlace(), size); }
    public void setAcadeMyPlace(String aAcadeMyPlace) { acadeMyPlace = aAcadeMyPlace; modifiedFields.add("AcadeMyPlace"); }
    public void assignAcadeMyPlace(String aAcadeMyPlace) { acadeMyPlace = aAcadeMyPlace; }
    public void paramAcadeMyPlace(HttpServletRequest request) { paramAcadeMyPlace(request, "AcadeMyPlace"); }
    public void paramAcadeMyPlace(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcadeMyPlace()); if (!tmp.equals(getAcadeMyPlace())) { setAcadeMyPlace(tmp); } }
    // 办公邮箱
    protected String acadeMyeMail = "";
    public String getAcadeMyeMail() {  return SqlTool.getDbString(acadeMyeMail);  }
    public String getAcadeMyeMail(int size) { return SqlTool.subString(getAcadeMyeMail(), size); }
    public void setAcadeMyeMail(String aAcadeMyeMail) { acadeMyeMail = aAcadeMyeMail; modifiedFields.add("AcadeMyeMail"); }
    public void assignAcadeMyeMail(String aAcadeMyeMail) { acadeMyeMail = aAcadeMyeMail; }
    public void paramAcadeMyeMail(HttpServletRequest request) { paramAcadeMyeMail(request, "AcadeMyeMail"); }
    public void paramAcadeMyeMail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcadeMyeMail()); if (!tmp.equals(getAcadeMyeMail())) { setAcadeMyeMail(tmp); } }
    // 54青年表彰提交
    protected String youthXyReport = "";
    public String getYouthXyReport() {  return SqlTool.getDbString(youthXyReport);  }
    public String getYouthXyReport(int size) { return SqlTool.subString(getYouthXyReport(), size); }
    public void setYouthXyReport(String aYouthXyReport) { youthXyReport = aYouthXyReport; modifiedFields.add("YouthXyReport"); }
    public void assignYouthXyReport(String aYouthXyReport) { youthXyReport = aYouthXyReport; }
    public void paramYouthXyReport(HttpServletRequest request) { paramYouthXyReport(request, "YouthXyReport"); }
    public void paramYouthXyReport(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getYouthXyReport()); if (!tmp.equals(getYouthXyReport())) { setYouthXyReport(tmp); } }
    // 54青年表彰学院提交时间
    protected java.util.Date youthXyReportTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getYouthXyReportTime() { return youthXyReportTime; }
    public void setYouthXyReportTime(java.util.Date aYouthXyReportTime) { youthXyReportTime = aYouthXyReportTime; modifiedFields.add("YouthXyReportTime"); }
    public void assignYouthXyReportTime(java.util.Date aYouthXyReportTime) { youthXyReportTime = aYouthXyReportTime; }
    public void paramYouthXyReportTime(HttpServletRequest request) { paramYouthXyReportTime(request, "YouthXyReportTime"); }
    public void paramYouthXyReportTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getYouthXyReportTime()); if (tmp.compareTo(getYouthXyReportTime()) != 0) { setYouthXyReportTime(tmp); } }
    // 54青年表彰修改
    protected String youthModifyFlag = "";
    public String getYouthModifyFlag() {  return SqlTool.getDbString(youthModifyFlag);  }
    public String getYouthModifyFlag(int size) { return SqlTool.subString(getYouthModifyFlag(), size); }
    public void setYouthModifyFlag(String aYouthModifyFlag) { youthModifyFlag = aYouthModifyFlag; modifiedFields.add("YouthModifyFlag"); }
    public void assignYouthModifyFlag(String aYouthModifyFlag) { youthModifyFlag = aYouthModifyFlag; }
    public void paramYouthModifyFlag(HttpServletRequest request) { paramYouthModifyFlag(request, "YouthModifyFlag"); }
    public void paramYouthModifyFlag(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getYouthModifyFlag()); if (!tmp.equals(getYouthModifyFlag())) { setYouthModifyFlag(tmp); } }
    // 54青团表彰修改时间
    protected java.util.Date youthModifyTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getYouthModifyTime() { return youthModifyTime; }
    public void setYouthModifyTime(java.util.Date aYouthModifyTime) { youthModifyTime = aYouthModifyTime; modifiedFields.add("YouthModifyTime"); }
    public void assignYouthModifyTime(java.util.Date aYouthModifyTime) { youthModifyTime = aYouthModifyTime; }
    public void paramYouthModifyTime(HttpServletRequest request) { paramYouthModifyTime(request, "YouthModifyTime"); }
    public void paramYouthModifyTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getYouthModifyTime()); if (tmp.compareTo(getYouthModifyTime()) != 0) { setYouthModifyTime(tmp); } }
    // 54青年表彰学年
    protected String youthSchoolYear = "";
    public String getYouthSchoolYear() {  return SqlTool.getDbString(youthSchoolYear);  }
    public String getYouthSchoolYear(int size) { return SqlTool.subString(getYouthSchoolYear(), size); }
    public void setYouthSchoolYear(String aYouthSchoolYear) { youthSchoolYear = aYouthSchoolYear; modifiedFields.add("YouthSchoolYear"); }
    public void assignYouthSchoolYear(String aYouthSchoolYear) { youthSchoolYear = aYouthSchoolYear; }
    public void paramYouthSchoolYear(HttpServletRequest request) { paramYouthSchoolYear(request, "YouthSchoolYear"); }
    public void paramYouthSchoolYear(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getYouthSchoolYear()); if (!tmp.equals(getYouthSchoolYear())) { setYouthSchoolYear(tmp); } }
    // 学院设置54青年表彰周期
    protected String youthPeriodTime = "";
    public String getYouthPeriodTime() {  return SqlTool.getDbString(youthPeriodTime);  }
    public String getYouthPeriodTime(int size) { return SqlTool.subString(getYouthPeriodTime(), size); }
    public void setYouthPeriodTime(String aYouthPeriodTime) { youthPeriodTime = aYouthPeriodTime; modifiedFields.add("YouthPeriodTime"); }
    public void assignYouthPeriodTime(String aYouthPeriodTime) { youthPeriodTime = aYouthPeriodTime; }
    public void paramYouthPeriodTime(HttpServletRequest request) { paramYouthPeriodTime(request, "YouthPeriodTime"); }
    public void paramYouthPeriodTime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getYouthPeriodTime()); if (!tmp.equals(getYouthPeriodTime())) { setYouthPeriodTime(tmp); } }
    // 标识
    protected String flag = "";
    public String getFlag() {  return SqlTool.getDbString(flag);  }
    public String getFlag(int size) { return SqlTool.subString(getFlag(), size); }
    public void setFlag(String aFlag) { flag = aFlag; modifiedFields.add("Flag"); }
    public void assignFlag(String aFlag) { flag = aFlag; }
    public void paramFlag(HttpServletRequest request) { paramFlag(request, "Flag"); }
    public void paramFlag(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFlag()); if (!tmp.equals(getFlag())) { setFlag(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public Academy (String db) {
        DBNAME = db;
    }
    public Academy (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public Academy (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public Academy () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return Academy类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public Academy getByParameter(HttpServletRequest request) {
        Academy v = new Academy(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramAcademyName(request);
        paramAcademyalias(request);
        paramListOrder(request);
        paramAddPerson(request);
        paramAddTime(request);
        paramModiPerson(request);
        paramModiTime(request);
        paramLeaguecount(request);
        paramAcadeMySecretary(request);
        paramAcadePutySecretary(request);
        paramAcaorgPerson(request);
        paramAcapublicity(request);
        paramAcadeMyLevel(request);
        paramAcadeMyPhone(request);
        paramAcadeMyPlace(request);
        paramAcadeMyeMail(request);
        paramYouthXyReport(request);
        paramYouthXyReportTime(request);
        paramYouthModifyFlag(request);
        paramYouthModifyTime(request);
        paramYouthSchoolYear(request);
        paramYouthPeriodTime(request);
        paramFlag(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(Academy bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("academyName")) { setAcademyName(bean.getAcademyName()); }
        if (!ncl.contains("academyalias")) { setAcademyalias(bean.getAcademyalias()); }
        if (!ncl.contains("listOrder")) { setListOrder(bean.getListOrder()); }
        if (!ncl.contains("addPerson")) { setAddPerson(bean.getAddPerson()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("modiPerson")) { setModiPerson(bean.getModiPerson()); }
        if (!ncl.contains("modiTime")) { setModiTime(bean.getModiTime()); }
        if (!ncl.contains("leaguecount")) { setLeaguecount(bean.getLeaguecount()); }
        if (!ncl.contains("acadeMySecretary")) { setAcadeMySecretary(bean.getAcadeMySecretary()); }
        if (!ncl.contains("acadePutySecretary")) { setAcadePutySecretary(bean.getAcadePutySecretary()); }
        if (!ncl.contains("acaorgPerson")) { setAcaorgPerson(bean.getAcaorgPerson()); }
        if (!ncl.contains("acapublicity")) { setAcapublicity(bean.getAcapublicity()); }
        if (!ncl.contains("acadeMyLevel")) { setAcadeMyLevel(bean.getAcadeMyLevel()); }
        if (!ncl.contains("acadeMyPhone")) { setAcadeMyPhone(bean.getAcadeMyPhone()); }
        if (!ncl.contains("acadeMyPlace")) { setAcadeMyPlace(bean.getAcadeMyPlace()); }
        if (!ncl.contains("acadeMyeMail")) { setAcadeMyeMail(bean.getAcadeMyeMail()); }
        if (!ncl.contains("youthXyReport")) { setYouthXyReport(bean.getYouthXyReport()); }
        if (!ncl.contains("youthXyReportTime")) { setYouthXyReportTime(bean.getYouthXyReportTime()); }
        if (!ncl.contains("youthModifyFlag")) { setYouthModifyFlag(bean.getYouthModifyFlag()); }
        if (!ncl.contains("youthModifyTime")) { setYouthModifyTime(bean.getYouthModifyTime()); }
        if (!ncl.contains("youthSchoolYear")) { setYouthSchoolYear(bean.getYouthSchoolYear()); }
        if (!ncl.contains("youthPeriodTime")) { setYouthPeriodTime(bean.getYouthPeriodTime()); }
        if (!ncl.contains("flag")) { setFlag(bean.getFlag()); }
    }
    public Academy getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        Academy[] rslt= queryByCondition(cdt);
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
     * @return Academy类的实例列表。
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
                Academy ve = new Academy(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignAcademyName(fromDbCh(rs.getString(2)));
                ve.assignAcademyalias(fromDbCh(rs.getString(3)));
                ve.assignListOrder(rs.getInt(4));
                ve.assignAddPerson(fromDbCh(rs.getString(5)));
                ve.assignAddTime(fromDbCh(rs.getString(6)));
                ve.assignModiPerson(fromDbCh(rs.getString(7)));
                tmpDate = rs.getTimestamp(8); if (tmpDate != null) { ve.assignModiTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignLeaguecount(rs.getInt(9));
                ve.assignAcadeMySecretary(fromDbCh(rs.getString(10)));
                ve.assignAcadePutySecretary(fromDbCh(rs.getString(11)));
                ve.assignAcaorgPerson(fromDbCh(rs.getString(12)));
                ve.assignAcapublicity(fromDbCh(rs.getString(13)));
                ve.assignAcadeMyLevel(fromDbCh(rs.getString(14)));
                ve.assignAcadeMyPhone(fromDbCh(rs.getString(15)));
                ve.assignAcadeMyPlace(fromDbCh(rs.getString(16)));
                ve.assignAcadeMyeMail(fromDbCh(rs.getString(17)));
                ve.assignYouthXyReport(fromDbCh(rs.getString(18)));
                tmpDate = rs.getTimestamp(19); if (tmpDate != null) { ve.assignYouthXyReportTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignYouthModifyFlag(fromDbCh(rs.getString(20)));
                tmpDate = rs.getTimestamp(21); if (tmpDate != null) { ve.assignYouthModifyTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignYouthSchoolYear(fromDbCh(rs.getString(22)));
                ve.assignYouthPeriodTime(fromDbCh(rs.getString(23)));
                ve.assignFlag(fromDbCh(rs.getString(24)));
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
    public Academy[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (Academy[])vrs.toArray(new Academy[vrs.size()]);
    }
    public Academy[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (Academy[])vrs.toArray(new Academy[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (academyname,academyalias,listorder,addperson,addtime,modiperson,moditime,leaguecount,academysecretary,acadeputysecretary,acaorgperson,acapublicity,academylevel,academyphone,academyplace,academyemail,youthxyreport,youthxyreporttime,youthmodifyflag,youthmodifytime,youthschoolyear,youthperiodtime,flag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(academyName));
            pstmt.setString(2, toDbCh(academyalias));
            pstmt.setInt(3, listOrder);
            pstmt.setString(4, toDbCh(addPerson));
            pstmt.setString(5, toDbCh(addTime));
            pstmt.setString(6, toDbCh(modiPerson));
            pstmt.setTimestamp(7, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setInt(8, leaguecount);
            pstmt.setString(9, toDbCh(acadeMySecretary));
            pstmt.setString(10, toDbCh(acadePutySecretary));
            pstmt.setString(11, toDbCh(acaorgPerson));
            pstmt.setString(12, toDbCh(acapublicity));
            pstmt.setString(13, toDbCh(acadeMyLevel));
            pstmt.setString(14, toDbCh(acadeMyPhone));
            pstmt.setString(15, toDbCh(acadeMyPlace));
            pstmt.setString(16, toDbCh(acadeMyeMail));
            pstmt.setString(17, toDbCh(youthXyReport));
            pstmt.setTimestamp(18, new java.sql.Timestamp(youthXyReportTime.getTime()));
            pstmt.setString(19, toDbCh(youthModifyFlag));
            pstmt.setTimestamp(20, new java.sql.Timestamp(youthModifyTime.getTime()));
            pstmt.setString(21, toDbCh(youthSchoolYear));
            pstmt.setString(22, toDbCh(youthPeriodTime));
            pstmt.setString(23, toDbCh(flag));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.Academy");
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,academyname,academyalias,listorder,addperson,addtime,modiperson,moditime,leaguecount,academysecretary,acadeputysecretary,acaorgperson,acapublicity,academylevel,academyphone,academyplace,academyemail,youthxyreport,youthxyreporttime,youthmodifyflag,youthmodifytime,youthschoolyear,youthperiodtime,flag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(academyName));
            pstmt.setString(3, toDbCh(academyalias));
            pstmt.setInt(4, listOrder);
            pstmt.setString(5, toDbCh(addPerson));
            pstmt.setString(6, toDbCh(addTime));
            pstmt.setString(7, toDbCh(modiPerson));
            pstmt.setTimestamp(8, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setInt(9, leaguecount);
            pstmt.setString(10, toDbCh(acadeMySecretary));
            pstmt.setString(11, toDbCh(acadePutySecretary));
            pstmt.setString(12, toDbCh(acaorgPerson));
            pstmt.setString(13, toDbCh(acapublicity));
            pstmt.setString(14, toDbCh(acadeMyLevel));
            pstmt.setString(15, toDbCh(acadeMyPhone));
            pstmt.setString(16, toDbCh(acadeMyPlace));
            pstmt.setString(17, toDbCh(acadeMyeMail));
            pstmt.setString(18, toDbCh(youthXyReport));
            pstmt.setTimestamp(19, new java.sql.Timestamp(youthXyReportTime.getTime()));
            pstmt.setString(20, toDbCh(youthModifyFlag));
            pstmt.setTimestamp(21, new java.sql.Timestamp(youthModifyTime.getTime()));
            pstmt.setString(22, toDbCh(youthSchoolYear));
            pstmt.setString(23, toDbCh(youthPeriodTime));
            pstmt.setString(24, toDbCh(flag));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.Academy");
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
            Academy item = (Academy)it.next();
            Academy v = new Academy(dbname);
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
                if (modifiedFields.contains("AcademyName")) { pstmt.setString(pi ++, toDbCh(academyName)); }
                if (modifiedFields.contains("Academyalias")) { pstmt.setString(pi ++, toDbCh(academyalias)); }
                if (modifiedFields.contains("ListOrder")) { pstmt.setInt(pi ++, listOrder); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setString(pi ++, toDbCh(addTime)); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("Leaguecount")) { pstmt.setInt(pi ++, leaguecount); }
                if (modifiedFields.contains("AcadeMySecretary")) { pstmt.setString(pi ++, toDbCh(acadeMySecretary)); }
                if (modifiedFields.contains("AcadePutySecretary")) { pstmt.setString(pi ++, toDbCh(acadePutySecretary)); }
                if (modifiedFields.contains("AcaorgPerson")) { pstmt.setString(pi ++, toDbCh(acaorgPerson)); }
                if (modifiedFields.contains("Acapublicity")) { pstmt.setString(pi ++, toDbCh(acapublicity)); }
                if (modifiedFields.contains("AcadeMyLevel")) { pstmt.setString(pi ++, toDbCh(acadeMyLevel)); }
                if (modifiedFields.contains("AcadeMyPhone")) { pstmt.setString(pi ++, toDbCh(acadeMyPhone)); }
                if (modifiedFields.contains("AcadeMyPlace")) { pstmt.setString(pi ++, toDbCh(acadeMyPlace)); }
                if (modifiedFields.contains("AcadeMyeMail")) { pstmt.setString(pi ++, toDbCh(acadeMyeMail)); }
                if (modifiedFields.contains("YouthXyReport")) { pstmt.setString(pi ++, toDbCh(youthXyReport)); }
                if (modifiedFields.contains("YouthXyReportTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(youthXyReportTime.getTime())); }
                if (modifiedFields.contains("YouthModifyFlag")) { pstmt.setString(pi ++, toDbCh(youthModifyFlag)); }
                if (modifiedFields.contains("YouthModifyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(youthModifyTime.getTime())); }
                if (modifiedFields.contains("YouthSchoolYear")) { pstmt.setString(pi ++, toDbCh(youthSchoolYear)); }
                if (modifiedFields.contains("YouthPeriodTime")) { pstmt.setString(pi ++, toDbCh(youthPeriodTime)); }
                if (modifiedFields.contains("Flag")) { pstmt.setString(pi ++, toDbCh(flag)); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.Academy");
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
                if (modifiedFields.contains("AcademyName")) { pstmt.setString(pi ++, toDbCh(academyName)); }
                if (modifiedFields.contains("Academyalias")) { pstmt.setString(pi ++, toDbCh(academyalias)); }
                if (modifiedFields.contains("ListOrder")) { pstmt.setInt(pi ++, listOrder); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setString(pi ++, toDbCh(addTime)); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("Leaguecount")) { pstmt.setInt(pi ++, leaguecount); }
                if (modifiedFields.contains("AcadeMySecretary")) { pstmt.setString(pi ++, toDbCh(acadeMySecretary)); }
                if (modifiedFields.contains("AcadePutySecretary")) { pstmt.setString(pi ++, toDbCh(acadePutySecretary)); }
                if (modifiedFields.contains("AcaorgPerson")) { pstmt.setString(pi ++, toDbCh(acaorgPerson)); }
                if (modifiedFields.contains("Acapublicity")) { pstmt.setString(pi ++, toDbCh(acapublicity)); }
                if (modifiedFields.contains("AcadeMyLevel")) { pstmt.setString(pi ++, toDbCh(acadeMyLevel)); }
                if (modifiedFields.contains("AcadeMyPhone")) { pstmt.setString(pi ++, toDbCh(acadeMyPhone)); }
                if (modifiedFields.contains("AcadeMyPlace")) { pstmt.setString(pi ++, toDbCh(acadeMyPlace)); }
                if (modifiedFields.contains("AcadeMyeMail")) { pstmt.setString(pi ++, toDbCh(acadeMyeMail)); }
                if (modifiedFields.contains("YouthXyReport")) { pstmt.setString(pi ++, toDbCh(youthXyReport)); }
                if (modifiedFields.contains("YouthXyReportTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(youthXyReportTime.getTime())); }
                if (modifiedFields.contains("YouthModifyFlag")) { pstmt.setString(pi ++, toDbCh(youthModifyFlag)); }
                if (modifiedFields.contains("YouthModifyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(youthModifyTime.getTime())); }
                if (modifiedFields.contains("YouthSchoolYear")) { pstmt.setString(pi ++, toDbCh(youthSchoolYear)); }
                if (modifiedFields.contains("YouthPeriodTime")) { pstmt.setString(pi ++, toDbCh(youthPeriodTime)); }
                if (modifiedFields.contains("Flag")) { pstmt.setString(pi ++, toDbCh(flag)); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.Academy");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.Academy");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.Academy");
        return iResult;
    }
    public Map toMap() {
        Map map = new HashMap();
        map.put("Id", getId() + "");
        map.put("AcademyName", getAcademyName());
        map.put("Academyalias", getAcademyalias());
        map.put("ListOrder", getListOrder() + "");
        map.put("AddPerson", getAddPerson());
        map.put("AddTime", getAddTime());
        map.put("ModiPerson", getModiPerson());
        map.put("ModiTime", Tool.stringOfDateTime(getModiTime()));
        map.put("Leaguecount", getLeaguecount() + "");
        map.put("AcadeMySecretary", getAcadeMySecretary());
        map.put("AcadePutySecretary", getAcadePutySecretary());
        map.put("AcaorgPerson", getAcaorgPerson());
        map.put("Acapublicity", getAcapublicity());
        map.put("AcadeMyLevel", getAcadeMyLevel());
        map.put("AcadeMyPhone", getAcadeMyPhone());
        map.put("AcadeMyPlace", getAcadeMyPlace());
        map.put("AcadeMyeMail", getAcadeMyeMail());
        map.put("YouthXyReport", getYouthXyReport());
        map.put("YouthXyReportTime", Tool.stringOfDateTime(getYouthXyReportTime()));
        map.put("YouthModifyFlag", getYouthModifyFlag());
        map.put("YouthModifyTime", Tool.stringOfDateTime(getYouthModifyTime()));
        map.put("YouthSchoolYear", getYouthSchoolYear());
        map.put("YouthPeriodTime", getYouthPeriodTime());
        map.put("Flag", getFlag());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("AcademyName:\"" + Tool.jsSpecialChars(getAcademyName()) + "\"");
        row.add("Academyalias:\"" + Tool.jsSpecialChars(getAcademyalias()) + "\"");
        row.add("ListOrder:\"" + getListOrder() + "\"");
        row.add("AddPerson:\"" + Tool.jsSpecialChars(getAddPerson()) + "\"");
        row.add("AddTime:\"" + Tool.jsSpecialChars(getAddTime()) + "\"");
        row.add("ModiPerson:\"" + Tool.jsSpecialChars(getModiPerson()) + "\"");
        row.add("ModiTime:\"" + Tool.stringOfDateTime(getModiTime()) + "\"");
        row.add("Leaguecount:\"" + getLeaguecount() + "\"");
        row.add("AcadeMySecretary:\"" + Tool.jsSpecialChars(getAcadeMySecretary()) + "\"");
        row.add("AcadePutySecretary:\"" + Tool.jsSpecialChars(getAcadePutySecretary()) + "\"");
        row.add("AcaorgPerson:\"" + Tool.jsSpecialChars(getAcaorgPerson()) + "\"");
        row.add("Acapublicity:\"" + Tool.jsSpecialChars(getAcapublicity()) + "\"");
        row.add("AcadeMyLevel:\"" + Tool.jsSpecialChars(getAcadeMyLevel()) + "\"");
        row.add("AcadeMyPhone:\"" + Tool.jsSpecialChars(getAcadeMyPhone()) + "\"");
        row.add("AcadeMyPlace:\"" + Tool.jsSpecialChars(getAcadeMyPlace()) + "\"");
        row.add("AcadeMyeMail:\"" + Tool.jsSpecialChars(getAcadeMyeMail()) + "\"");
        row.add("YouthXyReport:\"" + Tool.jsSpecialChars(getYouthXyReport()) + "\"");
        row.add("YouthXyReportTime:\"" + Tool.stringOfDateTime(getYouthXyReportTime()) + "\"");
        row.add("YouthModifyFlag:\"" + Tool.jsSpecialChars(getYouthModifyFlag()) + "\"");
        row.add("YouthModifyTime:\"" + Tool.stringOfDateTime(getYouthModifyTime()) + "\"");
        row.add("YouthSchoolYear:\"" + Tool.jsSpecialChars(getYouthSchoolYear()) + "\"");
        row.add("YouthPeriodTime:\"" + Tool.jsSpecialChars(getYouthPeriodTime()) + "\"");
        row.add("Flag:\"" + Tool.jsSpecialChars(getFlag()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,academyname varchar2(45),academyalias varchar2(45),listorder number(*,0),addperson varchar2(45),addtime varchar2(45),modiperson varchar2(45),moditime date,leaguecount number(*,0),academysecretary varchar2(45),acadeputysecretary varchar2(45),acaorgperson varchar2(45),acapublicity varchar2(45),academylevel varchar2(45),academyphone varchar2(45),academyplace varchar2(45),academyemail varchar2(45),youthxyreport varchar2(2),youthxyreporttime date,youthmodifyflag varchar2(2),youthmodifytime date,youthschoolyear varchar2(45),youthperiodtime varchar2(45),flag varchar2(4))"});
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
        Academy v = new Academy(sourceDb, sourceTb);
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
        Academy v = new Academy(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(Academy obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getAcademyName().compareTo(obj.getAcademyName()); if (rtn != 0) return rtn;
        rtn = getAcademyalias().compareTo(obj.getAcademyalias()); if (rtn != 0) return rtn;
        rtn = ("" + getListOrder()).compareTo("" + obj.getListOrder()); if (rtn != 0) return rtn;
        rtn = getAddPerson().compareTo(obj.getAddPerson()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = getModiPerson().compareTo(obj.getModiPerson()); if (rtn != 0) return rtn;
        rtn = getModiTime().compareTo(obj.getModiTime()); if (rtn != 0) return rtn;
        rtn = ("" + getLeaguecount()).compareTo("" + obj.getLeaguecount()); if (rtn != 0) return rtn;
        rtn = getAcadeMySecretary().compareTo(obj.getAcadeMySecretary()); if (rtn != 0) return rtn;
        rtn = getAcadePutySecretary().compareTo(obj.getAcadePutySecretary()); if (rtn != 0) return rtn;
        rtn = getAcaorgPerson().compareTo(obj.getAcaorgPerson()); if (rtn != 0) return rtn;
        rtn = getAcapublicity().compareTo(obj.getAcapublicity()); if (rtn != 0) return rtn;
        rtn = getAcadeMyLevel().compareTo(obj.getAcadeMyLevel()); if (rtn != 0) return rtn;
        rtn = getAcadeMyPhone().compareTo(obj.getAcadeMyPhone()); if (rtn != 0) return rtn;
        rtn = getAcadeMyPlace().compareTo(obj.getAcadeMyPlace()); if (rtn != 0) return rtn;
        rtn = getAcadeMyeMail().compareTo(obj.getAcadeMyeMail()); if (rtn != 0) return rtn;
        rtn = getYouthXyReport().compareTo(obj.getYouthXyReport()); if (rtn != 0) return rtn;
        rtn = getYouthXyReportTime().compareTo(obj.getYouthXyReportTime()); if (rtn != 0) return rtn;
        rtn = getYouthModifyFlag().compareTo(obj.getYouthModifyFlag()); if (rtn != 0) return rtn;
        rtn = getYouthModifyTime().compareTo(obj.getYouthModifyTime()); if (rtn != 0) return rtn;
        rtn = getYouthSchoolYear().compareTo(obj.getYouthSchoolYear()); if (rtn != 0) return rtn;
        rtn = getYouthPeriodTime().compareTo(obj.getYouthPeriodTime()); if (rtn != 0) return rtn;
        rtn = getFlag().compareTo(obj.getFlag()); if (rtn != 0) return rtn;
        return rtn;
    }
}
