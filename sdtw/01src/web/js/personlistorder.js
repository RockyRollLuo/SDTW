//////////////////////////////////////////////////////////////////////////////////////////////////////////
//显示教师搜索窗口，同时标记调用的位置
//obj为对象参数，用于确定搜索窗口的显示位置
//datapos用于标识要显示的数据位置
function showsearchwnd(obj, datapos){
 var offset = $(obj).offset();
 $('#teacherlist').show();
 $('#teacherlist').offset({
   top:offset.top + 20
 });
 $("input[name='datapos']").val(datapos);
}
//显示学习资源搜索窗口
function showsearchwnd_f(obj, datapos){
	 var offset = $(obj).offset();
	 $('#filelist').show();
	 $('#filelist').offset({
	   top:offset.top + 20
	 });
	 $("input[name='datapos_f']").val(datapos);
	}


//从搜索教师窗口，添加成员，trid为窗口列表行的id号
//datapos为页面hidden输入域，标识数据要显示的位置
//添加本校教职工
function addrecord(trid){
datapos = $("input[name='datapos']").val();
datapos = parseInt(datapos);
switch(datapos){
   case 1:
	  addoneperson(trid);//添加校内负责人
       break;
   case 2:
	   addteam(trid);// 添加校内团队成员
       break;
	}
}
//从学习资料搜索窗口添加内容
function addrecord_f(trid){
datapos = $("input[name='datapos_f']").val();
datapos = parseInt(datapos);
if(datapos==3){
	addfile(trid);
}
}

// 添加外校人员
function addotherrecord(trid){
datapos = $("input[name='datapos']").val();
datapos = parseInt(datapos);
switch(datapos){
   case 1:
	   addotherperson(trid);//添加校外负责人
       break;
   case 2:
	   addotherteam(trid);// 添加校外团队成员
       break;
	}
}

// 添加本校研究生
function addgraduate(trid){
	datapos = $("input[name='datapos']").val();
	datapos = parseInt(datapos);
	switch(datapos){
	   case 1:
		   addonegraduate(trid);//添加本校研究生负责人
	       break;
	   case 2:
		   addgraduateteam(trid);// 添加本校研究生
	       break;
		}
}

//添加校内负责人（只能添加一个）
function addoneperson(id){
 var personname = $("#"+id+">td").eq(1).text();
 var teacherid = $("#"+id+">td").eq(0).text();
 var leaderspan = $("#leadertd>span.leader");
 if(leaderspan.length!=0){
		   leaderspan.html("<span class='leader' ><span class='hidden' style='display:none' id='leaderidspan'>"+teacherid+"</span><span  id='leaderspan' >"+personname+"</span></span>"	   
		   );
 }
else {
	   $("#leadertd>span:last").before(
	    "<span class='leader'><span class='hidden' style='display:none'  id='leaderidspan'>"+teacherid+"</span><span  id='leaderspan' onclick='showspan99(this);' >"+personname+"</span></span>&nbsp;&nbsp;&nbsp;"
	    );
	   $("#leaderaddbtn").text("替换");
	}
	document.getElementById("leader").value= personname;
	document.getElementById("teacherid").value= teacherid;
	if(document.getElementById("otheruniversityflag")){
		document.getElementById("otheruniversityflag").value= "0";
		document.getElementById("otheruniversityflag").checked = "false";
	}
}

//添加校外负责人（只能添加一个）
function addotherperson(id){
	var personname = $("input[name='othername']").val();
	var teacherid = $("input[name='otheruniversity']").val();
	if(personname==""||teacherid==""){
		alert("请填写教师名字和学校名称！");
		return false;
	}
	var leaderspan = $("#leadertd>span.leader");
	 if(leaderspan.length!=0){
			   leaderspan.html("<span class='leader' >" 
					   +"<span  id='leaderspan'>"+personname+"&nbsp;&nbsp;&nbsp;</span>"
					    +"<input type='checkbox' id='' name='otheruniversityflag' value='1' onclick='return false' checked='true'/>校外&nbsp;&nbsp;&nbsp;"
					    +"<span  id='leaderidspan'>学校名称："+ teacherid + "&nbsp;&nbsp;&nbsp;</span>"
					    +"</span>&nbsp;&nbsp;&nbsp;" );
	 }
	else {
		   $("#leadertd>span:last").before(
		    "<span class='leader'>"
	    	+"<span  id='leaderspan'>"+personname+"&nbsp;&nbsp;&nbsp;</span>"
		    +"<input type='checkbox' id='' name='otheruniversityflag' value='1' onclick='return false' checked='true'/>校外&nbsp;&nbsp;&nbsp;"
		    +"<span  id='leaderidspan'>学校名称："+ teacherid + "&nbsp;&nbsp;&nbsp;</span>"
		    +"</span>&nbsp;&nbsp;&nbsp;"
		    );
		   $("#leaderaddbtn").text("替换");
	}
	 document.getElementById("leader").value= personname;
	document.getElementById("teacherid").value= teacherid;
	if(document.getElementById("otheruniversityflag")){
		document.getElementById("otheruniversityflag").value= "1";
		document.getElementById("otheruniversityflag").checked = "true";
	}
}

