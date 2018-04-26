var data_table = "";
var manager_properties = null;
var obj_name = "";
var block = 1;
var data = null;

$(document).ready(function() {
    
    jQuery.fn.extend({
    	
    	set_table_header : function(){
    		data_table += '<thead><tr>';
    		
    		for(var i=0;i<manager_properties['display'].length;i++){
    			data_table += '<th>'+manager_properties['display'][i]['display_name']+'</th>';
    		}
            
            data_table += '</tr></thead>';
//            console.log(data_table);
    	},
    	
    	set_table_content : function(){
    		data_table += '<tbody>';
    		
    		for(var i = 0;i<data.length;i++){
    			
    			data_table += '<tr>';
    			for(var j = 0;j<manager_properties['display'].length;j++){
    				
    				var split = manager_properties['display'][j]['name'].split(".");
    				console.log(split);
    				if(split.length == 1){
    					data_table += '<td>'+data[i][split[0]]+'</td>';
    				}else{
    					var count = 0;
    					var temp = data[i];
    					while(count < split.length){
    						temp = temp[split[count]];
    						count+=1;
    					}
    					data_table += '<td>'+temp+'</td>';
    				}
    				
    			}
    			data_table += '</tr>';
    		}
    		
    		data_table += '</tbody>';
    	},
    	
    	clear_table : function(){
    		data_table = '';
    	},
    	
    	set_table : function(){
    		
    		$(this).clear_table();
    		$(this).set_table_header();
    		$(this).set_table_content();
    		$("#table_manager").find('#tbl').html(data_table);
    		$('#tbl').DataTable();
    		
    	},
    	
    	get_and_display_data : function(){
    		$(this).simple_ajax_request(obj_name+"/data",null,'GET',false);
    		data = ansync_ajax_result;
    		$(this).set_table();
    	}
    	
    });
    
} );