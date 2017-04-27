<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page language="java" %>
<%--社团注册信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(Club_Regist.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ClubId", "ClubName", "ClubType", "ClubTimeSetup", "ClubAcademy", "ClubQQ", "ClubEmail", "ClubPubAccount", "RegistSponsor", "RegistTime", "Tenet", "MemberCount", "MemberUndergra", "MemberGra", "MenberLeague", "MenberParty", "MemberMale", "MemberFemale", "ClubManager", "ClubTea", "RegistSummary", "RegistPlan", "CommentAcademy", "CommentUnion", "CheckFlag", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "CheckXy", "CheckTw"};
private String[] DicKeys = {"Id", "ClubId", "ClubName", "ClubType", "ClubTimeSetup", "ClubAcademy", "ClubQQ", "ClubEmail", "ClubPubAccount", "RegistSponsor", "RegistTime", "Tenet", "MemberCount", "MemberUndergra", "MemberGra", "MenberLeague", "MenberParty", "MemberMale", "MemberFemale", "ClubManager", "ClubTea", "RegistSummary", "RegistPlan", "CommentAcademy", "CommentUnion", "CheckFlag", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "CheckXy", "CheckTw"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "登录账号", "45", "hidden", ""}, {"string", "社团名称", "45", "ClubName", ""}, {"string", "社团类别", "45", "ClubTypeName", ""}, {"string", "社团成立时间", "45", "text", ""}, {"string", "指导单位", "45", "AcademyName", ""}, {"string", "QQ", "45", "text", ""}, {"string", "邮箱", "45", "text", ""}, {"string", "公众号", "45", "text", ""}, {"string", "注册联系人", "45", "hidden", ""}, {"date", "本期注册时间", "0", "text", ""}, {"string", "社团宗旨", "45", "hidden", ""}, {"int", "现有人数", "0", "hidden", ""}, {"int", "本科人数", "0", "hidden", ""}, {"int", "本科生人数", "0", "hidden", ""}, {"int", "团员人数", "0", "hidden", ""}, {"int", "党员人数", "0", "hidden", ""}, {"int", "男生人数", "0", "hidden", ""}, {"int", "女生人数", "0", "hidden", ""}, {"string", "社团负责人情况", "500", "hidden", ""}, {"string", "社团指导教师情况", "500", "hidden", ""}, {"string", "上学期工作总结（要点）", "1000", "hidden", ""}, {"string", "本学期工作计划（要点）", "1000", "hidden", ""}, {"string", "学院审核意见", "500", "hidden", ""}, {"string", "学校审核意见", "500", "hidden", ""}, {"int", "审核状态", "0", "hidden", ""}, {"string", "添加人", "50", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "修改人", "50", "hidden", ""}, {"date", "修改时间", "0", "hidden", ""}, {"int", "学院审核人", "0", "hidden", ""}, {"int", "团委审核人", "0", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ClubId", "ClubName", "ClubType", "ClubTimeSetup", "ClubAcademy", "ClubQQ", "ClubEmail", "ClubPubAccount", "RegistSponsor", "RegistTime", "Tenet", "MemberCount", "MemberUndergra", "MemberGra", "MenberLeague", "MenberParty", "MemberMale", "MemberFemale", "ClubManager", "ClubTea", "RegistSummary", "RegistPlan", "CommentAcademy", "CommentUnion", "CheckFlag", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "CheckXy", "CheckTw"};
private String[] ListFields = {"ClubName", "ClubType", "ClubTimeSetup", "ClubAcademy", "ClubQQ", "ClubEmail", "ClubPubAccount", "RegistTime","CheckFlag"};
private String[] FormFields = {"ClubName", "ClubType", "ClubTimeSetup", "ClubAcademy", "ClubQQ", "ClubEmail", "ClubPubAccount", "RegistSponsor", "RegistTime", "Tenet", "MemberCount", "MemberUndergra", "MemberGra", "MenberLeague", "MenberParty", "MemberMale", "MemberFemale", "ClubManager", "ClubTea", "RegistSummary", "RegistPlan", "CommentAcademy", "CommentUnion", "CheckFlag", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "CheckXy", "CheckTw"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private Club_Regist getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Club_Regist v = new Club_Regist();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramClubId(request, "ClubId");
        v.paramClubName(request, "ClubName");
        v.paramClubType(request, "ClubType");
        v.paramClubTimeSetup(request, "ClubTimeSetup");
        v.paramClubAcademy(request, "ClubAcademy");
        v.paramClubQQ(request, "ClubQQ");
        v.paramClubEmail(request, "ClubEmail");
        v.paramClubPubAccount(request, "ClubPubAccount");
        v.paramRegistSponsor(request, "RegistSponsor");
        v.paramRegistTime(request, "RegistTime");
        v.paramTenet(request, "Tenet");
        v.paramMemberCount(request, "MemberCount");
        v.paramMemberUndergra(request, "MemberUndergra");
        v.paramMemberGra(request, "MemberGra");
        v.paramMenberLeague(request, "MenberLeague");
        v.paramMenberParty(request, "MenberParty");
        v.paramMemberMale(request, "MemberMale");
        v.paramMemberFemale(request, "MemberFemale");
        v.paramClubManager(request, "ClubManager");
        v.paramClubTea(request, "ClubTea");
        v.paramRegistSummary(request, "RegistSummary");
        v.paramRegistPlan(request, "RegistPlan");
        v.paramCommentAcademy(request, "CommentAcademy");
        v.paramCommentUnion(request, "CommentUnion");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramAddPerson(request, "AddPerson");
        v.paramAddTime(request, "AddTime");
        v.paramModiPerson(request, "ModiPerson");
        v.paramModiTime(request, "ModiTime");
        v.paramCheckXy(request, "CheckXy");
        v.paramCheckTw(request, "CheckTw");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setClubId(ParamUtils.getParameter(request, "ClubId", ""));
        v.setClubName(ParamUtils.getParameter(request, "ClubName", ""));
        v.setClubType(ParamUtils.getParameter(request, "ClubType", ""));
        v.setClubTimeSetup(ParamUtils.getParameter(request, "ClubTimeSetup", ""));
        v.setClubAcademy(ParamUtils.getParameter(request, "ClubAcademy", ""));
        v.setClubQQ(ParamUtils.getParameter(request, "ClubQQ", ""));
        v.setClubEmail(ParamUtils.getParameter(request, "ClubEmail", ""));
        v.setClubPubAccount(ParamUtils.getParameter(request, "ClubPubAccount", ""));
        v.setRegistSponsor(ParamUtils.getParameter(request, "RegistSponsor", ""));
        v.setRegistTime(ParamUtils.getDateTimeParameter(request, "RegistTime", java.sql.Date.valueOf("0001-01-01")));
        v.setTenet(ParamUtils.getParameter(request, "Tenet", ""));
        v.setMemberCount(ParamUtils.getIntParameter(request, "MemberCount", -1));
        v.setMemberUndergra(ParamUtils.getIntParameter(request, "MemberUndergra", -1));
        v.setMemberGra(ParamUtils.getIntParameter(request, "MemberGra", -1));
        v.setMenberLeague(ParamUtils.getIntParameter(request, "MenberLeague", -1));
        v.setMenberParty(ParamUtils.getIntParameter(request, "MenberParty", -1));
        v.setMemberMale(ParamUtils.getIntParameter(request, "MemberMale", -1));
        v.setMemberFemale(ParamUtils.getIntParameter(request, "MemberFemale", -1));
        v.setClubManager(ParamUtils.getParameter(request, "ClubManager", ""));
        v.setClubTea(ParamUtils.getParameter(request, "ClubTea", ""));
        v.setRegistSummary(ParamUtils.getParameter(request, "RegistSummary", ""));
        v.setRegistPlan(ParamUtils.getParameter(request, "RegistPlan", ""));
        v.setCommentAcademy(ParamUtils.getParameter(request, "CommentAcademy", ""));
        v.setCommentUnion(ParamUtils.getParameter(request, "CommentUnion", ""));
        v.setCheckFlag(ParamUtils.getIntParameter(request, "CheckFlag", -1));
        v.setAddPerson(ParamUtils.getParameter(request, "AddPerson", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setModiPerson(ParamUtils.getParameter(request, "ModiPerson", ""));
        v.setModiTime(ParamUtils.getDateTimeParameter(request, "ModiTime", java.sql.Date.valueOf("0001-01-01")));
        v.setCheckXy(ParamUtils.getIntParameter(request, "CheckXy", -1));
        v.setCheckTw(ParamUtils.getIntParameter(request, "CheckTw", -1));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Club_Regist pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map ClubTypeNamemap = CEditConst.getClubTypeNameMap(userInfo);
    Map ClubNamemap = CEditConst.getClubNameMap(userInfo);
    ClubUtil util = new ClubUtil();
    Map CheckFlagMap = util.getCheckFlagMap();
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Club_Regist v = (Club_Regist)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getClubId()));
        row.add((String)ClubNamemap.get("" + v.getClubName()));
        row.add((String)ClubTypeNamemap.get("" + v.getClubType()));
        row.add(Tool.jsSpecialChars(v.getClubTimeSetup()));
        row.add((String)AcademyNamemap.get("" + v.getClubAcademy()));
        row.add(Tool.jsSpecialChars(v.getClubQQ()));
        row.add(Tool.jsSpecialChars(v.getClubEmail()));
        row.add(Tool.jsSpecialChars(v.getClubPubAccount()));
        row.add(Tool.jsSpecialChars(v.getRegistSponsor()));
        row.add(Tool.stringOfDate(v.getRegistTime()));
        row.add(Tool.jsSpecialChars(v.getTenet()));
        row.add("" + v.getMemberCount());
        row.add("" + v.getMemberUndergra());
        row.add("" + v.getMemberGra());
        row.add("" + v.getMenberLeague());
        row.add("" + v.getMenberParty());
        row.add("" + v.getMemberMale());
        row.add("" + v.getMemberFemale());
        row.add(Tool.jsSpecialChars(v.getClubManager()));
        row.add(Tool.jsSpecialChars(v.getClubTea()));
        row.add(Tool.jsSpecialChars(v.getRegistSummary()));
        row.add(Tool.jsSpecialChars(v.getRegistPlan()));
        row.add(Tool.jsSpecialChars(v.getCommentAcademy()));
        row.add(Tool.jsSpecialChars(v.getCommentUnion()));
        row.add((String)CheckFlagMap.get("" + v.getCheckFlag()));
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getModiPerson()));
        row.add(Tool.stringOfDate(v.getModiTime()));
        row.add("" + v.getCheckXy());
        row.add("" + v.getCheckTw());
        rows.add(row);
    }
    CheckFlagMap.clear();
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Club_Regist pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Club_Regist pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    if(userInfo.hasFunPower(Power.STUSER)){//社团用户
    	cdt.add("ClubId='"+userInfo.getUserCode().getName()+"'");
    }
    if(userInfo.hasFunPower(Power.UserAdminPower)) {
    	List cdt1 = new ArrayList();
    	//cdt.add("clubAcademy="+userInfo.getDeptId());
    	cdt.add("ClubId in( select clubid from club where academy="+userInfo.getUserCode().getDeptId()+")");
    	cdt.add("checkflag!=-1");
    }
    if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)) {
    	cdt.add("checkflag!=-1");
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
    Club_Regist pv = new Club_Regist();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Club_Regist");
    request.setAttribute("describe", "社团注册信息");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Club_Regist pv = new Club_Regist();
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
private void setForm(javax.servlet.http.HttpServletRequest request, Club_Regist form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    //request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("ClubTypeNameoptions", CEditConst.getClubTypeNameOptions(userInfo, ""));
    request.setAttribute("ClubNameoptions", CEditConst.getClubNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Club_Regist");
    request.setAttribute("describe", "社团注册信息");
}
private List mkRtn(String cmd, String forward, Club_Regist form)
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
    Club_Regist form = getByParameterDb(request);
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
    	form.setRegistTime(new Date());
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
log.debug("Club_RegistAction");
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
forwardMap.put("list", "Club_RegistAction.jsp");
forwardMap.put("failure", "Club_RegistForm.jsp");
forwardMap.put("success", "Club_RegistList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "Club_RegistForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='Club_RegistAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
