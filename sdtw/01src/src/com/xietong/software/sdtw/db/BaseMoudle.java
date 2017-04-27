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
@Description("模块")
public class BaseMoudle implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(BaseMoudle.class);
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
    public static final String DbTableName = "base_moudle";
    private String TNAME = "base_moudle";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","pid","name","code","moudleGrade","moudleType","isDept","toUrl","orderNum","isEnable","opLog"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","pid","name","code","moudlegrade","moudletype","isdept","tourl","ordernum","isenable","oplog"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"Pid","pid","int"},{"Name","name","String"},{"Code","code","String"},{"MoudleGrade","moudlegrade","int"},{"MoudleType","moudletype","int"},{"IsDept","isdept","int"},{"ToUrl","tourl","String"},{"OrderNum","ordernum","int"},{"IsEnable","isenable","int"},{"OpLog","oplog","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"pid","pid"},{"name","name"},{"code","code"},{"moudleGrade","moudlegrade"},{"moudleType","moudletype"},{"isDept","isdept"},{"toUrl","tourl"},{"orderNum","ordernum"},{"isEnable","isenable"},{"opLog","oplog"}};
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
    // 上级模块
    protected int pid = -1;
    public int getPid() { return pid; }
    public void setPid(int aPid) { pid = aPid; modifiedFields.add("Pid"); }
    public void assignPid(int aPid) { pid = aPid; }
    public void paramPid(HttpServletRequest request) { paramPid(request, "Pid"); }
    public void paramPid(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getPid()); if (tmp != getPid()) { setPid(tmp); } }
    // 模块名称
    protected String name = "";
    public String getName() {  return SqlTool.getDbString(name);  }
    public String getName(int size) { return SqlTool.subString(getName(), size); }
    public void setName(String aName) { name = aName; modifiedFields.add("Name"); refreshFlag = true; }
    public void assignName(String aName) { name = aName; }
    public void paramName(HttpServletRequest request) { paramName(request, "Name"); }
    public void paramName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getName()); if (!tmp.equals(getName())) { setName(tmp); } }
    // 编码
    protected String code = "";
    public String getCode() {  return SqlTool.getDbString(code);  }
    public String getCode(int size) { return SqlTool.subString(getCode(), size); }
    public void setCode(String aCode) { code = aCode; modifiedFields.add("Code"); }
    public void assignCode(String aCode) { code = aCode; }
    public void paramCode(HttpServletRequest request) { paramCode(request, "Code"); }
    public void paramCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCode()); if (!tmp.equals(getCode())) { setCode(tmp); } }
    // 级别
    protected int moudleGrade = -1;
    public int getMoudleGrade() { return moudleGrade; }
    public void setMoudleGrade(int aMoudleGrade) { moudleGrade = aMoudleGrade; modifiedFields.add("MoudleGrade"); }
    public void assignMoudleGrade(int aMoudleGrade) { moudleGrade = aMoudleGrade; }
    public void paramMoudleGrade(HttpServletRequest request) { paramMoudleGrade(request, "MoudleGrade"); }
    public void paramMoudleGrade(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getMoudleGrade()); if (tmp != getMoudleGrade()) { setMoudleGrade(tmp); } }
    // 类型
    protected int moudleType = -1;
    public int getMoudleType() { return moudleType; }
    public void setMoudleType(int aMoudleType) { moudleType = aMoudleType; modifiedFields.add("MoudleType"); }
    public void assignMoudleType(int aMoudleType) { moudleType = aMoudleType; }
    public void paramMoudleType(HttpServletRequest request) { paramMoudleType(request, "MoudleType"); }
    public void paramMoudleType(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getMoudleType()); if (tmp != getMoudleType()) { setMoudleType(tmp); } }
    // 部门模块
    protected int isDept = -1;
    public int getIsDept() { return isDept; }
    public void setIsDept(int aIsDept) { isDept = aIsDept; modifiedFields.add("IsDept"); }
    public void assignIsDept(int aIsDept) { isDept = aIsDept; }
    public void paramIsDept(HttpServletRequest request) { paramIsDept(request, "IsDept"); }
    public void paramIsDept(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getIsDept()); if (tmp != getIsDept()) { setIsDept(tmp); } }
    // 连接Url
    protected String toUrl = "";
    public String getToUrl() {  return SqlTool.getDbString(toUrl);  }
    public String getToUrl(int size) { return SqlTool.subString(getToUrl(), size); }
    public void setToUrl(String aToUrl) { toUrl = aToUrl; modifiedFields.add("ToUrl"); }
    public void assignToUrl(String aToUrl) { toUrl = aToUrl; }
    public void paramToUrl(HttpServletRequest request) { paramToUrl(request, "ToUrl"); }
    public void paramToUrl(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getToUrl()); if (!tmp.equals(getToUrl())) { setToUrl(tmp); } }
    // 排序
    protected int orderNum = -1;
    public int getOrderNum() { return orderNum; }
    public void setOrderNum(int aOrderNum) { orderNum = aOrderNum; modifiedFields.add("OrderNum"); }
    public void assignOrderNum(int aOrderNum) { orderNum = aOrderNum; }
    public void paramOrderNum(HttpServletRequest request) { paramOrderNum(request, "OrderNum"); }
    public void paramOrderNum(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getOrderNum()); if (tmp != getOrderNum()) { setOrderNum(tmp); } }
    // 是否可用
    protected int isEnable = -1;
    public int getIsEnable() { return isEnable; }
    public void setIsEnable(int aIsEnable) { isEnable = aIsEnable; modifiedFields.add("IsEnable"); }
    public void assignIsEnable(int aIsEnable) { isEnable = aIsEnable; }
    public void paramIsEnable(HttpServletRequest request) { paramIsEnable(request, "IsEnable"); }
    public void paramIsEnable(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getIsEnable()); if (tmp != getIsEnable()) { setIsEnable(tmp); } }
    // 操作日志
    protected String opLog = "";
    public String getOpLog() {  return SqlTool.getDbString(opLog);  }
    public String getOpLog(int size) { return SqlTool.subString(getOpLog(), size); }
    public void setOpLog(String aOpLog) { opLog = aOpLog; modifiedFields.add("OpLog"); }
    public void assignOpLog(String aOpLog) { opLog = aOpLog; }
    public void paramOpLog(HttpServletRequest request) { paramOpLog(request, "OpLog"); }
    public void paramOpLog(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOpLog()); if (!tmp.equals(getOpLog())) { setOpLog(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public BaseMoudle (String db) {
        DBNAME = db;
    }
    public BaseMoudle (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public BaseMoudle (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public BaseMoudle () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return BaseMoudle类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public BaseMoudle getByParameter(HttpServletRequest request) {
        BaseMoudle v = new BaseMoudle(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramPid(request);
        paramName(request);
        paramCode(request);
        paramMoudleGrade(request);
        paramMoudleType(request);
        paramIsDept(request);
        paramToUrl(request);
        paramOrderNum(request);
        paramIsEnable(request);
        paramOpLog(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(BaseMoudle bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("pid")) { setPid(bean.getPid()); }
        if (!ncl.contains("name")) { setName(bean.getName()); }
        if (!ncl.contains("code")) { setCode(bean.getCode()); }
        if (!ncl.contains("moudleGrade")) { setMoudleGrade(bean.getMoudleGrade()); }
        if (!ncl.contains("moudleType")) { setMoudleType(bean.getMoudleType()); }
        if (!ncl.contains("isDept")) { setIsDept(bean.getIsDept()); }
        if (!ncl.contains("toUrl")) { setToUrl(bean.getToUrl()); }
        if (!ncl.contains("orderNum")) { setOrderNum(bean.getOrderNum()); }
        if (!ncl.contains("isEnable")) { setIsEnable(bean.getIsEnable()); }
        if (!ncl.contains("opLog")) { setOpLog(bean.getOpLog()); }
    }
    public BaseMoudle getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        BaseMoudle[] rslt= queryByCondition(cdt);
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
     * @return BaseMoudle类的实例列表。
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
                BaseMoudle ve = new BaseMoudle(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignPid(rs.getInt(2));
                ve.assignName(fromDbCh(rs.getString(3)));
                ve.assignCode(fromDbCh(rs.getString(4)));
                ve.assignMoudleGrade(rs.getInt(5));
                ve.assignMoudleType(rs.getInt(6));
                ve.assignIsDept(rs.getInt(7));
                ve.assignToUrl(fromDbCh(rs.getString(8)));
                ve.assignOrderNum(rs.getInt(9));
                ve.assignIsEnable(rs.getInt(10));
                ve.assignOpLog(fromDbCh(rs.getString(11)));
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
    public BaseMoudle[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (BaseMoudle[])vrs.toArray(new BaseMoudle[vrs.size()]);
    }
    public BaseMoudle[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (BaseMoudle[])vrs.toArray(new BaseMoudle[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (pid,name,code,moudlegrade,moudletype,isdept,tourl,ordernum,isenable,oplog) VALUES (?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, pid);
            pstmt.setString(2, toDbCh(name));
            pstmt.setString(3, toDbCh(code));
            pstmt.setInt(4, moudleGrade);
            pstmt.setInt(5, moudleType);
            pstmt.setInt(6, isDept);
            pstmt.setString(7, toDbCh(toUrl));
            pstmt.setInt(8, orderNum);
            pstmt.setInt(9, isEnable);
            pstmt.setString(10, toDbCh(opLog));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseMoudle");
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,pid,name,code,moudlegrade,moudletype,isdept,tourl,ordernum,isenable,oplog) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, pid);
            pstmt.setString(3, toDbCh(name));
            pstmt.setString(4, toDbCh(code));
            pstmt.setInt(5, moudleGrade);
            pstmt.setInt(6, moudleType);
            pstmt.setInt(7, isDept);
            pstmt.setString(8, toDbCh(toUrl));
            pstmt.setInt(9, orderNum);
            pstmt.setInt(10, isEnable);
            pstmt.setString(11, toDbCh(opLog));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseMoudle");
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
            BaseMoudle item = (BaseMoudle)it.next();
            BaseMoudle v = new BaseMoudle(dbname);
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
                if (modifiedFields.contains("Pid")) { pstmt.setInt(pi ++, pid); }
                if (modifiedFields.contains("Name")) { pstmt.setString(pi ++, toDbCh(name)); }
                if (modifiedFields.contains("Code")) { pstmt.setString(pi ++, toDbCh(code)); }
                if (modifiedFields.contains("MoudleGrade")) { pstmt.setInt(pi ++, moudleGrade); }
                if (modifiedFields.contains("MoudleType")) { pstmt.setInt(pi ++, moudleType); }
                if (modifiedFields.contains("IsDept")) { pstmt.setInt(pi ++, isDept); }
                if (modifiedFields.contains("ToUrl")) { pstmt.setString(pi ++, toDbCh(toUrl)); }
                if (modifiedFields.contains("OrderNum")) { pstmt.setInt(pi ++, orderNum); }
                if (modifiedFields.contains("IsEnable")) { pstmt.setInt(pi ++, isEnable); }
                if (modifiedFields.contains("OpLog")) { pstmt.setString(pi ++, toDbCh(opLog)); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseMoudle");
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
                if (modifiedFields.contains("Pid")) { pstmt.setInt(pi ++, pid); }
                if (modifiedFields.contains("Name")) { pstmt.setString(pi ++, toDbCh(name)); }
                if (modifiedFields.contains("Code")) { pstmt.setString(pi ++, toDbCh(code)); }
                if (modifiedFields.contains("MoudleGrade")) { pstmt.setInt(pi ++, moudleGrade); }
                if (modifiedFields.contains("MoudleType")) { pstmt.setInt(pi ++, moudleType); }
                if (modifiedFields.contains("IsDept")) { pstmt.setInt(pi ++, isDept); }
                if (modifiedFields.contains("ToUrl")) { pstmt.setString(pi ++, toDbCh(toUrl)); }
                if (modifiedFields.contains("OrderNum")) { pstmt.setInt(pi ++, orderNum); }
                if (modifiedFields.contains("IsEnable")) { pstmt.setInt(pi ++, isEnable); }
                if (modifiedFields.contains("OpLog")) { pstmt.setString(pi ++, toDbCh(opLog)); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseMoudle");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseMoudle");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseMoudle");
        return iResult;
    }
    public TreeItem cloneTi(BaseMoudle item) {
        TreeItem ti = new TreeItem();
        ti.setId(item.getId());
        ti.setPid(item.getPid());
        ti.setName(item.getName());
        ti.setCode(item.getCode());
        ti.setOrders("" + item.getId());
        ti.setClassName("BaseMoudle");
        return ti;
    }
    public String findRootKey(Map parent) {
        List allids = new ArrayList();
        for (Iterator mit = parent.keySet().iterator(); mit.hasNext();) {
            String key = (String)mit.next();
            List list = (List)parent.get(key);
            for (Iterator it = list.iterator(); it.hasNext();) {
                BaseMoudle v = (BaseMoudle)it.next();
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
    public TreeItem initTree(BaseMoudle item, Map parent) {
        TreeItem ti = cloneTi(item);
        List list = (List)parent.get("" + item.getId());
        if (list != null) {
            for (Iterator it = list.iterator(); it.hasNext();) {
                BaseMoudle v = (BaseMoudle)it.next();
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
            BaseMoudle v = (BaseMoudle)it.next();
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
        map.put("Pid", getPid() + "");
        map.put("Name", getName());
        map.put("Code", getCode());
        map.put("MoudleGrade", getMoudleGrade() + "");
        map.put("MoudleType", getMoudleType() + "");
        map.put("IsDept", getIsDept() + "");
        map.put("ToUrl", getToUrl());
        map.put("OrderNum", getOrderNum() + "");
        map.put("IsEnable", getIsEnable() + "");
        map.put("OpLog", getOpLog());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("Pid:\"" + getPid() + "\"");
        row.add("Name:\"" + Tool.jsSpecialChars(getName()) + "\"");
        row.add("Code:\"" + Tool.jsSpecialChars(getCode()) + "\"");
        row.add("MoudleGrade:\"" + getMoudleGrade() + "\"");
        row.add("MoudleType:\"" + getMoudleType() + "\"");
        row.add("IsDept:\"" + getIsDept() + "\"");
        row.add("ToUrl:\"" + Tool.jsSpecialChars(getToUrl()) + "\"");
        row.add("OrderNum:\"" + getOrderNum() + "\"");
        row.add("IsEnable:\"" + getIsEnable() + "\"");
        row.add("OpLog:\"" + Tool.jsSpecialChars(getOpLog()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,pid number(*,0),name varchar2(200),code varchar2(200),moudlegrade number(*,0),moudletype number(*,0),isdept number(*,0),tourl varchar2(500),ordernum number(*,0),isenable number(*,0),oplog varchar2(1000))"});
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
        BaseMoudle v = new BaseMoudle(sourceDb, sourceTb);
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
        BaseMoudle v = new BaseMoudle(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(BaseMoudle obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getPid()).compareTo("" + obj.getPid()); if (rtn != 0) return rtn;
        rtn = getName().compareTo(obj.getName()); if (rtn != 0) return rtn;
        rtn = getCode().compareTo(obj.getCode()); if (rtn != 0) return rtn;
        rtn = ("" + getMoudleGrade()).compareTo("" + obj.getMoudleGrade()); if (rtn != 0) return rtn;
        rtn = ("" + getMoudleType()).compareTo("" + obj.getMoudleType()); if (rtn != 0) return rtn;
        rtn = ("" + getIsDept()).compareTo("" + obj.getIsDept()); if (rtn != 0) return rtn;
        rtn = getToUrl().compareTo(obj.getToUrl()); if (rtn != 0) return rtn;
        rtn = ("" + getOrderNum()).compareTo("" + obj.getOrderNum()); if (rtn != 0) return rtn;
        rtn = ("" + getIsEnable()).compareTo("" + obj.getIsEnable()); if (rtn != 0) return rtn;
        rtn = getOpLog().compareTo(obj.getOpLog()); if (rtn != 0) return rtn;
        return rtn;
    }
}
