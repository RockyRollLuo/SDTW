function renderSelect(list, currkey, name, defaultkey, chgevent)
{
    var rtn = "";
    rtn += "<select name=\"" + name + "\" onChange=\"" + chgevent + "\">";
    rtn += renderSelectOption(list, currkey, defaultkey);
    rtn += "</select>&nbsp;";
    return rtn;
}

function renderSelectOption(list, currkey, defaultkey)
{
    var rtn = "";
    if (currkey == undefined||currkey == ""||currkey == "-1") {
        currkey = defaultkey;
    }
    for (var i = 0; i < list.length; i ++) {
        rtn += "<option value=\"" + list[i][1] + "\"";
        if (currkey == list[i][1])
            rtn += " selected";
        rtn += ">" + list[i][0] + "</option>";
    }
    return rtn;
}

function getFieldIndex(fstr) {
    for (var i = 0; i < allfields.length; i ++) {
        if (fstr == allfields[i]) {
            return i;
        }
    }
    return 0;
}

var data_align = {"string": "left", "int": "right", "double": "right", "date": "left", "control": "center"};

function openshow(link1)
{
    var windowopen = window.open;
	openwin=windowopen(link1 , "link1", "top=58,left=200,width=600,height=500,status=no,toolbar=no,menubar=no,scrollbars=no, resizable=no");    

}

function showForm(className, cmd, page, forms) {
    var str = '<form action="' + className + 'Action.jsp" method="post" name="' + className + 'Form" id="' + className + 'Form">';
    str += '<input type="hidden" name="cmd" value="' + cmd + '">';
    str += '<input type="hidden" name="page" value="' + page + '">';
    str += forms;
    str += '<table border="0" width="100%" cellspacing="0">';
    for (var i = 0; i < allfields.length; i ++) {
        var gsname = allfields[i];
        var edit = dic[allfields[i]].edit;
        var width = parseInt(dic[allfields[i]].width);
        if (edit == "none") {
        } else if (edit == "hidden") {
            str += '<input type="hidden" name="' + gsname + '" value="' + form[allfields[i]] + '">';
        } else if (edit == "text" || edit == "readonly") {
            str += '<tr><td>';
            str += '<div align="right">' + dic[allfields[i]].name + '</div>';
            str += '</td><td>';
            var readonly = "";
            if (edit == "readonly") {
                readonly = " readonly";
            }
            if (dic[allfields[i]].type == 'string') {
                if (width > -1 && width <= 80) {
                    str += '<input name="' + gsname + '" size="' + width + '" value="' + form[allfields[i]] + '"' + readonly + '>';
                } else if (width == -1) {
                    str += '<textarea name="' + gsname + '" cols="80" rows="5"' + readonly + '>' + form[allfields[i]] + '</textarea>';
                } else {
                    str += '<textarea name="' + gsname + '" cols="80" rows="' + (width / 80 + 1) + '"' + readonly + '>' + form[allfields[i]] + '</textarea>';
                }
            } else {
                str += '<input name="' + gsname + '" value="' + form[allfields[i]] + '"' + readonly + '>';
            }
            str += '</td></tr>';
        } else {
            str += '<tr><td>';
            str += '<div align="right">' + dic[allfields[i]].name + '</div>';
            str += '</td><td>';
            str += renderSelect(options[edit + "options"], form[allfields[i]], gsname, "", "");
            str += '</td></tr>';
        }
    }
    str += '</table></form>';
    document.getElementById("form").innerHTML = str;
}

function prepareForm(className, dic, uPower) {
    for (var key in dic) {
        if (key != "" && dic[key][4] != "") {
            if (dic[key][4].indexOf(uPower) < 0) {
                document.postForm[key].style.readonly = true;
                //document.getElementById('postForm' + key).style.display = "none";
            }
        }
    }
}

function deleteThis(className, id, url_para)
{
    if (!url_para)
        url_para = "";
    if (confirm("确实要删除记录吗?")) {
        location = className + "Action.jsp?cmd=delete&" + keyfield + "=" + id + ((url_para.length == 0) ? "" : "&" + url_para); 
    }
}
//some form has new record button
function addNew(className, url_para)
{
    if (!url_para)
        url_para = "";
    location = className + "Action.jsp?cmd=create" + ((url_para.length == 0) ? "" : "&" + url_para); 
}

	//jxlnote:特别注意：附件上传时中文字符处理问题		
	function ReplaceAll(oriStr,oldStr,newStr){   
	    if(oriStr == null || oriStr == "")   
	        return "";   
	    if(oriStr.indexOf(oldStr) == -1)   
	        return oriStr;   
	    oriStr = oriStr.replace(oldStr,newStr);   
	    return ReplaceAll(oriStr, oldStr, newStr);   
	}  