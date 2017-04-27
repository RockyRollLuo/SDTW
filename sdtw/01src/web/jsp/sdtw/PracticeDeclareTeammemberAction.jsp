<%@ page language="java" %>
<%--参加社会实践团成员表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(PracticeDeclareTeammember.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "PracticeId", "ReportId", "TeamId", "Sno", "SName", "Sex", "Academy", "Grade", "IdCard", "Address", "Phone", "Email", "Duty", "Type2", "Identity", "Remark", "Remark2", "Remark3", "Remark4", "Honor"};
private String[] DicKeys = {"Id", "PracticeId", "ReportId", "TeamId", "Sno", "SName", "Sex", "Academy", "Grade", "IdCard", "Address", "Phone", "Email", "Duty", "Type2", "Identity", "Remark", "Remark2", "Remark3", "Remark4", "Honor"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "立项表ID", "45", "text", ""}, {"string", "结题表Id", "45", "text", ""}, {"int", "团队id", "0", "text", ""}, {"string", "学号", "45", "text", ""}, {"string", "姓名", "45", "text", ""}, {"string", "性别", "45", "text", ""}, {"string", "院系", "45", "AcademyName", ""}, {"string", "年级", "45", "GradeName", ""}, {"string", "身份证", "45", "text", ""}, {"string", "家庭住址", "45", "text", ""}, {"string", "联系方式", "45", "text", ""}, {"string", "邮箱", "45", "text", ""}, {"string", "承担工作", "45", "text", ""}, {"int", "类别", "0", "text", ""}, {"string", "学历", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "荣誉", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "PracticeId", "ReportId", "TeamId", "Sno", "SName", "Sex", "Academy", "Grade", "IdCard", "Address", "Phone", "Email", "Duty", "Type2", "Identity", "Remark", "Remark2", "Remark3", "Remark4", "Honor"};
private String[] ListFields = {"PracticeId", "ReportId", "TeamId", "Sno", "SName", "Sex", "Academy", "Grade", "IdCard", "Address", "Phone", "Email", "Duty", "Type2", "Identity", "Remark", "Remark2", "Remark3", "Remark4", "Honor"};
private String[] FormFields = {"PracticeId", "ReportId", "TeamId", "Sno", "SName", "Sex", "Academy", "Grade", "IdCard", "Address", "Phone", "Email", "Duty", "Type2", "Identity", "Remark", "Remark2", "Remark3", "Remark4", "Honor"};
private String[] QueryFields = {"Sno", "SName"};
private String[] HideFields = {"Id"};
private PracticeDeclareTeammember getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    PracticeDeclareTeammember v = new PracticeDeclareTeammember();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramPracticeId(request, "PracticeId");
        v.paramReportId(request, "ReportId");
        v.paramTeamId(request, "TeamId");
        v.paramSno(request, "Sno");
        v.paramSName(request, "SName");
        v.paramSex(request, "Sex");
        v.paramAcademy(request, "Academy");
        v.paramGrade(request, "Grade");
        v.paramIdCard(request, "IdCard");
        v.paramAddress(request, "Address");
        v.paramPhone(request, "Phone");
        v.paramEmail(request, "Email");
        v.paramDuty(request, "Duty");
        v.paramType2(request, "Type2");
        v.paramIdentity(request, "Identity");
        v.paramRemark(request, "Remark");
        v.paramRemark2(request, "Remark2");
        v.paramRemark3(request, "Remark3");
        v.paramRemark4(request, "Remark4");
        v.paramHonor(request, "Honor");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setPracticeId(ParamUtils.getParameter(request, "PracticeId", ""));
        v.setReportId(ParamUtils.getParameter(request, "ReportId", ""));
        v.setTeamId(ParamUtils.getIntParameter(request, "TeamId", -1));
        v.setSno(ParamUtils.getParameter(request, "Sno", ""));
        v.setSName(ParamUtils.getParameter(request, "SName", ""));
        v.setSex(ParamUtils.getParameter(request, "Sex", ""));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setGrade(ParamUtils.getParameter(request, "Grade", ""));
        v.setIdCard(ParamUtils.getParameter(request, "IdCard", ""));
        v.setAddress(ParamUtils.getParameter(request, "Address", ""));
        v.setPhone(ParamUtils.getParameter(request, "Phone", ""));
        v.setEmail(ParamUtils.getParameter(request, "Email", ""));
        v.setDuty(ParamUtils.getParameter(request, "Duty", ""));
        v.setType2(ParamUtils.getIntParameter(request, "Type2", -1));
        v.setIdentity(ParamUtils.getParameter(request, "Identity", ""));
        v.setRemark(ParamUtils.getParameter(request, "Remark", ""));
        v.setRemark2(ParamUtils.getParameter(request, "Remark2", ""));
        v.setRemark3(ParamUtils.getParameter(request, "Remark3", ""));
        v.setRemark4(ParamUtils.getParameter(request, "Remark4", ""));
        v.setHonor(ParamUtils.getParameter(request, "Honor", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, PracticeDeclareTeammember pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map GradeNamemap = CEditConst.getGradeNameMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        PracticeDeclareTeammember v = (PracticeDeclareTeammember)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getPracticeId()));
        row.add(Tool.jsSpecialChars(v.getReportId()));
        row.add("" + v.getTeamId());
        row.add(Tool.jsSpecialChars(v.getSno()));
        row.add(Tool.jsSpecialChars(v.getSName()));
        row.add(Tool.jsSpecialChars(v.getSex()));
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add((String)GradeNamemap.get("" + v.getGrade()));
        row.add(Tool.jsSpecialChars(v.getIdCard()));
        row.add(Tool.jsSpecialChars(v.getAddress()));
        row.add(Tool.jsSpecialChars(v.getPhone()));
        row.add(Tool.jsSpecialChars(v.getEmail()));
        row.add(Tool.jsSpecialChars(v.getDuty()));
        row.add("" + v.getType2());
        row.add(Tool.jsSpecialChars(v.getIdentity()));
        row.add(Tool.jsSpecialChars(v.getRemark()));
        row.add(Tool.jsSpecialChars(v.getRemark2()));
        row.add(Tool.jsSpecialChars(v.getRemark3()));
        row.add(Tool.jsSpecialChars(v.getRemark4()));
        row.add(Tool.jsSpecialChars(v.getHonor()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, PracticeDeclareTeammember pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, PracticeDeclareTeammember pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_Sno_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("sno like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_SName_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("sname like '%" + qval + "%'");
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
    PracticeDeclareTeammember pv = new PracticeDeclareTeammember();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "PracticeDeclareTeammember");
    request.setAttribute("describe", "参加社会实践团成员表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    PracticeDeclareTeammember pv = new PracticeDeclareTeammember();
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
private void setForm(javax.servlet.http.HttpServletRequest request, PracticeDeclareTeammember form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("GradeNameoptions", CEditConst.getGradeNameOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "PracticeDeclareTeammember");
    request.setAttribute("describe", "参加社会实践团成员表");
}
private List mkRtn(String cmd, String forward, PracticeDeclareTeammember form)
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
    PracticeDeclareTeammember form = getByParameterDb(request);
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
log.debug("PracticeDeclareTeammemberAction");
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
forwardMap.put("list", "PracticeDeclareTeammemberAction.jsp");
forwardMap.put("failure", "PracticeDeclareTeammemberForm.jsp");
forwardMap.put("success", "PracticeDeclareTeammemberList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "PracticeDeclareTeammemberForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='PracticeDeclareTeammemberAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
