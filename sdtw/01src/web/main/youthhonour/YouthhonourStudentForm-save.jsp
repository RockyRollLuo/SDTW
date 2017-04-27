<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.sdtw.db.YouthHonour"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.sdtw.db.ClubMembers"%>
<%@ page import="com.xietong.software.sdtw.club.CurrentSemester"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.sdtw.db.ClientAttach"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.common.CUploadFile"%>
<%@page import="com.xietong.software.common.FileTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%
UserInfo userInfo =Tool.getUserInfo(request);
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
%>
<%!
private synchronized int save(YouthHonour v ,HttpServletRequest request){
		int num = 0;
		
		Date currentDate=new Date();
		String currentSchoolyear=CurrentSemester.getSchoolYear(currentDate);
		UserInfo userInfo =Tool.getUserInfo(request);
		
		int Id = ParamUtils.getIntParameter(request, "Id", -1); 
		if(v.getById(Id)!=null){
			v = v.getById(Id);
		}
//         v.setSchoolYear(ParamUtils.getParameter(request, "SchoolYear", ""));
//         v.setAddaccount(ParamUtils.getParameter(request, "Addaccount", ""));
//         v.setAddtime(ParamUtils.getDateTimeParameter(request, "Addtime", java.sql.Date.valueOf("0001-01-01")));
	
		v.setSchoolYear(currentSchoolyear);
        v.setAddaccount(userInfo.getId()+"");//userid
        v.setAddtime(currentDate);

        v.setType(ParamUtils.getIntParameter(request, "Type", -1));
        v.setNoticeid(ParamUtils.getIntParameter(request, "Noticeid", -1));
        v.setAyCheckFlag(ParamUtils.getIntParameter(request, "AyCheckFlag", -1));
        v.setTwCheckFlag(ParamUtils.getIntParameter(request, "TwCheckFlag", -1));
        v.setModifyFlag(ParamUtils.getIntParameter(request, "ModifyFlag", -1));
        v.setXyReport(ParamUtils.getIntParameter(request, "XyReport", -1));
        v.setTwReport(ParamUtils.getIntParameter(request, "TwReport", -1));
        v.setXyCheckDate(ParamUtils.getDateTimeParameter(request, "XyCheckDate", java.sql.Date.valueOf("0001-01-01")));
        v.setTwCheckDate(ParamUtils.getDateTimeParameter(request, "TwCheckDate", java.sql.Date.valueOf("0001-01-01")));
        
//      	v.setBelongAcademy(ParamUtils.getParameter(request, "BelongAcademy", ""));
		v.setBelongAcademy(userInfo.getDeptId()+"");

        v.setAttachids(ParamUtils.getParameter(request, "Attachids", ""));
        v.setVal1(ParamUtils.getParameter(request, "Val1", ""));
        v.setVal2(ParamUtils.getParameter(request, "Val2", ""));
        v.setVal3(ParamUtils.getParameter(request, "Val3", ""));
        v.setVal4(ParamUtils.getParameter(request, "Val4", ""));
        v.setVal5(ParamUtils.getParameter(request, "Val5", ""));
        v.setVal6(ParamUtils.getParameter(request, "Val6", ""));
        v.setVal7(ParamUtils.getParameter(request, "Val7", ""));
        v.setVal8(ParamUtils.getParameter(request, "Val8", ""));
        v.setVal9(ParamUtils.getParameter(request, "Val9", ""));
        v.setVal10(ParamUtils.getParameter(request, "Val10", ""));
        v.setVal11(ParamUtils.getParameter(request, "Val11", ""));
        v.setVal12(ParamUtils.getParameter(request, "Val12", ""));
        v.setVal13(ParamUtils.getParameter(request, "Val13", ""));
        v.setVal14(ParamUtils.getParameter(request, "Val14", ""));
        v.setVal15(ParamUtils.getParameter(request, "Val15", ""));
        v.setVal16(ParamUtils.getParameter(request, "Val16", ""));
        v.setVal17(ParamUtils.getParameter(request, "Val17", ""));
        v.setVal18(ParamUtils.getParameter(request, "Val18", ""));
        v.setVal19(ParamUtils.getParameter(request, "Val19", ""));
        v.setVal20(ParamUtils.getParameter(request, "Val20", ""));
        v.setVal21(ParamUtils.getParameter(request, "Val21", ""));
        v.setVal22(ParamUtils.getParameter(request, "Val22", ""));
        v.setText1(ParamUtils.getParameter(request, "Text1", ""));
        v.setText2(ParamUtils.getParameter(request, "Text2", ""));
        v.setText3(ParamUtils.getParameter(request, "Text3", ""));
        v.setText4(ParamUtils.getParameter(request, "Text4", ""));
        v.setText5(ParamUtils.getParameter(request, "Text5", ""));
        v.setText6(ParamUtils.getParameter(request, "Text6", ""));
        
		if(v.getById(Id)==null){
			num = v.insert();
		}else{
			num = v.update();
		}
		return num;
	}//end save
