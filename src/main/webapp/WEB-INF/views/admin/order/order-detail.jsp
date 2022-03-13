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
			<h1 class="mt-4">Order Detail</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="<c:url value='/Admin'/>">Home</a></li>
				<li class="breadcrumb-item active">Order Detail</li>
			</ol>
			<div class="card mb-4">

			</div>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> Table Order Detail
				</div>

				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>Name</th>
								<th>Image</th>
								<th>Quantity</th>
								
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Name</th>
								<th>Image</th>
								<th>Quantity</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach var="item" items="${orderDetailDTO}">
								<tr>
									<td>${item.productName}</td>
									<td><img src="${item.productImage}" style="height: 45px; width: 45px" /></td>
									<td>${item.productQuantity}</td>
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
</body>
</html>