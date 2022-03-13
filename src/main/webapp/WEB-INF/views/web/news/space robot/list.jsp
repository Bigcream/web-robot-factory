<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List news</title>
</head>
<body>

<form action="<c:url value='/News'/>" id="formSubmit" method="get">
	<!-- Header -->
	<section id="header" class="main-header shop-header inner-header">
		<div class="container">


			<div style="width: 1110px;" class="intro row">
				<div class="overlay"></div>
				<div class="col-sm-12">
					<ol class="breadcrumb">

					</ol>
				</div>
			</div>
			<!-- /.intro.row -->
		</div>
		<!-- /.container -->
		<div class="nutral"></div>
	</section>
	<!-- /#header -->

	<c:forEach var="item" items="${model.listResult}">
		<section id="one">
			<div style="border: 1px solid black;">

				<div class="row">
					<div class="col-md-8">
						<div class="section-highlight">
							<h2>${item.title}</h2>
						</div>
						<div class="section-details">
							<p style="letter-spacing: 0px;">${item.shortDescription}</p>
							<c:url var="detail" value="/Detail">
								<c:param name="id" value="${item.id}" />
							</c:url>
							<a href="${detail}" class="btn btn-learn-more">LEARN MORE <i
								class="ion-ios-arrow-right"></i></a>
						</div>
					</div>
					<div class="col-md-4">

						<img style="width: 336px;height: 330px;" src="${item.thumbnail}"
							alt="Responsive image" class="img-responsive">
					</div>
				</div>

			</div>
		</section>
	</c:forEach>





	<div class="row">
		<div class="col-md-12">
			<a style="color: white;" href="#" class="btn btn-expand-all">Back
				top</a>
		</div>
	</div>
	<ul class="pager" id="pagination"></ul>
	<input type="hidden" value="" id="page" name="page"/>
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