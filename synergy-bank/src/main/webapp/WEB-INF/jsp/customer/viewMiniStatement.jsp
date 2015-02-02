<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${pageContext.request.contextPath}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css" />
<link href="${pageContext.request.contextPath}/css/breadcrumb.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/breadcrumb.js"></script>
</head>

<body>
	<%@include file="cheader.jsp"%>
	<br>
	<br>

	<div id="content">
		<br> <br>
		<h3>Mini Statement</h3>
		<br>
		<ff:form action="viewMiniStatement" method="get">
			<table align="center" width="100%" border="1" cellspacing="3"
				cellpadding="3">
				<tr>
					<td>Serial Number</td>
					<td>Account Number</td>
					<td>Amount</td>
					<td>CR/DR</td>
					<td>Transaction Remark</td>
					<td>Transaction Id</td>
					<td>Transaction Date</td>
				</tr>

				<c:forEach items="${customerTransactionForms}" var="item">
					<tr>
						<td>${item.payeeAccountNumber}</td>
						<td>${item.transactionAmount}</td>
						<td>${item.transactionDate}</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
			</table>

		</ff:form>
		<br>
		<input id="button" type="submit" value="email notice" size="20" /><br>
		<div class="metalinks">
			<a href="#"><img
				src="${pageContext.request.contextPath}/images/pdf.jpg" alt=""
				width="20" height="10" /></a>
		</div>
		<br> <br> <br> <br> <br>

	</div>


















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
				<li><a href="#">Convallis nonummy tellus</a></li>
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
