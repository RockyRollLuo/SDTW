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
@Description("角色表")
public class BaseRoleCode implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(BaseRoleCode.class);
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
    public static final String DbTableName = "base_rolecode";
    private String TNAME = "base_rolecode";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","name","code","funIds","funCodes","moudleIds","moudleCode","orderNum","isEnable","opLog"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","name","code","funids","funcodes","moudleids","moudlecode","ordernum","isenable","oplog"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"Name","name","String"},{"Code","code","String"},{"FunIds","funids","String"},{"FunCodes","funcodes","String"},{"MoudleIds","moudleids","String"},{"MoudleCode","moudlecode","String"},{"OrderNum","ordernum","int"},{"IsEnable","isenable","int"},{"OpLog","oplog","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"name","name"},{"code","code"},{"funIds","funids"},{"funCodes","funcodes"},{"moudleIds","moudleids"},{"moudleCode","moudlecode"},{"orderNum","ordernum"},{"isEnable","isenable"},{"opLog","oplog"}};
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
    // 角色名
    protected String name = "";
    public String getName() {  return SqlTool.getDbString(name);  }
    public String getName(int size) { return SqlTool.subString(getName(), size); }
    public void setName(String aName) { name = aName; modifiedFields.add("Name"); refreshFlag = true; }
    public void assignName(String aName) { name = aName; }
    public void paramName(HttpServletRequest request) { paramName(request, "Name"); }
    public void paramName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getName()); if (!tmp.equals(getName())) { setName(tmp); } }
    // 角色代码
    protected String code = "";
    public String getCode() {  return SqlTool.getDbString(code);  }
    public String getCode(int size) { return SqlTool.subString(getCode(), size); }
    public void setCode(String aCode) { code = aCode; modifiedFields.add("Code"); }
    public void assignCode(String aCode) { code = aCode; }
    public void paramCode(HttpServletRequest request) { paramCode(request, "Code"); }
    public void paramCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCode()); if (!tmp.equals(getCode())) { setCode(tmp); } }
    // 功能点权限
    protected String funIds = "";
    public String getFunIds() {  return SqlTool.getDbString(funIds);  }
    public String getFunIds(int size) { return SqlTool.subString(getFunIds(), size); }
    public void setFunIds(String aFunIds) { funIds = aFunIds; modifiedFields.add("FunIds"); }
    public void assignFunIds(String aFunIds) { funIds = aFunIds; }
    public void paramFunIds(HttpServletRequest request) { paramFunIds(request, "FunIds"); }
    public void paramFunIds(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFunIds()); if (!tmp.equals(getFunIds())) { setFunIds(tmp); } }
    // 功能点权限代码
    protected String funCodes = "";
    public String getFunCodes() {  return SqlTool.getDbString(funCodes);  }
    public String getFunCodes(int size) { return SqlTool.subString(getFunCodes(), size); }
    public void setFunCodes(String aFunCodes) { funCodes = aFunCodes; modifiedFields.add("FunCodes"); }
    public void assignFunCodes(String aFunCodes) { funCodes = aFunCodes; }
    public void paramFunCodes(HttpServletRequest request) { paramFunCodes(request, "FunCodes"); }
    public void paramFunCodes(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getFunCodes()); if (!tmp.equals(getFunCodes())) { setFunCodes(tmp); } }
    // 模块权限
    protected String moudleIds = "";
    public String getMoudleIds() {  return SqlTool.getDbString(moudleIds);  }
    public String getMoudleIds(int size) { return SqlTool.subString(getMoudleIds(), size); }
    public void setMoudleIds(String aMoudleIds) { moudleIds = aMoudleIds; modifiedFields.add("MoudleIds"); }
    public void assignMoudleIds(String aMoudleIds) { moudleIds = aMoudleIds; }
    public void paramMoudleIds(HttpServletRequest request) { paramMoudleIds(request, "MoudleIds"); }
    public void paramMoudleIds(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMoudleIds()); if (!tmp.equals(getMoudleIds())) { setMoudleIds(tmp); } }
    // 模块权限代码
    protected String moudleCode = "";
    public String getMoudleCode() {  return SqlTool.getDbString(moudleCode);  }
    public String getMoudleCode(int size) { return SqlTool.subString(getMoudleCode(), size); }
    public void setMoudleCode(String aMoudleCode) { moudleCode = aMoudleCode; modifiedFields.add("MoudleCode"); }
    public void assignMoudleCode(String aMoudleCode) { moudleCode = aMoudleCode; }
    public void paramMoudleCode(HttpServletRequest request) { paramMoudleCode(request, "MoudleCode"); }
    public void paramMoudleCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMoudleCode()); if (!tmp.equals(getMoudleCode())) { setMoudleCode(tmp); } }
    // 排序
    protected int orderNum = -1;
    public int getOrderNum() { return orderNum; }
    public void setOrderNum(int aOrderNum) { orderNum = aOrderNum; modifiedFields.add("OrderNum"); }
    public void assignOrderNum(int aOrderNum) { orderNum = aOrderNum; }
    public void paramOrderNum(HttpServletRequest request) { paramOrderNum(request, "OrderNum"); }
    public void paramOrderNum(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getOrderNum()); if (tmp != getOrderNum()) { setOrderNum(tmp); } }
    // 有效标志
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
    public BaseRoleCode (String db) {
        DBNAME = db;
    }
    public BaseRoleCode (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public BaseRoleCode (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public BaseRoleCode () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return BaseRoleCode类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public BaseRoleCode getByParameter(HttpServletRequest request) {
        BaseRoleCode v = new BaseRoleCode(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramName(request);
        paramCode(request);
        paramFunIds(request);
        paramFunCodes(request);
        paramMoudleIds(request);
        paramMoudleCode(request);
        paramOrderNum(request);
        paramIsEnable(request);
        paramOpLog(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(BaseRoleCode bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("name")) { setName(bean.getName()); }
        if (!ncl.contains("code")) { setCode(bean.getCode()); }
        if (!ncl.contains("funIds")) { setFunIds(bean.getFunIds()); }
        if (!ncl.contains("funCodes")) { setFunCodes(bean.getFunCodes()); }
        if (!ncl.contains("moudleIds")) { setMoudleIds(bean.getMoudleIds()); }
        if (!ncl.contains("moudleCode")) { setMoudleCode(bean.getMoudleCode()); }
        if (!ncl.contains("orderNum")) { setOrderNum(bean.getOrderNum()); }
        if (!ncl.contains("isEnable")) { setIsEnable(bean.getIsEnable()); }
        if (!ncl.contains("opLog")) { setOpLog(bean.getOpLog()); }
    }
    public BaseRoleCode getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        BaseRoleCode[] rslt= queryByCondition(cdt);
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
     * @return BaseRoleCode类的实例列表。
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
                BaseRoleCode ve = new BaseRoleCode(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignName(fromDbCh(rs.getString(2)));
                ve.assignCode(fromDbCh(rs.getString(3)));
                ve.assignFunIds(fromDbCh(rs.getString(4)));
                ve.assignFunCodes(fromDbCh(rs.getString(5)));
                ve.assignMoudleIds(fromDbCh(rs.getString(6)));
                ve.assignMoudleCode(fromDbCh(rs.getString(7)));
                ve.assignOrderNum(rs.getInt(8));
                ve.assignIsEnable(rs.getInt(9));
                ve.assignOpLog(fromDbCh(rs.getString(10)));
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
    public BaseRoleCode[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (BaseRoleCode[])vrs.toArray(new BaseRoleCode[vrs.size()]);
    }
    public BaseRoleCode[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (BaseRoleCode[])vrs.toArray(new BaseRoleCode[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (name,code,funids,funcodes,moudleids,moudlecode,ordernum,isenable,oplog) VALUES (?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(name));
            pstmt.setString(2, toDbCh(code));
            pstmt.setString(3, toDbCh(funIds));
            pstmt.setString(4, toDbCh(funCodes));
            pstmt.setString(5, toDbCh(moudleIds));
            pstmt.setString(6, toDbCh(moudleCode));
            pstmt.setInt(7, orderNum);
            pstmt.setInt(8, isEnable);
            pstmt.setString(9, toDbCh(opLog));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseRoleCode");
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,name,code,funids,funcodes,moudleids,moudlecode,ordernum,isenable,oplog) VALUES (?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(name));
            pstmt.setString(3, toDbCh(code));
            pstmt.setString(4, toDbCh(funIds));
            pstmt.setString(5, toDbCh(funCodes));
            pstmt.setString(6, toDbCh(moudleIds));
            pstmt.setString(7, toDbCh(moudleCode));
            pstmt.setInt(8, orderNum);
            pstmt.setInt(9, isEnable);
            pstmt.setString(10, toDbCh(opLog));
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseRoleCode");
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
            BaseRoleCode item = (BaseRoleCode)it.next();
            BaseRoleCode v = new BaseRoleCode(dbname);
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
                if (modifiedFields.contains("Name")) { pstmt.setString(pi ++, toDbCh(name)); }
                if (modifiedFields.contains("Code")) { pstmt.setString(pi ++, toDbCh(code)); }
                if (modifiedFields.contains("FunIds")) { pstmt.setString(pi ++, toDbCh(funIds)); }
                if (modifiedFields.contains("FunCodes")) { pstmt.setString(pi ++, toDbCh(funCodes)); }
                if (modifiedFields.contains("MoudleIds")) { pstmt.setString(pi ++, toDbCh(moudleIds)); }
                if (modifiedFields.contains("MoudleCode")) { pstmt.setString(pi ++, toDbCh(moudleCode)); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseRoleCode");
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
                if (modifiedFields.contains("Name")) { pstmt.setString(pi ++, toDbCh(name)); }
                if (modifiedFields.contains("Code")) { pstmt.setString(pi ++, toDbCh(code)); }
                if (modifiedFields.contains("FunIds")) { pstmt.setString(pi ++, toDbCh(funIds)); }
                if (modifiedFields.contains("FunCodes")) { pstmt.setString(pi ++, toDbCh(funCodes)); }
                if (modifiedFields.contains("MoudleIds")) { pstmt.setString(pi ++, toDbCh(moudleIds)); }
                if (modifiedFields.contains("MoudleCode")) { pstmt.setString(pi ++, toDbCh(moudleCode)); }
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
            CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseRoleCode");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseRoleCode");
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
        CEditConst.setRefreshFlag(DBNAME, "com.xietong.software.sdtw.db.BaseRoleCode");
        return iResult;
    }
    public TreeItem cloneTi(BaseRoleCode item) {
        TreeItem ti = new TreeItem();
        ti.setId(item.getId());
        ti.setCode(item.getCode());
        ti.setName(item.getName());
        ti.setOrders(item.getCode());
        return ti;
    }
    public String findRootKey(Map parent) {
        List allids = new ArrayList();
        for (Iterator mit = parent.keySet().iterator(); mit.hasNext();) {
            String key = (String)mit.next();
            List list = (List)parent.get(key);
            for (Iterator it = list.iterator(); it.hasNext();) {
                BaseRoleCode v = (BaseRoleCode)it.next();
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
    public TreeItem initTree(BaseRoleCode item, Map parent) {
        TreeItem ti = cloneTi(item);
        List list = (List)parent.get("" + item.getId());
        if (list != null) {
            for (Iterator it = list.iterator(); it.hasNext(); ) {
                BaseRoleCode v = (BaseRoleCode)it.next();
                TreeItem nti = cloneTi(v);
                nti.setPid(ti.getId());
                nti.setPcode(ti.getCode());
                TreeItem sti = initTree(v, parent);
                sti.setPid(ti.getId());
                sti.setPcode(ti.getCode());
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
        Map code2idmap = new HashMap();
        for (Iterator it = vs.iterator(); it.hasNext(); ) {
            BaseRoleCode v = (BaseRoleCode)it.next();
            code2idmap.put(v.getCode(), "" + v.getId());
        }
        CodeUtils codeutils = new CodeUtils(HeadConst.splitType);
        Map map = new HashMap();
        for (Iterator it = vs.iterator(); it.hasNext(); ) {
            BaseRoleCode v = (BaseRoleCode)it.next();
            String pid = (String)code2idmap.get(codeutils.getPcode(v.getCode()));
            if (pid == null) {
                pid = "0";
            }
            List child = (List)map.get(pid);
            if (child == null) {
                child = new ArrayList();
            }
            child.add(v);
            map.put(pid, child);
        }
        return map;
    }
    public Map toMap() {
        Map map = new HashMap();
        map.put("Id", getId() + "");
        map.put("Name", getName());
        map.put("Code", getCode());
        map.put("FunIds", getFunIds());
        map.put("FunCodes", getFunCodes());
        map.put("MoudleIds", getMoudleIds());
        map.put("MoudleCode", getMoudleCode());
        map.put("OrderNum", getOrderNum() + "");
        map.put("IsEnable", getIsEnable() + "");
        map.put("OpLog", getOpLog());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("Name:\"" + Tool.jsSpecialChars(getName()) + "\"");
        row.add("Code:\"" + Tool.jsSpecialChars(getCode()) + "\"");
        row.add("FunIds:\"" + Tool.jsSpecialChars(getFunIds()) + "\"");
        row.add("FunCodes:\"" + Tool.jsSpecialChars(getFunCodes()) + "\"");
        row.add("MoudleIds:\"" + Tool.jsSpecialChars(getMoudleIds()) + "\"");
        row.add("MoudleCode:\"" + Tool.jsSpecialChars(getMoudleCode()) + "\"");
        row.add("OrderNum:\"" + getOrderNum() + "\"");
        row.add("IsEnable:\"" + getIsEnable() + "\"");
        row.add("OpLog:\"" + Tool.jsSpecialChars(getOpLog()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,name varchar2(200),code varchar2(200),funids varchar2(1000),funcodes varchar2(1000),moudleids varchar2(1000),moudlecode varchar2(1000),ordernum number(*,0),isenable number(*,0),oplog varchar2(1000))"});
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
        BaseRoleCode v = new BaseRoleCode(sourceDb, sourceTb);
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
        BaseRoleCode v = new BaseRoleCode(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(BaseRoleCode obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getName().compareTo(obj.getName()); if (rtn != 0) return rtn;
        rtn = getCode().compareTo(obj.getCode()); if (rtn != 0) return rtn;
        rtn = getFunIds().compareTo(obj.getFunIds()); if (rtn != 0) return rtn;
        rtn = getFunCodes().compareTo(obj.getFunCodes()); if (rtn != 0) return rtn;
        rtn = getMoudleIds().compareTo(obj.getMoudleIds()); if (rtn != 0) return rtn;
        rtn = getMoudleCode().compareTo(obj.getMoudleCode()); if (rtn != 0) return rtn;
        rtn = ("" + getOrderNum()).compareTo("" + obj.getOrderNum()); if (rtn != 0) return rtn;
        rtn = ("" + getIsEnable()).compareTo("" + obj.getIsEnable()); if (rtn != 0) return rtn;
        rtn = getOpLog().compareTo(obj.getOpLog()); if (rtn != 0) return rtn;
        return rtn;
    }
}
