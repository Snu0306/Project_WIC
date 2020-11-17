<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.modal-header, h4, .close {
	background-color: #ddc5ee;
	color: white !important;
	text-align: center;
	font-size: 30px;
}

.modal-footer {
	background-color: #f9f9f9;
}
</style>
<script>
    $(document).ready(function(){
      $("#modalBtn").click(function(){
        $("#myModal").modal();
      });
    });
    </script>
</head>
<body>
	<div class="container">
		<table>
			<tbody>
				<tr>
					<td>1</td>
					<td><a id="modalBtn" href="#myModal" data-toggle="modal"
						data-target="#myModal">상품 문의드려요.</a></td>
					<td>문지</td>
				</tr>
				<tr>
					<td>2</td>
					<td><a href="#">에눌 가능한가요?</a></td>
					<td>재형이</td>
				</tr>
			</tbody>
		</table>


		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog" style="position: absolute;">

				<!-- Modal content-->
				<div class="modal-content"
					style="min-width: 1200px; margin: 100px 180px;">
					<div class="modal-header" style="padding: 25px 35px;">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>
							<span class="glyphicon glyphicon-lock"></span> ct_title
						</h4>
						<br>
					</div>
					<div class="modal-body" style="padding: 40px 50px;">
						<form role="form">
							<div class="form-group"
								style="width: 40%; float: left; margin-right: 10%;">
								<label for="ch-content"><span
									class="glyphicon glyphicon-user"></span> content</label> <input
									type="text" class="form-control" id="ch-content"> <label
									for="comment"><span
									class="glyphicon glyphicon-eye-open"></span> comment</label> <input
									type="text" class="form-control" id="comment">
							</div>
							<div class="form-group" style="width: 50%; float: left;">
								<label for="commentlist"><span
									class="glyphicon glyphicon-eye-open"></span> commentlist</label> <input
									type="text" class="form-control" id="commentlist">
							</div>


						</form>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn-success" value="CONFIRM">
						<input type="submit" class="btn-danger" value="CANCEL"
							data-dismiss="modal">
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>