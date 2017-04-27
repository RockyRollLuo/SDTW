<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.youthhonour.YouthhonourUtil"%>
<%@ page import="com.xietong.software.sdtw.db.YouthHonour"%>
<%@ page import="com.xietong.software.sdtw.db.Academy"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="com.xietong.software.base.Power"%>
<%@ page import="com.xietong.software.base.SdtwConst"%>
<%@ page import="java.io.*,java.util.*"%>

<%
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	YouthhonourUtil yhUtil=new YouthhonourUtil();
	
	//noticeid
	int noticeid=ParamUtils.getIntParameter(request, "noticeid",-1);
	Youthhonour_notice yhNotice=new Youthhonour_notice();
	yhNotice=yhNotice.getById(noticeid);
	
	//academyMap
	Map academyMap=CEditConst.getAcademyNameMap(userInfo);
	//Map<type,List<YouthHonour>>,Map<type,Map<academyidstr,List<YouthHonour>>>
	Map youthhonourNameMap=yhUtil.youthhonourName;
	Map youthhonourByTypeMap=yhUtil.getYouthhonourListByType(noticeid);
	Map<Integer,Map<String,List<YouthHonour>>> youthhonourMap=yhUtil.getYouthhonourByXyByType(noticeid,userInfo);
	
	//
	String space4="&nbsp;&nbsp;&nbsp;&nbsp;";
	String space2="&nbsp;&nbsp;";
	Date currentDate=new Date();
	String year=currentDate.toLocaleString().substring(0,4);
%>
<head>
	<title>五四表彰公示文件</title>
	<script>
	function printword(){
    	var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
  		if ((userAgent.indexOf("compatible")>-1 && userAgent.indexOf("MSIE")>-1)|| userAgent.indexOf("Trident")>-1){
			IEPrint();
   		}else{
   			alert("请使用IE浏览器！");
   		}
	}
	
	function IEPrint(){
		try{
	        ExcelSheet = new ActiveXObject("word.Application");   
	   	 	ExcelSheet.Application.Visible = true;   
	    	var orgNum=ExcelSheet.Documents.Add('',0,1);   
	       	myRange =orgNum.Range(0,1);  
	        sel=parent.document.body.createTextRange();   
	    	oTblExport = parent.document.getElementById("theObjTable");   
	    	if (oTblExport != null) {   
	        	sel.moveToElementText(oTblExport);   
	        	sel.execCommand('Copy');   
	        	parent.document.body.blur();   
	        	myRange.Paste();   
	    	}   
		}catch(err){
			alert("设置IE:工具-Internet选项-安全-选择‘Internet’自定义级别-启用‘对标记为可安全执行的ActiveX控件执行脚本’、‘对未标记为可安全执行脚本的ActiveX控件初始化并执行’、运行ActiveX控件和插件");
		}
	}
	</script>
	<style type="text/css">
body{
	background:#fff;
	font-color:#000;
}
#theObjTable{
	background:#fff;
	font-size:15pt;
	font-family:仿宋_GB2312;
}
p{
	line-height:150%;
}
.title{
	font-size:16pt;
	line-height:150%;
	text-align:left;
	padding-top:-20px;
	padding-bottom:-20px;
}
.title1{
	font-size:18pt;
	line-height:150%;
	font-family:黑体;
	text-align:left;
}
.title2{
	font-size:16pt;
	line-height:150%;
	font-family:黑体;
	text-align:center;
}
.title3{
	font-size:16pt;
	line-height:150%;
	font-family:黑体;
	text-indent:0cm;
	text-align:justify;
	text-justify:inter-ideograph;
}
.title4{
	font-size:16pt;
	line-height:150%;
	font-family:楷体;
	text-indent:0cm;
	text-align:justify;
	text-justify:inter-ideograph;
}
.item{
	font-size:15pt;
	line-height:150%;
	font-family:仿宋_GB2312;
	text-align:justify;
	text-justify:inter-ideograph;
}
.itemname{   
	width:60px;
	font-size:15pt;
	line-height:150%;
	font-family:仿宋_GB2312;
	text-align:justify;
	text-justify:kashida;
}	
	</style>
</head>
<body>
	<div align="center"><button onclick="printword()">打印</button></div>
	
	<div id="theObjTable">
<p><span class="title1">主题词：五四<%=space4%>表彰<%=space4%>决定</span></p>
<p><span class="title">共青团山东大学委员会 <%=space4%><span id="printtime"></span>印发</span></p>


