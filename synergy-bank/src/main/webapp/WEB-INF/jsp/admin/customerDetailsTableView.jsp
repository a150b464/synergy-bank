<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"/>
 -->    
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery1.9.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tableStyle.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<script src="<%=request.getContextPath() %>/js/controller.js">
</script>
<script type="text/javascript" language="javascript">
  var ccontextPath="${pageContext.request.contextPath}";
  function deleteCustomerByAjax(uid){
	   alert("uid = "+uid);
		$.ajax({
			url:"${pageContext.request.contextPath}/bank/ajaxDeleteCustomer",
			data:{userId:uid},
			success:function(data) {
		    if(data=='done') {
				 var cid="#"+uid;
				 $(cid).remove();
				 removeToken("count"+rownum);
				 for(var row=1;row<=len;row++){
					 $("#"+idTokens[row-1]).html("<b>"+row+"</b>");
				 }
		    }else{
		    	 
		    }
		  }
		});
	}
  
  
  
  
  </script>

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
	<%-- 	<a href="index.html" class="logo"><img src="${pageContext.request.contextPath}/images/clogo.jpg" alt="setalpm" width="40" height="40" /></a>
	 --%>	
	 <span class="slogan">&nbsp;<font color="green"><b>&nbsp;&nbsp;Synergy Bank</b></font></span>
		<%-- <ul id="menu">
			<li><a href="#">Home			</a></li>
			<li><a href="#">Employer		</a></li>
			<li><a href="#">Personal Bank	</a></li>
			<li><a href="#">Loan			</a></li>
			<li><a href="#">Credit Card		</a></li>
			<li><a href="#">About Us		</a></li>
			<li><a href="#">Help			</a></li>
			<li class="last"><a href="#">Register</a></li>
			<li class="last"><a href="${pageContext.request.contextPath}/bank/logout">logout</a></li>
		</ul> --%>
		<%@include file="aheader.jsp"%>
<%-- 		<img src="${pageContext.request.contextPath}/images/bank_logo.jpg" alt="" width="192" height="63" />
 --%>		<img src="${pageContext.request.contextPath}/images/registrationPic.png" alt="" width="892" height="280" />
		
	</div>
	
	<div id="content">

 <h3> Current Customers </h3>			    



<form action="searchCustomerInformation" method="get" id = "detailsTable">	
				    				    
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
	
	
	<form action="customerInformation" method="get">				    
		<input type="submit" value="Clear Search"/>
	</form> 

	<div ng-app="customerDeleteApp">
  	<div ng-controller="customerDeleteController">

	<table align="center" width="100%" border="0" cellspacing="20" cellpadding="20">
	<thead>
		<tr>
			<td><b>USERID</b></td>
		 	<td><b>Name</b></td>
		 	<td><b>Category</b></td>
		 	<td><b>Email</b></td>
			<td><b>Mobile</b></td>
 			<td><b>Occupation</b></td>
		 	<td><b>Education</b></td>
			<td><b>Gross Income</b></td>
 			<td><b>Edit and Delete</b></td>
		</tr>		
	</thead>
	<tbody>		
	<c:forEach items="${customerList}" var="item">		
		<tr id="${item.userId}">
			<td id="currentUserId">${item.userId}</td>
		 	<td>${item.firstName} ${item.lastName}</td>
		 	<td>${item.category}</td>
 			<td>${item.email}</td>
			<td>${item.mobile}</td>
 			<td>${item.occupation}</td>
 			<td>${item.education}</td>
			<td>${item.grossAnualIncome}</td>
   			<td>
   			<%-- <button ng-click="deleteCustomerRecord()"><img src="${pageContext.request.contextPath}/images/delete.png"/></button> --%>
   			<a href="javascript:deleteCustomerByAjax(${item.userId});"><img src="${pageContext.request.contextPath}/images/delete.png"/></a>
	<%-- 		<a href="deleteCustomer?userId=${item.userId}"><img src="${pageContext.request.contextPath}/images/delete.png"/></a>
	 --%>		
	 		<a href="editRegistration?userId=${item.userId}"><img src="${pageContext.request.contextPath}/images/edit.png"/></a>
		
			</td>	 	
	 	</tr>
	</c:forEach>
	
	</tbody>		
</table>
</div>
</div>
		<a href="${pageContext.request.contextPath}/bank/loadPreviousPage?current_page_number=${current_page_number}"><img src="${pageContext.request.contextPath}/images/prev.png" /></a>
			<input type="text" name="pageInformation" value="${pageInformation}" align="right"/>			
		<a href="${pageContext.request.contextPath}/bank/loadNextPage?current_page_number=${current_page_number}"><img src="${pageContext.request.contextPath}/images/next.png" /></a>
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