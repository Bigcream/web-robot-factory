<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="cartURL" value="/Cart" />
<c:url var="loginURL" value="/Login" />
<c:url var="addressAPI" value="/api/address" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>


		<c:if test="${not empty message}">
			<div class="alert alert-${alert}">${message}</div>
		</c:if>
		<div style="margin-top: 40px;" class="container">
			<div class="card">
				<div class="row">
					<div class="col-md-8 cart">
						<div class="title">
							<div class="row">
								<div class="col">
									<h4 style="color: black">
										<b>Detail Order</b>
									</h4>
								</div>
							</div>
						</div>
						<c:forEach var="item" items="${orderDetailDTO}">
							<div class="row border-top border-bottom">
								<div class="row main align-items-center">
									<div class="col-2">
										<img class="img-fluid" src="${item.productImage}">
									</div>
									<div class="col">
										<div class="row text-muted">${item.productName}</div>
										
									</div>
									<div style="font-size: 20px;" class="col">
										<a href="#" class="border">${item.productQuantity}</a>
											
									</div>
								</div>
							</div>
						</c:forEach>

						<div class="back-to-shop">
							<a href="<c:url value='/Check-out/Order'/>">&leftarrow;</a><span
								class="text-muted">Back to my order</span>
						</div>
						<div class="row mt-3">
							<div class="col-md-6">
								<button type="button" class="btn" id="btn-show-profile">See
									address</button>
							</div>
							<div class="col-md-6">
								<button type="button" class="btn" id="btn-show-update-profile">Hide
									address</button>
							</div>
						</div>
					</div>

					<div class="col-md-4 summary">
						<div>
							<h5>
								<b>Order</b>
							</h5>
						</div>
						<hr>

						<p>SHIPPING</p>
						<select>
							<option class="text-muted">Standard-Delivery- &euro;5.00</option>
						</select>
					</div>
				</div>
			</div>
		</div>
	<form:form action="" class="tm-edit-product-form"
		id="formAddressSubmit" role="form" commandName="addressDTO">
		<div style="width: 900px;"
			class="container rounded bg-white mt-5 mb-5" id="form-update-profile">

			<div class="col-md-3 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
					<img class="rounded-circle mt-5" width="250px"
						src="<c:url value='/template/web/assets/images/1575377212_timthumb.png'/>">
				</div>
			</div>
			<div class="col-md-5 border-right">
				<div class="p-3 py-5">
					<div class="d-flex justify-content-between align-items-center mb-3">
						<h4 class="text-right">Profile Settings</h4>
					</div>

					<div class="row mt-3">
						<div class="col-md-6">
							<label style="color: black;" class="labels">Name</label>
							<form:input readonly="true" type="text" class="form-control" placeholder="Name"
								path="name" />
						</div>
						<div class="col-md-6">
							<label style="color: black;" class="labels">Mobile Number</label>
							<form:input readonly="true" type="text" class="form-control" path="phoneNumber"
								placeholder="Mobile Number" />
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-md-12">
							<label style="color: black;" class="labels">Address</label>
							<form:input readonly="true" type="text" class="form-control"
								placeholder="Enter address " path="address" />
						</div>

					</div>
					<div class="row mt-3">
						<div class="col-md-6">
							<label style="color: black;" class="labels">Country</label>
							<form:input readonly="true" type="text" class="form-control"
								placeholder="Country" path="country" />
						</div>
						<div class="col-md-6">
							<label style="color: black;" class="labels">City</label>
							<form:input readonly="true" type="text" class="form-control" path="city"
								placeholder="City" />
						</div>
						<div class="col-md-12">
							<label style="color: black;" class="labels">Email</label>
							<form:input readonly="true" type="text" class="form-control" placeholder="Email"
								path="email" />
						</div>
					</div>
				</div>
			</div>

		</div>
	</form:form>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.sub-bnr').css("display", "none")
			$('#form-update-profile').css("display", "none")
		})
		$(document).on('click', "#btn-show-update-profile", function() {
			$('#table-profile').css("display", "none");
			$('#form-update-profile').css("display", "none")
		})
		$(document).on('click', "#btn-show-profile", function() {
			$('#table-profile').css("display", "block");
			$('#form-update-profile').css("display", "block")
		})

	</script>
</body>
</html>