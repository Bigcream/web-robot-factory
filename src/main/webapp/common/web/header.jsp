<%@ page import="com.blog.util.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- Site Header -->
<div class="site-header-bg">
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
			
				<a href="index.html"><img style="width: 200px;" src="<c:url value='/template/web/assets/images/logo.png'/>"
					alt="logo"></a>
			</div>
			<div class="col-sm-3 col-sm-offset-3 text-right">
				<span class="ion-android-cart"></span><a href="<c:url value='/Shop?page=1'/>">${cart.totalProduct} products</a> 
				<form  action="<c:url value='/Search?page=1'/>" method="POST">
					<div class="input-group">
						<input id="key" name="key" style="color: white;" type="text" class="form-control" placeholder=""> <span
							class="input-group-btn">
							<button class="btn btn-default btn-robot" type="submit">Search</button>
						</span>
					</div>
					<!-- /input-group -->
				</form>
			</div>
		</div>
	</div>
</div>

<!-- Header -->

<section id="header" class="main-header">
	<div class="container">

		<div class="row">
			<nav class="navbar navbar-default">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#site-nav-bar"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>

				<div class="collapse navbar-collapse" id="site-nav-bar">
					<ul class="nav navbar-nav">
						<li class="active"><a href="<c:url value='/Home'/>">Home</a></li>
						<li><a href="<c:url value='/Shop?page=1'/>">Shop</a></li>
						<li><a href="<c:url value='/News?page=1'/>">News</a></li>
						<li><a href="<c:url value='/Cart'/>">My cart</a></li>
						<li><a href="<c:url value='/Check-out/Order'/>">My order</a></li>
						<security:authorize access="isAnonymous()">
							<li><a href="<c:url value='/Login'/>">Sign in</a></li>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<li><a href="#">Wellcome, <%=SecurityUtils.getPrincipal().getFullName()%></a></li>
							<li><a href="<c:url value='/Logout'/>">Log out</a></li>
						</security:authorize>

					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</nav>
		</div>
		

<!-- /#header -->