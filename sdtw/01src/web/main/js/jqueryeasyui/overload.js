function alert(s){
	$.messager.alert("提示",s,"info")
}
function deleteList(className, url_para)
{
    var chks = document.getElementsByName("chk1");
    if (!url_para)
        url_para = "";
    var chkeds = new Array();
    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
        if (chks[i].checked == true) {
            chkeds.push(chks[i].value);
        }
    }
    if (chkeds.length > 0) {
    	$.messager.confirm("提示","确实要删除这些记录吗?",function(r){
    		if(r){
    			 location = className + "Action.jsp?cmd=deletelist&idlist=" + chkeds.join(',') + "&page=1" + ((url_para.length == 0) ? "" : "&" + url_para);
    		}
    	})
           
    } else {
        alert("未选择记录！");
    }
}