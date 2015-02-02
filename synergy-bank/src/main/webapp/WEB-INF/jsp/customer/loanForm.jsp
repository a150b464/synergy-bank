<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>${pageContext.request.contextPath}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css" />
<link href="${pageContext.request.contextPath}/css/breadcrumb.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/breadcrumb.js">
</script>

<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
</head>
<body onload="javascript:breadcrumbs()">
	<%@include file="cheader.jsp"%>
	<img src="${pageContext.request.contextPath}/images/loan.jpg"
		width="892" height="260" />
		
	<div id="content" style="padding-left: 30px" >
		<h2>
			<u>Check Loan Eligibility </u>
		</h2>
		<br />
	
		<ff:form action = "">
			<table align="center" width="100%" border="0" cellspacing="4" cellpadding="4">
				
			
			
			</table>
		</ff:form>
	</div>

</body>
</html>