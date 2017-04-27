<%@ page language="java" %>
<%--团委场地--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(Places.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "PlaceCode", "PlaceName", "Principal", "Contact", "Area", "AddAccount", "AddTime", "PeopleNums", "Instruments", "Marks", "LastModifyTime", "LastModifyAccount"};
private String[] DicKeys = {"Id", "PlaceCode", "PlaceName", "Principal", "Contact", "Area", "AddAccount", "AddTime", "PeopleNums", "Instruments", "Marks", "LastModifyTime", "LastModifyAccount"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "地点代码", "45", "text", ""}, {"string", "名称", "50", "text", ""}, {"string", "发布人", "50", "UserName", ""}, {"string", "联系人", "50", "text", ""}, {"string", "地点", "50", "text", ""}, {"string", "添加人", "50", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"int", "人数", "0", "hidden", ""}, {"string", "场地设备", "50", "text", ""}, {"string", "备注", "255", "hidden", ""}, {"date", "最后修改时间", "0", "hidden", ""}, {"string", "最后修改人", "50", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "PlaceCode", "PlaceName", "Principal", "Contact", "Area", "AddAccount", "AddTime", "PeopleNums", "Instruments", "Marks", "LastModifyTime", "LastModifyAccount"};
private String[] ListFields = {"PlaceCode", "PlaceName", "Principal", "Contact", "Area", "Instruments"};
private String[] FormFields = {"PlaceCode", "PlaceName", "Principal", "Contact", "Area", "AddAccount", "PeopleNums", "Instruments", "Marks", "LastModifyTime", "LastModifyAccount"};
private String[] QueryFields = {"PlaceName"};
private String[] HideFields = {"Id"};
private Places getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Places v = new Places();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramPlaceCode(request, "PlaceCode");
        v.paramPlaceName(request, "PlaceName");
        v.paramPrincipal(request, "Principal");
        v.paramContact(request, "Contact");
        v.paramArea(request, "Area");
        v.paramAddAccount(request, "AddAccount");
        v.paramAddTime(request, "AddTime");
        v.paramPeopleNums(request, "PeopleNums");
        v.paramInstruments(request, "Instruments");
        v.paramMarks(request, "Marks");
        v.paramLastModifyTime(request, "LastModifyTime");
        v.paramLastModifyAccount(request, "LastModifyAccount");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setPlaceCode(ParamUtils.getParameter(request, "PlaceCode", ""));
        v.setPlaceName(ParamUtils.getParameter(request, "PlaceName", ""));
        v.setPrincipal(ParamUtils.getParameter(request, "Principal", ""));
        v.setContact(ParamUtils.getParameter(request, "Contact", ""));
        v.setArea(ParamUtils.getParameter(request, "Area", ""));
        v.setAddAccount(ParamUtils.getParameter(request, "AddAccount", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setPeopleNums(ParamUtils.getIntParameter(request, "PeopleNums", -1));
        v.setInstruments(ParamUtils.getParameter(request, "Instruments", ""));
        v.setMarks(ParamUtils.getParameter(request, "Marks", ""));
        v.setLastModifyTime(ParamUtils.getDateTimeParameter(request, "LastModifyTime", java.sql.Date.valueOf("0001-01-01")));
        v.setLastModifyAccount(ParamUtils.getParameter(request, "LastModifyAccount", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Places pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map UserNamemap = CEditConst.getUserNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Places v = (Places)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getPlaceCode()));
        row.add(Tool.jsSpecialChars(v.getPlaceName()));
        row.add((String)UserNamemap.get("" + v.getPrincipal()));
        row.add(Tool.jsSpecialChars(v.getContact()));
        row.add(Tool.jsSpecialChars(v.getArea()));
        row.add(Tool.jsSpecialChars(v.getAddAccount()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add("" + v.getPeopleNums());
        row.add(Tool.jsSpecialChars(v.getInstruments()));
        row.add(Tool.jsSpecialChars(v.getMarks()));
        row.add(Tool.stringOfDate(v.getLastModifyTime()));
        row.add(Tool.jsSpecialChars(v.getLastModifyAccount()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Places pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Places pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_PlaceName_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("placename like '%" + qval + "%'");
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
    Places pv = new Places();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Places");
    request.setAttribute("describe", "团委场地");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Places pv = new Places();
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
private void setForm(javax.servlet.http.HttpServletRequest request, Places form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Places");
    request.setAttribute("describe", "团委场地");
}
private List mkRtn(String cmd, String forward, Places form)
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
    Places form = getByParameterDb(request);
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
log.debug("PlacesAction");
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
forwardMap.put("list", "PlacesAction.jsp");
forwardMap.put("failure", "PlacesForm.jsp");
forwardMap.put("success", "PlacesList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "PlacesForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='PlacesAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