<!-- -----------------------------------------附件1 红旗团委 优秀青年工作者----------------------------------------------->
<p>附件1:</p>
<p class="title2"><%=year%><%=youthhonourNameMap.get(1)%></p>
<p class="title2">优秀青年工作者<%=space2%>名单</p>
<%		
Map map1=youthhonourMap.get(1);
if(map1!=null)
for(Iterator it1=map1.keySet().iterator();it1.hasNext();){
	String academyid=(String)it1.next();
	List list1=(List)map1.get(academyid);
	if(list1!=null)
	for(int i=0;i<list1.size();i++){
	%>
		<p class="item"><%=space2%><%=academyMap.get(academyid)%></p>
	<%
	}
}
	List list12=(List)youthhonourByTypeMap.get(1);
	if(list12!=null){
	%>
	<p class="item"><%=space2%>同时授予
	<%	
	for(int i=0;i<list12.size();i++){	
		if(i!=(list12.size()-1)){
			%><%=((YouthHonour)list12.get(i)).getVal1()%>，<%
		}else{
			%><%=((YouthHonour)list12.get(i)).getVal1()%><%
		}
	}
	%>
	<%=list12.size()%>位同志为“山东大学优秀青年工作者”荣誉称号。</p>
	<%}%>
<br/>
<br/>
<br/>
<br/>
<!-- -----------------------------------------附件2 十佳团支部 先进团支部（按学院）------------------------------------------------>
<p>附件2:</p>
<p class="title2"><%=year%><%=youthhonourNameMap.get(2)%><%=space2%>名单</p>
<p class="title3">一、十佳团支部</p>
<%
List list2=(List)youthhonourByTypeMap.get(2);
if(list2!=null)
for(int i=0;i<list2.size();i++){
%>
	<p class="item"><%=((YouthHonour)list2.get(i)).getVal1()%></p>
<%
}
%>
<p class="title3">二、先进团支部</p>
<%
Map map2=youthhonourMap.get(3);//map2:Map<(String)academyid,List<YouthHonour>>
if(map2!=null)
for(Iterator it2=map2.entrySet().iterator();it2.hasNext();){
	String academyid=String.valueOf(it2.next());
	List list21=(List)map2.get(academyid);
	
	%><p class="title4"><%=academyMap.get(academyid)%>:</p><%
		
	if(list21!=null)
	for(int i=0;i<list21.size();i++){
		%><p class="item"><%=((YouthHonour)list21.get(i)).getVal1()%></p><%
	}
}//end while 
%>
<br/>
<br/>
<br/>
<br/>
<!-- -----------------------------------------附件3 十佳共青团员------------------------------------------------>
<p>附件3:</p>
<p class="title2"><%=year%><%=youthhonourNameMap.get(11)%></p>
<%
List list3=(List<YouthHonour>)youthhonourByTypeMap.get(11);
if(list3!=null)
for(int i=0;i<list3.size();i++){
%>
	<p><span class="itemname"><%=((YouthHonour)list3.get(i)).getVal1()%></span></p>
<%
}
%>
<br/>
<br/>
<br/>
<br/>
<!-- -----------------------------------------附件4 青年文明号 青年岗位能手------------------------------------------------>
<p>附件4:</p>
<p class="title2"><%=year%><%=youthhonourNameMap.get(4)%></p>
<p class="title2"><%=youthhonourNameMap.get(15)%></p>
<p class="title3">一、青年文明号</p>
<%
List list41=(List<YouthHonour>)youthhonourByTypeMap.get(4);
if(list41!=null)
for(int i=0;i<list41.size();i++){
	%><p class="item"><%=((YouthHonour)list41.get(i)).getVal1()%></p><%
}
%>
<p class="title3">二、青年岗位能手</p>
<%
List list42=(List<YouthHonour>)youthhonourByTypeMap.get(15);
if(list42!=null)
for(int i=0;i<list42.size();i++){
	%><p><span class="itemname"><%=((YouthHonour)list41.get(i)).getVal1()%></span><%=space2%>(<%=academyMap.get(((YouthHonour)list41.get(i)).getBelongAcademy())%>)</p><%
}
%>
<br/>
<br/>
<br/>
<br/>
<!-- -----------------------------------------附件5 模范团干部------------------------------------------------>
<p>附件5:</p>
<p class="title2"><%=year%><%=youthhonourNameMap.get(13)%></p>
<p class="title2">(人)</p>
<%
List list5=(List<YouthHonour>)youthhonourByTypeMap.get(13);
if(list5!=null)
for(int i=0;i<list5.size();i++){
	%><p><%=((YouthHonour)list5.get(i)).getVal7()%>:<span class="itemname"><%=((YouthHonour)list5.get(i)).getVal1()%></span></p><%
}
%>

