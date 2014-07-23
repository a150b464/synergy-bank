<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${pageContext.request.contextPath}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css" />
<link href="${pageContext.request.contextPath}/css/breadcrumb.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/breadcrumb.js">
</script>

<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript">
	
	var ccontextPath="${pageContext.request.contextPath}";
	
	$(function(){
		$("#payeeAccountNo").keyup(
		 function() {
			 var payeeAccount=$("#payeeAccountNo").val();
			// alert("payeeAccount = "+payeeAccount);
			 if(payeeAccountNo.length==0){
				 alert("Payee AccountNo cannot be blank.")
				 $("#payeeAccountNo").focus();
				 return;
			 }
			 //making ajax call
			 $.ajax({url:ccontextPath+"/bank/checkPayeeAccountNo.do",data:{ppayeeAccountNumber:payeeAccount},success:function(data) {
						    if(data=='invalid') {
								// alert(payeeAccount+ " is not valid account number.");
								 $("#accountError").html(payeeAccount+ " is not valid account number.");
								 //$("input[type='text'][id='tosender']").focus();
								 return;
						    }else{
						    	 $("#accountError").html("");
						    	 return;
						    }
		  			  }
			   });   
			 
			
			 
		 }); 		
	});
	
	 $(function(){
		$("#payeeName").blur(
		 function() {
			 var payeeName=$("#payeeName").val();
			// alert("payeeAccount = "+payeeAccount);
			 if(payeeName.length==0){
				 alert("Payee AccountNo cannot be blank.")
				 $("#payeeName").focus();
				 return;
			 }
			 //making ajax call
			 $.ajax({url:ccontextPath+"/bank/checkPayeeName.do",data:{ppayeeName:payeeName},success:function(data) {
						    if(data=='invalid') {
								// alert(payeeAccount+ " is not valid account number.");
								 $("#nameError").html(payeeName+ " is not a valid Name.");
								 //$("input[type='text'][id='tosender']").focus();
								 return;
						    }else{
						    	 $("#nameError").html("");
						    	 return;
						    }
		  			  }
			   });   
			 
			
			 
		 }); 		
	}); 
</script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/addPayeeForm-validations.js"></script> --%>
</head>

<body onload="javascript:breadcrumbs()">
	<%@include file="cheader.jsp"%>
	<img src="${pageContext.request.contextPath}/images/cash3.jpg"
		width="892" height="260" />

	<div id="content" style="padding-left: 30px" >
		<h2>
			<u>To Add Payee Please enter the Payee Details </u>
		</h2>
		<br />
		<p style="color: red;">${message}</p>
		<ff:form action="addpayee.do" method="post" commandName="addPayeeCommand">
			
			<table align="center" width="100%" border="0" cellspacing="4" cellpadding="4">
				<tr>
					<td><ff:hidden path="" /> <b>Payee Account Number</b></td>
					<td><ff:input path="payeeAccountNo" size="40" style="background:#D0F5A9; font-family: Palatino Linotype" /></td>
					<td  id="accountError" style="font-size:10;color: red;"></td>
				</tr>
				<tr>
					<td><b>Payee Name</b></td>
					<td><ff:input path="payeeName" size="40" style="background:#D0F5A9;font-family: Palatino Linotype"/>
					<td id="nameError" style="font-size:10; color: red; "></td>
					
				</tr>
				<tr>
					<td><b>Payee Nick Name</b></td>
					<td><ff:input path="payeeNickName" size="40" style="background:#D0F5A9;font-family: Palatino Linotype" readonly="true"/></td>
							<td>&nbsp;</td>
				</tr>
				<tr>
					<td><b>Mobile Number</b></td>
					<td><ff:input path="mobile" size="40"
							style="background:#D0F5A9;font-family: Palatino Linotype" /></td>
							<td>&nbsp;</td>
				</tr>
				<tr>
					<td><b>Payee Registration alert to be sent on email.</b></td>
					<td><ff:input path="email" size="40" style="background:#D0F5A9;font-family: Palatino Linotype" readonly="true"/></td>
				</tr>

			</table>
			<br>
			<br>
			<h3
				style="font-family: Palatino Linotype; font-size: 13px; color: grey">
				Notes: <br> 1. To add/update your email id, please contact the
				customer service.<br> 2. Please make sure the account number is
				correct.<br> 3. Synergy Bank is not responsible for funds
				transferred to unintended recipient.<br> 4. Before you proceed
				make sure you have entered all the details correctly.<br>
			</h3>
			<br>
			<table>
				<tr>
					<td><input type="button" value="Next" id="nextButton"
						style="background: #04B45F; font-family: Palatino Linotype; font-size: 17px;" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><input type="submit" value="Back"
						style="background: #04B45F; font-family: Palatino Linotype; font-size: 17px;" /></td>
				</tr>
			</table>
		</ff:form>
		<br /> <br /> <br />
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
