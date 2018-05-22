
var data = [
	            {
	            	key : 'temp',
	            	values : []
	            },
	            {
	            	key : 'humid',
	            	values : []
	            }
	       ];

var line_data = [
            {
            	key : 'temp',
            	values : []
            },
            {
            	key : 'humid',
            	values : []
            }
       ];

var client = new Paho.MQTT.Client("ws://iot.eclipse.org/ws", "myClientId" + new Date().getTime());

client.onConnectionLost = onConnectionLost;
client.onMessageArrived = onMessageArrived;
client.connect({onSuccess:onConnect});

function onConnect() {
	  // Once a connection has been made, make a subscription and send a message.
	  console.log("onConnect");
	  var topic = document.getElementById("statistic").getAttribute("topic");
	  console.log(topic);
	  client.subscribe(topic);
//	  message = new Paho.MQTT.Message("Hello");
//	  message.destinationName = "World";
//	  client.send(message);
	}
function onConnectionLost(responseObject) {
	  if (responseObject.errorCode !== 0) {
	    console.log("onConnectionLost:"+responseObject.errorMessage);
	  }
}

function onMessageArrived(message) {
	  console.log("onMessageArrived:"+message.payloadString);
	  var msg = message.payloadString;
	  var split = msg.split(";");
	  var time = (new Date()).getTime();
	  data[0]['values'].push({
			x : time,
			y : parseFloat(split[1])
		});
	  data[0]['values'].shift();
	  data[1]['values'].push({
			x : time,
			y : parseFloat(split[2])
		});
	  data[1]['values'].shift();
		
		line_data[0]['values'].push([time,parseFloat(split[1])]);
		line_data[1]['values'].push([time,parseFloat(split[2])]);
	  
	  draw_bar_chart(null,null,data);
	  draw_line_chart(null,null,line_data);
}

$(document).ready(function(){
	var fid = $("#statistic").attr("frameid");
	$(this).simple_ajax_request("statistic/data/0?row=40",null,"GET",false);
	var data = parse_data_for_bar_chart(ansync_ajax_result['lis']);
//	var line = parse_data_for_line_chart(ansync_ajax_result['lis']);
	draw_bar_chart(null,null,data);
//	draw_line_chart(null,null,line);
	
	
});