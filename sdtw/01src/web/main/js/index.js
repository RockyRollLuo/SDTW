function showsubmenu(sid) {
	var pre = 'submenu';
	var num = 0;
	var tmp ;
	if(typeof sid == 'number'){
		whichEl = $("#" + pre + sid)[0];
		num = $('div[id^=submenu_se]').length;
	}else{
		if(sid.indexOf('th_') == 0){
			pre = 'submenu_';
			tmp = sid.split('_');
			whichEl = $("#" + pre + sid)[0];
			num = $('div[id^=' + pre + tmp[0] + + '_' + tmp[1] + '_]').length;
		}else{
			pre = 'submenu_se_';
			tmp = sid.split('_');
			whichEl = $("#" + pre + sid)[0];
			num = $('div[id^=' + pre + tmp[0] + '_]').length;
		}
	}
	if (whichEl.style.display == "none") {
		$("#" + pre + sid).slideDown();
		for (var i = 1; i <= num; i++) {
			if(typeof sid != 'number' && i != parseInt(tmp[1])){
				if(sid.indexOf('th_') == 0 ){
					$("#" + pre + tmp[0] + '_' + tmp[1] + '_' + i).slideUp();
				}else
					$("#" + pre + tmp[0] + '_' + i).slideUp();
			}
			else if(i != sid) {
				$('#' + pre +i).slideUp();
			}
		}
	} else {
		$('#' + pre +sid).slideUp();
	}
}

/*
 * 资讯等打开窗口
 */
function showwin(id,title){
	/*document.getElementById("MyDiv").style.display='block';
	document.getElementById("fade").style.display='block' ;
	var bgdiv = document.getElementById("fade");
	bgdiv.style.width = document.body.scrollWidth;
	$("#fade").height($(document).height());
	var ajaxurl="information/InformationAction.jsp?cmd=selInfo&infoId="+id;
	infoajax(ajaxurl);*/
	parent.showDialog('site/publish/InfoEnter.jsp?&flag=tzgg&id='+id,parent.document.body.scrollWidth,$(parent.document).height(),title
			,{});
}

function showwinWs(id,title,w,h){
	/*document.getElementById("MyDiv").style.display='block';
	document.getElementById("fade").style.display='block' ;
	var bgdiv = document.getElementById("fade");
	bgdiv.style.width = document.body.scrollWidth;
	$("#fade").height($(document).height());
	var ajaxurl="information/InformationAction.jsp?cmd=selInfo&infoId="+id;
	infoajax(ajaxurl);*/
	parent.showDialog('site/publish/InfoEnter.jsp?&flag=tzgg&id='+id,w,h,title
			,{});
}

/*
 * 获取资讯等内容
 */
function infoajax(ajaxurl){
	$.ajax({url: ajaxurl,type: 'POST',dataType: 'html',timeout: 20000, async: false ,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
        alert(XMLHttpRequest.status);
        alert(XMLHttpRequest.readyState);
        alert(textStatus);
    	},
		success: function(msg){
			var index = msg.indexOf(":::");
			var sub = msg.substr(0,index);
			var con = msg.substr(index+3,msg.length);
			$("#sub").html(sub);
			$("#con").html(con);
			
		}
	});	
}

//站点
function showwinsite(id,title){
	/*document.getElementById("MyDiv").style.display='block';
	document.getElementById("fade").style.display='block' ;
	var bgdiv = document.getElementById("fade");
	bgdiv.style.width = document.body.scrollWidth;
	$("#fade").height($(document).height());
	var ajaxurl="site/publish/InfoAction.jsp?cmd=selInfo&Id="+id;
	infoajax(ajaxurl);*/
	parent.showDialog('site/publish/InfoEnter.jsp?id='+id,parent.document.body.scrollWidth,$(parent.document).height(),title
			,{});
}

function showwinsiteWs(id,title,w,h){
	/*document.getElementById("MyDiv").style.display='block';
	document.getElementById("fade").style.display='block' ;
	var bgdiv = document.getElementById("fade");
	bgdiv.style.width = document.body.scrollWidth;
	$("#fade").height($(document).height());
	var ajaxurl="site/publish/InfoAction.jsp?cmd=selInfo&Id="+id;
	infoajax(ajaxurl);*/
	parent.showDialog('site/publish/InfoEnter.jsp?id='+id,w,h,title
			,{});
}

/*
 * 关闭窗口
 */
function CloseDiv(show_div,bg_div)
{
	document.getElementById(show_div).style.display='none';
	document.getElementById(bg_div).style.display='none';
}

function getCookie(c_name)
{
	if (document.cookie.length>0)
	  {
	  c_start=document.cookie.indexOf(c_name + "=")
	  if (c_start!=-1)
	    { 
	    c_start=c_start + c_name.length+1 
	    c_end=document.cookie.indexOf(";",c_start)
	    if (c_end==-1) c_end=document.cookie.length
	    return unescape(document.cookie.substring(c_start,c_end))
	    } 
	  }
	return ""
}

