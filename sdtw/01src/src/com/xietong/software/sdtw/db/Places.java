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
@Description("团委场地")
public class Places implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(Places.class);
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
    public static final String DbTableName = "places";
    private String TNAME = "places";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","placeCode","placeName","principal","contact","area","addAccount","addTime","peopleNums","instruments","marks","lastModifyTime","lastModifyAccount"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","placecode","placename","principal","contact","area","addaccount","addtime","peoplenums","instruments","marks","lastmodifytime","lastmodifyaccount"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"PlaceCode","placecode","String"},{"PlaceName","placename","String"},{"Principal","principal","String"},{"Contact","contact","String"},{"Area","area","String"},{"AddAccount","addaccount","String"},{"AddTime","addtime","java.util.Date"},{"PeopleNums","peoplenums","int"},{"Instruments","instruments","String"},{"Marks","marks","String"},{"LastModifyTime","lastmodifytime","java.util.Date"},{"LastModifyAccount","lastmodifyaccount","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"placeCode","placecode"},{"placeName","placename"},{"principal","principal"},{"contact","contact"},{"area","area"},{"addAccount","addaccount"},{"addTime","addtime"},{"peopleNums","peoplenums"},{"instruments","instruments"},{"marks","marks"},{"lastModifyTime","lastmodifytime"},{"lastModifyAccount","lastmodifyaccount"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ADDTIME","LASTMODIFYTIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 地点代码
    protected String placeCode = "";
    public String getPlaceCode() {  return SqlTool.getDbString(placeCode);  }
    public String getPlaceCode(int size) { return SqlTool.subString(getPlaceCode(), size); }
    public void setPlaceCode(String aPlaceCode) { placeCode = aPlaceCode; modifiedFields.add("PlaceCode"); }
    public void assignPlaceCode(String aPlaceCode) { placeCode = aPlaceCode; }
    public void paramPlaceCode(HttpServletRequest request) { paramPlaceCode(request, "PlaceCode"); }
    public void paramPlaceCode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPlaceCode()); if (!tmp.equals(getPlaceCode())) { setPlaceCode(tmp); } }
    // 名称
    protected String placeName = "";
    public String getPlaceName() {  return SqlTool.getDbString(placeName);  }
    public String getPlaceName(int size) { return SqlTool.subString(getPlaceName(), size); }
    public void setPlaceName(String aPlaceName) { placeName = aPlaceName; modifiedFields.add("PlaceName"); }
    public void assignPlaceName(String aPlaceName) { placeName = aPlaceName; }
    public void paramPlaceName(HttpServletRequest request) { paramPlaceName(request, "PlaceName"); }
    public void paramPlaceName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPlaceName()); if (!tmp.equals(getPlaceName())) { setPlaceName(tmp); } }
    // 发布人
    protected String principal = "";
    public String getPrincipal() {  return SqlTool.getDbString(principal);  }
    public String getPrincipal(int size) { return SqlTool.subString(getPrincipal(), size); }
    public void setPrincipal(String aPrincipal) { principal = aPrincipal; modifiedFields.add("Principal"); }
    public void assignPrincipal(String aPrincipal) { principal = aPrincipal; }
    public void paramPrincipal(HttpServletRequest request) { paramPrincipal(request, "Principal"); }
    public void paramPrincipal(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPrincipal()); if (!tmp.equals(getPrincipal())) { setPrincipal(tmp); } }
    // 联系人
    protected String contact = "";
    public String getContact() {  return SqlTool.getDbString(contact);  }
    public String getContact(int size) { return SqlTool.subString(getContact(), size); }
    public void setContact(String aContact) { contact = aContact; modifiedFields.add("Contact"); }
    public void assignContact(String aContact) { contact = aContact; }
    public void paramContact(HttpServletRequest request) { paramContact(request, "Contact"); }
    public void paramContact(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getContact()); if (!tmp.equals(getContact())) { setContact(tmp); } }
    // 地点
    protected String area = "";
    public String getArea() {  return SqlTool.getDbString(area);  }
    public String getArea(int size) { return SqlTool.subString(getArea(), size); }
    public void setArea(String aArea) { area = aArea; modifiedFields.add("Area"); }
    public void assignArea(String aArea) { area = aArea; }
    public void paramArea(HttpServletRequest request) { paramArea(request, "Area"); }
    public void paramArea(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getArea()); if (!tmp.equals(getArea())) { setArea(tmp); } }
    // 添加人
    protected String addAccount = "";
    public String getAddAccount() {  return SqlTool.getDbString(addAccount);  }
    public String getAddAccount(int size) { return SqlTool.subString(getAddAccount(), size); }
    public void setAddAccount(String aAddAccount) { addAccount = aAddAccount; modifiedFields.add("AddAccount"); }
    public void assignAddAccount(String aAddAccount) { addAccount = aAddAccount; }
    public void paramAddAccount(HttpServletRequest request) { paramAddAccount(request, "AddAccount"); }
    public void paramAddAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddAccount()); if (!tmp.equals(getAddAccount())) { setAddAccount(tmp); } }
    // 添加时间
    protected java.util.Date addTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddTime() { return addTime; }
    public void setAddTime(java.util.Date aAddTime) { addTime = aAddTime; modifiedFields.add("AddTime"); }
    public void assignAddTime(java.util.Date aAddTime) { addTime = aAddTime; }
    public void paramAddTime(HttpServletRequest request) { paramAddTime(request, "AddTime"); }
    public void paramAddTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddTime()); if (tmp.compareTo(getAddTime()) != 0) { setAddTime(tmp); } }
    // 人数
    protected int peopleNums = -1;
    public int getPeopleNums() { return peopleNums; }
    public void setPeopleNums(int aPeopleNums) { peopleNums = aPeopleNums; modifiedFields.add("PeopleNums"); }
    public void assignPeopleNums(int aPeopleNums) { peopleNums = aPeopleNums; }
    public void paramPeopleNums(HttpServletRequest request) { paramPeopleNums(request, "PeopleNums"); }
    public void paramPeopleNums(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getPeopleNums()); if (tmp != getPeopleNums()) { setPeopleNums(tmp); } }
    // 场地设备
    protected String instruments = "";
    public String getInstruments() {  return SqlTool.getDbString(instruments);  }
    public String getInstruments(int size) { return SqlTool.subString(getInstruments(), size); }
    public void setInstruments(String aInstruments) { instruments = aInstruments; modifiedFields.add("Instruments"); }
    public void assignInstruments(String aInstruments) { instruments = aInstruments; }
    public void paramInstruments(HttpServletRequest request) { paramInstruments(request, "Instruments"); }
    public void paramInstruments(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getInstruments()); if (!tmp.equals(getInstruments())) { setInstruments(tmp); } }
    // 备注
    protected String marks = "";
    public String getMarks() {  return SqlTool.getDbString(marks);  }
    public String getMarks(int size) { return SqlTool.subString(getMarks(), size); }
    public void setMarks(String aMarks) { marks = aMarks; modifiedFields.add("Marks"); }
    public void assignMarks(String aMarks) { marks = aMarks; }
    public void paramMarks(HttpServletRequest request) { paramMarks(request, "Marks"); }
    public void paramMarks(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMarks()); if (!tmp.equals(getMarks())) { setMarks(tmp); } }
    // 最后修改时间
    protected java.util.Date lastModifyTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getLastModifyTime() { return lastModifyTime; }
    public void setLastModifyTime(java.util.Date aLastModifyTime) { lastModifyTime = aLastModifyTime; modifiedFields.add("LastModifyTime"); }
    public void assignLastModifyTime(java.util.Date aLastModifyTime) { lastModifyTime = aLastModifyTime; }
    public void paramLastModifyTime(HttpServletRequest request) { paramLastModifyTime(request, "LastModifyTime"); }
    public void paramLastModifyTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getLastModifyTime()); if (tmp.compareTo(getLastModifyTime()) != 0) { setLastModifyTime(tmp); } }
    // 最后修改人
    protected String lastModifyAccount = "";
    public String getLastModifyAccount() {  return SqlTool.getDbString(lastModifyAccount);  }
    public String getLastModifyAccount(int size) { return SqlTool.subString(getLastModifyAccount(), size); }
    public void setLastModifyAccount(String aLastModifyAccount) { lastModifyAccount = aLastModifyAccount; modifiedFields.add("LastModifyAccount"); }
    public void assignLastModifyAccount(String aLastModifyAccount) { lastModifyAccount = aLastModifyAccount; }
    public void paramLastModifyAccount(HttpServletRequest request) { paramLastModifyAccount(request, "LastModifyAccount"); }
    public void paramLastModifyAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getLastModifyAccount()); if (!tmp.equals(getLastModifyAccount())) { setLastModifyAccount(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public Places (String db) {
        DBNAME = db;
    }
    public Places (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public Places (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public Places () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return Places类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public Places getByParameter(HttpServletRequest request) {
        Places v = new Places(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramPlaceCode(request);
        paramPlaceName(request);
        paramPrincipal(request);
        paramContact(request);
        paramArea(request);
        paramAddAccount(request);
        paramAddTime(request);
        paramPeopleNums(request);
        paramInstruments(request);
        paramMarks(request);
        paramLastModifyTime(request);
        paramLastModifyAccount(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(Places bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("placeCode")) { setPlaceCode(bean.getPlaceCode()); }
        if (!ncl.contains("placeName")) { setPlaceName(bean.getPlaceName()); }
        if (!ncl.contains("principal")) { setPrincipal(bean.getPrincipal()); }
        if (!ncl.contains("contact")) { setContact(bean.getContact()); }
        if (!ncl.contains("area")) { setArea(bean.getArea()); }
        if (!ncl.contains("addAccount")) { setAddAccount(bean.getAddAccount()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("peopleNums")) { setPeopleNums(bean.getPeopleNums()); }
        if (!ncl.contains("instruments")) { setInstruments(bean.getInstruments()); }
        if (!ncl.contains("marks")) { setMarks(bean.getMarks()); }
        if (!ncl.contains("lastModifyTime")) { setLastModifyTime(bean.getLastModifyTime()); }
        if (!ncl.contains("lastModifyAccount")) { setLastModifyAccount(bean.getLastModifyAccount()); }
    }
    public Places getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        Places[] rslt= queryByCondition(cdt);
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
     * @return Places类的实例列表。
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
                Places ve = new Places(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignPlaceCode(fromDbCh(rs.getString(2)));
                ve.assignPlaceName(fromDbCh(rs.getString(3)));
                ve.assignPrincipal(fromDbCh(rs.getString(4)));
                ve.assignContact(fromDbCh(rs.getString(5)));
                ve.assignArea(fromDbCh(rs.getString(6)));
                ve.assignAddAccount(fromDbCh(rs.getString(7)));
                tmpDate = rs.getTimestamp(8); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignPeopleNums(rs.getInt(9));
                ve.assignInstruments(fromDbCh(rs.getString(10)));
                ve.assignMarks(fromDbCh(rs.getString(11)));
                tmpDate = rs.getTimestamp(12); if (tmpDate != null) { ve.assignLastModifyTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignLastModifyAccount(fromDbCh(rs.getString(13)));
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
    public Places[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (Places[])vrs.toArray(new Places[vrs.size()]);
    }
    public Places[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (Places[])vrs.toArray(new Places[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (placecode,placename,principal,contact,area,addaccount,addtime,peoplenums,instruments,marks,lastmodifytime,lastmodifyaccount) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(placeCode));
            pstmt.setString(2, toDbCh(placeName));
            pstmt.setString(3, toDbCh(principal));
            pstmt.setString(4, toDbCh(contact));
            pstmt.setString(5, toDbCh(area));
            pstmt.setString(6, toDbCh(addAccount));
            pstmt.setTimestamp(7, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setInt(8, peopleNums);
            pstmt.setString(9, toDbCh(instruments));
            pstmt.setString(10, toDbCh(marks));
            pstmt.setTimestamp(11, new java.sql.Timestamp(lastModifyTime.getTime()));
            pstmt.setString(12, toDbCh(lastModifyAccount));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,placecode,placename,principal,contact,area,addaccount,addtime,peoplenums,instruments,marks,lastmodifytime,lastmodifyaccount) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(placeCode));
            pstmt.setString(3, toDbCh(placeName));
            pstmt.setString(4, toDbCh(principal));
            pstmt.setString(5, toDbCh(contact));
            pstmt.setString(6, toDbCh(area));
            pstmt.setString(7, toDbCh(addAccount));
            pstmt.setTimestamp(8, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setInt(9, peopleNums);
            pstmt.setString(10, toDbCh(instruments));
            pstmt.setString(11, toDbCh(marks));
            pstmt.setTimestamp(12, new java.sql.Timestamp(lastModifyTime.getTime()));
            pstmt.setString(13, toDbCh(lastModifyAccount));
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
            Places item = (Places)it.next();
            Places v = new Places(dbname);
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
                if (modifiedFields.contains("PlaceCode")) { pstmt.setString(pi ++, toDbCh(placeCode)); }
                if (modifiedFields.contains("PlaceName")) { pstmt.setString(pi ++, toDbCh(placeName)); }
                if (modifiedFields.contains("Principal")) { pstmt.setString(pi ++, toDbCh(principal)); }
                if (modifiedFields.contains("Contact")) { pstmt.setString(pi ++, toDbCh(contact)); }
                if (modifiedFields.contains("Area")) { pstmt.setString(pi ++, toDbCh(area)); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("PeopleNums")) { pstmt.setInt(pi ++, peopleNums); }
                if (modifiedFields.contains("Instruments")) { pstmt.setString(pi ++, toDbCh(instruments)); }
                if (modifiedFields.contains("Marks")) { pstmt.setString(pi ++, toDbCh(marks)); }
                if (modifiedFields.contains("LastModifyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(lastModifyTime.getTime())); }
                if (modifiedFields.contains("LastModifyAccount")) { pstmt.setString(pi ++, toDbCh(lastModifyAccount)); }
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
                if (modifiedFields.contains("PlaceCode")) { pstmt.setString(pi ++, toDbCh(placeCode)); }
                if (modifiedFields.contains("PlaceName")) { pstmt.setString(pi ++, toDbCh(placeName)); }
                if (modifiedFields.contains("Principal")) { pstmt.setString(pi ++, toDbCh(principal)); }
                if (modifiedFields.contains("Contact")) { pstmt.setString(pi ++, toDbCh(contact)); }
                if (modifiedFields.contains("Area")) { pstmt.setString(pi ++, toDbCh(area)); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("PeopleNums")) { pstmt.setInt(pi ++, peopleNums); }
                if (modifiedFields.contains("Instruments")) { pstmt.setString(pi ++, toDbCh(instruments)); }
                if (modifiedFields.contains("Marks")) { pstmt.setString(pi ++, toDbCh(marks)); }
                if (modifiedFields.contains("LastModifyTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(lastModifyTime.getTime())); }
                if (modifiedFields.contains("LastModifyAccount")) { pstmt.setString(pi ++, toDbCh(lastModifyAccount)); }
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
        map.put("PlaceCode", getPlaceCode());
        map.put("PlaceName", getPlaceName());
        map.put("Principal", getPrincipal());
        map.put("Contact", getContact());
        map.put("Area", getArea());
        map.put("AddAccount", getAddAccount());
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("PeopleNums", getPeopleNums() + "");
        map.put("Instruments", getInstruments());
        map.put("Marks", getMarks());
        map.put("LastModifyTime", Tool.stringOfDateTime(getLastModifyTime()));
        map.put("LastModifyAccount", getLastModifyAccount());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("PlaceCode:\"" + Tool.jsSpecialChars(getPlaceCode()) + "\"");
        row.add("PlaceName:\"" + Tool.jsSpecialChars(getPlaceName()) + "\"");
        row.add("Principal:\"" + Tool.jsSpecialChars(getPrincipal()) + "\"");
        row.add("Contact:\"" + Tool.jsSpecialChars(getContact()) + "\"");
        row.add("Area:\"" + Tool.jsSpecialChars(getArea()) + "\"");
        row.add("AddAccount:\"" + Tool.jsSpecialChars(getAddAccount()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("PeopleNums:\"" + getPeopleNums() + "\"");
        row.add("Instruments:\"" + Tool.jsSpecialChars(getInstruments()) + "\"");
        row.add("Marks:\"" + Tool.jsSpecialChars(getMarks()) + "\"");
        row.add("LastModifyTime:\"" + Tool.stringOfDateTime(getLastModifyTime()) + "\"");
        row.add("LastModifyAccount:\"" + Tool.jsSpecialChars(getLastModifyAccount()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,placecode varchar2(45),placename varchar2(50),principal varchar2(50),contact varchar2(50),area varchar2(50),addaccount varchar2(50),addtime date,peoplenums number(*,0),instruments varchar2(50),marks varchar2(255),lastmodifytime date,lastmodifyaccount varchar2(50))"});
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
        Places v = new Places(sourceDb, sourceTb);
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
        Places v = new Places(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(Places obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getPlaceCode().compareTo(obj.getPlaceCode()); if (rtn != 0) return rtn;
        rtn = getPlaceName().compareTo(obj.getPlaceName()); if (rtn != 0) return rtn;
        rtn = getPrincipal().compareTo(obj.getPrincipal()); if (rtn != 0) return rtn;
        rtn = getContact().compareTo(obj.getContact()); if (rtn != 0) return rtn;
        rtn = getArea().compareTo(obj.getArea()); if (rtn != 0) return rtn;
        rtn = getAddAccount().compareTo(obj.getAddAccount()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = ("" + getPeopleNums()).compareTo("" + obj.getPeopleNums()); if (rtn != 0) return rtn;
        rtn = getInstruments().compareTo(obj.getInstruments()); if (rtn != 0) return rtn;
        rtn = getMarks().compareTo(obj.getMarks()); if (rtn != 0) return rtn;
        rtn = getLastModifyTime().compareTo(obj.getLastModifyTime()); if (rtn != 0) return rtn;
        rtn = getLastModifyAccount().compareTo(obj.getLastModifyAccount()); if (rtn != 0) return rtn;
        return rtn;
    }
}
