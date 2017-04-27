<%@ page contentType="text/html;charset=utf-8" %>
<%@page import="com.xietong.software.util.OptionBean"%>
<%@page import="com.xietong.software.sdtw.db.Places"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>

<%

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Calendar calendar=Calendar.getInstance();    //当前日期date格式  
Calendar c1 = Calendar.getInstance();
Calendar c2 = Calendar.getInstance();
String currentdate=sdf.format(calendar.getTime());//当前日期

c1.add(Calendar.DAY_OF_MONTH, 7);    //7天后日期date格式  
c2.add(Calendar.DAY_OF_MONTH, 30);    //30天当前日期date格式  

String weekafterdate=sdf.format(c1.getTime()); //7天后日期  （会查出8天）
String monthafterdate=sdf.format(c2.getTime());//30天后日期（会查出31天）

String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"}; 
Map shenhe1= new HashMap();
Map shenhe2= new HashMap();
List cdt1= new ArrayList();
List list1= new ArrayList();
List cdt2= new ArrayList();
List list2= new ArrayList();
Places_Applytable pat= new Places_Applytable ();
cdt1.add("status =0");
cdt2.add("status =1");
list1=pat.query(cdt1);
list2=pat.query(cdt2);
if(list1.size()>0){
	for(int i=0;i<list1.size();i++){
		pat=(Places_Applytable)list1.get(i);
		shenhe1.put(pat.getPlaceApplycode()+pat.getApplyDate()+pat.getApplyTimeRange(), pat);
	}
}
if(list2.size()>0){
	for(int i=0;i<list2.size();i++){
		pat=(Places_Applytable)list2.get(i);
		shenhe2.put(pat.getPlaceApplycode()+pat.getApplyDate()+pat.getApplyTimeRange(), pat);
	}
}

// System.out.println("当前日期："+currentdate);
// System.out.println("7天后日期："+weekafterdate);
// System.out.println("30天后日期："+monthafterdate);

%>
<html>
<head>
<link href="../css/common.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>

<!--以下2个为datepicker-->
<link rel="stylesheet" href="../css/jqueryUI/jquery-ui.css">
<script src="../js/jqueryUI/jquery-ui.js"></script>


<script type="text/javascript">
function applyformsubmit()
{	
	var table = document.getElementById("applytable");
	var rows = table.rows; 
 	var a = document.getElementsByName("applytimerange"); //checkboxs 所有复选框的集合
 	
 	var applydata=new Array(); //存放申请数据
 	var count=0; //数组行数
 	var timerange;
 	var i=0;
 	
	while(i<a.length) 
	{ 
 		if(a[i].checked)
 		{ 
	 		var row = a[i].parentElement.parentElement.parentElement.rowIndex; //获取勾选中的checkbox所在行号，注意input被div包裹了
	 		var col = a[i].parentElement.parentElement.cellIndex;              //获取列号
	 		
			var colTotimerange=["上午","下午","晚上"];
			timerange=colTotimerange[col-5];		
			applydata[count]=new Array();
			applydata[count][0]=rows[row].cells[2].innerHTML;   //场地名称
			applydata[count][1]=rows[row].cells[3].innerHTML;	//日期
			applydata[count][2]=timerange;                      //时段
			applydata[count][3]=rows[row].cells[0].innerHTML;   //placecode
			
			count++;
		}
		i++;
	}
	if(count==0){
		alert("未选择申请时段！");
	}else{
		
		document.applyform.applydata.value =applydata;  
 	 	document.applyform.count.value =count;
	 	document.applyform.submit();
	}
}

