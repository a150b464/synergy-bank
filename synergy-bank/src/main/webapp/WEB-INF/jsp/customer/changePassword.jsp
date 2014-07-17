<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.titlePage}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer-validations.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/updateLoginPwdvalidations.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>

</head>
<body>
	<%@include file="cheader.jsp"%>
	<div>	<img src="${pageContext.request.contextPath}/images/bank_logo.jpg" alt="" width="192" height="63" />
		<img src="${pageContext.request.contextPath}/images/registrationPic.png" alt="" width="892" height="280" />
		
	</div>
	<div id="content">
	<h3>This page is under construction:</h3> 
	<br/>	 <br/>	 <br/>	 <br/>	 <br/>	 
			<form name="changePassword" action="${pageContext.request.contextPath}/bank/changePassword" method="post" > 
				<table align=center width="60%" border="0" cellspacing="20" cellpadding="20" background = "${pageContext.request.contextPath}/images/table-background.jpg" >
			
			 
			
			
					<tr>
						<td>
							<b>Current Password :</b>
							<input name = "cPassword" type="text" size="20" readonly="readonly" />
						</td>						
					</tr>
					
					<tr>
						<td>
							<b>New Password :</b>
							<input name = "nPassword" type="text" size="20" />
						</td>						
					</tr>
					
					<tr>
						<td>
							<b>Confirm Password :</b>
							<input name = "confirmPassword" type="password" size="20" />
						</td>						
					</tr>
			
		</table>
			
	</form> 
	
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
