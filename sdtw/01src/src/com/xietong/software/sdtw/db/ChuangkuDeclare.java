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
@Description("参加山大创库作品表")
public class ChuangkuDeclare implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(ChuangkuDeclare.class);
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
    public static final String DbTableName = "chuangku_declare";
    private String TNAME = "chuangku_declare";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","ckId","academy","addFilelist","addAccount","addTime","checkFlag","cdp1","cdp2","cdp3","cdp4","cd1","cd2","cd3","cd4","cd5","cd6","cd7","cd8","cd9","cd10","cd11","cd12","cd13","cd14"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","ckid","academy","addfilelist","addaccount","addtime","checkflag","cdp1","cdp2","cdp3","cdp4","cd1","cd2","cd3","cd4","cd5","cd6","cd7","cd8","cd9","cd10","cd11","cd12","cd13","cd14"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"CkId","ckid","int"},{"Academy","academy","String"},{"AddFilelist","addfilelist","String"},{"AddAccount","addaccount","String"},{"AddTime","addtime","String"},{"CheckFlag","checkflag","int"},{"Cdp1","cdp1","String"},{"Cdp2","cdp2","String"},{"Cdp3","cdp3","String"},{"Cdp4","cdp4","String"},{"Cd1","cd1","String"},{"Cd2","cd2","String"},{"Cd3","cd3","String"},{"Cd4","cd4","String"},{"Cd5","cd5","String"},{"Cd6","cd6","String"},{"Cd7","cd7","String"},{"Cd8","cd8","String"},{"Cd9","cd9","String"},{"Cd10","cd10","String"},{"Cd11","cd11","String"},{"Cd12","cd12","String"},{"Cd13","cd13","String"},{"Cd14","cd14","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"ckId","ckid"},{"academy","academy"},{"addFilelist","addfilelist"},{"addAccount","addaccount"},{"addTime","addtime"},{"checkFlag","checkflag"},{"cdp1","cdp1"},{"cdp2","cdp2"},{"cdp3","cdp3"},{"cdp4","cdp4"},{"cd1","cd1"},{"cd2","cd2"},{"cd3","cd3"},{"cd4","cd4"},{"cd5","cd5"},{"cd6","cd6"},{"cd7","cd7"},{"cd8","cd8"},{"cd9","cd9"},{"cd10","cd10"},{"cd11","cd11"},{"cd12","cd12"},{"cd13","cd13"},{"cd14","cd14"}};
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
    // 参与的创库通知的id
    protected int ckId = -1;
    public int getCkId() { return ckId; }
    public void setCkId(int aCkId) { ckId = aCkId; modifiedFields.add("CkId"); }
    public void assignCkId(int aCkId) { ckId = aCkId; }
    public void paramCkId(HttpServletRequest request) { paramCkId(request, "CkId"); }
    public void paramCkId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCkId()); if (tmp != getCkId()) { setCkId(tmp); } }
    // 学院
    protected String academy = "";
    public String getAcademy() {  return SqlTool.getDbString(academy);  }
    public String getAcademy(int size) { return SqlTool.subString(getAcademy(), size); }
    public void setAcademy(String aAcademy) { academy = aAcademy; modifiedFields.add("Academy"); }
    public void assignAcademy(String aAcademy) { academy = aAcademy; }
    public void paramAcademy(HttpServletRequest request) { paramAcademy(request, "Academy"); }
    public void paramAcademy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAcademy()); if (!tmp.equals(getAcademy())) { setAcademy(tmp); } }
    // 上传文件列表
    protected String addFilelist = "";
    public String getAddFilelist() {  return SqlTool.getDbString(addFilelist);  }
    public String getAddFilelist(int size) { return SqlTool.subString(getAddFilelist(), size); }
    public void setAddFilelist(String aAddFilelist) { addFilelist = aAddFilelist; modifiedFields.add("AddFilelist"); }
    public void assignAddFilelist(String aAddFilelist) { addFilelist = aAddFilelist; }
    public void paramAddFilelist(HttpServletRequest request) { paramAddFilelist(request, "AddFilelist"); }
    public void paramAddFilelist(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddFilelist()); if (!tmp.equals(getAddFilelist())) { setAddFilelist(tmp); } }
    // 添加描述
    protected String addAccount = "";
    public String getAddAccount() {  return SqlTool.getDbString(addAccount);  }
    public String getAddAccount(int size) { return SqlTool.subString(getAddAccount(), size); }
    public void setAddAccount(String aAddAccount) { addAccount = aAddAccount; modifiedFields.add("AddAccount"); }
    public void assignAddAccount(String aAddAccount) { addAccount = aAddAccount; }
    public void paramAddAccount(HttpServletRequest request) { paramAddAccount(request, "AddAccount"); }
    public void paramAddAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddAccount()); if (!tmp.equals(getAddAccount())) { setAddAccount(tmp); } }
    // 添加时间
    protected String addTime = "";
    public String getAddTime() {  return SqlTool.getDbString(addTime);  }
    public String getAddTime(int size) { return SqlTool.subString(getAddTime(), size); }
    public void setAddTime(String aAddTime) { addTime = aAddTime; modifiedFields.add("AddTime"); }
    public void assignAddTime(String aAddTime) { addTime = aAddTime; }
    public void paramAddTime(HttpServletRequest request) { paramAddTime(request, "AddTime"); }
    public void paramAddTime(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAddTime()); if (!tmp.equals(getAddTime())) { setAddTime(tmp); } }
    // 审核状态
    protected int checkFlag = 0;
    public int getCheckFlag() { return checkFlag; }
    public void setCheckFlag(int aCheckFlag) { checkFlag = aCheckFlag; modifiedFields.add("CheckFlag"); }
    public void assignCheckFlag(int aCheckFlag) { checkFlag = aCheckFlag; }
    public void paramCheckFlag(HttpServletRequest request) { paramCheckFlag(request, "CheckFlag"); }
    public void paramCheckFlag(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getCheckFlag()); if (tmp != getCheckFlag()) { setCheckFlag(tmp); } }
    // 负责人姓名
    protected String cdp1 = "";
    public String getCdp1() {  return SqlTool.getDbString(cdp1);  }
    public String getCdp1(int size) { return SqlTool.subString(getCdp1(), size); }
    public void setCdp1(String aCdp1) { cdp1 = aCdp1; modifiedFields.add("Cdp1"); }
    public void assignCdp1(String aCdp1) { cdp1 = aCdp1; }
    public void paramCdp1(HttpServletRequest request) { paramCdp1(request, "Cdp1"); }
    public void paramCdp1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCdp1()); if (!tmp.equals(getCdp1())) { setCdp1(tmp); } }
    // 负责人学院
    protected String cdp2 = "";
    public String getCdp2() {  return SqlTool.getDbString(cdp2);  }
    public String getCdp2(int size) { return SqlTool.subString(getCdp2(), size); }
    public void setCdp2(String aCdp2) { cdp2 = aCdp2; modifiedFields.add("Cdp2"); }
    public void assignCdp2(String aCdp2) { cdp2 = aCdp2; }
    public void paramCdp2(HttpServletRequest request) { paramCdp2(request, "Cdp2"); }
    public void paramCdp2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCdp2()); if (!tmp.equals(getCdp2())) { setCdp2(tmp); } }
    // 负责人学号
    protected String cdp3 = "";
    public String getCdp3() {  return SqlTool.getDbString(cdp3);  }
    public String getCdp3(int size) { return SqlTool.subString(getCdp3(), size); }
    public void setCdp3(String aCdp3) { cdp3 = aCdp3; modifiedFields.add("Cdp3"); }
    public void assignCdp3(String aCdp3) { cdp3 = aCdp3; }
    public void paramCdp3(HttpServletRequest request) { paramCdp3(request, "Cdp3"); }
    public void paramCdp3(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCdp3()); if (!tmp.equals(getCdp3())) { setCdp3(tmp); } }
    // 负责人联系方式
    protected String cdp4 = "";
    public String getCdp4() {  return SqlTool.getDbString(cdp4);  }
    public String getCdp4(int size) { return SqlTool.subString(getCdp4(), size); }
    public void setCdp4(String aCdp4) { cdp4 = aCdp4; modifiedFields.add("Cdp4"); }
    public void assignCdp4(String aCdp4) { cdp4 = aCdp4; }
    public void paramCdp4(HttpServletRequest request) { paramCdp4(request, "Cdp4"); }
    public void paramCdp4(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCdp4()); if (!tmp.equals(getCdp4())) { setCdp4(tmp); } }
    // 项目名称
    protected String cd1 = "";
    public String getCd1() {  return SqlTool.getDbString(cd1);  }
    public String getCd1(int size) { return SqlTool.subString(getCd1(), size); }
    public void setCd1(String aCd1) { cd1 = aCd1; modifiedFields.add("Cd1"); }
    public void assignCd1(String aCd1) { cd1 = aCd1; }
    public void paramCd1(HttpServletRequest request) { paramCd1(request, "Cd1"); }
    public void paramCd1(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd1()); if (!tmp.equals(getCd1())) { setCd1(tmp); } }
    // 项目分类
    protected String cd2 = "";
    public String getCd2() {  return SqlTool.getDbString(cd2);  }
    public String getCd2(int size) { return SqlTool.subString(getCd2(), size); }
    public void setCd2(String aCd2) { cd2 = aCd2; modifiedFields.add("Cd2"); }
    public void assignCd2(String aCd2) { cd2 = aCd2; }
    public void paramCd2(HttpServletRequest request) { paramCd2(request, "Cd2"); }
    public void paramCd2(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd2()); if (!tmp.equals(getCd2())) { setCd2(tmp); } }
    // 项目分组
    protected String cd3 = "";
    public String getCd3() {  return SqlTool.getDbString(cd3);  }
    public String getCd3(int size) { return SqlTool.subString(getCd3(), size); }
    public void setCd3(String aCd3) { cd3 = aCd3; modifiedFields.add("Cd3"); }
    public void assignCd3(String aCd3) { cd3 = aCd3; }
    public void paramCd3(HttpServletRequest request) { paramCd3(request, "Cd3"); }
    public void paramCd3(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd3()); if (!tmp.equals(getCd3())) { setCd3(tmp); } }
    // 技术可行性分析
    protected String cd4 = "";
    public String getCd4() {  return SqlTool.getDbString(cd4);  }
    public String getCd4(int size) { return SqlTool.subString(getCd4(), size); }
    public void setCd4(String aCd4) { cd4 = aCd4; modifiedFields.add("Cd4"); }
    public void assignCd4(String aCd4) { cd4 = aCd4; }
    public void paramCd4(HttpServletRequest request) { paramCd4(request, "Cd4"); }
    public void paramCd4(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd4()); if (!tmp.equals(getCd4())) { setCd4(tmp); } }
    // 市场可行性分析
    protected String cd5 = "";
    public String getCd5() {  return SqlTool.getDbString(cd5);  }
    public String getCd5(int size) { return SqlTool.subString(getCd5(), size); }
    public void setCd5(String aCd5) { cd5 = aCd5; modifiedFields.add("Cd5"); }
    public void assignCd5(String aCd5) { cd5 = aCd5; }
    public void paramCd5(HttpServletRequest request) { paramCd5(request, "Cd5"); }
    public void paramCd5(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd5()); if (!tmp.equals(getCd5())) { setCd5(tmp); } }
    // 项目推进时间分析
    protected String cd6 = "";
    public String getCd6() {  return SqlTool.getDbString(cd6);  }
    public String getCd6(int size) { return SqlTool.subString(getCd6(), size); }
    public void setCd6(String aCd6) { cd6 = aCd6; modifiedFields.add("Cd6"); }
    public void assignCd6(String aCd6) { cd6 = aCd6; }
    public void paramCd6(HttpServletRequest request) { paramCd6(request, "Cd6"); }
    public void paramCd6(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd6()); if (!tmp.equals(getCd6())) { setCd6(tmp); } }
    // 项目阶段
    protected String cd7 = "";
    public String getCd7() {  return SqlTool.getDbString(cd7);  }
    public String getCd7(int size) { return SqlTool.subString(getCd7(), size); }
    public void setCd7(String aCd7) { cd7 = aCd7; modifiedFields.add("Cd7"); }
    public void assignCd7(String aCd7) { cd7 = aCd7; }
    public void paramCd7(HttpServletRequest request) { paramCd7(request, "Cd7"); }
    public void paramCd7(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd7()); if (!tmp.equals(getCd7())) { setCd7(tmp); } }
    // 是否有社会资金
    protected String cd8 = "";
    public String getCd8() {  return SqlTool.getDbString(cd8);  }
    public String getCd8(int size) { return SqlTool.subString(getCd8(), size); }
    public void setCd8(String aCd8) { cd8 = aCd8; modifiedFields.add("Cd8"); }
    public void assignCd8(String aCd8) { cd8 = aCd8; }
    public void paramCd8(HttpServletRequest request) { paramCd8(request, "Cd8"); }
    public void paramCd8(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd8()); if (!tmp.equals(getCd8())) { setCd8(tmp); } }
    // 社会资金额度
    protected String cd9 = "";
    public String getCd9() {  return SqlTool.getDbString(cd9);  }
    public String getCd9(int size) { return SqlTool.subString(getCd9(), size); }
    public void setCd9(String aCd9) { cd9 = aCd9; modifiedFields.add("Cd9"); }
    public void assignCd9(String aCd9) { cd9 = aCd9; }
    public void paramCd9(HttpServletRequest request) { paramCd9(request, "Cd9"); }
    public void paramCd9(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd9()); if (!tmp.equals(getCd9())) { setCd9(tmp); } }
    // 计划注册资本金额
    protected String cd10 = "";
    public String getCd10() {  return SqlTool.getDbString(cd10);  }
    public String getCd10(int size) { return SqlTool.subString(getCd10(), size); }
    public void setCd10(String aCd10) { cd10 = aCd10; modifiedFields.add("Cd10"); }
    public void assignCd10(String aCd10) { cd10 = aCd10; }
    public void paramCd10(HttpServletRequest request) { paramCd10(request, "Cd10"); }
    public void paramCd10(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd10()); if (!tmp.equals(getCd10())) { setCd10(tmp); } }
    // 创业团队自有资金
    protected String cd11 = "";
    public String getCd11() {  return SqlTool.getDbString(cd11);  }
    public String getCd11(int size) { return SqlTool.subString(getCd11(), size); }
    public void setCd11(String aCd11) { cd11 = aCd11; modifiedFields.add("Cd11"); }
    public void assignCd11(String aCd11) { cd11 = aCd11; }
    public void paramCd11(HttpServletRequest request) { paramCd11(request, "Cd11"); }
    public void paramCd11(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd11()); if (!tmp.equals(getCd11())) { setCd11(tmp); } }
    // 团队已经经营该项目时间
    protected String cd12 = "";
    public String getCd12() {  return SqlTool.getDbString(cd12);  }
    public String getCd12(int size) { return SqlTool.subString(getCd12(), size); }
    public void setCd12(String aCd12) { cd12 = aCd12; modifiedFields.add("Cd12"); }
    public void assignCd12(String aCd12) { cd12 = aCd12; }
    public void paramCd12(HttpServletRequest request) { paramCd12(request, "Cd12"); }
    public void paramCd12(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd12()); if (!tmp.equals(getCd12())) { setCd12(tmp); } }
    // 盈利情况
    protected String cd13 = "";
    public String getCd13() {  return SqlTool.getDbString(cd13);  }
    public String getCd13(int size) { return SqlTool.subString(getCd13(), size); }
    public void setCd13(String aCd13) { cd13 = aCd13; modifiedFields.add("Cd13"); }
    public void assignCd13(String aCd13) { cd13 = aCd13; }
    public void paramCd13(HttpServletRequest request) { paramCd13(request, "Cd13"); }
    public void paramCd13(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd13()); if (!tmp.equals(getCd13())) { setCd13(tmp); } }
    // 备注
    protected String cd14 = "";
    public String getCd14() {  return SqlTool.getDbString(cd14);  }
    public String getCd14(int size) { return SqlTool.subString(getCd14(), size); }
    public void setCd14(String aCd14) { cd14 = aCd14; modifiedFields.add("Cd14"); }
    public void assignCd14(String aCd14) { cd14 = aCd14; }
    public void paramCd14(HttpServletRequest request) { paramCd14(request, "Cd14"); }
    public void paramCd14(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getCd14()); if (!tmp.equals(getCd14())) { setCd14(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public ChuangkuDeclare (String db) {
        DBNAME = db;
    }
    public ChuangkuDeclare (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public ChuangkuDeclare (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public ChuangkuDeclare () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return ChuangkuDeclare类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public ChuangkuDeclare getByParameter(HttpServletRequest request) {
        ChuangkuDeclare v = new ChuangkuDeclare(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramCkId(request);
        paramAcademy(request);
        paramAddFilelist(request);
        paramAddAccount(request);
        paramAddTime(request);
        paramCheckFlag(request);
        paramCdp1(request);
        paramCdp2(request);
        paramCdp3(request);
        paramCdp4(request);
        paramCd1(request);
        paramCd2(request);
        paramCd3(request);
        paramCd4(request);
        paramCd5(request);
        paramCd6(request);
        paramCd7(request);
        paramCd8(request);
        paramCd9(request);
        paramCd10(request);
        paramCd11(request);
        paramCd12(request);
        paramCd13(request);
        paramCd14(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(ChuangkuDeclare bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("ckId")) { setCkId(bean.getCkId()); }
        if (!ncl.contains("academy")) { setAcademy(bean.getAcademy()); }
        if (!ncl.contains("addFilelist")) { setAddFilelist(bean.getAddFilelist()); }
        if (!ncl.contains("addAccount")) { setAddAccount(bean.getAddAccount()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("checkFlag")) { setCheckFlag(bean.getCheckFlag()); }
        if (!ncl.contains("cdp1")) { setCdp1(bean.getCdp1()); }
        if (!ncl.contains("cdp2")) { setCdp2(bean.getCdp2()); }
        if (!ncl.contains("cdp3")) { setCdp3(bean.getCdp3()); }
        if (!ncl.contains("cdp4")) { setCdp4(bean.getCdp4()); }
        if (!ncl.contains("cd1")) { setCd1(bean.getCd1()); }
        if (!ncl.contains("cd2")) { setCd2(bean.getCd2()); }
        if (!ncl.contains("cd3")) { setCd3(bean.getCd3()); }
        if (!ncl.contains("cd4")) { setCd4(bean.getCd4()); }
        if (!ncl.contains("cd5")) { setCd5(bean.getCd5()); }
        if (!ncl.contains("cd6")) { setCd6(bean.getCd6()); }
        if (!ncl.contains("cd7")) { setCd7(bean.getCd7()); }
        if (!ncl.contains("cd8")) { setCd8(bean.getCd8()); }
        if (!ncl.contains("cd9")) { setCd9(bean.getCd9()); }
        if (!ncl.contains("cd10")) { setCd10(bean.getCd10()); }
        if (!ncl.contains("cd11")) { setCd11(bean.getCd11()); }
        if (!ncl.contains("cd12")) { setCd12(bean.getCd12()); }
        if (!ncl.contains("cd13")) { setCd13(bean.getCd13()); }
        if (!ncl.contains("cd14")) { setCd14(bean.getCd14()); }
    }
    public ChuangkuDeclare getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        ChuangkuDeclare[] rslt= queryByCondition(cdt);
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
     * @return ChuangkuDeclare类的实例列表。
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
                ChuangkuDeclare ve = new ChuangkuDeclare(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignCkId(rs.getInt(2));
                ve.assignAcademy(fromDbCh(rs.getString(3)));
                ve.assignAddFilelist(fromDbCh(rs.getString(4)));
                ve.assignAddAccount(fromDbCh(rs.getString(5)));
                ve.assignAddTime(fromDbCh(rs.getString(6)));
                ve.assignCheckFlag(rs.getInt(7));
                ve.assignCdp1(fromDbCh(rs.getString(8)));
                ve.assignCdp2(fromDbCh(rs.getString(9)));
                ve.assignCdp3(fromDbCh(rs.getString(10)));
                ve.assignCdp4(fromDbCh(rs.getString(11)));
                ve.assignCd1(fromDbCh(rs.getString(12)));
                ve.assignCd2(fromDbCh(rs.getString(13)));
                ve.assignCd3(fromDbCh(rs.getString(14)));
                ve.assignCd4(fromDbCh(rs.getString(15)));
                ve.assignCd5(fromDbCh(rs.getString(16)));
                ve.assignCd6(fromDbCh(rs.getString(17)));
                ve.assignCd7(fromDbCh(rs.getString(18)));
                ve.assignCd8(fromDbCh(rs.getString(19)));
                ve.assignCd9(fromDbCh(rs.getString(20)));
                ve.assignCd10(fromDbCh(rs.getString(21)));
                ve.assignCd11(fromDbCh(rs.getString(22)));
                ve.assignCd12(fromDbCh(rs.getString(23)));
                ve.assignCd13(fromDbCh(rs.getString(24)));
                ve.assignCd14(fromDbCh(rs.getString(25)));
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
    public ChuangkuDeclare[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (ChuangkuDeclare[])vrs.toArray(new ChuangkuDeclare[vrs.size()]);
    }
    public ChuangkuDeclare[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (ChuangkuDeclare[])vrs.toArray(new ChuangkuDeclare[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (ckid,academy,addfilelist,addaccount,addtime,checkflag,cdp1,cdp2,cdp3,cdp4,cd1,cd2,cd3,cd4,cd5,cd6,cd7,cd8,cd9,cd10,cd11,cd12,cd13,cd14) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, ckId);
            pstmt.setString(2, toDbCh(academy));
            pstmt.setString(3, toDbCh(addFilelist));
            pstmt.setString(4, toDbCh(addAccount));
            pstmt.setString(5, toDbCh(addTime));
            pstmt.setInt(6, checkFlag);
            pstmt.setString(7, toDbCh(cdp1));
            pstmt.setString(8, toDbCh(cdp2));
            pstmt.setString(9, toDbCh(cdp3));
            pstmt.setString(10, toDbCh(cdp4));
            pstmt.setString(11, toDbCh(cd1));
            pstmt.setString(12, toDbCh(cd2));
            pstmt.setString(13, toDbCh(cd3));
            pstmt.setString(14, toDbCh(cd4));
            pstmt.setString(15, toDbCh(cd5));
            pstmt.setString(16, toDbCh(cd6));
            pstmt.setString(17, toDbCh(cd7));
            pstmt.setString(18, toDbCh(cd8));
            pstmt.setString(19, toDbCh(cd9));
            pstmt.setString(20, toDbCh(cd10));
            pstmt.setString(21, toDbCh(cd11));
            pstmt.setString(22, toDbCh(cd12));
            pstmt.setString(23, toDbCh(cd13));
            pstmt.setString(24, toDbCh(cd14));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,ckid,academy,addfilelist,addaccount,addtime,checkflag,cdp1,cdp2,cdp3,cdp4,cd1,cd2,cd3,cd4,cd5,cd6,cd7,cd8,cd9,cd10,cd11,cd12,cd13,cd14) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setInt(2, ckId);
            pstmt.setString(3, toDbCh(academy));
            pstmt.setString(4, toDbCh(addFilelist));
            pstmt.setString(5, toDbCh(addAccount));
            pstmt.setString(6, toDbCh(addTime));
            pstmt.setInt(7, checkFlag);
            pstmt.setString(8, toDbCh(cdp1));
            pstmt.setString(9, toDbCh(cdp2));
            pstmt.setString(10, toDbCh(cdp3));
            pstmt.setString(11, toDbCh(cdp4));
            pstmt.setString(12, toDbCh(cd1));
            pstmt.setString(13, toDbCh(cd2));
            pstmt.setString(14, toDbCh(cd3));
            pstmt.setString(15, toDbCh(cd4));
            pstmt.setString(16, toDbCh(cd5));
            pstmt.setString(17, toDbCh(cd6));
            pstmt.setString(18, toDbCh(cd7));
            pstmt.setString(19, toDbCh(cd8));
            pstmt.setString(20, toDbCh(cd9));
            pstmt.setString(21, toDbCh(cd10));
            pstmt.setString(22, toDbCh(cd11));
            pstmt.setString(23, toDbCh(cd12));
            pstmt.setString(24, toDbCh(cd13));
            pstmt.setString(25, toDbCh(cd14));
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
            ChuangkuDeclare item = (ChuangkuDeclare)it.next();
            ChuangkuDeclare v = new ChuangkuDeclare(dbname);
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
                if (modifiedFields.contains("CkId")) { pstmt.setInt(pi ++, ckId); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("AddFilelist")) { pstmt.setString(pi ++, toDbCh(addFilelist)); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setString(pi ++, toDbCh(addTime)); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("Cdp1")) { pstmt.setString(pi ++, toDbCh(cdp1)); }
                if (modifiedFields.contains("Cdp2")) { pstmt.setString(pi ++, toDbCh(cdp2)); }
                if (modifiedFields.contains("Cdp3")) { pstmt.setString(pi ++, toDbCh(cdp3)); }
                if (modifiedFields.contains("Cdp4")) { pstmt.setString(pi ++, toDbCh(cdp4)); }
                if (modifiedFields.contains("Cd1")) { pstmt.setString(pi ++, toDbCh(cd1)); }
                if (modifiedFields.contains("Cd2")) { pstmt.setString(pi ++, toDbCh(cd2)); }
                if (modifiedFields.contains("Cd3")) { pstmt.setString(pi ++, toDbCh(cd3)); }
                if (modifiedFields.contains("Cd4")) { pstmt.setString(pi ++, toDbCh(cd4)); }
                if (modifiedFields.contains("Cd5")) { pstmt.setString(pi ++, toDbCh(cd5)); }
                if (modifiedFields.contains("Cd6")) { pstmt.setString(pi ++, toDbCh(cd6)); }
                if (modifiedFields.contains("Cd7")) { pstmt.setString(pi ++, toDbCh(cd7)); }
                if (modifiedFields.contains("Cd8")) { pstmt.setString(pi ++, toDbCh(cd8)); }
                if (modifiedFields.contains("Cd9")) { pstmt.setString(pi ++, toDbCh(cd9)); }
                if (modifiedFields.contains("Cd10")) { pstmt.setString(pi ++, toDbCh(cd10)); }
                if (modifiedFields.contains("Cd11")) { pstmt.setString(pi ++, toDbCh(cd11)); }
                if (modifiedFields.contains("Cd12")) { pstmt.setString(pi ++, toDbCh(cd12)); }
                if (modifiedFields.contains("Cd13")) { pstmt.setString(pi ++, toDbCh(cd13)); }
                if (modifiedFields.contains("Cd14")) { pstmt.setString(pi ++, toDbCh(cd14)); }
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
                if (modifiedFields.contains("CkId")) { pstmt.setInt(pi ++, ckId); }
                if (modifiedFields.contains("Academy")) { pstmt.setString(pi ++, toDbCh(academy)); }
                if (modifiedFields.contains("AddFilelist")) { pstmt.setString(pi ++, toDbCh(addFilelist)); }
                if (modifiedFields.contains("AddAccount")) { pstmt.setString(pi ++, toDbCh(addAccount)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setString(pi ++, toDbCh(addTime)); }
                if (modifiedFields.contains("CheckFlag")) { pstmt.setInt(pi ++, checkFlag); }
                if (modifiedFields.contains("Cdp1")) { pstmt.setString(pi ++, toDbCh(cdp1)); }
                if (modifiedFields.contains("Cdp2")) { pstmt.setString(pi ++, toDbCh(cdp2)); }
                if (modifiedFields.contains("Cdp3")) { pstmt.setString(pi ++, toDbCh(cdp3)); }
                if (modifiedFields.contains("Cdp4")) { pstmt.setString(pi ++, toDbCh(cdp4)); }
                if (modifiedFields.contains("Cd1")) { pstmt.setString(pi ++, toDbCh(cd1)); }
                if (modifiedFields.contains("Cd2")) { pstmt.setString(pi ++, toDbCh(cd2)); }
                if (modifiedFields.contains("Cd3")) { pstmt.setString(pi ++, toDbCh(cd3)); }
                if (modifiedFields.contains("Cd4")) { pstmt.setString(pi ++, toDbCh(cd4)); }
                if (modifiedFields.contains("Cd5")) { pstmt.setString(pi ++, toDbCh(cd5)); }
                if (modifiedFields.contains("Cd6")) { pstmt.setString(pi ++, toDbCh(cd6)); }
                if (modifiedFields.contains("Cd7")) { pstmt.setString(pi ++, toDbCh(cd7)); }
                if (modifiedFields.contains("Cd8")) { pstmt.setString(pi ++, toDbCh(cd8)); }
                if (modifiedFields.contains("Cd9")) { pstmt.setString(pi ++, toDbCh(cd9)); }
                if (modifiedFields.contains("Cd10")) { pstmt.setString(pi ++, toDbCh(cd10)); }
                if (modifiedFields.contains("Cd11")) { pstmt.setString(pi ++, toDbCh(cd11)); }
                if (modifiedFields.contains("Cd12")) { pstmt.setString(pi ++, toDbCh(cd12)); }
                if (modifiedFields.contains("Cd13")) { pstmt.setString(pi ++, toDbCh(cd13)); }
                if (modifiedFields.contains("Cd14")) { pstmt.setString(pi ++, toDbCh(cd14)); }
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
        map.put("CkId", getCkId() + "");
        map.put("Academy", getAcademy());
        map.put("AddFilelist", getAddFilelist());
        map.put("AddAccount", getAddAccount());
        map.put("AddTime", getAddTime());
        map.put("CheckFlag", getCheckFlag() + "");
        map.put("Cdp1", getCdp1());
        map.put("Cdp2", getCdp2());
        map.put("Cdp3", getCdp3());
        map.put("Cdp4", getCdp4());
        map.put("Cd1", getCd1());
        map.put("Cd2", getCd2());
        map.put("Cd3", getCd3());
        map.put("Cd4", getCd4());
        map.put("Cd5", getCd5());
        map.put("Cd6", getCd6());
        map.put("Cd7", getCd7());
        map.put("Cd8", getCd8());
        map.put("Cd9", getCd9());
        map.put("Cd10", getCd10());
        map.put("Cd11", getCd11());
        map.put("Cd12", getCd12());
        map.put("Cd13", getCd13());
        map.put("Cd14", getCd14());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("CkId:\"" + getCkId() + "\"");
        row.add("Academy:\"" + Tool.jsSpecialChars(getAcademy()) + "\"");
        row.add("AddFilelist:\"" + Tool.jsSpecialChars(getAddFilelist()) + "\"");
        row.add("AddAccount:\"" + Tool.jsSpecialChars(getAddAccount()) + "\"");
        row.add("AddTime:\"" + Tool.jsSpecialChars(getAddTime()) + "\"");
        row.add("CheckFlag:\"" + getCheckFlag() + "\"");
        row.add("Cdp1:\"" + Tool.jsSpecialChars(getCdp1()) + "\"");
        row.add("Cdp2:\"" + Tool.jsSpecialChars(getCdp2()) + "\"");
        row.add("Cdp3:\"" + Tool.jsSpecialChars(getCdp3()) + "\"");
        row.add("Cdp4:\"" + Tool.jsSpecialChars(getCdp4()) + "\"");
        row.add("Cd1:\"" + Tool.jsSpecialChars(getCd1()) + "\"");
        row.add("Cd2:\"" + Tool.jsSpecialChars(getCd2()) + "\"");
        row.add("Cd3:\"" + Tool.jsSpecialChars(getCd3()) + "\"");
        row.add("Cd4:\"" + Tool.jsSpecialChars(getCd4()) + "\"");
        row.add("Cd5:\"" + Tool.jsSpecialChars(getCd5()) + "\"");
        row.add("Cd6:\"" + Tool.jsSpecialChars(getCd6()) + "\"");
        row.add("Cd7:\"" + Tool.jsSpecialChars(getCd7()) + "\"");
        row.add("Cd8:\"" + Tool.jsSpecialChars(getCd8()) + "\"");
        row.add("Cd9:\"" + Tool.jsSpecialChars(getCd9()) + "\"");
        row.add("Cd10:\"" + Tool.jsSpecialChars(getCd10()) + "\"");
        row.add("Cd11:\"" + Tool.jsSpecialChars(getCd11()) + "\"");
        row.add("Cd12:\"" + Tool.jsSpecialChars(getCd12()) + "\"");
        row.add("Cd13:\"" + Tool.jsSpecialChars(getCd13()) + "\"");
        row.add("Cd14:\"" + Tool.jsSpecialChars(getCd14()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,ckid number(*,0),academy varchar2(45),addfilelist varchar2(255),addaccount varchar2(45),addtime varchar2(45),checkflag number(*,0),cdp1 varchar2(45),cdp2 varchar2(45),cdp3 varchar2(45),cdp4 varchar2(45),cd1 varchar2(45),cd2 varchar2(45),cd3 varchar2(45),cd4 varchar2(2000),cd5 varchar2(2000),cd6 varchar2(2000),cd7 varchar2(45),cd8 varchar2(45),cd9 varchar2(45),cd10 varchar2(45),cd11 varchar2(45),cd12 varchar2(45),cd13 varchar2(45),cd14 varchar2(255))"});
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
        ChuangkuDeclare v = new ChuangkuDeclare(sourceDb, sourceTb);
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
        ChuangkuDeclare v = new ChuangkuDeclare(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(ChuangkuDeclare obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = ("" + getCkId()).compareTo("" + obj.getCkId()); if (rtn != 0) return rtn;
        rtn = getAcademy().compareTo(obj.getAcademy()); if (rtn != 0) return rtn;
        rtn = getAddFilelist().compareTo(obj.getAddFilelist()); if (rtn != 0) return rtn;
        rtn = getAddAccount().compareTo(obj.getAddAccount()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = ("" + getCheckFlag()).compareTo("" + obj.getCheckFlag()); if (rtn != 0) return rtn;
        rtn = getCdp1().compareTo(obj.getCdp1()); if (rtn != 0) return rtn;
        rtn = getCdp2().compareTo(obj.getCdp2()); if (rtn != 0) return rtn;
        rtn = getCdp3().compareTo(obj.getCdp3()); if (rtn != 0) return rtn;
        rtn = getCdp4().compareTo(obj.getCdp4()); if (rtn != 0) return rtn;
        rtn = getCd1().compareTo(obj.getCd1()); if (rtn != 0) return rtn;
        rtn = getCd2().compareTo(obj.getCd2()); if (rtn != 0) return rtn;
        rtn = getCd3().compareTo(obj.getCd3()); if (rtn != 0) return rtn;
        rtn = getCd4().compareTo(obj.getCd4()); if (rtn != 0) return rtn;
        rtn = getCd5().compareTo(obj.getCd5()); if (rtn != 0) return rtn;
        rtn = getCd6().compareTo(obj.getCd6()); if (rtn != 0) return rtn;
        rtn = getCd7().compareTo(obj.getCd7()); if (rtn != 0) return rtn;
        rtn = getCd8().compareTo(obj.getCd8()); if (rtn != 0) return rtn;
        rtn = getCd9().compareTo(obj.getCd9()); if (rtn != 0) return rtn;
        rtn = getCd10().compareTo(obj.getCd10()); if (rtn != 0) return rtn;
        rtn = getCd11().compareTo(obj.getCd11()); if (rtn != 0) return rtn;
        rtn = getCd12().compareTo(obj.getCd12()); if (rtn != 0) return rtn;
        rtn = getCd13().compareTo(obj.getCd13()); if (rtn != 0) return rtn;
        rtn = getCd14().compareTo(obj.getCd14()); if (rtn != 0) return rtn;
        return rtn;
    }
}