$(function(){
	$("#datepicker").datepicker();
	$("input[type=submit],input[type=button]").button();

// 	alert(1);
//接收参数
	var allocatednums=document.allocatedform.allocatednums.value;
	var placecodestring=document.allocatedform.placecode2.value;
	var datestring=document.allocatedform.date.value;
	var timerangestring=document.allocatedform.timerange.value;
	var statusstring=document.allocatedform.status.value;
	
	var activityprincipalstring=document.allocatedform.activityprincipal.value;
	var principalphonestring=document.allocatedform.principalphone.value;
	
//参数数组
	var placecodearray=new Array();
	var datearray=new Array();
	var timerangearray=new Array();
	var statusarray=new Array();
	
	var activityprincipalarray=new Array();
	var principalphonearray=new Array();
	
	placecodearray=placecodestring.split(",");
	datearray=datestring.split(",");
	timerangearray=timerangestring.split(",");
	statusarray=statusstring.split(",");
	
	activityprincipalarray=activityprincipalstring.split(",");
	principalphonearray=principalphonestring.split(",");


//向表中插值	
	var table = document.getElementById("applytable");
	var rows = table.rows; 
	
	var col;
	var statusinner;

	var explaindetails="";
	for(var i=0;i<allocatednums;i++)   //分条读取申请数据
	{
		if(timerangearray[i]=="上午") col=5;
		else if(timerangearray[i]=="下午") col=6;	
		else if(timerangearray[i]=="晚上") col=7;
		
		
		
		if(i>0&&placecodearray[i]==placecodearray[i-1]&&datearray[i]==datearray[i-1]){  //拼接同一场地的“说明”
			explaindetails+=timerangearray[i]+":"+activityprincipalarray[i]+";"+principalphonearray[i]+"<br/>";
		}else{
			explaindetails=timerangearray[i]+":"+activityprincipalarray[i]+";"+principalphonearray[i]+"<br/>";				
		}
		
		if(statusarray[i]==0){
			statusinner="";
		}else if(statusarray[i]==1){
			statusinner="<div style='width:20px;margin:auto;background:#FFD700;' ><input type='checkbox' name='applytimerange' ></div>";
		}else if(statusarray[i]==2){
			statusinner="<img src='../images/checkbox.png' title='不可申请'>";
		}else if(statusarray[i]==3){
			statusinner="<div style='width:20px;margin:auto;background:#00E5EE;' ><input type='checkbox' name='applytimerange' ></div>";
		}
		
		for(var j=0;j<rows.length;j++)
		{
			
			if(rows[j].cells[0].innerHTML==placecodearray[i]&&rows[j].cells[3].innerHTML==datearray[i])
			{
				rows[j].cells[col].innerHTML=statusinner;
				rows[j].cells[8].innerHTML=explaindetails; 
			}
		}
	}
});
</script>

<%
	//接受各种参数 从session或者其他对象中 
	String myuserrole = (String)session.getAttribute("userrole"); 
	
	//接收searchform参数
	String search_placename="";   //gb2312导致空数据,已修改
 	String search_date=request.getParameter("date");
 
//  	//在没有点击查询时，两个值均为null
// 	System.out.println("查找场地名称"+search_placename);
// 	System.out.println("查找日期"+search_date);

	String wherestr1="",wherestr2="",explainstr="";
	int searchtimes=0;//查询次数
	if((search_placename==null||search_placename=="")&&(search_date==null||search_date==""))
	{
	//默认无场地，无时间
		wherestr1="";
		wherestr2=" date >= '"+currentdate+"' AND date <= '"+ weekafterdate+"'";
		searchtimes=7;
		explainstr="所有场地在7天内申请状态";
	}
	else if((search_placename!=null||search_placename!="")&&(search_date==null||search_date==""))
	{
	//有场地，无时间
		wherestr1=" WHERE placename='"+search_placename+"'";
		wherestr2=" placename='"+search_placename+"' AND date >= '"+currentdate+"' AND date <='"+ monthafterdate+"'";
		searchtimes=30;
		explainstr="场地:"+search_placename+" 在30天内所有申请状态";
	}
	else if((search_placename==null||search_placename=="")&&(search_date!=null||search_date!=""))
	{
	//无场地，有时间
		wherestr1="";
		wherestr2=" date like '%"+search_date+"%'";
		searchtimes=1;
		explainstr="所有场地在日期："+search_date+" 时的申请状态";
	}
	else
	{
	//有场地，有时间
		wherestr1=" WHERE placename='"+search_placename+"'";
		wherestr2=" placename='"+search_placename+"' AND date like '%"+search_date+"%'";
		searchtimes=1;
		explainstr="场地："+search_placename+" 在 日期："+search_date+"的申请状态";
	}
	
	String checkbox="<div style='width:20px;margin:auto;background:#66CDAA;' ><input type='checkbox' name='applytimerange' ></div>";
	String checkbox1="<div style='width:20px;margin:auto;background:#FFD700;' ><input type='checkbox' name='applytimerange' ></div>";
	String checkbox2="<img src='../images/checkbox.png' title='不可申请'>";
 %>
