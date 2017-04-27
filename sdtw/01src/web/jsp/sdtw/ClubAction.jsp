<%@ page language="java" %>
<%--学生社团基本信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(Club.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ClubName", "ClubCode", "ClubId", "ClubType", "Tenet", "ClubProfile", "Academy", "Teacher", "Chairman", "Sponsor", "Feasibility", "CommentTea", "CommentAcademy", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "ApplyRecruitment", "ManagerFlag", "TeaFlag", "CheckFlag", "Commenttw", "Clubqq", "ClubeMail", "ClubPubAccount", "ClubTimeSetup", "ClubTimeCheck", "AddPersonName", "TeacherModifyFlag", "AddFileList", "RecruitmentStart", "RecruitmentStop", "RecruitmentCheckflag", "Iscancle", "CancleReason", "CancleCheckFlag", "CancleCommentXy", "CancleCommentTw", "City"};
private String[] DicKeys = {"Id", "ClubName", "ClubCode", "ClubId", "ClubType", "Tenet", "ClubProfile", "Academy", "Teacher", "Chairman", "Sponsor", "Feasibility", "CommentTea", "CommentAcademy", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "ApplyRecruitment", "ManagerFlag", "TeaFlag", "CheckFlag", "Commenttw", "Clubqq", "ClubeMail", "ClubPubAccount", "ClubTimeSetup", "ClubTimeCheck", "AddPersonName", "TeacherModifyFlag", "AddFileList", "RecruitmentStart", "RecruitmentStop", "RecruitmentCheckflag", "Iscancle", "CancleReason", "CancleCheckFlag", "CancleCommentXy", "CancleCommentTw", "City"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "社团名称", "45", "text", ""}, {"string", "社团编码", "45", "text", ""}, {"string", "登录账号", "20", "text", ""}, {"string", "社团类别", "20", "ClubTypeName", ""}, {"string", "宗旨", "100", "hidden", ""}, {"string", "简介", "2000", "hidden", ""}, {"string", "学院", "45", "AcademyName", ""}, {"string", "教师", "45", "UserName", ""}, {"string", "拟负责人", "45", "hidden", ""}, {"string", "发起人情况", "2000", "hidden", ""}, {"string", "成立原因", "2000", "hidden", ""}, {"string", "指导教师意见", "500", "hidden", ""}, {"string", "学院审核意见", "500", "hidden", ""}, {"string", "添加人", "45", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "修改人", "45", "hidden", ""}, {"date", "修改时间", "0", "hidden", ""}, {"int", "申请纳新", "0", "text", ""}, {"int", "是否添加负责人", "0", "hidden", ""}, {"int", "是否添加指导教师", "0", "hidden", ""}, {"string", "审核", "20", "text", ""}, {"string", "团委审核意见", "500", "hidden", ""}, {"string", "联系方式QQ", "45", "hidden", ""}, {"string", "邮箱", "45", "hidden", ""}, {"string", "公众号", "45", "hidden", ""}, {"string", "成立时间", "45", "hidden", ""}, {"date", "批准时间", "0", "hidden", ""}, {"string", "添加人姓名", "50", "hidden", ""}, {"int", "指导教师是否更换", "0", "text", ""}, {"string", "附件", "2000", "hidden", ""}, {"date", "社团招新开始日期", "0", "hidden", ""}, {"date", "社团招新结束日期", "0", "hidden", ""}, {"int", "社团是否招新标志", "0", "hidden", ""}, {"int", "是否注销", "0", "hidden", ""}, {"string", "注销原因", "500", "hidden", ""}, {"int", "注销状态", "0", "hidden", ""}, {"string", "注销原因学院", "500", "hidden", ""}, {"string", "注销原因团委", "45", "hidden", ""}, {"string", "城市", "50", "OrgCityName", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ClubName", "ClubCode", "ClubId", "ClubType", "Tenet", "ClubProfile", "Academy", "Teacher", "Chairman", "Sponsor", "Feasibility", "CommentTea", "CommentAcademy", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "ApplyRecruitment", "ManagerFlag", "TeaFlag", "CheckFlag", "Commenttw", "Clubqq", "ClubeMail", "ClubPubAccount", "ClubTimeSetup", "ClubTimeCheck", "AddPersonName", "TeacherModifyFlag", "AddFileList", "RecruitmentStart", "RecruitmentStop", "RecruitmentCheckflag", "Iscancle", "CancleReason", "CancleCheckFlag", "CancleCommentXy", "CancleCommentTw", "City"};
private String[] ListFields = {"ClubName", "ClubCode", "ClubId", "ClubType", "Academy", "Teacher", "ApplyRecruitment", "CheckFlag", "TeacherModifyFlag", "City"};
private String[] FormFields = {"ClubName", "ClubCode", "ClubId", "ClubType", "Tenet", "ClubProfile", "Academy", "Teacher", "Chairman", "Sponsor", "Feasibility", "CommentTea", "CommentAcademy", "ApplyRecruitment", "ManagerFlag", "TeaFlag", "CheckFlag", "Commenttw", "Clubqq", "ClubeMail", "ClubPubAccount", "AddPersonName", "TeacherModifyFlag", "CancleReason", "CancleCheckFlag", "CancleCommentXy", "CancleCommentTw", "City"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private Club getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Club v = new Club();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramClubName(request, "ClubName");
        v.paramClubCode(request, "ClubCode");
        v.paramClubId(request, "ClubId");
        v.paramClubType(request, "ClubType");
        v.paramTenet(request, "Tenet");
        v.paramClubProfile(request, "ClubProfile");
        v.paramAcademy(request, "Academy");
        v.paramTeacher(request, "Teacher");
        v.paramChairman(request, "Chairman");
        v.paramSponsor(request, "Sponsor");
        v.paramFeasibility(request, "Feasibility");
        v.paramCommentTea(request, "CommentTea");
        v.paramCommentAcademy(request, "CommentAcademy");
        v.paramAddPerson(request, "AddPerson");
        v.paramAddTime(request, "AddTime");
        v.paramModiPerson(request, "ModiPerson");
        v.paramModiTime(request, "ModiTime");
        v.paramApplyRecruitment(request, "ApplyRecruitment");
        v.paramManagerFlag(request, "ManagerFlag");
        v.paramTeaFlag(request, "TeaFlag");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramCommenttw(request, "Commenttw");
        v.paramClubqq(request, "Clubqq");
        v.paramClubeMail(request, "ClubeMail");
        v.paramClubPubAccount(request, "ClubPubAccount");
        v.paramClubTimeSetup(request, "ClubTimeSetup");
        v.paramClubTimeCheck(request, "ClubTimeCheck");
        v.paramAddPersonName(request, "AddPersonName");
        v.paramTeacherModifyFlag(request, "TeacherModifyFlag");
        v.paramAddFileList(request, "AddFileList");
        v.paramRecruitmentStart(request, "RecruitmentStart");
        v.paramRecruitmentStop(request, "RecruitmentStop");
        v.paramRecruitmentCheckflag(request, "RecruitmentCheckflag");
        v.paramIscancle(request, "Iscancle");
        v.paramCancleReason(request, "CancleReason");
        v.paramCancleCheckFlag(request, "CancleCheckFlag");
        v.paramCancleCommentXy(request, "CancleCommentXy");
        v.paramCancleCommentTw(request, "CancleCommentTw");
        v.paramCity(request, "City");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setClubName(ParamUtils.getParameter(request, "ClubName", ""));
        v.setClubCode(ParamUtils.getParameter(request, "ClubCode", ""));
        v.setClubId(ParamUtils.getParameter(request, "ClubId", ""));
        v.setClubType(ParamUtils.getParameter(request, "ClubType", ""));
        v.setTenet(ParamUtils.getParameter(request, "Tenet", ""));
        v.setClubProfile(ParamUtils.getParameter(request, "ClubProfile", ""));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setTeacher(ParamUtils.getParameter(request, "Teacher", ""));
        v.setChairman(ParamUtils.getParameter(request, "Chairman", ""));
        v.setSponsor(ParamUtils.getParameter(request, "Sponsor", ""));
        v.setFeasibility(ParamUtils.getParameter(request, "Feasibility", ""));
        v.setCommentTea(ParamUtils.getParameter(request, "CommentTea", ""));
        v.setCommentAcademy(ParamUtils.getParameter(request, "CommentAcademy", ""));
        v.setAddPerson(ParamUtils.getParameter(request, "AddPerson", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setModiPerson(ParamUtils.getParameter(request, "ModiPerson", ""));
        v.setModiTime(ParamUtils.getDateTimeParameter(request, "ModiTime", java.sql.Date.valueOf("0001-01-01")));
        v.setApplyRecruitment(ParamUtils.getIntParameter(request, "ApplyRecruitment", -1));
        v.setManagerFlag(ParamUtils.getIntParameter(request, "ManagerFlag", 0));
        v.setTeaFlag(ParamUtils.getIntParameter(request, "TeaFlag", 0));
        v.setCheckFlag(ParamUtils.getParameter(request, "CheckFlag", ""));
        v.setCommenttw(ParamUtils.getParameter(request, "Commenttw", ""));
        v.setClubqq(ParamUtils.getParameter(request, "Clubqq", ""));
        v.setClubeMail(ParamUtils.getParameter(request, "ClubeMail", ""));
        v.setClubPubAccount(ParamUtils.getParameter(request, "ClubPubAccount", ""));
        v.setClubTimeSetup(ParamUtils.getParameter(request, "ClubTimeSetup", ""));
        v.setClubTimeCheck(ParamUtils.getDateTimeParameter(request, "ClubTimeCheck", java.sql.Date.valueOf("0001-01-01")));
        v.setAddPersonName(ParamUtils.getParameter(request, "AddPersonName", ""));
        v.setTeacherModifyFlag(ParamUtils.getIntParameter(request, "TeacherModifyFlag", -1));
        v.setAddFileList(ParamUtils.getParameter(request, "AddFileList", ""));
        v.setRecruitmentStart(ParamUtils.getDateTimeParameter(request, "RecruitmentStart", java.sql.Date.valueOf("0001-01-01")));
        v.setRecruitmentStop(ParamUtils.getDateTimeParameter(request, "RecruitmentStop", java.sql.Date.valueOf("0001-01-01")));
        v.setRecruitmentCheckflag(ParamUtils.getIntParameter(request, "RecruitmentCheckflag", -1));
        v.setIscancle(ParamUtils.getIntParameter(request, "Iscancle", 0));
        v.setCancleReason(ParamUtils.getParameter(request, "CancleReason", ""));
        v.setCancleCheckFlag(ParamUtils.getIntParameter(request, "CancleCheckFlag", -1));
        v.setCancleCommentXy(ParamUtils.getParameter(request, "CancleCommentXy", ""));
        v.setCancleCommentTw(ParamUtils.getParameter(request, "CancleCommentTw", ""));
        v.setCity(ParamUtils.getParameter(request, "City", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Club pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map OrgCityNamemap = CEditConst.getOrgCityNameMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map ClubTypeNamemap = CEditConst.getClubTypeNameMap(userInfo);
    Map UserNamemap = CEditConst.getUserNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Club v = (Club)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getClubName()));
        row.add(Tool.jsSpecialChars(v.getClubCode()));
        row.add(Tool.jsSpecialChars(v.getClubId()));
        row.add((String)ClubTypeNamemap.get("" + v.getClubType()));
        row.add(Tool.jsSpecialChars(v.getTenet()));
        row.add(Tool.jsSpecialChars(v.getClubProfile()));
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add((String)UserNamemap.get("" + v.getTeacher()));
        row.add(Tool.jsSpecialChars(v.getChairman()));
        row.add(Tool.jsSpecialChars(v.getSponsor()));
        row.add(Tool.jsSpecialChars(v.getFeasibility()));
        row.add(Tool.jsSpecialChars(v.getCommentTea()));
        row.add(Tool.jsSpecialChars(v.getCommentAcademy()));
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getModiPerson()));
        row.add(Tool.stringOfDate(v.getModiTime()));
        row.add("" + v.getApplyRecruitment());
        row.add("" + v.getManagerFlag());
        row.add("" + v.getTeaFlag());
        row.add(Tool.jsSpecialChars(v.getCheckFlag()));
        row.add(Tool.jsSpecialChars(v.getCommenttw()));
        row.add(Tool.jsSpecialChars(v.getClubqq()));
        row.add(Tool.jsSpecialChars(v.getClubeMail()));
        row.add(Tool.jsSpecialChars(v.getClubPubAccount()));
        row.add(Tool.jsSpecialChars(v.getClubTimeSetup()));
        row.add(Tool.stringOfDate(v.getClubTimeCheck()));
        row.add(Tool.jsSpecialChars(v.getAddPersonName()));
        row.add("" + v.getTeacherModifyFlag());
        row.add(Tool.jsSpecialChars(v.getAddFileList()));
        row.add(Tool.stringOfDate(v.getRecruitmentStart()));
        row.add(Tool.stringOfDate(v.getRecruitmentStop()));
        row.add("" + v.getRecruitmentCheckflag());
        row.add("" + v.getIscancle());
        row.add(Tool.jsSpecialChars(v.getCancleReason()));
        row.add("" + v.getCancleCheckFlag());
        row.add(Tool.jsSpecialChars(v.getCancleCommentXy()));
        row.add(Tool.jsSpecialChars(v.getCancleCommentTw()));
        row.add((String)OrgCityNamemap.get("" + v.getCity()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Club pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Club pv, boolean isAll)
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
    Club pv = new Club();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Club");
    request.setAttribute("describe", "学生社团基本信息");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Club pv = new Club();
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
private void setForm(javax.servlet.http.HttpServletRequest request, Club form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, ""));
    request.setAttribute("CancleCheckFlagoptions", CEditConst.getCancleCheckFlagOptions(userInfo, "-1"));
    request.setAttribute("OrgCityNameoptions", CEditConst.getOrgCityNameOptions(userInfo, ""));
    request.setAttribute("ClubTypeNameoptions", CEditConst.getClubTypeNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Club");
    request.setAttribute("describe", "学生社团基本信息");
}
private List mkRtn(String cmd, String forward, Club form)
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
    Club form = getByParameterDb(request);
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
log.debug("ClubAction");
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
forwardMap.put("list", "ClubAction.jsp");
forwardMap.put("failure", "ClubForm.jsp");
forwardMap.put("success", "ClubList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "ClubForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='ClubAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
