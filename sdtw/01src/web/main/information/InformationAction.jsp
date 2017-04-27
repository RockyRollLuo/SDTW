<%@ page language="java" %>
<%--资讯信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@page import="com.xietong.software.base.Power"%>
<%!
private static Log log = LogFactory.getLog(Information.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Subject", "ImageInfo", "InfoDesc", "NewDate", "UserId", "UserType", "AttachIds", "VideoPath", "IsRecommond", "IsFocus", "Dept", "IsDel", "OrderNum"};
private String[] DicKeys = {"Id", "Subject", "ImageInfo", "InfoDesc", "NewDate", "UserId", "UserType", "AttachIds", "VideoPath", "IsRecommond", "IsFocus", "Dept", "IsDel", "OrderNum"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "标题", "500", "text", ""}, {"string", "图片信息", "300", "hidden", ""}, {"string", "描述", "2000", "hidden", ""}, {"date", "创建时间", "0", "text", ""}, {"int", "发表人", "0", "UserName", ""}, {"string", "发表人类型", "1", "hidden", ""}, {"string", "相关附件ids", "200", "text", ""}, {"string", "视频", "200", "hidden", ""}, {"int", "是否推荐", "0", "YesNo", ""}, {"int", "是否置顶", "0", "YesNo", ""}, {"string", "发布部门", "50", "text", ""}, {"int", "是否删除", "0", "YesNo", ""}, {"int", "排序", "0", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Subject", "ImageInfo", "InfoDesc", "NewDate", "UserId", "UserType", "AttachIds", "VideoPath", "IsRecommond", "IsFocus", "Dept", "IsDel", "OrderNum"};
private String[] ListFields = {"Subject", "NewDate", "UserId"};
private String[] FormFields = {"Subject", "ImageInfo", "InfoDesc", "NewDate", "UserId", "AttachIds", "IsRecommond", "IsFocus", "Dept", "IsDel", "OrderNum"};
private String[] QueryFields = {"Subject", "ImageInfo", "NewDate", "UserId", "IsRecommond", "IsFocus"};
private String[] HideFields = {"Id"};
private Information getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Information v = new Information();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramSubject(request, "Subject");
        v.paramImageInfo(request, "ImageInfo");
        v.paramInfoDesc(request, "InfoDesc");
        v.paramNewDate(request, "NewDate");
        v.paramUserId(request, "UserId");
        v.paramUserType(request, "UserType");
        v.paramAttachIds(request, "AttachIds");
        v.paramVideoPath(request, "VideoPath");
        v.paramIsRecommond(request, "IsRecommond");
        v.paramIsFocus(request, "IsFocus");
        v.paramDept(request, "Dept");
        v.paramIsDel(request, "IsDel");
        v.paramOrderNum(request, "OrderNum");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        System.out.println("subject的长度"+ParamUtils.getParameter(request, "Subject", "").length());
        v.setSubject(ParamUtils.getParameter(request, "Subject", ""));
        v.setImageInfo(ParamUtils.getParameter(request, "ImageInfo", ""));
        v.setInfoDesc(ParamUtils.getParameter(request, "InfoDesc", ""));
        v.setNewDate(ParamUtils.getDateTimeParameter(request, "NewDate", java.sql.Date.valueOf("0001-01-01")));
        v.setUserId(ParamUtils.getIntParameter(request, "UserId", -1));
        v.setUserType(ParamUtils.getParameter(request, "UserType", ""));
        v.setAttachIds(ParamUtils.getParameter(request, "AttachIds", ""));
        v.setVideoPath(ParamUtils.getParameter(request, "VideoPath", ""));
        v.setIsRecommond(ParamUtils.getIntParameter(request, "IsRecommond", -1));
        v.setIsFocus(ParamUtils.getIntParameter(request, "IsFocus", -1));
        v.setDept(ParamUtils.getParameter(request, "Dept", ""));
        v.setIsDel(ParamUtils.getIntParameter(request, "IsDel", -1));
        v.setOrderNum(ParamUtils.getIntParameter(request, "OrderNum", -1));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Information pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map YesNomap = CEditConst.getYesNoMap(userInfo);
    Map UserNamemap = CEditConst.getUserNameMap(userInfo);
    Map  xy=CEditConst.getAcademyNameMap(userInfo);
    Map yonghu=CEditConst.getUserCnNameMap(userInfo);
    Map yonghu2=CEditConst.getUserNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Information v = (Information)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getSubject()));
        row.add(Tool.jsSpecialChars(v.getImageInfo()));
        row.add(Tool.jsSpecialChars(v.getInfoDesc()));
        row.add(Tool.stringOfDate(v.getNewDate()));
        row.add((String)yonghu.get(v.getUserId()+""));
        row.add(Tool.jsSpecialChars(v.getUserType()));
        row.add(Tool.jsSpecialChars(v.getAttachIds()));
        row.add(Tool.jsSpecialChars(v.getVideoPath()));
        String fabuyonghu=v.getDept();
	 
        row.add((String)YesNomap.get("" + v.getIsRecommond()));
        row.add((String)YesNomap.get("" + v.getIsFocus()));
       
        row.add((String)YesNomap.get("" + v.getIsDel()));
        row.add("" + v.getOrderNum());
   /*      BaseUserCode gonggaouser=userInfo.getUserCode(v.getUserId());
	    System.out.println(gonggaouser.getRoles());
		if(userInfo.hasFunPower(Power.STUSER)&&gonggaouser.getRoles().equals("4")&&v.getUserId()!=userInfo.getId()){
			
		}else{ */
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Information pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Information pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    BaseUserCode user = new BaseUserCode();
	 user=userInfo.getUserCode();
    String userDept=user.getRoles();
    System.out.println(userDept+"ddddddddddddd");
    if(userInfo.hasFunPower(Power.UserAdminPower)||userInfo.hasFunPower(Power.STUSER)){
    	cdt.add("dept in (1,"+user.getDeptId()+")");
    }
    String guanli=ParamUtils.getParameter(request, "guanli", "");
    System.out.println(guanli+"ddddddddddddd");
    if(guanli.equals("1")){
    	cdt.add("UserId ="+user.getId());
    }
    
    qval = ParamUtils.getParameter(request, "_Subject_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("subject like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_ImageInfo_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("imageinfo like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_NewDate_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
    	String start = qval + " 00:00:00";
    	
        cdt.add("newdate='" + qval + "'");
    }
    qval = ParamUtils.getParameter(request, "_UserId_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("userid=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_IsRecommond_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("isrecommond=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_IsFocus_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("isfocus=" + qval);
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
    request.setAttribute("DeptNameoptions", CEditConst.getDeptNameOptions(userInfo, "-1"));
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, "-1"));
    request.setAttribute("UserCnNameoptions", CEditConst.getUserCnNameOptions(userInfo,"-1"));
    request.setAttribute("YesNooptions", CEditConst.getYesNoOptions(userInfo, "-1"));
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
    Information pv = new Information();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Information");
    request.setAttribute("describe", "资讯信息");
    CEditConst.getAcademyNameOptions(userInfo);
    request.setAttribute("DeptNameoptions", CEditConst.getDeptNameOptions(userInfo, "-1"));
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Information pv = new Information();
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
private void setForm(javax.servlet.http.HttpServletRequest request, Information form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("YesNooptions", CEditConst.getYesNoOptions(userInfo, "-1"));
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, "-1"));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Information");
    request.setAttribute("describe", "资讯信息");
    request.setAttribute("DeptNameoptions", CEditConst.getDeptNameOptions(userInfo, "-1"));
    request.setAttribute("xyNameoptions", CEditConst.getAcademyNameOptions(userInfo));
    request.setAttribute("UserCnNameoptions", CEditConst.getUserCnNameOptions(userInfo,"-1"));
}
private List mkRtn(String cmd, String forward, Information form)
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
    Information form = getByParameterDb(request);
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
log.debug("InformationAction");
int currpage = ParamUtils.getIntParameter(request, "page", 1);
List rtn = null;
UserInfo userInfo = Tool.getUserInfo(request);
if (userInfo==null) {
    rtn = mkRtn("login", "login", null);
}
else {
	String tmp = ParamUtils.getParameter(request,"cmd","");
	if(tmp.equals("upPic")){
		String ImageInfo = ParamUtils.getParameter(request,"ImageInfo","");
		String fileElementId = ParamUtils.getParameter(request,"fileElementId","");
		if(!ImageInfo.equals("")){
			FileTool.delete(HeadConst.root_file_path+ImageInfo);
		}
		if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/frequency")){
			FileTool.createDir(HeadConst.root_file_path+"/main/upload/frequency");
		}
		CUploadFile cuf = new CUploadFile(fileElementId,new Date().getTime()+"","/main/upload/frequency/");
		cuf.setlimitSize(1024*1024L);
    	int flag = cuf.save(request);
    	if(flag==-1){//上传失败
	    	try{
	    		out.clear();
	    		out.print("{error:'上传失败',msg:''}");
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
    	}else if(flag ==0){
    		out.clear();
	    	out.print("{error:'图片大小超过1M不 能上传！',msg:''}");
    	}
    	else{//上传成功
    		try{
    			out.clear();
	    		out.print("{error:'',msg:'上传成功',url:'/main/upload/frequency/"+cuf.getSaveTotalName()+"'}");
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
    	}
    	return;
	}else if(tmp.equals("otherattach")){
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
    			attach.setAttachType(2);
    			//attach.setUploadType("application/msword");
    			attach.setUploadName(cuf.getRealName());
    			attach.setAttachSize(100);
    			attach.setUploadDate(new Date());
    			
    			attach.setGenerateName(cuf.getSavePath()+"/"+cuf.getSaveTotalName());
    			attach.setFromClass("volunter/VolunteerActivityAction.jsp");
    			attach.setFromTable("volunteer_activity");
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
		else{
			rtn = main(request);	
		}
    	
    }


String cmd = (String)rtn.get(0);
String forwardKey = (String)rtn.get(1);
request.setAttribute("fromBean", rtn.get(2));
Map forwardMap = new HashMap();
forwardMap.put("login", "logon.jsp");
forwardMap.put("list1", "InformationAction.jsp");
forwardMap.put("list", "InformationAction.jsp");
forwardMap.put("failure", "InformationForm.jsp");
forwardMap.put("success", "InformationList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "InformationForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='InformationAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>