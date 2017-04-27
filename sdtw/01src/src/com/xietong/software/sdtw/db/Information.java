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
@Description("资讯信息")
public class Information implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(Information.class);
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
    public static final String DbTableName = "information";
    private String TNAME = "information";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","subject","imageInfo","infoDesc","newDate","userId","userType","attachIds","videoPath","isRecommond","isFocus","dept","isDel","orderNum"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","subject","imageinfo","infodesc","newdate","userid","usertype","attachids","videopath","isrecommond","isfocus","dept","isdel","ordernum"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"Subject","subject","String"},{"ImageInfo","imageinfo","String"},{"InfoDesc","infodesc","String"},{"NewDate","newdate","java.util.Date"},{"UserId","userid","int"},{"UserType","usertype","String"},{"AttachIds","attachids","String"},{"VideoPath","videopath","String"},{"IsRecommond","isrecommond","int"},{"IsFocus","isfocus","int"},{"Dept","dept","String"},{"IsDel","isdel","int"},{"OrderNum","ordernum","int"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"subject","subject"},{"imageInfo","imageinfo"},{"infoDesc","infodesc"},{"newDate","newdate"},{"userId","userid"},{"userType","usertype"},{"attachIds","attachids"},{"videoPath","videopath"},{"isRecommond","isrecommond"},{"isFocus","isfocus"},{"dept","dept"},{"isDel","isdel"},{"orderNum","ordernum"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"NEWDATE"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 标题
    protected String subject = "";
    public String getSubject() {  return SqlTool.getDbString(subject);  }
    public String getSubject(int size) { return SqlTool.subString(getSubject(), size); }
    public void setSubject(String aSubject) { subject = aSubject; modifiedFields.add("Subject"); }
    public void assignSubject(String aSubject) { subject = aSubject; }
    public void paramSubject(HttpServletRequest request) { paramSubject(request, "Subject"); }
    public void paramSubject(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSubject()); if (!tmp.equals(getSubject())) { setSubject(tmp); } }
    // 图片信息
    protected String imageInfo = "";
    public String getImageInfo() {  return SqlTool.getDbString(imageInfo);  }
    public String getImageInfo(int size) { return SqlTool.subString(getImageInfo(), size); }
    public void setImageInfo(String aImageInfo) { imageInfo = aImageInfo; modifiedFields.add("ImageInfo"); }
    public void assignImageInfo(String aImageInfo) { imageInfo = aImageInfo; }
    public void paramImageInfo(HttpServletRequest request) { paramImageInfo(request, "ImageInfo"); }
    public void paramImageInfo(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getImageInfo()); if (!tmp.equals(getImageInfo())) { setImageInfo(tmp); } }
    // 描述
    protected String infoDesc = "";
    public String getInfoDesc() {  return SqlTool.getDbString(infoDesc);  }
    public String getInfoDesc(int size) { return SqlTool.subString(getInfoDesc(), size); }
    public void setInfoDesc(String aInfoDesc) { infoDesc = aInfoDesc; modifiedFields.add("InfoDesc"); }
    public void assignInfoDesc(String aInfoDesc) { infoDesc = aInfoDesc; }
    public void paramInfoDesc(HttpServletRequest request) { paramInfoDesc(request, "InfoDesc"); }
    public void paramInfoDesc(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getInfoDesc()); if (!tmp.equals(getInfoDesc())) { setInfoDesc(tmp); } }
    // 创建时间
    protected java.util.Date newDate = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getNewDate() { return newDate; }
    public void setNewDate(java.util.Date aNewDate) { newDate = aNewDate; modifiedFields.add("NewDate"); }
    public void assignNewDate(java.util.Date aNewDate) { newDate = aNewDate; }
    public void paramNewDate(HttpServletRequest request) { paramNewDate(request, "NewDate"); }
    public void paramNewDate(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getNewDate()); if (tmp.compareTo(getNewDate()) != 0) { setNewDate(tmp); } }
    // 发表人
    protected int userId = -1;
    public int getUserId() { return userId; }
    public void setUserId(int aUserId) { userId = aUserId; modifiedFields.add("UserId"); }
    public void assignUserId(int aUserId) { userId = aUserId; }
    public void paramUserId(HttpServletRequest request) { paramUserId(request, "UserId"); }
    public void paramUserId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getUserId()); if (tmp != getUserId()) { setUserId(tmp); } }
    // 发表人类型
    protected String userType = "";
    public String getUserType() {  return SqlTool.getDbString(userType);  }
    public String getUserType(int size) { return SqlTool.subString(getUserType(), size); }
    public void setUserType(String aUserType) { userType = aUserType; modifiedFields.add("UserType"); }
    public void assignUserType(String aUserType) { userType = aUserType; }
    public void paramUserType(HttpServletRequest request) { paramUserType(request, "UserType"); }
    public void paramUserType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUserType()); if (!tmp.equals(getUserType())) { setUserType(tmp); } }
    // 相关附件ids
    protected String attachIds = "";
    public String getAttachIds() {  return SqlTool.getDbString(attachIds);  }
    public String getAttachIds(int size) { return SqlTool.subString(getAttachIds(), size); }
    public void setAttachIds(String aAttachIds) { attachIds = aAttachIds; modifiedFields.add("AttachIds"); }
    public void assignAttachIds(String aAttachIds) { attachIds = aAttachIds; }
    public void paramAttachIds(HttpServletRequest request) { paramAttachIds(request, "AttachIds"); }
    public void paramAttachIds(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAttachIds()); if (!tmp.equals(getAttachIds())) { setAttachIds(tmp); } }
    // 视频
    protected String videoPath = "";
    public String getVideoPath() {  return SqlTool.getDbString(videoPath);  }
    public String getVideoPath(int size) { return SqlTool.subString(getVideoPath(), size); }
    public void setVideoPath(String aVideoPath) { videoPath = aVideoPath; modifiedFields.add("VideoPath"); }
    public void assignVideoPath(String aVideoPath) { videoPath = aVideoPath; }
    public void paramVideoPath(HttpServletRequest request) { paramVideoPath(request, "VideoPath"); }
    public void paramVideoPath(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVideoPath()); if (!tmp.equals(getVideoPath())) { setVideoPath(tmp); } }
    // 是否推荐
    protected int isRecommond = -1;
    public int getIsRecommond() { return isRecommond; }
    public void setIsRecommond(int aIsRecommond) { isRecommond = aIsRecommond; modifiedFields.add("IsRecommond"); }
    public void assignIsRecommond(int aIsRecommond) { isRecommond = aIsRecommond; }
    public void paramIsRecommond(HttpServletRequest request) { paramIsRecommond(request, "IsRecommond"); }
    public void paramIsRecommond(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getIsRecommond()); if (tmp != getIsRecommond()) { setIsRecommond(tmp); } }
    // 是否焦点
    protected int isFocus = -1;
    public int getIsFocus() { return isFocus; }
    public void setIsFocus(int aIsFocus) { isFocus = aIsFocus; modifiedFields.add("IsFocus"); }
    public void assignIsFocus(int aIsFocus) { isFocus = aIsFocus; }
    public void paramIsFocus(HttpServletRequest request) { paramIsFocus(request, "IsFocus"); }
    public void paramIsFocus(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getIsFocus()); if (tmp != getIsFocus()) { setIsFocus(tmp); } }
    // 部门
    protected String dept = "";
    public String getDept() {  return SqlTool.getDbString(dept);  }
    public String getDept(int size) { return SqlTool.subString(getDept(), size); }
    public void setDept(String aDept) { dept = aDept; modifiedFields.add("Dept"); }
    public void assignDept(String aDept) { dept = aDept; }
    public void paramDept(HttpServletRequest request) { paramDept(request, "Dept"); }
    public void paramDept(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDept()); if (!tmp.equals(getDept())) { setDept(tmp); } }
    // 是否删除
    protected int isDel = -1;
    public int getIsDel() { return isDel; }
    public void setIsDel(int aIsDel) { isDel = aIsDel; modifiedFields.add("IsDel"); }
    public void assignIsDel(int aIsDel) { isDel = aIsDel; }
    public void paramIsDel(HttpServletRequest request) { paramIsDel(request, "IsDel"); }
    public void paramIsDel(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getIsDel()); if (tmp != getIsDel()) { setIsDel(tmp); } }
    // 排序
    protected int orderNum = -1;
    public int getOrderNum() { return orderNum; }
    public void setOrderNum(int aOrderNum) { orderNum = aOrderNum; modifiedFields.add("OrderNum"); }
    public void assignOrderNum(int aOrderNum) { orderNum = aOrderNum; }
    public void paramOrderNum(HttpServletRequest request) { paramOrderNum(request, "OrderNum"); }
    public void paramOrderNum(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getOrderNum()); if (tmp != getOrderNum()) { setOrderNum(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public Information (String db) {
        DBNAME = db;
    }
    public Information (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public Information (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public Information () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return Information类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public Information getByParameter(HttpServletRequest request) {
        Information v = new Information(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramSubject(request);
        paramImageInfo(request);
        paramInfoDesc(request);
        paramNewDate(request);
        paramUserId(request);
        paramUserType(request);
        paramAttachIds(request);
        paramVideoPath(request);
        paramIsRecommond(request);
        paramIsFocus(request);
        paramDept(request);
        paramIsDel(request);
        paramOrderNum(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(Information bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("subject")) { setSubject(bean.getSubject()); }
        if (!ncl.contains("imageInfo")) { setImageInfo(bean.getImageInfo()); }
        if (!ncl.contains("infoDesc")) { setInfoDesc(bean.getInfoDesc()); }
        if (!ncl.contains("newDate")) { setNewDate(bean.getNewDate()); }
        if (!ncl.contains("userId")) { setUserId(bean.getUserId()); }
        if (!ncl.contains("userType")) { setUserType(bean.getUserType()); }
        if (!ncl.contains("attachIds")) { setAttachIds(bean.getAttachIds()); }
        if (!ncl.contains("videoPath")) { setVideoPath(bean.getVideoPath()); }
        if (!ncl.contains("isRecommond")) { setIsRecommond(bean.getIsRecommond()); }
        if (!ncl.contains("isFocus")) { setIsFocus(bean.getIsFocus()); }
        if (!ncl.contains("dept")) { setDept(bean.getDept()); }
        if (!ncl.contains("isDel")) { setIsDel(bean.getIsDel()); }
        if (!ncl.contains("orderNum")) { setOrderNum(bean.getOrderNum()); }
    }
    public Information getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        Information[] rslt= queryByCondition(cdt);
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
     * @return Information类的实例列表。
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
                Information ve = new Information(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignSubject(fromDbCh(rs.getString(2)));
                ve.assignImageInfo(fromDbCh(rs.getString(3)));
                ve.assignInfoDesc(fromDbCh(rs.getString(4)));
                tmpDate = rs.getTimestamp(5); if (tmpDate != null) { ve.assignNewDate(new java.util.Date(tmpDate.getTime())); }
                ve.assignUserId(rs.getInt(6));
                ve.assignUserType(fromDbCh(rs.getString(7)));
                ve.assignAttachIds(fromDbCh(rs.getString(8)));
                ve.assignVideoPath(fromDbCh(rs.getString(9)));
                ve.assignIsRecommond(rs.getInt(10));
                ve.assignIsFocus(rs.getInt(11));
                ve.assignDept(fromDbCh(rs.getString(12)));
                ve.assignIsDel(rs.getInt(13));
                ve.assignOrderNum(rs.getInt(14));
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
    public Information[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (Information[])vrs.toArray(new Information[vrs.size()]);
    }
    public Information[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (Information[])vrs.toArray(new Information[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (subject,imageinfo,infodesc,newdate,userid,usertype,attachids,videopath,isrecommond,isfocus,dept,isdel,ordernum) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(subject));
            System.out.println("wenzangbiaoti"+toDbCh(subject));
            pstmt.setString(2, toDbCh(imageInfo));
            pstmt.setString(3, toDbCh(infoDesc));
            pstmt.setTimestamp(4, new java.sql.Timestamp(newDate.getTime()));
            pstmt.setInt(5, userId);
            pstmt.setString(6, toDbCh(userType));
            pstmt.setString(7, toDbCh(attachIds));
            pstmt.setString(8, toDbCh(videoPath));
            pstmt.setInt(9, isRecommond);
            pstmt.setInt(10, isFocus);
            pstmt.setString(11, toDbCh(dept));
            pstmt.setInt(12, isDel);
            pstmt.setInt(13, orderNum);
            iResult = pstmt.executeUpdate();
            System.out.println(SELECT); 
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,subject,imageinfo,infodesc,newdate,userid,usertype,attachids,videopath,isrecommond,isfocus,dept,isdel,ordernum) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(subject));
            pstmt.setString(3, toDbCh(imageInfo));
            pstmt.setString(4, toDbCh(infoDesc));
            pstmt.setTimestamp(5, new java.sql.Timestamp(newDate.getTime()));
            pstmt.setInt(6, userId);
            pstmt.setString(7, toDbCh(userType));
            pstmt.setString(8, toDbCh(attachIds));
            pstmt.setString(9, toDbCh(videoPath));
            pstmt.setInt(10, isRecommond);
            pstmt.setInt(11, isFocus);
            pstmt.setString(12, toDbCh(dept));
            pstmt.setInt(13, isDel);
            pstmt.setInt(14, orderNum);
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
            Information item = (Information)it.next();
            Information v = new Information(dbname);
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
                if (modifiedFields.contains("Subject")) { pstmt.setString(pi ++, toDbCh(subject)); }
                if (modifiedFields.contains("ImageInfo")) { pstmt.setString(pi ++, toDbCh(imageInfo)); }
                if (modifiedFields.contains("InfoDesc")) { pstmt.setString(pi ++, toDbCh(infoDesc)); }
                if (modifiedFields.contains("NewDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(newDate.getTime())); }
                if (modifiedFields.contains("UserId")) { pstmt.setInt(pi ++, userId); }
                if (modifiedFields.contains("UserType")) { pstmt.setString(pi ++, toDbCh(userType)); }
                if (modifiedFields.contains("AttachIds")) { pstmt.setString(pi ++, toDbCh(attachIds)); }
                if (modifiedFields.contains("VideoPath")) { pstmt.setString(pi ++, toDbCh(videoPath)); }
                if (modifiedFields.contains("IsRecommond")) { pstmt.setInt(pi ++, isRecommond); }
                if (modifiedFields.contains("IsFocus")) { pstmt.setInt(pi ++, isFocus); }
                if (modifiedFields.contains("Dept")) { pstmt.setString(pi ++, toDbCh(dept)); }
                if (modifiedFields.contains("IsDel")) { pstmt.setInt(pi ++, isDel); }
                if (modifiedFields.contains("OrderNum")) { pstmt.setInt(pi ++, orderNum); }
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
                if (modifiedFields.contains("Subject")) { pstmt.setString(pi ++, toDbCh(subject)); }
                if (modifiedFields.contains("ImageInfo")) { pstmt.setString(pi ++, toDbCh(imageInfo)); }
                if (modifiedFields.contains("InfoDesc")) { pstmt.setString(pi ++, toDbCh(infoDesc)); }
                if (modifiedFields.contains("NewDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(newDate.getTime())); }
                if (modifiedFields.contains("UserId")) { pstmt.setInt(pi ++, userId); }
                if (modifiedFields.contains("UserType")) { pstmt.setString(pi ++, toDbCh(userType)); }
                if (modifiedFields.contains("AttachIds")) { pstmt.setString(pi ++, toDbCh(attachIds)); }
                if (modifiedFields.contains("VideoPath")) { pstmt.setString(pi ++, toDbCh(videoPath)); }
                if (modifiedFields.contains("IsRecommond")) { pstmt.setInt(pi ++, isRecommond); }
                if (modifiedFields.contains("IsFocus")) { pstmt.setInt(pi ++, isFocus); }
                if (modifiedFields.contains("Dept")) { pstmt.setString(pi ++, toDbCh(dept)); }
                if (modifiedFields.contains("IsDel")) { pstmt.setInt(pi ++, isDel); }
                if (modifiedFields.contains("OrderNum")) { pstmt.setInt(pi ++, orderNum); }
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
        map.put("Subject", getSubject());
        map.put("ImageInfo", getImageInfo());
        map.put("InfoDesc", getInfoDesc());
        map.put("NewDate", Tool.stringOfDateTime(getNewDate()));
        map.put("UserId", getUserId() + "");
        map.put("UserType", getUserType());
        map.put("AttachIds", getAttachIds());
        map.put("VideoPath", getVideoPath());
        map.put("IsRecommond", getIsRecommond() + "");
        map.put("IsFocus", getIsFocus() + "");
        map.put("Dept", getDept());
        map.put("IsDel", getIsDel() + "");
        map.put("OrderNum", getOrderNum() + "");
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("Subject:\"" + Tool.jsSpecialChars(getSubject()) + "\"");
        row.add("ImageInfo:\"" + Tool.jsSpecialChars(getImageInfo()) + "\"");
        row.add("InfoDesc:\"" + Tool.jsSpecialChars(getInfoDesc()) + "\"");
        row.add("NewDate:\"" + Tool.stringOfDateTime(getNewDate()) + "\"");
        row.add("UserId:\"" + getUserId() + "\"");
        row.add("UserType:\"" + Tool.jsSpecialChars(getUserType()) + "\"");
        row.add("AttachIds:\"" + Tool.jsSpecialChars(getAttachIds()) + "\"");
        row.add("VideoPath:\"" + Tool.jsSpecialChars(getVideoPath()) + "\"");
        row.add("IsRecommond:\"" + getIsRecommond() + "\"");
        row.add("IsFocus:\"" + getIsFocus() + "\"");
        row.add("Dept:\"" + Tool.jsSpecialChars(getDept()) + "\"");
        row.add("IsDel:\"" + getIsDel() + "\"");
        row.add("OrderNum:\"" + getOrderNum() + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,subject varchar2(500),imageinfo varchar2(300),infodesc varchar2(2000),newdate date,userid number(*,0),usertype varchar2(1),attachids varchar2(200),videopath varchar2(200),isrecommond number(*,0),isfocus number(*,0),dept varchar2(50),isdel number(*,0),ordernum number(*,0))"});
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
        Information v = new Information(sourceDb, sourceTb);
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
        Information v = new Information(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(Information obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getSubject().compareTo(obj.getSubject()); if (rtn != 0) return rtn;
        rtn = getImageInfo().compareTo(obj.getImageInfo()); if (rtn != 0) return rtn;
        rtn = getInfoDesc().compareTo(obj.getInfoDesc()); if (rtn != 0) return rtn;
        rtn = getNewDate().compareTo(obj.getNewDate()); if (rtn != 0) return rtn;
        rtn = ("" + getUserId()).compareTo("" + obj.getUserId()); if (rtn != 0) return rtn;
        rtn = getUserType().compareTo(obj.getUserType()); if (rtn != 0) return rtn;
        rtn = getAttachIds().compareTo(obj.getAttachIds()); if (rtn != 0) return rtn;
        rtn = getVideoPath().compareTo(obj.getVideoPath()); if (rtn != 0) return rtn;
        rtn = ("" + getIsRecommond()).compareTo("" + obj.getIsRecommond()); if (rtn != 0) return rtn;
        rtn = ("" + getIsFocus()).compareTo("" + obj.getIsFocus()); if (rtn != 0) return rtn;
        rtn = getDept().compareTo(obj.getDept()); if (rtn != 0) return rtn;
        rtn = ("" + getIsDel()).compareTo("" + obj.getIsDel()); if (rtn != 0) return rtn;
        rtn = ("" + getOrderNum()).compareTo("" + obj.getOrderNum()); if (rtn != 0) return rtn;
        return rtn;
    }
}
