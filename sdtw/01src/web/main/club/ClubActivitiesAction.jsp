<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="com.xietong.software.sdtw.club.CurrentSemester"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page language="java" %>
<%--社团活动信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(ClubActivities.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ActivityName", "OrgacadeMy", "ClubName", "ClubId", "TimeStart", "TimeEnd", "ActivityPlace", "Organizer", "PredictNumber", "IsSupported", "Contant", "Contacts", "ContactsPhone", "Forecast", "CommentTeacher", "CommentAcademy", "CommentShelian", "CheckFlag", "Remark", "AddPerson", "AddTime", "Modiperson", "ModiTime", "CheckPerson", "ProjectId", "ProjectName", "Module", "IsatSchool", "ApplyTime", "CheckTime", "BelongId", "BudgetList", "BudgetAmountAll", "ConclusionCheckFlag", "ConclusionApplyTime", "ConclusionCommentAcademy", "ConclusionCommentShelian", "ConclusionGeneral", "ConclusionManuscript", "ConclusionCommentClub", "ConclusionCommentcTuanwei", "ConclusionPlanNums", "ConclusionPlanNames", "ConclusionBroadcastNums", "ConclusionBroadcastNames", "ConclusionelseNums", "ConclusionelseNames", "ConclusionCost", "ConclusionIsSupport", "ConclusionSupportDetail", "ConclusionSummary", "ConclusionRemark", "ActivityLevel","IsLiXiang"};
private String[] DicKeys = {"Id", "ActivityName", "OrgacadeMy", "ClubName", "ClubId", "TimeStart", "TimeEnd", "ActivityPlace", "Organizer", "PredictNumber", "IsSupported", "Contant", "Contacts", "ContactsPhone", "Forecast", "CommentTeacher", "CommentAcademy", "CommentShelian", "CheckFlag", "Remark", "AddPerson", "AddTime", "Modiperson", "ModiTime", "CheckPerson", "ProjectId", "ProjectName", "Module", "IsatSchool", "ApplyTime", "CheckTime", "BelongId", "BudgetList", "BudgetAmountAll", "ConclusionCheckFlag", "ConclusionApplyTime", "ConclusionCommentAcademy", "ConclusionCommentShelian", "ConclusionGeneral", "ConclusionManuscript", "ConclusionCommentClub", "ConclusionCommentcTuanwei", "ConclusionPlanNums", "ConclusionPlanNames", "ConclusionBroadcastNums", "ConclusionBroadcastNames", "ConclusionelseNums", "ConclusionelseNames", "ConclusionCost", "ConclusionIsSupport", "ConclusionSupportDetail", "ConclusionSummary", "ConclusionRemark", "ActivityLevel","IsLiXiang"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "活动主题", "45", "text", ""}, {"string", "组织单位", "45", "AcademyName", ""}, {"string", "社团名称", "45", "ClubName", ""}, {"string", "登录账号", "45", "hidden", ""}, {"string", "活动时间", "45", "text", ""}, {"string", "活动结束时间", "45", "text", ""}, {"string", "活动地点", "45", "text", ""}, {"string", "组织者", "45", "UserName", ""}, {"string", "预计参加人数", "10", "hidden", ""}, {"string", "申请时是否有赞助", "5", "hidden", ""}, {"string", "活动具体内容及活动经费使用情况", "500", "hidden", ""}, {"string", "第一负责人", "45", "hidden", ""}, {"string", "第一负责人电话", "45", "hidden", ""}, {"string", "活动预告", "500", "hidden", ""}, {"string", "指导教师意见", "200", "hidden", ""}, {"string", "指导单位意见", "200", "hidden", ""}, {"string", "社团联合会意见", "200", "hidden", ""}, {"int", "审核", "0", "hidden", ""}, {"string", "备注", "500", "hidden", ""}, {"string", "添加人", "45", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "修改人", "45", "hidden", ""}, {"date", "修改时间", "0", "hidden", ""}, {"string", "活动审批老师", "45", "hidden", ""}, {"string", "项目id", "45", "hidden", ""}, {"string", "项目名称", "45", "hidden", ""}, {"string", "社团创立(club)或团委立项(club-project)", "45", "hidden", ""}, {"string", "是否校内活动", "5", "text", ""}, {"date", "申请时间", "0", "hidden", ""}, {"date", "审核时间", "0", "hidden", ""}, {"string", "立项0为社团创建", "45", "hidden", ""}, {"string", "预算清单", "2000", "hidden", ""}, {"string", "所有预算", "45", "hidden", ""}, {"int", "项目结题：检查", "0", "hidden", ""}, {"date", "项目结题：申请时间", "0", "hidden", ""}, {"string", "学院审核意见", "2000", "hidden", ""}, {"string", "社团的审核意见", "500", "hidden", ""}, {"string", "项目结题:活动概要", "1000", "hidden", ""}, {"string", "项目结题:稿件情况", "500", "hidden", ""}, {"string", "社团意见", "500", "hidden", ""}, {"string", "团委意见", "500", "hidden", ""}, {"string", "活动前期策划和组织人数", "5", "hidden", ""}, {"string", "活动前期策划和组织参与人员", "500", "hidden", ""}, {"string", "活动材料制作、宣传、表演人数", "5", "hidden", ""}, {"string", "活动材料制作、宣传、表演人参与人员", "500", "hidden", ""}, {"string", "活动其他参与人数", "5", "hidden", ""}, {"string", "活动其他参与人员", "2000", "hidden", ""}, {"string", "活动总经费", "20", "hidden", ""}, {"string", "结题时是否有赞助", "5", "hidden", ""}, {"string", "赞助情况", "500", "hidden", ""}, {"string", "结题总结", "1000", "hidden", ""}, {"string", "其他必要说明人", "1000", "hidden", ""}, {"string", "立项等级l", "15", "hidden", ""},{"string", "是否立项", "5", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ActivityName", "OrgacadeMy", "ClubName", "ClubId", "TimeStart","TimeEnd","ActivityPlace", "Organizer", "PredictNumber", "IsSupported", "Contant", "Contacts", "ContactsPhone","Forecast", "CommentTeacher", "CommentAcademy", "CommentShelian", "CheckFlag", "Remark","AddPerson", "AddTime", "Modiperson", "ModiTime", "CheckPerson", "ProjectId", "ProjectName", "Module","IsatSchool", "ApplyTime", "CheckTime", "BelongId", "BudgetList", "BudgetAmountAll", "ConclusionCheckFlag", "ConclusionApplyTime", "ConclusionCommentAcademy", "ConclusionCommentShelian", "ConclusionGeneral", "ConclusionManuscript", "ConclusionCommentClub", "ConclusionCommentcTuanwei", "ConclusionPlanNums", "ConclusionPlanNames", "ConclusionBroadcastNums", "ConclusionBroadcastNames", "ConclusionelseNums", "ConclusionelseNames", "ConclusionCost", "ConclusionIsSupport", "ConclusionSupportDetail", "ConclusionSummary", "ConclusionRemark", "ActivityLevel","IsLiXiang"};
private String[] ListFields = {"ActivityName", "OrgacadeMy", "ClubName", "TimeStart","Organizer", "IsatSchool","CheckFlag","IsLiXiang"};
private String[] FormFields = {"ActivityName", "OrgacadeMy", "ClubName", "TimeStart", "TimeEnd", "ActivityPlace", "Organizer", "PredictNumber", "IsSupported", "Contant", "Contacts", "ContactsPhone", "Forecast", "CommentTeacher", "CommentAcademy", "CommentShelian", "CheckFlag", "Remark", "AddPerson", "AddTime", "Modiperson", "ModiTime", "CheckPerson", "ProjectId", "ProjectName", "Module", "IsatSchool", "ApplyTime", "CheckTime", "BelongId", "BudgetList", "BudgetAmountAll", "ConclusionCheckFlag", "ConclusionApplyTime", "ConclusionCommentAcademy", "ConclusionCommentShelian", "ConclusionGeneral", "ConclusionManuscript", "ConclusionCommentClub", "ConclusionCommentcTuanwei", "ConclusionPlanNums", "ConclusionPlanNames", "ConclusionBroadcastNums", "ConclusionBroadcastNames", "ConclusionelseNums", "ConclusionelseNames", "ConclusionCost", "ConclusionIsSupport", "ConclusionSupportDetail", "ConclusionSummary", "ConclusionRemark", "ActivityLevel"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private ClubActivities getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubActivities v = new ClubActivities();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    String TimeStart = ParamUtils.getParameter(request,"TimeStart","");
    String TimeEnd = ParamUtils.getParameter(request, "TimeEnd", "");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramActivityName(request, "ActivityName");
        v.paramOrgacadeMy(request, "OrgacadeMy");
        v.paramClubName(request, "ClubName");
        v.paramClubId(request, "ClubId");
        //v.paramTimeStart(request, "TimeStart");
        //v.paramTimeEnd(request, "TimeEnd");
        v.setTimeStart(TimeStart+" 0:00:00");
        v.setTimeEnd(TimeEnd+" 23:59:59");
        v.paramActivityPlace(request, "ActivityPlace");
        v.paramOrganizer(request, "Organizer");
        v.paramPredictNumber(request, "PredictNumber");
        v.paramIsSupported(request, "IsSupported");
        v.paramContant(request, "Contant");
        v.paramContacts(request, "Contacts");
        v.paramContactsPhone(request, "ContactsPhone");
        v.paramForecast(request, "Forecast");
        v.paramCommentTeacher(request, "CommentTeacher");
        v.paramCommentAcademy(request, "CommentAcademy");
        v.paramCommentShelian(request, "CommentShelian");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramRemark(request, "Remark");
        v.paramAddPerson(request, "AddPerson");
        v.paramAddTime(request, "AddTime");
        v.paramModiperson(request, "Modiperson");
        v.paramModiTime(request, "ModiTime");
        v.paramCheckPerson(request, "CheckPerson");
        v.paramProjectId(request, "ProjectId");
        v.paramProjectName(request, "ProjectName");
        v.paramModule(request, "Module");
        v.paramIsatSchool(request, "IsatSchool");
        v.paramApplyTime(request, "ApplyTime");
        v.paramCheckTime(request, "CheckTime");
        v.paramBelongId(request, "BelongId");
        v.paramBudgetList(request, "BudgetList");
        v.paramBudgetAmountAll(request, "BudgetAmountAll");
        v.paramConclusionCheckFlag(request, "ConclusionCheckFlag");
        v.paramConclusionApplyTime(request, "ConclusionApplyTime");
        v.paramConclusionCommentAcademy(request, "ConclusionCommentAcademy");
        v.paramConclusionCommentShelian(request, "ConclusionCommentShelian");
        v.paramConclusionGeneral(request, "ConclusionGeneral");
        v.paramConclusionManuscript(request, "ConclusionManuscript");
        v.paramConclusionCommentClub(request, "ConclusionCommentClub");
        v.paramConclusionCommentcTuanwei(request, "ConclusionCommentcTuanwei");
        v.paramConclusionPlanNums(request, "ConclusionPlanNums");
        v.paramConclusionPlanNames(request, "ConclusionPlanNames");
        v.paramConclusionBroadcastNums(request, "ConclusionBroadcastNums");
        v.paramConclusionBroadcastNames(request, "ConclusionBroadcastNames");
        v.paramConclusionelseNums(request, "ConclusionelseNums");
        v.paramConclusionelseNames(request, "ConclusionelseNames");
        v.paramConclusionCost(request, "ConclusionCost");
        v.paramConclusionIsSupport(request, "ConclusionIsSupport");
        v.paramConclusionSupportDetail(request, "ConclusionSupportDetail");
        v.paramConclusionSummary(request, "ConclusionSummary");
        v.paramConclusionRemark(request, "ConclusionRemark");
        v.paramActivityLevel(request, "ActivityLevel");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setActivityName(ParamUtils.getParameter(request, "ActivityName", ""));
        v.setOrgacadeMy(ParamUtils.getParameter(request, "OrgacadeMy", ""));
        v.setClubName(ParamUtils.getParameter(request, "ClubName", ""));
        v.setClubId(ParamUtils.getParameter(request, "ClubId", ""));
        v.setTimeStart(TimeStart+" 0:00:00");
        v.setTimeEnd(TimeEnd+" 23:59:59");
        v.setActivityPlace(ParamUtils.getParameter(request, "ActivityPlace", ""));
        v.setOrganizer(ParamUtils.getParameter(request, "Organizer", ""));
        v.setPredictNumber(ParamUtils.getParameter(request, "PredictNumber", ""));
        v.setIsSupported(ParamUtils.getParameter(request, "IsSupported", ""));
        v.setContant(ParamUtils.getParameter(request, "Contant", ""));
        v.setContacts(ParamUtils.getParameter(request, "Contacts", ""));
        v.setContactsPhone(ParamUtils.getParameter(request, "ContactsPhone", ""));
        v.setForecast(ParamUtils.getParameter(request, "Forecast", ""));
        v.setCommentTeacher(ParamUtils.getParameter(request, "CommentTeacher", ""));
        v.setCommentAcademy(ParamUtils.getParameter(request, "CommentAcademy", ""));
        v.setCommentShelian(ParamUtils.getParameter(request, "CommentShelian", ""));
        v.setCheckFlag(ParamUtils.getIntParameter(request, "CheckFlag", -1));
        v.setRemark(ParamUtils.getParameter(request, "Remark", ""));
        v.setAddPerson(ParamUtils.getParameter(request, "AddPerson", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", new Date()));
        v.setModiperson(ParamUtils.getParameter(request, "Modiperson", ""));
        v.setModiTime(ParamUtils.getDateTimeParameter(request, "ModiTime", java.sql.Date.valueOf("0001-01-01")));
        v.setCheckPerson(ParamUtils.getParameter(request, "CheckPerson", ""));
        v.setProjectId(ParamUtils.getParameter(request, "ProjectId", ""));
        v.setProjectName(ParamUtils.getParameter(request, "ProjectName", ""));
        v.setModule(ParamUtils.getParameter(request, "Module", ""));
        v.setIsatSchool(ParamUtils.getParameter(request, "IsatSchool", ""));
        v.setApplyTime(ParamUtils.getDateTimeParameter(request, "ApplyTime", new Date()));
        v.setCheckTime(ParamUtils.getDateTimeParameter(request, "CheckTime", java.sql.Date.valueOf("0001-01-01")));
        v.setBelongId(ParamUtils.getParameter(request, "BelongId", ""));
        v.setBudgetList(ParamUtils.getParameter(request, "BudgetList", ""));
        v.setBudgetAmountAll(ParamUtils.getParameter(request, "BudgetAmountAll", ""));
        v.setConclusionCheckFlag(ParamUtils.getIntParameter(request, "ConclusionCheckFlag", 0));
        v.setConclusionApplyTime(ParamUtils.getDateTimeParameter(request, "ConclusionApplyTime", java.sql.Date.valueOf("0001-01-01")));
        v.setConclusionCommentAcademy(ParamUtils.getParameter(request, "ConclusionCommentAcademy", ""));
        v.setConclusionCommentShelian(ParamUtils.getParameter(request, "ConclusionCommentShelian", ""));
        v.setConclusionGeneral(ParamUtils.getParameter(request, "ConclusionGeneral", ""));
        v.setConclusionManuscript(ParamUtils.getParameter(request, "ConclusionManuscript", ""));
        v.setConclusionCommentClub(ParamUtils.getParameter(request, "ConclusionCommentClub", ""));
        v.setConclusionCommentcTuanwei(ParamUtils.getParameter(request, "ConclusionCommentcTuanwei", ""));
        v.setConclusionPlanNums(ParamUtils.getParameter(request, "ConclusionPlanNums", ""));
        v.setConclusionPlanNames(ParamUtils.getParameter(request, "ConclusionPlanNames", ""));
        v.setConclusionBroadcastNums(ParamUtils.getParameter(request, "ConclusionBroadcastNums", ""));
        v.setConclusionBroadcastNames(ParamUtils.getParameter(request, "ConclusionBroadcastNames", ""));
        v.setConclusionelseNums(ParamUtils.getParameter(request, "ConclusionelseNums", ""));
        v.setConclusionelseNames(ParamUtils.getParameter(request, "ConclusionelseNames", ""));
        v.setConclusionCost(ParamUtils.getParameter(request, "ConclusionCost", ""));
        v.setConclusionIsSupport(ParamUtils.getParameter(request, "ConclusionIsSupport", ""));
        v.setConclusionSupportDetail(ParamUtils.getParameter(request, "ConclusionSupportDetail", ""));
        v.setConclusionSummary(ParamUtils.getParameter(request, "ConclusionSummary", ""));
        v.setConclusionRemark(ParamUtils.getParameter(request, "ConclusionRemark", ""));
        v.setActivityLevel(ParamUtils.getParameter(request, "ActivityLevel", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, ClubActivities pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map ClubNamemap = CEditConst.getClubNameMap(userInfo);
    Map UserNamemap = CEditConst.getUserCnNameMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map YesNoMap = CEditConst.getYesNoMap(userInfo);
    ClubUtil util = new ClubUtil();
    Map CheckFlagMap = util.getCheckFlagMap();
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        ClubActivities v = (ClubActivities)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getActivityName()));
        row.add((String)AcademyNamemap.get("" + v.getOrgacadeMy()));
        row.add((String)ClubNamemap.get("" + v.getClubName()));
        row.add(Tool.jsSpecialChars(v.getClubId()));
        row.add(Tool.jsSpecialChars(v.getTimeStart()+" ~ "+v.getTimeEnd()));
        row.add(Tool.jsSpecialChars(v.getTimeEnd()));
        row.add(Tool.jsSpecialChars(v.getActivityPlace()));
        row.add((String)UserNamemap.get("" + v.getOrganizer()));
        row.add(Tool.jsSpecialChars(v.getPredictNumber()));
        row.add(Tool.jsSpecialChars(v.getIsSupported()));
        row.add(Tool.jsSpecialChars(v.getContant()));
        row.add(Tool.jsSpecialChars(v.getContacts()));
        row.add(Tool.jsSpecialChars(v.getContactsPhone()));
        row.add(Tool.jsSpecialChars(v.getForecast()));
        row.add(Tool.jsSpecialChars(v.getCommentTeacher()));
        row.add(Tool.jsSpecialChars(v.getCommentAcademy()));
        row.add(Tool.jsSpecialChars(v.getCommentShelian()));
        row.add((String)CheckFlagMap.get("" + v.getCheckFlag()));
        row.add(Tool.jsSpecialChars(v.getRemark()));
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getModiperson()));
        row.add(Tool.stringOfDate(v.getModiTime()));
        row.add(Tool.jsSpecialChars(v.getCheckPerson()));
        row.add(Tool.jsSpecialChars(v.getProjectId()));
        row.add(Tool.jsSpecialChars(v.getProjectName()));
        row.add(Tool.jsSpecialChars(v.getModule()));
        row.add((String)YesNoMap.get(v.getIsatSchool()+""));
        row.add(Tool.stringOfDate(v.getApplyTime()));
        row.add(Tool.stringOfDate(v.getCheckTime()));
        row.add(Tool.jsSpecialChars(v.getBelongId()));
        row.add(Tool.jsSpecialChars(v.getBudgetList()));
        row.add(Tool.jsSpecialChars(v.getBudgetAmountAll()));
        row.add("" + v.getConclusionCheckFlag());
        row.add(Tool.stringOfDate(v.getConclusionApplyTime()));
        row.add(Tool.jsSpecialChars(v.getConclusionCommentAcademy()));
        row.add(Tool.jsSpecialChars(v.getConclusionCommentShelian()));
        row.add(Tool.jsSpecialChars(v.getConclusionGeneral()));
        row.add(Tool.jsSpecialChars(v.getConclusionManuscript()));
        row.add(Tool.jsSpecialChars(v.getConclusionCommentClub()));
        row.add(Tool.jsSpecialChars(v.getConclusionCommentcTuanwei()));
        row.add(Tool.jsSpecialChars(v.getConclusionPlanNums()));
        row.add(Tool.jsSpecialChars(v.getConclusionPlanNames()));
        row.add(Tool.jsSpecialChars(v.getConclusionBroadcastNums()));
        row.add(Tool.jsSpecialChars(v.getConclusionBroadcastNames()));
        row.add(Tool.jsSpecialChars(v.getConclusionelseNums()));
        row.add(Tool.jsSpecialChars(v.getConclusionelseNames()));
        row.add(Tool.jsSpecialChars(v.getConclusionCost()));
        row.add(Tool.jsSpecialChars(v.getConclusionIsSupport()));
        row.add(Tool.jsSpecialChars(v.getConclusionSupportDetail()));
        row.add(Tool.jsSpecialChars(v.getConclusionSummary()));
        row.add(Tool.jsSpecialChars(v.getConclusionRemark()));
        row.add(Tool.jsSpecialChars(v.getActivityLevel()));
        if("".equals(v.getProjectId())){
        row.add("未立项");
        }else{
        	row.add("立项");
        }
        rows.add(row);
    }
    CheckFlagMap.clear();
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, ClubActivities pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, ClubActivities pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request,"_Module_","");
    if(qval.trim().length()>0&&!"-1".equals(qval.trim()))
    	cdt.add("Module='"+qval+"'");
    if(userInfo.hasFunPower(Power.STUSER)){
    	cdt.add("ClubId='"+userInfo.getUserCode().getName()+"'");
    }
   
    if(userInfo.hasFunPower(Power.UserAdminPower)){//指导单位
    	cdt.add("OrgacadeMy="+userInfo.getUserCode().getDeptId());
        /* if(qval.equals("club"))
    		cdt.add("(checkflag in(0,1,2,3,4))");
    	if(qval.equals("club-project"))
    		cdt.add("checkflag in(0,1,2,3,4,6,7,8,9,10)"); */
    	cdt.add("checkflag!=-1");
    }
    if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST))//团委用户
    {
    	//if(qval.equals("club"))
    	//	cdt.add("(checkflag in(1,3,4))");
    	//if(qval.equals("club-project"))
    		cdt.add("checkflag!=-1");
    }
    int ProjectId = ParamUtils.getIntParameter(request,"ProjectId",-1);
    if (ProjectId!=-1) {
    	cdt.add("ProjectId="+ProjectId);
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
    ClubActivities pv = new ClubActivities();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "ClubActivities");
    request.setAttribute("describe", "社团活动信息");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubActivities pv = new ClubActivities();
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
private void setForm(javax.servlet.http.HttpServletRequest request, ClubActivities form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("Moduleoptions", CEditConst.getModuleOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("ClubProjectNameoptions", CEditConst.getClubProjectNameOptions(userInfo, ""));
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, ""));
    request.setAttribute("ActivityLeveloptions", CEditConst.getActivityLevelOptions(userInfo, ""));
    request.setAttribute("ClubNameoptions", CEditConst.getClubNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "ClubActivities");
    request.setAttribute("describe", "社团活动信息");
}
private List mkRtn(String cmd, String forward, ClubActivities form)
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
    ClubActivities form = getByParameterDb(request);
    if (cmd.equals("list"))
    {
        setList(request);
        return mkRtn("list", "success", form);
    }
    if (cmd.equals("projectList"))
    {
        setList(request);
        return mkRtn("list", "projectList", form);
    }
     if (cmd.equals("clubproject"))
    {
        setList(request);
        return mkRtn("list", "clubproject", form);
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
    if (cmd.equals("project"))
    {
    	int id = ParamUtils.getIntParameter(request,"ProjectId",-1);
    	if(userInfo.hasFunPower(Power.STUSER)){//社团用户
    		
	    		List cdt = new ArrayList();
	    		List list = new ArrayList();
	    		cdt.add("ProjectId="+id);
	    		cdt.add("AddPerson="+userInfo.getId());
	    		cdt.add("Module='club-project'");
	    		list = form.query(cdt);
	    		if(list.size()>0)
	    			form = (ClubActivities)list.get(0);
	    		else{
	    			form = new ClubActivities();
	    		}
    	}else{
    		form = form.getById(form.getId());
    	}
    	setForm(request, form);
        return mkRtn("project", "project", form);
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
    if (cmd.equals("saveProject"))
    {
        form.insert();
        List CAIds = new ArrayList();
        double total = 0.0;
        for(int i=0;i<10;i++){
        	ClubActivitiesBudgetAmount caba = new ClubActivitiesBudgetAmount();
        	String Purpose = ParamUtils.getParameter(request,"Purpose"+i,"");
        	double Price = ParamUtils.getDoubleParameter(request,"Price"+i,0.0);
        	int Num = ParamUtils.getIntParameter(request,"Num"+i,0);
        	double Amount = ParamUtils.getDoubleParameter(request,"Amount"+i,0.0);
        	String Remark = ParamUtils.getParameter(request,"Remark"+i,"");
        	int CAId = form.getId();
        	caba.setPurpose(Purpose);
        	caba.setPrice(Price);
        	caba.setNum(Num);
        	caba.setAmount(Amount);
        	caba.setRemark(Remark);
        	caba.setCAId(CAId);
        	if(!"".equals(Purpose)&&Price>0&&Num>0&&Amount>0){
        		caba.insert();
        		total+=(Price*Num);
	        	CAIds.add(caba.getId()+"");
        	}
        }
        int ProjectId = ParamUtils.getIntParameter(request,"ProjectId",-1);
    	form.setProjectId(ProjectId+"");
    	form.setModule("club-project");
        form.setBudgetAmountAll(total+"");
        form.setBudgetList(Tool.join(",",CAIds));
        form.update();
        //return mkRtn("projectList", "projectList", form);
        return mkRtn("updateProject", "updateProject", form);
    }
    if (cmd.equals("update"))
    {
        //form.update();
        form.setConclusionGeneral(form.getConclusionGeneral());
        form.setConclusionManuscript(form.getConclusionManuscript());
        form.setConclusionCommentClub(form.getConclusionCommentClub());
        form.setConclusionPlanNums(form.getConclusionPlanNums());
        form.update();
        return mkRtn("projectList", "list", form);
    }
    if (cmd.equals("update_activities"))
    {
        form.update();
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("update_Jt"))
    {
        //form.update();
        form.setConclusionGeneral(form.getConclusionGeneral());
        form.setConclusionManuscript(form.getConclusionManuscript());
        form.setConclusionCommentClub(form.getConclusionCommentClub());
        form.setConclusionPlanNums(form.getConclusionPlanNums());
        form.update();
        //return mkRtn("projectList", "list", form);
        setList(request);
        return mkRtn("list", "clubproject", form);
    }
    if (cmd.equals("updateProject"))
    {
        List CAIds = new ArrayList();
        for(int i=0;i<10;i++){
        	ClubActivitiesBudgetAmount caba = new ClubActivitiesBudgetAmount();
        	int id= ParamUtils.getIntParameter(request,"cabaid"+i,-1);
        	String Purpose = ParamUtils.getParameter(request,"Purpose"+i,"");
        	double Price = ParamUtils.getDoubleParameter(request,"Price"+i,0.0);
        	int Num = ParamUtils.getIntParameter(request,"Num"+i,0);
        	double Amount = ParamUtils.getDoubleParameter(request,"Amount"+i,0.0);
        	String Remark = ParamUtils.getParameter(request,"Remark"+i,"");
        	int CAId = form.getId();
        	if(caba.getById(id)!=null)
        	caba = caba.getById(id);
        	caba.setPurpose(Purpose);
        	caba.setPrice(Price);
        	caba.setNum(Num);
        	caba.setAmount(Amount);
        	caba.setRemark(Remark);
        	caba.setCAId(CAId);
        	if(!"".equals(Purpose)&&Price>0&&Num>0&&Amount>0){
        		if(caba.getById(id)!=null)
        		caba.update();
        		else{
        			caba.insert();
        		}
        	CAIds.add(caba.getId()+"");
        	}
        }
        form.setBudgetList(Tool.join(",",CAIds));
        form.update();
        return mkRtn("updateProject", "updateProject", form);
    }
    if (cmd.equals("checkProject"))
    {
    	form.setCheckFlag(form.getCheckFlag());
    	form.setCommentAcademy(form.getCommentAcademy());
    	form.setCommentShelian(form.getCommentShelian());
    	if(userInfo.hasFunPower(Power.STUSER))
    	form.setCheckPerson(userInfo.getId()+"");
    	form.update();
        return mkRtn("clubproject", "projectList", form);
    }
    request.setAttribute("msg", "未规定的cmd:" + cmd);
    return mkRtn("list", "failure", form);
}
%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("ClubActivitiesAction");
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
forwardMap.put("list", "ClubActivitiesAction.jsp");
forwardMap.put("failure", "ClubActivitiesForm.jsp");
forwardMap.put("success", "ClubActivitiesList.jsp");
forwardMap.put("projectList", "ClubActivitiesAction.jsp");
forwardMap.put("clubproject", "ClubActivitiesList_project.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "ClubActivitiesForm.jsp");
forwardMap.put("updateProject", "ClubActivityProjectAction.jsp");
forwardMap.put("project", "ClubActivitiesForm_project.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")||forwardKey.equals("projectList")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    System.out.println("<script>window.location='ClubActivitiesAction.jsp?cmd="+cmd+"&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
    out.println("<script>window.location='ClubActivitiesAction.jsp?cmd="+cmd+"&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
