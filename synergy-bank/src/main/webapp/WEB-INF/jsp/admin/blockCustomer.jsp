<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<title>${initParam.titlePage}</title>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/tableStyle.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery1.9.1.js"></script>

<script type="text/javascript">
function switchLock(userid){
	var status="";
    var result=$("#"+userid).attr("src");
	 var p=result.indexOf("lock-2.png");
	 if(p>0){
		 status="unlock";
	 }else{
		 status="lock";
	 }
	$.ajax({
		url:"${pageContext.request.contextPath}/bank/lockUnlockCustomers",
		data:{pstatus:status,puserid:userid},
		timeout:5000,
		success:function(data) {
	    if(data=='yes') {
			 if(status=='lock'){
				 $("#"+userid).attr("src", "${pageContext.request.contextPath}/images/lock-2.png"); 
			 }else{
				 $("#"+userid).attr("src", "${pageContext.request.contextPath}/images/unlock.png"); 
			 }
	    }else{
	    	
	    	
	    	 
	    }
	  },error:function(result) {
		     alert("Sorry data could not be accessed");
		  }
	});
}
</script>

<style type="text/css">
#submitBtn {
	background-color: #04B45F;
	padding: 5px;
	margin-top: 5px;
	font-weight: bold;
}

.round-border {
	border: 1px solid #eee;
	border: 1px solid rgba(0, 0, 0, 0.05);
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	padding: 10px;
	margin-bottom: 5px;
}
</style>





</head>

<body>

	<%@include file="aheader.jsp"%>

	<img src="${pageContext.request.contextPath}/images/bigpicture.jpg"
		alt="" width="892" height="280" />



	<div id="content">


		<br />
		<h2 align="left">APPROVED CUSTOMER LIST:</h2>
		<br />

		<p align="center" style="color: red;">
		<h5>${msg}</h5>
		</p>

		<table align="center" id="tab1">
			<thead>
				<tr>

					<td><b>SNO</b></td>
					<td><b>First Name</b></td>
					<td><b>Middle Name</b></td>
					<td><b>Last Name</b></td>
					<td><b>Email ID</b></td>
					<td><b>Account No.</b></td>
					<td><b>Total Available Balance</b></td>
					<td><b>Currency</b></td>
					<td><b>Block </b> &nbsp; <input type="checkbox"
						onchange="checkAll()" id="checkAll" value=" All" />(All)</td>

				</tr>

			</thead>

			<tbody>

				<c:forEach items="${approvedCustomerList}" var="item"
					varStatus="myIndex">

					<tr>

						<td>${myIndex.count}</td>

						<td>${item.firstName}</td>
						<td>${item.middleName}</td>
						<td>${item.lastName}</td>

						<td>${item.email}</td>

						<td>${item.customerAccountNo}</td>

						<td>${item.totalAvailBalance}</td>

						<td>${item.currency}</td>

						<td><input type="checkbox" name="blockCheckbox"
							class="chkbox" value="${item.userId}" /></td>
						<!-- Trying something -->
						<%-- <td><a href="#" id="hideshow">
								<img src="${pageContext.request.contextPath}/images/lock-2.png" width="40" height="40" id="lock">
								<img src="${pageContext.request.contextPath}/images/unlock.png" width="40" height="40" id="unlock">
							</a></td> --%>

						<td>
						
						<c:choose>
		    		 	<c:when test="${item.lockStatus eq 'no'}">
		    		 	<a href="javascript:switchLock('${item.userId}');">
						  <img width="30" height="30" id="${item.userId}" src="${pageContext.request.contextPath}/images/lock-2.png"/>
						</a>
		    		 	</c:when>
		    		 	<c:otherwise>
		    		 		<a href="javascript:switchLock('${item.userId}');">
						  <img  width="30" height="30" id="${item.userId}" src="${pageContext.request.contextPath}/images/unlock.png"/>
						</a>
		    		 	</c:otherwise>
		    		 </c:choose> 
						
						
					</tr>

				</c:forEach>

			</tbody>

		</table>


		<br /> <br /> <br /> <br /> <br /> <br />


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