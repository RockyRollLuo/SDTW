function onLoad()
{
    jsonrpc = new JSONRpcClient(GBasePath + "/JSON-RPC");
}
function mount(am){
//判断是否是数字
	if(isNaN(am.value))
	{
		alert("请输入合法数字");
		am.value="";
		return false;
	}
	return true;
}
function loadAsync(sUri, uFunc) {
    var xmlHttp = XmlHttp.create();
    var async = true;
    xmlHttp.open("GET", sUri, async);
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4) {
            uFunc(stripHtml(xmlHttp.responseText)); // responseXML : XmlDocument
        }
    }
    xmlHttp.send(null);
}

function loadSync(sUri, isStrip) {
    var xmlHttp = XmlHttp.create();
    var async = false;
    xmlHttp.open("GET", sUri, async);
    xmlHttp.send(null);
    if (isStrip == undefined || isStrip) {
        return stripHtml(xmlHttp.responseText); // responseXML : XmlDocument
    } else {
        return xmlHttp.responseText; // responseXML : XmlDocument
    }
}

function stripHtml(s) {
    return s.replace(/\t/g, "").replace(/\n/g, "");
}

function openWindow(url, opensize, target) {
    openWindowWithReturn(url, opensize,target);
}

function openWindowWithReturn(url, opensize,target) {
    var win;
    if (target == null)
    {
        target = "";
    }
    window.open_new = window.open;//避免弹出窗口被屏蔽。
    if (opensize == undefined || opensize == "fullscreen") {
        win = window.open_new(url,"","status=no,toolbar=no,menubar=no,scrollbars=no,resizable=no");
        win.moveTo(0,0);
        win.resizeTo(screen.width,screen.height-25);
    } else {
        wh = ["600", "500"];
        if (opensize.indexOf(",") > 0) {
            wh = opensize.split(",");
        }
        var style = "top=" + (screen.height - wh[1]) / 2 + ",left=" + (screen.width - wh[0]) / 2 + ",width=" + wh[0] + ",height=" + wh[1] + ",status=no,toolbar=no,menubar=no,scrollbars=yes,resizable=yes";
        win = window.open_new(url, target, style);
    }
    return win;
}

function showObject(obj) {
    var str = "";
    for (key in obj) str += key + ":" + obj[key] + "\n";
    alert(str);
}

String.prototype.trim= function() 
{ 
    // 用正则表达式将前后空格 
    // 用空字符串替代。 
    return this.replace(/(^\s*)|(\s*$)/g, ""); 
}

function trim(str) {
    return str.replace(/(^\s*)|(\s*$)/g, ""); 
}

