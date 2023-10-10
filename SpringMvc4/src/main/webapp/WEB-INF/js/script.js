/**
 * 
 */
 $(function(){
 	$("#myimg").attr("src","../image/1.png");
 	
 	$("#myimg").hover(function(){
 		$(this).attr("src","../image/2.png");
 	},function(){
 		$(this).attr("src","../image/1.png");
 	});
 	
 });