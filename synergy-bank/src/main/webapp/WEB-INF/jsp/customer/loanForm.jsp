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
	<img src="${pageContext.request.contextPath}/images/autoLoan.jpg"
		width="892" height="260" />
		
	<div id="content" style="padding-left: 30px" >
		<b>	Please review our </b><a href = "${pageContext.request.contextPath}/bank/checkList.do">Application Check-list</a><b> before you begin.</b>
		<br />
		<h2>
			<u>Loan Form </u>
		</h2>
		<br />
	
		<ff:form action = "" method="post" commandName="addLoanForm">
			<table align="center" width="100%" border="0" cellspacing="4" cellpadding="4">
				<tr>
					<td><b>What is the zip code of your place of residence?</b></td>
					<td><ff:input path="zipCode" size="40" style="background:#D0F5A9; font-family: Palatino Linotype" /></td>
				</tr>
				
				<tr>
					<td><b>What is the purpose of your loan?</b></td>
					<td>
						<select name = "purpose">
           		 		<option>Purchase Franchise Dealer</option>
           		 		<option>Purchase Independent Dealer</option>
           		 		<option>Purchase Private Party</option>
           		 		<option>Refinance</option>
           		 		<option>Lease Buy-out</option>
           		 		<option>Cash out (no existing loan)</option>
           		 	</select>
					</td>
				</tr>
				
				<tr>
					<td><b>Are you looking to purchase a vehicle greater than 8 years old or a vehicle with over 80,000 miles?</b></td>
					<td><ff:radiobutton path="purchase" value="Y" />Yes <ff:radiobutton	path="purchase" value="N" />No</td>
				</tr>
				
				<tr>
					<td><b>Do you intend to apply for joint credit with a co-applicant?</b></td>
					<td><ff:radiobutton path="jointCredit" value="Y" />Yes <ff:radiobutton	path="jointCredit" value="N" />No</td>
				</tr>
				
				<tr>
					<td><b>If Yes does the co-applicant intend to apply for joint credit and has the co-applicant given you permission to apply jointly on her or his behalf?</b></td>
					<td><ff:radiobutton path="permission" value="Y" />Yes <ff:radiobutton	path="permission" value="N" />No</td>
				</tr>
				
				<tr>
					<td><b>Are you, or your co-applicant, an employee or retiree of Synergy Bank or one of Synergy Bank's's Affilates?</b></td>
					<td>
						<select name = "relation">
           		 		<option>No - Not Applicable</option>
           		 		<option>Yes - Applicant</option>
           		 		<option>Yes - Co-Applicant</option>
           		 		<option>Yes - Both</option>
           		 	</select>
					</td>
				</tr>
				
				<tr>
					<td><b>If you received a pre-approved certificate number enter code:</b></td>
					<td><ff:input path="preApprovedNo" size="40" style="background:#D0F5A9; font-family: Palatino Linotype" /><b>Optional</b></td>
				</tr>
				
			</table><br />
		<div align = "center"><input type="button" value="Continue" style="background: #04B45F; font-family: Palatino Linotype; font-size: 17px;" /></div>
		<br />
		<b>	If you wish to cancel your application, please </b><a href = "${pageContext.request.contextPath}/bank/loanForm.do">click here.</a>
		</ff:form>
	</div>
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