<%@ page language="java" %>
<%--在线用户--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(BaseOnlineUser.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "OrgId", "DeptId", "Occupation", "LogonTime", "LastTime", "LockTime", "LockList"};
private String[] DicKeys = {"Id", "OrgId", "DeptId", "Occupation", "LogonTime", "LastTime", "LockTime", "LockList"};
private String[][] DicValues = {{"int", "Id", "0", "UserName", ""}, {"int", "单位", "0", "OrgName", ""}, {"int", "部门", "0", "DeptName", ""}, {"string", "职务", "100", "text", ""}, {"date", "登录时间", "0", "hidden", ""}, {"date", "最近时间", "0", "hidden", ""}, {"date", "锁定时间", "0", "hidden", ""}, {"string", "锁定", "100", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "OrgId", "DeptId", "Occupation", "LogonTime", "LastTime", "LockTime", "LockList"};
private String[] ListFields = {"Id", "OrgId", "DeptId", "Occupation"};
private String[] FormFields = {"OrgId", "DeptId", "Occupation", "LogonTime", "LastTime", "LockTime", "LockList"};
private String[] QueryFields = {"OrgId", "DeptId"};
private String[] HideFields = {"Id"};
private BaseOnlineUser getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    BaseOnlineUser v = new BaseOnlineUser();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramOrgId(request, "OrgId");
        v.paramDeptId(request, "DeptId");
        v.paramOccupation(request, "Occupation");
        v.paramLogonTime(request, "LogonTime");
        v.paramLastTime(request, "LastTime");
        v.paramLockTime(request, "LockTime");
        v.paramLockList(request, "LockList");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setOrgId(ParamUtils.getIntParameter(request, "OrgId", -1));
        v.setDeptId(ParamUtils.getIntParameter(request, "DeptId", -1));
        v.setOccupation(ParamUtils.getParameter(request, "Occupation", ""));
        v.setLogonTime(ParamUtils.getDateTimeParameter(request, "LogonTime", java.sql.Date.valueOf("0001-01-01")));
        v.setLastTime(ParamUtils.getDateTimeParameter(request, "LastTime", java.sql.Date.valueOf("0001-01-01")));
        v.setLockTime(ParamUtils.getDateTimeParameter(request, "LockTime", java.sql.Date.valueOf("0001-01-01")));
        v.setLockList(ParamUtils.getParameter(request, "LockList", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, BaseOnlineUser pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map UserNamemap = CEditConst.getUserNameMap(userInfo);
    Map DeptNamemap = CEditConst.getDeptNameMap(userInfo);
    Map OrgNamemap = CEditConst.getOrgNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        BaseOnlineUser v = (BaseOnlineUser)it.next();
        List row = new ArrayList();
        row.add((String)UserNamemap.get("" + v.getId()));
        row.add((String)OrgNamemap.get("" + v.getOrgId()));
        row.add((String)DeptNamemap.get("" + v.getDeptId()));
        row.add(Tool.jsSpecialChars(v.getOccupation()));
        row.add(Tool.stringOfDate(v.getLogonTime()));
        row.add(Tool.stringOfDate(v.getLastTime()));
        row.add(Tool.stringOfDate(v.getLockTime()));
        row.add(Tool.jsSpecialChars(v.getLockList()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, BaseOnlineUser pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, BaseOnlineUser pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_OrgId_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("orgid=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_DeptId_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("deptid=" + qval);
    }
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
    request.setAttribute("DeptNameoptions", CEditConst.getDeptNameOptions(userInfo, "-1"));
    request.setAttribute("OrgNameoptions", CEditConst.getOrgNameOptions(userInfo, "-1"));
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
    BaseOnlineUser pv = new BaseOnlineUser();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "BaseOnlineUser");
    request.setAttribute("describe", "在线用户");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    BaseOnlineUser pv = new BaseOnlineUser();
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
private void setForm(javax.servlet.http.HttpServletRequest request, BaseOnlineUser form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("DeptNameoptions", CEditConst.getDeptNameOptions(userInfo, "-1"));
    request.setAttribute("OrgNameoptions", CEditConst.getOrgNameOptions(userInfo, "-1"));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "BaseOnlineUser");
    request.setAttribute("describe", "在线用户");
}
private List mkRtn(String cmd, String forward, BaseOnlineUser form)
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
    BaseOnlineUser form = getByParameterDb(request);
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
log.debug("BaseOnlineUserAction");
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
forwardMap.put("list", "BaseOnlineUserAction.jsp");
forwardMap.put("failure", "BaseOnlineUserForm.jsp");
forwardMap.put("success", "BaseOnlineUserList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "BaseOnlineUserForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='BaseOnlineUserAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
