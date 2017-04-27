<%@ page language="java" %>
<%--参加社会实践团队表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(PracticeDeclareTeam.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "PracticeId", "TeamName", "Academy", "PracticeReportTeamType", "Report21", "Report22", "Remark", "Remark2", "Remark3", "Remark4", "Honor"};
private String[] DicKeys = {"Id", "PracticeId", "TeamName", "Academy", "PracticeReportTeamType", "Report21", "Report22", "Remark", "Remark2", "Remark3", "Remark4", "Honor"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "结题表ID", "45", "text", ""}, {"string", "团队名称", "45", "text", ""}, {"string", "所属学院", "45", "AcademyName", ""}, {"string", "团队类别", "45", "PracticeReportTeamType", ""}, {"string", "团队活动小结", "255", "hidden", ""}, {"string", "团队主要成绩成果", "255", "hidden", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "荣誉", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "PracticeId", "TeamName", "Academy", "PracticeReportTeamType", "Report21", "Report22", "Remark", "Remark2", "Remark3", "Remark4", "Honor"};
private String[] ListFields = {"PracticeId", "TeamName", "Academy", "PracticeReportTeamType", "Remark", "Remark2", "Remark3", "Remark4", "Honor"};
private String[] FormFields = {"PracticeId", "TeamName", "Academy", "PracticeReportTeamType", "Report21", "Report22", "Remark", "Remark2", "Remark3", "Remark4", "Honor"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private PracticeDeclareTeam getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    PracticeDeclareTeam v = new PracticeDeclareTeam();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramPracticeId(request, "PracticeId");
        v.paramTeamName(request, "TeamName");
        v.paramAcademy(request, "Academy");
        v.paramPracticeReportTeamType(request, "PracticeReportTeamType");
        v.paramReport21(request, "Report21");
        v.paramReport22(request, "Report22");
        v.paramRemark(request, "Remark");
        v.paramRemark2(request, "Remark2");
        v.paramRemark3(request, "Remark3");
        v.paramRemark4(request, "Remark4");
        v.paramHonor(request, "Honor");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setPracticeId(ParamUtils.getParameter(request, "PracticeId", ""));
        v.setTeamName(ParamUtils.getParameter(request, "TeamName", ""));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setPracticeReportTeamType(ParamUtils.getParameter(request, "PracticeReportTeamType", ""));
        v.setReport21(ParamUtils.getParameter(request, "Report21", ""));
        v.setReport22(ParamUtils.getParameter(request, "Report22", ""));
        v.setRemark(ParamUtils.getParameter(request, "Remark", ""));
        v.setRemark2(ParamUtils.getParameter(request, "Remark2", ""));
        v.setRemark3(ParamUtils.getParameter(request, "Remark3", ""));
        v.setRemark4(ParamUtils.getParameter(request, "Remark4", ""));
        v.setHonor(ParamUtils.getParameter(request, "Honor", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, PracticeDeclareTeam pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map PracticeReportTeamTypemap = CEditConst.getPracticeReportTeamTypeMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        PracticeDeclareTeam v = (PracticeDeclareTeam)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getPracticeId()));
        row.add(Tool.jsSpecialChars(v.getTeamName()));
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add((String)PracticeReportTeamTypemap.get("" + v.getPracticeReportTeamType()));
        row.add(Tool.jsSpecialChars(v.getReport21()));
        row.add(Tool.jsSpecialChars(v.getReport22()));
        row.add(Tool.jsSpecialChars(v.getRemark()));
        row.add(Tool.jsSpecialChars(v.getRemark2()));
        row.add(Tool.jsSpecialChars(v.getRemark3()));
        row.add(Tool.jsSpecialChars(v.getRemark4()));
        row.add(Tool.jsSpecialChars(v.getHonor()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, PracticeDeclareTeam pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, PracticeDeclareTeam pv, boolean isAll)
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
    PracticeDeclareTeam pv = new PracticeDeclareTeam();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "PracticeDeclareTeam");
    request.setAttribute("describe", "参加社会实践团队表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    PracticeDeclareTeam pv = new PracticeDeclareTeam();
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
private void setForm(javax.servlet.http.HttpServletRequest request, PracticeDeclareTeam form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("PracticeReportTeamTypeoptions", CEditConst.getPracticeReportTeamTypeOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "PracticeDeclareTeam");
    request.setAttribute("describe", "参加社会实践团队表");
}
private List mkRtn(String cmd, String forward, PracticeDeclareTeam form)
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
    PracticeDeclareTeam form = getByParameterDb(request);
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
log.debug("PracticeDeclareTeamAction");
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
forwardMap.put("list", "PracticeDeclareTeamAction.jsp");
forwardMap.put("failure", "PracticeDeclareTeamForm.jsp");
forwardMap.put("success", "PracticeDeclareTeamList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "PracticeDeclareTeamForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='PracticeDeclareTeamAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
