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
@Description("参加社会实践团成员表")
public class Practice_Declare_Teammember implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(Practice_Declare_Teammember.class);
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
    private String DBNAME = "practicedeclareteammember";
    public void setDataBase(String val) { DBNAME = val; }
    public String getDataBase() { return DBNAME; }
    public String getDBNAME() { if (DBNAME.length() > 0) return DBNAME + "." + TNAME; else return TNAME; }
    public static final String _DbType = "mysql";
    public String getDbType() { return _DbType; }
    // 保存当前连接的数据表名
    public static final String DbTableName = "practice_declare_teammember";
    private String TNAME = "practice_declare_teammember";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","practiceId","sno","sName","sex","academy","grade","idCard","address","phone","email","duty","type","teacherType","workPlace"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","practiceid","sno","sname","sex","academy","grade","idcard","address","phone","email","duty","type","teachertype","workplace"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"PracticeId","practiceid","String"},{"Sno","sno","String"},{"SName","sname","String"},{"Sex","sex","String"},{"Academy","academy","String"},{"Grade","grade","String"},{"IdCard","idcard","String"},{"Address","address","String"},{"Phone","phone","String"},{"Email","email","String"},{"Duty","duty","String"},{"Type","type","int"},{"TeacherType","teachertype","int"},{"WorkPlace","workplace","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"practiceId","practiceid"},{"sno","sno"},{"sName","sname"},{"sex","sex"},{"academy","academy"},{"grade","grade"},{"idCard","idcard"},{"address","address"},{"phone","phone"},{"email","email"},{"duty","duty"},{"type","type"},{"teacherType","teachertype"},{"workPlace","workplace"}};
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
    // 所参加的实践项目ID
    protected String practiceId = "";
    public String getPracticeId() {  return SqlTool.getDbString(practiceId);  }
    public String getPracticeId(int size) { return SqlTool.subString(getPracticeId(), size); }
    public void setPracticeId(String aPracticeId) { practiceId = aPracticeId; modifiedFields.add("PracticeId"); }
    public void assignPracticeId(String aPracticeId) { practiceId = aPracticeId; }
    public void paramPracticeId(HttpServletRequest request) { paramPracticeId(request, "PracticeId"); }
    public void paramPracticeId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPracticeId()); if (!tmp.equals(getPracticeId())) { setPracticeId(tmp); } }
    // 学号
    protected String sno = "";
    public String getSno() {  return SqlTool.getDbString(sno);  }
    public String getSno(int size) { return SqlTool.subString(getSno(), size); }
    public void setSno(String aSno) { sno = aSno; modifiedFields.add("Sno"); }
    public void assignSno(String aSno) { sno = aSno; }
    public void paramSno(HttpServletRequest request) { paramSno(request, "Sno"); }
    public void paramSno(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSno()); if (!tmp.equals(getSno())) { setSno(tmp); } }
    // 姓名
    protected String sName = "";
    public String getSName() {  return SqlTool.getDbString(sName);  }
    public String getSName(int size) { return SqlTool.subString(getSName(), size); }
    public void setSName(String aSName) { sName = aSName; modifiedFields.add("SName"); }
    public void assignSName(String aSName) { sName = aSName; }
    public void paramSName(HttpServletRequest request) { paramSName(request, "SName"); }
    public void paramSName(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSName()); if (!tmp.equals(getSName())) { setSName(tmp); } }
    // 性别
    protected String sex = "";
    public String getSex() {  return SqlTool.getDbString(sex);  }
    public String getSex(int size) { return SqlTool.subString(getSex(), size); }
    public void setSex(String aSex) { sex = aSex; modifiedFields.add("Sex"); }
    public void assignSex(String aSex) { sex = aSex; }
    public void paramSex(HttpServletRequest request) { paramSex(request, "Sex"); }
    public void paramSex(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSex()); if (!tmp.equals(getSex())) { setSex(tmp); } }
    // 院系
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 年级
    protected String grade = "";
    public String getGrade() {  return SqlTool.getDbString(grade);  }
    public String getGrade(int size) { return SqlTool.subString(getGrade(), size); }
    public void setGrade(String aGrade) { grade = aGrade; modifiedFields.add("Grade"); }
    public void assignGrade(String aGrade) { grade = aGrade; }
    public void paramGrade(HttpServletRequest request) { paramGrade(request, "Grade"); }
    public void paramGrade(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGrade()); if (!tmp.equals(getGrade())) { setGrade(tmp); } }
    // 身份证
    protected String idCard = "";
    public String getIdCard() {  return SqlTool.getDbString(idCard);  }
    public String getIdCard(int size) { return SqlTool.subString(getIdCard(), size); }
    public void setIdCard(String aIdCard) { idCard = aIdCard; modifiedFields.add("IdCard"); }
    public void assignIdCard(String aIdCard) { idCard = aIdCard; }
    public void paramIdCard(HttpServletRequest request) { paramIdCard(request, "IdCard"); }
    public void paramIdCard(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIdCard()); if (!tmp.equals(getIdCard())) { setIdCard(tmp); } }
    // 家庭住址
    protected String address = "";
    public String getAddress() {  return SqlTool.getDbString(address);  }
    public String getAddress(int size) { return SqlTool.subString(getAddress(), size); }
    public void setAddress(String aAddress) { address = aAddress; modifiedFields.add("Address"); }
    public void assignAddress(String aAddress) { address = aAddress; }
    public void paramAddress(HttpServletRequest request) { paramAddress(request, "Address"); }
    public void paramAddress(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddress()); if (!tmp.equals(getAddress())) { setAddress(tmp); } }
    // 联系方式
    protected String phone = "";
    public String getPhone() {  return SqlTool.getDbString(phone);  }
    public String getPhone(int size) { return SqlTool.subString(getPhone(), size); }
    public void setPhone(String aPhone) { phone = aPhone; modifiedFields.add("Phone"); }
    public void assignPhone(String aPhone) { phone = aPhone; }
    public void paramPhone(HttpServletRequest request) { paramPhone(request, "Phone"); }
    public void paramPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPhone()); if (!tmp.equals(getPhone())) { setPhone(tmp); } }
    // 邮箱
    protected String email = "";
    public String getEmail() {  return SqlTool.getDbString(email);  }
    public String getEmail(int size) { return SqlTool.subString(getEmail(), size); }
    public void setEmail(String aEmail) { email = aEmail; modifiedFields.add("Email"); }
    public void assignEmail(String aEmail) { email = aEmail; }
    public void paramEmail(HttpServletRequest request) { paramEmail(request, "Email"); }
    public void paramEmail(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getEmail()); if (!tmp.equals(getEmail())) { setEmail(tmp); } }
    // 承担工作
    protected String duty = "";
    public String getDuty() {  return SqlTool.getDbString(duty);  }
    public String getDuty(int size) { return SqlTool.subString(getDuty(), size); }
    public void setDuty(String aDuty) { duty = aDuty; modifiedFields.add("Duty"); }
    public void assignDuty(String aDuty) { duty = aDuty; }
    public void paramDuty(HttpServletRequest request) { paramDuty(request, "Duty"); }
    public void paramDuty(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDuty()); if (!tmp.equals(getDuty())) { setDuty(tmp); } }
    // 类别
    protected int type = -1;
    public int getType() { return type; }
    public void setType(int aType) { type = aType; modifiedFields.add("Type"); }
    public void assignType(int aType) { type = aType; }
    public void paramType(HttpServletRequest request) { paramType(request, "Type"); }
    public void paramType(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getType()); if (tmp != getType()) { setType(tmp); } }
    // 领队类别
    protected int teacherType = -1;
    public int getTeacherType() { return teacherType; }
    public void setTeacherType(int aTeacherType) { teacherType = aTeacherType; modifiedFields.add("TeacherType"); }
    public void assignTeacherType(int aTeacherType) { teacherType = aTeacherType; }
    public void paramTeacherType(HttpServletRequest request) { paramTeacherType(request, "TeacherType"); }
    public void paramTeacherType(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getTeacherType()); if (tmp != getTeacherType()) { setTeacherType(tmp); } }
    // 工作单位
    protected String workPlace = "";
    public String getWorkPlace() {  return SqlTool.getDbString(workPlace);  }
    public String getWorkPlace(int size) { return SqlTool.subString(getWorkPlace(), size); }
    public void setWorkPlace(String aWorkPlace) { workPlace = aWorkPlace; modifiedFields.add("WorkPlace"); }
    public void assignWorkPlace(String aWorkPlace) { workPlace = aWorkPlace; }
    public void paramWorkPlace(HttpServletRequest request) { paramWorkPlace(request, "WorkPlace"); }
    public void paramWorkPlace(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getWorkPlace()); if (!tmp.equals(getWorkPlace())) { setWorkPlace(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public Practice_Declare_Teammember (String db) {
        DBNAME = db;
    }
    public Practice_Declare_Teammember (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public Practice_Declare_Teammember (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public Practice_Declare_Teammember () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return Practice_Declare_Teammember类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public Practice_Declare_Teammember getByParameter(HttpServletRequest request) {
        Practice_Declare_Teammember v = new Practice_Declare_Teammember(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramPracticeId(request);
        paramSno(request);
        paramSName(request);
        paramSex(request);
        paramAcademy(request);
        paramGrade(request);
        paramIdCard(request);
        paramAddress(request);
        paramPhone(request);
        paramEmail(request);
        paramDuty(request);
        paramType(request);
        paramTeacherType(request);
        paramWorkPlace(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(Practice_Declare_Teammember bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("practiceId")) { setPracticeId(bean.getPracticeId()); }
        if (!ncl.contains("sno")) { setSno(bean.getSno()); }
        if (!ncl.contains("sName")) { setSName(bean.getSName()); }
        if (!ncl.contains("sex")) { setSex(bean.getSex()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("grade")) { setGrade(bean.getGrade()); }
        if (!ncl.contains("idCard")) { setIdCard(bean.getIdCard()); }
        if (!ncl.contains("address")) { setAddress(bean.getAddress()); }
        if (!ncl.contains("phone")) { setPhone(bean.getPhone()); }
        if (!ncl.contains("email")) { setEmail(bean.getEmail()); }
        if (!ncl.contains("duty")) { setDuty(bean.getDuty()); }
        if (!ncl.contains("type")) { setType(bean.getType()); }
        if (!ncl.contains("teacherType")) { setTeacherType(bean.getTeacherType()); }
        if (!ncl.contains("workPlace")) { setWorkPlace(bean.getWorkPlace()); }
    }
    public Practice_Declare_Teammember getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        Practice_Declare_Teammember[] rslt= queryByCondition(cdt);
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
     * @return Practice_Declare_Teammember类的实例列表。
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
                Practice_Declare_Teammember ve = new Practice_Declare_Teammember(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignPracticeId(fromDbCh(rs.getString(2)));
                ve.assignSno(fromDbCh(rs.getString(3)));
                ve.assignSName(fromDbCh(rs.getString(4)));
                ve.assignSex(fromDbCh(rs.getString(5)));
                ve.assignAcademy(fromDbCh(rs.getString(6)));
                ve.assignGrade(fromDbCh(rs.getString(7)));
                ve.assignIdCard(fromDbCh(rs.getString(8)));
                ve.assignAddress(fromDbCh(rs.getString(9)));
                ve.assignPhone(fromDbCh(rs.getString(10)));
                ve.assignEmail(fromDbCh(rs.getString(11)));
                ve.assignDuty(fromDbCh(rs.getString(12)));
                ve.assignType(rs.getInt(13));
                ve.assignTeacherType(rs.getInt(14));
                ve.assignWorkPlace(fromDbCh(rs.getString(15)));
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
    public Practice_Declare_Teammember[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (Practice_Declare_Teammember[])vrs.toArray(new Practice_Declare_Teammember[vrs.size()]);
    }
    public Practice_Declare_Teammember[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (Practice_Declare_Teammember[])vrs.toArray(new Practice_Declare_Teammember[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (practiceid,sno,sname,sex,academy,grade,idcard,address,phone,email,duty,type,teachertype,workplace) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(practiceId));
            pstmt.setString(2, toDbCh(sno));
            pstmt.setString(3, toDbCh(sName));
            pstmt.setString(4, toDbCh(sex));
            pstmt.setString(5, toDbCh(academy));
            pstmt.setString(6, toDbCh(grade));
            pstmt.setString(7, toDbCh(idCard));
            pstmt.setString(8, toDbCh(address));
            pstmt.setString(9, toDbCh(phone));
            pstmt.setString(10, toDbCh(email));
            pstmt.setString(11, toDbCh(duty));
            pstmt.setInt(12, type);
            pstmt.setInt(13, teacherType);
            pstmt.setString(14, toDbCh(workPlace));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,practiceid,sno,sname,sex,academy,grade,idcard,address,phone,email,duty,type,teachertype,workplace) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(practiceId));
            pstmt.setString(3, toDbCh(sno));
            pstmt.setString(4, toDbCh(sName));
            pstmt.setString(5, toDbCh(sex));
            pstmt.setString(6, toDbCh(academy));
            pstmt.setString(7, toDbCh(grade));
            pstmt.setString(8, toDbCh(idCard));
            pstmt.setString(9, toDbCh(address));
            pstmt.setString(10, toDbCh(phone));
            pstmt.setString(11, toDbCh(email));
            pstmt.setString(12, toDbCh(duty));
            pstmt.setInt(13, type);
            pstmt.setInt(14, teacherType);
            pstmt.setString(15, toDbCh(workPlace));
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
            Practice_Declare_Teammember item = (Practice_Declare_Teammember)it.next();
            Practice_Declare_Teammember v = new Practice_Declare_Teammember(dbname);
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
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("SName")) { pstmt.setString(pi ++, toDbCh(sName)); }
                if (modifiedFields.contains("Sex")) { pstmt.setString(pi ++, toDbCh(sex)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Grade")) { pstmt.setString(pi ++, toDbCh(grade)); }
                if (modifiedFields.contains("IdCard")) { pstmt.setString(pi ++, toDbCh(idCard)); }
                if (modifiedFields.contains("Address")) { pstmt.setString(pi ++, toDbCh(address)); }
                if (modifiedFields.contains("Phone")) { pstmt.setString(pi ++, toDbCh(phone)); }
                if (modifiedFields.contains("Email")) { pstmt.setString(pi ++, toDbCh(email)); }
                if (modifiedFields.contains("Duty")) { pstmt.setString(pi ++, toDbCh(duty)); }
                if (modifiedFields.contains("Type")) { pstmt.setInt(pi ++, type); }
                if (modifiedFields.contains("TeacherType")) { pstmt.setInt(pi ++, teacherType); }
                if (modifiedFields.contains("WorkPlace")) { pstmt.setString(pi ++, toDbCh(workPlace)); }
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
                if (modifiedFields.contains("Sno")) { pstmt.setString(pi ++, toDbCh(sno)); }
                if (modifiedFields.contains("SName")) { pstmt.setString(pi ++, toDbCh(sName)); }
                if (modifiedFields.contains("Sex")) { pstmt.setString(pi ++, toDbCh(sex)); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("Grade")) { pstmt.setString(pi ++, toDbCh(grade)); }
                if (modifiedFields.contains("IdCard")) { pstmt.setString(pi ++, toDbCh(idCard)); }
                if (modifiedFields.contains("Address")) { pstmt.setString(pi ++, toDbCh(address)); }
                if (modifiedFields.contains("Phone")) { pstmt.setString(pi ++, toDbCh(phone)); }
                if (modifiedFields.contains("Email")) { pstmt.setString(pi ++, toDbCh(email)); }
                if (modifiedFields.contains("Duty")) { pstmt.setString(pi ++, toDbCh(duty)); }
                if (modifiedFields.contains("Type")) { pstmt.setInt(pi ++, type); }
                if (modifiedFields.contains("TeacherType")) { pstmt.setInt(pi ++, teacherType); }
                if (modifiedFields.contains("WorkPlace")) { pstmt.setString(pi ++, toDbCh(workPlace)); }
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
        map.put("Sno", getSno());
        map.put("SName", getSName());
        map.put("Sex", getSex());
        map.put("Academy", getAcademy());
        map.put("Grade", getGrade());
        map.put("IdCard", getIdCard());
        map.put("Address", getAddress());
        map.put("Phone", getPhone());
        map.put("Email", getEmail());
        map.put("Duty", getDuty());
        map.put("Type", getType() + "");
        map.put("TeacherType", getTeacherType() + "");
        map.put("WorkPlace", getWorkPlace());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("PracticeId:\"" + Tool.jsSpecialChars(getPracticeId()) + "\"");
        row.add("Sno:\"" + Tool.jsSpecialChars(getSno()) + "\"");
        row.add("SName:\"" + Tool.jsSpecialChars(getSName()) + "\"");
        row.add("Sex:\"" + Tool.jsSpecialChars(getSex()) + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("Grade:\"" + Tool.jsSpecialChars(getGrade()) + "\"");
        row.add("IdCard:\"" + Tool.jsSpecialChars(getIdCard()) + "\"");
        row.add("Address:\"" + Tool.jsSpecialChars(getAddress()) + "\"");
        row.add("Phone:\"" + Tool.jsSpecialChars(getPhone()) + "\"");
        row.add("Email:\"" + Tool.jsSpecialChars(getEmail()) + "\"");
        row.add("Duty:\"" + Tool.jsSpecialChars(getDuty()) + "\"");
        row.add("Type:\"" + getType() + "\"");
        row.add("TeacherType:\"" + getTeacherType() + "\"");
        row.add("WorkPlace:\"" + Tool.jsSpecialChars(getWorkPlace()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,practiceid varchar2(45),sno varchar2(45),sname varchar2(45),sex varchar2(45),academy varchar2(45),grade varchar2(45),idcard varchar2(45),address varchar2(45),phone varchar2(45),email varchar2(45),duty varchar2(45),type number(*,0),teachertype number(*,0),workplace varchar2(45))"});
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
        Practice_Declare_Teammember v = new Practice_Declare_Teammember(sourceDb, sourceTb);
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
        Practice_Declare_Teammember v = new Practice_Declare_Teammember(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(Practice_Declare_Teammember obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getPracticeId().compareTo(obj.getPracticeId()); if (rtn != 0) return rtn;
        rtn = getSno().compareTo(obj.getSno()); if (rtn != 0) return rtn;
        rtn = getSName().compareTo(obj.getSName()); if (rtn != 0) return rtn;
        rtn = getSex().compareTo(obj.getSex()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getGrade().compareTo(obj.getGrade()); if (rtn != 0) return rtn;
        rtn = getIdCard().compareTo(obj.getIdCard()); if (rtn != 0) return rtn;
        rtn = getAddress().compareTo(obj.getAddress()); if (rtn != 0) return rtn;
        rtn = getPhone().compareTo(obj.getPhone()); if (rtn != 0) return rtn;
        rtn = getEmail().compareTo(obj.getEmail()); if (rtn != 0) return rtn;
        rtn = getDuty().compareTo(obj.getDuty()); if (rtn != 0) return rtn;
        rtn = ("" + getType()).compareTo("" + obj.getType()); if (rtn != 0) return rtn;
        rtn = ("" + getTeacherType()).compareTo("" + obj.getTeacherType()); if (rtn != 0) return rtn;
        rtn = getWorkPlace().compareTo(obj.getWorkPlace()); if (rtn != 0) return rtn;
        return rtn;
    }
}
