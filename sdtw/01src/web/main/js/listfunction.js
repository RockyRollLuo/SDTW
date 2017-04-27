var GEditIcon = GResPath + "/images/default/update.png";
function selectAll(cbx)
{
    var chks = document.getElementsByName("chk1");
    for (var i = 0; i < chks.length; i ++) {   //当前页面上有多条记录时
        chks[i].checked = cbx.checked;
    }
}
function deleteList(className, url_para){
	deleteList1(className, url_para, 1);
}
function deleteList1(className, url_para, page)
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
        if (confirm("确实要删除这些记录吗?")) {
            location = className + "Action.jsp?cmd=deletelist&idlist=" + chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
        }
    } else {
        alert("未选择记录！");
    }
}
function deleteSelect(className,id, currpage, url_para){
	if (confirm("确实要删除当前记录吗?")) {
    	location = className + "Action.jsp?cmd=deletelist&idlist=" + id + "&page=" + currpage + ((url_para.length == 0) ? "" : "&" + url_para);
    }
}
function addNew(className, url_para)
{	//alert(url_para);
    addNew1(className, url_para, "create");
}
function addNew1(className, url_para, cmd)
{
    if (!url_para)
        url_para = "";
    location = className + "Action.jsp?cmd=" + cmd + ((url_para.length == 0) ? "" : "&" + url_para); 
}
function importNew(className)
{
    location = className + "Action.jsp?cmd=list"; 
}
function imp(className)
{
    var chks = document.getElementsByName("chk1");
    var chkeds = new Array();
    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
        if (chks[i].checked == true) {
            chkeds.push(chks[i].value);
        }
    }
    if (chkeds.length > 0) {
        if (confirm("确实要导入这些记录吗?")) {
            location = className + "Action.jsp?cmd=imp&idlist=" + chkeds.join(',');
        }
    } else {
        alert("未选择记录！");
    }
}
function cmd_change_page(url_para, currpage, lastpage)
{
    var page = document.getElementById('changepageinput');
    if (page.value > 0 && page.value <= lastpage )
        window.location = url_para + page.value;
    else
        page.value = currpage;
}
function getIdList(type1)
{
    var chks = document.getElementsByName("chk1");
    var chkeds = new Array();
    var flag=0;
    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
        if (chks[i].checked == true) {
            flag=1;
            chkeds.push(chks[i].value);
        }
    }
    if(flag==0) {
        return "-1";  //没有选择行
    } else {
        if(type1==0)
            return chkeds[0];
        else
            return chkeds.join(',');
    }
}

function getFieldIndex(fstr) {
    for (var i = 0; i < allfields.length; i ++) {
        if (fstr == allfields[i]) {
            return i;
        }
    }
    return 0;
}

var asc_desc = {"asc": "desc", "desc": "asc"};
var curr_orderby;

function setOrderBy(fieldname, url_para) {
    if (curr_orderby == undefined) {
        return;
    }
    if (curr_orderby[0] == fieldname) {
        curr_orderby[1] = asc_desc[curr_orderby[1]];
    } else {
        curr_orderby = [fieldname, "asc"];
    }
    var arr = window.location.toString().split('&');
    var hasOrder = false;
    for (var i = 0; i < arr.length; i ++) {
        if (i ==0) continue;
        var subarr = arr[i].split('=');
        if (subarr[0] == 'orderfield') {
            hasOrder = true;
            arr[i] = "orderfield=" + curr_orderby[0];
        }
        if (subarr[0] == 'ordertype') {
            hasOrder = true;
            arr[i] = "ordertype=" + curr_orderby[1];
        }
    }
    if (!hasOrder) {
        arr[arr.length] = "orderfield=" + curr_orderby[0];
        arr[arr.length] = "ordertype=" + curr_orderby[1];
    }
    if (url_para.length == 0) {
        arr[arr.length] = "&" + url_para;
    }
    if (arr[0].indexOf('?') == -1) {
        arr[0] = arr[0] + "?cmd=list";
    }
    query.action = arr.join('&');
    query.submit();
    //window.location = arr.join('&');
}

var order_image = {"asc": GResPath + "/images/black-up-arrow.gif", "desc": GResPath + "/images/black-down-arrow.gif"};
var data_align = {"string": "left", "int": "right", "double": "right", "date": "left", "control": "center"};

