<%@ page language="java" %>
<%--模块--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(BaseMoudle.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Pid", "Name", "Code", "MoudleGrade", "MoudleType", "IsDept", "ToUrl", "OrderNum", "IsEnable", "OpLog"};
private String[] DicKeys = {"Id", "Pid", "Name", "Code", "MoudleGrade", "MoudleType", "IsDept", "ToUrl", "OrderNum", "IsEnable", "OpLog"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "上级模块", "0", "MoudleName", ""}, {"string", "模块名称", "200", "text", ""}, {"string", "编码", "200", "text", ""}, {"int", "级别", "0", "text", ""}, {"int", "类型", "0", "MoudleOrFun", ""}, {"int", "部门模块", "0", "YesNo", ""}, {"string", "连接Url", "500", "hidden", ""}, {"int", "排序", "0", "hidden", ""}, {"int", "是否可用", "0", "YesNo", ""}, {"string", "操作日志", "1000", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Pid", "Name", "Code", "MoudleGrade", "MoudleType", "IsDept", "ToUrl", "OrderNum", "IsEnable", "OpLog"};
private String[] ListFields = {"Pid", "Name", "Code", "MoudleGrade", "MoudleType", "IsDept", "IsEnable"};
private String[] FormFields = {"Pid", "Name", "Code", "MoudleGrade", "MoudleType", "IsDept", "ToUrl", "OrderNum", "IsEnable", "OpLog"};
private String[] QueryFields = {"Pid", "Name", "Code"};
private String[] HideFields = {"Id"};
private BaseMoudle getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    BaseMoudle v = new BaseMoudle();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramPid(request, "Pid");
        v.paramName(request, "Name");
        v.paramCode(request, "Code");
        v.paramMoudleGrade(request, "MoudleGrade");
        v.paramMoudleType(request, "MoudleType");
        v.paramIsDept(request, "IsDept");
        v.paramToUrl(request, "ToUrl");
        v.paramOrderNum(request, "OrderNum");
        v.paramIsEnable(request, "IsEnable");
        v.paramOpLog(request, "OpLog");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setPid(ParamUtils.getIntParameter(request, "Pid", -1));
        v.setName(ParamUtils.getParameter(request, "Name", ""));
        v.setCode(ParamUtils.getParameter(request, "Code", ""));
        v.setMoudleGrade(ParamUtils.getIntParameter(request, "MoudleGrade", -1));
        v.setMoudleType(ParamUtils.getIntParameter(request, "MoudleType", -1));
        v.setIsDept(ParamUtils.getIntParameter(request, "IsDept", -1));
        v.setToUrl(ParamUtils.getParameter(request, "ToUrl", ""));
        v.setOrderNum(ParamUtils.getIntParameter(request, "OrderNum", -1));
        v.setIsEnable(ParamUtils.getIntParameter(request, "IsEnable", -1));
        v.setOpLog(ParamUtils.getParameter(request, "OpLog", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, BaseMoudle pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map MoudleOrFunmap = CEditConst.getMoudleOrFunMap(userInfo);
    Map MoudleNamemap = CEditConst.getMoudleNameMap(userInfo);
    Map YesNomap = CEditConst.getYesNoMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        BaseMoudle v = (BaseMoudle)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add((String)MoudleNamemap.get("" + v.getPid()));
        row.add(Tool.jsSpecialChars(v.getName()));
        row.add(Tool.jsSpecialChars(v.getCode()));
        row.add("" + v.getMoudleGrade());
        row.add((String)MoudleOrFunmap.get("" + v.getMoudleType()));
        row.add((String)YesNomap.get("" + v.getIsDept()));
        row.add(Tool.jsSpecialChars(v.getToUrl()));
        row.add("" + v.getOrderNum());
        row.add((String)YesNomap.get("" + v.getIsEnable()));
        row.add(Tool.jsSpecialChars(v.getOpLog()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, BaseMoudle pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, BaseMoudle pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_Pid_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("pid=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_Name_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("name like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_Code_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("code like '%" + qval + "%'");
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
    request.setAttribute("MoudleNameoptions", CEditConst.getMoudleNameOptions(userInfo, "-1"));
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
    BaseMoudle pv = new BaseMoudle();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "BaseMoudle");
    request.setAttribute("describe", "模块");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    BaseMoudle pv = new BaseMoudle();
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
private void setForm(javax.servlet.http.HttpServletRequest request, BaseMoudle form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("MoudleOrFunoptions", CEditConst.getMoudleOrFunOptions(userInfo, "-1"));
    request.setAttribute("MoudleNameoptions", CEditConst.getMoudleNameOptions(userInfo, "-1"));
    request.setAttribute("YesNooptions", CEditConst.getYesNoOptions(userInfo, "-1"));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "BaseMoudle");
    request.setAttribute("describe", "模块");
}
/*
 * 校验提交保存数据的重复性问题
 * 如果有重复数据，返回true, 否则返回false
 */
private boolean isDuplicated(BaseMoudle form, String cmd)
{
    List cdt = new ArrayList();
    cdt.add("code='" + form.getCode() + "'");
    if(cmd.equals("update")) {
        cdt.add("id<>" + form.getId());
    }
    return (form.getCount(cdt) > 0);
}
private List mkRtn(String cmd, String forward, BaseMoudle form)
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
    BaseMoudle form = getByParameterDb(request);
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
        if (isDuplicated(form, cmd)) {
            request.setAttribute("msg", "编码重复!");
            setForm(request, form);
            return mkRtn("save", "input", form);
        }
        else {
            form.insert();
            return mkRtn("list", "list", form);
        }
    }
    if (cmd.equals("update"))
    {
        if (isDuplicated(form, cmd)) {
            request.setAttribute("msg", "编码重复!");
            setForm(request, form);
            return mkRtn("update", "input", form);
        }
        else {
            form.update();
            return mkRtn("list", "list", form);
        }
    }
    if (cmd.equals("tree"))
    {
        return mkRtn("tree", "tree", null);
    }
    request.setAttribute("msg", "未规定的cmd:" + cmd);
    return mkRtn("list", "failure", form);
}
%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("BaseMoudleAction");
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
forwardMap.put("list", "BaseMoudleAction.jsp");
forwardMap.put("failure", "BaseMoudleForm.jsp");
forwardMap.put("success", "BaseMoudleList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "BaseMoudleForm.jsp");
forwardMap.put("tree", "BaseMoudleTree.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='BaseMoudleAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
