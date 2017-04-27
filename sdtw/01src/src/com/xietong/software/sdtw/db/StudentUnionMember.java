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
@Description("学生会部门成员")
public class StudentUnionMember implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(StudentUnionMember.class);
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
    public static final String DbTableName = "studentunionmember";
    private String TNAME = "studentunionmember";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","unionid","deptid","unionorDept","sNo","campus","chargeDept","phone","duty","remark","schoolYear"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","unionid","deptid","unionordept","sno","campus","chargedept","phone","duty","remark","schoolyear"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"Unionid","unionid","int"},{"Deptid","deptid","int"},{"UnionorDept","unionordept","String"},{"SNo","sno","String"},{"Campus","campus","String"},{"ChargeDept","chargedept","String"},{"Phone","phone","String"},{"Duty","duty","String"},{"Remark","remark","String"},{"SchoolYear","schoolyear","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"unionid","unionid"},{"deptid","deptid"},{"unionorDept","unionordept"},{"sNo","sno"},{"campus","campus"},{"chargeDept","chargedept"},{"phone","phone"},{"duty","duty"},{"remark","remark"},{"schoolYear","schoolyear"}};
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
    // 校级院级学生会id
    protected int unionid = -1;
    public int getUnionid() { return unionid; }
    public void setUnionid(int aUnionid) { unionid = aUnionid; modifiedFields.add("Unionid"); }
    public void assignUnionid(int aUnionid) { unionid = aUnionid; }
    public void paramUnionid(HttpServletRequest request) { paramUnionid(request, "Unionid"); }
    public void paramUnionid(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getUnionid()); if (tmp != getUnionid()) { setUnionid(tmp); } }
    // 部门学生会id
    protected int deptid = -1;
    public int getDeptid() { return deptid; }
    public void setDeptid(int aDeptid) { deptid = aDeptid; modifiedFields.add("Deptid"); }
    public void assignDeptid(int aDeptid) { deptid = aDeptid; }
    public void paramDeptid(HttpServletRequest request) { paramDeptid(request, "Deptid"); }
    public void paramDeptid(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getDeptid()); if (tmp != getDeptid()) { setDeptid(tmp); } }
    // 院级或部门级学生会
    protected String unionorDept = "";
    public String getUnionorDept() {  return SqlTool.getDbString(unionorDept);  }
    public String getUnionorDept(int size) { return SqlTool.subString(getUnionorDept(), size); }
    public void setUnionorDept(String aUnionorDept) { unionorDept = aUnionorDept; modifiedFields.add("UnionorDept"); }
    public void assignUnionorDept(String aUnionorDept) { unionorDept = aUnionorDept; }
    public void paramUnionorDept(HttpServletRequest request) { paramUnionorDept(request, "UnionorDept"); }
    public void paramUnionorDept(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUnionorDept()); if (!tmp.equals(getUnionorDept())) { setUnionorDept(tmp); } }
    // 账号
    protected String sNo = "";
    public String getSNo() {  return SqlTool.getDbString(sNo);  }
    public String getSNo(int size) { return SqlTool.subString(getSNo(), size); }
    public void setSNo(String aSNo) { sNo = aSNo; modifiedFields.add("SNo"); }
    public void assignSNo(String aSNo) { sNo = aSNo; }
    public void paramSNo(HttpServletRequest request) { paramSNo(request, "SNo"); }
    public void paramSNo(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSNo()); if (!tmp.equals(getSNo())) { setSNo(tmp); } }
    // 校区
    protected String campus = "";
    public String getCampus() {  return SqlTool.getDbString(campus);  }
    public String getCampus(int size) { return SqlTool.subString(getCampus(), size); }
    public void setCampus(String aCampus) { campus = aCampus; modifiedFields.add("Campus"); }
    public void assignCampus(String aCampus) { campus = aCampus; }
    public void paramCampus(HttpServletRequest request) { paramCampus(request, "Campus"); }
    public void paramCampus(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCampus()); if (!tmp.equals(getCampus())) { setCampus(tmp); } }
    // 主要部门
    protected String chargeDept = "";
    public String getChargeDept() {  return SqlTool.getDbString(chargeDept);  }
    public String getChargeDept(int size) { return SqlTool.subString(getChargeDept(), size); }
    public void setChargeDept(String aChargeDept) { chargeDept = aChargeDept; modifiedFields.add("ChargeDept"); }
    public void assignChargeDept(String aChargeDept) { chargeDept = aChargeDept; }
    public void paramChargeDept(HttpServletRequest request) { paramChargeDept(request, "ChargeDept"); }
    public void paramChargeDept(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getChargeDept()); if (!tmp.equals(getChargeDept())) { setChargeDept(tmp); } }
    // 手机
    protected String phone = "";
    public String getPhone() {  return SqlTool.getDbString(phone);  }
    public String getPhone(int size) { return SqlTool.subString(getPhone(), size); }
    public void setPhone(String aPhone) { phone = aPhone; modifiedFields.add("Phone"); }
    public void assignPhone(String aPhone) { phone = aPhone; }
    public void paramPhone(HttpServletRequest request) { paramPhone(request, "Phone"); }
    public void paramPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPhone()); if (!tmp.equals(getPhone())) { setPhone(tmp); } }
    // 职位
    protected String duty = "";
    public String getDuty() {  return SqlTool.getDbString(duty);  }
    public String getDuty(int size) { return SqlTool.subString(getDuty(), size); }
    public void setDuty(String aDuty) { duty = aDuty; modifiedFields.add("Duty"); }
    public void assignDuty(String aDuty) { duty = aDuty; }
    public void paramDuty(HttpServletRequest request) { paramDuty(request, "Duty"); }
    public void paramDuty(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDuty()); if (!tmp.equals(getDuty())) { setDuty(tmp); } }
    // 备注
    protected String remark = "";
    public String getRemark() {  return SqlTool.getDbString(remark);  }
    public String getRemark(int size) { return SqlTool.subString(getRemark(), size); }
    public void setRemark(String aRemark) { remark = aRemark; modifiedFields.add("Remark"); }
    public void assignRemark(String aRemark) { remark = aRemark; }
    public void paramRemark(HttpServletRequest request) { paramRemark(request, "Remark"); }
    public void paramRemark(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark()); if (!tmp.equals(getRemark())) { setRemark(tmp); } }
    // 学年
    protected String schoolYear = "";
    public String getSchoolYear() {  return SqlTool.getDbString(schoolYear);  }
    public String getSchoolYear(int size) { return SqlTool.subString(getSchoolYear(), size); }
    public void setSchoolYear(String aSchoolYear) { schoolYear = aSchoolYear; modifiedFields.add("SchoolYear"); }
    public void assignSchoolYear(String aSchoolYear) { schoolYear = aSchoolYear; }
    public void paramSchoolYear(HttpServletRequest request) { paramSchoolYear(request, "SchoolYear"); }
    public void paramSchoolYear(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSchoolYear()); if (!tmp.equals(getSchoolYear())) { setSchoolYear(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public StudentUnionMember (String db) {
        DBNAME = db;
    }
    public StudentUnionMember (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public StudentUnionMember (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public StudentUnionMember () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return StudentUnionMember类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public StudentUnionMember getByParameter(HttpServletRequest request) {
        StudentUnionMember v = new StudentUnionMember(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramUnionid(request);
        paramDeptid(request);
        paramUnionorDept(request);
        paramSNo(request);
        paramCampus(request);
        paramChargeDept(request);
        paramPhone(request);
        paramDuty(request);
        paramRemark(request);
        paramSchoolYear(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(StudentUnionMember bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("unionid")) { setUnionid(bean.getUnionid()); }
        if (!ncl.contains("deptid")) { setDeptid(bean.getDeptid()); }
        if (!ncl.contains("unionorDept")) { setUnionorDept(bean.getUnionorDept()); }
        if (!ncl.contains("sNo")) { setSNo(bean.getSNo()); }
        if (!ncl.contains("campus")) { setCampus(bean.getCampus()); }
        if (!ncl.contains("chargeDept")) { setChargeDept(bean.getChargeDept()); }
        if (!ncl.contains("phone")) { setPhone(bean.getPhone()); }
        if (!ncl.contains("duty")) { setDuty(bean.getDuty()); }
        if (!ncl.contains("remark")) { setRemark(bean.getRemark()); }
        if (!ncl.contains("schoolYear")) { setSchoolYear(bean.getSchoolYear()); }
    }
    public StudentUnionMember getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        StudentUnionMember[] rslt= queryByCondition(cdt);
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
     * @return StudentUnionMember类的实例列表。
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
                StudentUnionMember ve = new StudentUnionMember(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignUnionid(rs.getInt(2));
                ve.assignDeptid(rs.getInt(3));
                ve.assignUnionorDept(fromDbCh(rs.getString(4)));
                ve.assignSNo(fromDbCh(rs.getString(5)));
                ve.assignCampus(fromDbCh(rs.getString(6)));
                ve.assignChargeDept(fromDbCh(rs.getString(7)));
                ve.assignPhone(fromDbCh(rs.getString(8)));
                ve.assignDuty(fromDbCh(rs.getString(9)));
                ve.assignRemark(fromDbCh(rs.getString(10)));
                ve.assignSchoolYear(fromDbCh(rs.getString(11)));
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
    public StudentUnionMember[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (StudentUnionMember[])vrs.toArray(new StudentUnionMember[vrs.size()]);
    }
    public StudentUnionMember[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (StudentUnionMember[])vrs.toArray(new StudentUnionMember[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (unionid,deptid,unionordept,sno,campus,chargedept,phone,duty,remark,schoolyear) VALUES (?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, unionid);
            pstmt.setInt(2, deptid);
            pstmt.setString(3, toDbCh(unionorDept));
            pstmt.setString(4, toDbCh(sNo));
            pstmt.setString(5, toDbCh(campus));
            pstmt.setString(6, toDbCh(chargeDept));
            pstmt.setString(7, toDbCh(phone));
            pstmt.setString(8, toDbCh(duty));
            pstmt.setString(9, toDbCh(remark));
            pstmt.setString(10, toDbCh(schoolYear));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,unionid,deptid,unionordept,sno,campus,chargedept,phone,duty,remark,schoolyear) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, unionid);
            pstmt.setInt(3, deptid);
            pstmt.setString(4, toDbCh(unionorDept));
            pstmt.setString(5, toDbCh(sNo));
            pstmt.setString(6, toDbCh(campus));
            pstmt.setString(7, toDbCh(chargeDept));
            pstmt.setString(8, toDbCh(phone));
            pstmt.setString(9, toDbCh(duty));
            pstmt.setString(10, toDbCh(remark));
            pstmt.setString(11, toDbCh(schoolYear));
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
            StudentUnionMember item = (StudentUnionMember)it.next();
            StudentUnionMember v = new StudentUnionMember(dbname);
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
                if (modifiedFields.contains("Unionid")) { pstmt.setInt(pi ++, unionid); }
                if (modifiedFields.contains("Deptid")) { pstmt.setInt(pi ++, deptid); }
                if (modifiedFields.contains("UnionorDept")) { pstmt.setString(pi ++, toDbCh(unionorDept)); }
                if (modifiedFields.contains("SNo")) { pstmt.setString(pi ++, toDbCh(sNo)); }
                if (modifiedFields.contains("Campus")) { pstmt.setString(pi ++, toDbCh(campus)); }
                if (modifiedFields.contains("ChargeDept")) { pstmt.setString(pi ++, toDbCh(chargeDept)); }
                if (modifiedFields.contains("Phone")) { pstmt.setString(pi ++, toDbCh(phone)); }
                if (modifiedFields.contains("Duty")) { pstmt.setString(pi ++, toDbCh(duty)); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("SchoolYear")) { pstmt.setString(pi ++, toDbCh(schoolYear)); }
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
                if (modifiedFields.contains("Unionid")) { pstmt.setInt(pi ++, unionid); }
                if (modifiedFields.contains("Deptid")) { pstmt.setInt(pi ++, deptid); }
                if (modifiedFields.contains("UnionorDept")) { pstmt.setString(pi ++, toDbCh(unionorDept)); }
                if (modifiedFields.contains("SNo")) { pstmt.setString(pi ++, toDbCh(sNo)); }
                if (modifiedFields.contains("Campus")) { pstmt.setString(pi ++, toDbCh(campus)); }
                if (modifiedFields.contains("ChargeDept")) { pstmt.setString(pi ++, toDbCh(chargeDept)); }
                if (modifiedFields.contains("Phone")) { pstmt.setString(pi ++, toDbCh(phone)); }
                if (modifiedFields.contains("Duty")) { pstmt.setString(pi ++, toDbCh(duty)); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("SchoolYear")) { pstmt.setString(pi ++, toDbCh(schoolYear)); }
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
        map.put("Unionid", getUnionid() + "");
        map.put("Deptid", getDeptid() + "");
        map.put("UnionorDept", getUnionorDept());
        map.put("SNo", getSNo());
        map.put("Campus", getCampus());
        map.put("ChargeDept", getChargeDept());
        map.put("Phone", getPhone());
        map.put("Duty", getDuty());
        map.put("Remark", getRemark());
        map.put("SchoolYear", getSchoolYear());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("Unionid:\"" + getUnionid() + "\"");
        row.add("Deptid:\"" + getDeptid() + "\"");
        row.add("UnionorDept:\"" + Tool.jsSpecialChars(getUnionorDept()) + "\"");
        row.add("SNo:\"" + Tool.jsSpecialChars(getSNo()) + "\"");
        row.add("Campus:\"" + Tool.jsSpecialChars(getCampus()) + "\"");
        row.add("ChargeDept:\"" + Tool.jsSpecialChars(getChargeDept()) + "\"");
        row.add("Phone:\"" + Tool.jsSpecialChars(getPhone()) + "\"");
        row.add("Duty:\"" + Tool.jsSpecialChars(getDuty()) + "\"");
        row.add("Remark:\"" + Tool.jsSpecialChars(getRemark()) + "\"");
        row.add("SchoolYear:\"" + Tool.jsSpecialChars(getSchoolYear()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,unionid number(*,0),deptid number(*,0),unionordept varchar2(45),sno varchar2(45),campus varchar2(45),chargedept varchar2(45),phone varchar2(45),duty varchar2(45),remark varchar2(45),schoolyear varchar2(45))"});
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
        StudentUnionMember v = new StudentUnionMember(sourceDb, sourceTb);
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
        StudentUnionMember v = new StudentUnionMember(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(StudentUnionMember obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getUnionid()).compareTo("" + obj.getUnionid()); if (rtn != 0) return rtn;
        rtn = ("" + getDeptid()).compareTo("" + obj.getDeptid()); if (rtn != 0) return rtn;
        rtn = getUnionorDept().compareTo(obj.getUnionorDept()); if (rtn != 0) return rtn;
        rtn = getSNo().compareTo(obj.getSNo()); if (rtn != 0) return rtn;
        rtn = getCampus().compareTo(obj.getCampus()); if (rtn != 0) return rtn;
        rtn = getChargeDept().compareTo(obj.getChargeDept()); if (rtn != 0) return rtn;
        rtn = getPhone().compareTo(obj.getPhone()); if (rtn != 0) return rtn;
        rtn = getDuty().compareTo(obj.getDuty()); if (rtn != 0) return rtn;
        rtn = getRemark().compareTo(obj.getRemark()); if (rtn != 0) return rtn;
        rtn = getSchoolYear().compareTo(obj.getSchoolYear()); if (rtn != 0) return rtn;
        return rtn;
    }
}
