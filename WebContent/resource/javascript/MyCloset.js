$(function(){
	$('.like').on("click",function(){
		if($(this).hasClass('far')){
			$(this).removeClass('far');
			$(this).addClass('fas');
			$.ajax({ 
				url:'myCart.my',
				data : {
					prd_num:$(this).val(),
				},
				type:"get",
				success:function(){
				}
			});
			
		}else if($(this).hasClass('fas')){
			$(this).removeClass('fas');
			$(this).addClass('far');
			$.ajax({ 
				url:'myCart.my',
				data : {
					prd_num:$(this).val(),
						},
				type:"get",
				success:function(){
				}
	
			});
		}
	});
});