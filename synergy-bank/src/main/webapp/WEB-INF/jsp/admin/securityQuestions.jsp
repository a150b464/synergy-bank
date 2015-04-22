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
		<img src="${pageContext.request.contextPath}/images/bigpicture.jpg" alt="" width="892" height="280" />
	<div id="content">
			
		<br/> 
		<h3 align="left">PENDING APPROVAL CUSTOMER LIST:</h3>  <br/>
		<p align="center"><h5>${msg}</h5></p>
		<p align="left">		
		<ff:form name="pendingApprovalForm" method="post" action="approvePendingCustomers">
			<table  style="width: 900px;margin-left: -5px">
				<thead>
					<tr>
						<td><b>SNO</b></td>
						<td><b>User ID</b></td>		
						<td><b>Customer Name</b></td>	
						 <td><b>Email ID</b></td>	
						 <td><b>Mobile No.</b></td>
						<td><b>Photo</b></td>	
						<td>
						<b>Approve</b> &nbsp; 
						<input type="checkbox" 
						onchange="checkAll()" id="checkAll" value="All"/>(All)
						 </td>
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${pendingCustomerList}" var="item" varStatus="myIndex">		
						<tr>
			    			<td>${myIndex.count}</td>
			    			<td>
			    			${item.userId}</td>
			    				<td>${item.firstName} ${item.middleName} ${item.lastName}</td>
			    			<td>${item.email}</td>
			    			<td>${item.mobile}</td>
			    			<td><img src="${pageContext.request.contextPath}/bank/findPhotoByUserId?userId=${item.userId}" width="40" height="40"></td>
			    			<td>
			    			<input type="checkbox" name="approveCheckbox" class="chkbox" 
			    			value="${item.userId}"/>  
			    			</td>
			    		</tr>
					</c:forEach>	
				</tbody>
			</table>	
			<p align="right" style="width:900px; ">
			
			<input type="submit"  value="Approve" id="submitBtn" />
			</p>
			
				
		</ff:form>	
		</p>	
			

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
