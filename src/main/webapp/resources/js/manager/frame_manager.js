$(document).ready(function(){
	$.ajax({
    	headers: { 
            Accept: 'application/json'
        },
        contentType	: "application/json; charset=utf-8",
        type 		: "GET",
        url 		: "frame/properties",
        timeout		: 6000,
        dataType 	: 'json',
        async 		: false,
        
        success : function (result) {            	
        	$("head").find("title").html(result['name'] + "Manager");
        	block = result['block'];
        	obj_name = result['name']
        	$("#pt").html(obj_name + "Manage");
        	manager_properties = result;
        	$("#total_records").html("Total records : "+result['total_records']+" records");
        	$(this).simple_ajax_request(obj_name+"/"+page+"?row="+row,null,'GET',false);
        	$(this).set_display(ansync_ajax_result);
        	
        	$("#manager").find("#tbl-ul").html(block_table);
        	
        	data = ansync_ajax_result;
        	
			
			$(this).reload_pager();
        },
        
        error : function (jqXHR, exception) {
        	$(this).error(jqXHR, exception);
        }
    });
	
});