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
</head>

<body>
	<%@include file="cheader.jsp"%>
	<h1 align="center">
		<img src="${pageContext.request.contextPath}/images/account.jpg"
			alt="" width="700" height="250" />
	</h1>
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

			<ul id="menu">
				<li><h3 align="center">
						<a href="viewMiniStatement">View Mini Statement</a>
					</h3></li>
			</ul>


		</ff:form>
		<br /> <br /> <br /> <br /> <br />


		<div id="blocks"></div>
		<div id="info">
			<div>
				<img src="${pageContext.request.contextPath}/images/title5.gif"
					alt="" width="160" height="26" />
				<ul>
					<li><a href="#">Maecenas hendrerit</a></li>
					<li><a href="#">Massa ac laoreet iaculipede</a></li>
					<li><a href="#">Convallis nonummy tellus</a></li>
					<li><a href="#">In tincidunt mauris</a></li>
					<li><a href="#">Maecenas hendrerit</a></li>
					<li><a href="#">Convallis nummy tellus</a></li>
					<li><a href="#">In tincidunt mauris</a></li>
				</ul>
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/images/title6.gif"
					alt="" width="160" height="26" />
				<ul>
					<li><a href="#">Maecenas hendrerit</a></li>
					<li><a href="#">Massa ac laoreet iaculipede</a></li>
					<li><a href="#">Convallis nonummy tellus</a></li>
					<li><a href="#">In tincidunt mauris</a></li>
					<li><a href="#">Maecenas hendrerit</a></li>
					<li><a href="#">Convallis nonummy tellus</a></li>
					<li><a href="#">In tincidunt mauris</a></li>
				</ul>
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/images/title7.gif"
					alt="" width="160" height="26" />
				<ul>
					<li><a href="#">Maecenas hendrerit</a></li>
					<li><a href="#">Massa ac laoreet iaculipede</a></li>
					<li><a href="#">Convallis nonummy tellus</a></li>
					<li><a href="#">In tincidunt mauris</a></li>
					<li><a href="#">Maecenas hendrerit</a></li>
					<li><a href="#">Convallis nonummy tellus</a></li>
					<li><a href="#">In tincidunt mauris</a></li>
				</ul>
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/images/title8.gif"
					alt="" width="160" height="26" />
				<ul>
					<li><a href="#">Maecenas hendrerit</a></li>
					<li><a href="#">Massa ac laoreet iaculipede</a></li>
					<li><a href="#">Convallis nonummy tellus</a></li>
					<li><a href="#">In tincidunt mauris</a></li>
					<li><a href="#">Maecenas hendrerit</a></li>
					<li><a href="#">Convallis nonummy tellus</a></li>
					<li><a href="#">In tincidunt mauris</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<%@ include file="../common/footer.jsp"%>
</body>
</html>

















