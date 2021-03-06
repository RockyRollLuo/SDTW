<%@ page language="java" %>
<%--团支部达标升级文件上报--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(StandardupGrade_File.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "StandardUpGradeName", "Academy", "Principal", "Contact", "AddFileList", "AddAccount", "AddTime", "CheckTime", "ChackFlag", "ApplyLevelType", "ZBName", "ZBNums"};
private String[] DicKeys = {"Id", "StandardUpGradeName", "Academy", "Principal", "Contact", "AddFileList", "AddAccount", "AddTime", "CheckTime", "ChackFlag", "ApplyLevelType", "ZBName", "ZBNums"};
private String[][] DicValues = {{"int", "Id", "0", "UserName", ""}, {"string", "团支部达标升级Id", "45", "StandardUpGradeName", ""}, {"string", "学院", "45", "AcademyName", ""}, {"string", "发布人", "45", "text", ""}, {"string", "联系方式", "45", "hidden", ""}, {"string", "附件", "2000", "hidden", ""}, {"string", "操作人", "45", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"date", "审核时间", "0", "hidden", ""}, {"string", "审核状态", "45", "hidden", ""}, {"string", "申报级别", "45", "ApplyLevelType", ""}, {"string", "团支部名称", "45", "text", ""}, {"int", "团支部人数", "0", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "StandardUpGradeName", "Academy", "Principal", "Contact", "AddFileList", "AddAccount", "AddTime", "CheckTime", "ChackFlag", "ApplyLevelType", "ZBName", "ZBNums"};
private String[] ListFields = {"Id", "StandardUpGradeName", "Academy", "Principal", "ApplyLevelType", "ZBName", "ZBNums"};
private String[] FormFields = {"StandardUpGradeName", "Academy", "Principal", "Contact", "AddFileList", "AddAccount", "AddTime", "CheckTime", "ChackFlag", "ApplyLevelType", "ZBName", "ZBNums"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private StandardupGrade_File getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    StandardupGrade_File v = new StandardupGrade_File();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramStandardUpGradeName(request, "StandardUpGradeName");
        v.paramAcademy(request, "Academy");
        v.paramPrincipal(request, "Principal");
        v.paramContact(request, "Contact");
        v.paramAddFileList(request, "AddFileList");
        v.paramAddAccount(request, "AddAccount");
        v.paramAddTime(request, "AddTime");
        v.paramCheckTime(request, "CheckTime");
        v.paramChackFlag(request, "ChackFlag");
        v.paramApplyLevelType(request, "ApplyLevelType");
        v.paramZBName(request, "ZBName");
        v.paramZBNums(request, "ZBNums");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setStandardUpGradeName(ParamUtils.getParameter(request, "StandardUpGradeName", ""));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setPrincipal(ParamUtils.getParameter(request, "Principal", ""));
        v.setContact(ParamUtils.getParameter(request, "Contact", ""));
        v.setAddFileList(ParamUtils.getParameter(request, "AddFileList", ""));
        v.setAddAccount(ParamUtils.getParameter(request, "AddAccount", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setCheckTime(ParamUtils.getDateTimeParameter(request, "CheckTime", java.sql.Date.valueOf("0001-01-01")));
        v.setChackFlag(ParamUtils.getParameter(request, "ChackFlag", ""));
        v.setApplyLevelType(ParamUtils.getParameter(request, "ApplyLevelType", ""));
        v.setZBName(ParamUtils.getParameter(request, "ZBName", ""));
        v.setZBNums(ParamUtils.getIntParameter(request, "ZBNums", -1));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, StandardupGrade_File pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map UserNamemap = CEditConst.getUserNameMap(userInfo);
    Map StandardUpGradeNamemap = CEditConst.getStandardUpGradeNameMap(userInfo);
    Map ApplyLevelTypemap = CEditConst.getApplyLevelTypeMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        StandardupGrade_File v = (StandardupGrade_File)it.next();
        List row = new ArrayList();
        row.add((String)UserNamemap.get("" + v.getId()));
        row.add((String)StandardUpGradeNamemap.get("" + v.getStandardUpGradeName()));
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add(Tool.jsSpecialChars(v.getPrincipal()));
        row.add(Tool.jsSpecialChars(v.getContact()));
        row.add(Tool.jsSpecialChars(v.getAddFileList()));
        row.add(Tool.jsSpecialChars(v.getAddAccount()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.stringOfDate(v.getCheckTime()));
        row.add(Tool.jsSpecialChars(v.getChackFlag()));
        row.add((String)ApplyLevelTypemap.get("" + v.getApplyLevelType()));
        row.add(Tool.jsSpecialChars(v.getZBName()));
        row.add("" + v.getZBNums());
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, StandardupGrade_File pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, StandardupGrade_File pv, boolean isAll)
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
    StandardupGrade_File pv = new StandardupGrade_File();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "StandardupGrade_File");
    request.setAttribute("describe", "团支部达标升级文件上报");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    StandardupGrade_File pv = new StandardupGrade_File();
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
private void setForm(javax.servlet.http.HttpServletRequest request, StandardupGrade_File form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("StandardUpGradeNameoptions", CEditConst.getStandardUpGradeNameOptions(userInfo, ""));
    request.setAttribute("ApplyLevelTypeoptions", CEditConst.getApplyLevelTypeOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "StandardupGrade_File");
    request.setAttribute("describe", "团支部达标升级文件上报");
}
private List mkRtn(String cmd, String forward, StandardupGrade_File form)
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
    StandardupGrade_File form = getByParameterDb(request);
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
log.debug("StandardupGrade_FileAction");
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
forwardMap.put("list", "StandardupGrade_FileAction.jsp");
forwardMap.put("failure", "StandardupGrade_FileForm.jsp");
forwardMap.put("success", "StandardupGrade_FileList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "StandardupGrade_FileForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='StandardupGrade_FileAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
