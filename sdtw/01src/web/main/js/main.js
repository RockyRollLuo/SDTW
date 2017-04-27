function AutoIframe(frameId)
{
	var ifobj = document.getElementById(frameId);
	if (ifobj.contentWindow.document.readyState != 'complete')
	{	
		setTimeout( function() {
			AutoIframe(frameId);
		}, 400);
		return;
	}
	else
	{
		var h1 = ifobj.contentWindow.document.documentElement.scrollHeight;
		var h2 = ifobj.contentWindow.document.body.scrollHeight;
		ifobj.height = Math.max(h1, h2);
	}
}
function DrawImage(ImgD,iwidth,iheight){
    //参数(图片,允许的宽度,允许的高度)
    var flag=false;
    var image=new Image();
    image.src=ImgD.src;
    if(image.width>0 && image.height>0){
    flag=true;
    if(image.width/image.height>= iwidth/iheight){
        if(image.width>iwidth){  
        ImgD.width=iwidth;
        ImgD.height=(image.height*iwidth)/image.width;
        }else{
        ImgD.width=image.width;  
        ImgD.height=image.height;
        }
        ImgD.alt=image.width+"×"+image.height;
        }
    else{
        if(image.height>iheight){  
        ImgD.height=iheight;
        ImgD.width=(image.width*iheight)/image.height;        
        }else{
        ImgD.width=image.width;  
        ImgD.height=image.height;
        }
        ImgD.alt=image.width+"×"+image.height;
        }
    }
} 
function DrawImageW(ImgD,iwidth){
	var flag=false;
    var image=new Image();
    image.src=ImgD.src;
    if(image.width>0 && image.height>0){
    flag=true;
	if(image.width>iwidth){  
        ImgD.width=iwidth;
        ImgD.height=(image.height*iwidth)/image.width;
    }else{
	    ImgD.width=image.width;  
	    ImgD.height=image.height;
    }
    ImgD.alt=image.width+"×"+image.height;
    }
}
//fckeditor中的文本
function getEditorTextContents(EditorName) {
	var oEditor = FCKeditorAPI.GetInstance(EditorName);
	return(oEditor.EditorDocument.body.innerText);
}

