<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.titlePage}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tableStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery1.9.1.js"></script>
<script type="text/javascript">
		
	$(document).ready(function(){	
	
	$("#checkAll").change(function () {
        if ($("#checkAll").is(':checked')) {
            
            $(".chkbox").prop("checked", true);

        } else {

            $(".chkbox").prop("checked", false);
        }
    }); 
 
  });

</script>
<style type="text/css">

#submitBtn{
	
	background-color: #04B45F; 
	padding: 5px; 
	margin-top: 5px; 
	font-weight: bold;
}


</style>


</head>
<body>
		<%@include file="aheader.jsp"%>
		<img src="${pageContext.request.contextPath}/images/synergy.png" align="left" alt="" width="500" height="400" />
	
	<br></br>
	<br></br>
	<br></br>
	<div id="content">
			
		<br/> <h3 align="center">PENDING APPROVAL CUSTOMER LIST:</h3>  <br/>
		<p align="center"><h5>${msg}</h5></p>		
		<ff:form name="pendingApprovalForm" method="post" action="approvePendingCustomers">
			<table align="center" id="tab1">
				<thead>
					<tr>
						<td><b>SNO</b></td>	
						<td><b>Customer Name</b></td>	
						 <td><b>Email ID</b></td>	
						 <td><b>Mobile No.</b></td>
						<td><b>Annual Income</b></td>
						<td><b>Photo</b></td>
					<%-- 	<td align="center">
           		 <a href="${pageContext.request.contextPath}/bank/showPhotoById?userId=${item.userId}"  class="preview">
           		 <img src="${pageContext.request.contextPath}/bank/showPhotoById?userId=${item.userId}" width="20" height="20"/>
           		 </a>
           		 </td> --%>
							<td><b>Approve</b> &nbsp; 
						<input type="checkbox" 
						onchange="checkAll()" id="checkAll" value="All"/>(All)
						 </td>
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${pendingCreditCardList}" var="item" varStatus="myIndex">		
						<tr>
			    			<td>${myIndex.count}</td>
			    			<td>${item.firstName} ${item.middleName} ${item.lastName}</td>
			    			<td>${item.email}</td>
			    			<td>${item.mobile}</td>
			    			<td>${item.grossAnualIncome}</td>
			    		<td align="center">
           		 <%-- <a href="${pageContext.request.contextPath}/bank/showPhotoById?userId=${item.userId}"  class="preview"> --%>
           		<a> <img src="${pageContext.request.contextPath}/bank/showPhotoById?userId=${item.userId}" width="150" height="200"/>
           		 </a>
			    			<td>
			    			<input type="checkbox" name="approveCheckbox" class="chkbox" 
			    			value="${item.userId}"/>  
			    			</td>
			    		</tr>
					</c:forEach>	
				</tbody>
			</table>	
				
			<div align="right"><input type="submit"  value="Approve" id="submitBtn" /></div>
				
		</ff:form>	
			
			

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
