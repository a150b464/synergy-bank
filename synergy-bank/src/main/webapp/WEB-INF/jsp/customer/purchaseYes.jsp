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
	<%@include file="cheader.jsp"%><br /> <br />
	<img src="${pageContext.request.contextPath}/images/autoLoan.jpg"
		width="892" height="260" /><br /><br /><br />

	<div id="content" style="padding-left: 30px">
		<h3 align="center"
			style="font-family: Palatino Linotype; font-size: 20px; color: black">
			<b> Because the vehicle you wish to purchase is greater than
				eight years old or has more than 80,000 miles, this loan is not
				within our normal auto lone guidelines. Please consider our personal
				installment loan to purchase your vehicle. To apply for a personal
				installment loan please contact the Synergy Bank Customer Care. </b>
		</h3><br />
		
		<b> If you wish to cancel your application, please </b>
			<a href="${pageContext.request.contextPath}/loan/loanForm.do">click
				here.</a>
	</div>

</body>
</html>