var data = [
            {
            	key : 'temp',
            	values : [
            	         {x : 0,y:10},
            	         {x : 1,y:12}
            	         ]
            },
            {
            	key : 'humid',
            	values : [
            	         {x : 0,y:50},
            	         {x : 1,y:70}
            	         ]
            }
            ];
var bar_chart;
var bar_data;
function draw_bar_chart(description,config){
	nv.addGraph(function() {
	    var chart = nv.models.multiBarChart()
	      //.transitionDuration(350)
	      .reduceXTicks(true)   //If 'false', every single x-axis tick label will be rendered.
	      .rotateLabels(0)      //Angle to rotate x-axis labels.
	      .showControls(true)   //Allow user to switch between 'Grouped' and 'Stacked' mode.
	      .groupSpacing(0.1)    //Distance between each group of bars.
	    ;

	    chart.xAxis
	        .tickFormat(d3.format(',f'));

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

function parse_to_bar_chart_data(common_data){
	
}

function update() {
	bar_chart.update;
}

draw_bar_chart(null,null);