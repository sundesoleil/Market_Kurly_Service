//header.js
$(function(){
	$("#ad_close").click(function(e){
		e.preventDefault(); // a 태그의 href로 넘어가는 기능을 작동하지 않게 막음
		$(".header_ad").addClass("close");
	})
	$(".user_menu a:last-child, .service_popup").hover(function(){
		$(".service_popup").show();
	},
	function(){
		$(".service_popup").hide();
	})
	
	$("#user_name, .user_popup").hover(function(){
		$(".user_popup").show();
	}, function(){
		$(".user_popup").hide();
	})
	
	$(".main_menu li:first-child, .categories").hover(function(){
		$(".categories").show();
	}, function(){
		$(".categories").hide();
	})
})