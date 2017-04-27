<%@ page language="java" %>
<%--附件下载--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(ClientAttach.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "AttachType", "Content", "UploadDate", "UploadType", "UploadName", "AttachSize", "GenerateName", "Oplog", "RelationId", "FromClass", "FromTable"};
private String[] DicKeys = {"Id", "AttachType", "Content", "UploadDate", "UploadType", "UploadName", "AttachSize", "GenerateName", "Oplog", "RelationId", "FromClass", "FromTable"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "附件种类", "0", "AttachType", ""}, {"string", "内容", "200", "hidden", ""}, {"date", "上传时间", "0", "text", ""}, {"string", "附件类型", "200", "text", ""}, {"string", "上传名称", "500", "text", ""}, {"int", "附件尺寸", "0", "text", ""}, {"string", "生成名称", "500", "text", ""}, {"string", "操作日志", "1000", "hidden", ""}, {"int", "相关Id", "0", "hidden", ""}, {"string", "所属类", "20", "hidden", ""}, {"string", "所属表名", "20", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "AttachType", "Content", "UploadDate", "UploadType", "UploadName", "AttachSize", "GenerateName", "Oplog", "RelationId", "FromClass", "FromTable"};
private String[] ListFields = {"AttachType", "UploadDate", "UploadType", "UploadName", "AttachSize", "GenerateName"};
private String[] FormFields = {"AttachType", "UploadDate", "UploadType", "UploadName", "AttachSize", "GenerateName", "RelationId"};
private String[] QueryFields = {"AttachType"};
private String[] HideFields = {"Id"};
private ClientAttach getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    ClientAttach v = new ClientAttach();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramAttachType(request, "AttachType");
        v.paramContent(request, "Content");
        v.paramUploadDate(request, "UploadDate");
        v.paramUploadType(request, "UploadType");
        v.paramUploadName(request, "UploadName");
        v.paramAttachSize(request, "AttachSize");
        v.paramGenerateName(request, "GenerateName");
        v.paramOplog(request, "Oplog");
        v.paramRelationId(request, "RelationId");
        v.paramFromClass(request, "FromClass");
        v.paramFromTable(request, "FromTable");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setAttachType(ParamUtils.getIntParameter(request, "AttachType", -1));
        v.setContent(ParamUtils.getParameter(request, "Content", ""));
        v.setUploadDate(ParamUtils.getDateTimeParameter(request, "UploadDate", java.sql.Date.valueOf("0001-01-01")));
        v.setUploadType(ParamUtils.getParameter(request, "UploadType", ""));
        v.setUploadName(ParamUtils.getParameter(request, "UploadName", ""));
        v.setAttachSize(ParamUtils.getIntParameter(request, "AttachSize", -1));
        v.setGenerateName(ParamUtils.getParameter(request, "GenerateName", ""));
        v.setOplog(ParamUtils.getParameter(request, "Oplog", ""));
        v.setRelationId(ParamUtils.getIntParameter(request, "RelationId", -1));
        v.setFromClass(ParamUtils.getParameter(request, "FromClass", ""));
        v.setFromTable(ParamUtils.getParameter(request, "FromTable", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, ClientAttach pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AttachTypemap = CEditConst.getAttachTypeMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        ClientAttach v = (ClientAttach)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add((String)AttachTypemap.get("" + v.getAttachType()));
        row.add(Tool.jsSpecialChars(v.getContent()));
        row.add(Tool.stringOfDate(v.getUploadDate()));
        row.add(Tool.jsSpecialChars(v.getUploadType()));
        row.add(Tool.jsSpecialChars(v.getUploadName()));
        row.add("" + v.getAttachSize());
        row.add(Tool.jsSpecialChars(v.getGenerateName()));
        row.add(Tool.jsSpecialChars(v.getOplog()));
        row.add("" + v.getRelationId());
        row.add(Tool.jsSpecialChars(v.getFromClass()));
        row.add(Tool.jsSpecialChars(v.getFromTable()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, ClientAttach pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, ClientAttach pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_AttachType_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("attachtype=" + qval);
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
    request.setAttribute("AttachTypeoptions", CEditConst.getAttachTypeOptions(userInfo, "-1"));
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
    ClientAttach pv = new ClientAttach();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "ClientAttach");
    request.setAttribute("describe", "附件下载");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    ClientAttach pv = new ClientAttach();
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
private void setForm(javax.servlet.http.HttpServletRequest request, ClientAttach form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AttachTypeoptions", CEditConst.getAttachTypeOptions(userInfo, "-1"));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "ClientAttach");
    request.setAttribute("describe", "附件下载");
}
private List mkRtn(String cmd, String forward, ClientAttach form)
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
    ClientAttach form = getByParameterDb(request);
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
log.debug("ClientAttachAction");
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
forwardMap.put("list", "ClientAttachAction.jsp");
forwardMap.put("failure", "ClientAttachForm.jsp");
forwardMap.put("success", "ClientAttachList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "ClientAttachForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='ClientAttachAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
