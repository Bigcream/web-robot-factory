<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="productAPI" value="/api/product"/>
<c:url var="productURL" value="/Admin/product/list"/>
<!DOCTYPE html>
<html>
<body>
<div id="layoutSidenav">

	<div id="layoutSidenav_content">
		<main>
		<div style="width: 1130px;" class="container-fluid px-4">
			<h1 class="mt-4">Product</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="<c:url value='/Admin'/>">Home</a></li>
				<li class="breadcrumb-item active">Product</li>
			</ol>
			<div class="card mb-4">

			</div>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> Table Product
				</div>

				<div class="card-body">
					<div style="float: right">
						<c:url var="createProductURL" value="/Admin/product/edit" />
						<a data-toggle="tooltip" title='Create product' href='${createProductURL}'>
							<span> <i class="fa fa-plus-circle"
								style="font-size: 24px"></i>
						</span>
						</a>
						<button id="btnDelete" type="button"
							onclick="warningBeforeDelete()" class='far fa-trash-alt'
							style='font-size: 24px' data-toggle="tooltip" title='Delete product'>
							<span> <i class="fa fa-trash-o bigger-110 pink"></i>
							</span>
						</button>
					</div>
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Image</th>
								<th>Category code</th>
								<th>Short description</th>
								<th>Quantity</th>
								<th>Edit</th>
								
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Image</th>
								<th>Category code</th>
								<th>Short description</th>
								<th>Quantity</th>
								<th>Edit</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach var="item" items="${model.listResult}">
								<tr>
									<td><input style="left: 20px" class="form-check-input"
										type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
									<td>${item.name}</td>
									<td><img src="${item.image}" style="height: 45px; width: 45px" /></td>
									<td>${item.categoryCode}</td>
									<td>${item.description}</td>
									<td>${item.quantity}</td>
									<c:url var="updateproductURL" value="/Admin/product/edit">
										<c:param name="id" value="${item.id}" />
									</c:url>
									<td><a class="btn " data-toggle="tooltip"
										title="update product" href='${updateproductURL}'><i
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
		            url: '${productAPI}',
		            type: 'DELETE',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            success: function (result) {
		                window.location.href = "${productURL}";
		            },
		            error: function (error) {
		            	window.location.href = "${productURL}";
		            }
		        });
		    }
		</script>
</body>
</html>