<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery1.9.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tableStyle.css" />
<link href="${pageContext.request.contextPath}/css/breadcrumb.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/breadcrumb.js"></script>
</head>
<body onload="javascript:breadcrumbs()">
	<img src="${pageContext.request.contextPath}/images/checkList-header.jpg"
		width="892" height="260" /><br />
	
	<div id="content" style="padding-left: 30px">
		<h2>
			<u>What You'll Need... </u>
		</h2>
	<br />
		<table align="center" width="100%" border="0" cellspacing="4"
			cellpadding="4">
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/checkList.jpg" width = "30" height = "30"></td>
				<td><b>10 to 15 minutes to complete the application.</b></td>
			</tr>
			
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/checkList.jpg" width = "30" height = "30"></td>
				<td><b>The dollar amount that you would like to borrow.</b></td>
			</tr>
			
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/checkList.jpg" width = "30" height = "30"></td>
				<td><b>One form of photo identification (ID):<br />- Driver's license, state-issued ID or US passport</b></td>
			</tr>
			
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/checkList.jpg" width = "30" height = "30"></td>
				<td><b>Previous address, if at current address less than two years.</b></td>
			</tr>
			
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/checkList.jpg" width = "30" height = "30"></td>
				<td><b>Previous employer, if with current less than two years.</b></td>
			</tr>
			
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/checkList.jpg" width = "30" height = "30"></td>
				<td><b>Your annual income and any other income to be considered.</b></td>
			</tr>
			
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/checkList.jpg" width = "30" height = "30"></td>
				<td><b>If you are applying with a co-applicant, you will need their:<br />- Current address and previous, if less than two years<br />- Current employer and previous, if less than two years<br />- Annual income and any other income to be considered</b></td>
			</tr>
			
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/checkList.jpg" width = "30" height = "30"></td>
				<td><b>If you are purchasing a vehicle from a private seller, or are refinancing, you will need:<br />-Vehicle selling price, year, make and model<br />-Vehicle trade in value, year, make and model<br />-Down payment, if any</b></td>
			</tr>
	
		</table>	
		<h3 align="center" style="font-family: Palatino Linotype; font-size: 20px; color: orange">
	    	<a href = "${pageContext.request.contextPath}/bank/apply.do">Back to loan form</a>
	    </h3><br />
	</div>
</body>
</html>