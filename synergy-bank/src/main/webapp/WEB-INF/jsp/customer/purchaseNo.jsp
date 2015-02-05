<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
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
	<%@include file="cheader.jsp"%><br />
	<br />
	<img src="${pageContext.request.contextPath}/images/autoLoan.jpg"
		width="892" height="260" />
	<br />
	<br />
	<br />

	<div id="content" style="padding-left: 30px">
		<h3 align="center"
			style="font-family: Palatino Linotype; font-size: 20px; color: black">
			<b> Great news! If your loan application is approved for a Check
				Ready auto loan, we will provide you with a blank check in the mail
				to purchase a vehicle, up to your approved loan amount. Do you want
				to continue your application for a Check Ready auto loan? If yes,
				select continue. </b>
		</h3>
		<br />
		<h3 align="right"
			style="font-family: Palatino Linotype; font-size: 20px; color: black">
			<form action = "${pageContext.request.contextPath}/loan/loanInfo.do" method="get">
				<input type = "submit" value="Continue"/>
			</form>
		</h3> 
		<br />
		<b> If you wish to cancel your application, please </b> <a
			href="${pageContext.request.contextPath}/loan/loanForm.do">click
			here.</a>
	</div>

</body>
</html>