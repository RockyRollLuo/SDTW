		function AuditBaoMing(className, url_para, page,flag)
			{
			    var chks = document.getElementsByName("chk1");
			    if (!url_para)
			        url_para = "";
			    var chkeds = new Array();
			    for (var i = 0; i < chks.length; i ++) {  // 当前页面上有多条记录时
			        if (chks[i].checked == true) {
			            chkeds.push(chks[i].value);
			        }
			    }
			    var f = "通过";
			    if(flag==0){
			    	f = "不通过";
			    }
			    if (chkeds.length > 0) {
			        if (confirm("确实要审核"+f+"这些记录吗?")) {
			            location = className + "Action.jsp?cmd=auditsbaoming&CheckFlag="+flag+"&idlist=" + chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
			        }
			    } else {
			        alert("未选择记录！");
			    }
			}
			function AuditPass (className, url_para, page,flag) {
				 var chks = document.getElementsByName("chk1");
				    if (!url_para)
				        url_para = "";
				    var chkeds = new Array();
				    for (var i = 0; i < chks.length; i ++) {  // 当前页面上有多条记录时
				        if (chks[i].checked == true) {
				            chkeds.push(chks[i].value);
				        }
				    }
				    if (chkeds.length > 0) {
				        if (confirm("确实要晋级这些记录吗?")) {
				            location = className + "Action.jsp?cmd=auditspass&FinalRounds="+flag+"&idlist=" + chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
				        }
				    } else {
				        alert("未选择记录！");
				    }
			}
			function AuditHonor (className, url_para, page,flag) {
				    var val = new Array();
				    var ids = new Array();
				    var objs=document.getElementsByTagName( "select") 
				    for(var i=0;i <objs.length;i++) 
				    { 
					    if(objs[i].value!=""){
					    val.push(objs[i].value);
					    ids.push(objs[i].id);
					    }
				    }
				    
				   if (val.length > 0) {
					   debugger;
				        if (confirm("确实要提交级这些记录吗?")) {
				            var url = className + "Action.jsp?cmd=audithonor&val=" + val.join(',') +"&ids="+ids.join(',');
				        	$.ajax({
			                    type: "post",
			                    async:false,
			                    url: url,
			                    dataType: "json",
			                    cache: false,
			                    success: function(data){
			                              if (data.msg=='no') {
			                            	  alert("请按照说明分配奖项");
			                            	  return;
			                              } 
			                              if (data.msg=="ok") {
			                            	  alert("分配奖项成功");
			                            	  return;
			                              }
			                             },
			                             error : function() { 
			                                         // view("异常！");
			                                         alert( "异常！"); 
										}
			                });
				            
				        }
				    } else {
				        alert("未选择记录！");
				    } 
			}
			
			function getOptions(HonorType,ActivityId){
		    	var msg = new Array();
					$.ajax({
	                    type: "get",
	                    async:false,
	                    url: "CampusParticipateAction.jsp",
	                    data: {HonorType:HonorType,cmd:'HonorOptions' ,ActivityId:ActivityId},
	                    dataType: "json",
	                    cache: false,
	                    success: function(data){
	                            msg= data;
	                             },
	                             error : function() { 
	                                         // view("异常！");
	                                         alert( "异常！"); 
								}
	                });
				return msg;
			}
			
