<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>${pageContext.request.contextPath}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery1.9.1.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/tableStyle.css" />
<link href="${pageContext.request.contextPath}/css/breadcrumb.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/breadcrumb.js"></script>
</head>
<body onload="javascript:breadcrumbs()">
	<%@include file="cheader.jsp"%>
	<img
		src="${pageContext.request.contextPath}/images/application_complete.jpg"
		width="892" height="260" />
	<br />

	<div id="content" style="padding-left: 30px">
		<h3 align="center">
			<b> Good News! You Auto Loan application has been successfully
				completed. We will review all the details and contact you if you
				meet all the eligibility criteria. Thank you so much for your time.</b>
		</h3>

	</div>
</body>
</html>