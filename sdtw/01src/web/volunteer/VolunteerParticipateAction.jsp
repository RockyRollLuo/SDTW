<%@ page language="java" %>
<%--志愿活动报名表-学生素质拓展培养认证单-志愿活动--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(VolunteerParticipate.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ActivityId", "Sno", "HonourName", "CheckFlag", "Evaluation", "Servicelenth", "Apptime", "Addfilelist"};
private String[] DicKeys = {"Id", "ActivityId", "Sno", "HonourName", "CheckFlag", "Evaluation", "Servicelenth", "Apptime", "Addfilelist"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"String", "志愿活动名称", "0", "VolunActivityName", ""}, {"string", "学生学号", "20", "text", ""}, {"string", "荣誉名称", "45", "text", ""}, {"int", "审核标志", "0", "text", ""}, {"string", "评价等级", "20", "EvaluationType", ""}, {"int", "服务时长", "0", "text", ""}, {"date", "申请时间", "0", "hidden", ""}, {"string", "上传文件列表", "500", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ActivityId", "Sno", "HonourName", "CheckFlag", "Evaluation", "Servicelenth", "Apptime", "Addfilelist"};
private String[] ListFields = {"ActivityId", "Sno", "HonourName", "CheckFlag", "Evaluation", "Servicelenth"};
private String[] FormFields = {"ActivityId", "Sno", "HonourName", "CheckFlag", "Evaluation", "Servicelenth"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private VolunteerParticipate getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    VolunteerParticipate v = new VolunteerParticipate();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramActivityId(request, "ActivityId");
        v.paramSno(request, "Sno");
        v.paramHonourName(request, "HonourName");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramEvaluation(request, "Evaluation");
        v.paramServicelenth(request, "Servicelenth");
        v.paramApptime(request, "Apptime");
        v.paramAddfilelist(request, "Addfilelist");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setActivityId(ParamUtils.getIntParameter(request, "ActivityId", -1));
        v.setSno(ParamUtils.getParameter(request, "Sno", ""));
        v.setHonourName(ParamUtils.getParameter(request, "HonourName", ""));
        v.setCheckFlag(ParamUtils.getIntParameter(request, "CheckFlag", -1));
        v.setEvaluation(ParamUtils.getParameter(request, "Evaluation", ""));
        v.setServicelenth(ParamUtils.getIntParameter(request, "Servicelenth", 0));
        v.setApptime(ParamUtils.getDateTimeParameter(request, "Apptime", java.sql.Date.valueOf("0001-01-01")));
        v.setAddfilelist(ParamUtils.getParameter(request, "Addfilelist", ""));
    }
    return v;
}
private synchronized void  formInsert (VolunteerParticipate pv){
	pv.insert();
}
private List getListRows(javax.servlet.http.HttpServletRequest request, VolunteerParticipate pv, List cdt)
{
	UserInfo userInfo = Tool.getUserInfo(request);


    //默认值定义
    Map VolunActivityNamemap = CEditConst.getVolunActivityNameMap(userInfo);
    Map EvaluationTypemap = CEditConst.getEvaluationTypeMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        VolunteerParticipate v = (VolunteerParticipate)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add((String)VolunActivityNamemap.get("" + v.getActivityId()));
        row.add(Tool.jsSpecialChars(v.getSno()));
        row.add(Tool.jsSpecialChars(v.getHonourName()));
        row.add(v.getCheckFlag()==0?"未审核":(v.getCheckFlag()==1?"审核通过":"<font color='red'>审核未通过<font>"));
        row.add((String)EvaluationTypemap.get("" + v.getEvaluation()));
        row.add("" + v.getServicelenth());
        row.add(Tool.stringOfDate(v.getApptime()));
        row.add(Tool.jsSpecialChars(v.getAddfilelist()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, VolunteerParticipate pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, VolunteerParticipate pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "ActivityId", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("activityId=" + qval);
    }
    qval = ParamUtils.getParameter(request, "CheckFlag", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("checkflag=" + qval);
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
    VolunteerParticipate pv = new VolunteerParticipate();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "VolunteerParticipate");
    request.setAttribute("describe", "志愿活动报名表-学生素质拓展培养认证单-志愿活动");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    VolunteerParticipate pv = new VolunteerParticipate();
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
private void setForm(javax.servlet.http.HttpServletRequest request, VolunteerParticipate form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("VolunActivityNameoptions", CEditConst.getVolunActivityNameOptions(userInfo, "-1"));
    request.setAttribute("EvaluationTypeoptions", CEditConst.getEvaluationTypeOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "VolunteerParticipate");
    request.setAttribute("describe", "志愿活动报名表-学生素质拓展培养认证单-志愿活动");
}
private List mkRtn(String cmd, String forward, VolunteerParticipate form)
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
    VolunteerParticipate form = getByParameterDb(request);
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
        form.setCheckFlag(1);
        form.update();
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("modifylist"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        List cdt = new ArrayList();
        cdt.add("id in (" + idlist + ")");
        VolunteerParticipate vp=new VolunteerParticipate();
        vp.setCheckFlag(1);
        vp.updateByCondition(cdt);
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("modifylist1"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        List cdt = new ArrayList();
        cdt.add("id in (" + idlist + ")");
        VolunteerParticipate vp=new VolunteerParticipate();
        vp.setCheckFlag(2);
        vp.updateByCondition(cdt);
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("save"))
    {  // System.out.println("111111111222211111111");
    	formInsert(form);
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
log.debug("VolunteerParticipateAction");
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
			attach.setFromClass("VolunteerParticipateAction.jsp");
			attach.setFromTable("VolunteerParticipate");
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
else
 {
    rtn = main(request);
}
String cmd = (String)rtn.get(0);
String forwardKey = (String)rtn.get(1);
request.setAttribute("fromBean", rtn.get(2));
Map forwardMap = new HashMap();
forwardMap.put("login", "logon.jsp");
forwardMap.put("list1", "volunteer-activity-list.jsp");
forwardMap.put("list", "VolunteerParticipateAction.jsp");
forwardMap.put("failure", "VolunteerParticipateForm.jsp");
forwardMap.put("success", "VolunteerParticipateList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "VolunteerParticipateForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='VolunteerParticipateAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
