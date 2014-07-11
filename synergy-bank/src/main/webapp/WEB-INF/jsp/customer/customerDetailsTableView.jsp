<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tableStyle.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<title>Customer Details</title>

</head>
<body>
<br></br>					    
<br></br>					    
<br></br>					    
<br></br>					    

<form action="searchCustomerInformation" method="get">	
				    				    
	    Search by
<select name="searchAttr">
	<option value="userId" >userId</option>
	<option value="password">password</option>
	<option value="salutation">salutation</option>
	<option value="gender">gender</option>
	<option value="firstName">firstName</option>
	<option value="middleName">middleName</option>
	<option value="lastName">lastName</option>
	<option value="maritalStatus">maritalStatus</option>
	<option value="dob">dob</option>
	<option value="category">category</option>
	<option value="motherMaidenName">motherMaidenName</option>
	<option value="fatherName">fatherName</option>
	<option value="email">email</option>
	<option value="mobile">mobile</option>
	<option value="ssn">ssn</option>
	<option value="occupation">occupation</option>
	<option value="occupationType">occupationType</option>
	<option value="education">education</option>
	<option value="grossAnualIncome">grossAnualIncome</option>
	<option value="sourceOfFunds">sourceOfFunds</option>
	<option value="role">role</option>
	<option value="doe">doe</option>
	<option value="dom">dom</option>
	<option value="photo">photo</option>
	<option value="description">description</option>
</select>					
<input type="text" name="searchValue" align="middle"/>	
		<input type="submit" value="Search"/>
</form>
 
 <h3> Current Customers </h3>

	<table align="center">
	<thead>
		<tr>
			<td><b>userId</b></td>
			<td><b>password</b></td>
			<td><b>salutation</b></td>
			<td><b>gender</b></td>
			<td><b>firstName</b></td>
			<td><b>middleName</b></td>
			<td><b>lastName</b></td>
			<td><b>maritalStatus</b></td>
			<td><b>dob</b></td>
			<td><b>category</b></td>
			<td><b>motderMaidenName</b></td>
			<td><b>fatderName</b></td>
			<td><b>email</b></td>
			<td><b>mobile</b></td>
			<td><b>ssn</b></td>
			<td><b>occupation</b></td>
			<td><b>occupationType</b></td>
			<td><b>education</b></td>
			<td><b>grossAnualIncome</b></td>
			<td><b>sourceOfFunds</b></td>
			<td><b>role</b></td>
			<td><b>doe</b></td>
			<td><b>dom</b></td>
			<td><b>photo</b></td>
			<td><b>description</b></td>
		</tr>		
	</thead>
	<tbody>		
	<c:forEach items="${customerList}" var="item">		
		<tr>
			<td>${item.userId}</td>
			<td>${item.password}</td>
			<td>${item.salutation}</td>
			<td>${item.gender}</td>
			<td>${item.firstName}</td>
			<td>${item.middleName}</td>
			<td>${item.lastName}</td>
			<td>${item.maritalStatus}</td>
			<td>${item.dob}</td>
			<td>${item.category}</td>
			<td>${item.motherMaidenName}</td>
			<td>${item.fatherName}</td>
			<td>${item.email}</td>
			<td>${item.mobile}</td>
			<td>${item.ssn}</td>
			<td>${item.occupation}</td>
			<td>${item.occupationType}</td>
			<td>${item.education}</td>
			<td>${item.grossAnualIncome}</td>
			<td>${item.sourceOfFunds}</td>
			<td>${item.role}</td>
			<td>${item.doe}</td>
			<td>${item.dom}</td>
			<td>${item.photo}</td>
			<td>${item.description}</td>
   			<td>
			<a href="deleteEmployee?userId=${item.userId}"><img src="${pageContext.request.contextPath}/images/delete.png"/></a>
<%-- 			<a href="editRegistration?id=${item.id}"><img src="${pageContext.request.contextPath}/images/edit.png"/></a>
 --%>			</td>	 	
	 	</tr>
	</c:forEach>
	</tbody>		
</table>
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

	<%@ include file="../common/footer.jsp" %>		
</body>
</html>