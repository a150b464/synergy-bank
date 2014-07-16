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
	</div>
	<div id="content">
			
		<br/> <h2 align="center">ACTIVE CUSTOMER LIST:</h2>  <br/>
		<p align="center"><h3>${msg}</h3></p>		
		<ff:form  name="blockedCustomerListForm" method="post" action="blockCustomers" commandName="blockCustomerCommand" >
			<table align="center" id="tab1">
				<thead>
					<tr>
						<td><b>SNO</b></td>	
						<td><b>Customer Name</b></td>	 <td><b>Email ID</b></td>	<td><b>Account No.</b></td>
						<td><b>Total Available Balance</b></td><td><b>Currency</b></td>	<td><b>Block </b> &nbsp; <input type="checkbox" onchange="checkAll()" id="checkAll" value=" All"/>(All) </td>
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${approvedCustomerList}" var="item" varStatus="myIndex">		
						<tr>
			    			<td>${myIndex.count}</td>
			    			<td>${item.firstName} ${item.middleName} ${item.lastName}</td>
			    			<td>${item.email}</td>
			    			<td>${item.customerAccountNo}</td>
			    			<td>${item.totalAvailBalance}</td>
			    			<td>${item.currency}</td>
			    			<td><input type="checkbox" name="blockCheckbox" class="chkbox" value="${item.userId}"/>  </td>
			    		</tr>
					</c:forEach>	
				</tbody>
			</table>	
				
			<div align="right"><input type="submit"  value="Block" id="submitBtn" /></div>
				
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
