<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="newAPI" value="/api/new"/>
<c:url var="newURL" value="/Admin/new/list"/>
<!DOCTYPE html>
<html>
<body>
<div id="layoutSidenav">

	<div id="layoutSidenav_content">
		<main>
		<div style="width: 1130px;" class="container-fluid px-4">
			<h1 class="mt-4">News</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="<c:url value='/Admin'/>">Home</a></li>
				<li class="breadcrumb-item active">News</li>
			</ol>
			<div class="card mb-4">

			</div>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> Table News
				</div>

				<div class="card-body">
					<div style="float: right">
						<c:url var="createNewURL" value="/Admin/new/edit" />
						<a data-toggle="tooltip" title='Create new' href='${createNewURL}'>
							<span> <i class="fa fa-plus-circle"
								style="font-size: 24px"></i>
						</span>
						</a>
						<button id="btnDelete" type="button"
							onclick="warningBeforeDelete()" class='far fa-trash-alt'
							style='font-size: 24px' data-toggle="tooltip" title='Delete new'>
							<span> <i class="fa fa-trash-o bigger-110 pink"></i>
							</span>
						</button>
					</div>
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th></th>
								<th>Title</th>
								<th>Thumbnail</th>
								<th>Category</th>
								<th>Short description</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Title</th>
								<th>Thumbnail</th>
								<th>Category code</th>
								<th>Short description</th>
								<th>Edit</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach var="item" items="${model.listResult}">
								<tr>
									<td><input style="left: 20px" class="form-check-input"
										type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
									<td>${item.title}</td>
									<td><img src="${item.thumbnail}" style="height: 45px; width: 45px" /></td>
									<td>${item.categoryCode}</td>
									<td>${item.shortDescription}</td>
									<c:url var="updateNewURL" value="/Admin/new/edit">
										<c:param name="id" value="${item.id}" />
									</c:url>
									<td><a class="btn " data-toggle="tooltip"
										title="update new" href='${updateNewURL}'><i
											class='fas fa-edit' style='font-size: 24px'
											aria-hidden="true"></i> </a></td>
								</tr>
							</c:forEach>
		
						</tbody>
					</table>
				</div>
			</div>
		</div>
		</main>
		<footer class="py-4 bg-light mt-auto">
			<div class="container-fluid px-4">
				<div class="d-flex align-items-center justify-content-between small">
					<div class="text-muted">Copyright &copy; Your Website 2021</div>
					<div>
						<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
							&amp; Conditions</a>
					</div>
				</div>
			</div>
		</footer>
	</div>
</div>
		<script>
			
			function warningBeforeDelete() {
					swal({
					  title: "Confirm delete",
					  text: "Are you sure you want to delete?",
					  type: "warning",
					  showCancelButton: true,
					  confirmButtonClass: "btn-success",
					  cancelButtonClass: "btn-danger",
					  confirmButtonText: "Yes, Delete it",
					  cancelButtonText: "No, Cancel pls",
					}).then(function(isConfirm) {
					  if (isConfirm) {
							var ids = $('tbody input[type=checkbox]:checked').map(function () {
					            return $(this).val();
					        }).get();
							deleteNew(ids);
					  }
					});
			} 
			function deleteNew(data) {
		        $.ajax({
		            url: '${newAPI}',
		            type: 'DELETE',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            success: function (result) {
		                window.location.href = "${newURL}";
		            },
		            error: function (error) {
		            	window.location.href = "${newURL}";
		            }
		        });
		    }
		</script>
</body>
</html>