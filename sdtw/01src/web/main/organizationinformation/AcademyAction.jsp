<%@ page language="java" %>
<%--学院表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(Academy.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "AcademyName", "Academyalias", "ListOrder", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "Leaguecount", "AcadeMySecretary", "AcadePutySecretary", "AcaorgPerson", "Acapublicity", "AcadeMyLevel", "AcadeMyPhone", "AcadeMyPlace", "AcadeMyeMail", "YouthXyReport", "YouthXyReportTime", "YouthModifyFlag", "YouthModifyTime", "YouthSchoolYear", "YouthPeriodTime", "Flag","ziduan1","ziduan2"};
private String[] DicKeys = {"Id", "AcademyName", "Academyalias", "ListOrder", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "Leaguecount", "AcadeMySecretary", "AcadePutySecretary", "AcaorgPerson", "Acapublicity", "AcadeMyLevel", "AcadeMyPhone", "AcadeMyPlace", "AcadeMyeMail", "YouthXyReport", "YouthXyReportTime", "YouthModifyFlag", "YouthModifyTime", "YouthSchoolYear", "YouthPeriodTime", "Flag","ziduan1","ziduan2"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "学院名称", "45", "AcademyName", ""}, {"string", "别名", "45", "text", ""}, {"int", "排序", "0", "text", ""}, {"string", "添加人", "45", "text", ""}, {"string", "添加时间", "45", "text", ""}, {"string", "系所码", "45", "text", ""}, {"date", "修改时间", "0", "text", ""}, {"int", "团支部数量", "0", "text", ""}, {"string", "团委书记", "45", "text", ""}, {"string", "团委副书记", "45", "text", ""}, {"string", "组织委员", "45", "text", ""}, {"string", "宣传委员", "45", "text", ""}, {"string", "支部等级", "45", "text", ""}, {"string", "办公电话", "45", "text", ""}, {"string", "办公地点", "45", "text", ""}, {"string", "办公邮箱", "45", "text", ""}, {"string", "54青年表彰提交", "2", "YesNo", ""}, {"date", "54青年表彰学院提交时间", "0", "text", ""}, {"string", "54青年表彰修改", "2", "YesNo", ""}, {"date", "54青团表彰修改时间", "0", "text", ""}, {"string", "54青年表彰学年", "45", "text", ""}, {"string", "学院设置54青年表彰周期", "45", "text", ""}, {"string", "标识", "4", "AcademyType", ""}, {"string", "支部荣誉", "45", "text", ""}, {"string", "支部活动", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "AcademyName", "Academyalias", "ListOrder", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "Leaguecount", "AcadeMySecretary", "AcadePutySecretary", "AcaorgPerson", "Acapublicity", "AcadeMyLevel", "AcadeMyPhone", "AcadeMyPlace", "AcadeMyeMail", "YouthXyReport"};
private String[] ListFields = {"AcademyName","ModiPerson","AcadeMySecretary", "AcadePutySecretary","AcaorgPerson", "Acapublicity"};
private String[] FormFields = {"AcademyName", "Academyalias", "ListOrder", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "Leaguecount", "AcadeMySecretary", "AcadePutySecretary", "AcaorgPerson", "Acapublicity", "AcadeMyLevel", "AcadeMyPhone", "AcadeMyPlace", "AcadeMyeMail", "YouthXyReport", "YouthXyReportTime", "YouthModifyFlag", "YouthModifyTime", "YouthSchoolYear", "YouthPeriodTime", "Flag"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private Academy getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Academy v = new Academy();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramAcademyName(request, "AcademyName");
        v.paramAcademyalias(request, "Academyalias");
        v.paramListOrder(request, "ListOrder");
        v.paramAddPerson(request, "AddPerson");
        v.paramAddTime(request, "AddTime");
        v.paramModiPerson(request, "ModiPerson");
        v.paramModiTime(request, "ModiTime");
        v.paramLeaguecount(request, "Leaguecount");
        v.paramAcadeMySecretary(request, "AcadeMySecretary");
        v.paramAcadePutySecretary(request, "AcadePutySecretary");
        v.paramAcaorgPerson(request, "AcaorgPerson");
        v.paramAcapublicity(request, "Acapublicity");
        v.paramAcadeMyLevel(request, "AcadeMyLevel");
        v.paramAcadeMyPhone(request, "AcadeMyPhone");
        v.paramAcadeMyPlace(request, "AcadeMyPlace");
        v.paramAcadeMyeMail(request, "AcadeMyeMail");
        v.paramYouthXyReport(request, "YouthXyReport");
        v.paramYouthXyReportTime(request, "YouthXyReportTime");
        v.paramYouthModifyFlag(request, "YouthModifyFlag");
        v.paramYouthModifyTime(request, "YouthModifyTime");
        v.paramYouthSchoolYear(request, "YouthSchoolYear");
        v.paramYouthPeriodTime(request, "YouthPeriodTime");
        v.paramFlag(request, "Flag");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setAcademyName(ParamUtils.getParameter(request, "AcademyName", ""));
        v.setAcademyalias(ParamUtils.getParameter(request, "Academyalias", ""));
        v.setListOrder(ParamUtils.getIntParameter(request, "ListOrder", -1));
        v.setAddPerson(ParamUtils.getParameter(request, "AddPerson", ""));
        v.setAddTime(ParamUtils.getParameter(request, "AddTime", ""));
        v.setModiPerson(ParamUtils.getParameter(request, "ModiPerson", ""));
        v.setModiTime(ParamUtils.getDateTimeParameter(request, "ModiTime", java.sql.Date.valueOf("0001-01-01")));
        v.setLeaguecount(ParamUtils.getIntParameter(request, "Leaguecount", -1));
        v.setAcadeMySecretary(ParamUtils.getParameter(request, "AcadeMySecretary", ""));
        v.setAcadePutySecretary(ParamUtils.getParameter(request, "AcadePutySecretary", ""));
        v.setAcaorgPerson(ParamUtils.getParameter(request, "AcaorgPerson", ""));
        v.setAcapublicity(ParamUtils.getParameter(request, "Acapublicity", ""));
        v.setAcadeMyLevel(ParamUtils.getParameter(request, "AcadeMyLevel", ""));
        v.setAcadeMyPhone(ParamUtils.getParameter(request, "AcadeMyPhone", ""));
        v.setAcadeMyPlace(ParamUtils.getParameter(request, "AcadeMyPlace", ""));
        v.setAcadeMyeMail(ParamUtils.getParameter(request, "AcadeMyeMail", ""));
        v.setYouthXyReport(ParamUtils.getParameter(request, "YouthXyReport", ""));
        v.setYouthXyReportTime(ParamUtils.getDateTimeParameter(request, "YouthXyReportTime", java.sql.Date.valueOf("0001-01-01")));
        v.setYouthModifyFlag(ParamUtils.getParameter(request, "YouthModifyFlag", ""));
        v.setYouthModifyTime(ParamUtils.getDateTimeParameter(request, "YouthModifyTime", java.sql.Date.valueOf("0001-01-01")));
        v.setYouthSchoolYear(ParamUtils.getParameter(request, "YouthSchoolYear", ""));
        v.setYouthPeriodTime(ParamUtils.getParameter(request, "YouthPeriodTime", ""));
        v.setFlag(ParamUtils.getParameter(request, "Flag", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Academy pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyTypemap = CEditConst.getAcademyTypeMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map YesNomap = CEditConst.getYesNoMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Academy v = (Academy)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add("" + v.getAcademyName());
        row.add(Tool.jsSpecialChars(v.getAcademyalias()));
        row.add("" + v.getListOrder());
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.jsSpecialChars(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getModiPerson()));
        row.add(Tool.stringOfDate(v.getModiTime()));
        row.add("" + v.getLeaguecount());
        row.add(Tool.jsSpecialChars(v.getAcadeMySecretary()));
        row.add(Tool.jsSpecialChars(v.getAcadePutySecretary()));
        row.add(Tool.jsSpecialChars(v.getAcaorgPerson()));
        row.add(Tool.jsSpecialChars(v.getAcapublicity()));
        row.add(Tool.jsSpecialChars(v.getAcadeMyLevel()));
        row.add(Tool.jsSpecialChars(v.getAcadeMyPhone()));
        row.add(Tool.jsSpecialChars(v.getAcadeMyPlace()));
        row.add(Tool.jsSpecialChars(v.getAcadeMyeMail()));
        
        rows.add(row);
    }
    return rows;
}
private List getListRows_forexcel(javax.servlet.http.HttpServletRequest request, Academy pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyTypemap = CEditConst.getAcademyTypeMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map YesNomap = CEditConst.getYesNoMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Academy v = (Academy)it.next();
        List row = new ArrayList();
        
        row.add("" + v.getAcademyName());
        row.add(Tool.jsSpecialChars(v.getAcademyalias()));
       
        row.add(Tool.jsSpecialChars(v.getAcadeMySecretary()));
        row.add(Tool.jsSpecialChars(v.getAcadePutySecretary()));
        row.add(Tool.jsSpecialChars(v.getAcaorgPerson()));
        row.add(Tool.jsSpecialChars(v.getAcapublicity()));
        row.add(Tool.jsSpecialChars(v.getAcadeMyLevel()));
        row.add(Tool.jsSpecialChars(v.getAcadeMyPhone()));
        row.add(Tool.jsSpecialChars(v.getAcadeMyPlace()));
        row.add(Tool.jsSpecialChars(v.getAcadeMyeMail()));
        
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Academy pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Academy pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_xisuoma_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("modiperson =" +qval);
    }
    qval = ParamUtils.getParameter(request, "_Name_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("academyname like '%" + qval + "%'");
    }
    if (!isAll) {
        int currpage = ParamUtils.getIntParameter(request, "page", 1);
        com.xietong.software.common.PageControl pc = new com.xietong.software.common.PageControl(pv.getCount(cdt), currpage, shownum);
        cdt.add("limit " + pc.getOffset() + "," + pc.getShownum());
        request.setAttribute("PageControl", pc);
    }
    String cname = pv.getFieldByProperty(orderfield);
    if (cname.length() != 0) {
        cdt.add("order by flag " );
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
    Academy pv = new Academy();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Academy");
    request.setAttribute("describe", "学院表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    String[][] excelValues = { {"string", "学院名称", "45", "AcademyName", ""}, {"string", "简称", "45", "text", ""}, {"string", "团委书记", "45", "text", ""}, {"string", "团委副书记", "45", "text", ""}, {"string", "组织委员", "45", "text", ""}, {"string", "宣传委员", "45", "text", ""}, {"string", "支部等级", "45", "text", ""}, {"string", "办公电话", "45", "text", ""}, {"string", "办公地点", "45", "text", ""}, {"string", "办公邮箱", "45", "text", ""}};

    Academy pv = new Academy();
    try {
        WorkbookSettings ws = new WorkbookSettings();
        ws.setLocale(new Locale("zh", "CN"));
        WritableWorkbook workbook = Workbook.createWorkbook(new File(filename), ws);
        WritableSheet s1 = workbook.createSheet("Sheet1", 0);
        for (int k = 0; k < excelValues.length; k ++) {
            Label lr = new Label(k, 0, excelValues[k][1]);
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
            for (Iterator rit = getListRows_forexcel(request, pv, cdt).iterator(); rit.hasNext(); i ++) {
                List row = (List)rit.next();
                int j = 0;
                for (Iterator cit = row.iterator(); cit.hasNext(); j ++) {
                    Label lr = new Label(j, i, (String)cit.next());
                    s1.addCell(lr);
                   
                }
            }
        }
        s1.setColumnView(0, 25);
        s1.setColumnView(1, 15);
        s1.setColumnView(2, 15);
        s1.setColumnView(3,15);
        s1.setColumnView(4, 15);
        s1.setColumnView(5, 15);
        s1.setColumnView(6, 15);
        s1.setColumnView(7, 15);
        s1.setColumnView(8, 15);
        s1.setColumnView(9, 15);
        workbook.write();
        workbook.close();
    }
    catch (IOException e) {
    }
    catch (WriteException e) {
    }
}
private void setForm(javax.servlet.http.HttpServletRequest request, Academy form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AcademyTypeoptions", CEditConst.getAcademyTypeOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("YesNooptions", CEditConst.getYesNoOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Academy");
    request.setAttribute("describe", "学院表");
}
private List mkRtn(String cmd, String forward, Academy form)
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
    Academy form = getByParameterDb(request);
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
        String filename = HeadConst.root_file_path + "/main/upload/" + userInfo.getName() + ".xls";
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
log.debug("AcademyAction");
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
forwardMap.put("list", "AcademyAction.jsp");
forwardMap.put("failure", "AcademyForm.jsp");
forwardMap.put("success", "AcademyList.jsp");
forwardMap.put("excel", "/main/upload/" + userInfo.getName() + ".xls");
forwardMap.put("input", "AcademyForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
	
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='AcademyAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else if(forwardKey.equals("excel")){
	out.clear();
	out  =  pageContext.pushBody();
	response.setContentType("applicationnd.ms-excel");
	response.sendRedirect(HeadConst.apache_url + "/main/upload/"+userInfo.getName()+".xls");
}
else {
	
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
