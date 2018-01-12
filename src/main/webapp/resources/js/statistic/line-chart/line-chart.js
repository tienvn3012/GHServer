function draw_line_chart(description,config,data){
		  nv.addGraph(function() {
		    var chart = nv.models.cumulativeLineChart()
		                  .x(function(d) { return d[0] })
		                  .y(function(d) { return d[1] }) //adjusting, 100% is 1.00, not 100 as it is in the data
		                  .color(d3.scale.category10().range())
		                  .useInteractiveGuideline(true)
		                  ;

		     chart.xAxis
		        .tickFormat(function(d) {
		            return d3.time.format("%d/%m/%Y %Hh:%M':%Ss")(new Date(d))
		          });

		    chart.yAxis
		        .tickFormat(d3.format(',.1f'));

		    d3.select('#line-chart svg')
		        .datum(data)
		        .call(chart);

		    //TODO: Figure out a good way to do this automatically
		    nv.utils.windowResize(chart.update);

		    return chart;
		  });
}

function parse_data_for_line_chart(result){
	
	for (var i = 0; i < result.length; i++) {
		data[0]['values'].push([result[i]['time'],result[i]['tempurature']]);
		data[1]['values'].push([result[i]['time'],result[i]['humidity']]);
	}
	
	return data;
}