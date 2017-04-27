<%@ page language="java" %>
<%--志愿活动--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(VolunteerActivity.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "AddFilelist", "Activityname", "ActivityKind", "ActivityLevel", "ActivityPrincipal", "ActivityPlace", "Endtime", "Starttime", "Deadline", "PersonNumber", "Contact", "GuideTeacher", "ActivityExplain", "ApplicationRangeType", "ApplicationRange", "LaunchAcademy", "HonourList", "CheckFlag", "Addtime", "AddAccount", "ModifyTime", "ModifyAccount", "CheckTime", "CheckAccount", "Academy", "Settop"};
private String[] DicKeys = {"Id", "AddFilelist", "Activityname", "ActivityKind", "ActivityLevel", "ActivityPrincipal", "ActivityPlace", "Endtime", "Starttime", "Deadline", "PersonNumber", "Contact", "GuideTeacher", "ActivityExplain", "ApplicationRangeType", "ApplicationRange", "LaunchAcademy", "HonourList", "CheckFlag", "Addtime", "AddAccount", "ModifyTime", "ModifyAccount", "CheckTime", "CheckAccount", "Academy", "Settop"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "上传文件列表", "500", "hidden", ""}, {"string", "活动名称", "45", "text", ""}, {"string", "活动类别", "45", "ActivitykindType", ""}, {"string", "活动级别", "45", "ActivityLevel", ""}, {"string", "负责人", "45", "text", ""}, {"string", "活动地点", "45", "text", ""}, {"date", "活动结束日期", "0", "text", ""}, {"date", "活动开始日期", "0", "text", ""}, {"date", "报名截止日期", "0", "text", ""}, {"int", "所需人数", "0", "text", ""}, {"string", "联系方式", "45", "text", ""}, {"string", "指导教师", "45", "UserName", ""}, {"string", "详细信息", "255", "hidden", ""}, {"string", "申请范围分类", "45", "ApplicationRangeType", ""}, {"string", "申请范围", "255", "text", ""}, {"string", "申办单位", "45", "text", ""}, {"string", "荣誉列表", "255", "text", ""}, {"int", "审核标志", "0", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "添加账号", "45", "hidden", ""}, {"date", "修改时间", "0", "hidden", ""}, {"string", "修改账号", "45", "hidden", ""}, {"date", "审核时间", "0", "hidden", ""}, {"string", "审核账号", "45", "hidden", ""}, {"string", "所属学院", "45", "AcademyName", ""}, {"int", "置顶标志", "0", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "AddFilelist", "Activityname", "ActivityKind", "ActivityLevel", "ActivityPrincipal", "ActivityPlace", "Endtime", "Starttime", "Deadline", "PersonNumber", "Contact", "GuideTeacher", "ActivityExplain", "ApplicationRangeType", "ApplicationRange", "LaunchAcademy", "HonourList", "CheckFlag", "Addtime", "AddAccount", "ModifyTime", "ModifyAccount", "CheckTime", "CheckAccount", "Academy", "Settop"};
private String[] ListFields = {"Activityname", "ActivityKind", "ActivityLevel", "ActivityPrincipal", "ActivityPlace", "Endtime", "Starttime", "Deadline", "PersonNumber", "Contact", "GuideTeacher", "ApplicationRangeType", "ApplicationRange", "LaunchAcademy", "HonourList", "Academy"};
private String[] FormFields = {"AddFilelist", "Activityname", "ActivityKind", "ActivityLevel", "ActivityPrincipal", "ActivityPlace", "Endtime", "Starttime", "Deadline", "PersonNumber", "Contact", "GuideTeacher", "ActivityExplain", "ApplicationRangeType", "ApplicationRange", "LaunchAcademy", "HonourList", "CheckFlag", "Addtime", "AddAccount", "ModifyTime", "ModifyAccount", "CheckTime", "CheckAccount", "Academy", "Settop"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private VolunteerActivity getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    VolunteerActivity v = new VolunteerActivity();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramAddFilelist(request, "AddFilelist");
        v.paramActivityname(request, "Activityname");
        v.paramActivityKind(request, "ActivityKind");
        v.paramActivityLevel(request, "ActivityLevel");
        v.paramActivityPrincipal(request, "ActivityPrincipal");
        v.paramActivityPlace(request, "ActivityPlace");
        v.paramEndtime(request, "Endtime");
        v.paramStarttime(request, "Starttime");
        v.paramDeadline(request, "Deadline");
        v.paramPersonNumber(request, "PersonNumber");
        v.paramContact(request, "Contact");
        v.paramGuideTeacher(request, "GuideTeacher");
        v.paramActivityExplain(request, "ActivityExplain");
        v.paramApplicationRangeType(request, "ApplicationRangeType");
        v.paramApplicationRange(request, "ApplicationRange");
        v.paramLaunchAcademy(request, "LaunchAcademy");
        v.paramHonourList(request, "HonourList");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramAddtime(request, "Addtime");
        v.paramAddAccount(request, "AddAccount");
        v.paramModifyTime(request, "ModifyTime");
        v.paramModifyAccount(request, "ModifyAccount");
        v.paramCheckTime(request, "CheckTime");
        v.paramCheckAccount(request, "CheckAccount");
        v.paramAcademy(request, "Academy");
        v.paramSettop(request, "Settop");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setAddFilelist(ParamUtils.getParameter(request, "AddFilelist", ""));
        v.setActivityname(ParamUtils.getParameter(request, "Activityname", ""));
        v.setActivityKind(ParamUtils.getParameter(request, "ActivityKind", ""));
        v.setActivityLevel(ParamUtils.getParameter(request, "ActivityLevel", ""));
        v.setActivityPrincipal(ParamUtils.getParameter(request, "ActivityPrincipal", ""));
        v.setActivityPlace(ParamUtils.getParameter(request, "ActivityPlace", ""));
        v.setEndtime(ParamUtils.getDateTimeParameter(request, "Endtime", java.sql.Date.valueOf("0001-01-01")));
        v.setStarttime(ParamUtils.getDateTimeParameter(request, "Starttime", java.sql.Date.valueOf("0001-01-01")));
        v.setDeadline(ParamUtils.getDateTimeParameter(request, "Deadline", java.sql.Date.valueOf("0001-01-01")));
        v.setPersonNumber(ParamUtils.getIntParameter(request, "PersonNumber", -1));
        v.setContact(ParamUtils.getParameter(request, "Contact", ""));
        v.setGuideTeacher(ParamUtils.getParameter(request, "GuideTeacher", ""));
        v.setActivityExplain(ParamUtils.getParameter(request, "ActivityExplain", ""));
        v.setApplicationRangeType(ParamUtils.getParameter(request, "ApplicationRangeType", ""));
        v.setApplicationRange(ParamUtils.getParameter(request, "ApplicationRange", ""));
        v.setLaunchAcademy(ParamUtils.getParameter(request, "LaunchAcademy", ""));
        v.setHonourList(ParamUtils.getParameter(request, "HonourList", ""));
        v.setCheckFlag(ParamUtils.getIntParameter(request, "CheckFlag", -1));
        v.setAddtime(ParamUtils.getDateTimeParameter(request, "Addtime", java.sql.Date.valueOf("0001-01-01")));
        v.setAddAccount(ParamUtils.getParameter(request, "AddAccount", ""));
        v.setModifyTime(ParamUtils.getDateTimeParameter(request, "ModifyTime", java.sql.Date.valueOf("0001-01-01")));
        v.setModifyAccount(ParamUtils.getParameter(request, "ModifyAccount", ""));
        v.setCheckTime(ParamUtils.getDateTimeParameter(request, "CheckTime", java.sql.Date.valueOf("0001-01-01")));
        v.setCheckAccount(ParamUtils.getParameter(request, "CheckAccount", ""));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setSettop(ParamUtils.getIntParameter(request, "Settop", -1));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, VolunteerActivity pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map UserNamemap = CEditConst.getUserNameMap(userInfo);
    Map ActivityLevelmap = CEditConst.getActivityLevelMap(userInfo);
    Map ApplicationRangeTypemap = CEditConst.getApplicationRangeTypeMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map ActivitykindTypemap = CEditConst.getActivitykindTypeMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        VolunteerActivity v = (VolunteerActivity)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getAddFilelist()));
        row.add(Tool.jsSpecialChars(v.getActivityname()));
        row.add((String)ActivitykindTypemap.get("" + v.getActivityKind()));
        row.add((String)ActivityLevelmap.get("" + v.getActivityLevel()));
        row.add(Tool.jsSpecialChars(v.getActivityPrincipal()));
        row.add(Tool.jsSpecialChars(v.getActivityPlace()));
        row.add(Tool.stringOfDate(v.getEndtime()));
        row.add(Tool.stringOfDate(v.getStarttime()));
        row.add(Tool.stringOfDate(v.getDeadline()));
        row.add("" + v.getPersonNumber());
        row.add(Tool.jsSpecialChars(v.getContact()));
        row.add((String)UserNamemap.get("" + v.getGuideTeacher()));
        row.add(Tool.jsSpecialChars(v.getActivityExplain()));
        row.add((String)ApplicationRangeTypemap.get("" + v.getApplicationRangeType()));
        row.add(Tool.jsSpecialChars(v.getApplicationRange()));
        row.add(Tool.jsSpecialChars(v.getLaunchAcademy()));
        row.add(Tool.jsSpecialChars(v.getHonourList()));
        row.add("" + v.getCheckFlag());
        row.add(Tool.stringOfDate(v.getAddtime()));
        row.add(Tool.jsSpecialChars(v.getAddAccount()));
        row.add(Tool.stringOfDate(v.getModifyTime()));
        row.add(Tool.jsSpecialChars(v.getModifyAccount()));
        row.add(Tool.stringOfDate(v.getCheckTime()));
        row.add(Tool.jsSpecialChars(v.getCheckAccount()));
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add("" + v.getSettop());
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, VolunteerActivity pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, VolunteerActivity pv, boolean isAll)
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
    VolunteerActivity pv = new VolunteerActivity();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "VolunteerActivity");
    request.setAttribute("describe", "志愿活动");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    VolunteerActivity pv = new VolunteerActivity();
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
private void setForm(javax.servlet.http.HttpServletRequest request, VolunteerActivity form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, ""));
    request.setAttribute("ActivityLeveloptions", CEditConst.getActivityLevelOptions(userInfo, ""));
    request.setAttribute("ApplicationRangeTypeoptions", CEditConst.getApplicationRangeTypeOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("ActivitykindTypeoptions", CEditConst.getActivitykindTypeOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "VolunteerActivity");
    request.setAttribute("describe", "志愿活动");
}
private List mkRtn(String cmd, String forward, VolunteerActivity form)
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
    VolunteerActivity form = getByParameterDb(request);
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
log.debug("VolunteerActivityAction");
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
forwardMap.put("list", "VolunteerActivityAction.jsp");
forwardMap.put("failure", "VolunteerActivityForm.jsp");
forwardMap.put("success", "VolunteerActivityList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "VolunteerActivityForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='VolunteerActivityAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
