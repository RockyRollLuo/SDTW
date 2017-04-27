	<%@ page language="java" %>
<%--参加山大创库作品表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(ChuangkuDeclare.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "CkId", "Academy", "AddFilelist", "AddAccount", "AddTime", "CheckFlag", "Cdp1", "Cdp2", "Cdp3", "Cdp4", "Cd1", "Cd2", "Cd3", "Cd4", "Cd5", "Cd6", "Cd7", "Cd8", "Cd9", "Cd10", "Cd11", "Cd12", "Cd13", "Cd14"};
private String[] DicKeys = {"Id", "CkId", "Academy", "AddFilelist", "AddAccount", "AddTime", "CheckFlag", "Cdp1", "Cdp2", "Cdp3", "Cdp4", "Cd1", "Cd2", "Cd3", "Cd4", "Cd5", "Cd6", "Cd7", "Cd8", "Cd9", "Cd10", "Cd11", "Cd12", "Cd13", "Cd14"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "参与的创库通知的id", "0", "hidden", ""}, {"string", "学院", "45", "AcademyName", ""}, {"string", "上传文件列表", "255", "hidden", ""}, {"string", "添加描述", "45", "hidden", ""}, {"string", "添加时间", "45", "hidden", ""}, {"int", "审核状态", "0", "Audit", ""}, {"string", "负责人姓名", "45", "text", ""}, {"string", "负责人学院", "45", "AcademyName", ""}, {"string", "负责人学号", "45", "text", ""}, {"string", "负责人联系方式", "45", "text", ""}, {"string", "项目名称", "45", "text", ""}, {"string", "项目分类", "45", "CkProjectType", ""}, {"string", "项目分组", "45", "CkProjectGroup", ""}, {"string", "技术可行性分析", "2000", "hidden", ""}, {"string", "市场可行性分析", "2000", "hidden", ""}, {"string", "项目推进时间分析", "2000", "hidden", ""}, {"string", "项目阶段", "45", "CkProjectStage", ""}, {"string", "是否有社会资金", "45", "text", ""}, {"string", "社会资金额度", "45", "text", ""}, {"string", "计划注册资本金额", "45", "text", ""}, {"string", "创业团队自有资金", "45", "text", ""}, {"string", "团队已经经营该项目时间", "45", "hidden", ""}, {"string", "盈利情况", "45", "text", ""}, {"string", "备注", "255", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "CkId", "Academy", "AddFilelist", "AddAccount", "AddTime", "CheckFlag", "Cdp1", "Cdp2", "Cdp3", "Cdp4", "Cd1", "Cd2", "Cd3", "Cd4", "Cd5", "Cd6", "Cd7", "Cd8", "Cd9", "Cd10", "Cd11", "Cd12", "Cd13", "Cd14"};
private String[] ListFields = {"Academy", "CheckFlag", "Cdp1", "Cdp2", "Cdp3", "Cdp4", "Cd1", "Cd2", "Cd3", "Cd7", "Cd8", "Cd9", "Cd10", "Cd11", "Cd13"};
private String[] FormFields = {"CkId", "Academy", "AddFilelist", "AddAccount", "CheckFlag", "Cdp1", "Cdp2", "Cdp3", "Cdp4", "Cd1", "Cd2", "Cd3", "Cd4", "Cd5", "Cd6", "Cd7", "Cd8", "Cd9", "Cd10", "Cd11", "Cd12", "Cd13", "Cd14"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private synchronized void  formInsert (ChuangkuDeclare pv){
	pv.insert();
}
private ChuangkuDeclare getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    ChuangkuDeclare v = new ChuangkuDeclare();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramCkId(request, "CkId");
        v.paramAcademy(request, "Academy");
        v.paramAddFilelist(request, "AddFilelist");
        v.paramAddAccount(request, "AddAccount");
        v.paramAddTime(request, "AddTime");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramCdp1(request, "Cdp1");
        v.paramCdp2(request, "Cdp2");
        v.paramCdp3(request, "Cdp3");
        v.paramCdp4(request, "Cdp4");
        v.paramCd1(request, "Cd1");
        v.paramCd2(request, "Cd2");
        v.paramCd3(request, "Cd3");
        v.paramCd4(request, "Cd4");
        v.paramCd5(request, "Cd5");
        v.paramCd6(request, "Cd6");
        v.paramCd7(request, "Cd7");
        v.paramCd8(request, "Cd8");
        v.paramCd9(request, "Cd9");
        v.paramCd10(request, "Cd10");
        v.paramCd11(request, "Cd11");
        v.paramCd12(request, "Cd12");
        v.paramCd13(request, "Cd13");
        v.paramCd14(request, "Cd14");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setCkId(ParamUtils.getIntParameter(request, "CkId", -1));
        v.setAcademy(ParamUtils.getParameter(request, "Academy", ""));
        v.setAddFilelist(ParamUtils.getParameter(request, "AddFilelist", ""));
        v.setAddAccount(ParamUtils.getParameter(request, "AddAccount", ""));
        v.setAddTime(ParamUtils.getParameter(request, "AddTime", ""));
        v.setCheckFlag(ParamUtils.getIntParameter(request, "CheckFlag", 0));
        v.setCdp1(ParamUtils.getParameter(request, "Cdp1", ""));
        v.setCdp2(ParamUtils.getParameter(request, "Cdp2", ""));
        v.setCdp3(ParamUtils.getParameter(request, "Cdp3", ""));
        v.setCdp4(ParamUtils.getParameter(request, "Cdp4", ""));
        v.setCd1(ParamUtils.getParameter(request, "Cd1", ""));
        v.setCd2(ParamUtils.getParameter(request, "Cd2", ""));
        v.setCd3(ParamUtils.getParameter(request, "Cd3", ""));
        v.setCd4(ParamUtils.getParameter(request, "Cd4", ""));
        v.setCd5(ParamUtils.getParameter(request, "Cd5", ""));
        v.setCd6(ParamUtils.getParameter(request, "Cd6", ""));
        v.setCd7(ParamUtils.getParameter(request, "Cd7", ""));
        v.setCd8(ParamUtils.getParameter(request, "Cd8", ""));
        v.setCd9(ParamUtils.getParameter(request, "Cd9", ""));
        v.setCd10(ParamUtils.getParameter(request, "Cd10", ""));
        v.setCd11(ParamUtils.getParameter(request, "Cd11", ""));
        v.setCd12(ParamUtils.getParameter(request, "Cd12", ""));
        v.setCd13(ParamUtils.getParameter(request, "Cd13", ""));
        v.setCd14(ParamUtils.getParameter(request, "Cd14", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, ChuangkuDeclare pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map CkProjectGroupmap = CEditConst.getCkProjectGroupMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map CkProjectTypemap = CEditConst.getCkProjectTypeMap(userInfo);
    Map Auditmap = CEditConst.getAuditMap(userInfo);
    Map CkProjectStagemap = CEditConst.getCkProjectStageMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        ChuangkuDeclare v = (ChuangkuDeclare)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add("" + v.getCkId());
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add(Tool.jsSpecialChars(v.getAddFilelist()));
        row.add(Tool.jsSpecialChars(v.getAddAccount()));
        row.add(Tool.jsSpecialChars(v.getAddTime()));
        row.add((String)Auditmap.get("" + v.getCheckFlag()));
        row.add(Tool.jsSpecialChars(v.getCdp1()));
        row.add((String)AcademyNamemap.get("" + v.getCdp2()));
        row.add(Tool.jsSpecialChars(v.getCdp3()));
        row.add(Tool.jsSpecialChars(v.getCdp4()));
        row.add(Tool.jsSpecialChars(v.getCd1()));
        row.add((String)CkProjectTypemap.get("" + v.getCd2()));
        row.add((String)CkProjectGroupmap.get("" + v.getCd3()));
        row.add(Tool.jsSpecialChars(v.getCd4()));
        row.add(Tool.jsSpecialChars(v.getCd5()));
        row.add(Tool.jsSpecialChars(v.getCd6()));
        row.add((String)CkProjectStagemap.get("" + v.getCd7()));
        row.add(Tool.jsSpecialChars(v.getCd8()));
        row.add(Tool.jsSpecialChars(v.getCd9()));
        row.add(Tool.jsSpecialChars(v.getCd10()));
        row.add(Tool.jsSpecialChars(v.getCd11()));
        row.add(Tool.jsSpecialChars(v.getCd12()));
        row.add(Tool.jsSpecialChars(v.getCd13()));
        row.add(Tool.jsSpecialChars(v.getCd14()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, ChuangkuDeclare pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, ChuangkuDeclare pv, boolean isAll)
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
    ChuangkuDeclare pv = new ChuangkuDeclare();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "ChuangkuDeclare");
    request.setAttribute("describe", "参加山大创库作品表");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    ChuangkuDeclare pv = new ChuangkuDeclare();
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
private void setForm(javax.servlet.http.HttpServletRequest request, ChuangkuDeclare form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("CkProjectGroupoptions", CEditConst.getCkProjectGroupOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("CkProjectTypeoptions", CEditConst.getCkProjectTypeOptions(userInfo, ""));
    request.setAttribute("Auditoptions", CEditConst.getAuditOptions(userInfo, "0"));
    request.setAttribute("CkProjectStageoptions", CEditConst.getCkProjectStageOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "ChuangkuDeclare");
    request.setAttribute("describe", "参加山大创库作品表");
}
private List mkRtn(String cmd, String forward, ChuangkuDeclare form)
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
    ChuangkuDeclare form = getByParameterDb(request);
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
    {  ChuangkuDeclareMembers vpm= new    ChuangkuDeclareMembers();
    List cdt= new ArrayList();
    cdt.add("chuangkudeclareid ="+form.getId());
        form.delete(form.getId());
      
        vpm.deleteByCondition(cdt);
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
    	formInsert (form);
    	int  ppid=form.getId();
     	String sids=ParamUtils.getParameter(request, "SId", "-1");
   	 String  [] ssids=Tool.split(",", sids);
   	// String zhiwu="zhiwu";
   	 String phone="";
   	 String duty="";
   	 String name="";
   ChuangkuDeclareMembers vpm= new    ChuangkuDeclareMembers();
   BaseUserCode user=new BaseUserCode();
   	for(int i=0;i<ssids.length;i++){
   		vpm.setChuangkuDeclareId(ppid);
   		phone=ParamUtils.getParameter(request, "phone"+i, "-1");
   		duty=ParamUtils.getParameter(request, "duty"+i, "-1");
   		user= user.getById(Integer.parseInt(ssids[i]));
   		vpm.setSno(user.getName());
   		vpm.setAcademy(user.getDeptId()+"");
   		vpm.setTel(phone);
   		vpm.setName(ssids[i]);
   		vpm.setDuty(duty);
   		vpm.insert();
   		if(("负责人").equals(duty)){
   			form.setCdp1(user.getCnName());
   			form.setCdp2(user.getDeptId()+"");
   			form.setCdp3(user.getName());
   			form.setCdp4(phone);
   			form.update();
   		}
   		
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
log.debug("ChuangkuDeclareAction");
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
forwardMap.put("list", "ChuangkuDeclareAction.jsp");
forwardMap.put("list1", "innovation-competition-list1.jsp");
forwardMap.put("failure", "ChuangkuDeclareForm.jsp");
forwardMap.put("success", "ChuangkuDeclareList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "ChuangkuDeclareForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='ChuangkuDeclareAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
	int ckid=ParamUtils.getIntParameter(request, "CkId", -1);
    pageContext.forward((String)forwardMap.get(forwardKey) + "?Ckid="+ckid+"&cmd=" + cmd + "&page=" + currpage);
}
%>