function showQuery(className, currpage, url_para) {
    if (queryfields.length == 0) {
        return "";
    }
    if (queryfields[0] == "") {
        return "";
    }
    var getInput = function (name, val) {
        var type = dic[name][3];
        if (type == "text" || type == "hidden")
            return "<input name=\"" + name + "\" value=\"" + val + "\" size=\"10\">";
        var options = queryoptions[type];
        if (options != undefined) {
            var str = "<select name=\"" + name + "\" size=1>";
            for (var i = 0; i < options.length; i ++) {
                var checked = "";
                if (val == options[i][0])
                    checked = " selected";
                str += "<option value=\"" + options[i][0] + "\"" + checked + ">" + options[i][1] + "</option>";
            }
            str += "</select>";
            return str;
        }
        return "";
    };
    var str = "<form name=\"query\" action=\"" + className + "Action.jsp\">\n";
    str += "<input type=\"hidden\" name=\"cmd\" value=\"list\">";
    str += "<table border=\"0\" width=\"100%\" cellspacing=\"0\">\n<tr>\n";
    var i
    for (i = 0; i < queryfields.length; i ++) {
        str += "<td class=title_bgcolor>" + dic[queryfields[i]][1] + "</td><td>" + getInput(queryfields[i], queryvalues[i]) + "</td>";
        if (i % 4 == 3 && i < (queryfields.length - 1)) {
            str = str + '</tr><tr>\n';
        }
    }
    var j = (i % 4);
    if (j > 0) {
        str += "<td colspan=" + (4 - j) + ">&nbsp;</td>";
    }
    str = str + '</tr></table>\n';
    str += "</form>\n";
    return str;
}
function modifyRecord(className, id, currpage, url_para) {
	modifyRecord1(className, id, currpage, url_para, "modify")
}
function modifyRecord1(className, id, currpage, url_para, cmd) {
    //已经由Action处理了，现在不用处理了。
    //var new_url = getQuery(url_para);
	//alert("modifyRecord1"+className);
    var new_url = url_para;
   	window.location= className + "Action.jsp?cmd="+cmd+"&" + keyfield + "=" + id + "&page=" + currpage + ((new_url.length == 0) ? "" : "&" + new_url);
}
function modifyRecord1_frm(className, id, currpage, url_para, cmd) {
	//alert("modifyRecord1_frm:"+className+"--"+ id+ "--"+ url_para + "--"+ cmd);
    var new_url = url_para;
   	window.parent.frames["childfrm"].location=className + "Action.jsp?cmd="+cmd+"&" + keyfield + "=" + id + "&page=" + currpage + ((new_url.length == 0) ? "" : "&" + new_url);
   	//window.parent.location= className + "Action.jsp?cmd="+cmd+"&" + keyfield + "=" + id + "&page=" + currpage + ((new_url.length == 0) ? "" : "&" + new_url);
}
function modifyRecord1_home_frm(className, id, currpage, url_para, cmd) {
    var new_url = url_para;
   	window.frames["childfrm"].location=className + "Action.jsp?cmd="+cmd+"&" + keyfield + "=" + id + "&page=" + currpage + ((new_url.length == 0) ? "" : "&" + new_url);
   	//window.parent.location= className + "Action.jsp?cmd="+cmd+"&" + keyfield + "=" + id + "&page=" + currpage + ((new_url.length == 0) ? "" : "&" + new_url);
}

