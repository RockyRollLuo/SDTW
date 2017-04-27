
/*
 * 数据列表
 * param:classname-数据库表名,curpage=当前页,name-列表的标题，icon-列表图标，disnum-显示条数
 * showedit-显示编辑图标
 * funs  菜单按钮
 * addfuns  datagrid加载完调用
 */
function showList(classname,curpage,name,icon,url_para,shownum,showedit,funs,addfuns){
    if(icon==undefined||icon=="")
        icon = "icon-box";
    if(showedit==undefined)
        showedit=true;
    var pageListNum = [shownum];
    var edit = "",editheader="",fun;
    var tbdic = {
    		"search":"'-',{\
    	        text:'查询',\
    	        iconCls:'icon-search',\
    	        handler:function(){\
    	            var jsonvar = JSON.parse(\"\"+$(\"form\").form2json());\
		            $(\"#list\").datagrid('options').queryParams=jsonvar;\
		            $(\"#list\").datagrid('reload'); \
    	        }\
    	    }",
    		"add":"'-',{\
    	        text:'添加',\
    	        iconCls:'icon-add',\
    	        handler:function(){\
    	            addNew(classname, url_para);\
    	        }\
    	    }",
    	    "del":"'-',{\
			        text:'删除',\
			        iconCls:'icon-remove',\
			        handler:function(){\
			            deleteList(classname, url_para);\
			        }\
			    }",
        	"modify":"'-',{\
		        text:'修改',\
		        iconCls:'icon-edit',\
		        handler:function(){\
		            editSelect(classname);\
		        }\
		    }"
    	};
    var isArray = function(obj) { 
    	return Object.prototype.toString.call(obj) === '[object Array]'; 
    } 
    
    var hasEl = function(obj,el){
    	if(!isArray(obj))
    		return false;
    	for(var i in obj){
    		if(obj[i] == el)
    			return true;
    	}
    	return false;
    }
    if(funs == undefined || !isArray(funs)){
    	funs = ["search","add","del"];
    }
    if(showedit == true && !hasEl(funs,'modify')){
    	funs.push("modify");
    }

    
    for(var i in funs){
    	funs[i] = eval(tbdic[funs[i]]);
    }
    
    if(showedit!=undefined&&showedit==true){
        editheader = {
            title:'编辑',
            field:'opt',
            width:30,
            formatter:function(value,rec){
                return '<span class="l-btn-text icon-edit" style="padding-left: 20px;cursor:pointer;line-height:20pxx; " onclick="javascript:modifyRecord1(\''+classname+'\',\''+rec.Id+'\',\''+$('#list').datagrid('options').pageNumber+'\',\''+$('form').form2param()+'\',\'modify\')">&nbsp;</span>';
            }
        };
    }
if(editheader!="")
    header.push(editheader);
var h1 = document.documentElement.scrollHeight;
var h2 = document.body.scrollHeight;
var h = Math.max(h1, h2)-35;
var isAdd = false;
var param_tmp = url_para.split('&');
var url_para_tmp ='';
if(param_tmp.length > 0){
	url_para_tmp = '{'
	for(var i = 0 ; i< param_tmp.length; i++){
		var t1 = param_tmp[i].split('=');
		url_para_tmp += '"' + t1[0] + '":"' + t1[1] + '"';
		if(i < param_tmp.length -1)
			url_para_tmp += ',';
	}
	url_para_tmp += '}'
}
$('#list').datagrid({
    title:name,
    iconCls:icon,
    nowrap: false,
    striped: true,
    url:classname+"Action.jsp?cmd=json",
    queryParams:$.parseJSON(url_para_tmp),
    collapsible:true,
    loadMsg:'数据装载中...',
    remoteSort: true,
    pageList:pageListNum,
    pageSize:shownum,
    pageNumber:currpage,
    columns:[
    header
    ],
    onLoadSuccess:function(){
		var d1 = $('#list').datagrid('getData');
		if(d1.total==0){
			$("#datagrid-row-r1-1-0").html("");
			$(".datagrid-view .datagrid-body").html("");
			$(".datagrid-view2 .datagrid-body").html("<div style='text-align:center;font-size:14px;line-height:200px;' id='nomsg'>没有记录！</div>");
			$("#nomsg").attr("style","text-align:center;font-size:14px;width:"+$("#nomsg").parent().parent().width()+"px;text-align:center;line-height:200px;");
		}
		if(addfuns != undefined &&　!isAdd){
			isAdd = true;
			addfuns();
		}
	},
    toolbar:funs,

    rownumbers:true,
    pagination:true

});
//showData();
displayPage();
addSearchBar(classname);
//reloadurl_para(url_para);
}
function displayPage(){
    $('#list').datagrid('getPager').pagination({
        displayMsg:'当前显示从{from}到{to}共{total}记录'
    });
}
/*
 *展示本地json数据  需先定义json
 */
function showData(){
    $('#list').datagrid('loadData',rows1); 
}
/*
 *如果地址栏参数不为空的话，则重新加载下 datagrid数据
 */
