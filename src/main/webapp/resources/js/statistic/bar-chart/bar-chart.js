//var data = [
//            {
//            	key : 'temp',
//            	values : [
//            	         {x : 0,y:10},
//            	         {x : 1,y:12}
//            	         ]
//            },
//            {
//            	key : 'humid',
//            	values : [
//            	         {x : 0,y:50},
//            	         {x : 1,y:70}
//            	         ]
//            }
//            ];


function draw_bar_chart(description,config,data){
	nv.addGraph(function() {
	    var chart = nv.models.multiBarChart()
	      //.transitionDuration(350)
	      .reduceXTicks(true)   //If 'false', every single x-axis tick label will be rendered.
	      .rotateLabels(10)      //Angle to rotate x-axis labels.
	      .showControls(true)   //Allow user to switch between 'Grouped' and 'Stacked' mode.
	      .groupSpacing(0.1)    //Distance between each group of bars.
	    ;

	    chart.xAxis
        	.tickFormat(function(d) { 
        		return d3.time.format("%d/%m/%Y %Hh:%M':%Ss")(new Date(d)) 
        	});

	    chart.yAxis
	        .tickFormat(d3.format(',.1f'));

	    d3.select('#bar-chart svg')
	        .datum(data)
	        .call(chart);

	    nv.utils.windowResize(chart.update);
	    bar_chart = chart;
	    return chart;
	});
}

function update() {
	bar_chart.update;
}

function parse_data_for_bar_chart(result){
	
	for (var i = 0; i < result.length; i++) {
		data[0]['values'].push({
			x : result[i]['time'],
			y : result[i]['tempurature']
		});
		data[1]['values'].push({
			x : result[i]['time'],
			y : result[i]['humidity']
		});
	}
	
	return data;
}

