var ansync_ajax_result = null;
var interval_event_countdown;
var isClose = false;
var error = false;

toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "newestOnTop": true,
		  "progressBar": true,
		  "positionClass": "toast-top-right",
		  "preventDuplicates": false,
		  "onclick": null,
		  "showDuration": "300",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}

/*base function*/
function find_obj_by_id(array, id){
	if(!Array.isArray(array)) return null;
	
	for (var i = 0; i < array.length; i++) {
		if(parseInt(array[i]['id']) == parseInt(id))
			return array[i];
	}
	
	return null;
}
/*end base function*/

$(document).ready(function(){
	
	$(".scroll").niceScroll();
	
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
				toastr.error("Can't connect to server !", "Error !");
            } else if (jqXHR.status == 404) {
            	toastr.error("Server not found !", "Error !");
            } else if (jqXHR.status == 500) {
            	toastr.error("Server error, please try again later !", "Error !");
            } else if (exception === 'parsererror') {
            	toastr.error("JSON parse error !", "Error !");
            } else if (exception === 'timeout') {
            	toastr.error("Server not responding !", "Error !");
            } else if (exception === 'abort') {
            	toastr.error("Error sending !", "Error !");
            } else {
            	toastr.error("Unexpected error, please try again later !", "Error !")
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
	            	error = false;
	            },
	            
	            error : function (jqXHR, exception) {
	            	$(this).error(jqXHR, exception);
	            	error = true;
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
		}else{
			window.location = $(this).attr("ref");
		}
	});
});