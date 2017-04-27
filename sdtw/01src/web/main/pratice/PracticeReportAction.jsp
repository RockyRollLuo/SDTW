<%@page import="net.sf.json.JSONArray"%>
<%@page import="com.xietong.software.sdtw.pratice.PracticeUtil"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page language="java" %>
<%--社会实践结题书表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(PracticeReport.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "DeclareId", "Type", "TeamId", "Memberid", "PracticeId", "Academy", "AddFilelist", "XyCheckFlag", "TwCheckFlag", "SubmitFlag", "XyHonour", "Report1", "Report2", "Report3", "Report4", "Report5", "Report6", "Report12", "Report13", "Report14", "Report15", "StartTime", "EndTime", "Report17", "Report18", "Report19", "Report20", "Report23", "Report24", "Report25", "Report26", "Report27", "Report28", "Report29", "Report30", "Addaccount", "Addtime", "Remark", "Remark2", "Remark3", "Remark4", "Remark5", "Remark6"};
private String[] DicKeys = {"Id", "DeclareId", "Type", "TeamId", "Memberid", "PracticeId", "Academy", "AddFilelist", "XyCheckFlag", "TwCheckFlag", "SubmitFlag", "XyHonour", "Report1", "Report2", "Report3", "Report4", "Report5", "Report6", "Report12", "Report13", "Report14", "Report15", "StartTime", "EndTime", "Report17", "Report18", "Report19", "Report20", "Report23", "Report24", "Report25", "Report26", "Report27", "Report28", "Report29", "Report30", "Addaccount", "Addtime", "Remark", "Remark2", "Remark3", "Remark4", "Remark5", "Remark6"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "立项表id", "0", "text", ""}, {"int", "申请类型", "0", "text", ""}, {"string", "团队名称", "45", "text", ""}, {"string", "成员id", "45", "text", ""}, {"int", "所参加实践ID", "0", "hidden", ""}, {"string", "学院", "45", "AcademyName", ""}, {"string", "添加文件列表", "255", "hidden", ""}, {"int", "学院审核状态", "0", "hidden", ""}, {"int", "团委审核状态", "0", "hidden", ""}, {"int", "状态", "0", "hidden", ""}, {"string", "分配荣誉", "45", "text", ""}, {"string", "团队名称", "45", "text", ""}, {"string", "所属学院", "45", "AcademyName", ""}, {"string", "课题名称", "45", "text", ""}, {"string", "团队类别", "45", "PracticeReportTeamType", ""}, {"string", "实践主题", "45", "text", ""}, {"string", "立项类别", "45", "PracticeReportProjectType", ""}, {"string", "活动地点、路线", "45", "text", ""}, {"string", "本科学生", "45", "hidden", ""}, {"string", "硕士研究生", "45", "hidden", ""}, {"string", "博士研究生", "45", "hidden", ""}, {"string", "活动开始时间", "45", "hidden", ""}, {"string", "活动结束时间", "45", "hidden", ""}, {"string", "活动天数", "45", "hidden", ""}, {"string", "接收单位对团队活动的评价", "45", "hidden", ""}, {"string", "回访联系人", "255", "hidden", ""}, {"string", "回访电话", "45", "hidden", ""}, {"string", "报告题目", "45", "text", ""}, {"string", "报告类别", "45", "hidden", ""}, {"string", "报告字数", "45", "hidden", ""}, {"string", "对地方经济、社会和文化发展或企业成长的实际作用", "1000", "hidden", ""}, {"string", "指导教师工作总结", "1000", "hidden", ""}, {"string", "主要宣传报道情况", "1000", "hidden", ""}, {"string", "宣传报道数量", "45", "hidden", ""}, {"string", "安全工作落实情况总结", "1000", "hidden", ""}, {"string", "添加人", "45", "hidden", ""}, {"string", "添加时间", "45", "hidden", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}, {"string", "备用", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "DeclareId", "Type", "TeamId", "Memberid", "PracticeId", "Academy", "AddFilelist", "XyCheckFlag", "TwCheckFlag", "SubmitFlag", "XyHonour", "Report1", "Report2", "Report3", "Report4", "Report5", "Report6", "Report12", "Report13", "Report14", "Report15", "StartTime", "EndTime", "Report17", "Report18", "Report19", "Report20", "Report23", "Report24", "Report25", "Report26", "Report27", "Report28", "Report29", "Report30", "Addaccount", "Addtime", "Remark", "Remark2", "Remark3", "Remark4", "Remark5", "Remark6"};
private String[] ListFieldstab0 = {"TeamId","Academy","Type", "Report3","XyCheckFlag","TwCheckFlag"};
private String[] ListFieldstab1 = {"TeamId","Academy","Type", "Report3","XyCheckFlag","TwCheckFlag","XyHonour"};
private String[] FormFields = {"DeclareId", "Type", "TeamId", "Memberid", "Academy", "AddFilelist", "XyCheckFlag", "TwCheckFlag", "SubmitFlag", "XyHonour", "Report1", "Report2", "Report3", "Report4", "Report5", "Report6", "Report12", "Report13", "Report14", "Report15", "StartTime", "EndTime", "Report17", "Report18", "Report19", "Report20", "Report23", "Report24", "Report25", "Report26", "Report27", "Report28", "Report29", "Report30", "Addaccount", "Addtime", "Remark", "Remark2", "Remark3", "Remark4", "Remark5", "Remark6"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private PracticeReport getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    PracticeReport v = new PracticeReport();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramDeclareId(request, "DeclareId");
        v.paramType(request, "Type");
        v.paramTeamId(request, "TeamId");
        v.paramMemberid(request, "Memberid");
        v.paramPracticeId(request, "PracticeId");
        v.paramAcademy(request, "Academy");
        v.paramAddFilelist(request, "AddFilelist");
        v.paramXyCheckFlag(request, "XyCheckFlag");
        v.paramTwCheckFlag(request, "TwCheckFlag");
        v.paramSubmitFlag(request, "SubmitFlag");
        v.paramXyHonour(request, "XyHonour");
        v.paramReport1(request, "Report1");
        v.paramReport2(request, "Report2");
        v.paramReport3(request, "Report3");
        v.paramReport4(request, "Report4");
        v.paramReport5(request, "Report5");
        v.paramReport6(request, "Report6");
        v.paramReport12(request, "Report12");
        v.paramReport13(request, "Report13");
        v.paramReport14(request, "Report14");
        v.paramReport15(request, "Report15");
        v.paramStartTime(request, "StartTime");
        v.paramEndTime(request, "EndTime");
        v.paramReport17(request, "Report17");
        v.paramReport18(request, "Report18");
        v.paramReport19(request, "Report19");
        v.paramReport20(request, "Report20");
        v.paramReport23(request, "Report23");
        v.paramReport24(request, "Report24");
        v.paramReport25(request, "Report25");
        v.paramReport26(request, "Report26");
        v.paramReport27(request, "Report27");
        v.paramReport28(request, "Report28");
        v.paramReport29(request, "Report29");
        v.paramReport30(request, "Report30");
        v.paramAddaccount(request, "Addaccount");
        v.paramAddtime(request, "Addtime");
        v.paramRemark(request, "Remark");
        v.paramRemark2(request, "Remark2");
        v.paramRemark3(request, "Remark3");
        v.paramRemark4(request, "Remark4");
        v.paramRemark5(request, "Remark5");
        v.paramRemark6(request, "Remark6");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setDeclareId(ParamUtils.getIntParameter(request, "DeclareId", -1));
        v.setType(ParamUtils.getIntParameter(request, "Type", -1));
        v.setTeamId(ParamUtils.getParameter(request, "TeamId", ""));
        v.setMemberid(ParamUtils.getParameter(request, "Memberid", ""));
        v.setPracticeId(ParamUtils.getIntParameter(request, "PracticeId", -1));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setAddFilelist(ParamUtils.getParameter(request, "AddFilelist", ""));
        v.setXyCheckFlag(ParamUtils.getIntParameter(request, "XyCheckFlag", -1));
        v.setTwCheckFlag(ParamUtils.getIntParameter(request, "TwCheckFlag", -1));
        v.setSubmitFlag(ParamUtils.getIntParameter(request, "SubmitFlag", -1));
        v.setXyHonour(ParamUtils.getParameter(request, "XyHonour", ""));
        v.setReport1(ParamUtils.getParameter(request, "Report1", ""));
        v.setReport2(ParamUtils.getParameter(request, "Report2", ""));
        v.setReport3(ParamUtils.getParameter(request, "Report3", ""));
        v.setReport4(ParamUtils.getParameter(request, "Report4", ""));
        v.setReport5(ParamUtils.getParameter(request, "Report5", ""));
        v.setReport6(ParamUtils.getParameter(request, "Report6", ""));
        v.setReport12(ParamUtils.getParameter(request, "Report12", ""));
        v.setReport13(ParamUtils.getParameter(request, "Report13", ""));
        v.setReport14(ParamUtils.getParameter(request, "Report14", ""));
        v.setReport15(ParamUtils.getParameter(request, "Report15", ""));
        v.setStartTime(ParamUtils.getParameter(request, "StartTime", ""));
        v.setEndTime(ParamUtils.getParameter(request, "EndTime", ""));
        v.setReport17(ParamUtils.getParameter(request, "Report17", ""));
        v.setReport18(ParamUtils.getParameter(request, "Report18", ""));
        v.setReport19(ParamUtils.getParameter(request, "Report19", ""));
        v.setReport20(ParamUtils.getParameter(request, "Report20", ""));
        v.setReport23(ParamUtils.getParameter(request, "Report23", ""));
        v.setReport24(ParamUtils.getParameter(request, "Report24", ""));
        v.setReport25(ParamUtils.getParameter(request, "Report25", ""));
        v.setReport26(ParamUtils.getParameter(request, "Report26", ""));
        v.setReport27(ParamUtils.getParameter(request, "Report27", ""));
        v.setReport28(ParamUtils.getParameter(request, "Report28", ""));
        v.setReport29(ParamUtils.getParameter(request, "Report29", ""));
        v.setReport30(ParamUtils.getParameter(request, "Report30", ""));
        v.setAddaccount(ParamUtils.getParameter(request, "Addaccount", ""));
        v.setAddtime(ParamUtils.getParameter(request, "Addtime", ""));
        v.setRemark(ParamUtils.getParameter(request, "Remark", ""));
        v.setRemark2(ParamUtils.getParameter(request, "Remark2", ""));
        v.setRemark3(ParamUtils.getParameter(request, "Remark3", ""));
        v.setRemark4(ParamUtils.getParameter(request, "Remark4", ""));
        v.setRemark5(ParamUtils.getParameter(request, "Remark5", ""));
        v.setRemark6(ParamUtils.getParameter(request, "Remark6", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, PracticeReport pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map PracticeReportTeamTypemap = CEditConst.getPracticeReportTeamTypeMap(userInfo);
    Map PracticeReportProjectTypemap = CEditConst.getPracticeReportProjectTypeMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);

    PracticeUtil util = new PracticeUtil();
    Map map = util.getPracticeDeclareTeamMap();
    Map SubmitflagMap =  util.getSubmitflagMap();
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        PracticeReport v = (PracticeReport)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add("" + v.getDeclareId());
        if (v.getType()==1) {
	        row.add("集体");
        } else if (v.getType()==2) {
	        row.add("个人");
        }else{
        	row.add("");
        }
        row.add(map.get(v.getTeamId()));
        row.add("" + v.getPracticeId());
         row.add((String)v.getMemberid());
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add(Tool.jsSpecialChars(v.getAddFilelist()));
        if (v.getXyCheckFlag()==1) {
        	row.add("审核通过");
        } else if (v.getXyCheckFlag()==2) {
            row.add("<span style='color: red'>审核不通过</span>");
        } else {
        	row.add("未审核");
        }
        //row.add("" + v.getXyCheckFlag());
        if (v.getTwCheckFlag()==1) {
        	row.add("审核通过");
        } else if (v.getTwCheckFlag()==2) {
            row.add("<span style='color: red'>审核不通过</span>");
        } else {
        	row.add("未审核");
        }
        //row.add("" + v.getTwCheckFlag());
        row.add(SubmitflagMap.get(v.getSubmitFlag()+""));
        //row.add("" + v.getSubmitFlag());
        row.add(Tool.jsSpecialChars(v.getXyHonour()));
        row.add(Tool.jsSpecialChars(v.getReport1()));
        row.add((String)AcademyNamemap.get("" + v.getReport2()));
        row.add(Tool.jsSpecialChars(v.getReport3()));
        row.add((String)PracticeReportTeamTypemap.get("" + v.getReport4()));
        row.add(Tool.jsSpecialChars(v.getReport5()));
        row.add((String)PracticeReportProjectTypemap.get("" + v.getReport6()));
        row.add(Tool.jsSpecialChars(v.getReport12()));
        row.add(Tool.jsSpecialChars(v.getReport13()));
        row.add(Tool.jsSpecialChars(v.getReport14()));
        row.add(Tool.jsSpecialChars(v.getReport15()));
        row.add(Tool.jsSpecialChars(v.getStartTime()));
        row.add(Tool.jsSpecialChars(v.getEndTime()));
        row.add(Tool.jsSpecialChars(v.getReport17()));
        row.add(Tool.jsSpecialChars(v.getReport18()));
        row.add(Tool.jsSpecialChars(v.getReport19()));
        row.add(Tool.jsSpecialChars(v.getReport20()));
        row.add(Tool.jsSpecialChars(v.getReport23()));
        row.add(Tool.jsSpecialChars(v.getReport24()));
        row.add(Tool.jsSpecialChars(v.getReport25()));
        row.add(Tool.jsSpecialChars(v.getReport26()));
        row.add(Tool.jsSpecialChars(v.getReport27()));
        row.add(Tool.jsSpecialChars(v.getReport28()));
        row.add(Tool.jsSpecialChars(v.getReport29()));
        row.add(Tool.jsSpecialChars(v.getReport30()));
        row.add(Tool.jsSpecialChars(v.getAddaccount()));
        row.add(Tool.jsSpecialChars(v.getAddtime()));
        row.add(Tool.jsSpecialChars(v.getRemark()));
        row.add(Tool.jsSpecialChars(v.getRemark2()));
        row.add(Tool.jsSpecialChars(v.getRemark3()));
        row.add(Tool.jsSpecialChars(v.getRemark4()));
        row.add(Tool.jsSpecialChars(v.getRemark5()));
        row.add(Tool.jsSpecialChars(v.getRemark6()));
        rows.add(row);
    }
    map.clear();
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, PracticeReport pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, PracticeReport pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    if (userInfo.hasFunPower(Power.UserAdminPower)) {//指导单位
    	cdt.add("Academy="+userInfo.getDeptId());
    }
    cdt.add("SubmitFlag>-1");
    int tabs = ParamUtils.getIntParameter(request,"tabs",0);
    if (tabs==0) {//审核    显示学院未审核或未通过、  团委未审核或未通过记录
    	if (userInfo.hasFunPower(Power.UserAdminPower)) {//学院级别
    		cdt.add("XyCheckFlag!=1");
        	cdt.add("TwCheckFlag!=1");
    	}
    	if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.SHSJ)) {//团委级别
    		cdt.add("XyCheckFlag=1");
        	//cdt.add("TwCheckFlag!=1");
    	}
    }
    if (tabs==1) {//分配荣誉  显示学院审核通过
	    cdt.add("XyCheckFlag=1");
	    // cdt.add("TwCheckFlag!=1");
    }
    int declareId = ParamUtils.getIntParameter(request,"_DeclareId_",-1);
    if (declareId!=-1) {
    	cdt.add("declareId="+declareId);
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
    PracticeReport pv = new PracticeReport();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    int tabs = ParamUtils.getIntParameter(request,"tabs",0);
    if (tabs==0) {
	    request.setAttribute("fields", ListFieldstab0);
    } else {
    	request.setAttribute("fields", ListFieldstab1);
    }
    request.setAttribute("classname", "PracticeReport");
    request.setAttribute("describe", "社会实践结题书表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    PracticeReport pv = new PracticeReport();
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
private void setForm(javax.servlet.http.HttpServletRequest request, PracticeReport form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("PracticeReportTeamTypeoptions", CEditConst.getPracticeReportTeamTypeOptions(userInfo, ""));
    request.setAttribute("PracticeReportProjectTypeoptions", CEditConst.getPracticeReportProjectTypeOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "PracticeReport");
    request.setAttribute("describe", "社会实践结题书表");
}
private List mkRtn(String cmd, String forward, PracticeReport form)
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
    PracticeReport form = getByParameterDb(request);
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
    if (cmd.equals("checklist"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        int XyCheckFlag = ParamUtils.getIntParameter(request,"XyCheckFlag",-1);//学院审核
        int TwCheckFlag = ParamUtils.getIntParameter(request,"TwCheckFlag",-1);//团委审核
        List cdt = new ArrayList();
        cdt.add("id in (" + idlist + ")");
        PracticeReport v = new PracticeReport();
        //form.deleteByCondition(cdt);
        if (XyCheckFlag!=-1) {
        	v.setXyCheckFlag(XyCheckFlag);
        }
        if (TwCheckFlag!=-1) {
        	v.setTwCheckFlag(TwCheckFlag);
        }
        v.updateByCondition(cdt);
         return mkRtn("list", "list", form);
    }
    if (cmd.equals("save"))
    {
    	form.setStartTime(form.getStartTime()+" 00:00:00");
    	form.setEndTime(form.getEndTime()+" 23:59:59");
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
log.debug("PracticeReportAction");
int currpage = ParamUtils.getIntParameter(request, "page", 1);
List rtn = null;
UserInfo userInfo = Tool.getUserInfo(request);
String tmp = ParamUtils.getParameter(request,"cmd","");
if (userInfo==null) {
    rtn = mkRtn("login", "login", null);
}else if(tmp.equals("HonorOptions")){
	int HonorType = ParamUtils.getIntParameter(request,"HonorType",-1);
	int ActivityId = ParamUtils.getIntParameter(request,"ActivityId",-1);
	CampusParticipate cp = new CampusParticipate();
	List cdt1 = new ArrayList();
	List list1 = new ArrayList();
	Map<String,String> honorMap = new HashMap<String,String> (); 
	cdt1.add("CampusActivityId="+ActivityId);
	cdt1.add("1=1 order by id desc");
	list1 = cp.query(cdt1);
	if(list1.size()>0){
		for(int i=0;i<list1.size();i++){
			cp = (CampusParticipate)list1.get(i);
			honorMap.put(cp.getId()+"_"+cp.getHonor(),cp.getHonor());
		}
	}
	Honor v = new Honor();
	List list = new ArrayList();
	List cdt = new ArrayList();
	cdt.add("HonorType="+HonorType);
	cdt.add("ActivityId="+ActivityId);
	list = v.query(cdt);
	List sbList = new ArrayList();
	if(list.size()>0){
		for(int m=0;m<list1.size();m++) {
			StringBuffer sb = new StringBuffer();
			sb.append("<option value='-1'></option>");
			CampusParticipate cap = new CampusParticipate();
			cap = (CampusParticipate)list1.get(m);
		for(int i=0;i<list.size();i++){
			v = (Honor)list.get(i);
			if(honorMap.get(cap.getId()+"_"+v.getId())!=null) {
				sb.append("<option value='"+v.getId()+"' selected='selected'>"+v.getHonorName()+"</option>");
			} else {
				sb.append("<option value='"+v.getId()+"'>"+v.getHonorName()+"</option>");
			} 
			
		}
			sbList.add(sb.toString());
	}
	}
	honorMap.clear();
	JSONArray jsonObject = JSONArray.fromObject(sbList);
	out.println(jsonObject.toString());
	jsonObject.clear();
	return;
}
else {
    rtn = main(request);
}
String cmd = (String)rtn.get(0);
String forwardKey = (String)rtn.get(1);
request.setAttribute("fromBean", rtn.get(2));
Map forwardMap = new HashMap();
forwardMap.put("login", "logon.jsp");
forwardMap.put("list", "PracticeReportAction.jsp");
forwardMap.put("failure", "PracticeReportForm.jsp");
forwardMap.put("success", "PracticeReportList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "PracticeReportForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='PracticeReportAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
