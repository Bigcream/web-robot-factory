<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
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
							<i class="fas fa-table me-1"></i> Table order canceling
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
									</tr>
								</tfoot>
								
								<tbody>
									
									
									<c:forEach var="item" items="${orderDTO}">
									    <c:if test="${item.statusId == 4}">
											<tr>
												<td>${item.id}</td>
												<td>${item.createdBy}</td>
												<td>${item.totalPrice}</td>
												<td>${item.createdDate}</td>
												<td>${item.status}</td>
									<c:url var="yesURL" value="/Admin/order/canceling">
										<c:param name="id" value="${item.id}" />
										<c:param name="statusId" value="5" />
									</c:url>
									<c:url var="noURL" value="/Admin/order/canceling">
										<c:param name="id" value="${item.id}" />
										<c:param name="statusId" value="1" />
									</c:url>
									<td><a class="btn " data-toggle="tooltip"
										title="No" href='${noURL}'><i
											class="fa fa-times-circle"  style='font-size: 24px;color:red'
											aria-hidden="true"></i> </a>
											<a class="btn " data-toggle="tooltip"
										title="Yes" href='${yesURL}'><i
											class="fa fa-check-circle"  style='font-size: 24px;color:green'
											aria-hidden="true"></i> </a>
									</td>
							 					
											</tr>
											  </c:if> 
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