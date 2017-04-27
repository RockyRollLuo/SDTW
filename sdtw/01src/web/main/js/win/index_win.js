
/*
 * 获取站内信数量
 */
function getShortMsg(){
	$.ajax({
		url:'shortMessage/ShortMessageAction.jsp?cmd=scount',
		success:function(num){
			if(parseInt(num) > 0){
				receiveMessages("您有"+num+"条信息待查看<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a style='float:right;font-weight:bold;' target='mainFrame' href='javascript:void(0);' onclick=showDetail('shortMessage/ShortMessageAction.jsp?cmd=list&_SmsStyle_=2&_orsee_=6&_ReceiveIds_=" + userId + "')>点击查看</a>");
			}
		},
		error:function(){
			alert("站内信获取error！");
		}
	});
}

function showDetail(detail){
	$('#mainFrame').attr('src',detail);
	Message.close();
}

/*
 * 新消息提醒
 */
function receiveMessages(messages) {
	Message.init();
	Message.setContent(messages);
	Message.open();
	audioRemind();
}
jQuery.extend({
	browser: function() 
	{
		var
	    rwebkit = /(webkit)\/([\w.]+)/,
	    ropera = /(opera)(?:.*version)?[ \/]([\w.]+)/,
	    rmsie = /(msie) ([\w.]+)/,
	    rmozilla = /(mozilla)(?:.*? rv:([\w.]+))?/,    
	    browser = {},
	    ua = window.navigator.userAgent,
	    browserMatch = uaMatch(ua);

	    if (browserMatch.browser) {
	        browser[browserMatch.browser] = true;
	        browser.version = browserMatch.version;
	    }
	    return { browser: browser };
	},
});

function uaMatch(ua) 
{
        ua = ua.toLowerCase();

        var match = rwebkit.exec(ua)
                    || ropera.exec(ua)
                    || rmsie.exec(ua)
                    || ua.indexOf("compatible") < 0 && rmozilla.exec(ua)
                    || [];

        return {
            browser : match[1] || "",
            version : match[2] || "0"
        };
}
/*
 * 声音提醒
 */
function audioRemind(fsrc){
	var str = "" , music = 'images/ring.wav';
	if(fsrc != undefined ){
		music = fsrc;
	}
	if($.browser.msie && $.browser.version=='8.0'){ 
		str = '<div><embed id="media" src="' + music + '" autostart=false/></div>'; 
	}else{ 
		//IE9+,Firefox,Chrome均支持<audio/> 
		str = '<div><audio id="media"><source src="' + music + '"' 
		+ 'type="audio/wav"/></audio></div>'; 
	} 
	if($('#media')[0] == undefined){
		$(function(){
			$('body').append(str);
			$('#media')[0].play();
		});
	}else
		$('#media')[0].play();
}
