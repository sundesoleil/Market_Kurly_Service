$(function(){
	$(".recommend_list").slick({
		slidesToShow:4,
		slidesToScroll:4,
		swipe:false,
		focusOnSelect:false,
		infinite:false
	});
	
	let current = 0; // 현재 보고 있는 배너의 번호
	let animate = false;
	
	$("#next").click(function(){
		if(animate) return;
		animate = true;
		// .banner_item들 중 첫번째 요소의 애니메이션을 우선 중지 시키고, left 좌표를 -100%로 
		// 애니메이션 하는데, 그 시간을 1000ms로 한다.
		$(".banner_item").eq(current).stop().animate({left:"-100%"}, 1000);
		current++;
		if(current >= $(".banner_item").length) current = 0;
		$(".banner_item").eq(current).css("left", "100%").stop().animate({left:"0%"}, 1000, function(){
			// 애니메이션 끝나고 재실행
			animate = false;
		});
	});
	
		$("#prev").click(function(){
		if(animate) return;
		animate = true;
		// .banner_item들 중 첫번째 요소의 애니메이션을 우선 중지 시키고, left 좌표를 -100%로 
		// 애니메이션 하는데, 그 시간을 1000ms로 한다.
		$(".banner_item").eq(current).stop().animate({left:"100%"}, 1000);
		current--;
		if(current < 0) current = $(".banner_item").length - 1;
		$(".banner_item").eq(current).css("left", "-100%").stop().animate({left:"0%"}, 1000, function(){
			// 애니메이션 끝나고 재실행
			animate = false;
		});
	});
	
	setInterval(function(){
		$("#next").trigger("click");
	}, 5000)
	
})