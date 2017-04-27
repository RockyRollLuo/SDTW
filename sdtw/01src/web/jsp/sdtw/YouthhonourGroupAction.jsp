<%@ page language="java" %>
<%--五四评比表彰团体申请表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(YouthhonourGroup.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "SchoolYear", "Type", "Addaccount", "Addtime", "AyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "XyCheckDate", "TwCheckDate", "BelongAcademy", "Val1", "Val2", "Val3", "Val4", "Val5", "Val6", "Val7", "Val8", "Val9", "Val10", "Val11", "Val12", "Val13", "Val14", "Val15", "Val16", "Val17", "Val18", "Val19", "Val20", "Text1", "Text2", "Text3", "Text4"};
private String[] DicKeys = {"Id", "SchoolYear", "Type", "Addaccount", "Addtime", "AyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "XyCheckDate", "TwCheckDate", "BelongAcademy", "Val1", "Val2", "Val3", "Val4", "Val5", "Val6", "Val7", "Val8", "Val9", "Val10", "Val11", "Val12", "Val13", "Val14", "Val15", "Val16", "Val17", "Val18", "Val19", "Val20", "Text1", "Text2", "Text3", "Text4"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "学年", "45", "text", ""}, {"int", "申请表类型", "0", "text", ""}, {"string", "添加账号", "45", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"int", "学院审核标志", "0", "text", ""}, {"int", "团委审核标志", "0", "text", ""}, {"int", "是否可修改标志", "0", "text", ""}, {"int", "学院提交标志", "0", "text", ""}, {"int", "团委发布标志", "0", "text", ""}, {"date", "学院审核时间", "0", "hidden", ""}, {"date", "团委审核时间", "0", "hidden", ""}, {"string", "所属单位", "45", "text", ""}, {"string", "va1", "45", "hidden", ""}, {"string", "va2", "45", "hidden", ""}, {"string", "va3", "45", "hidden", ""}, {"string", "va4", "45", "hidden", ""}, {"string", "va5", "45", "hidden", ""}, {"string", "va6", "45", "hidden", ""}, {"string", "va7", "45", "hidden", ""}, {"string", "va8", "45", "hidden", ""}, {"string", "va9", "45", "hidden", ""}, {"string", "va10", "45", "hidden", ""}, {"string", "va11", "45", "hidden", ""}, {"string", "va12", "45", "hidden", ""}, {"string", "va13", "45", "hidden", ""}, {"string", "va14", "45", "hidden", ""}, {"string", "va15", "45", "hidden", ""}, {"string", "va16", "45", "hidden", ""}, {"string", "va17", "45", "hidden", ""}, {"string", "va18", "45", "hidden", ""}, {"string", "va19", "45", "hidden", ""}, {"string", "va20", "45", "hidden", ""}, {"string", "text1", "500", "hidden", ""}, {"string", "text2", "500", "hidden", ""}, {"string", "text3", "500", "hidden", ""}, {"string", "text4", "500", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "SchoolYear", "Type", "Addaccount", "Addtime", "AyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "XyCheckDate", "TwCheckDate", "BelongAcademy", "Val1", "Val2", "Val3", "Val4", "Val5", "Val6", "Val7", "Val8", "Val9", "Val10", "Val11", "Val12", "Val13", "Val14", "Val15", "Val16", "Val17", "Val18", "Val19", "Val20", "Text1", "Text2", "Text3", "Text4"};
private String[] ListFields = {"SchoolYear", "Type", "AyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "BelongAcademy"};
private String[] FormFields = {"SchoolYear", "Type", "AyCheckFlag", "TwCheckFlag", "ModifyFlag", "XyReport", "TwReport", "BelongAcademy", "Val1", "Val2", "Val3", "Val4", "Val5", "Val6", "Val7", "Val8", "Val9", "Val10", "Val11", "Val12", "Val13", "Val14", "Val15", "Val16", "Val17", "Val18", "Val19", "Val20", "Text1", "Text2", "Text3", "Text4"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private YouthhonourGroup getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    YouthhonourGroup v = new YouthhonourGroup();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramSchoolYear(request, "SchoolYear");
        v.paramType(request, "Type");
        v.paramAddaccount(request, "Addaccount");
        v.paramAddtime(request, "Addtime");
        v.paramAyCheckFlag(request, "AyCheckFlag");
        v.paramTwCheckFlag(request, "TwCheckFlag");
        v.paramModifyFlag(request, "ModifyFlag");
        v.paramXyReport(request, "XyReport");
        v.paramTwReport(request, "TwReport");
        v.paramXyCheckDate(request, "XyCheckDate");
        v.paramTwCheckDate(request, "TwCheckDate");
        v.paramBelongAcademy(request, "BelongAcademy");
        v.paramVal1(request, "Val1");
        v.paramVal2(request, "Val2");
        v.paramVal3(request, "Val3");
        v.paramVal4(request, "Val4");
        v.paramVal5(request, "Val5");
        v.paramVal6(request, "Val6");
        v.paramVal7(request, "Val7");
        v.paramVal8(request, "Val8");
        v.paramVal9(request, "Val9");
        v.paramVal10(request, "Val10");
        v.paramVal11(request, "Val11");
        v.paramVal12(request, "Val12");
        v.paramVal13(request, "Val13");
        v.paramVal14(request, "Val14");
        v.paramVal15(request, "Val15");
        v.paramVal16(request, "Val16");
        v.paramVal17(request, "Val17");
        v.paramVal18(request, "Val18");
        v.paramVal19(request, "Val19");
        v.paramVal20(request, "Val20");
        v.paramText1(request, "Text1");
        v.paramText2(request, "Text2");
        v.paramText3(request, "Text3");
        v.paramText4(request, "Text4");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setSchoolYear(ParamUtils.getParameter(request, "SchoolYear", ""));
        v.setType(ParamUtils.getIntParameter(request, "Type", -1));
        v.setAddaccount(ParamUtils.getParameter(request, "Addaccount", ""));
        v.setAddtime(ParamUtils.getDateTimeParameter(request, "Addtime", java.sql.Date.valueOf("0001-01-01")));
        v.setAyCheckFlag(ParamUtils.getIntParameter(request, "AyCheckFlag", -1));
        v.setTwCheckFlag(ParamUtils.getIntParameter(request, "TwCheckFlag", -1));
        v.setModifyFlag(ParamUtils.getIntParameter(request, "ModifyFlag", -1));
        v.setXyReport(ParamUtils.getIntParameter(request, "XyReport", -1));
        v.setTwReport(ParamUtils.getIntParameter(request, "TwReport", -1));
        v.setXyCheckDate(ParamUtils.getDateTimeParameter(request, "XyCheckDate", java.sql.Date.valueOf("0001-01-01")));
        v.setTwCheckDate(ParamUtils.getDateTimeParameter(request, "TwCheckDate", java.sql.Date.valueOf("0001-01-01")));
        v.setBelongAcademy(ParamUtils.getParameter(request, "BelongAcademy", ""));
        v.setVal1(ParamUtils.getParameter(request, "Val1", ""));
        v.setVal2(ParamUtils.getParameter(request, "Val2", ""));
        v.setVal3(ParamUtils.getParameter(request, "Val3", ""));
        v.setVal4(ParamUtils.getParameter(request, "Val4", ""));
        v.setVal5(ParamUtils.getParameter(request, "Val5", ""));
        v.setVal6(ParamUtils.getParameter(request, "Val6", ""));
        v.setVal7(ParamUtils.getParameter(request, "Val7", ""));
        v.setVal8(ParamUtils.getParameter(request, "Val8", ""));
        v.setVal9(ParamUtils.getParameter(request, "Val9", ""));
        v.setVal10(ParamUtils.getParameter(request, "Val10", ""));
        v.setVal11(ParamUtils.getParameter(request, "Val11", ""));
        v.setVal12(ParamUtils.getParameter(request, "Val12", ""));
        v.setVal13(ParamUtils.getParameter(request, "Val13", ""));
        v.setVal14(ParamUtils.getParameter(request, "Val14", ""));
        v.setVal15(ParamUtils.getParameter(request, "Val15", ""));
        v.setVal16(ParamUtils.getParameter(request, "Val16", ""));
        v.setVal17(ParamUtils.getParameter(request, "Val17", ""));
        v.setVal18(ParamUtils.getParameter(request, "Val18", ""));
        v.setVal19(ParamUtils.getParameter(request, "Val19", ""));
        v.setVal20(ParamUtils.getParameter(request, "Val20", ""));
        v.setText1(ParamUtils.getParameter(request, "Text1", ""));
        v.setText2(ParamUtils.getParameter(request, "Text2", ""));
        v.setText3(ParamUtils.getParameter(request, "Text3", ""));
        v.setText4(ParamUtils.getParameter(request, "Text4", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, YouthhonourGroup pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        YouthhonourGroup v = (YouthhonourGroup)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getSchoolYear()));
        row.add("" + v.getType());
        row.add(Tool.jsSpecialChars(v.getAddaccount()));
        row.add(Tool.stringOfDate(v.getAddtime()));
        row.add("" + v.getAyCheckFlag());
        row.add("" + v.getTwCheckFlag());
        row.add("" + v.getModifyFlag());
        row.add("" + v.getXyReport());
        row.add("" + v.getTwReport());
        row.add(Tool.stringOfDate(v.getXyCheckDate()));
        row.add(Tool.stringOfDate(v.getTwCheckDate()));
        row.add(Tool.jsSpecialChars(v.getBelongAcademy()));
        row.add(Tool.jsSpecialChars(v.getVal1()));
        row.add(Tool.jsSpecialChars(v.getVal2()));
        row.add(Tool.jsSpecialChars(v.getVal3()));
        row.add(Tool.jsSpecialChars(v.getVal4()));
        row.add(Tool.jsSpecialChars(v.getVal5()));
        row.add(Tool.jsSpecialChars(v.getVal6()));
        row.add(Tool.jsSpecialChars(v.getVal7()));
        row.add(Tool.jsSpecialChars(v.getVal8()));
        row.add(Tool.jsSpecialChars(v.getVal9()));
        row.add(Tool.jsSpecialChars(v.getVal10()));
        row.add(Tool.jsSpecialChars(v.getVal11()));
        row.add(Tool.jsSpecialChars(v.getVal12()));
        row.add(Tool.jsSpecialChars(v.getVal13()));
        row.add(Tool.jsSpecialChars(v.getVal14()));
        row.add(Tool.jsSpecialChars(v.getVal15()));
        row.add(Tool.jsSpecialChars(v.getVal16()));
        row.add(Tool.jsSpecialChars(v.getVal17()));
        row.add(Tool.jsSpecialChars(v.getVal18()));
        row.add(Tool.jsSpecialChars(v.getVal19()));
        row.add(Tool.jsSpecialChars(v.getVal20()));
        row.add(Tool.jsSpecialChars(v.getText1()));
        row.add(Tool.jsSpecialChars(v.getText2()));
        row.add(Tool.jsSpecialChars(v.getText3()));
        row.add(Tool.jsSpecialChars(v.getText4()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, YouthhonourGroup pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, YouthhonourGroup pv, boolean isAll)
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
    YouthhonourGroup pv = new YouthhonourGroup();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "YouthhonourGroup");
    request.setAttribute("describe", "五四评比表彰团体申请表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    YouthhonourGroup pv = new YouthhonourGroup();
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
private void setForm(javax.servlet.http.HttpServletRequest request, YouthhonourGroup form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "YouthhonourGroup");
    request.setAttribute("describe", "五四评比表彰团体申请表");
}
private List mkRtn(String cmd, String forward, YouthhonourGroup form)
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
    YouthhonourGroup form = getByParameterDb(request);
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
log.debug("YouthhonourGroupAction");
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
forwardMap.put("list", "YouthhonourGroupAction.jsp");
forwardMap.put("failure", "YouthhonourGroupForm.jsp");
forwardMap.put("success", "YouthhonourGroupList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "YouthhonourGroupForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='YouthhonourGroupAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
