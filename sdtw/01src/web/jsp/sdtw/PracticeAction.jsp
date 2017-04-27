<%@ page language="java" %>
<%--社会实践项目团委立项表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(Practice.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "PracticeCode", "PracticeName", "PracticeSubject", "Starttime", "Endtime", "Funding", "TeamDemand", "Schedule", "WorkDemand", "OtherExplain", "Addtime", "AddAccount", "AddUserrole", "AddAcademy", "AddFilelist", "Remark", "Remark2", "Remark3", "Remark4", "Remark5", "Remark6"};
private String[] DicKeys = {"Id", "PracticeCode", "PracticeName", "PracticeSubject", "Starttime", "Endtime", "Funding", "TeamDemand", "Schedule", "WorkDemand", "OtherExplain", "Addtime", "AddAccount", "AddUserrole", "AddAcademy", "AddFilelist", "Remark", "Remark2", "Remark3", "Remark4", "Remark5", "Remark6"};
private String[][] DicValues = {{"int", "id", "0", "hidden", ""}, {"string", "项目编码", "45", "text", ""}, {"string", "项目名", "45", "text", ""}, {"string", "项目实践主题", "2000", "text", ""}, {"string", "项目开始实践", "45", "text", ""}, {"string", "项目结束时间", "45", "text", ""}, {"string", "经费资助", "255", "text", ""}, {"string", "团队组织要求", "255", "text", ""}, {"string", "立项程序及日程", "255", "text", ""}, {"string", "工作要求", "255", "text", ""}, {"string", "其他说明", "255", "text", ""}, {"string", "项目添加时间", "45", "hidden", ""}, {"string", "添加用户名", "45", "hidden", ""}, {"string", "添加用户编号", "45", "hidden", ""}, {"string", "添加单位", "45", "hidden", ""}, {"string", "添加文件列表", "255", "hidden", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "PracticeCode", "PracticeName", "PracticeSubject", "Starttime", "Endtime", "Funding", "TeamDemand", "Schedule", "WorkDemand", "OtherExplain", "Addtime", "AddAccount", "AddUserrole", "AddAcademy", "AddFilelist", "Remark", "Remark2", "Remark3", "Remark4", "Remark5", "Remark6"};
private String[] ListFields = {"PracticeCode", "PracticeName", "PracticeSubject", "Starttime", "Endtime", "Funding", "TeamDemand", "Schedule", "WorkDemand", "OtherExplain", "Remark", "Remark2", "Remark3", "Remark4", "Remark5", "Remark6"};
private String[] FormFields = {"PracticeCode", "PracticeName", "PracticeSubject", "Starttime", "Endtime", "Funding", "TeamDemand", "Schedule", "WorkDemand", "OtherExplain", "Addtime", "AddAccount", "AddUserrole", "AddAcademy", "AddFilelist", "Remark", "Remark2", "Remark3", "Remark4", "Remark5", "Remark6"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private Practice getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Practice v = new Practice();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramPracticeCode(request, "PracticeCode");
        v.paramPracticeName(request, "PracticeName");
        v.paramPracticeSubject(request, "PracticeSubject");
        v.paramStarttime(request, "Starttime");
        v.paramEndtime(request, "Endtime");
        v.paramFunding(request, "Funding");
        v.paramTeamDemand(request, "TeamDemand");
        v.paramSchedule(request, "Schedule");
        v.paramWorkDemand(request, "WorkDemand");
        v.paramOtherExplain(request, "OtherExplain");
        v.paramAddtime(request, "Addtime");
        v.paramAddAccount(request, "AddAccount");
        v.paramAddUserrole(request, "AddUserrole");
        v.paramAddAcademy(request, "AddAcademy");
        v.paramAddFilelist(request, "AddFilelist");
        v.paramRemark(request, "Remark");
        v.paramRemark2(request, "Remark2");
        v.paramRemark3(request, "Remark3");
        v.paramRemark4(request, "Remark4");
        v.paramRemark5(request, "Remark5");
        v.paramRemark6(request, "Remark6");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setPracticeCode(ParamUtils.getParameter(request, "PracticeCode", ""));
        v.setPracticeName(ParamUtils.getParameter(request, "PracticeName", ""));
        v.setPracticeSubject(ParamUtils.getParameter(request, "PracticeSubject", ""));
        v.setStarttime(ParamUtils.getParameter(request, "Starttime", ""));
        v.setEndtime(ParamUtils.getParameter(request, "Endtime", ""));
        v.setFunding(ParamUtils.getParameter(request, "Funding", ""));
        v.setTeamDemand(ParamUtils.getParameter(request, "TeamDemand", ""));
        v.setSchedule(ParamUtils.getParameter(request, "Schedule", ""));
        v.setWorkDemand(ParamUtils.getParameter(request, "WorkDemand", ""));
        v.setOtherExplain(ParamUtils.getParameter(request, "OtherExplain", ""));
        v.setAddtime(ParamUtils.getParameter(request, "Addtime", ""));
        v.setAddAccount(ParamUtils.getParameter(request, "AddAccount", ""));
        v.setAddUserrole(ParamUtils.getParameter(request, "AddUserrole", ""));
        v.setAddAcademy(ParamUtils.getParameter(request, "AddAcademy", ""));
        v.setAddFilelist(ParamUtils.getParameter(request, "AddFilelist", ""));
        v.setRemark(ParamUtils.getParameter(request, "Remark", ""));
        v.setRemark2(ParamUtils.getParameter(request, "Remark2", ""));
        v.setRemark3(ParamUtils.getParameter(request, "Remark3", ""));
        v.setRemark4(ParamUtils.getParameter(request, "Remark4", ""));
        v.setRemark5(ParamUtils.getParameter(request, "Remark5", ""));
        v.setRemark6(ParamUtils.getParameter(request, "Remark6", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Practice pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Practice v = (Practice)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getPracticeCode()));
        row.add(Tool.jsSpecialChars(v.getPracticeName()));
        row.add(Tool.jsSpecialChars(v.getPracticeSubject()));
        row.add(Tool.jsSpecialChars(v.getStarttime()));
        row.add(Tool.jsSpecialChars(v.getEndtime()));
        row.add(Tool.jsSpecialChars(v.getFunding()));
        row.add(Tool.jsSpecialChars(v.getTeamDemand()));
        row.add(Tool.jsSpecialChars(v.getSchedule()));
        row.add(Tool.jsSpecialChars(v.getWorkDemand()));
        row.add(Tool.jsSpecialChars(v.getOtherExplain()));
        row.add(Tool.jsSpecialChars(v.getAddtime()));
        row.add(Tool.jsSpecialChars(v.getAddAccount()));
        row.add(Tool.jsSpecialChars(v.getAddUserrole()));
        row.add(Tool.jsSpecialChars(v.getAddAcademy()));
        row.add(Tool.jsSpecialChars(v.getAddFilelist()));
        row.add(Tool.jsSpecialChars(v.getRemark()));
        row.add(Tool.jsSpecialChars(v.getRemark2()));
        row.add(Tool.jsSpecialChars(v.getRemark3()));
        row.add(Tool.jsSpecialChars(v.getRemark4()));
        row.add(Tool.jsSpecialChars(v.getRemark5()));
        row.add(Tool.jsSpecialChars(v.getRemark6()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Practice pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Practice pv, boolean isAll)
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
    Practice pv = new Practice();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Practice");
    request.setAttribute("describe", "社会实践项目团委立项表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Practice pv = new Practice();
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
private void setForm(javax.servlet.http.HttpServletRequest request, Practice form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Practice");
    request.setAttribute("describe", "社会实践项目团委立项表");
}
private List mkRtn(String cmd, String forward, Practice form)
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
    Practice form = getByParameterDb(request);
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
log.debug("PracticeAction");
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
forwardMap.put("list", "PracticeAction.jsp");
forwardMap.put("failure", "PracticeForm.jsp");
forwardMap.put("success", "PracticeList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "PracticeForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='PracticeAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
