/**
 * 
 */
/*
	$(document).ready(function() {
    //네비게이션 토글

    $(".question-box").click(function(){
        //$(".answer-box").not($(this).next(".answer-box").slideToggle(500)).slideUp();
        //$("i", this).toggleClass("fa-chervon-down fa-chevron-up");

        if($(this).next(".answer-box").css("display") == "none") 
        {
            $(this).next(".answer-box").slideDown(500);
            $(this).find(".fa-chevron-down").addClass("on");

            $(".answer-box").not($(this).next(".answer-box")).slideUp(500);
            $(".fa-chevron-down").not($(this).find(".fa-chevron-down")).removeClass("on");
        }
        else {
            $(this).next(".answer-box").slideUp(500);
            $(this).find(".fa-chevron-down").removeClass("on");
        }
    });
});
*/
        		 
	
    $(document).ready(function() {


        $(".question-box").click(function()
        {
          
          $(".answer-box").not($(this).next(".answer-box").slideToggle(500)).slideUp();
          $("i", this).addClass("fa-chevron-up");
          $(".question-box > i").not($("i", this)).removeClass("fa-chevron-up");
       
          
        });
      });