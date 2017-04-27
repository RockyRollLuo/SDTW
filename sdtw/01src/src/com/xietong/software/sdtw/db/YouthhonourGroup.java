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
@Description("五四评比表彰团体申请表")
public class YouthhonourGroup implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(YouthhonourGroup.class);
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
    public static final String DbTableName = "youthhonourgroup";
    private String TNAME = "youthhonourgroup";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","schoolYear","type","addaccount","addtime","ayCheckFlag","twCheckFlag","modifyFlag","xyReport","twReport","xyCheckDate","twCheckDate","belongAcademy","val1","val2","val3","val4","val5","val6","val7","val8","val9","val10","val11","val12","val13","val14","val15","val16","val17","val18","val19","val20","text1","text2","text3","text4"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","schoolyear","type","addaccount","addtime","aycheckflag","twcheckflag","modifyflag","xyreport","twreport","xycheckdate","twcheckdate","belongacademy","val1","val2","val3","val4","val5","val6","val7","val8","val9","val10","val11","val12","val13","val14","val15","val16","val17","val18","val19","val20","text1","text2","text3","text4"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"SchoolYear","schoolyear","String"},{"Type","type","int"},{"Addaccount","addaccount","String"},{"Addtime","addtime","java.util.Date"},{"AyCheckFlag","aycheckflag","int"},{"TwCheckFlag","twcheckflag","int"},{"ModifyFlag","modifyflag","int"},{"XyReport","xyreport","int"},{"TwReport","twreport","int"},{"XyCheckDate","xycheckdate","java.util.Date"},{"TwCheckDate","twcheckdate","java.util.Date"},{"BelongAcademy","belongacademy","String"},{"Val1","val1","String"},{"Val2","val2","String"},{"Val3","val3","String"},{"Val4","val4","String"},{"Val5","val5","String"},{"Val6","val6","String"},{"Val7","val7","String"},{"Val8","val8","String"},{"Val9","val9","String"},{"Val10","val10","String"},{"Val11","val11","String"},{"Val12","val12","String"},{"Val13","val13","String"},{"Val14","val14","String"},{"Val15","val15","String"},{"Val16","val16","String"},{"Val17","val17","String"},{"Val18","val18","String"},{"Val19","val19","String"},{"Val20","val20","String"},{"Text1","text1","String"},{"Text2","text2","String"},{"Text3","text3","String"},{"Text4","text4","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"schoolYear","schoolyear"},{"type","type"},{"addaccount","addaccount"},{"addtime","addtime"},{"ayCheckFlag","aycheckflag"},{"twCheckFlag","twcheckflag"},{"modifyFlag","modifyflag"},{"xyReport","xyreport"},{"twReport","twreport"},{"xyCheckDate","xycheckdate"},{"twCheckDate","twcheckdate"},{"belongAcademy","belongacademy"},{"val1","val1"},{"val2","val2"},{"val3","val3"},{"val4","val4"},{"val5","val5"},{"val6","val6"},{"val7","val7"},{"val8","val8"},{"val9","val9"},{"val10","val10"},{"val11","val11"},{"val12","val12"},{"val13","val13"},{"val14","val14"},{"val15","val15"},{"val16","val16"},{"val17","val17"},{"val18","val18"},{"val19","val19"},{"val20","val20"},{"text1","text1"},{"text2","text2"},{"text3","text3"},{"text4","text4"}};
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
    protected String addaccount = "";
    public String getAddaccount() {  return SqlTool.getDbString(addaccount);  }
    public String getAddaccount(int size) { return SqlTool.subString(getAddaccount(), size); }
    public void setAddaccount(String aAddaccount) { addaccount = aAddaccount; modifiedFields.add("Addaccount"); }
    public void assignAddaccount(String aAddaccount) { addaccount = aAddaccount; }
    public void paramAddaccount(HttpServletRequest request) { paramAddaccount(request, "Addaccount"); }
    public void paramAddaccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddaccount()); if (!tmp.equals(getAddaccount())) { setAddaccount(tmp); } }
    // 添加时间
    protected java.util.Date addtime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddtime() { return addtime; }
    public void setAddtime(java.util.Date aAddtime) { addtime = aAddtime; modifiedFields.add("Addtime"); }
    public void assignAddtime(java.util.Date aAddtime) { addtime = aAddtime; }
    public void paramAddtime(HttpServletRequest request) { paramAddtime(request, "Addtime"); }
    public void paramAddtime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddtime()); if (tmp.compareTo(getAddtime()) != 0) { setAddtime(tmp); } }
    // 学院审核标志
    protected int ayCheckFlag = -1;
    public int getAyCheckFlag() { return ayCheckFlag; }
    public void setAyCheckFlag(int aAyCheckFlag) { ayCheckFlag = aAyCheckFlag; modifiedFields.add("AyCheckFlag"); }
    public void assignAyCheckFlag(int aAyCheckFlag) { ayCheckFlag = aAyCheckFlag; }
    public void paramAyCheckFlag(HttpServletRequest request) { paramAyCheckFlag(request, "AyCheckFlag"); }
    public void paramAyCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getAyCheckFlag()); if (tmp != getAyCheckFlag()) { setAyCheckFlag(tmp); } }
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
    // va1
    protected String val1 = "";
    public String getVal1() {  return SqlTool.getDbString(val1);  }
    public String getVal1(int size) { return SqlTool.subString(getVal1(), size); }
    public void setVal1(String aVal1) { val1 = aVal1; modifiedFields.add("Val1"); }
    public void assignVal1(String aVal1) { val1 = aVal1; }
    public void paramVal1(HttpServletRequest request) { paramVal1(request, "Val1"); }
    public void paramVal1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal1()); if (!tmp.equals(getVal1())) { setVal1(tmp); } }
    // va2
    protected String val2 = "";
    public String getVal2() {  return SqlTool.getDbString(val2);  }
    public String getVal2(int size) { return SqlTool.subString(getVal2(), size); }
    public void setVal2(String aVal2) { val2 = aVal2; modifiedFields.add("Val2"); }
    public void assignVal2(String aVal2) { val2 = aVal2; }
    public void paramVal2(HttpServletRequest request) { paramVal2(request, "Val2"); }
    public void paramVal2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal2()); if (!tmp.equals(getVal2())) { setVal2(tmp); } }
    // va3
    protected String val3 = "";
    public String getVal3() {  return SqlTool.getDbString(val3);  }
    public String getVal3(int size) { return SqlTool.subString(getVal3(), size); }
    public void setVal3(String aVal3) { val3 = aVal3; modifiedFields.add("Val3"); }
    public void assignVal3(String aVal3) { val3 = aVal3; }
    public void paramVal3(HttpServletRequest request) { paramVal3(request, "Val3"); }
    public void paramVal3(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal3()); if (!tmp.equals(getVal3())) { setVal3(tmp); } }
    // va4
    protected String val4 = "";
    public String getVal4() {  return SqlTool.getDbString(val4);  }
    public String getVal4(int size) { return SqlTool.subString(getVal4(), size); }
    public void setVal4(String aVal4) { val4 = aVal4; modifiedFields.add("Val4"); }
    public void assignVal4(String aVal4) { val4 = aVal4; }
    public void paramVal4(HttpServletRequest request) { paramVal4(request, "Val4"); }
    public void paramVal4(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal4()); if (!tmp.equals(getVal4())) { setVal4(tmp); } }
    // va5
    protected String val5 = "";
    public String getVal5() {  return SqlTool.getDbString(val5);  }
    public String getVal5(int size) { return SqlTool.subString(getVal5(), size); }
    public void setVal5(String aVal5) { val5 = aVal5; modifiedFields.add("Val5"); }
    public void assignVal5(String aVal5) { val5 = aVal5; }
    public void paramVal5(HttpServletRequest request) { paramVal5(request, "Val5"); }
    public void paramVal5(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal5()); if (!tmp.equals(getVal5())) { setVal5(tmp); } }
    // va6
    protected String val6 = "";
    public String getVal6() {  return SqlTool.getDbString(val6);  }
    public String getVal6(int size) { return SqlTool.subString(getVal6(), size); }
    public void setVal6(String aVal6) { val6 = aVal6; modifiedFields.add("Val6"); }
    public void assignVal6(String aVal6) { val6 = aVal6; }
    public void paramVal6(HttpServletRequest request) { paramVal6(request, "Val6"); }
    public void paramVal6(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal6()); if (!tmp.equals(getVal6())) { setVal6(tmp); } }
    // va7
    protected String val7 = "";
    public String getVal7() {  return SqlTool.getDbString(val7);  }
    public String getVal7(int size) { return SqlTool.subString(getVal7(), size); }
    public void setVal7(String aVal7) { val7 = aVal7; modifiedFields.add("Val7"); }
    public void assignVal7(String aVal7) { val7 = aVal7; }
    public void paramVal7(HttpServletRequest request) { paramVal7(request, "Val7"); }
    public void paramVal7(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal7()); if (!tmp.equals(getVal7())) { setVal7(tmp); } }
    // va8
    protected String val8 = "";
    public String getVal8() {  return SqlTool.getDbString(val8);  }
    public String getVal8(int size) { return SqlTool.subString(getVal8(), size); }
    public void setVal8(String aVal8) { val8 = aVal8; modifiedFields.add("Val8"); }
    public void assignVal8(String aVal8) { val8 = aVal8; }
    public void paramVal8(HttpServletRequest request) { paramVal8(request, "Val8"); }
    public void paramVal8(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal8()); if (!tmp.equals(getVal8())) { setVal8(tmp); } }
    // va9
    protected String val9 = "";
    public String getVal9() {  return SqlTool.getDbString(val9);  }
    public String getVal9(int size) { return SqlTool.subString(getVal9(), size); }
    public void setVal9(String aVal9) { val9 = aVal9; modifiedFields.add("Val9"); }
    public void assignVal9(String aVal9) { val9 = aVal9; }
    public void paramVal9(HttpServletRequest request) { paramVal9(request, "Val9"); }
    public void paramVal9(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal9()); if (!tmp.equals(getVal9())) { setVal9(tmp); } }
    // va10
    protected String val10 = "";
    public String getVal10() {  return SqlTool.getDbString(val10);  }
    public String getVal10(int size) { return SqlTool.subString(getVal10(), size); }
    public void setVal10(String aVal10) { val10 = aVal10; modifiedFields.add("Val10"); }
    public void assignVal10(String aVal10) { val10 = aVal10; }
    public void paramVal10(HttpServletRequest request) { paramVal10(request, "Val10"); }
    public void paramVal10(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal10()); if (!tmp.equals(getVal10())) { setVal10(tmp); } }
    // va11
    protected String val11 = "";
    public String getVal11() {  return SqlTool.getDbString(val11);  }
    public String getVal11(int size) { return SqlTool.subString(getVal11(), size); }
    public void setVal11(String aVal11) { val11 = aVal11; modifiedFields.add("Val11"); }
    public void assignVal11(String aVal11) { val11 = aVal11; }
    public void paramVal11(HttpServletRequest request) { paramVal11(request, "Val11"); }
    public void paramVal11(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal11()); if (!tmp.equals(getVal11())) { setVal11(tmp); } }
    // va12
    protected String val12 = "";
    public String getVal12() {  return SqlTool.getDbString(val12);  }
    public String getVal12(int size) { return SqlTool.subString(getVal12(), size); }
    public void setVal12(String aVal12) { val12 = aVal12; modifiedFields.add("Val12"); }
    public void assignVal12(String aVal12) { val12 = aVal12; }
    public void paramVal12(HttpServletRequest request) { paramVal12(request, "Val12"); }
    public void paramVal12(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal12()); if (!tmp.equals(getVal12())) { setVal12(tmp); } }
    // va13
    protected String val13 = "";
    public String getVal13() {  return SqlTool.getDbString(val13);  }
    public String getVal13(int size) { return SqlTool.subString(getVal13(), size); }
    public void setVal13(String aVal13) { val13 = aVal13; modifiedFields.add("Val13"); }
    public void assignVal13(String aVal13) { val13 = aVal13; }
    public void paramVal13(HttpServletRequest request) { paramVal13(request, "Val13"); }
    public void paramVal13(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal13()); if (!tmp.equals(getVal13())) { setVal13(tmp); } }
    // va14
    protected String val14 = "";
    public String getVal14() {  return SqlTool.getDbString(val14);  }
    public String getVal14(int size) { return SqlTool.subString(getVal14(), size); }
    public void setVal14(String aVal14) { val14 = aVal14; modifiedFields.add("Val14"); }
    public void assignVal14(String aVal14) { val14 = aVal14; }
    public void paramVal14(HttpServletRequest request) { paramVal14(request, "Val14"); }
    public void paramVal14(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal14()); if (!tmp.equals(getVal14())) { setVal14(tmp); } }
    // va15
    protected String val15 = "";
    public String getVal15() {  return SqlTool.getDbString(val15);  }
    public String getVal15(int size) { return SqlTool.subString(getVal15(), size); }
    public void setVal15(String aVal15) { val15 = aVal15; modifiedFields.add("Val15"); }
    public void assignVal15(String aVal15) { val15 = aVal15; }
    public void paramVal15(HttpServletRequest request) { paramVal15(request, "Val15"); }
    public void paramVal15(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal15()); if (!tmp.equals(getVal15())) { setVal15(tmp); } }
    // va16
    protected String val16 = "";
    public String getVal16() {  return SqlTool.getDbString(val16);  }
    public String getVal16(int size) { return SqlTool.subString(getVal16(), size); }
    public void setVal16(String aVal16) { val16 = aVal16; modifiedFields.add("Val16"); }
    public void assignVal16(String aVal16) { val16 = aVal16; }
    public void paramVal16(HttpServletRequest request) { paramVal16(request, "Val16"); }
    public void paramVal16(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal16()); if (!tmp.equals(getVal16())) { setVal16(tmp); } }
    // va17
    protected String val17 = "";
    public String getVal17() {  return SqlTool.getDbString(val17);  }
    public String getVal17(int size) { return SqlTool.subString(getVal17(), size); }
    public void setVal17(String aVal17) { val17 = aVal17; modifiedFields.add("Val17"); }
    public void assignVal17(String aVal17) { val17 = aVal17; }
    public void paramVal17(HttpServletRequest request) { paramVal17(request, "Val17"); }
    public void paramVal17(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal17()); if (!tmp.equals(getVal17())) { setVal17(tmp); } }
    // va18
    protected String val18 = "";
    public String getVal18() {  return SqlTool.getDbString(val18);  }
    public String getVal18(int size) { return SqlTool.subString(getVal18(), size); }
    public void setVal18(String aVal18) { val18 = aVal18; modifiedFields.add("Val18"); }
    public void assignVal18(String aVal18) { val18 = aVal18; }
    public void paramVal18(HttpServletRequest request) { paramVal18(request, "Val18"); }
    public void paramVal18(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal18()); if (!tmp.equals(getVal18())) { setVal18(tmp); } }
    // va19
    protected String val19 = "";
    public String getVal19() {  return SqlTool.getDbString(val19);  }
    public String getVal19(int size) { return SqlTool.subString(getVal19(), size); }
    public void setVal19(String aVal19) { val19 = aVal19; modifiedFields.add("Val19"); }
    public void assignVal19(String aVal19) { val19 = aVal19; }
    public void paramVal19(HttpServletRequest request) { paramVal19(request, "Val19"); }
    public void paramVal19(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal19()); if (!tmp.equals(getVal19())) { setVal19(tmp); } }
    // va20
    protected String val20 = "";
    public String getVal20() {  return SqlTool.getDbString(val20);  }
    public String getVal20(int size) { return SqlTool.subString(getVal20(), size); }
    public void setVal20(String aVal20) { val20 = aVal20; modifiedFields.add("Val20"); }
    public void assignVal20(String aVal20) { val20 = aVal20; }
    public void paramVal20(HttpServletRequest request) { paramVal20(request, "Val20"); }
    public void paramVal20(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVal20()); if (!tmp.equals(getVal20())) { setVal20(tmp); } }
    // text1
    protected String text1 = "";
    public String getText1() {  return SqlTool.getDbString(text1);  }
    public String getText1(int size) { return SqlTool.subString(getText1(), size); }
    public void setText1(String aText1) { text1 = aText1; modifiedFields.add("Text1"); }
    public void assignText1(String aText1) { text1 = aText1; }
    public void paramText1(HttpServletRequest request) { paramText1(request, "Text1"); }
    public void paramText1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getText1()); if (!tmp.equals(getText1())) { setText1(tmp); } }
    // text2
    protected String text2 = "";
    public String getText2() {  return SqlTool.getDbString(text2);  }
    public String getText2(int size) { return SqlTool.subString(getText2(), size); }
    public void setText2(String aText2) { text2 = aText2; modifiedFields.add("Text2"); }
    public void assignText2(String aText2) { text2 = aText2; }
    public void paramText2(HttpServletRequest request) { paramText2(request, "Text2"); }
    public void paramText2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getText2()); if (!tmp.equals(getText2())) { setText2(tmp); } }
    // text3
    protected String text3 = "";
    public String getText3() {  return SqlTool.getDbString(text3);  }
    public String getText3(int size) { return SqlTool.subString(getText3(), size); }
    public void setText3(String aText3) { text3 = aText3; modifiedFields.add("Text3"); }
    public void assignText3(String aText3) { text3 = aText3; }
    public void paramText3(HttpServletRequest request) { paramText3(request, "Text3"); }
    public void paramText3(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getText3()); if (!tmp.equals(getText3())) { setText3(tmp); } }
    // text4
    protected String text4 = "";
    public String getText4() {  return SqlTool.getDbString(text4);  }
    public String getText4(int size) { return SqlTool.subString(getText4(), size); }
    public void setText4(String aText4) { text4 = aText4; modifiedFields.add("Text4"); }
    public void assignText4(String aText4) { text4 = aText4; }
    public void paramText4(HttpServletRequest request) { paramText4(request, "Text4"); }
    public void paramText4(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getText4()); if (!tmp.equals(getText4())) { setText4(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public YouthhonourGroup (String db) {
        DBNAME = db;
    }
    public YouthhonourGroup (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public YouthhonourGroup (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public YouthhonourGroup () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return YouthhonourGroup类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public YouthhonourGroup getByParameter(HttpServletRequest request) {
        YouthhonourGroup v = new YouthhonourGroup(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramSchoolYear(request);
        paramType(request);
        paramAddaccount(request);
        paramAddtime(request);
        paramAyCheckFlag(request);
        paramTwCheckFlag(request);
        paramModifyFlag(request);
        paramXyReport(request);
        paramTwReport(request);
        paramXyCheckDate(request);
        paramTwCheckDate(request);
        paramBelongAcademy(request);
        paramVal1(request);
        paramVal2(request);
        paramVal3(request);
        paramVal4(request);
        paramVal5(request);
        paramVal6(request);
        paramVal7(request);
        paramVal8(request);
        paramVal9(request);
        paramVal10(request);
        paramVal11(request);
        paramVal12(request);
        paramVal13(request);
        paramVal14(request);
        paramVal15(request);
        paramVal16(request);
        paramVal17(request);
        paramVal18(request);
        paramVal19(request);
        paramVal20(request);
        paramText1(request);
        paramText2(request);
        paramText3(request);
        paramText4(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(YouthhonourGroup bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("schoolYear")) { setSchoolYear(bean.getSchoolYear()); }
        if (!ncl.contains("type")) { setType(bean.getType()); }
        if (!ncl.contains("addaccount")) { setAddaccount(bean.getAddaccount()); }
        if (!ncl.contains("addtime")) { setAddtime(bean.getAddtime()); }
        if (!ncl.contains("ayCheckFlag")) { setAyCheckFlag(bean.getAyCheckFlag()); }
        if (!ncl.contains("twCheckFlag")) { setTwCheckFlag(bean.getTwCheckFlag()); }
        if (!ncl.contains("modifyFlag")) { setModifyFlag(bean.getModifyFlag()); }
        if (!ncl.contains("xyReport")) { setXyReport(bean.getXyReport()); }
        if (!ncl.contains("twReport")) { setTwReport(bean.getTwReport()); }
        if (!ncl.contains("xyCheckDate")) { setXyCheckDate(bean.getXyCheckDate()); }
        if (!ncl.contains("twCheckDate")) { setTwCheckDate(bean.getTwCheckDate()); }
        if (!ncl.contains("belongAcademy")) { setBelongAcademy(bean.getBelongAcademy()); }
        if (!ncl.contains("val1")) { setVal1(bean.getVal1()); }
        if (!ncl.contains("val2")) { setVal2(bean.getVal2()); }
        if (!ncl.contains("val3")) { setVal3(bean.getVal3()); }
        if (!ncl.contains("val4")) { setVal4(bean.getVal4()); }
        if (!ncl.contains("val5")) { setVal5(bean.getVal5()); }
        if (!ncl.contains("val6")) { setVal6(bean.getVal6()); }
        if (!ncl.contains("val7")) { setVal7(bean.getVal7()); }
        if (!ncl.contains("val8")) { setVal8(bean.getVal8()); }
        if (!ncl.contains("val9")) { setVal9(bean.getVal9()); }
        if (!ncl.contains("val10")) { setVal10(bean.getVal10()); }
        if (!ncl.contains("val11")) { setVal11(bean.getVal11()); }
        if (!ncl.contains("val12")) { setVal12(bean.getVal12()); }
        if (!ncl.contains("val13")) { setVal13(bean.getVal13()); }
        if (!ncl.contains("val14")) { setVal14(bean.getVal14()); }
        if (!ncl.contains("val15")) { setVal15(bean.getVal15()); }
        if (!ncl.contains("val16")) { setVal16(bean.getVal16()); }
        if (!ncl.contains("val17")) { setVal17(bean.getVal17()); }
        if (!ncl.contains("val18")) { setVal18(bean.getVal18()); }
        if (!ncl.contains("val19")) { setVal19(bean.getVal19()); }
        if (!ncl.contains("val20")) { setVal20(bean.getVal20()); }
        if (!ncl.contains("text1")) { setText1(bean.getText1()); }
        if (!ncl.contains("text2")) { setText2(bean.getText2()); }
        if (!ncl.contains("text3")) { setText3(bean.getText3()); }
        if (!ncl.contains("text4")) { setText4(bean.getText4()); }
    }
    public YouthhonourGroup getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        YouthhonourGroup[] rslt= queryByCondition(cdt);
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
     * @return YouthhonourGroup类的实例列表。
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
                YouthhonourGroup ve = new YouthhonourGroup(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignSchoolYear(fromDbCh(rs.getString(2)));
                ve.assignType(rs.getInt(3));
                ve.assignAddaccount(fromDbCh(rs.getString(4)));
                tmpDate = rs.getTimestamp(5); if (tmpDate != null) { ve.assignAddtime(new java.util.Date(tmpDate.getTime())); }
                ve.assignAyCheckFlag(rs.getInt(6));
                ve.assignTwCheckFlag(rs.getInt(7));
                ve.assignModifyFlag(rs.getInt(8));
                ve.assignXyReport(rs.getInt(9));
                ve.assignTwReport(rs.getInt(10));
                tmpDate = rs.getTimestamp(11); if (tmpDate != null) { ve.assignXyCheckDate(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(12); if (tmpDate != null) { ve.assignTwCheckDate(new java.util.Date(tmpDate.getTime())); }
                ve.assignBelongAcademy(fromDbCh(rs.getString(13)));
                ve.assignVal1(fromDbCh(rs.getString(14)));
                ve.assignVal2(fromDbCh(rs.getString(15)));
                ve.assignVal3(fromDbCh(rs.getString(16)));
                ve.assignVal4(fromDbCh(rs.getString(17)));
                ve.assignVal5(fromDbCh(rs.getString(18)));
                ve.assignVal6(fromDbCh(rs.getString(19)));
                ve.assignVal7(fromDbCh(rs.getString(20)));
                ve.assignVal8(fromDbCh(rs.getString(21)));
                ve.assignVal9(fromDbCh(rs.getString(22)));
                ve.assignVal10(fromDbCh(rs.getString(23)));
                ve.assignVal11(fromDbCh(rs.getString(24)));
                ve.assignVal12(fromDbCh(rs.getString(25)));
                ve.assignVal13(fromDbCh(rs.getString(26)));
                ve.assignVal14(fromDbCh(rs.getString(27)));
                ve.assignVal15(fromDbCh(rs.getString(28)));
                ve.assignVal16(fromDbCh(rs.getString(29)));
                ve.assignVal17(fromDbCh(rs.getString(30)));
                ve.assignVal18(fromDbCh(rs.getString(31)));
                ve.assignVal19(fromDbCh(rs.getString(32)));
                ve.assignVal20(fromDbCh(rs.getString(33)));
                ve.assignText1(fromDbCh(rs.getString(34)));
                ve.assignText2(fromDbCh(rs.getString(35)));
                ve.assignText3(fromDbCh(rs.getString(36)));
                ve.assignText4(fromDbCh(rs.getString(37)));
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
    public YouthhonourGroup[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (YouthhonourGroup[])vrs.toArray(new YouthhonourGroup[vrs.size()]);
    }
    public YouthhonourGroup[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (YouthhonourGroup[])vrs.toArray(new YouthhonourGroup[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (schoolyear,type,addaccount,addtime,aycheckflag,twcheckflag,modifyflag,xyreport,twreport,xycheckdate,twcheckdate,belongacademy,val1,val2,val3,val4,val5,val6,val7,val8,val9,val10,val11,val12,val13,val14,val15,val16,val17,val18,val19,val20,text1,text2,text3,text4) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            pstmt.setString(3, toDbCh(addaccount));
            pstmt.setTimestamp(4, new java.sql.Timestamp(addtime.getTime()));
            pstmt.setInt(5, ayCheckFlag);
            pstmt.setInt(6, twCheckFlag);
            pstmt.setInt(7, modifyFlag);
            pstmt.setInt(8, xyReport);
            pstmt.setInt(9, twReport);
            pstmt.setTimestamp(10, new java.sql.Timestamp(xyCheckDate.getTime()));
            pstmt.setTimestamp(11, new java.sql.Timestamp(twCheckDate.getTime()));
            pstmt.setString(12, toDbCh(belongAcademy));
            pstmt.setString(13, toDbCh(val1));
            pstmt.setString(14, toDbCh(val2));
            pstmt.setString(15, toDbCh(val3));
            pstmt.setString(16, toDbCh(val4));
            pstmt.setString(17, toDbCh(val5));
            pstmt.setString(18, toDbCh(val6));
            pstmt.setString(19, toDbCh(val7));
            pstmt.setString(20, toDbCh(val8));
            pstmt.setString(21, toDbCh(val9));
            pstmt.setString(22, toDbCh(val10));
            pstmt.setString(23, toDbCh(val11));
            pstmt.setString(24, toDbCh(val12));
            pstmt.setString(25, toDbCh(val13));
            pstmt.setString(26, toDbCh(val14));
            pstmt.setString(27, toDbCh(val15));
            pstmt.setString(28, toDbCh(val16));
            pstmt.setString(29, toDbCh(val17));
            pstmt.setString(30, toDbCh(val18));
            pstmt.setString(31, toDbCh(val19));
            pstmt.setString(32, toDbCh(val20));
            pstmt.setString(33, toDbCh(text1));
            pstmt.setString(34, toDbCh(text2));
            pstmt.setString(35, toDbCh(text3));
            pstmt.setString(36, toDbCh(text4));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,schoolyear,type,addaccount,addtime,aycheckflag,twcheckflag,modifyflag,xyreport,twreport,xycheckdate,twcheckdate,belongacademy,val1,val2,val3,val4,val5,val6,val7,val8,val9,val10,val11,val12,val13,val14,val15,val16,val17,val18,val19,val20,text1,text2,text3,text4) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            pstmt.setString(4, toDbCh(addaccount));
            pstmt.setTimestamp(5, new java.sql.Timestamp(addtime.getTime()));
            pstmt.setInt(6, ayCheckFlag);
            pstmt.setInt(7, twCheckFlag);
            pstmt.setInt(8, modifyFlag);
            pstmt.setInt(9, xyReport);
            pstmt.setInt(10, twReport);
            pstmt.setTimestamp(11, new java.sql.Timestamp(xyCheckDate.getTime()));
            pstmt.setTimestamp(12, new java.sql.Timestamp(twCheckDate.getTime()));
            pstmt.setString(13, toDbCh(belongAcademy));
            pstmt.setString(14, toDbCh(val1));
            pstmt.setString(15, toDbCh(val2));
            pstmt.setString(16, toDbCh(val3));
            pstmt.setString(17, toDbCh(val4));
            pstmt.setString(18, toDbCh(val5));
            pstmt.setString(19, toDbCh(val6));
            pstmt.setString(20, toDbCh(val7));
            pstmt.setString(21, toDbCh(val8));
            pstmt.setString(22, toDbCh(val9));
            pstmt.setString(23, toDbCh(val10));
            pstmt.setString(24, toDbCh(val11));
            pstmt.setString(25, toDbCh(val12));
            pstmt.setString(26, toDbCh(val13));
            pstmt.setString(27, toDbCh(val14));
            pstmt.setString(28, toDbCh(val15));
            pstmt.setString(29, toDbCh(val16));
            pstmt.setString(30, toDbCh(val17));
            pstmt.setString(31, toDbCh(val18));
            pstmt.setString(32, toDbCh(val19));
            pstmt.setString(33, toDbCh(val20));
            pstmt.setString(34, toDbCh(text1));
            pstmt.setString(35, toDbCh(text2));
            pstmt.setString(36, toDbCh(text3));
            pstmt.setString(37, toDbCh(text4));
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
            YouthhonourGroup item = (YouthhonourGroup)it.next();
            YouthhonourGroup v = new YouthhonourGroup(dbname);
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
                if (modifiedFields.contains("Addaccount")) { pstmt.setString(pi ++, toDbCh(addaccount)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addtime.getTime())); }
                if (modifiedFields.contains("AyCheckFlag")) { pstmt.setInt(pi ++, ayCheckFlag); }
                if (modifiedFields.contains("TwCheckFlag")) { pstmt.setInt(pi ++, twCheckFlag); }
                if (modifiedFields.contains("ModifyFlag")) { pstmt.setInt(pi ++, modifyFlag); }
                if (modifiedFields.contains("XyReport")) { pstmt.setInt(pi ++, xyReport); }
                if (modifiedFields.contains("TwReport")) { pstmt.setInt(pi ++, twReport); }
                if (modifiedFields.contains("XyCheckDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(xyCheckDate.getTime())); }
                if (modifiedFields.contains("TwCheckDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(twCheckDate.getTime())); }
                if (modifiedFields.contains("BelongAcademy")) { pstmt.setString(pi ++, toDbCh(belongAcademy)); }
                if (modifiedFields.contains("Val1")) { pstmt.setString(pi ++, toDbCh(val1)); }
                if (modifiedFields.contains("Val2")) { pstmt.setString(pi ++, toDbCh(val2)); }
                if (modifiedFields.contains("Val3")) { pstmt.setString(pi ++, toDbCh(val3)); }
                if (modifiedFields.contains("Val4")) { pstmt.setString(pi ++, toDbCh(val4)); }
                if (modifiedFields.contains("Val5")) { pstmt.setString(pi ++, toDbCh(val5)); }
                if (modifiedFields.contains("Val6")) { pstmt.setString(pi ++, toDbCh(val6)); }
                if (modifiedFields.contains("Val7")) { pstmt.setString(pi ++, toDbCh(val7)); }
                if (modifiedFields.contains("Val8")) { pstmt.setString(pi ++, toDbCh(val8)); }
                if (modifiedFields.contains("Val9")) { pstmt.setString(pi ++, toDbCh(val9)); }
                if (modifiedFields.contains("Val10")) { pstmt.setString(pi ++, toDbCh(val10)); }
                if (modifiedFields.contains("Val11")) { pstmt.setString(pi ++, toDbCh(val11)); }
                if (modifiedFields.contains("Val12")) { pstmt.setString(pi ++, toDbCh(val12)); }
                if (modifiedFields.contains("Val13")) { pstmt.setString(pi ++, toDbCh(val13)); }
                if (modifiedFields.contains("Val14")) { pstmt.setString(pi ++, toDbCh(val14)); }
                if (modifiedFields.contains("Val15")) { pstmt.setString(pi ++, toDbCh(val15)); }
                if (modifiedFields.contains("Val16")) { pstmt.setString(pi ++, toDbCh(val16)); }
                if (modifiedFields.contains("Val17")) { pstmt.setString(pi ++, toDbCh(val17)); }
                if (modifiedFields.contains("Val18")) { pstmt.setString(pi ++, toDbCh(val18)); }
                if (modifiedFields.contains("Val19")) { pstmt.setString(pi ++, toDbCh(val19)); }
                if (modifiedFields.contains("Val20")) { pstmt.setString(pi ++, toDbCh(val20)); }
                if (modifiedFields.contains("Text1")) { pstmt.setString(pi ++, toDbCh(text1)); }
                if (modifiedFields.contains("Text2")) { pstmt.setString(pi ++, toDbCh(text2)); }
                if (modifiedFields.contains("Text3")) { pstmt.setString(pi ++, toDbCh(text3)); }
                if (modifiedFields.contains("Text4")) { pstmt.setString(pi ++, toDbCh(text4)); }
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
                if (modifiedFields.contains("Addaccount")) { pstmt.setString(pi ++, toDbCh(addaccount)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addtime.getTime())); }
                if (modifiedFields.contains("AyCheckFlag")) { pstmt.setInt(pi ++, ayCheckFlag); }
                if (modifiedFields.contains("TwCheckFlag")) { pstmt.setInt(pi ++, twCheckFlag); }
                if (modifiedFields.contains("ModifyFlag")) { pstmt.setInt(pi ++, modifyFlag); }
                if (modifiedFields.contains("XyReport")) { pstmt.setInt(pi ++, xyReport); }
                if (modifiedFields.contains("TwReport")) { pstmt.setInt(pi ++, twReport); }
                if (modifiedFields.contains("XyCheckDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(xyCheckDate.getTime())); }
                if (modifiedFields.contains("TwCheckDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(twCheckDate.getTime())); }
                if (modifiedFields.contains("BelongAcademy")) { pstmt.setString(pi ++, toDbCh(belongAcademy)); }
                if (modifiedFields.contains("Val1")) { pstmt.setString(pi ++, toDbCh(val1)); }
                if (modifiedFields.contains("Val2")) { pstmt.setString(pi ++, toDbCh(val2)); }
                if (modifiedFields.contains("Val3")) { pstmt.setString(pi ++, toDbCh(val3)); }
                if (modifiedFields.contains("Val4")) { pstmt.setString(pi ++, toDbCh(val4)); }
                if (modifiedFields.contains("Val5")) { pstmt.setString(pi ++, toDbCh(val5)); }
                if (modifiedFields.contains("Val6")) { pstmt.setString(pi ++, toDbCh(val6)); }
                if (modifiedFields.contains("Val7")) { pstmt.setString(pi ++, toDbCh(val7)); }
                if (modifiedFields.contains("Val8")) { pstmt.setString(pi ++, toDbCh(val8)); }
                if (modifiedFields.contains("Val9")) { pstmt.setString(pi ++, toDbCh(val9)); }
                if (modifiedFields.contains("Val10")) { pstmt.setString(pi ++, toDbCh(val10)); }
                if (modifiedFields.contains("Val11")) { pstmt.setString(pi ++, toDbCh(val11)); }
                if (modifiedFields.contains("Val12")) { pstmt.setString(pi ++, toDbCh(val12)); }
                if (modifiedFields.contains("Val13")) { pstmt.setString(pi ++, toDbCh(val13)); }
                if (modifiedFields.contains("Val14")) { pstmt.setString(pi ++, toDbCh(val14)); }
                if (modifiedFields.contains("Val15")) { pstmt.setString(pi ++, toDbCh(val15)); }
                if (modifiedFields.contains("Val16")) { pstmt.setString(pi ++, toDbCh(val16)); }
                if (modifiedFields.contains("Val17")) { pstmt.setString(pi ++, toDbCh(val17)); }
                if (modifiedFields.contains("Val18")) { pstmt.setString(pi ++, toDbCh(val18)); }
                if (modifiedFields.contains("Val19")) { pstmt.setString(pi ++, toDbCh(val19)); }
                if (modifiedFields.contains("Val20")) { pstmt.setString(pi ++, toDbCh(val20)); }
                if (modifiedFields.contains("Text1")) { pstmt.setString(pi ++, toDbCh(text1)); }
                if (modifiedFields.contains("Text2")) { pstmt.setString(pi ++, toDbCh(text2)); }
                if (modifiedFields.contains("Text3")) { pstmt.setString(pi ++, toDbCh(text3)); }
                if (modifiedFields.contains("Text4")) { pstmt.setString(pi ++, toDbCh(text4)); }
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
        map.put("Addaccount", getAddaccount());
        map.put("Addtime", Tool.stringOfDateTime(getAddtime()));
        map.put("AyCheckFlag", getAyCheckFlag() + "");
        map.put("TwCheckFlag", getTwCheckFlag() + "");
        map.put("ModifyFlag", getModifyFlag() + "");
        map.put("XyReport", getXyReport() + "");
        map.put("TwReport", getTwReport() + "");
        map.put("XyCheckDate", Tool.stringOfDateTime(getXyCheckDate()));
        map.put("TwCheckDate", Tool.stringOfDateTime(getTwCheckDate()));
        map.put("BelongAcademy", getBelongAcademy());
        map.put("Val1", getVal1());
        map.put("Val2", getVal2());
        map.put("Val3", getVal3());
        map.put("Val4", getVal4());
        map.put("Val5", getVal5());
        map.put("Val6", getVal6());
        map.put("Val7", getVal7());
        map.put("Val8", getVal8());
        map.put("Val9", getVal9());
        map.put("Val10", getVal10());
        map.put("Val11", getVal11());
        map.put("Val12", getVal12());
        map.put("Val13", getVal13());
        map.put("Val14", getVal14());
        map.put("Val15", getVal15());
        map.put("Val16", getVal16());
        map.put("Val17", getVal17());
        map.put("Val18", getVal18());
        map.put("Val19", getVal19());
        map.put("Val20", getVal20());
        map.put("Text1", getText1());
        map.put("Text2", getText2());
        map.put("Text3", getText3());
        map.put("Text4", getText4());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("SchoolYear:\"" + Tool.jsSpecialChars(getSchoolYear()) + "\"");
        row.add("Type:\"" + getType() + "\"");
        row.add("Addaccount:\"" + Tool.jsSpecialChars(getAddaccount()) + "\"");
        row.add("Addtime:\"" + Tool.stringOfDateTime(getAddtime()) + "\"");
        row.add("AyCheckFlag:\"" + getAyCheckFlag() + "\"");
        row.add("TwCheckFlag:\"" + getTwCheckFlag() + "\"");
        row.add("ModifyFlag:\"" + getModifyFlag() + "\"");
        row.add("XyReport:\"" + getXyReport() + "\"");
        row.add("TwReport:\"" + getTwReport() + "\"");
        row.add("XyCheckDate:\"" + Tool.stringOfDateTime(getXyCheckDate()) + "\"");
        row.add("TwCheckDate:\"" + Tool.stringOfDateTime(getTwCheckDate()) + "\"");
        row.add("BelongAcademy:\"" + Tool.jsSpecialChars(getBelongAcademy()) + "\"");
        row.add("Val1:\"" + Tool.jsSpecialChars(getVal1()) + "\"");
        row.add("Val2:\"" + Tool.jsSpecialChars(getVal2()) + "\"");
        row.add("Val3:\"" + Tool.jsSpecialChars(getVal3()) + "\"");
        row.add("Val4:\"" + Tool.jsSpecialChars(getVal4()) + "\"");
        row.add("Val5:\"" + Tool.jsSpecialChars(getVal5()) + "\"");
        row.add("Val6:\"" + Tool.jsSpecialChars(getVal6()) + "\"");
        row.add("Val7:\"" + Tool.jsSpecialChars(getVal7()) + "\"");
        row.add("Val8:\"" + Tool.jsSpecialChars(getVal8()) + "\"");
        row.add("Val9:\"" + Tool.jsSpecialChars(getVal9()) + "\"");
        row.add("Val10:\"" + Tool.jsSpecialChars(getVal10()) + "\"");
        row.add("Val11:\"" + Tool.jsSpecialChars(getVal11()) + "\"");
        row.add("Val12:\"" + Tool.jsSpecialChars(getVal12()) + "\"");
        row.add("Val13:\"" + Tool.jsSpecialChars(getVal13()) + "\"");
        row.add("Val14:\"" + Tool.jsSpecialChars(getVal14()) + "\"");
        row.add("Val15:\"" + Tool.jsSpecialChars(getVal15()) + "\"");
        row.add("Val16:\"" + Tool.jsSpecialChars(getVal16()) + "\"");
        row.add("Val17:\"" + Tool.jsSpecialChars(getVal17()) + "\"");
        row.add("Val18:\"" + Tool.jsSpecialChars(getVal18()) + "\"");
        row.add("Val19:\"" + Tool.jsSpecialChars(getVal19()) + "\"");
        row.add("Val20:\"" + Tool.jsSpecialChars(getVal20()) + "\"");
        row.add("Text1:\"" + Tool.jsSpecialChars(getText1()) + "\"");
        row.add("Text2:\"" + Tool.jsSpecialChars(getText2()) + "\"");
        row.add("Text3:\"" + Tool.jsSpecialChars(getText3()) + "\"");
        row.add("Text4:\"" + Tool.jsSpecialChars(getText4()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,schoolyear varchar2(45),type number(*,0),addaccount varchar2(45),addtime date,aycheckflag number(*,0),twcheckflag number(*,0),modifyflag number(*,0),xyreport number(*,0),twreport number(*,0),xycheckdate date,twcheckdate date,belongacademy varchar2(45),val1 varchar2(45),val2 varchar2(45),val3 varchar2(45),val4 varchar2(45),val5 varchar2(45),val6 varchar2(45),val7 varchar2(45),val8 varchar2(45),val9 varchar2(45),val10 varchar2(45),val11 varchar2(45),val12 varchar2(45),val13 varchar2(45),val14 varchar2(45),val15 varchar2(45),val16 varchar2(45),val17 varchar2(45),val18 varchar2(45),val19 varchar2(45),val20 varchar2(45),text1 varchar2(500),text2 varchar2(500),text3 varchar2(500),text4 varchar2(500))"});
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
        YouthhonourGroup v = new YouthhonourGroup(sourceDb, sourceTb);
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
        YouthhonourGroup v = new YouthhonourGroup(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(YouthhonourGroup obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getSchoolYear().compareTo(obj.getSchoolYear()); if (rtn != 0) return rtn;
        rtn = ("" + getType()).compareTo("" + obj.getType()); if (rtn != 0) return rtn;
        rtn = getAddaccount().compareTo(obj.getAddaccount()); if (rtn != 0) return rtn;
        rtn = getAddtime().compareTo(obj.getAddtime()); if (rtn != 0) return rtn;
        rtn = ("" + getAyCheckFlag()).compareTo("" + obj.getAyCheckFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getTwCheckFlag()).compareTo("" + obj.getTwCheckFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getModifyFlag()).compareTo("" + obj.getModifyFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getXyReport()).compareTo("" + obj.getXyReport()); if (rtn != 0) return rtn;
        rtn = ("" + getTwReport()).compareTo("" + obj.getTwReport()); if (rtn != 0) return rtn;
        rtn = getXyCheckDate().compareTo(obj.getXyCheckDate()); if (rtn != 0) return rtn;
        rtn = getTwCheckDate().compareTo(obj.getTwCheckDate()); if (rtn != 0) return rtn;
        rtn = getBelongAcademy().compareTo(obj.getBelongAcademy()); if (rtn != 0) return rtn;
        rtn = getVal1().compareTo(obj.getVal1()); if (rtn != 0) return rtn;
        rtn = getVal2().compareTo(obj.getVal2()); if (rtn != 0) return rtn;
        rtn = getVal3().compareTo(obj.getVal3()); if (rtn != 0) return rtn;
        rtn = getVal4().compareTo(obj.getVal4()); if (rtn != 0) return rtn;
        rtn = getVal5().compareTo(obj.getVal5()); if (rtn != 0) return rtn;
        rtn = getVal6().compareTo(obj.getVal6()); if (rtn != 0) return rtn;
        rtn = getVal7().compareTo(obj.getVal7()); if (rtn != 0) return rtn;
        rtn = getVal8().compareTo(obj.getVal8()); if (rtn != 0) return rtn;
        rtn = getVal9().compareTo(obj.getVal9()); if (rtn != 0) return rtn;
        rtn = getVal10().compareTo(obj.getVal10()); if (rtn != 0) return rtn;
        rtn = getVal11().compareTo(obj.getVal11()); if (rtn != 0) return rtn;
        rtn = getVal12().compareTo(obj.getVal12()); if (rtn != 0) return rtn;
        rtn = getVal13().compareTo(obj.getVal13()); if (rtn != 0) return rtn;
        rtn = getVal14().compareTo(obj.getVal14()); if (rtn != 0) return rtn;
        rtn = getVal15().compareTo(obj.getVal15()); if (rtn != 0) return rtn;
        rtn = getVal16().compareTo(obj.getVal16()); if (rtn != 0) return rtn;
        rtn = getVal17().compareTo(obj.getVal17()); if (rtn != 0) return rtn;
        rtn = getVal18().compareTo(obj.getVal18()); if (rtn != 0) return rtn;
        rtn = getVal19().compareTo(obj.getVal19()); if (rtn != 0) return rtn;
        rtn = getVal20().compareTo(obj.getVal20()); if (rtn != 0) return rtn;
        rtn = getText1().compareTo(obj.getText1()); if (rtn != 0) return rtn;
        rtn = getText2().compareTo(obj.getText2()); if (rtn != 0) return rtn;
        rtn = getText3().compareTo(obj.getText3()); if (rtn != 0) return rtn;
        rtn = getText4().compareTo(obj.getText4()); if (rtn != 0) return rtn;
        return rtn;
    }
}
