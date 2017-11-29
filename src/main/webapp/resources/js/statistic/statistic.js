var client = new Paho.MQTT.Client("ws://iot.eclipse.org/ws", "myClientId" + new Date().getTime());

client.onConnectionLost = onConnectionLost;
client.onMessageArrived = onMessageArrived;
client.connect({onSuccess:onConnect});

function onConnect() {
	  // Once a connection has been made, make a subscription and send a message.
	  console.log("onConnect");
	  client.subscribe("nct_collect");
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
}