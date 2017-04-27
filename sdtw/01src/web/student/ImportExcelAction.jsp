<%@page import="com.xietong.software.sdtw.db.ChuangkuDeclareMembers"%>
<%@page import="com.xietong.software.sdtw.db.ChuangkuDeclare"%>
<%@page import="com.xietong.software.sdtw.user.UserCodeUtil"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@ page language="java" %>
<%--人员管理--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.db.VolunteerZhikuDeclare"%>
<%@ page import="com.xietong.software.sdtw.db.VolunteerZhikuTeammember"%>
<%@ page import="com.xietong.software.sdtw.db.ChuangkuDeclare"%>
<%@ page import="com.xietong.software.sdtw.db.ChuangkuDeclareMembers"%>
<%@ page import="com.xietong.software.sdtw.ImportExcelUtil"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*"%>
<%!
	public int zhikuTeamList(){
		int retval=0;
		List<VolunteerZhikuDeclare> list=new ArrayList<VolunteerZhikuDeclare>();
		List cdt=new ArrayList();
		VolunteerZhikuDeclare vzd=new VolunteerZhikuDeclare();
		cdt.clear();
		list=vzd.query(cdt);
		
		ImportExcelUtil ieutil=new ImportExcelUtil();
		Map snoToidMap=ieutil.getSnoToIdMap();
		
		for(int i=0;i<list.size();i++){
			String teamlist=(list.get(i)).getAddfilelist();
			int zhikuid=(list.get(i)).getId();//申请表id
			
			try{
				String[] teamary=teamlist.split(",");
				for(int j=0;j<teamary.length;j++){
					System.out.println("---学生："+teamary[j]);
					String[] oneStuAry=(teamary[j]).split("\\|");
					
// 					for(int k=0;k<oneStuAry.length;k++){
// 						System.out.println(oneStuAry[k]);
// 					}
					
// 					String name=oneStuAry[0];
// 					String sex=oneStuAry[1];
// 					String academy=oneStuAry[2];
// 					String grade=oneStuAry[3];
					String sno=""+snoToidMap.get(oneStuAry[4]);
					String phone=oneStuAry[5];
					String duty=oneStuAry[6];
					
					VolunteerZhikuTeammember vzt=new VolunteerZhikuTeammember();
					vzt.setZhikuDeclareId(zhikuid);
// 					vzt.setName(name);
// 					vzt.setSex(sex);
// 					vzt.setAcademy(academy);
// 					vzt.setGrade(grade);
					vzt.setSno(sno);
					vzt.setPhone(phone);
					vzt.setDuty(duty);
					
					int num=0;
					num=vzt.insert();
					if(num>0){
						System.out.println("---第"+(i+1)+"条 第"+j+"个成员录入成功--");
					}else{
						System.out.println("---！！！第"+(i+1)+"条 第"+(j+1)+"个成员录入失败--");
					}
				}
			}catch(Exception ex){
				System.out.println("---第"+(i+1)+"条 录入失败--");
			}
			
		}
		return retval;
	}
	
	public int chuangkuTeamList(){
		int retval=0;
		List<ChuangkuDeclare> list=new ArrayList<ChuangkuDeclare>();
		List cdt=new ArrayList();
		ChuangkuDeclare ckd=new ChuangkuDeclare();
		cdt.clear();
		list=ckd.query(cdt);
		
		ImportExcelUtil ieutil=new ImportExcelUtil();
		Map snoToidMap=ieutil.getSnoToIdMap();
		Map academyMap=ieutil.getAcademyNameMap();
		
		for(int i=0;i<list.size();i++){
			String teamlist=(list.get(i)).getAddFilelist();
			int chuangkuid=(list.get(i)).getId();//申请表id
			
			try{
				String[] teamary=teamlist.split(",");
				for(int j=0;j<teamary.length;j++){
					System.out.println("---学生："+teamary[j]);
					String[] oneStuAry=(teamary[j]).split("\\|");
					
// 					for(int k=0;k<oneStuAry.length;k++){
// 						System.out.println(oneStuAry[k]);
// 					}
					
// 					String name=oneStuAry[0];
// 					String sex=oneStuAry[1];
// 					String academy=oneStuAry[2];
// 					String grade=oneStuAry[3];
					String name=oneStuAry[0];
					String academyid=""+academyMap.get(oneStuAry[1]);
					String sno=oneStuAry[2];
					String tel=oneStuAry[3];
					
					try{
						name=""+snoToidMap.get(oneStuAry[2]);
					}catch(Exception exs){
						System.out.println("---存研究生---");
						name=oneStuAry[0];
					}
					
					ChuangkuDeclareMembers cdm=new ChuangkuDeclareMembers();
					cdm.setChuangkuDeclareId(chuangkuid);
					cdm.setSno(sno);
					cdm.setName(name);
					cdm.setTel(tel);
					cdm.setAcademy(academyid);
					cdm.setDuty("成员");
					
					int num=0;
					num=cdm.insert();
					if(num>0){
						System.out.println("---第"+(i+1)+"条 第"+j+"个成员录入成功--");
					}else{
						System.out.println("---！！！第"+(i+1)+"条 第"+(j+1)+"个成员录入失败--");
					}
				}
			}catch(Exception ex){
				System.out.println("---第"+(i+1)+"条 录入失败--");
			}
			
		}
		return retval;
	}
 %>
<%

response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");

String tmp = ParamUtils.getParameter(request,"cmd","");
if(tmp.equals("upLoadFile")){
	String fileElementId = ParamUtils.getParameter(request,"fileElementId","");
	String filePath=HeadConst.root_file_path+"student/upload";
	if(!FileTool.exists(filePath)){
		FileTool.createDir(filePath);
	}
	CUploadFile cuf = new CUploadFile(fileElementId,new Date().getTime()+"","/student/upload");
	//cuf.setlimitSize(1024*1024L);
	int flag = cuf.save(request);
	if(flag==-1){//上传失败
    	try{
    		out.clear();
    		out.print("{error:'上传失败',msg:''}");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	else{//上传成功
		try{
		    		String fileUpPath=filePath+"/"+cuf.getSaveTotalName();
		    		ImportExcelUtil ieutil=new ImportExcelUtil();
		    		System.out.println("---------开始读文件了-----------------------");
		    		List resStr=ieutil.readExcel(fileUpPath,request);
		    		String outStr="";
		    		for(int i=resStr.size()-1;i>=0;i--){ //倒序取出
		    			String str=(String)resStr.get(i);
		    			outStr+=str+"<br/>";
		    		} 
		    		out.clear();
		    		out.print("{error:'',msg:'文件上传成功',outstr:'"+outStr+"'}");
		    	}catch(Exception e){
		    		e.printStackTrace();
		    	}
	}
}

if(tmp.equals("dataProcess")){
	System.out.println("---------开始处理 文件了-----------------------");
	int num=0;
// 	num=zhikuTeamList();
	num=chuangkuTeamList();
}

%>
