/**
 * Created by yorge on 2017/9/5.
 */
  $(function(){
    	 /*菜单隐藏功能*/
        $("#leftArrow").click(function () {
            $("#leftbackground").hide();
            $(this).hide();
            $(".el_right").css("width","100%");
            $("#rightArrow").css("display","block");
            //$(".el_left").animate({width: '-20'});
        })
        $("#rightArrow").click(function () {
            $("#leftbackground").show();
            $(".el_right").css("width","87%");
            $(this).hide();
            $("#leftArrow").show();
        })
        
        //部门
        /*for(var i = 0; i < 8; i ++) {
        	$(".selectDepart").append("<option>部门"+i+"</option>");
        }*/
        
    })