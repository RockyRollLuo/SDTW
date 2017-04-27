<%@ page language="java" %>
<%--团建课题各学院上传资料--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(SubjectFile.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "SubjectCode", "Academy", "Principal", "Contact", "Checkflag", "Addtime", "CheckAccount", "CheckTime", "AddFileList", "AddAcount"};
private String[] DicKeys = {"Id", "SubjectCode", "Academy", "Principal", "Contact", "Checkflag", "Addtime", "CheckAccount", "CheckTime", "AddFileList", "AddAcount"};
private String[][] DicValues = {{"int", "id", "0", "hidden", ""}, {"string", "课题编码", "50", "text", ""}, {"string", "学院", "50", "AcademyName", ""}, {"string", "负责人", "50", "text", ""}, {"string", "联系方式", "50", "text", ""}, {"int", "审核状态", "0", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "添加账号", "50", "hidden", ""}, {"date", "审核时间", "0", "hidden", ""}, {"string", "附件", "50", "hidden", ""}, {"string", "添加人", "50", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "SubjectCode", "Academy", "Principal", "Contact", "Checkflag", "Addtime", "CheckAccount", "CheckTime", "AddFileList", "AddAcount"};
private String[] ListFields = {"SubjectCode", "Academy", "Principal", "Contact"};
private String[] FormFields = {"SubjectCode", "Academy", "Principal", "Contact", "AddFileList"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private SubjectFile getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    SubjectFile v = new SubjectFile();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramSubjectCode(request, "SubjectCode");
        v.paramAcademy(request, "Academy");
        v.paramPrincipal(request, "Principal");
        v.paramContact(request, "Contact");
        v.paramCheckflag(request, "Checkflag");
        v.paramAddtime(request, "Addtime");
        v.paramCheckAccount(request, "CheckAccount");
        v.paramCheckTime(request, "CheckTime");
        v.paramAddFileList(request, "AddFileList");
        v.paramAddAcount(request, "AddAcount");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setSubjectCode(ParamUtils.getParameter(request, "SubjectCode", ""));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setPrincipal(ParamUtils.getParameter(request, "Principal", ""));
        v.setContact(ParamUtils.getParameter(request, "Contact", ""));
        v.setCheckflag(ParamUtils.getIntParameter(request, "Checkflag", 1));
        v.setAddtime(ParamUtils.getDateTimeParameter(request, "Addtime", java.sql.Date.valueOf("0001-01-01")));
        v.setCheckAccount(ParamUtils.getParameter(request, "CheckAccount", ""));
        v.setCheckTime(ParamUtils.getDateTimeParameter(request, "CheckTime", java.sql.Date.valueOf("0001-01-01")));
        v.setAddFileList(ParamUtils.getParameter(request, "AddFileList", ""));
        v.setAddAcount(ParamUtils.getParameter(request, "AddAcount", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, SubjectFile pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        SubjectFile v = (SubjectFile)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getSubjectCode()));
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add(Tool.jsSpecialChars(v.getPrincipal()));
        row.add(Tool.jsSpecialChars(v.getContact()));
        row.add("" + v.getCheckflag());
        row.add(Tool.stringOfDate(v.getAddtime()));
        row.add(Tool.jsSpecialChars(v.getCheckAccount()));
        row.add(Tool.stringOfDate(v.getCheckTime()));
        row.add(Tool.jsSpecialChars(v.getAddFileList()));
        row.add(Tool.jsSpecialChars(v.getAddAcount()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, SubjectFile pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, SubjectFile pv, boolean isAll)
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
    SubjectFile pv = new SubjectFile();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "SubjectFile");
    request.setAttribute("describe", "团建课题各学院上传资料");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    SubjectFile pv = new SubjectFile();
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
private void setForm(javax.servlet.http.HttpServletRequest request, SubjectFile form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "SubjectFile");
    request.setAttribute("describe", "团建课题各学院上传资料");
}
private List mkRtn(String cmd, String forward, SubjectFile form)
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
    SubjectFile form = getByParameterDb(request);
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
log.debug("SubjectFileAction");
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
forwardMap.put("list", "SubjectFileAction.jsp");
forwardMap.put("failure", "SubjectFileForm.jsp");
forwardMap.put("success", "SubjectFileList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "SubjectFileForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='SubjectFileAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
