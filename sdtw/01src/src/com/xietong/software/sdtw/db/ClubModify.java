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
@Description("社团变更指导单位")
public class ClubModify implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(ClubModify.class);
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
    public static final String DbTableName = "club_modify";
    private String TNAME = "club_modify";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","clubId","clubName","clubType","clubAcademy","clubAcadeMyNew","modifyType","modifyReason","commentXy","commentXyNew","commentTw","checkFlag","applyDate","addPerson","addTime","modiPerson","modiTime"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","clubid","clubname","clubtype","clubacademy","clubacademynew","modifytype","modifyreason","commentxy","commentxynew","commenttw","checkflag","applydate","addperson","addtime","modiperson","moditime"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"ClubId","clubid","String"},{"ClubName","clubname","String"},{"ClubType","clubtype","String"},{"ClubAcademy","clubacademy","String"},{"ClubAcadeMyNew","clubacademynew","String"},{"ModifyType","modifytype","String"},{"ModifyReason","modifyreason","String"},{"CommentXy","commentxy","String"},{"CommentXyNew","commentxynew","String"},{"CommentTw","commenttw","String"},{"CheckFlag","checkflag","String"},{"ApplyDate","applydate","java.util.Date"},{"AddPerson","addperson","String"},{"AddTime","addtime","java.util.Date"},{"ModiPerson","modiperson","String"},{"ModiTime","moditime","java.util.Date"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"clubId","clubid"},{"clubName","clubname"},{"clubType","clubtype"},{"clubAcademy","clubacademy"},{"clubAcadeMyNew","clubacademynew"},{"modifyType","modifytype"},{"modifyReason","modifyreason"},{"commentXy","commentxy"},{"commentXyNew","commentxynew"},{"commentTw","commenttw"},{"checkFlag","checkflag"},{"applyDate","applydate"},{"addPerson","addperson"},{"addTime","addtime"},{"modiPerson","modiperson"},{"modiTime","moditime"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"APPLYDATE","ADDTIME","MODITIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 登录账号
    protected String clubId = "";
    public String getClubId() {  return SqlTool.getDbString(clubId);  }
    public String getClubId(int size) { return SqlTool.subString(getClubId(), size); }
    public void setClubId(String aClubId) { clubId = aClubId; modifiedFields.add("ClubId"); }
    public void assignClubId(String aClubId) { clubId = aClubId; }
    public void paramClubId(HttpServletRequest request) { paramClubId(request, "ClubId"); }
    public void paramClubId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubId()); if (!tmp.equals(getClubId())) { setClubId(tmp); } }
    // 社团名称
    protected String clubName = "";
    public String getClubName() {  return SqlTool.getDbString(clubName);  }
    public String getClubName(int size) { return SqlTool.subString(getClubName(), size); }
    public void setClubName(String aClubName) { clubName = aClubName; modifiedFields.add("ClubName"); }
    public void assignClubName(String aClubName) { clubName = aClubName; }
    public void paramClubName(HttpServletRequest request) { paramClubName(request, "ClubName"); }
    public void paramClubName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubName()); if (!tmp.equals(getClubName())) { setClubName(tmp); } }
    // 社团类别
    protected String clubType = "";
    public String getClubType() {  return SqlTool.getDbString(clubType);  }
    public String getClubType(int size) { return SqlTool.subString(getClubType(), size); }
    public void setClubType(String aClubType) { clubType = aClubType; modifiedFields.add("ClubType"); }
    public void assignClubType(String aClubType) { clubType = aClubType; }
    public void paramClubType(HttpServletRequest request) { paramClubType(request, "ClubType"); }
    public void paramClubType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubType()); if (!tmp.equals(getClubType())) { setClubType(tmp); } }
    // 原指导单位
    protected String clubAcademy = "";
    public String getClubAcademy() {  return SqlTool.getDbString(clubAcademy);  }
    public String getClubAcademy(int size) { return SqlTool.subString(getClubAcademy(), size); }
    public void setClubAcademy(String aClubAcademy) { clubAcademy = aClubAcademy; modifiedFields.add("ClubAcademy"); }
    public void assignClubAcademy(String aClubAcademy) { clubAcademy = aClubAcademy; }
    public void paramClubAcademy(HttpServletRequest request) { paramClubAcademy(request, "ClubAcademy"); }
    public void paramClubAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubAcademy()); if (!tmp.equals(getClubAcademy())) { setClubAcademy(tmp); } }
    // 新指导单位
    protected String clubAcadeMyNew = "";
    public String getClubAcadeMyNew() {  return SqlTool.getDbString(clubAcadeMyNew);  }
    public String getClubAcadeMyNew(int size) { return SqlTool.subString(getClubAcadeMyNew(), size); }
    public void setClubAcadeMyNew(String aClubAcadeMyNew) { clubAcadeMyNew = aClubAcadeMyNew; modifiedFields.add("ClubAcadeMyNew"); }
    public void assignClubAcadeMyNew(String aClubAcadeMyNew) { clubAcadeMyNew = aClubAcadeMyNew; }
    public void paramClubAcadeMyNew(HttpServletRequest request) { paramClubAcadeMyNew(request, "ClubAcadeMyNew"); }
    public void paramClubAcadeMyNew(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClubAcadeMyNew()); if (!tmp.equals(getClubAcadeMyNew())) { setClubAcadeMyNew(tmp); } }
    // 变更类别
    protected String modifyType = "";
    public String getModifyType() {  return SqlTool.getDbString(modifyType);  }
    public String getModifyType(int size) { return SqlTool.subString(getModifyType(), size); }
    public void setModifyType(String aModifyType) { modifyType = aModifyType; modifiedFields.add("ModifyType"); }
    public void assignModifyType(String aModifyType) { modifyType = aModifyType; }
    public void paramModifyType(HttpServletRequest request) { paramModifyType(request, "ModifyType"); }
    public void paramModifyType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getModifyType()); if (!tmp.equals(getModifyType())) { setModifyType(tmp); } }
    // 变更原因
    protected String modifyReason = "";
    public String getModifyReason() {  return SqlTool.getDbString(modifyReason);  }
    public String getModifyReason(int size) { return SqlTool.subString(getModifyReason(), size); }
    public void setModifyReason(String aModifyReason) { modifyReason = aModifyReason; modifiedFields.add("ModifyReason"); }
    public void assignModifyReason(String aModifyReason) { modifyReason = aModifyReason; }
    public void paramModifyReason(HttpServletRequest request) { paramModifyReason(request, "ModifyReason"); }
    public void paramModifyReason(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getModifyReason()); if (!tmp.equals(getModifyReason())) { setModifyReason(tmp); } }
    // 原指导单位意见
    protected String commentXy = "";
    public String getCommentXy() {  return SqlTool.getDbString(commentXy);  }
    public String getCommentXy(int size) { return SqlTool.subString(getCommentXy(), size); }
    public void setCommentXy(String aCommentXy) { commentXy = aCommentXy; modifiedFields.add("CommentXy"); }
    public void assignCommentXy(String aCommentXy) { commentXy = aCommentXy; }
    public void paramCommentXy(HttpServletRequest request) { paramCommentXy(request, "CommentXy"); }
    public void paramCommentXy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentXy()); if (!tmp.equals(getCommentXy())) { setCommentXy(tmp); } }
    // 新指导单位意见
    protected String commentXyNew = "";
    public String getCommentXyNew() {  return SqlTool.getDbString(commentXyNew);  }
    public String getCommentXyNew(int size) { return SqlTool.subString(getCommentXyNew(), size); }
    public void setCommentXyNew(String aCommentXyNew) { commentXyNew = aCommentXyNew; modifiedFields.add("CommentXyNew"); }
    public void assignCommentXyNew(String aCommentXyNew) { commentXyNew = aCommentXyNew; }
    public void paramCommentXyNew(HttpServletRequest request) { paramCommentXyNew(request, "CommentXyNew"); }
    public void paramCommentXyNew(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentXyNew()); if (!tmp.equals(getCommentXyNew())) { setCommentXyNew(tmp); } }
    // 团委审核意见
    protected String commentTw = "";
    public String getCommentTw() {  return SqlTool.getDbString(commentTw);  }
    public String getCommentTw(int size) { return SqlTool.subString(getCommentTw(), size); }
    public void setCommentTw(String aCommentTw) { commentTw = aCommentTw; modifiedFields.add("CommentTw"); }
    public void assignCommentTw(String aCommentTw) { commentTw = aCommentTw; }
    public void paramCommentTw(HttpServletRequest request) { paramCommentTw(request, "CommentTw"); }
    public void paramCommentTw(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCommentTw()); if (!tmp.equals(getCommentTw())) { setCommentTw(tmp); } }
    // 审核状态
    protected String checkFlag = "";
    public String getCheckFlag() {  return SqlTool.getDbString(checkFlag);  }
    public String getCheckFlag(int size) { return SqlTool.subString(getCheckFlag(), size); }
    public void setCheckFlag(String aCheckFlag) { checkFlag = aCheckFlag; modifiedFields.add("CheckFlag"); }
    public void assignCheckFlag(String aCheckFlag) { checkFlag = aCheckFlag; }
    public void paramCheckFlag(HttpServletRequest request) { paramCheckFlag(request, "CheckFlag"); }
    public void paramCheckFlag(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCheckFlag()); if (!tmp.equals(getCheckFlag())) { setCheckFlag(tmp); } }
    // 申请时间
    protected java.util.Date applyDate = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getApplyDate() { return applyDate; }
    public void setApplyDate(java.util.Date aApplyDate) { applyDate = aApplyDate; modifiedFields.add("ApplyDate"); }
    public void assignApplyDate(java.util.Date aApplyDate) { applyDate = aApplyDate; }
    public void paramApplyDate(HttpServletRequest request) { paramApplyDate(request, "ApplyDate"); }
    public void paramApplyDate(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getApplyDate()); if (tmp.compareTo(getApplyDate()) != 0) { setApplyDate(tmp); } }
    // 申请人
    protected String addPerson = "";
    public String getAddPerson() {  return SqlTool.getDbString(addPerson);  }
    public String getAddPerson(int size) { return SqlTool.subString(getAddPerson(), size); }
    public void setAddPerson(String aAddPerson) { addPerson = aAddPerson; modifiedFields.add("AddPerson"); }
    public void assignAddPerson(String aAddPerson) { addPerson = aAddPerson; }
    public void paramAddPerson(HttpServletRequest request) { paramAddPerson(request, "AddPerson"); }
    public void paramAddPerson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddPerson()); if (!tmp.equals(getAddPerson())) { setAddPerson(tmp); } }
    // 添加时间
    protected java.util.Date addTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddTime() { return addTime; }
    public void setAddTime(java.util.Date aAddTime) { addTime = aAddTime; modifiedFields.add("AddTime"); }
    public void assignAddTime(java.util.Date aAddTime) { addTime = aAddTime; }
    public void paramAddTime(HttpServletRequest request) { paramAddTime(request, "AddTime"); }
    public void paramAddTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddTime()); if (tmp.compareTo(getAddTime()) != 0) { setAddTime(tmp); } }
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
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public ClubModify (String db) {
        DBNAME = db;
    }
    public ClubModify (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public ClubModify (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public ClubModify () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return ClubModify类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public ClubModify getByParameter(HttpServletRequest request) {
        ClubModify v = new ClubModify(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramClubId(request);
        paramClubName(request);
        paramClubType(request);
        paramClubAcademy(request);
        paramClubAcadeMyNew(request);
        paramModifyType(request);
        paramModifyReason(request);
        paramCommentXy(request);
        paramCommentXyNew(request);
        paramCommentTw(request);
        paramCheckFlag(request);
        paramApplyDate(request);
        paramAddPerson(request);
        paramAddTime(request);
        paramModiPerson(request);
        paramModiTime(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(ClubModify bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("clubId")) { setClubId(bean.getClubId()); }
        if (!ncl.contains("clubName")) { setClubName(bean.getClubName()); }
        if (!ncl.contains("clubType")) { setClubType(bean.getClubType()); }
        if (!ncl.contains("clubAcademy")) { setClubAcademy(bean.getClubAcademy()); }
        if (!ncl.contains("clubAcadeMyNew")) { setClubAcadeMyNew(bean.getClubAcadeMyNew()); }
        if (!ncl.contains("modifyType")) { setModifyType(bean.getModifyType()); }
        if (!ncl.contains("modifyReason")) { setModifyReason(bean.getModifyReason()); }
        if (!ncl.contains("commentXy")) { setCommentXy(bean.getCommentXy()); }
        if (!ncl.contains("commentXyNew")) { setCommentXyNew(bean.getCommentXyNew()); }
        if (!ncl.contains("commentTw")) { setCommentTw(bean.getCommentTw()); }
        if (!ncl.contains("checkFlag")) { setCheckFlag(bean.getCheckFlag()); }
        if (!ncl.contains("applyDate")) { setApplyDate(bean.getApplyDate()); }
        if (!ncl.contains("addPerson")) { setAddPerson(bean.getAddPerson()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("modiPerson")) { setModiPerson(bean.getModiPerson()); }
        if (!ncl.contains("modiTime")) { setModiTime(bean.getModiTime()); }
    }
    public ClubModify getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        ClubModify[] rslt= queryByCondition(cdt);
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
     * @return ClubModify类的实例列表。
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
                ClubModify ve = new ClubModify(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignClubId(fromDbCh(rs.getString(2)));
                ve.assignClubName(fromDbCh(rs.getString(3)));
                ve.assignClubType(fromDbCh(rs.getString(4)));
                ve.assignClubAcademy(fromDbCh(rs.getString(5)));
                ve.assignClubAcadeMyNew(fromDbCh(rs.getString(6)));
                ve.assignModifyType(fromDbCh(rs.getString(7)));
                ve.assignModifyReason(fromDbCh(rs.getString(8)));
                ve.assignCommentXy(fromDbCh(rs.getString(9)));
                ve.assignCommentXyNew(fromDbCh(rs.getString(10)));
                ve.assignCommentTw(fromDbCh(rs.getString(11)));
                ve.assignCheckFlag(fromDbCh(rs.getString(12)));
                tmpDate = rs.getTimestamp(13); if (tmpDate != null) { ve.assignApplyDate(new java.util.Date(tmpDate.getTime())); }
                ve.assignAddPerson(fromDbCh(rs.getString(14)));
                tmpDate = rs.getTimestamp(15); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignModiPerson(fromDbCh(rs.getString(16)));
                tmpDate = rs.getTimestamp(17); if (tmpDate != null) { ve.assignModiTime(new java.util.Date(tmpDate.getTime())); }
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
    public ClubModify[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (ClubModify[])vrs.toArray(new ClubModify[vrs.size()]);
    }
    public ClubModify[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (ClubModify[])vrs.toArray(new ClubModify[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (clubid,clubname,clubtype,clubacademy,clubacademynew,modifytype,modifyreason,commentxy,commentxynew,commenttw,checkflag,applydate,addperson,addtime,modiperson,moditime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(clubId));
            pstmt.setString(2, toDbCh(clubName));
            pstmt.setString(3, toDbCh(clubType));
            pstmt.setString(4, toDbCh(clubAcademy));
            pstmt.setString(5, toDbCh(clubAcadeMyNew));
            pstmt.setString(6, toDbCh(modifyType));
            pstmt.setString(7, toDbCh(modifyReason));
            pstmt.setString(8, toDbCh(commentXy));
            pstmt.setString(9, toDbCh(commentXyNew));
            pstmt.setString(10, toDbCh(commentTw));
            pstmt.setString(11, toDbCh(checkFlag));
            pstmt.setTimestamp(12, new java.sql.Timestamp(applyDate.getTime()));
            pstmt.setString(13, toDbCh(addPerson));
            pstmt.setTimestamp(14, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(15, toDbCh(modiPerson));
            pstmt.setTimestamp(16, new java.sql.Timestamp(modiTime.getTime()));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,clubid,clubname,clubtype,clubacademy,clubacademynew,modifytype,modifyreason,commentxy,commentxynew,commenttw,checkflag,applydate,addperson,addtime,modiperson,moditime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(clubId));
            pstmt.setString(3, toDbCh(clubName));
            pstmt.setString(4, toDbCh(clubType));
            pstmt.setString(5, toDbCh(clubAcademy));
            pstmt.setString(6, toDbCh(clubAcadeMyNew));
            pstmt.setString(7, toDbCh(modifyType));
            pstmt.setString(8, toDbCh(modifyReason));
            pstmt.setString(9, toDbCh(commentXy));
            pstmt.setString(10, toDbCh(commentXyNew));
            pstmt.setString(11, toDbCh(commentTw));
            pstmt.setString(12, toDbCh(checkFlag));
            pstmt.setTimestamp(13, new java.sql.Timestamp(applyDate.getTime()));
            pstmt.setString(14, toDbCh(addPerson));
            pstmt.setTimestamp(15, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(16, toDbCh(modiPerson));
            pstmt.setTimestamp(17, new java.sql.Timestamp(modiTime.getTime()));
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
            ClubModify item = (ClubModify)it.next();
            ClubModify v = new ClubModify(dbname);
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
                if (modifiedFields.contains("ClubId")) { pstmt.setString(pi ++, toDbCh(clubId)); }
                if (modifiedFields.contains("ClubName")) { pstmt.setString(pi ++, toDbCh(clubName)); }
                if (modifiedFields.contains("ClubType")) { pstmt.setString(pi ++, toDbCh(clubType)); }
                if (modifiedFields.contains("ClubAcademy")) { pstmt.setString(pi ++, toDbCh(clubAcademy)); }
                if (modifiedFields.contains("ClubAcadeMyNew")) { pstmt.setString(pi ++, toDbCh(clubAcadeMyNew)); }
                if (modifiedFields.contains("ModifyType")) { pstmt.setString(pi ++, toDbCh(modifyType)); }
                if (modifiedFields.contains("ModifyReason")) { pstmt.setString(pi ++, toDbCh(modifyReason)); }
                if (modifiedFields.contains("CommentXy")) { pstmt.setString(pi ++, toDbCh(commentXy)); }
                if (modifiedFields.contains("CommentXyNew")) { pstmt.setString(pi ++, toDbCh(commentXyNew)); }
                if (modifiedFields.contains("CommentTw")) { pstmt.setString(pi ++, toDbCh(commentTw)); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setString(pi ++, toDbCh(checkFlag)); }
                if (modifiedFields.contains("ApplyDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(applyDate.getTime())); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
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
                if (modifiedFields.contains("ClubId")) { pstmt.setString(pi ++, toDbCh(clubId)); }
                if (modifiedFields.contains("ClubName")) { pstmt.setString(pi ++, toDbCh(clubName)); }
                if (modifiedFields.contains("ClubType")) { pstmt.setString(pi ++, toDbCh(clubType)); }
                if (modifiedFields.contains("ClubAcademy")) { pstmt.setString(pi ++, toDbCh(clubAcademy)); }
                if (modifiedFields.contains("ClubAcadeMyNew")) { pstmt.setString(pi ++, toDbCh(clubAcadeMyNew)); }
                if (modifiedFields.contains("ModifyType")) { pstmt.setString(pi ++, toDbCh(modifyType)); }
                if (modifiedFields.contains("ModifyReason")) { pstmt.setString(pi ++, toDbCh(modifyReason)); }
                if (modifiedFields.contains("CommentXy")) { pstmt.setString(pi ++, toDbCh(commentXy)); }
                if (modifiedFields.contains("CommentXyNew")) { pstmt.setString(pi ++, toDbCh(commentXyNew)); }
                if (modifiedFields.contains("CommentTw")) { pstmt.setString(pi ++, toDbCh(commentTw)); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setString(pi ++, toDbCh(checkFlag)); }
                if (modifiedFields.contains("ApplyDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(applyDate.getTime())); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("ModiPerson")) { pstmt.setString(pi ++, toDbCh(modiPerson)); }
                if (modifiedFields.contains("ModiTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modiTime.getTime())); }
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
        map.put("ClubId", getClubId());
        map.put("ClubName", getClubName());
        map.put("ClubType", getClubType());
        map.put("ClubAcademy", getClubAcademy());
        map.put("ClubAcadeMyNew", getClubAcadeMyNew());
        map.put("ModifyType", getModifyType());
        map.put("ModifyReason", getModifyReason());
        map.put("CommentXy", getCommentXy());
        map.put("CommentXyNew", getCommentXyNew());
        map.put("CommentTw", getCommentTw());
        map.put("CheckFlag", getCheckFlag());
        map.put("ApplyDate", Tool.stringOfDateTime(getApplyDate()));
        map.put("AddPerson", getAddPerson());
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("ModiPerson", getModiPerson());
        map.put("ModiTime", Tool.stringOfDateTime(getModiTime()));
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("ClubId:\"" + Tool.jsSpecialChars(getClubId()) + "\"");
        row.add("ClubName:\"" + Tool.jsSpecialChars(getClubName()) + "\"");
        row.add("ClubType:\"" + Tool.jsSpecialChars(getClubType()) + "\"");
        row.add("ClubAcademy:\"" + Tool.jsSpecialChars(getClubAcademy()) + "\"");
        row.add("ClubAcadeMyNew:\"" + Tool.jsSpecialChars(getClubAcadeMyNew()) + "\"");
        row.add("ModifyType:\"" + Tool.jsSpecialChars(getModifyType()) + "\"");
        row.add("ModifyReason:\"" + Tool.jsSpecialChars(getModifyReason()) + "\"");
        row.add("CommentXy:\"" + Tool.jsSpecialChars(getCommentXy()) + "\"");
        row.add("CommentXyNew:\"" + Tool.jsSpecialChars(getCommentXyNew()) + "\"");
        row.add("CommentTw:\"" + Tool.jsSpecialChars(getCommentTw()) + "\"");
        row.add("CheckFlag:\"" + Tool.jsSpecialChars(getCheckFlag()) + "\"");
        row.add("ApplyDate:\"" + Tool.stringOfDateTime(getApplyDate()) + "\"");
        row.add("AddPerson:\"" + Tool.jsSpecialChars(getAddPerson()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("ModiPerson:\"" + Tool.jsSpecialChars(getModiPerson()) + "\"");
        row.add("ModiTime:\"" + Tool.stringOfDateTime(getModiTime()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,clubid varchar2(45),clubname varchar2(45),clubtype varchar2(45),clubacademy varchar2(45),clubacademynew varchar2(45),modifytype varchar2(45),modifyreason varchar2(45),commentxy varchar2(500),commentxynew varchar2(500),commenttw varchar2(500),checkflag varchar2(45),applydate date,addperson varchar2(50),addtime date,modiperson varchar2(50),moditime date)"});
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
        ClubModify v = new ClubModify(sourceDb, sourceTb);
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
        ClubModify v = new ClubModify(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(ClubModify obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getClubId().compareTo(obj.getClubId()); if (rtn != 0) return rtn;
        rtn = getClubName().compareTo(obj.getClubName()); if (rtn != 0) return rtn;
        rtn = getClubType().compareTo(obj.getClubType()); if (rtn != 0) return rtn;
        rtn = getClubAcademy().compareTo(obj.getClubAcademy()); if (rtn != 0) return rtn;
        rtn = getClubAcadeMyNew().compareTo(obj.getClubAcadeMyNew()); if (rtn != 0) return rtn;
        rtn = getModifyType().compareTo(obj.getModifyType()); if (rtn != 0) return rtn;
        rtn = getModifyReason().compareTo(obj.getModifyReason()); if (rtn != 0) return rtn;
        rtn = getCommentXy().compareTo(obj.getCommentXy()); if (rtn != 0) return rtn;
        rtn = getCommentXyNew().compareTo(obj.getCommentXyNew()); if (rtn != 0) return rtn;
        rtn = getCommentTw().compareTo(obj.getCommentTw()); if (rtn != 0) return rtn;
        rtn = getCheckFlag().compareTo(obj.getCheckFlag()); if (rtn != 0) return rtn;
        rtn = getApplyDate().compareTo(obj.getApplyDate()); if (rtn != 0) return rtn;
        rtn = getAddPerson().compareTo(obj.getAddPerson()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = getModiPerson().compareTo(obj.getModiPerson()); if (rtn != 0) return rtn;
        rtn = getModiTime().compareTo(obj.getModiTime()); if (rtn != 0) return rtn;
        return rtn;
    }
}
