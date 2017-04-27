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
@Description("山大志库")
public class VolunteerZhikuDeclare implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(VolunteerZhikuDeclare.class);
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
    public static final String DbTableName = "volunteer_zhiku_declare";
    private String TNAME = "volunteer_zhiku_declare";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","zhikuId","addAccount","addtime","academy","checkflag","addfilelist","name","teamname","unit","type","intention","arrange","process","expectresults","results","cost1","cost2","cost3","cost4","cost5","cost6","totalcost"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","zhikuid","addaccount","addtime","academy","checkflag","addfilelist","name","teamname","unit","type","intention","arrange","process","expectresults","results","cost1","cost2","cost3","cost4","cost5","cost6","totalcost"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"ZhikuId","zhikuid","int"},{"AddAccount","addaccount","String"},{"Addtime","addtime","java.util.Date"},{"Academy","academy","String"},{"Checkflag","checkflag","int"},{"Addfilelist","addfilelist","String"},{"Name","name","String"},{"Teamname","teamname","String"},{"Unit","unit","String"},{"Type","type","String"},{"Intention","intention","String"},{"Arrange","arrange","String"},{"Process","process","String"},{"Expectresults","expectresults","String"},{"Results","results","String"},{"Cost1","cost1","String"},{"Cost2","cost2","String"},{"Cost3","cost3","String"},{"Cost4","cost4","String"},{"Cost5","cost5","String"},{"Cost6","cost6","String"},{"Totalcost","totalcost","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"zhikuId","zhikuid"},{"addAccount","addaccount"},{"addtime","addtime"},{"academy","academy"},{"checkflag","checkflag"},{"addfilelist","addfilelist"},{"name","name"},{"teamname","teamname"},{"unit","unit"},{"type","type"},{"intention","intention"},{"arrange","arrange"},{"process","process"},{"expectresults","expectresults"},{"results","results"},{"cost1","cost1"},{"cost2","cost2"},{"cost3","cost3"},{"cost4","cost4"},{"cost5","cost5"},{"cost6","cost6"},{"totalcost","totalcost"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME"};
    public String[] getDateFields () {return _dateFields;};
    // id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 志库通知的id
    protected int zhikuId = -1;
    public int getZhikuId() { return zhikuId; }
    public void setZhikuId(int aZhikuId) { zhikuId = aZhikuId; modifiedFields.add("ZhikuId"); }
    public void assignZhikuId(int aZhikuId) { zhikuId = aZhikuId; }
    public void paramZhikuId(HttpServletRequest request) { paramZhikuId(request, "ZhikuId"); }
    public void paramZhikuId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getZhikuId()); if (tmp != getZhikuId()) { setZhikuId(tmp); } }
    // 添加账号
    protected String addAccount = "";
    public String getAddAccount() {  return SqlTool.getDbString(addAccount);  }
    public String getAddAccount(int size) { return SqlTool.subString(getAddAccount(), size); }
    public void setAddAccount(String aAddAccount) { addAccount = aAddAccount; modifiedFields.add("AddAccount"); }
    public void assignAddAccount(String aAddAccount) { addAccount = aAddAccount; }
    public void paramAddAccount(HttpServletRequest request) { paramAddAccount(request, "AddAccount"); }
    public void paramAddAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddAccount()); if (!tmp.equals(getAddAccount())) { setAddAccount(tmp); } }
    // 添加时间
    protected java.util.Date addtime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddtime() { return addtime; }
    public void setAddtime(java.util.Date aAddtime) { addtime = aAddtime; modifiedFields.add("Addtime"); }
    public void assignAddtime(java.util.Date aAddtime) { addtime = aAddtime; }
    public void paramAddtime(HttpServletRequest request) { paramAddtime(request, "Addtime"); }
    public void paramAddtime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddtime()); if (tmp.compareTo(getAddtime()) != 0) { setAddtime(tmp); } }
    // 学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 审核标志
    protected int checkflag = -1;
    public int getCheckflag() { return checkflag; }
    public void setCheckflag(int aCheckflag) { checkflag = aCheckflag; modifiedFields.add("Checkflag"); }
    public void assignCheckflag(int aCheckflag) { checkflag = aCheckflag; }
    public void paramCheckflag(HttpServletRequest request) { paramCheckflag(request, "Checkflag"); }
    public void paramCheckflag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckflag()); if (tmp != getCheckflag()) { setCheckflag(tmp); } }
    // 上传文件
    protected String addfilelist = "";
    public String getAddfilelist() {  return SqlTool.getDbString(addfilelist);  }
    public String getAddfilelist(int size) { return SqlTool.subString(getAddfilelist(), size); }
    public void setAddfilelist(String aAddfilelist) { addfilelist = aAddfilelist; modifiedFields.add("Addfilelist"); }
    public void assignAddfilelist(String aAddfilelist) { addfilelist = aAddfilelist; }
    public void paramAddfilelist(HttpServletRequest request) { paramAddfilelist(request, "Addfilelist"); }
    public void paramAddfilelist(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddfilelist()); if (!tmp.equals(getAddfilelist())) { setAddfilelist(tmp); } }
    // 项目名称
    protected String name = "";
    public String getName() {  return SqlTool.getDbString(name);  }
    public String getName(int size) { return SqlTool.subString(getName(), size); }
    public void setName(String aName) { name = aName; modifiedFields.add("Name"); }
    public void assignName(String aName) { name = aName; }
    public void paramName(HttpServletRequest request) { paramName(request, "Name"); }
    public void paramName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getName()); if (!tmp.equals(getName())) { setName(tmp); } }
    // 团队名称
    protected String teamname = "";
    public String getTeamname() {  return SqlTool.getDbString(teamname);  }
    public String getTeamname(int size) { return SqlTool.subString(getTeamname(), size); }
    public void setTeamname(String aTeamname) { teamname = aTeamname; modifiedFields.add("Teamname"); }
    public void assignTeamname(String aTeamname) { teamname = aTeamname; }
    public void paramTeamname(HttpServletRequest request) { paramTeamname(request, "Teamname"); }
    public void paramTeamname(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeamname()); if (!tmp.equals(getTeamname())) { setTeamname(tmp); } }
    // 学院
    protected String unit = "";
    public String getUnit() {  return SqlTool.getDbString(unit);  }
    public String getUnit(int size) { return SqlTool.subString(getUnit(), size); }
    public void setUnit(String aUnit) { unit = aUnit; modifiedFields.add("Unit"); }
    public void assignUnit(String aUnit) { unit = aUnit; }
    public void paramUnit(HttpServletRequest request) { paramUnit(request, "Unit"); }
    public void paramUnit(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUnit()); if (!tmp.equals(getUnit())) { setUnit(tmp); } }
    // 项目分组
    protected String type = "";
    public String getType() {  return SqlTool.getDbString(type);  }
    public String getType(int size) { return SqlTool.subString(getType(), size); }
    public void setType(String aType) { type = aType; modifiedFields.add("Type"); }
    public void assignType(String aType) { type = aType; }
    public void paramType(HttpServletRequest request) { paramType(request, "Type"); }
    public void paramType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getType()); if (!tmp.equals(getType())) { setType(tmp); } }
    // 项目活动背景及目的
    protected String intention = "";
    public String getIntention() {  return SqlTool.getDbString(intention);  }
    public String getIntention(int size) { return SqlTool.subString(getIntention(), size); }
    public void setIntention(String aIntention) { intention = aIntention; modifiedFields.add("Intention"); }
    public void assignIntention(String aIntention) { intention = aIntention; }
    public void paramIntention(HttpServletRequest request) { paramIntention(request, "Intention"); }
    public void paramIntention(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIntention()); if (!tmp.equals(getIntention())) { setIntention(tmp); } }
    // 活动流程
    protected String arrange = "";
    public String getArrange() {  return SqlTool.getDbString(arrange);  }
    public String getArrange(int size) { return SqlTool.subString(getArrange(), size); }
    public void setArrange(String aArrange) { arrange = aArrange; modifiedFields.add("Arrange"); }
    public void assignArrange(String aArrange) { arrange = aArrange; }
    public void paramArrange(HttpServletRequest request) { paramArrange(request, "Arrange"); }
    public void paramArrange(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getArrange()); if (!tmp.equals(getArrange())) { setArrange(tmp); } }
    // 预期成果
    protected String process = "";
    public String getProcess() {  return SqlTool.getDbString(process);  }
    public String getProcess(int size) { return SqlTool.subString(getProcess(), size); }
    public void setProcess(String aProcess) { process = aProcess; modifiedFields.add("Process"); }
    public void assignProcess(String aProcess) { process = aProcess; }
    public void paramProcess(HttpServletRequest request) { paramProcess(request, "Process"); }
    public void paramProcess(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProcess()); if (!tmp.equals(getProcess())) { setProcess(tmp); } }
    // 预期成果
    protected String expectresults = "";
    public String getExpectresults() {  return SqlTool.getDbString(expectresults);  }
    public String getExpectresults(int size) { return SqlTool.subString(getExpectresults(), size); }
    public void setExpectresults(String aExpectresults) { expectresults = aExpectresults; modifiedFields.add("Expectresults"); }
    public void assignExpectresults(String aExpectresults) { expectresults = aExpectresults; }
    public void paramExpectresults(HttpServletRequest request) { paramExpectresults(request, "Expectresults"); }
    public void paramExpectresults(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getExpectresults()); if (!tmp.equals(getExpectresults())) { setExpectresults(tmp); } }
    // 已取得成果
    protected String results = "";
    public String getResults() {  return SqlTool.getDbString(results);  }
    public String getResults(int size) { return SqlTool.subString(getResults(), size); }
    public void setResults(String aResults) { results = aResults; modifiedFields.add("Results"); }
    public void assignResults(String aResults) { results = aResults; }
    public void paramResults(HttpServletRequest request) { paramResults(request, "Results"); }
    public void paramResults(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getResults()); if (!tmp.equals(getResults())) { setResults(tmp); } }
    // （项目情况）交通费
    protected String cost1 = "";
    public String getCost1() {  return SqlTool.getDbString(cost1);  }
    public String getCost1(int size) { return SqlTool.subString(getCost1(), size); }
    public void setCost1(String aCost1) { cost1 = aCost1; modifiedFields.add("Cost1"); }
    public void assignCost1(String aCost1) { cost1 = aCost1; }
    public void paramCost1(HttpServletRequest request) { paramCost1(request, "Cost1"); }
    public void paramCost1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCost1()); if (!tmp.equals(getCost1())) { setCost1(tmp); } }
    // （项目情况）住宿费
    protected String cost2 = "";
    public String getCost2() {  return SqlTool.getDbString(cost2);  }
    public String getCost2(int size) { return SqlTool.subString(getCost2(), size); }
    public void setCost2(String aCost2) { cost2 = aCost2; modifiedFields.add("Cost2"); }
    public void assignCost2(String aCost2) { cost2 = aCost2; }
    public void paramCost2(HttpServletRequest request) { paramCost2(request, "Cost2"); }
    public void paramCost2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCost2()); if (!tmp.equals(getCost2())) { setCost2(tmp); } }
    // （项目情况）其他1
    protected String cost3 = "";
    public String getCost3() {  return SqlTool.getDbString(cost3);  }
    public String getCost3(int size) { return SqlTool.subString(getCost3(), size); }
    public void setCost3(String aCost3) { cost3 = aCost3; modifiedFields.add("Cost3"); }
    public void assignCost3(String aCost3) { cost3 = aCost3; }
    public void paramCost3(HttpServletRequest request) { paramCost3(request, "Cost3"); }
    public void paramCost3(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCost3()); if (!tmp.equals(getCost3())) { setCost3(tmp); } }
    // （项目情况）其他2
    protected String cost4 = "";
    public String getCost4() {  return SqlTool.getDbString(cost4);  }
    public String getCost4(int size) { return SqlTool.subString(getCost4(), size); }
    public void setCost4(String aCost4) { cost4 = aCost4; modifiedFields.add("Cost4"); }
    public void assignCost4(String aCost4) { cost4 = aCost4; }
    public void paramCost4(HttpServletRequest request) { paramCost4(request, "Cost4"); }
    public void paramCost4(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCost4()); if (!tmp.equals(getCost4())) { setCost4(tmp); } }
    // （项目情况）其他3
    protected String cost5 = "";
    public String getCost5() {  return SqlTool.getDbString(cost5);  }
    public String getCost5(int size) { return SqlTool.subString(getCost5(), size); }
    public void setCost5(String aCost5) { cost5 = aCost5; modifiedFields.add("Cost5"); }
    public void assignCost5(String aCost5) { cost5 = aCost5; }
    public void paramCost5(HttpServletRequest request) { paramCost5(request, "Cost5"); }
    public void paramCost5(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCost5()); if (!tmp.equals(getCost5())) { setCost5(tmp); } }
    // （项目情况）其他4
    protected String cost6 = "";
    public String getCost6() {  return SqlTool.getDbString(cost6);  }
    public String getCost6(int size) { return SqlTool.subString(getCost6(), size); }
    public void setCost6(String aCost6) { cost6 = aCost6; modifiedFields.add("Cost6"); }
    public void assignCost6(String aCost6) { cost6 = aCost6; }
    public void paramCost6(HttpServletRequest request) { paramCost6(request, "Cost6"); }
    public void paramCost6(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCost6()); if (!tmp.equals(getCost6())) { setCost6(tmp); } }
    // （项目情况）总计
    protected String totalcost = "";
    public String getTotalcost() {  return SqlTool.getDbString(totalcost);  }
    public String getTotalcost(int size) { return SqlTool.subString(getTotalcost(), size); }
    public void setTotalcost(String aTotalcost) { totalcost = aTotalcost; modifiedFields.add("Totalcost"); }
    public void assignTotalcost(String aTotalcost) { totalcost = aTotalcost; }
    public void paramTotalcost(HttpServletRequest request) { paramTotalcost(request, "Totalcost"); }
    public void paramTotalcost(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTotalcost()); if (!tmp.equals(getTotalcost())) { setTotalcost(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public VolunteerZhikuDeclare (String db) {
        DBNAME = db;
    }
    public VolunteerZhikuDeclare (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public VolunteerZhikuDeclare (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public VolunteerZhikuDeclare () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return VolunteerZhikuDeclare类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public VolunteerZhikuDeclare getByParameter(HttpServletRequest request) {
        VolunteerZhikuDeclare v = new VolunteerZhikuDeclare(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramZhikuId(request);
        paramAddAccount(request);
        paramAddtime(request);
        paramAcademy(request);
        paramCheckflag(request);
        paramAddfilelist(request);
        paramName(request);
        paramTeamname(request);
        paramUnit(request);
        paramType(request);
        paramIntention(request);
        paramArrange(request);
        paramProcess(request);
        paramExpectresults(request);
        paramResults(request);
        paramCost1(request);
        paramCost2(request);
        paramCost3(request);
        paramCost4(request);
        paramCost5(request);
        paramCost6(request);
        paramTotalcost(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(VolunteerZhikuDeclare bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("zhikuId")) { setZhikuId(bean.getZhikuId()); }
        if (!ncl.contains("addAccount")) { setAddAccount(bean.getAddAccount()); }
        if (!ncl.contains("addtime")) { setAddtime(bean.getAddtime()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("checkflag")) { setCheckflag(bean.getCheckflag()); }
        if (!ncl.contains("addfilelist")) { setAddfilelist(bean.getAddfilelist()); }
        if (!ncl.contains("name")) { setName(bean.getName()); }
        if (!ncl.contains("teamname")) { setTeamname(bean.getTeamname()); }
        if (!ncl.contains("unit")) { setUnit(bean.getUnit()); }
        if (!ncl.contains("type")) { setType(bean.getType()); }
        if (!ncl.contains("intention")) { setIntention(bean.getIntention()); }
        if (!ncl.contains("arrange")) { setArrange(bean.getArrange()); }
        if (!ncl.contains("process")) { setProcess(bean.getProcess()); }
        if (!ncl.contains("expectresults")) { setExpectresults(bean.getExpectresults()); }
        if (!ncl.contains("results")) { setResults(bean.getResults()); }
        if (!ncl.contains("cost1")) { setCost1(bean.getCost1()); }
        if (!ncl.contains("cost2")) { setCost2(bean.getCost2()); }
        if (!ncl.contains("cost3")) { setCost3(bean.getCost3()); }
        if (!ncl.contains("cost4")) { setCost4(bean.getCost4()); }
        if (!ncl.contains("cost5")) { setCost5(bean.getCost5()); }
        if (!ncl.contains("cost6")) { setCost6(bean.getCost6()); }
        if (!ncl.contains("totalcost")) { setTotalcost(bean.getTotalcost()); }
    }
    public VolunteerZhikuDeclare getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        VolunteerZhikuDeclare[] rslt= queryByCondition(cdt);
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
     * @return VolunteerZhikuDeclare类的实例列表。
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
                VolunteerZhikuDeclare ve = new VolunteerZhikuDeclare(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignZhikuId(rs.getInt(2));
                ve.assignAddAccount(fromDbCh(rs.getString(3)));
                tmpDate = rs.getTimestamp(4); if (tmpDate != null) { ve.assignAddtime(new java.util.Date(tmpDate.getTime())); }
                ve.assignAcademy(fromDbCh(rs.getString(5)));
                ve.assignCheckflag(rs.getInt(6));
                ve.assignAddfilelist(fromDbCh(rs.getString(7)));
                ve.assignName(fromDbCh(rs.getString(8)));
                ve.assignTeamname(fromDbCh(rs.getString(9)));
                ve.assignUnit(fromDbCh(rs.getString(10)));
                ve.assignType(fromDbCh(rs.getString(11)));
                ve.assignIntention(fromDbCh(rs.getString(12)));
                ve.assignArrange(fromDbCh(rs.getString(13)));
                ve.assignProcess(fromDbCh(rs.getString(14)));
                ve.assignExpectresults(fromDbCh(rs.getString(15)));
                ve.assignResults(fromDbCh(rs.getString(16)));
                ve.assignCost1(fromDbCh(rs.getString(17)));
                ve.assignCost2(fromDbCh(rs.getString(18)));
                ve.assignCost3(fromDbCh(rs.getString(19)));
                ve.assignCost4(fromDbCh(rs.getString(20)));
                ve.assignCost5(fromDbCh(rs.getString(21)));
                ve.assignCost6(fromDbCh(rs.getString(22)));
                ve.assignTotalcost(fromDbCh(rs.getString(23)));
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
    public VolunteerZhikuDeclare[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (VolunteerZhikuDeclare[])vrs.toArray(new VolunteerZhikuDeclare[vrs.size()]);
    }
    public VolunteerZhikuDeclare[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (VolunteerZhikuDeclare[])vrs.toArray(new VolunteerZhikuDeclare[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (zhikuid,addaccount,addtime,academy,checkflag,addfilelist,name,teamname,unit,type,intention,arrange,process,expectresults,results,cost1,cost2,cost3,cost4,cost5,cost6,totalcost) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, zhikuId);
            pstmt.setString(2, toDbCh(addAccount));
            pstmt.setTimestamp(3, new java.sql.Timestamp(addtime.getTime()));
            pstmt.setString(4, toDbCh(academy));
            pstmt.setInt(5, checkflag);
            pstmt.setString(6, toDbCh(addfilelist));
            pstmt.setString(7, toDbCh(name));
            pstmt.setString(8, toDbCh(teamname));
            pstmt.setString(9, toDbCh(unit));
            pstmt.setString(10, toDbCh(type));
            pstmt.setString(11, toDbCh(intention));
            pstmt.setString(12, toDbCh(arrange));
            pstmt.setString(13, toDbCh(process));
            pstmt.setString(14, toDbCh(expectresults));
            pstmt.setString(15, toDbCh(results));
            pstmt.setString(16, toDbCh(cost1));
            pstmt.setString(17, toDbCh(cost2));
            pstmt.setString(18, toDbCh(cost3));
            pstmt.setString(19, toDbCh(cost4));
            pstmt.setString(20, toDbCh(cost5));
            pstmt.setString(21, toDbCh(cost6));
            pstmt.setString(22, toDbCh(totalcost));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,zhikuid,addaccount,addtime,academy,checkflag,addfilelist,name,teamname,unit,type,intention,arrange,process,expectresults,results,cost1,cost2,cost3,cost4,cost5,cost6,totalcost) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, zhikuId);
            pstmt.setString(3, toDbCh(addAccount));
            pstmt.setTimestamp(4, new java.sql.Timestamp(addtime.getTime()));
            pstmt.setString(5, toDbCh(academy));
            pstmt.setInt(6, checkflag);
            pstmt.setString(7, toDbCh(addfilelist));
            pstmt.setString(8, toDbCh(name));
            pstmt.setString(9, toDbCh(teamname));
            pstmt.setString(10, toDbCh(unit));
            pstmt.setString(11, toDbCh(type));
            pstmt.setString(12, toDbCh(intention));
            pstmt.setString(13, toDbCh(arrange));
            pstmt.setString(14, toDbCh(process));
            pstmt.setString(15, toDbCh(expectresults));
            pstmt.setString(16, toDbCh(results));
            pstmt.setString(17, toDbCh(cost1));
            pstmt.setString(18, toDbCh(cost2));
            pstmt.setString(19, toDbCh(cost3));
            pstmt.setString(20, toDbCh(cost4));
            pstmt.setString(21, toDbCh(cost5));
            pstmt.setString(22, toDbCh(cost6));
            pstmt.setString(23, toDbCh(totalcost));
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
            VolunteerZhikuDeclare item = (VolunteerZhikuDeclare)it.next();
            VolunteerZhikuDeclare v = new VolunteerZhikuDeclare(dbname);
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
                if (modifiedFields.contains("ZhikuId")) { pstmt.setInt(pi ++, zhikuId); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addtime.getTime())); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Checkflag")) { pstmt.setInt(pi ++, checkflag); }
                if (modifiedFields.contains("Addfilelist")) { pstmt.setString(pi ++, toDbCh(addfilelist)); }
                if (modifiedFields.contains("Name")) { pstmt.setString(pi ++, toDbCh(name)); }
                if (modifiedFields.contains("Teamname")) { pstmt.setString(pi ++, toDbCh(teamname)); }
                if (modifiedFields.contains("Unit")) { pstmt.setString(pi ++, toDbCh(unit)); }
                if (modifiedFields.contains("Type")) { pstmt.setString(pi ++, toDbCh(type)); }
                if (modifiedFields.contains("Intention")) { pstmt.setString(pi ++, toDbCh(intention)); }
                if (modifiedFields.contains("Arrange")) { pstmt.setString(pi ++, toDbCh(arrange)); }
                if (modifiedFields.contains("Process")) { pstmt.setString(pi ++, toDbCh(process)); }
                if (modifiedFields.contains("Expectresults")) { pstmt.setString(pi ++, toDbCh(expectresults)); }
                if (modifiedFields.contains("Results")) { pstmt.setString(pi ++, toDbCh(results)); }
                if (modifiedFields.contains("Cost1")) { pstmt.setString(pi ++, toDbCh(cost1)); }
                if (modifiedFields.contains("Cost2")) { pstmt.setString(pi ++, toDbCh(cost2)); }
                if (modifiedFields.contains("Cost3")) { pstmt.setString(pi ++, toDbCh(cost3)); }
                if (modifiedFields.contains("Cost4")) { pstmt.setString(pi ++, toDbCh(cost4)); }
                if (modifiedFields.contains("Cost5")) { pstmt.setString(pi ++, toDbCh(cost5)); }
                if (modifiedFields.contains("Cost6")) { pstmt.setString(pi ++, toDbCh(cost6)); }
                if (modifiedFields.contains("Totalcost")) { pstmt.setString(pi ++, toDbCh(totalcost)); }
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
                if (modifiedFields.contains("ZhikuId")) { pstmt.setInt(pi ++, zhikuId); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addtime.getTime())); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Checkflag")) { pstmt.setInt(pi ++, checkflag); }
                if (modifiedFields.contains("Addfilelist")) { pstmt.setString(pi ++, toDbCh(addfilelist)); }
                if (modifiedFields.contains("Name")) { pstmt.setString(pi ++, toDbCh(name)); }
                if (modifiedFields.contains("Teamname")) { pstmt.setString(pi ++, toDbCh(teamname)); }
                if (modifiedFields.contains("Unit")) { pstmt.setString(pi ++, toDbCh(unit)); }
                if (modifiedFields.contains("Type")) { pstmt.setString(pi ++, toDbCh(type)); }
                if (modifiedFields.contains("Intention")) { pstmt.setString(pi ++, toDbCh(intention)); }
                if (modifiedFields.contains("Arrange")) { pstmt.setString(pi ++, toDbCh(arrange)); }
                if (modifiedFields.contains("Process")) { pstmt.setString(pi ++, toDbCh(process)); }
                if (modifiedFields.contains("Expectresults")) { pstmt.setString(pi ++, toDbCh(expectresults)); }
                if (modifiedFields.contains("Results")) { pstmt.setString(pi ++, toDbCh(results)); }
                if (modifiedFields.contains("Cost1")) { pstmt.setString(pi ++, toDbCh(cost1)); }
                if (modifiedFields.contains("Cost2")) { pstmt.setString(pi ++, toDbCh(cost2)); }
                if (modifiedFields.contains("Cost3")) { pstmt.setString(pi ++, toDbCh(cost3)); }
                if (modifiedFields.contains("Cost4")) { pstmt.setString(pi ++, toDbCh(cost4)); }
                if (modifiedFields.contains("Cost5")) { pstmt.setString(pi ++, toDbCh(cost5)); }
                if (modifiedFields.contains("Cost6")) { pstmt.setString(pi ++, toDbCh(cost6)); }
                if (modifiedFields.contains("Totalcost")) { pstmt.setString(pi ++, toDbCh(totalcost)); }
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
        map.put("ZhikuId", getZhikuId() + "");
        map.put("AddAccount", getAddAccount());
        map.put("Addtime", Tool.stringOfDateTime(getAddtime()));
        map.put("Academy", getAcademy());
        map.put("Checkflag", getCheckflag() + "");
        map.put("Addfilelist", getAddfilelist());
        map.put("Name", getName());
        map.put("Teamname", getTeamname());
        map.put("Unit", getUnit());
        map.put("Type", getType());
        map.put("Intention", getIntention());
        map.put("Arrange", getArrange());
        map.put("Process", getProcess());
        map.put("Expectresults", getExpectresults());
        map.put("Results", getResults());
        map.put("Cost1", getCost1());
        map.put("Cost2", getCost2());
        map.put("Cost3", getCost3());
        map.put("Cost4", getCost4());
        map.put("Cost5", getCost5());
        map.put("Cost6", getCost6());
        map.put("Totalcost", getTotalcost());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("ZhikuId:\"" + getZhikuId() + "\"");
        row.add("AddAccount:\"" + Tool.jsSpecialChars(getAddAccount()) + "\"");
        row.add("Addtime:\"" + Tool.stringOfDateTime(getAddtime()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("Checkflag:\"" + getCheckflag() + "\"");
        row.add("Addfilelist:\"" + Tool.jsSpecialChars(getAddfilelist()) + "\"");
        row.add("Name:\"" + Tool.jsSpecialChars(getName()) + "\"");
        row.add("Teamname:\"" + Tool.jsSpecialChars(getTeamname()) + "\"");
        row.add("Unit:\"" + Tool.jsSpecialChars(getUnit()) + "\"");
        row.add("Type:\"" + Tool.jsSpecialChars(getType()) + "\"");
        row.add("Intention:\"" + Tool.jsSpecialChars(getIntention()) + "\"");
        row.add("Arrange:\"" + Tool.jsSpecialChars(getArrange()) + "\"");
        row.add("Process:\"" + Tool.jsSpecialChars(getProcess()) + "\"");
        row.add("Expectresults:\"" + Tool.jsSpecialChars(getExpectresults()) + "\"");
        row.add("Results:\"" + Tool.jsSpecialChars(getResults()) + "\"");
        row.add("Cost1:\"" + Tool.jsSpecialChars(getCost1()) + "\"");
        row.add("Cost2:\"" + Tool.jsSpecialChars(getCost2()) + "\"");
        row.add("Cost3:\"" + Tool.jsSpecialChars(getCost3()) + "\"");
        row.add("Cost4:\"" + Tool.jsSpecialChars(getCost4()) + "\"");
        row.add("Cost5:\"" + Tool.jsSpecialChars(getCost5()) + "\"");
        row.add("Cost6:\"" + Tool.jsSpecialChars(getCost6()) + "\"");
        row.add("Totalcost:\"" + Tool.jsSpecialChars(getTotalcost()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,zhikuid number(*,0),addaccount varchar2(20),addtime date,academy varchar2(45),checkflag number(*,0),addfilelist varchar2(500),name varchar2(45),teamname varchar2(45),unit varchar2(45),type varchar2(45),intention varchar2(500),arrange varchar2(500),process varchar2(500),expectresults varchar2(500),results varchar2(500),cost1 varchar2(45),cost2 varchar2(45),cost3 varchar2(45),cost4 varchar2(45),cost5 varchar2(45),cost6 varchar2(45),totalcost varchar2(45))"});
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
        VolunteerZhikuDeclare v = new VolunteerZhikuDeclare(sourceDb, sourceTb);
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
        VolunteerZhikuDeclare v = new VolunteerZhikuDeclare(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(VolunteerZhikuDeclare obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getZhikuId()).compareTo("" + obj.getZhikuId()); if (rtn != 0) return rtn;
        rtn = getAddAccount().compareTo(obj.getAddAccount()); if (rtn != 0) return rtn;
        rtn = getAddtime().compareTo(obj.getAddtime()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckflag()).compareTo("" + obj.getCheckflag()); if (rtn != 0) return rtn;
        rtn = getAddfilelist().compareTo(obj.getAddfilelist()); if (rtn != 0) return rtn;
        rtn = getName().compareTo(obj.getName()); if (rtn != 0) return rtn;
        rtn = getTeamname().compareTo(obj.getTeamname()); if (rtn != 0) return rtn;
        rtn = getUnit().compareTo(obj.getUnit()); if (rtn != 0) return rtn;
        rtn = getType().compareTo(obj.getType()); if (rtn != 0) return rtn;
        rtn = getIntention().compareTo(obj.getIntention()); if (rtn != 0) return rtn;
        rtn = getArrange().compareTo(obj.getArrange()); if (rtn != 0) return rtn;
        rtn = getProcess().compareTo(obj.getProcess()); if (rtn != 0) return rtn;
        rtn = getExpectresults().compareTo(obj.getExpectresults()); if (rtn != 0) return rtn;
        rtn = getResults().compareTo(obj.getResults()); if (rtn != 0) return rtn;
        rtn = getCost1().compareTo(obj.getCost1()); if (rtn != 0) return rtn;
        rtn = getCost2().compareTo(obj.getCost2()); if (rtn != 0) return rtn;
        rtn = getCost3().compareTo(obj.getCost3()); if (rtn != 0) return rtn;
        rtn = getCost4().compareTo(obj.getCost4()); if (rtn != 0) return rtn;
        rtn = getCost5().compareTo(obj.getCost5()); if (rtn != 0) return rtn;
        rtn = getCost6().compareTo(obj.getCost6()); if (rtn != 0) return rtn;
        rtn = getTotalcost().compareTo(obj.getTotalcost()); if (rtn != 0) return rtn;
        return rtn;
    }
}
