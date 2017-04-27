<%@ page language="java" %>
<%--社团指导教师--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(ClubTeacher.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ClubName", "ClubCode", "TeaName", "TeaSex", "TeaAge", "TeaNation", "TeaPolitics", "TeaBirthplace", "TeaDuty", "TeaAcademy", "TeaTel", "TeaPhone", "TeaEmail", "TeaAcademic", "CommentAcatw", "CommentClubunion", "CommentTw", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "StartDate", "StopDate", "Generation", "ApplyDate", "CheckFlag", "CommentXy"};
private String[] DicKeys = {"Id", "ClubName", "ClubCode", "TeaName", "TeaSex", "TeaAge", "TeaNation", "TeaPolitics", "TeaBirthplace", "TeaDuty", "TeaAcademy", "TeaTel", "TeaPhone", "TeaEmail", "TeaAcademic", "CommentAcatw", "CommentClubunion", "CommentTw", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "StartDate", "StopDate", "Generation", "ApplyDate", "CheckFlag", "CommentXy"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "社团名称", "45", "ClubName", ""}, {"string", "社团code", "45", "text", ""}, {"string", "姓名", "45", "text", ""}, {"string", "性别", "45", "sex", ""}, {"string", "年龄", "45", "text", ""}, {"string", "民族", "45", "NationName", ""}, {"string", "政治面貌", "45", "PoliticsName", ""}, {"string", "籍贯", "45", "text", ""}, {"string", "职位", "45", "text", ""}, {"string", "所在学院（部门", "45", "AcademyName", ""}, {"string", "联系方式", "45", "text", ""}, {"string", "手机", "45", "text", ""}, {"string", "邮箱", "45", "text", ""}, {"string", "个人情况简介", "500", "hidden", ""}, {"string", "commentAcatw", "500", "hidden", ""}, {"string", "commentClubunion", "500", "hidden", ""}, {"string", "团委评价", "500", "hidden", ""}, {"string", "添加人", "50", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "修改人", "50", "hidden", ""}, {"date", "修改时间", "0", "hidden", ""}, {"date", "开始时间", "0", "text", ""}, {"date", "结束时间", "0", "text", ""}, {"int", "元老", "0", "text", ""}, {"date", "提交申请日期", "0", "hidden", ""}, {"int", "是否可用", "0", "hidden", ""}, {"string", "学院意见", "45", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ClubName", "ClubCode", "TeaName", "TeaSex", "TeaAge", "TeaNation", "TeaPolitics", "TeaBirthplace", "TeaDuty", "TeaAcademy", "TeaTel", "TeaPhone", "TeaEmail", "TeaAcademic", "CommentAcatw", "CommentClubunion", "CommentTw", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "StartDate", "StopDate", "Generation", "ApplyDate", "CheckFlag", "CommentXy"};
private String[] ListFields = {"ClubName", "ClubCode", "TeaName", "TeaSex", "TeaAge", "TeaNation", "TeaPolitics", "TeaBirthplace", "TeaDuty", "TeaAcademy", "TeaTel", "TeaPhone", "TeaEmail", "StartDate", "StopDate", "Generation"};
private String[] FormFields = {"ClubName", "ClubCode", "TeaName", "TeaSex", "TeaAge", "TeaNation", "TeaPolitics", "TeaBirthplace", "TeaDuty", "TeaAcademy", "TeaTel", "TeaPhone", "TeaEmail", "TeaAcademic", "CommentAcatw", "CommentClubunion", "CommentTw", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "StartDate", "StopDate", "Generation", "ApplyDate", "CheckFlag", "CommentXy"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private ClubTeacher getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubTeacher v = new ClubTeacher();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramClubName(request, "ClubName");
        v.paramClubCode(request, "ClubCode");
        v.paramTeaName(request, "TeaName");
        v.paramTeaSex(request, "TeaSex");
        v.paramTeaAge(request, "TeaAge");
        v.paramTeaNation(request, "TeaNation");
        v.paramTeaPolitics(request, "TeaPolitics");
        v.paramTeaBirthplace(request, "TeaBirthplace");
        v.paramTeaDuty(request, "TeaDuty");
        v.paramTeaAcademy(request, "TeaAcademy");
        v.paramTeaTel(request, "TeaTel");
        v.paramTeaPhone(request, "TeaPhone");
        v.paramTeaEmail(request, "TeaEmail");
        v.paramTeaAcademic(request, "TeaAcademic");
        v.paramCommentAcatw(request, "CommentAcatw");
        v.paramCommentClubunion(request, "CommentClubunion");
        v.paramCommentTw(request, "CommentTw");
        v.paramAddPerson(request, "AddPerson");
        v.paramAddTime(request, "AddTime");
        v.paramModiPerson(request, "ModiPerson");
        v.paramModiTime(request, "ModiTime");
        v.paramStartDate(request, "StartDate");
        v.paramStopDate(request, "StopDate");
        v.paramGeneration(request, "Generation");
        v.paramApplyDate(request, "ApplyDate");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramCommentXy(request, "CommentXy");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setClubName(ParamUtils.getParameter(request, "ClubName", ""));
        v.setClubCode(ParamUtils.getParameter(request, "ClubCode", ""));
        v.setTeaName(ParamUtils.getParameter(request, "TeaName", ""));
        v.setTeaSex(ParamUtils.getParameter(request, "TeaSex", ""));
        v.setTeaAge(ParamUtils.getParameter(request, "TeaAge", ""));
        v.setTeaNation(ParamUtils.getParameter(request, "TeaNation", ""));
        v.setTeaPolitics(ParamUtils.getParameter(request, "TeaPolitics", ""));
        v.setTeaBirthplace(ParamUtils.getParameter(request, "TeaBirthplace", ""));
        v.setTeaDuty(ParamUtils.getParameter(request, "TeaDuty", ""));
        v.setTeaAcademy(ParamUtils.getParameter(request, "TeaAcademy", ""));
        v.setTeaTel(ParamUtils.getParameter(request, "TeaTel", ""));
        v.setTeaPhone(ParamUtils.getParameter(request, "TeaPhone", ""));
        v.setTeaEmail(ParamUtils.getParameter(request, "TeaEmail", ""));
        v.setTeaAcademic(ParamUtils.getParameter(request, "TeaAcademic", ""));
        v.setCommentAcatw(ParamUtils.getParameter(request, "CommentAcatw", ""));
        v.setCommentClubunion(ParamUtils.getParameter(request, "CommentClubunion", ""));
        v.setCommentTw(ParamUtils.getParameter(request, "CommentTw", ""));
        v.setAddPerson(ParamUtils.getParameter(request, "AddPerson", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setModiPerson(ParamUtils.getParameter(request, "ModiPerson", ""));
        v.setModiTime(ParamUtils.getDateTimeParameter(request, "ModiTime", java.sql.Date.valueOf("0001-01-01")));
        v.setStartDate(ParamUtils.getDateTimeParameter(request, "StartDate", java.sql.Date.valueOf("0001-01-01")));
        v.setStopDate(ParamUtils.getDateTimeParameter(request, "StopDate", java.sql.Date.valueOf("0001-01-01")));
        v.setGeneration(ParamUtils.getIntParameter(request, "Generation", -1));
        v.setApplyDate(ParamUtils.getDateTimeParameter(request, "ApplyDate", java.sql.Date.valueOf("0001-01-01")));
        v.setCheckFlag(ParamUtils.getIntParameter(request, "CheckFlag", -1));
        v.setCommentXy(ParamUtils.getParameter(request, "CommentXy", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, ClubTeacher pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map NationNamemap = CEditConst.getNationNameMap(userInfo);
    Map sexmap = CEditConst.getsexMap(userInfo);
    Map PoliticsNamemap = CEditConst.getPoliticsNameMap(userInfo);
    Map ClubNamemap = CEditConst.getClubNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        ClubTeacher v = (ClubTeacher)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add((String)ClubNamemap.get("" + v.getClubName()));
        row.add(Tool.jsSpecialChars(v.getClubCode()));
        row.add(Tool.jsSpecialChars(v.getTeaName()));
        row.add((String)sexmap.get("" + v.getTeaSex()));
        row.add(Tool.jsSpecialChars(v.getTeaAge()));
        row.add((String)NationNamemap.get("" + v.getTeaNation()));
        row.add((String)PoliticsNamemap.get("" + v.getTeaPolitics()));
        row.add(Tool.jsSpecialChars(v.getTeaBirthplace()));
        row.add(Tool.jsSpecialChars(v.getTeaDuty()));
        row.add((String)AcademyNamemap.get("" + v.getTeaAcademy()));
        row.add(Tool.jsSpecialChars(v.getTeaTel()));
        row.add(Tool.jsSpecialChars(v.getTeaPhone()));
        row.add(Tool.jsSpecialChars(v.getTeaEmail()));
        row.add(Tool.jsSpecialChars(v.getTeaAcademic()));
        row.add(Tool.jsSpecialChars(v.getCommentAcatw()));
        row.add(Tool.jsSpecialChars(v.getCommentClubunion()));
        row.add(Tool.jsSpecialChars(v.getCommentTw()));
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getModiPerson()));
        row.add(Tool.stringOfDate(v.getModiTime()));
        row.add(Tool.stringOfDate(v.getStartDate()));
        row.add(Tool.stringOfDate(v.getStopDate()));
        row.add("" + v.getGeneration());
        row.add(Tool.stringOfDate(v.getApplyDate()));
        row.add("" + v.getCheckFlag());
        row.add(Tool.jsSpecialChars(v.getCommentXy()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, ClubTeacher pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, ClubTeacher pv, boolean isAll)
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
    ClubTeacher pv = new ClubTeacher();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "ClubTeacher");
    request.setAttribute("describe", "社团指导教师");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubTeacher pv = new ClubTeacher();
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
private void setForm(javax.servlet.http.HttpServletRequest request, ClubTeacher form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("PoliticsNameoptions", CEditConst.getPoliticsNameOptions(userInfo, ""));
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, ""));
    request.setAttribute("NationNameoptions", CEditConst.getNationNameOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("sexoptions", CEditConst.getsexOptions(userInfo, ""));
    request.setAttribute("ClubNameoptions", CEditConst.getClubNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "ClubTeacher");
    request.setAttribute("describe", "社团指导教师");
}
private List mkRtn(String cmd, String forward, ClubTeacher form)
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
    ClubTeacher form = getByParameterDb(request);
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
log.debug("ClubTeacherAction");
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
forwardMap.put("list", "ClubTeacherAction.jsp");
forwardMap.put("failure", "ClubTeacherForm.jsp");
forwardMap.put("success", "ClubTeacherList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "ClubTeacherForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='ClubTeacherAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
