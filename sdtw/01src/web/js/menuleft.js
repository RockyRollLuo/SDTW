/*ԭʼ�����˵�*/
//$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
//$(".leftsidebar_box dt img").attr("src","images/left/select_right.png");
//$(function(){
//	$(".leftsidebar_box dd").hide();
//	$(".leftsidebar_box dt").click(function(){
//		$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
//		$(this).css({"background-color": "#317eb4"});
//		$(this).parent().find('dd').removeClass("close_menu");
//		$(".leftsidebar_box dt img").attr("src","images/left/select_right.png");
//		$(this).parent().find('img').attr("src","images/left/select_down.png");
//		$(".close_menu").slideUp(); 
//		$(this).parent().find('dd').slideToggle();
//		$(this).parent().find('dd').addClass("close_menu");
//	});
//});


/*��˵�*/
$(function(){
	$("dd").hide();
	$(".two").hide();
	//����ˆ��е�һ�������¼�
	$(".one-three").click(function(){ 
		$(this).parent().find('.two').removeClass("close_menu");
		$(this).parent().find('dd').removeClass("close_menu");
		$(".close_menu").slideUp(); 

		if($(this).parent().find('.two').is(":hidden")){
		    $(this).parent().find('.two').slideDown();
		    $(this).parent().find('.one-three-two').slideDown();     //�D����У��ѵ������ӵ�һ��
		    $(this).parent().find('.two').css({"background-color": "#317eb4"});
		}else if($(this).parent().find('.two').is(":visible")){
		    $(this).parent().find('.two').slideUp();
		    $(this).parent().find('dd').slideUp();
		    $(this).parent().find('.two').css({"background-color": "#3992d0"});
		}
		$(this).parent().find('.two').addClass("close_menu");
	    $(this).parent().find('dd').addClass("close_menu");
	});

	//����ˆ��еĶ��������¼�
	$(".two").click(function(){
		if($(this).parent().find('dd').is(":hidden")){
		    $(this).parent().find('dd').slideDown();
		    $(this).parent().find('img').attr("src","../images/menuico/arrowdown.png");
		}else if($(this).parent().find('dd').is(":visible")){
		    $(this).parent().find('dd').slideUp();
		    $(this).parent().find('img').attr("src","../images/menuico/arrowright.png");
		}
	});
	
	//������ˆ��е�һ�������¼�
	$(".one-two").click(function(){
		//$(this).parent().find('dd').slideToggle();
		$(this).parent().find('.two').removeClass("close_menu");
		$(this).parent().find('dd').removeClass("close_menu");
		$(".close_menu").slideUp(); 
		
		if($(this).parent().find('dd').is(":hidden")){
		    $(this).parent().find('dd').slideDown();
		}else if($(this).parent().find('dd').is(":visible")){
		    $(this).parent().find('dd').slideUp();
		}
		$(this).parent().find('.two').addClass("close_menu");
	    $(this).parent().find('dd').addClass("close_menu");
	});

});
