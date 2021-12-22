/**
 * 
 */

	$(document).ready(function() {
    //Admin 네비게이션 토글 (중첩 안됨)

    $(".mdl_nav > li").click(function() {
        $(this).next(".sub_nav").slideToggle();

    });
    
	});
	
	
	        		 