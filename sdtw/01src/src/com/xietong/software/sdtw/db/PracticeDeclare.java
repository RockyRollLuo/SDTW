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
@Description("社会实践项目报名表-学生素质拓展培养认证单-实践服务")
public class PracticeDeclare implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(PracticeDeclare.class);
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
    public static final String DbTableName = "practice_declare";
    private String TNAME = "practice_declare";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","type","declareId","academy","xyHonour","submitflag","xyCheckFlag","twCheckFlag","addaccount","addtime","declare1","declare2","declare5","declare8","declare6","declare7","declare9","declare10","declare11","declare12","declare13","declare14","declare15","declare16","declare17","declare18","declare19","declare20","declare21","declare22","declare23","declare24","declare25","declare26","declare27","declare28","declare29","declare30","declare31","declare32","declare33","declare34","declare35","declare36","declare37","declare38","declare39","declare40","declare41","declare42","declare43","declare44","declare45","declare46","declare47","declare48","declare49","declare50","declare51","declare52","declare53","declare54","declare55","declare56","declare57","declare58","declare59","declare60","declare61","declare62","declare63","declare64","addFileList","remark1","remark2","remark3"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","type","declareid","academy","xyhonour","submitflag","xycheckflag","twcheckflag","addaccount","addtime","declare1","declare2","declare5","declare8","declare6","declare7","declare9","declare10","declare11","declare12","declare13","declare14","declare15","declare16","declare17","declare18","declare19","declare20","declare21","declare22","declare23","declare24","declare25","declare26","declare27","declare28","declare29","declare30","declare31","declare32","declare33","declare34","declare35","declare36","declare37","declare38","declare39","declare40","declare41","declare42","declare43","declare44","declare45","declare46","declare47","declare48","declare49","declare50","declare51","declare52","declare53","declare54","declare55","declare56","declare57","declare58","declare59","declare60","declare61","declare62","declare63","declare64","addfilelist","remark1","remark2","remark3"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"Type","type","int"},{"DeclareId","declareid","int"},{"Academy","academy","String"},{"XyHonour","xyhonour","String"},{"Submitflag","submitflag","int"},{"XyCheckFlag","xycheckflag","int"},{"TwCheckFlag","twcheckflag","int"},{"Addaccount","addaccount","String"},{"Addtime","addtime","String"},{"Declare1","declare1","String"},{"Declare2","declare2","String"},{"Declare5","declare5","String"},{"Declare8","declare8","String"},{"Declare6","declare6","String"},{"Declare7","declare7","String"},{"Declare9","declare9","String"},{"Declare10","declare10","String"},{"Declare11","declare11","String"},{"Declare12","declare12","String"},{"Declare13","declare13","String"},{"Declare14","declare14","String"},{"Declare15","declare15","String"},{"Declare16","declare16","String"},{"Declare17","declare17","String"},{"Declare18","declare18","String"},{"Declare19","declare19","String"},{"Declare20","declare20","String"},{"Declare21","declare21","String"},{"Declare22","declare22","String"},{"Declare23","declare23","String"},{"Declare24","declare24","String"},{"Declare25","declare25","String"},{"Declare26","declare26","String"},{"Declare27","declare27","String"},{"Declare28","declare28","String"},{"Declare29","declare29","String"},{"Declare30","declare30","String"},{"Declare31","declare31","String"},{"Declare32","declare32","String"},{"Declare33","declare33","String"},{"Declare34","declare34","String"},{"Declare35","declare35","String"},{"Declare36","declare36","String"},{"Declare37","declare37","String"},{"Declare38","declare38","String"},{"Declare39","declare39","String"},{"Declare40","declare40","String"},{"Declare41","declare41","String"},{"Declare42","declare42","String"},{"Declare43","declare43","String"},{"Declare44","declare44","String"},{"Declare45","declare45","String"},{"Declare46","declare46","String"},{"Declare47","declare47","String"},{"Declare48","declare48","String"},{"Declare49","declare49","String"},{"Declare50","declare50","String"},{"Declare51","declare51","String"},{"Declare52","declare52","String"},{"Declare53","declare53","String"},{"Declare54","declare54","String"},{"Declare55","declare55","String"},{"Declare56","declare56","String"},{"Declare57","declare57","String"},{"Declare58","declare58","String"},{"Declare59","declare59","String"},{"Declare60","declare60","String"},{"Declare61","declare61","String"},{"Declare62","declare62","String"},{"Declare63","declare63","String"},{"Declare64","declare64","String"},{"AddFileList","addfilelist","String"},{"Remark1","remark1","String"},{"Remark2","remark2","String"},{"Remark3","remark3","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"type","type"},{"declareId","declareid"},{"academy","academy"},{"xyHonour","xyhonour"},{"submitflag","submitflag"},{"xyCheckFlag","xycheckflag"},{"twCheckFlag","twcheckflag"},{"addaccount","addaccount"},{"addtime","addtime"},{"declare1","declare1"},{"declare2","declare2"},{"declare5","declare5"},{"declare8","declare8"},{"declare6","declare6"},{"declare7","declare7"},{"declare9","declare9"},{"declare10","declare10"},{"declare11","declare11"},{"declare12","declare12"},{"declare13","declare13"},{"declare14","declare14"},{"declare15","declare15"},{"declare16","declare16"},{"declare17","declare17"},{"declare18","declare18"},{"declare19","declare19"},{"declare20","declare20"},{"declare21","declare21"},{"declare22","declare22"},{"declare23","declare23"},{"declare24","declare24"},{"declare25","declare25"},{"declare26","declare26"},{"declare27","declare27"},{"declare28","declare28"},{"declare29","declare29"},{"declare30","declare30"},{"declare31","declare31"},{"declare32","declare32"},{"declare33","declare33"},{"declare34","declare34"},{"declare35","declare35"},{"declare36","declare36"},{"declare37","declare37"},{"declare38","declare38"},{"declare39","declare39"},{"declare40","declare40"},{"declare41","declare41"},{"declare42","declare42"},{"declare43","declare43"},{"declare44","declare44"},{"declare45","declare45"},{"declare46","declare46"},{"declare47","declare47"},{"declare48","declare48"},{"declare49","declare49"},{"declare50","declare50"},{"declare51","declare51"},{"declare52","declare52"},{"declare53","declare53"},{"declare54","declare54"},{"declare55","declare55"},{"declare56","declare56"},{"declare57","declare57"},{"declare58","declare58"},{"declare59","declare59"},{"declare60","declare60"},{"declare61","declare61"},{"declare62","declare62"},{"declare63","declare63"},{"declare64","declare64"},{"addFileList","addfilelist"},{"remark1","remark1"},{"remark2","remark2"},{"remark3","remark3"}};
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
    // 类别
    protected int type = -1;
    public int getType() { return type; }
    public void setType(int aType) { type = aType; modifiedFields.add("Type"); }
    public void assignType(int aType) { type = aType; }
    public void paramType(HttpServletRequest request) { paramType(request, "Type"); }
    public void paramType(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getType()); if (tmp != getType()) { setType(tmp); } }
    // 立项表id
    protected int declareId = -1;
    public int getDeclareId() { return declareId; }
    public void setDeclareId(int aDeclareId) { declareId = aDeclareId; modifiedFields.add("DeclareId"); }
    public void assignDeclareId(int aDeclareId) { declareId = aDeclareId; }
    public void paramDeclareId(HttpServletRequest request) { paramDeclareId(request, "DeclareId"); }
    public void paramDeclareId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getDeclareId()); if (tmp != getDeclareId()) { setDeclareId(tmp); } }
    // 学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 学院设置荣誉
    protected String xyHonour = "";
    public String getXyHonour() {  return SqlTool.getDbString(xyHonour);  }
    public String getXyHonour(int size) { return SqlTool.subString(getXyHonour(), size); }
    public void setXyHonour(String aXyHonour) { xyHonour = aXyHonour; modifiedFields.add("XyHonour"); }
    public void assignXyHonour(String aXyHonour) { xyHonour = aXyHonour; }
    public void paramXyHonour(HttpServletRequest request) { paramXyHonour(request, "XyHonour"); }
    public void paramXyHonour(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getXyHonour()); if (!tmp.equals(getXyHonour())) { setXyHonour(tmp); } }
    // 提交状态
    protected int submitflag = -1;
    public int getSubmitflag() { return submitflag; }
    public void setSubmitflag(int aSubmitflag) { submitflag = aSubmitflag; modifiedFields.add("Submitflag"); }
    public void assignSubmitflag(int aSubmitflag) { submitflag = aSubmitflag; }
    public void paramSubmitflag(HttpServletRequest request) { paramSubmitflag(request, "Submitflag"); }
    public void paramSubmitflag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getSubmitflag()); if (tmp != getSubmitflag()) { setSubmitflag(tmp); } }
    // 学院状态
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
    // 添加用户
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
    // 课题名称
    protected String declare1 = "";
    public String getDeclare1() {  return SqlTool.getDbString(declare1);  }
    public String getDeclare1(int size) { return SqlTool.subString(getDeclare1(), size); }
    public void setDeclare1(String aDeclare1) { declare1 = aDeclare1; modifiedFields.add("Declare1"); }
    public void assignDeclare1(String aDeclare1) { declare1 = aDeclare1; }
    public void paramDeclare1(HttpServletRequest request) { paramDeclare1(request, "Declare1"); }
    public void paramDeclare1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare1()); if (!tmp.equals(getDeclare1())) { setDeclare1(tmp); } }
    // 团队名称
    protected String declare2 = "";
    public String getDeclare2() {  return SqlTool.getDbString(declare2);  }
    public String getDeclare2(int size) { return SqlTool.subString(getDeclare2(), size); }
    public void setDeclare2(String aDeclare2) { declare2 = aDeclare2; modifiedFields.add("Declare2"); }
    public void assignDeclare2(String aDeclare2) { declare2 = aDeclare2; }
    public void paramDeclare2(HttpServletRequest request) { paramDeclare2(request, "Declare2"); }
    public void paramDeclare2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare2()); if (!tmp.equals(getDeclare2())) { setDeclare2(tmp); } }
    // 实践主题
    protected String declare5 = "";
    public String getDeclare5() {  return SqlTool.getDbString(declare5);  }
    public String getDeclare5(int size) { return SqlTool.subString(getDeclare5(), size); }
    public void setDeclare5(String aDeclare5) { declare5 = aDeclare5; modifiedFields.add("Declare5"); }
    public void assignDeclare5(String aDeclare5) { declare5 = aDeclare5; }
    public void paramDeclare5(HttpServletRequest request) { paramDeclare5(request, "Declare5"); }
    public void paramDeclare5(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare5()); if (!tmp.equals(getDeclare5())) { setDeclare5(tmp); } }
    // 其他主题
    protected String declare8 = "";
    public String getDeclare8() {  return SqlTool.getDbString(declare8);  }
    public String getDeclare8(int size) { return SqlTool.subString(getDeclare8(), size); }
    public void setDeclare8(String aDeclare8) { declare8 = aDeclare8; modifiedFields.add("Declare8"); }
    public void assignDeclare8(String aDeclare8) { declare8 = aDeclare8; }
    public void paramDeclare8(HttpServletRequest request) { paramDeclare8(request, "Declare8"); }
    public void paramDeclare8(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare8()); if (!tmp.equals(getDeclare8())) { setDeclare8(tmp); } }
    // 接受单位（个人）
    protected String declare6 = "";
    public String getDeclare6() {  return SqlTool.getDbString(declare6);  }
    public String getDeclare6(int size) { return SqlTool.subString(getDeclare6(), size); }
    public void setDeclare6(String aDeclare6) { declare6 = aDeclare6; modifiedFields.add("Declare6"); }
    public void assignDeclare6(String aDeclare6) { declare6 = aDeclare6; }
    public void paramDeclare6(HttpServletRequest request) { paramDeclare6(request, "Declare6"); }
    public void paramDeclare6(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare6()); if (!tmp.equals(getDeclare6())) { setDeclare6(tmp); } }
    // 接收单位负责人或接收个人姓名
    protected String declare7 = "";
    public String getDeclare7() {  return SqlTool.getDbString(declare7);  }
    public String getDeclare7(int size) { return SqlTool.subString(getDeclare7(), size); }
    public void setDeclare7(String aDeclare7) { declare7 = aDeclare7; modifiedFields.add("Declare7"); }
    public void assignDeclare7(String aDeclare7) { declare7 = aDeclare7; }
    public void paramDeclare7(HttpServletRequest request) { paramDeclare7(request, "Declare7"); }
    public void paramDeclare7(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare7()); if (!tmp.equals(getDeclare7())) { setDeclare7(tmp); } }
    // 手机
    protected String declare9 = "";
    public String getDeclare9() {  return SqlTool.getDbString(declare9);  }
    public String getDeclare9(int size) { return SqlTool.subString(getDeclare9(), size); }
    public void setDeclare9(String aDeclare9) { declare9 = aDeclare9; modifiedFields.add("Declare9"); }
    public void assignDeclare9(String aDeclare9) { declare9 = aDeclare9; }
    public void paramDeclare9(HttpServletRequest request) { paramDeclare9(request, "Declare9"); }
    public void paramDeclare9(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare9()); if (!tmp.equals(getDeclare9())) { setDeclare9(tmp); } }
    // 接受单位个人简介
    protected String declare10 = "";
    public String getDeclare10() {  return SqlTool.getDbString(declare10);  }
    public String getDeclare10(int size) { return SqlTool.subString(getDeclare10(), size); }
    public void setDeclare10(String aDeclare10) { declare10 = aDeclare10; modifiedFields.add("Declare10"); }
    public void assignDeclare10(String aDeclare10) { declare10 = aDeclare10; }
    public void paramDeclare10(HttpServletRequest request) { paramDeclare10(request, "Declare10"); }
    public void paramDeclare10(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare10()); if (!tmp.equals(getDeclare10())) { setDeclare10(tmp); } }
    // 活动计划主题
    protected String declare11 = "";
    public String getDeclare11() {  return SqlTool.getDbString(declare11);  }
    public String getDeclare11(int size) { return SqlTool.subString(getDeclare11(), size); }
    public void setDeclare11(String aDeclare11) { declare11 = aDeclare11; modifiedFields.add("Declare11"); }
    public void assignDeclare11(String aDeclare11) { declare11 = aDeclare11; }
    public void paramDeclare11(HttpServletRequest request) { paramDeclare11(request, "Declare11"); }
    public void paramDeclare11(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare11()); if (!tmp.equals(getDeclare11())) { setDeclare11(tmp); } }
    // 活动计划背景及意义
    protected String declare12 = "";
    public String getDeclare12() {  return SqlTool.getDbString(declare12);  }
    public String getDeclare12(int size) { return SqlTool.subString(getDeclare12(), size); }
    public void setDeclare12(String aDeclare12) { declare12 = aDeclare12; modifiedFields.add("Declare12"); }
    public void assignDeclare12(String aDeclare12) { declare12 = aDeclare12; }
    public void paramDeclare12(HttpServletRequest request) { paramDeclare12(request, "Declare12"); }
    public void paramDeclare12(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare12()); if (!tmp.equals(getDeclare12())) { setDeclare12(tmp); } }
    // 时间
    protected String declare13 = "";
    public String getDeclare13() {  return SqlTool.getDbString(declare13);  }
    public String getDeclare13(int size) { return SqlTool.subString(getDeclare13(), size); }
    public void setDeclare13(String aDeclare13) { declare13 = aDeclare13; modifiedFields.add("Declare13"); }
    public void assignDeclare13(String aDeclare13) { declare13 = aDeclare13; }
    public void paramDeclare13(HttpServletRequest request) { paramDeclare13(request, "Declare13"); }
    public void paramDeclare13(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare13()); if (!tmp.equals(getDeclare13())) { setDeclare13(tmp); } }
    // 活动地点及路线
    protected String declare14 = "";
    public String getDeclare14() {  return SqlTool.getDbString(declare14);  }
    public String getDeclare14(int size) { return SqlTool.subString(getDeclare14(), size); }
    public void setDeclare14(String aDeclare14) { declare14 = aDeclare14; modifiedFields.add("Declare14"); }
    public void assignDeclare14(String aDeclare14) { declare14 = aDeclare14; }
    public void paramDeclare14(HttpServletRequest request) { paramDeclare14(request, "Declare14"); }
    public void paramDeclare14(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare14()); if (!tmp.equals(getDeclare14())) { setDeclare14(tmp); } }
    // 项目预期成果
    protected String declare15 = "";
    public String getDeclare15() {  return SqlTool.getDbString(declare15);  }
    public String getDeclare15(int size) { return SqlTool.subString(getDeclare15(), size); }
    public void setDeclare15(String aDeclare15) { declare15 = aDeclare15; modifiedFields.add("Declare15"); }
    public void assignDeclare15(String aDeclare15) { declare15 = aDeclare15; }
    public void paramDeclare15(HttpServletRequest request) { paramDeclare15(request, "Declare15"); }
    public void paramDeclare15(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare15()); if (!tmp.equals(getDeclare15())) { setDeclare15(tmp); } }
    // 宣讲会
    protected String declare16 = "";
    public String getDeclare16() {  return SqlTool.getDbString(declare16);  }
    public String getDeclare16(int size) { return SqlTool.subString(getDeclare16(), size); }
    public void setDeclare16(String aDeclare16) { declare16 = aDeclare16; modifiedFields.add("Declare16"); }
    public void assignDeclare16(String aDeclare16) { declare16 = aDeclare16; }
    public void paramDeclare16(HttpServletRequest request) { paramDeclare16(request, "Declare16"); }
    public void paramDeclare16(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare16()); if (!tmp.equals(getDeclare16())) { setDeclare16(tmp); } }
    // 讲座
    protected String declare17 = "";
    public String getDeclare17() {  return SqlTool.getDbString(declare17);  }
    public String getDeclare17(int size) { return SqlTool.subString(getDeclare17(), size); }
    public void setDeclare17(String aDeclare17) { declare17 = aDeclare17; modifiedFields.add("Declare17"); }
    public void assignDeclare17(String aDeclare17) { declare17 = aDeclare17; }
    public void paramDeclare17(HttpServletRequest request) { paramDeclare17(request, "Declare17"); }
    public void paramDeclare17(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare17()); if (!tmp.equals(getDeclare17())) { setDeclare17(tmp); } }
    // 专业培训
    protected String declare18 = "";
    public String getDeclare18() {  return SqlTool.getDbString(declare18);  }
    public String getDeclare18(int size) { return SqlTool.subString(getDeclare18(), size); }
    public void setDeclare18(String aDeclare18) { declare18 = aDeclare18; modifiedFields.add("Declare18"); }
    public void assignDeclare18(String aDeclare18) { declare18 = aDeclare18; }
    public void paramDeclare18(HttpServletRequest request) { paramDeclare18(request, "Declare18"); }
    public void paramDeclare18(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare18()); if (!tmp.equals(getDeclare18())) { setDeclare18(tmp); } }
    // 调研报告
    protected String declare19 = "";
    public String getDeclare19() {  return SqlTool.getDbString(declare19);  }
    public String getDeclare19(int size) { return SqlTool.subString(getDeclare19(), size); }
    public void setDeclare19(String aDeclare19) { declare19 = aDeclare19; modifiedFields.add("Declare19"); }
    public void assignDeclare19(String aDeclare19) { declare19 = aDeclare19; }
    public void paramDeclare19(HttpServletRequest request) { paramDeclare19(request, "Declare19"); }
    public void paramDeclare19(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare19()); if (!tmp.equals(getDeclare19())) { setDeclare19(tmp); } }
    // 支教受益人数
    protected String declare20 = "";
    public String getDeclare20() {  return SqlTool.getDbString(declare20);  }
    public String getDeclare20(int size) { return SqlTool.subString(getDeclare20(), size); }
    public void setDeclare20(String aDeclare20) { declare20 = aDeclare20; modifiedFields.add("Declare20"); }
    public void assignDeclare20(String aDeclare20) { declare20 = aDeclare20; }
    public void paramDeclare20(HttpServletRequest request) { paramDeclare20(request, "Declare20"); }
    public void paramDeclare20(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare20()); if (!tmp.equals(getDeclare20())) { setDeclare20(tmp); } }
    // 文体演出
    protected String declare21 = "";
    public String getDeclare21() {  return SqlTool.getDbString(declare21);  }
    public String getDeclare21(int size) { return SqlTool.subString(getDeclare21(), size); }
    public void setDeclare21(String aDeclare21) { declare21 = aDeclare21; modifiedFields.add("Declare21"); }
    public void assignDeclare21(String aDeclare21) { declare21 = aDeclare21; }
    public void paramDeclare21(HttpServletRequest request) { paramDeclare21(request, "Declare21"); }
    public void paramDeclare21(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare21()); if (!tmp.equals(getDeclare21())) { setDeclare21(tmp); } }
    // 捐赠（价值）
    protected String declare22 = "";
    public String getDeclare22() {  return SqlTool.getDbString(declare22);  }
    public String getDeclare22(int size) { return SqlTool.subString(getDeclare22(), size); }
    public void setDeclare22(String aDeclare22) { declare22 = aDeclare22; modifiedFields.add("Declare22"); }
    public void assignDeclare22(String aDeclare22) { declare22 = aDeclare22; }
    public void paramDeclare22(HttpServletRequest request) { paramDeclare22(request, "Declare22"); }
    public void paramDeclare22(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare22()); if (!tmp.equals(getDeclare22())) { setDeclare22(tmp); } }
    // 咨询场次
    protected String declare23 = "";
    public String getDeclare23() {  return SqlTool.getDbString(declare23);  }
    public String getDeclare23(int size) { return SqlTool.subString(getDeclare23(), size); }
    public void setDeclare23(String aDeclare23) { declare23 = aDeclare23; modifiedFields.add("Declare23"); }
    public void assignDeclare23(String aDeclare23) { declare23 = aDeclare23; }
    public void paramDeclare23(HttpServletRequest request) { paramDeclare23(request, "Declare23"); }
    public void paramDeclare23(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare23()); if (!tmp.equals(getDeclare23())) { setDeclare23(tmp); } }
    // 是否建立实践基地
    protected String declare24 = "";
    public String getDeclare24() {  return SqlTool.getDbString(declare24);  }
    public String getDeclare24(int size) { return SqlTool.subString(getDeclare24(), size); }
    public void setDeclare24(String aDeclare24) { declare24 = aDeclare24; modifiedFields.add("Declare24"); }
    public void assignDeclare24(String aDeclare24) { declare24 = aDeclare24; }
    public void paramDeclare24(HttpServletRequest request) { paramDeclare24(request, "Declare24"); }
    public void paramDeclare24(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare24()); if (!tmp.equals(getDeclare24())) { setDeclare24(tmp); } }
    // 其它实践成果
    protected String declare25 = "";
    public String getDeclare25() {  return SqlTool.getDbString(declare25);  }
    public String getDeclare25(int size) { return SqlTool.subString(getDeclare25(), size); }
    public void setDeclare25(String aDeclare25) { declare25 = aDeclare25; modifiedFields.add("Declare25"); }
    public void assignDeclare25(String aDeclare25) { declare25 = aDeclare25; }
    public void paramDeclare25(HttpServletRequest request) { paramDeclare25(request, "Declare25"); }
    public void paramDeclare25(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare25()); if (!tmp.equals(getDeclare25())) { setDeclare25(tmp); } }
    // 实践中团队是否拍摄DV
    protected String declare26 = "";
    public String getDeclare26() {  return SqlTool.getDbString(declare26);  }
    public String getDeclare26(int size) { return SqlTool.subString(getDeclare26(), size); }
    public void setDeclare26(String aDeclare26) { declare26 = aDeclare26; modifiedFields.add("Declare26"); }
    public void assignDeclare26(String aDeclare26) { declare26 = aDeclare26; }
    public void paramDeclare26(HttpServletRequest request) { paramDeclare26(request, "Declare26"); }
    public void paramDeclare26(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare26()); if (!tmp.equals(getDeclare26())) { setDeclare26(tmp); } }
    // 前期准备工作
    protected String declare27 = "";
    public String getDeclare27() {  return SqlTool.getDbString(declare27);  }
    public String getDeclare27(int size) { return SqlTool.subString(getDeclare27(), size); }
    public void setDeclare27(String aDeclare27) { declare27 = aDeclare27; modifiedFields.add("Declare27"); }
    public void assignDeclare27(String aDeclare27) { declare27 = aDeclare27; }
    public void paramDeclare27(HttpServletRequest request) { paramDeclare27(request, "Declare27"); }
    public void paramDeclare27(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare27()); if (!tmp.equals(getDeclare27())) { setDeclare27(tmp); } }
    // 新闻媒体联系报道
    protected String declare28 = "";
    public String getDeclare28() {  return SqlTool.getDbString(declare28);  }
    public String getDeclare28(int size) { return SqlTool.subString(getDeclare28(), size); }
    public void setDeclare28(String aDeclare28) { declare28 = aDeclare28; modifiedFields.add("Declare28"); }
    public void assignDeclare28(String aDeclare28) { declare28 = aDeclare28; }
    public void paramDeclare28(HttpServletRequest request) { paramDeclare28(request, "Declare28"); }
    public void paramDeclare28(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare28()); if (!tmp.equals(getDeclare28())) { setDeclare28(tmp); } }
    // 实践期间完成的任务、详细活动计划及日程安排
    protected String declare29 = "";
    public String getDeclare29() {  return SqlTool.getDbString(declare29);  }
    public String getDeclare29(int size) { return SqlTool.subString(getDeclare29(), size); }
    public void setDeclare29(String aDeclare29) { declare29 = aDeclare29; modifiedFields.add("Declare29"); }
    public void assignDeclare29(String aDeclare29) { declare29 = aDeclare29; }
    public void paramDeclare29(HttpServletRequest request) { paramDeclare29(request, "Declare29"); }
    public void paramDeclare29(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare29()); if (!tmp.equals(getDeclare29())) { setDeclare29(tmp); } }
    // 团队安全应急预案
    protected String declare30 = "";
    public String getDeclare30() {  return SqlTool.getDbString(declare30);  }
    public String getDeclare30(int size) { return SqlTool.subString(getDeclare30(), size); }
    public void setDeclare30(String aDeclare30) { declare30 = aDeclare30; modifiedFields.add("Declare30"); }
    public void assignDeclare30(String aDeclare30) { declare30 = aDeclare30; }
    public void paramDeclare30(HttpServletRequest request) { paramDeclare30(request, "Declare30"); }
    public void paramDeclare30(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare30()); if (!tmp.equals(getDeclare30())) { setDeclare30(tmp); } }
    // 指导老师姓名
    protected String declare31 = "";
    public String getDeclare31() {  return SqlTool.getDbString(declare31);  }
    public String getDeclare31(int size) { return SqlTool.subString(getDeclare31(), size); }
    public void setDeclare31(String aDeclare31) { declare31 = aDeclare31; modifiedFields.add("Declare31"); }
    public void assignDeclare31(String aDeclare31) { declare31 = aDeclare31; }
    public void paramDeclare31(HttpServletRequest request) { paramDeclare31(request, "Declare31"); }
    public void paramDeclare31(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare31()); if (!tmp.equals(getDeclare31())) { setDeclare31(tmp); } }
    // 是否随从队伍
    protected String declare32 = "";
    public String getDeclare32() {  return SqlTool.getDbString(declare32);  }
    public String getDeclare32(int size) { return SqlTool.subString(getDeclare32(), size); }
    public void setDeclare32(String aDeclare32) { declare32 = aDeclare32; modifiedFields.add("Declare32"); }
    public void assignDeclare32(String aDeclare32) { declare32 = aDeclare32; }
    public void paramDeclare32(HttpServletRequest request) { paramDeclare32(request, "Declare32"); }
    public void paramDeclare32(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare32()); if (!tmp.equals(getDeclare32())) { setDeclare32(tmp); } }
    // 工作单位
    protected String declare33 = "";
    public String getDeclare33() {  return SqlTool.getDbString(declare33);  }
    public String getDeclare33(int size) { return SqlTool.subString(getDeclare33(), size); }
    public void setDeclare33(String aDeclare33) { declare33 = aDeclare33; modifiedFields.add("Declare33"); }
    public void assignDeclare33(String aDeclare33) { declare33 = aDeclare33; }
    public void paramDeclare33(HttpServletRequest request) { paramDeclare33(request, "Declare33"); }
    public void paramDeclare33(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare33()); if (!tmp.equals(getDeclare33())) { setDeclare33(tmp); } }
    // 职务职称
    protected String declare34 = "";
    public String getDeclare34() {  return SqlTool.getDbString(declare34);  }
    public String getDeclare34(int size) { return SqlTool.subString(getDeclare34(), size); }
    public void setDeclare34(String aDeclare34) { declare34 = aDeclare34; modifiedFields.add("Declare34"); }
    public void assignDeclare34(String aDeclare34) { declare34 = aDeclare34; }
    public void paramDeclare34(HttpServletRequest request) { paramDeclare34(request, "Declare34"); }
    public void paramDeclare34(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare34()); if (!tmp.equals(getDeclare34())) { setDeclare34(tmp); } }
    // 指导老师电话
    protected String declare35 = "";
    public String getDeclare35() {  return SqlTool.getDbString(declare35);  }
    public String getDeclare35(int size) { return SqlTool.subString(getDeclare35(), size); }
    public void setDeclare35(String aDeclare35) { declare35 = aDeclare35; modifiedFields.add("Declare35"); }
    public void assignDeclare35(String aDeclare35) { declare35 = aDeclare35; }
    public void paramDeclare35(HttpServletRequest request) { paramDeclare35(request, "Declare35"); }
    public void paramDeclare35(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare35()); if (!tmp.equals(getDeclare35())) { setDeclare35(tmp); } }
    // 指导老师手机
    protected String declare36 = "";
    public String getDeclare36() {  return SqlTool.getDbString(declare36);  }
    public String getDeclare36(int size) { return SqlTool.subString(getDeclare36(), size); }
    public void setDeclare36(String aDeclare36) { declare36 = aDeclare36; modifiedFields.add("Declare36"); }
    public void assignDeclare36(String aDeclare36) { declare36 = aDeclare36; }
    public void paramDeclare36(HttpServletRequest request) { paramDeclare36(request, "Declare36"); }
    public void paramDeclare36(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare36()); if (!tmp.equals(getDeclare36())) { setDeclare36(tmp); } }
    // 指导老师邮箱
    protected String declare37 = "";
    public String getDeclare37() {  return SqlTool.getDbString(declare37);  }
    public String getDeclare37(int size) { return SqlTool.subString(getDeclare37(), size); }
    public void setDeclare37(String aDeclare37) { declare37 = aDeclare37; modifiedFields.add("Declare37"); }
    public void assignDeclare37(String aDeclare37) { declare37 = aDeclare37; }
    public void paramDeclare37(HttpServletRequest request) { paramDeclare37(request, "Declare37"); }
    public void paramDeclare37(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare37()); if (!tmp.equals(getDeclare37())) { setDeclare37(tmp); } }
    // 领队姓名
    protected String declare38 = "";
    public String getDeclare38() {  return SqlTool.getDbString(declare38);  }
    public String getDeclare38(int size) { return SqlTool.subString(getDeclare38(), size); }
    public void setDeclare38(String aDeclare38) { declare38 = aDeclare38; modifiedFields.add("Declare38"); }
    public void assignDeclare38(String aDeclare38) { declare38 = aDeclare38; }
    public void paramDeclare38(HttpServletRequest request) { paramDeclare38(request, "Declare38"); }
    public void paramDeclare38(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare38()); if (!tmp.equals(getDeclare38())) { setDeclare38(tmp); } }
    // 领队工作单位
    protected String declare39 = "";
    public String getDeclare39() {  return SqlTool.getDbString(declare39);  }
    public String getDeclare39(int size) { return SqlTool.subString(getDeclare39(), size); }
    public void setDeclare39(String aDeclare39) { declare39 = aDeclare39; modifiedFields.add("Declare39"); }
    public void assignDeclare39(String aDeclare39) { declare39 = aDeclare39; }
    public void paramDeclare39(HttpServletRequest request) { paramDeclare39(request, "Declare39"); }
    public void paramDeclare39(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare39()); if (!tmp.equals(getDeclare39())) { setDeclare39(tmp); } }
    // 领队职务名称
    protected String declare40 = "";
    public String getDeclare40() {  return SqlTool.getDbString(declare40);  }
    public String getDeclare40(int size) { return SqlTool.subString(getDeclare40(), size); }
    public void setDeclare40(String aDeclare40) { declare40 = aDeclare40; modifiedFields.add("Declare40"); }
    public void assignDeclare40(String aDeclare40) { declare40 = aDeclare40; }
    public void paramDeclare40(HttpServletRequest request) { paramDeclare40(request, "Declare40"); }
    public void paramDeclare40(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare40()); if (!tmp.equals(getDeclare40())) { setDeclare40(tmp); } }
    // 领队电话
    protected String declare41 = "";
    public String getDeclare41() {  return SqlTool.getDbString(declare41);  }
    public String getDeclare41(int size) { return SqlTool.subString(getDeclare41(), size); }
    public void setDeclare41(String aDeclare41) { declare41 = aDeclare41; modifiedFields.add("Declare41"); }
    public void assignDeclare41(String aDeclare41) { declare41 = aDeclare41; }
    public void paramDeclare41(HttpServletRequest request) { paramDeclare41(request, "Declare41"); }
    public void paramDeclare41(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare41()); if (!tmp.equals(getDeclare41())) { setDeclare41(tmp); } }
    // 领队手机
    protected String declare42 = "";
    public String getDeclare42() {  return SqlTool.getDbString(declare42);  }
    public String getDeclare42(int size) { return SqlTool.subString(getDeclare42(), size); }
    public void setDeclare42(String aDeclare42) { declare42 = aDeclare42; modifiedFields.add("Declare42"); }
    public void assignDeclare42(String aDeclare42) { declare42 = aDeclare42; }
    public void paramDeclare42(HttpServletRequest request) { paramDeclare42(request, "Declare42"); }
    public void paramDeclare42(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare42()); if (!tmp.equals(getDeclare42())) { setDeclare42(tmp); } }
    // 领队邮箱
    protected String declare43 = "";
    public String getDeclare43() {  return SqlTool.getDbString(declare43);  }
    public String getDeclare43(int size) { return SqlTool.subString(getDeclare43(), size); }
    public void setDeclare43(String aDeclare43) { declare43 = aDeclare43; modifiedFields.add("Declare43"); }
    public void assignDeclare43(String aDeclare43) { declare43 = aDeclare43; }
    public void paramDeclare43(HttpServletRequest request) { paramDeclare43(request, "Declare43"); }
    public void paramDeclare43(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare43()); if (!tmp.equals(getDeclare43())) { setDeclare43(tmp); } }
    // 领队2姓名
    protected String declare44 = "";
    public String getDeclare44() {  return SqlTool.getDbString(declare44);  }
    public String getDeclare44(int size) { return SqlTool.subString(getDeclare44(), size); }
    public void setDeclare44(String aDeclare44) { declare44 = aDeclare44; modifiedFields.add("Declare44"); }
    public void assignDeclare44(String aDeclare44) { declare44 = aDeclare44; }
    public void paramDeclare44(HttpServletRequest request) { paramDeclare44(request, "Declare44"); }
    public void paramDeclare44(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare44()); if (!tmp.equals(getDeclare44())) { setDeclare44(tmp); } }
    // 领队2学院
    protected String declare45 = "";
    public String getDeclare45() {  return SqlTool.getDbString(declare45);  }
    public String getDeclare45(int size) { return SqlTool.subString(getDeclare45(), size); }
    public void setDeclare45(String aDeclare45) { declare45 = aDeclare45; modifiedFields.add("Declare45"); }
    public void assignDeclare45(String aDeclare45) { declare45 = aDeclare45; }
    public void paramDeclare45(HttpServletRequest request) { paramDeclare45(request, "Declare45"); }
    public void paramDeclare45(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare45()); if (!tmp.equals(getDeclare45())) { setDeclare45(tmp); } }
    // 领队2专业
    protected String declare46 = "";
    public String getDeclare46() {  return SqlTool.getDbString(declare46);  }
    public String getDeclare46(int size) { return SqlTool.subString(getDeclare46(), size); }
    public void setDeclare46(String aDeclare46) { declare46 = aDeclare46; modifiedFields.add("Declare46"); }
    public void assignDeclare46(String aDeclare46) { declare46 = aDeclare46; }
    public void paramDeclare46(HttpServletRequest request) { paramDeclare46(request, "Declare46"); }
    public void paramDeclare46(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare46()); if (!tmp.equals(getDeclare46())) { setDeclare46(tmp); } }
    // 领队2年级
    protected String declare47 = "";
    public String getDeclare47() {  return SqlTool.getDbString(declare47);  }
    public String getDeclare47(int size) { return SqlTool.subString(getDeclare47(), size); }
    public void setDeclare47(String aDeclare47) { declare47 = aDeclare47; modifiedFields.add("Declare47"); }
    public void assignDeclare47(String aDeclare47) { declare47 = aDeclare47; }
    public void paramDeclare47(HttpServletRequest request) { paramDeclare47(request, "Declare47"); }
    public void paramDeclare47(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare47()); if (!tmp.equals(getDeclare47())) { setDeclare47(tmp); } }
    // 领队2学历
    protected String declare48 = "";
    public String getDeclare48() {  return SqlTool.getDbString(declare48);  }
    public String getDeclare48(int size) { return SqlTool.subString(getDeclare48(), size); }
    public void setDeclare48(String aDeclare48) { declare48 = aDeclare48; modifiedFields.add("Declare48"); }
    public void assignDeclare48(String aDeclare48) { declare48 = aDeclare48; }
    public void paramDeclare48(HttpServletRequest request) { paramDeclare48(request, "Declare48"); }
    public void paramDeclare48(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare48()); if (!tmp.equals(getDeclare48())) { setDeclare48(tmp); } }
    // 领队2电话
    protected String declare49 = "";
    public String getDeclare49() {  return SqlTool.getDbString(declare49);  }
    public String getDeclare49(int size) { return SqlTool.subString(getDeclare49(), size); }
    public void setDeclare49(String aDeclare49) { declare49 = aDeclare49; modifiedFields.add("Declare49"); }
    public void assignDeclare49(String aDeclare49) { declare49 = aDeclare49; }
    public void paramDeclare49(HttpServletRequest request) { paramDeclare49(request, "Declare49"); }
    public void paramDeclare49(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare49()); if (!tmp.equals(getDeclare49())) { setDeclare49(tmp); } }
    // 领队2手机
    protected String declare50 = "";
    public String getDeclare50() {  return SqlTool.getDbString(declare50);  }
    public String getDeclare50(int size) { return SqlTool.subString(getDeclare50(), size); }
    public void setDeclare50(String aDeclare50) { declare50 = aDeclare50; modifiedFields.add("Declare50"); }
    public void assignDeclare50(String aDeclare50) { declare50 = aDeclare50; }
    public void paramDeclare50(HttpServletRequest request) { paramDeclare50(request, "Declare50"); }
    public void paramDeclare50(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare50()); if (!tmp.equals(getDeclare50())) { setDeclare50(tmp); } }
    // 领队2邮箱
    protected String declare51 = "";
    public String getDeclare51() {  return SqlTool.getDbString(declare51);  }
    public String getDeclare51(int size) { return SqlTool.subString(getDeclare51(), size); }
    public void setDeclare51(String aDeclare51) { declare51 = aDeclare51; modifiedFields.add("Declare51"); }
    public void assignDeclare51(String aDeclare51) { declare51 = aDeclare51; }
    public void paramDeclare51(HttpServletRequest request) { paramDeclare51(request, "Declare51"); }
    public void paramDeclare51(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare51()); if (!tmp.equals(getDeclare51())) { setDeclare51(tmp); } }
    // 总人数
    protected String declare52 = "";
    public String getDeclare52() {  return SqlTool.getDbString(declare52);  }
    public String getDeclare52(int size) { return SqlTool.subString(getDeclare52(), size); }
    public void setDeclare52(String aDeclare52) { declare52 = aDeclare52; modifiedFields.add("Declare52"); }
    public void assignDeclare52(String aDeclare52) { declare52 = aDeclare52; }
    public void paramDeclare52(HttpServletRequest request) { paramDeclare52(request, "Declare52"); }
    public void paramDeclare52(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare52()); if (!tmp.equals(getDeclare52())) { setDeclare52(tmp); } }
    // 专业老师
    protected String declare53 = "";
    public String getDeclare53() {  return SqlTool.getDbString(declare53);  }
    public String getDeclare53(int size) { return SqlTool.subString(getDeclare53(), size); }
    public void setDeclare53(String aDeclare53) { declare53 = aDeclare53; modifiedFields.add("Declare53"); }
    public void assignDeclare53(String aDeclare53) { declare53 = aDeclare53; }
    public void paramDeclare53(HttpServletRequest request) { paramDeclare53(request, "Declare53"); }
    public void paramDeclare53(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare53()); if (!tmp.equals(getDeclare53())) { setDeclare53(tmp); } }
    // 政工干部
    protected String declare54 = "";
    public String getDeclare54() {  return SqlTool.getDbString(declare54);  }
    public String getDeclare54(int size) { return SqlTool.subString(getDeclare54(), size); }
    public void setDeclare54(String aDeclare54) { declare54 = aDeclare54; modifiedFields.add("Declare54"); }
    public void assignDeclare54(String aDeclare54) { declare54 = aDeclare54; }
    public void paramDeclare54(HttpServletRequest request) { paramDeclare54(request, "Declare54"); }
    public void paramDeclare54(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare54()); if (!tmp.equals(getDeclare54())) { setDeclare54(tmp); } }
    // 本专科学生
    protected String declare55 = "";
    public String getDeclare55() {  return SqlTool.getDbString(declare55);  }
    public String getDeclare55(int size) { return SqlTool.subString(getDeclare55(), size); }
    public void setDeclare55(String aDeclare55) { declare55 = aDeclare55; modifiedFields.add("Declare55"); }
    public void assignDeclare55(String aDeclare55) { declare55 = aDeclare55; }
    public void paramDeclare55(HttpServletRequest request) { paramDeclare55(request, "Declare55"); }
    public void paramDeclare55(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare55()); if (!tmp.equals(getDeclare55())) { setDeclare55(tmp); } }
    // 研究生
    protected String declare56 = "";
    public String getDeclare56() {  return SqlTool.getDbString(declare56);  }
    public String getDeclare56(int size) { return SqlTool.subString(getDeclare56(), size); }
    public void setDeclare56(String aDeclare56) { declare56 = aDeclare56; modifiedFields.add("Declare56"); }
    public void assignDeclare56(String aDeclare56) { declare56 = aDeclare56; }
    public void paramDeclare56(HttpServletRequest request) { paramDeclare56(request, "Declare56"); }
    public void paramDeclare56(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare56()); if (!tmp.equals(getDeclare56())) { setDeclare56(tmp); } }
    // 交通费
    protected String declare57 = "";
    public String getDeclare57() {  return SqlTool.getDbString(declare57);  }
    public String getDeclare57(int size) { return SqlTool.subString(getDeclare57(), size); }
    public void setDeclare57(String aDeclare57) { declare57 = aDeclare57; modifiedFields.add("Declare57"); }
    public void assignDeclare57(String aDeclare57) { declare57 = aDeclare57; }
    public void paramDeclare57(HttpServletRequest request) { paramDeclare57(request, "Declare57"); }
    public void paramDeclare57(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare57()); if (!tmp.equals(getDeclare57())) { setDeclare57(tmp); } }
    // 住宿费
    protected String declare58 = "";
    public String getDeclare58() {  return SqlTool.getDbString(declare58);  }
    public String getDeclare58(int size) { return SqlTool.subString(getDeclare58(), size); }
    public void setDeclare58(String aDeclare58) { declare58 = aDeclare58; modifiedFields.add("Declare58"); }
    public void assignDeclare58(String aDeclare58) { declare58 = aDeclare58; }
    public void paramDeclare58(HttpServletRequest request) { paramDeclare58(request, "Declare58"); }
    public void paramDeclare58(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare58()); if (!tmp.equals(getDeclare58())) { setDeclare58(tmp); } }
    // 其他费用
    protected String declare59 = "";
    public String getDeclare59() {  return SqlTool.getDbString(declare59);  }
    public String getDeclare59(int size) { return SqlTool.subString(getDeclare59(), size); }
    public void setDeclare59(String aDeclare59) { declare59 = aDeclare59; modifiedFields.add("Declare59"); }
    public void assignDeclare59(String aDeclare59) { declare59 = aDeclare59; }
    public void paramDeclare59(HttpServletRequest request) { paramDeclare59(request, "Declare59"); }
    public void paramDeclare59(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare59()); if (!tmp.equals(getDeclare59())) { setDeclare59(tmp); } }
    // 费用总计
    protected String declare60 = "";
    public String getDeclare60() {  return SqlTool.getDbString(declare60);  }
    public String getDeclare60(int size) { return SqlTool.subString(getDeclare60(), size); }
    public void setDeclare60(String aDeclare60) { declare60 = aDeclare60; modifiedFields.add("Declare60"); }
    public void assignDeclare60(String aDeclare60) { declare60 = aDeclare60; }
    public void paramDeclare60(HttpServletRequest request) { paramDeclare60(request, "Declare60"); }
    public void paramDeclare60(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare60()); if (!tmp.equals(getDeclare60())) { setDeclare60(tmp); } }
    // 团队自筹费用
    protected String declare61 = "";
    public String getDeclare61() {  return SqlTool.getDbString(declare61);  }
    public String getDeclare61(int size) { return SqlTool.subString(getDeclare61(), size); }
    public void setDeclare61(String aDeclare61) { declare61 = aDeclare61; modifiedFields.add("Declare61"); }
    public void assignDeclare61(String aDeclare61) { declare61 = aDeclare61; }
    public void paramDeclare61(HttpServletRequest request) { paramDeclare61(request, "Declare61"); }
    public void paramDeclare61(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare61()); if (!tmp.equals(getDeclare61())) { setDeclare61(tmp); } }
    // 申请学校立项经费
    protected String declare62 = "";
    public String getDeclare62() {  return SqlTool.getDbString(declare62);  }
    public String getDeclare62(int size) { return SqlTool.subString(getDeclare62(), size); }
    public void setDeclare62(String aDeclare62) { declare62 = aDeclare62; modifiedFields.add("Declare62"); }
    public void assignDeclare62(String aDeclare62) { declare62 = aDeclare62; }
    public void paramDeclare62(HttpServletRequest request) { paramDeclare62(request, "Declare62"); }
    public void paramDeclare62(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare62()); if (!tmp.equals(getDeclare62())) { setDeclare62(tmp); } }
    // 学校配套经费
    protected String declare63 = "";
    public String getDeclare63() {  return SqlTool.getDbString(declare63);  }
    public String getDeclare63(int size) { return SqlTool.subString(getDeclare63(), size); }
    public void setDeclare63(String aDeclare63) { declare63 = aDeclare63; modifiedFields.add("Declare63"); }
    public void assignDeclare63(String aDeclare63) { declare63 = aDeclare63; }
    public void paramDeclare63(HttpServletRequest request) { paramDeclare63(request, "Declare63"); }
    public void paramDeclare63(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare63()); if (!tmp.equals(getDeclare63())) { setDeclare63(tmp); } }
    // 接收单位（个人）支持经费
    protected String declare64 = "";
    public String getDeclare64() {  return SqlTool.getDbString(declare64);  }
    public String getDeclare64(int size) { return SqlTool.subString(getDeclare64(), size); }
    public void setDeclare64(String aDeclare64) { declare64 = aDeclare64; modifiedFields.add("Declare64"); }
    public void assignDeclare64(String aDeclare64) { declare64 = aDeclare64; }
    public void paramDeclare64(HttpServletRequest request) { paramDeclare64(request, "Declare64"); }
    public void paramDeclare64(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclare64()); if (!tmp.equals(getDeclare64())) { setDeclare64(tmp); } }
    // 附件
    protected String addFileList = "";
    public String getAddFileList() {  return SqlTool.getDbString(addFileList);  }
    public String getAddFileList(int size) { return SqlTool.subString(getAddFileList(), size); }
    public void setAddFileList(String aAddFileList) { addFileList = aAddFileList; modifiedFields.add("AddFileList"); }
    public void assignAddFileList(String aAddFileList) { addFileList = aAddFileList; }
    public void paramAddFileList(HttpServletRequest request) { paramAddFileList(request, "AddFileList"); }
    public void paramAddFileList(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddFileList()); if (!tmp.equals(getAddFileList())) { setAddFileList(tmp); } }
    // 备用
    protected String remark1 = "";
    public String getRemark1() {  return SqlTool.getDbString(remark1);  }
    public String getRemark1(int size) { return SqlTool.subString(getRemark1(), size); }
    public void setRemark1(String aRemark1) { remark1 = aRemark1; modifiedFields.add("Remark1"); }
    public void assignRemark1(String aRemark1) { remark1 = aRemark1; }
    public void paramRemark1(HttpServletRequest request) { paramRemark1(request, "Remark1"); }
    public void paramRemark1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark1()); if (!tmp.equals(getRemark1())) { setRemark1(tmp); } }
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
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public PracticeDeclare (String db) {
        DBNAME = db;
    }
    public PracticeDeclare (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public PracticeDeclare (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public PracticeDeclare () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return PracticeDeclare类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public PracticeDeclare getByParameter(HttpServletRequest request) {
        PracticeDeclare v = new PracticeDeclare(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramType(request);
        paramDeclareId(request);
        paramAcademy(request);
        paramXyHonour(request);
        paramSubmitflag(request);
        paramXyCheckFlag(request);
        paramTwCheckFlag(request);
        paramAddaccount(request);
        paramAddtime(request);
        paramDeclare1(request);
        paramDeclare2(request);
        paramDeclare5(request);
        paramDeclare8(request);
        paramDeclare6(request);
        paramDeclare7(request);
        paramDeclare9(request);
        paramDeclare10(request);
        paramDeclare11(request);
        paramDeclare12(request);
        paramDeclare13(request);
        paramDeclare14(request);
        paramDeclare15(request);
        paramDeclare16(request);
        paramDeclare17(request);
        paramDeclare18(request);
        paramDeclare19(request);
        paramDeclare20(request);
        paramDeclare21(request);
        paramDeclare22(request);
        paramDeclare23(request);
        paramDeclare24(request);
        paramDeclare25(request);
        paramDeclare26(request);
        paramDeclare27(request);
        paramDeclare28(request);
        paramDeclare29(request);
        paramDeclare30(request);
        paramDeclare31(request);
        paramDeclare32(request);
        paramDeclare33(request);
        paramDeclare34(request);
        paramDeclare35(request);
        paramDeclare36(request);
        paramDeclare37(request);
        paramDeclare38(request);
        paramDeclare39(request);
        paramDeclare40(request);
        paramDeclare41(request);
        paramDeclare42(request);
        paramDeclare43(request);
        paramDeclare44(request);
        paramDeclare45(request);
        paramDeclare46(request);
        paramDeclare47(request);
        paramDeclare48(request);
        paramDeclare49(request);
        paramDeclare50(request);
        paramDeclare51(request);
        paramDeclare52(request);
        paramDeclare53(request);
        paramDeclare54(request);
        paramDeclare55(request);
        paramDeclare56(request);
        paramDeclare57(request);
        paramDeclare58(request);
        paramDeclare59(request);
        paramDeclare60(request);
        paramDeclare61(request);
        paramDeclare62(request);
        paramDeclare63(request);
        paramDeclare64(request);
        paramAddFileList(request);
        paramRemark1(request);
        paramRemark2(request);
        paramRemark3(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(PracticeDeclare bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("type")) { setType(bean.getType()); }
        if (!ncl.contains("declareId")) { setDeclareId(bean.getDeclareId()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("xyHonour")) { setXyHonour(bean.getXyHonour()); }
        if (!ncl.contains("submitflag")) { setSubmitflag(bean.getSubmitflag()); }
        if (!ncl.contains("xyCheckFlag")) { setXyCheckFlag(bean.getXyCheckFlag()); }
        if (!ncl.contains("twCheckFlag")) { setTwCheckFlag(bean.getTwCheckFlag()); }
        if (!ncl.contains("addaccount")) { setAddaccount(bean.getAddaccount()); }
        if (!ncl.contains("addtime")) { setAddtime(bean.getAddtime()); }
        if (!ncl.contains("declare1")) { setDeclare1(bean.getDeclare1()); }
        if (!ncl.contains("declare2")) { setDeclare2(bean.getDeclare2()); }
        if (!ncl.contains("declare5")) { setDeclare5(bean.getDeclare5()); }
        if (!ncl.contains("declare8")) { setDeclare8(bean.getDeclare8()); }
        if (!ncl.contains("declare6")) { setDeclare6(bean.getDeclare6()); }
        if (!ncl.contains("declare7")) { setDeclare7(bean.getDeclare7()); }
        if (!ncl.contains("declare9")) { setDeclare9(bean.getDeclare9()); }
        if (!ncl.contains("declare10")) { setDeclare10(bean.getDeclare10()); }
        if (!ncl.contains("declare11")) { setDeclare11(bean.getDeclare11()); }
        if (!ncl.contains("declare12")) { setDeclare12(bean.getDeclare12()); }
        if (!ncl.contains("declare13")) { setDeclare13(bean.getDeclare13()); }
        if (!ncl.contains("declare14")) { setDeclare14(bean.getDeclare14()); }
        if (!ncl.contains("declare15")) { setDeclare15(bean.getDeclare15()); }
        if (!ncl.contains("declare16")) { setDeclare16(bean.getDeclare16()); }
        if (!ncl.contains("declare17")) { setDeclare17(bean.getDeclare17()); }
        if (!ncl.contains("declare18")) { setDeclare18(bean.getDeclare18()); }
        if (!ncl.contains("declare19")) { setDeclare19(bean.getDeclare19()); }
        if (!ncl.contains("declare20")) { setDeclare20(bean.getDeclare20()); }
        if (!ncl.contains("declare21")) { setDeclare21(bean.getDeclare21()); }
        if (!ncl.contains("declare22")) { setDeclare22(bean.getDeclare22()); }
        if (!ncl.contains("declare23")) { setDeclare23(bean.getDeclare23()); }
        if (!ncl.contains("declare24")) { setDeclare24(bean.getDeclare24()); }
        if (!ncl.contains("declare25")) { setDeclare25(bean.getDeclare25()); }
        if (!ncl.contains("declare26")) { setDeclare26(bean.getDeclare26()); }
        if (!ncl.contains("declare27")) { setDeclare27(bean.getDeclare27()); }
        if (!ncl.contains("declare28")) { setDeclare28(bean.getDeclare28()); }
        if (!ncl.contains("declare29")) { setDeclare29(bean.getDeclare29()); }
        if (!ncl.contains("declare30")) { setDeclare30(bean.getDeclare30()); }
        if (!ncl.contains("declare31")) { setDeclare31(bean.getDeclare31()); }
        if (!ncl.contains("declare32")) { setDeclare32(bean.getDeclare32()); }
        if (!ncl.contains("declare33")) { setDeclare33(bean.getDeclare33()); }
        if (!ncl.contains("declare34")) { setDeclare34(bean.getDeclare34()); }
        if (!ncl.contains("declare35")) { setDeclare35(bean.getDeclare35()); }
        if (!ncl.contains("declare36")) { setDeclare36(bean.getDeclare36()); }
        if (!ncl.contains("declare37")) { setDeclare37(bean.getDeclare37()); }
        if (!ncl.contains("declare38")) { setDeclare38(bean.getDeclare38()); }
        if (!ncl.contains("declare39")) { setDeclare39(bean.getDeclare39()); }
        if (!ncl.contains("declare40")) { setDeclare40(bean.getDeclare40()); }
        if (!ncl.contains("declare41")) { setDeclare41(bean.getDeclare41()); }
        if (!ncl.contains("declare42")) { setDeclare42(bean.getDeclare42()); }
        if (!ncl.contains("declare43")) { setDeclare43(bean.getDeclare43()); }
        if (!ncl.contains("declare44")) { setDeclare44(bean.getDeclare44()); }
        if (!ncl.contains("declare45")) { setDeclare45(bean.getDeclare45()); }
        if (!ncl.contains("declare46")) { setDeclare46(bean.getDeclare46()); }
        if (!ncl.contains("declare47")) { setDeclare47(bean.getDeclare47()); }
        if (!ncl.contains("declare48")) { setDeclare48(bean.getDeclare48()); }
        if (!ncl.contains("declare49")) { setDeclare49(bean.getDeclare49()); }
        if (!ncl.contains("declare50")) { setDeclare50(bean.getDeclare50()); }
        if (!ncl.contains("declare51")) { setDeclare51(bean.getDeclare51()); }
        if (!ncl.contains("declare52")) { setDeclare52(bean.getDeclare52()); }
        if (!ncl.contains("declare53")) { setDeclare53(bean.getDeclare53()); }
        if (!ncl.contains("declare54")) { setDeclare54(bean.getDeclare54()); }
        if (!ncl.contains("declare55")) { setDeclare55(bean.getDeclare55()); }
        if (!ncl.contains("declare56")) { setDeclare56(bean.getDeclare56()); }
        if (!ncl.contains("declare57")) { setDeclare57(bean.getDeclare57()); }
        if (!ncl.contains("declare58")) { setDeclare58(bean.getDeclare58()); }
        if (!ncl.contains("declare59")) { setDeclare59(bean.getDeclare59()); }
        if (!ncl.contains("declare60")) { setDeclare60(bean.getDeclare60()); }
        if (!ncl.contains("declare61")) { setDeclare61(bean.getDeclare61()); }
        if (!ncl.contains("declare62")) { setDeclare62(bean.getDeclare62()); }
        if (!ncl.contains("declare63")) { setDeclare63(bean.getDeclare63()); }
        if (!ncl.contains("declare64")) { setDeclare64(bean.getDeclare64()); }
        if (!ncl.contains("addFileList")) { setAddFileList(bean.getAddFileList()); }
        if (!ncl.contains("remark1")) { setRemark1(bean.getRemark1()); }
        if (!ncl.contains("remark2")) { setRemark2(bean.getRemark2()); }
        if (!ncl.contains("remark3")) { setRemark3(bean.getRemark3()); }
    }
    public PracticeDeclare getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        PracticeDeclare[] rslt= queryByCondition(cdt);
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
     * @return PracticeDeclare类的实例列表。
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
                PracticeDeclare ve = new PracticeDeclare(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignType(rs.getInt(2));
                ve.assignDeclareId(rs.getInt(3));
                ve.assignAcademy(fromDbCh(rs.getString(4)));
                ve.assignXyHonour(fromDbCh(rs.getString(5)));
                ve.assignSubmitflag(rs.getInt(6));
                ve.assignXyCheckFlag(rs.getInt(7));
                ve.assignTwCheckFlag(rs.getInt(8));
                ve.assignAddaccount(fromDbCh(rs.getString(9)));
                ve.assignAddtime(fromDbCh(rs.getString(10)));
                ve.assignDeclare1(fromDbCh(rs.getString(11)));
                ve.assignDeclare2(fromDbCh(rs.getString(12)));
                ve.assignDeclare5(fromDbCh(rs.getString(13)));
                ve.assignDeclare8(fromDbCh(rs.getString(14)));
                ve.assignDeclare6(fromDbCh(rs.getString(15)));
                ve.assignDeclare7(fromDbCh(rs.getString(16)));
                ve.assignDeclare9(fromDbCh(rs.getString(17)));
                ve.assignDeclare10(fromDbCh(rs.getString(18)));
                ve.assignDeclare11(fromDbCh(rs.getString(19)));
                ve.assignDeclare12(fromDbCh(rs.getString(20)));
                ve.assignDeclare13(fromDbCh(rs.getString(21)));
                ve.assignDeclare14(fromDbCh(rs.getString(22)));
                ve.assignDeclare15(fromDbCh(rs.getString(23)));
                ve.assignDeclare16(fromDbCh(rs.getString(24)));
                ve.assignDeclare17(fromDbCh(rs.getString(25)));
                ve.assignDeclare18(fromDbCh(rs.getString(26)));
                ve.assignDeclare19(fromDbCh(rs.getString(27)));
                ve.assignDeclare20(fromDbCh(rs.getString(28)));
                ve.assignDeclare21(fromDbCh(rs.getString(29)));
                ve.assignDeclare22(fromDbCh(rs.getString(30)));
                ve.assignDeclare23(fromDbCh(rs.getString(31)));
                ve.assignDeclare24(fromDbCh(rs.getString(32)));
                ve.assignDeclare25(fromDbCh(rs.getString(33)));
                ve.assignDeclare26(fromDbCh(rs.getString(34)));
                ve.assignDeclare27(fromDbCh(rs.getString(35)));
                ve.assignDeclare28(fromDbCh(rs.getString(36)));
                ve.assignDeclare29(fromDbCh(rs.getString(37)));
                ve.assignDeclare30(fromDbCh(rs.getString(38)));
                ve.assignDeclare31(fromDbCh(rs.getString(39)));
                ve.assignDeclare32(fromDbCh(rs.getString(40)));
                ve.assignDeclare33(fromDbCh(rs.getString(41)));
                ve.assignDeclare34(fromDbCh(rs.getString(42)));
                ve.assignDeclare35(fromDbCh(rs.getString(43)));
                ve.assignDeclare36(fromDbCh(rs.getString(44)));
                ve.assignDeclare37(fromDbCh(rs.getString(45)));
                ve.assignDeclare38(fromDbCh(rs.getString(46)));
                ve.assignDeclare39(fromDbCh(rs.getString(47)));
                ve.assignDeclare40(fromDbCh(rs.getString(48)));
                ve.assignDeclare41(fromDbCh(rs.getString(49)));
                ve.assignDeclare42(fromDbCh(rs.getString(50)));
                ve.assignDeclare43(fromDbCh(rs.getString(51)));
                ve.assignDeclare44(fromDbCh(rs.getString(52)));
                ve.assignDeclare45(fromDbCh(rs.getString(53)));
                ve.assignDeclare46(fromDbCh(rs.getString(54)));
                ve.assignDeclare47(fromDbCh(rs.getString(55)));
                ve.assignDeclare48(fromDbCh(rs.getString(56)));
                ve.assignDeclare49(fromDbCh(rs.getString(57)));
                ve.assignDeclare50(fromDbCh(rs.getString(58)));
                ve.assignDeclare51(fromDbCh(rs.getString(59)));
                ve.assignDeclare52(fromDbCh(rs.getString(60)));
                ve.assignDeclare53(fromDbCh(rs.getString(61)));
                ve.assignDeclare54(fromDbCh(rs.getString(62)));
                ve.assignDeclare55(fromDbCh(rs.getString(63)));
                ve.assignDeclare56(fromDbCh(rs.getString(64)));
                ve.assignDeclare57(fromDbCh(rs.getString(65)));
                ve.assignDeclare58(fromDbCh(rs.getString(66)));
                ve.assignDeclare59(fromDbCh(rs.getString(67)));
                ve.assignDeclare60(fromDbCh(rs.getString(68)));
                ve.assignDeclare61(fromDbCh(rs.getString(69)));
                ve.assignDeclare62(fromDbCh(rs.getString(70)));
                ve.assignDeclare63(fromDbCh(rs.getString(71)));
                ve.assignDeclare64(fromDbCh(rs.getString(72)));
                ve.assignAddFileList(fromDbCh(rs.getString(73)));
                ve.assignRemark1(fromDbCh(rs.getString(74)));
                ve.assignRemark2(fromDbCh(rs.getString(75)));
                ve.assignRemark3(fromDbCh(rs.getString(76)));
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
    public PracticeDeclare[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (PracticeDeclare[])vrs.toArray(new PracticeDeclare[vrs.size()]);
    }
    public PracticeDeclare[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (PracticeDeclare[])vrs.toArray(new PracticeDeclare[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (type,declareid,academy,xyhonour,submitflag,xycheckflag,twcheckflag,addaccount,addtime,declare1,declare2,declare5,declare8,declare6,declare7,declare9,declare10,declare11,declare12,declare13,declare14,declare15,declare16,declare17,declare18,declare19,declare20,declare21,declare22,declare23,declare24,declare25,declare26,declare27,declare28,declare29,declare30,declare31,declare32,declare33,declare34,declare35,declare36,declare37,declare38,declare39,declare40,declare41,declare42,declare43,declare44,declare45,declare46,declare47,declare48,declare49,declare50,declare51,declare52,declare53,declare54,declare55,declare56,declare57,declare58,declare59,declare60,declare61,declare62,declare63,declare64,addfilelist,remark1,remark2,remark3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, type);
            pstmt.setInt(2, declareId);
            pstmt.setString(3, toDbCh(academy));
            pstmt.setString(4, toDbCh(xyHonour));
            pstmt.setInt(5, submitflag);
            pstmt.setInt(6, xyCheckFlag);
            pstmt.setInt(7, twCheckFlag);
            pstmt.setString(8, toDbCh(addaccount));
            pstmt.setString(9, toDbCh(addtime));
            pstmt.setString(10, toDbCh(declare1));
            pstmt.setString(11, toDbCh(declare2));
            pstmt.setString(12, toDbCh(declare5));
            pstmt.setString(13, toDbCh(declare8));
            pstmt.setString(14, toDbCh(declare6));
            pstmt.setString(15, toDbCh(declare7));
            pstmt.setString(16, toDbCh(declare9));
            pstmt.setString(17, toDbCh(declare10));
            pstmt.setString(18, toDbCh(declare11));
            pstmt.setString(19, toDbCh(declare12));
            pstmt.setString(20, toDbCh(declare13));
            pstmt.setString(21, toDbCh(declare14));
            pstmt.setString(22, toDbCh(declare15));
            pstmt.setString(23, toDbCh(declare16));
            pstmt.setString(24, toDbCh(declare17));
            pstmt.setString(25, toDbCh(declare18));
            pstmt.setString(26, toDbCh(declare19));
            pstmt.setString(27, toDbCh(declare20));
            pstmt.setString(28, toDbCh(declare21));
            pstmt.setString(29, toDbCh(declare22));
            pstmt.setString(30, toDbCh(declare23));
            pstmt.setString(31, toDbCh(declare24));
            pstmt.setString(32, toDbCh(declare25));
            pstmt.setString(33, toDbCh(declare26));
            pstmt.setString(34, toDbCh(declare27));
            pstmt.setString(35, toDbCh(declare28));
            pstmt.setString(36, toDbCh(declare29));
            pstmt.setString(37, toDbCh(declare30));
            pstmt.setString(38, toDbCh(declare31));
            pstmt.setString(39, toDbCh(declare32));
            pstmt.setString(40, toDbCh(declare33));
            pstmt.setString(41, toDbCh(declare34));
            pstmt.setString(42, toDbCh(declare35));
            pstmt.setString(43, toDbCh(declare36));
            pstmt.setString(44, toDbCh(declare37));
            pstmt.setString(45, toDbCh(declare38));
            pstmt.setString(46, toDbCh(declare39));
            pstmt.setString(47, toDbCh(declare40));
            pstmt.setString(48, toDbCh(declare41));
            pstmt.setString(49, toDbCh(declare42));
            pstmt.setString(50, toDbCh(declare43));
            pstmt.setString(51, toDbCh(declare44));
            pstmt.setString(52, toDbCh(declare45));
            pstmt.setString(53, toDbCh(declare46));
            pstmt.setString(54, toDbCh(declare47));
            pstmt.setString(55, toDbCh(declare48));
            pstmt.setString(56, toDbCh(declare49));
            pstmt.setString(57, toDbCh(declare50));
            pstmt.setString(58, toDbCh(declare51));
            pstmt.setString(59, toDbCh(declare52));
            pstmt.setString(60, toDbCh(declare53));
            pstmt.setString(61, toDbCh(declare54));
            pstmt.setString(62, toDbCh(declare55));
            pstmt.setString(63, toDbCh(declare56));
            pstmt.setString(64, toDbCh(declare57));
            pstmt.setString(65, toDbCh(declare58));
            pstmt.setString(66, toDbCh(declare59));
            pstmt.setString(67, toDbCh(declare60));
            pstmt.setString(68, toDbCh(declare61));
            pstmt.setString(69, toDbCh(declare62));
            pstmt.setString(70, toDbCh(declare63));
            pstmt.setString(71, toDbCh(declare64));
            pstmt.setString(72, toDbCh(addFileList));
            pstmt.setString(73, toDbCh(remark1));
            pstmt.setString(74, toDbCh(remark2));
            pstmt.setString(75, toDbCh(remark3));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,type,declareid,academy,xyhonour,submitflag,xycheckflag,twcheckflag,addaccount,addtime,declare1,declare2,declare5,declare8,declare6,declare7,declare9,declare10,declare11,declare12,declare13,declare14,declare15,declare16,declare17,declare18,declare19,declare20,declare21,declare22,declare23,declare24,declare25,declare26,declare27,declare28,declare29,declare30,declare31,declare32,declare33,declare34,declare35,declare36,declare37,declare38,declare39,declare40,declare41,declare42,declare43,declare44,declare45,declare46,declare47,declare48,declare49,declare50,declare51,declare52,declare53,declare54,declare55,declare56,declare57,declare58,declare59,declare60,declare61,declare62,declare63,declare64,addfilelist,remark1,remark2,remark3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, type);
            pstmt.setInt(3, declareId);
            pstmt.setString(4, toDbCh(academy));
            pstmt.setString(5, toDbCh(xyHonour));
            pstmt.setInt(6, submitflag);
            pstmt.setInt(7, xyCheckFlag);
            pstmt.setInt(8, twCheckFlag);
            pstmt.setString(9, toDbCh(addaccount));
            pstmt.setString(10, toDbCh(addtime));
            pstmt.setString(11, toDbCh(declare1));
            pstmt.setString(12, toDbCh(declare2));
            pstmt.setString(13, toDbCh(declare5));
            pstmt.setString(14, toDbCh(declare8));
            pstmt.setString(15, toDbCh(declare6));
            pstmt.setString(16, toDbCh(declare7));
            pstmt.setString(17, toDbCh(declare9));
            pstmt.setString(18, toDbCh(declare10));
            pstmt.setString(19, toDbCh(declare11));
            pstmt.setString(20, toDbCh(declare12));
            pstmt.setString(21, toDbCh(declare13));
            pstmt.setString(22, toDbCh(declare14));
            pstmt.setString(23, toDbCh(declare15));
            pstmt.setString(24, toDbCh(declare16));
            pstmt.setString(25, toDbCh(declare17));
            pstmt.setString(26, toDbCh(declare18));
            pstmt.setString(27, toDbCh(declare19));
            pstmt.setString(28, toDbCh(declare20));
            pstmt.setString(29, toDbCh(declare21));
            pstmt.setString(30, toDbCh(declare22));
            pstmt.setString(31, toDbCh(declare23));
            pstmt.setString(32, toDbCh(declare24));
            pstmt.setString(33, toDbCh(declare25));
            pstmt.setString(34, toDbCh(declare26));
            pstmt.setString(35, toDbCh(declare27));
            pstmt.setString(36, toDbCh(declare28));
            pstmt.setString(37, toDbCh(declare29));
            pstmt.setString(38, toDbCh(declare30));
            pstmt.setString(39, toDbCh(declare31));
            pstmt.setString(40, toDbCh(declare32));
            pstmt.setString(41, toDbCh(declare33));
            pstmt.setString(42, toDbCh(declare34));
            pstmt.setString(43, toDbCh(declare35));
            pstmt.setString(44, toDbCh(declare36));
            pstmt.setString(45, toDbCh(declare37));
            pstmt.setString(46, toDbCh(declare38));
            pstmt.setString(47, toDbCh(declare39));
            pstmt.setString(48, toDbCh(declare40));
            pstmt.setString(49, toDbCh(declare41));
            pstmt.setString(50, toDbCh(declare42));
            pstmt.setString(51, toDbCh(declare43));
            pstmt.setString(52, toDbCh(declare44));
            pstmt.setString(53, toDbCh(declare45));
            pstmt.setString(54, toDbCh(declare46));
            pstmt.setString(55, toDbCh(declare47));
            pstmt.setString(56, toDbCh(declare48));
            pstmt.setString(57, toDbCh(declare49));
            pstmt.setString(58, toDbCh(declare50));
            pstmt.setString(59, toDbCh(declare51));
            pstmt.setString(60, toDbCh(declare52));
            pstmt.setString(61, toDbCh(declare53));
            pstmt.setString(62, toDbCh(declare54));
            pstmt.setString(63, toDbCh(declare55));
            pstmt.setString(64, toDbCh(declare56));
            pstmt.setString(65, toDbCh(declare57));
            pstmt.setString(66, toDbCh(declare58));
            pstmt.setString(67, toDbCh(declare59));
            pstmt.setString(68, toDbCh(declare60));
            pstmt.setString(69, toDbCh(declare61));
            pstmt.setString(70, toDbCh(declare62));
            pstmt.setString(71, toDbCh(declare63));
            pstmt.setString(72, toDbCh(declare64));
            pstmt.setString(73, toDbCh(addFileList));
            pstmt.setString(74, toDbCh(remark1));
            pstmt.setString(75, toDbCh(remark2));
            pstmt.setString(76, toDbCh(remark3));
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
            PracticeDeclare item = (PracticeDeclare)it.next();
            PracticeDeclare v = new PracticeDeclare(dbname);
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
                if (modifiedFields.contains("Type")) { pstmt.setInt(pi ++, type); }
                if (modifiedFields.contains("DeclareId")) { pstmt.setInt(pi ++, declareId); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("XyHonour")) { pstmt.setString(pi ++, toDbCh(xyHonour)); }
                if (modifiedFields.contains("Submitflag")) { pstmt.setInt(pi ++, submitflag); }
                if (modifiedFields.contains("XyCheckFlag")) { pstmt.setInt(pi ++, xyCheckFlag); }
                if (modifiedFields.contains("TwCheckFlag")) { pstmt.setInt(pi ++, twCheckFlag); }
                if (modifiedFields.contains("Addaccount")) { pstmt.setString(pi ++, toDbCh(addaccount)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setString(pi ++, toDbCh(addtime)); }
                if (modifiedFields.contains("Declare1")) { pstmt.setString(pi ++, toDbCh(declare1)); }
                if (modifiedFields.contains("Declare2")) { pstmt.setString(pi ++, toDbCh(declare2)); }
                if (modifiedFields.contains("Declare5")) { pstmt.setString(pi ++, toDbCh(declare5)); }
                if (modifiedFields.contains("Declare8")) { pstmt.setString(pi ++, toDbCh(declare8)); }
                if (modifiedFields.contains("Declare6")) { pstmt.setString(pi ++, toDbCh(declare6)); }
                if (modifiedFields.contains("Declare7")) { pstmt.setString(pi ++, toDbCh(declare7)); }
                if (modifiedFields.contains("Declare9")) { pstmt.setString(pi ++, toDbCh(declare9)); }
                if (modifiedFields.contains("Declare10")) { pstmt.setString(pi ++, toDbCh(declare10)); }
                if (modifiedFields.contains("Declare11")) { pstmt.setString(pi ++, toDbCh(declare11)); }
                if (modifiedFields.contains("Declare12")) { pstmt.setString(pi ++, toDbCh(declare12)); }
                if (modifiedFields.contains("Declare13")) { pstmt.setString(pi ++, toDbCh(declare13)); }
                if (modifiedFields.contains("Declare14")) { pstmt.setString(pi ++, toDbCh(declare14)); }
                if (modifiedFields.contains("Declare15")) { pstmt.setString(pi ++, toDbCh(declare15)); }
                if (modifiedFields.contains("Declare16")) { pstmt.setString(pi ++, toDbCh(declare16)); }
                if (modifiedFields.contains("Declare17")) { pstmt.setString(pi ++, toDbCh(declare17)); }
                if (modifiedFields.contains("Declare18")) { pstmt.setString(pi ++, toDbCh(declare18)); }
                if (modifiedFields.contains("Declare19")) { pstmt.setString(pi ++, toDbCh(declare19)); }
                if (modifiedFields.contains("Declare20")) { pstmt.setString(pi ++, toDbCh(declare20)); }
                if (modifiedFields.contains("Declare21")) { pstmt.setString(pi ++, toDbCh(declare21)); }
                if (modifiedFields.contains("Declare22")) { pstmt.setString(pi ++, toDbCh(declare22)); }
                if (modifiedFields.contains("Declare23")) { pstmt.setString(pi ++, toDbCh(declare23)); }
                if (modifiedFields.contains("Declare24")) { pstmt.setString(pi ++, toDbCh(declare24)); }
                if (modifiedFields.contains("Declare25")) { pstmt.setString(pi ++, toDbCh(declare25)); }
                if (modifiedFields.contains("Declare26")) { pstmt.setString(pi ++, toDbCh(declare26)); }
                if (modifiedFields.contains("Declare27")) { pstmt.setString(pi ++, toDbCh(declare27)); }
                if (modifiedFields.contains("Declare28")) { pstmt.setString(pi ++, toDbCh(declare28)); }
                if (modifiedFields.contains("Declare29")) { pstmt.setString(pi ++, toDbCh(declare29)); }
                if (modifiedFields.contains("Declare30")) { pstmt.setString(pi ++, toDbCh(declare30)); }
                if (modifiedFields.contains("Declare31")) { pstmt.setString(pi ++, toDbCh(declare31)); }
                if (modifiedFields.contains("Declare32")) { pstmt.setString(pi ++, toDbCh(declare32)); }
                if (modifiedFields.contains("Declare33")) { pstmt.setString(pi ++, toDbCh(declare33)); }
                if (modifiedFields.contains("Declare34")) { pstmt.setString(pi ++, toDbCh(declare34)); }
                if (modifiedFields.contains("Declare35")) { pstmt.setString(pi ++, toDbCh(declare35)); }
                if (modifiedFields.contains("Declare36")) { pstmt.setString(pi ++, toDbCh(declare36)); }
                if (modifiedFields.contains("Declare37")) { pstmt.setString(pi ++, toDbCh(declare37)); }
                if (modifiedFields.contains("Declare38")) { pstmt.setString(pi ++, toDbCh(declare38)); }
                if (modifiedFields.contains("Declare39")) { pstmt.setString(pi ++, toDbCh(declare39)); }
                if (modifiedFields.contains("Declare40")) { pstmt.setString(pi ++, toDbCh(declare40)); }
                if (modifiedFields.contains("Declare41")) { pstmt.setString(pi ++, toDbCh(declare41)); }
                if (modifiedFields.contains("Declare42")) { pstmt.setString(pi ++, toDbCh(declare42)); }
                if (modifiedFields.contains("Declare43")) { pstmt.setString(pi ++, toDbCh(declare43)); }
                if (modifiedFields.contains("Declare44")) { pstmt.setString(pi ++, toDbCh(declare44)); }
                if (modifiedFields.contains("Declare45")) { pstmt.setString(pi ++, toDbCh(declare45)); }
                if (modifiedFields.contains("Declare46")) { pstmt.setString(pi ++, toDbCh(declare46)); }
                if (modifiedFields.contains("Declare47")) { pstmt.setString(pi ++, toDbCh(declare47)); }
                if (modifiedFields.contains("Declare48")) { pstmt.setString(pi ++, toDbCh(declare48)); }
                if (modifiedFields.contains("Declare49")) { pstmt.setString(pi ++, toDbCh(declare49)); }
                if (modifiedFields.contains("Declare50")) { pstmt.setString(pi ++, toDbCh(declare50)); }
                if (modifiedFields.contains("Declare51")) { pstmt.setString(pi ++, toDbCh(declare51)); }
                if (modifiedFields.contains("Declare52")) { pstmt.setString(pi ++, toDbCh(declare52)); }
                if (modifiedFields.contains("Declare53")) { pstmt.setString(pi ++, toDbCh(declare53)); }
                if (modifiedFields.contains("Declare54")) { pstmt.setString(pi ++, toDbCh(declare54)); }
                if (modifiedFields.contains("Declare55")) { pstmt.setString(pi ++, toDbCh(declare55)); }
                if (modifiedFields.contains("Declare56")) { pstmt.setString(pi ++, toDbCh(declare56)); }
                if (modifiedFields.contains("Declare57")) { pstmt.setString(pi ++, toDbCh(declare57)); }
                if (modifiedFields.contains("Declare58")) { pstmt.setString(pi ++, toDbCh(declare58)); }
                if (modifiedFields.contains("Declare59")) { pstmt.setString(pi ++, toDbCh(declare59)); }
                if (modifiedFields.contains("Declare60")) { pstmt.setString(pi ++, toDbCh(declare60)); }
                if (modifiedFields.contains("Declare61")) { pstmt.setString(pi ++, toDbCh(declare61)); }
                if (modifiedFields.contains("Declare62")) { pstmt.setString(pi ++, toDbCh(declare62)); }
                if (modifiedFields.contains("Declare63")) { pstmt.setString(pi ++, toDbCh(declare63)); }
                if (modifiedFields.contains("Declare64")) { pstmt.setString(pi ++, toDbCh(declare64)); }
                if (modifiedFields.contains("AddFileList")) { pstmt.setString(pi ++, toDbCh(addFileList)); }
                if (modifiedFields.contains("Remark1")) { pstmt.setString(pi ++, toDbCh(remark1)); }
                if (modifiedFields.contains("Remark2")) { pstmt.setString(pi ++, toDbCh(remark2)); }
                if (modifiedFields.contains("Remark3")) { pstmt.setString(pi ++, toDbCh(remark3)); }
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
                if (modifiedFields.contains("Type")) { pstmt.setInt(pi ++, type); }
                if (modifiedFields.contains("DeclareId")) { pstmt.setInt(pi ++, declareId); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("XyHonour")) { pstmt.setString(pi ++, toDbCh(xyHonour)); }
                if (modifiedFields.contains("Submitflag")) { pstmt.setInt(pi ++, submitflag); }
                if (modifiedFields.contains("XyCheckFlag")) { pstmt.setInt(pi ++, xyCheckFlag); }
                if (modifiedFields.contains("TwCheckFlag")) { pstmt.setInt(pi ++, twCheckFlag); }
                if (modifiedFields.contains("Addaccount")) { pstmt.setString(pi ++, toDbCh(addaccount)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setString(pi ++, toDbCh(addtime)); }
                if (modifiedFields.contains("Declare1")) { pstmt.setString(pi ++, toDbCh(declare1)); }
                if (modifiedFields.contains("Declare2")) { pstmt.setString(pi ++, toDbCh(declare2)); }
                if (modifiedFields.contains("Declare5")) { pstmt.setString(pi ++, toDbCh(declare5)); }
                if (modifiedFields.contains("Declare8")) { pstmt.setString(pi ++, toDbCh(declare8)); }
                if (modifiedFields.contains("Declare6")) { pstmt.setString(pi ++, toDbCh(declare6)); }
                if (modifiedFields.contains("Declare7")) { pstmt.setString(pi ++, toDbCh(declare7)); }
                if (modifiedFields.contains("Declare9")) { pstmt.setString(pi ++, toDbCh(declare9)); }
                if (modifiedFields.contains("Declare10")) { pstmt.setString(pi ++, toDbCh(declare10)); }
                if (modifiedFields.contains("Declare11")) { pstmt.setString(pi ++, toDbCh(declare11)); }
                if (modifiedFields.contains("Declare12")) { pstmt.setString(pi ++, toDbCh(declare12)); }
                if (modifiedFields.contains("Declare13")) { pstmt.setString(pi ++, toDbCh(declare13)); }
                if (modifiedFields.contains("Declare14")) { pstmt.setString(pi ++, toDbCh(declare14)); }
                if (modifiedFields.contains("Declare15")) { pstmt.setString(pi ++, toDbCh(declare15)); }
                if (modifiedFields.contains("Declare16")) { pstmt.setString(pi ++, toDbCh(declare16)); }
                if (modifiedFields.contains("Declare17")) { pstmt.setString(pi ++, toDbCh(declare17)); }
                if (modifiedFields.contains("Declare18")) { pstmt.setString(pi ++, toDbCh(declare18)); }
                if (modifiedFields.contains("Declare19")) { pstmt.setString(pi ++, toDbCh(declare19)); }
                if (modifiedFields.contains("Declare20")) { pstmt.setString(pi ++, toDbCh(declare20)); }
                if (modifiedFields.contains("Declare21")) { pstmt.setString(pi ++, toDbCh(declare21)); }
                if (modifiedFields.contains("Declare22")) { pstmt.setString(pi ++, toDbCh(declare22)); }
                if (modifiedFields.contains("Declare23")) { pstmt.setString(pi ++, toDbCh(declare23)); }
                if (modifiedFields.contains("Declare24")) { pstmt.setString(pi ++, toDbCh(declare24)); }
                if (modifiedFields.contains("Declare25")) { pstmt.setString(pi ++, toDbCh(declare25)); }
                if (modifiedFields.contains("Declare26")) { pstmt.setString(pi ++, toDbCh(declare26)); }
                if (modifiedFields.contains("Declare27")) { pstmt.setString(pi ++, toDbCh(declare27)); }
                if (modifiedFields.contains("Declare28")) { pstmt.setString(pi ++, toDbCh(declare28)); }
                if (modifiedFields.contains("Declare29")) { pstmt.setString(pi ++, toDbCh(declare29)); }
                if (modifiedFields.contains("Declare30")) { pstmt.setString(pi ++, toDbCh(declare30)); }
                if (modifiedFields.contains("Declare31")) { pstmt.setString(pi ++, toDbCh(declare31)); }
                if (modifiedFields.contains("Declare32")) { pstmt.setString(pi ++, toDbCh(declare32)); }
                if (modifiedFields.contains("Declare33")) { pstmt.setString(pi ++, toDbCh(declare33)); }
                if (modifiedFields.contains("Declare34")) { pstmt.setString(pi ++, toDbCh(declare34)); }
                if (modifiedFields.contains("Declare35")) { pstmt.setString(pi ++, toDbCh(declare35)); }
                if (modifiedFields.contains("Declare36")) { pstmt.setString(pi ++, toDbCh(declare36)); }
                if (modifiedFields.contains("Declare37")) { pstmt.setString(pi ++, toDbCh(declare37)); }
                if (modifiedFields.contains("Declare38")) { pstmt.setString(pi ++, toDbCh(declare38)); }
                if (modifiedFields.contains("Declare39")) { pstmt.setString(pi ++, toDbCh(declare39)); }
                if (modifiedFields.contains("Declare40")) { pstmt.setString(pi ++, toDbCh(declare40)); }
                if (modifiedFields.contains("Declare41")) { pstmt.setString(pi ++, toDbCh(declare41)); }
                if (modifiedFields.contains("Declare42")) { pstmt.setString(pi ++, toDbCh(declare42)); }
                if (modifiedFields.contains("Declare43")) { pstmt.setString(pi ++, toDbCh(declare43)); }
                if (modifiedFields.contains("Declare44")) { pstmt.setString(pi ++, toDbCh(declare44)); }
                if (modifiedFields.contains("Declare45")) { pstmt.setString(pi ++, toDbCh(declare45)); }
                if (modifiedFields.contains("Declare46")) { pstmt.setString(pi ++, toDbCh(declare46)); }
                if (modifiedFields.contains("Declare47")) { pstmt.setString(pi ++, toDbCh(declare47)); }
                if (modifiedFields.contains("Declare48")) { pstmt.setString(pi ++, toDbCh(declare48)); }
                if (modifiedFields.contains("Declare49")) { pstmt.setString(pi ++, toDbCh(declare49)); }
                if (modifiedFields.contains("Declare50")) { pstmt.setString(pi ++, toDbCh(declare50)); }
                if (modifiedFields.contains("Declare51")) { pstmt.setString(pi ++, toDbCh(declare51)); }
                if (modifiedFields.contains("Declare52")) { pstmt.setString(pi ++, toDbCh(declare52)); }
                if (modifiedFields.contains("Declare53")) { pstmt.setString(pi ++, toDbCh(declare53)); }
                if (modifiedFields.contains("Declare54")) { pstmt.setString(pi ++, toDbCh(declare54)); }
                if (modifiedFields.contains("Declare55")) { pstmt.setString(pi ++, toDbCh(declare55)); }
                if (modifiedFields.contains("Declare56")) { pstmt.setString(pi ++, toDbCh(declare56)); }
                if (modifiedFields.contains("Declare57")) { pstmt.setString(pi ++, toDbCh(declare57)); }
                if (modifiedFields.contains("Declare58")) { pstmt.setString(pi ++, toDbCh(declare58)); }
                if (modifiedFields.contains("Declare59")) { pstmt.setString(pi ++, toDbCh(declare59)); }
                if (modifiedFields.contains("Declare60")) { pstmt.setString(pi ++, toDbCh(declare60)); }
                if (modifiedFields.contains("Declare61")) { pstmt.setString(pi ++, toDbCh(declare61)); }
                if (modifiedFields.contains("Declare62")) { pstmt.setString(pi ++, toDbCh(declare62)); }
                if (modifiedFields.contains("Declare63")) { pstmt.setString(pi ++, toDbCh(declare63)); }
                if (modifiedFields.contains("Declare64")) { pstmt.setString(pi ++, toDbCh(declare64)); }
                if (modifiedFields.contains("AddFileList")) { pstmt.setString(pi ++, toDbCh(addFileList)); }
                if (modifiedFields.contains("Remark1")) { pstmt.setString(pi ++, toDbCh(remark1)); }
                if (modifiedFields.contains("Remark2")) { pstmt.setString(pi ++, toDbCh(remark2)); }
                if (modifiedFields.contains("Remark3")) { pstmt.setString(pi ++, toDbCh(remark3)); }
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
        map.put("Type", getType() + "");
        map.put("DeclareId", getDeclareId() + "");
        map.put("Academy", getAcademy());
        map.put("XyHonour", getXyHonour());
        map.put("Submitflag", getSubmitflag() + "");
        map.put("XyCheckFlag", getXyCheckFlag() + "");
        map.put("TwCheckFlag", getTwCheckFlag() + "");
        map.put("Addaccount", getAddaccount());
        map.put("Addtime", getAddtime());
        map.put("Declare1", getDeclare1());
        map.put("Declare2", getDeclare2());
        map.put("Declare5", getDeclare5());
        map.put("Declare8", getDeclare8());
        map.put("Declare6", getDeclare6());
        map.put("Declare7", getDeclare7());
        map.put("Declare9", getDeclare9());
        map.put("Declare10", getDeclare10());
        map.put("Declare11", getDeclare11());
        map.put("Declare12", getDeclare12());
        map.put("Declare13", getDeclare13());
        map.put("Declare14", getDeclare14());
        map.put("Declare15", getDeclare15());
        map.put("Declare16", getDeclare16());
        map.put("Declare17", getDeclare17());
        map.put("Declare18", getDeclare18());
        map.put("Declare19", getDeclare19());
        map.put("Declare20", getDeclare20());
        map.put("Declare21", getDeclare21());
        map.put("Declare22", getDeclare22());
        map.put("Declare23", getDeclare23());
        map.put("Declare24", getDeclare24());
        map.put("Declare25", getDeclare25());
        map.put("Declare26", getDeclare26());
        map.put("Declare27", getDeclare27());
        map.put("Declare28", getDeclare28());
        map.put("Declare29", getDeclare29());
        map.put("Declare30", getDeclare30());
        map.put("Declare31", getDeclare31());
        map.put("Declare32", getDeclare32());
        map.put("Declare33", getDeclare33());
        map.put("Declare34", getDeclare34());
        map.put("Declare35", getDeclare35());
        map.put("Declare36", getDeclare36());
        map.put("Declare37", getDeclare37());
        map.put("Declare38", getDeclare38());
        map.put("Declare39", getDeclare39());
        map.put("Declare40", getDeclare40());
        map.put("Declare41", getDeclare41());
        map.put("Declare42", getDeclare42());
        map.put("Declare43", getDeclare43());
        map.put("Declare44", getDeclare44());
        map.put("Declare45", getDeclare45());
        map.put("Declare46", getDeclare46());
        map.put("Declare47", getDeclare47());
        map.put("Declare48", getDeclare48());
        map.put("Declare49", getDeclare49());
        map.put("Declare50", getDeclare50());
        map.put("Declare51", getDeclare51());
        map.put("Declare52", getDeclare52());
        map.put("Declare53", getDeclare53());
        map.put("Declare54", getDeclare54());
        map.put("Declare55", getDeclare55());
        map.put("Declare56", getDeclare56());
        map.put("Declare57", getDeclare57());
        map.put("Declare58", getDeclare58());
        map.put("Declare59", getDeclare59());
        map.put("Declare60", getDeclare60());
        map.put("Declare61", getDeclare61());
        map.put("Declare62", getDeclare62());
        map.put("Declare63", getDeclare63());
        map.put("Declare64", getDeclare64());
        map.put("AddFileList", getAddFileList());
        map.put("Remark1", getRemark1());
        map.put("Remark2", getRemark2());
        map.put("Remark3", getRemark3());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("Type:\"" + getType() + "\"");
        row.add("DeclareId:\"" + getDeclareId() + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("XyHonour:\"" + Tool.jsSpecialChars(getXyHonour()) + "\"");
        row.add("Submitflag:\"" + getSubmitflag() + "\"");
        row.add("XyCheckFlag:\"" + getXyCheckFlag() + "\"");
        row.add("TwCheckFlag:\"" + getTwCheckFlag() + "\"");
        row.add("Addaccount:\"" + Tool.jsSpecialChars(getAddaccount()) + "\"");
        row.add("Addtime:\"" + Tool.jsSpecialChars(getAddtime()) + "\"");
        row.add("Declare1:\"" + Tool.jsSpecialChars(getDeclare1()) + "\"");
        row.add("Declare2:\"" + Tool.jsSpecialChars(getDeclare2()) + "\"");
        row.add("Declare5:\"" + Tool.jsSpecialChars(getDeclare5()) + "\"");
        row.add("Declare8:\"" + Tool.jsSpecialChars(getDeclare8()) + "\"");
        row.add("Declare6:\"" + Tool.jsSpecialChars(getDeclare6()) + "\"");
        row.add("Declare7:\"" + Tool.jsSpecialChars(getDeclare7()) + "\"");
        row.add("Declare9:\"" + Tool.jsSpecialChars(getDeclare9()) + "\"");
        row.add("Declare10:\"" + Tool.jsSpecialChars(getDeclare10()) + "\"");
        row.add("Declare11:\"" + Tool.jsSpecialChars(getDeclare11()) + "\"");
        row.add("Declare12:\"" + Tool.jsSpecialChars(getDeclare12()) + "\"");
        row.add("Declare13:\"" + Tool.jsSpecialChars(getDeclare13()) + "\"");
        row.add("Declare14:\"" + Tool.jsSpecialChars(getDeclare14()) + "\"");
        row.add("Declare15:\"" + Tool.jsSpecialChars(getDeclare15()) + "\"");
        row.add("Declare16:\"" + Tool.jsSpecialChars(getDeclare16()) + "\"");
        row.add("Declare17:\"" + Tool.jsSpecialChars(getDeclare17()) + "\"");
        row.add("Declare18:\"" + Tool.jsSpecialChars(getDeclare18()) + "\"");
        row.add("Declare19:\"" + Tool.jsSpecialChars(getDeclare19()) + "\"");
        row.add("Declare20:\"" + Tool.jsSpecialChars(getDeclare20()) + "\"");
        row.add("Declare21:\"" + Tool.jsSpecialChars(getDeclare21()) + "\"");
        row.add("Declare22:\"" + Tool.jsSpecialChars(getDeclare22()) + "\"");
        row.add("Declare23:\"" + Tool.jsSpecialChars(getDeclare23()) + "\"");
        row.add("Declare24:\"" + Tool.jsSpecialChars(getDeclare24()) + "\"");
        row.add("Declare25:\"" + Tool.jsSpecialChars(getDeclare25()) + "\"");
        row.add("Declare26:\"" + Tool.jsSpecialChars(getDeclare26()) + "\"");
        row.add("Declare27:\"" + Tool.jsSpecialChars(getDeclare27()) + "\"");
        row.add("Declare28:\"" + Tool.jsSpecialChars(getDeclare28()) + "\"");
        row.add("Declare29:\"" + Tool.jsSpecialChars(getDeclare29()) + "\"");
        row.add("Declare30:\"" + Tool.jsSpecialChars(getDeclare30()) + "\"");
        row.add("Declare31:\"" + Tool.jsSpecialChars(getDeclare31()) + "\"");
        row.add("Declare32:\"" + Tool.jsSpecialChars(getDeclare32()) + "\"");
        row.add("Declare33:\"" + Tool.jsSpecialChars(getDeclare33()) + "\"");
        row.add("Declare34:\"" + Tool.jsSpecialChars(getDeclare34()) + "\"");
        row.add("Declare35:\"" + Tool.jsSpecialChars(getDeclare35()) + "\"");
        row.add("Declare36:\"" + Tool.jsSpecialChars(getDeclare36()) + "\"");
        row.add("Declare37:\"" + Tool.jsSpecialChars(getDeclare37()) + "\"");
        row.add("Declare38:\"" + Tool.jsSpecialChars(getDeclare38()) + "\"");
        row.add("Declare39:\"" + Tool.jsSpecialChars(getDeclare39()) + "\"");
        row.add("Declare40:\"" + Tool.jsSpecialChars(getDeclare40()) + "\"");
        row.add("Declare41:\"" + Tool.jsSpecialChars(getDeclare41()) + "\"");
        row.add("Declare42:\"" + Tool.jsSpecialChars(getDeclare42()) + "\"");
        row.add("Declare43:\"" + Tool.jsSpecialChars(getDeclare43()) + "\"");
        row.add("Declare44:\"" + Tool.jsSpecialChars(getDeclare44()) + "\"");
        row.add("Declare45:\"" + Tool.jsSpecialChars(getDeclare45()) + "\"");
        row.add("Declare46:\"" + Tool.jsSpecialChars(getDeclare46()) + "\"");
        row.add("Declare47:\"" + Tool.jsSpecialChars(getDeclare47()) + "\"");
        row.add("Declare48:\"" + Tool.jsSpecialChars(getDeclare48()) + "\"");
        row.add("Declare49:\"" + Tool.jsSpecialChars(getDeclare49()) + "\"");
        row.add("Declare50:\"" + Tool.jsSpecialChars(getDeclare50()) + "\"");
        row.add("Declare51:\"" + Tool.jsSpecialChars(getDeclare51()) + "\"");
        row.add("Declare52:\"" + Tool.jsSpecialChars(getDeclare52()) + "\"");
        row.add("Declare53:\"" + Tool.jsSpecialChars(getDeclare53()) + "\"");
        row.add("Declare54:\"" + Tool.jsSpecialChars(getDeclare54()) + "\"");
        row.add("Declare55:\"" + Tool.jsSpecialChars(getDeclare55()) + "\"");
        row.add("Declare56:\"" + Tool.jsSpecialChars(getDeclare56()) + "\"");
        row.add("Declare57:\"" + Tool.jsSpecialChars(getDeclare57()) + "\"");
        row.add("Declare58:\"" + Tool.jsSpecialChars(getDeclare58()) + "\"");
        row.add("Declare59:\"" + Tool.jsSpecialChars(getDeclare59()) + "\"");
        row.add("Declare60:\"" + Tool.jsSpecialChars(getDeclare60()) + "\"");
        row.add("Declare61:\"" + Tool.jsSpecialChars(getDeclare61()) + "\"");
        row.add("Declare62:\"" + Tool.jsSpecialChars(getDeclare62()) + "\"");
        row.add("Declare63:\"" + Tool.jsSpecialChars(getDeclare63()) + "\"");
        row.add("Declare64:\"" + Tool.jsSpecialChars(getDeclare64()) + "\"");
        row.add("AddFileList:\"" + Tool.jsSpecialChars(getAddFileList()) + "\"");
        row.add("Remark1:\"" + Tool.jsSpecialChars(getRemark1()) + "\"");
        row.add("Remark2:\"" + Tool.jsSpecialChars(getRemark2()) + "\"");
        row.add("Remark3:\"" + Tool.jsSpecialChars(getRemark3()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,type number(*,0),declareid number(*,0),academy varchar2(45),xyhonour varchar2(45),submitflag number(*,0),xycheckflag number(*,0),twcheckflag number(*,0),addaccount varchar2(45),addtime varchar2(45),declare1 varchar2(45),declare2 varchar2(45),declare5 varchar2(45),declare8 varchar2(45),declare6 varchar2(45),declare7 varchar2(45),declare9 varchar2(45),declare10 varchar2(255),declare11 varchar2(255),declare12 varchar2(255),declare13 varchar2(255),declare14 varchar2(255),declare15 varchar2(255),declare16 varchar2(45),declare17 varchar2(45),declare18 varchar2(45),declare19 varchar2(45),declare20 varchar2(45),declare21 varchar2(45),declare22 varchar2(45),declare23 varchar2(45),declare24 varchar2(45),declare25 varchar2(45),declare26 varchar2(45),declare27 varchar2(255),declare28 varchar2(255),declare29 varchar2(255),declare30 varchar2(255),declare31 varchar2(45),declare32 varchar2(45),declare33 varchar2(45),declare34 varchar2(45),declare35 varchar2(45),declare36 varchar2(45),declare37 varchar2(45),declare38 varchar2(45),declare39 varchar2(45),declare40 varchar2(45),declare41 varchar2(45),declare42 varchar2(45),declare43 varchar2(45),declare44 varchar2(45),declare45 varchar2(45),declare46 varchar2(45),declare47 varchar2(45),declare48 varchar2(45),declare49 varchar2(45),declare50 varchar2(45),declare51 varchar2(45),declare52 varchar2(45),declare53 varchar2(45),declare54 varchar2(45),declare55 varchar2(45),declare56 varchar2(45),declare57 varchar2(45),declare58 varchar2(45),declare59 varchar2(255),declare60 varchar2(45),declare61 varchar2(45),declare62 varchar2(45),declare63 varchar2(45),declare64 varchar2(45),addfilelist varchar2(45),remark1 varchar2(45),remark2 varchar2(45),remark3 varchar2(45))"});
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
        PracticeDeclare v = new PracticeDeclare(sourceDb, sourceTb);
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
        PracticeDeclare v = new PracticeDeclare(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(PracticeDeclare obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getType()).compareTo("" + obj.getType()); if (rtn != 0) return rtn;
        rtn = ("" + getDeclareId()).compareTo("" + obj.getDeclareId()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getXyHonour().compareTo(obj.getXyHonour()); if (rtn != 0) return rtn;
        rtn = ("" + getSubmitflag()).compareTo("" + obj.getSubmitflag()); if (rtn != 0) return rtn;
        rtn = ("" + getXyCheckFlag()).compareTo("" + obj.getXyCheckFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getTwCheckFlag()).compareTo("" + obj.getTwCheckFlag()); if (rtn != 0) return rtn;
        rtn = getAddaccount().compareTo(obj.getAddaccount()); if (rtn != 0) return rtn;
        rtn = getAddtime().compareTo(obj.getAddtime()); if (rtn != 0) return rtn;
        rtn = getDeclare1().compareTo(obj.getDeclare1()); if (rtn != 0) return rtn;
        rtn = getDeclare2().compareTo(obj.getDeclare2()); if (rtn != 0) return rtn;
        rtn = getDeclare5().compareTo(obj.getDeclare5()); if (rtn != 0) return rtn;
        rtn = getDeclare8().compareTo(obj.getDeclare8()); if (rtn != 0) return rtn;
        rtn = getDeclare6().compareTo(obj.getDeclare6()); if (rtn != 0) return rtn;
        rtn = getDeclare7().compareTo(obj.getDeclare7()); if (rtn != 0) return rtn;
        rtn = getDeclare9().compareTo(obj.getDeclare9()); if (rtn != 0) return rtn;
        rtn = getDeclare10().compareTo(obj.getDeclare10()); if (rtn != 0) return rtn;
        rtn = getDeclare11().compareTo(obj.getDeclare11()); if (rtn != 0) return rtn;
        rtn = getDeclare12().compareTo(obj.getDeclare12()); if (rtn != 0) return rtn;
        rtn = getDeclare13().compareTo(obj.getDeclare13()); if (rtn != 0) return rtn;
        rtn = getDeclare14().compareTo(obj.getDeclare14()); if (rtn != 0) return rtn;
        rtn = getDeclare15().compareTo(obj.getDeclare15()); if (rtn != 0) return rtn;
        rtn = getDeclare16().compareTo(obj.getDeclare16()); if (rtn != 0) return rtn;
        rtn = getDeclare17().compareTo(obj.getDeclare17()); if (rtn != 0) return rtn;
        rtn = getDeclare18().compareTo(obj.getDeclare18()); if (rtn != 0) return rtn;
        rtn = getDeclare19().compareTo(obj.getDeclare19()); if (rtn != 0) return rtn;
        rtn = getDeclare20().compareTo(obj.getDeclare20()); if (rtn != 0) return rtn;
        rtn = getDeclare21().compareTo(obj.getDeclare21()); if (rtn != 0) return rtn;
        rtn = getDeclare22().compareTo(obj.getDeclare22()); if (rtn != 0) return rtn;
        rtn = getDeclare23().compareTo(obj.getDeclare23()); if (rtn != 0) return rtn;
        rtn = getDeclare24().compareTo(obj.getDeclare24()); if (rtn != 0) return rtn;
        rtn = getDeclare25().compareTo(obj.getDeclare25()); if (rtn != 0) return rtn;
        rtn = getDeclare26().compareTo(obj.getDeclare26()); if (rtn != 0) return rtn;
        rtn = getDeclare27().compareTo(obj.getDeclare27()); if (rtn != 0) return rtn;
        rtn = getDeclare28().compareTo(obj.getDeclare28()); if (rtn != 0) return rtn;
        rtn = getDeclare29().compareTo(obj.getDeclare29()); if (rtn != 0) return rtn;
        rtn = getDeclare30().compareTo(obj.getDeclare30()); if (rtn != 0) return rtn;
        rtn = getDeclare31().compareTo(obj.getDeclare31()); if (rtn != 0) return rtn;
        rtn = getDeclare32().compareTo(obj.getDeclare32()); if (rtn != 0) return rtn;
        rtn = getDeclare33().compareTo(obj.getDeclare33()); if (rtn != 0) return rtn;
        rtn = getDeclare34().compareTo(obj.getDeclare34()); if (rtn != 0) return rtn;
        rtn = getDeclare35().compareTo(obj.getDeclare35()); if (rtn != 0) return rtn;
        rtn = getDeclare36().compareTo(obj.getDeclare36()); if (rtn != 0) return rtn;
        rtn = getDeclare37().compareTo(obj.getDeclare37()); if (rtn != 0) return rtn;
        rtn = getDeclare38().compareTo(obj.getDeclare38()); if (rtn != 0) return rtn;
        rtn = getDeclare39().compareTo(obj.getDeclare39()); if (rtn != 0) return rtn;
        rtn = getDeclare40().compareTo(obj.getDeclare40()); if (rtn != 0) return rtn;
        rtn = getDeclare41().compareTo(obj.getDeclare41()); if (rtn != 0) return rtn;
        rtn = getDeclare42().compareTo(obj.getDeclare42()); if (rtn != 0) return rtn;
        rtn = getDeclare43().compareTo(obj.getDeclare43()); if (rtn != 0) return rtn;
        rtn = getDeclare44().compareTo(obj.getDeclare44()); if (rtn != 0) return rtn;
        rtn = getDeclare45().compareTo(obj.getDeclare45()); if (rtn != 0) return rtn;
        rtn = getDeclare46().compareTo(obj.getDeclare46()); if (rtn != 0) return rtn;
        rtn = getDeclare47().compareTo(obj.getDeclare47()); if (rtn != 0) return rtn;
        rtn = getDeclare48().compareTo(obj.getDeclare48()); if (rtn != 0) return rtn;
        rtn = getDeclare49().compareTo(obj.getDeclare49()); if (rtn != 0) return rtn;
        rtn = getDeclare50().compareTo(obj.getDeclare50()); if (rtn != 0) return rtn;
        rtn = getDeclare51().compareTo(obj.getDeclare51()); if (rtn != 0) return rtn;
        rtn = getDeclare52().compareTo(obj.getDeclare52()); if (rtn != 0) return rtn;
        rtn = getDeclare53().compareTo(obj.getDeclare53()); if (rtn != 0) return rtn;
        rtn = getDeclare54().compareTo(obj.getDeclare54()); if (rtn != 0) return rtn;
        rtn = getDeclare55().compareTo(obj.getDeclare55()); if (rtn != 0) return rtn;
        rtn = getDeclare56().compareTo(obj.getDeclare56()); if (rtn != 0) return rtn;
        rtn = getDeclare57().compareTo(obj.getDeclare57()); if (rtn != 0) return rtn;
        rtn = getDeclare58().compareTo(obj.getDeclare58()); if (rtn != 0) return rtn;
        rtn = getDeclare59().compareTo(obj.getDeclare59()); if (rtn != 0) return rtn;
        rtn = getDeclare60().compareTo(obj.getDeclare60()); if (rtn != 0) return rtn;
        rtn = getDeclare61().compareTo(obj.getDeclare61()); if (rtn != 0) return rtn;
        rtn = getDeclare62().compareTo(obj.getDeclare62()); if (rtn != 0) return rtn;
        rtn = getDeclare63().compareTo(obj.getDeclare63()); if (rtn != 0) return rtn;
        rtn = getDeclare64().compareTo(obj.getDeclare64()); if (rtn != 0) return rtn;
        rtn = getAddFileList().compareTo(obj.getAddFileList()); if (rtn != 0) return rtn;
        rtn = getRemark1().compareTo(obj.getRemark1()); if (rtn != 0) return rtn;
        rtn = getRemark2().compareTo(obj.getRemark2()); if (rtn != 0) return rtn;
        rtn = getRemark3().compareTo(obj.getRemark3()); if (rtn != 0) return rtn;
        return rtn;
    }
}