function setCookie(c_name,value)
{
	var exdate= DateAdd("s",15,new Date());
	document.cookie=c_name+ "=" +escape(value)+";expires="+exdate.toGMTString();
}
function TimeCom( dateValue )
{
    var newCom = new Date( dateValue );
    this.year = newCom.getYear();
    this.month = newCom.getMonth()+1;
    this.day = newCom.getDate();
    this.hour = newCom.getHours();
    this.minute = newCom.getMinutes();
    this.second = newCom.getSeconds();
    this.msecond = newCom.getMilliseconds();
    this.week = newCom.getDay();
}

function DateDiff(interval,date1,date2)
{
    var TimeCom1 = new TimeCom(date1);
    var TimeCom2 = new TimeCom(date2);
    var result;
    switch(String(interval).toLowerCase())
    {
        case "y":
        case "year":
        result = TimeCom1.year-TimeCom2.year;
        break;
        case "n":
        case "month":
        result = (TimeCom1.year-TimeCom2.year)*12+(TimeCom1.month-TimeCom2.month);
        break;
        case "d":
        case "day":
        result = Math.round((Date.UTC(TimeCom1.year,TimeCom1.month-1,TimeCom1.day)-Date.UTC(TimeCom2.year,TimeCom2.month-1,TimeCom2.day))/(1000*60*60*24));
        break;
        case "h":
        case "hour":
        result = Math.round((Date.UTC(TimeCom1.year,TimeCom1.month-1,TimeCom1.day,TimeCom1.hour)-Date.UTC(TimeCom2.year,TimeCom2.month-1,TimeCom2.day,TimeCom2.hour))/(1000*60*60));
        break;
        case "m":
        case "minute":
        result = Math.round((Date.UTC(TimeCom1.year,TimeCom1.month-1,TimeCom1.day,TimeCom1.hour,TimeCom1.minute)-Date.UTC(TimeCom2.year,TimeCom2.month-1,TimeCom2.day,TimeCom2.hour,TimeCom2.minute))/(1000*60));
        break;
        case "s":
        case "second":
        result = Math.round((Date.UTC(TimeCom1.year,TimeCom1.month-1,TimeCom1.day,TimeCom1.hour,TimeCom1.minute,TimeCom1.second)-Date.UTC(TimeCom2.year,TimeCom2.month-1,TimeCom2.day,TimeCom2.hour,TimeCom2.minute,TimeCom2.second))/1000);
        break;
        case "ms":
        case "msecond":
        result = Date.UTC(TimeCom1.year,TimeCom1.month-1,TimeCom1.day,TimeCom1.hour,TimeCom1.minute,TimeCom1.second,TimeCom1.msecond)-Date.UTC(TimeCom2.year,TimeCom2.month-1,TimeCom2.day,TimeCom2.hour,TimeCom2.minute,TimeCom2.second,TimeCom1.msecond);
        break;
        case "w":
        case "week":
        result = Math.round((Date.UTC(TimeCom1.year,TimeCom1.month-1,TimeCom1.day)-Date.UTC(TimeCom2.year,TimeCom2.month-1,TimeCom2.day))/(1000*60*60*24)) % 7;
        break;
        default:
        result = "invalid";
    }
    return(result);
}

function DateAdd(interval, num, dateValue)
{
    var newCom = new TimeCom(dateValue);
    switch(String(interval).toLowerCase())
    {
        case "y": case "year": newCom.year += num; break;
        case "n": case "month": newCom.month += num; break;
        case "d": case "day": newCom.day += num; break;
        case "h": case "hour": newCom.hour += num; break;
        case "m": case "minute": newCom.minute += num; break;
        case "s": case "second": newCom.second += num; break;
        case "ms": case "msecond": newCom.msecond += num; break;
        case "w": case "week": newCom.day += num*7; break;
        default: return("invalid");
    }
    var now = newCom.year+"/"+newCom.month+"/"+newCom.day+" "+newCom.hour+":"+newCom.minute+":"+newCom.second;
    return(new Date(now));
}

/*
 * json 合并
 */
function mergeJson(targetJson, packJson){
    if(targetJson && packJson){
       for(var p in packJson){
           targetJson[p] = packJson[p];
       }
    }
}

/*
 * 窗口
 */
function showDialog(inURL,w,h,t,b){
	if(typeof w == 'undefined'){
		w = 400;
	}
	if(typeof h == 'undefined'){
		h = 400;
	}
	if(typeof t == 'undefined'){
		t = "对话框";
	}
	if(typeof b == 'undefined'){
		b = {"取消": function () {
	                $(this).dialog("close");
	            }
		};
	}else{
		mergeJson(b,{"取消": function () {
            $(this).dialog("close");
        }
		});
	}
	
	$("#top_dialog").load(inURL);
	
	
	$("#top_dialog").dialog({
		title:t,
		width:w,
		height:h,
		buttons:b,
		show:{ effect:'slide' , direction: "up"},
		hide:{ effect:'slide' , direction: "up"}
	});
	$("#top_dialog").dialog("open");
	$("#top_dialog").dialog();
}

