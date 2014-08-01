<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<title>${initParam.titlePage}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css" />
<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" /> -->
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/customer-validations.js"></script> --%>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker();
	});
</script>

</head>
<body>
	<img src="${pageContext.request.contextPath}/images/bank_logo.jpg"
		alt="" width="192" height="63" />
	<img
		src="${pageContext.request.contextPath}/images/registrationPic.png"
		alt="" width="892" height="280" />
	<div id="left_section">
		<div class="title">
			<b>Welcome to Customer Registration</b>
		</div>
		<div class="text_content">
			<br /> <br />
			<marquee> <img
				src="${pageContext.request.contextPath}/images/bank_logo.jpg" alt="" />
			<b>The Worlds Local Bank!</b> </marquee>
		</div>

		<div id="content" style="padding-left: 0px">

			<h2 style="color: blue">${msg}</h2>
			<s:form action="/loan/carLoan">
				<s:textfield name="carid" label="Car Id" />
				<s:textfield name="color" label="Color" />
				<s:textfield name="model" label="Model" />
				<s:textfield name="email" label="Email" size="40" />
				<s:textfield name="mobile" label="Mobile" />
				<s:textfield name="vendor" label="Vemdor" />
				<s:textfield name="category" label="Category" />
				<s:textfield name="price" label="Price" />
	<%-- 			<s:select label="Sex" headerKey="-1" headerValue="Select Gender"
					list="listData" name="sex" value="Male" />
	 --%>			<s:submit value="Apply for Car Loan" />
			</s:form>
			<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
			<br /> <br /> <br />

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
	</div>
</body>
</html>