function getQuery(url_para) {
    var urls = [];
    var j = 0;
    if (url_para != undefined && url_para != "") {
        urls[j ++] = url_para;
    }
    if (queryfields.length == 0) {
        return urls.join("&");
    }
    if (queryfields[0] == "") {
        return urls.join("&");
    }
    for (var i = 0; i < queryfields.length; i ++) {
        qKey = "_" + queryfields[i] + "_";
        if (document.query[qKey] != undefined && document.query[qKey].value != "") {
            urls[j ++] = qKey + "=" + document.query[qKey].value;
        }
    }
    return urls.join("&");
}
function showList(className, currpage, url_para,aHasCheckbox) {
	showList1(className, currpage, url_para, aHasCheckbox, "modify", "0","-1");
}
function showList1(className, currpage, url_para, aHasCheckbox, cmd, haveSelect,curId) {
    var getRow = function (str, field) {
        if (str == "" || str == "null") {
            str = "&nbsp;";
        }
        var desc = ["string", "", "0", "text", ""];
        if (field != undefined) {
            desc = dic[field];
        }
        var dalign = desc[0] || "control";
        return "<td bgcolor=\"#FFFFFF\" class=\"xxybgx1\" align='" + data_align[dalign] + "'>" + str + "</td>\n";
    };
    var getRow1 = function (str, field) {
        if (str == "" || str == "null") {
            str = "&nbsp;";
        }
        var desc = ["string", "", "0", "text", ""];
        if (field != undefined) {
            desc = dic[field];
        }
        var dalign = desc[0] || "control";
        return "<td bgcolor=\"#FFFFFF\" class=\"xxybgx\" align='" + data_align[dalign] + "'>" + str + "</td>\n";
    };
    var hasCheckbox = (aHasCheckbox == undefined) ? true: aHasCheckbox;
    var showfields = new Array();
    var showhidefields = new Array();
    var keyindex = getFieldIndex(keyfield);
    //var str = showQuery(className, currpage, url_para);
    var str = "";
    if (typeof(curId) == "undefined") {var curId = "";}
    if (typeof(isSelect) == "undefined") var isSelect=0;
    
    var titlecolor = (isSelect == "1") ? "data_bgcolor_odd" : "title_bgcolor";
    str = str + "<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"1\" bgcolor=\"#D2D2D2\" >\n";
    if (hasCheckbox) {
        str = str + "<td background=\""+GImagePath+"/xxybgbg.gif\" bgcolor=\"#FFFFFF\" align=\"center\"><input type=\"checkbox\" onclick=\"selectAll(this);\" onchange=\"selectAll(this);\"></td>\n";
    }
    for (var i = 0; i < fields.length; i ++) {
        var title = dic[fields[i]][1];
        title = title.replace(/\(.*\)/, "");
        if (title == "") title = "&nbsp;";
        str = str + "<td align=\"center\" background=\""+GImagePath+"/xxybgbg.gif\" bgcolor=\"#FFFFFF\" align=\"center\" onclick=\"javascript:setOrderBy('" + fields[i] + "', '" + url_para + "')\" class=\"button\" nowrap>" + title;
        if (curr_orderby != undefined) {
            if (curr_orderby[0] == fields[i]) {
                str = str + "<img src=\"" + order_image[curr_orderby[1]] + "\">";
            }
        }
        str = str + "</td>\n";
        showfields[i] = getFieldIndex(fields[i]);
    }
    for (var i = 0; i < hidefields.length; i ++) {
        showhidefields[i] = getFieldIndex(hidefields[i]);
    }    
    str = str + "<td background=\""+GImagePath+"/xxybgbg.gif\" bgcolor=\"#FFFFFF\" align=\"center\" class=\"button\" nowrap>编辑</td>\n";
    str = str + "</tr>\n";
    if (rows.length == 0) {
        str = str + "<tr><td colspan=" + (showfields.length + 2) + " align=\"center\" bgcolor=\"#FFFFFF\" class=\"xxybgx1\">没有记录！</td></tr>\n";
    } 
    else {
        for (i = 0; i < rows.length; i ++) {
            var color = (i % 2 != 0) ? "data_bgcolor_odd" : "data_bgcolor_even";
            if (rows[i][keyindex] == curId){
            	str = str + "<tr onMouseOver=\"this.bgColor='#7DCDE6';\"  onMouseOut=\"this.bgColor='';\" bgcolor='#7DCDE6'>\n";
            }else{
            	str = str + "<tr onMouseOver=\"this.bgColor='#7DCDE6';\"  onMouseOut=\"this.bgColor='';\">\n";
            }
            if (hasCheckbox) {
            	if (haveSelect == "1" ){
            		var selectRowsIdsStr = (selectRowsIds == undefined) ? "" : selectRowsIds;
                	if (selectRowsIdsStr.indexOf(rows[i][keyindex])>-1){
                		str = str + "<td bgcolor=\"#FFFFFF\" align=\"center\"><input type=checkbox name=chk1 checked value=" + rows[i][keyindex] + " /></td>";
                	}else{
                		str = str + "<td bgcolor=\"#FFFFFF\" align=\"center\"><input type=checkbox name=chk1 value=" + rows[i][keyindex] + " /></td>";
                	}
                }else{
                	str = str + "<td bgcolor=\"#FFFFFF\" align=\"center\"><input type=checkbox name=chk1 value=" + rows[i][keyindex] + " /></td>";
                }
            }
             var atitle = "";
            for (var j = 0; j < fields.length; j ++) {
                var k = showfields[j];
                if(allfields[k]=="Id" ||allfields[k]=="OrderNo" ||allfields[k]=="Name" || allfields[k]=="Subject" || allfields[k] == "Email"){
                	for (m = 0; m < showhidefields.length; m++){
                		var n = showhidefields[m];
                	    atitle = atitle + dic[hidefields[m]][1] + ":" + rows[i][n] + " || ";
                	}
                	if (rows[i][k] == "" || rows[i][k] == "null") {
                		rows[i][k] = "&nbsp;";
                    }
                    if(j==0)
                		str = str + getRow1("<a class=visit style='cursor:hand' href=javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "'); title='" + atitle + "'>"+rows[i][k]+"</a>", fields[j]);
                	else
                		str = str + getRow("<a class=visit style='cursor:hand' href=javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "'); title='" + atitle + "'>"+rows[i][k]+"</a>", fields[j]);
                }else{
                	if(j==0)
                		str = str + getRow1(rows[i][k], fields[j]);
                	else
                		str = str + getRow(rows[i][k], fields[j]);
                }                
            }        		
           str = str + "<td bgcolor=\"#FFFFFF\" class=\"xxybgx2\" onclick=\"javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "')\">&nbsp;</td>";
            str = str + "</tr>\n";
        }
    }
    str = str + '</table>';
    document.getElementById("list").innerHTML = str;
}
///////////////jxl 嵌入页面转换

function showList_frm(className, currpage, url_para,aHasCheckbox) {
	showList_frm1(className, currpage, url_para, aHasCheckbox, "modify", "0","-1");
}
function showList_frm1(className, currpage, url_para, aHasCheckbox, cmd, haveSelect,curId) {
    var getRow = function (str, field) {
        if (str == "" || str == "null") {
            str = "&nbsp;";
        }
        var desc = ["string", "", "0", "text", ""];
        if (field != undefined) {
            desc = dic[field];
        }
        var dalign = desc[0] || "control";
        return "<td bgcolor=\"#FFFFFF\" class=\"xxybgx1\" align='" + data_align[dalign] + "'>" + str + "</td>\n";
    };
    var getRow1 = function (str, field) {
        if (str == "" || str == "null") {
            str = "&nbsp;";
        }
        var desc = ["string", "", "0", "text", ""];
        if (field != undefined) {
            desc = dic[field];
        }
        var dalign = desc[0] || "control";
        return "<td bgcolor=\"#FFFFFF\" class=\"xxybgx\" align='" + data_align[dalign] + "'>" + str + "</td>\n";
    };
    var hasCheckbox = (aHasCheckbox == undefined) ? true: aHasCheckbox;
    var showfields = new Array();
    var showhidefields = new Array();
    var keyindex = getFieldIndex(keyfield);
    //var str = showQuery(className, currpage, url_para);
    var str = "";
    if (typeof(curId) == "undefined") {var curId = "";}
    if (typeof(isSelect) == "undefined") var isSelect=0;
    
    var titlecolor = (isSelect == "1") ? "data_bgcolor_odd" : "title_bgcolor";
    str = str + "<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"1\" bgcolor=\"#D2D2D2\" >\n";
    if (hasCheckbox) {
        str = str + "<td background=\""+GImagePath+"/xxybgbg.gif\" bgcolor=\"#FFFFFF\" align=\"center\"><input type=\"checkbox\" onclick=\"selectAll(this);\" onchange=\"selectAll(this);\"></td>\n";
    }
    for (var i = 0; i < fields.length; i ++) {
        var title = dic[fields[i]][1];
        title = title.replace(/\(.*\)/, "");
        if (title == "") title = "&nbsp;";
        str = str + "<td align=\"center\" background=\""+GImagePath+"/xxybgbg.gif\" bgcolor=\"#FFFFFF\" align=\"center\" onclick=\"javascript:setOrderBy('" + fields[i] + "', '" + url_para + "')\" class=\"button\" nowrap>" + title;
        if (curr_orderby != undefined) {
            if (curr_orderby[0] == fields[i]) {
                str = str + "<img src=\"" + order_image[curr_orderby[1]] + "\">";
            }
        }
        str = str + "</td>\n";
        showfields[i] = getFieldIndex(fields[i]);
    }
    for (var i = 0; i < hidefields.length; i ++) {
        showhidefields[i] = getFieldIndex(hidefields[i]);
    }    
    str = str + "<td background=\""+GImagePath+"/xxybgbg.gif\" bgcolor=\"#FFFFFF\" align=\"center\" class=\"button\" nowrap>编辑</td>\n";
    str = str + "</tr>\n";
    if (rows.length == 0) {
        str = str + "<tr><td colspan=" + (showfields.length + 2) + " align=\"center\" bgcolor=\"#FFFFFF\" class=\"xxybgx1\">没有记录！</td></tr>\n";
    } 
    else {
        for (i = 0; i < rows.length; i ++) {
            var color = (i % 2 != 0) ? "data_bgcolor_odd" : "data_bgcolor_even";
            if (rows[i][keyindex] == curId){
            	str = str + "<tr align=\"left\" onMouseOver=\"this.bgColor='#7DCDE6';\"  onMouseOut=\"this.bgColor='';\" bgcolor='#7DCDE6'>\n";
            }else{
            	str = str + "<tr align=\"left\" onMouseOver=\"this.bgColor='#7DCDE6';\"  onMouseOut=\"this.bgColor='';\">\n";
            }
            if (hasCheckbox) {
            	if (haveSelect == "1" ){
            		var selectRowsIdsStr = (selectRowsIds == undefined) ? "" : selectRowsIds;
                	if (selectRowsIdsStr.indexOf(rows[i][keyindex])>-1){
                		str = str + "<td bgcolor=\"#FFFFFF\" align=\"center\"><input type=checkbox name=chk1 checked value=" + rows[i][keyindex] + " /></td>";
                	}else{
                		str = str + "<td bgcolor=\"#FFFFFF\" align=\"center\"><input type=checkbox name=chk1 value=" + rows[i][keyindex] + " /></td>";
                	}
                }else{
                	str = str + "<td bgcolor=\"#FFFFFF\" align=\"center\"><input type=checkbox name=chk1 value=" + rows[i][keyindex] + " /></td>";
                }
            }
             var atitle = "";
            for (var j = 0; j < fields.length; j ++) {
                var k = showfields[j];
                if(allfields[k]=="Id" ||allfields[k]=="OrderNo" ||allfields[k]=="Name" || allfields[k]=="Subject" || allfields[k] == "Email"){
                	for (m = 0; m < showhidefields.length; m++){
                		var n = showhidefields[m];
                	    atitle = atitle + dic[hidefields[m]][1] + ":" + rows[i][n] + " || ";
                	}
                	if (rows[i][k] == "" || rows[i][k] == "null") {
                		rows[i][k] = "&nbsp;";
                    }
                    if(j==0)
                		str = str + getRow1("<a class=visit style='cursor:hand' href=javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "'); title='" + atitle + "'>"+rows[i][k]+"</a>", fields[j]);
                	else
                		str = str + getRow("<a class=visit style='cursor:hand' href=javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "'); title='" + atitle + "'>"+rows[i][k]+"</a>", fields[j]);
                }else{
                	if(j==0)
                		str = str + getRow1(rows[i][k], fields[j]);
                	else
                		str = str + getRow(rows[i][k], fields[j]);
                }                
            }        		
           str = str + "<td bgcolor=\"#FFFFFF\" class=\"xxybgx2\" onclick=\"javascript:modifyRecord1_frm('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "')\">&nbsp;</td>";
            str = str + "</tr>\n";
        }
    }
    str = str + '</table>';
    document.getElementById("list").innerHTML = str;
}


///////////jxl end
function openshow(link1)
{
    var windowopen = window.open;
	openwin=windowopen(link1 , "link1", "top=58,left=200,width=600,height=500,status=no,toolbar=no,menubar=no,scrollbars=no, resizable=no");    
}
function deleteListPerson(className, url_para)
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
        if (confirm("确实要删除这些记录吗?")) {
            location = className + "Action.jsp?cmd=deletelistperson&idlist=" + chkeds.join(',') + ((url_para.length == 0) ? "" : "&" + url_para);
        }
    } else {
        alert("未选择记录！");
    }
}
function addNewPerson(className, url_para)
{
    if (!url_para)
        url_para = "";
    location = className + "Action.jsp?cmd=createperson" + ((url_para.length == 0) ? "" : "&" + url_para); 
}
