//////////////////////////////////////////////////////////////////////////////////////////////////////////
//��ʾ��ʦ�������ڣ�ͬʱ��ǵ��õ�λ��
//objΪ�������������ȷ���������ڵ���ʾλ��
//datapos���ڱ�ʶҪ��ʾ������λ��
function showsearchwnd(obj, datapos){
 var offset = $(obj).offset();
 $('#teacherlist').show();
 $('#teacherlist').offset({
   top:offset.top + 20
 });
 $("input[name='datapos']").val(datapos);
}
//��ʾѧϰ��Դ��������
function showsearchwnd_f(obj, datapos){
	 var offset = $(obj).offset();
	 $('#filelist').show();
	 $('#filelist').offset({
	   top:offset.top + 20
	 });
	 $("input[name='datapos_f']").val(datapos);
	}


//��������ʦ���ڣ���ӳ�Ա��tridΪ�����б��е�id��
//dataposΪҳ��hidden�����򣬱�ʶ����Ҫ��ʾ��λ��
//��ӱ�У��ְ��
function addrecord(trid){
datapos = $("input[name='datapos']").val();
datapos = parseInt(datapos);
switch(datapos){
   case 1:
	  addoneperson(trid);//���У�ڸ�����
       break;
   case 2:
	   addteam(trid);// ���У���Ŷӳ�Ա
       break;
	}
}
//��ѧϰ�������������������
function addrecord_f(trid){
datapos = $("input[name='datapos_f']").val();
datapos = parseInt(datapos);
if(datapos==3){
	addfile(trid);
}
}

// �����У��Ա
function addotherrecord(trid){
datapos = $("input[name='datapos']").val();
datapos = parseInt(datapos);
switch(datapos){
   case 1:
	   addotherperson(trid);//���У�⸺����
       break;
   case 2:
	   addotherteam(trid);// ���У���Ŷӳ�Ա
       break;
	}
}

// ��ӱ�У�о���
function addgraduate(trid){
	datapos = $("input[name='datapos']").val();
	datapos = parseInt(datapos);
	switch(datapos){
	   case 1:
		   addonegraduate(trid);//��ӱ�У�о���������
	       break;
	   case 2:
		   addgraduateteam(trid);// ��ӱ�У�о���
	       break;
		}
}

//���У�ڸ����ˣ�ֻ�����һ����
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
	   $("#leaderaddbtn").text("�滻");
	}
	document.getElementById("leader").value= personname;
	document.getElementById("teacherid").value= teacherid;
	if(document.getElementById("otheruniversityflag")){
		document.getElementById("otheruniversityflag").value= "0";
		document.getElementById("otheruniversityflag").checked = "false";
	}
}

//���У�⸺���ˣ�ֻ�����һ����
function addotherperson(id){
	var personname = $("input[name='othername']").val();
	var teacherid = $("input[name='otheruniversity']").val();
	if(personname==""||teacherid==""){
		alert("����д��ʦ���ֺ�ѧУ���ƣ�");
		return false;
	}
	var leaderspan = $("#leadertd>span.leader");
	 if(leaderspan.length!=0){
			   leaderspan.html("<span class='leader' >" 
					   +"<span  id='leaderspan'>"+personname+"&nbsp;&nbsp;&nbsp;</span>"
					    +"<input type='checkbox' id='' name='otheruniversityflag' value='1' onclick='return false' checked='true'/>У��&nbsp;&nbsp;&nbsp;"
					    +"<span  id='leaderidspan'>ѧУ���ƣ�"+ teacherid + "&nbsp;&nbsp;&nbsp;</span>"
					    +"</span>&nbsp;&nbsp;&nbsp;" );
	 }
	else {
		   $("#leadertd>span:last").before(
		    "<span class='leader'>"
	    	+"<span  id='leaderspan'>"+personname+"&nbsp;&nbsp;&nbsp;</span>"
		    +"<input type='checkbox' id='' name='otheruniversityflag' value='1' onclick='return false' checked='true'/>У��&nbsp;&nbsp;&nbsp;"
		    +"<span  id='leaderidspan'>ѧУ���ƣ�"+ teacherid + "&nbsp;&nbsp;&nbsp;</span>"
		    +"</span>&nbsp;&nbsp;&nbsp;"
		    );
		   $("#leaderaddbtn").text("�滻");
	}
	 document.getElementById("leader").value= personname;
	document.getElementById("teacherid").value= teacherid;
	if(document.getElementById("otheruniversityflag")){
		document.getElementById("otheruniversityflag").value= "1";
		document.getElementById("otheruniversityflag").checked = "true";
	}
}

