<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="shopURL" value="/Shop?page=1" />
<c:url var="cartAPI" value="/api/cart" />
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category</title>
</head>

<body>
	<form action="<c:url value='/Sport-robot?page=1'/>" id="formSubmit"
		method="get">
	<!-- Header -->
	<section id="header" class="main-header shop-header inner-header">
		<div class="container">


			<div class="intro row">
				<div class="overlay"></div>
				<div class="col-sm-12">
					<ol class="breadcrumb">
						<li><a href="<c:url value='/Space-robot?page=1'/>">SPACE ROBOT</a></li>
						<li><a href="<c:url value='/Sport-robot?page=1'/>">SPORTS ROBOT</a></li>
						<li><a href="<c:url value='/Toy-for-kid?page=1'/>">TOY FOR KIDS</a></li>
					</ol>
				</div>
			</div>
			<!-- /.intro.row -->
		</div>
		<!-- /.container -->
		<div class="nutral"></div>
	</section>
	<!-- /#header -->

		<!-- Shop -->
		<section class="shop">

			<div class="row">
				<div class="col-sm-12">
					<div class="title-box">
						<p>Get our</p>
						<h2 style="color: white" class="title mt0">Products</h2>
					</div>
				</div>
			</div>

			<div class="row">

				<c:forEach var="item" items="${model.listResult}">
				<c:if test="${item.categoryId == 2}">
					<div style="width: 300px; left: 122px;" class="col-sm-6">
						<div class="shop-box">
							<img style="height: 270px; width: 270px;"
								class="img-full img-responsive" src="${item.image}" alt="shop">
							<div class="shop-box-hover text-center">
								<div class="c-table">
                                        <div class="c-cell">
                                            <a href="#">
                                                <span class="ion-heart"></span>
                                            </a>
                                            <a href="<c:url value='/Product-detail/${item.id}'/>">
                                                <span class="ion-ios-search-strong"></span>
                                            </a>
                                            
                                        </div>

								</div>
							</div>
						</div>
						<div class="shop-box-title">
							<div class="row">
								<div class="col-sm-6">
									<h4 style="letter-spacing: 0px;">${item.name}</h4>
									<h4 style="letter-spacing: 0px;">
										MO: <span class="thin">#00SS5</span>
									</h4>
								</div>
								<div class="col-sm-6">
									<p style="letter-spacing: 0px; font-size: 20px;"
										class="shop-price">${item.price}$</p>
										
									<div class="star">
									
										<span class="ion-ios-star"></span> <span class="ion-ios-star"></span>
										<span class="ion-ios-star"></span> <span
											class="ion-ios-star-half"></span> <span
											class="ion-ios-star-outline"></span>
									</div>
								</div>
							</div>
						</div>
					</div>
					</c:if>
				</c:forEach>
				<div class="col-sm-12">
					<ul class="pager" id="pagination"></ul>
					<input type="hidden" value="" id="page" name="page" />
					
				</div>
			</div>

			</div>


		</section>

		<div class="container">
			<nav aria-label="Page navigation"></nav>
		</div>
		
	</form>
	<script>
	var totalPages = ${model.totalPage};
	var currentPage = ${model.page};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>
</body>
</html>