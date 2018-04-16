<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="manager">
<div id="block_manage">
	
	<!-- page title -->
	<div class="main">
	<div class="page-title">
		<span id="pt"></span>
		<div id="add-record" class="add-record" data-toggle="modal" data-target="#myModal">
			<i class="fa fa-plus"></i>
			<span> Add Record</span>
		</div>
		<div class="clear"></div>
	</div>
	</div>
	<!-- end page title -->
	
	<div class="main">
		<!-- pager -->
		<div class="line mar-t-20px">
			<div class="column">
				<div class = "fl-l mar-t-7px mar-r-10px">Select row : </div>
				<select class="form-control width-auto" id="num_row">
					<option value="5">5 rows</option>
					<option value="10">10 rows</option>
					<option value="20">20 rows</option>
					<option value="50">50 rows</option>
					<option value="100">100 rows</option>
				</select>
			</div>
			
			<div class="pager">
				<div class="end" id="first_page">First</div>
				<ul class="fl-l" id="pager">
					<li class="page-item" state="active">1</li>
					<li class="page-item">1</li>
					<li class="page-item">1</li>
					<li class="page-item">1</li>
					<li class="page-item">1</li>
				</ul>
				<div class="end" id="last_page">Last</div>
			</div>
			
			<div class="clear"></div>
		</div>
		<!-- end pager -->
	</div>
		
	<div class="container">
				<div class="row">

					<div class="frame-box col-lg-4 col-md-4 col-sm-4 col-xs-12" > 
						<div class="box-inside">
						<div class="delete-box"><i class="fa fa-trash"></i></div>
							<div class="main"> 
								<img class="frame-img" src="/GHServer/image?image=frame.png" />
								<div class="main"> 
									<div class="frame-title">Frame number 1</div>
									<div class="frame-info"><i class="fa fa-calendar"></i> Create at  : <b>10h:23m:12s 15/03/2018</b></div>
									<div class="frame-info"><i class="fa fa-leaf"></i> Plant         : <b>Tomatoes</b></div>
									<div class="frame-info"><i class="fa fa-cogs"></i> Status       : <b>Active</b></div>
									<div class="frame-info"><i class="fa fa-clock-o"></i> Days          : <b>30</b></div>



									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="main">
												<button class="btn btn-success frame-button"><i class="fa fa-gamepad"></i> Control</button>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="main">
												<button class="btn btn-success frame-button"><i class="fa fa-bar-chart-o"></i> Statistic</button>
											</div>
										</div>
									</div>

								</div>	
							</div>
						</div>
					</div>

				</div>
			</div>
</div>
</div>