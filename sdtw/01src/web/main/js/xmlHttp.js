function hideOrShow() {
	var dis = document.getElementById('formtable').style.display;
	if (dis == "" || dis == "block") {
		document.getElementById('formtable').style.display = 'none';
	} else {
		document.getElementById('formtable').style.display = 'block';
	}
}
function getXMLHTTPRequest() {
	var xmlHttp;
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlHttp;
}
var http;
function checkuser() {
	var email = document.getElementById("Email").value;
	if (isEmail(email) && email.length > 5) {
		http = getXMLHTTPRequest();
		var url = "ClientAction.jsp?emailvalue=" + email;
		if (http) {
			http.open("post", url, true);
			http.onreadystatechange = callback;
			http.send(null);
		}
	} else {
		document.getElementById("errorDiv").innerHTML = "邮箱格式不正确";
	}
}
function callback() {
	if (http.readyState == 4) {
		if (http.status == 200) {
			processResponse();
		}
	}
}

function processResponse() {
	var text = http.responseText;
	if (text==0){
		document.postForm.flag.value=1;
		document.getElementById("errorDiv").innerHTML = "该邮箱已经注册";
	}
	if(text==1){
		document.getElementById("errorDiv").innerHTML = "该邮箱可以使用";
	}
	
}
function checkclientform(){
	var flag=true;
	var card=document.getElementById("IDCardNo").value;
	var MobilePhone=document.getElementById("Mobile").value;
	var phone=document.getElementById("Tel").value;
	var Postcode=document.getElementById("Postcode").value;
	var cmd=document.postForm.cmd.value;
	if(document.postForm.cmd.value=="save"&&document.postForm.flag.value=="0"){
		flag=false;
	}
	if(!card==null&&!isCard(card)){
		flag=false;
		document.getElementById("errorDiv").innerHTML = "请填写有效身份证号";
	}
	if((MobilePhone=="")&&(phone=="")){
		document.getElementById("errorDiv").innerHTML = "手机、固定电话至少填写一项";
		flag=false;
	}
	var Expression=/(\d{3}-)(\d{8})$|(\d{4}-)(\d{7})$|(\d{3}-)(\d{7})$|(\d{4}-)(\d{8})$/;
	if(phone!=""&&!Expression.test(phone)){
		document.getElementById("errorDiv").innerHTML = "请填写正确的电话号码，区号和号码之间用-隔开";
		flag=false;
		}
	var myreg = /^(((13[0-9]{1})|159|153|158)+\d{8})$/;
	if(MobilePhone!=""&&!myreg.test(MobilePhone)&&MobilePhone.length!=11){
		document.getElementById("errorDiv").innerHTML = "请填写正确的手机号码";
		flag=false;
	}
	var rs=/\d{6}/;
	if (!rs.test(Postcode)||Postcode.length!=6) {
		document.getElementById("errorDiv").innerHTML="<span style=\"color: #c63230\">请检查邮编格式</span>";
		flag=false;
	}
	return flag;
}



