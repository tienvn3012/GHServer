$(document).ready(function(){
	
	$("#led_toggle").change(function() {
		var state;
		var self = this;
		
		if (this.checked) {
			state = "on";
			var time = $("#led_time").val();
			$("#led_time").val("");
			if(time.length != 0){
				$(this).simple_ajax_request("control/led?led="+state,null,"GET",false);
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
			}
			$(this).parents("li").attr("state","1");
			$(this).simple_ajax_request("control/led?led="+state,null,"GET",false);
		}else {
			state = "off";
			$(this).off_activity(self,"control/led?led="+state,null,"GET",false);
		}
		if(ansync_ajax_result){
			console.log(ansync_ajax_result);
		}
		
	});
	
	
	
	
});