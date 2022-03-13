<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail</title>
</head>
<body>
<form action="<c:url value='/Cart/${model.id}'/>" id="formSubmit"
		method="POST">
	<!-- Product section-->
	<section class="py-5">
		<div style="background: white;" class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div style="border-right: 1px solid black" class="col-md-6">
					<img style="height: 500px;width: 400px;" class="card-img-top mb-5 mb-md-0"
						src="${model.image}" alt="..." />
				</div>
				<div class="col-md-6">
					<div style="color: black" class="small mb-1">SKU: BST-498</div>
					<h1 style="color: black" class="display-5 fw-bolder">${model.name}</h1>
					<div class="fs-5 mb-5">
						<span style="color: black" class="text-decoration-line-through">$55.00</span>
						<span style="color: black">$${model.price}</span>
					</div>
					<p
						style="color: black; letter-spacing: 0px; font-family: 'Oswald';"
						class="lead">${model.description}</p>
					<!-- QTY -->
					<label style="color: black;" for="title">Quantity: ${model.quantity} </label>
					<div>
					
						<!-- QTY -->
						<input class="btn" class="selectpicker" id="minus"
							class="minus is-form" type="button" value="-"
							style="max-width: 3rem;border: 1px solid black;padding:0px;font-size: 16px;"> 
						<input class="btn"
							 readonly id="Num" name="quantity"
							class="form-control text-center me-3" type="num" value="1"
							style="max-width: 3rem;border: 1px solid black;padding:0px;font-size: 16px;" /> 
						<input class="btn"
							class="selectpicker" id="plus" class="plus is-form" type="button"
							value="+" style="max-width: 3rem;border: 1px solid black;padding:0px;font-size: 16px;">
					</div>

					<button
						style="color: black; border-radius: 12px; border: 1px solid black; width: 20%;"
						class="btn btn-outline-white flex-shrink-0" type="submit">
						Add to cart</button>

				</div>
			</div>
		</div>
	</section>
	</form>
	
	<!-- Related items section-->
	<section class="py-5 bg-light">
		<div class="container px-4 px-lg-5 mt-5">
			<h2 style="color: black;" class="fw-bolder mb-4">Related
				products</h2>
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<c:forEach var="item" items="${model.listResult}">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div style="color: black;"
							class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img style="height: 200px;width: 200px;" class="card-img-top"
							src="${item.image}" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 style="color: black;" class="fw-bolder">Special Item</h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								<span style="color: black;"
									class="text-muted">$${item.price}</span>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div style="border-radius: 12px; border: 1px solid black"
								class="text-center">
								<a class="btn btn-outline-white mt-auto" href="<c:url value='/Product-detail/${item.id}'/>">View product</a>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</section>
	    <script>
	    var quantity = ${model.quantity};
        $(document).ready(function () {
            var num = 1;
            $("#plus").click(function () {
            	if(num < quantity){
                    num++;
                    $("#Num").val(num);
            	}
            });
            $("#minus").click(function () {
                if (num != 1) {
                    num--;
                    $("#Num").val(num);
                }
            });
        });
    </script>
</body>
</html>