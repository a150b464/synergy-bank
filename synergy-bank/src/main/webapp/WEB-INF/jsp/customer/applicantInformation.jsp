<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/datePickerStyle.css"
	type="text/css" media="all" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/tableStyle.css" />
<link href="${pageContext.request.contextPath}/css/breadcrumb.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/breadcrumb.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/BeatPicker.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#dot")
								.datepicker(
										{
											dateFormat : 'yy-mm-dd',
											showOn : 'button',
											buttonImage : "${pageContext.request.contextPath}/images/datePickerPopup.gif",
											buttonImageOnly : true,
											showOtherMonths : true,
											selectOtherMonths : true,
											changeYear : true,
											yearRange : "c-50:c+0",
											showWeek : false
										}).next('button').text('').button({
									text : true
								});
					});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#expirationDate")
								.datepicker(
										{
											dateFormat : 'yy-mm-dd',
											showOn : 'button',
											buttonImage : "${pageContext.request.contextPath}/images/datePickerPopup.gif",
											buttonImageOnly : true,
											showOtherMonths : true,
											selectOtherMonths : true,
											changeYear : true,
											yearRange : "c-2:c+10",
											showWeek : false
										}).next('button').text('').button({
									text : true
								});
					});
</script>

</head>
<body onload="javascript:breadcrumbs()">
	<%@include file="cheader.jsp"%>
	<img
		src="${pageContext.request.contextPath}/images/loanApplication.jpg"
		width="892" height="260" />

	<div id="content" style="padding-left: 20px">
		<h2>
			<u>Applicant Information </u>
		</h2>
		<br />
		<p>
			<b>Important Information About Procedures for Opening a New Account:</b><br />To
			help the government fight the funding of terrorism and money
			laundering activities, Federal law requires all financial
			institutions to obtain, verify, and record information that
			identifies each customer that opens an account. What this means for
			you: When you open an account, we will ask you your name, address,
			date of birth and other information that will allow us to identify
			you. We may also ask to see your driver's license or other
			identifying information.
		</p>
		<br />

		<ff:form
			action="${pageContext.request.contextPath}/loan/addApplicationForm.do"
			method="post" commandName="addApplicationForm">
			<h3
				style="font-family: Palatino Linotype; font-size: 20px; color: orange">Personal
				Information</h3>
			<br />
			<b>First Name: </b>
			<ff:input path="firstName" name="firstName" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>Middle Name: </b>
			<ff:input path="middleName" name="middleName" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>Last Name: </b>
			<ff:input path="lastName" name="lastName" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>SSN: </b>
			<ff:input path="ssn" name="ssn" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>Date of Birth: </b>
			<ff:input path="dob" name="dob" id="dob" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>Marital Status: </b>
			<select name="maritalStatus">
				<option>Married</option>
				<option>UnMarried</option>
			</select>
			<br />

			<h3
				style="font-family: Palatino Linotype; font-size: 20px; color: orange">Identification
				Information</h3>
			<br />
			<b>Type: </b>
			<select name="type">
				<option>Driver's License</option>
				<option>State Issued ID</option>
				<option>US Passport</option>
			</select>
			<br />
			<b>State: </b>
			<select name="state">
				<option>US-AL</option>
				<option>US-AK</option>
				<option>US-AZ</option>
				<option>US-AR</option>
				<option>US-CA</option>
				<option>US-CO</option>
				<option>US-CT</option>
				<option>US-DE</option>
				<option>US-DC</option>
				<option>US-FL</option>
				<option>US-GA</option>
				<option>US-HI</option>
				<option>US-ID</option>
				<option>US-IL</option>
				<option>US-IN</option>
				<option>US-IA</option>
				<option>US-KS</option>
				<option>US-KY</option>
				<option>US-LA</option>
				<option>US-ME</option>
				<option>US-MD</option>
				<option>US-MA</option>
				<option>US-MI</option>
				<option>US-MN</option>
				<option>US-MS</option>
				<option>US-MO</option>
				<option>US-MT</option>
				<option>US-NE</option>
				<option>US-NV</option>
				<option>US-NH</option>
				<option>US-NJ</option>
				<option>US-NM</option>
				<option>US-NY</option>
				<option>US-NC</option>
				<option>US-ND</option>
				<option>US-OH</option>
			</select>
			<br />
			<b>Number:</b>
			<ff:input path="number" name="number" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>Expiration Date: </b>
			<ff:input path="expiration" name="expiration" id="expirationDate"
				size="40" style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />

			<h3
				style="font-family: Palatino Linotype; font-size: 20px; color: orange">Residential
				Information</h3>
			<br />
			<b>Address: </b>
			<ff:input path="address" name="address" size="100"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>City: </b>
			<ff:input path="city" name="city" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>State: </b>
			<ff:input path="resState" name="resState" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>ZipCode: </b>
			<ff:input path="zipCode" name="zipCode" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>County: </b>
			<ff:input path="county" name="county" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>Do you own or rent? </b>
			<ff:radiobutton  path="ownOrRent" value="yes" />Yes <ff:radiobutton
				 path="ownOrRent" value="no" />No
			<b>What is your monthly mortgage or rent payment? </b>
			<ff:input path="rent" name="rent" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />

			<h3
				style="font-family: Palatino Linotype; font-size: 20px; color: orange">Employment
				Information</h3>
			<br />
			<b>Occupation: </b>
			<select name="occupation">
				<option>Doctor</option>
				<option>Accountant</option>
				<option>Analyst</option>
				<option>Engineer</option>
				<option>Broker</option>
				<option>Attorney</option>
				<option>Retired</option>
				<option>Self-Employed</option>
				<option>Student</option>
				<option>Police</option>
				<option>PhD</option>
				<option>Homemaker</option>
				<option>Professor</option>
			</select>
			<br />
			<b>Employer: </b>
			<ff:input path="employer" name="employer" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>Annual Salary: </b>
			<ff:input path="salary" name="salary" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />

			<h3
				style="font-family: Palatino Linotype; font-size: 20px; color: orange">Additional
				Income Information</h3>
			<br />
			<h1>Please complete this section if you have additional income
				you would like to be considered for this loan.</h1>
			<br />
			<h1>Alimony, child support, or separate maintenance income need
				not be revealed if you do not wish to have it considered as a basis
				for repaying this obligation.</h1>
			<br />
			<b>Amount: </b>
			<ff:input path="amount" name="amount" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>Frequency: </b>
			<select name="frequency">
				<option>Weekly</option>
				<option>Bi-Weekly (Every 2 weeks)</option>
				<option>Monthly</option>
				<option>Annually</option>
			</select>
			<br />
			<b>Source: </b>
			<select name="source">
				<option>Alimony</option>
				<option>Child Support</option>
				<option>Separate Maintenance</option>
				<option>Rental Income</option>
				<option>Inheritance / Trust</option>
				<option>Investments</option>
				<option>Social Security</option>
				<option>Other</option>
			</select>
			<br />

			<h3
				style="font-family: Palatino Linotype; font-size: 20px; color: orange">Contact
				Information</h3>
			<br />
			<h1>By completing the e-mail address field, you authorize us to
				communicate with you using electronic mail.</h1>
			<br />
			<b>Email: </b>
			<ff:input path="email" name="email" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>Repeat Email: </b>
			<ff:input path="repeatEmail" name="repeatEmail" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<h1>Please enter your contact numbers.</h1>
			<br />
			<b>Home Telephone: </b>
			<ff:input path="homePhone" name="homePhone" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>Work Phone: </b>
			<ff:input path="workPhone" name="workPhone" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>Cell Phone: </b>
			<ff:input path="cellPhone" name="cellPhone" size="40"
				style="background:#D0F5A9; font-family: Palatino Linotype" />
			<br />
			<b>What is your contact time preference? </b>
			<select name="contactTime">
				<option>8:00 AM - 10:00 AM</option>
				<option>10:00 AM - 12:00 PM</option>
				<option>12:00 PM - 2:00 PM</option>
				<option>2:00 PM - 4:00 PM</option>
				<option>4:00 PM - 6:00 PM</option>
				<option>No Preference</option>
			</select>
			<br />

			<div align="center">
				<input type="submit" value="Continue"
					style="background: #04B45F; font-family: Palatino Linotype; font-size: 25px;" />
			</div>

			<b> If you wish to cancel your application, please </b>
			<a href="${pageContext.request.contextPath}/loan/loanForm.do">click
				here.</a>
		</ff:form>

	</div>