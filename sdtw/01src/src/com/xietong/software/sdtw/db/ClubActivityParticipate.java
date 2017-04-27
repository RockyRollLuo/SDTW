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
@Description("社团活动报名")
public class ClubActivityParticipate implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(ClubActivityParticipate.class);
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
    public static final String DbTableName = "club_activity_participate";
    private String TNAME = "club_activity_participate";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","clubid","clubname","activityid","activityname","sno","sname","applytime","checktime","checkaccount","checkflag","issafe","traffictool","activityprocedure","activitysecurity","istell","isbuy","tellway","iswilling","isvoluntary","isresponsible","safetime"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","clubid","clubname","activityid","activityname","sno","sname","applytime","checktime","checkaccount","checkflag","issafe","traffictool","activityprocedure","activitysecurity","istell","isbuy","tellway","iswilling","isvoluntary","isresponsible","safetime"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"Clubid","clubid","String"},{"Clubname","clubname","String"},{"Activityid","activityid","String"},{"Activityname","activityname","String"},{"Sno","sno","String"},{"Sname","sname","String"},{"Applytime","applytime","java.util.Date"},{"Checktime","checktime","java.util.Date"},{"Checkaccount","checkaccount","String"},{"Checkflag","checkflag","int"},{"Issafe","issafe","int"},{"Traffictool","traffictool","String"},{"Activityprocedure","activityprocedure","String"},{"Activitysecurity","activitysecurity","String"},{"Istell","istell","String"},{"Isbuy","isbuy","String"},{"Tellway","tellway","String"},{"Iswilling","iswilling","String"},{"Isvoluntary","isvoluntary","String"},{"Isresponsible","isresponsible","String"},{"Safetime","safetime","java.util.Date"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"clubid","clubid"},{"clubname","clubname"},{"activityid","activityid"},{"activityname","activityname"},{"sno","sno"},{"sname","sname"},{"applytime","applytime"},{"checktime","checktime"},{"checkaccount","checkaccount"},{"checkflag","checkflag"},{"issafe","issafe"},{"traffictool","traffictool"},{"activityprocedure","activityprocedure"},{"activitysecurity","activitysecurity"},{"istell","istell"},{"isbuy","isbuy"},{"tellway","tellway"},{"iswilling","iswilling"},{"isvoluntary","isvoluntary"},{"isresponsible","isresponsible"},{"safetime","safetime"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"APPLYTIME","CHECKTIME","SAFETIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 社团编号
    protected String clubid = "";
    public String getClubid() {  return SqlTool.getDbString(clubid);  }
    public String getClubid(int size) { return SqlTool.subString(getClubid(), size); }
    public void setClubid(String aClubid) { clubid = aClubid; modifiedFields.add("Clubid"); }
    public void assignClubid(String aClubid) { clubid = aClubid; }
    public void paramClubid(HttpServletRequest request) { paramClubid(request, "Clubid"); }
    public void paramClubid(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubid()); if (!tmp.equals(getClubid())) { setClubid(tmp); } }
    // 社团名称
    protected String clubname = "";
    public String getClubname() {  return SqlTool.getDbString(clubname);  }
    public String getClubname(int size) { return SqlTool.subString(getClubname(), size); }
    public void setClubname(String aClubname) { clubname = aClubname; modifiedFields.add("Clubname"); }
    public void assignClubname(String aClubname) { clubname = aClubname; }
    public void paramClubname(HttpServletRequest request) { paramClubname(request, "Clubname"); }
    public void paramClubname(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubname()); if (!tmp.equals(getClubname())) { setClubname(tmp); } }
    // 活动id
    protected String activityid = "";
    public String getActivityid() {  return SqlTool.getDbString(activityid);  }
    public String getActivityid(int size) { return SqlTool.subString(getActivityid(), size); }
    public void setActivityid(String aActivityid) { activityid = aActivityid; modifiedFields.add("Activityid"); }
    public void assignActivityid(String aActivityid) { activityid = aActivityid; }
    public void paramActivityid(HttpServletRequest request) { paramActivityid(request, "Activityid"); }
    public void paramActivityid(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityid()); if (!tmp.equals(getActivityid())) { setActivityid(tmp); } }
    // 活动名称
    protected String activityname = "";
    public String getActivityname() {  return SqlTool.getDbString(activityname);  }
    public String getActivityname(int size) { return SqlTool.subString(getActivityname(), size); }
    public void setActivityname(String aActivityname) { activityname = aActivityname; modifiedFields.add("Activityname"); }
    public void assignActivityname(String aActivityname) { activityname = aActivityname; }
    public void paramActivityname(HttpServletRequest request) { paramActivityname(request, "Activityname"); }
    public void paramActivityname(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityname()); if (!tmp.equals(getActivityname())) { setActivityname(tmp); } }
    // 学号
    protected String sno = "";
    public String getSno() {  return SqlTool.getDbString(sno);  }
    public String getSno(int size) { return SqlTool.subString(getSno(), size); }
    public void setSno(String aSno) { sno = aSno; modifiedFields.add("Sno"); }
    public void assignSno(String aSno) { sno = aSno; }
    public void paramSno(HttpServletRequest request) { paramSno(request, "Sno"); }
    public void paramSno(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSno()); if (!tmp.equals(getSno())) { setSno(tmp); } }
    // 姓名
    protected String sname = "";
    public String getSname() {  return SqlTool.getDbString(sname);  }
    public String getSname(int size) { return SqlTool.subString(getSname(), size); }
    public void setSname(String aSname) { sname = aSname; modifiedFields.add("Sname"); }
    public void assignSname(String aSname) { sname = aSname; }
    public void paramSname(HttpServletRequest request) { paramSname(request, "Sname"); }
    public void paramSname(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSname()); if (!tmp.equals(getSname())) { setSname(tmp); } }
    // 申请时间
    protected java.util.Date applytime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getApplytime() { return applytime; }
    public void setApplytime(java.util.Date aApplytime) { applytime = aApplytime; modifiedFields.add("Applytime"); }
    public void assignApplytime(java.util.Date aApplytime) { applytime = aApplytime; }
    public void paramApplytime(HttpServletRequest request) { paramApplytime(request, "Applytime"); }
    public void paramApplytime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getApplytime()); if (tmp.compareTo(getApplytime()) != 0) { setApplytime(tmp); } }
    // 审核时间
    protected java.util.Date checktime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getChecktime() { return checktime; }
    public void setChecktime(java.util.Date aChecktime) { checktime = aChecktime; modifiedFields.add("Checktime"); }
    public void assignChecktime(java.util.Date aChecktime) { checktime = aChecktime; }
    public void paramChecktime(HttpServletRequest request) { paramChecktime(request, "Checktime"); }
    public void paramChecktime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getChecktime()); if (tmp.compareTo(getChecktime()) != 0) { setChecktime(tmp); } }
    // 审核账号
    protected String checkaccount = "";
    public String getCheckaccount() {  return SqlTool.getDbString(checkaccount);  }
    public String getCheckaccount(int size) { return SqlTool.subString(getCheckaccount(), size); }
    public void setCheckaccount(String aCheckaccount) { checkaccount = aCheckaccount; modifiedFields.add("Checkaccount"); }
    public void assignCheckaccount(String aCheckaccount) { checkaccount = aCheckaccount; }
    public void paramCheckaccount(HttpServletRequest request) { paramCheckaccount(request, "Checkaccount"); }
    public void paramCheckaccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCheckaccount()); if (!tmp.equals(getCheckaccount())) { setCheckaccount(tmp); } }
    // 审核状态
    protected int checkflag = -1;
    public int getCheckflag() { return checkflag; }
    public void setCheckflag(int aCheckflag) { checkflag = aCheckflag; modifiedFields.add("Checkflag"); }
    public void assignCheckflag(int aCheckflag) { checkflag = aCheckflag; }
    public void paramCheckflag(HttpServletRequest request) { paramCheckflag(request, "Checkflag"); }
    public void paramCheckflag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckflag()); if (tmp != getCheckflag()) { setCheckflag(tmp); } }
    // issafe
    protected int issafe = -1;
    public int getIssafe() { return issafe; }
    public void setIssafe(int aIssafe) { issafe = aIssafe; modifiedFields.add("Issafe"); }
    public void assignIssafe(int aIssafe) { issafe = aIssafe; }
    public void paramIssafe(HttpServletRequest request) { paramIssafe(request, "Issafe"); }
    public void paramIssafe(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getIssafe()); if (tmp != getIssafe()) { setIssafe(tmp); } }
    // 交通工具
    protected String traffictool = "";
    public String getTraffictool() {  return SqlTool.getDbString(traffictool);  }
    public String getTraffictool(int size) { return SqlTool.subString(getTraffictool(), size); }
    public void setTraffictool(String aTraffictool) { traffictool = aTraffictool; modifiedFields.add("Traffictool"); }
    public void assignTraffictool(String aTraffictool) { traffictool = aTraffictool; }
    public void paramTraffictool(HttpServletRequest request) { paramTraffictool(request, "Traffictool"); }
    public void paramTraffictool(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTraffictool()); if (!tmp.equals(getTraffictool())) { setTraffictool(tmp); } }
    // 活动程序
    protected String activityprocedure = "";
    public String getActivityprocedure() {  return SqlTool.getDbString(activityprocedure);  }
    public String getActivityprocedure(int size) { return SqlTool.subString(getActivityprocedure(), size); }
    public void setActivityprocedure(String aActivityprocedure) { activityprocedure = aActivityprocedure; modifiedFields.add("Activityprocedure"); }
    public void assignActivityprocedure(String aActivityprocedure) { activityprocedure = aActivityprocedure; }
    public void paramActivityprocedure(HttpServletRequest request) { paramActivityprocedure(request, "Activityprocedure"); }
    public void paramActivityprocedure(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityprocedure()); if (!tmp.equals(getActivityprocedure())) { setActivityprocedure(tmp); } }
    // 安全保障措施
    protected String activitysecurity = "";
    public String getActivitysecurity() {  return SqlTool.getDbString(activitysecurity);  }
    public String getActivitysecurity(int size) { return SqlTool.subString(getActivitysecurity(), size); }
    public void setActivitysecurity(String aActivitysecurity) { activitysecurity = aActivitysecurity; modifiedFields.add("Activitysecurity"); }
    public void assignActivitysecurity(String aActivitysecurity) { activitysecurity = aActivitysecurity; }
    public void paramActivitysecurity(HttpServletRequest request) { paramActivitysecurity(request, "Activitysecurity"); }
    public void paramActivitysecurity(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivitysecurity()); if (!tmp.equals(getActivitysecurity())) { setActivitysecurity(tmp); } }
    // 是否将本次活动的详细情况告知了父母
    protected String istell = "";
    public String getIstell() {  return SqlTool.getDbString(istell);  }
    public String getIstell(int size) { return SqlTool.subString(getIstell(), size); }
    public void setIstell(String aIstell) { istell = aIstell; modifiedFields.add("Istell"); }
    public void assignIstell(String aIstell) { istell = aIstell; }
    public void paramIstell(HttpServletRequest request) { paramIstell(request, "Istell"); }
    public void paramIstell(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIstell()); if (!tmp.equals(getIstell())) { setIstell(tmp); } }
    // 和父母商议是否购买保险
    protected String isbuy = "";
    public String getIsbuy() {  return SqlTool.getDbString(isbuy);  }
    public String getIsbuy(int size) { return SqlTool.subString(getIsbuy(), size); }
    public void setIsbuy(String aIsbuy) { isbuy = aIsbuy; modifiedFields.add("Isbuy"); }
    public void assignIsbuy(String aIsbuy) { isbuy = aIsbuy; }
    public void paramIsbuy(HttpServletRequest request) { paramIsbuy(request, "Isbuy"); }
    public void paramIsbuy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIsbuy()); if (!tmp.equals(getIsbuy())) { setIsbuy(tmp); } }
    // 告知父母的方式(面谈/电话/信件)
    protected String tellway = "";
    public String getTellway() {  return SqlTool.getDbString(tellway);  }
    public String getTellway(int size) { return SqlTool.subString(getTellway(), size); }
    public void setTellway(String aTellway) { tellway = aTellway; modifiedFields.add("Tellway"); }
    public void assignTellway(String aTellway) { tellway = aTellway; }
    public void paramTellway(HttpServletRequest request) { paramTellway(request, "Tellway"); }
    public void paramTellway(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTellway()); if (!tmp.equals(getTellway())) { setTellway(tmp); } }
    // 父母是否知道这次活动是自愿参加
    protected String iswilling = "";
    public String getIswilling() {  return SqlTool.getDbString(iswilling);  }
    public String getIswilling(int size) { return SqlTool.subString(getIswilling(), size); }
    public void setIswilling(String aIswilling) { iswilling = aIswilling; modifiedFields.add("Iswilling"); }
    public void assignIswilling(String aIswilling) { iswilling = aIswilling; }
    public void paramIswilling(HttpServletRequest request) { paramIswilling(request, "Iswilling"); }
    public void paramIswilling(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIswilling()); if (!tmp.equals(getIswilling())) { setIswilling(tmp); } }
    // 父母是否知道这次活动是由学生社团自发组织
    protected String isvoluntary = "";
    public String getIsvoluntary() {  return SqlTool.getDbString(isvoluntary);  }
    public String getIsvoluntary(int size) { return SqlTool.subString(getIsvoluntary(), size); }
    public void setIsvoluntary(String aIsvoluntary) { isvoluntary = aIsvoluntary; modifiedFields.add("Isvoluntary"); }
    public void assignIsvoluntary(String aIsvoluntary) { isvoluntary = aIsvoluntary; }
    public void paramIsvoluntary(HttpServletRequest request) { paramIsvoluntary(request, "Isvoluntary"); }
    public void paramIsvoluntary(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIsvoluntary()); if (!tmp.equals(getIsvoluntary())) { setIsvoluntary(tmp); } }
    // 如万一在活动中发生任何意外情况，父母是否同意责任自负
    protected String isresponsible = "";
    public String getIsresponsible() {  return SqlTool.getDbString(isresponsible);  }
    public String getIsresponsible(int size) { return SqlTool.subString(getIsresponsible(), size); }
    public void setIsresponsible(String aIsresponsible) { isresponsible = aIsresponsible; modifiedFields.add("Isresponsible"); }
    public void assignIsresponsible(String aIsresponsible) { isresponsible = aIsresponsible; }
    public void paramIsresponsible(HttpServletRequest request) { paramIsresponsible(request, "Isresponsible"); }
    public void paramIsresponsible(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIsresponsible()); if (!tmp.equals(getIsresponsible())) { setIsresponsible(tmp); } }
    // safetime
    protected java.util.Date safetime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getSafetime() { return safetime; }
    public void setSafetime(java.util.Date aSafetime) { safetime = aSafetime; modifiedFields.add("Safetime"); }
    public void assignSafetime(java.util.Date aSafetime) { safetime = aSafetime; }
    public void paramSafetime(HttpServletRequest request) { paramSafetime(request, "Safetime"); }
    public void paramSafetime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getSafetime()); if (tmp.compareTo(getSafetime()) != 0) { setSafetime(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public ClubActivityParticipate (String db) {
        DBNAME = db;
    }
    public ClubActivityParticipate (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public ClubActivityParticipate (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public ClubActivityParticipate () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return ClubActivityParticipate类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public ClubActivityParticipate getByParameter(HttpServletRequest request) {
        ClubActivityParticipate v = new ClubActivityParticipate(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramClubid(request);
        paramClubname(request);
        paramActivityid(request);
        paramActivityname(request);
        paramSno(request);
        paramSname(request);
        paramApplytime(request);
        paramChecktime(request);
        paramCheckaccount(request);
        paramCheckflag(request);
        paramIssafe(request);
        paramTraffictool(request);
        paramActivityprocedure(request);
        paramActivitysecurity(request);
        paramIstell(request);
        paramIsbuy(request);
        paramTellway(request);
        paramIswilling(request);
        paramIsvoluntary(request);
        paramIsresponsible(request);
        paramSafetime(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(ClubActivityParticipate bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("clubid")) { setClubid(bean.getClubid()); }
        if (!ncl.contains("clubname")) { setClubname(bean.getClubname()); }
        if (!ncl.contains("activityid")) { setActivityid(bean.getActivityid()); }
        if (!ncl.contains("activityname")) { setActivityname(bean.getActivityname()); }
        if (!ncl.contains("sno")) { setSno(bean.getSno()); }
        if (!ncl.contains("sname")) { setSname(bean.getSname()); }
        if (!ncl.contains("applytime")) { setApplytime(bean.getApplytime()); }
        if (!ncl.contains("checktime")) { setChecktime(bean.getChecktime()); }
        if (!ncl.contains("checkaccount")) { setCheckaccount(bean.getCheckaccount()); }
        if (!ncl.contains("checkflag")) { setCheckflag(bean.getCheckflag()); }
        if (!ncl.contains("issafe")) { setIssafe(bean.getIssafe()); }
        if (!ncl.contains("traffictool")) { setTraffictool(bean.getTraffictool()); }
        if (!ncl.contains("activityprocedure")) { setActivityprocedure(bean.getActivityprocedure()); }
        if (!ncl.contains("activitysecurity")) { setActivitysecurity(bean.getActivitysecurity()); }
        if (!ncl.contains("istell")) { setIstell(bean.getIstell()); }
        if (!ncl.contains("isbuy")) { setIsbuy(bean.getIsbuy()); }
        if (!ncl.contains("tellway")) { setTellway(bean.getTellway()); }
        if (!ncl.contains("iswilling")) { setIswilling(bean.getIswilling()); }
        if (!ncl.contains("isvoluntary")) { setIsvoluntary(bean.getIsvoluntary()); }
        if (!ncl.contains("isresponsible")) { setIsresponsible(bean.getIsresponsible()); }
        if (!ncl.contains("safetime")) { setSafetime(bean.getSafetime()); }
    }
    public ClubActivityParticipate getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        ClubActivityParticipate[] rslt= queryByCondition(cdt);
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
     * @return ClubActivityParticipate类的实例列表。
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
                ClubActivityParticipate ve = new ClubActivityParticipate(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignClubid(fromDbCh(rs.getString(2)));
                ve.assignClubname(fromDbCh(rs.getString(3)));
                ve.assignActivityid(fromDbCh(rs.getString(4)));
                ve.assignActivityname(fromDbCh(rs.getString(5)));
                ve.assignSno(fromDbCh(rs.getString(6)));
                ve.assignSname(fromDbCh(rs.getString(7)));
                tmpDate = rs.getTimestamp(8); if (tmpDate != null) { ve.assignApplytime(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(9); if (tmpDate != null) { ve.assignChecktime(new java.util.Date(tmpDate.getTime())); }
                ve.assignCheckaccount(fromDbCh(rs.getString(10)));
                ve.assignCheckflag(rs.getInt(11));
                ve.assignIssafe(rs.getInt(12));
                ve.assignTraffictool(fromDbCh(rs.getString(13)));
                ve.assignActivityprocedure(fromDbCh(rs.getString(14)));
                ve.assignActivitysecurity(fromDbCh(rs.getString(15)));
                ve.assignIstell(fromDbCh(rs.getString(16)));
                ve.assignIsbuy(fromDbCh(rs.getString(17)));
                ve.assignTellway(fromDbCh(rs.getString(18)));
                ve.assignIswilling(fromDbCh(rs.getString(19)));
                ve.assignIsvoluntary(fromDbCh(rs.getString(20)));
                ve.assignIsresponsible(fromDbCh(rs.getString(21)));
                tmpDate = rs.getTimestamp(22); if (tmpDate != null) { ve.assignSafetime(new java.util.Date(tmpDate.getTime())); }
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
    public ClubActivityParticipate[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (ClubActivityParticipate[])vrs.toArray(new ClubActivityParticipate[vrs.size()]);
    }
    public ClubActivityParticipate[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (ClubActivityParticipate[])vrs.toArray(new ClubActivityParticipate[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (clubid,clubname,activityid,activityname,sno,sname,applytime,checktime,checkaccount,checkflag,issafe,traffictool,activityprocedure,activitysecurity,istell,isbuy,tellway,iswilling,isvoluntary,isresponsible,safetime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(clubid));
            pstmt.setString(2, toDbCh(clubname));
            pstmt.setString(3, toDbCh(activityid));
            pstmt.setString(4, toDbCh(activityname));
            pstmt.setString(5, toDbCh(sno));
            pstmt.setString(6, toDbCh(sname));
            pstmt.setTimestamp(7, new java.sql.Timestamp(applytime.getTime()));
            pstmt.setTimestamp(8, new java.sql.Timestamp(checktime.getTime()));
            pstmt.setString(9, toDbCh(checkaccount));
            pstmt.setInt(10, checkflag);
            pstmt.setInt(11, issafe);
            pstmt.setString(12, toDbCh(traffictool));
            pstmt.setString(13, toDbCh(activityprocedure));
            pstmt.setString(14, toDbCh(activitysecurity));
            pstmt.setString(15, toDbCh(istell));
            pstmt.setString(16, toDbCh(isbuy));
            pstmt.setString(17, toDbCh(tellway));
            pstmt.setString(18, toDbCh(iswilling));
            pstmt.setString(19, toDbCh(isvoluntary));
            pstmt.setString(20, toDbCh(isresponsible));
            pstmt.setTimestamp(21, new java.sql.Timestamp(safetime.getTime()));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,clubid,clubname,activityid,activityname,sno,sname,applytime,checktime,checkaccount,checkflag,issafe,traffictool,activityprocedure,activitysecurity,istell,isbuy,tellway,iswilling,isvoluntary,isresponsible,safetime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(clubid));
            pstmt.setString(3, toDbCh(clubname));
            pstmt.setString(4, toDbCh(activityid));
            pstmt.setString(5, toDbCh(activityname));
            pstmt.setString(6, toDbCh(sno));
            pstmt.setString(7, toDbCh(sname));
            pstmt.setTimestamp(8, new java.sql.Timestamp(applytime.getTime()));
            pstmt.setTimestamp(9, new java.sql.Timestamp(checktime.getTime()));
            pstmt.setString(10, toDbCh(checkaccount));
            pstmt.setInt(11, checkflag);
            pstmt.setInt(12, issafe);
            pstmt.setString(13, toDbCh(traffictool));
            pstmt.setString(14, toDbCh(activityprocedure));
            pstmt.setString(15, toDbCh(activitysecurity));
            pstmt.setString(16, toDbCh(istell));
            pstmt.setString(17, toDbCh(isbuy));
            pstmt.setString(18, toDbCh(tellway));
            pstmt.setString(19, toDbCh(iswilling));
            pstmt.setString(20, toDbCh(isvoluntary));
            pstmt.setString(21, toDbCh(isresponsible));
            pstmt.setTimestamp(22, new java.sql.Timestamp(safetime.getTime()));
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
            ClubActivityParticipate item = (ClubActivityParticipate)it.next();
            ClubActivityParticipate v = new ClubActivityParticipate(dbname);
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
                if (modifiedFields.contains("Clubid")) { pstmt.setString(pi ++, toDbCh(clubid)); }
                if (modifiedFields.contains("Clubname")) { pstmt.setString(pi ++, toDbCh(clubname)); }
                if (modifiedFields.contains("Activityid")) { pstmt.setString(pi ++, toDbCh(activityid)); }
                if (modifiedFields.contains("Activityname")) { pstmt.setString(pi ++, toDbCh(activityname)); }
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("Sname")) { pstmt.setString(pi ++, toDbCh(sname)); }
                if (modifiedFields.contains("Applytime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(applytime.getTime())); }
                if (modifiedFields.contains("Checktime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(checktime.getTime())); }
                if (modifiedFields.contains("Checkaccount")) { pstmt.setString(pi ++, toDbCh(checkaccount)); }
                if (modifiedFields.contains("Checkflag")) { pstmt.setInt(pi ++, checkflag); }
                if (modifiedFields.contains("Issafe")) { pstmt.setInt(pi ++, issafe); }
                if (modifiedFields.contains("Traffictool")) { pstmt.setString(pi ++, toDbCh(traffictool)); }
                if (modifiedFields.contains("Activityprocedure")) { pstmt.setString(pi ++, toDbCh(activityprocedure)); }
                if (modifiedFields.contains("Activitysecurity")) { pstmt.setString(pi ++, toDbCh(activitysecurity)); }
                if (modifiedFields.contains("Istell")) { pstmt.setString(pi ++, toDbCh(istell)); }
                if (modifiedFields.contains("Isbuy")) { pstmt.setString(pi ++, toDbCh(isbuy)); }
                if (modifiedFields.contains("Tellway")) { pstmt.setString(pi ++, toDbCh(tellway)); }
                if (modifiedFields.contains("Iswilling")) { pstmt.setString(pi ++, toDbCh(iswilling)); }
                if (modifiedFields.contains("Isvoluntary")) { pstmt.setString(pi ++, toDbCh(isvoluntary)); }
                if (modifiedFields.contains("Isresponsible")) { pstmt.setString(pi ++, toDbCh(isresponsible)); }
                if (modifiedFields.contains("Safetime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(safetime.getTime())); }
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
                if (modifiedFields.contains("Clubid")) { pstmt.setString(pi ++, toDbCh(clubid)); }
                if (modifiedFields.contains("Clubname")) { pstmt.setString(pi ++, toDbCh(clubname)); }
                if (modifiedFields.contains("Activityid")) { pstmt.setString(pi ++, toDbCh(activityid)); }
                if (modifiedFields.contains("Activityname")) { pstmt.setString(pi ++, toDbCh(activityname)); }
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("Sname")) { pstmt.setString(pi ++, toDbCh(sname)); }
                if (modifiedFields.contains("Applytime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(applytime.getTime())); }
                if (modifiedFields.contains("Checktime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(checktime.getTime())); }
                if (modifiedFields.contains("Checkaccount")) { pstmt.setString(pi ++, toDbCh(checkaccount)); }
                if (modifiedFields.contains("Checkflag")) { pstmt.setInt(pi ++, checkflag); }
                if (modifiedFields.contains("Issafe")) { pstmt.setInt(pi ++, issafe); }
                if (modifiedFields.contains("Traffictool")) { pstmt.setString(pi ++, toDbCh(traffictool)); }
                if (modifiedFields.contains("Activityprocedure")) { pstmt.setString(pi ++, toDbCh(activityprocedure)); }
                if (modifiedFields.contains("Activitysecurity")) { pstmt.setString(pi ++, toDbCh(activitysecurity)); }
                if (modifiedFields.contains("Istell")) { pstmt.setString(pi ++, toDbCh(istell)); }
                if (modifiedFields.contains("Isbuy")) { pstmt.setString(pi ++, toDbCh(isbuy)); }
                if (modifiedFields.contains("Tellway")) { pstmt.setString(pi ++, toDbCh(tellway)); }
                if (modifiedFields.contains("Iswilling")) { pstmt.setString(pi ++, toDbCh(iswilling)); }
                if (modifiedFields.contains("Isvoluntary")) { pstmt.setString(pi ++, toDbCh(isvoluntary)); }
                if (modifiedFields.contains("Isresponsible")) { pstmt.setString(pi ++, toDbCh(isresponsible)); }
                if (modifiedFields.contains("Safetime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(safetime.getTime())); }
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
        map.put("Clubid", getClubid());
        map.put("Clubname", getClubname());
        map.put("Activityid", getActivityid());
        map.put("Activityname", getActivityname());
        map.put("Sno", getSno());
        map.put("Sname", getSname());
        map.put("Applytime", Tool.stringOfDateTime(getApplytime()));
        map.put("Checktime", Tool.stringOfDateTime(getChecktime()));
        map.put("Checkaccount", getCheckaccount());
        map.put("Checkflag", getCheckflag() + "");
        map.put("Issafe", getIssafe() + "");
        map.put("Traffictool", getTraffictool());
        map.put("Activityprocedure", getActivityprocedure());
        map.put("Activitysecurity", getActivitysecurity());
        map.put("Istell", getIstell());
        map.put("Isbuy", getIsbuy());
        map.put("Tellway", getTellway());
        map.put("Iswilling", getIswilling());
        map.put("Isvoluntary", getIsvoluntary());
        map.put("Isresponsible", getIsresponsible());
        map.put("Safetime", Tool.stringOfDateTime(getSafetime()));
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("Clubid:\"" + Tool.jsSpecialChars(getClubid()) + "\"");
        row.add("Clubname:\"" + Tool.jsSpecialChars(getClubname()) + "\"");
        row.add("Activityid:\"" + Tool.jsSpecialChars(getActivityid()) + "\"");
        row.add("Activityname:\"" + Tool.jsSpecialChars(getActivityname()) + "\"");
        row.add("Sno:\"" + Tool.jsSpecialChars(getSno()) + "\"");
        row.add("Sname:\"" + Tool.jsSpecialChars(getSname()) + "\"");
        row.add("Applytime:\"" + Tool.stringOfDateTime(getApplytime()) + "\"");
        row.add("Checktime:\"" + Tool.stringOfDateTime(getChecktime()) + "\"");
        row.add("Checkaccount:\"" + Tool.jsSpecialChars(getCheckaccount()) + "\"");
        row.add("Checkflag:\"" + getCheckflag() + "\"");
        row.add("Issafe:\"" + getIssafe() + "\"");
        row.add("Traffictool:\"" + Tool.jsSpecialChars(getTraffictool()) + "\"");
        row.add("Activityprocedure:\"" + Tool.jsSpecialChars(getActivityprocedure()) + "\"");
        row.add("Activitysecurity:\"" + Tool.jsSpecialChars(getActivitysecurity()) + "\"");
        row.add("Istell:\"" + Tool.jsSpecialChars(getIstell()) + "\"");
        row.add("Isbuy:\"" + Tool.jsSpecialChars(getIsbuy()) + "\"");
        row.add("Tellway:\"" + Tool.jsSpecialChars(getTellway()) + "\"");
        row.add("Iswilling:\"" + Tool.jsSpecialChars(getIswilling()) + "\"");
        row.add("Isvoluntary:\"" + Tool.jsSpecialChars(getIsvoluntary()) + "\"");
        row.add("Isresponsible:\"" + Tool.jsSpecialChars(getIsresponsible()) + "\"");
        row.add("Safetime:\"" + Tool.stringOfDateTime(getSafetime()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,clubid varchar2(45),clubname varchar2(45),activityid varchar2(45),activityname varchar2(100),sno varchar2(45),sname varchar2(45),applytime date,checktime date,checkaccount varchar2(45),checkflag number(*,0),issafe number(*,0),traffictool varchar2(100),activityprocedure varchar2(1000),activitysecurity varchar2(1000),istell varchar2(10),isbuy varchar2(10),tellway varchar2(10),iswilling varchar2(10),isvoluntary varchar2(10),isresponsible varchar2(10),safetime date)"});
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
        ClubActivityParticipate v = new ClubActivityParticipate(sourceDb, sourceTb);
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
        ClubActivityParticipate v = new ClubActivityParticipate(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(ClubActivityParticipate obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getClubid().compareTo(obj.getClubid()); if (rtn != 0) return rtn;
        rtn = getClubname().compareTo(obj.getClubname()); if (rtn != 0) return rtn;
        rtn = getActivityid().compareTo(obj.getActivityid()); if (rtn != 0) return rtn;
        rtn = getActivityname().compareTo(obj.getActivityname()); if (rtn != 0) return rtn;
        rtn = getSno().compareTo(obj.getSno()); if (rtn != 0) return rtn;
        rtn = getSname().compareTo(obj.getSname()); if (rtn != 0) return rtn;
        rtn = getApplytime().compareTo(obj.getApplytime()); if (rtn != 0) return rtn;
        rtn = getChecktime().compareTo(obj.getChecktime()); if (rtn != 0) return rtn;
        rtn = getCheckaccount().compareTo(obj.getCheckaccount()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckflag()).compareTo("" + obj.getCheckflag()); if (rtn != 0) return rtn;
        rtn = ("" + getIssafe()).compareTo("" + obj.getIssafe()); if (rtn != 0) return rtn;
        rtn = getTraffictool().compareTo(obj.getTraffictool()); if (rtn != 0) return rtn;
        rtn = getActivityprocedure().compareTo(obj.getActivityprocedure()); if (rtn != 0) return rtn;
        rtn = getActivitysecurity().compareTo(obj.getActivitysecurity()); if (rtn != 0) return rtn;
        rtn = getIstell().compareTo(obj.getIstell()); if (rtn != 0) return rtn;
        rtn = getIsbuy().compareTo(obj.getIsbuy()); if (rtn != 0) return rtn;
        rtn = getTellway().compareTo(obj.getTellway()); if (rtn != 0) return rtn;
        rtn = getIswilling().compareTo(obj.getIswilling()); if (rtn != 0) return rtn;
        rtn = getIsvoluntary().compareTo(obj.getIsvoluntary()); if (rtn != 0) return rtn;
        rtn = getIsresponsible().compareTo(obj.getIsresponsible()); if (rtn != 0) return rtn;
        rtn = getSafetime().compareTo(obj.getSafetime()); if (rtn != 0) return rtn;
        return rtn;
    }
}
