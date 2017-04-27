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
@Description("学生会部门")
public class StudentUnionDept implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(StudentUnionDept.class);
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
    public static final String DbTableName = "studentuniondept";
    private String TNAME = "studentuniondept";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","unionId","listOrder","deptName","principal","contact","functionstr","deptprofile","addfilelist","addtime","addaccount"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","unionid","listorder","deptname","principal","contact","functionstr","deptprofile","addfilelist","addtime","addaccount"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"UnionId","unionid","int"},{"ListOrder","listorder","String"},{"DeptName","deptname","String"},{"Principal","principal","java.util.Date"},{"Contact","contact","String"},{"Functionstr","functionstr","String"},{"Deptprofile","deptprofile","String"},{"Addfilelist","addfilelist","String"},{"Addtime","addtime","String"},{"Addaccount","addaccount","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"unionId","unionid"},{"listOrder","listorder"},{"deptName","deptname"},{"principal","principal"},{"contact","contact"},{"functionstr","functionstr"},{"deptprofile","deptprofile"},{"addfilelist","addfilelist"},{"addtime","addtime"},{"addaccount","addaccount"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"PRINCIPAL"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 校级院级学生会id
    protected int unionId = -1;
    public int getUnionId() { return unionId; }
    public void setUnionId(int aUnionId) { unionId = aUnionId; modifiedFields.add("UnionId"); }
    public void assignUnionId(int aUnionId) { unionId = aUnionId; }
    public void paramUnionId(HttpServletRequest request) { paramUnionId(request, "UnionId"); }
    public void paramUnionId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getUnionId()); if (tmp != getUnionId()) { setUnionId(tmp); } }
    // 排序
    protected String listOrder = "";
    public String getListOrder() {  return SqlTool.getDbString(listOrder);  }
    public String getListOrder(int size) { return SqlTool.subString(getListOrder(), size); }
    public void setListOrder(String aListOrder) { listOrder = aListOrder; modifiedFields.add("ListOrder"); }
    public void assignListOrder(String aListOrder) { listOrder = aListOrder; }
    public void paramListOrder(HttpServletRequest request) { paramListOrder(request, "ListOrder"); }
    public void paramListOrder(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getListOrder()); if (!tmp.equals(getListOrder())) { setListOrder(tmp); } }
    // 部门
    protected String deptName = "";
    public String getDeptName() {  return SqlTool.getDbString(deptName);  }
    public String getDeptName(int size) { return SqlTool.subString(getDeptName(), size); }
    public void setDeptName(String aDeptName) { deptName = aDeptName; modifiedFields.add("DeptName"); refreshFlag = true; }
    public void assignDeptName(String aDeptName) { deptName = aDeptName; }
    public void paramDeptName(HttpServletRequest request) { paramDeptName(request, "DeptName"); }
    public void paramDeptName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeptName()); if (!tmp.equals(getDeptName())) { setDeptName(tmp); } }
    // 发布人
    protected java.util.Date principal = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getPrincipal() { return principal; }
    public void setPrincipal(java.util.Date aPrincipal) { principal = aPrincipal; modifiedFields.add("Principal"); }
    public void assignPrincipal(java.util.Date aPrincipal) { principal = aPrincipal; }
    public void paramPrincipal(HttpServletRequest request) { paramPrincipal(request, "Principal"); }
    public void paramPrincipal(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getPrincipal()); if (tmp.compareTo(getPrincipal()) != 0) { setPrincipal(tmp); } }
    // 联系方式
    protected String contact = "";
    public String getContact() {  return SqlTool.getDbString(contact);  }
    public String getContact(int size) { return SqlTool.subString(getContact(), size); }
    public void setContact(String aContact) { contact = aContact; modifiedFields.add("Contact"); }
    public void assignContact(String aContact) { contact = aContact; }
    public void paramContact(HttpServletRequest request) { paramContact(request, "Contact"); }
    public void paramContact(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getContact()); if (!tmp.equals(getContact())) { setContact(tmp); } }
    // 主要只能
    protected String functionstr = "";
    public String getFunctionstr() {  return SqlTool.getDbString(functionstr);  }
    public String getFunctionstr(int size) { return SqlTool.subString(getFunctionstr(), size); }
    public void setFunctionstr(String aFunctionstr) { functionstr = aFunctionstr; modifiedFields.add("Functionstr"); }
    public void assignFunctionstr(String aFunctionstr) { functionstr = aFunctionstr; }
    public void paramFunctionstr(HttpServletRequest request) { paramFunctionstr(request, "Functionstr"); }
    public void paramFunctionstr(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFunctionstr()); if (!tmp.equals(getFunctionstr())) { setFunctionstr(tmp); } }
    // 部门简介
    protected String deptprofile = "";
    public String getDeptprofile() {  return SqlTool.getDbString(deptprofile);  }
    public String getDeptprofile(int size) { return SqlTool.subString(getDeptprofile(), size); }
    public void setDeptprofile(String aDeptprofile) { deptprofile = aDeptprofile; modifiedFields.add("Deptprofile"); }
    public void assignDeptprofile(String aDeptprofile) { deptprofile = aDeptprofile; }
    public void paramDeptprofile(HttpServletRequest request) { paramDeptprofile(request, "Deptprofile"); }
    public void paramDeptprofile(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDeptprofile()); if (!tmp.equals(getDeptprofile())) { setDeptprofile(tmp); } }
    // 附件
    protected String addfilelist = "";
    public String getAddfilelist() {  return SqlTool.getDbString(addfilelist);  }
    public String getAddfilelist(int size) { return SqlTool.subString(getAddfilelist(), size); }
    public void setAddfilelist(String aAddfilelist) { addfilelist = aAddfilelist; modifiedFields.add("Addfilelist"); }
    public void assignAddfilelist(String aAddfilelist) { addfilelist = aAddfilelist; }
    public void paramAddfilelist(HttpServletRequest request) { paramAddfilelist(request, "Addfilelist"); }
    public void paramAddfilelist(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddfilelist()); if (!tmp.equals(getAddfilelist())) { setAddfilelist(tmp); } }
    // 添加时间
    protected String addtime = "";
    public String getAddtime() {  return SqlTool.getDbString(addtime);  }
    public String getAddtime(int size) { return SqlTool.subString(getAddtime(), size); }
    public void setAddtime(String aAddtime) { addtime = aAddtime; modifiedFields.add("Addtime"); }
    public void assignAddtime(String aAddtime) { addtime = aAddtime; }
    public void paramAddtime(HttpServletRequest request) { paramAddtime(request, "Addtime"); }
    public void paramAddtime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddtime()); if (!tmp.equals(getAddtime())) { setAddtime(tmp); } }
    // 添加人
    protected String addaccount = "";
    public String getAddaccount() {  return SqlTool.getDbString(addaccount);  }
    public String getAddaccount(int size) { return SqlTool.subString(getAddaccount(), size); }
    public void setAddaccount(String aAddaccount) { addaccount = aAddaccount; modifiedFields.add("Addaccount"); }
    public void assignAddaccount(String aAddaccount) { addaccount = aAddaccount; }
    public void paramAddaccount(HttpServletRequest request) { paramAddaccount(request, "Addaccount"); }
    public void paramAddaccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddaccount()); if (!tmp.equals(getAddaccount())) { setAddaccount(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public StudentUnionDept (String db) {
        DBNAME = db;
    }
    public StudentUnionDept (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public StudentUnionDept (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public StudentUnionDept () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return StudentUnionDept类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public StudentUnionDept getByParameter(HttpServletRequest request) {
        StudentUnionDept v = new StudentUnionDept(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramUnionId(request);
        paramListOrder(request);
        paramDeptName(request);
        paramPrincipal(request);
        paramContact(request);
        paramFunctionstr(request);
        paramDeptprofile(request);
        paramAddfilelist(request);
        paramAddtime(request);
        paramAddaccount(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(StudentUnionDept bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("unionId")) { setUnionId(bean.getUnionId()); }
        if (!ncl.contains("listOrder")) { setListOrder(bean.getListOrder()); }
        if (!ncl.contains("deptName")) { setDeptName(bean.getDeptName()); }
        if (!ncl.contains("principal")) { setPrincipal(bean.getPrincipal()); }
        if (!ncl.contains("contact")) { setContact(bean.getContact()); }
        if (!ncl.contains("functionstr")) { setFunctionstr(bean.getFunctionstr()); }
        if (!ncl.contains("deptprofile")) { setDeptprofile(bean.getDeptprofile()); }
        if (!ncl.contains("addfilelist")) { setAddfilelist(bean.getAddfilelist()); }
        if (!ncl.contains("addtime")) { setAddtime(bean.getAddtime()); }
        if (!ncl.contains("addaccount")) { setAddaccount(bean.getAddaccount()); }
    }
    public StudentUnionDept getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        StudentUnionDept[] rslt= queryByCondition(cdt);
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
     * @return StudentUnionDept类的实例列表。
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
                StudentUnionDept ve = new StudentUnionDept(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignUnionId(rs.getInt(2));
                ve.assignListOrder(fromDbCh(rs.getString(3)));
                ve.assignDeptName(fromDbCh(rs.getString(4)));
                tmpDate = rs.getTimestamp(5); if (tmpDate != null) { ve.assignPrincipal(new java.util.Date(tmpDate.getTime())); }
                ve.assignContact(fromDbCh(rs.getString(6)));
                ve.assignFunctionstr(fromDbCh(rs.getString(7)));
                ve.assignDeptprofile(fromDbCh(rs.getString(8)));
                ve.assignAddfilelist(fromDbCh(rs.getString(9)));
                ve.assignAddtime(fromDbCh(rs.getString(10)));
                ve.assignAddaccount(fromDbCh(rs.getString(11)));
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
    public StudentUnionDept[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (StudentUnionDept[])vrs.toArray(new StudentUnionDept[vrs.size()]);
    }
    public StudentUnionDept[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (StudentUnionDept[])vrs.toArray(new StudentUnionDept[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (unionid,listorder,deptname,principal,contact,functionstr,deptprofile,addfilelist,addtime,addaccount) VALUES (?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, unionId);
            pstmt.setString(2, toDbCh(listOrder));
            pstmt.setString(3, toDbCh(deptName));
            pstmt.setTimestamp(4, new java.sql.Timestamp(principal.getTime()));
            pstmt.setString(5, toDbCh(contact));
            pstmt.setString(6, toDbCh(functionstr));
            pstmt.setString(7, toDbCh(deptprofile));
            pstmt.setString(8, toDbCh(addfilelist));
            pstmt.setString(9, toDbCh(addtime));
            pstmt.setString(10, toDbCh(addaccount));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.StudentUnionDept");
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,unionid,listorder,deptname,principal,contact,functionstr,deptprofile,addfilelist,addtime,addaccount) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, unionId);
            pstmt.setString(3, toDbCh(listOrder));
            pstmt.setString(4, toDbCh(deptName));
            pstmt.setTimestamp(5, new java.sql.Timestamp(principal.getTime()));
            pstmt.setString(6, toDbCh(contact));
            pstmt.setString(7, toDbCh(functionstr));
            pstmt.setString(8, toDbCh(deptprofile));
            pstmt.setString(9, toDbCh(addfilelist));
            pstmt.setString(10, toDbCh(addtime));
            pstmt.setString(11, toDbCh(addaccount));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.StudentUnionDept");
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
            StudentUnionDept item = (StudentUnionDept)it.next();
            StudentUnionDept v = new StudentUnionDept(dbname);
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
                if (modifiedFields.contains("UnionId")) { pstmt.setInt(pi ++, unionId); }
                if (modifiedFields.contains("ListOrder")) { pstmt.setString(pi ++, toDbCh(listOrder)); }
                if (modifiedFields.contains("DeptName")) { pstmt.setString(pi ++, toDbCh(deptName)); }
                if (modifiedFields.contains("Principal")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(principal.getTime())); }
                if (modifiedFields.contains("Contact")) { pstmt.setString(pi ++, toDbCh(contact)); }
                if (modifiedFields.contains("Functionstr")) { pstmt.setString(pi ++, toDbCh(functionstr)); }
                if (modifiedFields.contains("Deptprofile")) { pstmt.setString(pi ++, toDbCh(deptprofile)); }
                if (modifiedFields.contains("Addfilelist")) { pstmt.setString(pi ++, toDbCh(addfilelist)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setString(pi ++, toDbCh(addtime)); }
                if (modifiedFields.contains("Addaccount")) { pstmt.setString(pi ++, toDbCh(addaccount)); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.StudentUnionDept");
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
                if (modifiedFields.contains("UnionId")) { pstmt.setInt(pi ++, unionId); }
                if (modifiedFields.contains("ListOrder")) { pstmt.setString(pi ++, toDbCh(listOrder)); }
                if (modifiedFields.contains("DeptName")) { pstmt.setString(pi ++, toDbCh(deptName)); }
                if (modifiedFields.contains("Principal")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(principal.getTime())); }
                if (modifiedFields.contains("Contact")) { pstmt.setString(pi ++, toDbCh(contact)); }
                if (modifiedFields.contains("Functionstr")) { pstmt.setString(pi ++, toDbCh(functionstr)); }
                if (modifiedFields.contains("Deptprofile")) { pstmt.setString(pi ++, toDbCh(deptprofile)); }
                if (modifiedFields.contains("Addfilelist")) { pstmt.setString(pi ++, toDbCh(addfilelist)); }
                if (modifiedFields.contains("Addtime")) { pstmt.setString(pi ++, toDbCh(addtime)); }
                if (modifiedFields.contains("Addaccount")) { pstmt.setString(pi ++, toDbCh(addaccount)); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.StudentUnionDept");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.StudentUnionDept");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.StudentUnionDept");
        return iResult;
    }
    public Map toMap() {
        Map map = new HashMap();
        map.put("Id", getId() + "");
        map.put("UnionId", getUnionId() + "");
        map.put("ListOrder", getListOrder());
        map.put("DeptName", getDeptName());
        map.put("Principal", Tool.stringOfDateTime(getPrincipal()));
        map.put("Contact", getContact());
        map.put("Functionstr", getFunctionstr());
        map.put("Deptprofile", getDeptprofile());
        map.put("Addfilelist", getAddfilelist());
        map.put("Addtime", getAddtime());
        map.put("Addaccount", getAddaccount());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("UnionId:\"" + getUnionId() + "\"");
        row.add("ListOrder:\"" + Tool.jsSpecialChars(getListOrder()) + "\"");
        row.add("DeptName:\"" + Tool.jsSpecialChars(getDeptName()) + "\"");
        row.add("Principal:\"" + Tool.stringOfDateTime(getPrincipal()) + "\"");
        row.add("Contact:\"" + Tool.jsSpecialChars(getContact()) + "\"");
        row.add("Functionstr:\"" + Tool.jsSpecialChars(getFunctionstr()) + "\"");
        row.add("Deptprofile:\"" + Tool.jsSpecialChars(getDeptprofile()) + "\"");
        row.add("Addfilelist:\"" + Tool.jsSpecialChars(getAddfilelist()) + "\"");
        row.add("Addtime:\"" + Tool.jsSpecialChars(getAddtime()) + "\"");
        row.add("Addaccount:\"" + Tool.jsSpecialChars(getAddaccount()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,unionid number(*,0),listorder varchar2(200),deptname varchar2(200),principal date,contact varchar2(45),functionstr varchar2(45),deptprofile varchar2(45),addfilelist varchar2(45),addtime varchar2(45),addaccount varchar2(45))"});
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
        StudentUnionDept v = new StudentUnionDept(sourceDb, sourceTb);
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
        StudentUnionDept v = new StudentUnionDept(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(StudentUnionDept obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getUnionId()).compareTo("" + obj.getUnionId()); if (rtn != 0) return rtn;
        rtn = getListOrder().compareTo(obj.getListOrder()); if (rtn != 0) return rtn;
        rtn = getDeptName().compareTo(obj.getDeptName()); if (rtn != 0) return rtn;
        rtn = getPrincipal().compareTo(obj.getPrincipal()); if (rtn != 0) return rtn;
        rtn = getContact().compareTo(obj.getContact()); if (rtn != 0) return rtn;
        rtn = getFunctionstr().compareTo(obj.getFunctionstr()); if (rtn != 0) return rtn;
        rtn = getDeptprofile().compareTo(obj.getDeptprofile()); if (rtn != 0) return rtn;
        rtn = getAddfilelist().compareTo(obj.getAddfilelist()); if (rtn != 0) return rtn;
        rtn = getAddtime().compareTo(obj.getAddtime()); if (rtn != 0) return rtn;
        rtn = getAddaccount().compareTo(obj.getAddaccount()); if (rtn != 0) return rtn;
        return rtn;
    }
}
