<%@ page language="java" %>
<%--学生会部门成员--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(StudentUnionMember.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Unionid", "Deptid", "UnionorDept", "SNo", "Campus", "ChargeDept", "Phone", "Duty", "Remark", "SchoolYear"};
private String[] DicKeys = {"Id", "Unionid", "Deptid", "UnionorDept", "SNo", "Campus", "ChargeDept", "Phone", "Duty", "Remark", "SchoolYear"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "校级院级学生会id", "0", "text", ""}, {"int", "部门学生会id", "0", "StuDeptName", ""}, {"string", "院级或部门级学生会", "45", "text", ""}, {"String", "姓名", "0", "text", ""}, {"string", "校区", "45", "OrgName", ""}, {"string", "学院", "45", "StuDeptName", ""}, {"string", "手机", "45", "text", ""}, {"string", "职位", "45", "StuDuty", ""}, {"string", "邮箱", "45", "text", ""}, {"string", "年级", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Unionid", "Deptid", "UnionorDept", "SNo", "Campus", "ChargeDept", "Phone", "Duty", "Remark", "SchoolYear"};
private String[] ListFields = {  "SNo", "Duty", "Campus", "ChargeDept", "Phone", "Remark", "SchoolYear"};
private String[] FormFields = {"Unionid", "Deptid", "UnionorDept", "SNo", "Campus", "ChargeDept", "Phone", "Duty", "Remark", "SchoolYear"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private StudentUnionMember getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    StudentUnionMember v = new StudentUnionMember();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramUnionid(request, "Unionid");
        v.paramDeptid(request, "Deptid");
        v.paramUnionorDept(request, "UnionorDept");
        v.paramSNo(request, "SNo");
        v.paramCampus(request, "Campus");
        v.paramChargeDept(request, "ChargeDept");
        v.paramPhone(request, "Phone");
        v.paramDuty(request, "Duty");
        v.paramRemark(request, "Remark");
        v.paramSchoolYear(request, "SchoolYear");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setUnionid(ParamUtils.getIntParameter(request, "Unionid", -1));
        v.setDeptid(ParamUtils.getIntParameter(request, "Deptid", -1));
        v.setUnionorDept(ParamUtils.getParameter(request, "UnionorDept", ""));
        v.setSNo(ParamUtils.getParameter(request, "SNo", ""));
        v.setCampus(ParamUtils.getParameter(request, "Campus", ""));
        v.setChargeDept(ParamUtils.getParameter(request, "ChargeDept", ""));
        v.setPhone(ParamUtils.getParameter(request, "Phone", ""));
        v.setDuty(ParamUtils.getParameter(request, "Duty", ""));
        v.setRemark(ParamUtils.getParameter(request, "Remark", ""));
        v.setSchoolYear(ParamUtils.getParameter(request, "SchoolYear", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, StudentUnionMember pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map StuDeptNamemap = CEditConst.getStuDeptNameMap(userInfo);
    Map OrgNamemap = CEditConst.getOrgNameMap(userInfo);
    Map StuDutymap = CEditConst.getStuDutyMap(userInfo);
    Map cnnamemap=CEditConst.getUserCnNameMap(userInfo);
    Map xynamemap= CEditConst.getAcademyNameMap(userInfo);
    Map nianjimap= CEditConst.getGradeNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        StudentUnionMember v = (StudentUnionMember)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add("" + v.getUnionid());
        row.add((String)StuDeptNamemap.get("" + v.getDeptid()));
        row.add(Tool.jsSpecialChars(v.getUnionorDept()));
        row.add(cnnamemap.get(v.getUnionorDept()));
        row.add((String)OrgNamemap.get("" + v.getCampus()));
        row.add((String)xynamemap.get("" + v.getChargeDept()));
        row.add(Tool.jsSpecialChars(v.getPhone()));
        row.add((String)StuDutymap.get("" + v.getDuty()));
        row.add(Tool.jsSpecialChars(v.getRemark()));
        row.add(nianjimap.get(v.getSchoolYear()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, StudentUnionMember pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, StudentUnionMember pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval=ParamUtils.getParameter(request, "_type_", "-1");

    if(qval.equals("zhuxi")){
    	cdt.add("duty in (0,1,2,3,4)");
    }
   
    qval=ParamUtils.getParameter(request, "_UnionId_", "-1");
    if(qval.length()>0&&!qval.equals("-1")){
    	cdt.add("unionid="+qval);
    }
    qval=ParamUtils.getParameter(request, "_deptid_", "-1");
    if(qval.length()>0&&!qval.equals("-1")){
    	cdt.add("deptid="+qval);
    }
    QueryValues.add(qval);
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
    StudentUnionMember pv = new StudentUnionMember();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "StudentUnionMember");
    request.setAttribute("describe", "学生会部门成员");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    StudentUnionMember pv = new StudentUnionMember();
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
private void setForm(javax.servlet.http.HttpServletRequest request, StudentUnionMember form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("StuDeptNameoptions", CEditConst.getStuDeptNameOptions(userInfo, ""));
    request.setAttribute("OrgNameoptions", CEditConst.getOrgNameOptions(userInfo, ""));
    request.setAttribute("StuDutyoptions", CEditConst.getStuDutyOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "StudentUnionMember");
    request.setAttribute("describe", "学生会部门成员");
}
private List mkRtn(String cmd, String forward, StudentUnionMember form)
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
    StudentUnionMember form = getByParameterDb(request);
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
log.debug("StudentUnionMemberAction");
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
forwardMap.put("list", "StudentUnionMemberAction.jsp");
forwardMap.put("failure", "StudentUnionMemberForm.jsp");
forwardMap.put("success", "StudentUnionMemberList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "StudentUnionMemberForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='StudentUnionMemberAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
