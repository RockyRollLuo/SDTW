<%@ page language="java" %>
<%--创新创业竞赛管理--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(InnovationCompetition.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ProductionCode", "ProductionName", "Academy", "Declarer", "ProductionType", "DeclarerRole", "Remark", "AddFilelist", "AddTime", "AddPerson", "ModiTime", "ModiPerson", "CheckCommentXy", "CheckCommentTw", "Leader", "LeaderId", "Team", "CheckFlagXy", "CheckPersonXy", "CheckFlagTw", "CheckPersonTw", "Award", "ProjectName"};
private String[] DicKeys = {"Id", "ProductionCode", "ProductionName", "Academy", "Declarer", "ProductionType", "DeclarerRole", "Remark", "AddFilelist", "AddTime", "AddPerson", "ModiTime", "ModiPerson", "CheckCommentXy", "CheckCommentTw", "Leader", "LeaderId", "Team", "CheckFlagXy", "CheckPersonXy", "CheckFlagTw", "CheckPersonTw", "Award", "ProjectName"};
private String[][] DicValues = {{"int", "id", "0", "hidden", ""}, {"string", "作品编码", "20", "text", ""}, {"string", "作品名称", "100", "text", ""}, {"string", "学院全称", "100", "AcademyName", ""}, {"string", "申报者姓名（集体名称）", "45", "text", ""}, {"string", "作品类别", "20", "ProductionType", ""}, {"string", "申报类别", "10", "DeclarerRoleType", ""}, {"string", "备注", "500", "hidden", ""}, {"string", "添加文件列表", "200", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "添加人", "45", "hidden", ""}, {"date", "修改时间", "0", "hidden", ""}, {"string", "修改人", "45", "hidden", ""}, {"string", "学院意见", "500", "hidden", ""}, {"string", "团委意见", "500", "hidden", ""}, {"string", "负责人", "45", "hidden", ""}, {"string", "负责人ID", "45", "hidden", ""}, {"string", "团队成员", "100", "hidden", ""}, {"int", "考核状态", "0", "Audit", ""}, {"string", "考核人", "45", "text", ""}, {"int", "考核状态", "0", "Audit", ""}, {"string", "考核人", "45", "text", ""}, {"string", "奖励荣誉", "45", "text", ""}, {"string", "所属项目", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ProductionCode", "ProductionName", "Academy", "Declarer", "ProductionType", "DeclarerRole", "Remark", "AddFilelist", "AddTime", "AddPerson", "ModiTime", "ModiPerson", "CheckCommentXy", "CheckCommentTw", "Leader", "LeaderId", "Team", "CheckFlagXy", "CheckPersonXy", "CheckFlagTw", "CheckPersonTw", "Award", "ProjectName"};
private String[] ListFields = {"ProductionCode", "ProductionName", "Academy", "Declarer", "ProductionType", "DeclarerRole", "CheckFlagXy", "CheckPersonXy", "CheckFlagTw", "CheckPersonTw", "Award", "ProjectName"};
private String[] FormFields = {"ProductionCode", "ProductionName", "Academy", "Declarer", "ProductionType", "DeclarerRole", "Remark", "AddFilelist", "CheckCommentXy", "CheckCommentTw", "Leader", "LeaderId", "CheckFlagXy", "CheckPersonXy", "CheckFlagTw", "CheckPersonTw", "Award", "ProjectName"};
private String[] QueryFields = {"ProductionName", "Academy", "ProductionType", "DeclarerRole"};
private String[] HideFields = {"Id"};
private InnovationCompetition getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    InnovationCompetition v = new InnovationCompetition();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramProductionCode(request, "ProductionCode");
        v.paramProductionName(request, "ProductionName");
        v.paramAcademy(request, "Academy");
        v.paramDeclarer(request, "Declarer");
        v.paramProductionType(request, "ProductionType");
        v.paramDeclarerRole(request, "DeclarerRole");
        v.paramRemark(request, "Remark");
        v.paramAddFilelist(request, "AddFilelist");
        v.paramAddTime(request, "AddTime");
        v.paramAddPerson(request, "AddPerson");
        v.paramModiTime(request, "ModiTime");
        v.paramModiPerson(request, "ModiPerson");
        v.paramCheckCommentXy(request, "CheckCommentXy");
        v.paramCheckCommentTw(request, "CheckCommentTw");
        v.paramLeader(request, "Leader");
        v.paramLeaderId(request, "LeaderId");
        v.paramTeam(request, "Team");
        v.paramCheckFlagXy(request, "CheckFlagXy");
        v.paramCheckPersonXy(request, "CheckPersonXy");
        v.paramCheckFlagTw(request, "CheckFlagTw");
        v.paramCheckPersonTw(request, "CheckPersonTw");
        v.paramAward(request, "Award");
        v.paramProjectName(request, "ProjectName");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setProductionCode(ParamUtils.getParameter(request, "ProductionCode", ""));
        v.setProductionName(ParamUtils.getParameter(request, "ProductionName", ""));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setDeclarer(ParamUtils.getParameter(request, "Declarer", ""));
        v.setProductionType(ParamUtils.getParameter(request, "ProductionType", ""));
        v.setDeclarerRole(ParamUtils.getParameter(request, "DeclarerRole", ""));
        v.setRemark(ParamUtils.getParameter(request, "Remark", ""));
        v.setAddFilelist(ParamUtils.getParameter(request, "AddFilelist", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setAddPerson(ParamUtils.getParameter(request, "AddPerson", ""));
        v.setModiTime(ParamUtils.getDateTimeParameter(request, "ModiTime", java.sql.Date.valueOf("0001-01-01")));
        v.setModiPerson(ParamUtils.getParameter(request, "ModiPerson", ""));
        v.setCheckCommentXy(ParamUtils.getParameter(request, "CheckCommentXy", ""));
        v.setCheckCommentTw(ParamUtils.getParameter(request, "CheckCommentTw", ""));
        v.setLeader(ParamUtils.getParameter(request, "Leader", ""));
        v.setLeaderId(ParamUtils.getParameter(request, "LeaderId", ""));
        v.setTeam(ParamUtils.getParameter(request, "Team", ""));
        v.setCheckFlagXy(ParamUtils.getIntParameter(request, "CheckFlagXy", 0));
        v.setCheckPersonXy(ParamUtils.getParameter(request, "CheckPersonXy", ""));
        v.setCheckFlagTw(ParamUtils.getIntParameter(request, "CheckFlagTw", 0));
        v.setCheckPersonTw(ParamUtils.getParameter(request, "CheckPersonTw", ""));
        v.setAward(ParamUtils.getParameter(request, "Award", ""));
        v.setProjectName(ParamUtils.getParameter(request, "ProjectName", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, InnovationCompetition pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map DeclarerRoleTypemap = CEditConst.getDeclarerRoleTypeMap(userInfo);
    Map ProductionTypemap = CEditConst.getProductionTypeMap(userInfo);
    Map Auditmap = CEditConst.getAuditMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        InnovationCompetition v = (InnovationCompetition)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getProductionCode()));
        row.add(Tool.jsSpecialChars(v.getProductionName()));
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add(Tool.jsSpecialChars(v.getDeclarer()));
        row.add((String)ProductionTypemap.get("" + v.getProductionType()));
        row.add((String)DeclarerRoleTypemap.get("" + v.getDeclarerRole()));
        row.add(Tool.jsSpecialChars(v.getRemark()));
        row.add(Tool.jsSpecialChars(v.getAddFilelist()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.stringOfDate(v.getModiTime()));
        row.add(Tool.jsSpecialChars(v.getModiPerson()));
        row.add(Tool.jsSpecialChars(v.getCheckCommentXy()));
        row.add(Tool.jsSpecialChars(v.getCheckCommentTw()));
        row.add(Tool.jsSpecialChars(v.getLeader()));
        row.add(Tool.jsSpecialChars(v.getLeaderId()));
        row.add(Tool.jsSpecialChars(v.getTeam()));
        row.add((String)Auditmap.get("" + v.getCheckFlagXy()));
        row.add(Tool.jsSpecialChars(v.getCheckPersonXy()));
        row.add((String)Auditmap.get("" + v.getCheckFlagTw()));
        row.add(Tool.jsSpecialChars(v.getCheckPersonTw()));
        row.add(Tool.jsSpecialChars(v.getAward()));
        row.add(Tool.jsSpecialChars(v.getProjectName()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, InnovationCompetition pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, InnovationCompetition pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_ProductionName_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("productionname like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_Academy_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("academy like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_ProductionType_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("productiontype like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_DeclarerRole_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("declarerrole like '%" + qval + "%'");
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
    request.setAttribute("DeclarerRoleTypeoptions", CEditConst.getDeclarerRoleTypeOptions(userInfo, ""));
    request.setAttribute("ProductionTypeoptions", CEditConst.getProductionTypeOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
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
    InnovationCompetition pv = new InnovationCompetition();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "InnovationCompetition");
    request.setAttribute("describe", "创新创业竞赛管理");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    InnovationCompetition pv = new InnovationCompetition();
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
private void setForm(javax.servlet.http.HttpServletRequest request, InnovationCompetition form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("DeclarerRoleTypeoptions", CEditConst.getDeclarerRoleTypeOptions(userInfo, ""));
    request.setAttribute("ProductionTypeoptions", CEditConst.getProductionTypeOptions(userInfo, ""));
    request.setAttribute("Auditoptions", CEditConst.getAuditOptions(userInfo, "0"));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "InnovationCompetition");
    request.setAttribute("describe", "创新创业竞赛管理");
}
private List mkRtn(String cmd, String forward, InnovationCompetition form)
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
    InnovationCompetition form = getByParameterDb(request);
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
        return mkRtn("list", "list1", form);
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
    if (cmd.equals("save1"))
    {
        System.out.println("jinru1111111111111111111111");
        form.insert();
      	int  ppid=form.getId();
     	String sids=ParamUtils.getParameter(request, "SId", "-1");
   	 String [] ssids=Tool.split(",", sids);
   	// String zhiwu="zhiwu";
   	 String gongzuo="";
   	 String duty="";
   	 BaseUserCode user= new   	 BaseUserCode ();
   	 System.out.println("jinru11111222222222222221111111");
   InnovationCompetitionMembers vpm= new InnovationCompetitionMembers();
   	for(int i=0;i<ssids.length;i++){
   		vpm.setProductionId(ppid);
   		
   		gongzuo=ParamUtils.getParameter(request, "phone"+i, "-1");
   		duty=ParamUtils.getParameter(request, "duty"+i, "-1");
   		System.out.println(gongzuo);
   		vpm.setTel(gongzuo);
   		user=user.getById(Integer.parseInt(ssids[i]));
   		vpm.setName(ssids[i]);
   		vpm.setAcademy(user.getDeptId()+"");
   		vpm.setSno(user.getName());
   		
   		vpm.insert();
   	} 
        return mkRtn("list", "list1", form);
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
log.debug("InnovationCompetitionAction");
int currpage = ParamUtils.getIntParameter(request, "page", 1);
List rtn = null;
UserInfo userInfo = Tool.getUserInfo(request);
if (userInfo==null) {
    rtn = mkRtn("login", "login", null);
}
String tmp = ParamUtils.getParameter(request,"cmd","");
if(tmp.equals("otherattach")){
	 String fileElementId = ParamUtils.getParameter(request,"fileElementId","");
	 Calendar c = Calendar.getInstance();
	CUploadFile cuf = new CUploadFile(fileElementId,new Date().getTime()+"","/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
	cuf.setlimitSize(1024*1024*5L);
	if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR))){
		FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR));
	}
	 if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1))){
		FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
	}  
	 int fl = cuf.save(request);

	 if(fl==-1){//上传失败
	    	try{
	    		out.clear();
				out.print("{error:'上传失败',msg:''}");
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
		}else if(fl==0){
			out.clear();
			out.print("{error:'附件大小超过10M不能上传',msg:''}");
		}
	else{//上传成功
		
		try{
			ClientAttach attach = new ClientAttach();
			attach.setDataBase("tuanwei");
			attach.setAttachType(5);
			//attach.setUploadType("application/msword");
			attach.setUploadName(cuf.getRealName());
			attach.setAttachSize(100);
			attach.setUploadDate(new Date());
			
			attach.setGenerateName(cuf.getSavePath()+"/"+cuf.getSaveTotalName());
			attach.setFromClass("VolunteerZhikuDeclareAction.jsp");
			attach.setFromTable("VolunteerZhikuDeclare");
			if(attach.insert()>0){
	
				out.clear();
				out.print("{\"name\":\""+cuf.getRealName()+"\",\"error\":\"\",\"ids\":\""+attach.getId()+"\",\"msg\":\"上传成功\",\"url\":\"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+cuf.getSaveTotalName()+"\"}");
				System.out.println("111111进入文件上传");
   		}else{
   			out.clear();
   			out.print("{error:'上传失败',msg:''}");
   		}
   	}catch(Exception e){
   		e.printStackTrace();
   	}
	}
	return;
}else if(tmp.equals("delAttach")){
	int tmpid = ParamUtils.getIntParameter(request,"did",-1);
	if(tmpid != -1){
		ClientAttach ca = new ClientAttach();
		ca.delete(tmpid);
		out.print("{\"error\":\"\",\"msg\":\"删除成功\"}");
	}
	else{
		out.print("{error:'删除失败',msg:''}");
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
forwardMap.put("list", "InnovationCompetitionAction.jsp");
forwardMap.put("list1", "innovation-competition-list.jsp");
forwardMap.put("failure", "InnovationCompetitionForm.jsp");
forwardMap.put("success", "InnovationCompetitionList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "InnovationCompetitionForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='InnovationCompetitionAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
	String  proid=ParamUtils.getParameter(request, "ProjectName", "-1");
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd+"&proid="+proid + "&page=" + currpage);
}
%>
