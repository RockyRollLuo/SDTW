<%@ page language="java" %>
<%--团校培训管理--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(TrainingArrangement.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ProjectName", "HostName", "HostId", "OtherUniversity", "AddUseraccount", "StartTime", "EndTime", "AddTime", "AddPerson", "ModifyTime", "ModifyUseraccount", "ModifyPerson", "AddFileList", "ProjectExplain"};
private String[] DicKeys = {"Id", "ProjectName", "HostName", "HostId", "OtherUniversity", "AddUseraccount", "StartTime", "EndTime", "AddTime", "AddPerson", "ModifyTime", "ModifyUseraccount", "ModifyPerson", "AddFileList", "ProjectExplain"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "学习项目名称", "2000", "text", ""}, {"string", "负责人", "2000", "text", ""}, {"string", "负责人id", "2000", "text", ""}, {"int", "是否外校", "0", "text", ""}, {"string", "校外负责人学校", "2000", "hidden", ""}, {"date", "开始时间", "0", "hidden", ""}, {"date", "结束时间", "0", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "添加人", "2000", "hidden", ""}, {"date", "修改时间", "0", "hidden", ""}, {"string", "修改人账号", "2000", "hidden", ""}, {"string", "修改人", "2000", "hidden", ""}, {"string", "附件", "2000", "hidden", ""}, {"string", "项目说明", "2000", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ProjectName", "HostName", "HostId", "OtherUniversity", "AddUseraccount", "StartTime", "EndTime", "AddTime", "AddPerson", "ModifyTime", "ModifyUseraccount", "ModifyPerson", "AddFileList", "ProjectExplain"};
private String[] ListFields = {"ProjectName", "HostName", "HostId", "OtherUniversity", "ProjectExplain"};
private String[] FormFields = {"ProjectName", "HostName", "HostId", "OtherUniversity", "AddUseraccount", "StartTime", "EndTime", "AddTime", "AddPerson", "ModifyTime", "ModifyUseraccount", "ModifyPerson", "AddFileList", "ProjectExplain"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private TrainingArrangement getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    TrainingArrangement v = new TrainingArrangement();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramProjectName(request, "ProjectName");
        v.paramHostName(request, "HostName");
        v.paramHostId(request, "HostId");
        v.paramOtherUniversity(request, "OtherUniversity");
        v.paramAddUseraccount(request, "AddUseraccount");
        v.paramStartTime(request, "StartTime");
        v.paramEndTime(request, "EndTime");
        v.paramAddTime(request, "AddTime");
        v.paramAddPerson(request, "AddPerson");
        v.paramModifyTime(request, "ModifyTime");
        v.paramModifyUseraccount(request, "ModifyUseraccount");
        v.paramModifyPerson(request, "ModifyPerson");
        v.paramAddFileList(request, "AddFileList");
        v.paramProjectExplain(request, "ProjectExplain");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setProjectName(ParamUtils.getParameter(request, "ProjectName", ""));
        v.setHostName(ParamUtils.getParameter(request, "HostName", ""));
        v.setHostId(ParamUtils.getParameter(request, "HostId", ""));
        v.setOtherUniversity(ParamUtils.getIntParameter(request, "OtherUniversity", 0));
        v.setAddUseraccount(ParamUtils.getParameter(request, "AddUseraccount", ""));
        v.setStartTime(ParamUtils.getDateTimeParameter(request, "StartTime", java.sql.Date.valueOf("0001-01-01")));
        v.setEndTime(ParamUtils.getDateTimeParameter(request, "EndTime", java.sql.Date.valueOf("0001-01-01")));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setAddPerson(ParamUtils.getParameter(request, "AddPerson", ""));
        v.setModifyTime(ParamUtils.getDateTimeParameter(request, "ModifyTime", java.sql.Date.valueOf("0001-01-01")));
        v.setModifyUseraccount(ParamUtils.getParameter(request, "ModifyUseraccount", ""));
        v.setModifyPerson(ParamUtils.getParameter(request, "ModifyPerson", ""));
        v.setAddFileList(ParamUtils.getParameter(request, "AddFileList", ""));
        v.setProjectExplain(ParamUtils.getParameter(request, "ProjectExplain", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, TrainingArrangement pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        TrainingArrangement v = (TrainingArrangement)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getProjectName()));
        row.add(Tool.jsSpecialChars(v.getHostName()));
        row.add(Tool.jsSpecialChars(v.getHostId()));
        row.add("" + v.getOtherUniversity());
        row.add(Tool.jsSpecialChars(v.getAddUseraccount()));
        row.add(Tool.stringOfDate(v.getStartTime()));
        row.add(Tool.stringOfDate(v.getEndTime()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.stringOfDate(v.getModifyTime()));
        row.add(Tool.jsSpecialChars(v.getModifyUseraccount()));
        row.add(Tool.jsSpecialChars(v.getModifyPerson()));
        row.add(Tool.jsSpecialChars(v.getAddFileList()));
        row.add(Tool.jsSpecialChars(v.getProjectExplain()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, TrainingArrangement pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, TrainingArrangement pv, boolean isAll)
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
    TrainingArrangement pv = new TrainingArrangement();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "TrainingArrangement");
    request.setAttribute("describe", "团校培训管理");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    TrainingArrangement pv = new TrainingArrangement();
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
private void setForm(javax.servlet.http.HttpServletRequest request, TrainingArrangement form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "TrainingArrangement");
    request.setAttribute("describe", "团校培训管理");
}
private List mkRtn(String cmd, String forward, TrainingArrangement form)
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
    TrainingArrangement form = getByParameterDb(request);
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
log.debug("TrainingArrangementAction");
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
forwardMap.put("list", "TrainingArrangementAction.jsp");
forwardMap.put("failure", "TrainingArrangementForm.jsp");
forwardMap.put("success", "TrainingArrangementList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "TrainingArrangementForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='TrainingArrangementAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
