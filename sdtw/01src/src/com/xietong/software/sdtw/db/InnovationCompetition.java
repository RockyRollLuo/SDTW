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
@Description("创新创业竞赛管理")
public class InnovationCompetition implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(InnovationCompetition.class);
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
    public static final String DbTableName = "innovation_competition";
    private String TNAME = "innovation_competition";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","productionCode","productionName","academy","declarer","productionType","declarerRole","remark","addFilelist","addTime","addPerson","modiTime","modiPerson","checkCommentXy","checkCommentTw","leader","leaderId","team","checkFlagXy","checkPersonXy","checkFlagTw","checkPersonTw","award","projectName"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","productioncode","productionname","academy","declarer","productiontype","declarerrole","remark","addfilelist","addtime","addperson","moditime","modiperson","checkcommentxy","checkcommenttw","leader","leaderid","team","checkflagxy","checkpersonxy","checkflagtw","checkpersontw","award","projectname"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"ProductionCode","productioncode","String"},{"ProductionName","productionname","String"},{"Academy","academy","String"},{"Declarer","declarer","String"},{"ProductionType","productiontype","String"},{"DeclarerRole","declarerrole","String"},{"Remark","remark","String"},{"AddFilelist","addfilelist","String"},{"AddTime","addtime","java.util.Date"},{"AddPerson","addperson","String"},{"ModiTime","moditime","java.util.Date"},{"ModiPerson","modiperson","String"},{"CheckCommentXy","checkcommentxy","String"},{"CheckCommentTw","checkcommenttw","String"},{"Leader","leader","String"},{"LeaderId","leaderid","String"},{"Team","team","String"},{"CheckFlagXy","checkflagxy","int"},{"CheckPersonXy","checkpersonxy","String"},{"CheckFlagTw","checkflagtw","int"},{"CheckPersonTw","checkpersontw","String"},{"Award","award","String"},{"ProjectName","projectname","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"productionCode","productioncode"},{"productionName","productionname"},{"academy","academy"},{"declarer","declarer"},{"productionType","productiontype"},{"declarerRole","declarerrole"},{"remark","remark"},{"addFilelist","addfilelist"},{"addTime","addtime"},{"addPerson","addperson"},{"modiTime","moditime"},{"modiPerson","modiperson"},{"checkCommentXy","checkcommentxy"},{"checkCommentTw","checkcommenttw"},{"leader","leader"},{"leaderId","leaderid"},{"team","team"},{"checkFlagXy","checkflagxy"},{"checkPersonXy","checkpersonxy"},{"checkFlagTw","checkflagtw"},{"checkPersonTw","checkpersontw"},{"award","award"},{"projectName","projectname"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME","MODITIME"};
    public String[] getDateFields () {return _dateFields;};
    // id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 作品编码
    protected String productionCode = "";
    public String getProductionCode() {  return SqlTool.getDbString(productionCode);  }
    public String getProductionCode(int size) { return SqlTool.subString(getProductionCode(), size); }
    public void setProductionCode(String aProductionCode) { productionCode = aProductionCode; modifiedFields.add("ProductionCode"); }
    public void assignProductionCode(String aProductionCode) { productionCode = aProductionCode; }
    public void paramProductionCode(HttpServletRequest request) { paramProductionCode(request, "ProductionCode"); }
    public void paramProductionCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProductionCode()); if (!tmp.equals(getProductionCode())) { setProductionCode(tmp); } }
    // 作品名称
    protected String productionName = "";
    public String getProductionName() {  return SqlTool.getDbString(productionName);  }
    public String getProductionName(int size) { return SqlTool.subString(getProductionName(), size); }
    public void setProductionName(String aProductionName) { productionName = aProductionName; modifiedFields.add("ProductionName"); refreshFlag = true; }
    public void assignProductionName(String aProductionName) { productionName = aProductionName; }
    public void paramProductionName(HttpServletRequest request) { paramProductionName(request, "ProductionName"); }
    public void paramProductionName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProductionName()); if (!tmp.equals(getProductionName())) { setProductionName(tmp); } }
    // 学院全称
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 申报者姓名（集体名称）
    protected String declarer = "";
    public String getDeclarer() {  return SqlTool.getDbString(declarer);  }
    public String getDeclarer(int size) { return SqlTool.subString(getDeclarer(), size); }
    public void setDeclarer(String aDeclarer) { declarer = aDeclarer; modifiedFields.add("Declarer"); }
    public void assignDeclarer(String aDeclarer) { declarer = aDeclarer; }
    public void paramDeclarer(HttpServletRequest request) { paramDeclarer(request, "Declarer"); }
    public void paramDeclarer(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclarer()); if (!tmp.equals(getDeclarer())) { setDeclarer(tmp); } }
    // 作品类别
    protected String productionType = "";
    public String getProductionType() {  return SqlTool.getDbString(productionType);  }
    public String getProductionType(int size) { return SqlTool.subString(getProductionType(), size); }
    public void setProductionType(String aProductionType) { productionType = aProductionType; modifiedFields.add("ProductionType"); }
    public void assignProductionType(String aProductionType) { productionType = aProductionType; }
    public void paramProductionType(HttpServletRequest request) { paramProductionType(request, "ProductionType"); }
    public void paramProductionType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProductionType()); if (!tmp.equals(getProductionType())) { setProductionType(tmp); } }
    // 申报类别
    protected String declarerRole = "";
    public String getDeclarerRole() {  return SqlTool.getDbString(declarerRole);  }
    public String getDeclarerRole(int size) { return SqlTool.subString(getDeclarerRole(), size); }
    public void setDeclarerRole(String aDeclarerRole) { declarerRole = aDeclarerRole; modifiedFields.add("DeclarerRole"); }
    public void assignDeclarerRole(String aDeclarerRole) { declarerRole = aDeclarerRole; }
    public void paramDeclarerRole(HttpServletRequest request) { paramDeclarerRole(request, "DeclarerRole"); }
    public void paramDeclarerRole(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeclarerRole()); if (!tmp.equals(getDeclarerRole())) { setDeclarerRole(tmp); } }
    // 备注
    protected String remark = "";
    public String getRemark() {  return SqlTool.getDbString(remark);  }
    public String getRemark(int size) { return SqlTool.subString(getRemark(), size); }
    public void setRemark(String aRemark) { remark = aRemark; modifiedFields.add("Remark"); }
    public void assignRemark(String aRemark) { remark = aRemark; }
    public void paramRemark(HttpServletRequest request) { paramRemark(request, "Remark"); }
    public void paramRemark(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark()); if (!tmp.equals(getRemark())) { setRemark(tmp); } }
    // 添加文件列表
    protected String addFilelist = "";
    public String getAddFilelist() {  return SqlTool.getDbString(addFilelist);  }
    public String getAddFilelist(int size) { return SqlTool.subString(getAddFilelist(), size); }
    public void setAddFilelist(String aAddFilelist) { addFilelist = aAddFilelist; modifiedFields.add("AddFilelist"); }
    public void assignAddFilelist(String aAddFilelist) { addFilelist = aAddFilelist; }
    public void paramAddFilelist(HttpServletRequest request) { paramAddFilelist(request, "AddFilelist"); }
    public void paramAddFilelist(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddFilelist()); if (!tmp.equals(getAddFilelist())) { setAddFilelist(tmp); } }
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
    // 修改时间
    protected java.util.Date modiTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getModiTime() { return modiTime; }
    public void setModiTime(java.util.Date aModiTime) { modiTime = aModiTime; modifiedFields.add("ModiTime"); }
    public void assignModiTime(java.util.Date aModiTime) { modiTime = aModiTime; }
    public void paramModiTime(HttpServletRequest request) { paramModiTime(request, "ModiTime"); }
    public void paramModiTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getModiTime()); if (tmp.compareTo(getModiTime()) != 0) { setModiTime(tmp); } }
    // 修改人
    protected String modiPerson = "";
    public String getModiPerson() {  return SqlTool.getDbString(modiPerson);  }
    public String getModiPerson(int size) { return SqlTool.subString(getModiPerson(), size); }
    public void setModiPerson(String aModiPerson) { modiPerson = aModiPerson; modifiedFields.add("ModiPerson"); }
    public void assignModiPerson(String aModiPerson) { modiPerson = aModiPerson; }
    public void paramModiPerson(HttpServletRequest request) { paramModiPerson(request, "ModiPerson"); }
    public void paramModiPerson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getModiPerson()); if (!tmp.equals(getModiPerson())) { setModiPerson(tmp); } }
    // 学院意见
    protected String checkCommentXy = "";
    public String getCheckCommentXy() {  return SqlTool.getDbString(checkCommentXy);  }
    public String getCheckCommentXy(int size) { return SqlTool.subString(getCheckCommentXy(), size); }
    public void setCheckCommentXy(String aCheckCommentXy) { checkCommentXy = aCheckCommentXy; modifiedFields.add("CheckCommentXy"); }
    public void assignCheckCommentXy(String aCheckCommentXy) { checkCommentXy = aCheckCommentXy; }
    public void paramCheckCommentXy(HttpServletRequest request) { paramCheckCommentXy(request, "CheckCommentXy"); }
    public void paramCheckCommentXy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCheckCommentXy()); if (!tmp.equals(getCheckCommentXy())) { setCheckCommentXy(tmp); } }
    // 团委意见
    protected String checkCommentTw = "";
    public String getCheckCommentTw() {  return SqlTool.getDbString(checkCommentTw);  }
    public String getCheckCommentTw(int size) { return SqlTool.subString(getCheckCommentTw(), size); }
    public void setCheckCommentTw(String aCheckCommentTw) { checkCommentTw = aCheckCommentTw; modifiedFields.add("CheckCommentTw"); }
    public void assignCheckCommentTw(String aCheckCommentTw) { checkCommentTw = aCheckCommentTw; }
    public void paramCheckCommentTw(HttpServletRequest request) { paramCheckCommentTw(request, "CheckCommentTw"); }
    public void paramCheckCommentTw(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCheckCommentTw()); if (!tmp.equals(getCheckCommentTw())) { setCheckCommentTw(tmp); } }
    // 负责人
    protected String leader = "";
    public String getLeader() {  return SqlTool.getDbString(leader);  }
    public String getLeader(int size) { return SqlTool.subString(getLeader(), size); }
    public void setLeader(String aLeader) { leader = aLeader; modifiedFields.add("Leader"); }
    public void assignLeader(String aLeader) { leader = aLeader; }
    public void paramLeader(HttpServletRequest request) { paramLeader(request, "Leader"); }
    public void paramLeader(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getLeader()); if (!tmp.equals(getLeader())) { setLeader(tmp); } }
    // 负责人ID
    protected String leaderId = "";
    public String getLeaderId() {  return SqlTool.getDbString(leaderId);  }
    public String getLeaderId(int size) { return SqlTool.subString(getLeaderId(), size); }
    public void setLeaderId(String aLeaderId) { leaderId = aLeaderId; modifiedFields.add("LeaderId"); }
    public void assignLeaderId(String aLeaderId) { leaderId = aLeaderId; }
    public void paramLeaderId(HttpServletRequest request) { paramLeaderId(request, "LeaderId"); }
    public void paramLeaderId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getLeaderId()); if (!tmp.equals(getLeaderId())) { setLeaderId(tmp); } }
    // 团队成员
    protected String team = "";
    public String getTeam() {  return SqlTool.getDbString(team);  }
    public String getTeam(int size) { return SqlTool.subString(getTeam(), size); }
    public void setTeam(String aTeam) { team = aTeam; modifiedFields.add("Team"); }
    public void assignTeam(String aTeam) { team = aTeam; }
    public void paramTeam(HttpServletRequest request) { paramTeam(request, "Team"); }
    public void paramTeam(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeam()); if (!tmp.equals(getTeam())) { setTeam(tmp); } }
    // 考核状态
    protected int checkFlagXy = 0;
    public int getCheckFlagXy() { return checkFlagXy; }
    public void setCheckFlagXy(int aCheckFlagXy) { checkFlagXy = aCheckFlagXy; modifiedFields.add("CheckFlagXy"); }
    public void assignCheckFlagXy(int aCheckFlagXy) { checkFlagXy = aCheckFlagXy; }
    public void paramCheckFlagXy(HttpServletRequest request) { paramCheckFlagXy(request, "CheckFlagXy"); }
    public void paramCheckFlagXy(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckFlagXy()); if (tmp != getCheckFlagXy()) { setCheckFlagXy(tmp); } }
    // 考核人
    protected String checkPersonXy = "";
    public String getCheckPersonXy() {  return SqlTool.getDbString(checkPersonXy);  }
    public String getCheckPersonXy(int size) { return SqlTool.subString(getCheckPersonXy(), size); }
    public void setCheckPersonXy(String aCheckPersonXy) { checkPersonXy = aCheckPersonXy; modifiedFields.add("CheckPersonXy"); }
    public void assignCheckPersonXy(String aCheckPersonXy) { checkPersonXy = aCheckPersonXy; }
    public void paramCheckPersonXy(HttpServletRequest request) { paramCheckPersonXy(request, "CheckPersonXy"); }
    public void paramCheckPersonXy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCheckPersonXy()); if (!tmp.equals(getCheckPersonXy())) { setCheckPersonXy(tmp); } }
    // 考核状态
    protected int checkFlagTw = 0;
    public int getCheckFlagTw() { return checkFlagTw; }
    public void setCheckFlagTw(int aCheckFlagTw) { checkFlagTw = aCheckFlagTw; modifiedFields.add("CheckFlagTw"); }
    public void assignCheckFlagTw(int aCheckFlagTw) { checkFlagTw = aCheckFlagTw; }
    public void paramCheckFlagTw(HttpServletRequest request) { paramCheckFlagTw(request, "CheckFlagTw"); }
    public void paramCheckFlagTw(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckFlagTw()); if (tmp != getCheckFlagTw()) { setCheckFlagTw(tmp); } }
    // 考核人
    protected String checkPersonTw = "";
    public String getCheckPersonTw() {  return SqlTool.getDbString(checkPersonTw);  }
    public String getCheckPersonTw(int size) { return SqlTool.subString(getCheckPersonTw(), size); }
    public void setCheckPersonTw(String aCheckPersonTw) { checkPersonTw = aCheckPersonTw; modifiedFields.add("CheckPersonTw"); }
    public void assignCheckPersonTw(String aCheckPersonTw) { checkPersonTw = aCheckPersonTw; }
    public void paramCheckPersonTw(HttpServletRequest request) { paramCheckPersonTw(request, "CheckPersonTw"); }
    public void paramCheckPersonTw(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCheckPersonTw()); if (!tmp.equals(getCheckPersonTw())) { setCheckPersonTw(tmp); } }
    // 奖励荣誉
    protected String award = "";
    public String getAward() {  return SqlTool.getDbString(award);  }
    public String getAward(int size) { return SqlTool.subString(getAward(), size); }
    public void setAward(String aAward) { award = aAward; modifiedFields.add("Award"); }
    public void assignAward(String aAward) { award = aAward; }
    public void paramAward(HttpServletRequest request) { paramAward(request, "Award"); }
    public void paramAward(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAward()); if (!tmp.equals(getAward())) { setAward(tmp); } }
    // 所属项目
    protected String projectName = "";
    public String getProjectName() {  return SqlTool.getDbString(projectName);  }
    public String getProjectName(int size) { return SqlTool.subString(getProjectName(), size); }
    public void setProjectName(String aProjectName) { projectName = aProjectName; modifiedFields.add("ProjectName"); }
    public void assignProjectName(String aProjectName) { projectName = aProjectName; }
    public void paramProjectName(HttpServletRequest request) { paramProjectName(request, "ProjectName"); }
    public void paramProjectName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectName()); if (!tmp.equals(getProjectName())) { setProjectName(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public InnovationCompetition (String db) {
        DBNAME = db;
    }
    public InnovationCompetition (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public InnovationCompetition (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public InnovationCompetition () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return InnovationCompetition类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public InnovationCompetition getByParameter(HttpServletRequest request) {
        InnovationCompetition v = new InnovationCompetition(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramProductionCode(request);
        paramProductionName(request);
        paramAcademy(request);
        paramDeclarer(request);
        paramProductionType(request);
        paramDeclarerRole(request);
        paramRemark(request);
        paramAddFilelist(request);
        paramAddTime(request);
        paramAddPerson(request);
        paramModiTime(request);
        paramModiPerson(request);
        paramCheckCommentXy(request);
        paramCheckCommentTw(request);
        paramLeader(request);
        paramLeaderId(request);
        paramTeam(request);
        paramCheckFlagXy(request);
        paramCheckPersonXy(request);
        paramCheckFlagTw(request);
        paramCheckPersonTw(request);
        paramAward(request);
        paramProjectName(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(InnovationCompetition bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("productionCode")) { setProductionCode(bean.getProductionCode()); }
        if (!ncl.contains("productionName")) { setProductionName(bean.getProductionName()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("declarer")) { setDeclarer(bean.getDeclarer()); }
        if (!ncl.contains("productionType")) { setProductionType(bean.getProductionType()); }
        if (!ncl.contains("declarerRole")) { setDeclarerRole(bean.getDeclarerRole()); }
        if (!ncl.contains("remark")) { setRemark(bean.getRemark()); }
        if (!ncl.contains("addFilelist")) { setAddFilelist(bean.getAddFilelist()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("addPerson")) { setAddPerson(bean.getAddPerson()); }
        if (!ncl.contains("modiTime")) { setModiTime(bean.getModiTime()); }
        if (!ncl.contains("modiPerson")) { setModiPerson(bean.getModiPerson()); }
        if (!ncl.contains("checkCommentXy")) { setCheckCommentXy(bean.getCheckCommentXy()); }
        if (!ncl.contains("checkCommentTw")) { setCheckCommentTw(bean.getCheckCommentTw()); }
        if (!ncl.contains("leader")) { setLeader(bean.getLeader()); }
        if (!ncl.contains("leaderId")) { setLeaderId(bean.getLeaderId()); }
        if (!ncl.contains("team")) { setTeam(bean.getTeam()); }
        if (!ncl.contains("checkFlagXy")) { setCheckFlagXy(bean.getCheckFlagXy()); }
        if (!ncl.contains("checkPersonXy")) { setCheckPersonXy(bean.getCheckPersonXy()); }
        if (!ncl.contains("checkFlagTw")) { setCheckFlagTw(bean.getCheckFlagTw()); }
        if (!ncl.contains("checkPersonTw")) { setCheckPersonTw(bean.getCheckPersonTw()); }
        if (!ncl.contains("award")) { setAward(bean.getAward()); }
        if (!ncl.contains("projectName")) { setProjectName(bean.getProjectName()); }
    }
    public InnovationCompetition getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        InnovationCompetition[] rslt= queryByCondition(cdt);
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
     * @return InnovationCompetition类的实例列表。
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
                InnovationCompetition ve = new InnovationCompetition(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignProductionCode(fromDbCh(rs.getString(2)));
                ve.assignProductionName(fromDbCh(rs.getString(3)));
                ve.assignAcademy(fromDbCh(rs.getString(4)));
                ve.assignDeclarer(fromDbCh(rs.getString(5)));
                ve.assignProductionType(fromDbCh(rs.getString(6)));
                ve.assignDeclarerRole(fromDbCh(rs.getString(7)));
                ve.assignRemark(fromDbCh(rs.getString(8)));
                ve.assignAddFilelist(fromDbCh(rs.getString(9)));
                tmpDate = rs.getTimestamp(10); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignAddPerson(fromDbCh(rs.getString(11)));
                tmpDate = rs.getTimestamp(12); if (tmpDate != null) { ve.assignModiTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignModiPerson(fromDbCh(rs.getString(13)));
                ve.assignCheckCommentXy(fromDbCh(rs.getString(14)));
                ve.assignCheckCommentTw(fromDbCh(rs.getString(15)));
                ve.assignLeader(fromDbCh(rs.getString(16)));
                ve.assignLeaderId(fromDbCh(rs.getString(17)));
                ve.assignTeam(fromDbCh(rs.getString(18)));
                ve.assignCheckFlagXy(rs.getInt(19));
                ve.assignCheckPersonXy(fromDbCh(rs.getString(20)));
                ve.assignCheckFlagTw(rs.getInt(21));
                ve.assignCheckPersonTw(fromDbCh(rs.getString(22)));
                ve.assignAward(fromDbCh(rs.getString(23)));
                ve.assignProjectName(fromDbCh(rs.getString(24)));
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
    public InnovationCompetition[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (InnovationCompetition[])vrs.toArray(new InnovationCompetition[vrs.size()]);
    }
    public InnovationCompetition[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (InnovationCompetition[])vrs.toArray(new InnovationCompetition[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (productioncode,productionname,academy,declarer,productiontype,declarerrole,remark,addfilelist,addtime,addperson,moditime,modiperson,checkcommentxy,checkcommenttw,leader,leaderid,team,checkflagxy,checkpersonxy,checkflagtw,checkpersontw,award,projectname) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(productionCode));
            pstmt.setString(2, toDbCh(productionName));
            pstmt.setString(3, toDbCh(academy));
            pstmt.setString(4, toDbCh(declarer));
            pstmt.setString(5, toDbCh(productionType));
            pstmt.setString(6, toDbCh(declarerRole));
            pstmt.setString(7, toDbCh(remark));
            pstmt.setString(8, toDbCh(addFilelist));
            pstmt.setTimestamp(9, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(10, toDbCh(addPerson));
            pstmt.setTimestamp(11, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setString(12, toDbCh(modiPerson));
            pstmt.setString(13, toDbCh(checkCommentXy));
            pstmt.setString(14, toDbCh(checkCommentTw));
            pstmt.setString(15, toDbCh(leader));
            pstmt.setString(16, toDbCh(leaderId));
            pstmt.setString(17, toDbCh(team));
            pstmt.setInt(18, checkFlagXy);
            pstmt.setString(19, toDbCh(checkPersonXy));
            pstmt.setInt(20, checkFlagTw);
            pstmt.setString(21, toDbCh(checkPersonTw));
            pstmt.setString(22, toDbCh(award));
            pstmt.setString(23, toDbCh(projectName));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.InnovationCompetition");
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,productioncode,productionname,academy,declarer,productiontype,declarerrole,remark,addfilelist,addtime,addperson,moditime,modiperson,checkcommentxy,checkcommenttw,leader,leaderid,team,checkflagxy,checkpersonxy,checkflagtw,checkpersontw,award,projectname) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(productionCode));
            pstmt.setString(3, toDbCh(productionName));
            pstmt.setString(4, toDbCh(academy));
            pstmt.setString(5, toDbCh(declarer));
            pstmt.setString(6, toDbCh(productionType));
            pstmt.setString(7, toDbCh(declarerRole));
            pstmt.setString(8, toDbCh(remark));
            pstmt.setString(9, toDbCh(addFilelist));
            pstmt.setTimestamp(10, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(11, toDbCh(addPerson));
            pstmt.setTimestamp(12, new java.sql.Timestamp(modiTime.getTime()));
            pstmt.setString(13, toDbCh(modiPerson));
            pstmt.setString(14, toDbCh(checkCommentXy));
            pstmt.setString(15, toDbCh(checkCommentTw));
            pstmt.setString(16, toDbCh(leader));
            pstmt.setString(17, toDbCh(leaderId));
            pstmt.setString(18, toDbCh(team));
            pstmt.setInt(19, checkFlagXy);
            pstmt.setString(20, toDbCh(checkPersonXy));
            pstmt.setInt(21, checkFlagTw);
            pstmt.setString(22, toDbCh(checkPersonTw));
            pstmt.setString(23, toDbCh(award));
            pstmt.setString(24, toDbCh(projectName));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.InnovationCompetition");
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
            InnovationCompetition item = (InnovationCompetition)it.next();
            InnovationCompetition v = new InnovationCompetition(dbname);
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
                if (modifiedFields.contains("ProductionCode")) { pstmt.setString(pi ++, toDbCh(productionCode)); }
                if (modifiedFields.contains("ProductionName")) { pstmt.setString(pi ++, toDbCh(productionName)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Declarer")) { pstmt.setString(pi ++, toDbCh(declarer)); }
                if (modifiedFields.contains("ProductionType")) { pstmt.setString(pi ++, toDbCh(productionType)); }
                if (modifiedFields.contains("DeclarerRole")) { pstmt.setString(pi ++, toDbCh(declarerRole)); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("AddFilelist")) { pstmt.setString(pi ++, toDbCh(addFilelist)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("CheckCommentXy")) { pstmt.setString(pi ++, toDbCh(checkCommentXy)); }
                if (modifiedFields.contains("CheckCommentTw")) { pstmt.setString(pi ++, toDbCh(checkCommentTw)); }
                if (modifiedFields.contains("Leader")) { pstmt.setString(pi ++, toDbCh(leader)); }
                if (modifiedFields.contains("LeaderId")) { pstmt.setString(pi ++, toDbCh(leaderId)); }
                if (modifiedFields.contains("Team")) { pstmt.setString(pi ++, toDbCh(team)); }
                if (modifiedFields.contains("CheckFlagXy")) { pstmt.setInt(pi ++, checkFlagXy); }
                if (modifiedFields.contains("CheckPersonXy")) { pstmt.setString(pi ++, toDbCh(checkPersonXy)); }
                if (modifiedFields.contains("CheckFlagTw")) { pstmt.setInt(pi ++, checkFlagTw); }
                if (modifiedFields.contains("CheckPersonTw")) { pstmt.setString(pi ++, toDbCh(checkPersonTw)); }
                if (modifiedFields.contains("Award")) { pstmt.setString(pi ++, toDbCh(award)); }
                if (modifiedFields.contains("ProjectName")) { pstmt.setString(pi ++, toDbCh(projectName)); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.InnovationCompetition");
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
                if (modifiedFields.contains("ProductionCode")) { pstmt.setString(pi ++, toDbCh(productionCode)); }
                if (modifiedFields.contains("ProductionName")) { pstmt.setString(pi ++, toDbCh(productionName)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Declarer")) { pstmt.setString(pi ++, toDbCh(declarer)); }
                if (modifiedFields.contains("ProductionType")) { pstmt.setString(pi ++, toDbCh(productionType)); }
                if (modifiedFields.contains("DeclarerRole")) { pstmt.setString(pi ++, toDbCh(declarerRole)); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("AddFilelist")) { pstmt.setString(pi ++, toDbCh(addFilelist)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("CheckCommentXy")) { pstmt.setString(pi ++, toDbCh(checkCommentXy)); }
                if (modifiedFields.contains("CheckCommentTw")) { pstmt.setString(pi ++, toDbCh(checkCommentTw)); }
                if (modifiedFields.contains("Leader")) { pstmt.setString(pi ++, toDbCh(leader)); }
                if (modifiedFields.contains("LeaderId")) { pstmt.setString(pi ++, toDbCh(leaderId)); }
                if (modifiedFields.contains("Team")) { pstmt.setString(pi ++, toDbCh(team)); }
                if (modifiedFields.contains("CheckFlagXy")) { pstmt.setInt(pi ++, checkFlagXy); }
                if (modifiedFields.contains("CheckPersonXy")) { pstmt.setString(pi ++, toDbCh(checkPersonXy)); }
                if (modifiedFields.contains("CheckFlagTw")) { pstmt.setInt(pi ++, checkFlagTw); }
                if (modifiedFields.contains("CheckPersonTw")) { pstmt.setString(pi ++, toDbCh(checkPersonTw)); }
                if (modifiedFields.contains("Award")) { pstmt.setString(pi ++, toDbCh(award)); }
                if (modifiedFields.contains("ProjectName")) { pstmt.setString(pi ++, toDbCh(projectName)); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.InnovationCompetition");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.InnovationCompetition");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.InnovationCompetition");
        return iResult;
    }
    public Map toMap() {
        Map map = new HashMap();
        map.put("Id", getId() + "");
        map.put("ProductionCode", getProductionCode());
        map.put("ProductionName", getProductionName());
        map.put("Academy", getAcademy());
        map.put("Declarer", getDeclarer());
        map.put("ProductionType", getProductionType());
        map.put("DeclarerRole", getDeclarerRole());
        map.put("Remark", getRemark());
        map.put("AddFilelist", getAddFilelist());
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("AddPerson", getAddPerson());
        map.put("ModiTime", Tool.stringOfDateTime(getModiTime()));
        map.put("ModiPerson", getModiPerson());
        map.put("CheckCommentXy", getCheckCommentXy());
        map.put("CheckCommentTw", getCheckCommentTw());
        map.put("Leader", getLeader());
        map.put("LeaderId", getLeaderId());
        map.put("Team", getTeam());
        map.put("CheckFlagXy", getCheckFlagXy() + "");
        map.put("CheckPersonXy", getCheckPersonXy());
        map.put("CheckFlagTw", getCheckFlagTw() + "");
        map.put("CheckPersonTw", getCheckPersonTw());
        map.put("Award", getAward());
        map.put("ProjectName", getProjectName());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("ProductionCode:\"" + Tool.jsSpecialChars(getProductionCode()) + "\"");
        row.add("ProductionName:\"" + Tool.jsSpecialChars(getProductionName()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("Declarer:\"" + Tool.jsSpecialChars(getDeclarer()) + "\"");
        row.add("ProductionType:\"" + Tool.jsSpecialChars(getProductionType()) + "\"");
        row.add("DeclarerRole:\"" + Tool.jsSpecialChars(getDeclarerRole()) + "\"");
        row.add("Remark:\"" + Tool.jsSpecialChars(getRemark()) + "\"");
        row.add("AddFilelist:\"" + Tool.jsSpecialChars(getAddFilelist()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("AddPerson:\"" + Tool.jsSpecialChars(getAddPerson()) + "\"");
        row.add("ModiTime:\"" + Tool.stringOfDateTime(getModiTime()) + "\"");
        row.add("ModiPerson:\"" + Tool.jsSpecialChars(getModiPerson()) + "\"");
        row.add("CheckCommentXy:\"" + Tool.jsSpecialChars(getCheckCommentXy()) + "\"");
        row.add("CheckCommentTw:\"" + Tool.jsSpecialChars(getCheckCommentTw()) + "\"");
        row.add("Leader:\"" + Tool.jsSpecialChars(getLeader()) + "\"");
        row.add("LeaderId:\"" + Tool.jsSpecialChars(getLeaderId()) + "\"");
        row.add("Team:\"" + Tool.jsSpecialChars(getTeam()) + "\"");
        row.add("CheckFlagXy:\"" + getCheckFlagXy() + "\"");
        row.add("CheckPersonXy:\"" + Tool.jsSpecialChars(getCheckPersonXy()) + "\"");
        row.add("CheckFlagTw:\"" + getCheckFlagTw() + "\"");
        row.add("CheckPersonTw:\"" + Tool.jsSpecialChars(getCheckPersonTw()) + "\"");
        row.add("Award:\"" + Tool.jsSpecialChars(getAward()) + "\"");
        row.add("ProjectName:\"" + Tool.jsSpecialChars(getProjectName()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,productioncode varchar2(20),productionname varchar2(100),academy varchar2(100),declarer varchar2(45),productiontype varchar2(20),declarerrole varchar2(10),remark varchar2(500),addfilelist varchar2(200),addtime date,addperson varchar2(45),moditime date,modiperson varchar2(45),checkcommentxy varchar2(500),checkcommenttw varchar2(500),leader varchar2(45),leaderid varchar2(45),team varchar2(100),checkflagxy number(*,0),checkpersonxy varchar2(45),checkflagtw number(*,0),checkpersontw varchar2(45),award varchar2(45),projectname varchar2(45))"});
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
        InnovationCompetition v = new InnovationCompetition(sourceDb, sourceTb);
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
        InnovationCompetition v = new InnovationCompetition(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(InnovationCompetition obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getProductionCode().compareTo(obj.getProductionCode()); if (rtn != 0) return rtn;
        rtn = getProductionName().compareTo(obj.getProductionName()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getDeclarer().compareTo(obj.getDeclarer()); if (rtn != 0) return rtn;
        rtn = getProductionType().compareTo(obj.getProductionType()); if (rtn != 0) return rtn;
        rtn = getDeclarerRole().compareTo(obj.getDeclarerRole()); if (rtn != 0) return rtn;
        rtn = getRemark().compareTo(obj.getRemark()); if (rtn != 0) return rtn;
        rtn = getAddFilelist().compareTo(obj.getAddFilelist()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = getAddPerson().compareTo(obj.getAddPerson()); if (rtn != 0) return rtn;
        rtn = getModiTime().compareTo(obj.getModiTime()); if (rtn != 0) return rtn;
        rtn = getModiPerson().compareTo(obj.getModiPerson()); if (rtn != 0) return rtn;
        rtn = getCheckCommentXy().compareTo(obj.getCheckCommentXy()); if (rtn != 0) return rtn;
        rtn = getCheckCommentTw().compareTo(obj.getCheckCommentTw()); if (rtn != 0) return rtn;
        rtn = getLeader().compareTo(obj.getLeader()); if (rtn != 0) return rtn;
        rtn = getLeaderId().compareTo(obj.getLeaderId()); if (rtn != 0) return rtn;
        rtn = getTeam().compareTo(obj.getTeam()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckFlagXy()).compareTo("" + obj.getCheckFlagXy()); if (rtn != 0) return rtn;
        rtn = getCheckPersonXy().compareTo(obj.getCheckPersonXy()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckFlagTw()).compareTo("" + obj.getCheckFlagTw()); if (rtn != 0) return rtn;
        rtn = getCheckPersonTw().compareTo(obj.getCheckPersonTw()); if (rtn != 0) return rtn;
        rtn = getAward().compareTo(obj.getAward()); if (rtn != 0) return rtn;
        rtn = getProjectName().compareTo(obj.getProjectName()); if (rtn != 0) return rtn;
        return rtn;
    }
}
