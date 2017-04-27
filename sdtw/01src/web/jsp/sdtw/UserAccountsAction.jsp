<%@ page language="java" %>
<%--用户表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(UserAccounts.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "UserAccount", "PassWord", "TrueName", "Sex", "NickName", "UserRole", "UserGroupList", "AccountState", "WorkUnit", "Academy", "MyLastLoginIp", "MyLastLoginTime", "Birthday", "Email", "Mobiltel", "HomeAddress", "HomeTel", "OfficeTel", "Fax", "OfficeAddress", "Question1", "Answer1", "City", "Addperson", "Addtime"};
private String[] DicKeys = {"Id", "UserAccount", "PassWord", "TrueName", "Sex", "NickName", "UserRole", "UserGroupList", "AccountState", "WorkUnit", "Academy", "MyLastLoginIp", "MyLastLoginTime", "Birthday", "Email", "Mobiltel", "HomeAddress", "HomeTel", "OfficeTel", "Fax", "OfficeAddress", "Question1", "Answer1", "City", "Addperson", "Addtime"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "用户账号", "0", "text", ""}, {"string", "密码", "45", "text", ""}, {"string", "真实姓名", "45", "text", ""}, {"string", "性别", "4", "sex", ""}, {"string", "昵称", "45", "text", ""}, {"string", "用户角色", "10", "RoleName", ""}, {"string", "用户分组", "45", "text", ""}, {"string", "账号状态", "45", "hidden", ""}, {"string", "工作单位", "45", "text", ""}, {"string", "学院", "45", "AcademyName", ""}, {"string", "最后登录ip", "45", "text", ""}, {"date", "最后登录时间", "0", "hidden", ""}, {"date", "生日", "0", "text", ""}, {"string", "邮箱", "45", "text", ""}, {"string", "手机", "45", "text", ""}, {"string", "家庭地址", "45", "text", ""}, {"string", "家庭电话", "45", "text", ""}, {"string", "办公电话", "45", "text", ""}, {"string", "传真", "45", "text", ""}, {"string", "办公地址", "45", "text", ""}, {"string", "问题1", "45", "text", ""}, {"string", "回答1", "45", "text", ""}, {"string", "城市", "45", "OrgCityName", ""}, {"string", "添加人", "45", "hidden", ""}, {"string", "添加时间", "45", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "UserAccount", "PassWord", "TrueName", "Sex", "NickName", "UserRole", "UserGroupList", "AccountState", "WorkUnit", "Academy", "MyLastLoginIp", "MyLastLoginTime", "Birthday", "Email", "Mobiltel", "HomeAddress", "HomeTel", "OfficeTel", "Fax", "OfficeAddress", "Question1", "Answer1", "City", "Addperson", "Addtime"};
private String[] ListFields = {"UserAccount", "PassWord", "TrueName", "Sex", "NickName", "UserRole", "UserGroupList", "WorkUnit", "Academy", "MyLastLoginIp", "Birthday", "Email", "Mobiltel", "HomeAddress", "HomeTel", "OfficeTel", "Fax", "OfficeAddress", "Question1", "Answer1", "City"};
private String[] FormFields = {"UserAccount", "PassWord", "TrueName", "Sex", "NickName", "UserRole", "UserGroupList", "AccountState", "WorkUnit", "Academy", "MyLastLoginIp", "Birthday", "Email", "Mobiltel", "HomeAddress", "HomeTel", "OfficeTel", "Fax", "OfficeAddress", "Question1", "Answer1", "City"};
private String[] QueryFields = {"UserAccount", "TrueName"};
private String[] HideFields = {"Id"};
private UserAccounts getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    UserAccounts v = new UserAccounts();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramUserAccount(request, "UserAccount");
        v.paramPassWord(request, "PassWord");
        v.paramTrueName(request, "TrueName");
        v.paramSex(request, "Sex");
        v.paramNickName(request, "NickName");
        v.paramUserRole(request, "UserRole");
        v.paramUserGroupList(request, "UserGroupList");
        v.paramAccountState(request, "AccountState");
        v.paramWorkUnit(request, "WorkUnit");
        v.paramAcademy(request, "Academy");
        v.paramMyLastLoginIp(request, "MyLastLoginIp");
        v.paramMyLastLoginTime(request, "MyLastLoginTime");
        v.paramBirthday(request, "Birthday");
        v.paramEmail(request, "Email");
        v.paramMobiltel(request, "Mobiltel");
        v.paramHomeAddress(request, "HomeAddress");
        v.paramHomeTel(request, "HomeTel");
        v.paramOfficeTel(request, "OfficeTel");
        v.paramFax(request, "Fax");
        v.paramOfficeAddress(request, "OfficeAddress");
        v.paramQuestion1(request, "Question1");
        v.paramAnswer1(request, "Answer1");
        v.paramCity(request, "City");
        v.paramAddperson(request, "Addperson");
        v.paramAddtime(request, "Addtime");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setUserAccount(ParamUtils.getIntParameter(request, "UserAccount", -1));
        v.setPassWord(ParamUtils.getParameter(request, "PassWord", ""));
        v.setTrueName(ParamUtils.getParameter(request, "TrueName", ""));
        v.setSex(ParamUtils.getParameter(request, "Sex", ""));
        v.setNickName(ParamUtils.getParameter(request, "NickName", ""));
        v.setUserRole(ParamUtils.getParameter(request, "UserRole", ""));
        v.setUserGroupList(ParamUtils.getParameter(request, "UserGroupList", ""));
        v.setAccountState(ParamUtils.getParameter(request, "AccountState", ""));
        v.setWorkUnit(ParamUtils.getParameter(request, "WorkUnit", ""));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setMyLastLoginIp(ParamUtils.getParameter(request, "MyLastLoginIp", ""));
        v.setMyLastLoginTime(ParamUtils.getDateTimeParameter(request, "MyLastLoginTime", java.sql.Date.valueOf("0001-01-01")));
        v.setBirthday(ParamUtils.getDateTimeParameter(request, "Birthday", java.sql.Date.valueOf("0001-01-01")));
        v.setEmail(ParamUtils.getParameter(request, "Email", ""));
        v.setMobiltel(ParamUtils.getParameter(request, "Mobiltel", ""));
        v.setHomeAddress(ParamUtils.getParameter(request, "HomeAddress", ""));
        v.setHomeTel(ParamUtils.getParameter(request, "HomeTel", ""));
        v.setOfficeTel(ParamUtils.getParameter(request, "OfficeTel", ""));
        v.setFax(ParamUtils.getParameter(request, "Fax", ""));
        v.setOfficeAddress(ParamUtils.getParameter(request, "OfficeAddress", ""));
        v.setQuestion1(ParamUtils.getParameter(request, "Question1", ""));
        v.setAnswer1(ParamUtils.getParameter(request, "Answer1", ""));
        v.setCity(ParamUtils.getParameter(request, "City", ""));
        v.setAddperson(ParamUtils.getParameter(request, "Addperson", ""));
        v.setAddtime(ParamUtils.getParameter(request, "Addtime", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, UserAccounts pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map OrgCityNamemap = CEditConst.getOrgCityNameMap(userInfo);
    Map sexmap = CEditConst.getsexMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map RoleNamemap = CEditConst.getRoleNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        UserAccounts v = (UserAccounts)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add("" + v.getUserAccount());
        row.add(Tool.jsSpecialChars(v.getPassWord()));
        row.add(Tool.jsSpecialChars(v.getTrueName()));
        row.add((String)sexmap.get("" + v.getSex()));
        row.add(Tool.jsSpecialChars(v.getNickName()));
        row.add((String)RoleNamemap.get("" + v.getUserRole()));
        row.add(Tool.jsSpecialChars(v.getUserGroupList()));
        row.add(Tool.jsSpecialChars(v.getAccountState()));
        row.add(Tool.jsSpecialChars(v.getWorkUnit()));
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add(Tool.jsSpecialChars(v.getMyLastLoginIp()));
        row.add(Tool.stringOfDate(v.getMyLastLoginTime()));
        row.add(Tool.stringOfDate(v.getBirthday()));
        row.add(Tool.jsSpecialChars(v.getEmail()));
        row.add(Tool.jsSpecialChars(v.getMobiltel()));
        row.add(Tool.jsSpecialChars(v.getHomeAddress()));
        row.add(Tool.jsSpecialChars(v.getHomeTel()));
        row.add(Tool.jsSpecialChars(v.getOfficeTel()));
        row.add(Tool.jsSpecialChars(v.getFax()));
        row.add(Tool.jsSpecialChars(v.getOfficeAddress()));
        row.add(Tool.jsSpecialChars(v.getQuestion1()));
        row.add(Tool.jsSpecialChars(v.getAnswer1()));
        row.add((String)OrgCityNamemap.get("" + v.getCity()));
        row.add(Tool.jsSpecialChars(v.getAddperson()));
        row.add(Tool.jsSpecialChars(v.getAddtime()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, UserAccounts pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, UserAccounts pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_UserAccount_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("useraccount=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_TrueName_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("truename like '%" + qval + "%'");
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
    UserAccounts pv = new UserAccounts();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "UserAccounts");
    request.setAttribute("describe", "用户表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    UserAccounts pv = new UserAccounts();
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
private void setForm(javax.servlet.http.HttpServletRequest request, UserAccounts form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("OrgCityNameoptions", CEditConst.getOrgCityNameOptions(userInfo, ""));
    request.setAttribute("sexoptions", CEditConst.getsexOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("RoleNameoptions", CEditConst.getRoleNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "UserAccounts");
    request.setAttribute("describe", "用户表");
}
private List mkRtn(String cmd, String forward, UserAccounts form)
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
    UserAccounts form = getByParameterDb(request);
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
log.debug("UserAccountsAction");
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
forwardMap.put("list", "UserAccountsAction.jsp");
forwardMap.put("failure", "UserAccountsForm.jsp");
forwardMap.put("success", "UserAccountsList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "UserAccountsForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='UserAccountsAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
