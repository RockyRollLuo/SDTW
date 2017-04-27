<%@ page language="java" %>
<%--团校培训管理资料--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(Materialslist.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "FileID", "UserAccount", "UserName", "FileTitle", "FileSaveName", "Description", "AddTime", "PublicFlag", "KeyWordsList", "ProjectName", "FoderCode"};
private String[] DicKeys = {"FileID", "UserAccount", "UserName", "FileTitle", "FileSaveName", "Description", "AddTime", "PublicFlag", "KeyWordsList", "ProjectName", "FoderCode"};
private String[][] DicValues = {{"int", "FileID", "0", "hidden", ""}, {"string", "用户账号", "2000", "text", ""}, {"string", "用户名称", "2000", "UserName", ""}, {"string", "文件标题", "2000", "text", ""}, {"string", "文件名称", "2000", "text", ""}, {"string", "文件描述", "2000", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"int", "是否公开", "0", "text", ""}, {"string", "关键字", "2000", "text", ""}, {"string", "项目名称", "2000", "text", ""}, {"string", "项目code", "2000", "text", ""}};
private String KeyField = "FileID";
private String[] AllFields = {"FileID", "UserAccount", "UserName", "FileTitle", "FileSaveName", "Description", "AddTime", "PublicFlag", "KeyWordsList", "ProjectName", "FoderCode"};
private String[] ListFields = {"UserAccount", "UserName", "FileTitle", "FileSaveName", "PublicFlag", "KeyWordsList", "ProjectName", "FoderCode"};
private String[] FormFields = {"UserAccount", "UserName", "FileTitle", "FileSaveName", "Description", "PublicFlag", "KeyWordsList", "ProjectName", "FoderCode"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private Materialslist getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Materialslist v = new Materialslist();
    v.setFileID(ParamUtils.getIntParameter(request, "FileID", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getByFileID(v.getFileID());
        v.paramFileID(request, "FileID");
        v.paramUserAccount(request, "UserAccount");
        v.paramUserName(request, "UserName");
        v.paramFileTitle(request, "FileTitle");
        v.paramFileSaveName(request, "FileSaveName");
        v.paramDescription(request, "Description");
        v.paramAddTime(request, "AddTime");
        v.paramPublicFlag(request, "PublicFlag");
        v.paramKeyWordsList(request, "KeyWordsList");
        v.paramProjectName(request, "ProjectName");
        v.paramFoderCode(request, "FoderCode");
    }
    else {
        v.setFileID(ParamUtils.getIntParameter(request, "FileID", -1));
        v.setUserAccount(ParamUtils.getParameter(request, "UserAccount", ""));
        v.setUserName(ParamUtils.getParameter(request, "UserName", ""));
        v.setFileTitle(ParamUtils.getParameter(request, "FileTitle", ""));
        v.setFileSaveName(ParamUtils.getParameter(request, "FileSaveName", ""));
        v.setDescription(ParamUtils.getParameter(request, "Description", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setPublicFlag(ParamUtils.getIntParameter(request, "PublicFlag", -1));
        v.setKeyWordsList(ParamUtils.getParameter(request, "KeyWordsList", ""));
        v.setProjectName(ParamUtils.getParameter(request, "ProjectName", ""));
        v.setFoderCode(ParamUtils.getParameter(request, "FoderCode", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Materialslist pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map UserNamemap = CEditConst.getUserNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Materialslist v = (Materialslist)it.next();
        List row = new ArrayList();
        row.add("" + v.getFileID());
        row.add(Tool.jsSpecialChars(v.getUserAccount()));
        row.add((String)UserNamemap.get("" + v.getUserName()));
        row.add(Tool.jsSpecialChars(v.getFileTitle()));
        row.add(Tool.jsSpecialChars(v.getFileSaveName()));
        row.add(Tool.jsSpecialChars(v.getDescription()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add("" + v.getPublicFlag());
        row.add(Tool.jsSpecialChars(v.getKeyWordsList()));
        row.add(Tool.jsSpecialChars(v.getProjectName()));
        row.add(Tool.jsSpecialChars(v.getFoderCode()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Materialslist pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Materialslist pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "FileID");
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
    Materialslist pv = new Materialslist();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Materialslist");
    request.setAttribute("describe", "团校培训管理资料");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Materialslist pv = new Materialslist();
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
private void setForm(javax.servlet.http.HttpServletRequest request, Materialslist form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Materialslist");
    request.setAttribute("describe", "团校培训管理资料");
}
private List mkRtn(String cmd, String forward, Materialslist form)
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
    Materialslist form = getByParameterDb(request);
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
        form = form.getByFileID(form.getFileID());
        setForm(request, form);
        return mkRtn("update", "input", form);
    }
    if (cmd.equals("delete"))
    {
        form.delete(form.getFileID());
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("deletelist"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        List cdt = new ArrayList();
        cdt.add("fileid in (" + idlist + ")");
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
log.debug("MaterialslistAction");
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
forwardMap.put("list", "MaterialslistAction.jsp");
forwardMap.put("failure", "MaterialslistForm.jsp");
forwardMap.put("success", "MaterialslistList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "MaterialslistForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='MaterialslistAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
