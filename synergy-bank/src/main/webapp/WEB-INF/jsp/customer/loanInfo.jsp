<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>${pageContext.request.contextPath}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery1.9.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tableStyle.css" />
<link href="${pageContext.request.contextPath}/css/breadcrumb.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/breadcrumb.js"></script>
</head>
<body onload="javascript:breadcrumbs()">
	<%@include file="cheader.jsp"%>
	<img src="${pageContext.request.contextPath}/images/loan.jpg"
		width="892" height="260" />

	<div id="content" style="padding-left: 30px">
		<h3 align="center" style="font-family: Palatino Linotype; font-size: 20px; color: orange">
		<a href = "${pageContext.request.contextPath}/bank/apply.do">Apply for Auto Loan</a>
		</h3><br /><br /><br />
		<h2>
			<u>Check Loan Eligibility </u>
		</h2>
		<br />
		<table align="center" width="100%" border="0" cellspacing="4"
			cellpadding="4">
			<tr>
				<td></td>
				<td><h3>Personal Line of Credit</h3></td>
				<td><h3>Personal Installment Loan</h3></td>
			</tr>

			<tr>
				<td>Type</td>
				<td>Line of credit that you can draw against as the need arises</td>
				<td>Installment loan with a fixed term</td>
			</tr>

			<tr>
				<td>APR</td>
				<td>Variable Rate, based on Wall Street Journal Prime Rate</td>
				<td>Fixed Rate</td>
			</tr>

			<tr>
				<td>Monthly Payment</td>
				<td>Variable, based on a percentage of the outstanding balance</td>
				<td>Fixed, based on initial disbursement</td>
			</tr>

			<tr>
				<td>Access to Funds</td>
				<td>As needed, by check or online transfer</td>
				<td>One-time, lump sum</td>
			</tr>

			<tr>
				<td>Loan Amounts</td>
				<td>Min: $1,000<br />Max: $25,000
				</td>
				<td>Min: $1,000<br />Max: $100,000
				</td>
			</tr>

		</table>
		<br />
		<br />
		<br />
		<br />
		<h3
			style="font-family: Palatino Linotype; font-size: 20px; color: orange">Personal
			Line of Credit</h3>
		<br />
		<h3
			style="font-family: Palatino Linotype; font-size: 16px; color: black">
			Key Features and Benefits:</h3>
		<br />
		<h3
			style="font-family: Palatino Linotype; font-size: 13px; color: black">
			1. You decide when and how much to borrow, up to your approved credit
			limit<br /> 2. Borrow when you need to, simply by writing a check or
			transferring money to your checking account<br /> 3. Credit line is
			approved without collateral
		</h3>
		<br />
		<br />
		<br />
		<br />

		<h3
			style="font-family: Palatino Linotype; font-size: 20px; color: orange">Personal
			Installment Loan</h3>
		<br />
		<h3
			style="font-family: Palatino Linotype; font-size: 16px; color: black">
			Key Features and Benefits:</h3>
		<br />
		<h3
			style="font-family: Palatino Linotype; font-size: 13px; color: black">
			1. Available either secured by collateral or unsecured<br /> 2.
			Regular, fixed monthly payments<br /> 3. No penalty for repayment in
			full at any time
		</h3>
		<br />
		<br />
		<br />
		<br />

		<h3
			style="font-family: Palatino Linotype; font-size: 20px; color: orange">
			Important Legal Disclosures and Information:</h3>
		<br />
		<h3
			style="font-family: Palatino Linotype; font-size: 13px; color: black">
			1. Credit is subject to approval.<br /> 2. Your Annual Percentage
			Rate (APR) will be based on a review of the initial credit criteria
			and other factors such as amount borrowed. Contact us to obtain
			current rates available in your market.<br /> 3. Automatic payment
			and employee discounts may be available. If automatic payment or
			employment is discontinued, the discount will be removed and the rate
			will increase.<br /> 4. Maximum loan amount of $100,000 for loans
			secured by non-real estate collateral, like boats, RVs, stocks/bonds,
			etc. Maximum loan amount for unsecured loan is $25,000.
		</h3>
		<br />
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