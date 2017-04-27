<%@ page language="java" %>
<%--山大志库--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(VolunteerZhikuDeclare.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ZhikuId", "AddAccount", "Addtime", "Academy", "Checkflag", "Addfilelist", "Name", "Teamname", "Unit", "Type", "Intention", "Arrange", "Process", "Expectresults", "Results", "Cost1", "Cost2", "Cost3", "Cost4", "Cost5", "Cost6", "Totalcost"};
private String[] DicKeys = {"Id", "ZhikuId", "AddAccount", "Addtime", "Academy", "Checkflag", "Addfilelist", "Name", "Teamname", "Unit", "Type", "Intention", "Arrange", "Process", "Expectresults", "Results", "Cost1", "Cost2", "Cost3", "Cost4", "Cost5", "Cost6", "Totalcost"};
private String[][] DicValues = {{"int", "id", "0", "hidden", ""}, {"int", "志库通知的id", "0", "NoticeName", ""}, {"string", "添加账号", "20", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "学院", "45", "AcademyName", ""}, {"int", "审核标志", "0", "hidden", ""}, {"string", "上传文件", "500", "hidden", ""}, {"string", "项目名称", "45", "text", ""}, {"string", "团队名称", "45", "text", ""}, {"string", "学院", "45", "AcademyName", ""}, {"string", "项目分组", "45", "ZkProjectType", ""}, {"string", "项目活动背景及目的", "500", "hidden", ""}, {"string", "活动流程", "500", "hidden", ""}, {"string", "预期成果", "500", "hidden", ""}, {"string", "预期成果", "500", "hidden", ""}, {"string", "已取得成果", "500", "hidden", ""}, {"string", "（项目情况）交通费", "45", "text", ""}, {"string", "（项目情况）住宿费", "45", "text", ""}, {"string", "（项目情况）其他1", "45", "text", ""}, {"string", "（项目情况）其他2", "45", "text", ""}, {"string", "（项目情况）其他3", "45", "text", ""}, {"string", "（项目情况）其他4", "45", "text", ""}, {"string", "（项目情况）总计", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ZhikuId", "AddAccount", "Addtime", "Academy", "Checkflag", "Addfilelist", "Name", "Teamname", "Unit", "Type", "Intention", "Arrange", "Process", "Expectresults", "Results", "Cost1", "Cost2", "Cost3", "Cost4", "Cost5", "Cost6", "Totalcost"};
private String[] ListFields = {"ZhikuId", "Academy", "Name", "Teamname", "Unit", "Type", "Cost1", "Cost2", "Cost3", "Cost4", "Cost5", "Cost6", "Totalcost"};
private String[] FormFields = {"ZhikuId", "Academy", "Name", "Teamname", "Unit", "Type", "Intention", "Arrange", "Process", "Expectresults", "Results", "Cost1", "Cost2", "Cost3", "Cost4", "Cost5", "Cost6", "Totalcost"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private VolunteerZhikuDeclare getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    VolunteerZhikuDeclare v = new VolunteerZhikuDeclare();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramZhikuId(request, "ZhikuId");
        v.paramAddAccount(request, "AddAccount");
        v.paramAddtime(request, "Addtime");
        v.paramAcademy(request, "Academy");
        v.paramCheckflag(request, "Checkflag");
        v.paramAddfilelist(request, "Addfilelist");
        v.paramName(request, "Name");
        v.paramTeamname(request, "Teamname");
        v.paramUnit(request, "Unit");
        v.paramType(request, "Type");
        v.paramIntention(request, "Intention");
        v.paramArrange(request, "Arrange");
        v.paramProcess(request, "Process");
        v.paramExpectresults(request, "Expectresults");
        v.paramResults(request, "Results");
        v.paramCost1(request, "Cost1");
        v.paramCost2(request, "Cost2");
        v.paramCost3(request, "Cost3");
        v.paramCost4(request, "Cost4");
        v.paramCost5(request, "Cost5");
        v.paramCost6(request, "Cost6");
        v.paramTotalcost(request, "Totalcost");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setZhikuId(ParamUtils.getIntParameter(request, "ZhikuId", -1));
        v.setAddAccount(ParamUtils.getParameter(request, "AddAccount", ""));
        v.setAddtime(ParamUtils.getDateTimeParameter(request, "Addtime", java.sql.Date.valueOf("0001-01-01")));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setCheckflag(ParamUtils.getIntParameter(request, "Checkflag", -1));
        v.setAddfilelist(ParamUtils.getParameter(request, "Addfilelist", ""));
        v.setName(ParamUtils.getParameter(request, "Name", ""));
        v.setTeamname(ParamUtils.getParameter(request, "Teamname", ""));
        v.setUnit(ParamUtils.getParameter(request, "Unit", ""));
        v.setType(ParamUtils.getParameter(request, "Type", ""));
        v.setIntention(ParamUtils.getParameter(request, "Intention", ""));
        v.setArrange(ParamUtils.getParameter(request, "Arrange", ""));
        v.setProcess(ParamUtils.getParameter(request, "Process", ""));
        v.setExpectresults(ParamUtils.getParameter(request, "Expectresults", ""));
        v.setResults(ParamUtils.getParameter(request, "Results", ""));
        v.setCost1(ParamUtils.getParameter(request, "Cost1", ""));
        v.setCost2(ParamUtils.getParameter(request, "Cost2", ""));
        v.setCost3(ParamUtils.getParameter(request, "Cost3", ""));
        v.setCost4(ParamUtils.getParameter(request, "Cost4", ""));
        v.setCost5(ParamUtils.getParameter(request, "Cost5", ""));
        v.setCost6(ParamUtils.getParameter(request, "Cost6", ""));
        v.setTotalcost(ParamUtils.getParameter(request, "Totalcost", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, VolunteerZhikuDeclare pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map ZkProjectTypemap = CEditConst.getZkProjectTypeMap(userInfo);
    Map NoticeNamemap = CEditConst.getNoticeNameMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        VolunteerZhikuDeclare v = (VolunteerZhikuDeclare)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add((String)NoticeNamemap.get("" + v.getZhikuId()));
        row.add(Tool.jsSpecialChars(v.getAddAccount()));
        row.add(Tool.stringOfDate(v.getAddtime()));
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add("" + v.getCheckflag());
        row.add(Tool.jsSpecialChars(v.getAddfilelist()));
        row.add(Tool.jsSpecialChars(v.getName()));
        row.add(Tool.jsSpecialChars(v.getTeamname()));
        row.add((String)AcademyNamemap.get("" + v.getUnit()));
        row.add((String)ZkProjectTypemap.get("" + v.getType()));
        row.add(Tool.jsSpecialChars(v.getIntention()));
        row.add(Tool.jsSpecialChars(v.getArrange()));
        row.add(Tool.jsSpecialChars(v.getProcess()));
        row.add(Tool.jsSpecialChars(v.getExpectresults()));
        row.add(Tool.jsSpecialChars(v.getResults()));
        row.add(Tool.jsSpecialChars(v.getCost1()));
        row.add(Tool.jsSpecialChars(v.getCost2()));
        row.add(Tool.jsSpecialChars(v.getCost3()));
        row.add(Tool.jsSpecialChars(v.getCost4()));
        row.add(Tool.jsSpecialChars(v.getCost5()));
        row.add(Tool.jsSpecialChars(v.getCost6()));
        row.add(Tool.jsSpecialChars(v.getTotalcost()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, VolunteerZhikuDeclare pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, VolunteerZhikuDeclare pv, boolean isAll)
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
    VolunteerZhikuDeclare pv = new VolunteerZhikuDeclare();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "VolunteerZhikuDeclare");
    request.setAttribute("describe", "山大志库");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    VolunteerZhikuDeclare pv = new VolunteerZhikuDeclare();
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
private void setForm(javax.servlet.http.HttpServletRequest request, VolunteerZhikuDeclare form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("ZkProjectTypeoptions", CEditConst.getZkProjectTypeOptions(userInfo, ""));
    request.setAttribute("NoticeNameoptions", CEditConst.getNoticeNameOptions(userInfo, "-1"));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "VolunteerZhikuDeclare");
    request.setAttribute("describe", "山大志库");
}
private List mkRtn(String cmd, String forward, VolunteerZhikuDeclare form)
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
    VolunteerZhikuDeclare form = getByParameterDb(request);
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
log.debug("VolunteerZhikuDeclareAction");
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
forwardMap.put("list", "VolunteerZhikuDeclareAction.jsp");
forwardMap.put("failure", "VolunteerZhikuDeclareForm.jsp");
forwardMap.put("success", "VolunteerZhikuDeclareList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "VolunteerZhikuDeclareForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='VolunteerZhikuDeclareAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
