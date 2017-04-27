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
@Description("社会实践项目团委立项表")
public class Practice implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(Practice.class);
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
    public static final String DbTableName = "practice";
    private String TNAME = "practice";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","practiceCode","practiceName","practiceSubject","starttime","endtime","funding","teamDemand","schedule","workDemand","otherExplain","addtime","addAccount","addUserrole","addAcademy","addFilelist","remark","remark2","remark3","remark4","remark5","remark6"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","practicecode","practicename","practicesubject","starttime","endtime","funding","teamdemand","schedule","workdemand","otherexplain","addtime","addaccount","adduserrole","addacademy","addfilelist","remark","remark2","remark3","remark4","remark5","remark6"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"PracticeCode","practicecode","String"},{"PracticeName","practicename","String"},{"PracticeSubject","practicesubject","String"},{"Starttime","starttime","String"},{"Endtime","endtime","String"},{"Funding","funding","String"},{"TeamDemand","teamdemand","String"},{"Schedule","schedule","String"},{"WorkDemand","workdemand","String"},{"OtherExplain","otherexplain","String"},{"Addtime","addtime","String"},{"AddAccount","addaccount","String"},{"AddUserrole","adduserrole","String"},{"AddAcademy","addacademy","String"},{"AddFilelist","addfilelist","String"},{"Remark","remark","String"},{"Remark2","remark2","String"},{"Remark3","remark3","String"},{"Remark4","remark4","String"},{"Remark5","remark5","String"},{"Remark6","remark6","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"practiceCode","practicecode"},{"practiceName","practicename"},{"practiceSubject","practicesubject"},{"starttime","starttime"},{"endtime","endtime"},{"funding","funding"},{"teamDemand","teamdemand"},{"schedule","schedule"},{"workDemand","workdemand"},{"otherExplain","otherexplain"},{"addtime","addtime"},{"addAccount","addaccount"},{"addUserrole","adduserrole"},{"addAcademy","addacademy"},{"addFilelist","addfilelist"},{"remark","remark"},{"remark2","remark2"},{"remark3","remark3"},{"remark4","remark4"},{"remark5","remark5"},{"remark6","remark6"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {};
    public String[] getDateFields () {return _dateFields;};
    // id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 项目编码
    protected String practiceCode = "";
    public String getPracticeCode() {  return SqlTool.getDbString(practiceCode);  }
    public String getPracticeCode(int size) { return SqlTool.subString(getPracticeCode(), size); }
    public void setPracticeCode(String aPracticeCode) { practiceCode = aPracticeCode; modifiedFields.add("PracticeCode"); }
    public void assignPracticeCode(String aPracticeCode) { practiceCode = aPracticeCode; }
    public void paramPracticeCode(HttpServletRequest request) { paramPracticeCode(request, "PracticeCode"); }
    public void paramPracticeCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPracticeCode()); if (!tmp.equals(getPracticeCode())) { setPracticeCode(tmp); } }
    // 项目名
    protected String practiceName = "";
    public String getPracticeName() {  return SqlTool.getDbString(practiceName);  }
    public String getPracticeName(int size) { return SqlTool.subString(getPracticeName(), size); }
    public void setPracticeName(String aPracticeName) { practiceName = aPracticeName; modifiedFields.add("PracticeName"); }
    public void assignPracticeName(String aPracticeName) { practiceName = aPracticeName; }
    public void paramPracticeName(HttpServletRequest request) { paramPracticeName(request, "PracticeName"); }
    public void paramPracticeName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPracticeName()); if (!tmp.equals(getPracticeName())) { setPracticeName(tmp); } }
    // 项目实践主题
    protected String practiceSubject = "";
    public String getPracticeSubject() {  return SqlTool.getDbString(practiceSubject);  }
    public String getPracticeSubject(int size) { return SqlTool.subString(getPracticeSubject(), size); }
    public void setPracticeSubject(String aPracticeSubject) { practiceSubject = aPracticeSubject; modifiedFields.add("PracticeSubject"); }
    public void assignPracticeSubject(String aPracticeSubject) { practiceSubject = aPracticeSubject; }
    public void paramPracticeSubject(HttpServletRequest request) { paramPracticeSubject(request, "PracticeSubject"); }
    public void paramPracticeSubject(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPracticeSubject()); if (!tmp.equals(getPracticeSubject())) { setPracticeSubject(tmp); } }
    // 项目开始实践
    protected String starttime = "";
    public String getStarttime() {  return SqlTool.getDbString(starttime);  }
    public String getStarttime(int size) { return SqlTool.subString(getStarttime(), size); }
    public void setStarttime(String aStarttime) { starttime = aStarttime; modifiedFields.add("Starttime"); }
    public void assignStarttime(String aStarttime) { starttime = aStarttime; }
    public void paramStarttime(HttpServletRequest request) { paramStarttime(request, "Starttime"); }
    public void paramStarttime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getStarttime()); if (!tmp.equals(getStarttime())) { setStarttime(tmp); } }
    // 项目结束时间
    protected String endtime = "";
    public String getEndtime() {  return SqlTool.getDbString(endtime);  }
    public String getEndtime(int size) { return SqlTool.subString(getEndtime(), size); }
    public void setEndtime(String aEndtime) { endtime = aEndtime; modifiedFields.add("Endtime"); }
    public void assignEndtime(String aEndtime) { endtime = aEndtime; }
    public void paramEndtime(HttpServletRequest request) { paramEndtime(request, "Endtime"); }
    public void paramEndtime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getEndtime()); if (!tmp.equals(getEndtime())) { setEndtime(tmp); } }
    // 经费资助
    protected String funding = "";
    public String getFunding() {  return SqlTool.getDbString(funding);  }
    public String getFunding(int size) { return SqlTool.subString(getFunding(), size); }
    public void setFunding(String aFunding) { funding = aFunding; modifiedFields.add("Funding"); }
    public void assignFunding(String aFunding) { funding = aFunding; }
    public void paramFunding(HttpServletRequest request) { paramFunding(request, "Funding"); }
    public void paramFunding(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFunding()); if (!tmp.equals(getFunding())) { setFunding(tmp); } }
    // 团队组织要求
    protected String teamDemand = "";
    public String getTeamDemand() {  return SqlTool.getDbString(teamDemand);  }
    public String getTeamDemand(int size) { return SqlTool.subString(getTeamDemand(), size); }
    public void setTeamDemand(String aTeamDemand) { teamDemand = aTeamDemand; modifiedFields.add("TeamDemand"); }
    public void assignTeamDemand(String aTeamDemand) { teamDemand = aTeamDemand; }
    public void paramTeamDemand(HttpServletRequest request) { paramTeamDemand(request, "TeamDemand"); }
    public void paramTeamDemand(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeamDemand()); if (!tmp.equals(getTeamDemand())) { setTeamDemand(tmp); } }
    // 立项程序及日程
    protected String schedule = "";
    public String getSchedule() {  return SqlTool.getDbString(schedule);  }
    public String getSchedule(int size) { return SqlTool.subString(getSchedule(), size); }
    public void setSchedule(String aSchedule) { schedule = aSchedule; modifiedFields.add("Schedule"); }
    public void assignSchedule(String aSchedule) { schedule = aSchedule; }
    public void paramSchedule(HttpServletRequest request) { paramSchedule(request, "Schedule"); }
    public void paramSchedule(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSchedule()); if (!tmp.equals(getSchedule())) { setSchedule(tmp); } }
    // 工作要求
    protected String workDemand = "";
    public String getWorkDemand() {  return SqlTool.getDbString(workDemand);  }
    public String getWorkDemand(int size) { return SqlTool.subString(getWorkDemand(), size); }
    public void setWorkDemand(String aWorkDemand) { workDemand = aWorkDemand; modifiedFields.add("WorkDemand"); }
    public void assignWorkDemand(String aWorkDemand) { workDemand = aWorkDemand; }
    public void paramWorkDemand(HttpServletRequest request) { paramWorkDemand(request, "WorkDemand"); }
    public void paramWorkDemand(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getWorkDemand()); if (!tmp.equals(getWorkDemand())) { setWorkDemand(tmp); } }
    // 其他说明
    protected String otherExplain = "";
    public String getOtherExplain() {  return SqlTool.getDbString(otherExplain);  }
    public String getOtherExplain(int size) { return SqlTool.subString(getOtherExplain(), size); }
    public void setOtherExplain(String aOtherExplain) { otherExplain = aOtherExplain; modifiedFields.add("OtherExplain"); }
    public void assignOtherExplain(String aOtherExplain) { otherExplain = aOtherExplain; }
    public void paramOtherExplain(HttpServletRequest request) { paramOtherExplain(request, "OtherExplain"); }
    public void paramOtherExplain(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOtherExplain()); if (!tmp.equals(getOtherExplain())) { setOtherExplain(tmp); } }
    // 项目添加时间
    protected String addtime = "";
    public String getAddtime() {  return SqlTool.getDbString(addtime);  }
    public String getAddtime(int size) { return SqlTool.subString(getAddtime(), size); }
    public void setAddtime(String aAddtime) { addtime = aAddtime; modifiedFields.add("Addtime"); }
    public void assignAddtime(String aAddtime) { addtime = aAddtime; }
    public void paramAddtime(HttpServletRequest request) { paramAddtime(request, "Addtime"); }
    public void paramAddtime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddtime()); if (!tmp.equals(getAddtime())) { setAddtime(tmp); } }
    // 添加用户名
    protected String addAccount = "";
    public String getAddAccount() {  return SqlTool.getDbString(addAccount);  }
    public String getAddAccount(int size) { return SqlTool.subString(getAddAccount(), size); }
    public void setAddAccount(String aAddAccount) { addAccount = aAddAccount; modifiedFields.add("AddAccount"); }
    public void assignAddAccount(String aAddAccount) { addAccount = aAddAccount; }
    public void paramAddAccount(HttpServletRequest request) { paramAddAccount(request, "AddAccount"); }
    public void paramAddAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddAccount()); if (!tmp.equals(getAddAccount())) { setAddAccount(tmp); } }
    // 添加用户编号
    protected String addUserrole = "";
    public String getAddUserrole() {  return SqlTool.getDbString(addUserrole);  }
    public String getAddUserrole(int size) { return SqlTool.subString(getAddUserrole(), size); }
    public void setAddUserrole(String aAddUserrole) { addUserrole = aAddUserrole; modifiedFields.add("AddUserrole"); }
    public void assignAddUserrole(String aAddUserrole) { addUserrole = aAddUserrole; }
    public void paramAddUserrole(HttpServletRequest request) { paramAddUserrole(request, "AddUserrole"); }
    public void paramAddUserrole(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddUserrole()); if (!tmp.equals(getAddUserrole())) { setAddUserrole(tmp); } }
    // 添加单位
    protected String addAcademy = "";
    public String getAddAcademy() {  return SqlTool.getDbString(addAcademy);  }
    public String getAddAcademy(int size) { return SqlTool.subString(getAddAcademy(), size); }
    public void setAddAcademy(String aAddAcademy) { addAcademy = aAddAcademy; modifiedFields.add("AddAcademy"); }
    public void assignAddAcademy(String aAddAcademy) { addAcademy = aAddAcademy; }
    public void paramAddAcademy(HttpServletRequest request) { paramAddAcademy(request, "AddAcademy"); }
    public void paramAddAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddAcademy()); if (!tmp.equals(getAddAcademy())) { setAddAcademy(tmp); } }
    // 添加文件列表
    protected String addFilelist = "";
    public String getAddFilelist() {  return SqlTool.getDbString(addFilelist);  }
    public String getAddFilelist(int size) { return SqlTool.subString(getAddFilelist(), size); }
    public void setAddFilelist(String aAddFilelist) { addFilelist = aAddFilelist; modifiedFields.add("AddFilelist"); }
    public void assignAddFilelist(String aAddFilelist) { addFilelist = aAddFilelist; }
    public void paramAddFilelist(HttpServletRequest request) { paramAddFilelist(request, "AddFilelist"); }
    public void paramAddFilelist(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddFilelist()); if (!tmp.equals(getAddFilelist())) { setAddFilelist(tmp); } }
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
    public Practice (String db) {
        DBNAME = db;
    }
    public Practice (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public Practice (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public Practice () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return Practice类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public Practice getByParameter(HttpServletRequest request) {
        Practice v = new Practice(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramPracticeCode(request);
        paramPracticeName(request);
        paramPracticeSubject(request);
        paramStarttime(request);
        paramEndtime(request);
        paramFunding(request);
        paramTeamDemand(request);
        paramSchedule(request);
        paramWorkDemand(request);
        paramOtherExplain(request);
        paramAddtime(request);
        paramAddAccount(request);
        paramAddUserrole(request);
        paramAddAcademy(request);
        paramAddFilelist(request);
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
    public void clone(Practice bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("practiceCode")) { setPracticeCode(bean.getPracticeCode()); }
        if (!ncl.contains("practiceName")) { setPracticeName(bean.getPracticeName()); }
        if (!ncl.contains("practiceSubject")) { setPracticeSubject(bean.getPracticeSubject()); }
        if (!ncl.contains("starttime")) { setStarttime(bean.getStarttime()); }
        if (!ncl.contains("endtime")) { setEndtime(bean.getEndtime()); }
        if (!ncl.contains("funding")) { setFunding(bean.getFunding()); }
        if (!ncl.contains("teamDemand")) { setTeamDemand(bean.getTeamDemand()); }
        if (!ncl.contains("schedule")) { setSchedule(bean.getSchedule()); }
        if (!ncl.contains("workDemand")) { setWorkDemand(bean.getWorkDemand()); }
        if (!ncl.contains("otherExplain")) { setOtherExplain(bean.getOtherExplain()); }
        if (!ncl.contains("addtime")) { setAddtime(bean.getAddtime()); }
        if (!ncl.contains("addAccount")) { setAddAccount(bean.getAddAccount()); }
        if (!ncl.contains("addUserrole")) { setAddUserrole(bean.getAddUserrole()); }
        if (!ncl.contains("addAcademy")) { setAddAcademy(bean.getAddAcademy()); }
        if (!ncl.contains("addFilelist")) { setAddFilelist(bean.getAddFilelist()); }
        if (!ncl.contains("remark")) { setRemark(bean.getRemark()); }
        if (!ncl.contains("remark2")) { setRemark2(bean.getRemark2()); }
        if (!ncl.contains("remark3")) { setRemark3(bean.getRemark3()); }
        if (!ncl.contains("remark4")) { setRemark4(bean.getRemark4()); }
        if (!ncl.contains("remark5")) { setRemark5(bean.getRemark5()); }
        if (!ncl.contains("remark6")) { setRemark6(bean.getRemark6()); }
    }
    public Practice getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        Practice[] rslt= queryByCondition(cdt);
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
     * @return Practice类的实例列表。
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
                Practice ve = new Practice(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignPracticeCode(fromDbCh(rs.getString(2)));
                ve.assignPracticeName(fromDbCh(rs.getString(3)));
                ve.assignPracticeSubject(fromDbCh(rs.getString(4)));
                ve.assignStarttime(fromDbCh(rs.getString(5)));
                ve.assignEndtime(fromDbCh(rs.getString(6)));
                ve.assignFunding(fromDbCh(rs.getString(7)));
                ve.assignTeamDemand(fromDbCh(rs.getString(8)));
                ve.assignSchedule(fromDbCh(rs.getString(9)));
                ve.assignWorkDemand(fromDbCh(rs.getString(10)));
                ve.assignOtherExplain(fromDbCh(rs.getString(11)));
                ve.assignAddtime(fromDbCh(rs.getString(12)));
                ve.assignAddAccount(fromDbCh(rs.getString(13)));
                ve.assignAddUserrole(fromDbCh(rs.getString(14)));
                ve.assignAddAcademy(fromDbCh(rs.getString(15)));
                ve.assignAddFilelist(fromDbCh(rs.getString(16)));
                ve.assignRemark(fromDbCh(rs.getString(17)));
                ve.assignRemark2(fromDbCh(rs.getString(18)));
                ve.assignRemark3(fromDbCh(rs.getString(19)));
                ve.assignRemark4(fromDbCh(rs.getString(20)));
                ve.assignRemark5(fromDbCh(rs.getString(21)));
                ve.assignRemark6(fromDbCh(rs.getString(22)));
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
    public Practice[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (Practice[])vrs.toArray(new Practice[vrs.size()]);
    }
    public Practice[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (Practice[])vrs.toArray(new Practice[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (practicecode,practicename,practicesubject,starttime,endtime,funding,teamdemand,schedule,workdemand,otherexplain,addtime,addaccount,adduserrole,addacademy,addfilelist,remark,remark2,remark3,remark4,remark5,remark6) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(practiceCode));
            pstmt.setString(2, toDbCh(practiceName));
            pstmt.setString(3, toDbCh(practiceSubject));
            pstmt.setString(4, toDbCh(starttime));
            pstmt.setString(5, toDbCh(endtime));
            pstmt.setString(6, toDbCh(funding));
            pstmt.setString(7, toDbCh(teamDemand));
            pstmt.setString(8, toDbCh(schedule));
            pstmt.setString(9, toDbCh(workDemand));
            pstmt.setString(10, toDbCh(otherExplain));
            pstmt.setString(11, toDbCh(addtime));
            pstmt.setString(12, toDbCh(addAccount));
            pstmt.setString(13, toDbCh(addUserrole));
            pstmt.setString(14, toDbCh(addAcademy));
            pstmt.setString(15, toDbCh(addFilelist));
            pstmt.setString(16, toDbCh(remark));
            pstmt.setString(17, toDbCh(remark2));
            pstmt.setString(18, toDbCh(remark3));
            pstmt.setString(19, toDbCh(remark4));
            pstmt.setString(20, toDbCh(remark5));
            pstmt.setString(21, toDbCh(remark6));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,practicecode,practicename,practicesubject,starttime,endtime,funding,teamdemand,schedule,workdemand,otherexplain,addtime,addaccount,adduserrole,addacademy,addfilelist,remark,remark2,remark3,remark4,remark5,remark6) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(practiceCode));
            pstmt.setString(3, toDbCh(practiceName));
            pstmt.setString(4, toDbCh(practiceSubject));
            pstmt.setString(5, toDbCh(starttime));
            pstmt.setString(6, toDbCh(endtime));
            pstmt.setString(7, toDbCh(funding));
            pstmt.setString(8, toDbCh(teamDemand));
            pstmt.setString(9, toDbCh(schedule));
            pstmt.setString(10, toDbCh(workDemand));
            pstmt.setString(11, toDbCh(otherExplain));
            pstmt.setString(12, toDbCh(addtime));
            pstmt.setString(13, toDbCh(addAccount));
            pstmt.setString(14, toDbCh(addUserrole));
            pstmt.setString(15, toDbCh(addAcademy));
            pstmt.setString(16, toDbCh(addFilelist));
            pstmt.setString(17, toDbCh(remark));
            pstmt.setString(18, toDbCh(remark2));
            pstmt.setString(19, toDbCh(remark3));
            pstmt.setString(20, toDbCh(remark4));
            pstmt.setString(21, toDbCh(remark5));
            pstmt.setString(22, toDbCh(remark6));
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
            Practice item = (Practice)it.next();
            Practice v = new Practice(dbname);
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
                if (modifiedFields.contains("PracticeCode")) { pstmt.setString(pi ++, toDbCh(practiceCode)); }
                if (modifiedFields.contains("PracticeName")) { pstmt.setString(pi ++, toDbCh(practiceName)); }
                if (modifiedFields.contains("PracticeSubject")) { pstmt.setString(pi ++, toDbCh(practiceSubject)); }
                if (modifiedFields.contains("Starttime")) { pstmt.setString(pi ++, toDbCh(starttime)); }
                if (modifiedFields.contains("Endtime")) { pstmt.setString(pi ++, toDbCh(endtime)); }
                if (modifiedFields.contains("Funding")) { pstmt.setString(pi ++, toDbCh(funding)); }
                if (modifiedFields.contains("TeamDemand")) { pstmt.setString(pi ++, toDbCh(teamDemand)); }
                if (modifiedFields.contains("Schedule")) { pstmt.setString(pi ++, toDbCh(schedule)); }
                if (modifiedFields.contains("WorkDemand")) { pstmt.setString(pi ++, toDbCh(workDemand)); }
                if (modifiedFields.contains("OtherExplain")) { pstmt.setString(pi ++, toDbCh(otherExplain)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setString(pi ++, toDbCh(addtime)); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("AddUserrole")) { pstmt.setString(pi ++, toDbCh(addUserrole)); }
                if (modifiedFields.contains("AddAcademy")) { pstmt.setString(pi ++, toDbCh(addAcademy)); }
                if (modifiedFields.contains("AddFilelist")) { pstmt.setString(pi ++, toDbCh(addFilelist)); }
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
                if (modifiedFields.contains("PracticeCode")) { pstmt.setString(pi ++, toDbCh(practiceCode)); }
                if (modifiedFields.contains("PracticeName")) { pstmt.setString(pi ++, toDbCh(practiceName)); }
                if (modifiedFields.contains("PracticeSubject")) { pstmt.setString(pi ++, toDbCh(practiceSubject)); }
                if (modifiedFields.contains("Starttime")) { pstmt.setString(pi ++, toDbCh(starttime)); }
                if (modifiedFields.contains("Endtime")) { pstmt.setString(pi ++, toDbCh(endtime)); }
                if (modifiedFields.contains("Funding")) { pstmt.setString(pi ++, toDbCh(funding)); }
                if (modifiedFields.contains("TeamDemand")) { pstmt.setString(pi ++, toDbCh(teamDemand)); }
                if (modifiedFields.contains("Schedule")) { pstmt.setString(pi ++, toDbCh(schedule)); }
                if (modifiedFields.contains("WorkDemand")) { pstmt.setString(pi ++, toDbCh(workDemand)); }
                if (modifiedFields.contains("OtherExplain")) { pstmt.setString(pi ++, toDbCh(otherExplain)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setString(pi ++, toDbCh(addtime)); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("AddUserrole")) { pstmt.setString(pi ++, toDbCh(addUserrole)); }
                if (modifiedFields.contains("AddAcademy")) { pstmt.setString(pi ++, toDbCh(addAcademy)); }
                if (modifiedFields.contains("AddFilelist")) { pstmt.setString(pi ++, toDbCh(addFilelist)); }
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
        map.put("PracticeCode", getPracticeCode());
        map.put("PracticeName", getPracticeName());
        map.put("PracticeSubject", getPracticeSubject());
        map.put("Starttime", getStarttime());
        map.put("Endtime", getEndtime());
        map.put("Funding", getFunding());
        map.put("TeamDemand", getTeamDemand());
        map.put("Schedule", getSchedule());
        map.put("WorkDemand", getWorkDemand());
        map.put("OtherExplain", getOtherExplain());
        map.put("Addtime", getAddtime());
        map.put("AddAccount", getAddAccount());
        map.put("AddUserrole", getAddUserrole());
        map.put("AddAcademy", getAddAcademy());
        map.put("AddFilelist", getAddFilelist());
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
        row.add("PracticeCode:\"" + Tool.jsSpecialChars(getPracticeCode()) + "\"");
        row.add("PracticeName:\"" + Tool.jsSpecialChars(getPracticeName()) + "\"");
        row.add("PracticeSubject:\"" + Tool.jsSpecialChars(getPracticeSubject()) + "\"");
        row.add("Starttime:\"" + Tool.jsSpecialChars(getStarttime()) + "\"");
        row.add("Endtime:\"" + Tool.jsSpecialChars(getEndtime()) + "\"");
        row.add("Funding:\"" + Tool.jsSpecialChars(getFunding()) + "\"");
        row.add("TeamDemand:\"" + Tool.jsSpecialChars(getTeamDemand()) + "\"");
        row.add("Schedule:\"" + Tool.jsSpecialChars(getSchedule()) + "\"");
        row.add("WorkDemand:\"" + Tool.jsSpecialChars(getWorkDemand()) + "\"");
        row.add("OtherExplain:\"" + Tool.jsSpecialChars(getOtherExplain()) + "\"");
        row.add("Addtime:\"" + Tool.jsSpecialChars(getAddtime()) + "\"");
        row.add("AddAccount:\"" + Tool.jsSpecialChars(getAddAccount()) + "\"");
        row.add("AddUserrole:\"" + Tool.jsSpecialChars(getAddUserrole()) + "\"");
        row.add("AddAcademy:\"" + Tool.jsSpecialChars(getAddAcademy()) + "\"");
        row.add("AddFilelist:\"" + Tool.jsSpecialChars(getAddFilelist()) + "\"");
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
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,practicecode varchar2(45),practicename varchar2(45),practicesubject varchar2(2000),starttime varchar2(45),endtime varchar2(45),funding varchar2(255),teamdemand varchar2(255),schedule varchar2(255),workdemand varchar2(255),otherexplain varchar2(255),addtime varchar2(45),addaccount varchar2(45),adduserrole varchar2(45),addacademy varchar2(45),addfilelist varchar2(255),remark varchar2(45),remark2 varchar2(45),remark3 varchar2(45),remark4 varchar2(45),remark5 varchar2(45),remark6 varchar2(45))"});
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
        Practice v = new Practice(sourceDb, sourceTb);
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
        Practice v = new Practice(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(Practice obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getPracticeCode().compareTo(obj.getPracticeCode()); if (rtn != 0) return rtn;
        rtn = getPracticeName().compareTo(obj.getPracticeName()); if (rtn != 0) return rtn;
        rtn = getPracticeSubject().compareTo(obj.getPracticeSubject()); if (rtn != 0) return rtn;
        rtn = getStarttime().compareTo(obj.getStarttime()); if (rtn != 0) return rtn;
        rtn = getEndtime().compareTo(obj.getEndtime()); if (rtn != 0) return rtn;
        rtn = getFunding().compareTo(obj.getFunding()); if (rtn != 0) return rtn;
        rtn = getTeamDemand().compareTo(obj.getTeamDemand()); if (rtn != 0) return rtn;
        rtn = getSchedule().compareTo(obj.getSchedule()); if (rtn != 0) return rtn;
        rtn = getWorkDemand().compareTo(obj.getWorkDemand()); if (rtn != 0) return rtn;
        rtn = getOtherExplain().compareTo(obj.getOtherExplain()); if (rtn != 0) return rtn;
        rtn = getAddtime().compareTo(obj.getAddtime()); if (rtn != 0) return rtn;
        rtn = getAddAccount().compareTo(obj.getAddAccount()); if (rtn != 0) return rtn;
        rtn = getAddUserrole().compareTo(obj.getAddUserrole()); if (rtn != 0) return rtn;
        rtn = getAddAcademy().compareTo(obj.getAddAcademy()); if (rtn != 0) return rtn;
        rtn = getAddFilelist().compareTo(obj.getAddFilelist()); if (rtn != 0) return rtn;
        rtn = getRemark().compareTo(obj.getRemark()); if (rtn != 0) return rtn;
        rtn = getRemark2().compareTo(obj.getRemark2()); if (rtn != 0) return rtn;
        rtn = getRemark3().compareTo(obj.getRemark3()); if (rtn != 0) return rtn;
        rtn = getRemark4().compareTo(obj.getRemark4()); if (rtn != 0) return rtn;
        rtn = getRemark5().compareTo(obj.getRemark5()); if (rtn != 0) return rtn;
        rtn = getRemark6().compareTo(obj.getRemark6()); if (rtn != 0) return rtn;
        return rtn;
    }
}
