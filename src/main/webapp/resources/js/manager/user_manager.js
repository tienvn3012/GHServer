$(document).ready(function(){
	
	$.ajax({
    	headers: { 
            Accept: 'application/json'
        },
        contentType	: "application/json; charset=utf-8",
        type 		: "GET",
        url 		: "user/properties",
        timeout		: 6000,
        dataType 	: 'json',
        async 		: false,
        
        success : function (result) {            	
        	$("head").find("title").html(result['name'] + "Manager");
        	obj_name = result['name']
        	$("#pt").html(obj_name + "Manage");
        	manager_properties = result;
        	$("#total_records").html("Total records : "+result['total_records']+" records");
        	$(this).simple_ajax_request("user/1?row=5",null,'GET',false);
        	$(this).set_display(ansync_ajax_result);
        	
        	$("#manager").find("ul").html(table);
        	
        },
        
        error : function (jqXHR, exception) {
        	$(this).error(jqXHR, exception);
        }
    });

});