<%@ page language="java" %>
<%--团委场地申请--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(Places_Applytable.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "UserAccount", "PlaceApplycode", "ApplyDate", "ApplyTimeRange", "Applicant", "ActivityPrincipal", "PrincipalDuty", "PrincipalPhone", "ActivityTime", "DistributionPeriod", "RehearsalPeriod", "ActivityContents", "Speaker", "BasicProcedures", "MeetingMarks", "BackgroundContents", "Aponsorship", "Propaganda", "OtherPropaganda", "TableNums", "ChairNums", "WiredmicroPhoneNums", "WirelessmicroPhoneNums", "BatteryNums", "UseFloor", "UseAudio", "UseLighting", "UseStageLight", "UseComputerLight", "UseProjector", "UseAc", "UseBanner", "BannerContent", "UsePoster", "PosterContent", "VehicleNums", "Promiser", "PromiserPhone", "PromiserAcadeMy", "PromiserClass", "Tutor", "TutorDuty", "TutorPhone", "TutorAgree", "Remarks", "AddTime", "Status", "GuideUnitAgree"};
private String[] DicKeys = {"Id", "UserAccount", "PlaceApplycode", "ApplyDate", "ApplyTimeRange", "Applicant", "ActivityPrincipal", "PrincipalDuty", "PrincipalPhone", "ActivityTime", "DistributionPeriod", "RehearsalPeriod", "ActivityContents", "Speaker", "BasicProcedures", "MeetingMarks", "BackgroundContents", "Aponsorship", "Propaganda", "OtherPropaganda", "TableNums", "ChairNums", "WiredmicroPhoneNums", "WirelessmicroPhoneNums", "BatteryNums", "UseFloor", "UseAudio", "UseLighting", "UseStageLight", "UseComputerLight", "UseProjector", "UseAc", "UseBanner", "BannerContent", "UsePoster", "PosterContent", "VehicleNums", "Promiser", "PromiserPhone", "PromiserAcadeMy", "PromiserClass", "Tutor", "TutorDuty", "TutorPhone", "TutorAgree", "Remarks", "AddTime", "Status", "GuideUnitAgree"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "用户账号", "45", "text", ""}, {"string", "场地代码", "45", "text", ""}, {"string", "申请时间", "45", "hidden", ""}, {"string", "申请时间段", "45", "text", ""}, {"string", "使用单位", "45", "text", ""}, {"string", "活动负责人", "45", "UserName", ""}, {"string", "活动负责人职务", "45", "text", ""}, {"string", "活动负责人联系电话", "45", "hidden", ""}, {"date", "活动时间", "0", "hidden", ""}, {"string", "布场时段", "45", "hidden", ""}, {"string", "彩排时段", "45", "hidden", ""}, {"string", "活动内容", "45", "hidden", ""}, {"string", "主讲人", "45", "UserName", ""}, {"string", "基本程序简介", "45", "hidden", ""}, {"string", "会标内容", "45", "hidden", ""}, {"string", "背景内容", "45", "hidden", ""}, {"string", "商业赞助", "45", "hidden", ""}, {"string", "宣传形式", "45", "hidden", ""}, {"string", "会场内其他宣传形式", "45", "hidden", ""}, {"int", "桌子数量", "0", "hidden", ""}, {"int", "椅子数量", "0", "hidden", ""}, {"int", "有线话筒", "0", "hidden", ""}, {"int", "无线话筒", "0", "hidden", ""}, {"int", "话筒电池", "0", "hidden", ""}, {"int", "使用发言台", "0", "hidden", ""}, {"int", "使用音响设备", "0", "hidden", ""}, {"int", "使用照明灯光", "0", "hidden", ""}, {"int", "使用舞台灯光", "0", "hidden", ""}, {"int", "使用电脑灯", "0", "hidden", ""}, {"int", "使用投影仪", "0", "hidden", ""}, {"int", "使用空调", "0", "hidden", ""}, {"int", "悬挂横幅", "0", "hidden", ""}, {"string", "横幅内容", "45", "hidden", ""}, {"string", "张贴海报或展板", "45", "hidden", ""}, {"string", "海报内容", "45", "hidden", ""}, {"string", "参加人员车辆数量", "45", "hidden", ""}, {"string", "承诺人", "45", "UserName", ""}, {"string", "承诺人联系电话", "45", "hidden", ""}, {"string", "承诺人学院", "45", "hidden", ""}, {"string", "承诺人班级", "45", "hidden", ""}, {"string", "指导老师", "45", "hidden", ""}, {"string", "指导老师职务", "45", "text", ""}, {"string", "指导老师联系方式", "45", "text", ""}, {"string", "指导老师意见", "45", "text", ""}, {"string", "备注", "45", "text", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "团委审核", "45", "text", ""}, {"string", "学院审核", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "UserAccount", "PlaceApplycode", "ApplyDate", "ApplyTimeRange", "Applicant", "ActivityPrincipal", "PrincipalDuty", "PrincipalPhone", "ActivityTime", "DistributionPeriod", "RehearsalPeriod", "ActivityContents", "Speaker", "BasicProcedures", "MeetingMarks", "BackgroundContents", "Aponsorship", "Propaganda", "OtherPropaganda", "TableNums", "ChairNums", "WiredmicroPhoneNums", "WirelessmicroPhoneNums", "BatteryNums", "UseFloor", "UseAudio", "UseLighting", "UseStageLight", "UseComputerLight", "UseProjector", "UseAc", "UseBanner", "BannerContent", "UsePoster", "PosterContent", "VehicleNums", "Promiser", "PromiserPhone", "PromiserAcadeMy", "PromiserClass", "Tutor", "TutorDuty", "TutorPhone", "TutorAgree", "Remarks", "AddTime", "Status", "GuideUnitAgree"};
private String[] ListFields = {"UserAccount", "PlaceApplycode", "ApplyTimeRange", "Applicant", "ActivityPrincipal", "PrincipalDuty", "Speaker", "Promiser", "TutorDuty", "TutorPhone", "TutorAgree", "Remarks", "Status", "GuideUnitAgree"};
private String[] FormFields = {"UserAccount", "PlaceApplycode", "ApplyTimeRange", "Applicant", "ActivityPrincipal", "PrincipalDuty", "PrincipalPhone", "ActivityTime", "DistributionPeriod", "RehearsalPeriod", "ActivityContents", "Speaker", "BasicProcedures", "MeetingMarks", "BackgroundContents", "Aponsorship", "Propaganda", "OtherPropaganda", "TableNums", "ChairNums", "WiredmicroPhoneNums", "WirelessmicroPhoneNums", "BatteryNums", "UseFloor", "UseAudio", "UseLighting", "UseStageLight", "UseComputerLight", "UseProjector", "UseAc", "UseBanner", "BannerContent", "UsePoster", "PosterContent", "VehicleNums", "Promiser", "PromiserPhone", "PromiserAcadeMy", "PromiserClass", "Tutor", "TutorDuty", "TutorPhone", "TutorAgree", "Remarks", "Status", "GuideUnitAgree"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private Places_Applytable getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Places_Applytable v = new Places_Applytable();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramUserAccount(request, "UserAccount");
        v.paramPlaceApplycode(request, "PlaceApplycode");
        v.paramApplyDate(request, "ApplyDate");
        v.paramApplyTimeRange(request, "ApplyTimeRange");
        v.paramApplicant(request, "Applicant");
        v.paramActivityPrincipal(request, "ActivityPrincipal");
        v.paramPrincipalDuty(request, "PrincipalDuty");
        v.paramPrincipalPhone(request, "PrincipalPhone");
        v.paramActivityTime(request, "ActivityTime");
        v.paramDistributionPeriod(request, "DistributionPeriod");
        v.paramRehearsalPeriod(request, "RehearsalPeriod");
        v.paramActivityContents(request, "ActivityContents");
        v.paramSpeaker(request, "Speaker");
        v.paramBasicProcedures(request, "BasicProcedures");
        v.paramMeetingMarks(request, "MeetingMarks");
        v.paramBackgroundContents(request, "BackgroundContents");
        v.paramAponsorship(request, "Aponsorship");
        v.paramPropaganda(request, "Propaganda");
        v.paramOtherPropaganda(request, "OtherPropaganda");
        v.paramTableNums(request, "TableNums");
        v.paramChairNums(request, "ChairNums");
        v.paramWiredmicroPhoneNums(request, "WiredmicroPhoneNums");
        v.paramWirelessmicroPhoneNums(request, "WirelessmicroPhoneNums");
        v.paramBatteryNums(request, "BatteryNums");
        v.paramUseFloor(request, "UseFloor");
        v.paramUseAudio(request, "UseAudio");
        v.paramUseLighting(request, "UseLighting");
        v.paramUseStageLight(request, "UseStageLight");
        v.paramUseComputerLight(request, "UseComputerLight");
        v.paramUseProjector(request, "UseProjector");
        v.paramUseAc(request, "UseAc");
        v.paramUseBanner(request, "UseBanner");
        v.paramBannerContent(request, "BannerContent");
        v.paramUsePoster(request, "UsePoster");
        v.paramPosterContent(request, "PosterContent");
        v.paramVehicleNums(request, "VehicleNums");
        v.paramPromiser(request, "Promiser");
        v.paramPromiserPhone(request, "PromiserPhone");
        v.paramPromiserAcadeMy(request, "PromiserAcadeMy");
        v.paramPromiserClass(request, "PromiserClass");
        v.paramTutor(request, "Tutor");
        v.paramTutorDuty(request, "TutorDuty");
        v.paramTutorPhone(request, "TutorPhone");
        v.paramTutorAgree(request, "TutorAgree");
        v.paramRemarks(request, "Remarks");
        v.paramAddTime(request, "AddTime");
        v.paramStatus(request, "Status");
        v.paramGuideUnitAgree(request, "GuideUnitAgree");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setUserAccount(ParamUtils.getParameter(request, "UserAccount", ""));
        v.setPlaceApplycode(ParamUtils.getParameter(request, "PlaceApplycode", ""));
        v.setApplyDate(ParamUtils.getParameter(request, "ApplyDate", ""));
        v.setApplyTimeRange(ParamUtils.getParameter(request, "ApplyTimeRange", ""));
        v.setApplicant(ParamUtils.getParameter(request, "Applicant", ""));
        v.setActivityPrincipal(ParamUtils.getParameter(request, "ActivityPrincipal", ""));
        v.setPrincipalDuty(ParamUtils.getParameter(request, "PrincipalDuty", ""));
        v.setPrincipalPhone(ParamUtils.getParameter(request, "PrincipalPhone", ""));
        v.setActivityTime(ParamUtils.getDateTimeParameter(request, "ActivityTime", java.sql.Date.valueOf("0001-01-01")));
        v.setDistributionPeriod(ParamUtils.getParameter(request, "DistributionPeriod", ""));
        v.setRehearsalPeriod(ParamUtils.getParameter(request, "RehearsalPeriod", ""));
        v.setActivityContents(ParamUtils.getParameter(request, "ActivityContents", ""));
        v.setSpeaker(ParamUtils.getParameter(request, "Speaker", ""));
        v.setBasicProcedures(ParamUtils.getParameter(request, "BasicProcedures", ""));
        v.setMeetingMarks(ParamUtils.getParameter(request, "MeetingMarks", ""));
        v.setBackgroundContents(ParamUtils.getParameter(request, "BackgroundContents", ""));
        v.setAponsorship(ParamUtils.getParameter(request, "Aponsorship", ""));
        v.setPropaganda(ParamUtils.getParameter(request, "Propaganda", ""));
        v.setOtherPropaganda(ParamUtils.getParameter(request, "OtherPropaganda", ""));
        v.setTableNums(ParamUtils.getIntParameter(request, "TableNums", -1));
        v.setChairNums(ParamUtils.getIntParameter(request, "ChairNums", -1));
        v.setWiredmicroPhoneNums(ParamUtils.getIntParameter(request, "WiredmicroPhoneNums", -1));
        v.setWirelessmicroPhoneNums(ParamUtils.getIntParameter(request, "WirelessmicroPhoneNums", -1));
        v.setBatteryNums(ParamUtils.getIntParameter(request, "BatteryNums", -1));
        v.setUseFloor(ParamUtils.getIntParameter(request, "UseFloor", -1));
        v.setUseAudio(ParamUtils.getIntParameter(request, "UseAudio", -1));
        v.setUseLighting(ParamUtils.getIntParameter(request, "UseLighting", -1));
        v.setUseStageLight(ParamUtils.getIntParameter(request, "UseStageLight", -1));
        v.setUseComputerLight(ParamUtils.getIntParameter(request, "UseComputerLight", -1));
        v.setUseProjector(ParamUtils.getIntParameter(request, "UseProjector", -1));
        v.setUseAc(ParamUtils.getIntParameter(request, "UseAc", -1));
        v.setUseBanner(ParamUtils.getIntParameter(request, "UseBanner", -1));
        v.setBannerContent(ParamUtils.getParameter(request, "BannerContent", ""));
        v.setUsePoster(ParamUtils.getParameter(request, "UsePoster", ""));
        v.setPosterContent(ParamUtils.getParameter(request, "PosterContent", ""));
        v.setVehicleNums(ParamUtils.getParameter(request, "VehicleNums", ""));
        v.setPromiser(ParamUtils.getParameter(request, "Promiser", ""));
        v.setPromiserPhone(ParamUtils.getParameter(request, "PromiserPhone", ""));
        v.setPromiserAcadeMy(ParamUtils.getParameter(request, "PromiserAcadeMy", ""));
        v.setPromiserClass(ParamUtils.getParameter(request, "PromiserClass", ""));
        v.setTutor(ParamUtils.getParameter(request, "Tutor", ""));
        v.setTutorDuty(ParamUtils.getParameter(request, "TutorDuty", ""));
        v.setTutorPhone(ParamUtils.getParameter(request, "TutorPhone", ""));
        v.setTutorAgree(ParamUtils.getParameter(request, "TutorAgree", ""));
        v.setRemarks(ParamUtils.getParameter(request, "Remarks", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setStatus(ParamUtils.getParameter(request, "Status", ""));
        v.setGuideUnitAgree(ParamUtils.getParameter(request, "GuideUnitAgree", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Places_Applytable pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map UserNamemap = CEditConst.getUserNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Places_Applytable v = (Places_Applytable)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getUserAccount()));
        row.add(Tool.jsSpecialChars(v.getPlaceApplycode()));
        row.add(Tool.jsSpecialChars(v.getApplyDate()));
        row.add(Tool.jsSpecialChars(v.getApplyTimeRange()));
        row.add(Tool.jsSpecialChars(v.getApplicant()));
        row.add((String)UserNamemap.get("" + v.getActivityPrincipal()));
        row.add(Tool.jsSpecialChars(v.getPrincipalDuty()));
        row.add(Tool.jsSpecialChars(v.getPrincipalPhone()));
        row.add(Tool.stringOfDate(v.getActivityTime()));
        row.add(Tool.jsSpecialChars(v.getDistributionPeriod()));
        row.add(Tool.jsSpecialChars(v.getRehearsalPeriod()));
        row.add(Tool.jsSpecialChars(v.getActivityContents()));
        row.add((String)UserNamemap.get("" + v.getSpeaker()));
        row.add(Tool.jsSpecialChars(v.getBasicProcedures()));
        row.add(Tool.jsSpecialChars(v.getMeetingMarks()));
        row.add(Tool.jsSpecialChars(v.getBackgroundContents()));
        row.add(Tool.jsSpecialChars(v.getAponsorship()));
        row.add(Tool.jsSpecialChars(v.getPropaganda()));
        row.add(Tool.jsSpecialChars(v.getOtherPropaganda()));
        row.add("" + v.getTableNums());
        row.add("" + v.getChairNums());
        row.add("" + v.getWiredmicroPhoneNums());
        row.add("" + v.getWirelessmicroPhoneNums());
        row.add("" + v.getBatteryNums());
        row.add("" + v.getUseFloor());
        row.add("" + v.getUseAudio());
        row.add("" + v.getUseLighting());
        row.add("" + v.getUseStageLight());
        row.add("" + v.getUseComputerLight());
        row.add("" + v.getUseProjector());
        row.add("" + v.getUseAc());
        row.add("" + v.getUseBanner());
        row.add(Tool.jsSpecialChars(v.getBannerContent()));
        row.add(Tool.jsSpecialChars(v.getUsePoster()));
        row.add(Tool.jsSpecialChars(v.getPosterContent()));
        row.add(Tool.jsSpecialChars(v.getVehicleNums()));
        row.add((String)UserNamemap.get("" + v.getPromiser()));
        row.add(Tool.jsSpecialChars(v.getPromiserPhone()));
        row.add(Tool.jsSpecialChars(v.getPromiserAcadeMy()));
        row.add(Tool.jsSpecialChars(v.getPromiserClass()));
        row.add(Tool.jsSpecialChars(v.getTutor()));
        row.add(Tool.jsSpecialChars(v.getTutorDuty()));
        row.add(Tool.jsSpecialChars(v.getTutorPhone()));
        row.add(Tool.jsSpecialChars(v.getTutorAgree()));
        row.add(Tool.jsSpecialChars(v.getRemarks()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getStatus()));
        row.add(Tool.jsSpecialChars(v.getGuideUnitAgree()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Places_Applytable pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Places_Applytable pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    if (!isAll) {
        int currpage = ParamUtils.getIntParameter(request, "page", 1);
        com.xietong.software.common.PageControl pc = new com.xietong.software.common.PageControl(pv.getCount(cdt), currpage, shownum);
        cdt.add("limit " + pc.getOffset() + "," + pc.getShownum());
        request.setAttribute("PageControl", pc);
    }
    String cname = pv.getFieldByProperty(orderfield);
    if (cname.length() != 0) {
        cdt.add("order by " + cname + " " + ordertype);
        log.debug("order by " + cname + " " + ordertype);
    }
    request.setAttribute("queryfields", QueryFields);
    request.setAttribute("queryvalues", QueryValues);
    return cdt;
}
private void setList(javax.servlet.http.HttpServletRequest request)
{
    setList(request, false);
request.setAttribute("hidefields", HideFields);}
private void setList(javax.servlet.http.HttpServletRequest request, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Places_Applytable pv = new Places_Applytable();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Places_Applytable");
    request.setAttribute("describe", "团委场地申请");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Places_Applytable pv = new Places_Applytable();
    try {
        WorkbookSettings ws = new WorkbookSettings();
        ws.setLocale(new Locale("zh", "CN"));
        WritableWorkbook workbook = Workbook.createWorkbook(new File(filename), ws);
        WritableSheet s1 = workbook.createSheet("Sheet1", 0);
        for (int k = 0; k < DicValues.length; k ++) {
            Label lr = new Label(k, 0, DicValues[k][1]);
            s1.addCell(lr);
        }
        int i = 1;
        List condition = getListCondition(request, pv, true);
        int num = pv.getCount(condition);
        for (int pos = 0; pos < num; pos += 100) {
            List cdt = new ArrayList(condition);
            for (Iterator it = condition.iterator(); it.hasNext();) {
                cdt.add(new String((String)it.next()));
            }
            cdt.add("limit " + pos + ",100");
            for (Iterator rit = getListRows(request, pv, cdt).iterator(); rit.hasNext(); i ++) {
                List row = (List)rit.next();
                int j = 0;
                for (Iterator cit = row.iterator(); cit.hasNext(); j ++) {
                    Label lr = new Label(j, i, (String)cit.next());
                    s1.addCell(lr);
                }
            }
        }
        workbook.write();
        workbook.close();
    }
    catch (IOException e) {
    }
    catch (WriteException e) {
    }
}
private void setForm(javax.servlet.http.HttpServletRequest request, Places_Applytable form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("YesNooptions", CEditConst.getYesNoOptions(userInfo, "-1"));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, ""));
    request.setAttribute("ClassesNameoptions", CEditConst.getClassesNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Places_Applytable");
    request.setAttribute("describe", "团委场地申请");
}
private List mkRtn(String cmd, String forward, Places_Applytable form)
{
    List rtn = new ArrayList();
    rtn.add(cmd);
    rtn.add(forward);
    rtn.add(form);
    return rtn;
}
public List main(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    log.debug("cmd=" + cmd);
    Places_Applytable form = getByParameterDb(request);
    if (cmd.equals("list"))
    {
        setList(request);
        return mkRtn("list", "success", form);
    }
    if (cmd.equals("listall"))
    {
        setList(request, true);
        return mkRtn(cmd, "success", form);
    }
    if (cmd.equals("excel"))
    {
        String filename = HeadConst.root_file_path + "/upload/temp/" + userInfo.getName() + ".xls";
        writeExcel(request, filename);
        return mkRtn(cmd, "excel", form);
    }
    if (cmd.equals("create"))
    {
        setForm(request, form);
        return mkRtn("save", "input", form);
    }
    if (cmd.equals("modify"))
    {
        form = form.getById(form.getId());
        setForm(request, form);
        return mkRtn("update", "input", form);
    }
    if (cmd.equals("delete"))
    {
        form.delete(form.getId());
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("deletelist"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        List cdt = new ArrayList();
        cdt.add("id in (" + idlist + ")");
        form.deleteByCondition(cdt);
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("save"))
    {
        form.insert();
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("update"))
    {
        form.update();
        return mkRtn("list", "list", form);
    }
    request.setAttribute("msg", "未规定的cmd:" + cmd);
    return mkRtn("list", "failure", form);
}
%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("Places_ApplytableAction");
int currpage = ParamUtils.getIntParameter(request, "page", 1);
List rtn = null;
UserInfo userInfo = Tool.getUserInfo(request);
if (userInfo==null) {
    rtn = mkRtn("login", "login", null);
}
else {
    rtn = main(request);
}
String cmd = (String)rtn.get(0);
String forwardKey = (String)rtn.get(1);
request.setAttribute("fromBean", rtn.get(2));
Map forwardMap = new HashMap();
forwardMap.put("login", "logon.jsp");
forwardMap.put("list", "Places_ApplytableAction.jsp");
forwardMap.put("failure", "Places_ApplytableForm.jsp");
forwardMap.put("success", "Places_ApplytableList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "Places_ApplytableForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='Places_ApplytableAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