//��ӱ�У�о��������ˣ�ֻ�����һ����
function addonegraduate(id){
	var personname = $("input[name='graduatename']").val();
	var teacherid = $("input[name='graduateacademy']").val();
	if(personname==""||teacherid==""){
		alert("����д�о������ֺ�ѧԺ��");
		return false;
	}
	var leaderspan = $("#leadertd>span.leader");
	 if(leaderspan.length!=0){
			   leaderspan.html("<span class='leader' >" 
					   +"<span  id='leaderspan'>"+personname+"&nbsp;&nbsp;&nbsp;</span>"
					    +"<input type='checkbox' id='' name='otheruniversityflag' value='1' onclick='return false' checked='true'/>�о���&nbsp;&nbsp;&nbsp;"
					    +"<span  id='leaderidspan'>ѧУ���ƣ�"+ teacherid + "&nbsp;&nbsp;&nbsp;</span>"
					    +"</span>&nbsp;&nbsp;&nbsp;" );
	 }
	else {
		   $("#leadertd>span:last").before(
		    "<span class='leader'>"
	    	+"<span  id='leaderspan'>"+personname+"&nbsp;&nbsp;&nbsp;</span>"
		    +"<input type='checkbox' id='' name='otheruniversityflag' value='1' onclick='return false' checked='true'/>�о���&nbsp;&nbsp;&nbsp;"
		    +"<span  id='leaderidspan'>ѧУ���ƣ�"+ teacherid + "&nbsp;&nbsp;&nbsp;</span>"
		    +"</span>&nbsp;&nbsp;&nbsp;"
		    );
		   $("#leaderaddbtn").text("�滻");
	}
	 document.getElementById("leader").value= personname;
	document.getElementById("teacherid").value= teacherid;
	if(document.getElementById("otheruniversityflag")){
		document.getElementById("otheruniversityflag").value= "1";
		document.getElementById("otheruniversityflag").checked = "true";
	}
}

//���У���Ŷӳ�Ա������
var teampersonid = 1;
function addteam(id){
var name = $("#"+id+">td").eq(1).text();
var teacherid = $("#"+id+">td").eq(0).text();
$("#teamtd>span:last").before("<span class='teamperson'   id='"+teampersonid+"' ><span class='hidden' style='display:none'>"+teacherid+"��</span><span onclick='showspan99(this);' >"+name+"��</span></span>");
	   teampersonid ++;
}
//���ѧϰ��Դ�����
var filelistid = 1;
function addfile(id){
var name = $("#"+id+">td").eq(1).text();
var fileid = $("#"+id+">td").eq(0).text();
$("#filetd>span:last").before("<span class='filelist'   id='"+filelistid+"' ><span class='hidden' style='display:none'>"+fileid+"��</span><span onclick='showspan98(this);' >"+name+"��</span></span>");
	   filelistid ++;
}
// �Ŷ����У����Ա������
function addotherteam(id){
	var name = $("input[name='othername']").val();
	var teacherid = $("input[name='otheruniversity']").val();
	if(name==""||teacherid==""){
		alert("����д��ʦ���ֺ�ѧУ���ƣ�");
		return false;
	}
	$("#teamtd>span:last").before(
		    "<span class='teamperson'   id='"+teampersonid+"' ><span class='hidden' style='display:none'>"+teacherid+"��</span><span onclick='showspan99(this);' >"+name+"��</span></span>");
		   teampersonid ++;
	}

//�Ŷ���ӱ�У�о���������
function addgraduateteam(id){
	var name = $("input[name='graduatename']").val();
	var teacherid = $("input[name='graduateacademy']").val();
	if(name==""||teacherid==""){
		alert("����д��ʦ���ֺ�ѧУ���ƣ�");
		return false;
	}
	$("#teamtd>span:last").before(
		    "<span class='teamperson'   id='"+teampersonid+"' ><span class='hidden' style='display:none'>"+teacherid+"��</span><span onclick='showspan99(this);' >"+name+"��</span></span>");
		   teampersonid ++;
	}

//�Ŷӳ�Աǰ�ơ��������ӵ���ʾ
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

// �Ŷӳ�Աǰ��
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

// �Ŷӳ�Ա����
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
//ѧϰ����ǰ��
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
//ѧϰ���Ϻ���
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
//�����Ŷӳ�Ա�ַ���
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
//����ѧϰ�����ַ���
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


//ɾ���Ŷӳ�Ա
function delperson(){
		for(var i = 1; i < teampersonid; i++){
			if(document.getElementById(i) &&document.getElementById(i).lastChild&&document.getElementById(i).lastChild.style)
					if(document.getElementById(i).lastChild.style.color == 'blue'){
						document.getElementById(i).parentNode.removeChild(document.getElementById(i));
				}
		}
}
//ɾ��ѧϰ����
function delfile(){
		for(var i = 1; i < filelistid; i++){
			if(document.getElementById(i) &&document.getElementById(i).lastChild&&document.getElementById(i).lastChild.style)
					if(document.getElementById(i).lastChild.style.color == 'red'){
						document.getElementById(i).parentNode.removeChild(document.getElementById(i));
				}
		}
}