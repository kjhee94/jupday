/**
 * 
 */

//네비게이션 바를 내리기 위해 클래스 추가
$( document ).ready( function(){
	
	$(".gnb-list>li").mouseenter(function(){
	    $("#header").addClass("on");
	});
	$(".gnb-list>li").mouseleave(function(){
	    $("#header").removeClass("on");
	});
});
