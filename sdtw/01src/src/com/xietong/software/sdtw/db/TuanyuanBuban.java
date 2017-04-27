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
@Description("团员补办")
public class TuanyuanBuban implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(TuanyuanBuban.class);
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
    public static final String DbTableName = "tuanyuanbuban";
    private String TNAME = "tuanyuanbuban";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","sno","sname","sacademy","applytime","reapplyNum","appliedTime","flag"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","sno","sname","sacademy","applytime","reapplynum","appliedtime","flag"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"Sno","sno","String"},{"Sname","sname","String"},{"Sacademy","sacademy","String"},{"Applytime","applytime","String"},{"ReapplyNum","reapplynum","String"},{"AppliedTime","appliedtime","String"},{"Flag","flag","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"sno","sno"},{"sname","sname"},{"sacademy","sacademy"},{"applytime","applytime"},{"reapplyNum","reapplynum"},{"appliedTime","appliedtime"},{"flag","flag"}};
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
    // 姓名
    protected String sname = "";
    public String getSname() {  return SqlTool.getDbString(sname);  }
    public String getSname(int size) { return SqlTool.subString(getSname(), size); }
    public void setSname(String aSname) { sname = aSname; modifiedFields.add("Sname"); }
    public void assignSname(String aSname) { sname = aSname; }
    public void paramSname(HttpServletRequest request) { paramSname(request, "Sname"); }
    public void paramSname(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSname()); if (!tmp.equals(getSname())) { setSname(tmp); } }
    // 学院
    protected String sacademy = "";
    public String getSacademy() {  return SqlTool.getDbString(sacademy);  }
    public String getSacademy(int size) { return SqlTool.subString(getSacademy(), size); }
    public void setSacademy(String aSacademy) { sacademy = aSacademy; modifiedFields.add("Sacademy"); }
    public void assignSacademy(String aSacademy) { sacademy = aSacademy; }
    public void paramSacademy(HttpServletRequest request) { paramSacademy(request, "Sacademy"); }
    public void paramSacademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSacademy()); if (!tmp.equals(getSacademy())) { setSacademy(tmp); } }
    // 申请时间
    protected String applytime = "";
    public String getApplytime() {  return SqlTool.getDbString(applytime);  }
    public String getApplytime(int size) { return SqlTool.subString(getApplytime(), size); }
    public void setApplytime(String aApplytime) { applytime = aApplytime; modifiedFields.add("Applytime"); }
    public void assignApplytime(String aApplytime) { applytime = aApplytime; }
    public void paramApplytime(HttpServletRequest request) { paramApplytime(request, "Applytime"); }
    public void paramApplytime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getApplytime()); if (!tmp.equals(getApplytime())) { setApplytime(tmp); } }
    // 系统账号
    protected String reapplyNum = "";
    public String getReapplyNum() {  return SqlTool.getDbString(reapplyNum);  }
    public String getReapplyNum(int size) { return SqlTool.subString(getReapplyNum(), size); }
    public void setReapplyNum(String aReapplyNum) { reapplyNum = aReapplyNum; modifiedFields.add("ReapplyNum"); }
    public void assignReapplyNum(String aReapplyNum) { reapplyNum = aReapplyNum; }
    public void paramReapplyNum(HttpServletRequest request) { paramReapplyNum(request, "ReapplyNum"); }
    public void paramReapplyNum(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReapplyNum()); if (!tmp.equals(getReapplyNum())) { setReapplyNum(tmp); } }
    // 添加时间
    protected String appliedTime = "";
    public String getAppliedTime() {  return SqlTool.getDbString(appliedTime);  }
    public String getAppliedTime(int size) { return SqlTool.subString(getAppliedTime(), size); }
    public void setAppliedTime(String aAppliedTime) { appliedTime = aAppliedTime; modifiedFields.add("AppliedTime"); }
    public void assignAppliedTime(String aAppliedTime) { appliedTime = aAppliedTime; }
    public void paramAppliedTime(HttpServletRequest request) { paramAppliedTime(request, "AppliedTime"); }
    public void paramAppliedTime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAppliedTime()); if (!tmp.equals(getAppliedTime())) { setAppliedTime(tmp); } }
    // 审核状态
    protected String flag = "";
    public String getFlag() {  return SqlTool.getDbString(flag);  }
    public String getFlag(int size) { return SqlTool.subString(getFlag(), size); }
    public void setFlag(String aFlag) { flag = aFlag; modifiedFields.add("Flag"); }
    public void assignFlag(String aFlag) { flag = aFlag; }
    public void paramFlag(HttpServletRequest request) { paramFlag(request, "Flag"); }
    public void paramFlag(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFlag()); if (!tmp.equals(getFlag())) { setFlag(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public TuanyuanBuban (String db) {
        DBNAME = db;
    }
    public TuanyuanBuban (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public TuanyuanBuban (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public TuanyuanBuban () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return TuanyuanBuban类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public TuanyuanBuban getByParameter(HttpServletRequest request) {
        TuanyuanBuban v = new TuanyuanBuban(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramSno(request);
        paramSname(request);
        paramSacademy(request);
        paramApplytime(request);
        paramReapplyNum(request);
        paramAppliedTime(request);
        paramFlag(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(TuanyuanBuban bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("sno")) { setSno(bean.getSno()); }
        if (!ncl.contains("sname")) { setSname(bean.getSname()); }
        if (!ncl.contains("sacademy")) { setSacademy(bean.getSacademy()); }
        if (!ncl.contains("applytime")) { setApplytime(bean.getApplytime()); }
        if (!ncl.contains("reapplyNum")) { setReapplyNum(bean.getReapplyNum()); }
        if (!ncl.contains("appliedTime")) { setAppliedTime(bean.getAppliedTime()); }
        if (!ncl.contains("flag")) { setFlag(bean.getFlag()); }
    }
    public TuanyuanBuban getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        TuanyuanBuban[] rslt= queryByCondition(cdt);
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
     * @return TuanyuanBuban类的实例列表。
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
                TuanyuanBuban ve = new TuanyuanBuban(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignSno(fromDbCh(rs.getString(2)));
                ve.assignSname(fromDbCh(rs.getString(3)));
                ve.assignSacademy(fromDbCh(rs.getString(4)));
                ve.assignApplytime(fromDbCh(rs.getString(5)));
                ve.assignReapplyNum(fromDbCh(rs.getString(6)));
                ve.assignAppliedTime(fromDbCh(rs.getString(7)));
                ve.assignFlag(fromDbCh(rs.getString(8)));
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
    public TuanyuanBuban[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (TuanyuanBuban[])vrs.toArray(new TuanyuanBuban[vrs.size()]);
    }
    public TuanyuanBuban[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (TuanyuanBuban[])vrs.toArray(new TuanyuanBuban[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (sno,sname,sacademy,applytime,reapplynum,appliedtime,flag) VALUES (?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(sno));
            pstmt.setString(2, toDbCh(sname));
            pstmt.setString(3, toDbCh(sacademy));
            pstmt.setString(4, toDbCh(applytime));
            pstmt.setString(5, toDbCh(reapplyNum));
            pstmt.setString(6, toDbCh(appliedTime));
            pstmt.setString(7, toDbCh(flag));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,sno,sname,sacademy,applytime,reapplynum,appliedtime,flag) VALUES (?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(sno));
            pstmt.setString(3, toDbCh(sname));
            pstmt.setString(4, toDbCh(sacademy));
            pstmt.setString(5, toDbCh(applytime));
            pstmt.setString(6, toDbCh(reapplyNum));
            pstmt.setString(7, toDbCh(appliedTime));
            pstmt.setString(8, toDbCh(flag));
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
            TuanyuanBuban item = (TuanyuanBuban)it.next();
            TuanyuanBuban v = new TuanyuanBuban(dbname);
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
                if (modifiedFields.contains("Sname")) { pstmt.setString(pi ++, toDbCh(sname)); }
                if (modifiedFields.contains("Sacademy")) { pstmt.setString(pi ++, toDbCh(sacademy)); }
                if (modifiedFields.contains("Applytime")) { pstmt.setString(pi ++, toDbCh(applytime)); }
                if (modifiedFields.contains("ReapplyNum")) { pstmt.setString(pi ++, toDbCh(reapplyNum)); }
                if (modifiedFields.contains("AppliedTime")) { pstmt.setString(pi ++, toDbCh(appliedTime)); }
                if (modifiedFields.contains("Flag")) { pstmt.setString(pi ++, toDbCh(flag)); }
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
                if (modifiedFields.contains("Sname")) { pstmt.setString(pi ++, toDbCh(sname)); }
                if (modifiedFields.contains("Sacademy")) { pstmt.setString(pi ++, toDbCh(sacademy)); }
                if (modifiedFields.contains("Applytime")) { pstmt.setString(pi ++, toDbCh(applytime)); }
                if (modifiedFields.contains("ReapplyNum")) { pstmt.setString(pi ++, toDbCh(reapplyNum)); }
                if (modifiedFields.contains("AppliedTime")) { pstmt.setString(pi ++, toDbCh(appliedTime)); }
                if (modifiedFields.contains("Flag")) { pstmt.setString(pi ++, toDbCh(flag)); }
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
        map.put("Sname", getSname());
        map.put("Sacademy", getSacademy());
        map.put("Applytime", getApplytime());
        map.put("ReapplyNum", getReapplyNum());
        map.put("AppliedTime", getAppliedTime());
        map.put("Flag", getFlag());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("Sno:\"" + Tool.jsSpecialChars(getSno()) + "\"");
        row.add("Sname:\"" + Tool.jsSpecialChars(getSname()) + "\"");
        row.add("Sacademy:\"" + Tool.jsSpecialChars(getSacademy()) + "\"");
        row.add("Applytime:\"" + Tool.jsSpecialChars(getApplytime()) + "\"");
        row.add("ReapplyNum:\"" + Tool.jsSpecialChars(getReapplyNum()) + "\"");
        row.add("AppliedTime:\"" + Tool.jsSpecialChars(getAppliedTime()) + "\"");
        row.add("Flag:\"" + Tool.jsSpecialChars(getFlag()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,sno varchar2(45),sname varchar2(45),sacademy varchar2(45),applytime varchar2(45),reapplynum varchar2(45),appliedtime varchar2(45),flag varchar2(10))"});
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
        TuanyuanBuban v = new TuanyuanBuban(sourceDb, sourceTb);
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
        TuanyuanBuban v = new TuanyuanBuban(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(TuanyuanBuban obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getSno().compareTo(obj.getSno()); if (rtn != 0) return rtn;
        rtn = getSname().compareTo(obj.getSname()); if (rtn != 0) return rtn;
        rtn = getSacademy().compareTo(obj.getSacademy()); if (rtn != 0) return rtn;
        rtn = getApplytime().compareTo(obj.getApplytime()); if (rtn != 0) return rtn;
        rtn = getReapplyNum().compareTo(obj.getReapplyNum()); if (rtn != 0) return rtn;
        rtn = getAppliedTime().compareTo(obj.getAppliedTime()); if (rtn != 0) return rtn;
        rtn = getFlag().compareTo(obj.getFlag()); if (rtn != 0) return rtn;
        return rtn;
    }
}
