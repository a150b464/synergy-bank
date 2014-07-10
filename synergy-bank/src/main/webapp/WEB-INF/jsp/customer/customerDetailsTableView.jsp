<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<title>Employee Details</title>
</head>
<body>
 	<div class="CSSTableGenerator" >
	 				<table id="insured_list">
					<thead>
					<tr>
					<th>userId</th>
					<th>password</th>
					<th>salutation</th>
					<th>gender</th>
					<th>firstName</th>
					<th>middleName</th>
					<th>lastName</th>
					<th>maritalStatus</th>
					<th>dob</th>
					<th>category</th>
					<th>motherMaidenName</th>
					<th>fatherName</th>
					<th>email</th>
					<th>mobile</th>
					<th>ssn</th>
					<th>occupation</th>
					<th>occupationType</th>
					<th>education</th>
					<th>grossAnualIncome</th>
					<th>sourceOfFunds</th>
					<th>role</th>
					<th>doe</th>
					<th>dom</th>
					<th>photo</th>
					<th>description</th>
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
    			</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
	<%@ include file="../common/footer.jsp" %>		
</body>
</html>