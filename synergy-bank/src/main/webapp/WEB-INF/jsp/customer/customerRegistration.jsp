<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.titlePage}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer-validations.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type = "text/javascript">
   $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
  

</head>
<body>
<%@include file="cheader.jsp"%>
		<img src="${pageContext.request.contextPath}/images/bank_logo.jpg" alt="" width="192" height="63" />
		<img src="${pageContext.request.contextPath}/images/registrationPic.png" alt="" width="892" height="280" />
		
	</div>
	<div id="content">
			
			 <br/>
			<h3>Customer Registration Page:</h3> 
			<br/>
			<ff:form name="customerRegistration" action="${pageContext.request.contextPath}/bank/customerRegistration.jsp" method="post"  commandName="customerForm"> 
				<table align=center width="30%" border="0" cellspacing="20" cellpadding="20" >
					<tr>
						<td>User Id:*</td>
						<td><ff:input path="userId" id="userId" size="40" />
						<span id="iderror"></span>
						</td>
						
					</tr>
					<tr>
						<td><b>Password:*</b></td>
						<td><ff:password path="password" id="password" size="40"/>
						<span id="passerror"></span>
						</td>
					</tr>
					<tr>
						<td><b>Salutation:</b></td>
						<td><ff:input path="salutation" size="40" /></td>
					</tr>
					<tr>
						<td><b>First Name:</b></td>
						<td><ff:input path="firstName" size="40" /></td>
					</tr>
					<tr>
						<td><b>Middle Name:</b></td>
						<td><ff:input path="middleName" size="40" /></td>
					</tr>
					<tr>
						<td><b>Last Name:</b></td>
						<td><ff:input path="lastName" size="40" /></td>
					</tr>
					<tr>
						<td><b>Gender:</b></td>
						<td><ff:input path="gender" size="40" /></td>
					</tr>
					<tr>
						<td><b>Marital Status:</b></td>
						<td><ff:input path="maritalStatus" size="40"/></td>
					</tr>
					<tr>
						<td><b>Date of Birth:</b></td>
						<td><ff:input path="dob" id ="datepicker" size="40"/></td>
					</tr>
					<tr>
						<td><b>Category:</b></td>
						<td><ff:input path="category" size="40" /></td>
					</tr>
					<tr>
						<td><b>Mother's Maiden Name:</b></td>
						<td><ff:input path="motherMaidenName" size="40" /></td>
					</tr>
					<tr>
						<td><b>Father's Name:</b></td>
						<td><ff:input path="fatherName" size="40" /></td>
					</tr>
					<tr>
						<td><b>Email:*</b></td>
						<td><ff:input path="email" size="40" />
						<span id="emailerror"></span>
						</td>
					</tr>
					<tr>
						<td><b>Mobile:</b></td>
						<td><ff:input path="mobile" size="40" />
						<span id="phoneerror"></span></td>
					</tr>
					<tr>
						<td><b>SSN:</b></td>
						<td><ff:input path="ssn" size="40"/></td>
					</tr>
					<tr>
						<td><b>Occupation:</b></td>
						<td><ff:input path="occupation" size="40" /></td>
					</tr>
					<tr>
						<td><b>Occupation Type:</b></td>
						<td><ff:input path="occupationType" size="40" /></td>
					</tr>
					<tr>
						<td><b>Education:</b></td>
						<td><ff:input path="education" size="40" /></td>
					</tr>
					<tr>
						<td><b>Gross Anual Income:</b></td>
						<td><ff:input path="grossAnualIncome" size="40" /></td>
					</tr>
					<tr>
						<td><b>Source of Funds:</b></td>
						<td><ff:input path="sourceOfFunds" size="40" /></td>
					</tr>
					<tr>
						<td><b>Role:</b></td>
						<td><ff:input path="role" size="40" /></td>
					</tr>
					
					<tr>
						<td><b>Photo:</b></td>
						<td><ff:input path="photo" size="40" /></td>
					</tr>
					<tr>
						<td><b>Description:</b></td>
						<td><ff:input path="description" size="40" /></td>
						<td><input id = "submitid" type="button" value="Register Me" size="50" onclick="validateCustomerForm();"/></td>
					</tr>
			</table>
			
	</ff:form> 
			
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		
		<div id="blocks">																																																																																																																													
			
		</div>
		<div id="info">
			<div>
				<img src="${pageContext.request.contextPath}/images/title5.gif" alt="" width="160" height="26" />
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
				<img src="${pageContext.request.contextPath}/images/title6.gif" alt="" width="160" height="26" />
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
				<img src="${pageContext.request.contextPath}/images/title7.gif" alt="" width="160" height="26" />
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
				<img src="${pageContext.request.contextPath}/images/title8.gif" alt="" width="160" height="26" />
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
	<%@ include file="../common/footer.jsp" %>
</body>
</html>