<br/>
<br/>
<br/>
<br/>
<!-- -----------------------------------------附件6 优秀团干部（按学院）------------------------------------------------>
<p>附件6:</p>
<p class="title2"><%=year%><%=youthhonourNameMap.get(12)%></p>
<p class="title2">(人)</p>
<%
Map map6=(Map)youthhonourMap.get(12);
if(map6!=null)
for(Iterator it6=map6.keySet().iterator();it6.hasNext();){
	String academyid=String.valueOf(it6.next());
	List list6=(List)map6.get(academyid);
	
	%><p><span class="title4"><%=academyMap.get(academyid)%>:</span><%
	
	if(list6!=null)
	for(int i=0;i<list6.size();i++){
		%><span class="item"><%=((YouthHonour)list6.get(i)).getVal1()%></span><%
	}
	%></p><%
}		
%>

<br/>
<br/>
<br/>
<br/>
<!-- -----------------------------------------附件7 优秀团员（按学院）------------------------------------------------>
<p>附件7:</p>
<p class="title2"><%=year%><%=youthhonourNameMap.get(14)%></p>
<p class="title2">(人)</p>
<%
Map map7=(Map)youthhonourMap.get(7);
if(map7!=null)
for(Iterator it7=map7.keySet().iterator();it7.hasNext();){
	String academyid=String.valueOf(it7.next());
	List list7=(List)map7.get(academyid);
	
	%><p><span class="title4"><%=academyMap.get(academyid)%>:</span><%
	if(list7!=null)
	for(int i=0;i<list7.size();i++){
		%><span class="item"><%=((YouthHonour)list7.get(i)).getVal1()%>、</span><%
	}
	%></p><%
}	
%>

<br/>
<br/>
<br/>
<br/>
<!-- -----------------------------------------附件8 先进集体----------------------------------------------->
<p>附件8:</p>
<p class="title2">山东大学<%=year%>共青团工作评比</p>
<p class="title2">先进集体类获奖名单</p>
<%
String[] nums={"一","二","三","四","五","六"};
for(int i=5;i<11;i++){
	List list8=(List<YouthHonour>)youthhonourByTypeMap.get(i);
	if(list8!=null){
		%><p class="title3"><%=nums[i-5]%>、<%=youthhonourNameMap.get(i)%>(共<%=list8.size()%>个)</p><%
		for(int k=0;i<list8.size();i++){
			%><p class="item"><%=academyMap.get(((YouthHonour)list8.get(k)).getBelongAcademy())%>团委</p><%
		}
		%><p>同时授予<%
		for(int k=0;i<list8.size();i++){
			if(i!=(list8.size()-1)){
				%><span><%=((YouthHonour)list8.get(k)).getVal1()%>、</span><%
			}else{
				%><span><%=((YouthHonour)list8.get(k)).getVal1()%></span><%
			}
		}
		%><%=list8.size()%>名同志“<%=year%><%=((String)youthhonourNameMap.get(i)).replaceAll("先进集体","优秀指导教师")%>”称号</p>
	<%}//end if(list8.size()>0)
}
%>

<br/>
<br/>
<br/>
<br/>
<!-- -----------------------------------------附件9 先进个人（每类按学院）----------------------------------------------->
<p>附件9:</p>
<p class="title2">山东大学<%=year%>共青团工作评比</p>
<p class="title2">先进个人类获奖名单</p>
<%
String[] nums2={"一","二","三","四","五","六","七","八","九"};
for(int i=16;i<25;i++){
	%><p class="title3"><%=nums2[i-16]%>、<%=youthhonourNameMap.get(i)%></p><%
	
	Map map9=youthhonourMap.get(i);
	if(map9!=null)
	for(Iterator it9=map9.keySet().iterator();it9.hasNext();){
		String academyid=String.valueOf(it9.next());
		List list9=(List)map9.get(academyid);
		
		%><p><span class="title4"><%=academyMap.get(academyid)%>:</span><%
		if(list9!=null)
		for(int k=0;i<list9.size();i++){
			%><span class="item"><%=((YouthHonour)list9.get(k)).getVal1()%></span><%
		}
	}
}//end for(16~24)
%>
</div>
<% 
youthhonourNameMap.clear();
youthhonourMap.clear();
youthhonourByTypeMap.clear();
%>
</body>
</html>