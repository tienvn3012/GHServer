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
        	
        	$("#manager").find("#tbl-ul").html(table);
        	
        	data = ansync_ajax_result;
        },
        
        error : function (jqXHR, exception) {
        	$(this).error(jqXHR, exception);
        }
    });
	
	
	jQuery.fn.extend({
		reload_table : function(manager_properties){
			manager_properties['total_records']+=1;
			$("#total_records").html("Total records : "+manager_properties['total_records']+" records");
        	$(this).simple_ajax_request("user/1?row=5",null,'GET',false);
        	$(this).set_display(ansync_ajax_result);
        	
        	$("#manager").find("ul").html(table);
        	
        	data = ansync_ajax_result;
		},
		
		//add or edit record 
		add_or_edit_record : function(action){
			var user = {};
			user['info'] = {};
			user['role'] = {};
			
			user['username']  				= $("#modal_body input[name='username']").val();
			user['active']    				= true;
			user['create_to'] 				= false;
			user['create_by'] 				= 1;
			user['create_time'] 			= null;
			user['last_login'] 				= null;
			user['avatar'] 					= null;
			user['state'] 					= false;
			
			user['info']['level'] 			= parseInt($("#modal_body select[name='level']").val());
			user['info']['fullname']		= $("#modal_body input[name='fullname']").val();
			user['info']['email']			= $("#modal_body input[name='email']").val();
			user['info']['phone']			= $("#modal_body input[name='phone']").val();
			user['info']['address']			= $("#modal_body input[name='address']").val();
			user['info']['date_of_birth']	= $("#modal_body input[name='date_of_birth']").val();
			user['info']['gender']			= $("#modal_body select[name='gender']").val() == "male"?true:false;
			
			user['role']['id'] 				= $("#modal_body select[name='role']").val();
			user['role']['role']			= $("#modal_body select[name='role'] :selected").text();
		
			$(this).simple_ajax_request("user/"+action,user,"POST",false);
		},
		
		add_record_action : function(){
			$(this).add_or_edit_record("add");
		
		},
		
		delete_record_action : function(id){
			$(this).simple_ajax_request("user/delete/"+id,null,"GET",false);
		},
		
		edit_record_action : function(id){
			$(this).add_or_edit_record("edit?id="+id);
		}
		
	});

});