<%@ page language="java" %>
<%--问卷调查基本信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(Survey_Basicinfo.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "SurveyCode", "SurveyTitle", "Head_1ID", "Head_1Title", "Head_1Score", "ItemNumber", "AddTime", "AddPerson", "AddUserAccount", "AddUserRole", "ActiveTime", "TimeLength", "SectionScore", "SurveyExplain", "ActiveFlag", "KindTypeFlag", "ScoreTypeFlag", "SurveyNumber", "SectionFlag"};
private String[] DicKeys = {"Id", "SurveyCode", "SurveyTitle", "Head_1ID", "Head_1Title", "Head_1Score", "ItemNumber", "AddTime", "AddPerson", "AddUserAccount", "AddUserRole", "ActiveTime", "TimeLength", "SectionScore", "SurveyExplain", "ActiveFlag", "KindTypeFlag", "ScoreTypeFlag", "SurveyNumber", "SectionFlag"};
private String[][] DicValues = {{"int", "id", "0", "hidden", ""}, {"string", "调查问卷code", "45", "text", ""}, {"string", "调查问卷标题", "45", "text", ""}, {"string", "Head_1ID", "45", "text", ""}, {"string", "Head_1Title", "45", "text", ""}, {"string", "分数", "45", "text", ""}, {"int", "数量", "0", "text", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "添加人", "45", "hidden", ""}, {"string", "添加账号", "45", "hidden", ""}, {"string", "添加人角色", "45", "hidden", ""}, {"date", "激活时间", "0", "text", ""}, {"string", "有效期", "45", "text", ""}, {"string", "SectionScore", "45", "text", ""}, {"string", "调查说明", "2000", "text", ""}, {"int", "是否可用", "0", "text", ""}, {"int", "是否评分", "0", "text", ""}, {"int", "ScoreTypeFlag", "0", "text", ""}, {"int", "SurveyNumber", "0", "text", ""}, {"int", "SectionFlag", "0", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "SurveyCode", "SurveyTitle", "Head_1ID", "Head_1Title", "Head_1Score", "ItemNumber", "AddTime", "AddPerson", "AddUserAccount", "AddUserRole", "ActiveTime", "TimeLength", "SectionScore", "SurveyExplain", "ActiveFlag", "KindTypeFlag", "ScoreTypeFlag", "SurveyNumber", "SectionFlag"};
private String[] ListFields = {"SurveyCode", "SurveyTitle", "Head_1ID", "Head_1Title", "Head_1Score", "ItemNumber", "ActiveTime", "TimeLength", "SectionScore", "SurveyExplain", "ActiveFlag", "KindTypeFlag", "ScoreTypeFlag", "SurveyNumber", "SectionFlag"};
private String[] FormFields = {"SurveyCode", "SurveyTitle", "Head_1ID", "Head_1Title", "Head_1Score", "ItemNumber", "ActiveTime", "TimeLength", "SectionScore", "SurveyExplain", "ActiveFlag", "KindTypeFlag", "ScoreTypeFlag", "SurveyNumber", "SectionFlag"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private Survey_Basicinfo getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Survey_Basicinfo v = new Survey_Basicinfo();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramSurveyCode(request, "SurveyCode");
        v.paramSurveyTitle(request, "SurveyTitle");
        v.paramHead_1ID(request, "Head_1ID");
        v.paramHead_1Title(request, "Head_1Title");
        v.paramHead_1Score(request, "Head_1Score");
        v.paramItemNumber(request, "ItemNumber");
        v.paramAddTime(request, "AddTime");
        v.paramAddPerson(request, "AddPerson");
        v.paramAddUserAccount(request, "AddUserAccount");
        v.paramAddUserRole(request, "AddUserRole");
        v.paramActiveTime(request, "ActiveTime");
        v.paramTimeLength(request, "TimeLength");
        v.paramSectionScore(request, "SectionScore");
        v.paramSurveyExplain(request, "SurveyExplain");
        v.paramActiveFlag(request, "ActiveFlag");
        v.paramKindTypeFlag(request, "KindTypeFlag");
        v.paramScoreTypeFlag(request, "ScoreTypeFlag");
        v.paramSurveyNumber(request, "SurveyNumber");
        v.paramSectionFlag(request, "SectionFlag");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setSurveyCode(ParamUtils.getParameter(request, "SurveyCode", ""));
        v.setSurveyTitle(ParamUtils.getParameter(request, "SurveyTitle", ""));
        v.setHead_1ID(ParamUtils.getParameter(request, "Head_1ID", ""));
        v.setHead_1Title(ParamUtils.getParameter(request, "Head_1Title", ""));
        v.setHead_1Score(ParamUtils.getParameter(request, "Head_1Score", ""));
        v.setItemNumber(ParamUtils.getIntParameter(request, "ItemNumber", 0));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setAddPerson(ParamUtils.getParameter(request, "AddPerson", ""));
        v.setAddUserAccount(ParamUtils.getParameter(request, "AddUserAccount", ""));
        v.setAddUserRole(ParamUtils.getParameter(request, "AddUserRole", ""));
        v.setActiveTime(ParamUtils.getDateTimeParameter(request, "ActiveTime", java.sql.Date.valueOf("0001-01-01")));
        v.setTimeLength(ParamUtils.getParameter(request, "TimeLength", ""));
        v.setSectionScore(ParamUtils.getParameter(request, "SectionScore", ""));
        v.setSurveyExplain(ParamUtils.getParameter(request, "SurveyExplain", ""));
        v.setActiveFlag(ParamUtils.getIntParameter(request, "ActiveFlag", 0));
        v.setKindTypeFlag(ParamUtils.getIntParameter(request, "KindTypeFlag", 1));
        v.setScoreTypeFlag(ParamUtils.getIntParameter(request, "ScoreTypeFlag", 1));
        v.setSurveyNumber(ParamUtils.getIntParameter(request, "SurveyNumber", 0));
        v.setSectionFlag(ParamUtils.getIntParameter(request, "SectionFlag", 0));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Survey_Basicinfo pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Survey_Basicinfo v = (Survey_Basicinfo)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getSurveyCode()));
        row.add(Tool.jsSpecialChars(v.getSurveyTitle()));
        row.add(Tool.jsSpecialChars(v.getHead_1ID()));
        row.add(Tool.jsSpecialChars(v.getHead_1Title()));
        row.add(Tool.jsSpecialChars(v.getHead_1Score()));
        row.add("" + v.getItemNumber());
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.jsSpecialChars(v.getAddUserAccount()));
        row.add(Tool.jsSpecialChars(v.getAddUserRole()));
        row.add(Tool.stringOfDate(v.getActiveTime()));
        row.add(Tool.jsSpecialChars(v.getTimeLength()));
        row.add(Tool.jsSpecialChars(v.getSectionScore()));
        row.add(Tool.jsSpecialChars(v.getSurveyExplain()));
        row.add("" + v.getActiveFlag());
        row.add("" + v.getKindTypeFlag());
        row.add("" + v.getScoreTypeFlag());
        row.add("" + v.getSurveyNumber());
        row.add("" + v.getSectionFlag());
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Survey_Basicinfo pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Survey_Basicinfo pv, boolean isAll)
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
    Survey_Basicinfo pv = new Survey_Basicinfo();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Survey_Basicinfo");
    request.setAttribute("describe", "问卷调查基本信息");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Survey_Basicinfo pv = new Survey_Basicinfo();
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
private void setForm(javax.servlet.http.HttpServletRequest request, Survey_Basicinfo form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Survey_Basicinfo");
    request.setAttribute("describe", "问卷调查基本信息");
}
private List mkRtn(String cmd, String forward, Survey_Basicinfo form)
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
    Survey_Basicinfo form = getByParameterDb(request);
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
log.debug("Survey_BasicinfoAction");
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
forwardMap.put("list", "Survey_BasicinfoAction.jsp");
forwardMap.put("failure", "Survey_BasicinfoForm.jsp");
forwardMap.put("success", "Survey_BasicinfoList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "Survey_BasicinfoForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='Survey_BasicinfoAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
