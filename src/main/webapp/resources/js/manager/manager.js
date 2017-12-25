var table = '<li class="item">'
	+'<div class="main display-flex">'
	+'			<div class="select-item">'
	+'				<input type="checkbox" />'
	+'			</div>'
	+'			<div class="display-left">'
	+'				<div class="image">'
	+'					<img src="" />'
	+'				</div>'
	+'					<div class="text">'
	+'						<span class="text-level-1 fl-l">hello</span>'
	+'						<span class="text-level-2 fl-l">asncsanc</span>'
	+'						<span class="text-level-3 fl-l">sacnjasncjasn</span>'
	+'					</div>'
	+'				</div>'
	+'				<div class="display-mid">'
	+'					<div class="image">'
	+'						<img src="" />'
	+'					</div>'
	+'					<div class="text">'
	+'						<span class="text-level-1 fl-l">hello</span>'
	+'						<span class="text-level-2 fl-l">asncsanc</span>'
	+'						<span class="text-level-3 fl-l">sacnjasncjasn</span>'
	+'					</div>'
	+'				</div>'
	+'				<div class="display-right">'
	+'					<div class="action"><i class="fa fa-trash"></i></div>'
	+'					<div class="action"><i class="fa fa-edit"></i></div>'
	+'					<div class="action"><i class="fa fa-arrow-right"></i></div>'
	+'				</div>'
	+'		</div>'
	+'	</li>';


var manager_properties = null;

$(document).ready(function(){
	
	jQuery.fn.extend({
		
		set_display : function(result){
			table = '';
			for (var i= 0; i < result['lis'].length; i++) {
				table = '<li class="item">'
					+'<div class="main display-flex">';
				table += '<div class="select-item">'
				+'				<input obj-id="'+result['lis'][i]['id']+'" type="checkbox" />'
				+'			</div>';
				table += '<div class="display-left">'
				
				if("img" == manager_properties['display_left'][0]['type']){
					var t = manager_properties['display_left'][0]['name']
					table +='				<div class="image">'
					+'					<img src="'+result['lis'][i][t]+'" />'
					+'				</div>'
				}
					
				table +=					'<div class="text">'
					+'						<span class="text-level-1 fl-l">'+result['lis'][i][manager_properties['display_left'][1]['name']]+'</span>'
					+'						<span class="text-level-2 fl-l">'+result['lis'][i][manager_properties['display_left'][2]['name']]+'</span>'
					+'						<span class="text-level-3 fl-l">'+result['lis'][i][manager_properties['display_left'][3]['name']]+'</span>'
					+'					</div>'
					+'				</div>'
				
				table +=			'<div class="display-mid">';
					
				if("img" == manager_properties['display_mid'][0]['type']){
						var t = manager_properties['display_mid'][0]['name']
						table +='				<div class="image">'
						+'					<img src="'+result['lis'][i][t]+'" />'
						+'				</div>'
				}
						
				table +=					'<div class="text">'
						+'						<span class="text-level-1 fl-l">'+result['lis'][i][manager_properties['display_mid'][1]['name']]+'</span>'
						+'						<span class="text-level-2 fl-l">'+result['lis'][i][manager_properties['display_mid'][2]['name']]+'</span>'
						+'						<span class="text-level-3 fl-l">'+result['lis'][i][manager_properties['display_mid'][3]['name']]+'</span>'
						+'					</div>'
						+'				</div>'
					
				table +=				'<div class="display-right">'
						+'					<div class="action"><i class="fa fa-trash"></i></div>'
						+'					<div class="action"><i class="fa fa-edit"></i></div>';
				if(manager_properties['display_right'].length == 3)
						table+= '<div class="action"><i class="fa fa-arrow-right"></i></div>';
				table+="</div></div></li>";
			}
			
		}
		
	});
	
});