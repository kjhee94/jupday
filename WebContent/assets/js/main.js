/**
 * 
 */

$( document ).ready( function(){
	//swiper
	var swiper = new Swiper(".mySwiper", {
        slidesPerView: 3,
        spaceBetween: 30,
        slidesPerGroup: 3,
        loop: true,
        loopFillGroupWithBlank: true,
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev"
        }
      });
	
	//이달의 리뷰 마우스 hover시 제목,댓글,좋아요 표시
	$(".swiper-slide").hover(function() {
		$(this).find(".box-review-hover").css("display", "block");
		$(this).find("img").css("transform", "scale(1.1)");
	}, function(){
		$(this).find(".box-review-hover").css("display", "none");
		$(this).find("img").css("transform", "scale(1)");
	});
	
	//줍데이 소식 버튼 누르면 게시판들이 나오도록
	$("#notice").click(function(){
		$("#campaign").removeClass("check");
		$(".box-campaign-list").css('display', 'none');
		
	    $(this).addClass("check");
	    $(".box-notice-list").css('display', 'block');
	    
	});
	$("#campaign").click(function(){
	    $("#notice").removeClass("check");
	    $(".box-notice-list").css('display', 'none');
	    
	    $(this).addClass("check");
		$(".box-campaign-list").css('display', 'block');
	});
	
});