//添加本校研究生负责人（只能添加一个）
function addonegraduate(id){
	var personname = $("input[name='graduatename']").val();
	var teacherid = $("input[name='graduateacademy']").val();
	if(personname==""||teacherid==""){
		alert("请填写研究生名字和学院！");
		return false;
	}
	var leaderspan = $("#leadertd>span.leader");
	 if(leaderspan.length!=0){
			   leaderspan.html("<span class='leader' >" 
					   +"<span  id='leaderspan'>"+personname+"&nbsp;&nbsp;&nbsp;</span>"
					    +"<input type='checkbox' id='' name='otheruniversityflag' value='1' onclick='return false' checked='true'/>研究生&nbsp;&nbsp;&nbsp;"
					    +"<span  id='leaderidspan'>学校名称："+ teacherid + "&nbsp;&nbsp;&nbsp;</span>"
					    +"</span>&nbsp;&nbsp;&nbsp;" );
	 }
	else {
		   $("#leadertd>span:last").before(
		    "<span class='leader'>"
	    	+"<span  id='leaderspan'>"+personname+"&nbsp;&nbsp;&nbsp;</span>"
		    +"<input type='checkbox' id='' name='otheruniversityflag' value='1' onclick='return false' checked='true'/>研究生&nbsp;&nbsp;&nbsp;"
		    +"<span  id='leaderidspan'>学校名称："+ teacherid + "&nbsp;&nbsp;&nbsp;</span>"
		    +"</span>&nbsp;&nbsp;&nbsp;"
		    );
		   $("#leaderaddbtn").text("替换");
	}
	 document.getElementById("leader").value= personname;
	document.getElementById("teacherid").value= teacherid;
	if(document.getElementById("otheruniversityflag")){
		document.getElementById("otheruniversityflag").value= "1";
		document.getElementById("otheruniversityflag").checked = "true";
	}
}

//添加校内团队成员，多人
var teampersonid = 1;
function addteam(id){
var name = $("#"+id+">td").eq(1).text();
var teacherid = $("#"+id+">td").eq(0).text();
$("#teamtd>span:last").before("<span class='teamperson'   id='"+teampersonid+"' ><span class='hidden' style='display:none'>"+teacherid+"，</span><span onclick='showspan99(this);' >"+name+"，</span></span>");
	   teampersonid ++;
}
//添加学习资源，多个
var filelistid = 1;
function addfile(id){
var name = $("#"+id+">td").eq(1).text();
var fileid = $("#"+id+">td").eq(0).text();
$("#filetd>span:last").before("<span class='filelist'   id='"+filelistid+"' ><span class='hidden' style='display:none'>"+fileid+"，</span><span onclick='showspan98(this);' >"+name+"，</span></span>");
	   filelistid ++;
}
// 团队添加校外人员，多人
function addotherteam(id){
	var name = $("input[name='othername']").val();
	var teacherid = $("input[name='otheruniversity']").val();
	if(name==""||teacherid==""){
		alert("请填写教师名字和学校名称！");
		return false;
	}
	$("#teamtd>span:last").before(
		    "<span class='teamperson'   id='"+teampersonid+"' ><span class='hidden' style='display:none'>"+teacherid+"，</span><span onclick='showspan99(this);' >"+name+"，</span></span>");
		   teampersonid ++;
	}

//团队添加本校研究生，多人
function addgraduateteam(id){
	var name = $("input[name='graduatename']").val();
	var teacherid = $("input[name='graduateacademy']").val();
	if(name==""||teacherid==""){
		alert("请填写教师名字和学校名称！");
		return false;
	}
	$("#teamtd>span:last").before(
		    "<span class='teamperson'   id='"+teampersonid+"' ><span class='hidden' style='display:none'>"+teacherid+"，</span><span onclick='showspan99(this);' >"+name+"，</span></span>");
		   teampersonid ++;
	}