</head>
<body>

<% 
String strposition = "场地管理 >> 场地申请 >> ";
String strfunction = "场地列表--"+explainstr;
String strhelpwords = "选择场地名称，选择申请日期，勾选需要申请的场地时间段，点击“提交申请”。"
					+"绿框为可申请场地；黄框为已被提出申请，处于待审核状态；红框为已被申请成功的场地，不可再提出申请。"
					+"“说明”一栏中显示的是已被申请场地的活动负责人及其联系电话。";
%>
<%-- <%@ include file="../pubpro/pagetop-positionandhelp.jsp" %>
 --%>
<form name="searchform" action="places-application-list.jsp" method="post">
<div style="padding:1em;font-family:microsoft yahei;">
<span style="margin:1em;">场地名称：
		
<%
List placeoptions =new ArrayList();
Places  ica= new Places();
List cdt= new ArrayList();
List list3= new ArrayList();
list3=ica.query(cdt);
OptionBean ob4= new OptionBean("","");
placeoptions.add(ob4);
if(list1.size()>0){
	for(int i=0;i<list3.size();i++){
		ica=(Places )list3.get(i);
		ob4=new OptionBean(ica.getPlaceName(),ica.getId()+"");
		placeoptions.add(ob4);
	}
}

%>
		
	<%=HtmlTool.renderSelect(placeoptions, ParamUtils.getParameter(request, "_PlaceApplyId_","-1"), "_PlaceApplyId_", "")%>
				


		</span>
	
		<span style="padding-left:2em;"><input type="submit" value="查询" ></span>
		<span style="padding-left:15em;"><input type="button" value="提交申请" onclick="applyformsubmit()" /></span>
</div>
</form>

<form name="applyform" method="post" action="places-applytable.jsp">
	  <input type="hidden" name="applydata" value="">
	  <input type="hidden" name="count" value="">
</form>

<table class="content-table" id="applytable" style="margin-top:-10px">
<tr>
	<th width="5%">序号</th>
	<th width="20%">场地名称</th>
	<th width="12%">日期</th>
	<th width="12%">星期</th>
	<th width="10%">上午</th>
	<th width="10%">下午</th>
	<th width="10%">晚上</th>
	<th>说明</th>
	
</tr>
<tr>
	<th colspan="8" align="left">说明：勾选需要申请的场地,黄色单选框表示该场地正在被申请但未审核，红色单选框表示场地已被人申请并审核通过</th>
</tr>
<%  

	//定义数据库中读取字段的变量 
	String placecode1="",placename1="",placecode2="",placename2="",placename1href="";
	String timerange="",statustr="",explain="",datestr="",weekday="";
	String activityprincipal="",principalphone="";//从places_applytable中去得的数据
	int places_allocationid,order=0,status,i=0,allocatednums=0;
	Date date=new Date();

List cdt4= new ArrayList();
String qual=ParamUtils.getParameter(request, "_PlaceApplycode_", "-1");
System.out.println(qual);
int Id=ParamUtils.getIntParameter(request, "_PlaceApplyId_", -1);
System.out.println(Id);
Places pla= new Places() ;
if(qual.length()>0&&qual!="-1"){
	cdt4.add("PlaceName ='"+qual+"'");
}
if(Id!=-1){
	pla=pla.getById(Id);
	cdt4.add("PlaceName ='"+pla.getPlaceName()+"'");
}
List list= new ArrayList();


