<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${pageContext.request.contextPath}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<link href="${pageContext.request.contextPath}/css/breadcrumb.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/breadcrumb.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript">
	
	var ccontextPath="${pageContext.request.contextPath}";
	
	$(function(){
		$("#oldPassword").blur(
		 function() {
			 alert("--Inside ajax call--");
			 var oldPassword=$("#oldPassword").val();
			 if(oldPassword.length==0){
				 $("#pwdErrorr").html(oldPassword+ " is not valid.");
				 $("#oldPassword").focus();
				 return;
			 }
			 //making ajax call
			 $.ajax({url:ccontextPath+"/bank/passwordReset.do",data:{ooldPassword:oldPassword},success:function(data) {
						    if(data=='invalid') {
								 $("#pwdErrorr").html(oldPassword+ " is not valid.");
								 //$("input[type='text'][id='tosender']").focus();
								 return;
						    }else{
						    	 $("#pwdErrorr").html("");
						    	 return;
						    }
		  			  }
			   });   
			 
			
			 
		 }); 		
	});
</script>
</head>

<body>
	<%@include file="cheader.jsp"%>
	
	<img src="${pageContext.request.contextPath}/images/bank_logo.jpg"
		alt="" width="192" height="63" />
	<img
		src="${pageContext.request.contextPath}/images/registrationPic.png"
		alt="" width="892" height="280" />
	
	<div id="content" style="padding-left:0px">
		<h1>Reset Password</h1><br>
		<ff:form action="updatePassword" method="post" >
			<table align="center" width="147%" border="0" cellspacing="6" cellpadding="6" background = "${pageContext.request.contextPath}/images/table-background.jpg">
				<tr>
					<td><b>Old password:</b>
						<input type="text" name="oldPassword" style="text-align: right">
						<td  id="pwdErrorr" style="font-size:10;color: red;"></td>
				</tr>
				
				<tr>
					<td><b>New password:</b>
						<input type="text" name="newPassword" style="text-align: right">
					</td>
				</tr>
				<tr>
					<td><b>Confirm new password:</b>
						<input type="text" name="newPasswordConfirm" style="text-align: right">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" name="Reset Password" size="20">
					</td>
				</tr>
				
			</table>
		
		</ff:form>
		
	</div>
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

	<%@ include file="../common/footer.jsp" %>
</body>
</html>
