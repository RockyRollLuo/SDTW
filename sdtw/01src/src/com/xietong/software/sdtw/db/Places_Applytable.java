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
@Description("团委场地申请")
public class Places_Applytable implements DaoBase {
    /**
     * 所有私有变量
    */
    // 日志
    private static Log log = LogFactory.getLog(Places_Applytable.class);
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
    public static final String DbTableName = "places_applytable";
    private String TNAME = "places_applytable";
    public void setTableName(String val) { TNAME = val; }
    public String getTableName() { return TNAME; }
    // 当前数据表的主键字段名
    public static final String _PKey = "id";
    public String getPKey() { return _PKey; }
    // 包含所有bean属性名数组
    private static final String[] _allProperties = {"id","userAccount","placeApplycode","applyDate","applyTimeRange","applicant","activityPrincipal","principalDuty","principalPhone","activityTime","distributionPeriod","rehearsalPeriod","activityContents","speaker","basicProcedures","meetingMarks","backgroundContents","aponsorship","propaganda","otherPropaganda","tableNums","chairNums","wiredmicroPhoneNums","wirelessmicroPhoneNums","batteryNums","useFloor","useAudio","useLighting","useStageLight","useComputerLight","useProjector","useAc","useBanner","bannerContent","usePoster","posterContent","vehicleNums","promiser","promiserPhone","promiserAcadeMy","promiserClass","tutor","tutorDuty","tutorPhone","tutorAgree","remarks","addTime","status","guideUnitAgree"};
    public String[] getAllProperties() { return _allProperties; }
    private static final String[] _allFields = {"id","useraccount","placeapplycode","applydate","applytimerange","applicant","activityprincipal","principalduty","principalphone","activitytime","distributionperiod","rehearsalperiod","activitycontents","speaker","basicprocedures","meetingmarks","backgroundcontents","aponsorship","propaganda","otherpropaganda","tablenums","chairnums","wiredmicrophonenums","wirelessmicrophonenums","batterynums","usefloor","useaudio","uselighting","usestagelight","usecomputerlight","useprojector","useac","usebanner","bannercontent","useposter","postercontent","vehiclenums","promiser","promiserphone","promiseracademy","promiserclass","tutor","tutorduty","tutorphone","tutoragree","remarks","addtime","status","guideunitagree"};
    public String[] getAllFields() {return _allFields;}
    private static final String[][] _arrayPF = {{"Id","id","int"},{"UserAccount","useraccount","String"},{"PlaceApplycode","placeapplycode","String"},{"ApplyDate","applydate","String"},{"ApplyTimeRange","applytimerange","String"},{"Applicant","applicant","String"},{"ActivityPrincipal","activityprincipal","String"},{"PrincipalDuty","principalduty","String"},{"PrincipalPhone","principalphone","String"},{"ActivityTime","activitytime","java.util.Date"},{"DistributionPeriod","distributionperiod","String"},{"RehearsalPeriod","rehearsalperiod","String"},{"ActivityContents","activitycontents","String"},{"Speaker","speaker","String"},{"BasicProcedures","basicprocedures","String"},{"MeetingMarks","meetingmarks","String"},{"BackgroundContents","backgroundcontents","String"},{"Aponsorship","aponsorship","String"},{"Propaganda","propaganda","String"},{"OtherPropaganda","otherpropaganda","String"},{"TableNums","tablenums","int"},{"ChairNums","chairnums","int"},{"WiredmicroPhoneNums","wiredmicrophonenums","int"},{"WirelessmicroPhoneNums","wirelessmicrophonenums","int"},{"BatteryNums","batterynums","int"},{"UseFloor","usefloor","int"},{"UseAudio","useaudio","int"},{"UseLighting","uselighting","int"},{"UseStageLight","usestagelight","int"},{"UseComputerLight","usecomputerlight","int"},{"UseProjector","useprojector","int"},{"UseAc","useac","int"},{"UseBanner","usebanner","int"},{"BannerContent","bannercontent","String"},{"UsePoster","useposter","String"},{"PosterContent","postercontent","String"},{"VehicleNums","vehiclenums","String"},{"Promiser","promiser","String"},{"PromiserPhone","promiserphone","String"},{"PromiserAcadeMy","promiseracademy","String"},{"PromiserClass","promiserclass","String"},{"Tutor","tutor","String"},{"TutorDuty","tutorduty","String"},{"TutorPhone","tutorphone","String"},{"TutorAgree","tutoragree","String"},{"Remarks","remarks","String"},{"AddTime","addtime","java.util.Date"},{"Status","status","String"},{"GuideUnitAgree","guideunitagree","String"}};
    private static final String[][] _allPropertiesAndFields = {{"id","id"},{"userAccount","useraccount"},{"placeApplycode","placeapplycode"},{"applyDate","applydate"},{"applyTimeRange","applytimerange"},{"applicant","applicant"},{"activityPrincipal","activityprincipal"},{"principalDuty","principalduty"},{"principalPhone","principalphone"},{"activityTime","activitytime"},{"distributionPeriod","distributionperiod"},{"rehearsalPeriod","rehearsalperiod"},{"activityContents","activitycontents"},{"speaker","speaker"},{"basicProcedures","basicprocedures"},{"meetingMarks","meetingmarks"},{"backgroundContents","backgroundcontents"},{"aponsorship","aponsorship"},{"propaganda","propaganda"},{"otherPropaganda","otherpropaganda"},{"tableNums","tablenums"},{"chairNums","chairnums"},{"wiredmicroPhoneNums","wiredmicrophonenums"},{"wirelessmicroPhoneNums","wirelessmicrophonenums"},{"batteryNums","batterynums"},{"useFloor","usefloor"},{"useAudio","useaudio"},{"useLighting","uselighting"},{"useStageLight","usestagelight"},{"useComputerLight","usecomputerlight"},{"useProjector","useprojector"},{"useAc","useac"},{"useBanner","usebanner"},{"bannerContent","bannercontent"},{"usePoster","useposter"},{"posterContent","postercontent"},{"vehicleNums","vehiclenums"},{"promiser","promiser"},{"promiserPhone","promiserphone"},{"promiserAcadeMy","promiseracademy"},{"promiserClass","promiserclass"},{"tutor","tutor"},{"tutorDuty","tutorduty"},{"tutorPhone","tutorphone"},{"tutorAgree","tutoragree"},{"remarks","remarks"},{"addTime","addtime"},{"status","status"},{"guideUnitAgree","guideunitagree"}};
    public String[][] getAllPropertiesAndFields() {return _allPropertiesAndFields;}
    // 数据库字符集转换函数，如果是西文字符集就有意义
    public String toDbCh(String str) { return str; }
    public String fromDbCh(String str) { return str; }
    // 数据表中所有日期类型的字段
    private static final String[] _dateFields = {"ACTIVITYTIME","ADDTIME"};
    public String[] getDateFields () {return _dateFields;};
    // Id
    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    public void assignId(int aId) { id = aId; }
    public void paramId(HttpServletRequest request) { paramId(request, "Id"); }
    public void paramId(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getId()); if (tmp != getId()) { setId(tmp); } }
    // 用户账号
    protected String userAccount = "";
    public String getUserAccount() {  return SqlTool.getDbString(userAccount);  }
    public String getUserAccount(int size) { return SqlTool.subString(getUserAccount(), size); }
    public void setUserAccount(String aUserAccount) { userAccount = aUserAccount; modifiedFields.add("UserAccount"); }
    public void assignUserAccount(String aUserAccount) { userAccount = aUserAccount; }
    public void paramUserAccount(HttpServletRequest request) { paramUserAccount(request, "UserAccount"); }
    public void paramUserAccount(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUserAccount()); if (!tmp.equals(getUserAccount())) { setUserAccount(tmp); } }
    // 场地代码
    protected String placeApplycode = "";
    public String getPlaceApplycode() {  return SqlTool.getDbString(placeApplycode);  }
    public String getPlaceApplycode(int size) { return SqlTool.subString(getPlaceApplycode(), size); }
    public void setPlaceApplycode(String aPlaceApplycode) { placeApplycode = aPlaceApplycode; modifiedFields.add("PlaceApplycode"); }
    public void assignPlaceApplycode(String aPlaceApplycode) { placeApplycode = aPlaceApplycode; }
    public void paramPlaceApplycode(HttpServletRequest request) { paramPlaceApplycode(request, "PlaceApplycode"); }
    public void paramPlaceApplycode(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPlaceApplycode()); if (!tmp.equals(getPlaceApplycode())) { setPlaceApplycode(tmp); } }
    // 申请时间
    protected String applyDate = "";
    public String getApplyDate() {  return SqlTool.getDbString(applyDate);  }
    public String getApplyDate(int size) { return SqlTool.subString(getApplyDate(), size); }
    public void setApplyDate(String aApplyDate) { applyDate = aApplyDate; modifiedFields.add("ApplyDate"); }
    public void assignApplyDate(String aApplyDate) { applyDate = aApplyDate; }
    public void paramApplyDate(HttpServletRequest request) { paramApplyDate(request, "ApplyDate"); }
    public void paramApplyDate(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getApplyDate()); if (!tmp.equals(getApplyDate())) { setApplyDate(tmp); } }
    // 申请时间段
    protected String applyTimeRange = "";
    public String getApplyTimeRange() {  return SqlTool.getDbString(applyTimeRange);  }
    public String getApplyTimeRange(int size) { return SqlTool.subString(getApplyTimeRange(), size); }
    public void setApplyTimeRange(String aApplyTimeRange) { applyTimeRange = aApplyTimeRange; modifiedFields.add("ApplyTimeRange"); }
    public void assignApplyTimeRange(String aApplyTimeRange) { applyTimeRange = aApplyTimeRange; }
    public void paramApplyTimeRange(HttpServletRequest request) { paramApplyTimeRange(request, "ApplyTimeRange"); }
    public void paramApplyTimeRange(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getApplyTimeRange()); if (!tmp.equals(getApplyTimeRange())) { setApplyTimeRange(tmp); } }
    // 使用单位
    protected String applicant = "";
    public String getApplicant() {  return SqlTool.getDbString(applicant);  }
    public String getApplicant(int size) { return SqlTool.subString(getApplicant(), size); }
    public void setApplicant(String aApplicant) { applicant = aApplicant; modifiedFields.add("Applicant"); }
    public void assignApplicant(String aApplicant) { applicant = aApplicant; }
    public void paramApplicant(HttpServletRequest request) { paramApplicant(request, "Applicant"); }
    public void paramApplicant(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getApplicant()); if (!tmp.equals(getApplicant())) { setApplicant(tmp); } }
    // 活动负责人
    protected String activityPrincipal = "";
    public String getActivityPrincipal() {  return SqlTool.getDbString(activityPrincipal);  }
    public String getActivityPrincipal(int size) { return SqlTool.subString(getActivityPrincipal(), size); }
    public void setActivityPrincipal(String aActivityPrincipal) { activityPrincipal = aActivityPrincipal; modifiedFields.add("ActivityPrincipal"); }
    public void assignActivityPrincipal(String aActivityPrincipal) { activityPrincipal = aActivityPrincipal; }
    public void paramActivityPrincipal(HttpServletRequest request) { paramActivityPrincipal(request, "ActivityPrincipal"); }
    public void paramActivityPrincipal(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityPrincipal()); if (!tmp.equals(getActivityPrincipal())) { setActivityPrincipal(tmp); } }
    // 活动负责人职务
    protected String principalDuty = "";
    public String getPrincipalDuty() {  return SqlTool.getDbString(principalDuty);  }
    public String getPrincipalDuty(int size) { return SqlTool.subString(getPrincipalDuty(), size); }
    public void setPrincipalDuty(String aPrincipalDuty) { principalDuty = aPrincipalDuty; modifiedFields.add("PrincipalDuty"); }
    public void assignPrincipalDuty(String aPrincipalDuty) { principalDuty = aPrincipalDuty; }
    public void paramPrincipalDuty(HttpServletRequest request) { paramPrincipalDuty(request, "PrincipalDuty"); }
    public void paramPrincipalDuty(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPrincipalDuty()); if (!tmp.equals(getPrincipalDuty())) { setPrincipalDuty(tmp); } }
    // 活动负责人联系电话
    protected String principalPhone = "";
    public String getPrincipalPhone() {  return SqlTool.getDbString(principalPhone);  }
    public String getPrincipalPhone(int size) { return SqlTool.subString(getPrincipalPhone(), size); }
    public void setPrincipalPhone(String aPrincipalPhone) { principalPhone = aPrincipalPhone; modifiedFields.add("PrincipalPhone"); }
    public void assignPrincipalPhone(String aPrincipalPhone) { principalPhone = aPrincipalPhone; }
    public void paramPrincipalPhone(HttpServletRequest request) { paramPrincipalPhone(request, "PrincipalPhone"); }
    public void paramPrincipalPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPrincipalPhone()); if (!tmp.equals(getPrincipalPhone())) { setPrincipalPhone(tmp); } }
    // 活动时间
    protected java.util.Date activityTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getActivityTime() { return activityTime; }
    public void setActivityTime(java.util.Date aActivityTime) { activityTime = aActivityTime; modifiedFields.add("ActivityTime"); }
    public void assignActivityTime(java.util.Date aActivityTime) { activityTime = aActivityTime; }
    public void paramActivityTime(HttpServletRequest request) { paramActivityTime(request, "ActivityTime"); }
    public void paramActivityTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getActivityTime()); if (tmp.compareTo(getActivityTime()) != 0) { setActivityTime(tmp); } }
    // 布场时段
    protected String distributionPeriod = "";
    public String getDistributionPeriod() {  return SqlTool.getDbString(distributionPeriod);  }
    public String getDistributionPeriod(int size) { return SqlTool.subString(getDistributionPeriod(), size); }
    public void setDistributionPeriod(String aDistributionPeriod) { distributionPeriod = aDistributionPeriod; modifiedFields.add("DistributionPeriod"); }
    public void assignDistributionPeriod(String aDistributionPeriod) { distributionPeriod = aDistributionPeriod; }
    public void paramDistributionPeriod(HttpServletRequest request) { paramDistributionPeriod(request, "DistributionPeriod"); }
    public void paramDistributionPeriod(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getDistributionPeriod()); if (!tmp.equals(getDistributionPeriod())) { setDistributionPeriod(tmp); } }
    // 彩排时段
    protected String rehearsalPeriod = "";
    public String getRehearsalPeriod() {  return SqlTool.getDbString(rehearsalPeriod);  }
    public String getRehearsalPeriod(int size) { return SqlTool.subString(getRehearsalPeriod(), size); }
    public void setRehearsalPeriod(String aRehearsalPeriod) { rehearsalPeriod = aRehearsalPeriod; modifiedFields.add("RehearsalPeriod"); }
    public void assignRehearsalPeriod(String aRehearsalPeriod) { rehearsalPeriod = aRehearsalPeriod; }
    public void paramRehearsalPeriod(HttpServletRequest request) { paramRehearsalPeriod(request, "RehearsalPeriod"); }
    public void paramRehearsalPeriod(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRehearsalPeriod()); if (!tmp.equals(getRehearsalPeriod())) { setRehearsalPeriod(tmp); } }
    // 活动内容
    protected String activityContents = "";
    public String getActivityContents() {  return SqlTool.getDbString(activityContents);  }
    public String getActivityContents(int size) { return SqlTool.subString(getActivityContents(), size); }
    public void setActivityContents(String aActivityContents) { activityContents = aActivityContents; modifiedFields.add("ActivityContents"); }
    public void assignActivityContents(String aActivityContents) { activityContents = aActivityContents; }
    public void paramActivityContents(HttpServletRequest request) { paramActivityContents(request, "ActivityContents"); }
    public void paramActivityContents(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getActivityContents()); if (!tmp.equals(getActivityContents())) { setActivityContents(tmp); } }
    // 主讲人
    protected String speaker = "";
    public String getSpeaker() {  return SqlTool.getDbString(speaker);  }
    public String getSpeaker(int size) { return SqlTool.subString(getSpeaker(), size); }
    public void setSpeaker(String aSpeaker) { speaker = aSpeaker; modifiedFields.add("Speaker"); }
    public void assignSpeaker(String aSpeaker) { speaker = aSpeaker; }
    public void paramSpeaker(HttpServletRequest request) { paramSpeaker(request, "Speaker"); }
    public void paramSpeaker(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getSpeaker()); if (!tmp.equals(getSpeaker())) { setSpeaker(tmp); } }
    // 基本程序简介
    protected String basicProcedures = "";
    public String getBasicProcedures() {  return SqlTool.getDbString(basicProcedures);  }
    public String getBasicProcedures(int size) { return SqlTool.subString(getBasicProcedures(), size); }
    public void setBasicProcedures(String aBasicProcedures) { basicProcedures = aBasicProcedures; modifiedFields.add("BasicProcedures"); }
    public void assignBasicProcedures(String aBasicProcedures) { basicProcedures = aBasicProcedures; }
    public void paramBasicProcedures(HttpServletRequest request) { paramBasicProcedures(request, "BasicProcedures"); }
    public void paramBasicProcedures(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getBasicProcedures()); if (!tmp.equals(getBasicProcedures())) { setBasicProcedures(tmp); } }
    // 会标内容
    protected String meetingMarks = "";
    public String getMeetingMarks() {  return SqlTool.getDbString(meetingMarks);  }
    public String getMeetingMarks(int size) { return SqlTool.subString(getMeetingMarks(), size); }
    public void setMeetingMarks(String aMeetingMarks) { meetingMarks = aMeetingMarks; modifiedFields.add("MeetingMarks"); }
    public void assignMeetingMarks(String aMeetingMarks) { meetingMarks = aMeetingMarks; }
    public void paramMeetingMarks(HttpServletRequest request) { paramMeetingMarks(request, "MeetingMarks"); }
    public void paramMeetingMarks(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getMeetingMarks()); if (!tmp.equals(getMeetingMarks())) { setMeetingMarks(tmp); } }
    // 背景内容
    protected String backgroundContents = "";
    public String getBackgroundContents() {  return SqlTool.getDbString(backgroundContents);  }
    public String getBackgroundContents(int size) { return SqlTool.subString(getBackgroundContents(), size); }
    public void setBackgroundContents(String aBackgroundContents) { backgroundContents = aBackgroundContents; modifiedFields.add("BackgroundContents"); }
    public void assignBackgroundContents(String aBackgroundContents) { backgroundContents = aBackgroundContents; }
    public void paramBackgroundContents(HttpServletRequest request) { paramBackgroundContents(request, "BackgroundContents"); }
    public void paramBackgroundContents(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getBackgroundContents()); if (!tmp.equals(getBackgroundContents())) { setBackgroundContents(tmp); } }
    // 商业赞助
    protected String aponsorship = "";
    public String getAponsorship() {  return SqlTool.getDbString(aponsorship);  }
    public String getAponsorship(int size) { return SqlTool.subString(getAponsorship(), size); }
    public void setAponsorship(String aAponsorship) { aponsorship = aAponsorship; modifiedFields.add("Aponsorship"); }
    public void assignAponsorship(String aAponsorship) { aponsorship = aAponsorship; }
    public void paramAponsorship(HttpServletRequest request) { paramAponsorship(request, "Aponsorship"); }
    public void paramAponsorship(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getAponsorship()); if (!tmp.equals(getAponsorship())) { setAponsorship(tmp); } }
    // 宣传形式
    protected String propaganda = "";
    public String getPropaganda() {  return SqlTool.getDbString(propaganda);  }
    public String getPropaganda(int size) { return SqlTool.subString(getPropaganda(), size); }
    public void setPropaganda(String aPropaganda) { propaganda = aPropaganda; modifiedFields.add("Propaganda"); }
    public void assignPropaganda(String aPropaganda) { propaganda = aPropaganda; }
    public void paramPropaganda(HttpServletRequest request) { paramPropaganda(request, "Propaganda"); }
    public void paramPropaganda(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPropaganda()); if (!tmp.equals(getPropaganda())) { setPropaganda(tmp); } }
    // 会场内其他宣传形式
    protected String otherPropaganda = "";
    public String getOtherPropaganda() {  return SqlTool.getDbString(otherPropaganda);  }
    public String getOtherPropaganda(int size) { return SqlTool.subString(getOtherPropaganda(), size); }
    public void setOtherPropaganda(String aOtherPropaganda) { otherPropaganda = aOtherPropaganda; modifiedFields.add("OtherPropaganda"); }
    public void assignOtherPropaganda(String aOtherPropaganda) { otherPropaganda = aOtherPropaganda; }
    public void paramOtherPropaganda(HttpServletRequest request) { paramOtherPropaganda(request, "OtherPropaganda"); }
    public void paramOtherPropaganda(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getOtherPropaganda()); if (!tmp.equals(getOtherPropaganda())) { setOtherPropaganda(tmp); } }
    // 桌子数量
    protected int tableNums = -1;
    public int getTableNums() { return tableNums; }
    public void setTableNums(int aTableNums) { tableNums = aTableNums; modifiedFields.add("TableNums"); }
    public void assignTableNums(int aTableNums) { tableNums = aTableNums; }
    public void paramTableNums(HttpServletRequest request) { paramTableNums(request, "TableNums"); }
    public void paramTableNums(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getTableNums()); if (tmp != getTableNums()) { setTableNums(tmp); } }
    // 椅子数量
    protected int chairNums = -1;
    public int getChairNums() { return chairNums; }
    public void setChairNums(int aChairNums) { chairNums = aChairNums; modifiedFields.add("ChairNums"); }
    public void assignChairNums(int aChairNums) { chairNums = aChairNums; }
    public void paramChairNums(HttpServletRequest request) { paramChairNums(request, "ChairNums"); }
    public void paramChairNums(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getChairNums()); if (tmp != getChairNums()) { setChairNums(tmp); } }
    // 有线话筒
    protected int wiredmicroPhoneNums = -1;
    public int getWiredmicroPhoneNums() { return wiredmicroPhoneNums; }
    public void setWiredmicroPhoneNums(int aWiredmicroPhoneNums) { wiredmicroPhoneNums = aWiredmicroPhoneNums; modifiedFields.add("WiredmicroPhoneNums"); }
    public void assignWiredmicroPhoneNums(int aWiredmicroPhoneNums) { wiredmicroPhoneNums = aWiredmicroPhoneNums; }
    public void paramWiredmicroPhoneNums(HttpServletRequest request) { paramWiredmicroPhoneNums(request, "WiredmicroPhoneNums"); }
    public void paramWiredmicroPhoneNums(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getWiredmicroPhoneNums()); if (tmp != getWiredmicroPhoneNums()) { setWiredmicroPhoneNums(tmp); } }
    // 无线话筒
    protected int wirelessmicroPhoneNums = -1;
    public int getWirelessmicroPhoneNums() { return wirelessmicroPhoneNums; }
    public void setWirelessmicroPhoneNums(int aWirelessmicroPhoneNums) { wirelessmicroPhoneNums = aWirelessmicroPhoneNums; modifiedFields.add("WirelessmicroPhoneNums"); }
    public void assignWirelessmicroPhoneNums(int aWirelessmicroPhoneNums) { wirelessmicroPhoneNums = aWirelessmicroPhoneNums; }
    public void paramWirelessmicroPhoneNums(HttpServletRequest request) { paramWirelessmicroPhoneNums(request, "WirelessmicroPhoneNums"); }
    public void paramWirelessmicroPhoneNums(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getWirelessmicroPhoneNums()); if (tmp != getWirelessmicroPhoneNums()) { setWirelessmicroPhoneNums(tmp); } }
    // 话筒电池
    protected int batteryNums = -1;
    public int getBatteryNums() { return batteryNums; }
    public void setBatteryNums(int aBatteryNums) { batteryNums = aBatteryNums; modifiedFields.add("BatteryNums"); }
    public void assignBatteryNums(int aBatteryNums) { batteryNums = aBatteryNums; }
    public void paramBatteryNums(HttpServletRequest request) { paramBatteryNums(request, "BatteryNums"); }
    public void paramBatteryNums(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getBatteryNums()); if (tmp != getBatteryNums()) { setBatteryNums(tmp); } }
    // 使用发言台
    protected int useFloor = -1;
    public int getUseFloor() { return useFloor; }
    public void setUseFloor(int aUseFloor) { useFloor = aUseFloor; modifiedFields.add("UseFloor"); }
    public void assignUseFloor(int aUseFloor) { useFloor = aUseFloor; }
    public void paramUseFloor(HttpServletRequest request) { paramUseFloor(request, "UseFloor"); }
    public void paramUseFloor(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getUseFloor()); if (tmp != getUseFloor()) { setUseFloor(tmp); } }
    // 使用音响设备
    protected int useAudio = -1;
    public int getUseAudio() { return useAudio; }
    public void setUseAudio(int aUseAudio) { useAudio = aUseAudio; modifiedFields.add("UseAudio"); }
    public void assignUseAudio(int aUseAudio) { useAudio = aUseAudio; }
    public void paramUseAudio(HttpServletRequest request) { paramUseAudio(request, "UseAudio"); }
    public void paramUseAudio(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getUseAudio()); if (tmp != getUseAudio()) { setUseAudio(tmp); } }
    // 使用照明灯光
    protected int useLighting = -1;
    public int getUseLighting() { return useLighting; }
    public void setUseLighting(int aUseLighting) { useLighting = aUseLighting; modifiedFields.add("UseLighting"); }
    public void assignUseLighting(int aUseLighting) { useLighting = aUseLighting; }
    public void paramUseLighting(HttpServletRequest request) { paramUseLighting(request, "UseLighting"); }
    public void paramUseLighting(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getUseLighting()); if (tmp != getUseLighting()) { setUseLighting(tmp); } }
    // 使用舞台灯光
    protected int useStageLight = -1;
    public int getUseStageLight() { return useStageLight; }
    public void setUseStageLight(int aUseStageLight) { useStageLight = aUseStageLight; modifiedFields.add("UseStageLight"); }
    public void assignUseStageLight(int aUseStageLight) { useStageLight = aUseStageLight; }
    public void paramUseStageLight(HttpServletRequest request) { paramUseStageLight(request, "UseStageLight"); }
    public void paramUseStageLight(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getUseStageLight()); if (tmp != getUseStageLight()) { setUseStageLight(tmp); } }
    // 使用电脑灯
    protected int useComputerLight = -1;
    public int getUseComputerLight() { return useComputerLight; }
    public void setUseComputerLight(int aUseComputerLight) { useComputerLight = aUseComputerLight; modifiedFields.add("UseComputerLight"); }
    public void assignUseComputerLight(int aUseComputerLight) { useComputerLight = aUseComputerLight; }
    public void paramUseComputerLight(HttpServletRequest request) { paramUseComputerLight(request, "UseComputerLight"); }
    public void paramUseComputerLight(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getUseComputerLight()); if (tmp != getUseComputerLight()) { setUseComputerLight(tmp); } }
    // 使用投影仪
    protected int useProjector = -1;
    public int getUseProjector() { return useProjector; }
    public void setUseProjector(int aUseProjector) { useProjector = aUseProjector; modifiedFields.add("UseProjector"); }
    public void assignUseProjector(int aUseProjector) { useProjector = aUseProjector; }
    public void paramUseProjector(HttpServletRequest request) { paramUseProjector(request, "UseProjector"); }
    public void paramUseProjector(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getUseProjector()); if (tmp != getUseProjector()) { setUseProjector(tmp); } }
    // 使用空调
    protected int useAc = -1;
    public int getUseAc() { return useAc; }
    public void setUseAc(int aUseAc) { useAc = aUseAc; modifiedFields.add("UseAc"); }
    public void assignUseAc(int aUseAc) { useAc = aUseAc; }
    public void paramUseAc(HttpServletRequest request) { paramUseAc(request, "UseAc"); }
    public void paramUseAc(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getUseAc()); if (tmp != getUseAc()) { setUseAc(tmp); } }
    // 悬挂横幅
    protected int useBanner = -1;
    public int getUseBanner() { return useBanner; }
    public void setUseBanner(int aUseBanner) { useBanner = aUseBanner; modifiedFields.add("UseBanner"); }
    public void assignUseBanner(int aUseBanner) { useBanner = aUseBanner; }
    public void paramUseBanner(HttpServletRequest request) { paramUseBanner(request, "UseBanner"); }
    public void paramUseBanner(HttpServletRequest request, String name) { int tmp = ParamUtils.getIntParameter(request, name, getUseBanner()); if (tmp != getUseBanner()) { setUseBanner(tmp); } }
    // 横幅内容
    protected String bannerContent = "";
    public String getBannerContent() {  return SqlTool.getDbString(bannerContent);  }
    public String getBannerContent(int size) { return SqlTool.subString(getBannerContent(), size); }
    public void setBannerContent(String aBannerContent) { bannerContent = aBannerContent; modifiedFields.add("BannerContent"); }
    public void assignBannerContent(String aBannerContent) { bannerContent = aBannerContent; }
    public void paramBannerContent(HttpServletRequest request) { paramBannerContent(request, "BannerContent"); }
    public void paramBannerContent(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getBannerContent()); if (!tmp.equals(getBannerContent())) { setBannerContent(tmp); } }
    // 张贴海报或展板
    protected String usePoster = "";
    public String getUsePoster() {  return SqlTool.getDbString(usePoster);  }
    public String getUsePoster(int size) { return SqlTool.subString(getUsePoster(), size); }
    public void setUsePoster(String aUsePoster) { usePoster = aUsePoster; modifiedFields.add("UsePoster"); }
    public void assignUsePoster(String aUsePoster) { usePoster = aUsePoster; }
    public void paramUsePoster(HttpServletRequest request) { paramUsePoster(request, "UsePoster"); }
    public void paramUsePoster(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getUsePoster()); if (!tmp.equals(getUsePoster())) { setUsePoster(tmp); } }
    // 海报内容
    protected String posterContent = "";
    public String getPosterContent() {  return SqlTool.getDbString(posterContent);  }
    public String getPosterContent(int size) { return SqlTool.subString(getPosterContent(), size); }
    public void setPosterContent(String aPosterContent) { posterContent = aPosterContent; modifiedFields.add("PosterContent"); }
    public void assignPosterContent(String aPosterContent) { posterContent = aPosterContent; }
    public void paramPosterContent(HttpServletRequest request) { paramPosterContent(request, "PosterContent"); }
    public void paramPosterContent(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPosterContent()); if (!tmp.equals(getPosterContent())) { setPosterContent(tmp); } }
    // 参加人员车辆数量
    protected String vehicleNums = "";
    public String getVehicleNums() {  return SqlTool.getDbString(vehicleNums);  }
    public String getVehicleNums(int size) { return SqlTool.subString(getVehicleNums(), size); }
    public void setVehicleNums(String aVehicleNums) { vehicleNums = aVehicleNums; modifiedFields.add("VehicleNums"); }
    public void assignVehicleNums(String aVehicleNums) { vehicleNums = aVehicleNums; }
    public void paramVehicleNums(HttpServletRequest request) { paramVehicleNums(request, "VehicleNums"); }
    public void paramVehicleNums(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getVehicleNums()); if (!tmp.equals(getVehicleNums())) { setVehicleNums(tmp); } }
    // 承诺人
    protected String promiser = "";
    public String getPromiser() {  return SqlTool.getDbString(promiser);  }
    public String getPromiser(int size) { return SqlTool.subString(getPromiser(), size); }
    public void setPromiser(String aPromiser) { promiser = aPromiser; modifiedFields.add("Promiser"); }
    public void assignPromiser(String aPromiser) { promiser = aPromiser; }
    public void paramPromiser(HttpServletRequest request) { paramPromiser(request, "Promiser"); }
    public void paramPromiser(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPromiser()); if (!tmp.equals(getPromiser())) { setPromiser(tmp); } }
    // 承诺人联系电话
    protected String promiserPhone = "";
    public String getPromiserPhone() {  return SqlTool.getDbString(promiserPhone);  }
    public String getPromiserPhone(int size) { return SqlTool.subString(getPromiserPhone(), size); }
    public void setPromiserPhone(String aPromiserPhone) { promiserPhone = aPromiserPhone; modifiedFields.add("PromiserPhone"); }
    public void assignPromiserPhone(String aPromiserPhone) { promiserPhone = aPromiserPhone; }
    public void paramPromiserPhone(HttpServletRequest request) { paramPromiserPhone(request, "PromiserPhone"); }
    public void paramPromiserPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPromiserPhone()); if (!tmp.equals(getPromiserPhone())) { setPromiserPhone(tmp); } }
    // 承诺人学院
    protected String promiserAcadeMy = "";
    public String getPromiserAcadeMy() {  return SqlTool.getDbString(promiserAcadeMy);  }
    public String getPromiserAcadeMy(int size) { return SqlTool.subString(getPromiserAcadeMy(), size); }
    public void setPromiserAcadeMy(String aPromiserAcadeMy) { promiserAcadeMy = aPromiserAcadeMy; modifiedFields.add("PromiserAcadeMy"); }
    public void assignPromiserAcadeMy(String aPromiserAcadeMy) { promiserAcadeMy = aPromiserAcadeMy; }
    public void paramPromiserAcadeMy(HttpServletRequest request) { paramPromiserAcadeMy(request, "PromiserAcadeMy"); }
    public void paramPromiserAcadeMy(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPromiserAcadeMy()); if (!tmp.equals(getPromiserAcadeMy())) { setPromiserAcadeMy(tmp); } }
    // 承诺人班级
    protected String promiserClass = "";
    public String getPromiserClass() {  return SqlTool.getDbString(promiserClass);  }
    public String getPromiserClass(int size) { return SqlTool.subString(getPromiserClass(), size); }
    public void setPromiserClass(String aPromiserClass) { promiserClass = aPromiserClass; modifiedFields.add("PromiserClass"); }
    public void assignPromiserClass(String aPromiserClass) { promiserClass = aPromiserClass; }
    public void paramPromiserClass(HttpServletRequest request) { paramPromiserClass(request, "PromiserClass"); }
    public void paramPromiserClass(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getPromiserClass()); if (!tmp.equals(getPromiserClass())) { setPromiserClass(tmp); } }
    // 指导老师
    protected String tutor = "";
    public String getTutor() {  return SqlTool.getDbString(tutor);  }
    public String getTutor(int size) { return SqlTool.subString(getTutor(), size); }
    public void setTutor(String aTutor) { tutor = aTutor; modifiedFields.add("Tutor"); }
    public void assignTutor(String aTutor) { tutor = aTutor; }
    public void paramTutor(HttpServletRequest request) { paramTutor(request, "Tutor"); }
    public void paramTutor(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTutor()); if (!tmp.equals(getTutor())) { setTutor(tmp); } }
    // 指导老师职务
    protected String tutorDuty = "";
    public String getTutorDuty() {  return SqlTool.getDbString(tutorDuty);  }
    public String getTutorDuty(int size) { return SqlTool.subString(getTutorDuty(), size); }
    public void setTutorDuty(String aTutorDuty) { tutorDuty = aTutorDuty; modifiedFields.add("TutorDuty"); }
    public void assignTutorDuty(String aTutorDuty) { tutorDuty = aTutorDuty; }
    public void paramTutorDuty(HttpServletRequest request) { paramTutorDuty(request, "TutorDuty"); }
    public void paramTutorDuty(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTutorDuty()); if (!tmp.equals(getTutorDuty())) { setTutorDuty(tmp); } }
    // 指导老师联系方式
    protected String tutorPhone = "";
    public String getTutorPhone() {  return SqlTool.getDbString(tutorPhone);  }
    public String getTutorPhone(int size) { return SqlTool.subString(getTutorPhone(), size); }
    public void setTutorPhone(String aTutorPhone) { tutorPhone = aTutorPhone; modifiedFields.add("TutorPhone"); }
    public void assignTutorPhone(String aTutorPhone) { tutorPhone = aTutorPhone; }
    public void paramTutorPhone(HttpServletRequest request) { paramTutorPhone(request, "TutorPhone"); }
    public void paramTutorPhone(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTutorPhone()); if (!tmp.equals(getTutorPhone())) { setTutorPhone(tmp); } }
    // 指导老师意见
    protected String tutorAgree = "";
    public String getTutorAgree() {  return SqlTool.getDbString(tutorAgree);  }
    public String getTutorAgree(int size) { return SqlTool.subString(getTutorAgree(), size); }
    public void setTutorAgree(String aTutorAgree) { tutorAgree = aTutorAgree; modifiedFields.add("TutorAgree"); }
    public void assignTutorAgree(String aTutorAgree) { tutorAgree = aTutorAgree; }
    public void paramTutorAgree(HttpServletRequest request) { paramTutorAgree(request, "TutorAgree"); }
    public void paramTutorAgree(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getTutorAgree()); if (!tmp.equals(getTutorAgree())) { setTutorAgree(tmp); } }
    // 备注
    protected String remarks = "";
    public String getRemarks() {  return SqlTool.getDbString(remarks);  }
    public String getRemarks(int size) { return SqlTool.subString(getRemarks(), size); }
    public void setRemarks(String aRemarks) { remarks = aRemarks; modifiedFields.add("Remarks"); }
    public void assignRemarks(String aRemarks) { remarks = aRemarks; }
    public void paramRemarks(HttpServletRequest request) { paramRemarks(request, "Remarks"); }
    public void paramRemarks(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getRemarks()); if (!tmp.equals(getRemarks())) { setRemarks(tmp); } }
    // 添加时间
    protected java.util.Date addTime = java.sql.Date.valueOf("0001-01-01");
    public java.util.Date getAddTime() { return addTime; }
    public void setAddTime(java.util.Date aAddTime) { addTime = aAddTime; modifiedFields.add("AddTime"); }
    public void assignAddTime(java.util.Date aAddTime) { addTime = aAddTime; }
    public void paramAddTime(HttpServletRequest request) { paramAddTime(request, "AddTime"); }
    public void paramAddTime(HttpServletRequest request, String name) { java.util.Date tmp = ParamUtils.getDateTimeParameter(request, name, getAddTime()); if (tmp.compareTo(getAddTime()) != 0) { setAddTime(tmp); } }
    // 团委审核
    protected String status = "";
    public String getStatus() {  return SqlTool.getDbString(status);  }
    public String getStatus(int size) { return SqlTool.subString(getStatus(), size); }
    public void setStatus(String aStatus) { status = aStatus; modifiedFields.add("Status"); }
    public void assignStatus(String aStatus) { status = aStatus; }
    public void paramStatus(HttpServletRequest request) { paramStatus(request, "Status"); }
    public void paramStatus(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getStatus()); if (!tmp.equals(getStatus())) { setStatus(tmp); } }
    // 学院审核
    protected String guideUnitAgree = "";
    public String getGuideUnitAgree() {  return SqlTool.getDbString(guideUnitAgree);  }
    public String getGuideUnitAgree(int size) { return SqlTool.subString(getGuideUnitAgree(), size); }
    public void setGuideUnitAgree(String aGuideUnitAgree) { guideUnitAgree = aGuideUnitAgree; modifiedFields.add("GuideUnitAgree"); }
    public void assignGuideUnitAgree(String aGuideUnitAgree) { guideUnitAgree = aGuideUnitAgree; }
    public void paramGuideUnitAgree(HttpServletRequest request) { paramGuideUnitAgree(request, "GuideUnitAgree"); }
    public void paramGuideUnitAgree(HttpServletRequest request, String name) { String tmp = ParamUtils.getParameter(request, name, getGuideUnitAgree()); if (!tmp.equals(getGuideUnitAgree())) { setGuideUnitAgree(tmp); } }
    public String getFieldByProperty(String pname) {
        for (int i = 0; i < _arrayPF.length; i ++) {
            if (_arrayPF[i][0].equals(pname))
            return _arrayPF[i][1];
        }
        return "";
    }
    public Places_Applytable (String db) {
        DBNAME = db;
    }
    public Places_Applytable (String db, String tname) {
        if (db != null) {
            DBNAME = db;
        }
        if (tname != null) {
            TNAME = tname;
        }
    }
    public Places_Applytable (HttpServletRequest request) {
        UserInfo userInfo = Tool.getUserInfo(request);
        if (userInfo != null) {
            DBNAME = userInfo.getDbname();
            TNAME = userInfo.getTname(DbTableName);
        }
    }
    public Places_Applytable () {
    }
    /**
     * 提交的form中的输入域名符合bean属性名，将被赋值给对应的bean属性。
     * @param request包含从http请求提交过来的form信息
     * @return Places_Applytable类的实例，包含了从http请求获得信息放到各个对应属性中
    */
    public Places_Applytable getByParameter(HttpServletRequest request) {
        Places_Applytable v = new Places_Applytable(DBNAME, TNAME);
        v.assignParameter(request);
        return v;
    }
    public void assignParameter(HttpServletRequest request) {
        paramId(request);
        paramUserAccount(request);
        paramPlaceApplycode(request);
        paramApplyDate(request);
        paramApplyTimeRange(request);
        paramApplicant(request);
        paramActivityPrincipal(request);
        paramPrincipalDuty(request);
        paramPrincipalPhone(request);
        paramActivityTime(request);
        paramDistributionPeriod(request);
        paramRehearsalPeriod(request);
        paramActivityContents(request);
        paramSpeaker(request);
        paramBasicProcedures(request);
        paramMeetingMarks(request);
        paramBackgroundContents(request);
        paramAponsorship(request);
        paramPropaganda(request);
        paramOtherPropaganda(request);
        paramTableNums(request);
        paramChairNums(request);
        paramWiredmicroPhoneNums(request);
        paramWirelessmicroPhoneNums(request);
        paramBatteryNums(request);
        paramUseFloor(request);
        paramUseAudio(request);
        paramUseLighting(request);
        paramUseStageLight(request);
        paramUseComputerLight(request);
        paramUseProjector(request);
        paramUseAc(request);
        paramUseBanner(request);
        paramBannerContent(request);
        paramUsePoster(request);
        paramPosterContent(request);
        paramVehicleNums(request);
        paramPromiser(request);
        paramPromiserPhone(request);
        paramPromiserAcadeMy(request);
        paramPromiserClass(request);
        paramTutor(request);
        paramTutorDuty(request);
        paramTutorPhone(request);
        paramTutorAgree(request);
        paramRemarks(request);
        paramAddTime(request);
        paramStatus(request);
        paramGuideUnitAgree(request);
    }
    /**
     * 将参数中类的实例数据复制到当前的类实例，noChangeList中包含属性名将不被复制。
    */
    public void clone(Places_Applytable bean) {
        List ncl = Arrays.asList(noChangeList);
        if (!ncl.contains("id")) { setId(bean.getId()); }
        if (!ncl.contains("userAccount")) { setUserAccount(bean.getUserAccount()); }
        if (!ncl.contains("placeApplycode")) { setPlaceApplycode(bean.getPlaceApplycode()); }
        if (!ncl.contains("applyDate")) { setApplyDate(bean.getApplyDate()); }
        if (!ncl.contains("applyTimeRange")) { setApplyTimeRange(bean.getApplyTimeRange()); }
        if (!ncl.contains("applicant")) { setApplicant(bean.getApplicant()); }
        if (!ncl.contains("activityPrincipal")) { setActivityPrincipal(bean.getActivityPrincipal()); }
        if (!ncl.contains("principalDuty")) { setPrincipalDuty(bean.getPrincipalDuty()); }
        if (!ncl.contains("principalPhone")) { setPrincipalPhone(bean.getPrincipalPhone()); }
        if (!ncl.contains("activityTime")) { setActivityTime(bean.getActivityTime()); }
        if (!ncl.contains("distributionPeriod")) { setDistributionPeriod(bean.getDistributionPeriod()); }
        if (!ncl.contains("rehearsalPeriod")) { setRehearsalPeriod(bean.getRehearsalPeriod()); }
        if (!ncl.contains("activityContents")) { setActivityContents(bean.getActivityContents()); }
        if (!ncl.contains("speaker")) { setSpeaker(bean.getSpeaker()); }
        if (!ncl.contains("basicProcedures")) { setBasicProcedures(bean.getBasicProcedures()); }
        if (!ncl.contains("meetingMarks")) { setMeetingMarks(bean.getMeetingMarks()); }
        if (!ncl.contains("backgroundContents")) { setBackgroundContents(bean.getBackgroundContents()); }
        if (!ncl.contains("aponsorship")) { setAponsorship(bean.getAponsorship()); }
        if (!ncl.contains("propaganda")) { setPropaganda(bean.getPropaganda()); }
        if (!ncl.contains("otherPropaganda")) { setOtherPropaganda(bean.getOtherPropaganda()); }
        if (!ncl.contains("tableNums")) { setTableNums(bean.getTableNums()); }
        if (!ncl.contains("chairNums")) { setChairNums(bean.getChairNums()); }
        if (!ncl.contains("wiredmicroPhoneNums")) { setWiredmicroPhoneNums(bean.getWiredmicroPhoneNums()); }
        if (!ncl.contains("wirelessmicroPhoneNums")) { setWirelessmicroPhoneNums(bean.getWirelessmicroPhoneNums()); }
        if (!ncl.contains("batteryNums")) { setBatteryNums(bean.getBatteryNums()); }
        if (!ncl.contains("useFloor")) { setUseFloor(bean.getUseFloor()); }
        if (!ncl.contains("useAudio")) { setUseAudio(bean.getUseAudio()); }
        if (!ncl.contains("useLighting")) { setUseLighting(bean.getUseLighting()); }
        if (!ncl.contains("useStageLight")) { setUseStageLight(bean.getUseStageLight()); }
        if (!ncl.contains("useComputerLight")) { setUseComputerLight(bean.getUseComputerLight()); }
        if (!ncl.contains("useProjector")) { setUseProjector(bean.getUseProjector()); }
        if (!ncl.contains("useAc")) { setUseAc(bean.getUseAc()); }
        if (!ncl.contains("useBanner")) { setUseBanner(bean.getUseBanner()); }
        if (!ncl.contains("bannerContent")) { setBannerContent(bean.getBannerContent()); }
        if (!ncl.contains("usePoster")) { setUsePoster(bean.getUsePoster()); }
        if (!ncl.contains("posterContent")) { setPosterContent(bean.getPosterContent()); }
        if (!ncl.contains("vehicleNums")) { setVehicleNums(bean.getVehicleNums()); }
        if (!ncl.contains("promiser")) { setPromiser(bean.getPromiser()); }
        if (!ncl.contains("promiserPhone")) { setPromiserPhone(bean.getPromiserPhone()); }
        if (!ncl.contains("promiserAcadeMy")) { setPromiserAcadeMy(bean.getPromiserAcadeMy()); }
        if (!ncl.contains("promiserClass")) { setPromiserClass(bean.getPromiserClass()); }
        if (!ncl.contains("tutor")) { setTutor(bean.getTutor()); }
        if (!ncl.contains("tutorDuty")) { setTutorDuty(bean.getTutorDuty()); }
        if (!ncl.contains("tutorPhone")) { setTutorPhone(bean.getTutorPhone()); }
        if (!ncl.contains("tutorAgree")) { setTutorAgree(bean.getTutorAgree()); }
        if (!ncl.contains("remarks")) { setRemarks(bean.getRemarks()); }
        if (!ncl.contains("addTime")) { setAddTime(bean.getAddTime()); }
        if (!ncl.contains("status")) { setStatus(bean.getStatus()); }
        if (!ncl.contains("guideUnitAgree")) { setGuideUnitAgree(bean.getGuideUnitAgree()); }
    }
    public Places_Applytable getById(int aId) {
        List cdt = new ArrayList();
        cdt.add("id=" + aId);
        Places_Applytable[] rslt= queryByCondition(cdt);
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
     * @return Places_Applytable类的实例列表。
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
                Places_Applytable ve = new Places_Applytable(DBNAME, TNAME);
                ve.assignId(rs.getInt(1));
                ve.assignUserAccount(fromDbCh(rs.getString(2)));
                ve.assignPlaceApplycode(fromDbCh(rs.getString(3)));
                ve.assignApplyDate(fromDbCh(rs.getString(4)));
                ve.assignApplyTimeRange(fromDbCh(rs.getString(5)));
                ve.assignApplicant(fromDbCh(rs.getString(6)));
                ve.assignActivityPrincipal(fromDbCh(rs.getString(7)));
                ve.assignPrincipalDuty(fromDbCh(rs.getString(8)));
                ve.assignPrincipalPhone(fromDbCh(rs.getString(9)));
                tmpDate = rs.getTimestamp(10); if (tmpDate != null) { ve.assignActivityTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignDistributionPeriod(fromDbCh(rs.getString(11)));
                ve.assignRehearsalPeriod(fromDbCh(rs.getString(12)));
                ve.assignActivityContents(fromDbCh(rs.getString(13)));
                ve.assignSpeaker(fromDbCh(rs.getString(14)));
                ve.assignBasicProcedures(fromDbCh(rs.getString(15)));
                ve.assignMeetingMarks(fromDbCh(rs.getString(16)));
                ve.assignBackgroundContents(fromDbCh(rs.getString(17)));
                ve.assignAponsorship(fromDbCh(rs.getString(18)));
                ve.assignPropaganda(fromDbCh(rs.getString(19)));
                ve.assignOtherPropaganda(fromDbCh(rs.getString(20)));
                ve.assignTableNums(rs.getInt(21));
                ve.assignChairNums(rs.getInt(22));
                ve.assignWiredmicroPhoneNums(rs.getInt(23));
                ve.assignWirelessmicroPhoneNums(rs.getInt(24));
                ve.assignBatteryNums(rs.getInt(25));
                ve.assignUseFloor(rs.getInt(26));
                ve.assignUseAudio(rs.getInt(27));
                ve.assignUseLighting(rs.getInt(28));
                ve.assignUseStageLight(rs.getInt(29));
                ve.assignUseComputerLight(rs.getInt(30));
                ve.assignUseProjector(rs.getInt(31));
                ve.assignUseAc(rs.getInt(32));
                ve.assignUseBanner(rs.getInt(33));
                ve.assignBannerContent(fromDbCh(rs.getString(34)));
                ve.assignUsePoster(fromDbCh(rs.getString(35)));
                ve.assignPosterContent(fromDbCh(rs.getString(36)));
                ve.assignVehicleNums(fromDbCh(rs.getString(37)));
                ve.assignPromiser(fromDbCh(rs.getString(38)));
                ve.assignPromiserPhone(fromDbCh(rs.getString(39)));
                ve.assignPromiserAcadeMy(fromDbCh(rs.getString(40)));
                ve.assignPromiserClass(fromDbCh(rs.getString(41)));
                ve.assignTutor(fromDbCh(rs.getString(42)));
                ve.assignTutorDuty(fromDbCh(rs.getString(43)));
                ve.assignTutorPhone(fromDbCh(rs.getString(44)));
                ve.assignTutorAgree(fromDbCh(rs.getString(45)));
                ve.assignRemarks(fromDbCh(rs.getString(46)));
                tmpDate = rs.getTimestamp(47); if (tmpDate != null) { ve.assignAddTime(new java.util.Date(tmpDate.getTime())); }
                ve.assignStatus(fromDbCh(rs.getString(48)));
                ve.assignGuideUnitAgree(fromDbCh(rs.getString(49)));
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
    public Places_Applytable[] queryByCondition(List cdt) {
        List vrs = query(cdt);
        return (Places_Applytable[])vrs.toArray(new Places_Applytable[vrs.size()]);
    }
    public Places_Applytable[] queryByCondition(Connection con, List cdt) {
        List vrs = query(con, cdt);
        return (Places_Applytable[])vrs.toArray(new Places_Applytable[vrs.size()]);
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (useraccount,placeapplycode,applydate,applytimerange,applicant,activityprincipal,principalduty,principalphone,activitytime,distributionperiod,rehearsalperiod,activitycontents,speaker,basicprocedures,meetingmarks,backgroundcontents,aponsorship,propaganda,otherpropaganda,tablenums,chairnums,wiredmicrophonenums,wirelessmicrophonenums,batterynums,usefloor,useaudio,uselighting,usestagelight,usecomputerlight,useprojector,useac,usebanner,bannercontent,useposter,postercontent,vehiclenums,promiser,promiserphone,promiseracademy,promiserclass,tutor,tutorduty,tutorphone,tutoragree,remarks,addtime,status,guideunitagree) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String SELECT = "select last_insert_id() as id from " + getDBNAME() + " limit 1";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setString(1, toDbCh(userAccount));
            pstmt.setString(2, toDbCh(placeApplycode));
            pstmt.setString(3, toDbCh(applyDate));
            pstmt.setString(4, toDbCh(applyTimeRange));
            pstmt.setString(5, toDbCh(applicant));
            pstmt.setString(6, toDbCh(activityPrincipal));
            pstmt.setString(7, toDbCh(principalDuty));
            pstmt.setString(8, toDbCh(principalPhone));
            pstmt.setTimestamp(9, new java.sql.Timestamp(activityTime.getTime()));
            pstmt.setString(10, toDbCh(distributionPeriod));
            pstmt.setString(11, toDbCh(rehearsalPeriod));
            pstmt.setString(12, toDbCh(activityContents));
            pstmt.setString(13, toDbCh(speaker));
            pstmt.setString(14, toDbCh(basicProcedures));
            pstmt.setString(15, toDbCh(meetingMarks));
            pstmt.setString(16, toDbCh(backgroundContents));
            pstmt.setString(17, toDbCh(aponsorship));
            pstmt.setString(18, toDbCh(propaganda));
            pstmt.setString(19, toDbCh(otherPropaganda));
            pstmt.setInt(20, tableNums);
            pstmt.setInt(21, chairNums);
            pstmt.setInt(22, wiredmicroPhoneNums);
            pstmt.setInt(23, wirelessmicroPhoneNums);
            pstmt.setInt(24, batteryNums);
            pstmt.setInt(25, useFloor);
            pstmt.setInt(26, useAudio);
            pstmt.setInt(27, useLighting);
            pstmt.setInt(28, useStageLight);
            pstmt.setInt(29, useComputerLight);
            pstmt.setInt(30, useProjector);
            pstmt.setInt(31, useAc);
            pstmt.setInt(32, useBanner);
            pstmt.setString(33, toDbCh(bannerContent));
            pstmt.setString(34, toDbCh(usePoster));
            pstmt.setString(35, toDbCh(posterContent));
            pstmt.setString(36, toDbCh(vehicleNums));
            pstmt.setString(37, toDbCh(promiser));
            pstmt.setString(38, toDbCh(promiserPhone));
            pstmt.setString(39, toDbCh(promiserAcadeMy));
            pstmt.setString(40, toDbCh(promiserClass));
            pstmt.setString(41, toDbCh(tutor));
            pstmt.setString(42, toDbCh(tutorDuty));
            pstmt.setString(43, toDbCh(tutorPhone));
            pstmt.setString(44, toDbCh(tutorAgree));
            pstmt.setString(45, toDbCh(remarks));
            pstmt.setTimestamp(46, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(47, toDbCh(status));
            pstmt.setString(48, toDbCh(guideUnitAgree));
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
        String INSERT = "INSERT INTO " + getDBNAME() + " (id,useraccount,placeapplycode,applydate,applytimerange,applicant,activityprincipal,principalduty,principalphone,activitytime,distributionperiod,rehearsalperiod,activitycontents,speaker,basicprocedures,meetingmarks,backgroundcontents,aponsorship,propaganda,otherpropaganda,tablenums,chairnums,wiredmicrophonenums,wirelessmicrophonenums,batterynums,usefloor,useaudio,uselighting,usestagelight,usecomputerlight,useprojector,useac,usebanner,bannercontent,useposter,postercontent,vehiclenums,promiser,promiserphone,promiseracademy,promiserclass,tutor,tutorduty,tutorphone,tutoragree,remarks,addtime,status,guideunitagree) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int iResult = -1;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(INSERT);
            stmt = con.createStatement();
            pstmt.setInt(1, id);
            pstmt.setString(2, toDbCh(userAccount));
            pstmt.setString(3, toDbCh(placeApplycode));
            pstmt.setString(4, toDbCh(applyDate));
            pstmt.setString(5, toDbCh(applyTimeRange));
            pstmt.setString(6, toDbCh(applicant));
            pstmt.setString(7, toDbCh(activityPrincipal));
            pstmt.setString(8, toDbCh(principalDuty));
            pstmt.setString(9, toDbCh(principalPhone));
            pstmt.setTimestamp(10, new java.sql.Timestamp(activityTime.getTime()));
            pstmt.setString(11, toDbCh(distributionPeriod));
            pstmt.setString(12, toDbCh(rehearsalPeriod));
            pstmt.setString(13, toDbCh(activityContents));
            pstmt.setString(14, toDbCh(speaker));
            pstmt.setString(15, toDbCh(basicProcedures));
            pstmt.setString(16, toDbCh(meetingMarks));
            pstmt.setString(17, toDbCh(backgroundContents));
            pstmt.setString(18, toDbCh(aponsorship));
            pstmt.setString(19, toDbCh(propaganda));
            pstmt.setString(20, toDbCh(otherPropaganda));
            pstmt.setInt(21, tableNums);
            pstmt.setInt(22, chairNums);
            pstmt.setInt(23, wiredmicroPhoneNums);
            pstmt.setInt(24, wirelessmicroPhoneNums);
            pstmt.setInt(25, batteryNums);
            pstmt.setInt(26, useFloor);
            pstmt.setInt(27, useAudio);
            pstmt.setInt(28, useLighting);
            pstmt.setInt(29, useStageLight);
            pstmt.setInt(30, useComputerLight);
            pstmt.setInt(31, useProjector);
            pstmt.setInt(32, useAc);
            pstmt.setInt(33, useBanner);
            pstmt.setString(34, toDbCh(bannerContent));
            pstmt.setString(35, toDbCh(usePoster));
            pstmt.setString(36, toDbCh(posterContent));
            pstmt.setString(37, toDbCh(vehicleNums));
            pstmt.setString(38, toDbCh(promiser));
            pstmt.setString(39, toDbCh(promiserPhone));
            pstmt.setString(40, toDbCh(promiserAcadeMy));
            pstmt.setString(41, toDbCh(promiserClass));
            pstmt.setString(42, toDbCh(tutor));
            pstmt.setString(43, toDbCh(tutorDuty));
            pstmt.setString(44, toDbCh(tutorPhone));
            pstmt.setString(45, toDbCh(tutorAgree));
            pstmt.setString(46, toDbCh(remarks));
            pstmt.setTimestamp(47, new java.sql.Timestamp(addTime.getTime()));
            pstmt.setString(48, toDbCh(status));
            pstmt.setString(49, toDbCh(guideUnitAgree));
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
            Places_Applytable item = (Places_Applytable)it.next();
            Places_Applytable v = new Places_Applytable(dbname);
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
                if (modifiedFields.contains("UserAccount")) { pstmt.setString(pi ++, toDbCh(userAccount)); }
                if (modifiedFields.contains("PlaceApplycode")) { pstmt.setString(pi ++, toDbCh(placeApplycode)); }
                if (modifiedFields.contains("ApplyDate")) { pstmt.setString(pi ++, toDbCh(applyDate)); }
                if (modifiedFields.contains("ApplyTimeRange")) { pstmt.setString(pi ++, toDbCh(applyTimeRange)); }
                if (modifiedFields.contains("Applicant")) { pstmt.setString(pi ++, toDbCh(applicant)); }
                if (modifiedFields.contains("ActivityPrincipal")) { pstmt.setString(pi ++, toDbCh(activityPrincipal)); }
                if (modifiedFields.contains("PrincipalDuty")) { pstmt.setString(pi ++, toDbCh(principalDuty)); }
                if (modifiedFields.contains("PrincipalPhone")) { pstmt.setString(pi ++, toDbCh(principalPhone)); }
                if (modifiedFields.contains("ActivityTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(activityTime.getTime())); }
                if (modifiedFields.contains("DistributionPeriod")) { pstmt.setString(pi ++, toDbCh(distributionPeriod)); }
                if (modifiedFields.contains("RehearsalPeriod")) { pstmt.setString(pi ++, toDbCh(rehearsalPeriod)); }
                if (modifiedFields.contains("ActivityContents")) { pstmt.setString(pi ++, toDbCh(activityContents)); }
                if (modifiedFields.contains("Speaker")) { pstmt.setString(pi ++, toDbCh(speaker)); }
                if (modifiedFields.contains("BasicProcedures")) { pstmt.setString(pi ++, toDbCh(basicProcedures)); }
                if (modifiedFields.contains("MeetingMarks")) { pstmt.setString(pi ++, toDbCh(meetingMarks)); }
                if (modifiedFields.contains("BackgroundContents")) { pstmt.setString(pi ++, toDbCh(backgroundContents)); }
                if (modifiedFields.contains("Aponsorship")) { pstmt.setString(pi ++, toDbCh(aponsorship)); }
                if (modifiedFields.contains("Propaganda")) { pstmt.setString(pi ++, toDbCh(propaganda)); }
                if (modifiedFields.contains("OtherPropaganda")) { pstmt.setString(pi ++, toDbCh(otherPropaganda)); }
                if (modifiedFields.contains("TableNums")) { pstmt.setInt(pi ++, tableNums); }
                if (modifiedFields.contains("ChairNums")) { pstmt.setInt(pi ++, chairNums); }
                if (modifiedFields.contains("WiredmicroPhoneNums")) { pstmt.setInt(pi ++, wiredmicroPhoneNums); }
                if (modifiedFields.contains("WirelessmicroPhoneNums")) { pstmt.setInt(pi ++, wirelessmicroPhoneNums); }
                if (modifiedFields.contains("BatteryNums")) { pstmt.setInt(pi ++, batteryNums); }
                if (modifiedFields.contains("UseFloor")) { pstmt.setInt(pi ++, useFloor); }
                if (modifiedFields.contains("UseAudio")) { pstmt.setInt(pi ++, useAudio); }
                if (modifiedFields.contains("UseLighting")) { pstmt.setInt(pi ++, useLighting); }
                if (modifiedFields.contains("UseStageLight")) { pstmt.setInt(pi ++, useStageLight); }
                if (modifiedFields.contains("UseComputerLight")) { pstmt.setInt(pi ++, useComputerLight); }
                if (modifiedFields.contains("UseProjector")) { pstmt.setInt(pi ++, useProjector); }
                if (modifiedFields.contains("UseAc")) { pstmt.setInt(pi ++, useAc); }
                if (modifiedFields.contains("UseBanner")) { pstmt.setInt(pi ++, useBanner); }
                if (modifiedFields.contains("BannerContent")) { pstmt.setString(pi ++, toDbCh(bannerContent)); }
                if (modifiedFields.contains("UsePoster")) { pstmt.setString(pi ++, toDbCh(usePoster)); }
                if (modifiedFields.contains("PosterContent")) { pstmt.setString(pi ++, toDbCh(posterContent)); }
                if (modifiedFields.contains("VehicleNums")) { pstmt.setString(pi ++, toDbCh(vehicleNums)); }
                if (modifiedFields.contains("Promiser")) { pstmt.setString(pi ++, toDbCh(promiser)); }
                if (modifiedFields.contains("PromiserPhone")) { pstmt.setString(pi ++, toDbCh(promiserPhone)); }
                if (modifiedFields.contains("PromiserAcadeMy")) { pstmt.setString(pi ++, toDbCh(promiserAcadeMy)); }
                if (modifiedFields.contains("PromiserClass")) { pstmt.setString(pi ++, toDbCh(promiserClass)); }
                if (modifiedFields.contains("Tutor")) { pstmt.setString(pi ++, toDbCh(tutor)); }
                if (modifiedFields.contains("TutorDuty")) { pstmt.setString(pi ++, toDbCh(tutorDuty)); }
                if (modifiedFields.contains("TutorPhone")) { pstmt.setString(pi ++, toDbCh(tutorPhone)); }
                if (modifiedFields.contains("TutorAgree")) { pstmt.setString(pi ++, toDbCh(tutorAgree)); }
                if (modifiedFields.contains("Remarks")) { pstmt.setString(pi ++, toDbCh(remarks)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("Status")) { pstmt.setString(pi ++, toDbCh(status)); }
                if (modifiedFields.contains("GuideUnitAgree")) { pstmt.setString(pi ++, toDbCh(guideUnitAgree)); }
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
                if (modifiedFields.contains("UserAccount")) { pstmt.setString(pi ++, toDbCh(userAccount)); }
                if (modifiedFields.contains("PlaceApplycode")) { pstmt.setString(pi ++, toDbCh(placeApplycode)); }
                if (modifiedFields.contains("ApplyDate")) { pstmt.setString(pi ++, toDbCh(applyDate)); }
                if (modifiedFields.contains("ApplyTimeRange")) { pstmt.setString(pi ++, toDbCh(applyTimeRange)); }
                if (modifiedFields.contains("Applicant")) { pstmt.setString(pi ++, toDbCh(applicant)); }
                if (modifiedFields.contains("ActivityPrincipal")) { pstmt.setString(pi ++, toDbCh(activityPrincipal)); }
                if (modifiedFields.contains("PrincipalDuty")) { pstmt.setString(pi ++, toDbCh(principalDuty)); }
                if (modifiedFields.contains("PrincipalPhone")) { pstmt.setString(pi ++, toDbCh(principalPhone)); }
                if (modifiedFields.contains("ActivityTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(activityTime.getTime())); }
                if (modifiedFields.contains("DistributionPeriod")) { pstmt.setString(pi ++, toDbCh(distributionPeriod)); }
                if (modifiedFields.contains("RehearsalPeriod")) { pstmt.setString(pi ++, toDbCh(rehearsalPeriod)); }
                if (modifiedFields.contains("ActivityContents")) { pstmt.setString(pi ++, toDbCh(activityContents)); }
                if (modifiedFields.contains("Speaker")) { pstmt.setString(pi ++, toDbCh(speaker)); }
                if (modifiedFields.contains("BasicProcedures")) { pstmt.setString(pi ++, toDbCh(basicProcedures)); }
                if (modifiedFields.contains("MeetingMarks")) { pstmt.setString(pi ++, toDbCh(meetingMarks)); }
                if (modifiedFields.contains("BackgroundContents")) { pstmt.setString(pi ++, toDbCh(backgroundContents)); }
                if (modifiedFields.contains("Aponsorship")) { pstmt.setString(pi ++, toDbCh(aponsorship)); }
                if (modifiedFields.contains("Propaganda")) { pstmt.setString(pi ++, toDbCh(propaganda)); }
                if (modifiedFields.contains("OtherPropaganda")) { pstmt.setString(pi ++, toDbCh(otherPropaganda)); }
                if (modifiedFields.contains("TableNums")) { pstmt.setInt(pi ++, tableNums); }
                if (modifiedFields.contains("ChairNums")) { pstmt.setInt(pi ++, chairNums); }
                if (modifiedFields.contains("WiredmicroPhoneNums")) { pstmt.setInt(pi ++, wiredmicroPhoneNums); }
                if (modifiedFields.contains("WirelessmicroPhoneNums")) { pstmt.setInt(pi ++, wirelessmicroPhoneNums); }
                if (modifiedFields.contains("BatteryNums")) { pstmt.setInt(pi ++, batteryNums); }
                if (modifiedFields.contains("UseFloor")) { pstmt.setInt(pi ++, useFloor); }
                if (modifiedFields.contains("UseAudio")) { pstmt.setInt(pi ++, useAudio); }
                if (modifiedFields.contains("UseLighting")) { pstmt.setInt(pi ++, useLighting); }
                if (modifiedFields.contains("UseStageLight")) { pstmt.setInt(pi ++, useStageLight); }
                if (modifiedFields.contains("UseComputerLight")) { pstmt.setInt(pi ++, useComputerLight); }
                if (modifiedFields.contains("UseProjector")) { pstmt.setInt(pi ++, useProjector); }
                if (modifiedFields.contains("UseAc")) { pstmt.setInt(pi ++, useAc); }
                if (modifiedFields.contains("UseBanner")) { pstmt.setInt(pi ++, useBanner); }
                if (modifiedFields.contains("BannerContent")) { pstmt.setString(pi ++, toDbCh(bannerContent)); }
                if (modifiedFields.contains("UsePoster")) { pstmt.setString(pi ++, toDbCh(usePoster)); }
                if (modifiedFields.contains("PosterContent")) { pstmt.setString(pi ++, toDbCh(posterContent)); }
                if (modifiedFields.contains("VehicleNums")) { pstmt.setString(pi ++, toDbCh(vehicleNums)); }
                if (modifiedFields.contains("Promiser")) { pstmt.setString(pi ++, toDbCh(promiser)); }
                if (modifiedFields.contains("PromiserPhone")) { pstmt.setString(pi ++, toDbCh(promiserPhone)); }
                if (modifiedFields.contains("PromiserAcadeMy")) { pstmt.setString(pi ++, toDbCh(promiserAcadeMy)); }
                if (modifiedFields.contains("PromiserClass")) { pstmt.setString(pi ++, toDbCh(promiserClass)); }
                if (modifiedFields.contains("Tutor")) { pstmt.setString(pi ++, toDbCh(tutor)); }
                if (modifiedFields.contains("TutorDuty")) { pstmt.setString(pi ++, toDbCh(tutorDuty)); }
                if (modifiedFields.contains("TutorPhone")) { pstmt.setString(pi ++, toDbCh(tutorPhone)); }
                if (modifiedFields.contains("TutorAgree")) { pstmt.setString(pi ++, toDbCh(tutorAgree)); }
                if (modifiedFields.contains("Remarks")) { pstmt.setString(pi ++, toDbCh(remarks)); }
                if (modifiedFields.contains("AddTime")) { pstmt.setTimestamp(pi ++, new java.sql.Timestamp(addTime.getTime())); }
                if (modifiedFields.contains("Status")) { pstmt.setString(pi ++, toDbCh(status)); }
                if (modifiedFields.contains("GuideUnitAgree")) { pstmt.setString(pi ++, toDbCh(guideUnitAgree)); }
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
        map.put("UserAccount", getUserAccount());
        map.put("PlaceApplycode", getPlaceApplycode());
        map.put("ApplyDate", getApplyDate());
        map.put("ApplyTimeRange", getApplyTimeRange());
        map.put("Applicant", getApplicant());
        map.put("ActivityPrincipal", getActivityPrincipal());
        map.put("PrincipalDuty", getPrincipalDuty());
        map.put("PrincipalPhone", getPrincipalPhone());
        map.put("ActivityTime", Tool.stringOfDateTime(getActivityTime()));
        map.put("DistributionPeriod", getDistributionPeriod());
        map.put("RehearsalPeriod", getRehearsalPeriod());
        map.put("ActivityContents", getActivityContents());
        map.put("Speaker", getSpeaker());
        map.put("BasicProcedures", getBasicProcedures());
        map.put("MeetingMarks", getMeetingMarks());
        map.put("BackgroundContents", getBackgroundContents());
        map.put("Aponsorship", getAponsorship());
        map.put("Propaganda", getPropaganda());
        map.put("OtherPropaganda", getOtherPropaganda());
        map.put("TableNums", getTableNums() + "");
        map.put("ChairNums", getChairNums() + "");
        map.put("WiredmicroPhoneNums", getWiredmicroPhoneNums() + "");
        map.put("WirelessmicroPhoneNums", getWirelessmicroPhoneNums() + "");
        map.put("BatteryNums", getBatteryNums() + "");
        map.put("UseFloor", getUseFloor() + "");
        map.put("UseAudio", getUseAudio() + "");
        map.put("UseLighting", getUseLighting() + "");
        map.put("UseStageLight", getUseStageLight() + "");
        map.put("UseComputerLight", getUseComputerLight() + "");
        map.put("UseProjector", getUseProjector() + "");
        map.put("UseAc", getUseAc() + "");
        map.put("UseBanner", getUseBanner() + "");
        map.put("BannerContent", getBannerContent());
        map.put("UsePoster", getUsePoster());
        map.put("PosterContent", getPosterContent());
        map.put("VehicleNums", getVehicleNums());
        map.put("Promiser", getPromiser());
        map.put("PromiserPhone", getPromiserPhone());
        map.put("PromiserAcadeMy", getPromiserAcadeMy());
        map.put("PromiserClass", getPromiserClass());
        map.put("Tutor", getTutor());
        map.put("TutorDuty", getTutorDuty());
        map.put("TutorPhone", getTutorPhone());
        map.put("TutorAgree", getTutorAgree());
        map.put("Remarks", getRemarks());
        map.put("AddTime", Tool.stringOfDateTime(getAddTime()));
        map.put("Status", getStatus());
        map.put("GuideUnitAgree", getGuideUnitAgree());
        return map;
    }
    public String toJsMap() {
        List row = new ArrayList();
        row.add("Id:\"" + getId() + "\"");
        row.add("UserAccount:\"" + Tool.jsSpecialChars(getUserAccount()) + "\"");
        row.add("PlaceApplycode:\"" + Tool.jsSpecialChars(getPlaceApplycode()) + "\"");
        row.add("ApplyDate:\"" + Tool.jsSpecialChars(getApplyDate()) + "\"");
        row.add("ApplyTimeRange:\"" + Tool.jsSpecialChars(getApplyTimeRange()) + "\"");
        row.add("Applicant:\"" + Tool.jsSpecialChars(getApplicant()) + "\"");
        row.add("ActivityPrincipal:\"" + Tool.jsSpecialChars(getActivityPrincipal()) + "\"");
        row.add("PrincipalDuty:\"" + Tool.jsSpecialChars(getPrincipalDuty()) + "\"");
        row.add("PrincipalPhone:\"" + Tool.jsSpecialChars(getPrincipalPhone()) + "\"");
        row.add("ActivityTime:\"" + Tool.stringOfDateTime(getActivityTime()) + "\"");
        row.add("DistributionPeriod:\"" + Tool.jsSpecialChars(getDistributionPeriod()) + "\"");
        row.add("RehearsalPeriod:\"" + Tool.jsSpecialChars(getRehearsalPeriod()) + "\"");
        row.add("ActivityContents:\"" + Tool.jsSpecialChars(getActivityContents()) + "\"");
        row.add("Speaker:\"" + Tool.jsSpecialChars(getSpeaker()) + "\"");
        row.add("BasicProcedures:\"" + Tool.jsSpecialChars(getBasicProcedures()) + "\"");
        row.add("MeetingMarks:\"" + Tool.jsSpecialChars(getMeetingMarks()) + "\"");
        row.add("BackgroundContents:\"" + Tool.jsSpecialChars(getBackgroundContents()) + "\"");
        row.add("Aponsorship:\"" + Tool.jsSpecialChars(getAponsorship()) + "\"");
        row.add("Propaganda:\"" + Tool.jsSpecialChars(getPropaganda()) + "\"");
        row.add("OtherPropaganda:\"" + Tool.jsSpecialChars(getOtherPropaganda()) + "\"");
        row.add("TableNums:\"" + getTableNums() + "\"");
        row.add("ChairNums:\"" + getChairNums() + "\"");
        row.add("WiredmicroPhoneNums:\"" + getWiredmicroPhoneNums() + "\"");
        row.add("WirelessmicroPhoneNums:\"" + getWirelessmicroPhoneNums() + "\"");
        row.add("BatteryNums:\"" + getBatteryNums() + "\"");
        row.add("UseFloor:\"" + getUseFloor() + "\"");
        row.add("UseAudio:\"" + getUseAudio() + "\"");
        row.add("UseLighting:\"" + getUseLighting() + "\"");
        row.add("UseStageLight:\"" + getUseStageLight() + "\"");
        row.add("UseComputerLight:\"" + getUseComputerLight() + "\"");
        row.add("UseProjector:\"" + getUseProjector() + "\"");
        row.add("UseAc:\"" + getUseAc() + "\"");
        row.add("UseBanner:\"" + getUseBanner() + "\"");
        row.add("BannerContent:\"" + Tool.jsSpecialChars(getBannerContent()) + "\"");
        row.add("UsePoster:\"" + Tool.jsSpecialChars(getUsePoster()) + "\"");
        row.add("PosterContent:\"" + Tool.jsSpecialChars(getPosterContent()) + "\"");
        row.add("VehicleNums:\"" + Tool.jsSpecialChars(getVehicleNums()) + "\"");
        row.add("Promiser:\"" + Tool.jsSpecialChars(getPromiser()) + "\"");
        row.add("PromiserPhone:\"" + Tool.jsSpecialChars(getPromiserPhone()) + "\"");
        row.add("PromiserAcadeMy:\"" + Tool.jsSpecialChars(getPromiserAcadeMy()) + "\"");
        row.add("PromiserClass:\"" + Tool.jsSpecialChars(getPromiserClass()) + "\"");
        row.add("Tutor:\"" + Tool.jsSpecialChars(getTutor()) + "\"");
        row.add("TutorDuty:\"" + Tool.jsSpecialChars(getTutorDuty()) + "\"");
        row.add("TutorPhone:\"" + Tool.jsSpecialChars(getTutorPhone()) + "\"");
        row.add("TutorAgree:\"" + Tool.jsSpecialChars(getTutorAgree()) + "\"");
        row.add("Remarks:\"" + Tool.jsSpecialChars(getRemarks()) + "\"");
        row.add("AddTime:\"" + Tool.stringOfDateTime(getAddTime()) + "\"");
        row.add("Status:\"" + Tool.jsSpecialChars(getStatus()) + "\"");
        row.add("GuideUnitAgree:\"" + Tool.jsSpecialChars(getGuideUnitAgree()) + "\"");
        return "{" + Tool.join(",", row) + "}";
    }
    public int init() {
        List sqlList= new ArrayList();
        sqlList.add(new String[]{"create", "create table :DBNAME:.:TNAME: (id number(*,0) not null,useraccount varchar2(45),placeapplycode varchar2(45),applydate varchar2(45),applytimerange varchar2(45),applicant varchar2(45),activityprincipal varchar2(45),principalduty varchar2(45),principalphone varchar2(45),activitytime date,distributionperiod varchar2(45),rehearsalperiod varchar2(45),activitycontents varchar2(45),speaker varchar2(45),basicprocedures varchar2(45),meetingmarks varchar2(45),backgroundcontents varchar2(45),aponsorship varchar2(45),propaganda varchar2(45),otherpropaganda varchar2(45),tablenums number(*,0),chairnums number(*,0),wiredmicrophonenums number(*,0),wirelessmicrophonenums number(*,0),batterynums number(*,0),usefloor number(*,0),useaudio number(*,0),uselighting number(*,0),usestagelight number(*,0),usecomputerlight number(*,0),useprojector number(*,0),useac number(*,0),usebanner number(*,0),bannercontent varchar2(45),useposter varchar2(45),postercontent varchar2(45),vehiclenums varchar2(45),promiser varchar2(45),promiserphone varchar2(45),promiseracademy varchar2(45),promiserclass varchar2(45),tutor varchar2(45),tutorduty varchar2(45),tutorphone varchar2(45),tutoragree varchar2(45),remarks varchar2(45),addtime date,status varchar2(45),guideunitagree varchar2(45))"});
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
        Places_Applytable v = new Places_Applytable(sourceDb, sourceTb);
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
        Places_Applytable v = new Places_Applytable(sourceDb);
        int num = v.getCount(cdt);
        for (int i = 0; i < num; i += 100) {
            cdt.clear();
            cdt.add("order by id asc");
            cdt.add("limit " + i + ",100");
            List list = v.query(cdt);
            batchInsertByKey(list);
        }
    }
    public int compareTo(Places_Applytable obj) {
        int rtn = 0;
        rtn = ("" + getId()).compareTo("" + obj.getId()); if (rtn != 0) return rtn;
        rtn = getUserAccount().compareTo(obj.getUserAccount()); if (rtn != 0) return rtn;
        rtn = getPlaceApplycode().compareTo(obj.getPlaceApplycode()); if (rtn != 0) return rtn;
        rtn = getApplyDate().compareTo(obj.getApplyDate()); if (rtn != 0) return rtn;
        rtn = getApplyTimeRange().compareTo(obj.getApplyTimeRange()); if (rtn != 0) return rtn;
        rtn = getApplicant().compareTo(obj.getApplicant()); if (rtn != 0) return rtn;
        rtn = getActivityPrincipal().compareTo(obj.getActivityPrincipal()); if (rtn != 0) return rtn;
        rtn = getPrincipalDuty().compareTo(obj.getPrincipalDuty()); if (rtn != 0) return rtn;
        rtn = getPrincipalPhone().compareTo(obj.getPrincipalPhone()); if (rtn != 0) return rtn;
        rtn = getActivityTime().compareTo(obj.getActivityTime()); if (rtn != 0) return rtn;
        rtn = getDistributionPeriod().compareTo(obj.getDistributionPeriod()); if (rtn != 0) return rtn;
        rtn = getRehearsalPeriod().compareTo(obj.getRehearsalPeriod()); if (rtn != 0) return rtn;
        rtn = getActivityContents().compareTo(obj.getActivityContents()); if (rtn != 0) return rtn;
        rtn = getSpeaker().compareTo(obj.getSpeaker()); if (rtn != 0) return rtn;
        rtn = getBasicProcedures().compareTo(obj.getBasicProcedures()); if (rtn != 0) return rtn;
        rtn = getMeetingMarks().compareTo(obj.getMeetingMarks()); if (rtn != 0) return rtn;
        rtn = getBackgroundContents().compareTo(obj.getBackgroundContents()); if (rtn != 0) return rtn;
        rtn = getAponsorship().compareTo(obj.getAponsorship()); if (rtn != 0) return rtn;
        rtn = getPropaganda().compareTo(obj.getPropaganda()); if (rtn != 0) return rtn;
        rtn = getOtherPropaganda().compareTo(obj.getOtherPropaganda()); if (rtn != 0) return rtn;
        rtn = ("" + getTableNums()).compareTo("" + obj.getTableNums()); if (rtn != 0) return rtn;
        rtn = ("" + getChairNums()).compareTo("" + obj.getChairNums()); if (rtn != 0) return rtn;
        rtn = ("" + getWiredmicroPhoneNums()).compareTo("" + obj.getWiredmicroPhoneNums()); if (rtn != 0) return rtn;
        rtn = ("" + getWirelessmicroPhoneNums()).compareTo("" + obj.getWirelessmicroPhoneNums()); if (rtn != 0) return rtn;
        rtn = ("" + getBatteryNums()).compareTo("" + obj.getBatteryNums()); if (rtn != 0) return rtn;
        rtn = ("" + getUseFloor()).compareTo("" + obj.getUseFloor()); if (rtn != 0) return rtn;
        rtn = ("" + getUseAudio()).compareTo("" + obj.getUseAudio()); if (rtn != 0) return rtn;
        rtn = ("" + getUseLighting()).compareTo("" + obj.getUseLighting()); if (rtn != 0) return rtn;
        rtn = ("" + getUseStageLight()).compareTo("" + obj.getUseStageLight()); if (rtn != 0) return rtn;
        rtn = ("" + getUseComputerLight()).compareTo("" + obj.getUseComputerLight()); if (rtn != 0) return rtn;
        rtn = ("" + getUseProjector()).compareTo("" + obj.getUseProjector()); if (rtn != 0) return rtn;
        rtn = ("" + getUseAc()).compareTo("" + obj.getUseAc()); if (rtn != 0) return rtn;
        rtn = ("" + getUseBanner()).compareTo("" + obj.getUseBanner()); if (rtn != 0) return rtn;
        rtn = getBannerContent().compareTo(obj.getBannerContent()); if (rtn != 0) return rtn;
        rtn = getUsePoster().compareTo(obj.getUsePoster()); if (rtn != 0) return rtn;
        rtn = getPosterContent().compareTo(obj.getPosterContent()); if (rtn != 0) return rtn;
        rtn = getVehicleNums().compareTo(obj.getVehicleNums()); if (rtn != 0) return rtn;
        rtn = getPromiser().compareTo(obj.getPromiser()); if (rtn != 0) return rtn;
        rtn = getPromiserPhone().compareTo(obj.getPromiserPhone()); if (rtn != 0) return rtn;
        rtn = getPromiserAcadeMy().compareTo(obj.getPromiserAcadeMy()); if (rtn != 0) return rtn;
        rtn = getPromiserClass().compareTo(obj.getPromiserClass()); if (rtn != 0) return rtn;
        rtn = getTutor().compareTo(obj.getTutor()); if (rtn != 0) return rtn;
        rtn = getTutorDuty().compareTo(obj.getTutorDuty()); if (rtn != 0) return rtn;
        rtn = getTutorPhone().compareTo(obj.getTutorPhone()); if (rtn != 0) return rtn;
        rtn = getTutorAgree().compareTo(obj.getTutorAgree()); if (rtn != 0) return rtn;
        rtn = getRemarks().compareTo(obj.getRemarks()); if (rtn != 0) return rtn;
        rtn = getAddTime().compareTo(obj.getAddTime()); if (rtn != 0) return rtn;
        rtn = getStatus().compareTo(obj.getStatus()); if (rtn != 0) return rtn;
        rtn = getGuideUnitAgree().compareTo(obj.getGuideUnitAgree()); if (rtn != 0) return rtn;
        return rtn;
    }
}
