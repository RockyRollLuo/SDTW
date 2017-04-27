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
@Description("社团活动立项")
public class ClubActivityProject implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(ClubActivityProject.class);
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
    public static final String DbTableName = "club_activity_project";
    private String TNAME = "club_activity_project";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","projectName","projectDetail","projectId","projectLeader","projectUnit","timeStart","timeEnd","remark","addPerson","addTime","modiPerson","modiTime"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","projectname","projectdetail","projectid","projectleader","projectunit","timestart","timeend","remark","addperson","addtime","modiperson","moditime"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"ProjectName","projectname","String"},{"ProjectDetail","projectdetail","String"},{"ProjectId","projectid","String"},{"ProjectLeader","projectleader","String"},{"ProjectUnit","projectunit","String"},{"TimeStart","timestart","String"},{"TimeEnd","timeend","String"},{"Remark","remark","String"},{"AddPerson","addperson","String"},{"AddTime","addtime","java.util.Date"},{"ModiPerson","modiperson","String"},{"ModiTime","moditime","java.util.Date"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"projectName","projectname"},{"projectDetail","projectdetail"},{"projectId","projectid"},{"projectLeader","projectleader"},{"projectUnit","projectunit"},{"timeStart","timestart"},{"timeEnd","timeend"},{"remark","remark"},{"addPerson","addperson"},{"addTime","addtime"},{"modiPerson","modiperson"},{"modiTime","moditime"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME","MODITIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 项目名称
    protected String projectName = "";
    public String getProjectName() {  return SqlTool.getDbString(projectName);  }
    public String getProjectName(int size) { return SqlTool.subString(getProjectName(), size); }
    public void setProjectName(String aProjectName) { projectName = aProjectName; modifiedFields.add("ProjectName"); refreshFlag = true; }
    public void assignProjectName(String aProjectName) { projectName = aProjectName; }
    public void paramProjectName(HttpServletRequest request) { paramProjectName(request, "ProjectName"); }
    public void paramProjectName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectName()); if (!tmp.equals(getProjectName())) { setProjectName(tmp); } }
    // 项目详情
    protected String projectDetail = "";
    public String getProjectDetail() {  return SqlTool.getDbString(projectDetail);  }
    public String getProjectDetail(int size) { return SqlTool.subString(getProjectDetail(), size); }
    public void setProjectDetail(String aProjectDetail) { projectDetail = aProjectDetail; modifiedFields.add("ProjectDetail"); }
    public void assignProjectDetail(String aProjectDetail) { projectDetail = aProjectDetail; }
    public void paramProjectDetail(HttpServletRequest request) { paramProjectDetail(request, "ProjectDetail"); }
    public void paramProjectDetail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectDetail()); if (!tmp.equals(getProjectDetail())) { setProjectDetail(tmp); } }
    // 项目编码
    protected String projectId = "";
    public String getProjectId() {  return SqlTool.getDbString(projectId);  }
    public String getProjectId(int size) { return SqlTool.subString(getProjectId(), size); }
    public void setProjectId(String aProjectId) { projectId = aProjectId; modifiedFields.add("ProjectId"); }
    public void assignProjectId(String aProjectId) { projectId = aProjectId; }
    public void paramProjectId(HttpServletRequest request) { paramProjectId(request, "ProjectId"); }
    public void paramProjectId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectId()); if (!tmp.equals(getProjectId())) { setProjectId(tmp); } }
    // 负责人
    protected String projectLeader = "";
    public String getProjectLeader() {  return SqlTool.getDbString(projectLeader);  }
    public String getProjectLeader(int size) { return SqlTool.subString(getProjectLeader(), size); }
    public void setProjectLeader(String aProjectLeader) { projectLeader = aProjectLeader; modifiedFields.add("ProjectLeader"); }
    public void assignProjectLeader(String aProjectLeader) { projectLeader = aProjectLeader; }
    public void paramProjectLeader(HttpServletRequest request) { paramProjectLeader(request, "ProjectLeader"); }
    public void paramProjectLeader(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectLeader()); if (!tmp.equals(getProjectLeader())) { setProjectLeader(tmp); } }
    // 立项单位
    protected String projectUnit = "";
    public String getProjectUnit() {  return SqlTool.getDbString(projectUnit);  }
    public String getProjectUnit(int size) { return SqlTool.subString(getProjectUnit(), size); }
    public void setProjectUnit(String aProjectUnit) { projectUnit = aProjectUnit; modifiedFields.add("ProjectUnit"); }
    public void assignProjectUnit(String aProjectUnit) { projectUnit = aProjectUnit; }
    public void paramProjectUnit(HttpServletRequest request) { paramProjectUnit(request, "ProjectUnit"); }
    public void paramProjectUnit(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectUnit()); if (!tmp.equals(getProjectUnit())) { setProjectUnit(tmp); } }
    // 开始时间
    protected String timeStart = "";
    public String getTimeStart() {  return SqlTool.getDbString(timeStart);  }
    public String getTimeStart(int size) { return SqlTool.subString(getTimeStart(), size); }
    public void setTimeStart(String aTimeStart) { timeStart = aTimeStart; modifiedFields.add("TimeStart"); }
    public void assignTimeStart(String aTimeStart) { timeStart = aTimeStart; }
    public void paramTimeStart(HttpServletRequest request) { paramTimeStart(request, "TimeStart"); }
    public void paramTimeStart(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTimeStart()); if (!tmp.equals(getTimeStart())) { setTimeStart(tmp); } }
    // 结束时间
    protected String timeEnd = "";
    public String getTimeEnd() {  return SqlTool.getDbString(timeEnd);  }
    public String getTimeEnd(int size) { return SqlTool.subString(getTimeEnd(), size); }
    public void setTimeEnd(String aTimeEnd) { timeEnd = aTimeEnd; modifiedFields.add("TimeEnd"); }
    public void assignTimeEnd(String aTimeEnd) { timeEnd = aTimeEnd; }
    public void paramTimeEnd(HttpServletRequest request) { paramTimeEnd(request, "TimeEnd"); }
    public void paramTimeEnd(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTimeEnd()); if (!tmp.equals(getTimeEnd())) { setTimeEnd(tmp); } }
    // 备注
    protected String remark = "";
    public String getRemark() {  return SqlTool.getDbString(remark);  }
    public String getRemark(int size) { return SqlTool.subString(getRemark(), size); }
    public void setRemark(String aRemark) { remark = aRemark; modifiedFields.add("Remark"); }
    public void assignRemark(String aRemark) { remark = aRemark; }
    public void paramRemark(HttpServletRequest request) { paramRemark(request, "Remark"); }
    public void paramRemark(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark()); if (!tmp.equals(getRemark())) { setRemark(tmp); } }
    // 添加人
    protected String addPerson = "";
    public String getAddPerson() {  return SqlTool.getDbString(addPerson);  }
    public String getAddPerson(int size) { return SqlTool.subString(getAddPerson(), size); }
    public void setAddPerson(String aAddPerson) { addPerson = aAddPerson; modifiedFields.add("AddPerson"); }
    public void assignAddPerson(String aAddPerson) { addPerson = aAddPerson; }
    public void paramAddPerson(HttpServletRequest request) { paramAddPerson(request, "AddPerson"); }
    public void paramAddPerson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddPerson()); if (!tmp.equals(getAddPerson())) { setAddPerson(tmp); } }
    // 立项单位
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
    public ClubActivityProject (String db) {
        DBNAME = db;
    }
    public ClubActivityProject (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public ClubActivityProject (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public ClubActivityProject () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return ClubActivityProject类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public ClubActivityProject getByParameter(HttpServletRequest request) {
        ClubActivityProject v = new ClubActivityProject(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramProjectName(request);
        paramProjectDetail(request);
        paramProjectId(request);
        paramProjectLeader(request);
        paramProjectUnit(request);
        paramTimeStart(request);
        paramTimeEnd(request);
        paramRemark(request);
        paramAddPerson(request);
        paramAddTime(request);
        paramModiPerson(request);
        paramModiTime(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(ClubActivityProject bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("projectName")) { setProjectName(bean.getProjectName()); }
        if (!ncl.contains("projectDetail")) { setProjectDetail(bean.getProjectDetail()); }
        if (!ncl.contains("projectId")) { setProjectId(bean.getProjectId()); }
        if (!ncl.contains("projectLeader")) { setProjectLeader(bean.getProjectLeader()); }
        if (!ncl.contains("projectUnit")) { setProjectUnit(bean.getProjectUnit()); }
        if (!ncl.contains("timeStart")) { setTimeStart(bean.getTimeStart()); }
        if (!ncl.contains("timeEnd")) { setTimeEnd(bean.getTimeEnd()); }
        if (!ncl.contains("remark")) { setRemark(bean.getRemark()); }
        if (!ncl.contains("addPerson")) { setAddPerson(bean.getAddPerson()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("modiPerson")) { setModiPerson(bean.getModiPerson()); }
        if (!ncl.contains("modiTime")) { setModiTime(bean.getModiTime()); }
    }
    public ClubActivityProject getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        ClubActivityProject[] rslt= queryByCondition(cdt);
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
     * @return ClubActivityProject类的实例列表。
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
                ClubActivityProject ve = new ClubActivityProject(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignProjectName(fromDbCh(rs.getString(2)));
                ve.assignProjectDetail(fromDbCh(rs.getString(3)));
                ve.assignProjectId(fromDbCh(rs.getString(4)));
                ve.assignProjectLeader(fromDbCh(rs.getString(5)));
                ve.assignProjectUnit(fromDbCh(rs.getString(6)));
                ve.assignTimeStart(fromDbCh(rs.getString(7)));
                ve.assignTimeEnd(fromDbCh(rs.getString(8)));
                ve.assignRemark(fromDbCh(rs.getString(9)));
                ve.assignAddPerson(fromDbCh(rs.getString(10)));
                tmpDate = rs.getTimestamp(11); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignModiPerson(fromDbCh(rs.getString(12)));
                tmpDate = rs.getTimestamp(13); if (tmpDate != null) { ve.assignModiTime(new java.util.Date(tmpDate.getTime())); }
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
    public ClubActivityProject[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (ClubActivityProject[])vrs.toArray(new ClubActivityProject[vrs.size()]);
    }
    public ClubActivityProject[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (ClubActivityProject[])vrs.toArray(new ClubActivityProject[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (projectname,projectdetail,projectid,projectleader,projectunit,timestart,timeend,remark,addperson,addtime,modiperson,moditime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(projectName));
            pstmt.setString(2, toDbCh(projectDetail));
            pstmt.setString(3, toDbCh(projectId));
            pstmt.setString(4, toDbCh(projectLeader));
            pstmt.setString(5, toDbCh(projectUnit));
            pstmt.setString(6, toDbCh(timeStart));
            pstmt.setString(7, toDbCh(timeEnd));
            pstmt.setString(8, toDbCh(remark));
            pstmt.setString(9, toDbCh(addPerson));
            pstmt.setTimestamp(10, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(11, toDbCh(modiPerson));
            pstmt.setTimestamp(12, new java.sql.Timestamp(modiTime.getTime()));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.ClubActivityProject");
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,projectname,projectdetail,projectid,projectleader,projectunit,timestart,timeend,remark,addperson,addtime,modiperson,moditime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(projectName));
            pstmt.setString(3, toDbCh(projectDetail));
            pstmt.setString(4, toDbCh(projectId));
            pstmt.setString(5, toDbCh(projectLeader));
            pstmt.setString(6, toDbCh(projectUnit));
            pstmt.setString(7, toDbCh(timeStart));
            pstmt.setString(8, toDbCh(timeEnd));
            pstmt.setString(9, toDbCh(remark));
            pstmt.setString(10, toDbCh(addPerson));
            pstmt.setTimestamp(11, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(12, toDbCh(modiPerson));
            pstmt.setTimestamp(13, new java.sql.Timestamp(modiTime.getTime()));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.ClubActivityProject");
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
            ClubActivityProject item = (ClubActivityProject)it.next();
            ClubActivityProject v = new ClubActivityProject(dbname);
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
                if (modifiedFields.contains("ProjectName")) { pstmt.setString(pi ++, toDbCh(projectName)); }
                if (modifiedFields.contains("ProjectDetail")) { pstmt.setString(pi ++, toDbCh(projectDetail)); }
                if (modifiedFields.contains("ProjectId")) { pstmt.setString(pi ++, toDbCh(projectId)); }
                if (modifiedFields.contains("ProjectLeader")) { pstmt.setString(pi ++, toDbCh(projectLeader)); }
                if (modifiedFields.contains("ProjectUnit")) { pstmt.setString(pi ++, toDbCh(projectUnit)); }
                if (modifiedFields.contains("TimeStart")) { pstmt.setString(pi ++, toDbCh(timeStart)); }
                if (modifiedFields.contains("TimeEnd")) { pstmt.setString(pi ++, toDbCh(timeEnd)); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
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
        if (refreshFlag) {
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.ClubActivityProject");
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
                if (modifiedFields.contains("ProjectName")) { pstmt.setString(pi ++, toDbCh(projectName)); }
                if (modifiedFields.contains("ProjectDetail")) { pstmt.setString(pi ++, toDbCh(projectDetail)); }
                if (modifiedFields.contains("ProjectId")) { pstmt.setString(pi ++, toDbCh(projectId)); }
                if (modifiedFields.contains("ProjectLeader")) { pstmt.setString(pi ++, toDbCh(projectLeader)); }
                if (modifiedFields.contains("ProjectUnit")) { pstmt.setString(pi ++, toDbCh(projectUnit)); }
                if (modifiedFields.contains("TimeStart")) { pstmt.setString(pi ++, toDbCh(timeStart)); }
                if (modifiedFields.contains("TimeEnd")) { pstmt.setString(pi ++, toDbCh(timeEnd)); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
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
        if (refreshFlag) {
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.ClubActivityProject");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.ClubActivityProject");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.ClubActivityProject");
        return iResult;
    }
    public Map toMap() {
        Map map = new HashMap();
        map.put("Id", getId() + "");
        map.put("ProjectName", getProjectName());
        map.put("ProjectDetail", getProjectDetail());
        map.put("ProjectId", getProjectId());
        map.put("ProjectLeader", getProjectLeader());
        map.put("ProjectUnit", getProjectUnit());
        map.put("TimeStart", getTimeStart());
        map.put("TimeEnd", getTimeEnd());
        map.put("Remark", getRemark());
        map.put("AddPerson", getAddPerson());
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("ModiPerson", getModiPerson());
        map.put("ModiTime", Tool.stringOfDateTime(getModiTime()));
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("ProjectName:\"" + Tool.jsSpecialChars(getProjectName()) + "\"");
        row.add("ProjectDetail:\"" + Tool.jsSpecialChars(getProjectDetail()) + "\"");
        row.add("ProjectId:\"" + Tool.jsSpecialChars(getProjectId()) + "\"");
        row.add("ProjectLeader:\"" + Tool.jsSpecialChars(getProjectLeader()) + "\"");
        row.add("ProjectUnit:\"" + Tool.jsSpecialChars(getProjectUnit()) + "\"");
        row.add("TimeStart:\"" + Tool.jsSpecialChars(getTimeStart()) + "\"");
        row.add("TimeEnd:\"" + Tool.jsSpecialChars(getTimeEnd()) + "\"");
        row.add("Remark:\"" + Tool.jsSpecialChars(getRemark()) + "\"");
        row.add("AddPerson:\"" + Tool.jsSpecialChars(getAddPerson()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("ModiPerson:\"" + Tool.jsSpecialChars(getModiPerson()) + "\"");
        row.add("ModiTime:\"" + Tool.stringOfDateTime(getModiTime()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,projectname varchar2(45),projectdetail varchar2(500),projectid varchar2(45),projectleader varchar2(45),projectunit varchar2(45),timestart varchar2(15),timeend varchar2(15),remark varchar2(500),addperson varchar2(45),addtime date,modiperson varchar2(45),moditime date)"});
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
        ClubActivityProject v = new ClubActivityProject(sourceDb, sourceTb);
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
        ClubActivityProject v = new ClubActivityProject(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(ClubActivityProject obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getProjectName().compareTo(obj.getProjectName()); if (rtn != 0) return rtn;
        rtn = getProjectDetail().compareTo(obj.getProjectDetail()); if (rtn != 0) return rtn;
        rtn = getProjectId().compareTo(obj.getProjectId()); if (rtn != 0) return rtn;
        rtn = getProjectLeader().compareTo(obj.getProjectLeader()); if (rtn != 0) return rtn;
        rtn = getProjectUnit().compareTo(obj.getProjectUnit()); if (rtn != 0) return rtn;
        rtn = getTimeStart().compareTo(obj.getTimeStart()); if (rtn != 0) return rtn;
        rtn = getTimeEnd().compareTo(obj.getTimeEnd()); if (rtn != 0) return rtn;
        rtn = getRemark().compareTo(obj.getRemark()); if (rtn != 0) return rtn;
        rtn = getAddPerson().compareTo(obj.getAddPerson()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = getModiPerson().compareTo(obj.getModiPerson()); if (rtn != 0) return rtn;
        rtn = getModiTime().compareTo(obj.getModiTime()); if (rtn != 0) return rtn;
        return rtn;
    }
}
