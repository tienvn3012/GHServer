<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
	
<div id="manager">
	<div class="main">
	
		<!-- page title -->
		<div class="page-title">
			<span id="pt"></span>
			<div id="add-record" class="add-record" data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i>
				<span> Add Record</span>
			</div>
		</div>
		<!-- end page title -->
	
		<!-- table -->
		<div class="line text-align-right mar-t-20px" id="total_records"></div>
		<div class="table-manager scroll">
			<ul>
				<li class="item">
					<div class="main display-flex">
						<div class="select-item">
							<input type="checkbox" />
						</div>
						<div class="display-left">
							<div class="image">
								<img src="https://scontent.fhan2-1.fna.fbcdn.net/v/t34.0-12/24099750_1120747188060839_1514970606_n.png?oh=e00177c45f74fb8c27270f3f571eed25&oe=5A427D81" />
							</div>
							<div class="text">
								<span class="text-level-1 fl-l">hello</span>
								<span class="text-level-2 fl-l">asncsanc</span>
								<span class="text-level-3 fl-l">sacnjasncjasn</span>
							</div>
						</div>
						<div class="display-mid">
							<div class="image">
								<img src="https://scontent.fhan2-1.fna.fbcdn.net/v/t34.0-12/24099750_1120747188060839_1514970606_n.png?oh=e00177c45f74fb8c27270f3f571eed25&oe=5A427D81" />
							</div>
							<div class="text">
								<span class="text-level-1 fl-l">hello</span>
								<span class="text-level-2 fl-l">asncsanc</span>
								<span class="text-level-3 fl-l">sacnjasncjasn</span>
							</div>
						</div>
						<div class="display-right">
							<div class="action"><i class="fa fa-trash"></i></div>
							<div class="action"><i class="fa fa-edit"></i></div>
							<div class="action"><i class="fa fa-arrow-right"></i></div>
						</div>
						
					</div>
				</li>
				
				
			</ul>
		</div>
		<!-- end table -->
		
	</div>
	
	
	<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title" id="modal_header">Modal Header</h4>
      </div>
      <div class="modal-body" id="modal_body">
        <p>Some text in the modal.</p>
      </div>
      <div class="modal-footer" id="modal_footer">
      	<button id="modal_action" type="button" action="" class="btn btn-success" data-dismiss="modal">something</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
	
</div>
<!-- end id -->