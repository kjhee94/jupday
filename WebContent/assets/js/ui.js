/**
 * 
 */
$(document).ready(function(){
	
	//Header navi
	$(".gnb-list>li").mouseenter(function(){
	    $("#header").addClass("on");
	});
	$(".gnb-list>li").mouseleave(function(){
	    $("#header").removeClass("on");
	});
	
	
	//bestReview hover
	$(".swiper-slide").hover(function() {
		$(this).find(".box-review-hover").css("display", "block");
		$(this).find("img").css("transform", "scale(1.1)");
	}, function(){
		$(this).find(".box-review-hover").css("display", "none");
		$(this).find("img").css("transform", "scale(1)");
	});
	
	
	//main-notice btn 전환
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
	
	
	//crew btn 전환
	$(".btn-created-crew").click(function(){
		$(".btn-joined-crew").removeClass("on");
		$(".area-joined-crew").css('display', 'none');
		
	    $(this).addClass("on");
	    $(".area-created-crew").css('display', 'block');
	});
	
	$(".btn-joined-crew").click(function(){
	    $(".btn-created-crew").removeClass("on");
	    $(".area-created-crew").css('display', 'none');
	    
	    $(this).addClass("on");
		$(".area-joined-crew").css('display', 'block');
	});
	
	
	//noticeFAQ slideDown
    $(".question-box").click(function(){
		if($(this).next(".answer-box").css("display") == "none") {
			$(this).next(".answer-box").slideDown(250);
			$(this).find(".fa-chevron-down").addClass("on");
			
			$(".answer-box").not($(this).next(".answer-box")).slideUp(250);
			$(".fa-chevron-down").not($(this).find(".fa-chevron-down")).removeClass("on");
		}
		else {
			$(this).next(".answer-box").slideUp(250);
			$(this).find(".fa-chevron-down").removeClass("on");
		}
    });
    
    
    //review map slideDown
    $(".map-top").click(function(){
    	
    	if($(this).next(".map-content").css("display")=="none"){
    		$(this).next(".map-content").slideDown(500);
    		$(this).find(".fa-chevron-down").addClass("on");
    	}else {
    		$(this).next(".map-content").slideUp(500);
    		$(this).find(".fa-chevron-down").removeClass("on");
    	}
	});
});

