	function uploadOtherAttatch(AttachType,FromClass){//上传其他附件
				var name=document.getElementById('OtherAttach').value;
			    $("#load1")
			    .ajaxStart(function(){
			        $(this).show();
			    })
			    .ajaxComplete(function(){
			        $(this).hide();
			    });
			    $.ajaxFileUpload
			    (
			        {
			            url:'../../main/common/upload.jsp?cmd=otherattachAll&AttachType='+AttachType+'&FromTable='+FromClass,
			            secureuri:false,
			            fileElementId:'OtherAttach',
			            type:'post',	
			            dataType: 'json',
			            success: function (data, status)
			            {
			                if(typeof(data.error) != 'undefined')
			                {
			                    if(data.error != '')
			                    {                    
			                        alert(data.error);
			                    }else
			                    {
			                    	 if(document.postForm.AddFileList.value==""){
			                         	var be = data.url.indexOf("=");
			                         	var en = data.url.lastIndexOf("/");
			                         	document.postForm.AddFileList.value = data.ids;
			                         }else{
			                            var be = data.url.indexOf("=");
			                         	var en = data.url.lastIndexOf("/");
			                         	document.postForm.AddFileList.value += ","+data.ids; 
			                         } 
			                        var table = document.getElementById('ShowFiles');
			                        var num = table.rows.length;
			                        var row = table.insertRow(num);
			                        var filename = data.url.replace(/.*(\/|\\)/, "");
			                        filename = data.name;
			                        var cell = row.insertCell(0);
			                        row.id = data.ids;//修改时以防和之前重名
			                        cell.innerHTML =  '<img src=\'../../main/images/file1.gif\'/>'+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'../../main/images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("'+filename+'",'+data.ids+');\' style="cursor:point;"/>';
			                        
			                    }
			                }
			            },
			            error: function (data, status, e)
			            {
			                alert("上传文件失败，请重新上传！");
			            }
			        }
			    )
			}
			
			function checkFileType(AttachType,FromClass){//上传文档格式过滤
				var file=document.getElementById('OtherAttach').value;
				if(file){
					var allowType = {"doc":"","docx":""};
					var filename=file.replace(/.*(\/|\\)/, "");//jquery获得文件名
					var fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : '';//jquery获得后缀名
					if((fileExt+"").toLowerCase() in allowType){
						uploadOtherAttatch(AttachType,FromClass);
					}
					else{
						alert("上传文件格式不符合要求，请重新选择！");
					}
				}
				return false;
			}
			
			function deleteUpdateFile(name,id){//删除修改时上传附件
				if(confirm('是否确定删除？')){
					$.ajax({
						type:"post",			
						url:"../../main/common/upload.jsp?cmd=delAttach&did="+id,
						dataType:"json",
						beforeSend:function(){
							$("#load1").show();
						},
						success:function(data, status, e){
				        	if(typeof(data.error) != 'undefined'){
			                    if(data.error != '')
			                    {
			                        alert(data.error);
			                    }else
			                    {
			                    	$("#load1").hide();
			        				var row = document.getElementById(id);
			        				for(var i=0;i<row.cells.length;i++){
			        					row.deleteCell(i);
			        				}
			        				var files = document.postForm.AddFileList.value;
			        				//alert(files+" "+id+" "+files.indexOf(id))
			        				if(files.indexOf(id)!=-1){
			        					//替换删掉的附件id
			        					files = ","+files+",";
			        					files = files.replace(","+id+",",',');
			        					//没有附件的情况
			        					if(files.indexOf(",")==files.lastIndexOf(","))
			        						files = "";
			        					else{
			        						files = files.substring(1,files.length-1);
			        					}
			        					document.postForm.AddFileList.value = files;
			        				}
			                    }
			                }
			             },
			            error: function (data, status, e){
			            	$("#load1").hide();
			                alert("删除文件失败!");
			            }
					});
				}
				return false;
			}
			function checkClientAttach(){
				var IsatSchool = $('#IsatSchool').val();
				if(IsatSchool!=1){
					$('#ClientAttach').show();
				}else{
					$('#ClientAttach').hide();
				}
			}