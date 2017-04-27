<%@ page language="java" %>
<%--调查问卷回答items--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(SurveyAnswer.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "UserAccount", "SurveyCode", "Head_1ID", "Item_ID", "Item_Type", "Item_Submition", "Item_Score", "Submit_Time", "Submit_Ip"};
private String[] DicKeys = {"Id", "UserAccount", "SurveyCode", "Head_1ID", "Item_ID", "Item_Type", "Item_Submition", "Item_Score", "Submit_Time", "Submit_Ip"};
private String[][] DicValues = {{"int", "id", "0", "hidden", ""}, {"string", "用户账号", "45", "text", ""}, {"string", "问卷编码", "45", "text", ""}, {"string", "Head_1ID", "45", "text", ""}, {"string", "Item_ID", "45", "text", ""}, {"string", "Item_Type", "45", "text", ""}, {"string", "Item_Submition", "2000", "text", ""}, {"int", "Item_Score", "0", "text", ""}, {"date", "Submit_Time", "0", "text", ""}, {"string", "Submit_Ip", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "UserAccount", "SurveyCode", "Head_1ID", "Item_ID", "Item_Type", "Item_Submition", "Item_Score", "Submit_Time", "Submit_Ip"};
private String[] ListFields = {"UserAccount", "SurveyCode", "Head_1ID", "Item_ID", "Item_Type", "Item_Submition", "Item_Score", "Submit_Time", "Submit_Ip"};
private String[] FormFields = {"UserAccount", "SurveyCode", "Head_1ID", "Item_ID", "Item_Type", "Item_Submition", "Item_Score", "Submit_Time", "Submit_Ip"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private SurveyAnswer getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    SurveyAnswer v = new SurveyAnswer();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramUserAccount(request, "UserAccount");
        v.paramSurveyCode(request, "SurveyCode");
        v.paramHead_1ID(request, "Head_1ID");
        v.paramItem_ID(request, "Item_ID");
        v.paramItem_Type(request, "Item_Type");
        v.paramItem_Submition(request, "Item_Submition");
        v.paramItem_Score(request, "Item_Score");
        v.paramSubmit_Time(request, "Submit_Time");
        v.paramSubmit_Ip(request, "Submit_Ip");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setUserAccount(ParamUtils.getParameter(request, "UserAccount", ""));
        v.setSurveyCode(ParamUtils.getParameter(request, "SurveyCode", ""));
        v.setHead_1ID(ParamUtils.getParameter(request, "Head_1ID", ""));
        v.setItem_ID(ParamUtils.getParameter(request, "Item_ID", ""));
        v.setItem_Type(ParamUtils.getParameter(request, "Item_Type", ""));
        v.setItem_Submition(ParamUtils.getParameter(request, "Item_Submition", ""));
        v.setItem_Score(ParamUtils.getIntParameter(request, "Item_Score", 0));
        v.setSubmit_Time(ParamUtils.getDateTimeParameter(request, "Submit_Time", java.sql.Date.valueOf("0001-01-01")));
        v.setSubmit_Ip(ParamUtils.getParameter(request, "Submit_Ip", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, SurveyAnswer pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        SurveyAnswer v = (SurveyAnswer)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getUserAccount()));
        row.add(Tool.jsSpecialChars(v.getSurveyCode()));
        row.add(Tool.jsSpecialChars(v.getHead_1ID()));
        row.add(Tool.jsSpecialChars(v.getItem_ID()));
        row.add(Tool.jsSpecialChars(v.getItem_Type()));
        row.add(Tool.jsSpecialChars(v.getItem_Submition()));
        row.add("" + v.getItem_Score());
        row.add(Tool.stringOfDate(v.getSubmit_Time()));
        row.add(Tool.jsSpecialChars(v.getSubmit_Ip()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, SurveyAnswer pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, SurveyAnswer pv, boolean isAll)
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
    SurveyAnswer pv = new SurveyAnswer();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "SurveyAnswer");
    request.setAttribute("describe", "调查问卷回答items");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    SurveyAnswer pv = new SurveyAnswer();
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
private void setForm(javax.servlet.http.HttpServletRequest request, SurveyAnswer form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "SurveyAnswer");
    request.setAttribute("describe", "调查问卷回答items");
}
private List mkRtn(String cmd, String forward, SurveyAnswer form)
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
    SurveyAnswer form = getByParameterDb(request);
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
log.debug("SurveyAnswerAction");
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
forwardMap.put("list", "SurveyAnswerAction.jsp");
forwardMap.put("failure", "SurveyAnswerForm.jsp");
forwardMap.put("success", "SurveyAnswerList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "SurveyAnswerForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='SurveyAnswerAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
