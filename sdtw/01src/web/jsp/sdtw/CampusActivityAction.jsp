<%@ page language="java" %>
<%--校园文化信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(CampusActivity.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ActivityName", "ActivitykindType", "OrgacadeMy", "ActivityLevel", "TotalRounds", "ActivityDate1", "ActivityPlace1", "ActivityDate2", "ActivityPlace2", "ActivityDate3", "ActivityPlace3", "Deadline", "PersonNumber", "ActivityPrincipal", "Contact", "ActivityExplain", "ApplicationRange", "Campus", "Academy", "Addtime", "Addperson", "ModifyTime", "ModifyPerson", "Honor"};
private String[] DicKeys = {"Id", "ActivityName", "ActivitykindType", "OrgacadeMy", "ActivityLevel", "TotalRounds", "ActivityDate1", "ActivityPlace1", "ActivityDate2", "ActivityPlace2", "ActivityDate3", "ActivityPlace3", "Deadline", "PersonNumber", "ActivityPrincipal", "Contact", "ActivityExplain", "ApplicationRange", "Campus", "Academy", "Addtime", "Addperson", "ModifyTime", "ModifyPerson", "Honor"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "活动名称", "100", "text", ""}, {"string", "活动类别", "45", "ActivitykindType", ""}, {"string", "活动组织单位", "100", "AcademyName", ""}, {"string", "活动级别", "45", "ActivityLevel", ""}, {"string", "活动轮次", "45", "TotalRounds", ""}, {"string", "第一轮活动日期", "10", "text", ""}, {"string", "第一轮活动地点", "200", "text", ""}, {"string", "第二轮活动日期", "10", "text", ""}, {"string", "第二轮活动地点", "200", "text", ""}, {"string", "第三轮活动日期", "10", "text", ""}, {"string", "第三轮活动地点", "200", "text", ""}, {"string", "报名截止日期", "10", "text", ""}, {"string", "所需人数", "10", "text", ""}, {"string", "负责人", "50", "text", ""}, {"string", "联系方式", "20", "text", ""}, {"string", "详细介绍", "2000", "text", ""}, {"string", "申请范围", "200", "text", ""}, {"string", "参与校区", "100", "OrgName", ""}, {"string", "学院", "1000", "AcademyName", ""}, {"date", "添加时间", "0", "text", ""}, {"string", "添加人", "45", "text", ""}, {"date", "修改时间", "0", "text", ""}, {"string", "修改人", "45", "text", ""}, {"string", "荣誉", "500", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ActivityName", "ActivitykindType", "OrgacadeMy", "ActivityLevel", "TotalRounds", "ActivityDate1", "ActivityPlace1", "ActivityDate2", "ActivityPlace2", "ActivityDate3", "ActivityPlace3", "Deadline", "PersonNumber", "ActivityPrincipal", "Contact", "ActivityExplain", "ApplicationRange", "Campus", "Academy", "Addtime", "Addperson", "ModifyTime", "ModifyPerson", "Honor"};
private String[] ListFields = {"ActivityName", "ActivitykindType", "OrgacadeMy", "ActivityLevel", "TotalRounds", "ActivityDate1", "ActivityPlace1", "ActivityDate2", "ActivityPlace2", "ActivityDate3", "ActivityPlace3", "Deadline", "PersonNumber", "ActivityPrincipal", "Contact", "ActivityExplain", "ApplicationRange", "Campus", "Academy", "Addtime", "Addperson", "ModifyTime", "ModifyPerson", "Honor"};
private String[] FormFields = {"ActivityName", "ActivitykindType", "OrgacadeMy", "ActivityLevel", "TotalRounds", "ActivityDate1", "ActivityPlace1", "ActivityDate2", "ActivityPlace2", "ActivityDate3", "ActivityPlace3", "Deadline", "PersonNumber", "ActivityPrincipal", "Contact", "ActivityExplain", "ApplicationRange", "Campus", "Academy", "Addtime", "Addperson", "ModifyTime", "ModifyPerson", "Honor"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private CampusActivity getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    CampusActivity v = new CampusActivity();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramActivityName(request, "ActivityName");
        v.paramActivitykindType(request, "ActivitykindType");
        v.paramOrgacadeMy(request, "OrgacadeMy");
        v.paramActivityLevel(request, "ActivityLevel");
        v.paramTotalRounds(request, "TotalRounds");
        v.paramActivityDate1(request, "ActivityDate1");
        v.paramActivityPlace1(request, "ActivityPlace1");
        v.paramActivityDate2(request, "ActivityDate2");
        v.paramActivityPlace2(request, "ActivityPlace2");
        v.paramActivityDate3(request, "ActivityDate3");
        v.paramActivityPlace3(request, "ActivityPlace3");
        v.paramDeadline(request, "Deadline");
        v.paramPersonNumber(request, "PersonNumber");
        v.paramActivityPrincipal(request, "ActivityPrincipal");
        v.paramContact(request, "Contact");
        v.paramActivityExplain(request, "ActivityExplain");
        v.paramApplicationRange(request, "ApplicationRange");
        v.paramCampus(request, "Campus");
        v.paramAcademy(request, "Academy");
        v.paramAddtime(request, "Addtime");
        v.paramAddperson(request, "Addperson");
        v.paramModifyTime(request, "ModifyTime");
        v.paramModifyPerson(request, "ModifyPerson");
        v.paramHonor(request, "Honor");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setActivityName(ParamUtils.getParameter(request, "ActivityName", ""));
        v.setActivitykindType(ParamUtils.getParameter(request, "ActivitykindType", ""));
        v.setOrgacadeMy(ParamUtils.getParameter(request, "OrgacadeMy", ""));
        v.setActivityLevel(ParamUtils.getParameter(request, "ActivityLevel", ""));
        v.setTotalRounds(ParamUtils.getParameter(request, "TotalRounds", ""));
        v.setActivityDate1(ParamUtils.getParameter(request, "ActivityDate1", ""));
        v.setActivityPlace1(ParamUtils.getParameter(request, "ActivityPlace1", ""));
        v.setActivityDate2(ParamUtils.getParameter(request, "ActivityDate2", ""));
        v.setActivityPlace2(ParamUtils.getParameter(request, "ActivityPlace2", ""));
        v.setActivityDate3(ParamUtils.getParameter(request, "ActivityDate3", ""));
        v.setActivityPlace3(ParamUtils.getParameter(request, "ActivityPlace3", ""));
        v.setDeadline(ParamUtils.getParameter(request, "Deadline", ""));
        v.setPersonNumber(ParamUtils.getParameter(request, "PersonNumber", ""));
        v.setActivityPrincipal(ParamUtils.getParameter(request, "ActivityPrincipal", ""));
        v.setContact(ParamUtils.getParameter(request, "Contact", ""));
        v.setActivityExplain(ParamUtils.getParameter(request, "ActivityExplain", ""));
        v.setApplicationRange(ParamUtils.getParameter(request, "ApplicationRange", ""));
        v.setCampus(ParamUtils.getParameter(request, "Campus", ""));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setAddtime(ParamUtils.getDateTimeParameter(request, "Addtime", java.sql.Date.valueOf("0001-01-01")));
        v.setAddperson(ParamUtils.getParameter(request, "Addperson", ""));
        v.setModifyTime(ParamUtils.getDateTimeParameter(request, "ModifyTime", java.sql.Date.valueOf("0001-01-01")));
        v.setModifyPerson(ParamUtils.getParameter(request, "ModifyPerson", ""));
        v.setHonor(ParamUtils.getParameter(request, "Honor", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, CampusActivity pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map OrgNamemap = CEditConst.getOrgNameMap(userInfo);
    Map ActivitykindTypemap = CEditConst.getActivitykindTypeMap(userInfo);
    Map TotalRoundsmap = CEditConst.getTotalRoundsMap(userInfo);
    Map ActivityLevelmap = CEditConst.getActivityLevelMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        CampusActivity v = (CampusActivity)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getActivityName()));
        row.add((String)ActivitykindTypemap.get("" + v.getActivitykindType()));
        row.add((String)AcademyNamemap.get("" + v.getOrgacadeMy()));
        row.add((String)ActivityLevelmap.get("" + v.getActivityLevel()));
        row.add((String)TotalRoundsmap.get("" + v.getTotalRounds()));
        row.add(Tool.jsSpecialChars(v.getActivityDate1()));
        row.add(Tool.jsSpecialChars(v.getActivityPlace1()));
        row.add(Tool.jsSpecialChars(v.getActivityDate2()));
        row.add(Tool.jsSpecialChars(v.getActivityPlace2()));
        row.add(Tool.jsSpecialChars(v.getActivityDate3()));
        row.add(Tool.jsSpecialChars(v.getActivityPlace3()));
        row.add(Tool.jsSpecialChars(v.getDeadline()));
        row.add(Tool.jsSpecialChars(v.getPersonNumber()));
        row.add(Tool.jsSpecialChars(v.getActivityPrincipal()));
        row.add(Tool.jsSpecialChars(v.getContact()));
        row.add(Tool.jsSpecialChars(v.getActivityExplain()));
        row.add(Tool.jsSpecialChars(v.getApplicationRange()));
        row.add((String)OrgNamemap.get("" + v.getCampus()));
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add(Tool.stringOfDate(v.getAddtime()));
        row.add(Tool.jsSpecialChars(v.getAddperson()));
        row.add(Tool.stringOfDate(v.getModifyTime()));
        row.add(Tool.jsSpecialChars(v.getModifyPerson()));
        row.add(Tool.jsSpecialChars(v.getHonor()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, CampusActivity pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, CampusActivity pv, boolean isAll)
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
    CampusActivity pv = new CampusActivity();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "CampusActivity");
    request.setAttribute("describe", "校园文化信息");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    CampusActivity pv = new CampusActivity();
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
private void setForm(javax.servlet.http.HttpServletRequest request, CampusActivity form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("OrgNameoptions", CEditConst.getOrgNameOptions(userInfo, ""));
    request.setAttribute("ActivitykindTypeoptions", CEditConst.getActivitykindTypeOptions(userInfo, ""));
    request.setAttribute("TotalRoundsoptions", CEditConst.getTotalRoundsOptions(userInfo, ""));
    request.setAttribute("ActivityLeveloptions", CEditConst.getActivityLevelOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "CampusActivity");
    request.setAttribute("describe", "校园文化信息");
}
private List mkRtn(String cmd, String forward, CampusActivity form)
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
    CampusActivity form = getByParameterDb(request);
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
log.debug("CampusActivityAction");
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
forwardMap.put("list", "CampusActivityAction.jsp");
forwardMap.put("failure", "CampusActivityForm.jsp");
forwardMap.put("success", "CampusActivityList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "CampusActivityForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='CampusActivityAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
