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
@Description("部门信息")
public class BaseDeptCode implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(BaseDeptCode.class);
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
    public static final String DbTableName = "base_deptcode";
    private String TNAME = "base_deptcode";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","orgId","pid","name","leaders","style","code","orderby","reptDept","address","postCode","tel","fax","email","remark","enable"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","orgid","pid","name","leaders","style","code","orderby","reptdept","address","postcode","tel","fax","email","remark","enable"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"OrgId","orgid","int"},{"Pid","pid","int"},{"Name","name","String"},{"Leaders","leaders","String"},{"Style","style","String"},{"Code","code","String"},{"Orderby","orderby","int"},{"ReptDept","reptdept","String"},{"Address","address","String"},{"PostCode","postcode","String"},{"Tel","tel","String"},{"Fax","fax","String"},{"Email","email","String"},{"Remark","remark","String"},{"Enable","enable","int"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"orgId","orgid"},{"pid","pid"},{"name","name"},{"leaders","leaders"},{"style","style"},{"code","code"},{"orderby","orderby"},{"reptDept","reptdept"},{"address","address"},{"postCode","postcode"},{"tel","tel"},{"fax","fax"},{"email","email"},{"remark","remark"},{"enable","enable"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 所属单位
    protected int orgId = -1;
    public int getOrgId() { return orgId; }
    public void setOrgId(int aOrgId) { orgId = aOrgId; modifiedFields.add("OrgId"); }
    public void assignOrgId(int aOrgId) { orgId = aOrgId; }
    public void paramOrgId(HttpServletRequest request) { paramOrgId(request, "OrgId"); }
    public void paramOrgId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getOrgId()); if (tmp != getOrgId()) { setOrgId(tmp); } }
    // 上级部门
    protected int pid = -1;
    public int getPid() { return pid; }
    public void setPid(int aPid) { pid = aPid; modifiedFields.add("Pid"); }
    public void assignPid(int aPid) { pid = aPid; }
    public void paramPid(HttpServletRequest request) { paramPid(request, "Pid"); }
    public void paramPid(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getPid()); if (tmp != getPid()) { setPid(tmp); } }
    // 部门名称
    protected String name = "";
    public String getName() {  return SqlTool.getDbString(name);  }
    public String getName(int size) { return SqlTool.subString(getName(), size); }
    public void setName(String aName) { name = aName; modifiedFields.add("Name"); refreshFlag = true; }
    public void assignName(String aName) { name = aName; }
    public void paramName(HttpServletRequest request) { paramName(request, "Name"); }
    public void paramName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getName()); if (!tmp.equals(getName())) { setName(tmp); } }
    // 部门领导
    protected String leaders = "";
    public String getLeaders() {  return SqlTool.getDbString(leaders);  }
    public String getLeaders(int size) { return SqlTool.subString(getLeaders(), size); }
    public void setLeaders(String aLeaders) { leaders = aLeaders; modifiedFields.add("Leaders"); }
    public void assignLeaders(String aLeaders) { leaders = aLeaders; }
    public void paramLeaders(HttpServletRequest request) { paramLeaders(request, "Leaders"); }
    public void paramLeaders(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getLeaders()); if (!tmp.equals(getLeaders())) { setLeaders(tmp); } }
    // 部门类型
    protected String style = "";
    public String getStyle() {  return SqlTool.getDbString(style);  }
    public String getStyle(int size) { return SqlTool.subString(getStyle(), size); }
    public void setStyle(String aStyle) { style = aStyle; modifiedFields.add("Style"); }
    public void assignStyle(String aStyle) { style = aStyle; }
    public void paramStyle(HttpServletRequest request) { paramStyle(request, "Style"); }
    public void paramStyle(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getStyle()); if (!tmp.equals(getStyle())) { setStyle(tmp); } }
    // 部门编码
    protected String code = "";
    public String getCode() {  return SqlTool.getDbString(code);  }
    public String getCode(int size) { return SqlTool.subString(getCode(), size); }
    public void setCode(String aCode) { code = aCode; modifiedFields.add("Code"); }
    public void assignCode(String aCode) { code = aCode; }
    public void paramCode(HttpServletRequest request) { paramCode(request, "Code"); }
    public void paramCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCode()); if (!tmp.equals(getCode())) { setCode(tmp); } }
    // 排序
    protected int orderby = -1;
    public int getOrderby() { return orderby; }
    public void setOrderby(int aOrderby) { orderby = aOrderby; modifiedFields.add("Orderby"); }
    public void assignOrderby(int aOrderby) { orderby = aOrderby; }
    public void paramOrderby(HttpServletRequest request) { paramOrderby(request, "Orderby"); }
    public void paramOrderby(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getOrderby()); if (tmp != getOrderby()) { setOrderby(tmp); } }
    // 上级主管部门
    protected String reptDept = "";
    public String getReptDept() {  return SqlTool.getDbString(reptDept);  }
    public String getReptDept(int size) { return SqlTool.subString(getReptDept(), size); }
    public void setReptDept(String aReptDept) { reptDept = aReptDept; modifiedFields.add("ReptDept"); }
    public void assignReptDept(String aReptDept) { reptDept = aReptDept; }
    public void paramReptDept(HttpServletRequest request) { paramReptDept(request, "ReptDept"); }
    public void paramReptDept(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReptDept()); if (!tmp.equals(getReptDept())) { setReptDept(tmp); } }
    // 部门地址
    protected String address = "";
    public String getAddress() {  return SqlTool.getDbString(address);  }
    public String getAddress(int size) { return SqlTool.subString(getAddress(), size); }
    public void setAddress(String aAddress) { address = aAddress; modifiedFields.add("Address"); }
    public void assignAddress(String aAddress) { address = aAddress; }
    public void paramAddress(HttpServletRequest request) { paramAddress(request, "Address"); }
    public void paramAddress(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddress()); if (!tmp.equals(getAddress())) { setAddress(tmp); } }
    // 邮政编码
    protected String postCode = "";
    public String getPostCode() {  return SqlTool.getDbString(postCode);  }
    public String getPostCode(int size) { return SqlTool.subString(getPostCode(), size); }
    public void setPostCode(String aPostCode) { postCode = aPostCode; modifiedFields.add("PostCode"); }
    public void assignPostCode(String aPostCode) { postCode = aPostCode; }
    public void paramPostCode(HttpServletRequest request) { paramPostCode(request, "PostCode"); }
    public void paramPostCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPostCode()); if (!tmp.equals(getPostCode())) { setPostCode(tmp); } }
    // 部门电话
    protected String tel = "";
    public String getTel() {  return SqlTool.getDbString(tel);  }
    public String getTel(int size) { return SqlTool.subString(getTel(), size); }
    public void setTel(String aTel) { tel = aTel; modifiedFields.add("Tel"); }
    public void assignTel(String aTel) { tel = aTel; }
    public void paramTel(HttpServletRequest request) { paramTel(request, "Tel"); }
    public void paramTel(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTel()); if (!tmp.equals(getTel())) { setTel(tmp); } }
    // 传真号码
    protected String fax = "";
    public String getFax() {  return SqlTool.getDbString(fax);  }
    public String getFax(int size) { return SqlTool.subString(getFax(), size); }
    public void setFax(String aFax) { fax = aFax; modifiedFields.add("Fax"); }
    public void assignFax(String aFax) { fax = aFax; }
    public void paramFax(HttpServletRequest request) { paramFax(request, "Fax"); }
    public void paramFax(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFax()); if (!tmp.equals(getFax())) { setFax(tmp); } }
    // 部门邮箱
    protected String email = "";
    public String getEmail() {  return SqlTool.getDbString(email);  }
    public String getEmail(int size) { return SqlTool.subString(getEmail(), size); }
    public void setEmail(String aEmail) { email = aEmail; modifiedFields.add("Email"); }
    public void assignEmail(String aEmail) { email = aEmail; }
    public void paramEmail(HttpServletRequest request) { paramEmail(request, "Email"); }
    public void paramEmail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getEmail()); if (!tmp.equals(getEmail())) { setEmail(tmp); } }
    // 备注
    protected String remark = "";
    public String getRemark() {  return SqlTool.getDbString(remark);  }
    public String getRemark(int size) { return SqlTool.subString(getRemark(), size); }
    public void setRemark(String aRemark) { remark = aRemark; modifiedFields.add("Remark"); }
    public void assignRemark(String aRemark) { remark = aRemark; }
    public void paramRemark(HttpServletRequest request) { paramRemark(request, "Remark"); }
    public void paramRemark(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark()); if (!tmp.equals(getRemark())) { setRemark(tmp); } }
    // Enable
    protected int enable = 1;
    public int getEnable() { return enable; }
    public void setEnable(int aEnable) { enable = aEnable; modifiedFields.add("Enable"); }
    public void assignEnable(int aEnable) { enable = aEnable; }
    public void paramEnable(HttpServletRequest request) { paramEnable(request, "Enable"); }
    public void paramEnable(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getEnable()); if (tmp != getEnable()) { setEnable(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public BaseDeptCode (String db) {
        DBNAME = db;
    }
    public BaseDeptCode (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public BaseDeptCode (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public BaseDeptCode () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return BaseDeptCode类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public BaseDeptCode getByParameter(HttpServletRequest request) {
        BaseDeptCode v = new BaseDeptCode(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramOrgId(request);
        paramPid(request);
        paramName(request);
        paramLeaders(request);
        paramStyle(request);
        paramCode(request);
        paramOrderby(request);
        paramReptDept(request);
        paramAddress(request);
        paramPostCode(request);
        paramTel(request);
        paramFax(request);
        paramEmail(request);
        paramRemark(request);
        paramEnable(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(BaseDeptCode bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("orgId")) { setOrgId(bean.getOrgId()); }
        if (!ncl.contains("pid")) { setPid(bean.getPid()); }
        if (!ncl.contains("name")) { setName(bean.getName()); }
        if (!ncl.contains("leaders")) { setLeaders(bean.getLeaders()); }
        if (!ncl.contains("style")) { setStyle(bean.getStyle()); }
        if (!ncl.contains("code")) { setCode(bean.getCode()); }
        if (!ncl.contains("orderby")) { setOrderby(bean.getOrderby()); }
        if (!ncl.contains("reptDept")) { setReptDept(bean.getReptDept()); }
        if (!ncl.contains("address")) { setAddress(bean.getAddress()); }
        if (!ncl.contains("postCode")) { setPostCode(bean.getPostCode()); }
        if (!ncl.contains("tel")) { setTel(bean.getTel()); }
        if (!ncl.contains("fax")) { setFax(bean.getFax()); }
        if (!ncl.contains("email")) { setEmail(bean.getEmail()); }
        if (!ncl.contains("remark")) { setRemark(bean.getRemark()); }
        if (!ncl.contains("enable")) { setEnable(bean.getEnable()); }
    }
    public BaseDeptCode getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        BaseDeptCode[] rslt= queryByCondition(cdt);
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
     * @return BaseDeptCode类的实例列表。
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
                BaseDeptCode ve = new BaseDeptCode(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignOrgId(rs.getInt(2));
                ve.assignPid(rs.getInt(3));
                ve.assignName(fromDbCh(rs.getString(4)));
                ve.assignLeaders(fromDbCh(rs.getString(5)));
                ve.assignStyle(fromDbCh(rs.getString(6)));
                ve.assignCode(fromDbCh(rs.getString(7)));
                ve.assignOrderby(rs.getInt(8));
                ve.assignReptDept(fromDbCh(rs.getString(9)));
                ve.assignAddress(fromDbCh(rs.getString(10)));
                ve.assignPostCode(fromDbCh(rs.getString(11)));
                ve.assignTel(fromDbCh(rs.getString(12)));
                ve.assignFax(fromDbCh(rs.getString(13)));
                ve.assignEmail(fromDbCh(rs.getString(14)));
                ve.assignRemark(fromDbCh(rs.getString(15)));
                ve.assignEnable(rs.getInt(16));
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
    public BaseDeptCode[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (BaseDeptCode[])vrs.toArray(new BaseDeptCode[vrs.size()]);
    }
    public BaseDeptCode[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (BaseDeptCode[])vrs.toArray(new BaseDeptCode[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (orgid,pid,name,leaders,style,code,orderby,reptdept,address,postcode,tel,fax,email,remark,enable) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, orgId);
            pstmt.setInt(2, pid);
            pstmt.setString(3, toDbCh(name));
            pstmt.setString(4, toDbCh(leaders));
            pstmt.setString(5, toDbCh(style));
            pstmt.setString(6, toDbCh(code));
            pstmt.setInt(7, orderby);
            pstmt.setString(8, toDbCh(reptDept));
            pstmt.setString(9, toDbCh(address));
            pstmt.setString(10, toDbCh(postCode));
            pstmt.setString(11, toDbCh(tel));
            pstmt.setString(12, toDbCh(fax));
            pstmt.setString(13, toDbCh(email));
            pstmt.setString(14, toDbCh(remark));
            pstmt.setInt(15, enable);
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseDeptCode");
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,orgid,pid,name,leaders,style,code,orderby,reptdept,address,postcode,tel,fax,email,remark,enable) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, orgId);
            pstmt.setInt(3, pid);
            pstmt.setString(4, toDbCh(name));
            pstmt.setString(5, toDbCh(leaders));
            pstmt.setString(6, toDbCh(style));
            pstmt.setString(7, toDbCh(code));
            pstmt.setInt(8, orderby);
            pstmt.setString(9, toDbCh(reptDept));
            pstmt.setString(10, toDbCh(address));
            pstmt.setString(11, toDbCh(postCode));
            pstmt.setString(12, toDbCh(tel));
            pstmt.setString(13, toDbCh(fax));
            pstmt.setString(14, toDbCh(email));
            pstmt.setString(15, toDbCh(remark));
            pstmt.setInt(16, enable);
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseDeptCode");
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
            BaseDeptCode item = (BaseDeptCode)it.next();
            BaseDeptCode v = new BaseDeptCode(dbname);
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
                if (modifiedFields.contains("Pid")) { pstmt.setInt(pi ++, pid); }
                if (modifiedFields.contains("Name")) { pstmt.setString(pi ++, toDbCh(name)); }
                if (modifiedFields.contains("Leaders")) { pstmt.setString(pi ++, toDbCh(leaders)); }
                if (modifiedFields.contains("Style")) { pstmt.setString(pi ++, toDbCh(style)); }
                if (modifiedFields.contains("Code")) { pstmt.setString(pi ++, toDbCh(code)); }
                if (modifiedFields.contains("Orderby")) { pstmt.setInt(pi ++, orderby); }
                if (modifiedFields.contains("ReptDept")) { pstmt.setString(pi ++, toDbCh(reptDept)); }
                if (modifiedFields.contains("Address")) { pstmt.setString(pi ++, toDbCh(address)); }
                if (modifiedFields.contains("PostCode")) { pstmt.setString(pi ++, toDbCh(postCode)); }
                if (modifiedFields.contains("Tel")) { pstmt.setString(pi ++, toDbCh(tel)); }
                if (modifiedFields.contains("Fax")) { pstmt.setString(pi ++, toDbCh(fax)); }
                if (modifiedFields.contains("Email")) { pstmt.setString(pi ++, toDbCh(email)); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("Enable")) { pstmt.setInt(pi ++, enable); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseDeptCode");
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
                if (modifiedFields.contains("OrgId")) { pstmt.setInt(pi ++, orgId); }
                if (modifiedFields.contains("Pid")) { pstmt.setInt(pi ++, pid); }
                if (modifiedFields.contains("Name")) { pstmt.setString(pi ++, toDbCh(name)); }
                if (modifiedFields.contains("Leaders")) { pstmt.setString(pi ++, toDbCh(leaders)); }
                if (modifiedFields.contains("Style")) { pstmt.setString(pi ++, toDbCh(style)); }
                if (modifiedFields.contains("Code")) { pstmt.setString(pi ++, toDbCh(code)); }
                if (modifiedFields.contains("Orderby")) { pstmt.setInt(pi ++, orderby); }
                if (modifiedFields.contains("ReptDept")) { pstmt.setString(pi ++, toDbCh(reptDept)); }
                if (modifiedFields.contains("Address")) { pstmt.setString(pi ++, toDbCh(address)); }
                if (modifiedFields.contains("PostCode")) { pstmt.setString(pi ++, toDbCh(postCode)); }
                if (modifiedFields.contains("Tel")) { pstmt.setString(pi ++, toDbCh(tel)); }
                if (modifiedFields.contains("Fax")) { pstmt.setString(pi ++, toDbCh(fax)); }
                if (modifiedFields.contains("Email")) { pstmt.setString(pi ++, toDbCh(email)); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("Enable")) { pstmt.setInt(pi ++, enable); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseDeptCode");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseDeptCode");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseDeptCode");
        return iResult;
    }
    public TreeItem cloneTi(BaseDeptCode item) {
        TreeItem ti = new TreeItem();
        ti.setId(item.getId());
        ti.setPid(item.getPid());
        ti.setName(item.getName());
        ti.setCode(item.getCode());
        ti.setOrders("" + item.getOrderby());
        ti.setClassName("BaseDeptCode");
        return ti;
    }
    public String findRootKey(Map parent) {
        List allids = new ArrayList();
        for (Iterator mit = parent.keySet().iterator(); mit.hasNext();) {
            String key = (String)mit.next();
            List list = (List)parent.get(key);
            for (Iterator it = list.iterator(); it.hasNext();) {
                BaseDeptCode v = (BaseDeptCode)it.next();
                allids.add("" + v.getId());
            }
        }
        for (Iterator mit = parent.keySet().iterator(); mit.hasNext();) {
            String key = (String)mit.next();
            if (!allids.contains(key)) {
                return key;
            }
        }
        return "";
    }
    public TreeItem initTree(BaseDeptCode item, Map parent) {
        TreeItem ti = cloneTi(item);
        List list = (List)parent.get("" + item.getId());
        if (list != null) {
            for (Iterator it = list.iterator(); it.hasNext();) {
                BaseDeptCode v = (BaseDeptCode)it.next();
                TreeItem nti = cloneTi(v);
                TreeItem sti = initTree(v, parent);
                if (sti.equals(nti)) {
                    ti.put(sti.getId(), sti);
                }
                else {
                    sti.put(nti.getId(), nti);
                }
            }
        }
        return ti;
    }
    public Map initParentMap(List cdt) {
        List vs = query(cdt);
        Map map = new HashMap();
        for (Iterator it = vs.iterator(); it.hasNext();) {
            BaseDeptCode v = (BaseDeptCode)it.next();
            List child = (List)map.get("" + v.getPid());
            if (child == null) {
                child = new ArrayList();
            }
            child.add(v);
            map.put("" + v.getPid(), child);
        }
        return map;
    }
    public Map toMap() {
        Map map = new HashMap();
        map.put("Id", getId() + "");
        map.put("OrgId", getOrgId() + "");
        map.put("Pid", getPid() + "");
        map.put("Name", getName());
        map.put("Leaders", getLeaders());
        map.put("Style", getStyle());
        map.put("Code", getCode());
        map.put("Orderby", getOrderby() + "");
        map.put("ReptDept", getReptDept());
        map.put("Address", getAddress());
        map.put("PostCode", getPostCode());
        map.put("Tel", getTel());
        map.put("Fax", getFax());
        map.put("Email", getEmail());
        map.put("Remark", getRemark());
        map.put("Enable", getEnable() + "");
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("OrgId:\"" + getOrgId() + "\"");
        row.add("Pid:\"" + getPid() + "\"");
        row.add("Name:\"" + Tool.jsSpecialChars(getName()) + "\"");
        row.add("Leaders:\"" + Tool.jsSpecialChars(getLeaders()) + "\"");
        row.add("Style:\"" + Tool.jsSpecialChars(getStyle()) + "\"");
        row.add("Code:\"" + Tool.jsSpecialChars(getCode()) + "\"");
        row.add("Orderby:\"" + getOrderby() + "\"");
        row.add("ReptDept:\"" + Tool.jsSpecialChars(getReptDept()) + "\"");
        row.add("Address:\"" + Tool.jsSpecialChars(getAddress()) + "\"");
        row.add("PostCode:\"" + Tool.jsSpecialChars(getPostCode()) + "\"");
        row.add("Tel:\"" + Tool.jsSpecialChars(getTel()) + "\"");
        row.add("Fax:\"" + Tool.jsSpecialChars(getFax()) + "\"");
        row.add("Email:\"" + Tool.jsSpecialChars(getEmail()) + "\"");
        row.add("Remark:\"" + Tool.jsSpecialChars(getRemark()) + "\"");
        row.add("Enable:\"" + getEnable() + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,orgid number(*,0),pid number(*,0),name varchar2(200),leaders varchar2(100),style varchar2(1),code varchar2(50),orderby number(*,0),reptdept varchar2(50),address varchar2(200),postcode varchar2(50),tel varchar2(50),fax varchar2(50),email varchar2(50),remark varchar2(255),enable number(*,0))"});
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
        BaseDeptCode v = new BaseDeptCode(sourceDb, sourceTb);
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
        BaseDeptCode v = new BaseDeptCode(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(BaseDeptCode obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getOrgId()).compareTo("" + obj.getOrgId()); if (rtn != 0) return rtn;
        rtn = ("" + getPid()).compareTo("" + obj.getPid()); if (rtn != 0) return rtn;
        rtn = getName().compareTo(obj.getName()); if (rtn != 0) return rtn;
        rtn = getLeaders().compareTo(obj.getLeaders()); if (rtn != 0) return rtn;
        rtn = getStyle().compareTo(obj.getStyle()); if (rtn != 0) return rtn;
        rtn = getCode().compareTo(obj.getCode()); if (rtn != 0) return rtn;
        rtn = ("" + getOrderby()).compareTo("" + obj.getOrderby()); if (rtn != 0) return rtn;
        rtn = getReptDept().compareTo(obj.getReptDept()); if (rtn != 0) return rtn;
        rtn = getAddress().compareTo(obj.getAddress()); if (rtn != 0) return rtn;
        rtn = getPostCode().compareTo(obj.getPostCode()); if (rtn != 0) return rtn;
        rtn = getTel().compareTo(obj.getTel()); if (rtn != 0) return rtn;
        rtn = getFax().compareTo(obj.getFax()); if (rtn != 0) return rtn;
        rtn = getEmail().compareTo(obj.getEmail()); if (rtn != 0) return rtn;
        rtn = getRemark().compareTo(obj.getRemark()); if (rtn != 0) return rtn;
        rtn = ("" + getEnable()).compareTo("" + obj.getEnable()); if (rtn != 0) return rtn;
        return rtn;
    }
}