list=pla.query(cdt4);
if(list.size()>0){
	for(int l=0;l<list.size();l++){
		pla=(Places)list.get(l);
		placename1=pla.getPlaceName();

			
			if(search_date==null||search_date==""){
				for(int k=0;k<searchtimes;k++){
					Calendar date1=Calendar.getInstance(); //当前日期date类型
					date1.add(Calendar.DAY_OF_MONTH, k); //在表格中显示日期date类型
	                datestr=sdf.format(date1.getTime()); //
					weekday=weekDaysName[date1.get(Calendar.DAY_OF_WEEK)-1];
				
					placename1href="<a href='places-details.jsp?placecode="+placecode1+"' >"+placename1+"</a>";
					String shuchu="";
%>
					<tr>
						<td style="display:none"><%=placecode1%></td>
						<td><%=order+1%></td>
						<td><%=placename1%></td><%--放palcename1href取值的时候去的链接--%>
						<td><%=datestr%></td>
						<td><%=weekday%></td>
						<%
							checkbox="<div style='width:20px;margin:auto;background:#66CDAA;' ><input type='checkbox' name='applytimerange' ></div>";;

							if(shenhe1.containsKey(placename1+datestr+"上午")){
								pat=(Places_Applytable)shenhe1.get(placename1+datestr+"上午");
							System.out.println("beishenqingle ");
							checkbox=checkbox1;
						
							shuchu+="该场地上午被"+pat.getPromiser()+"申请，联系方式"+pat.getPromiserPhone();
						}
							if(shenhe2.containsKey(placename1+datestr+"上午")){
								System.out.println("beishenqingle ");
								checkbox=checkbox2;
							}
								
							
						
						%>
						<td><%=checkbox%></td>
							<%
									checkbox="<div style='width:20px;margin:auto;background:#66CDAA;' ><input type='checkbox' name='applytimerange' ></div>";;

									

									if(shenhe1.containsKey(placename1+datestr+"下午")){
										pat=(Places_Applytable)shenhe1.get(placename1+datestr+"下午");
										System.out.println("beishenqingle ");
										checkbox=checkbox1;
										
										shuchu+="该场地下午被"+pat.getPromiser()+"申请，联系方式"+pat.getPromiserPhone();
								}
									if(shenhe2.containsKey(placename1+datestr+"下午")){
										System.out.println("beishenqingle ");
										checkbox=checkbox2;
									}
						%>
						<td><%=checkbox%></td>
								<%
									
									checkbox="<div style='width:20px;margin:auto;background:#66CDAA;' ><input type='checkbox' name='applytimerange' ></div>";;

									if(shenhe1.containsKey(placename1+datestr+"晚上")){
										pat=(Places_Applytable)shenhe1.get(placename1+datestr+"晚上");
										System.out.println("beishenqingle ");
										checkbox=checkbox1;
										shuchu+="该场地晚上被"+pat.getPromiser()+"申请，联系方式"+pat.getPromiserPhone();
								}
									if(shenhe2.containsKey(placename1+datestr+"晚上")){
										System.out.println("beishenqingle ");
										checkbox=checkbox2;
									}
						
						%>
						<td><%=checkbox%></td>
						<td align="left"><%=shuchu %></td>
					</tr>
<%
					order++;
				}//endfor
			}else{
				datestr=search_date;
				
				Date date2=sdf.parse(datestr);
				calendar.setTime(date2);//date转calendar
				weekday=weekDaysName[calendar.get(Calendar.DAY_OF_WEEK)-1];
%>
				<tr>
					<td style="display:none"><%=placecode1%></td>
					<td><%=order+1%></td>
					<td><%=placename1%></td>
					<td><%=datestr%></td>
					<td><%=weekday%></td>
					<td><%=checkbox%></td>
					<td><%=checkbox%></td>
					<td><%=checkbox%></td>
					<td align="left"></td>
				</tr>
<%
				order++;
			}//end else
		
	}
}

%>
<tr>
	<th colspan="8" align="left">说明：勾选需要申请的场地</th>
</tr>
</table>


	
	





</body>
</html>
