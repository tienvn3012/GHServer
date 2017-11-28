var ansync_ajax_result = null;

$(document).ready(function(){
	
	jQuery.fn.extend({
		
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
	            	return $(this).error(jqXHR, exception);
	            }
	        });
		}
		
	});
	
});