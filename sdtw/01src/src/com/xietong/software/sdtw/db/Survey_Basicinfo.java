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
@Description("问卷调查基本信息")
public class Survey_Basicinfo implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(Survey_Basicinfo.class);
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
    public static final String DbTableName = "survey_basicinfo";
    private String TNAME = "survey_basicinfo";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","surveyCode","surveyTitle","head_1ID","head_1Title","head_1Score","itemNumber","addTime","addPerson","addUserAccount","addUserRole","activeTime","timeLength","sectionScore","surveyExplain","activeFlag","kindTypeFlag","scoreTypeFlag","surveyNumber","sectionFlag"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","surveycode","surveytitle","head_1id","head_1title","head_1score","itemnumber","addtime","addperson","adduseraccount","adduserrole","activetime","timelength","sectionscore","surveyexplain","activeflag","kindtypeflag","scoretypeflag","surveynumber","sectionflag"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"SurveyCode","surveycode","String"},{"SurveyTitle","surveytitle","String"},{"Head_1ID","head_1id","String"},{"Head_1Title","head_1title","String"},{"Head_1Score","head_1score","String"},{"ItemNumber","itemnumber","int"},{"AddTime","addtime","java.util.Date"},{"AddPerson","addperson","String"},{"AddUserAccount","adduseraccount","String"},{"AddUserRole","adduserrole","String"},{"ActiveTime","activetime","java.util.Date"},{"TimeLength","timelength","String"},{"SectionScore","sectionscore","String"},{"SurveyExplain","surveyexplain","String"},{"ActiveFlag","activeflag","int"},{"KindTypeFlag","kindtypeflag","int"},{"ScoreTypeFlag","scoretypeflag","int"},{"SurveyNumber","surveynumber","int"},{"SectionFlag","sectionflag","int"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"surveyCode","surveycode"},{"surveyTitle","surveytitle"},{"head_1ID","head_1id"},{"head_1Title","head_1title"},{"head_1Score","head_1score"},{"itemNumber","itemnumber"},{"addTime","addtime"},{"addPerson","addperson"},{"addUserAccount","adduseraccount"},{"addUserRole","adduserrole"},{"activeTime","activetime"},{"timeLength","timelength"},{"sectionScore","sectionscore"},{"surveyExplain","surveyexplain"},{"activeFlag","activeflag"},{"kindTypeFlag","kindtypeflag"},{"scoreTypeFlag","scoretypeflag"},{"surveyNumber","surveynumber"},{"sectionFlag","sectionflag"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME","ACTIVETIME"};
    public String[] getDateFields () {return _dateFields;};
    // id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 调查问卷code
    protected String surveyCode = "";
    public String getSurveyCode() {  return SqlTool.getDbString(surveyCode);  }
    public String getSurveyCode(int size) { return SqlTool.subString(getSurveyCode(), size); }
    public void setSurveyCode(String aSurveyCode) { surveyCode = aSurveyCode; modifiedFields.add("SurveyCode"); }
    public void assignSurveyCode(String aSurveyCode) { surveyCode = aSurveyCode; }
    public void paramSurveyCode(HttpServletRequest request) { paramSurveyCode(request, "SurveyCode"); }
    public void paramSurveyCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSurveyCode()); if (!tmp.equals(getSurveyCode())) { setSurveyCode(tmp); } }
    // 调查问卷标题
    protected String surveyTitle = "";
    public String getSurveyTitle() {  return SqlTool.getDbString(surveyTitle);  }
    public String getSurveyTitle(int size) { return SqlTool.subString(getSurveyTitle(), size); }
    public void setSurveyTitle(String aSurveyTitle) { surveyTitle = aSurveyTitle; modifiedFields.add("SurveyTitle"); }
    public void assignSurveyTitle(String aSurveyTitle) { surveyTitle = aSurveyTitle; }
    public void paramSurveyTitle(HttpServletRequest request) { paramSurveyTitle(request, "SurveyTitle"); }
    public void paramSurveyTitle(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSurveyTitle()); if (!tmp.equals(getSurveyTitle())) { setSurveyTitle(tmp); } }
    // Head_1ID
    protected String head_1ID = "";
    public String getHead_1ID() {  return SqlTool.getDbString(head_1ID);  }
    public String getHead_1ID(int size) { return SqlTool.subString(getHead_1ID(), size); }
    public void setHead_1ID(String aHead_1ID) { head_1ID = aHead_1ID; modifiedFields.add("Head_1ID"); }
    public void assignHead_1ID(String aHead_1ID) { head_1ID = aHead_1ID; }
    public void paramHead_1ID(HttpServletRequest request) { paramHead_1ID(request, "Head_1ID"); }
    public void paramHead_1ID(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHead_1ID()); if (!tmp.equals(getHead_1ID())) { setHead_1ID(tmp); } }
    // Head_1Title
    protected String head_1Title = "";
    public String getHead_1Title() {  return SqlTool.getDbString(head_1Title);  }
    public String getHead_1Title(int size) { return SqlTool.subString(getHead_1Title(), size); }
    public void setHead_1Title(String aHead_1Title) { head_1Title = aHead_1Title; modifiedFields.add("Head_1Title"); }
    public void assignHead_1Title(String aHead_1Title) { head_1Title = aHead_1Title; }
    public void paramHead_1Title(HttpServletRequest request) { paramHead_1Title(request, "Head_1Title"); }
    public void paramHead_1Title(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHead_1Title()); if (!tmp.equals(getHead_1Title())) { setHead_1Title(tmp); } }
    // 分数
    protected String head_1Score = "";
    public String getHead_1Score() {  return SqlTool.getDbString(head_1Score);  }
    public String getHead_1Score(int size) { return SqlTool.subString(getHead_1Score(), size); }
    public void setHead_1Score(String aHead_1Score) { head_1Score = aHead_1Score; modifiedFields.add("Head_1Score"); }
    public void assignHead_1Score(String aHead_1Score) { head_1Score = aHead_1Score; }
    public void paramHead_1Score(HttpServletRequest request) { paramHead_1Score(request, "Head_1Score"); }
    public void paramHead_1Score(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHead_1Score()); if (!tmp.equals(getHead_1Score())) { setHead_1Score(tmp); } }
    // 数量
    protected int itemNumber = 0;
    public int getItemNumber() { return itemNumber; }
    public void setItemNumber(int aItemNumber) { itemNumber = aItemNumber; modifiedFields.add("ItemNumber"); }
    public void assignItemNumber(int aItemNumber) { itemNumber = aItemNumber; }
    public void paramItemNumber(HttpServletRequest request) { paramItemNumber(request, "ItemNumber"); }
    public void paramItemNumber(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getItemNumber()); if (tmp != getItemNumber()) { setItemNumber(tmp); } }
    // 添加时间
    protected java.util.Date addTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddTime() { return addTime; }
    public void setAddTime(java.util.Date aAddTime) { addTime = aAddTime; modifiedFields.add("AddTime"); }
    public void assignAddTime(java.util.Date aAddTime) { addTime = aAddTime; }
    public void paramAddTime(HttpServletRequest request) { paramAddTime(request, "AddTime"); }
    public void paramAddTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddTime()); if (tmp.compareTo(getAddTime()) != 0) { setAddTime(tmp); } }
    // 添加人
    protected String addPerson = "";
    public String getAddPerson() {  return SqlTool.getDbString(addPerson);  }
    public String getAddPerson(int size) { return SqlTool.subString(getAddPerson(), size); }
    public void setAddPerson(String aAddPerson) { addPerson = aAddPerson; modifiedFields.add("AddPerson"); }
    public void assignAddPerson(String aAddPerson) { addPerson = aAddPerson; }
    public void paramAddPerson(HttpServletRequest request) { paramAddPerson(request, "AddPerson"); }
    public void paramAddPerson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddPerson()); if (!tmp.equals(getAddPerson())) { setAddPerson(tmp); } }
    // 添加账号
    protected String addUserAccount = "";
    public String getAddUserAccount() {  return SqlTool.getDbString(addUserAccount);  }
    public String getAddUserAccount(int size) { return SqlTool.subString(getAddUserAccount(), size); }
    public void setAddUserAccount(String aAddUserAccount) { addUserAccount = aAddUserAccount; modifiedFields.add("AddUserAccount"); }
    public void assignAddUserAccount(String aAddUserAccount) { addUserAccount = aAddUserAccount; }
    public void paramAddUserAccount(HttpServletRequest request) { paramAddUserAccount(request, "AddUserAccount"); }
    public void paramAddUserAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddUserAccount()); if (!tmp.equals(getAddUserAccount())) { setAddUserAccount(tmp); } }
    // 添加人角色
    protected String addUserRole = "";
    public String getAddUserRole() {  return SqlTool.getDbString(addUserRole);  }
    public String getAddUserRole(int size) { return SqlTool.subString(getAddUserRole(), size); }
    public void setAddUserRole(String aAddUserRole) { addUserRole = aAddUserRole; modifiedFields.add("AddUserRole"); }
    public void assignAddUserRole(String aAddUserRole) { addUserRole = aAddUserRole; }
    public void paramAddUserRole(HttpServletRequest request) { paramAddUserRole(request, "AddUserRole"); }
    public void paramAddUserRole(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddUserRole()); if (!tmp.equals(getAddUserRole())) { setAddUserRole(tmp); } }
    // 激活时间
    protected java.util.Date activeTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getActiveTime() { return activeTime; }
    public void setActiveTime(java.util.Date aActiveTime) { activeTime = aActiveTime; modifiedFields.add("ActiveTime"); }
    public void assignActiveTime(java.util.Date aActiveTime) { activeTime = aActiveTime; }
    public void paramActiveTime(HttpServletRequest request) { paramActiveTime(request, "ActiveTime"); }
    public void paramActiveTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getActiveTime()); if (tmp.compareTo(getActiveTime()) != 0) { setActiveTime(tmp); } }
    // 有效期
    protected String timeLength = "";
    public String getTimeLength() {  return SqlTool.getDbString(timeLength);  }
    public String getTimeLength(int size) { return SqlTool.subString(getTimeLength(), size); }
    public void setTimeLength(String aTimeLength) { timeLength = aTimeLength; modifiedFields.add("TimeLength"); }
    public void assignTimeLength(String aTimeLength) { timeLength = aTimeLength; }
    public void paramTimeLength(HttpServletRequest request) { paramTimeLength(request, "TimeLength"); }
    public void paramTimeLength(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTimeLength()); if (!tmp.equals(getTimeLength())) { setTimeLength(tmp); } }
    // SectionScore
    protected String sectionScore = "";
    public String getSectionScore() {  return SqlTool.getDbString(sectionScore);  }
    public String getSectionScore(int size) { return SqlTool.subString(getSectionScore(), size); }
    public void setSectionScore(String aSectionScore) { sectionScore = aSectionScore; modifiedFields.add("SectionScore"); }
    public void assignSectionScore(String aSectionScore) { sectionScore = aSectionScore; }
    public void paramSectionScore(HttpServletRequest request) { paramSectionScore(request, "SectionScore"); }
    public void paramSectionScore(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSectionScore()); if (!tmp.equals(getSectionScore())) { setSectionScore(tmp); } }
    // 调查说明
    protected String surveyExplain = "";
    public String getSurveyExplain() {  return SqlTool.getDbString(surveyExplain);  }
    public String getSurveyExplain(int size) { return SqlTool.subString(getSurveyExplain(), size); }
    public void setSurveyExplain(String aSurveyExplain) { surveyExplain = aSurveyExplain; modifiedFields.add("SurveyExplain"); }
    public void assignSurveyExplain(String aSurveyExplain) { surveyExplain = aSurveyExplain; }
    public void paramSurveyExplain(HttpServletRequest request) { paramSurveyExplain(request, "SurveyExplain"); }
    public void paramSurveyExplain(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSurveyExplain()); if (!tmp.equals(getSurveyExplain())) { setSurveyExplain(tmp); } }
    // 是否可用
    protected int activeFlag = 0;
    public int getActiveFlag() { return activeFlag; }
    public void setActiveFlag(int aActiveFlag) { activeFlag = aActiveFlag; modifiedFields.add("ActiveFlag"); }
    public void assignActiveFlag(int aActiveFlag) { activeFlag = aActiveFlag; }
    public void paramActiveFlag(HttpServletRequest request) { paramActiveFlag(request, "ActiveFlag"); }
    public void paramActiveFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getActiveFlag()); if (tmp != getActiveFlag()) { setActiveFlag(tmp); } }
    // 是否评分
    protected int kindTypeFlag = 1;
    public int getKindTypeFlag() { return kindTypeFlag; }
    public void setKindTypeFlag(int aKindTypeFlag) { kindTypeFlag = aKindTypeFlag; modifiedFields.add("KindTypeFlag"); }
    public void assignKindTypeFlag(int aKindTypeFlag) { kindTypeFlag = aKindTypeFlag; }
    public void paramKindTypeFlag(HttpServletRequest request) { paramKindTypeFlag(request, "KindTypeFlag"); }
    public void paramKindTypeFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getKindTypeFlag()); if (tmp != getKindTypeFlag()) { setKindTypeFlag(tmp); } }
    // ScoreTypeFlag
    protected int scoreTypeFlag = 1;
    public int getScoreTypeFlag() { return scoreTypeFlag; }
    public void setScoreTypeFlag(int aScoreTypeFlag) { scoreTypeFlag = aScoreTypeFlag; modifiedFields.add("ScoreTypeFlag"); }
    public void assignScoreTypeFlag(int aScoreTypeFlag) { scoreTypeFlag = aScoreTypeFlag; }
    public void paramScoreTypeFlag(HttpServletRequest request) { paramScoreTypeFlag(request, "ScoreTypeFlag"); }
    public void paramScoreTypeFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getScoreTypeFlag()); if (tmp != getScoreTypeFlag()) { setScoreTypeFlag(tmp); } }
    // SurveyNumber
    protected int surveyNumber = 0;
    public int getSurveyNumber() { return surveyNumber; }
    public void setSurveyNumber(int aSurveyNumber) { surveyNumber = aSurveyNumber; modifiedFields.add("SurveyNumber"); }
    public void assignSurveyNumber(int aSurveyNumber) { surveyNumber = aSurveyNumber; }
    public void paramSurveyNumber(HttpServletRequest request) { paramSurveyNumber(request, "SurveyNumber"); }
    public void paramSurveyNumber(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getSurveyNumber()); if (tmp != getSurveyNumber()) { setSurveyNumber(tmp); } }
    // SectionFlag
    protected int sectionFlag = 0;
    public int getSectionFlag() { return sectionFlag; }
    public void setSectionFlag(int aSectionFlag) { sectionFlag = aSectionFlag; modifiedFields.add("SectionFlag"); }
    public void assignSectionFlag(int aSectionFlag) { sectionFlag = aSectionFlag; }
    public void paramSectionFlag(HttpServletRequest request) { paramSectionFlag(request, "SectionFlag"); }
    public void paramSectionFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getSectionFlag()); if (tmp != getSectionFlag()) { setSectionFlag(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public Survey_Basicinfo (String db) {
        DBNAME = db;
    }
    public Survey_Basicinfo (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public Survey_Basicinfo (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public Survey_Basicinfo () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return Survey_Basicinfo类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public Survey_Basicinfo getByParameter(HttpServletRequest request) {
        Survey_Basicinfo v = new Survey_Basicinfo(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramSurveyCode(request);
        paramSurveyTitle(request);
        paramHead_1ID(request);
        paramHead_1Title(request);
        paramHead_1Score(request);
        paramItemNumber(request);
        paramAddTime(request);
        paramAddPerson(request);
        paramAddUserAccount(request);
        paramAddUserRole(request);
        paramActiveTime(request);
        paramTimeLength(request);
        paramSectionScore(request);
        paramSurveyExplain(request);
        paramActiveFlag(request);
        paramKindTypeFlag(request);
        paramScoreTypeFlag(request);
        paramSurveyNumber(request);
        paramSectionFlag(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(Survey_Basicinfo bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("surveyCode")) { setSurveyCode(bean.getSurveyCode()); }
        if (!ncl.contains("surveyTitle")) { setSurveyTitle(bean.getSurveyTitle()); }
        if (!ncl.contains("head_1ID")) { setHead_1ID(bean.getHead_1ID()); }
        if (!ncl.contains("head_1Title")) { setHead_1Title(bean.getHead_1Title()); }
        if (!ncl.contains("head_1Score")) { setHead_1Score(bean.getHead_1Score()); }
        if (!ncl.contains("itemNumber")) { setItemNumber(bean.getItemNumber()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("addPerson")) { setAddPerson(bean.getAddPerson()); }
        if (!ncl.contains("addUserAccount")) { setAddUserAccount(bean.getAddUserAccount()); }
        if (!ncl.contains("addUserRole")) { setAddUserRole(bean.getAddUserRole()); }
        if (!ncl.contains("activeTime")) { setActiveTime(bean.getActiveTime()); }
        if (!ncl.contains("timeLength")) { setTimeLength(bean.getTimeLength()); }
        if (!ncl.contains("sectionScore")) { setSectionScore(bean.getSectionScore()); }
        if (!ncl.contains("surveyExplain")) { setSurveyExplain(bean.getSurveyExplain()); }
        if (!ncl.contains("activeFlag")) { setActiveFlag(bean.getActiveFlag()); }
        if (!ncl.contains("kindTypeFlag")) { setKindTypeFlag(bean.getKindTypeFlag()); }
        if (!ncl.contains("scoreTypeFlag")) { setScoreTypeFlag(bean.getScoreTypeFlag()); }
        if (!ncl.contains("surveyNumber")) { setSurveyNumber(bean.getSurveyNumber()); }
        if (!ncl.contains("sectionFlag")) { setSectionFlag(bean.getSectionFlag()); }
    }
    public Survey_Basicinfo getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        Survey_Basicinfo[] rslt= queryByCondition(cdt);
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
     * @return Survey_Basicinfo类的实例列表。
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
                Survey_Basicinfo ve = new Survey_Basicinfo(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignSurveyCode(fromDbCh(rs.getString(2)));
                ve.assignSurveyTitle(fromDbCh(rs.getString(3)));
                ve.assignHead_1ID(fromDbCh(rs.getString(4)));
                ve.assignHead_1Title(fromDbCh(rs.getString(5)));
                ve.assignHead_1Score(fromDbCh(rs.getString(6)));
                ve.assignItemNumber(rs.getInt(7));
                tmpDate = rs.getTimestamp(8); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignAddPerson(fromDbCh(rs.getString(9)));
                ve.assignAddUserAccount(fromDbCh(rs.getString(10)));
                ve.assignAddUserRole(fromDbCh(rs.getString(11)));
                tmpDate = rs.getTimestamp(12); if (tmpDate != null) { ve.assignActiveTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignTimeLength(fromDbCh(rs.getString(13)));
                ve.assignSectionScore(fromDbCh(rs.getString(14)));
                ve.assignSurveyExplain(fromDbCh(rs.getString(15)));
                ve.assignActiveFlag(rs.getInt(16));
                ve.assignKindTypeFlag(rs.getInt(17));
                ve.assignScoreTypeFlag(rs.getInt(18));
                ve.assignSurveyNumber(rs.getInt(19));
                ve.assignSectionFlag(rs.getInt(20));
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
    public Survey_Basicinfo[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (Survey_Basicinfo[])vrs.toArray(new Survey_Basicinfo[vrs.size()]);
    }
    public Survey_Basicinfo[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (Survey_Basicinfo[])vrs.toArray(new Survey_Basicinfo[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (surveycode,surveytitle,head_1id,head_1title,head_1score,itemnumber,addtime,addperson,adduseraccount,adduserrole,activetime,timelength,sectionscore,surveyexplain,activeflag,kindtypeflag,scoretypeflag,surveynumber,sectionflag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(surveyCode));
            pstmt.setString(2, toDbCh(surveyTitle));
            pstmt.setString(3, toDbCh(head_1ID));
            pstmt.setString(4, toDbCh(head_1Title));
            pstmt.setString(5, toDbCh(head_1Score));
            pstmt.setInt(6, itemNumber);
            pstmt.setTimestamp(7, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(8, toDbCh(addPerson));
            pstmt.setString(9, toDbCh(addUserAccount));
            pstmt.setString(10, toDbCh(addUserRole));
            pstmt.setTimestamp(11, new java.sql.Timestamp(activeTime.getTime()));
            pstmt.setString(12, toDbCh(timeLength));
            pstmt.setString(13, toDbCh(sectionScore));
            pstmt.setString(14, toDbCh(surveyExplain));
            pstmt.setInt(15, activeFlag);
            pstmt.setInt(16, kindTypeFlag);
            pstmt.setInt(17, scoreTypeFlag);
            pstmt.setInt(18, surveyNumber);
            pstmt.setInt(19, sectionFlag);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,surveycode,surveytitle,head_1id,head_1title,head_1score,itemnumber,addtime,addperson,adduseraccount,adduserrole,activetime,timelength,sectionscore,surveyexplain,activeflag,kindtypeflag,scoretypeflag,surveynumber,sectionflag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(surveyCode));
            pstmt.setString(3, toDbCh(surveyTitle));
            pstmt.setString(4, toDbCh(head_1ID));
            pstmt.setString(5, toDbCh(head_1Title));
            pstmt.setString(6, toDbCh(head_1Score));
            pstmt.setInt(7, itemNumber);
            pstmt.setTimestamp(8, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(9, toDbCh(addPerson));
            pstmt.setString(10, toDbCh(addUserAccount));
            pstmt.setString(11, toDbCh(addUserRole));
            pstmt.setTimestamp(12, new java.sql.Timestamp(activeTime.getTime()));
            pstmt.setString(13, toDbCh(timeLength));
            pstmt.setString(14, toDbCh(sectionScore));
            pstmt.setString(15, toDbCh(surveyExplain));
            pstmt.setInt(16, activeFlag);
            pstmt.setInt(17, kindTypeFlag);
            pstmt.setInt(18, scoreTypeFlag);
            pstmt.setInt(19, surveyNumber);
            pstmt.setInt(20, sectionFlag);
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
            Survey_Basicinfo item = (Survey_Basicinfo)it.next();
            Survey_Basicinfo v = new Survey_Basicinfo(dbname);
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
                if (modifiedFields.contains("SurveyCode")) { pstmt.setString(pi ++, toDbCh(surveyCode)); }
                if (modifiedFields.contains("SurveyTitle")) { pstmt.setString(pi ++, toDbCh(surveyTitle)); }
                if (modifiedFields.contains("Head_1ID")) { pstmt.setString(pi ++, toDbCh(head_1ID)); }
                if (modifiedFields.contains("Head_1Title")) { pstmt.setString(pi ++, toDbCh(head_1Title)); }
                if (modifiedFields.contains("Head_1Score")) { pstmt.setString(pi ++, toDbCh(head_1Score)); }
                if (modifiedFields.contains("ItemNumber")) { pstmt.setInt(pi ++, itemNumber); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddUserAccount")) { pstmt.setString(pi ++, toDbCh(addUserAccount)); }
                if (modifiedFields.contains("AddUserRole")) { pstmt.setString(pi ++, toDbCh(addUserRole)); }
                if (modifiedFields.contains("ActiveTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(activeTime.getTime())); }
                if (modifiedFields.contains("TimeLength")) { pstmt.setString(pi ++, toDbCh(timeLength)); }
                if (modifiedFields.contains("SectionScore")) { pstmt.setString(pi ++, toDbCh(sectionScore)); }
                if (modifiedFields.contains("SurveyExplain")) { pstmt.setString(pi ++, toDbCh(surveyExplain)); }
                if (modifiedFields.contains("ActiveFlag")) { pstmt.setInt(pi ++, activeFlag); }
                if (modifiedFields.contains("KindTypeFlag")) { pstmt.setInt(pi ++, kindTypeFlag); }
                if (modifiedFields.contains("ScoreTypeFlag")) { pstmt.setInt(pi ++, scoreTypeFlag); }
                if (modifiedFields.contains("SurveyNumber")) { pstmt.setInt(pi ++, surveyNumber); }
                if (modifiedFields.contains("SectionFlag")) { pstmt.setInt(pi ++, sectionFlag); }
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
                if (modifiedFields.contains("SurveyCode")) { pstmt.setString(pi ++, toDbCh(surveyCode)); }
                if (modifiedFields.contains("SurveyTitle")) { pstmt.setString(pi ++, toDbCh(surveyTitle)); }
                if (modifiedFields.contains("Head_1ID")) { pstmt.setString(pi ++, toDbCh(head_1ID)); }
                if (modifiedFields.contains("Head_1Title")) { pstmt.setString(pi ++, toDbCh(head_1Title)); }
                if (modifiedFields.contains("Head_1Score")) { pstmt.setString(pi ++, toDbCh(head_1Score)); }
                if (modifiedFields.contains("ItemNumber")) { pstmt.setInt(pi ++, itemNumber); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddUserAccount")) { pstmt.setString(pi ++, toDbCh(addUserAccount)); }
                if (modifiedFields.contains("AddUserRole")) { pstmt.setString(pi ++, toDbCh(addUserRole)); }
                if (modifiedFields.contains("ActiveTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(activeTime.getTime())); }
                if (modifiedFields.contains("TimeLength")) { pstmt.setString(pi ++, toDbCh(timeLength)); }
                if (modifiedFields.contains("SectionScore")) { pstmt.setString(pi ++, toDbCh(sectionScore)); }
                if (modifiedFields.contains("SurveyExplain")) { pstmt.setString(pi ++, toDbCh(surveyExplain)); }
                if (modifiedFields.contains("ActiveFlag")) { pstmt.setInt(pi ++, activeFlag); }
                if (modifiedFields.contains("KindTypeFlag")) { pstmt.setInt(pi ++, kindTypeFlag); }
                if (modifiedFields.contains("ScoreTypeFlag")) { pstmt.setInt(pi ++, scoreTypeFlag); }
                if (modifiedFields.contains("SurveyNumber")) { pstmt.setInt(pi ++, surveyNumber); }
                if (modifiedFields.contains("SectionFlag")) { pstmt.setInt(pi ++, sectionFlag); }
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
        map.put("SurveyCode", getSurveyCode());
        map.put("SurveyTitle", getSurveyTitle());
        map.put("Head_1ID", getHead_1ID());
        map.put("Head_1Title", getHead_1Title());
        map.put("Head_1Score", getHead_1Score());
        map.put("ItemNumber", getItemNumber() + "");
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("AddPerson", getAddPerson());
        map.put("AddUserAccount", getAddUserAccount());
        map.put("AddUserRole", getAddUserRole());
        map.put("ActiveTime", Tool.stringOfDateTime(getActiveTime()));
        map.put("TimeLength", getTimeLength());
        map.put("SectionScore", getSectionScore());
        map.put("SurveyExplain", getSurveyExplain());
        map.put("ActiveFlag", getActiveFlag() + "");
        map.put("KindTypeFlag", getKindTypeFlag() + "");
        map.put("ScoreTypeFlag", getScoreTypeFlag() + "");
        map.put("SurveyNumber", getSurveyNumber() + "");
        map.put("SectionFlag", getSectionFlag() + "");
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("SurveyCode:\"" + Tool.jsSpecialChars(getSurveyCode()) + "\"");
        row.add("SurveyTitle:\"" + Tool.jsSpecialChars(getSurveyTitle()) + "\"");
        row.add("Head_1ID:\"" + Tool.jsSpecialChars(getHead_1ID()) + "\"");
        row.add("Head_1Title:\"" + Tool.jsSpecialChars(getHead_1Title()) + "\"");
        row.add("Head_1Score:\"" + Tool.jsSpecialChars(getHead_1Score()) + "\"");
        row.add("ItemNumber:\"" + getItemNumber() + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("AddPerson:\"" + Tool.jsSpecialChars(getAddPerson()) + "\"");
        row.add("AddUserAccount:\"" + Tool.jsSpecialChars(getAddUserAccount()) + "\"");
        row.add("AddUserRole:\"" + Tool.jsSpecialChars(getAddUserRole()) + "\"");
        row.add("ActiveTime:\"" + Tool.stringOfDateTime(getActiveTime()) + "\"");
        row.add("TimeLength:\"" + Tool.jsSpecialChars(getTimeLength()) + "\"");
        row.add("SectionScore:\"" + Tool.jsSpecialChars(getSectionScore()) + "\"");
        row.add("SurveyExplain:\"" + Tool.jsSpecialChars(getSurveyExplain()) + "\"");
        row.add("ActiveFlag:\"" + getActiveFlag() + "\"");
        row.add("KindTypeFlag:\"" + getKindTypeFlag() + "\"");
        row.add("ScoreTypeFlag:\"" + getScoreTypeFlag() + "\"");
        row.add("SurveyNumber:\"" + getSurveyNumber() + "\"");
        row.add("SectionFlag:\"" + getSectionFlag() + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,surveycode varchar2(45),surveytitle varchar2(45),head_1id varchar2(45),head_1title varchar2(45),head_1score varchar2(45),itemnumber number(*,0),addtime date,addperson varchar2(45),adduseraccount varchar2(45),adduserrole varchar2(45),activetime date,timelength varchar2(45),sectionscore varchar2(45),surveyexplain varchar2(2000),activeflag number(*,0),kindtypeflag number(*,0),scoretypeflag number(*,0),surveynumber number(*,0),sectionflag number(*,0))"});
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
        Survey_Basicinfo v = new Survey_Basicinfo(sourceDb, sourceTb);
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
        Survey_Basicinfo v = new Survey_Basicinfo(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(Survey_Basicinfo obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getSurveyCode().compareTo(obj.getSurveyCode()); if (rtn != 0) return rtn;
        rtn = getSurveyTitle().compareTo(obj.getSurveyTitle()); if (rtn != 0) return rtn;
        rtn = getHead_1ID().compareTo(obj.getHead_1ID()); if (rtn != 0) return rtn;
        rtn = getHead_1Title().compareTo(obj.getHead_1Title()); if (rtn != 0) return rtn;
        rtn = getHead_1Score().compareTo(obj.getHead_1Score()); if (rtn != 0) return rtn;
        rtn = ("" + getItemNumber()).compareTo("" + obj.getItemNumber()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = getAddPerson().compareTo(obj.getAddPerson()); if (rtn != 0) return rtn;
        rtn = getAddUserAccount().compareTo(obj.getAddUserAccount()); if (rtn != 0) return rtn;
        rtn = getAddUserRole().compareTo(obj.getAddUserRole()); if (rtn != 0) return rtn;
        rtn = getActiveTime().compareTo(obj.getActiveTime()); if (rtn != 0) return rtn;
        rtn = getTimeLength().compareTo(obj.getTimeLength()); if (rtn != 0) return rtn;
        rtn = getSectionScore().compareTo(obj.getSectionScore()); if (rtn != 0) return rtn;
        rtn = getSurveyExplain().compareTo(obj.getSurveyExplain()); if (rtn != 0) return rtn;
        rtn = ("" + getActiveFlag()).compareTo("" + obj.getActiveFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getKindTypeFlag()).compareTo("" + obj.getKindTypeFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getScoreTypeFlag()).compareTo("" + obj.getScoreTypeFlag()); if (rtn != 0) return rtn;
        rtn = ("" + getSurveyNumber()).compareTo("" + obj.getSurveyNumber()); if (rtn != 0) return rtn;
        rtn = ("" + getSectionFlag()).compareTo("" + obj.getSectionFlag()); if (rtn != 0) return rtn;
        return rtn;
    }
}
