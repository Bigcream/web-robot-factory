<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Home</title>


<link rel="stylesheet" href="<c:url value='/template/admin/templatemo-style.css'/>">
<link
	href="<c:url value='https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/template/admin/css/styles.css'/>"
	rel="stylesheet" />
<script
	src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js'/>"
	crossorigin="anonymous"></script>
<!-- Custom fonts for this template-->
<link
	href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css'/>"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link
	href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.css'/>"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template-->
<link href="<c:url value='/template/admin/css/sb-admin.css'/>"
	rel="stylesheet" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <!-- sweetalert -->
    <script src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
    <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />

</head>
<body class="sb-nav-fixed">

	<%@ include file="/common/admin/header.jsp"%>
	<div id="layoutSidenav" >
	<%@ include file="/common/admin/menu.jsp"%>
		<dec:body />
		
	</div>

	<!-- Bootstrap core JavaScript-->
	
	<script
		src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

	<!-- Page level plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/chart.js/Chart.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/vendor/datatables/jquery.dataTables.js'/>"></script>
	<script
		src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.js'/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/template/admin/js/sb-admin.min.js'/>"></script>

	<!-- Demo scripts for this page-->
	<script
		src="<c:url value='/template/admin/js/demo/datatables-demo.js'/>"></script>
	<script
		src="<c:url value='/template/admin/js/demo/chart-area-demo.js'/>"></script>

	<script
		src="<c:url value='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'/>"
		crossorigin="anonymous"></script>
	<script src="<c:url value='/template/admin/js/scripts.js'/>"></script>
	<script
		src="<c:url value='https://cdn.jsdelivr.net/npm/simple-datatables@latest'/>"
		crossorigin="anonymous"></script>
	<script
		src="<c:url value='/template/admin/js/datatables-simple-demo.js'/>"></script>
</body>
</html>