$(document).ready(function(){
	
	$("#mode_toggle").change(function(){
		if (this.checked){
			var state = "on";
			$(this).simple_ajax_request("control/1/mode?mode="+state,null,"GET",false);
		}else{
			var state = "off";
			$(this).simple_ajax_request("control/1/mode?mode="+state,null,"GET",false);
		}
	});
	
	$("#led_toggle").change(function() {
		var state;
		var self = this;
		
		if (this.checked) {
			state = "on";
			var time = $("#led_time").val();
			$("#led_time").val("");
			$(this).parents("li").attr("state","1");
			if(time.length != 0){
				ansync_ajax_result = null; // clear ajax result
				$(this).simple_ajax_request("control/1/led?led="+state,null,"GET",false);
				
				if(ansync_ajax_result == null)
					return;
				
				toastr.success('Led on !', 'Success');
				$(this).parents("li").find(".time-countdown").removeClass("display-none");
				$(this).parents("li").find(".input-time").addClass("display-none");
				var distance = parseFloat(time)*1000*60;
				interval_event_countdown = setInterval(function(){
					var minutes = Math.floor(distance / (1000 * 60));
				    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
				    $(self).parents("li").find(".time-countdown").html(minutes + "m " + seconds + "s ");
				    distance-=1000;
				    
				    if (distance < 0) {
				        clearInterval(interval_event_countdown);
				        $(self).parents(".toggle[data-toggle='toggle']").click();
				        $(self).parents("li").find(".time-countdown").addClass("display-none");
						$(self).parents("li").find(".input-time").removeClass("display-none");
						$(self).parents("li").attr("state","0");
				    }
				    
				},1000);
			}else{
				
				
				ansync_ajax_result = null; // clear ajax result
				$(this).simple_ajax_request("control/1/led?led="+state,null,"GET",false);
				if(ansync_ajax_result == null)
					return;
				
				toastr.success('Led on !', 'Success');
			}
			
			
		}else {
			state = "off";
			ansync_ajax_result = null; // clear ajax result
			$(this).off_activity(self,"control/1/led?led="+state,null,"GET",false);
			if(ansync_ajax_result == null)
				return;
			toastr.success('Led off !', 'Success');
		}
	});
	
	$("#fan_toggle").change(function() {
		var state;
		var self = this;
		
		if (this.checked) {
			state = "on";
			var time = $("#fan_time").val();
			$("#fan_time").val("");
			$(this).parents("li").attr("state","1");
			if(time.length != 0){
				ansync_ajax_result = null; // clear ajax result
				$(this).simple_ajax_request("control/1/fan?fan="+state,null,"GET",false);
				
				if(ansync_ajax_result == null)
					return;
				
				toastr.success('Fan on !', 'Success');
				$(this).parents("li").find(".time-countdown").removeClass("display-none");
				$(this).parents("li").find(".input-time").addClass("display-none");
				var distance = parseFloat(time)*1000*60;
				interval_event_countdown = setInterval(function(){
					var minutes = Math.floor(distance / (1000 * 60));
				    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
				    $(self).parents("li").find(".time-countdown").html(minutes + "m " + seconds + "s ");
				    distance-=1000;
				    
				    if (distance < 0) {
				        clearInterval(interval_event_countdown);
				        $(self).parents(".toggle[data-toggle='toggle']").click();
				        $(self).parents("li").find(".time-countdown").addClass("display-none");
						$(self).parents("li").find(".input-time").removeClass("display-none");
						$(self).parents("li").attr("state","0");
				    }
				    
				},1000);
			}else{
				
				
				ansync_ajax_result = null; // clear ajax result
				$(this).simple_ajax_request("control/1/fan?fan="+state,null,"GET",false);
				if(ansync_ajax_result == null)
					return;
				
				toastr.success('Fan on !', 'Success');
			}
			
			
		}else {
			state = "off";
			ansync_ajax_result = null; // clear ajax result
			$(this).off_activity(self,"control/1/fan?fan="+state,null,"GET",false);
			if(ansync_ajax_result == null)
				return;
			toastr.success('Fan off !', 'Success');
		}
	});
	
	
});