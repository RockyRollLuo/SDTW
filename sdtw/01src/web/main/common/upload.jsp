<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.common.CUploadFile"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.common.FileTool"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.sdtw.db.ClientAttach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String cmd = ParamUtils.getParameter(request,"cmd","");
//只保留最新一条
if(cmd.equals("otherattach")){
    String fileElementId = ParamUtils.getParameter(request,"fileElementId","");
    int AttachType = ParamUtils.getIntParameter(request,"AttachType",-1);
    String FromTable = ParamUtils.getParameter(request,"FromTable","");
    int RelationId = ParamUtils.getIntParameter(request,"RelationId",-1);
	Calendar c = Calendar.getInstance();
	if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR))){
		FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR));
	}
	 if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1))){
		FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
	}  
	CUploadFile cuf = new CUploadFile(fileElementId,new Date().getTime()+"","/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
	cuf.setlimitSize(1024*1024*10L);
	//InputStream is = cuf.saveFileStream(request);
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
	}else{//上传成功
		try{
			ClientAttach attach = new ClientAttach();
			List cdt = new ArrayList();
			cdt.add("RelationId="+RelationId);
			attach.deleteByCondition(cdt);			
		//	attach.setDataBase("tuanwei");
			attach.setAttachType(AttachType);
			//attach.setUploadType("application/msword");
			attach.setUploadName(cuf.getRealName());
			attach.setAttachSize(100);
			attach.setUploadDate(new Date());
			
			attach.setGenerateName(cuf.getSavePath()+"/"+cuf.getSaveTotalName());
			//attach.setFromClass("student/upload");
			attach.setFromTable(FromTable);
			attach.setRelationId(RelationId);
			if(attach.insert()>0){
				out.clear();
				out.print("{\"name\":\""+cuf.getRealName()+"\",\"error\":\"\",\"ids\":\""+attach.getId()+"\",\"msg\":\"上传成功\",\"url\":\"/main/upload/jspj/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+cuf.getSaveTotalName()+"\"}");
    		}else{
    			out.clear();
    			out.print("{error:'上传失败',msg:''}");
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	return;
}
if(cmd.equals("otherattachAll")){
    String fileElementId = ParamUtils.getParameter(request,"fileElementId","");
    int AttachType = ParamUtils.getIntParameter(request,"AttachType",-1);
    String FromTable = ParamUtils.getParameter(request,"FromTable","");
    int RelationId = ParamUtils.getIntParameter(request,"RelationId",-1);
	Calendar c = Calendar.getInstance();
	if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR))){
		FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR));
	}
	 if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1))){
		FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
	}  
	CUploadFile cuf = new CUploadFile(fileElementId,new Date().getTime()+"","/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
	cuf.setlimitSize(1024*1024*10L);
	//InputStream is = cuf.saveFileStream(request);
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
	}else{//上传成功
		try{
			ClientAttach attach = new ClientAttach();
			List cdt = new ArrayList();
			attach.setAttachType(AttachType);
			attach.setUploadName(cuf.getRealName());
			attach.setAttachSize(100);
			attach.setUploadDate(new Date());
			
			attach.setGenerateName(cuf.getSavePath()+"/"+cuf.getSaveTotalName());
			attach.setFromClass("student/upload");
			//attach.setFromTable(FromTable);
			attach.setRelationId(RelationId);
			if(attach.insert()>0){
				out.clear();
				out.print("{\"name\":\""+cuf.getRealName()+"\",\"error\":\"\",\"ids\":\""+attach.getId()+"\",\"msg\":\"上传成功\",\"url\":\"/main/upload/jspj/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+cuf.getSaveTotalName()+"\"}");
    		}else{
    			out.clear();
    			out.print("{error:'上传失败',msg:''}");
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	return;
}
if(cmd.equals("delAttach")){
	int tmpid = ParamUtils.getIntParameter(request,"did",-1);
	if(tmpid != -1){
		List cdt = new ArrayList();
		cdt.add("id="+tmpid);
		ClientAttach ca = new ClientAttach();
		ca.deleteByCondition(cdt);
		out.print("{\"error\":\"\",\"msg\":\"删除成功\"}");
	}
	else{
		out.print("{error:'删除失败',msg:''}");
	}
	return;
}
%>