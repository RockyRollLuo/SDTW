<%@ page language="java" %>
<%--创业竞赛比赛奖励表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(InnovationCompetitionAwarditem.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Itemname", "Addtime", "Addperson", "Moditime", "Modiperson"};
private String[] DicKeys = {"Id", "Itemname", "Addtime", "Addperson", "Moditime", "Modiperson"};
private String[][] DicValues = {{"int", "id", "0", "hidden", ""}, {"string", "奖项名称", "45", "text", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "添加人", "45", "hidden", ""}, {"date", "修改时间", "0", "hidden", ""}, {"string", "修改人", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Itemname", "Addtime", "Addperson", "Moditime", "Modiperson"};
private String[] ListFields = {"Itemname", "Modiperson"};
private String[] FormFields = {"Itemname", "Modiperson"};
private String[] QueryFields = {"Itemname", "Modiperson"};
private String[] HideFields = {"Id"};
private InnovationCompetitionAwarditem getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    InnovationCompetitionAwarditem v = new InnovationCompetitionAwarditem();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramItemname(request, "Itemname");
        v.paramAddtime(request, "Addtime");
        v.paramAddperson(request, "Addperson");
        v.paramModitime(request, "Moditime");
        v.paramModiperson(request, "Modiperson");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setItemname(ParamUtils.getParameter(request, "Itemname", ""));
        v.setAddtime(ParamUtils.getDateTimeParameter(request, "Addtime", java.sql.Date.valueOf("0001-01-01")));
        v.setAddperson(ParamUtils.getParameter(request, "Addperson", ""));
        v.setModitime(ParamUtils.getDateTimeParameter(request, "Moditime", java.sql.Date.valueOf("0001-01-01")));
        v.setModiperson(ParamUtils.getParameter(request, "Modiperson", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, InnovationCompetitionAwarditem pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        InnovationCompetitionAwarditem v = (InnovationCompetitionAwarditem)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getItemname()));
        row.add(Tool.stringOfDate(v.getAddtime()));
        row.add(Tool.jsSpecialChars(v.getAddperson()));
        row.add(Tool.stringOfDate(v.getModitime()));
        row.add(Tool.jsSpecialChars(v.getModiperson()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, InnovationCompetitionAwarditem pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, InnovationCompetitionAwarditem pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_Itemname_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("itemname like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_Modiperson_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("modiperson like '%" + qval + "%'");
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
    InnovationCompetitionAwarditem pv = new InnovationCompetitionAwarditem();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "InnovationCompetitionAwarditem");
    request.setAttribute("describe", "创业竞赛比赛奖励表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    InnovationCompetitionAwarditem pv = new InnovationCompetitionAwarditem();
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
private void setForm(javax.servlet.http.HttpServletRequest request, InnovationCompetitionAwarditem form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "InnovationCompetitionAwarditem");
    request.setAttribute("describe", "创业竞赛比赛奖励表");
}
private List mkRtn(String cmd, String forward, InnovationCompetitionAwarditem form)
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
    InnovationCompetitionAwarditem form = getByParameterDb(request);
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
log.debug("InnovationCompetitionAwarditemAction");
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
forwardMap.put("list", "InnovationCompetitionAwarditemAction.jsp");
forwardMap.put("failure", "InnovationCompetitionAwarditemForm.jsp");
forwardMap.put("success", "InnovationCompetitionAwarditemList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "InnovationCompetitionAwarditemForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='InnovationCompetitionAwarditemAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
