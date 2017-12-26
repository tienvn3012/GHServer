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

$(document).ready(function(){
	
	jQuery.fn.extend({
		
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
	
});