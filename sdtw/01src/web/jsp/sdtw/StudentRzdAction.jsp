<%@ page language="java" %>
<%--学生素质拓展培养认证单--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(StudentRzd.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Stuid", "Deptid", "Type", "Modifyflag", "Checkreason", "Checkflag", "ActivityId", "Value1", "Value2", "Value3", "Value4"};
private String[] DicKeys = {"Id", "Stuid", "Deptid", "Type", "Modifyflag", "Checkreason", "Checkflag", "ActivityId", "Value1", "Value2", "Value3", "Value4"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "学院id", "0", "hidden", ""}, {"string", "学院", "0", "AcademyName", ""}, {"int", "类别", "0", "StudentRzdTypeName", ""}, {"int", "修改标志", "0", "hidden", ""}, {"string", "审核原因", "100", "text", ""}, {"int", "审核标志", "0", "hidden", ""}, {"int", "活动id", "0", "hidden", ""}, {"string", "名称", "45", "text", ""}, {"string", "单位", "45", "text", ""}, {"string", "时间", "45", "text", ""}, {"string", "成果", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Stuid", "Deptid", "Type", "Modifyflag", "Checkreason", "Checkflag", "ActivityId", "Value1", "Value2", "Value3", "Value4"};
private String[] ListFields = {"Deptid", "Type", "Checkreason", "Value1", "Value2", "Value3", "Value4"};
private String[] FormFields = {"Deptid", "Type", "Modifyflag", "Checkreason", "Checkflag", "Value1", "Value2", "Value3", "Value4"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private StudentRzd getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    StudentRzd v = new StudentRzd();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramStuid(request, "Stuid");
        v.paramDeptid(request, "Deptid");
        v.paramType(request, "Type");
        v.paramModifyflag(request, "Modifyflag");
        v.paramCheckreason(request, "Checkreason");
        v.paramCheckflag(request, "Checkflag");
        v.paramActivityId(request, "ActivityId");
        v.paramValue1(request, "Value1");
        v.paramValue2(request, "Value2");
        v.paramValue3(request, "Value3");
        v.paramValue4(request, "Value4");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setStuid(ParamUtils.getIntParameter(request, "Stuid", -1));
        v.setDeptid(ParamUtils.getParameter(request, "Deptid", ""));
        v.setType(ParamUtils.getIntParameter(request, "Type", -1));
        v.setModifyflag(ParamUtils.getIntParameter(request, "Modifyflag", -1));
        v.setCheckreason(ParamUtils.getParameter(request, "Checkreason", ""));
        v.setCheckflag(ParamUtils.getIntParameter(request, "Checkflag", -1));
        v.setActivityId(ParamUtils.getIntParameter(request, "ActivityId", -1));
        v.setValue1(ParamUtils.getParameter(request, "Value1", ""));
        v.setValue2(ParamUtils.getParameter(request, "Value2", ""));
        v.setValue3(ParamUtils.getParameter(request, "Value3", ""));
        v.setValue4(ParamUtils.getParameter(request, "Value4", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, StudentRzd pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map StudentRzdTypeNamemap = CEditConst.getStudentRzdTypeNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        StudentRzd v = (StudentRzd)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add("" + v.getStuid());
        row.add((String)AcademyNamemap.get("" + v.getDeptid()));
        row.add((String)StudentRzdTypeNamemap.get("" + v.getType()));
        row.add("" + v.getModifyflag());
        row.add(Tool.jsSpecialChars(v.getCheckreason()));
        row.add("" + v.getCheckflag());
        row.add("" + v.getActivityId());
        row.add(Tool.jsSpecialChars(v.getValue1()));
        row.add(Tool.jsSpecialChars(v.getValue2()));
        row.add(Tool.jsSpecialChars(v.getValue3()));
        row.add(Tool.jsSpecialChars(v.getValue4()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, StudentRzd pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, StudentRzd pv, boolean isAll)
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
    StudentRzd pv = new StudentRzd();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "StudentRzd");
    request.setAttribute("describe", "学生素质拓展培养认证单");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    StudentRzd pv = new StudentRzd();
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
private void setForm(javax.servlet.http.HttpServletRequest request, StudentRzd form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("StudentRzdTypeNameoptions", CEditConst.getStudentRzdTypeNameOptions(userInfo, "-1"));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "StudentRzd");
    request.setAttribute("describe", "学生素质拓展培养认证单");
}
private List mkRtn(String cmd, String forward, StudentRzd form)
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
    StudentRzd form = getByParameterDb(request);
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
log.debug("StudentRzdAction");
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
forwardMap.put("list", "StudentRzdAction.jsp");
forwardMap.put("failure", "StudentRzdForm.jsp");
forwardMap.put("success", "StudentRzdList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "StudentRzdForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='StudentRzdAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
