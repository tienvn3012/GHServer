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
var obj_name = "";
var modal_html = "";


$(document).ready(function(){
	
	jQuery.fn.extend({
		
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
					 modal_html += " <select class='form-control'>";
					 if(t[1] == "values"){
						 var t2 = t[2].split(";");
						 for(var j=0;j<t2.length;j++){
							 modal_html += "<option>"+t2[j]+"</option>"
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
		
		// clear old table
		clear_table : function(){
			table = '';
		},
		
		// table set head
		set_header : function(id){
			table += '<li class="item">'
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
				+'					<div class="action"><i class="fa fa-trash"></i></div>'
				+'					<div class="action"><i class="fa fa-edit"></i></div>';
			if(manager_properties['display_right'].length == 3)
				table+= '<div class="action"><i class="fa fa-arrow-right"></i></div>';
			table += '</div>';
		},
		
		set_display : function(result){
			$(this).clear_table();
			for (var i= 0; i < result['lis'].length; i++){
				$(this).set_header();
				$(this).set_left(result['lis'][i]);
				$(this).set_mid(result['lis'][i]);
				$(this).set_right();
				$(this).set_tail();
			}
		}
		
	});
	
	$("#add-record").click(function(){
		$("#modal_header").html("Add new " + obj_name);
		$("#modal_action").html("Add");
		
		$(this).set_modal_add_html(manager_properties['model_properties']);
		
		for(var i = 0;i<manager_properties['lis_model_reference_properties'].length;i++){
			$(this).set_modal_add_html(manager_properties['lis_model_reference_properties'][i]['lis']);
		}
		
		$("#modal_body").html(modal_html);
		
	});
	
});