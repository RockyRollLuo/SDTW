<%@ page language="java" %>
<%--团建课题--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@page import="com.xietong.software.base.Power"%>
<%!

private static Log log = LogFactory.getLog(Subject.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "SubjectCode", "SubjectName", "Principal", "Institution", "AddFileList", "AddAccount", "AddTime", "CheckAccount", "CheckTime", "CheckFlag", "Contact","ziduan1","ziduan2"};
private String[] DicKeys = {"Id", "SubjectCode", "SubjectName", "Principal", "Institution", "AddFileList", "AddAccount", "AddTime", "CheckAccount", "CheckTime", "CheckFlag", "Contact","ziduan1","ziduan2"};
private String[][] DicValues = {{"int", "id", "0", "hidden", ""}, {"string", "课题编码", "45", "text", ""}, {"string", "课题名称", "100", "text", ""}, {"string", "发布人", "45", "text", ""}, {"string", "发布单位", "50", "text", ""}, {"string", "附件", "45", "hidden", ""}, {"string", "添加账号", "45", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "审核账号", "45", "hidden", ""}, {"date", "审核时间", "0", "hidden", ""}, {"int", "审核状态", "0", "hidden", ""}, {"string", "各学院上传资料", "45", "text", ""}, {"string", "已上传资料", "45", "text", ""}, {"string", "上传资料", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "SubjectCode", "SubjectName", "Principal", "Institution", "AddFileList", "AddAccount", "AddTime", "CheckAccount", "CheckTime", "CheckFlag", "Contact","ziduan1","ziduan2"};

private String[] ListFields = {"SubjectName", "Principal", "Institution", "Contact"};
private String[] ListFields1 = {"SubjectName", "Principal", "Institution","ziduan1","ziduan2"};
private String[] FormFields = {"SubjectCode", "SubjectName", "Principal", "Institution", "Contact"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private Subject getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Subject v = new Subject();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramSubjectCode(request, "SubjectCode");
        v.paramSubjectName(request, "SubjectName");
        v.paramPrincipal(request, "Principal");
        v.paramInstitution(request, "Institution");
        v.paramAddFileList(request, "AddFileList");
        v.paramAddAccount(request, "AddAccount");
        v.paramAddTime(request, "AddTime");
        v.paramCheckAccount(request, "CheckAccount");
        v.paramCheckTime(request, "CheckTime");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramContact(request, "Contact");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setSubjectCode(ParamUtils.getParameter(request, "SubjectCode", ""));
        v.setSubjectName(ParamUtils.getParameter(request, "SubjectName", ""));
        v.setPrincipal(ParamUtils.getParameter(request, "Principal", ""));
        v.setInstitution(ParamUtils.getParameter(request, "Institution", ""));
        v.setAddFileList(ParamUtils.getParameter(request, "AddFileList", ""));
        v.setAddAccount(ParamUtils.getParameter(request, "AddAccount", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setCheckAccount(ParamUtils.getParameter(request, "CheckAccount", ""));
        v.setCheckTime(ParamUtils.getDateTimeParameter(request, "CheckTime", java.sql.Date.valueOf("0001-01-01")));
        v.setCheckFlag(ParamUtils.getIntParameter(request, "CheckFlag", 1));
        v.setContact(ParamUtils.getParameter(request, "Contact", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Subject pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    BaseUserCode user=userInfo.getUserCode();
    Map userMap=CEditConst.getUserCnNameMap(userInfo);
    //默认值定义
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Subject v = (Subject)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getSubjectCode()));
        row.add(Tool.jsSpecialChars(v.getSubjectName()));
        row.add((String)userMap.get(v.getPrincipal()+""));
        row.add(Tool.jsSpecialChars(v.getInstitution()));
        row.add(Tool.jsSpecialChars(v.getAddFileList()));
        row.add((String)userMap.get(v.getAddAccount()+""));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getCheckAccount()));
        row.add(Tool.stringOfDate(v.getCheckTime()));
        row.add("" + v.getCheckFlag());
        row.add("<a href='AcademyList1.jsp?subjectcode="+v.getId()+"'>点击进入</a>");
        row.add("<a href='SubjectFileAction.jsp?cmd=list&_academy_="+user.getDeptId()+"&_subjectcode_="+v.getId()+"'>点击进入</a>");
        row.add("<a href='SubjectFileAction.jsp?cmd=create&_subjectcode_="+v.getId()+"&_academy_="+user.getDeptId()+"'>点击上传</a>");
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Subject pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Subject pv, boolean isAll)
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
    Subject pv = new Subject();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    if(userInfo.hasFunPower(Power.UserAdminPower)){
    request.setAttribute("fields", ListFields1);	
    };
    if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){
    request.setAttribute("fields", ListFields);};
   
    request.setAttribute("classname", "Subject");
    request.setAttribute("describe", "团建课题");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Subject pv = new Subject();
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
private void setForm(javax.servlet.http.HttpServletRequest request, Subject form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Subject");
    request.setAttribute("describe", "团建课题");
}
private List mkRtn(String cmd, String forward, Subject form)
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
    Subject form = getByParameterDb(request);
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
log.debug("SubjectAction");
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
forwardMap.put("list", "SubjectAction.jsp");
forwardMap.put("failure", "SubjectForm.jsp");
forwardMap.put("success", "SubjectList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "SubjectForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='SubjectAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
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
			attach.setAttachType(11);
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
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
