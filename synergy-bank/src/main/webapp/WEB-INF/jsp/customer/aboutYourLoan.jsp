<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
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
		
		<h2>
			<u>About Your Loan </u>
		</h2>
		<br />
		<ff:form action="${pageContext.request.contextPath}/loan/addLoanInfoForm.do" method="post" commandName="loanInfoForm">
			<table align="center" width="100%" border="0" cellspacing="4"
				cellpadding="4">
				<tr style = "text-align: left">
					<td>Maximum Check Amount</td>
					<td><ff:input name="checkAmount" path="checkAmount" size="40"
							style="background:#D0F5A9; font-family: Palatino Linotype" /></td>
					<td>Apply for up to $50,000. Your loan also may be used to finance vehicle tax, title and license fees. The minimum loan amount is $7,500 for terms upto 6 years. Other conditions and restrictions apply.</td>
				</tr>
			
				<tr style = "text-align: left">
					<td>Repayment Term</td>
					<td><select name="repaymentTerm">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
					</select></td>
					<td>Please select a repayment term</td>
				</tr>
			
				<tr style = "text-align: left">
					<td>Will you be trading a vehicle that is currently financed?</td>
					<td><ff:radiobutton name="trading" path="trading"
							value="yes" />Yes <ff:radiobutton name="trading"
							path="trading" value="no" />No</td>
					<td></td>
				</tr>
			</table><br />
			<div align="right">
				<input type="submit" value="Continue"
					style="background: #04B45F; font-family: Palatino Linotype; font-size: 17px;" />
			</div>
			<br />
			<b> If you wish to cancel your application, please </b>
			<a href="${pageContext.request.contextPath}/loan/loanForm.do">click
				here.</a>
		</ff:form>
	</div>