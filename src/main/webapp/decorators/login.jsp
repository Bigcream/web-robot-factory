<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><dec:title default="Login" /></title>
<link rel="stylesheet"
	href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'/>"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<c:url value='https://use.fontawesome.com/releases/v5.3.1/css/all.css'/>"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/template/login/style.css'/>">
</head>
<body id="LoginForm">
	<dec:body />

	<script
		src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'/>"></script>
	<script
		src="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js'/>"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="<c:url value='/template/login/script.js'/>"></script>
</body>

</html>