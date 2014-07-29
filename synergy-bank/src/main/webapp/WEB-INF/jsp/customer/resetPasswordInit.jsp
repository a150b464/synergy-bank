
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${pageContext.request.contextPath}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<link href="${pageContext.request.contextPath}/css/breadcrumb.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/breadcrumb.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/resetPassword-validations.js"></script>
<style type="text/css"></style>
</head>

<body>
	<%@include file="cheader.jsp"%>
	
	<div id="reset_password_form" style="padding-left:0px">
		<h1>Reset Password Init</h1><br>
		<ff:form action="resetPasswordInit" method="post">
			<table align="center" width="96.3%" border="0" cellspacing="6" cellpadding="6" background = "${pageContext.request.contextPath}/images/table-background.jpg">
                               <tr>
                                       <td>
                                       <b>Enter your Email:</b>
                                       <input type="text" name="email" size="40"/><br/><br/>
                                       </td>
                               </tr>
             
        <tr>     
			<td><font size="3">Answer the questions below:</font></td>
		</tr>
		
		
		<tr>     
			<td><font size="3">
				<c:forEach items="${errorMessage}" var="eitem" varStatus="i"><br/>
					<li>
							${eitem}
					<br/>
					</li>
				</c:forEach>
			
			</font></td>
		</tr>
			
		<tr>
		
		<td><b>
		
				
		
				<c:forEach items="${secretQuestions}" var="item" varStatus="i"><br/>
					<li>
					${item.description}<br/>
					 <input type="hidden" name="displayedQuestions" value="${item.questionId}">
					<input type="text" name="answersByCustomers">
					</li>
				</c:forEach>
		</b></td></tr>
		<tr><td><b>
			<input type="submit" name="submit" id="submit_btn" size = "20" value="resetPassword"/>
		</b></td></tr>
		
		</table>
		
		</ff:form>
	</div>


<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript">
	var ccontextPath="${pageContext.request.contextPath}";
	$(function(){
		$("#answer").blur(
		 function() {
			 var answer=$("#answer").val();
			 //alert("your answer = "+answer);
			 if(answer.length==0){
				 alert("answer cannot be blank.")
				 $("#answer").focus();
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
</script>


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
