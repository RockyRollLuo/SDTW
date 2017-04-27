<%@ page language="java" %>
<%--学生素质拓展培养认证单-不用--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(StudentsRzd.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Reason", "Submitflag", "Printcode", "Sno", "Academy", "Rownumstr", "Value1", "Value2", "Value3", "Value4", "Value5", "Listarray1", "Listarray2", "Listarray3", "Listarray4", "Listarray5", "Listarray6", "Listarray7", "Listarray8", "Listarray9", "Listarray10", "Checkflag"};
private String[] DicKeys = {"Id", "Reason", "Submitflag", "Printcode", "Sno", "Academy", "Rownumstr", "Value1", "Value2", "Value3", "Value4", "Value5", "Listarray1", "Listarray2", "Listarray3", "Listarray4", "Listarray5", "Listarray6", "Listarray7", "Listarray8", "Listarray9", "Listarray10", "Checkflag"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "审核意见", "255", "text", ""}, {"smallint", "是否提交", "0", "text", ""}, {"string", "打印编号", "20", "text", ""}, {"string", "学号", "20", "text", ""}, {"string", "学院", "45", "text", ""}, {"string", "rowspan", "255", "text", ""}, {"string", "姓名", "45", "text", ""}, {"string", "政治面貌", "45", "text", ""}, {"string", "学院下分院", "45", "text", ""}, {"string", "专业", "45", "text", ""}, {"string", "年级", "45", "text", ""}, {"string", "主题教育", "255", "text", ""}, {"string", "文化艺术", "255", "text", ""}, {"string", "体育健康", "255", "text", ""}, {"string", "科技创新", "255", "text", ""}, {"string", "实践服务", "255", "text", ""}, {"string", "就业创业", "255", "text", ""}, {"string", "志愿服务", "255", "text", ""}, {"string", "社会工作", "255", "text", ""}, {"string", "社团经历", "255", "text", ""}, {"string", "学术论坛", "255", "text", ""}, {"smallint", "0未审核 ，2 未通过 ，1通过", "0", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Reason", "Submitflag", "Printcode", "Sno", "Academy", "Rownumstr", "Value1", "Value2", "Value3", "Value4", "Value5", "Listarray1", "Listarray2", "Listarray3", "Listarray4", "Listarray5", "Listarray6", "Listarray7", "Listarray8", "Listarray9", "Listarray10", "Checkflag"};
private String[] ListFields = {"Reason", "Submitflag", "Printcode", "Sno", "Academy", "Rownumstr", "Value1", "Value2", "Value3", "Value4", "Value5", "Listarray1", "Listarray2", "Listarray3", "Listarray4", "Listarray5", "Listarray6", "Listarray7", "Listarray8", "Listarray9", "Listarray10", "Checkflag"};
private String[] FormFields = {"Reason", "Submitflag", "Printcode", "Sno", "Academy", "Rownumstr", "Value1", "Value2", "Value3", "Value4", "Value5", "Listarray1", "Listarray2", "Listarray3", "Listarray4", "Listarray5", "Listarray6", "Listarray7", "Listarray8", "Listarray9", "Listarray10", "Checkflag"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private StudentsRzd getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    StudentsRzd v = new StudentsRzd();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramReason(request, "Reason");
        v.paramSubmitflag(request, "Submitflag");
        v.paramPrintcode(request, "Printcode");
        v.paramSno(request, "Sno");
        v.paramAcademy(request, "Academy");
        v.paramRownumstr(request, "Rownumstr");
        v.paramValue1(request, "Value1");
        v.paramValue2(request, "Value2");
        v.paramValue3(request, "Value3");
        v.paramValue4(request, "Value4");
        v.paramValue5(request, "Value5");
        v.paramListarray1(request, "Listarray1");
        v.paramListarray2(request, "Listarray2");
        v.paramListarray3(request, "Listarray3");
        v.paramListarray4(request, "Listarray4");
        v.paramListarray5(request, "Listarray5");
        v.paramListarray6(request, "Listarray6");
        v.paramListarray7(request, "Listarray7");
        v.paramListarray8(request, "Listarray8");
        v.paramListarray9(request, "Listarray9");
        v.paramListarray10(request, "Listarray10");
        v.paramCheckflag(request, "Checkflag");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setReason(ParamUtils.getParameter(request, "Reason", ""));
        v.setSubmitflag(ParamUtils.getIntParameter(request, "Submitflag", 0));
        v.setPrintcode(ParamUtils.getParameter(request, "Printcode", ""));
        v.setSno(ParamUtils.getParameter(request, "Sno", ""));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setRownumstr(ParamUtils.getParameter(request, "Rownumstr", ""));
        v.setValue1(ParamUtils.getParameter(request, "Value1", ""));
        v.setValue2(ParamUtils.getParameter(request, "Value2", ""));
        v.setValue3(ParamUtils.getParameter(request, "Value3", ""));
        v.setValue4(ParamUtils.getParameter(request, "Value4", ""));
        v.setValue5(ParamUtils.getParameter(request, "Value5", ""));
        v.setListarray1(ParamUtils.getParameter(request, "Listarray1", ""));
        v.setListarray2(ParamUtils.getParameter(request, "Listarray2", ""));
        v.setListarray3(ParamUtils.getParameter(request, "Listarray3", ""));
        v.setListarray4(ParamUtils.getParameter(request, "Listarray4", ""));
        v.setListarray5(ParamUtils.getParameter(request, "Listarray5", ""));
        v.setListarray6(ParamUtils.getParameter(request, "Listarray6", ""));
        v.setListarray7(ParamUtils.getParameter(request, "Listarray7", ""));
        v.setListarray8(ParamUtils.getParameter(request, "Listarray8", ""));
        v.setListarray9(ParamUtils.getParameter(request, "Listarray9", ""));
        v.setListarray10(ParamUtils.getParameter(request, "Listarray10", ""));
        v.setCheckflag(ParamUtils.getIntParameter(request, "Checkflag", 0));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, StudentsRzd pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        StudentsRzd v = (StudentsRzd)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getReason()));
        row.add("" + v.getSubmitflag());
        row.add(Tool.jsSpecialChars(v.getPrintcode()));
        row.add(Tool.jsSpecialChars(v.getSno()));
        row.add(Tool.jsSpecialChars(v.getAcademy()));
        row.add(Tool.jsSpecialChars(v.getRownumstr()));
        row.add(Tool.jsSpecialChars(v.getValue1()));
        row.add(Tool.jsSpecialChars(v.getValue2()));
        row.add(Tool.jsSpecialChars(v.getValue3()));
        row.add(Tool.jsSpecialChars(v.getValue4()));
        row.add(Tool.jsSpecialChars(v.getValue5()));
        row.add(Tool.jsSpecialChars(v.getListarray1()));
        row.add(Tool.jsSpecialChars(v.getListarray2()));
        row.add(Tool.jsSpecialChars(v.getListarray3()));
        row.add(Tool.jsSpecialChars(v.getListarray4()));
        row.add(Tool.jsSpecialChars(v.getListarray5()));
        row.add(Tool.jsSpecialChars(v.getListarray6()));
        row.add(Tool.jsSpecialChars(v.getListarray7()));
        row.add(Tool.jsSpecialChars(v.getListarray8()));
        row.add(Tool.jsSpecialChars(v.getListarray9()));
        row.add(Tool.jsSpecialChars(v.getListarray10()));
        row.add("" + v.getCheckflag());
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, StudentsRzd pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, StudentsRzd pv, boolean isAll)
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
    StudentsRzd pv = new StudentsRzd();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "StudentsRzd");
    request.setAttribute("describe", "学生素质拓展培养认证单-不用");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    StudentsRzd pv = new StudentsRzd();
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
private void setForm(javax.servlet.http.HttpServletRequest request, StudentsRzd form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "StudentsRzd");
    request.setAttribute("describe", "学生素质拓展培养认证单-不用");
}
private List mkRtn(String cmd, String forward, StudentsRzd form)
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
    StudentsRzd form = getByParameterDb(request);
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
log.debug("StudentsRzdAction");
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
forwardMap.put("list", "StudentsRzdAction.jsp");
forwardMap.put("failure", "StudentsRzdForm.jsp");
forwardMap.put("success", "StudentsRzdList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "StudentsRzdForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='StudentsRzdAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
