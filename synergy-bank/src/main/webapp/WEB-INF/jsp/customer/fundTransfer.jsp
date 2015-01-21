
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<head>
<title>${initParam.titlePage}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fundTransfer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/makePayment-validations.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<link rel="stylesheet"
     href="${pageContext.request.contextPath}/css/BeatPicker.css" type="text/css" media="all"/>
<%-- <link rel="stylesheet"
     href="${pageContext.request.contextPath}/css/jquery-ui.css" /> --%>
<%-- <link rel="stylesheet"
     href="${pageContext.request.contextPath}/css/jquery.ui.theme.css" /> --%>
     <link rel="stylesheet"
     href="${pageContext.request.contextPath}/css/datePickerStyle.css" type="text/css" media="all"/>	
	
<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" /> -->
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/customer-validations.js"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script> --%>
<script type="text/javascript"
     src="${pageContext.request.contextPath}/js/BeatPicker.js"></script>
<!-- <script type = "text/javascript">
   $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script> -->
  
<script type="text/javascript">
 $(document).ready(function() {
	 $("#dot").datepicker({
         dateFormat: 'yy-mm-dd',
         showOn: 'button',
         buttonImage: "${pageContext.request.contextPath}/images/datePickerPopup.gif",
         buttonImageOnly: true,
         showOtherMonths : true,
         selectOtherMonths : true,
         changeYear:true,
         yearRange: "c-50:c+0",
         showWeek: false
    }).next('button').text('').button({
       text: true
    });
 });	 
</script>	
  
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript">
	
	var ccontextPath="${pageContext.request.contextPath}";
	
	$(function(){
		$("#transactionAmount").blur(
		 function() {
			 var transactionAmt=$("#transactionAmount").val();
			// alert("payeeAccount = "+payeeAccount);
			 if(transactionAmt.length==0){
				 $("#tAmountError").html(transactionAmt+ " is not valid transaction amount.");
				 $("#transactionAmount").focus();
				 return;
			 }
			 //making ajax call
			 $.ajax({url:ccontextPath+"/bank/checkTransactionAmount.do",data:{ttransactionAmount:transactionAmt},success:function(data) {
						    if(data=='invalid') {
								// alert(payeeAccount+ " is not valid account number.");
								 $("#tAmountError").html(transactionAmt+ " is not valid transaction amount.");
								 //$("input[type='text'][id='tosender']").focus();
								 return;
						    }else{
						    	 $("#tAmountError").html("");
						    	 return;
						    }
		  			  }
			   });   
			 
			
			 
		 }); 		
	});
</script>
</head>
<body>
	<div id="header">
		<%@include file="cheader.jsp"%>
		<img src="${pageContext.request.contextPath}/images/bank_logo.jpg" alt="" width="192" height="63" />
		<img src="${pageContext.request.contextPath}/images/registrationPic.png" alt="" width="892" height="280" />
		</div>
	
	<br/><br/><br/><br/>
	<div id="content">
			
			
			<h3>Fund Transfer - Add Payee :</h3> 
			<br/>
			<ff:form name="makePayments" action="${pageContext.request.contextPath}/bank/makePayments" method="post"  commandName="customerTransactionCommand"> 
				<table align=center width="100%" border="0" cellspacing="6" cellpadding="6" background = "${pageContext.request.contextPath}/images/table-background.jpg">
					<tr>
						<td><b>Select account</b></td>
						<td>
						<ff:select path ="customerAccountType" align="right"> 
						<ff:option value="Saving">Saving</ff:option>
						<ff:option value="Checking">Checking</ff:option>
						<ff:option value="Credit">Credit</ff:option>
						</ff:select>
						</td>			
					</tr>
				
					<tr>
						<td><b>Receivers account number</b></td>
 							<td><ff:input path="payeeAccountNumber" value="${payeeAccountNumber}" size="60" width="40" align="right" readonly="true"/></td>
					</tr>
					
					<tr>
					<td><b>Transaction Amount(USD)</b></td>
						<td><ff:input type="number" min="1" path="transactionAmount" size="60" width="80" align="right"/></td>
						<td  id="tAmountError" style="font-size:10;color: red;"></td>
					</tr>

					<%-- <tr>
						<td><b>Date of Transaction to happen:</b></td>
						<td><ff:input path="transactionDate" id ="dot" size="8" align="right"/></td>
 
					</tr> --%>
					
					<tr>
					<td><b>Quick Comments</b></td>
						<td><ff:input path="transactionRemark" name="comments" size="60" width="40" align="right" /></td>
					</tr>
					
					<tr>	
						<td><input id = "button" type="submit" value="Make a Payment" size="20" onclick="validateMakePaymentForm();"/>
						 	<td>Payee Registration alert to be sent on mobile number</td>
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
