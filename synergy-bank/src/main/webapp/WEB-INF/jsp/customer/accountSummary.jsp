<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>

<body>
	<%@include file="cheader.jsp"%>

	<div id="content">
		<h1 align="center">Accounts Details</h1>
		<br>
		<ff:form action="accountSummary" method="get">
			<table align="center">
				<thead>
					<tr>
						<td>Name</td>
						<td>Currency</td>
						<td>Account Type</td>
						<td>Total Available Balance</td>
						<td>Email</td>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${customerAccountForms}" var="item">
						<tr>
							<td>${item.customerName}</td>
							<td>${item.currency}</td>
							<td>${item.accountType}</td>
							<td>${item.totalAvailBalance}</td>
							<td>${item.customerEmail}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<br>
			<h1 align="center">Accounts Summary</h1>
			<br>
			<table align="center">
				<thead>
					<tr>
						<td>Total Deposit</td>
						<td>Total Liability</td>
						<td>Total Asset</td>
						<td>Status as of</td>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>${totalDeposit}</td>
						<td>${totalLiability}</td>
						<td>${totalAsset}</td>
						<td>${statusOf}</td>
					</tr>
				</tbody>
			</table>
			<br>
			<ff:form action="" method="post">
				<h3 align="center">Full Detailed Statement: Select starting
					date and ending date</h3>
				<br> <div id = "detaillstmt">
				<label for="startdate">Starting Date: </label>
				<input id="startdate" name="startdate" type="date" max="" value="" />
				<label for="enddate">Closing Date: </label>
				<input id="enddate" name="enddate" type="date" max="" value="" />	
				<input type="submit" /> </div>
					<br>
<table align="center" width="100%" border="1" cellspacing="3"
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
				
			</ff:form>
			<ul id="menu">
				<li><h3 align="center">
						<a href="viewMiniStatement">View Mini Statement</a>		
					</h3></li>
			</ul>


		</ff:form>
		<br /> <br /> <br /> <br /> <br />
	</div>


	<%@ include file="../common/footer.jsp"%>
</body>
</html>