<%@ page language="java" %>
<%--通讯录成员信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(AddBookPerson.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "UserAccount", "Groupid", "MyNums", "PersonName", "PersonAccount", "PersonId", "WorkDepartment", "OfficeTel", "MobileTel", "HomeTel", "Email", "OthersInfo", "AddTime"};
private String[] DicKeys = {"Id", "UserAccount", "Groupid", "MyNums", "PersonName", "PersonAccount", "PersonId", "WorkDepartment", "OfficeTel", "MobileTel", "HomeTel", "Email", "OthersInfo", "AddTime"};
private String[][] DicValues = {{"int", "id", "0", "hidden", ""}, {"string", "账号", "45", "text", ""}, {"string", "分组id", "45", "hidden", ""}, {"string", "成员数目", "45", "text", ""}, {"string", "姓名", "45", "text", ""}, {"string", "账号", "45", "text", ""}, {"string", "用户id", "45", "text", ""}, {"string", "工作单位", "45", "text", ""}, {"string", "办公电话", "45", "text", ""}, {"string", "手机", "45", "text", ""}, {"string", "家庭电话", "45", "text", ""}, {"string", "邮箱", "45", "text", ""}, {"string", "其他信息", "45", "text", ""}, {"string", "添加时间", "45", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "UserAccount", "Groupid", "MyNums", "PersonName", "PersonAccount", "PersonId", "WorkDepartment", "OfficeTel", "MobileTel", "HomeTel", "Email", "OthersInfo", "AddTime"};
private String[] ListFields = {"UserAccount", "MyNums", "PersonName", "PersonAccount", "PersonId", "WorkDepartment", "OfficeTel", "MobileTel", "HomeTel", "Email", "OthersInfo"};
private String[] FormFields = {"UserAccount", "MyNums", "PersonName", "PersonAccount", "PersonId", "WorkDepartment", "OfficeTel", "MobileTel", "HomeTel", "Email", "OthersInfo"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private AddBookPerson getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    AddBookPerson v = new AddBookPerson();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramUserAccount(request, "UserAccount");
        v.paramGroupid(request, "Groupid");
        v.paramMyNums(request, "MyNums");
        v.paramPersonName(request, "PersonName");
        v.paramPersonAccount(request, "PersonAccount");
        v.paramPersonId(request, "PersonId");
        v.paramWorkDepartment(request, "WorkDepartment");
        v.paramOfficeTel(request, "OfficeTel");
        v.paramMobileTel(request, "MobileTel");
        v.paramHomeTel(request, "HomeTel");
        v.paramEmail(request, "Email");
        v.paramOthersInfo(request, "OthersInfo");
        v.paramAddTime(request, "AddTime");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setUserAccount(ParamUtils.getParameter(request, "UserAccount", ""));
        v.setGroupid(ParamUtils.getParameter(request, "Groupid", ""));
        v.setMyNums(ParamUtils.getParameter(request, "MyNums", ""));
        v.setPersonName(ParamUtils.getParameter(request, "PersonName", ""));
        v.setPersonAccount(ParamUtils.getParameter(request, "PersonAccount", ""));
        v.setPersonId(ParamUtils.getParameter(request, "PersonId", ""));
        v.setWorkDepartment(ParamUtils.getParameter(request, "WorkDepartment", ""));
        v.setOfficeTel(ParamUtils.getParameter(request, "OfficeTel", ""));
        v.setMobileTel(ParamUtils.getParameter(request, "MobileTel", ""));
        v.setHomeTel(ParamUtils.getParameter(request, "HomeTel", ""));
        v.setEmail(ParamUtils.getParameter(request, "Email", ""));
        v.setOthersInfo(ParamUtils.getParameter(request, "OthersInfo", ""));
        v.setAddTime(ParamUtils.getParameter(request, "AddTime", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, AddBookPerson pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        AddBookPerson v = (AddBookPerson)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getUserAccount()));
        row.add(Tool.jsSpecialChars(v.getGroupid()));
        row.add(Tool.jsSpecialChars(v.getMyNums()));
        row.add(Tool.jsSpecialChars(v.getPersonName()));
        row.add(Tool.jsSpecialChars(v.getPersonAccount()));
        row.add(Tool.jsSpecialChars(v.getPersonId()));
        row.add(Tool.jsSpecialChars(v.getWorkDepartment()));
        row.add(Tool.jsSpecialChars(v.getOfficeTel()));
        row.add(Tool.jsSpecialChars(v.getMobileTel()));
        row.add(Tool.jsSpecialChars(v.getHomeTel()));
        row.add(Tool.jsSpecialChars(v.getEmail()));
        row.add(Tool.jsSpecialChars(v.getOthersInfo()));
        row.add(Tool.jsSpecialChars(v.getAddTime()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, AddBookPerson pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, AddBookPerson pv, boolean isAll)
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
    AddBookPerson pv = new AddBookPerson();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "AddBookPerson");
    request.setAttribute("describe", "通讯录成员信息");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    AddBookPerson pv = new AddBookPerson();
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
private void setForm(javax.servlet.http.HttpServletRequest request, AddBookPerson form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "AddBookPerson");
    request.setAttribute("describe", "通讯录成员信息");
}
private List mkRtn(String cmd, String forward, AddBookPerson form)
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
    AddBookPerson form = getByParameterDb(request);
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
log.debug("AddBookPersonAction");
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
forwardMap.put("list", "AddBookPersonAction.jsp");
forwardMap.put("failure", "AddBookPersonForm.jsp");
forwardMap.put("success", "AddBookPersonList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "AddBookPersonForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='AddBookPersonAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
