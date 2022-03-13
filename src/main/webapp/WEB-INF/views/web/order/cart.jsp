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

	<form action="<c:url value='/Check-out'/>" id="formSubmit"
		method="POST">
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
										<b>Shopping Cart</b>
									</h4>
								</div>
								<div class="col align-self-center text-right text-muted">${size}
									items</div>
							</div>
						</div>
						<c:forEach var="item" items="${cart.items}">
							<div class="row border-top border-bottom">
								<div class="row main align-items-center">
									<div class="col-2">
										<img class="img-fluid" src="${item.productDTO.image}">
									</div>
									<div class="col">
										<div class="row text-muted">${item.productDTO.name}</div>
										
									</div>
									<div style="font-size: 20px;" class="col">
										<a href="#">-</a><a href="#" class="border">${item.quantity}</a><a
											href="#">+</a>
									</div>
									<div style="color: red" class="col">
										&euro; ${item.productDTO.price*item.quantity} <a
											href="<c:url value='/Remove-item/${item.productDTO.id}'/>"
											style="color: red" class="close">&#10005;</a>
									</div>
								</div>
							</div>
						</c:forEach>

						<div class="back-to-shop">
							<a href="<c:url value='/Shop?page=1'/>">&leftarrow;</a><span
								class="text-muted">Back to shop</span>
						</div>
						<div class="row mt-3">
							<div class="col-md-6">
								<button type="button" class="btn" id="btn-show-profile">Add
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
								<b>Summary</b>
							</h5>
						</div>
						<hr>
						<div class="row">
							<div class="col" style="padding-left: 0;">${cart.totalProduct}
								products</div>

						</div>

						<p>SHIPPING</p>
						<select>
							<option class="text-muted">Standard-Delivery- &euro;5.00</option>
						</select>
						<p>GIVE CODE</p>
						<select id="codeSale" name="codeSale">
							<option value="0" class="text-muted">Choose your code</option>
							<option value="10" class="text-muted">10%</option>
							<option value="20" class="text-muted">20%</option>
							<option value="30" class="text-muted">30%</option>
						</select>

						<div class="row"
							style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">
							<div class="col">TOTAL PRICE</div>
							<div class="col text-right">&euro; ${cart.totalMoney}</div>
						</div>
						<button type="submit" style="margin-top: 30px;">CHECKOUT</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<form:form action="" class="tm-edit-product-form"
		id="formAddressSubmit" role="form" commandName="addressDTO">
		<div style="width: 900px;"
			class="container rounded bg-white mt-5 mb-5" id="form-update-profile">

			<div class="col-md-3 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
					<img class="rounded-circle mt-5" width="250px"
						src="<c:url value='/template/web/assets/images/1575377212_timthumb.png'/>"><span
						class="font-weight-bold">Edogaru</span><span class="text-black-50">edogaru@mail.com.my</span><span>
					</span>
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
							<form:input type="text" class="form-control" placeholder="Name"
								path="name" />
						</div>
						<div class="col-md-6">
							<label style="color: black;" class="labels">Mobile Number</label>
							<form:input type="text" class="form-control" path="phoneNumber"
								placeholder="Mobile Number" />
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-md-12">
							<label style="color: black;" class="labels">Address</label>
							<form:input type="text" class="form-control"
								placeholder="Enter address " path="address" />
						</div>

					</div>
					<div class="row mt-3">
						<div class="col-md-6">
							<label style="color: black;" class="labels">Country</label>
							<form:input type="text" class="form-control"
								placeholder="Country" path="country" />
						</div>
						<div class="col-md-6">
							<label style="color: black;" class="labels">City</label>
							<form:input type="text" class="form-control" path="city"
								placeholder="City" />
						</div>
						<div class="col-md-12">
							<label style="color: black;" class="labels">Email</label>
							<form:input type="text" class="form-control" placeholder="Email"
								path="email" />
						</div>
					</div>
					<div class="mt-5 text-center">
						<button id="addAddress" class="btn btn-primary profile-button"
							type="button">Save Profile</button>
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

		$('#addAddress').click(function(e) {
			e.preventDefault();
			var data = {};

			var formData = $('#formAddressSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			addAddress(data);
		});

		function addAddress(data) {
			$.ajax({
				url : '${addressAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${cartURL}";
				},
				error : function(error) {
					window.location.href = "${loginURL}";
				}
			});
		}
	</script>
</body>
</html>