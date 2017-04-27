<%@page import="com.xietong.software.base.Power"%>
<%@ page language="java" %>
<%--社团成员--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(ClubMembers.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "MemberName", "MemberSex", "MemberBrith", "MemberPolitics", "MemberBirthplace", "MemberClubname", "Memberclubcode", "MemberDuty", "MemberAcademy", "MemberMajor", "MemberGrade", "MemberEmail", "MemberPhone", "Memberqq", "Memberwx", "MProfile", "MExperience", "MCommentAcademy", "MCommentAcatw", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "MemberSno", "IsManager", "CheckFlag", "Remark", "ApplyTime", "CheckTime", "Identity", "ApplyContent", "StartDate", "StopDate", "ManagerGeneration", "CommentXy"};
private String[] DicKeys = {"Id", "MemberName", "MemberSex", "MemberBrith", "MemberPolitics", "MemberBirthplace", "MemberClubname", "Memberclubcode", "MemberDuty", "MemberAcademy", "MemberMajor", "MemberGrade", "MemberEmail", "MemberPhone", "Memberqq", "Memberwx", "MProfile", "MExperience", "MCommentAcademy", "MCommentAcatw", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "MemberSno", "IsManager", "CheckFlag", "Remark", "ApplyTime", "CheckTime", "Identity", "ApplyContent", "StartDate", "StopDate", "ManagerGeneration", "CommentXy"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "名称", "45", "UserName", ""}, {"string", "性别", "10", "sex", ""}, {"string", "生日", "10", "text", ""}, {"string", "政治面貌", "45", "PoliticsName", ""}, {"string", "籍贯", "50", "text", ""}, {"string", "社团名称", "45", "ClubName", ""}, {"string", "社团code", "10", "text", ""}, {"string", "职责", "50", "text", ""}, {"string", "学院", "45", "AcademyName", ""}, {"string", "专业", "45", "MajorName", ""}, {"string", "年级", "10", "GradeName", ""}, {"string", "邮箱", "45", "text", ""}, {"string", "手机", "45", "text", ""}, {"string", "QQ", "45", "text", ""}, {"string", "微信", "45", "text", ""}, {"string", "个人简介", "500", "hidden", ""}, {"string", "社团工作经历", "500", "hidden", ""}, {"string", "学院意见", "500", "hidden", ""}, {"string", "团委意见", "500", "hidden", ""}, {"string", "添加人", "50", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "修改人", "50", "hidden", ""}, {"date", "修改时间", "0", "hidden", ""}, {"string", "学号", "45", "text", ""}, {"string", "是否负责人", "45", "text", ""}, {"int", "是否审核", "0", "hidden", ""}, {"string", "备注", "500", "hidden", ""}, {"date", "申请时间", "0", "hidden", ""}, {"date", "审核时间", "0", "hidden", ""}, {"string", "学历", "45", "hidden", ""}, {"string", "个人简介1", "500", "hidden", ""}, {"date", "开始时间", "0", "text", ""}, {"date", "结束时间", "0", "text", ""}, {"int", "是否元老", "0", "text", ""}, {"string", "指导单位审核意见", "500", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "MemberName", "MemberSex", "MemberBrith", "MemberPolitics", "MemberBirthplace", "MemberClubname", "Memberclubcode", "MemberDuty", "MemberAcademy", "MemberMajor", "MemberGrade", "MemberEmail", "MemberPhone", "Memberqq", "Memberwx", "MProfile", "MExperience", "MCommentAcademy", "MCommentAcatw", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "MemberSno", "IsManager", "CheckFlag", "Remark", "ApplyTime", "CheckTime", "Identity", "ApplyContent", "StartDate", "StopDate", "ManagerGeneration", "CommentXy"};
private String[] ListFields = {"MemberClubname","MemberName","Identity", "MemberSno", "MemberAcademy", "MemberPhone", "ApplyTime","CheckFlag","IsManager"};
private String[] FormFields = {"MemberName", "MemberSex", "MemberBrith", "MemberPolitics", "MemberBirthplace", "MemberClubname", "Memberclubcode", "MemberDuty", "MemberAcademy", "MemberMajor", "MemberGrade", "MemberEmail", "MemberPhone", "Memberqq", "Memberwx", "MProfile", "MExperience", "MCommentAcademy", "MCommentAcatw", "AddPerson", "AddTime", "ModiPerson", "ModiTime", "MemberSno", "IsManager", "CheckFlag", "Remark", "ApplyTime", "CheckTime", "Identity", "ApplyContent", "StartDate", "StopDate", "ManagerGeneration", "CommentXy"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private ClubMembers getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubMembers v = new ClubMembers();
    System.out.println(ParamUtils.getIntParameter(request, "Id", -1));
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")||cmd.equals("updateUser")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramMemberName(request, "MemberName");
        v.paramMemberSex(request, "MemberSex");
        v.paramMemberBrith(request, "MemberBrith");
        v.paramMemberPolitics(request, "MemberPolitics");
        v.paramMemberBirthplace(request, "MemberBirthplace");
        v.paramMemberClubname(request, "MemberClubname");
        v.paramMemberclubcode(request, "Memberclubcode");
        v.paramMemberDuty(request, "MemberDuty");
        v.paramMemberAcademy(request, "MemberAcademy");
        v.paramMemberMajor(request, "MemberMajor");
        v.paramMemberGrade(request, "MemberGrade");
        v.paramMemberEmail(request, "MemberEmail");
        v.paramMemberPhone(request, "MemberPhone");
        v.paramMemberqq(request, "Memberqq");
        v.paramMemberwx(request, "Memberwx");
        v.paramMProfile(request, "MProfile");
        v.paramMExperience(request, "MExperience");
        v.paramMCommentAcademy(request, "MCommentAcademy");
        v.paramMCommentAcatw(request, "MCommentAcatw");
        v.paramAddPerson(request, "AddPerson");
        v.paramAddTime(request, "AddTime");
        v.paramModiPerson(request, "ModiPerson");
        v.paramModiTime(request, "ModiTime");
        v.paramMemberSno(request, "MemberSno");
        v.paramIsManager(request, "IsManager");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramRemark(request, "Remark");
        v.paramApplyTime(request, "ApplyTime");
        v.paramCheckTime(request, "CheckTime");
        v.paramIdentity(request, "Identity");
        v.paramApplyContent(request, "ApplyContent");
        v.paramStartDate(request, "StartDate");
        v.paramStopDate(request, "StopDate");
        v.paramManagerGeneration(request, "ManagerGeneration");
        v.paramCommentXy(request, "CommentXy");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setMemberName(ParamUtils.getParameter(request, "MemberName", ""));
        v.setMemberSex(ParamUtils.getParameter(request, "MemberSex", ""));
        v.setMemberBrith(ParamUtils.getParameter(request, "MemberBrith", ""));
        v.setMemberPolitics(ParamUtils.getParameter(request, "MemberPolitics", ""));
        v.setMemberBirthplace(ParamUtils.getParameter(request, "MemberBirthplace", ""));
        v.setMemberClubname(ParamUtils.getParameter(request, "MemberClubname", ""));
        v.setMemberclubcode(ParamUtils.getParameter(request, "Memberclubcode", ""));
        v.setMemberDuty(ParamUtils.getParameter(request, "MemberDuty", ""));
        v.setMemberAcademy(ParamUtils.getParameter(request, "MemberAcademy", ""));
        v.setMemberMajor(ParamUtils.getParameter(request, "MemberMajor", ""));
        v.setMemberGrade(ParamUtils.getParameter(request, "MemberGrade", ""));
        v.setMemberEmail(ParamUtils.getParameter(request, "MemberEmail", ""));
        v.setMemberPhone(ParamUtils.getParameter(request, "MemberPhone", ""));
        v.setMemberqq(ParamUtils.getParameter(request, "Memberqq", ""));
        v.setMemberwx(ParamUtils.getParameter(request, "Memberwx", ""));
        v.setMProfile(ParamUtils.getParameter(request, "MProfile", ""));
        v.setMExperience(ParamUtils.getParameter(request, "MExperience", ""));
        v.setMCommentAcademy(ParamUtils.getParameter(request, "MCommentAcademy", ""));
        v.setMCommentAcatw(ParamUtils.getParameter(request, "MCommentAcatw", ""));
        v.setAddPerson(ParamUtils.getParameter(request, "AddPerson", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setModiPerson(ParamUtils.getParameter(request, "ModiPerson", ""));
        v.setModiTime(ParamUtils.getDateTimeParameter(request, "ModiTime", java.sql.Date.valueOf("0001-01-01")));
        v.setMemberSno(ParamUtils.getParameter(request, "MemberSno", ""));
        v.setIsManager(ParamUtils.getParameter(request, "IsManager", ""));
        v.setCheckFlag(ParamUtils.getIntParameter(request, "CheckFlag", -1));
        v.setRemark(ParamUtils.getParameter(request, "Remark", ""));
        v.setApplyTime(ParamUtils.getDateTimeParameter(request, "ApplyTime", java.sql.Date.valueOf("0001-01-01")));
        v.setCheckTime(ParamUtils.getDateTimeParameter(request, "CheckTime", java.sql.Date.valueOf("0001-01-01")));
        v.setIdentity(ParamUtils.getParameter(request, "Identity", ""));
        v.setApplyContent(ParamUtils.getParameter(request, "ApplyContent", ""));
        v.setStartDate(ParamUtils.getDateTimeParameter(request, "StartDate", java.sql.Date.valueOf("0001-01-01")));
        v.setStopDate(ParamUtils.getDateTimeParameter(request, "StopDate", java.sql.Date.valueOf("0001-01-01")));
        v.setManagerGeneration(ParamUtils.getIntParameter(request, "ManagerGeneration", -1));
        v.setCommentXy(ParamUtils.getParameter(request, "CommentXy", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, ClubMembers pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map MajorNamemap = CEditConst.getMajorNameMap(userInfo);
    Map ClubNamemap = CEditConst.getClubNameMap(userInfo);
    Map UserNamemap = CEditConst.getUserCnNameMap(userInfo);
    Map sexmap = CEditConst.getsexMap(userInfo);
    Map GradeNamemap = CEditConst.getGradeNameMap(userInfo);
    Map PoliticsNamemap = CEditConst.getPoliticsNameMap(userInfo);
    Map AuditMap = CEditConst.getAuditMap(userInfo);
    Map YesNoMap = CEditConst.getYesNoMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        ClubMembers v = (ClubMembers)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        if ("0".equals(v.getIdentity())) {
	        row.add((String)UserNamemap.get("" + v.getMemberName()));
        } else if ("1".equals(v.getIdentity())) {
	        	row.add("" + v.getMemberName());
        } else {
        	row.add("");
        }
        row.add((String)sexmap.get("" + v.getMemberSex()));
        row.add(Tool.jsSpecialChars(v.getMemberBrith()));
        row.add((String)PoliticsNamemap.get("" + v.getMemberPolitics()));
        row.add(Tool.jsSpecialChars(v.getMemberBirthplace()));
        row.add((String)ClubNamemap.get("" + v.getMemberClubname()));
        
        row.add(Tool.jsSpecialChars(v.getMemberclubcode()));
        row.add(Tool.jsSpecialChars(v.getMemberDuty()));
        row.add((String)AcademyNamemap.get("" + v.getMemberAcademy()));
        row.add((String)MajorNamemap.get("" + v.getMemberMajor()));
        row.add((String)GradeNamemap.get("" + v.getMemberGrade()));
        row.add(Tool.jsSpecialChars(v.getMemberEmail()));
        row.add(Tool.jsSpecialChars(v.getMemberPhone()));
        row.add(Tool.jsSpecialChars(v.getMemberqq()));
        row.add(Tool.jsSpecialChars(v.getMemberwx()));
        row.add(Tool.jsSpecialChars(v.getMProfile()));
        row.add(Tool.jsSpecialChars(v.getMExperience()));
        row.add(Tool.jsSpecialChars(v.getMCommentAcademy()));
        row.add(Tool.jsSpecialChars(v.getMCommentAcatw()));
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getModiPerson()));
        row.add(Tool.stringOfDate(v.getModiTime()));
        row.add(Tool.jsSpecialChars(v.getMemberSno()));
        row.add((String)YesNoMap.get(v.getIsManager()));
        row.add((String)AuditMap.get("" + v.getCheckFlag()));
        row.add(Tool.jsSpecialChars(v.getRemark()));
        if(Tool.stringOfDate(v.getApplyTime()).equals("0001-01-01")){
        	row.add("");
        }else{
      	  row.add(Tool.stringOfDate(v.getApplyTime()));
        }
        row.add(Tool.stringOfDate(v.getCheckTime()));
        if ("1".equals(v.getIdentity())) {
        	row.add("研究生");
        } else {
	        row.add("本科");
        }
        row.add(Tool.jsSpecialChars(v.getApplyContent()));
        row.add(Tool.stringOfDate(v.getStartDate()));
        row.add(Tool.stringOfDate(v.getStopDate()));
        row.add("" + v.getManagerGeneration());
        row.add(Tool.jsSpecialChars(v.getCommentXy()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, ClubMembers pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, ClubMembers pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    String flag = ParamUtils.getParameter(request,"_flag_","-1");
    String  CheckFlag = ParamUtils.getParameter(request,"_CheckFlag_","");
    String MemberClubname = ParamUtils.getParameter(request,"MemberClubname","-1");
    if ("-1".equals(MemberClubname)||"".equals(MemberClubname))
     MemberClubname = ParamUtils.getParameter(request,"_MemberClubname_","-1");
    if(userInfo.hasFunPower(Power.STUSER)){
    	 List cdt2 = new ArrayList();
    	Club club = new Club();
    	List list = new ArrayList();
    	cdt2.add("ClubId = '"+userInfo.getUserCode().getName()+"'");
    	list = club.query(cdt2);
    	int clubid = -1;
    	if(list.size()>0){
    	   club = (Club)list.get(0);
    	   clubid = club.getId();
    	} 
    	if (clubid!=-1 ||!"-1".equals(MemberClubname))
	    cdt.add("MemberClubname="+clubid);
	    if("".equals(CheckFlag)){
	    if("check".equals(flag))
	    	cdt.add("CheckFlag=0");
	    if("cy".equals(flag))
	    	cdt.add("CheckFlag=1");
	    }else{
	    	 cdt.add("CheckFlag="+CheckFlag);
	    }
	    
    }else   if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)){
    	if("cy".equals(flag)){
    	cdt.add("CheckFlag=1");
    	}
    }
    if("sponsor".equals(flag)){
    	cdt.add("MemberClubname="+MemberClubname);
    	cdt.add("IsManager=1");
    	cdt.add("CheckFlag=1");
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
    ClubMembers pv = new ClubMembers();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "ClubMembers");
    String flag = ParamUtils.getParameter(request,"_flag_","");
    if("check".equals(flag)){
    	request.setAttribute("describe", "纳新管理");
    }else{
	    request.setAttribute("describe", "社团成员");
    }
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubMembers pv = new ClubMembers();
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
private void setForm(javax.servlet.http.HttpServletRequest request, ClubMembers form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, ""));
    request.setAttribute("MajorNameoptions", CEditConst.getMajorNameOptions(userInfo, ""));
    request.setAttribute("ClubNameoptions", CEditConst.getClubNameOptions(userInfo, ""));
    request.setAttribute("sexoptions", CEditConst.getsexOptions(userInfo, ""));
    request.setAttribute("GradeNameoptions", CEditConst.getGradeNameOptions(userInfo, ""));
    request.setAttribute("PoliticsNameoptions", CEditConst.getPoliticsNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "ClubMembers");
    String flag = ParamUtils.getParameter(request,"_flag_","");
    if("check".equals(flag)){
    	request.setAttribute("describe", "纳新管理");
    }else{
	    request.setAttribute("describe", "社团成员");
    }
}
private List mkRtn(String cmd, String forward, ClubMembers form)
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
    ClubMembers form = getByParameterDb(request);
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
    	form.setStartDate(new Date());
    	form.setManagerGeneration(0);
        form.insert();
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("update"))
    {
    	form.setCheckTime(new Date());
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
log.debug("ClubMembersAction");
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
forwardMap.put("list", "ClubMembersAction.jsp");
forwardMap.put("failure", "ClubMembersForm.jsp");
forwardMap.put("success", "ClubMembersList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "ClubMembersForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
String tmp = ParamUtils.getParameter(request,"cmd","");
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='ClubMembersAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}else  if (tmp.equals("updateUser"))//变更负责人
{
	//form.setCheckTime(new Date());
	ClubMembers form = getByParameterDb(request);
	System.out.println(form.getId());
    int num = form.update();
    if (num>0) {
    	out.print("{\"msg\":\"ok\"}");
    }else{
    	out.print("{\"msg\":\"no\"}");
    }
    return;
   // return mkRtn("list", "list", form);
}else  if (tmp.equals("add"))//后台新增
{
	String Identity = ParamUtils.getParameter(request,"Identity","");//0本科1研究生
	String SId = ParamUtils.getParameter(request,"SId","-1");
	int num = 0;
	if ("0".equals(Identity)){
		BaseUserCode user = new BaseUserCode();
		if (!"-1".equals(SId)&&user.getById(Tool.StrToInt(SId))!=null) {
			ClubMembers v = new ClubMembers();
			num = save(v,request);
		} else {
			out.print("{\"msg\":\"noId\"}");
			return;
		}
	} else if ("1".equals(Identity)){
		ClubMembers v = new ClubMembers();
		num = save(v,request);
	}else {
		out.print("{\"msg\":\"no\"}");
	}
		if (num>0) {
	    	out.print("{\"msg\":\"ok\"}");
	    }else{
	    	out.print("{\"msg\":\"no\"}");
	    }
	    return;
	} 
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
<%!
public synchronized int save(ClubMembers v,HttpServletRequest request) {
	UserInfo userInfo = Tool.getUserInfo(request);
	String SId = ParamUtils.getParameter(request,"SId","-1");
	BaseUserCode user = new BaseUserCode();
	String MemberName = ParamUtils.getParameter(request,"MemberName","");
	String MemberSex = ParamUtils.getParameter(request,"MemberSex","");
	String MemberPolitics = ParamUtils.getParameter(request,"MemberPolitics","");
	String MemberAcademy = ParamUtils.getParameter(request,"MemberAcademy","");
	String MemberSno = ParamUtils.getParameter(request,"MemberSno","");
	String MemberMajor = ParamUtils.getParameter(request,"MemberMajor","");
	String MemberGrade = user.getGrade()+"";
	if (!"-1".equals(SId)&&user.getById(Tool.StrToInt(SId))!=null) {
		user = user.getById(Tool.StrToInt(SId));
		 MemberName = user.getId()+"";
		 MemberSex = user.getGender()+"";
		 MemberPolitics = user.getMemberPolitics();
		 MemberAcademy = user.getDeptId()+"";
		 MemberSno = user.getName();
		 MemberMajor = user.getMajor();
		 MemberGrade = user.getGrade()+"";
		}
		String MemberBrith = ParamUtils.getParameter(request,"MemberBrith","");
		String MemberBirthplace = ParamUtils.getParameter(request,"MemberBirthplace","");
		String MemberDuty = ParamUtils.getParameter(request,"MemberDuty","");
		String IsManager = ParamUtils.getParameter(request,"IsManager","");
		String MemberClubname = ParamUtils.getParameter(request,"MemberClubname","");
		String MemberEmail = ParamUtils.getParameter(request,"MemberEmail","");
		String MemberPhone = ParamUtils.getParameter(request,"MemberPhone","");
		String Memberqq = ParamUtils.getParameter(request,"Memberqq","");
		String Memberwx = ParamUtils.getParameter(request,"Memberwx","");
		String MProfile = ParamUtils.getParameter(request,"MProfile","");
		String MExperience = ParamUtils.getParameter(request,"MExperience","");
		String Identity = ParamUtils.getParameter(request,"Identity","");//0本科1研究生
		
		v.setMemberName(MemberName);
		v.setMemberSno(MemberSno);
		v.setMemberSex(MemberSex);
		v.setMemberPolitics(MemberPolitics);
		v.setMemberAcademy(MemberAcademy);
		v.setMemberMajor(MemberMajor);
		v.setMemberGrade(MemberGrade);
		v.setMemberBrith(MemberBrith);
		v.setMemberBirthplace(MemberBirthplace);
		v.setMemberDuty(MemberDuty);
		v.setIsManager(IsManager);
		v.setMemberClubname(MemberClubname);
		v.setMemberEmail(MemberEmail);
		v.setMemberPhone(MemberPhone);
		v.setMemberqq(Memberqq);
		v.setMemberwx(Memberwx);
		v.setMProfile(MProfile);
		v.setMExperience(MExperience);
		v.setIdentity(Identity);
		v.setCheckFlag(1);
		v.setApplyTime(new Date());
		v.setAddTime(new Date());
		v.setIsManager("0");
		v.setAddPerson(userInfo.getId()+"");
		
	int num = v.insert();
	return num;
}
%>