//修改收货信息
function modify(value,targetForm,cityform) {
	specBoxAction('descArea','_specrely_','AlphaCover',true);
	var xmlHttp;
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}
	var aurl = "receiveAddress.jsp?cmd=modify&addressid="+value;
	var async = true;
	xmlHttp.open("POST", aurl, async);
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var returnValue = xmlHttp.responseText;
			//拆分返回的字符串 ,将收货地址信息拆分到对应的文本框
			var returnValues = returnValue.split(" ");
			//姓名
			var name=returnValues[0];
			document.ll1.Receivername1.value=name;
			//省份
			var Pid=returnValues[1];
			var provincename=returnValues[7];
			targetForm.options[0].text = provincename;
			targetForm.options[0].value = Pid;
			//城市
			var Cid=returnValues[2];
			var cityname=returnValues[8];
			cityform.options[0].text = cityname;
			cityform.options[0].value = Cid;
			//详细地址
			var address=returnValues[3];
			document.ll1.Address1.value=address;
			//邮编
			var code=returnValues[4];
			document.ll1.Postcode1.value=code;
			//电话
			var phone=returnValues[9];
			document.ll1.telephone1.value=phone;
			//手机
			var mobile=returnValues[5];
			document.ll1.MobilePhone1.value=mobile;
			var AddressId=returnValues[6];
			//将隐藏域中的地址信息ID改为被选中的地址信息ID
			document.ll1.addressid.value=AddressId;
		}
	}
	xmlHttp.send(null);
} 	//商品类别联动
function selectGoodsTypeByPid(sourceForm, targetForm, nextForm) {
	var xmlHttp;
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}
	var async = true;
	var pid = sourceForm.value;
	var aurl = "../common/xmlHttp.jsp?cmd=getGoodsTypeByPid&Pid=" + pid;
	xmlHttp.open("POST", aurl, async);
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var returnValue = xmlHttp.responseText;
			returnValue = returnValue.replace(/\r/g, "");
			returnValue = returnValue.replace(/\n/g, "");
			targetForm.options.length = 0;
			targetForm.options[0] = new Option();
			targetForm.options[0].value = "";
			targetForm.options[0].text = " ";
			var returnValues = returnValue.split(",");
			for ( var i = 0; i < returnValues.length; i++) {
				var r_v = returnValues[i].split("-");
				if (r_v[1] != undefined) {
					targetForm.options[i + 1] = new Option();
					targetForm.options[i + 1].value = r_v[0];
					targetForm.options[i + 1].text = r_v[1];
				}
			}
			targetForm.focus();
			if (nextForm) {
				nextForm.options.length = 0;
			}
		}
	}
	xmlHttp.send(null);
}
// 省市级别联动
function selectCityByProvinceid1(sourceForm, targetForm) {
	var xmlHttp;
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}
	var async = true;
	var pid = sourceForm.value;
	var aurl = "common/xmlHttp.jsp?cmd=getCityByPid&Pid=" + pid;
	xmlHttp.open("POST", aurl, async);
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var returnValue = xmlHttp.responseText;
			returnValue = returnValue.replace(/\r/g, "");
			returnValue = returnValue.replace(/\n/g, "");
			targetForm.options.length = 0;
			targetForm.options[0] = new Option();
			targetForm.options[0].value = "";
			targetForm.options[0].text = " ";
			var returnValues = returnValue.split(",");
			for ( var i = 0; i < returnValues.length; i++) {
				var r_v = returnValues[i].split("-");
				if (r_v[1] != undefined) {
					targetForm.options[i + 1] = new Option();
					targetForm.options[i + 1].value = r_v[0];
					targetForm.options[i + 1].text = r_v[1];
				}
			}
			targetForm.focus();
		}
	}
	xmlHttp.send(null);
}
function selectCityByProvinceid(sourceForm, targetForm) {
	var xmlHttp;
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}
	var async = true;
	var pid = sourceForm.value;
	var aurl = "../common/xmlHttp.jsp?cmd=getCityByPid&Pid=" + pid;
	xmlHttp.open("POST", aurl, async);
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var returnValue = xmlHttp.responseText;
			returnValue = returnValue.replace(/\r/g, "");
			returnValue = returnValue.replace(/\n/g, "");
			targetForm.options.length = 0;
			targetForm.options[0] = new Option();
			targetForm.options[0].value = "";
			targetForm.options[0].text = " ";
			var returnValues = returnValue.split(",");
			for ( var i = 0; i < returnValues.length; i++) {
				var r_v = returnValues[i].split("-");
				if (r_v[1] != undefined) {
					targetForm.options[i + 1] = new Option();
					targetForm.options[i + 1].value = r_v[0];
					targetForm.options[i + 1].text = r_v[1];
				}
			}
			targetForm.focus();
		}
	}
	xmlHttp.send(null);
}

function selectBankByPayMethod(sourceForm, targetForm) {
	var xmlHttp;
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}
	var async = true;
	var pid = sourceForm.value;
	//alert(pid);
	var aurl = "../../common/xmlHttp.jsp?cmd=getBankByPayMethod&Pid=" + pid;
	xmlHttp.open("POST", aurl, async);
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var returnValue = xmlHttp.responseText;
			returnValue = returnValue.replace(/\r/g, "");
			returnValue = returnValue.replace(/\n/g, "");
			targetForm.options.length = 0;
			targetForm.options[0] = new Option();
			targetForm.options[0].value = "";
			targetForm.options[0].text = " ";
			var returnValues = returnValue.split(",");
			for ( var i = 0; i < returnValues.length; i++) {
				var r_v = returnValues[i].split("-");
				if (r_v[1] != undefined) {
					targetForm.options[i + 1] = new Option();
					targetForm.options[i + 1].value = r_v[0];
					targetForm.options[i + 1].text = r_v[1];
				}
			}
			targetForm.focus();
		}
	}
	xmlHttp.send(null);
}
function checkcode(){
	var xmlHttp;
	var mail=document.getElementById("username1").value;
	if(mail.length<5){
		alert("请输入您的注册邮箱");
		return;
	}
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}
	var async = true;
	var checkcode = document.getElementById("checkcode").value;
	if(checkcode.length<4){
		alert("请输入验证码");
		return;
	}
	var url="checkcode.jsp?checkcode="+checkcode;
	xmlHttp.open("POST", url, async);
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var returnValue = xmlHttp.responseText;
			if(returnValue==0){
				alert("验证码不正确")
				return;
			}else{
				document.method1.submit();
			}
		}
	}
	xmlHttp.send(null);
}


