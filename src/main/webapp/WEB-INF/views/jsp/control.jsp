<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>

<div id="control">
	<div class="line">
		<div class="title">Control Page
			<div class="switch-mode">
				<label class="checkbox-inline control-led">
  					<input id="mode_toggle" type="checkbox"  data-toggle="toggle"> Automatic mode
				</label>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="line control-area">

			<div class="control-box">
				<div class="line box-title">
					LEDs Control
					<div class="activity"><i title="Info" class="fa fa-table"></i> <i title="Delete" class="fa fa-times"></i></div>
				</div>
				<div class="main">		
					<ul>
						<li class="line box-item"  state="0">
							<div class="icon"><i class="fa fa-lightbulb-o"></i></div>
							<div class="control-button">
								<div class="main">
									<div class="line text">LED</div>
									<input id="led_time" type="text" class="form-control input-time" placeholder="Time" />
									<div class="time-countdown display-none">Start</div>
								</div>
								<label class="checkbox-inline control-led">
  									<input id="led_toggle" type="checkbox"  data-toggle="toggle">
								</label>
							</div>
							<div class="clear"></div>
						</li>
						
						<li class="line box-item"  state="0">
							<div class="icon"><i class="fa fa-lightbulb-o"></i></div>
							<div class="control-button">
								<div class="main">
									<div class="line text">Heat LED</div>
									<input type="text" class="form-control input-time" placeholder="Time" />
								</div>
								<label class="checkbox-inline control-led">
  									<input id="heat_led_toggle" type="checkbox"  data-toggle="toggle">
								</label>
							</div>
							<div class="clear"></div>
						</li>
						
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			
			<div class="control-box">
				<div class="line box-title">
					Pumps Control
					<div class="activity"><i title="Info" class="fa fa-table"></i> <i title="Delete" class="fa fa-times"></i></div>
				</div>
				<div class="main">
					<ul>
						<li class="line box-item"  state="0">
							<div class="icon"><i class="fa fa-tint"></i></div>
							<div class="control-button">
								<div class="main">
									<div class="line text">Pump of A liquid</div>
									<input type="text" class="form-control input-time" placeholder="Time" />
								</div>
								<label class="checkbox-inline control-led">
  									<input id="led_toggle" type="checkbox"  data-toggle="toggle">
								</label>
							</div>
							<div class="clear"></div>
						</li>
						
						<li class="line box-item"  state="0">
							<div class="icon"><i class="fa fa-tint"></i></div>
							<div class="control-button">
								<div class="main">
									<div class="line text">Pump of B liquid</div>
									<input type="text" class="form-control input-time" placeholder="Time" />
								</div>
								<label class="checkbox-inline control-led">
  									<input id="led_toggle" type="checkbox"  data-toggle="toggle">
								</label>
							</div>
							<div class="clear"></div>
						</li>
						
						<li class="line box-item"  state="0">
							<div class="icon"><i class="fa fa-tint"></i></div>
							<div class="control-button">
								<div class="main">
									<div class="line text">Pump of pH up</div>
									<input type="text" class="form-control input-time" placeholder="Time" />
								</div>
								<label class="checkbox-inline control-led">
  									<input id="led_toggle" type="checkbox"  data-toggle="toggle">
								</label>
							</div>
							<div class="clear"></div>
						</li>
						
						<li class="line box-item"  state="0">
							<div class="icon"><i class="fa fa-tint"></i></div>
							<div class="control-button">
								<div class="main">
									<div class="line text">Pump of pH down</div>
									<input type="text" class="form-control input-time" placeholder="Time" />
								</div>
								<label class="checkbox-inline control-led">
  									<input id="led_toggle" type="checkbox"  data-toggle="toggle">
								</label>
							</div>
							<div class="clear"></div>
						</li>
						
					</ul>
				</div>
				<div class="clear"></div>	
			</div>

			
			<div class="control-box">
				<div class="line box-title">
					Fan Control
					<div class="activity"><i title="Info" class="fa fa-table"></i> <i title="Delete" class="fa fa-times"></i></div>
				</div>
				<div class="main">		
					<ul>
						<li class="line box-item"  state="0">
							<div class="icon"><i class="fa fa-snowflake-o"></i></div>
							<div class="control-button">
								<div class="main">
									<div class="line text">Fan</div>
									<input type="text" class="form-control input-time" placeholder="Time" />
								</div>
								<label class="checkbox-inline control-led">
  									<input id="led_toggle" type="checkbox"  data-toggle="toggle">
								</label>
							</div>
							<div class="clear"></div>
						</li>
						
						
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			
			<div class="clear"></div>
	</div>
</div>

<!-- <label class="checkbox-inline">
  <input type="checkbox" checked data-toggle="toggle"> LED 2
</label> -->