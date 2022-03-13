<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
    <c:url var="orderURL" value="/Check-out" />
<c:url var="orderAPI" value="/api/order" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My order</title>
</head>
<body>
	<div class="card">
		<div style="margin-left: 35px;" class="row">
			<div class="col-md-8 cart">
				<div class="title">
					<div class="row">
						<div class="col">
							<h4>
								<b style="color: green; margin-left: 250px;">My Order </b>
							</h4>
						</div>

					</div>
				</div>
				<div style="width: 900px;" class="row border-top border-bottom">
					<div margin-left: 15px; class="row main align-items-center">
					 <form  id="formSubmit" >
						<table class="table table-bordered">
							<thead>
								<tr>
									<th style="text-align: center;">Order Number</th>
									<th style="text-align: center;">Total Price</th>
									<th style="text-align: center;">Date</th>
									<th style="text-align: center;">Status</th>
									<th style="text-align: center;">Edit</th>
									<th style="text-align: center;">Detail</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${orderDTO}">
								<c:if test="${item.statusId != 5}">
									<tr>
										<td>${item.id}</td>
										<td>${item.totalPrice}</td>
										<td>${item.createdDate}</td>
										<td>${item.status}</td>
										<c:url var="updateURL" value="/Admin/order/edit">
											<c:param name="id" value="${item.id}" />
										</c:url>
										<td>
										<a ><i class="icon-close"></i></a>
											<a href="<c:url value='/Change/${item.id}'/>"
												style="margin-right: 12px; color: red;" 
												class="close">&#10005;</a>
										</td>
										<td>
										<a href="/Order/Detail/${item.id}"  style="font-size:14px">Detail</a>
										</td>

									</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
						<input type="hidden" value="${item.id}" id="id" name="id"/>
						</form>
						<div class="title">
							<div class="row">
								<div class="col">
									<h4>
										<b style="color: red; margin-left: 60px;">Canceled order</b>
									</h4>
								</div>
							</div>
						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th style="text-align: center;">Order Number</th>
									<th style="text-align: center;">Total Price</th>
									<th style="text-align: center;">Date</th>
									<th style="text-align: center;">Status</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${orderDTO}">
								<c:if test="${item.statusId == 5}">
									<tr>
										<td>${item.id}</td>
										<td>${item.totalPrice}</td>
										<td>${item.createdDate}</td>
										<td>${item.status}</td>
									</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
						<div class="back-to-shop">
							<a href="<c:url value='/Shop?page=1'/>">&leftarrow;</a><span
								class="text-muted">Back to shop</span>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>