function filterValue(str) {
    var tmp = str;
    tmp = tmp.replace(/\'/g," ");
    tmp = tmp.replace(/\"/g," ");
    tmp = tmp.replace(/\,/g," ");
    tmp = tmp.replace(/\r/g," ");
    tmp = tmp.replace(/\n/g," ");
    return tmp; 
}

function exit()
{
    if(confirm("您点击了注销按钮，确信要退出本系统吗？"))
        window.location.href = GBasePath + "/logoff.jsp";				
}
//打开留言窗口
function openwin(loadpos){
    openWindow(loadpos,'640,480');
}
function openwin1(loadpos){
    openWindow(loadpos,'430,230');
}
//屏蔽鼠标右键
function click(e) 
{
    if (document.all)
    {
        if (event.button==2||event.button==3)
        {
            oncontextmenu='return false';
        }
    }
    if (document.layers)
    {
        if (e.which == 3)
        {
            oncontextmenu='return false';
        }
    }
}
function CloseWin()
{
    var ua = navigator.userAgent;
    var ie = navigator.appName=="Microsoft Internet Explorer"?true:false;
    if(ie){
        var IEversion = parseFloat(ua.substring(ua.indexOf("MSIE ")+5,ua.indexOf(";",ua.indexOf("MSIE "))));
        if(IEversion< 5.5){
            var str  = '<object id=noTipClose classid="clsid:ADB880A6-D8FF-11CF-9377-00AA003B7A11">';
            str += '<param name="Command" value="Close"></object>';
            document.body.insertAdjacentHTML("beforeEnd", str);
            document.all.noTipClose.Click();
        }else{
            window.opener = null;
            window.close();
        }
    }else{
        window.close()
    }
}

function Transform()
{
    var whole = document.all.num.value;

    //分离整数与小数
    var num;
    var dig;
    if(whole.indexOf(".") == -1)
    {
        num = whole;
        dig = "";
    }
    else
    {
        num = whole.substr(0,whole.indexOf("."));
        dig = whole.substr( whole.indexOf(".")+1, whole.length);
    }

    //转换整数部分
    var i=1;
    var len = num.length;

    var dw2 = new Array("","万","亿");//大单位
    var dw1 = new Array("拾","佰","千");//小单位
    var dw = new Array("","壹","贰","叁","肆","伍","陆","柒","捌","玖");//整数部分用
    var dws = new Array("零","壹","贰","叁","肆","伍","陆","柒","捌","玖");//小数部分用
    var k1=0;//计小单位
    var k2=0;//计大单位
    var str="";

    for(i=1;i<=len;i++)
    {
        var n = num.charAt(len-i);
        if(n=="0")
        {
            if(k1!=0)
                str = str.substr( 1, str.length-1);
        }

        str = dw[Number(n)].concat(str);//加数字

        if(len-i-1>=0)//在数字范围内
        {
            if(k1!=3)//加小单位
            {
                str = dw1[k1].concat(str);
                k1++;
            }
            else//不加小单位，加大单位
            {
                k1=0;
                var temp = str.charAt(0);
                if(temp=="万" || temp=="亿")//若大单位前没有数字则舍去大单位
                    str = str.substr( 1, str.length-1);
                str = dw2[k2].concat(str);
            }
        }


        if(k1==3)//小单位到千则大单位进一
        {
            k2++;
        }

    }

    //转换小数部分
    var strdig="";
    for(i=0;i<2;i++)
    {
        var n = dig.charAt(i);
        strdig += dws[Number(n)];//加数字
    }

    str += " 点 "+strdig;

    document.all.text.value = str;
}

function include(path,type,title){
	var s,i,t;
	if(arguments.length < 1){
		return ;
	}
	if(arguments.length == 1){
		type = "js";
	}
	switch(type.toLowerCase()){
		case "css":
				t = document.getElementsByTagName("link");
				for(i=0;i<t.length;i++){
					if(t[i].href && t[i].href.indexOf(path)!=-1){
						return;
					}
				}
				s=document.createElement("link");
				s.rel="alternate stylesheet";
				s.type="text/css";
				s.href=path;
				s.title=title;
				s.disabled=false;
				break;
		case "js":
		case "javascript":
		default:
				t = document.getElementsByTagName("script");
				for(i=0;i<t.length;i++){
					if(t[i].src && t[i].src.indexOf(path)!=-1){
						return;
					}
				}
				s=document.createElement("script");
				s.type="text/javascript";
				s.src=path;
			break;
	}
	var h=document.getElementsByTagName("head")[0];
	h.appendChild(s);
}
//字符处理;
//去左右空格; 
function trim(s){
 	return rtrim(ltrim(s)); 
}
//去左空格; 
function ltrim(s){
 	return s.replace( /^\s*/, ""); 
} 
//去右空格; 
function rtrim(s){ 
 	return s.replace( /\s*$/, ""); 
}
//验证信息;
//空字符值; 
function isEmpty(s){
	s = trim(s); 
	return s.length == 0; 
}
//Email;
function isEmail(s){
	s = trim(s); 
 	var p = /^[_\.0-9a-z-]+@([0-9a-z][0-9a-z-]+\.){1,4}[a-z]{2,3}$/i; 
 	return p.test(s);
}
//数字; 
function isNumber(s){
	return !isNaN(s); 
}
//颜色值; 
function isColor(s){ 
	s = trim(s); 
	if (s.length !=7) return false; 
	return s.search(/\#[a-fA-F0-9]{6}/) != -1; 
}
//手机号码; 
function isMobile(s){ 
	s = trim(s); 
	//var p =/^(13|15|18)\d{9}/; 
	var p=/^(((13[0-9]{1})|159|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/
	return p.test(s);
}
//身份证;
function isCard(s){ 
	s = trim(s); 
	var p = /^\d{15}(\d{2}[xX0-9])?$/; 
	return p.test(s);
}
//URL;
function isURL(s){
	s = trim(s).toLowerCase();
	var p = /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
	return p.test(s);
}
//Phone;
function isPhone(s){
	s = trim(s);
	var p = /^((\(\d{3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}$/;
	return p.test(s);
}
//邮编;
function isZip(s){
	s = trim(s);
	var p = /^[1-9]\d{5}$/;
	return p.test(s);
}
//Double;
function isDouble(s){
	s = trim(s);
	var p = /^[-\+]?\d+(\.\d+)?$/;
	return p.test(s);
}
//Integer;
function isInteger(s){
	s = trim(s);
	var p = /^[-\+]?\d+$/;
	return p.test(s);
}
//English;
function isEnglish(s){
	s = trim(s);
	var p = /^[A-Za-z]+$/;
	return p.test(s);
}
//中文;
function isChinese(s){
	s = trim(s);
	var p = /^[\u0391-\uFFE5]+$/;
	return p.test(s);
}

//双字节
function isDoubleChar(s){
	var p = /^[^\x00-\xff]+$/;
	return p.test(s);
}
//含有中文字符
function hasChineseChar(s){
	var p = /[^\x00-\xff]/;
	return p.test(s);
}
//非法字符
function hasstrangecode(code){
	var strangCode="~`#%^&\'\"<>";  
    var temp;  
    for (var i=0;i<code.length;i++){  
        temp=code.substring(i,i+1);  
           if(strangCode.indexOf(temp)   !=-1){  
              return   false;  
           }  
      }  
       return   true;  
}
//帐号字符过滤
function hasAccountChar(s){
	var p = /^[a-zA-Z0-9][a-zA-Z0-9_-]{0,15}$/;
	return p.test(s);
}
function limitLen(s,Min,Max){
	s=trim(s);
	if(s=="") return false;
	if((s.length<Min)||(s.length>Max))
		return false;
	else
		return true;
}
//功能;
//延时事件;
function setDeferEvent(type,action,time){
	if (trim(time).length == 0) time = 1;
	if (typeof(time)!="number") time = 1;
	
	switch(type.toLowerCase()){
		case "go":
			window.setTimeout("window.location='"+ action +"'",time);
			break;
		case "alert":
			window.setTimeout("alert('"+ action +"')",time);
			break;
		case "js":
		case "javascript":
			window.setTimeout("'"+ action.toString() +"'",time);
			break;
		default:
			alert("Nothing will do!");
			break
	}		
}
function addLoadListener(handler){
	if (typeof window.addEventListener != 'undefined')
		window.addEventListener('load', handler, false);
	else if (typeof document.addEventListener != 'undefined')
		document.addEventListener('load', handler, false);
	else if (typeof window.attachEvent != 'undefined')
		window.attachEvent('onload', handler);
};
function addEventListener(element, eventType, handler, capture)
{
	try
	{
		if (element.addEventListener)
			element.addEventListener(eventType, handler, capture);
		else if (element.attachEvent)
			element.attachEvent("on" + eventType, handler);
	}
	catch (e) {}
};

function removeEventListener(element, eventType, handler, capture)
{
	try
	{
		if (element.removeEventListener)
			element.removeEventListener(eventType, handler, capture);
		else if (element.detachEvent)
			element.detachEvent("on" + eventType, handler);
	}
	catch (e) {}
};
//Image;
function preloadImages(){
	var d = document;
	if(d.images){
		if(!d.p_i_a) d.p_i_a = new Array();
		var i,j=d.p_i_a.length,a=arguments;
		for(i=0;i<a.length;i++){
			d.p_i_a[j]= new Image();
			d.p_i_a[j++].src = a[i];
		}
	}
}
//Ajax功能;
function loadAjaxElement(e,u,p,f,l){
	if(arguments.length < 3){
		return ;
	}
	o = $(e);
	o.innerHTML = l;
	p = $H(p).toQueryString();
	new Ajax.Updater(					 
                    {success: e},
                    u,
                    {method: 'get', parameters: p, onFailure: f});
}
function loadAjaxData(u,p,s,f){
	if(arguments.length < 3){
		return ;
	}
	p = $H(p).toQueryString();
	new Ajax.Request(					 
                    u,
                    {method: 'get', parameters: p, onSuccess:s,onFailure: f});
}
function sendAjaxElement(e,u,p,f,l){
	if(arguments.length < 3){
		return ;
	}
	o = $(e);
	o.innerHTML = l;
	p = $H(p).toQueryString();
	new Ajax.Updater(					 
                    {success: e},
                    u,
                    {method: 'post', parameters: p, onFailure: f});
}
function sendAjaxData(u,p,s,f){
	if(arguments.length < 3){
		return ;
	}
	p = $H(p).toQueryString();
	new Ajax.Request(					 
                    u,
                    {method: 'post', parameters: p, onSuccess:s,onFailure: f});
}