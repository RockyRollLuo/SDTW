<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page language="java" %>
<%--社团变更指导单位--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(ClubModify.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ClubId", "ClubName", "ClubType", "ClubAcademy", "ClubAcadeMyNew", "ModifyType", "ModifyReason", "CommentXy", "CommentXyNew", "CommentTw", "CheckFlag", "ApplyDate", "AddPerson", "AddTime", "ModiPerson", "ModiTime"};
private String[] DicKeys = {"Id", "ClubId", "ClubName", "ClubType", "ClubAcademy", "ClubAcadeMyNew", "ModifyType", "ModifyReason", "CommentXy", "CommentXyNew", "CommentTw", "CheckFlag", "ApplyDate", "AddPerson", "AddTime", "ModiPerson", "ModiTime"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "登录账号", "45", "hidden", ""}, {"string", "社团名称", "45", "hidden", ""}, {"string", "社团类别", "45", "ClubTypeName", ""}, {"string", "原指导单位", "45", "AcademyName", ""}, {"string", "新指导单位", "45", "AcademyName", ""}, {"string", "变更类别", "45", "hidden", ""}, {"string", "变更原因", "45", "hidden", ""}, {"string", "原指导单位意见", "500", "hidden", ""}, {"string", "新指导单位意见", "500", "hidden", ""}, {"string", "团委审核意见", "500", "hidden", ""}, {"string", "审核状态", "45", "hidden", ""}, {"date", "申请时间", "0", "hidden", ""}, {"string", "申请人", "50", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "修改人", "50", "hidden", ""}, {"date", "修改时间", "0", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ClubId", "ClubName", "ClubType", "ClubAcademy", "ClubAcadeMyNew", "ModifyType", "ModifyReason", "CommentXy", "CommentXyNew", "CommentTw", "CheckFlag", "ApplyDate", "AddPerson", "AddTime", "ModiPerson", "ModiTime"};
private String[] ListFields = {"ClubId", "ClubName","ClubType", "ClubAcademy", "ClubAcadeMyNew", "CheckFlag"};
private String[] FormFields = {"ClubName", "ClubType", "ClubAcademy", "ClubAcadeMyNew", "ModifyType", "ModifyReason", "CommentXy", "CommentXyNew", "CommentTw", "AddPerson", "ModiPerson", "ModiTime"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private ClubModify getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubModify v = new ClubModify();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramClubId(request, "ClubId");
        v.paramClubName(request, "ClubName");
        v.paramClubType(request, "ClubType");
        v.paramClubAcademy(request, "ClubAcademy");
        v.paramClubAcadeMyNew(request, "ClubAcadeMyNew");
        v.paramModifyType(request, "ModifyType");
        v.paramModifyReason(request, "ModifyReason");
        v.paramCommentXy(request, "CommentXy");
        v.paramCommentXyNew(request, "CommentXyNew");
        v.paramCommentTw(request, "CommentTw");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramApplyDate(request, "ApplyDate");
        v.paramAddPerson(request, "AddPerson");
        v.paramAddTime(request, "AddTime");
        v.paramModiPerson(request, "ModiPerson");
        v.paramModiTime(request, "ModiTime");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setClubId(ParamUtils.getParameter(request, "ClubId", ""));
        v.setClubName(ParamUtils.getParameter(request, "ClubName", ""));
        v.setClubType(ParamUtils.getParameter(request, "ClubType", ""));
        v.setClubAcademy(ParamUtils.getParameter(request, "ClubAcademy", ""));
        v.setClubAcadeMyNew(ParamUtils.getParameter(request, "ClubAcadeMyNew", ""));
        v.setModifyType(ParamUtils.getParameter(request, "ModifyType", ""));
        v.setModifyReason(ParamUtils.getParameter(request, "ModifyReason", ""));
        v.setCommentXy(ParamUtils.getParameter(request, "CommentXy", ""));
        v.setCommentXyNew(ParamUtils.getParameter(request, "CommentXyNew", ""));
        v.setCommentTw(ParamUtils.getParameter(request, "CommentTw", ""));
        v.setCheckFlag(ParamUtils.getParameter(request, "CheckFlag", ""));
        v.setApplyDate(ParamUtils.getDateTimeParameter(request, "ApplyDate", java.sql.Date.valueOf("0001-01-01")));
        v.setAddPerson(ParamUtils.getParameter(request, "AddPerson", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setModiPerson(ParamUtils.getParameter(request, "ModiPerson", ""));
        v.setModiTime(ParamUtils.getDateTimeParameter(request, "ModiTime", java.sql.Date.valueOf("0001-01-01")));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, ClubModify pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map ClubTypeNamemap = CEditConst.getClubTypeNameMap(userInfo);
    ClubUtil util = new ClubUtil();
    Map CheckFlag_BGMap = util.getCheckFlag_BGMap();
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        ClubModify v = (ClubModify)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getClubId()));
        row.add(Tool.jsSpecialChars(v.getClubName()));
        row.add((String)ClubTypeNamemap.get("" + v.getClubType()));
        row.add((String)AcademyNamemap.get("" + v.getClubAcademy()));
        row.add((String)AcademyNamemap.get("" + v.getClubAcadeMyNew()));
        row.add(Tool.jsSpecialChars(v.getModifyType()));
        row.add(Tool.jsSpecialChars(v.getModifyReason()));
        row.add(Tool.jsSpecialChars(v.getCommentXy()));
        row.add(Tool.jsSpecialChars(v.getCommentXyNew()));
        row.add(Tool.jsSpecialChars(v.getCommentTw()));
        row.add((String)CheckFlag_BGMap.get(v.getCheckFlag()));
        row.add(Tool.stringOfDate(v.getApplyDate()));
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getModiPerson()));
        row.add(Tool.stringOfDate(v.getModiTime()));
        rows.add(row);
    }
    CheckFlag_BGMap.clear();
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, ClubModify pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, ClubModify pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    if(userInfo.hasFunPower(Power.STUSER)){
    	cdt.add("ClubId='"+userInfo.getName()+"'");
    }
    String ClubAcademy = ParamUtils.getParameter(request,"_ClubAcademy_","");
    if(!"".equals(ClubAcademy.trim())&&!"-1".equals(ClubAcademy.trim())){
    	cdt.add("ClubAcademy = "+ClubAcademy);
    }
    String ClubAcadeMyNew  = ParamUtils.getParameter(request,"_ClubAcadeMyNew_","");
    if(!"".equals(ClubAcadeMyNew.trim())&&!"-1".equals(ClubAcadeMyNew.trim())){
    	cdt.add("ClubAcadeMyNew = "+ClubAcadeMyNew);
    }
    if(userInfo.hasFunPower(Power.UserAdminPower)){
    	if("".equals(ClubAcademy)&&"".equals(ClubAcadeMyNew)) {
    		cdt.add("(ClubAcademy="+userInfo.getDeptId()+"|| ClubAcadeMyNew="+userInfo.getDeptId()+")");
    	}
    }
    if(!userInfo.hasFunPower(Power.STUSER))
    cdt.add("checkflag!=''");
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
    ClubModify pv = new ClubModify();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "ClubModify");
    request.setAttribute("describe", "社团变更指导单位");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubModify pv = new ClubModify();
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
private void setForm(javax.servlet.http.HttpServletRequest request, ClubModify form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("ClubModifyTypeoptions", CEditConst.getClubModifyTypeOptions(userInfo, ""));
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("ClubNameoptions", CEditConst.getClubNameOptions(userInfo, ""));
    request.setAttribute("ClubTypeNameoptions", CEditConst.getClubTypeNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "ClubModify");
    request.setAttribute("describe", "社团变更指导单位");
}
private List mkRtn(String cmd, String forward, ClubModify form)
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
    ClubModify form = getByParameterDb(request);
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
    	form.setAddPerson(userInfo.getId()+"");
    	form.setAddTime(new Date());
        form.insert();
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("update"))
    {
    	String CheckFlag = ParamUtils.getParameter(request,"CheckFlag","");
        form.update();
    	if (SdtwConst.CHANGE_CLUB_TWTG.equals(CheckFlag)) {
    		int cid = Tool.StrToInt(form.getClubName());
    		Club club = new Club();
    		club = club.getById(cid);
    		club.setAcademy(form.getClubAcadeMyNew());
    		club.update();
    		BaseUserCode user = new BaseUserCode();
    		List cdt = new ArrayList();
    		cdt.add("name='"+club.getClubId()+"'");
    		cdt.add("roles=4");
    		user.setDeptId(Tool.StrToInt(club.getAcademy()));
    		user.updateByCondition(cdt);
    	}
        return mkRtn("list", "list", form);
    }
    request.setAttribute("msg", "未规定的cmd:" + cmd);
    return mkRtn("list", "failure", form);
}
%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("ClubModifyAction");
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
forwardMap.put("list", "ClubModifyAction.jsp");
forwardMap.put("failure", "ClubModifyForm.jsp");
forwardMap.put("success", "ClubModifyList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "ClubModifyForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='ClubModifyAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
