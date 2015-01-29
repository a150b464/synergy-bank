<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<title>${initParam.titlePage}</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="${pageContext.request.contextPath}/js/selectPayeeSubmitButton.js"></script>	
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript">
    var contextPath="${pageContext.request.contextPath}";
	$(function() {
		$("#datepicker").datepicker();
	});
</script>


</head>
<body>
	<div id="header">
		<%@include file="cheader.jsp"%>
		<img src="${pageContext.request.contextPath}/images/bank_logo.jpg" alt="" width="192" height="63" />
		<img src="${pageContext.request.contextPath}/images/registrationPic.png" alt="" width="892" height="280" />
		
	</div>
	<div id="content" style="padding-left: 30px" >

		<br />
		<br />
		<br />
		<br />
		
		<h3>Fund Transfer - Add Payee :</h3>
		<br />
		
						
		<ff:form name="selectPayee" method="get" action="${pageContext.request.contextPath}/bank/makePayments"
			commandName="customerTransactionCommand">
			<table align="center" width="100%" border="0" cellspacing="6" cellpadding="6" background="${pageContext.request.contextPath}/images/table-background.jpg">

					<tr>
						<td><b>Register a new Payee:</b></td>
						<td><input id="button" type="button" value="Add Payee" size="20" 
						onclick="onSelectPayeeSubmit('addPayeeAction');"/></td>
					</tr>
					
					<tr>
					<td><b>Select a Payee to Make Payment:</b></td>
					<td>
					<ff:select path="payeeAccountNumber" width="2">
					<ff:options items="${payeeDetailsFormList}" />
					</ff:select></td>
				</tr>

				<tr>
					<td><input type="button" value="Make Payment" size="20" onclick="onSelectPayeeSubmit('makePaymentAction');"/></td>
				</tr>
				
				<tr><td><b>Payee Registration alert to be sent on mobile number</b> <br/></td></tr>
			</table>

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
