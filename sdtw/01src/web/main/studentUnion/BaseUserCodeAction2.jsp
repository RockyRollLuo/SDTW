<%@ page language="java" %>
<%--人员管理--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(BaseUserCode.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "OrgId", "OrgCode", "DeptId", "DeptCode", "Name", "CnName", "Code", "Gender", "Occupation", "Grade", "Dept", "Orderby", "Principal", "PhoneNum", "MobilePhone", "Fax", "OfficeAddress", "Email", "Pwd", "HomeAddress", "HomeZipcode", "DeptZipcode", "UserIpphome", "LastTime", "SkinId", "DispNum", "OrderbyField", "OrderStyle", "Roles", "Enable", "IsFirstLogon", "OperTime", "OperLog", "OperUser", "LocusCode", "LogonNum", "CurIp", "CurTime", "Ip"};
private String[] DicKeys = {"Id", "OrgId", "OrgCode", "DeptId", "DeptCode", "Name", "CnName", "Code", "Gender", "Occupation", "Grade", "Dept", "Orderby", "Principal", "PhoneNum", "MobilePhone", "Fax", "OfficeAddress", "Email", "Pwd", "HomeAddress", "HomeZipcode", "DeptZipcode", "UserIpphome", "LastTime", "SkinId", "DispNum", "OrderbyField", "OrderStyle", "Roles", "Enable", "IsFirstLogon", "OperTime", "OperLog", "OperUser", "LocusCode", "LogonNum", "CurIp", "CurTime", "Ip"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "校区", "0", "OrgName", ""}, {"string", "单位代码", "50", "hidden", ""}, {"int", "学院", "0", "DeptName", ""}, {"string", "部门代码", "50", "hidden", ""}, {"string", "学号", "50", "text", ""}, {"string", "学生姓名", "50", "text", ""}, {"string", "用户编码", "50", "text", ""}, {"int", "性别", "0", "sex", ""}, {"string", "用户职务", "100", "text", ""}, {"string", "用户职称", "100", "hidden", ""}, {"string", "用户所属部门", "100", "hidden", ""}, {"int", "排序", "0", "hidden", ""}, {"string", "主管领导", "50", "hidden", ""}, {"string", "办公电话", "50", "text", ""}, {"string", "手机号码", "50", "text", ""}, {"string", "传真号码", "50", "hidden", ""}, {"string", "用户办公室地址", "200", "hidden", ""}, {"string", "电子邮箱", "50", "text", ""}, {"string", "用户登陆密码", "50", "hidden", ""}, {"string", "家庭地址", "255", "hidden", ""}, {"string", "住址邮编", "12", "hidden", ""}, {"string", "单位邮编", "12", "hidden", ""}, {"string", "用户Ip电话(代办改变否)", "50", "hidden", ""}, {"date", "最后访问时间", "0", "hidden", ""}, {"string", "皮肤Id号", "200", "hidden", ""}, {"int", "显示的条数", "0", "hidden", ""}, {"string", "按字段排序", "20", "hidden", ""}, {"string", "排序方式", "11", "hidden", ""}, {"string", "用户角色", "500", "RoleName", ""}, {"int", "删除标记", "0", "hidden", ""}, {"int", "是否初次登录", "0", "hidden", ""}, {"date", "操作时间", "0", "hidden", ""}, {"string", "操作日志", "500", "hidden", ""}, {"int", "操作人", "0", "hidden", ""}, {"string", "所在地编码", "50", "hidden", ""}, {"int", "登录次数", "0", "hidden", ""}, {"string", "本次Ip", "50", "hidden", ""}, {"date", "本次登录时间", "0", "hidden", ""}, {"string", "登录Ip", "50", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "OrgId", "OrgCode", "DeptId", "DeptCode", "Name", "CnName", "Code", "Gender", "Occupation", "Grade", "Dept", "Orderby", "Principal", "PhoneNum", "MobilePhone", "Fax", "OfficeAddress", "Email", "Pwd", "HomeAddress", "HomeZipcode", "DeptZipcode", "UserIpphome", "LastTime", "SkinId", "DispNum", "OrderbyField", "OrderStyle", "Roles", "Enable", "IsFirstLogon", "OperTime", "OperLog", "OperUser", "LocusCode", "LogonNum", "CurIp", "CurTime", "Ip"};
private String[] ListFields = {"OrgId", "DeptId", "Name", "CnName", "Gender"};
private String[] FormFields = {"OrgId", "DeptId", "Name", "CnName", "Code", "Gender", "Occupation", "Grade", "Dept", "Orderby", "Principal", "PhoneNum", "MobilePhone", "Fax", "OfficeAddress", "Email", "HomeAddress", "HomeZipcode", "DeptZipcode", "UserIpphome", "LastTime", "SkinId", "DispNum", "OrderbyField", "OrderStyle", "Roles", "IsFirstLogon", "OperLog", "CurTime"};
private String[] QueryFields = {"OrgId", "DeptId", "Name", "CnName", "Code", "Gender", "Occupation", "PhoneNum", "MobilePhone", "Email"};
private String[] HideFields = {"Id"};
private BaseUserCode getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    BaseUserCode v = new BaseUserCode();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramOrgId(request, "OrgId");
        v.paramOrgCode(request, "OrgCode");
        v.paramDeptId(request, "DeptId");
        v.paramDeptCode(request, "DeptCode");
        v.paramName(request, "Name");
        v.paramCnName(request, "CnName");
        v.paramCode(request, "Code");
        v.paramGender(request, "Gender");
        v.paramOccupation(request, "Occupation");
        v.paramGrade(request, "Grade");
        v.paramDept(request, "Dept");
        v.paramOrderby(request, "Orderby");
        v.paramPrincipal(request, "Principal");
        v.paramPhoneNum(request, "PhoneNum");
        v.paramMobilePhone(request, "MobilePhone");
        v.paramFax(request, "Fax");
        v.paramOfficeAddress(request, "OfficeAddress");
        v.paramEmail(request, "Email");
        v.paramPwd(request, "Pwd");
        v.paramHomeAddress(request, "HomeAddress");
        v.paramHomeZipcode(request, "HomeZipcode");
        v.paramDeptZipcode(request, "DeptZipcode");
        v.paramUserIpphome(request, "UserIpphome");
        v.paramLastTime(request, "LastTime");
        v.paramSkinId(request, "SkinId");
        v.paramDispNum(request, "DispNum");
        v.paramOrderbyField(request, "OrderbyField");
        v.paramOrderStyle(request, "OrderStyle");
        v.paramRoles(request, "Roles");
        v.paramEnable(request, "Enable");
        v.paramIsFirstLogon(request, "IsFirstLogon");
        v.paramOperTime(request, "OperTime");
        v.paramOperLog(request, "OperLog");
        v.paramOperUser(request, "OperUser");
        v.paramLocusCode(request, "LocusCode");
        v.paramLogonNum(request, "LogonNum");
        v.paramCurIp(request, "CurIp");
        v.paramCurTime(request, "CurTime");
        v.paramIp(request, "Ip");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setOrgId(ParamUtils.getIntParameter(request, "OrgId", -1));
        v.setOrgCode(ParamUtils.getParameter(request, "OrgCode", ""));
        v.setDeptId(ParamUtils.getIntParameter(request, "DeptId", -1));
        v.setDeptCode(ParamUtils.getParameter(request, "DeptCode", ""));
        v.setName(ParamUtils.getParameter(request, "Name", ""));
        v.setCnName(ParamUtils.getParameter(request, "CnName", ""));
        v.setCode(ParamUtils.getParameter(request, "Code", ""));
        v.setGender(ParamUtils.getIntParameter(request, "Gender", -1));
        v.setOccupation(ParamUtils.getParameter(request, "Occupation", ""));
        v.setGrade(ParamUtils.getParameter(request, "Grade", ""));
        v.setDept(ParamUtils.getParameter(request, "Dept", ""));
        v.setOrderby(ParamUtils.getIntParameter(request, "Orderby", -1));
        v.setPrincipal(ParamUtils.getParameter(request, "Principal", ""));
        v.setPhoneNum(ParamUtils.getParameter(request, "PhoneNum", ""));
        v.setMobilePhone(ParamUtils.getParameter(request, "MobilePhone", ""));
        v.setFax(ParamUtils.getParameter(request, "Fax", ""));
        v.setOfficeAddress(ParamUtils.getParameter(request, "OfficeAddress", ""));
        v.setEmail(ParamUtils.getParameter(request, "Email", ""));
        v.setPwd(ParamUtils.getParameter(request, "Pwd", ""));
        v.setHomeAddress(ParamUtils.getParameter(request, "HomeAddress", ""));
        v.setHomeZipcode(ParamUtils.getParameter(request, "HomeZipcode", ""));
        v.setDeptZipcode(ParamUtils.getParameter(request, "DeptZipcode", ""));
        v.setUserIpphome(ParamUtils.getParameter(request, "UserIpphome", ""));
        v.setLastTime(ParamUtils.getDateTimeParameter(request, "LastTime", java.sql.Date.valueOf("0001-01-01")));
        v.setSkinId(ParamUtils.getParameter(request, "SkinId", ""));
        v.setDispNum(ParamUtils.getIntParameter(request, "DispNum", -1));
        v.setOrderbyField(ParamUtils.getParameter(request, "OrderbyField", ""));
        v.setOrderStyle(ParamUtils.getParameter(request, "OrderStyle", ""));
        v.setRoles(ParamUtils.getParameter(request, "Roles", ""));
        v.setEnable(ParamUtils.getIntParameter(request, "Enable", 1));
        v.setIsFirstLogon(ParamUtils.getIntParameter(request, "IsFirstLogon", -1));
        v.setOperTime(ParamUtils.getDateTimeParameter(request, "OperTime", java.sql.Date.valueOf("0001-01-01")));
        v.setOperLog(ParamUtils.getParameter(request, "OperLog", ""));
        v.setOperUser(ParamUtils.getIntParameter(request, "OperUser", -1));
        v.setLocusCode(ParamUtils.getParameter(request, "LocusCode", ""));
        v.setLogonNum(ParamUtils.getIntParameter(request, "LogonNum", -1));
        v.setCurIp(ParamUtils.getParameter(request, "CurIp", ""));
        v.setCurTime(ParamUtils.getDateTimeParameter(request, "CurTime", java.sql.Date.valueOf("0001-01-01")));
        v.setIp(ParamUtils.getParameter(request, "Ip", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, BaseUserCode pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    
    Map DeptNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map OrgNamemap = CEditConst.getOrgCityNameMap(userInfo);
    Map RoleNamemap = CEditConst.getRoleNameMap(userInfo);
    Map sexmap = CEditConst.getsexMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        BaseUserCode v = (BaseUserCode)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add((String)OrgNamemap.get("" + v.getOrgId()));
        row.add(Tool.jsSpecialChars(v.getOrgCode()));
        row.add((String)DeptNamemap.get("" + v.getDeptId()));
        row.add(Tool.jsSpecialChars(v.getDeptCode()));
        row.add(Tool.jsSpecialChars(v.getName()));
        row.add(Tool.jsSpecialChars(v.getCnName()));
        row.add(Tool.jsSpecialChars(v.getCode()));
        row.add((String)sexmap.get("" + v.getGender()));
        row.add(Tool.jsSpecialChars(v.getOccupation()));
        row.add(Tool.jsSpecialChars(v.getGrade()));
        row.add(Tool.jsSpecialChars(v.getDept()));
        row.add("" + v.getOrderby());
        row.add(Tool.jsSpecialChars(v.getPrincipal()));
        row.add(Tool.jsSpecialChars(v.getPhoneNum()));
        row.add(Tool.jsSpecialChars(v.getMobilePhone()));
        row.add(Tool.jsSpecialChars(v.getFax()));
        row.add(Tool.jsSpecialChars(v.getOfficeAddress()));
        row.add(Tool.jsSpecialChars(v.getEmail()));
        row.add(Tool.jsSpecialChars(v.getPwd()));
        row.add(Tool.jsSpecialChars(v.getHomeAddress()));
        row.add(Tool.jsSpecialChars(v.getHomeZipcode()));
        row.add(Tool.jsSpecialChars(v.getDeptZipcode()));
        row.add(Tool.jsSpecialChars(v.getUserIpphome()));
        row.add(Tool.stringOfDate(v.getLastTime()));
        row.add(Tool.jsSpecialChars(v.getSkinId()));
        row.add("" + v.getDispNum());
        row.add(Tool.jsSpecialChars(v.getOrderbyField()));
        row.add(Tool.jsSpecialChars(v.getOrderStyle()));
        row.add((String)RoleNamemap.get("" + v.getRoles()));
        row.add("" + v.getEnable());
        row.add("" + v.getIsFirstLogon());
        row.add(Tool.stringOfDate(v.getOperTime()));
        row.add(Tool.jsSpecialChars(v.getOperLog()));
        row.add("" + v.getOperUser());
        row.add(Tool.jsSpecialChars(v.getLocusCode()));
        row.add("" + v.getLogonNum());
        row.add(Tool.jsSpecialChars(v.getCurIp()));
        row.add(Tool.stringOfDate(v.getCurTime()));
        row.add(Tool.jsSpecialChars(v.getIp()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, BaseUserCode pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, BaseUserCode pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_OrgId_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("orgid=" + qval);
    }
    cdt.add("roles =3");
    qval = ParamUtils.getParameter(request, "_DeptId_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&&!"-1".equals(qval.trim())) {
        cdt.add("deptid=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_Name_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("name like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_CnName_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("cnname like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_Sno_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("name ='"+qval+"'");
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
    request.setAttribute("DeptNameoptions", CEditConst.getDeptNameOptions(userInfo, "-1"));
    request.setAttribute("OrgNameoptions", CEditConst.getOrgNameOptions(userInfo, "-1"));
    request.setAttribute("sexoptions", CEditConst.getsexOptions(userInfo, "-1"));
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
    BaseUserCode pv = new BaseUserCode();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "BaseUserCode");
    request.setAttribute("describe", "人员管理");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    BaseUserCode pv = new BaseUserCode();
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
private void setForm(javax.servlet.http.HttpServletRequest request, BaseUserCode form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("DeptNameoptions", CEditConst.getDeptNameOptions(userInfo, "-1"));
    request.setAttribute("OrgNameoptions", CEditConst.getOrgNameOptions(userInfo, "-1"));
    request.setAttribute("RoleNameoptions", CEditConst.getRoleNameOptions(userInfo, ""));
    request.setAttribute("sexoptions", CEditConst.getsexOptions(userInfo, "-1"));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "BaseUserCode");
    request.setAttribute("describe", "人员管理");
}
/*
 * 校验提交保存数据的重复性问题
 * 如果有重复数据，返回true, 否则返回false
 */
private boolean isDuplicated(BaseUserCode form, String cmd)
{
    List cdt = new ArrayList();
    cdt.add("code='" + form.getCode() + "'");
    if(cmd.equals("update")) {
        cdt.add("id<>" + form.getId());
    }
    return (form.getCount(cdt) > 0);
}
private List mkRtn(String cmd, String forward, BaseUserCode form)
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
    BaseUserCode form = getByParameterDb(request);
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
            request.setAttribute("msg", "用户编码重复!");
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
            request.setAttribute("msg", "用户编码重复!");
            setForm(request, form);
            return mkRtn("update", "input", form);
        }
        else {
            form.update();
            return mkRtn("list", "list", form);
        }
    }
    request.setAttribute("msg", "未规定的cmd:" + cmd);
    return mkRtn("list", "failure", form);
}
%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("BaseUserCodeAction");
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
forwardMap.put("list", "BaseUserCodeAction2.jsp");
forwardMap.put("failure", "BaseUserCodeForm.jsp");
forwardMap.put("success", "BaseUserCodeList2.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "BaseUserCodeForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='BaseUserCodeAction2.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
