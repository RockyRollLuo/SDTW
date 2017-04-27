<%@page import="com.xietong.software.sdtw.train.TrainUtil"%>
<%@ page language="java" %>
<%--团校培训管理资料--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(TrainingParticipate.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Sno", "Sname", "ProjectId", "HomeWork", "WorkFileList", "CheckFileEstimate", "DateRate", "CheckReport", "AddFileList", "CheckReportEstimate", "CheckId", "Audit","Sex","Academy","Grade"};
private String[] DicKeys = {"Id", "Sno", "Sname", "ProjectId", "HomeWork", "WorkFileList", "CheckFileEstimate", "DateRate", "CheckReport", "AddFileList", "CheckReportEstimate", "CheckId", "Audit","Sex","Academy","Grade"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "学号", "2000", "text", ""}, {"string", "姓名", "2000", "text", ""}, {"int", "团校培训管理id", "0", "text", ""}, {"string", "作业", "2000", "text", ""}, {"string", "作业附件", "2000", "text", ""}, {"string", "作业评价", "2000", "hidden", ""}, {"string", "考勤", "45", "text", ""}, {"string", "结题报告", "2000", "text", ""}, {"string", "结题附件", "2000", "text", ""}, {"string", "结题报告评价", "2000", "hidden", ""}, {"int", "checkId", "0", "hidden", ""}, {"int", "状态", "0", "hidden", ""},{"int", "性别", "0", "hidden", ""},{"int", "学院", "0", "hidden", ""},{"int", "年级", "0", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Sno", "Sname", "ProjectId", "HomeWork", "WorkFileList", "CheckFileEstimate", "DateRate", "CheckReport", "AddFileList", "CheckReportEstimate", "CheckId", "Audit","Sex","Academy","Grade"};
private String[] ListFields = {"Sno", "Sname","Sex","Academy","Grade","Audit"};
private String[] FormFields = {"Sno", "Sname", "ProjectId", "HomeWork", "WorkFileList", "CheckFileEstimate", "DateRate", "CheckReport", "AddFileList", "CheckReportEstimate"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private TrainingParticipate getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    TrainingParticipate v = new TrainingParticipate();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramSno(request, "Sno");
        v.paramSname(request, "Sname");
        v.paramProjectId(request, "ProjectId");
        v.paramHomeWork(request, "HomeWork");
        v.paramWorkFileList(request, "WorkFileList");
        v.paramCheckFileEstimate(request, "CheckFileEstimate");
        v.paramDateRate(request, "DateRate");
        v.paramCheckReport(request, "CheckReport");
        v.paramAddFileList(request, "AddFileList");
        v.paramCheckReportEstimate(request, "CheckReportEstimate");
        v.paramCheckId(request, "CheckId");
        v.paramAudit(request, "Audit");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setSno(ParamUtils.getParameter(request, "Sno", ""));
        v.setSname(ParamUtils.getParameter(request, "Sname", ""));
        v.setProjectId(ParamUtils.getIntParameter(request, "ProjectId", -1));
        v.setHomeWork(ParamUtils.getParameter(request, "HomeWork", ""));
        v.setWorkFileList(ParamUtils.getParameter(request, "WorkFileList", ""));
        v.setCheckFileEstimate(ParamUtils.getParameter(request, "CheckFileEstimate", ""));
        v.setDateRate(ParamUtils.getParameter(request, "DateRate", ""));
        v.setCheckReport(ParamUtils.getParameter(request, "CheckReport", ""));
        v.setAddFileList(ParamUtils.getParameter(request, "AddFileList", ""));
        v.setCheckReportEstimate(ParamUtils.getParameter(request, "CheckReportEstimate", ""));
        v.setCheckId(ParamUtils.getIntParameter(request, "CheckId", -1));
        v.setAudit(ParamUtils.getIntParameter(request, "Audit", -1));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, TrainingParticipate pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    //查询符合条件的资料
    List vs = pv.query(cdt);
    String ids = XtUtil.getColValusByList(vs,"Sname" ,TrainingParticipate.class);
    List cdt1 = new ArrayList();
    cdt1.add(" id in("+ids+")");
    Map map = XtUtil.getBeanMapByCdt(cdt1,BaseUserCode.class);
	Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
	Map sexMap = CEditConst.getsexMap(userInfo);
	Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
	Map GradeNameMap = CEditConst.getGradeNameMap(userInfo);
	TrainUtil util = new TrainUtil();
	Map AuditMap = util.getAuditMap();
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        TrainingParticipate v = (TrainingParticipate)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getSno()));
        row.add((String)UserCnNameMap.get(v.getSname()));
        row.add("" + v.getProjectId());
        row.add(Tool.jsSpecialChars(v.getHomeWork()));
        row.add(Tool.jsSpecialChars(v.getWorkFileList()));
        row.add(Tool.jsSpecialChars(v.getCheckFileEstimate()));
        row.add(Tool.jsSpecialChars(v.getDateRate()));
        row.add(Tool.jsSpecialChars(v.getCheckReport()));
        row.add(Tool.jsSpecialChars(v.getAddFileList()));
        row.add(Tool.jsSpecialChars(v.getCheckReportEstimate()));
        row.add((String) UserCnNameMap.get(v.getCheckId()+""));
        row.add((String)AuditMap.get(v.getAudit()));
        BaseUserCode b = (BaseUserCode)map.get(v.getSname());
        row.add((String)sexMap.get(b.getGender()+""));
        row.add((String)AcademyNameMap.get(b.getDeptId()+""));
        row.add((String)GradeNameMap.get(b.getGrade()+""));
        rows.add(row);
    }
    map.clear();
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, TrainingParticipate pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, TrainingParticipate pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request,"_ProjectId_","");
    if (!"".equals(qval.trim())&&qval.trim().length()>0) {
	    cdt.add("ProjectId="+qval);
    }
    qval = ParamUtils.getParameter(request,"_Audit_","");
    if (!"".equals(qval.trim())&&qval.trim().length()>0) {
	    cdt.add("Audit="+qval);
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
    TrainingParticipate pv = new TrainingParticipate();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "TrainingParticipate");
    request.setAttribute("describe", "团校培训管理资料");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    TrainingParticipate pv = new TrainingParticipate();
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
private void setForm(javax.servlet.http.HttpServletRequest request, TrainingParticipate form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "TrainingParticipate");
    request.setAttribute("describe", "团校培训管理资料");
}
private List mkRtn(String cmd, String forward, TrainingParticipate form)
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
    TrainingParticipate form = getByParameterDb(request);
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
        String filename = HeadConst.root_file_path + "/main/upload/" + userInfo.getName() + ".xls";
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
    if (cmd.equals("baominglist"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        int Audit = ParamUtils.getIntParameter(request,"Audit",-2);
        if (Audit!=-2) {
        	TrainingParticipate v = new TrainingParticipate();
            List cdt = new ArrayList();
            cdt.add("id in (" + idlist + ")");
            v.setAudit(Audit);
           // form.deleteByCondition(cdt);
            v.updateByCondition(cdt);
        }
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
log.debug("TrainingParticipateAction");
int currpage = ParamUtils.getIntParameter(request, "page", 1);
String tmp = ParamUtils.getParameter(request,"cmd","");
List rtn = null;
UserInfo userInfo = Tool.getUserInfo(request);
if (userInfo==null) {
    rtn = mkRtn("login", "login", null);
} else if ("zuoyelist".equals(tmp)) {
	int Audit = ParamUtils.getIntParameter(request,"Audit",-2);
	String idlist = ParamUtils.getParameter(request,"idlist","");
	String CheckFileEstimate = ParamUtils.getParameter(request,"CheckFileEstimate","");
	String DateRate = ParamUtils.getParameter(request,"DateRate","");
	if (Audit!=-2) {
		TrainingParticipate v = new TrainingParticipate();
	    List cdt = new ArrayList();
	    cdt.add("id in (" + idlist + ")");
	    v.setAudit(Audit);
	    v.setCheckFileEstimate(CheckFileEstimate);
	    v.setDateRate(DateRate);
	   int num = v.updateByCondition(cdt);
	   if (num>0) {
		   out.print("{\"msg\":\"ok\"}");
	   } else {
		   out.print("{\"msg\":\"error\"}");
	   }
	} else {
		out.print("{\"msg\":\"error\"}");
	}
	return;
} else if ("jietilist".equals(tmp)) {
	int Audit = ParamUtils.getIntParameter(request,"Audit",-2);
	String idlist = ParamUtils.getParameter(request,"idlist","");
	String CheckReportEstimate = ParamUtils.getParameter(request,"CheckReportEstimate","");
	if (Audit!=-2) {
		TrainingParticipate v = new TrainingParticipate();
	    List cdt = new ArrayList();
	    cdt.add("id in (" + idlist + ")");
	    v.setAudit(Audit);
	    v.setCheckReportEstimate(CheckReportEstimate);
	   int num = v.updateByCondition(cdt);
	   if (num>0) {
		   out.print("{\"msg\":\"ok\"}");
	   } else {
		   out.print("{\"msg\":\"error\"}");
	   }
	} else {
		out.print("{\"msg\":\"error\"}");
	}
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
forwardMap.put("list", "TrainingParticipateAction.jsp");
forwardMap.put("failure", "TrainingParticipateForm.jsp");
forwardMap.put("success", "TrainingParticipateList.jsp");
forwardMap.put("excel", "/main/upload/" + userInfo.getName() + ".xls");
forwardMap.put("input", "TrainingParticipateForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='TrainingParticipateAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}else if(forwardKey.equals("excel")){
	out.clear();
	out  =  pageContext.pushBody();
	response.setContentType("applicationnd.ms-excel");
	response.sendRedirect(HeadConst.apache_url + "/main/upload/"+userInfo.getName()+".xls");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>