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
@Description("参加社会实践团队表")
public class PracticeDeclareTeam implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(PracticeDeclareTeam.class);
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
    public static final String DbTableName = "practice_declare_team";
    private String TNAME = "practice_declare_team";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","practiceId","teamName","academy","practiceReportTeamType","report21","report22","remark","remark2","remark3","remark4","honor"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","practiceid","teamname","academy","practicereportteamtype","report21","report22","remark","remark2","remark3","remark4","honor"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"PracticeId","practiceid","String"},{"TeamName","teamname","String"},{"Academy","academy","String"},{"PracticeReportTeamType","practicereportteamtype","String"},{"Report21","report21","String"},{"Report22","report22","String"},{"Remark","remark","String"},{"Remark2","remark2","String"},{"Remark3","remark3","String"},{"Remark4","remark4","String"},{"Honor","honor","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"practiceId","practiceid"},{"teamName","teamname"},{"academy","academy"},{"practiceReportTeamType","practicereportteamtype"},{"report21","report21"},{"report22","report22"},{"remark","remark"},{"remark2","remark2"},{"remark3","remark3"},{"remark4","remark4"},{"honor","honor"}};
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
    public void setId(int aId) { id = aId; modifiedFields.add("Id"); }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 结题表ID
    protected String practiceId = "";
    public String getPracticeId() {  return SqlTool.getDbString(practiceId);  }
    public String getPracticeId(int size) { return SqlTool.subString(getPracticeId(), size); }
    public void setPracticeId(String aPracticeId) { practiceId = aPracticeId; modifiedFields.add("PracticeId"); }
    public void assignPracticeId(String aPracticeId) { practiceId = aPracticeId; }
    public void paramPracticeId(HttpServletRequest request) { paramPracticeId(request, "PracticeId"); }
    public void paramPracticeId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPracticeId()); if (!tmp.equals(getPracticeId())) { setPracticeId(tmp); } }
    // 团队名称
    protected String teamName = "";
    public String getTeamName() {  return SqlTool.getDbString(teamName);  }
    public String getTeamName(int size) { return SqlTool.subString(getTeamName(), size); }
    public void setTeamName(String aTeamName) { teamName = aTeamName; modifiedFields.add("TeamName"); }
    public void assignTeamName(String aTeamName) { teamName = aTeamName; }
    public void paramTeamName(HttpServletRequest request) { paramTeamName(request, "TeamName"); }
    public void paramTeamName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTeamName()); if (!tmp.equals(getTeamName())) { setTeamName(tmp); } }
    // 所属学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 团队类别
    protected String practiceReportTeamType = "";
    public String getPracticeReportTeamType() {  return SqlTool.getDbString(practiceReportTeamType);  }
    public String getPracticeReportTeamType(int size) { return SqlTool.subString(getPracticeReportTeamType(), size); }
    public void setPracticeReportTeamType(String aPracticeReportTeamType) { practiceReportTeamType = aPracticeReportTeamType; modifiedFields.add("PracticeReportTeamType"); }
    public void assignPracticeReportTeamType(String aPracticeReportTeamType) { practiceReportTeamType = aPracticeReportTeamType; }
    public void paramPracticeReportTeamType(HttpServletRequest request) { paramPracticeReportTeamType(request, "PracticeReportTeamType"); }
    public void paramPracticeReportTeamType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPracticeReportTeamType()); if (!tmp.equals(getPracticeReportTeamType())) { setPracticeReportTeamType(tmp); } }
    // 团队活动小结
    protected String report21 = "";
    public String getReport21() {  return SqlTool.getDbString(report21);  }
    public String getReport21(int size) { return SqlTool.subString(getReport21(), size); }
    public void setReport21(String aReport21) { report21 = aReport21; modifiedFields.add("Report21"); }
    public void assignReport21(String aReport21) { report21 = aReport21; }
    public void paramReport21(HttpServletRequest request) { paramReport21(request, "Report21"); }
    public void paramReport21(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport21()); if (!tmp.equals(getReport21())) { setReport21(tmp); } }
    // 团队主要成绩成果
    protected String report22 = "";
    public String getReport22() {  return SqlTool.getDbString(report22);  }
    public String getReport22(int size) { return SqlTool.subString(getReport22(), size); }
    public void setReport22(String aReport22) { report22 = aReport22; modifiedFields.add("Report22"); }
    public void assignReport22(String aReport22) { report22 = aReport22; }
    public void paramReport22(HttpServletRequest request) { paramReport22(request, "Report22"); }
    public void paramReport22(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReport22()); if (!tmp.equals(getReport22())) { setReport22(tmp); } }
    // 备用
    protected String remark = "";
    public String getRemark() {  return SqlTool.getDbString(remark);  }
    public String getRemark(int size) { return SqlTool.subString(getRemark(), size); }
    public void setRemark(String aRemark) { remark = aRemark; modifiedFields.add("Remark"); }
    public void assignRemark(String aRemark) { remark = aRemark; }
    public void paramRemark(HttpServletRequest request) { paramRemark(request, "Remark"); }
    public void paramRemark(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark()); if (!tmp.equals(getRemark())) { setRemark(tmp); } }
    // 备用
    protected String remark2 = "";
    public String getRemark2() {  return SqlTool.getDbString(remark2);  }
    public String getRemark2(int size) { return SqlTool.subString(getRemark2(), size); }
    public void setRemark2(String aRemark2) { remark2 = aRemark2; modifiedFields.add("Remark2"); }
    public void assignRemark2(String aRemark2) { remark2 = aRemark2; }
    public void paramRemark2(HttpServletRequest request) { paramRemark2(request, "Remark2"); }
    public void paramRemark2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark2()); if (!tmp.equals(getRemark2())) { setRemark2(tmp); } }
    // 备用
    protected String remark3 = "";
    public String getRemark3() {  return SqlTool.getDbString(remark3);  }
    public String getRemark3(int size) { return SqlTool.subString(getRemark3(), size); }
    public void setRemark3(String aRemark3) { remark3 = aRemark3; modifiedFields.add("Remark3"); }
    public void assignRemark3(String aRemark3) { remark3 = aRemark3; }
    public void paramRemark3(HttpServletRequest request) { paramRemark3(request, "Remark3"); }
    public void paramRemark3(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark3()); if (!tmp.equals(getRemark3())) { setRemark3(tmp); } }
    // 备用
    protected String remark4 = "";
    public String getRemark4() {  return SqlTool.getDbString(remark4);  }
    public String getRemark4(int size) { return SqlTool.subString(getRemark4(), size); }
    public void setRemark4(String aRemark4) { remark4 = aRemark4; modifiedFields.add("Remark4"); }
    public void assignRemark4(String aRemark4) { remark4 = aRemark4; }
    public void paramRemark4(HttpServletRequest request) { paramRemark4(request, "Remark4"); }
    public void paramRemark4(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemark4()); if (!tmp.equals(getRemark4())) { setRemark4(tmp); } }
    // 荣誉
    protected String honor = "";
    public String getHonor() {  return SqlTool.getDbString(honor);  }
    public String getHonor(int size) { return SqlTool.subString(getHonor(), size); }
    public void setHonor(String aHonor) { honor = aHonor; modifiedFields.add("Honor"); }
    public void assignHonor(String aHonor) { honor = aHonor; }
    public void paramHonor(HttpServletRequest request) { paramHonor(request, "Honor"); }
    public void paramHonor(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getHonor()); if (!tmp.equals(getHonor())) { setHonor(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public PracticeDeclareTeam (String db) {
        DBNAME = db;
    }
    public PracticeDeclareTeam (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public PracticeDeclareTeam (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public PracticeDeclareTeam () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return PracticeDeclareTeam类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public PracticeDeclareTeam getByParameter(HttpServletRequest request) {
        PracticeDeclareTeam v = new PracticeDeclareTeam(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramPracticeId(request);
        paramTeamName(request);
        paramAcademy(request);
        paramPracticeReportTeamType(request);
        paramReport21(request);
        paramReport22(request);
        paramRemark(request);
        paramRemark2(request);
        paramRemark3(request);
        paramRemark4(request);
        paramHonor(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(PracticeDeclareTeam bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("practiceId")) { setPracticeId(bean.getPracticeId()); }
        if (!ncl.contains("teamName")) { setTeamName(bean.getTeamName()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("practiceReportTeamType")) { setPracticeReportTeamType(bean.getPracticeReportTeamType()); }
        if (!ncl.contains("report21")) { setReport21(bean.getReport21()); }
        if (!ncl.contains("report22")) { setReport22(bean.getReport22()); }
        if (!ncl.contains("remark")) { setRemark(bean.getRemark()); }
        if (!ncl.contains("remark2")) { setRemark2(bean.getRemark2()); }
        if (!ncl.contains("remark3")) { setRemark3(bean.getRemark3()); }
        if (!ncl.contains("remark4")) { setRemark4(bean.getRemark4()); }
        if (!ncl.contains("honor")) { setHonor(bean.getHonor()); }
    }
    public PracticeDeclareTeam getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        PracticeDeclareTeam[] rslt= queryByCondition(cdt);
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
     * @return PracticeDeclareTeam类的实例列表。
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
                PracticeDeclareTeam ve = new PracticeDeclareTeam(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignPracticeId(fromDbCh(rs.getString(2)));
                ve.assignTeamName(fromDbCh(rs.getString(3)));
                ve.assignAcademy(fromDbCh(rs.getString(4)));
                ve.assignPracticeReportTeamType(fromDbCh(rs.getString(5)));
                ve.assignReport21(fromDbCh(rs.getString(6)));
                ve.assignReport22(fromDbCh(rs.getString(7)));
                ve.assignRemark(fromDbCh(rs.getString(8)));
                ve.assignRemark2(fromDbCh(rs.getString(9)));
                ve.assignRemark3(fromDbCh(rs.getString(10)));
                ve.assignRemark4(fromDbCh(rs.getString(11)));
                ve.assignHonor(fromDbCh(rs.getString(12)));
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
    public PracticeDeclareTeam[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (PracticeDeclareTeam[])vrs.toArray(new PracticeDeclareTeam[vrs.size()]);
    }
    public PracticeDeclareTeam[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (PracticeDeclareTeam[])vrs.toArray(new PracticeDeclareTeam[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (practiceid,teamname,academy,practicereportteamtype,report21,report22,remark,remark2,remark3,remark4,honor) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(practiceId));
            pstmt.setString(2, toDbCh(teamName));
            pstmt.setString(3, toDbCh(academy));
            pstmt.setString(4, toDbCh(practiceReportTeamType));
            pstmt.setString(5, toDbCh(report21));
            pstmt.setString(6, toDbCh(report22));
            pstmt.setString(7, toDbCh(remark));
            pstmt.setString(8, toDbCh(remark2));
            pstmt.setString(9, toDbCh(remark3));
            pstmt.setString(10, toDbCh(remark4));
            pstmt.setString(11, toDbCh(honor));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,practiceid,teamname,academy,practicereportteamtype,report21,report22,remark,remark2,remark3,remark4,honor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(practiceId));
            pstmt.setString(3, toDbCh(teamName));
            pstmt.setString(4, toDbCh(academy));
            pstmt.setString(5, toDbCh(practiceReportTeamType));
            pstmt.setString(6, toDbCh(report21));
            pstmt.setString(7, toDbCh(report22));
            pstmt.setString(8, toDbCh(remark));
            pstmt.setString(9, toDbCh(remark2));
            pstmt.setString(10, toDbCh(remark3));
            pstmt.setString(11, toDbCh(remark4));
            pstmt.setString(12, toDbCh(honor));
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
            PracticeDeclareTeam item = (PracticeDeclareTeam)it.next();
            PracticeDeclareTeam v = new PracticeDeclareTeam(dbname);
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
                if (modifiedFields.contains("PracticeId")) { pstmt.setString(pi ++, toDbCh(practiceId)); }
                if (modifiedFields.contains("TeamName")) { pstmt.setString(pi ++, toDbCh(teamName)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("PracticeReportTeamType")) { pstmt.setString(pi ++, toDbCh(practiceReportTeamType)); }
                if (modifiedFields.contains("Report21")) { pstmt.setString(pi ++, toDbCh(report21)); }
                if (modifiedFields.contains("Report22")) { pstmt.setString(pi ++, toDbCh(report22)); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("Remark2")) { pstmt.setString(pi ++, toDbCh(remark2)); }
                if (modifiedFields.contains("Remark3")) { pstmt.setString(pi ++, toDbCh(remark3)); }
                if (modifiedFields.contains("Remark4")) { pstmt.setString(pi ++, toDbCh(remark4)); }
                if (modifiedFields.contains("Honor")) { pstmt.setString(pi ++, toDbCh(honor)); }
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
                if (modifiedFields.contains("PracticeId")) { pstmt.setString(pi ++, toDbCh(practiceId)); }
                if (modifiedFields.contains("TeamName")) { pstmt.setString(pi ++, toDbCh(teamName)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("PracticeReportTeamType")) { pstmt.setString(pi ++, toDbCh(practiceReportTeamType)); }
                if (modifiedFields.contains("Report21")) { pstmt.setString(pi ++, toDbCh(report21)); }
                if (modifiedFields.contains("Report22")) { pstmt.setString(pi ++, toDbCh(report22)); }
                if (modifiedFields.contains("Remark")) { pstmt.setString(pi ++, toDbCh(remark)); }
                if (modifiedFields.contains("Remark2")) { pstmt.setString(pi ++, toDbCh(remark2)); }
                if (modifiedFields.contains("Remark3")) { pstmt.setString(pi ++, toDbCh(remark3)); }
                if (modifiedFields.contains("Remark4")) { pstmt.setString(pi ++, toDbCh(remark4)); }
                if (modifiedFields.contains("Honor")) { pstmt.setString(pi ++, toDbCh(honor)); }
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
        map.put("PracticeId", getPracticeId());
        map.put("TeamName", getTeamName());
        map.put("Academy", getAcademy());
        map.put("PracticeReportTeamType", getPracticeReportTeamType());
        map.put("Report21", getReport21());
        map.put("Report22", getReport22());
        map.put("Remark", getRemark());
        map.put("Remark2", getRemark2());
        map.put("Remark3", getRemark3());
        map.put("Remark4", getRemark4());
        map.put("Honor", getHonor());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("PracticeId:\"" + Tool.jsSpecialChars(getPracticeId()) + "\"");
        row.add("TeamName:\"" + Tool.jsSpecialChars(getTeamName()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("PracticeReportTeamType:\"" + Tool.jsSpecialChars(getPracticeReportTeamType()) + "\"");
        row.add("Report21:\"" + Tool.jsSpecialChars(getReport21()) + "\"");
        row.add("Report22:\"" + Tool.jsSpecialChars(getReport22()) + "\"");
        row.add("Remark:\"" + Tool.jsSpecialChars(getRemark()) + "\"");
        row.add("Remark2:\"" + Tool.jsSpecialChars(getRemark2()) + "\"");
        row.add("Remark3:\"" + Tool.jsSpecialChars(getRemark3()) + "\"");
        row.add("Remark4:\"" + Tool.jsSpecialChars(getRemark4()) + "\"");
        row.add("Honor:\"" + Tool.jsSpecialChars(getHonor()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,practiceid varchar2(45),teamname varchar2(45),academy varchar2(45),practicereportteamtype varchar2(45),report21 varchar2(255),report22 varchar2(255),remark varchar2(45),remark2 varchar2(45),remark3 varchar2(45),remark4 varchar2(45),honor varchar2(45))"});
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
        PracticeDeclareTeam v = new PracticeDeclareTeam(sourceDb, sourceTb);
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
        PracticeDeclareTeam v = new PracticeDeclareTeam(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(PracticeDeclareTeam obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getPracticeId().compareTo(obj.getPracticeId()); if (rtn != 0) return rtn;
        rtn = getTeamName().compareTo(obj.getTeamName()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getPracticeReportTeamType().compareTo(obj.getPracticeReportTeamType()); if (rtn != 0) return rtn;
        rtn = getReport21().compareTo(obj.getReport21()); if (rtn != 0) return rtn;
        rtn = getReport22().compareTo(obj.getReport22()); if (rtn != 0) return rtn;
        rtn = getRemark().compareTo(obj.getRemark()); if (rtn != 0) return rtn;
        rtn = getRemark2().compareTo(obj.getRemark2()); if (rtn != 0) return rtn;
        rtn = getRemark3().compareTo(obj.getRemark3()); if (rtn != 0) return rtn;
        rtn = getRemark4().compareTo(obj.getRemark4()); if (rtn != 0) return rtn;
        rtn = getHonor().compareTo(obj.getHonor()); if (rtn != 0) return rtn;
        return rtn;
    }
}