function reloadurl_para(url_para){
    if(url_para!=""){
        $("#list").datagrid('options').queryParams=url_para2json(url_para);
        $("#list").datagrid('reload'); 
    }
}
function fixWidth(percent,sub)  
{  
    return (document.body.clientWidth-sub) * percent ; //这里你可以自己做调整  
}
function addSearchBar(classname){
    $(function(){
        // $("div .datagrid-toolbar").append("<table  width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><form action='"+classname+"Action.jsp' method='post'><tr><td>dd</td></tr></form></table>")
        $("div .datagrid-toolbar").append("<form action='"+classname+"Action.jsp' method='post'><table style=float:left  width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr></tr></table></form>")
        $(".cxbj").appendTo($("div .datagrid-toolbar form tr"));
        $("div .datagrid-toolbar").height("auto");
        resetGridHeight();
    });
}
function resetGridHeight(){
	if($.browser.msie && $.browser.version < 8){
		if($(".datagrid-view").height() == 0){
			setTimeout(resetGridHeight,10);
		}else{
			$(".datagrid-view").height($(".datagrid-view").height()-20);
		}
	}else{
		if($(".datagrid-view").height() == 0){
			setTimeout(resetGridHeight,10);
		}else{
			$(".datagrid-view").height($(".datagrid-view").height()-$(".cxbj").parent().parent().height()-20);
		}
	}
}
function editSelect(classname){
    if (!url_para)
        url_para = "";
    var chks = $('#list').datagrid('getSelections');
    var chkeds = new Array();
    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
        chkeds.push(chks[i].Id);
    }
    if (chkeds.length == 1) {
        modifyRecord1(classname,chkeds[0],$('#list').datagrid('options').pageNumber,$('form').form2param(),'modify');
    } else if(chkeds.length>1) {
        alert("只能选择一条记录！");
    }else{
        alert("未选择记录！");
    }
}
/*
 *删除选中数据
 */
function deleteList1(classname, url_para, page)
{
    if (!url_para)
        url_para = "";
    var chks = $('#list').datagrid('getSelections');
    var chkeds = new Array();
    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
        chkeds.push(chks[i].Id);
    }
    if (chkeds.length > 0) {
        if (confirm("确实要删除这些记录吗?")) {
            location = classname + "Action.jsp?cmd=deletelist&idlist=" + chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
        }
    } else {
        alert("未选择记录！");
    }
}
                            
function paramString2obj (serializedParams) {

    var obj={};
    function evalThem (str) {
        var attributeName = str.split("=")[0];
        var attributeValue = str.split("=")[1];
        if(!attributeValue){
            return ;
        }

        var array = attributeName.split(".");
        for (var i = 1; i < array.length; i++) {
            var tmpArray = Array();
            tmpArray.push("obj");
            for (var j = 0; j < i; j++) {
                tmpArray.push(array[j]);
            };
            var evalString = tmpArray.join(".");
            // alert(evalString);
            if(!eval(evalString)){
                eval(evalString+"={};");               
            }
        };
        eval("obj."+attributeName+"='"+decodeURIComponent(attributeValue)+"';");

    };

    var properties = serializedParams.split("&");
    for (var i = 0; i < properties.length; i++) {
        evalThem(properties[i]);
    };

    return obj;
}
                            
function paramString2objreplaceXX (serializedParams) {

    var obj={};
    function evalThem (str) {
        var attributeName = str.split("=")[0];
        var attributeValue = str.split("=")[1];
        if(!attributeValue){
            return ;
        }

        var array = attributeName.split(".");
        for (var i = 1; i < array.length; i++) {
            var tmpArray = Array();
            tmpArray.push("obj");
            for (var j = 0; j < i; j++) {
                tmpArray.push(array[j]);
            };
            var evalString = tmpArray.join(".");
            // alert(evalString);
            if(!eval(evalString)){
                eval(evalString+"={};");               
            }
        };
        eval("obj."+attributeName+"='"+decodeURIComponent(attributeValue.replace(/XX/g,"%"))+"';");

    };

    var properties = serializedParams.split("&");
    for (var i = 0; i < properties.length; i++) {
        evalThem(properties[i]);
    };

    return obj;
}

/*
 * 将表单数据转换为json
 */
$.fn.form2json = function(){
    var serializedParams = this.serialize();
    var obj = paramString2obj(serializedParams);
    return JSON.stringify(obj);
}
                            
/*
 * 将地址栏参数转化为json数据
 */
function url_para2json(url_para){
    var obj = paramString2objreplaceXX(url_para);
    return  JSON.parse(""+JSON.stringify(obj));
}
                            
$.fn.form2param = function(){
    var serializedParams = this.serialize();
    var properties = serializedParams.split("&");
    var paramArr = new Array();
    for (var i = 0; i < properties.length; i++) {
        var attributeName = properties[i].split("=")[0];
        var attributeValue = properties[i].split("=")[1];
        if(!attributeValue){
            continue ;
        }
        paramArr.push(attributeName+"="+attributeValue.replace(/%/g,"XX"));
    }
    return paramArr.join("&");
}

/*
 * form表单页用来 自适应宽度
 */
$(function(){
    $('#dlgForm').dialog({
        width:fixWidth(0.98,0)
    });
})
