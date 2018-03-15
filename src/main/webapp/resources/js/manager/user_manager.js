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
	
	
	jQuery.fn.extend({
		
		add_record_action : function(){
			var user = {};
			user['info'] = {};
			user['role'] = {};
			
			user['username']  				= $("#modal_body input[name='username']").val();
			user['active']    				= true;
			user['create_to'] 				= false;
			user['create_time'] 			= null;
			user['last_login'] 				= null;
			user['avatar'] 					= null;
			
			user['info']['level'] 			= parseInt($("#modal_body select[name='level']").val());
			user['info']['fullname']		= $("#modal_body input[name='fullname']").val();
			user['info']['email']			= $("#modal_body input[name='email']").val();
			user['info']['phone']			= $("#modal_body input[name='phone']").val();
			user['info']['address']			= $("#modal_body input[name='address']").val();
			user['info']['date_of_birth']	= $("#modal_body input[name='date_of_birth']").val();
			user['info']['gender']			= $("#modal_body select[name='gender']").val() == "male"?true:false;
			
			user['role']['id'] 				= $("#modal_body select[name='role']").val();
			user['role']['role']			= $("#modal_body select[name='role'] :selected").text();
		
			$(this).simple_ajax_request("user/add",user,"POST",false);
		
		},
		
		delete_record_action : function(){
			
		},
		
		edit_record_action : function(){
			
		}
		
	});

});