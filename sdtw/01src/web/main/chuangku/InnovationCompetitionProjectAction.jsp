<%@ page language="java" %>
<%--创业项目--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@page import="com.xietong.software.base.Power"%>

<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(InnovationCompetitionProject.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ProjectName", "ProjectId", "TimeStart", "TimeEnd", "ProjectLeader", "LeaderPhone", "ProjectUnit", "ProjectDetail", "Remark", "AddFilelist", "AddTime", "AddPerson", "ModiTime", "ModiPerson","ziduan1","ziduan2","ziduan3"};
private String[] DicKeys = {"Id", "ProjectName", "ProjectId", "TimeStart", "TimeEnd", "ProjectLeader", "LeaderPhone", "ProjectUnit", "ProjectDetail", "Remark", "AddFilelist", "AddTime", "AddPerson", "ModiTime", "ModiPerson","ziduan1","ziduan2","ziduan3"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "项目名称", "45", "ProductionName", ""}, {"string", "项目编码", "45", "text", ""}, {"string", "启动时间", "45", "hidden", ""}, {"string", "结束时间", "45", "hidden", ""}, {"string", "项目负责人", "45", "text", ""}, {"string", "负责人电话", "45", "text", ""}, {"string", "立项单位", "45", "text", ""}, {"string", "项目详情", "500", "hidden", ""}, {"string", "备注", "500", "hidden", ""}, {"string", "添加文件列表", "200", "hidden", ""}, {"date", "项目添加时间", "0", "hidden", ""}, {"string", "项目添加人", "45", "hidden", ""}, {"date", "修改时间", "0", "hidden", ""}, {"string", "修改人", "45", "hidden", ""}, {"string", "报名作品列表", "45", "hidden", ""}, {"string", "竞赛奖项设置", "45", "hidden", ""}, {"string", "荣誉分配列表", "45", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ProjectName", "ProjectId", "TimeStart", "TimeEnd", "ProjectLeader", "LeaderPhone", "ProjectUnit", "ProjectDetail", "Remark", "AddFilelist", "AddTime", "AddPerson", "ModiTime", "ModiPerson","ziduan1","ziduan2","ziduan3"};
private String[] ListFields = {"ProjectName",  "ProjectLeader", "LeaderPhone", "ProjectUnit","ziduan2","ziduan1","ziduan3"};
private String[] ListFields1 = {"ProjectName",  "ProjectLeader", "LeaderPhone", "ProjectUnit","ziduan1"};

private String[] FormFields = {"ProjectName", "ProjectId", "TimeStart", "TimeEnd", "ProjectLeader", "LeaderPhone", "ProjectUnit", "ProjectDetail", "Remark", "AddFilelist"};
private String[] QueryFields = {"ProjectName"};
private String[] HideFields = {"Id"};
private InnovationCompetitionProject getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    InnovationCompetitionProject v = new InnovationCompetitionProject();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramProjectName(request, "ProjectName");
        v.paramProjectId(request, "ProjectId");
        v.paramTimeStart(request, "TimeStart");
        v.paramTimeEnd(request, "TimeEnd");
        v.paramProjectLeader(request, "ProjectLeader");
        v.paramLeaderPhone(request, "LeaderPhone");
        v.paramProjectUnit(request, "ProjectUnit");
        v.paramProjectDetail(request, "ProjectDetail");
        v.paramRemark(request, "Remark");
        v.paramAddFilelist(request, "AddFilelist");
        v.paramAddTime(request, "AddTime");
        v.paramAddPerson(request, "AddPerson");
        v.paramModiTime(request, "ModiTime");
        v.paramModiPerson(request, "ModiPerson");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setProjectName(ParamUtils.getParameter(request, "ProjectName", ""));
        v.setProjectId(ParamUtils.getParameter(request, "ProjectId", ""));
        v.setTimeStart(ParamUtils.getParameter(request, "TimeStart", ""));
        v.setTimeEnd(ParamUtils.getParameter(request, "TimeEnd", ""));
        v.setProjectLeader(ParamUtils.getParameter(request, "ProjectLeader", ""));
        v.setLeaderPhone(ParamUtils.getParameter(request, "LeaderPhone", ""));
        v.setProjectUnit(ParamUtils.getParameter(request, "ProjectUnit", ""));
        v.setProjectDetail(ParamUtils.getParameter(request, "ProjectDetail", ""));
        v.setRemark(ParamUtils.getParameter(request, "Remark", ""));
        v.setAddFilelist(ParamUtils.getParameter(request, "AddFilelist", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setAddPerson(ParamUtils.getParameter(request, "AddPerson", ""));
        v.setModiTime(ParamUtils.getDateTimeParameter(request, "ModiTime", java.sql.Date.valueOf("0001-01-01")));
        v.setModiPerson(ParamUtils.getParameter(request, "ModiPerson", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, InnovationCompetitionProject pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    BaseUserCode user= userInfo.getUserCode()  ;
    //默认值定义
    Map ProductionNamemap = CEditConst.getProductionNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        InnovationCompetitionProject v = (InnovationCompetitionProject)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add( v.getProjectName());
        row.add(Tool.jsSpecialChars(v.getProjectId()));
        row.add(Tool.jsSpecialChars(v.getTimeStart()));
        row.add(Tool.jsSpecialChars(v.getTimeEnd()));
        row.add(Tool.jsSpecialChars(v.getProjectLeader()));
        row.add(Tool.jsSpecialChars(v.getLeaderPhone()));
        row.add(Tool.jsSpecialChars(v.getProjectUnit()));
        row.add(Tool.jsSpecialChars(v.getProjectDetail()));
        row.add(Tool.jsSpecialChars(v.getRemark()));
        row.add(Tool.jsSpecialChars(v.getAddFilelist()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.stringOfDate(v.getModiTime()));
        row.add(Tool.jsSpecialChars(v.getModiPerson()));
      
        row.add("<a href='InnovationCompetitionAction.jsp?honourType=7&_Projectname_="+v.getId()+"&_titleName_=bm'"+">点击查看"+"</a>");
        if(v.getAddPerson().equals(user.getId() +"")){
        row.add("<a href='HonorAction.jsp?_honourType_=7&&_ActivityId_="+v.getId()+"'"+">点击设置"+"</a>");
        row.add("<a href='InnovationCompetitionAction.jsp?honourType=7&_check_=1&_Projectname_="+v.getId()+"&_titleName_=honor'"+">点击查看"+"</a>");
        }else{
        	row.add("")	;
        	row.add("")	;
        }
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, InnovationCompetitionProject pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, InnovationCompetitionProject pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_ProjectName_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("projectname like '%" + qval + "%'");
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
    request.setAttribute("ProductionNameoptions", CEditConst.getProductionNameOptions(userInfo, ""));
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
    InnovationCompetitionProject pv = new InnovationCompetitionProject();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    if(userInfo.hasFunPower(Power.UserAdminPower)){
        request.setAttribute("fields", ListFields1);
    }else{
    request.setAttribute("fields", ListFields);
    }
    request.setAttribute("classname", "InnovationCompetitionProject");
    request.setAttribute("describe", "创业项目");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    InnovationCompetitionProject pv = new InnovationCompetitionProject();
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
private void setForm(javax.servlet.http.HttpServletRequest request, InnovationCompetitionProject form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("ProductionNameoptions", CEditConst.getProductionNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "InnovationCompetitionProject");
    request.setAttribute("describe", "创业项目");
}
private List mkRtn(String cmd, String forward, InnovationCompetitionProject form)
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
    InnovationCompetitionProject form = getByParameterDb(request);
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
log.debug("InnovationCompetitionProjectAction");
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
		System.out.println("111111进入文件上传");
		try{
			ClientAttach attach = new ClientAttach();
			attach.setDataBase("tuanwei");
			attach.setAttachType(14);
			//attach.setUploadType("application/msword");
			attach.setUploadName(cuf.getRealName());
			attach.setAttachSize(100);
			attach.setUploadDate(new Date());
			
			attach.setGenerateName(cuf.getSavePath()+"/"+cuf.getSaveTotalName());
			attach.setFromClass("volunter/VolunteerProjectAction.jsp");
			attach.setFromTable("VolunteerProject");
			if(attach.insert()>0){
				out.clear();
				out.print("{\"name\":\""+cuf.getRealName()+"\",\"error\":\"\",\"ids\":\""+attach.getId()+"\",\"msg\":\"上传成功\",\"url\":\"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+cuf.getSaveTotalName()+"\"}");
   			
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
forwardMap.put("list", "InnovationCompetitionProjectAction.jsp");
forwardMap.put("failure", "InnovationCompetitionProjectForm.jsp");
forwardMap.put("success", "InnovationCompetitionProjectList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "InnovationCompetitionProjectForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='InnovationCompetitionProjectAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
