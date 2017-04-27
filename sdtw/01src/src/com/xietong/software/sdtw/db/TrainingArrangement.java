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
@Description("团校培训管理")
public class TrainingArrangement implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(TrainingArrangement.class);
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
    public static final String DbTableName = "training_arrangement";
    private String TNAME = "training_arrangement";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","projectName","hostName","hostId","otherUniversity","addUseraccount","startTime","endTime","addTime","addPerson","modifyTime","modifyUseraccount","modifyPerson","addFileList","projectExplain"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","projectname","hostname","hostid","otheruniversity","adduseraccount","starttime","endtime","addtime","addperson","modifytime","modifyuseraccount","modifyperson","addfilelist","projectexplain"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"ProjectName","projectname","String"},{"HostName","hostname","String"},{"HostId","hostid","String"},{"OtherUniversity","otheruniversity","int"},{"AddUseraccount","adduseraccount","String"},{"StartTime","starttime","java.util.Date"},{"EndTime","endtime","java.util.Date"},{"AddTime","addtime","java.util.Date"},{"AddPerson","addperson","String"},{"ModifyTime","modifytime","java.util.Date"},{"ModifyUseraccount","modifyuseraccount","String"},{"ModifyPerson","modifyperson","String"},{"AddFileList","addfilelist","String"},{"ProjectExplain","projectexplain","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"projectName","projectname"},{"hostName","hostname"},{"hostId","hostid"},{"otherUniversity","otheruniversity"},{"addUseraccount","adduseraccount"},{"startTime","starttime"},{"endTime","endtime"},{"addTime","addtime"},{"addPerson","addperson"},{"modifyTime","modifytime"},{"modifyUseraccount","modifyuseraccount"},{"modifyPerson","modifyperson"},{"addFileList","addfilelist"},{"projectExplain","projectexplain"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"STARTTIME","ENDTIME","ADDTIME","MODIFYTIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 学习项目名称
    protected String projectName = "";
    public String getProjectName() {  return SqlTool.getDbString(projectName);  }
    public String getProjectName(int size) { return SqlTool.subString(getProjectName(), size); }
    public void setProjectName(String aProjectName) { projectName = aProjectName; modifiedFields.add("ProjectName"); }
    public void assignProjectName(String aProjectName) { projectName = aProjectName; }
    public void paramProjectName(HttpServletRequest request) { paramProjectName(request, "ProjectName"); }
    public void paramProjectName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectName()); if (!tmp.equals(getProjectName())) { setProjectName(tmp); } }
    // 负责人
    protected String hostName = "";
    public String getHostName() {  return SqlTool.getDbString(hostName);  }
    public String getHostName(int size) { return SqlTool.subString(getHostName(), size); }
    public void setHostName(String aHostName) { hostName = aHostName; modifiedFields.add("HostName"); }
    public void assignHostName(String aHostName) { hostName = aHostName; }
    public void paramHostName(HttpServletRequest request) { paramHostName(request, "HostName"); }
    public void paramHostName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHostName()); if (!tmp.equals(getHostName())) { setHostName(tmp); } }
    // 负责人id
    protected String hostId = "";
    public String getHostId() {  return SqlTool.getDbString(hostId);  }
    public String getHostId(int size) { return SqlTool.subString(getHostId(), size); }
    public void setHostId(String aHostId) { hostId = aHostId; modifiedFields.add("HostId"); }
    public void assignHostId(String aHostId) { hostId = aHostId; }
    public void paramHostId(HttpServletRequest request) { paramHostId(request, "HostId"); }
    public void paramHostId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHostId()); if (!tmp.equals(getHostId())) { setHostId(tmp); } }
    // 是否外校
    protected int otherUniversity = 0;
    public int getOtherUniversity() { return otherUniversity; }
    public void setOtherUniversity(int aOtherUniversity) { otherUniversity = aOtherUniversity; modifiedFields.add("OtherUniversity"); }
    public void assignOtherUniversity(int aOtherUniversity) { otherUniversity = aOtherUniversity; }
    public void paramOtherUniversity(HttpServletRequest request) { paramOtherUniversity(request, "OtherUniversity"); }
    public void paramOtherUniversity(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getOtherUniversity()); if (tmp != getOtherUniversity()) { setOtherUniversity(tmp); } }
    // 校外负责人学校
    protected String addUseraccount = "";
    public String getAddUseraccount() {  return SqlTool.getDbString(addUseraccount);  }
    public String getAddUseraccount(int size) { return SqlTool.subString(getAddUseraccount(), size); }
    public void setAddUseraccount(String aAddUseraccount) { addUseraccount = aAddUseraccount; modifiedFields.add("AddUseraccount"); }
    public void assignAddUseraccount(String aAddUseraccount) { addUseraccount = aAddUseraccount; }
    public void paramAddUseraccount(HttpServletRequest request) { paramAddUseraccount(request, "AddUseraccount"); }
    public void paramAddUseraccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddUseraccount()); if (!tmp.equals(getAddUseraccount())) { setAddUseraccount(tmp); } }
    // 开始时间
    protected java.util.Date startTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getStartTime() { return startTime; }
    public void setStartTime(java.util.Date aStartTime) { startTime = aStartTime; modifiedFields.add("StartTime"); }
    public void assignStartTime(java.util.Date aStartTime) { startTime = aStartTime; }
    public void paramStartTime(HttpServletRequest request) { paramStartTime(request, "StartTime"); }
    public void paramStartTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getStartTime()); if (tmp.compareTo(getStartTime()) != 0) { setStartTime(tmp); } }
    // 结束时间
    protected java.util.Date endTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getEndTime() { return endTime; }
    public void setEndTime(java.util.Date aEndTime) { endTime = aEndTime; modifiedFields.add("EndTime"); }
    public void assignEndTime(java.util.Date aEndTime) { endTime = aEndTime; }
    public void paramEndTime(HttpServletRequest request) { paramEndTime(request, "EndTime"); }
    public void paramEndTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getEndTime()); if (tmp.compareTo(getEndTime()) != 0) { setEndTime(tmp); } }
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
    protected java.util.Date modifyTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getModifyTime() { return modifyTime; }
    public void setModifyTime(java.util.Date aModifyTime) { modifyTime = aModifyTime; modifiedFields.add("ModifyTime"); }
    public void assignModifyTime(java.util.Date aModifyTime) { modifyTime = aModifyTime; }
    public void paramModifyTime(HttpServletRequest request) { paramModifyTime(request, "ModifyTime"); }
    public void paramModifyTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getModifyTime()); if (tmp.compareTo(getModifyTime()) != 0) { setModifyTime(tmp); } }
    // 修改人账号
    protected String modifyUseraccount = "";
    public String getModifyUseraccount() {  return SqlTool.getDbString(modifyUseraccount);  }
    public String getModifyUseraccount(int size) { return SqlTool.subString(getModifyUseraccount(), size); }
    public void setModifyUseraccount(String aModifyUseraccount) { modifyUseraccount = aModifyUseraccount; modifiedFields.add("ModifyUseraccount"); }
    public void assignModifyUseraccount(String aModifyUseraccount) { modifyUseraccount = aModifyUseraccount; }
    public void paramModifyUseraccount(HttpServletRequest request) { paramModifyUseraccount(request, "ModifyUseraccount"); }
    public void paramModifyUseraccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getModifyUseraccount()); if (!tmp.equals(getModifyUseraccount())) { setModifyUseraccount(tmp); } }
    // 修改人
    protected String modifyPerson = "";
    public String getModifyPerson() {  return SqlTool.getDbString(modifyPerson);  }
    public String getModifyPerson(int size) { return SqlTool.subString(getModifyPerson(), size); }
    public void setModifyPerson(String aModifyPerson) { modifyPerson = aModifyPerson; modifiedFields.add("ModifyPerson"); }
    public void assignModifyPerson(String aModifyPerson) { modifyPerson = aModifyPerson; }
    public void paramModifyPerson(HttpServletRequest request) { paramModifyPerson(request, "ModifyPerson"); }
    public void paramModifyPerson(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getModifyPerson()); if (!tmp.equals(getModifyPerson())) { setModifyPerson(tmp); } }
    // 附件
    protected String addFileList = "";
    public String getAddFileList() {  return SqlTool.getDbString(addFileList);  }
    public String getAddFileList(int size) { return SqlTool.subString(getAddFileList(), size); }
    public void setAddFileList(String aAddFileList) { addFileList = aAddFileList; modifiedFields.add("AddFileList"); }
    public void assignAddFileList(String aAddFileList) { addFileList = aAddFileList; }
    public void paramAddFileList(HttpServletRequest request) { paramAddFileList(request, "AddFileList"); }
    public void paramAddFileList(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddFileList()); if (!tmp.equals(getAddFileList())) { setAddFileList(tmp); } }
    // 项目说明
    protected String projectExplain = "";
    public String getProjectExplain() {  return SqlTool.getDbString(projectExplain);  }
    public String getProjectExplain(int size) { return SqlTool.subString(getProjectExplain(), size); }
    public void setProjectExplain(String aProjectExplain) { projectExplain = aProjectExplain; modifiedFields.add("ProjectExplain"); }
    public void assignProjectExplain(String aProjectExplain) { projectExplain = aProjectExplain; }
    public void paramProjectExplain(HttpServletRequest request) { paramProjectExplain(request, "ProjectExplain"); }
    public void paramProjectExplain(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getProjectExplain()); if (!tmp.equals(getProjectExplain())) { setProjectExplain(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public TrainingArrangement (String db) {
        DBNAME = db;
    }
    public TrainingArrangement (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public TrainingArrangement (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public TrainingArrangement () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return TrainingArrangement类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public TrainingArrangement getByParameter(HttpServletRequest request) {
        TrainingArrangement v = new TrainingArrangement(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramProjectName(request);
        paramHostName(request);
        paramHostId(request);
        paramOtherUniversity(request);
        paramAddUseraccount(request);
        paramStartTime(request);
        paramEndTime(request);
        paramAddTime(request);
        paramAddPerson(request);
        paramModifyTime(request);
        paramModifyUseraccount(request);
        paramModifyPerson(request);
        paramAddFileList(request);
        paramProjectExplain(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(TrainingArrangement bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("projectName")) { setProjectName(bean.getProjectName()); }
        if (!ncl.contains("hostName")) { setHostName(bean.getHostName()); }
        if (!ncl.contains("hostId")) { setHostId(bean.getHostId()); }
        if (!ncl.contains("otherUniversity")) { setOtherUniversity(bean.getOtherUniversity()); }
        if (!ncl.contains("addUseraccount")) { setAddUseraccount(bean.getAddUseraccount()); }
        if (!ncl.contains("startTime")) { setStartTime(bean.getStartTime()); }
        if (!ncl.contains("endTime")) { setEndTime(bean.getEndTime()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("addPerson")) { setAddPerson(bean.getAddPerson()); }
        if (!ncl.contains("modifyTime")) { setModifyTime(bean.getModifyTime()); }
        if (!ncl.contains("modifyUseraccount")) { setModifyUseraccount(bean.getModifyUseraccount()); }
        if (!ncl.contains("modifyPerson")) { setModifyPerson(bean.getModifyPerson()); }
        if (!ncl.contains("addFileList")) { setAddFileList(bean.getAddFileList()); }
        if (!ncl.contains("projectExplain")) { setProjectExplain(bean.getProjectExplain()); }
    }
    public TrainingArrangement getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        TrainingArrangement[] rslt= queryByCondition(cdt);
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
     * @return TrainingArrangement类的实例列表。
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
                TrainingArrangement ve = new TrainingArrangement(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignProjectName(fromDbCh(rs.getString(2)));
                ve.assignHostName(fromDbCh(rs.getString(3)));
                ve.assignHostId(fromDbCh(rs.getString(4)));
                ve.assignOtherUniversity(rs.getInt(5));
                ve.assignAddUseraccount(fromDbCh(rs.getString(6)));
                tmpDate = rs.getTimestamp(7); if (tmpDate != null) { ve.assignStartTime(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(8); if (tmpDate != null) { ve.assignEndTime(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(9); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignAddPerson(fromDbCh(rs.getString(10)));
                tmpDate = rs.getTimestamp(11); if (tmpDate != null) { ve.assignModifyTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignModifyUseraccount(fromDbCh(rs.getString(12)));
                ve.assignModifyPerson(fromDbCh(rs.getString(13)));
                ve.assignAddFileList(fromDbCh(rs.getString(14)));
                ve.assignProjectExplain(fromDbCh(rs.getString(15)));
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
    public TrainingArrangement[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (TrainingArrangement[])vrs.toArray(new TrainingArrangement[vrs.size()]);
    }
    public TrainingArrangement[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (TrainingArrangement[])vrs.toArray(new TrainingArrangement[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (projectname,hostname,hostid,otheruniversity,adduseraccount,starttime,endtime,addtime,addperson,modifytime,modifyuseraccount,modifyperson,addfilelist,projectexplain) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(projectName));
            pstmt.setString(2, toDbCh(hostName));
            pstmt.setString(3, toDbCh(hostId));
            pstmt.setInt(4, otherUniversity);
            pstmt.setString(5, toDbCh(addUseraccount));
            pstmt.setTimestamp(6, new java.sql.Timestamp(startTime.getTime()));
            pstmt.setTimestamp(7, new java.sql.Timestamp(endTime.getTime()));
            pstmt.setTimestamp(8, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(9, toDbCh(addPerson));
            pstmt.setTimestamp(10, new java.sql.Timestamp(modifyTime.getTime()));
            pstmt.setString(11, toDbCh(modifyUseraccount));
            pstmt.setString(12, toDbCh(modifyPerson));
            pstmt.setString(13, toDbCh(addFileList));
            pstmt.setString(14, toDbCh(projectExplain));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,projectname,hostname,hostid,otheruniversity,adduseraccount,starttime,endtime,addtime,addperson,modifytime,modifyuseraccount,modifyperson,addfilelist,projectexplain) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(projectName));
            pstmt.setString(3, toDbCh(hostName));
            pstmt.setString(4, toDbCh(hostId));
            pstmt.setInt(5, otherUniversity);
            pstmt.setString(6, toDbCh(addUseraccount));
            pstmt.setTimestamp(7, new java.sql.Timestamp(startTime.getTime()));
            pstmt.setTimestamp(8, new java.sql.Timestamp(endTime.getTime()));
            pstmt.setTimestamp(9, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(10, toDbCh(addPerson));
            pstmt.setTimestamp(11, new java.sql.Timestamp(modifyTime.getTime()));
            pstmt.setString(12, toDbCh(modifyUseraccount));
            pstmt.setString(13, toDbCh(modifyPerson));
            pstmt.setString(14, toDbCh(addFileList));
            pstmt.setString(15, toDbCh(projectExplain));
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
            TrainingArrangement item = (TrainingArrangement)it.next();
            TrainingArrangement v = new TrainingArrangement(dbname);
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
                if (modifiedFields.contains("HostName")) { pstmt.setString(pi ++, toDbCh(hostName)); }
                if (modifiedFields.contains("HostId")) { pstmt.setString(pi ++, toDbCh(hostId)); }
                if (modifiedFields.contains("OtherUniversity")) { pstmt.setInt(pi ++, otherUniversity); }
                if (modifiedFields.contains("AddUseraccount")) { pstmt.setString(pi ++, toDbCh(addUseraccount)); }
                if (modifiedFields.contains("StartTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(startTime.getTime())); }
                if (modifiedFields.contains("EndTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(endTime.getTime())); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("ModifyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modifyTime.getTime())); }
                if (modifiedFields.contains("ModifyUseraccount")) { pstmt.setString(pi ++, toDbCh(modifyUseraccount)); }
                if (modifiedFields.contains("ModifyPerson")) { pstmt.setString(pi ++, toDbCh(modifyPerson)); }
                if (modifiedFields.contains("AddFileList")) { pstmt.setString(pi ++, toDbCh(addFileList)); }
                if (modifiedFields.contains("ProjectExplain")) { pstmt.setString(pi ++, toDbCh(projectExplain)); }
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
                if (modifiedFields.contains("ProjectName")) { pstmt.setString(pi ++, toDbCh(projectName)); }
                if (modifiedFields.contains("HostName")) { pstmt.setString(pi ++, toDbCh(hostName)); }
                if (modifiedFields.contains("HostId")) { pstmt.setString(pi ++, toDbCh(hostId)); }
                if (modifiedFields.contains("OtherUniversity")) { pstmt.setInt(pi ++, otherUniversity); }
                if (modifiedFields.contains("AddUseraccount")) { pstmt.setString(pi ++, toDbCh(addUseraccount)); }
                if (modifiedFields.contains("StartTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(startTime.getTime())); }
                if (modifiedFields.contains("EndTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(endTime.getTime())); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("AddPerson")) { pstmt.setString(pi ++, toDbCh(addPerson)); }
                if (modifiedFields.contains("ModifyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(modifyTime.getTime())); }
                if (modifiedFields.contains("ModifyUseraccount")) { pstmt.setString(pi ++, toDbCh(modifyUseraccount)); }
                if (modifiedFields.contains("ModifyPerson")) { pstmt.setString(pi ++, toDbCh(modifyPerson)); }
                if (modifiedFields.contains("AddFileList")) { pstmt.setString(pi ++, toDbCh(addFileList)); }
                if (modifiedFields.contains("ProjectExplain")) { pstmt.setString(pi ++, toDbCh(projectExplain)); }
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
        map.put("ProjectName", getProjectName());
        map.put("HostName", getHostName());
        map.put("HostId", getHostId());
        map.put("OtherUniversity", getOtherUniversity() + "");
        map.put("AddUseraccount", getAddUseraccount());
        map.put("StartTime", Tool.stringOfDateTime(getStartTime()));
        map.put("EndTime", Tool.stringOfDateTime(getEndTime()));
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("AddPerson", getAddPerson());
        map.put("ModifyTime", Tool.stringOfDateTime(getModifyTime()));
        map.put("ModifyUseraccount", getModifyUseraccount());
        map.put("ModifyPerson", getModifyPerson());
        map.put("AddFileList", getAddFileList());
        map.put("ProjectExplain", getProjectExplain());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("ProjectName:\"" + Tool.jsSpecialChars(getProjectName()) + "\"");
        row.add("HostName:\"" + Tool.jsSpecialChars(getHostName()) + "\"");
        row.add("HostId:\"" + Tool.jsSpecialChars(getHostId()) + "\"");
        row.add("OtherUniversity:\"" + getOtherUniversity() + "\"");
        row.add("AddUseraccount:\"" + Tool.jsSpecialChars(getAddUseraccount()) + "\"");
        row.add("StartTime:\"" + Tool.stringOfDateTime(getStartTime()) + "\"");
        row.add("EndTime:\"" + Tool.stringOfDateTime(getEndTime()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("AddPerson:\"" + Tool.jsSpecialChars(getAddPerson()) + "\"");
        row.add("ModifyTime:\"" + Tool.stringOfDateTime(getModifyTime()) + "\"");
        row.add("ModifyUseraccount:\"" + Tool.jsSpecialChars(getModifyUseraccount()) + "\"");
        row.add("ModifyPerson:\"" + Tool.jsSpecialChars(getModifyPerson()) + "\"");
        row.add("AddFileList:\"" + Tool.jsSpecialChars(getAddFileList()) + "\"");
        row.add("ProjectExplain:\"" + Tool.jsSpecialChars(getProjectExplain()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,projectname varchar2(2000),hostname varchar2(2000),hostid varchar2(2000),otheruniversity number(*,0),adduseraccount varchar2(2000),starttime date,endtime date,addtime date,addperson varchar2(2000),modifytime date,modifyuseraccount varchar2(2000),modifyperson varchar2(2000),addfilelist varchar2(2000),projectexplain varchar2(2000))"});
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
        TrainingArrangement v = new TrainingArrangement(sourceDb, sourceTb);
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
        TrainingArrangement v = new TrainingArrangement(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(TrainingArrangement obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getProjectName().compareTo(obj.getProjectName()); if (rtn != 0) return rtn;
        rtn = getHostName().compareTo(obj.getHostName()); if (rtn != 0) return rtn;
        rtn = getHostId().compareTo(obj.getHostId()); if (rtn != 0) return rtn;
        rtn = ("" + getOtherUniversity()).compareTo("" + obj.getOtherUniversity()); if (rtn != 0) return rtn;
        rtn = getAddUseraccount().compareTo(obj.getAddUseraccount()); if (rtn != 0) return rtn;
        rtn = getStartTime().compareTo(obj.getStartTime()); if (rtn != 0) return rtn;
        rtn = getEndTime().compareTo(obj.getEndTime()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = getAddPerson().compareTo(obj.getAddPerson()); if (rtn != 0) return rtn;
        rtn = getModifyTime().compareTo(obj.getModifyTime()); if (rtn != 0) return rtn;
        rtn = getModifyUseraccount().compareTo(obj.getModifyUseraccount()); if (rtn != 0) return rtn;
        rtn = getModifyPerson().compareTo(obj.getModifyPerson()); if (rtn != 0) return rtn;
        rtn = getAddFileList().compareTo(obj.getAddFileList()); if (rtn != 0) return rtn;
        rtn = getProjectExplain().compareTo(obj.getProjectExplain()); if (rtn != 0) return rtn;
        return rtn;
    }
}
