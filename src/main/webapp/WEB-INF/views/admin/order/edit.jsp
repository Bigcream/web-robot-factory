<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
    <c:url var="orderURL" value="/Admin/order/edit?id=${orderDTO.id}" />
<c:url var="orderAPI" value="/api/order" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update order</title>
</head>
<body>
<form:form action="" class="tm-edit-product-form" id="formSubmit"
		role="form" commandName="orderDTO">
		<div id="layoutSidenav_content">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}">${message}</div>
			</c:if>
			<div class="row">
				<div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
					<div style="background-color: #ffffff;" class="tm-bg-primary-dark tm-block tm-block-h-auto">
						<div class="row">
							<div class="col-12">
								<h2 style="color: black;" class="tm-block-title d-inline-block">Update order</h2>
							</div>
						</div>
						<div class="row tm-edit-product-row">

							

								<div class="form-group mb-3">
									<label style="color: black;" for="id">Order number</label>
									<form:input readonly="true" path="id" id="id"
										class="form-control validate" />
								</div>

								<div class="form-group mb-3">
									<label style="color: black;" for=statusId>Status</label>
									<form:select class="custom-select tm-select-accounts"
										path="statusId" id="statusId">
										<form:option value="" label="-- Select status --" />
										<form:options items="${statusEntity}" />
									</form:select>
								</div>
								<div class="form-group mb-3">
									<label style="color: black;" for="createdBy">Customer</label>
									<form:input readonly="true" path="createdBy" id="createdBy"
										class="form-control validate"  />

								</div>
								<div class="form-group mb-3">
									<label style="color: black;" for="createdDate">Date</label>
									<form:input readonly="true" path="createdDate" id="createdDate"
										class="form-control validate"  />

								</div>
								<div class="form-group mb-3">
									<label style="color: black;" for="totalPrice">Total Price</label>
									<form:input readonly="true" path="totalPrice" id="totalPrice"
										class="form-control validate"  />

								</div>
										<div class="row gutters">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="text-right">
					<a href="<c:url value='/Admin/order/list'/>" id="submit" name="submit" class="btn btn-secondary">Cancel</a>
					<button type="button" id="btnChangeStatusOrder"  class="btn btn-primary">Update</button>
				</div>
			</div>
			
		</div>
						</div>
					</div>
				</div>
			</div>
			</main>
									<div class="form-group mb-3">

				
				</div>
<div class="row gutters">
<div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
<div class="card h-100">
	<div class="card-body">
		<div class="account-settings">
			<div class="user-profile">
				<div class="user-avatar">
					<img style="    width: 100px;height: 100px;" src="https://lazi.vn/uploads/users/avatar/1575377212_timthumb.png" alt="Maxwell Admin">
				</div>
				<h5 class="user-name">${addressDTO.name}</h5>
				<h6 class="user-email">${addressDTO.email}</h6>
			</div>
			<div class="about">
				<h5>About</h5>
				<p>I'm Yuki. Full Stack Designer I enjoy creating user-centric, delightful and human experiences.</p>
			</div>
		</div>
	</div>
</div>
</div>
<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
<div class="card h-100">
	<div class="card-body">
		<div class="row gutters">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<h6 class="mb-2 text-primary">Personal Details</h6>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<label style="color: black;" for="fullName">Full Name</label>
					<input type="text" class="form-control" readonly="readonly" value="${addressDTO.name}" id="fullName" placeholder="Enter full name">
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<label style="color: black;" for="eMail">Email</label>
					<input type="email" class="form-control" readonly="readonly" value="${addressDTO.email}" id="eMail" placeholder="Enter email ID">
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<label style="color: black;" for="phone">Phone</label>
					<input type="text" class="form-control" readonly="readonly" value="${addressDTO.phoneNumber}" id="phone" placeholder="Enter phone number">
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<label style="color: black;" for="website">Website URL</label>
					<input type="url" class="form-control" readonly="readonly" value="none" id="website" placeholder="Website url">
				</div>
			</div>
		</div>
		<div class="row gutters">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<h6 class="mt-3 mb-2 text-primary">Address</h6>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<label style="color: black;" for="Street">Street</label>
					<input type="name" class="form-control" readonly="readonly" value="${addressDTO.address}" id="Street" placeholder="Enter Street">
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<label style="color: black;" for="ciTy">City</label>
					<input type="name" class="form-control" readonly="readonly" value="${addressDTO.city}" id="ciTy" placeholder="Enter City">
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<label style="color: black;" for="sTate">Country</label>
					<input type="text" class="form-control" readonly="readonly" value="${addressDTO.country}" id="sTate" placeholder="Enter State">
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<label style="color: black;" for="zIp">Zip Code</label>
					<input type="text" class="form-control" readonly="readonly" value="000000" id="zIp" placeholder="Zip Code">
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</div>
	<form:hidden path="id" id="orderId" />
		</div>
		
	</form:form>
		<script>
		$('#btnChangeStatusOrder').click(function(e) {
			e.preventDefault();
			var data = {};
			var id = $('#orderId').val();
			var statusId = $('#statusId').val();
			data["id"] = id;
			data["statusId"] = statusId;
			updateOrder(data);
		});
        function updateOrder(data) {
            $.ajax({
            	
                url: '${orderAPI}',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'text',
                success: function (result) {
                    window.location.href = "${orderURL}";
                    alert("Changed status order!");
                },
                error: function (error) {
                    window.location.href = "${orderURL}";
                }
            });
        };
	</script>
</body>
</html>