function showSticky(msg,arg){
	$.sticky(msg,arg);
}


function getSeason(){
	var cur = new Date();
	var month = cur.getMonth()+1;
	var season = "dong";
	if(month >= 6 && month <= 8)
		season = "xia";
	else if(month >= 9 && month <= 11){
		season = "qiu";
	}else if(month >= 3 && month <= 5){
		season = "chun";
	}
	return season;
}
/*
 * 获取天气信息
 */
function getWeather(){
		if(weatherData.error != undefined){
			remoteWeather();
		}else{
			$('#temperature').text(weatherData[0].t1 + "°");
			curWeather = weatherData[0].w1;
	        var litmps = $('#future li');
	        for (var i = 0; i < 3; i++) {
	            $(litmps[i]).removeClass();
	            var tmp = eval('icon.' + getWeatherFlag(eval('weatherData['+i+'].w'+(i+1))));
	            if (tmp) {
	                $(litmps[i]).addClass(tmp);
	                if (ie6) {
	                    DD_belatedPNG.fix('.' + tmp);
	                }
	            } else {
	                $(litmps[i]).text(eval('weatherData['+i+'].w'+(i+1)));
	            }
	        }
	        getWeatherBg();
	        if (ie6) {
	            DD_belatedPNG.fix('.a001');
	            DD_belatedPNG.fix('.a002');
	            DD_belatedPNG.fix('.a003');
	            DD_belatedPNG.fix('.a004');
	        }
		}
}
function saveWeather(weatherdata){
	 $.ajax({
     	url:'basicinfo/WeatherAction.jsp?cmd=savejson',
     	data:JSON.stringify(weatherdata),
     	type:'POST',
     	dataType:'json',
     	contentType: "application/json; charset=utf-8",
     	success:function(data){
     		if(data.Id < 0)
     			alert('数据保存失败！');
     	},
     	error:function(e){
     		alert(e);
     	}
     });
}
function remoteWeather(){
    $.getScript('http://php.weather.sina.com.cn/iframe/index/w_cl.php?code=js&day=2&city=%BC%C3%C4%CF&dfc=1&charset=utf-8', function (a) {
        var s = "", r = "", q = "", flag = 0;
        for (s in window.SWther.w) {
            q = SWther.w[s][0];
            $('#temperature').text(q.t1 + "°");
            var litmps = $('#future li');
            saveWeather(SWther.w[s]);
            curWeather = SWther.w[s][0].s1;
            for (var i = 0; i < SWther.w[s].length; i++) {
                q = SWther.w[s][i];
                $(litmps[i]).removeClass();
                var tmp = eval('icon.' + getWeatherFlag(q.s1));
                if (tmp) {
                    $(litmps[i]).addClass(tmp);
                    if (ie6) {
                        DD_belatedPNG.fix('.' + tmp);
                    }
                } else {
                    $(litmps[i]).text(q.s1);
                }
            }
        }
        getWeatherBg();
        if (ie6) {
            DD_belatedPNG.fix('.a001');
            DD_belatedPNG.fix('.a002');
            DD_belatedPNG.fix('.a003');
            DD_belatedPNG.fix('.a004');
        }
    });
}
function getWeatherFlag(w) {
    if (w.indexOf('晴') > -1) {
        return '晴';
    } else if (w.indexOf('多云') > -1) {
        return '多云';
    } else if (w.indexOf('雨') > -1) {
        return '雨';
    } else if (w.indexOf('雪') > -1) {
        return '雪';
    } else if (w.indexOf('阴') > -1) {
        return '阴';
    } else if (w.indexOf('雾') > -1) {
        return '雾';
    } else if (w.indexOf('霾') > -1) {
        return '霾';
    } else if (w.indexOf('冰雹') > -1) {
        return '冰雹';
    }  else {
        return w;
    }
}
var py = {"雨":"yu","晴":"qing","多云":"duoyun","雪":"雪"};
/*
 * 天气背景
 */
function getWeatherBg(){
	var tmp = eval('bg.we.'+(eval('py.'+curWeather)));
	if(tmp == undefined){
		tmp = eval('bg.season.'+getSeason());
	}
	$('.weather').css('background-image','url(\'images/weather/'+tmp+'\')');
}
//getWeatherFlag('阴');
function Clock() {
    var date = new Date();
    this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    this.date = this.date < 10 ? "0" + this.date : this.date;
    this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
    this.suffix = "AM";
    if (parseInt(this.hour) > 12) {
        this.suffix = "PM";
    }

    this.toString = function () {
        return this.hour + ":" + this.minute + " " + this.suffix;
    };


    this.display = function (ele) {
        var clock = new Clock();
        ele.innerHTML = "" + clock.toString();
        window.setTimeout(function () {
            clock.display(ele);
        }, 1000);
    };
}