//团队成员前移、后移链接的显示
var personchosen = '';
var chosenbefore;
function showspan99(obj){
	document.getElementById("span99").style.display='';
	if(personchosen != ''){
		chosenbefore.style.color = '';
	}
	obj.style.color = 'blue';
	personchosen = obj.parentNode.id;
	chosenbefore = obj;
}

var filechosen = '';
var chosenbefore_f;
function showspan98(obj){
	document.getElementById("span98").style.display='';
	if(filechosen != ''){
		chosenbefore_f.style.color = '';
	}
	obj.style.color = 'red';
	filechosen = obj.parentNode.id;
	chosenbefore_f = obj;
}

// 团队成员前移
function moveforward (){
	 var node1=document.getElementById(personchosen);
	 var node2;
	 var nodeTmp;
	 for(var i = (parseInt(personchosen) - 1); i > 0; i-- ){
		 if(document.getElementById(i)){
		node2=document.getElementById(i);
		nodeTmp=node1.innerHTML;
		node1.innerHTML=node2.innerHTML;
	    node2.innerHTML=nodeTmp;
		 }
	 }
}

// 团队成员后移
function movebackward (){
	 var node3=document.getElementById(personchosen);//
	 var node4;
	 var nodeTmp;
	 for(var i = (parseInt(personchosen) + 1); i < parseInt(teampersonid); i++ ){
		 if(document.getElementById(i)){
		node4=document.getElementById(i);
		nodeTmp=node3.innerHTML;
		node3.innerHTML=node4.innerHTML;
	    node4.innerHTML=nodeTmp;
		 }
	 }
}
//学习资料前移
function moveforward_f (){
	 var node1=document.getElementById(filechosen);
	 var node2;
	 var nodeTmp;
	 for(var i = (parseInt(filechosen) - 1); i > 0; i-- ){
		 if(document.getElementById(i)){
		node2=document.getElementById(i);
		nodeTmp=node1.innerHTML;
		node1.innerHTML=node2.innerHTML;
	    node2.innerHTML=nodeTmp;
		 }
	 }
}
//学习资料后移
function movebackward_f (){
	 var node3=document.getElementById(filechosen);//
	 var node4;
	 var nodeTmp;
	 for(var i = (parseInt(filechosen) + 1); i < parseInt(filelistid); i++ ){
		 if(document.getElementById(i)){
		node4=document.getElementById(i);
		nodeTmp=node3.innerHTML;
		node3.innerHTML=node4.innerHTML;
	    node4.innerHTML=nodeTmp;
		 }
	 }
}
//生成团队成员字符串
function getteamperson(){
	   var team = "";
	   var teamid = "";
	   $("span.teamperson").each(
	     function(){
	     	teamid += $(this).find('span').eq(0).text();
	     	team += $(this).find('span').eq(1).text();
	     }
	   );
	   	teamid=teamid.substring(0,teamid.length-1);
	 	team=team.substring(0,team.length-1);
	    document.getElementById("team").value= team;
	  	document.getElementById("teamid").value= teamid;
}
//生成学习资料字符串
function getfilelist(){
	   var file = "";
	   var fileid = "";
	   $("span.filelist").each(
	     function(){
	     	fileid += $(this).find('span').eq(0).text();
	     	file += $(this).find('span').eq(1).text();
	     }
	   );
	   	fileid=fileid.substring(0,fileid.length-1);
	 	file=file.substring(0,file.length-1);
	    document.getElementById("file").value= file;
	  	document.getElementById("fileid").value= fileid;
}


//删除团队成员
function delperson(){
		for(var i = 1; i < teampersonid; i++){
			if(document.getElementById(i) &&document.getElementById(i).lastChild&&document.getElementById(i).lastChild.style)
					if(document.getElementById(i).lastChild.style.color == 'blue'){
						document.getElementById(i).parentNode.removeChild(document.getElementById(i));
				}
		}
}
//删除学习资料
function delfile(){
		for(var i = 1; i < filelistid; i++){
			if(document.getElementById(i) &&document.getElementById(i).lastChild&&document.getElementById(i).lastChild.style)
					if(document.getElementById(i).lastChild.style.color == 'red'){
						document.getElementById(i).parentNode.removeChild(document.getElementById(i));
				}
		}
}