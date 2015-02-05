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
	$(document).ready(function() {

		$("#checkAll").change(function() {

			if ($("#checkAll").is(':checked')) {

				$(".chkbox").prop("checked", true);

			} else {

				$(".chkbox").prop("checked", false);

			}

		});

	});
	
	/* 
	$(document).ready(function() {
		  $('.nav-toggle').click(function(){
			//get collapse content selector
			var collapse_content_selector = $(this).attr('type');				

			//make the collapse content to be shown or hide
			var toggle_switch = $(this);
			$(collapse_content_selector).toggle(function(){
			  if($(this).css('display')=='none'){
                              //change the button label to be 'Show'
				toggle_switch.html('${pageContext.request.contextPath}/images/lock-2.png');
			  }else{
                              //change the button label to be 'Hide'
				toggle_switch.html('${pageContext.request.contextPath}/images/unlock.png');
			  }
			});
		  });

		});	
	
	$(document).ready(function() {
		  $('#hideshow').toggle(function(){ 
			  $('#hideshow').id('unlock');
			  $('#hideshow').hide('lock');
		  
		  
		  },function(){
			  $('#hideshow').id('lock');
			  
			  
			  
		  });
		  } */
	
	
	function OnSubmitForm()
	{
	  if(document.pressed == 'blockCust')
	  {
	   document.blockedCustomerListForm.action ="blockCustomers";
	  }
	  else
	  if(document.pressed == 'unblockCust')
	  {
	    document.blockedCustomerListForm.action ="unblockCustomers";
	  }
	  return true;
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

		<ff:form name="blockedCustomerListForm" method="post" onsubmit="return onsubmitform();" commandName="blockCustomerCommand">
<!-- //action="blockCustomers"  -->
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

							<td>${item.firstName} </td>
							<td>${item.middleName} </td>
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
							
							<td><input type="image" src="${pageContext.request.contextPath}/images/lock-2.png" name="blockCust" class="nav-toggle" 
							onclick="document.pressed=this.id" id="blockCust" width="40" height="40"/></td>
							
							<td><input type="image" src="${pageContext.request.contextPath}/images/unlock.png" name="unblockCust" class="nav-toggle" 
							onclick="document.pressed=this.id" id="unblockCust" width="40" height="40"/></td>
							
							
						</tr>

					</c:forEach>

				</tbody>

			</table>


			<!-- <div align="right">
				<input type="submit" value="Block" id="submitBtn" />
			</div> -->


		</ff:form>


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