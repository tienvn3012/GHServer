var table = '';
//	'<li class="item">'
//	+'<div class="main display-flex">'
//	+'			<div class="select-item">'
//	+'				<input type="checkbox" />'
//	+'			</div>'
//	+'			<div class="display-left">'
//	+'				<div class="image">'
//	+'					<img src="" />'
//	+'				</div>'
//	+'					<div class="text">'
//	+'						<span class="text-level-1 fl-l">hello</span>'
//	+'						<span class="text-level-2 fl-l">asncsanc</span>'
//	+'						<span class="text-level-3 fl-l">sacnjasncjasn</span>'
//	+'					</div>'
//	+'				</div>'
//	+'				<div class="display-mid">'
//	+'					<div class="image">'
//	+'						<img src="" />'
//	+'					</div>'
//	+'					<div class="text">'
//	+'						<span class="text-level-1 fl-l">hello</span>'
//	+'						<span class="text-level-2 fl-l">asncsanc</span>'
//	+'						<span class="text-level-3 fl-l">sacnjasncjasn</span>'
//	+'					</div>'
//	+'				</div>'
//	+'				<div class="display-right">'
//	+'					<div class="action"><i class="fa fa-trash"></i></div>'
//	+'					<div class="action"><i class="fa fa-edit"></i></div>'
//	+'					<div class="action"><i class="fa fa-arrow-right"></i></div>'
//	+'				</div>'
//	+'		</div>'
//	+'	</li>';


var manager_properties = null;
var num_page = 0;
var obj_name = "";
var modal_html = "";
var pager = "";
var data = {};
var page = 1;
var row = 5;


