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
@Description("班级委员具体任职情况-学生素质拓展培养认证单-社会工作")
public class StudentClassDuty implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(StudentClassDuty.class);
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
    public static final String DbTableName = "studentclassduty";
    private String TNAME = "studentclassduty";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","sno","duty","classname","schoolYear","academy"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","sno","duty","classname","schoolyear","academy"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"Sno","sno","String"},{"Duty","duty","String"},{"Classname","classname","String"},{"SchoolYear","schoolyear","String"},{"Academy","academy","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"sno","sno"},{"duty","duty"},{"classname","classname"},{"schoolYear","schoolyear"},{"academy","academy"}};
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
    // 学号
    protected String sno = "";
    public String getSno() {  return SqlTool.getDbString(sno);  }
    public String getSno(int size) { return SqlTool.subString(getSno(), size); }
    public void setSno(String aSno) { sno = aSno; modifiedFields.add("Sno"); }
    public void assignSno(String aSno) { sno = aSno; }
    public void paramSno(HttpServletRequest request) { paramSno(request, "Sno"); }
    public void paramSno(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSno()); if (!tmp.equals(getSno())) { setSno(tmp); } }
    // 职位
    protected String duty = "";
    public String getDuty() {  return SqlTool.getDbString(duty);  }
    public String getDuty(int size) { return SqlTool.subString(getDuty(), size); }
    public void setDuty(String aDuty) { duty = aDuty; modifiedFields.add("Duty"); }
    public void assignDuty(String aDuty) { duty = aDuty; }
    public void paramDuty(HttpServletRequest request) { paramDuty(request, "Duty"); }
    public void paramDuty(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDuty()); if (!tmp.equals(getDuty())) { setDuty(tmp); } }
    // 班级
    protected String classname = "";
    public String getClassname() {  return SqlTool.getDbString(classname);  }
    public String getClassname(int size) { return SqlTool.subString(getClassname(), size); }
    public void setClassname(String aClassname) { classname = aClassname; modifiedFields.add("Classname"); }
    public void assignClassname(String aClassname) { classname = aClassname; }
    public void paramClassname(HttpServletRequest request) { paramClassname(request, "Classname"); }
    public void paramClassname(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getClassname()); if (!tmp.equals(getClassname())) { setClassname(tmp); } }
    // 担任学年
    protected String schoolYear = "";
    public String getSchoolYear() {  return SqlTool.getDbString(schoolYear);  }
    public String getSchoolYear(int size) { return SqlTool.subString(getSchoolYear(), size); }
    public void setSchoolYear(String aSchoolYear) { schoolYear = aSchoolYear; modifiedFields.add("SchoolYear"); }
    public void assignSchoolYear(String aSchoolYear) { schoolYear = aSchoolYear; }
    public void paramSchoolYear(HttpServletRequest request) { paramSchoolYear(request, "SchoolYear"); }
    public void paramSchoolYear(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSchoolYear()); if (!tmp.equals(getSchoolYear())) { setSchoolYear(tmp); } }
    // 学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public StudentClassDuty (String db) {
        DBNAME = db;
    }
    public StudentClassDuty (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public StudentClassDuty (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public StudentClassDuty () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return StudentClassDuty类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public StudentClassDuty getByParameter(HttpServletRequest request) {
        StudentClassDuty v = new StudentClassDuty(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramSno(request);
        paramDuty(request);
        paramClassname(request);
        paramSchoolYear(request);
        paramAcademy(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(StudentClassDuty bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("sno")) { setSno(bean.getSno()); }
        if (!ncl.contains("duty")) { setDuty(bean.getDuty()); }
        if (!ncl.contains("classname")) { setClassname(bean.getClassname()); }
        if (!ncl.contains("schoolYear")) { setSchoolYear(bean.getSchoolYear()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
    }
    public StudentClassDuty getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        StudentClassDuty[] rslt= queryByCondition(cdt);
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
     * @return StudentClassDuty类的实例列表。
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
                StudentClassDuty ve = new StudentClassDuty(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignSno(fromDbCh(rs.getString(2)));
                ve.assignDuty(fromDbCh(rs.getString(3)));
                ve.assignClassname(fromDbCh(rs.getString(4)));
                ve.assignSchoolYear(fromDbCh(rs.getString(5)));
                ve.assignAcademy(fromDbCh(rs.getString(6)));
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
    public StudentClassDuty[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (StudentClassDuty[])vrs.toArray(new StudentClassDuty[vrs.size()]);
    }
    public StudentClassDuty[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (StudentClassDuty[])vrs.toArray(new StudentClassDuty[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (sno,duty,classname,schoolyear,academy) VALUES (?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(sno));
            pstmt.setString(2, toDbCh(duty));
            pstmt.setString(3, toDbCh(classname));
            pstmt.setString(4, toDbCh(schoolYear));
            pstmt.setString(5, toDbCh(academy));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,sno,duty,classname,schoolyear,academy) VALUES (?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(sno));
            pstmt.setString(3, toDbCh(duty));
            pstmt.setString(4, toDbCh(classname));
            pstmt.setString(5, toDbCh(schoolYear));
            pstmt.setString(6, toDbCh(academy));
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
            StudentClassDuty item = (StudentClassDuty)it.next();
            StudentClassDuty v = new StudentClassDuty(dbname);
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
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("Duty")) { pstmt.setString(pi ++, toDbCh(duty)); }
                if (modifiedFields.contains("Classname")) { pstmt.setString(pi ++, toDbCh(classname)); }
                if (modifiedFields.contains("SchoolYear")) { pstmt.setString(pi ++, toDbCh(schoolYear)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
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
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("Duty")) { pstmt.setString(pi ++, toDbCh(duty)); }
                if (modifiedFields.contains("Classname")) { pstmt.setString(pi ++, toDbCh(classname)); }
                if (modifiedFields.contains("SchoolYear")) { pstmt.setString(pi ++, toDbCh(schoolYear)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
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
        map.put("Sno", getSno());
        map.put("Duty", getDuty());
        map.put("Classname", getClassname());
        map.put("SchoolYear", getSchoolYear());
        map.put("Academy", getAcademy());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("Sno:\"" + Tool.jsSpecialChars(getSno()) + "\"");
        row.add("Duty:\"" + Tool.jsSpecialChars(getDuty()) + "\"");
        row.add("Classname:\"" + Tool.jsSpecialChars(getClassname()) + "\"");
        row.add("SchoolYear:\"" + Tool.jsSpecialChars(getSchoolYear()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,sno varchar2(45),duty varchar2(45),classname varchar2(45),schoolyear varchar2(45),academy varchar2(45))"});
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
        StudentClassDuty v = new StudentClassDuty(sourceDb, sourceTb);
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
        StudentClassDuty v = new StudentClassDuty(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(StudentClassDuty obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getSno().compareTo(obj.getSno()); if (rtn != 0) return rtn;
        rtn = getDuty().compareTo(obj.getDuty()); if (rtn != 0) return rtn;
        rtn = getClassname().compareTo(obj.getClassname()); if (rtn != 0) return rtn;
        rtn = getSchoolYear().compareTo(obj.getSchoolYear()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        return rtn;
    }
}
