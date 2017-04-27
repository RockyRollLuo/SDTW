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
@Description("站内信")
public class ShortMessage implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(ShortMessage.class);
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
    public static final String DbTableName = "shortmessage";
    private String TNAME = "shortmessage";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","sendDate","subject","msgGrade","sendId","receiveIds","ifSee","receipt","collectDate","saveDate","smsStyle","attachIds","remUrl","remindSys","isEnable","remindType"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","senddate","subject","msggrade","sendid","receiveids","ifsee","receipt","collectdate","savedate","smsstyle","attachids","remurl","remindsys","isenable","remindtype"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"SendDate","senddate","java.util.Date"},{"Subject","subject","String"},{"MsgGrade","msggrade","int"},{"SendId","sendid","int"},{"ReceiveIds","receiveids","String"},{"IfSee","ifsee","int"},{"Receipt","receipt","int"},{"CollectDate","collectdate","java.util.Date"},{"SaveDate","savedate","java.util.Date"},{"SmsStyle","smsstyle","int"},{"AttachIds","attachids","String"},{"RemUrl","remurl","String"},{"RemindSys","remindsys","String"},{"IsEnable","isenable","int"},{"RemindType","remindtype","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"sendDate","senddate"},{"subject","subject"},{"msgGrade","msggrade"},{"sendId","sendid"},{"receiveIds","receiveids"},{"ifSee","ifsee"},{"receipt","receipt"},{"collectDate","collectdate"},{"saveDate","savedate"},{"smsStyle","smsstyle"},{"attachIds","attachids"},{"remUrl","remurl"},{"remindSys","remindsys"},{"isEnable","isenable"},{"remindType","remindtype"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"SENDDATE","COLLECTDATE","SAVEDATE"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 短消息发送时间
    protected java.util.Date sendDate = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getSendDate() { return sendDate; }
    public void setSendDate(java.util.Date aSendDate) { sendDate = aSendDate; modifiedFields.add("SendDate"); }
    public void assignSendDate(java.util.Date aSendDate) { sendDate = aSendDate; }
    public void paramSendDate(HttpServletRequest request) { paramSendDate(request, "SendDate"); }
    public void paramSendDate(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getSendDate()); if (tmp.compareTo(getSendDate()) != 0) { setSendDate(tmp); } }
    // 短消息标题
    protected String subject = "";
    public String getSubject() {  return SqlTool.getDbString(subject);  }
    public String getSubject(int size) { return SqlTool.subString(getSubject(), size); }
    public void setSubject(String aSubject) { subject = aSubject; modifiedFields.add("Subject"); }
    public void assignSubject(String aSubject) { subject = aSubject; }
    public void paramSubject(HttpServletRequest request) { paramSubject(request, "Subject"); }
    public void paramSubject(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSubject()); if (!tmp.equals(getSubject())) { setSubject(tmp); } }
    // 短消息级别
    protected int msgGrade = -1;
    public int getMsgGrade() { return msgGrade; }
    public void setMsgGrade(int aMsgGrade) { msgGrade = aMsgGrade; modifiedFields.add("MsgGrade"); }
    public void assignMsgGrade(int aMsgGrade) { msgGrade = aMsgGrade; }
    public void paramMsgGrade(HttpServletRequest request) { paramMsgGrade(request, "MsgGrade"); }
    public void paramMsgGrade(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getMsgGrade()); if (tmp != getMsgGrade()) { setMsgGrade(tmp); } }
    // 发送人
    protected int sendId = -1;
    public int getSendId() { return sendId; }
    public void setSendId(int aSendId) { sendId = aSendId; modifiedFields.add("SendId"); }
    public void assignSendId(int aSendId) { sendId = aSendId; }
    public void paramSendId(HttpServletRequest request) { paramSendId(request, "SendId"); }
    public void paramSendId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getSendId()); if (tmp != getSendId()) { setSendId(tmp); } }
    // 接受人
    protected String receiveIds = "";
    public String getReceiveIds() {  return SqlTool.getDbString(receiveIds);  }
    public String getReceiveIds(int size) { return SqlTool.subString(getReceiveIds(), size); }
    public void setReceiveIds(String aReceiveIds) { receiveIds = aReceiveIds; modifiedFields.add("ReceiveIds"); }
    public void assignReceiveIds(String aReceiveIds) { receiveIds = aReceiveIds; }
    public void paramReceiveIds(HttpServletRequest request) { paramReceiveIds(request, "ReceiveIds"); }
    public void paramReceiveIds(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getReceiveIds()); if (!tmp.equals(getReceiveIds())) { setReceiveIds(tmp); } }
    // 是否查看
    protected int ifSee = -1;
    public int getIfSee() { return ifSee; }
    public void setIfSee(int aIfSee) { ifSee = aIfSee; modifiedFields.add("IfSee"); }
    public void assignIfSee(int aIfSee) { ifSee = aIfSee; }
    public void paramIfSee(HttpServletRequest request) { paramIfSee(request, "IfSee"); }
    public void paramIfSee(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getIfSee()); if (tmp != getIfSee()) { setIfSee(tmp); } }
    // 是否回执
    protected int receipt = -1;
    public int getReceipt() { return receipt; }
    public void setReceipt(int aReceipt) { receipt = aReceipt; modifiedFields.add("Receipt"); }
    public void assignReceipt(int aReceipt) { receipt = aReceipt; }
    public void paramReceipt(HttpServletRequest request) { paramReceipt(request, "Receipt"); }
    public void paramReceipt(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getReceipt()); if (tmp != getReceipt()) { setReceipt(tmp); } }
    // 短消息收藏时间
    protected java.util.Date collectDate = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getCollectDate() { return collectDate; }
    public void setCollectDate(java.util.Date aCollectDate) { collectDate = aCollectDate; modifiedFields.add("CollectDate"); }
    public void assignCollectDate(java.util.Date aCollectDate) { collectDate = aCollectDate; }
    public void paramCollectDate(HttpServletRequest request) { paramCollectDate(request, "CollectDate"); }
    public void paramCollectDate(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getCollectDate()); if (tmp.compareTo(getCollectDate()) != 0) { setCollectDate(tmp); } }
    // 短消息保存时间
    protected java.util.Date saveDate = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getSaveDate() { return saveDate; }
    public void setSaveDate(java.util.Date aSaveDate) { saveDate = aSaveDate; modifiedFields.add("SaveDate"); }
    public void assignSaveDate(java.util.Date aSaveDate) { saveDate = aSaveDate; }
    public void paramSaveDate(HttpServletRequest request) { paramSaveDate(request, "SaveDate"); }
    public void paramSaveDate(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getSaveDate()); if (tmp.compareTo(getSaveDate()) != 0) { setSaveDate(tmp); } }
    // 短消息级别
    protected int smsStyle = -1;
    public int getSmsStyle() { return smsStyle; }
    public void setSmsStyle(int aSmsStyle) { smsStyle = aSmsStyle; modifiedFields.add("SmsStyle"); }
    public void assignSmsStyle(int aSmsStyle) { smsStyle = aSmsStyle; }
    public void paramSmsStyle(HttpServletRequest request) { paramSmsStyle(request, "SmsStyle"); }
    public void paramSmsStyle(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getSmsStyle()); if (tmp != getSmsStyle()) { setSmsStyle(tmp); } }
    // 相关附件ids
    protected String attachIds = "";
    public String getAttachIds() {  return SqlTool.getDbString(attachIds);  }
    public String getAttachIds(int size) { return SqlTool.subString(getAttachIds(), size); }
    public void setAttachIds(String aAttachIds) { attachIds = aAttachIds; modifiedFields.add("AttachIds"); }
    public void assignAttachIds(String aAttachIds) { attachIds = aAttachIds; }
    public void paramAttachIds(HttpServletRequest request) { paramAttachIds(request, "AttachIds"); }
    public void paramAttachIds(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAttachIds()); if (!tmp.equals(getAttachIds())) { setAttachIds(tmp); } }
    // 跳转地址
    protected String remUrl = "";
    public String getRemUrl() {  return SqlTool.getDbString(remUrl);  }
    public String getRemUrl(int size) { return SqlTool.subString(getRemUrl(), size); }
    public void setRemUrl(String aRemUrl) { remUrl = aRemUrl; modifiedFields.add("RemUrl"); }
    public void assignRemUrl(String aRemUrl) { remUrl = aRemUrl; }
    public void paramRemUrl(HttpServletRequest request) { paramRemUrl(request, "RemUrl"); }
    public void paramRemUrl(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemUrl()); if (!tmp.equals(getRemUrl())) { setRemUrl(tmp); } }
    // RemindSys
    protected String remindSys = "";
    public String getRemindSys() {  return SqlTool.getDbString(remindSys);  }
    public String getRemindSys(int size) { return SqlTool.subString(getRemindSys(), size); }
    public void setRemindSys(String aRemindSys) { remindSys = aRemindSys; modifiedFields.add("RemindSys"); }
    public void assignRemindSys(String aRemindSys) { remindSys = aRemindSys; }
    public void paramRemindSys(HttpServletRequest request) { paramRemindSys(request, "RemindSys"); }
    public void paramRemindSys(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemindSys()); if (!tmp.equals(getRemindSys())) { setRemindSys(tmp); } }
    // 是否可用
    protected int isEnable = -1;
    public int getIsEnable() { return isEnable; }
    public void setIsEnable(int aIsEnable) { isEnable = aIsEnable; modifiedFields.add("IsEnable"); }
    public void assignIsEnable(int aIsEnable) { isEnable = aIsEnable; }
    public void paramIsEnable(HttpServletRequest request) { paramIsEnable(request, "IsEnable"); }
    public void paramIsEnable(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getIsEnable()); if (tmp != getIsEnable()) { setIsEnable(tmp); } }
    // 提醒方式
    protected String remindType = "";
    public String getRemindType() {  return SqlTool.getDbString(remindType);  }
    public String getRemindType(int size) { return SqlTool.subString(getRemindType(), size); }
    public void setRemindType(String aRemindType) { remindType = aRemindType; modifiedFields.add("RemindType"); }
    public void assignRemindType(String aRemindType) { remindType = aRemindType; }
    public void paramRemindType(HttpServletRequest request) { paramRemindType(request, "RemindType"); }
    public void paramRemindType(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemindType()); if (!tmp.equals(getRemindType())) { setRemindType(tmp); } }
    protected InputStream iscontent = new ByteArrayInputStream(new byte[0]);
    private int stateOfcontent = 0;
    public InputStream getContent() {
        if (id <= 0||stateOfcontent == 2) {
            return iscontent;
        }
        if(stateOfcontent == 0) {
            SqlTool content = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "content", "id");
            iscontent = content.getBlob("jdbc/ds", getId());
            stateOfcontent = 1;
        }
        if(iscontent == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        else {
            return iscontent;
        }
    }
    public void setContent(InputStream aContent) {
        iscontent = aContent;
        modifiedFields.add("Content");
        stateOfcontent = 2;
    }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public ShortMessage (String db) {
        DBNAME = db;
    }
    public ShortMessage (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public ShortMessage (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public ShortMessage () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return ShortMessage类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public ShortMessage getByParameter(HttpServletRequest request) {
        ShortMessage v = new ShortMessage(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramSendDate(request);
        paramSubject(request);
        paramMsgGrade(request);
        paramSendId(request);
        paramReceiveIds(request);
        paramIfSee(request);
        paramReceipt(request);
        paramCollectDate(request);
        paramSaveDate(request);
        paramSmsStyle(request);
        paramAttachIds(request);
        paramRemUrl(request);
        paramRemindSys(request);
        paramIsEnable(request);
        paramRemindType(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(ShortMessage bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("sendDate")) { setSendDate(bean.getSendDate()); }
        if (!ncl.contains("subject")) { setSubject(bean.getSubject()); }
        if (!ncl.contains("msgGrade")) { setMsgGrade(bean.getMsgGrade()); }
        if (!ncl.contains("sendId")) { setSendId(bean.getSendId()); }
        if (!ncl.contains("receiveIds")) { setReceiveIds(bean.getReceiveIds()); }
        if (!ncl.contains("ifSee")) { setIfSee(bean.getIfSee()); }
        if (!ncl.contains("receipt")) { setReceipt(bean.getReceipt()); }
        if (!ncl.contains("collectDate")) { setCollectDate(bean.getCollectDate()); }
        if (!ncl.contains("saveDate")) { setSaveDate(bean.getSaveDate()); }
        if (!ncl.contains("smsStyle")) { setSmsStyle(bean.getSmsStyle()); }
        if (!ncl.contains("attachIds")) { setAttachIds(bean.getAttachIds()); }
        if (!ncl.contains("remUrl")) { setRemUrl(bean.getRemUrl()); }
        if (!ncl.contains("remindSys")) { setRemindSys(bean.getRemindSys()); }
        if (!ncl.contains("isEnable")) { setIsEnable(bean.getIsEnable()); }
        if (!ncl.contains("remindType")) { setRemindType(bean.getRemindType()); }
    }
    public ShortMessage getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        ShortMessage[] rslt= queryByCondition(cdt);
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
     * @return ShortMessage类的实例列表。
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
                ShortMessage ve = new ShortMessage(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                tmpDate = rs.getTimestamp(2); if (tmpDate != null) { ve.assignSendDate(new java.util.Date(tmpDate.getTime())); }
                ve.assignSubject(fromDbCh(rs.getString(3)));
                ve.assignMsgGrade(rs.getInt(4));
                ve.assignSendId(rs.getInt(5));
                ve.assignReceiveIds(fromDbCh(rs.getString(6)));
                ve.assignIfSee(rs.getInt(7));
                ve.assignReceipt(rs.getInt(8));
                tmpDate = rs.getTimestamp(9); if (tmpDate != null) { ve.assignCollectDate(new java.util.Date(tmpDate.getTime())); }
                tmpDate = rs.getTimestamp(10); if (tmpDate != null) { ve.assignSaveDate(new java.util.Date(tmpDate.getTime())); }
                ve.assignSmsStyle(rs.getInt(11));
                ve.assignAttachIds(fromDbCh(rs.getString(12)));
                ve.assignRemUrl(fromDbCh(rs.getString(13)));
                ve.assignRemindSys(fromDbCh(rs.getString(14)));
                ve.assignIsEnable(rs.getInt(15));
                ve.assignRemindType(fromDbCh(rs.getString(16)));
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
    public ShortMessage[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (ShortMessage[])vrs.toArray(new ShortMessage[vrs.size()]);
    }
    public ShortMessage[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (ShortMessage[])vrs.toArray(new ShortMessage[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (senddate,subject,msggrade,sendid,receiveids,ifsee,receipt,collectdate,savedate,smsstyle,attachids,remurl,remindsys,isenable,remindtype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        SqlTool content = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "content", "id");
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setTimestamp(1, new java.sql.Timestamp(sendDate.getTime()));
            pstmt.setString(2, toDbCh(subject));
            pstmt.setInt(3, msgGrade);
            pstmt.setInt(4, sendId);
            pstmt.setString(5, toDbCh(receiveIds));
            pstmt.setInt(6, ifSee);
            pstmt.setInt(7, receipt);
            pstmt.setTimestamp(8, new java.sql.Timestamp(collectDate.getTime()));
            pstmt.setTimestamp(9, new java.sql.Timestamp(saveDate.getTime()));
            pstmt.setInt(10, smsStyle);
            pstmt.setString(11, toDbCh(attachIds));
            pstmt.setString(12, toDbCh(remUrl));
            pstmt.setString(13, toDbCh(remindSys));
            pstmt.setInt(14, isEnable);
            pstmt.setString(15, toDbCh(remindType));
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
        content.setBlob("jdbc/ds", getContent(), id);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,senddate,subject,msggrade,sendid,receiveids,ifsee,receipt,collectdate,savedate,smsstyle,attachids,remurl,remindsys,isenable,remindtype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        SqlTool content = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "content", "id");
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setTimestamp(2, new java.sql.Timestamp(sendDate.getTime()));
            pstmt.setString(3, toDbCh(subject));
            pstmt.setInt(4, msgGrade);
            pstmt.setInt(5, sendId);
            pstmt.setString(6, toDbCh(receiveIds));
            pstmt.setInt(7, ifSee);
            pstmt.setInt(8, receipt);
            pstmt.setTimestamp(9, new java.sql.Timestamp(collectDate.getTime()));
            pstmt.setTimestamp(10, new java.sql.Timestamp(saveDate.getTime()));
            pstmt.setInt(11, smsStyle);
            pstmt.setString(12, toDbCh(attachIds));
            pstmt.setString(13, toDbCh(remUrl));
            pstmt.setString(14, toDbCh(remindSys));
            pstmt.setInt(15, isEnable);
            pstmt.setString(16, toDbCh(remindType));
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
        content.setBlob("jdbc/ds", getContent(), id);
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
            ShortMessage item = (ShortMessage)it.next();
            ShortMessage v = new ShortMessage(dbname);
            v.setNoChangeList(noChangeList);
            v.clone(item);
            v.setContent(item.getContent());
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
                if (modifiedFields.contains("SendDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(sendDate.getTime())); }
                if (modifiedFields.contains("Subject")) { pstmt.setString(pi ++, toDbCh(subject)); }
                if (modifiedFields.contains("MsgGrade")) { pstmt.setInt(pi ++, msgGrade); }
                if (modifiedFields.contains("SendId")) { pstmt.setInt(pi ++, sendId); }
                if (modifiedFields.contains("ReceiveIds")) { pstmt.setString(pi ++, toDbCh(receiveIds)); }
                if (modifiedFields.contains("IfSee")) { pstmt.setInt(pi ++, ifSee); }
                if (modifiedFields.contains("Receipt")) { pstmt.setInt(pi ++, receipt); }
                if (modifiedFields.contains("CollectDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(collectDate.getTime())); }
                if (modifiedFields.contains("SaveDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(saveDate.getTime())); }
                if (modifiedFields.contains("SmsStyle")) { pstmt.setInt(pi ++, smsStyle); }
                if (modifiedFields.contains("AttachIds")) { pstmt.setString(pi ++, toDbCh(attachIds)); }
                if (modifiedFields.contains("RemUrl")) { pstmt.setString(pi ++, toDbCh(remUrl)); }
                if (modifiedFields.contains("RemindSys")) { pstmt.setString(pi ++, toDbCh(remindSys)); }
                if (modifiedFields.contains("IsEnable")) { pstmt.setInt(pi ++, isEnable); }
                if (modifiedFields.contains("RemindType")) { pstmt.setString(pi ++, toDbCh(remindType)); }
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
        if (modifiedFields.contains("Content")) {
            SqlTool content = new SqlTool(SqlTool.MYSQL, DBNAME, TNAME, "content", "id");
            content.setBlob("jdbc/ds", getContent(), id);
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
                if (modifiedFields.contains("SendDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(sendDate.getTime())); }
                if (modifiedFields.contains("Subject")) { pstmt.setString(pi ++, toDbCh(subject)); }
                if (modifiedFields.contains("MsgGrade")) { pstmt.setInt(pi ++, msgGrade); }
                if (modifiedFields.contains("SendId")) { pstmt.setInt(pi ++, sendId); }
                if (modifiedFields.contains("ReceiveIds")) { pstmt.setString(pi ++, toDbCh(receiveIds)); }
                if (modifiedFields.contains("IfSee")) { pstmt.setInt(pi ++, ifSee); }
                if (modifiedFields.contains("Receipt")) { pstmt.setInt(pi ++, receipt); }
                if (modifiedFields.contains("CollectDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(collectDate.getTime())); }
                if (modifiedFields.contains("SaveDate")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(saveDate.getTime())); }
                if (modifiedFields.contains("SmsStyle")) { pstmt.setInt(pi ++, smsStyle); }
                if (modifiedFields.contains("AttachIds")) { pstmt.setString(pi ++, toDbCh(attachIds)); }
                if (modifiedFields.contains("RemUrl")) { pstmt.setString(pi ++, toDbCh(remUrl)); }
                if (modifiedFields.contains("RemindSys")) { pstmt.setString(pi ++, toDbCh(remindSys)); }
                if (modifiedFields.contains("IsEnable")) { pstmt.setInt(pi ++, isEnable); }
                if (modifiedFields.contains("RemindType")) { pstmt.setString(pi ++, toDbCh(remindType)); }
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
        map.put("Content", StrTool.base64Encode(getContent()));
        map.put("SendDate", Tool.stringOfDateTime(getSendDate()));
        map.put("Subject", getSubject());
        map.put("MsgGrade", getMsgGrade() + "");
        map.put("SendId", getSendId() + "");
        map.put("ReceiveIds", getReceiveIds());
        map.put("IfSee", getIfSee() + "");
        map.put("Receipt", getReceipt() + "");
        map.put("CollectDate", Tool.stringOfDateTime(getCollectDate()));
        map.put("SaveDate", Tool.stringOfDateTime(getSaveDate()));
        map.put("SmsStyle", getSmsStyle() + "");
        map.put("AttachIds", getAttachIds());
        map.put("RemUrl", getRemUrl());
        map.put("RemindSys", getRemindSys());
        map.put("IsEnable", getIsEnable() + "");
        map.put("RemindType", getRemindType());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("Content:\"" + StrTool.base64Encode(getContent()) + "\"");
        row.add("SendDate:\"" + Tool.stringOfDateTime(getSendDate()) + "\"");
        row.add("Subject:\"" + Tool.jsSpecialChars(getSubject()) + "\"");
        row.add("MsgGrade:\"" + getMsgGrade() + "\"");
        row.add("SendId:\"" + getSendId() + "\"");
        row.add("ReceiveIds:\"" + Tool.jsSpecialChars(getReceiveIds()) + "\"");
        row.add("IfSee:\"" + getIfSee() + "\"");
        row.add("Receipt:\"" + getReceipt() + "\"");
        row.add("CollectDate:\"" + Tool.stringOfDateTime(getCollectDate()) + "\"");
        row.add("SaveDate:\"" + Tool.stringOfDateTime(getSaveDate()) + "\"");
        row.add("SmsStyle:\"" + getSmsStyle() + "\"");
        row.add("AttachIds:\"" + Tool.jsSpecialChars(getAttachIds()) + "\"");
        row.add("RemUrl:\"" + Tool.jsSpecialChars(getRemUrl()) + "\"");
        row.add("RemindSys:\"" + Tool.jsSpecialChars(getRemindSys()) + "\"");
        row.add("IsEnable:\"" + getIsEnable() + "\"");
        row.add("RemindType:\"" + Tool.jsSpecialChars(getRemindType()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,content blob,senddate date,subject varchar2(500),msggrade number(*,0),sendid number(*,0),receiveids varchar2(500),ifsee number(*,0),receipt number(*,0),collectdate date,savedate date,smsstyle number(*,0),attachids varchar2(200),remurl varchar2(200),remindsys varchar2(20),isenable number(*,0),remindtype varchar2(20))"});
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
        ShortMessage v = new ShortMessage(sourceDb, sourceTb);
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
        ShortMessage v = new ShortMessage(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(ShortMessage obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = StrTool.base64Encode(getContent()).compareTo(StrTool.base64Encode(obj.getContent())); if (rtn != 0) return rtn;
        rtn = getSendDate().compareTo(obj.getSendDate()); if (rtn != 0) return rtn;
        rtn = getSubject().compareTo(obj.getSubject()); if (rtn != 0) return rtn;
        rtn = ("" + getMsgGrade()).compareTo("" + obj.getMsgGrade()); if (rtn != 0) return rtn;
        rtn = ("" + getSendId()).compareTo("" + obj.getSendId()); if (rtn != 0) return rtn;
        rtn = getReceiveIds().compareTo(obj.getReceiveIds()); if (rtn != 0) return rtn;
        rtn = ("" + getIfSee()).compareTo("" + obj.getIfSee()); if (rtn != 0) return rtn;
        rtn = ("" + getReceipt()).compareTo("" + obj.getReceipt()); if (rtn != 0) return rtn;
        rtn = getCollectDate().compareTo(obj.getCollectDate()); if (rtn != 0) return rtn;
        rtn = getSaveDate().compareTo(obj.getSaveDate()); if (rtn != 0) return rtn;
        rtn = ("" + getSmsStyle()).compareTo("" + obj.getSmsStyle()); if (rtn != 0) return rtn;
        rtn = getAttachIds().compareTo(obj.getAttachIds()); if (rtn != 0) return rtn;
        rtn = getRemUrl().compareTo(obj.getRemUrl()); if (rtn != 0) return rtn;
        rtn = getRemindSys().compareTo(obj.getRemindSys()); if (rtn != 0) return rtn;
        rtn = ("" + getIsEnable()).compareTo("" + obj.getIsEnable()); if (rtn != 0) return rtn;
        rtn = getRemindType().compareTo(obj.getRemindType()); if (rtn != 0) return rtn;
        return rtn;
    }
}
