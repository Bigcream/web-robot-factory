<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="orderURL" value="/Admin/order/list" />
<c:url var="orderAPI" value="/api/order" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Order</title>
</head>
<body>

	<div id="layoutSidenav">

		<div id="layoutSidenav_content">
			<main>
			<div style="width: 1130px;" class="container-fluid px-4">
				<h1 class="mt-4">Order</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a href="<c:url value='/Admin'/>">Home</a></li>
					<li class="breadcrumb-item active">Order</li>
				</ol>
				<div class="card mb-4"></div>
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table me-1"></i> Table order
					</div>

					<div class="card-body">

						<table id="datatablesSimple">
							<thead>
								<tr>
									<th>Order Number</th>
									<th>Customer</th>
									<th>Total Price</th>
									<th>Date</th>
									<th>Status</th>
									<th>Edit</th>
									<th>Detail</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Order Number</th>
									<th>Customer</th>
									<th>Total Price</th>
									<th>Date</th>
									<th>Status</th>
									<th>Edit</th>
									<th>Detail</th>
								</tr>
							</tfoot>

							<tbody>


								<c:forEach var="item" items="${orderDTO}">


									<tr>
										<td>${item.id}</td>
										<td>${item.createdBy}</td>
										<td>${item.totalPrice}</td>
										<td>${item.createdDate}</td>
										<td>${item.status}</td>
										<c:url var="updateURL" value="/Admin/order/edit">
											<c:param name="id" value="${item.id}" />
										</c:url>
										<td><a class="btn " data-toggle="tooltip"
											title="update new" href='${updateURL}'><i
												class='fas fa-edit' style='font-size: 24px'
												aria-hidden="true"></i> </a></td>
										<c:url var="detailURL" value="/Admin/Order/Detail/${item.id}">
										</c:url>
										<td><a class="btn " data-toggle="tooltip"
											title="update new" href='${detailURL}'><i
												class="fa fa-search-plus" style="font-size: 24px"
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
					<div
						class="d-flex align-items-center justify-content-between small">
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