<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/getCurrentDate.js"></script>	
	 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
<%-- <script type="text/javascript"	
src="${pageContext.request.contextPath}/js/verifyDate.js"></script> --%>
</head>
<body>
	<%@include file="cheader.jsp"%>

	<div id="content">
		<h1 align="center">Accounts Details</h1>
		<br>
			<br>
		<ff:form id="detailsummaryform" action="${pageContext.request.contextPath}/bank/detailedSummary" method="post" modelAttribute="detailTransaction">
				<h3 align="center">Full Detailed Statement: Select starting
					date and ending date </h3>
				<br> <div id = "detaillstmt">
				<label for="startdate">Starting Date: </label>
				<input id="startdate" name="startDate" type="date" max=""  value="${startDate}"  /> 
				<label for="enddate">Closing Date: </label>	
				<input id="enddate" name="endDate" type="date" max="" value="${endDate}" />	
				<input type="submit" name = "Submit"  /> 
				</div> </ff:form>
					<br>
<table align="center" class="table table-hover" width="100%" border="1" cellspacing="3"
				cellpadding="3">
				<tr align = "center">
					<th>Transaction Id</th>
					<th>Customer Account Number</th>
					<th>Amount</th>
					<th>Account type</th>
					<th>Transaction Amount</th>
					<th>Transaction Remark</th>
					<th>Transaction Date</th>
				</tr>

				<c:forEach items="${customerTransactionHistoryForms}" var="item">
					<tr align="center">
						<td>${item.id}</td>
						<td>${item.customerAccountNumber}</td>
						<td>${item.ammount}</td>
						<td>${item.creditDr}</td>
						<td>${item.description}</td>
						<td>${item.transactionId}</td>
						<td>${item.transactionDate}</td>
					</tr>
				</c:forEach>
			</table>		
			
				<ul id="menu">
				<li><h3 align="center">
						<a href="viewMiniStatement">View MiniStatement</a>
					</h3></li>
			</ul>
			
		<br /> <br /> <br /> <br /> <br />
	</div>


	<%@ include file="../common/footer.jsp"%>
</body>
</html>