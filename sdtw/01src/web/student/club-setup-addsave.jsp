<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.sdtw.XtUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.xietong.software.sdtw.db.Academy"%>
<%@page import="com.xietong.software.sdtw.db.Grade"%>
<%@page import="com.xietong.software.sdtw.db.ClubTeacher"%>
<%@page import="com.xietong.software.sdtw.db.ClubMembers"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.sdtw.db.ClientAttach"%>
<%@page import="com.xietong.software.common.FileTool"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.util.Base64.InputStream"%>
<%@page import="com.xietong.software.common.CUploadFile"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.sdtw.db.Club"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%
UserInfo ui = Tool.getUserInfo(request);
UserInfo userInfo =null;
if(ui.hasFunPower(Power.USERSTUDENTPOWER)){
	userInfo = ui;
}
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}%>
<%!
private synchronized int save(Club v ,HttpServletRequest request){
	UserInfo userinInfo = Tool.getUserInfo(request);
	int Id = ParamUtils.getIntParameter(request, "Id", -1);
	String City = ParamUtils.getParameter(request,"City","-1");
	String ClubName = ParamUtils.getParameter(request,"ClubName","-1");
	String ClubType = ParamUtils.getParameter(request,"ClubType","-1");
	String Chairman = ParamUtils.getParameter(request,"Chairman","-1");
	String Academy = ParamUtils.getParameter(request,"Academy","-1");
	String Teacher = ParamUtils.getParameter(request,"Teacher","-1");
	String Clubqq = ParamUtils.getParameter(request,"Clubqq","");
	String ClubeMail = ParamUtils.getParameter(request,"ClubeMail","");
	String ClubPubAccount = ParamUtils.getParameter(request,"ClubPubAccount","");
	String Tenet = ParamUtils.getParameter(request,"Tenet","");
	String ClubProfile = ParamUtils.getParameter(request,"ClubProfile","");
	String AddFileList = ParamUtils.getParameter(request,"AddFileList","");
	//String SId = ParamUtils.getParameter(request,"SId","");//发起人ids
	String Feasibility = ParamUtils.getParameter(request,"Feasibility","");
	String CommentTea = ParamUtils.getParameter(request,"CommentTea","");
	int num = 0;
	if(v.getById(Id)!=null){
		v = v.getById(Id);
		if(SdtwConst.CHECKFLAG_XXWTG.equals(v.getCheckFlag())) {
			v.setCheckFlag(SdtwConst.CHECKFLAG_XYTG);
		}
	}
	v.setCity(City);
	v.setClubName(ClubName);
	v.setClubType(ClubType);
	v.setChairman(Chairman);
	v.setAcademy(Academy);
	v.setTeacher(Teacher);
	v.setClubqq(Clubqq);
	v.setClubeMail(ClubeMail);
	v.setClubPubAccount(ClubPubAccount);
	v.setTenet(Tenet);
	v.setClubProfile(ClubProfile);
	v.setAddFileList(AddFileList);
	//v.setSponsor(SId);存clubmeber的id
	v.setFeasibility(Feasibility);
	v.setCommentTea(CommentTea);
	 v.setRecruitmentStart(ParamUtils.getDateTimeParameter(request, "RecruitmentStart", java.sql.Date.valueOf("0001-01-01")));
     v.setRecruitmentStop(ParamUtils.getDateTimeParameter(request, "RecruitmentStop", java.sql.Date.valueOf("0001-01-01")));
	if(v.getById(Id)==null){
		UserInfo ui = Tool.getUserInfo(request);
		UserInfo userInfo =null;
		if(ui.hasFunPower(Power.USERSTUDENTPOWER)){
			userInfo = ui;
		}
		v.setAddPerson(ui.getId()+"");
		num = v.insert();
	}else{
		num = v.update();
	}
	
	 /**保存本科生*/
    List cdt = new ArrayList();
    ClubMembers member = new ClubMembers();
     String SId = ParamUtils.getParameter(request,"SId","");
    Map<String,ClubMembers> map = new HashMap<String,ClubMembers>();
    if (SId.length()>0) {
    	
   	cdt.clear();
    cdt.add("MemberClubname="+v.getId());
    cdt.add("Identity=0");//本科
    cdt.add("MemberName not in("+SId+")");
    member.deleteByCondition(cdt);
    
    List list = new ArrayList();
    cdt.clear();
    cdt.add("MemberClubname="+v.getId());
    cdt.add("Identity=0");//本科
    cdt.add("MemberName in("+SId+")");
    list = member.query(cdt);
    if (list.size()>0) {
    	for (int i=0;i<list.size();i++) {
    		member = (ClubMembers)list.get(i);
    		map.put(member.getMemberName(),member);
    	}
    }
    String sidArr[] = SId.split(",");
    cdt.clear();
    cdt.add("id in("+SId+")");
    Map userMap = XtUtil.getBeanMapByCdt(cdt, BaseUserCode.class);
    for (int i=0;i<sidArr.length;i++) {
    	String SName = ParamUtils.getParameter(request,"SName"+sidArr[i],"");
    	String Sno = ParamUtils.getParameter(request,"Sno"+sidArr[i],"");
    	String Sex = ParamUtils.getParameter(request,"Sex"+sidArr[i],"");
    	//String Academy = ParamUtils.getParameter(request,"Academy"+sidArr[i],"");
    	//String Grade = ParamUtils.getParameter(request,"Grade"+sidArr[i],"");
    	//String IdCard = ParamUtils.getParameter(request,"IdCard"+sidArr[i],"");
    	//String Address = ParamUtils.getParameter(request,"Address"+sidArr[i],"");
    	String Phone = ParamUtils.getParameter(request,"Phone"+sidArr[i],"");
    	String Duty = ParamUtils.getParameter(request,"Duty"+sidArr[i],"");
    	ClubMembers team = new ClubMembers();
    	BaseUserCode user = (BaseUserCode)userMap.get(sidArr[i]);
    	if (map.get(SName)!=null) {
    		team = map.get(SName);
    	}
    	System.out.println(v.getId());
    	team.setMemberClubname(v.getId()+"");//社团id
    	team.setMemberSno(user.getName());
    	team.setMemberName(user.getId()+"");
    	team.setMemberSex(user.getGender()+"");
    	team.setMemberAcademy(user.getDeptId()+"");
    	team.setMemberGrade(user.getGrade());
    	team.setIdentity("0");
    	//team.setIdCard(IdCard);
    	//team.setAddress(Address);
    	team.setMemberPhone(Phone);
    	team.setMemberDuty(Duty);
    	team.setCheckFlag(1);
    	team.setManagerGeneration(1);
    	team.setAddTime(new Date());
    	team.setIsManager("0");
    	team.setApplyTime(new Date());
    	if (map.get(SName) ==null) {
    		team.setAddPerson(userinInfo.getId()+"");
        	team.insert();
    	} else {
        	team.update();
    	}
    }
    } else {
    	String cmd = ParamUtils.getParameter(request,"cmd","");
    	if ("update".equals(cmd)) {
    	cdt.clear();
        cdt.add("MemberClubname="+v.getId());
        cdt.add("Identity=0");//本科
        member.deleteByCondition(cdt);
    	}
    }
    map.clear(); 
	/**保存本科生**/
	/**保存研究生**/
	 /**保存研究生**/
        String Nums = ParamUtils.getParameter(request,"Nums","");
        if (Nums.length()>0) {
	     //   Nums = XtUtil.getIdsStr(Nums);
        	ClubMembers team = new ClubMembers();
        	List teamids = new ArrayList();
        	String NumsArr[] = Nums.split(",");
        	for (int i=0;i<NumsArr.length;i++) {
        		int Id_t = ParamUtils.getIntParameter(request,"Id_t"+NumsArr[i],-1);
        		teamids.add(Id_t+"");
        	}
        	cdt.clear();
        	cdt.add("id not in("+Tool.join(",",teamids)+")");
        	cdt.add("Identity=1");//学历
        	cdt.add("MemberClubname="+v.getId());
        	team.deleteByCondition(cdt);
        	for (int i=0;i<NumsArr.length;i++) {
        		String j = NumsArr[i];
        		int Id_t = ParamUtils.getIntParameter(request,"Id_t"+NumsArr[i],-1);
        		String Sno = ParamUtils.getParameter(request,"Sno_t"+NumsArr[i],"");
        		String SName = ParamUtils.getParameter(request,"SName_t"+NumsArr[i],"");
        		String Sex = ParamUtils.getParameter(request,"Sex_t"+NumsArr[i],"");
        		String Academy_t = ParamUtils.getParameter(request,"Academy_t"+NumsArr[i],"");
        		String Identity = ParamUtils.getParameter(request,"Identity_t"+NumsArr[i],"");// 学历
        		String Grade = ParamUtils.getParameter(request,"Grade_t"+NumsArr[i],"");
        		String Phone = ParamUtils.getParameter(request,"Phone_t"+NumsArr[i],"");
        		String Duty = ParamUtils.getParameter(request,"Duty_t"+NumsArr[i],"");//0队长1成员
        		if(Id_t!=-1) {
        			team = team.getById(Id_t);
        		}
        		team.setMemberClubname(v.getId()+"");//社团id
            	team.setMemberSno(Sno);
            	team.setMemberName(SName);
            	team.setMemberSex(Sex);
            	team.setMemberAcademy(Academy);
            	team.setMemberGrade(Grade);
            	team.setIdentity("1");
            	//team.setIdCard(IdCard);
            	//team.setAddress(Address);
            	team.setMemberPhone(Phone);
            	team.setMemberDuty(Duty);
            	team.setManagerGeneration(1);
            	team.setCheckFlag(1);
            	team.setAddTime(new Date());
            	team.setIsManager("0");
            	team.setApplyTime(new Date());
        		if(Id_t!=-1) {
        			team.update();
        		} else {
        			team.setAddPerson(userinInfo.getId()+"");
        			team.insert();
        		}
        	}
        }else {
        	String cmd = ParamUtils.getParameter(request,"cmd","");
        	if ("update".equals(cmd)) {
        	cdt.clear();
	        cdt.add("Identity=1");//学历
        	cdt.add("MemberClubname="+v.getId());
	        ClubMembers team = new ClubMembers();
	        team.deleteByCondition(cdt);
        	}
        }
	/**保存研究生**/
        List sids = new ArrayList();
        List list2 = new ArrayList();
        cdt.clear();
        ClubMembers team = new ClubMembers();
        cdt.add("MemberClubname="+v.getId());
        cdt.add("ManagerGeneration=1");
        cdt.add("CheckFlag=1");
        list2 = team.query(cdt);
        if(list2.size()>0)
        	for(int i=0;i<list2.size();i++) {
        		team = (ClubMembers)list2.get(i);
        		sids.add(team.getId()+"");
        	}
        if(sids.size()>0){
       	 v.setSponsor(Tool.join(",",sids));
        }else{
        	v.setSponsor("");
        }
        v.update();
	return num;
}
private synchronized int shangbao(Club v ,HttpServletRequest request){
	if(SdtwConst.CHECKFLAG_XXWTG.equals(v.getCheckFlag())) {
		v.setCheckFlag(SdtwConst.CHECKFLAG_XYTG);
	}else{
		v.setCheckFlag(SdtwConst.CHECKFLAG_SB);
	}
	int num = v.update();
	return num;
}
%>
<%
String cmd = ParamUtils.getParameter(request,"cmd","list");
if("save".equals(cmd)||"update".equals(cmd)){
	Club club = new Club();
	int num = 0;
	num = save(club,request);
	if(num>0)
	response.sendRedirect(HeadConst.apache_url+"/student/club-setup-list.jsp");
	return;
}
if("shangbao".equals(cmd)){
	int id = ParamUtils.getIntParameter(request,"id",-1);
	Club club = new Club();
	if(id!=-1&&club.getById(id)!=null){
		club = club.getById(id);
	}
	club = club.getById(id);
	int num = shangbao(club,request);
	if(num>0)
	response.sendRedirect(HeadConst.apache_url+"/student/club-setup-list.jsp");
	return;
}
if(cmd.equals("otherattach")){
    String fileElementId = ParamUtils.getParameter(request,"fileElementId","");
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
			attach.setDataBase("tuanwei");
			attach.setAttachType(0);
			//attach.setUploadType("application/msword");
			attach.setUploadName(cuf.getRealName());
			attach.setAttachSize(100);
			attach.setUploadDate(new Date());
			
			attach.setGenerateName(cuf.getSavePath()+"/"+cuf.getSaveTotalName());
			attach.setFromClass("student/club-setup-addsave");
			attach.setFromTable("club");
			
			
			
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
if(cmd.equals("del")){
	int id = ParamUtils.getIntParameter(request,"id",-1);
	Club club = new Club();
	if(id != -1&& club.getById(id)!=null){
		club = club.getById(id);
		int num = club.delete(id);
		if(num>0){
			//response.sendRedirect(HeadConst.apache_url+"/student/club-setup-list.jsp");
			out.println("<script>alert('删除成功');window.location='club-setup-list.jsp';</script>");
		}
	}
	return;
}
if (cmd.equals("checkSave")) {
	int id = ParamUtils.getIntParameter(request,"id",-1);
	List cdt = new ArrayList();
	ClubMembers m = new ClubMembers();
	cdt.add("memberClubname="+id);
	cdt.add("ismanager=1");
	cdt.add("checkflag=1");
	int num = m.getCount(cdt);
	cdt.clear();
	ClubTeacher t = new ClubTeacher();
	cdt.add("clubname="+id);
	int num2 = t.getCount(cdt);
	if (num>0&&num2>0) {
		out.print("{\"msg\":\"ok\"}");
	} else if(num<1){
		out.print("{\"msg\":\"fzrno\"}");
	} else if (num2<1) {
		out.print("{\"msg\":\"jsno\"}");
	}
	return;
}
//String cmd = ParamUtils.getParameter(request,"cmd","");
if("AcademyOptions".equals(cmd)){
	Academy v = new Academy();
	List cdt = new ArrayList();
	List list = new ArrayList();
	cdt.add("flag=1");
	list = v.query(cdt);
	StringBuffer sb = new StringBuffer();
	sb.append("<option value=-1></option>");
	if (list.size()>0) {
		for (int i=0;i<list.size();i++) {
			v = (Academy)list.get(i);
			sb.append("<option value="+v.getId()+">"+v.getAcademyName()+"</option>");
		}
	}
	out.print(sb.toString());
	return;
}
if("GradeOptions".equals(cmd)){
	Grade v = new Grade();
	List cdt = new ArrayList();
	List list = new ArrayList();
	//cdt.add("isEnable=1");
	list = v.query(cdt);
	StringBuffer sb = new StringBuffer();
	sb.append("<option value=-1></option>");
	if (list.size()>0) {
		for (int i=0;i<list.size();i++) {
			v = (Grade)list.get(i);
			sb.append("<option value="+v.getId()+">"+v.getName()+"</option>");
		}
	}
	out.print(sb.toString());
	return;
}
%>