%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");

String cmd = ParamUtils.getParameter(request,"cmd","");
int noticeid = ParamUtils.getIntParameter(request,"noticeid",-1);
//添加、更新
if("create".equals(cmd)||"update".equals(cmd)){
	YouthHonour v = new YouthHonour();
	int num = save(v,request);
		if(num>0){
			out.println("<script>alert('保存成功');window.location.href='YouthhonourStudentList.jsp?noticeid="+noticeid+"';</script>");
		}else{
			out.println("<script>alert('保存失败');window.location.href='YouthhonourStudentList.jsp?noticeid="+noticeid+"';</script>");
		}
	return;
}
//删除
if("delete".equals(cmd)){
	int id=ParamUtils.getIntParameter(request, "id", -1);
	YouthHonour v = new YouthHonour();
	if(id != -1&& v.getById(id)!=null){
		v = v.getById(id);
		int num = v.delete(id);
		if(num>0){
			out.println("<script>alert('删除成功');window.location.href='YouthhonourStudentList.jsp?noticeid="+noticeid+"';</script>");
		}else{
			out.println("<script>alert('删除失败');window.location.href='YouthhonourStudentList.jsp?noticeid="+noticeid+"';</script>");
		}
	}
	return;
}
//上报，提交
if("submit".equals(cmd)){
	int id = ParamUtils.getIntParameter(request,"id",-1);
	YouthHonour v = new YouthHonour();
	if(id!=-1&&v.getById(id)!=null){
		v = v.getById(id);
	}
	v = v.getById(id);
	
	v.setModifyFlag(SdtwConst.MODIFY_YTJ);//已提交
	
	int num = v.update();
	if(num>0){
		out.println("<script>alert('提交成功');window.location.href='YouthhonourStudentList.jsp?noticeid="+noticeid+"';</script>");
	}else{
		out.println("<script>alert('操作失败');window.location.href='YouthhonourStudentList.jsp?noticeid="+noticeid+"';</script>");
	}
	return;
}	
//申请修改
if("applymodify".equals(cmd)){
	int id = ParamUtils.getIntParameter(request,"id",-1);
	YouthHonour v = new YouthHonour();
	if(id!=-1&&v.getById(id)!=null){
		v = v.getById(id);
	}
	v = v.getById(id);
	
	v.setModifyFlag(SdtwConst.MODIFY_SQXG);//申请修改
	
	int num = v.update();
	if(num>0){
		out.println("<script>alert('申请成功,等待学院审核');window.location.href='YouthhonourStudentList.jsp?noticeid="+noticeid+"';</script>");
	}else{
		out.println("<script>alert('提交失败');window.location.href='YouthhonourStudentList.jsp?noticeid="+noticeid+"';</script>");
	}
	return;
}


//附件
String tmp = ParamUtils.getParameter(request,"cmd","");
List rtn = null;
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
			attach.setAttachType(2);
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
//end 附件
//pic
if(tmp.equals("upPic")){
	String Attachids = ParamUtils.getParameter(request,"Attachids","");
	String fileElementId = ParamUtils.getParameter(request,"fileElementId","");
	Calendar c = Calendar.getInstance();
	if(!Attachids.equals("")){
		FileTool.delete(HeadConst.root_file_path+Attachids);
	}
	if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR))){
		FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR));
	}
	 if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1))){
		FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
	}  
	CUploadFile cuf = new CUploadFile(fileElementId,new Date().getTime()+"","/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
	cuf.setlimitSize(1024*1024*3L);
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
    	out.print("{error:'图片大小超过3M不 能上传！',msg:''}");
   	}
   	else{//上传成功
   		try{
   			out.clear();
   			//System.out.println(cuf.getSaveTotalName());
    		out.print("{error:'',msg:'上传成功',url:'/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+cuf.getSaveTotalName()+"'}");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
   	}
   	return;
}
//end pic

%>