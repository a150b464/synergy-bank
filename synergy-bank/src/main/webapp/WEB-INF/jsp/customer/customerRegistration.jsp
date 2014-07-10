<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.titlePage}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
	<div class="meta">
		<div class="metalinks">
			<a href="#"><img src="${pageContext.request.contextPath}/images/meta1.gif" alt="" width="15" height="14" /></a>
			<a href="#"><img src="${pageContext.request.contextPath}/images/meta2.gif" alt="" width="17" height="14" /></a>
			<a href="#"><img src="${pageContext.request.contextPath}/images/meta3.gif" alt="" width="17" height="14" /></a>
			<a href="#"><img src="${pageContext.request.contextPath}/images/meta4.gif" alt="" width="15" height="14" /></a>
		</div>
		<p>Recruiters: <a href="#">Log in</a> or <a href="#">Find out more</a></p>																																															
	</div>
	<div id="header">
		<a href="index.html" class="logo"><img src="${pageContext.request.contextPath}/images/clogo.jpg" alt="setalpm" width="50" height="50" /></a>
		<span class="slogan">&nbsp;<font color="green"><b>&nbsp;&nbsp;Synergy Bank</b></font></span>
		<ul id="menu">
			<li><a href="#">Home</a></li>
			<li><a href="#">Employer</a></li>
			<li><a href="#">Personal Bank</a></li>
			<li><a href="#">Loan</a></li>
			<li><a href="#">Credit Card</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Help</a></li>
			<li class="last"><a href="#">Register</a></li>
		</ul>
		<img src="${pageContext.request.contextPath}/images/bigpicture.jpg" alt="" width="892" height="303" />
	</div>
	<div id="content">
			
			 <br/>
			<h3>Customer Registration Page:</h3> 
			<br/>
			<ff:form method="post" action="${pageContext.request.contextPath}/bank/customerRegistration" commandName="customerCommand"> 
				<table align="right" width="70%" border="0" cellspacing="8" cellpadding="3">
					<tr>
						<td>User Id:</td>
						<td><ff:input path="userId" size="60" style="background:#FFF380;"/></td>
					</tr>
					<tr>
						<td><b>Password:</b></td>
						<td><ff:password path="password" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Salutation:</b></td>
						<td><ff:input path="salutation" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>First Name:</b></td>
						<td><ff:input path="firstName" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Middle Name:</b></td>
						<td><ff:input path="middleName" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Last Name:</b></td>
						<td><ff:input path="lastName" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Gender:</b></td>
						<td><ff:input path="gender" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Marital Status:</b></td>
						<td><ff:input path="maritalStatus" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Date of Birth:</b></td>
						<td><ff:input path="dob" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Category:</b></td>
						<td><ff:input path="category" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Mother's Maiden Name:</b></td>
						<td><ff:input path="motherMaidenName" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Father's Name:</b></td>
						<td><ff:input path="fatherName" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Email:</b></td>
						<td><ff:input path="email" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Mobile:</b></td>
						<td><ff:input path="mobile" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>SSN:</b></td>
						<td><ff:input path="ssn" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Occupation:</b></td>
						<td><ff:input path="occupation" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Occupation Type:</b></td>
						<td><ff:input path="occupationType" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Education:</b></td>
						<td><ff:input path="education" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Gross Anual Income:</b></td>
						<td><ff:input path="grossAnualIncome" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Source of Funds:</b></td>
						<td><ff:input path="sourceOfFunds" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Role:</b></td>
						<td><ff:input path="role" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Date of Entry:</b></td>
						<td><ff:input path="doe" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Date of Modification:</b></td>
						<td><ff:input path="dom" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Photo:</b></td>
						<td><ff:input path="photo" size="40" style=""/></td>
					</tr>
					<tr>
						<td><b>Description:</b></td>
						<td><ff:input path="description" size="40" style=""/></td>
						<td><input type="submit" value="Registration"  style="background:pink;" size="30" /></td>
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