$(document).ready(function(){
	
	jQuery.fn.extend({
		// delete html for modal
		set_modal_delete_html : function(){
			modal_html += "<h3 style='color:#4a4a4a;'>Are you sure want to delete this "+obj_name+" ?</h3>";
		},
		
		// edit html for modal
		set_modal_edit_html : function(lis, obj, ref){
			for(var i = 0;i<lis.length;i++){
				if("ignore" == lis[i]['rule']){
					continue;
				} 
				
				modal_html += "<p>"+lis[i]['name']+" :</p>";
				var t = lis[i]['input'].split("_");
				switch(t[0]){
				 case "inputtext" : 
					 modal_html += "<input type='text'" +
					 		" placeholder='"+(lis[i]['notification'] == null ? lis[i]['name'] : lis[i]['notification'])+"'" +
					 		" class='form-control' name='"+lis[i]['name']+"' value='"+(ref == null ? obj[lis[i]['name']]:obj[ref][lis[i]['name']])+"' />"
					 break;
				 case "select":
					 modal_html += " <select class='form-control' name ='"+lis[i]['name']+"'>";
					 if(t[1] == "values"){
						 var t2 = t[2].split(";");
						 for(var j=0;j<t2.length;j++){
							 modal_html += "<option value='"+t2[j]+"' "+(t2[j] == (ref == null ? obj[lis[i]['name']]:obj[ref][lis[i]['name']])?"selected":"")+">"+t2[j]+"</option>"
						 }
						 modal_html += "</select>"
					 }else if(t[1] == "link"){
						 $(this).simple_ajax_request(t[2],null,'GET',false);
						 for(var j=0;j<ansync_ajax_result.length;j++){
							 modal_html += "<option value='"+ansync_ajax_result[j]['id']+"' "+(ansync_ajax_result[j]['value'] == (ref == null ? obj[lis[i]['name']]:obj[ref][lis[i]['name']])?"selected":"")+">" +
							 		""+ansync_ajax_result[j]['value']+"</option>"
						 }
						 modal_html += "</select>"
					 }else{
						 
					 }
					 break;
				 case "img":
//					 modal_html += '<div class="file-tab panel-body">' +
//						 '<div class="imageupload panel panel-default">'+
//						 '<label class="btn btn-default btn-file">'+
//			            '<span>Browse</span>'+
//			            '<input type="file" name="'+lis[i]['name']+'">'+
//			            '</label>'+
//			            '<button type="button" class="btn btn-default" style="display:none;">Remove</button>'+
//			            '</div></div>';
					 break;
				 case "radio":
					 break;
				 case "checkbox":
					 break;
				 default : 
					 break;
				};
				
			}
		},
		
		// add html for modal add
		set_modal_add_html : function(lis){
			for(var i = 0;i<lis.length;i++){
				if("ignore" == lis[i]['rule']){
					continue;
				} 
				
				modal_html += "<p>"+lis[i]['name']+" :</p>";
				var t = lis[i]['input'].split("_");
				switch(t[0]){
				 case "inputtext" : 
					 modal_html += "<input type='text'" +
					 		" placeholder='"+(lis[i]['notification'] == null ? lis[i]['name'] : lis[i]['notification'])+"'" +
					 		" class='form-control' name='"+lis[i]['name']+"' />"
					 break;
				 case "select":
					 modal_html += " <select class='form-control' name ='"+lis[i]['name']+"'>";
					 if(t[1] == "values"){
						 var t2 = t[2].split(";");
						 for(var j=0;j<t2.length;j++){
							 modal_html += "<option value='"+t2[j]+"'>"+t2[j]+"</option>"
						 }
						 modal_html += "</select>"
					 }else if(t[1] == "link"){
						 $(this).simple_ajax_request(t[2],null,'GET',false);
						 for(var j=0;j<ansync_ajax_result.length;j++){
							 modal_html += "<option value='"+ansync_ajax_result[j]['id']+"'>"+ansync_ajax_result[j]['value']+"</option>"
						 }
						 modal_html += "</select>"
					 }else{
						 
					 }
					 break;
				 case "img":
					 modal_html += '<div class="file-tab panel-body">' +
						 '<div class="imageupload panel panel-default">'+
						 '<label class="btn btn-default btn-file">'+
			            '<span>Browse</span>'+
			            '<input type="file" name="'+lis[i]['name']+'">'+
			            '</label>'+
			            '<button type="button" class="btn btn-default" style="display:none;">Remove</button>'+
			            '</div></div>';
					 break;
				 case "radio":
					 break;
				 case "checkbox":
					 break;
				 default : 
					 break;
				};
				
			}
		},
		
		//clear modal
		clear_modal : function(){
			modal_html = "";
		},
		
		//clear pager
		clear_pager : function(){
			pager = "";
		},
		
		//reload pager
		reload_pager : function(){
			num_page = (manager_properties['total_records']%row == 0 ? 
					Math.floor(manager_properties['total_records']/row) : Math.floor(manager_properties['total_records']/row) + 1);
			
			$("#manager").find("#pager").empty();
			$(this).clear_pager();
			if(num_page <= 5){
				for (var i = 1; i <= num_page; i++) {
					pager+="<li class='page-item' " +
					"state='"+(i==page ? "active":"")+"'>"+i+"</li>";
				}
			}else{
				if(num_page - 5 < page){
					for (var i = num_page-5; i < num_page; i++) {
						pager+="<li class='page-item' " +
						"state='"+(i==page ? "active":"")+"'>"+i+"</li>";
					}
				}else{
					if(page == 1){
						for (var i = page; i < page+5; i++) {
							pager+="<li class='page-item' " +
							"state='"+(i==page ? "active":"")+"'>"+i+"</li>";
						}
					}else{
						for (var i = page-1; i < page+4; i++) {
							pager+="<li class='page-item' " +
							"state='"+(i==page ? "active":"")+"'>"+i+"</li>";
						}
					}
				}
			}
			
			$("#pager").html(pager);
		},
		
		//reload table
		reload_table : function(){
			$("#total_records").html("Total records : "+manager_properties['total_records']+" records");
        	$(this).simple_ajax_request(obj_name+"/"+page+"?row="+row,null,'GET',false);
        	$(this).set_display(ansync_ajax_result);
        	
        	$("#manager").find("#tbl-ul").html(table);
        	
        	data = ansync_ajax_result;
		},
		
		// clear old table
		clear_table : function(){
			table = '';
		},
		
		// table set head
		set_header : function(id){
			table += '<li class="item" obj-id="'+id+'">'
				+'<div class="main display-flex">';
			table += '<div class="select-item">'
				+'				<input obj-id="'+id+'" type="checkbox" />'
				+'			</div>';
		},
		
		//table set tail
		set_tail : function(){
			table += '</div></li>';
		},
		
		//table set left
		set_left : function(result){
			table += '<div class="display-left">';
			
			if("img" == manager_properties['display_left'][0]['type']){
				var t = manager_properties['display_left'][0]['name']
				table +='				<div class="image">'
				+'					<img src="/GHServer/image?image='+result[t]+'" />'
				+'				</div>'
			}
			
			table += '<div class="text">';
			
			for (var i = 1; i < manager_properties['display_left'].length; i++) {
				var split = manager_properties['display_left'][i]['name'].split(".");
				if(split.length < 2){
					table += '<span class="text-level-'+i+' fl-l">'+result[split[0]]+'</span>';
				}else if(split.length == 2){
					table += '<span class="text-level-'+i+' fl-l">'+result[split[0]][split[1]]+'</span>';
				}else{
					alert("Error !!!!!");
				}
			}
			
			// end text
			table += '</div>';
			
			// end class "display-left"
			table += '</div>';
		},
		
		//table set mid
		set_mid : function(result){
			table += '<div class="display-mid">';
			
			if("img" == manager_properties['display_mid'][0]['type']){
				var t = manager_properties['display_mid'][0]['name']
				table +='				<div class="image">'
				+'					<img src="/GHServer/image?image='+result[t]+'" />'
				+'				</div>'
			}
			
			table += '<div class="text">';
			
			for (var i = 1; i < manager_properties['display_mid'].length; i++) {
				var split = manager_properties['display_mid'][i]['name'].split(".");
				if(split.length < 2){
					table += '<span class="text-level-'+i+' fl-l">'+result[split[0]]+'</span>';
				}else if(split.length == 2){
					table += '<span class="text-level-'+i+' fl-l">'+result[split[0]][split[1]]+'</span>';
				}else{
					alert("Error !!!!!");
				}
			}
			
			// end text
			table += '</div>';
			
			// end class "display-mid"
			table += '</div>';
		},
		
		set_right : function(){
			table +=				'<div class="display-right">'
				+'					<div class="action delete-record" data-toggle="modal" data-target="#myModal"><i class="fa fa-trash"></i></div>'
				+'					<div class="action edit-record" data-toggle="modal" data-target="#myModal"><i class="fa fa-edit"></i></div>';
			if(manager_properties['display_right'].length == 3)
				table+= '<div class="action" ><i class="fa fa-arrow-right"></i></div>';
			table += '</div>';
		},
		
		set_display : function(result){
			$(this).clear_table();
			for (var i= 0; i < result['lis'].length; i++){
				$(this).set_header(result['lis'][i]['id']);
				$(this).set_left(result['lis'][i]);
				$(this).set_mid(result['lis'][i]);
				$(this).set_right();
				$(this).set_tail();
			}
		}
		
	});
	
	$("#add-record").click(function(){
		$(this).clear_modal();
		$("#modal_header").html("Add new " + obj_name);
		$("#modal_action").html("Add");
		$("#modal_action").attr("action","add");
		
		$(this).set_modal_add_html(manager_properties['model_properties']);
		
		for(var i = 0;i<manager_properties['lis_model_reference_properties'].length;i++){
			$(this).set_modal_add_html(manager_properties['lis_model_reference_properties'][i]['lis']);
		}
		
		$("#modal_body").html(modal_html);
		
	});
	
	
	$(document).on("click", "#manager .table-manager li .delete-record",function() {
		$(this).clear_modal();
		$("#modal_header").html("Delete new " + obj_name);
		$("#modal_action").html("Delete");
		$("#modal_action").attr("action","delete");
		
		var id	= $(this).parents("li.item").attr("obj-id");
		$("#modal_action").attr("obj-id",id);
		
		$(this).set_modal_delete_html();
		
		$("#modal_body").html(modal_html);
		});
	
	$(document).on("click", "#manager .table-manager li .edit-record",function() {
		$(this).clear_modal();
		$("#modal_header").html("Edit new " + obj_name);
		$("#modal_action").html("Edit");
		$("#modal_action").attr("action","edit");

		var id	= $(this).parents("li.item").attr("obj-id");
		$("#modal_action").attr("obj-id",id);
		var obj = find_obj_by_id(data['lis'],id);
		
		$(this).set_modal_edit_html(manager_properties['model_properties'],obj,null);
		
		for(var i = 0;i<manager_properties['lis_model_reference_properties'].length;i++){
			$(this).set_modal_edit_html(manager_properties['lis_model_reference_properties'][i]['lis'],obj,
					manager_properties['lis_model_reference_properties'][i]['name']);
		}
		
		$("#modal_body").html(modal_html);
		
	});
	
	
	$("#modal_action").click(function(){
		var action = $(this).attr("action");
		
		if(action === "add"){
			ansync_ajax_result = null; // clear ajax result
			$(this).add_record_action();
			if(ansync_ajax_result == null)
				return;
			toastr.success('Record added !', 'Success');
			
			$(this).reload_table();
			
		}else if(action === "delete"){
			ansync_ajax_result = null; // clear ajax result
			$(this).delete_record_action($(this).attr("obj-id"));
			if(ansync_ajax_result == null)
				return;
			toastr.success('Record deleted !', 'Success');
			
			$(this).reload_table();
		}else if(action === "edit"){
			ansync_ajax_result = null; // clear ajax result
			$(this).edit_record_action($(this).attr("obj-id"));
			if(ansync_ajax_result == null)
				return;
			toastr.success('Record edited !', 'Success');
			
			$(this).reload_table();
		}else{
			
		}
		
	});
	
	$(document).on("click", "#manager .pager li.page-item[state!='active']",function() {
		page = parseInt($(this).text());
		$(this).reload_table();
		$(this).reload_pager();
	});
	
	$(document).on("change", "#manager #num_row",function() {
		row = parseInt($(this).val());
		page = 1;
		$(this).reload_table();
		$(this).reload_pager();
	});
	
	$("#first_page").click(function(){
		page = 1;
		$(this).reload_table();
		$(this).reload_pager();
	});
	$("#last_page").click(function(){
		page = num_page;
		$(this).reload_table();
		$(this).reload_pager();
	});
	
	
	
});