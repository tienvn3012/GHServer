var ansync_ajax_result = null;
var interval_event_countdown;
var isClose = false;

$(document).ready(function(){
	
	jQuery.fn.extend({
		
		/*close menu*/
		close_menu : function(){
			$(".menu-collapse").addClass("display-none");
			$("#gh-sidebar").addClass("width40px");
			$("#content-width").width(screen.width - 40);
			$("#collapse-icon").addClass("fa-arrow-right");
		},
		
		/*open menu*/
		open_menu : function(){
			$(".menu-collapse").removeClass("display-none");
			$("#gh-sidebar").removeClass("width40px");
			$("#content-width").width(screen.width - screen.width*0.2);
			$("#collapse-icon").removeClass("fa-arrow-right");
		},
		
		/*error handle*/
		error : function(jqXHR, exception){
			if (jqXHR.status === 0) {
                alert('Không thể kết nối đến máy chủ !');
            } else if (jqXHR.status == 404) {
            	alert('Không tìm thấy máy chủ !');
            } else if (jqXHR.status == 500) {
            	alert('Lỗi máy chủ , xin thử lại sau !');
            } else if (exception === 'parsererror') {
            	alert('JSON parse error !!!! ');
            } else if (exception === 'timeout') {
            	alert('Máy chủ không phản hồi !!!!');
            } else if (exception === 'abort') {
            	alert('Xảy ra lỗi khi gửi !!!!');
            } else {
            	alert('Đã xảy ra lỗi !!!!');
            }
		},
		
		simple_ajax_request : function(url,data,method,async){
			$.ajax({
	        	headers: { 
	                Accept: 'application/json'
	            },
	            contentType	: "application/json; charset=utf-8",
	            type 		: method,
	            url 		: url,
	            data 		: JSON.stringify(data),
	            timeout		: 6000,
	            dataType 	: 'json',
	            async 		: async,
	            
	            success : function (result) {            	
	            	ansync_ajax_result = result;
	            },
	            
	            error : function (jqXHR, exception) {
	            	$(this).error(jqXHR, exception);
	            }
	        });
		},
		
		off_activity : function(target,url,data,method,async) {
			clearInterval(interval_event_countdown);
			$(target).parents("li").find(".time-countdown").addClass("display-none");
			$(target).parents("li").find(".input-time").removeClass("display-none");
			$(target).parents("li").attr("state","0");
			$(target).simple_ajax_request(url,data,method,async);
		},
		
	});
	
	$("#collapse-item").click(function(e){
		e.stopPropagation();
		if(!isClose){
			$(this).close_menu();
			isClose = true;
		}else{
			$(this).open_menu();
			isClose = false;
		}
		
	});
	
	$("#gh-sidebar li.item:not(:last-child)").click(function(e) {
		e.stopPropagation();
		if(isClose){
			$(this).open_menu();
			isClose = false;
		}
	});
});