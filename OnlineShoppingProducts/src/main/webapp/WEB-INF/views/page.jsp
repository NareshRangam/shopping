<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Online Shopping - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot='${contextRoot}';
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Bootstrap Datatable-->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>
			<!--  About Us -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>
			<!-- contact -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			<!-- list all products -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			<!-- show view single products -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			<!-- Manage products -->
			<c:if test="${userClickManageProducts == true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			<!-- show cart -->
			<c:if test="${userClickShowCart == true}">
				<%@include file="cart.jsp"%>
			</c:if>
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->

		<!-- <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
    
		<!-- jquery -->
		<script src="${js}/jquery.js"></script>
		
		<!-- jquery Validator-->
		<script src="${js}/jquery.validate.js"></script>
		
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!--Datatable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!--Datatable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<!--BootBox.js-->
		<script src="${js}/bootbox.min.js"></script>
		
		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>
