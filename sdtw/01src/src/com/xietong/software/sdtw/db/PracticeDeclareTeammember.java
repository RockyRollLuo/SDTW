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
public class PracticeDeclareTeammember implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(PracticeDeclareTeammember.class);
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
    public static final String DbTableName = "practice_declare_teammember";
    private String TNAME = "practice_declare_teammember";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","practiceId","reportId","teamId","sno","sName","sex","academy","grade","idCard","address","phone","email","duty","type2","identity","remark","remark2","remark3","remark4","honor"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","practiceid","reportid","teamid","sno","sname","sex","academy","grade","idcard","address","phone","email","duty","type2","identity","remark","remark2","remark3","remark4","honor"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"PracticeId","practiceid","String"},{"ReportId","reportid","String"},{"TeamId","teamid","int"},{"Sno","sno","String"},{"SName","sname","String"},{"Sex","sex","String"},{"Academy","academy","String"},{"Grade","grade","String"},{"IdCard","idcard","String"},{"Address","address","String"},{"Phone","phone","String"},{"Email","email","String"},{"Duty","duty","String"},{"Type2","type2","int"},{"Identity","identity","String"},{"Remark","remark","String"},{"Remark2","remark2","String"},{"Remark3","remark3","String"},{"Remark4","remark4","String"},{"Honor","honor","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"practiceId","practiceid"},{"reportId","reportid"},{"teamId","teamid"},{"sno","sno"},{"sName","sname"},{"sex","sex"},{"academy","academy"},{"grade","grade"},{"idCard","idcard"},{"address","address"},{"phone","phone"},{"email","email"},{"duty","duty"},{"type2","type2"},{"identity","identity"},{"remark","remark"},{"remark2","remark2"},{"remark3","remark3"},{"remark4","remark4"},{"honor","honor"}};
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
    // 立项表ID
    protected String practiceId = "";
    public String getPracticeId() {  return SqlTool.getDbString(practiceId);  }
    public String getPracticeId(int size) { return SqlTool.subString(getPracticeId(), size); }
    public void setPracticeId(String aPracticeId) { practiceId = aPracticeId; modifiedFields.add("PracticeId"); }
    public void assignPracticeId(String aPracticeId) { practiceId = aPracticeId; }
    public void paramPracticeId(HttpServletRequest request) { paramPracticeId(request, "PracticeId"); }
    public void paramPracticeId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPracticeId()); if (!tmp.equals(getPracticeId())) { setPracticeId(tmp); } }
    // 结题表Id
    protected String reportId = "";
    public String getReportId() {  return SqlTool.getDbString(reportId);  }
    public String getReportId(int size) { return SqlTool.subString(getReportId(), size); }
    public void setReportId(String aReportId) { reportId = aReportId; modifiedFields.add("ReportId"); }
    public void assignReportId(String aReportId) { reportId = aReportId; }
    public void paramReportId(HttpServletRequest request) { paramReportId(request, "ReportId"); }
    public void paramReportId(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReportId()); if (!tmp.equals(getReportId())) { setReportId(tmp); } }
    // 团队id
    protected int teamId = -1;
    public int getTeamId() { return teamId; }
    public void setTeamId(int aTeamId) { teamId = aTeamId; modifiedFields.add("TeamId"); }
    public void assignTeamId(int aTeamId) { teamId = aTeamId; }
    public void paramTeamId(HttpServletRequest request) { paramTeamId(request, "TeamId"); }
    public void paramTeamId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getTeamId()); if (tmp != getTeamId()) { setTeamId(tmp); } }
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
    protected int type2 = -1;
    public int getType2() { return type2; }
    public void setType2(int aType2) { type2 = aType2; modifiedFields.add("Type2"); }
    public void assignType2(int aType2) { type2 = aType2; }
    public void paramType2(HttpServletRequest request) { paramType2(request, "Type2"); }
    public void paramType2(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getType2()); if (tmp != getType2()) { setType2(tmp); } }
    // 学历
    protected String identity = "";
    public String getIdentity() {  return SqlTool.getDbString(identity);  }
    public String getIdentity(int size) { return SqlTool.subString(getIdentity(), size); }
    public void setIdentity(String aIdentity) { identity = aIdentity; modifiedFields.add("Identity"); }
    public void assignIdentity(String aIdentity) { identity = aIdentity; }
    public void paramIdentity(HttpServletRequest request) { paramIdentity(request, "Identity"); }
    public void paramIdentity(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getIdentity()); if (!tmp.equals(getIdentity())) { setIdentity(tmp); } }
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
    public PracticeDeclareTeammember (String db) {
        DBNAME = db;
    }
    public PracticeDeclareTeammember (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public PracticeDeclareTeammember (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public PracticeDeclareTeammember () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return PracticeDeclareTeammember类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public PracticeDeclareTeammember getByParameter(HttpServletRequest request) {
        PracticeDeclareTeammember v = new PracticeDeclareTeammember(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramPracticeId(request);
        paramReportId(request);
        paramTeamId(request);
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
        paramType2(request);
        paramIdentity(request);
        paramRemark(request);
        paramRemark2(request);
        paramRemark3(request);
        paramRemark4(request);
        paramHonor(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(PracticeDeclareTeammember bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("practiceId")) { setPracticeId(bean.getPracticeId()); }
        if (!ncl.contains("reportId")) { setReportId(bean.getReportId()); }
        if (!ncl.contains("teamId")) { setTeamId(bean.getTeamId()); }
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
        if (!ncl.contains("type2")) { setType2(bean.getType2()); }
        if (!ncl.contains("identity")) { setIdentity(bean.getIdentity()); }
        if (!ncl.contains("remark")) { setRemark(bean.getRemark()); }
        if (!ncl.contains("remark2")) { setRemark2(bean.getRemark2()); }
        if (!ncl.contains("remark3")) { setRemark3(bean.getRemark3()); }
        if (!ncl.contains("remark4")) { setRemark4(bean.getRemark4()); }
        if (!ncl.contains("honor")) { setHonor(bean.getHonor()); }
    }
    public PracticeDeclareTeammember getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        PracticeDeclareTeammember[] rslt= queryByCondition(cdt);
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
     * @return PracticeDeclareTeammember类的实例列表。
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
                PracticeDeclareTeammember ve = new PracticeDeclareTeammember(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignPracticeId(fromDbCh(rs.getString(2)));
                ve.assignReportId(fromDbCh(rs.getString(3)));
                ve.assignTeamId(rs.getInt(4));
                ve.assignSno(fromDbCh(rs.getString(5)));
                ve.assignSName(fromDbCh(rs.getString(6)));
                ve.assignSex(fromDbCh(rs.getString(7)));
                ve.assignAcademy(fromDbCh(rs.getString(8)));
                ve.assignGrade(fromDbCh(rs.getString(9)));
                ve.assignIdCard(fromDbCh(rs.getString(10)));
                ve.assignAddress(fromDbCh(rs.getString(11)));
                ve.assignPhone(fromDbCh(rs.getString(12)));
                ve.assignEmail(fromDbCh(rs.getString(13)));
                ve.assignDuty(fromDbCh(rs.getString(14)));
                ve.assignType2(rs.getInt(15));
                ve.assignIdentity(fromDbCh(rs.getString(16)));
                ve.assignRemark(fromDbCh(rs.getString(17)));
                ve.assignRemark2(fromDbCh(rs.getString(18)));
                ve.assignRemark3(fromDbCh(rs.getString(19)));
                ve.assignRemark4(fromDbCh(rs.getString(20)));
                ve.assignHonor(fromDbCh(rs.getString(21)));
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
    public PracticeDeclareTeammember[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (PracticeDeclareTeammember[])vrs.toArray(new PracticeDeclareTeammember[vrs.size()]);
    }
    public PracticeDeclareTeammember[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (PracticeDeclareTeammember[])vrs.toArray(new PracticeDeclareTeammember[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (practiceid,reportid,teamid,sno,sname,sex,academy,grade,idcard,address,phone,email,duty,type2,identity,remark,remark2,remark3,remark4,honor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(practiceId));
            pstmt.setString(2, toDbCh(reportId));
            pstmt.setInt(3, teamId);
            pstmt.setString(4, toDbCh(sno));
            pstmt.setString(5, toDbCh(sName));
            pstmt.setString(6, toDbCh(sex));
            pstmt.setString(7, toDbCh(academy));
            pstmt.setString(8, toDbCh(grade));
            pstmt.setString(9, toDbCh(idCard));
            pstmt.setString(10, toDbCh(address));
            pstmt.setString(11, toDbCh(phone));
            pstmt.setString(12, toDbCh(email));
            pstmt.setString(13, toDbCh(duty));
            pstmt.setInt(14, type2);
            pstmt.setString(15, toDbCh(identity));
            pstmt.setString(16, toDbCh(remark));
            pstmt.setString(17, toDbCh(remark2));
            pstmt.setString(18, toDbCh(remark3));
            pstmt.setString(19, toDbCh(remark4));
            pstmt.setString(20, toDbCh(honor));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,practiceid,reportid,teamid,sno,sname,sex,academy,grade,idcard,address,phone,email,duty,type2,identity,remark,remark2,remark3,remark4,honor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(practiceId));
            pstmt.setString(3, toDbCh(reportId));
            pstmt.setInt(4, teamId);
            pstmt.setString(5, toDbCh(sno));
            pstmt.setString(6, toDbCh(sName));
            pstmt.setString(7, toDbCh(sex));
            pstmt.setString(8, toDbCh(academy));
            pstmt.setString(9, toDbCh(grade));
            pstmt.setString(10, toDbCh(idCard));
            pstmt.setString(11, toDbCh(address));
            pstmt.setString(12, toDbCh(phone));
            pstmt.setString(13, toDbCh(email));
            pstmt.setString(14, toDbCh(duty));
            pstmt.setInt(15, type2);
            pstmt.setString(16, toDbCh(identity));
            pstmt.setString(17, toDbCh(remark));
            pstmt.setString(18, toDbCh(remark2));
            pstmt.setString(19, toDbCh(remark3));
            pstmt.setString(20, toDbCh(remark4));
            pstmt.setString(21, toDbCh(honor));
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
            PracticeDeclareTeammember item = (PracticeDeclareTeammember)it.next();
            PracticeDeclareTeammember v = new PracticeDeclareTeammember(dbname);
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
                if (modifiedFields.contains("ReportId")) { pstmt.setString(pi ++, toDbCh(reportId)); }
                if (modifiedFields.contains("TeamId")) { pstmt.setInt(pi ++, teamId); }
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
                if (modifiedFields.contains("Type2")) { pstmt.setInt(pi ++, type2); }
                if (modifiedFields.contains("Identity")) { pstmt.setString(pi ++, toDbCh(identity)); }
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
                if (modifiedFields.contains("ReportId")) { pstmt.setString(pi ++, toDbCh(reportId)); }
                if (modifiedFields.contains("TeamId")) { pstmt.setInt(pi ++, teamId); }
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
                if (modifiedFields.contains("Type2")) { pstmt.setInt(pi ++, type2); }
                if (modifiedFields.contains("Identity")) { pstmt.setString(pi ++, toDbCh(identity)); }
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
        map.put("ReportId", getReportId());
        map.put("TeamId", getTeamId() + "");
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
        map.put("Type2", getType2() + "");
        map.put("Identity", getIdentity());
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
        row.add("ReportId:\"" + Tool.jsSpecialChars(getReportId()) + "\"");
        row.add("TeamId:\"" + getTeamId() + "\"");
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
        row.add("Type2:\"" + getType2() + "\"");
        row.add("Identity:\"" + Tool.jsSpecialChars(getIdentity()) + "\"");
        row.add("Remark:\"" + Tool.jsSpecialChars(getRemark()) + "\"");
        row.add("Remark2:\"" + Tool.jsSpecialChars(getRemark2()) + "\"");
        row.add("Remark3:\"" + Tool.jsSpecialChars(getRemark3()) + "\"");
        row.add("Remark4:\"" + Tool.jsSpecialChars(getRemark4()) + "\"");
        row.add("Honor:\"" + Tool.jsSpecialChars(getHonor()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,practiceid varchar2(45),reportid varchar2(45),teamid number(*,0),sno varchar2(45),sname varchar2(45),sex varchar2(45),academy varchar2(45),grade varchar2(45),idcard varchar2(45),address varchar2(45),phone varchar2(45),email varchar2(45),duty varchar2(45),type2 number(*,0),identity varchar2(45),remark varchar2(45),remark2 varchar2(45),remark3 varchar2(45),remark4 varchar2(45),honor varchar2(45))"});
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
        PracticeDeclareTeammember v = new PracticeDeclareTeammember(sourceDb, sourceTb);
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
        PracticeDeclareTeammember v = new PracticeDeclareTeammember(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(PracticeDeclareTeammember obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getPracticeId().compareTo(obj.getPracticeId()); if (rtn != 0) return rtn;
        rtn = getReportId().compareTo(obj.getReportId()); if (rtn != 0) return rtn;
        rtn = ("" + getTeamId()).compareTo("" + obj.getTeamId()); if (rtn != 0) return rtn;
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
        rtn = ("" + getType2()).compareTo("" + obj.getType2()); if (rtn != 0) return rtn;
        rtn = getIdentity().compareTo(obj.getIdentity()); if (rtn != 0) return rtn;
        rtn = getRemark().compareTo(obj.getRemark()); if (rtn != 0) return rtn;
        rtn = getRemark2().compareTo(obj.getRemark2()); if (rtn != 0) return rtn;
        rtn = getRemark3().compareTo(obj.getRemark3()); if (rtn != 0) return rtn;
        rtn = getRemark4().compareTo(obj.getRemark4()); if (rtn != 0) return rtn;
        rtn = getHonor().compareTo(obj.getHonor()); if (rtn != 0) return rtn;
        return rtn;
    }
}
