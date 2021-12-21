/**
 * 
 */

$( document ).ready( function(){
	
	//크루 버튼을 누르면 게시판들이 나오도록
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
});
