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
@Description("在线用户")
public class BaseOnlineUser implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(BaseOnlineUser.class);
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
    private String DBNAME = "xhsd";
    public void setDataBase(String val) { DBNAME = val; }
    public String getDataBase() { return DBNAME; }
    public String getDBNAME() { if (DBNAME.length() > 0) return DBNAME + "." + TNAME; else return TNAME; }
    public static final String _DbType = "mysql";
    public String getDbType() { return _DbType; }
    // 保存当前连接的数据表名
    public static final String DbTableName = "base_onlineuser";
    private String TNAME = "base_onlineuser";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","orgId","deptId","occupation","logonTime","lastTime","lockTime","lockList"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","orgid","deptid","occupation","logontime","lasttime","locktime","locklist"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"OrgId","orgid","int"},{"DeptId","deptid","int"},{"Occupation","occupation","String"},{"LogonTime","logontime","java.util.Date"},{"LastTime","lasttime","java.util.Date"},{"LockTime","locktime","java.util.Date"},{"LockList","locklist","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"orgId","orgid"},{"deptId","deptid"},{"occupation","occupation"},{"logonTime","logontime"},{"lastTime","lasttime"},{"lockTime","locktime"},{"lockList","locklist"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"LOGONTIME","LASTTIME","LOCKTIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 单位
    protected int orgId = -1;
    public int getOrgId() { return orgId; }
    public void setOrgId(int aOrgId) { orgId = aOrgId; modifiedFields.add("OrgId"); }
    public void assignOrgId(int aOrgId) { orgId = aOrgId; }
    public void paramOrgId(HttpServletRequest request) { paramOrgId(request, "OrgId"); }
    public void paramOrgId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getOrgId()); if (tmp != getOrgId()) { setOrgId(tmp); } }
    // 部门
    protected int deptId = -1;
    public int getDeptId() { return deptId; }
    public void setDeptId(int aDeptId) { deptId = aDeptId; modifiedFields.add("DeptId"); }
    public void assignDeptId(int aDeptId) { deptId = aDeptId; }
    public void paramDeptId(HttpServletRequest request) { paramDeptId(request, "DeptId"); }
    public void paramDeptId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getDeptId()); if (tmp != getDeptId()) { setDeptId(tmp); } }
    // 职务
    protected String occupation = "";
    public String getOccupation() {  return SqlTool.getDbString(occupation);  }
    public String getOccupation(int size) { return SqlTool.subString(getOccupation(), size); }
    public void setOccupation(String aOccupation) { occupation = aOccupation; modifiedFields.add("Occupation"); }
    public void assignOccupation(String aOccupation) { occupation = aOccupation; }
    public void paramOccupation(HttpServletRequest request) { paramOccupation(request, "Occupation"); }
    public void paramOccupation(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOccupation()); if (!tmp.equals(getOccupation())) { setOccupation(tmp); } }
    // 登录时间
    protected java.util.Date logonTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getLogonTime() { return logonTime; }
    public void setLogonTime(java.util.Date aLogonTime) { logonTime = aLogonTime; modifiedFields.add("LogonTime"); }
    public void assignLogonTime(java.util.Date aLogonTime) { logonTime = aLogonTime; }
    public void paramLogonTime(HttpServletRequest request) { paramLogonTime(request, "LogonTime"); }
    public void paramLogonTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getLogonTime()); if (tmp.compareTo(getLogonTime()) != 0) { setLogonTime(tmp); } }
    // 最近时间
    protected java.util.Date lastTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getLastTime() { return lastTime; }
    public void setLastTime(java.util.Date aLastTime) { lastTime = aLastTime; modifiedFields.add("LastTime"); }
    public void assignLastTime(java.util.Date aLastTime) { lastTime = aLastTime; }
    public void paramLastTime(HttpServletRequest request) { paramLastTime(request, "LastTime"); }
    public void paramLastTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getLastTime()); if (tmp.compareTo(getLastTime()) != 0) { setLastTime(tmp); } }
    // 锁定时间
    protected java.util.Date lockTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getLockTime() { return lockTime; }
    public void setLockTime(java.util.Date aLockTime) { lockTime = aLockTime; modifiedFields.add("LockTime"); }
    public void assignLockTime(java.util.Date aLockTime) { lockTime = aLockTime; }
    public void paramLockTime(HttpServletRequest request) { paramLockTime(request, "LockTime"); }
    public void paramLockTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getLockTime()); if (tmp.compareTo(getLockTime()) != 0) { setLockTime(tmp); } }
    // 锁定
    protected String lockList = "";
    public String getLockList() {  return SqlTool.getDbString(lockList);  }
    public String getLockList(int size) { return SqlTool.subString(getLockList(), size); }
    public void setLockList(String aLockList) { lockList = aLockList; modifiedFields.add("LockList"); }
    public void assignLockList(String aLockList) { lockList = aLockList; }
    public void paramLockList(HttpServletRequest request) { paramLockList(request, "LockList"); }
    public void paramLockList(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getLockList()); if (!tmp.equals(getLockList())) { setLockList(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public BaseOnlineUser (String db) {
        DBNAME = db;
    }
    public BaseOnlineUser (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public BaseOnlineUser (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public BaseOnlineUser () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return BaseOnlineUser类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public BaseOnlineUser getByParameter(HttpServletRequest request) {
        BaseOnlineUser v = new BaseOnlineUser(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramOrgId(request);
        paramDeptId(request);
        paramOccupation(request);
        paramLogonTime(request);
        paramLastTime(request);
        paramLockTime(request);
        paramLockList(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(BaseOnlineUser bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("orgId")) { setOrgId(bean.getOrgId()); }
        if (!ncl.contains("deptId")) { setDeptId(bean.getDeptId()); }
        if (!ncl.contains("occupation")) { setOccupation(bean.getOccupation()); }
        if (!ncl.contains("logonTime")) { setLogonTime(bean.getLogonTime()); }
        if (!ncl.contains("lastTime")) { setLastTime(bean.getLastTime()); }
        if (!ncl.contains("lockTime")) { setLockTime(bean.getLockTime()); }
        if (!ncl.contains("lockList")) { setLockList(bean.getLockList()); }
    }
    public BaseOnlineUser getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        BaseOnlineUser[] rslt= queryByCondition(cdt);
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
     * @return BaseOnlineUser类的实例列表。
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
                BaseOnlineUser ve = new BaseOnlineUser(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignOrgId(rs.getInt(2));
                ve.assignDeptId(rs.getInt(3));
                ve.assignOccupation(fromDbCh(rs.getString(4)));
                tmpDate = rs.getTimestamp(5); if (tmpDate != null) { ve.assignLogonTime(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(6); if (tmpDate != null) { ve.assignLastTime(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(7); if (tmpDate != null) { ve.assignLockTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignLockList(fromDbCh(rs.getString(8)));
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
    public BaseOnlineUser[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (BaseOnlineUser[])vrs.toArray(new BaseOnlineUser[vrs.size()]);
    }
    public BaseOnlineUser[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (BaseOnlineUser[])vrs.toArray(new BaseOnlineUser[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (orgid,deptid,occupation,logontime,lasttime,locktime,locklist) VALUES (?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, orgId);
            pstmt.setInt(2, deptId);
            pstmt.setString(3, toDbCh(occupation));
            pstmt.setTimestamp(4, new java.sql.Timestamp(logonTime.getTime()));
            pstmt.setTimestamp(5, new java.sql.Timestamp(lastTime.getTime()));
            pstmt.setTimestamp(6, new java.sql.Timestamp(lockTime.getTime()));
            pstmt.setString(7, toDbCh(lockList));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,orgid,deptid,occupation,logontime,lasttime,locktime,locklist) VALUES (?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, orgId);
            pstmt.setInt(3, deptId);
            pstmt.setString(4, toDbCh(occupation));
            pstmt.setTimestamp(5, new java.sql.Timestamp(logonTime.getTime()));
            pstmt.setTimestamp(6, new java.sql.Timestamp(lastTime.getTime()));
            pstmt.setTimestamp(7, new java.sql.Timestamp(lockTime.getTime()));
            pstmt.setString(8, toDbCh(lockList));
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
            BaseOnlineUser item = (BaseOnlineUser)it.next();
            BaseOnlineUser v = new BaseOnlineUser(dbname);
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
                if (modifiedFields.contains("OrgId")) { pstmt.setInt(pi ++, orgId); }
                if (modifiedFields.contains("DeptId")) { pstmt.setInt(pi ++, deptId); }
                if (modifiedFields.contains("Occupation")) { pstmt.setString(pi ++, toDbCh(occupation)); }
                if (modifiedFields.contains("LogonTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(logonTime.getTime())); }
                if (modifiedFields.contains("LastTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(lastTime.getTime())); }
                if (modifiedFields.contains("LockTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(lockTime.getTime())); }
                if (modifiedFields.contains("LockList")) { pstmt.setString(pi ++, toDbCh(lockList)); }
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
                if (modifiedFields.contains("OrgId")) { pstmt.setInt(pi ++, orgId); }
                if (modifiedFields.contains("DeptId")) { pstmt.setInt(pi ++, deptId); }
                if (modifiedFields.contains("Occupation")) { pstmt.setString(pi ++, toDbCh(occupation)); }
                if (modifiedFields.contains("LogonTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(logonTime.getTime())); }
                if (modifiedFields.contains("LastTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(lastTime.getTime())); }
                if (modifiedFields.contains("LockTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(lockTime.getTime())); }
                if (modifiedFields.contains("LockList")) { pstmt.setString(pi ++, toDbCh(lockList)); }
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
        map.put("OrgId", getOrgId() + "");
        map.put("DeptId", getDeptId() + "");
        map.put("Occupation", getOccupation());
        map.put("LogonTime", Tool.stringOfDateTime(getLogonTime()));
        map.put("LastTime", Tool.stringOfDateTime(getLastTime()));
        map.put("LockTime", Tool.stringOfDateTime(getLockTime()));
        map.put("LockList", getLockList());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("OrgId:\"" + getOrgId() + "\"");
        row.add("DeptId:\"" + getDeptId() + "\"");
        row.add("Occupation:\"" + Tool.jsSpecialChars(getOccupation()) + "\"");
        row.add("LogonTime:\"" + Tool.stringOfDateTime(getLogonTime()) + "\"");
        row.add("LastTime:\"" + Tool.stringOfDateTime(getLastTime()) + "\"");
        row.add("LockTime:\"" + Tool.stringOfDateTime(getLockTime()) + "\"");
        row.add("LockList:\"" + Tool.jsSpecialChars(getLockList()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,orgid number(*,0),deptid number(*,0),occupation varchar2(100),logontime date,lasttime date,locktime date,locklist varchar2(100))"});
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
        BaseOnlineUser v = new BaseOnlineUser(sourceDb, sourceTb);
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
        BaseOnlineUser v = new BaseOnlineUser(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(BaseOnlineUser obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getOrgId()).compareTo("" + obj.getOrgId()); if (rtn != 0) return rtn;
        rtn = ("" + getDeptId()).compareTo("" + obj.getDeptId()); if (rtn != 0) return rtn;
        rtn = getOccupation().compareTo(obj.getOccupation()); if (rtn != 0) return rtn;
        rtn = getLogonTime().compareTo(obj.getLogonTime()); if (rtn != 0) return rtn;
        rtn = getLastTime().compareTo(obj.getLastTime()); if (rtn != 0) return rtn;
        rtn = getLockTime().compareTo(obj.getLockTime()); if (rtn != 0) return rtn;
        rtn = getLockList().compareTo(obj.getLockList()); if (rtn != 0) return rtn;
        return rtn;
    }
}
