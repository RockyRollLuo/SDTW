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
@Description("学生素质拓展培养认证单-不用")
public class StudentsRzd implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(StudentsRzd.class);
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
    public static final String DbTableName = "students_rzd";
    private String TNAME = "students_rzd";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","reason","submitflag","printcode","sno","academy","rownumstr","value1","value2","value3","value4","value5","listarray1","listarray2","listarray3","listarray4","listarray5","listarray6","listarray7","listarray8","listarray9","listarray10","checkflag"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","reason","submitflag","printcode","sno","academy","rownumstr","value1","value2","value3","value4","value5","listarray1","listarray2","listarray3","listarray4","listarray5","listarray6","listarray7","listarray8","listarray9","listarray10","checkflag"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"Reason","reason","String"},{"Submitflag","submitflag","int"},{"Printcode","printcode","String"},{"Sno","sno","String"},{"Academy","academy","String"},{"Rownumstr","rownumstr","String"},{"Value1","value1","String"},{"Value2","value2","String"},{"Value3","value3","String"},{"Value4","value4","String"},{"Value5","value5","String"},{"Listarray1","listarray1","String"},{"Listarray2","listarray2","String"},{"Listarray3","listarray3","String"},{"Listarray4","listarray4","String"},{"Listarray5","listarray5","String"},{"Listarray6","listarray6","String"},{"Listarray7","listarray7","String"},{"Listarray8","listarray8","String"},{"Listarray9","listarray9","String"},{"Listarray10","listarray10","String"},{"Checkflag","checkflag","int"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"reason","reason"},{"submitflag","submitflag"},{"printcode","printcode"},{"sno","sno"},{"academy","academy"},{"rownumstr","rownumstr"},{"value1","value1"},{"value2","value2"},{"value3","value3"},{"value4","value4"},{"value5","value5"},{"listarray1","listarray1"},{"listarray2","listarray2"},{"listarray3","listarray3"},{"listarray4","listarray4"},{"listarray5","listarray5"},{"listarray6","listarray6"},{"listarray7","listarray7"},{"listarray8","listarray8"},{"listarray9","listarray9"},{"listarray10","listarray10"},{"checkflag","checkflag"}};
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
    public void setId(int aId) { id = aId; modifiedFields.add("Id"); }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 审核意见
    protected String reason = "";
    public String getReason() {  return SqlTool.getDbString(reason);  }
    public String getReason(int size) { return SqlTool.subString(getReason(), size); }
    public void setReason(String aReason) { reason = aReason; modifiedFields.add("Reason"); }
    public void assignReason(String aReason) { reason = aReason; }
    public void paramReason(HttpServletRequest request) { paramReason(request, "Reason"); }
    public void paramReason(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReason()); if (!tmp.equals(getReason())) { setReason(tmp); } }
    // 是否提交
    protected int submitflag = 0;
    public int getSubmitflag() { return submitflag; }
    public void setSubmitflag(int aSubmitflag) { submitflag = aSubmitflag; modifiedFields.add("Submitflag"); }
    public void assignSubmitflag(int aSubmitflag) { submitflag = aSubmitflag; }
    public void paramSubmitflag(HttpServletRequest request) { paramSubmitflag(request, "Submitflag"); }
    public void paramSubmitflag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getSubmitflag()); if (tmp != getSubmitflag()) { setSubmitflag(tmp); } }
    // 打印编号
    protected String printcode = "";
    public String getPrintcode() {  return SqlTool.getDbString(printcode);  }
    public String getPrintcode(int size) { return SqlTool.subString(getPrintcode(), size); }
    public void setPrintcode(String aPrintcode) { printcode = aPrintcode; modifiedFields.add("Printcode"); }
    public void assignPrintcode(String aPrintcode) { printcode = aPrintcode; }
    public void paramPrintcode(HttpServletRequest request) { paramPrintcode(request, "Printcode"); }
    public void paramPrintcode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPrintcode()); if (!tmp.equals(getPrintcode())) { setPrintcode(tmp); } }
    // 学号
    protected String sno = "";
    public String getSno() {  return SqlTool.getDbString(sno);  }
    public String getSno(int size) { return SqlTool.subString(getSno(), size); }
    public void setSno(String aSno) { sno = aSno; modifiedFields.add("Sno"); }
    public void assignSno(String aSno) { sno = aSno; }
    public void paramSno(HttpServletRequest request) { paramSno(request, "Sno"); }
    public void paramSno(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSno()); if (!tmp.equals(getSno())) { setSno(tmp); } }
    // 学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // rowspan
    protected String rownumstr = "";
    public String getRownumstr() {  return SqlTool.getDbString(rownumstr);  }
    public String getRownumstr(int size) { return SqlTool.subString(getRownumstr(), size); }
    public void setRownumstr(String aRownumstr) { rownumstr = aRownumstr; modifiedFields.add("Rownumstr"); }
    public void assignRownumstr(String aRownumstr) { rownumstr = aRownumstr; }
    public void paramRownumstr(HttpServletRequest request) { paramRownumstr(request, "Rownumstr"); }
    public void paramRownumstr(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRownumstr()); if (!tmp.equals(getRownumstr())) { setRownumstr(tmp); } }
    // 姓名
    protected String value1 = "";
    public String getValue1() {  return SqlTool.getDbString(value1);  }
    public String getValue1(int size) { return SqlTool.subString(getValue1(), size); }
    public void setValue1(String aValue1) { value1 = aValue1; modifiedFields.add("Value1"); }
    public void assignValue1(String aValue1) { value1 = aValue1; }
    public void paramValue1(HttpServletRequest request) { paramValue1(request, "Value1"); }
    public void paramValue1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getValue1()); if (!tmp.equals(getValue1())) { setValue1(tmp); } }
    // 政治面貌
    protected String value2 = "";
    public String getValue2() {  return SqlTool.getDbString(value2);  }
    public String getValue2(int size) { return SqlTool.subString(getValue2(), size); }
    public void setValue2(String aValue2) { value2 = aValue2; modifiedFields.add("Value2"); }
    public void assignValue2(String aValue2) { value2 = aValue2; }
    public void paramValue2(HttpServletRequest request) { paramValue2(request, "Value2"); }
    public void paramValue2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getValue2()); if (!tmp.equals(getValue2())) { setValue2(tmp); } }
    // 学院下分院
    protected String value3 = "";
    public String getValue3() {  return SqlTool.getDbString(value3);  }
    public String getValue3(int size) { return SqlTool.subString(getValue3(), size); }
    public void setValue3(String aValue3) { value3 = aValue3; modifiedFields.add("Value3"); }
    public void assignValue3(String aValue3) { value3 = aValue3; }
    public void paramValue3(HttpServletRequest request) { paramValue3(request, "Value3"); }
    public void paramValue3(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getValue3()); if (!tmp.equals(getValue3())) { setValue3(tmp); } }
    // 专业
    protected String value4 = "";
    public String getValue4() {  return SqlTool.getDbString(value4);  }
    public String getValue4(int size) { return SqlTool.subString(getValue4(), size); }
    public void setValue4(String aValue4) { value4 = aValue4; modifiedFields.add("Value4"); }
    public void assignValue4(String aValue4) { value4 = aValue4; }
    public void paramValue4(HttpServletRequest request) { paramValue4(request, "Value4"); }
    public void paramValue4(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getValue4()); if (!tmp.equals(getValue4())) { setValue4(tmp); } }
    // 年级
    protected String value5 = "";
    public String getValue5() {  return SqlTool.getDbString(value5);  }
    public String getValue5(int size) { return SqlTool.subString(getValue5(), size); }
    public void setValue5(String aValue5) { value5 = aValue5; modifiedFields.add("Value5"); }
    public void assignValue5(String aValue5) { value5 = aValue5; }
    public void paramValue5(HttpServletRequest request) { paramValue5(request, "Value5"); }
    public void paramValue5(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getValue5()); if (!tmp.equals(getValue5())) { setValue5(tmp); } }
    // 主题教育
    protected String listarray1 = "";
    public String getListarray1() {  return SqlTool.getDbString(listarray1);  }
    public String getListarray1(int size) { return SqlTool.subString(getListarray1(), size); }
    public void setListarray1(String aListarray1) { listarray1 = aListarray1; modifiedFields.add("Listarray1"); }
    public void assignListarray1(String aListarray1) { listarray1 = aListarray1; }
    public void paramListarray1(HttpServletRequest request) { paramListarray1(request, "Listarray1"); }
    public void paramListarray1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getListarray1()); if (!tmp.equals(getListarray1())) { setListarray1(tmp); } }
    // 文化艺术
    protected String listarray2 = "";
    public String getListarray2() {  return SqlTool.getDbString(listarray2);  }
    public String getListarray2(int size) { return SqlTool.subString(getListarray2(), size); }
    public void setListarray2(String aListarray2) { listarray2 = aListarray2; modifiedFields.add("Listarray2"); }
    public void assignListarray2(String aListarray2) { listarray2 = aListarray2; }
    public void paramListarray2(HttpServletRequest request) { paramListarray2(request, "Listarray2"); }
    public void paramListarray2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getListarray2()); if (!tmp.equals(getListarray2())) { setListarray2(tmp); } }
    // 体育健康
    protected String listarray3 = "";
    public String getListarray3() {  return SqlTool.getDbString(listarray3);  }
    public String getListarray3(int size) { return SqlTool.subString(getListarray3(), size); }
    public void setListarray3(String aListarray3) { listarray3 = aListarray3; modifiedFields.add("Listarray3"); }
    public void assignListarray3(String aListarray3) { listarray3 = aListarray3; }
    public void paramListarray3(HttpServletRequest request) { paramListarray3(request, "Listarray3"); }
    public void paramListarray3(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getListarray3()); if (!tmp.equals(getListarray3())) { setListarray3(tmp); } }
    // 科技创新
    protected String listarray4 = "";
    public String getListarray4() {  return SqlTool.getDbString(listarray4);  }
    public String getListarray4(int size) { return SqlTool.subString(getListarray4(), size); }
    public void setListarray4(String aListarray4) { listarray4 = aListarray4; modifiedFields.add("Listarray4"); }
    public void assignListarray4(String aListarray4) { listarray4 = aListarray4; }
    public void paramListarray4(HttpServletRequest request) { paramListarray4(request, "Listarray4"); }
    public void paramListarray4(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getListarray4()); if (!tmp.equals(getListarray4())) { setListarray4(tmp); } }
    // 实践服务
    protected String listarray5 = "";
    public String getListarray5() {  return SqlTool.getDbString(listarray5);  }
    public String getListarray5(int size) { return SqlTool.subString(getListarray5(), size); }
    public void setListarray5(String aListarray5) { listarray5 = aListarray5; modifiedFields.add("Listarray5"); }
    public void assignListarray5(String aListarray5) { listarray5 = aListarray5; }
    public void paramListarray5(HttpServletRequest request) { paramListarray5(request, "Listarray5"); }
    public void paramListarray5(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getListarray5()); if (!tmp.equals(getListarray5())) { setListarray5(tmp); } }
    // 就业创业
    protected String listarray6 = "";
    public String getListarray6() {  return SqlTool.getDbString(listarray6);  }
    public String getListarray6(int size) { return SqlTool.subString(getListarray6(), size); }
    public void setListarray6(String aListarray6) { listarray6 = aListarray6; modifiedFields.add("Listarray6"); }
    public void assignListarray6(String aListarray6) { listarray6 = aListarray6; }
    public void paramListarray6(HttpServletRequest request) { paramListarray6(request, "Listarray6"); }
    public void paramListarray6(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getListarray6()); if (!tmp.equals(getListarray6())) { setListarray6(tmp); } }
    // 志愿服务
    protected String listarray7 = "";
    public String getListarray7() {  return SqlTool.getDbString(listarray7);  }
    public String getListarray7(int size) { return SqlTool.subString(getListarray7(), size); }
    public void setListarray7(String aListarray7) { listarray7 = aListarray7; modifiedFields.add("Listarray7"); }
    public void assignListarray7(String aListarray7) { listarray7 = aListarray7; }
    public void paramListarray7(HttpServletRequest request) { paramListarray7(request, "Listarray7"); }
    public void paramListarray7(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getListarray7()); if (!tmp.equals(getListarray7())) { setListarray7(tmp); } }
    // 社会工作
    protected String listarray8 = "";
    public String getListarray8() {  return SqlTool.getDbString(listarray8);  }
    public String getListarray8(int size) { return SqlTool.subString(getListarray8(), size); }
    public void setListarray8(String aListarray8) { listarray8 = aListarray8; modifiedFields.add("Listarray8"); }
    public void assignListarray8(String aListarray8) { listarray8 = aListarray8; }
    public void paramListarray8(HttpServletRequest request) { paramListarray8(request, "Listarray8"); }
    public void paramListarray8(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getListarray8()); if (!tmp.equals(getListarray8())) { setListarray8(tmp); } }
    // 社团经历
    protected String listarray9 = "";
    public String getListarray9() {  return SqlTool.getDbString(listarray9);  }
    public String getListarray9(int size) { return SqlTool.subString(getListarray9(), size); }
    public void setListarray9(String aListarray9) { listarray9 = aListarray9; modifiedFields.add("Listarray9"); }
    public void assignListarray9(String aListarray9) { listarray9 = aListarray9; }
    public void paramListarray9(HttpServletRequest request) { paramListarray9(request, "Listarray9"); }
    public void paramListarray9(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getListarray9()); if (!tmp.equals(getListarray9())) { setListarray9(tmp); } }
    // 学术论坛
    protected String listarray10 = "";
    public String getListarray10() {  return SqlTool.getDbString(listarray10);  }
    public String getListarray10(int size) { return SqlTool.subString(getListarray10(), size); }
    public void setListarray10(String aListarray10) { listarray10 = aListarray10; modifiedFields.add("Listarray10"); }
    public void assignListarray10(String aListarray10) { listarray10 = aListarray10; }
    public void paramListarray10(HttpServletRequest request) { paramListarray10(request, "Listarray10"); }
    public void paramListarray10(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getListarray10()); if (!tmp.equals(getListarray10())) { setListarray10(tmp); } }
    // 0未审核 ，2 未通过 ，1通过
    protected int checkflag = 0;
    public int getCheckflag() { return checkflag; }
    public void setCheckflag(int aCheckflag) { checkflag = aCheckflag; modifiedFields.add("Checkflag"); }
    public void assignCheckflag(int aCheckflag) { checkflag = aCheckflag; }
    public void paramCheckflag(HttpServletRequest request) { paramCheckflag(request, "Checkflag"); }
    public void paramCheckflag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckflag()); if (tmp != getCheckflag()) { setCheckflag(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public StudentsRzd (String db) {
        DBNAME = db;
    }
    public StudentsRzd (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public StudentsRzd (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public StudentsRzd () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return StudentsRzd类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public StudentsRzd getByParameter(HttpServletRequest request) {
        StudentsRzd v = new StudentsRzd(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramReason(request);
        paramSubmitflag(request);
        paramPrintcode(request);
        paramSno(request);
        paramAcademy(request);
        paramRownumstr(request);
        paramValue1(request);
        paramValue2(request);
        paramValue3(request);
        paramValue4(request);
        paramValue5(request);
        paramListarray1(request);
        paramListarray2(request);
        paramListarray3(request);
        paramListarray4(request);
        paramListarray5(request);
        paramListarray6(request);
        paramListarray7(request);
        paramListarray8(request);
        paramListarray9(request);
        paramListarray10(request);
        paramCheckflag(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(StudentsRzd bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("reason")) { setReason(bean.getReason()); }
        if (!ncl.contains("submitflag")) { setSubmitflag(bean.getSubmitflag()); }
        if (!ncl.contains("printcode")) { setPrintcode(bean.getPrintcode()); }
        if (!ncl.contains("sno")) { setSno(bean.getSno()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("rownumstr")) { setRownumstr(bean.getRownumstr()); }
        if (!ncl.contains("value1")) { setValue1(bean.getValue1()); }
        if (!ncl.contains("value2")) { setValue2(bean.getValue2()); }
        if (!ncl.contains("value3")) { setValue3(bean.getValue3()); }
        if (!ncl.contains("value4")) { setValue4(bean.getValue4()); }
        if (!ncl.contains("value5")) { setValue5(bean.getValue5()); }
        if (!ncl.contains("listarray1")) { setListarray1(bean.getListarray1()); }
        if (!ncl.contains("listarray2")) { setListarray2(bean.getListarray2()); }
        if (!ncl.contains("listarray3")) { setListarray3(bean.getListarray3()); }
        if (!ncl.contains("listarray4")) { setListarray4(bean.getListarray4()); }
        if (!ncl.contains("listarray5")) { setListarray5(bean.getListarray5()); }
        if (!ncl.contains("listarray6")) { setListarray6(bean.getListarray6()); }
        if (!ncl.contains("listarray7")) { setListarray7(bean.getListarray7()); }
        if (!ncl.contains("listarray8")) { setListarray8(bean.getListarray8()); }
        if (!ncl.contains("listarray9")) { setListarray9(bean.getListarray9()); }
        if (!ncl.contains("listarray10")) { setListarray10(bean.getListarray10()); }
        if (!ncl.contains("checkflag")) { setCheckflag(bean.getCheckflag()); }
    }
    public StudentsRzd getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        StudentsRzd[] rslt= queryByCondition(cdt);
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
     * @return StudentsRzd类的实例列表。
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
                StudentsRzd ve = new StudentsRzd(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignReason(fromDbCh(rs.getString(2)));
                ve.assignSubmitflag(rs.getInt(3));
                ve.assignPrintcode(fromDbCh(rs.getString(4)));
                ve.assignSno(fromDbCh(rs.getString(5)));
                ve.assignAcademy(fromDbCh(rs.getString(6)));
                ve.assignRownumstr(fromDbCh(rs.getString(7)));
                ve.assignValue1(fromDbCh(rs.getString(8)));
                ve.assignValue2(fromDbCh(rs.getString(9)));
                ve.assignValue3(fromDbCh(rs.getString(10)));
                ve.assignValue4(fromDbCh(rs.getString(11)));
                ve.assignValue5(fromDbCh(rs.getString(12)));
                ve.assignListarray1(fromDbCh(rs.getString(13)));
                ve.assignListarray2(fromDbCh(rs.getString(14)));
                ve.assignListarray3(fromDbCh(rs.getString(15)));
                ve.assignListarray4(fromDbCh(rs.getString(16)));
                ve.assignListarray5(fromDbCh(rs.getString(17)));
                ve.assignListarray6(fromDbCh(rs.getString(18)));
                ve.assignListarray7(fromDbCh(rs.getString(19)));
                ve.assignListarray8(fromDbCh(rs.getString(20)));
                ve.assignListarray9(fromDbCh(rs.getString(21)));
                ve.assignListarray10(fromDbCh(rs.getString(22)));
                ve.assignCheckflag(rs.getInt(23));
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
    public StudentsRzd[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (StudentsRzd[])vrs.toArray(new StudentsRzd[vrs.size()]);
    }
    public StudentsRzd[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (StudentsRzd[])vrs.toArray(new StudentsRzd[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (reason,submitflag,printcode,sno,academy,rownumstr,value1,value2,value3,value4,value5,listarray1,listarray2,listarray3,listarray4,listarray5,listarray6,listarray7,listarray8,listarray9,listarray10,checkflag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(reason));
            pstmt.setInt(2, submitflag);
            pstmt.setString(3, toDbCh(printcode));
            pstmt.setString(4, toDbCh(sno));
            pstmt.setString(5, toDbCh(academy));
            pstmt.setString(6, toDbCh(rownumstr));
            pstmt.setString(7, toDbCh(value1));
            pstmt.setString(8, toDbCh(value2));
            pstmt.setString(9, toDbCh(value3));
            pstmt.setString(10, toDbCh(value4));
            pstmt.setString(11, toDbCh(value5));
            pstmt.setString(12, toDbCh(listarray1));
            pstmt.setString(13, toDbCh(listarray2));
            pstmt.setString(14, toDbCh(listarray3));
            pstmt.setString(15, toDbCh(listarray4));
            pstmt.setString(16, toDbCh(listarray5));
            pstmt.setString(17, toDbCh(listarray6));
            pstmt.setString(18, toDbCh(listarray7));
            pstmt.setString(19, toDbCh(listarray8));
            pstmt.setString(20, toDbCh(listarray9));
            pstmt.setString(21, toDbCh(listarray10));
            pstmt.setInt(22, checkflag);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,reason,submitflag,printcode,sno,academy,rownumstr,value1,value2,value3,value4,value5,listarray1,listarray2,listarray3,listarray4,listarray5,listarray6,listarray7,listarray8,listarray9,listarray10,checkflag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(reason));
            pstmt.setInt(3, submitflag);
            pstmt.setString(4, toDbCh(printcode));
            pstmt.setString(5, toDbCh(sno));
            pstmt.setString(6, toDbCh(academy));
            pstmt.setString(7, toDbCh(rownumstr));
            pstmt.setString(8, toDbCh(value1));
            pstmt.setString(9, toDbCh(value2));
            pstmt.setString(10, toDbCh(value3));
            pstmt.setString(11, toDbCh(value4));
            pstmt.setString(12, toDbCh(value5));
            pstmt.setString(13, toDbCh(listarray1));
            pstmt.setString(14, toDbCh(listarray2));
            pstmt.setString(15, toDbCh(listarray3));
            pstmt.setString(16, toDbCh(listarray4));
            pstmt.setString(17, toDbCh(listarray5));
            pstmt.setString(18, toDbCh(listarray6));
            pstmt.setString(19, toDbCh(listarray7));
            pstmt.setString(20, toDbCh(listarray8));
            pstmt.setString(21, toDbCh(listarray9));
            pstmt.setString(22, toDbCh(listarray10));
            pstmt.setInt(23, checkflag);
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
            StudentsRzd item = (StudentsRzd)it.next();
            StudentsRzd v = new StudentsRzd(dbname);
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
                if (modifiedFields.contains("Reason")) { pstmt.setString(pi ++, toDbCh(reason)); }
                if (modifiedFields.contains("Submitflag")) { pstmt.setInt(pi ++, submitflag); }
                if (modifiedFields.contains("Printcode")) { pstmt.setString(pi ++, toDbCh(printcode)); }
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Rownumstr")) { pstmt.setString(pi ++, toDbCh(rownumstr)); }
                if (modifiedFields.contains("Value1")) { pstmt.setString(pi ++, toDbCh(value1)); }
                if (modifiedFields.contains("Value2")) { pstmt.setString(pi ++, toDbCh(value2)); }
                if (modifiedFields.contains("Value3")) { pstmt.setString(pi ++, toDbCh(value3)); }
                if (modifiedFields.contains("Value4")) { pstmt.setString(pi ++, toDbCh(value4)); }
                if (modifiedFields.contains("Value5")) { pstmt.setString(pi ++, toDbCh(value5)); }
                if (modifiedFields.contains("Listarray1")) { pstmt.setString(pi ++, toDbCh(listarray1)); }
                if (modifiedFields.contains("Listarray2")) { pstmt.setString(pi ++, toDbCh(listarray2)); }
                if (modifiedFields.contains("Listarray3")) { pstmt.setString(pi ++, toDbCh(listarray3)); }
                if (modifiedFields.contains("Listarray4")) { pstmt.setString(pi ++, toDbCh(listarray4)); }
                if (modifiedFields.contains("Listarray5")) { pstmt.setString(pi ++, toDbCh(listarray5)); }
                if (modifiedFields.contains("Listarray6")) { pstmt.setString(pi ++, toDbCh(listarray6)); }
                if (modifiedFields.contains("Listarray7")) { pstmt.setString(pi ++, toDbCh(listarray7)); }
                if (modifiedFields.contains("Listarray8")) { pstmt.setString(pi ++, toDbCh(listarray8)); }
                if (modifiedFields.contains("Listarray9")) { pstmt.setString(pi ++, toDbCh(listarray9)); }
                if (modifiedFields.contains("Listarray10")) { pstmt.setString(pi ++, toDbCh(listarray10)); }
                if (modifiedFields.contains("Checkflag")) { pstmt.setInt(pi ++, checkflag); }
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
                if (modifiedFields.contains("Reason")) { pstmt.setString(pi ++, toDbCh(reason)); }
                if (modifiedFields.contains("Submitflag")) { pstmt.setInt(pi ++, submitflag); }
                if (modifiedFields.contains("Printcode")) { pstmt.setString(pi ++, toDbCh(printcode)); }
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Rownumstr")) { pstmt.setString(pi ++, toDbCh(rownumstr)); }
                if (modifiedFields.contains("Value1")) { pstmt.setString(pi ++, toDbCh(value1)); }
                if (modifiedFields.contains("Value2")) { pstmt.setString(pi ++, toDbCh(value2)); }
                if (modifiedFields.contains("Value3")) { pstmt.setString(pi ++, toDbCh(value3)); }
                if (modifiedFields.contains("Value4")) { pstmt.setString(pi ++, toDbCh(value4)); }
                if (modifiedFields.contains("Value5")) { pstmt.setString(pi ++, toDbCh(value5)); }
                if (modifiedFields.contains("Listarray1")) { pstmt.setString(pi ++, toDbCh(listarray1)); }
                if (modifiedFields.contains("Listarray2")) { pstmt.setString(pi ++, toDbCh(listarray2)); }
                if (modifiedFields.contains("Listarray3")) { pstmt.setString(pi ++, toDbCh(listarray3)); }
                if (modifiedFields.contains("Listarray4")) { pstmt.setString(pi ++, toDbCh(listarray4)); }
                if (modifiedFields.contains("Listarray5")) { pstmt.setString(pi ++, toDbCh(listarray5)); }
                if (modifiedFields.contains("Listarray6")) { pstmt.setString(pi ++, toDbCh(listarray6)); }
                if (modifiedFields.contains("Listarray7")) { pstmt.setString(pi ++, toDbCh(listarray7)); }
                if (modifiedFields.contains("Listarray8")) { pstmt.setString(pi ++, toDbCh(listarray8)); }
                if (modifiedFields.contains("Listarray9")) { pstmt.setString(pi ++, toDbCh(listarray9)); }
                if (modifiedFields.contains("Listarray10")) { pstmt.setString(pi ++, toDbCh(listarray10)); }
                if (modifiedFields.contains("Checkflag")) { pstmt.setInt(pi ++, checkflag); }
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
        map.put("Reason", getReason());
        map.put("Submitflag", getSubmitflag() + "");
        map.put("Printcode", getPrintcode());
        map.put("Sno", getSno());
        map.put("Academy", getAcademy());
        map.put("Rownumstr", getRownumstr());
        map.put("Value1", getValue1());
        map.put("Value2", getValue2());
        map.put("Value3", getValue3());
        map.put("Value4", getValue4());
        map.put("Value5", getValue5());
        map.put("Listarray1", getListarray1());
        map.put("Listarray2", getListarray2());
        map.put("Listarray3", getListarray3());
        map.put("Listarray4", getListarray4());
        map.put("Listarray5", getListarray5());
        map.put("Listarray6", getListarray6());
        map.put("Listarray7", getListarray7());
        map.put("Listarray8", getListarray8());
        map.put("Listarray9", getListarray9());
        map.put("Listarray10", getListarray10());
        map.put("Checkflag", getCheckflag() + "");
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("Reason:\"" + Tool.jsSpecialChars(getReason()) + "\"");
        row.add("Submitflag:\"" + getSubmitflag() + "\"");
        row.add("Printcode:\"" + Tool.jsSpecialChars(getPrintcode()) + "\"");
        row.add("Sno:\"" + Tool.jsSpecialChars(getSno()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("Rownumstr:\"" + Tool.jsSpecialChars(getRownumstr()) + "\"");
        row.add("Value1:\"" + Tool.jsSpecialChars(getValue1()) + "\"");
        row.add("Value2:\"" + Tool.jsSpecialChars(getValue2()) + "\"");
        row.add("Value3:\"" + Tool.jsSpecialChars(getValue3()) + "\"");
        row.add("Value4:\"" + Tool.jsSpecialChars(getValue4()) + "\"");
        row.add("Value5:\"" + Tool.jsSpecialChars(getValue5()) + "\"");
        row.add("Listarray1:\"" + Tool.jsSpecialChars(getListarray1()) + "\"");
        row.add("Listarray2:\"" + Tool.jsSpecialChars(getListarray2()) + "\"");
        row.add("Listarray3:\"" + Tool.jsSpecialChars(getListarray3()) + "\"");
        row.add("Listarray4:\"" + Tool.jsSpecialChars(getListarray4()) + "\"");
        row.add("Listarray5:\"" + Tool.jsSpecialChars(getListarray5()) + "\"");
        row.add("Listarray6:\"" + Tool.jsSpecialChars(getListarray6()) + "\"");
        row.add("Listarray7:\"" + Tool.jsSpecialChars(getListarray7()) + "\"");
        row.add("Listarray8:\"" + Tool.jsSpecialChars(getListarray8()) + "\"");
        row.add("Listarray9:\"" + Tool.jsSpecialChars(getListarray9()) + "\"");
        row.add("Listarray10:\"" + Tool.jsSpecialChars(getListarray10()) + "\"");
        row.add("Checkflag:\"" + getCheckflag() + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,reason varchar2(255),submitflag number(*,0),printcode varchar2(20),sno varchar2(20),academy varchar2(45),rownumstr varchar2(255),value1 varchar2(45),value2 varchar2(45),value3 varchar2(45),value4 varchar2(45),value5 varchar2(45),listarray1 varchar2(255),listarray2 varchar2(255),listarray3 varchar2(255),listarray4 varchar2(255),listarray5 varchar2(255),listarray6 varchar2(255),listarray7 varchar2(255),listarray8 varchar2(255),listarray9 varchar2(255),listarray10 varchar2(255),checkflag number(*,0))"});
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
        StudentsRzd v = new StudentsRzd(sourceDb, sourceTb);
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
        StudentsRzd v = new StudentsRzd(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(StudentsRzd obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getReason().compareTo(obj.getReason()); if (rtn != 0) return rtn;
        rtn = ("" + getSubmitflag()).compareTo("" + obj.getSubmitflag()); if (rtn != 0) return rtn;
        rtn = getPrintcode().compareTo(obj.getPrintcode()); if (rtn != 0) return rtn;
        rtn = getSno().compareTo(obj.getSno()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getRownumstr().compareTo(obj.getRownumstr()); if (rtn != 0) return rtn;
        rtn = getValue1().compareTo(obj.getValue1()); if (rtn != 0) return rtn;
        rtn = getValue2().compareTo(obj.getValue2()); if (rtn != 0) return rtn;
        rtn = getValue3().compareTo(obj.getValue3()); if (rtn != 0) return rtn;
        rtn = getValue4().compareTo(obj.getValue4()); if (rtn != 0) return rtn;
        rtn = getValue5().compareTo(obj.getValue5()); if (rtn != 0) return rtn;
        rtn = getListarray1().compareTo(obj.getListarray1()); if (rtn != 0) return rtn;
        rtn = getListarray2().compareTo(obj.getListarray2()); if (rtn != 0) return rtn;
        rtn = getListarray3().compareTo(obj.getListarray3()); if (rtn != 0) return rtn;
        rtn = getListarray4().compareTo(obj.getListarray4()); if (rtn != 0) return rtn;
        rtn = getListarray5().compareTo(obj.getListarray5()); if (rtn != 0) return rtn;
        rtn = getListarray6().compareTo(obj.getListarray6()); if (rtn != 0) return rtn;
        rtn = getListarray7().compareTo(obj.getListarray7()); if (rtn != 0) return rtn;
        rtn = getListarray8().compareTo(obj.getListarray8()); if (rtn != 0) return rtn;
        rtn = getListarray9().compareTo(obj.getListarray9()); if (rtn != 0) return rtn;
        rtn = getListarray10().compareTo(obj.getListarray10()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckflag()).compareTo("" + obj.getCheckflag()); if (rtn != 0) return rtn;
        return rtn;
    }
}
