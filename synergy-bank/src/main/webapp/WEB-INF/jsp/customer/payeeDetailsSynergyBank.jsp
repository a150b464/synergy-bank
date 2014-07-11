<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${pageContext.request.contextPath}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
</head>

<body>
	<div class="meta">
		<div class="metalinks">
			<a href="#"><img src="${pageContext.request.contextPath}/images/meta1.gif" alt="" width="15" height="14" /></a>
			<a href="#"><img src="${pageContext.request.contextPath}/images/meta2.gif" alt="" width="17" height="14" /></a>
			<a href="#"><img src="${pageContext.request.contextPath}/images/meta3.gif" alt="" width="17" height="14" /></a>
			<a href="#"><img src="${pageContext.request.contextPath}/images/meta4.gif" alt="" width="15" height="14" /></a>
		</div>
		<p>Recruiters: <a href="#">Log in</a> or <a href="#">Find out more</a></p>																																															
	</div>
	<div id="header">
		<a href="index.html" class="logo"><img src="${pageContext.request.contextPath}/images/clogo.jpg" alt="setalpm" width="50" height="50" /></a>
		<span class="slogan">&nbsp;<font color="green"><b>&nbsp;&nbsp;Synergy Bank</b></font></span>
		<ul id="menu">
			<li><a href="#">Home</a></li>
			<li><a href="#">Employer</a></li>
			<li><a href="#">Personal Bank</a></li>
			<li><a href="#">Loan</a></li>
			<li><a href="#">Credit Card</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Help</a></li>
			<li class="last"><a href="#">Register</a></li>
		</ul>
		<img src="${pageContext.request.contextPath}/transfer_money3.swf" alt="" width="892" height="303" />
	</div>
	<div id="content">
			
			 <br/>
			<h1>Payee Details</h1> 
			<br/>
			<ff:form action="addpayee.do" method="post" commandName="addPayeeCommand">
				<table align="center" width="80%" border="0" cellspacing="3" cellpadding="3">
					<tr>
						<td>
						<ff:hidden path=""/>
						<b>Payee Account Number</b></td>
						<td><ff:input path="payeeAccountNo" size="40" style="background:orange; font-family: Palatino Linotype"/></td>
					</tr>
					<tr>
						<td><b>Payee Name</b></td>
						<td><ff:input  path="payeeName" size="40" style="background:orange;font-family: Palatino Linotype"/></td>
					</tr>	
					<tr>
						<td><b>Payee Nick Name</b></td>
						<td><ff:input path="payeeNickName" size="40" style="background:orange;font-family: Palatino Linotype"/></td>
					</tr>
					<tr>
						<td><b>Mobile Number</b></td>
						<td><ff:input path="mobile" size="40" style="background:orange;font-family: Palatino Linotype"/></td>
					</tr>
					<tr>
						<td><b>Payee Registration alert to be sent on email.</b></td>
						<td><ff:input path="email" size="40" style="background:orange;font-family: Palatino Linotype"/></td>
					</tr>
							
				</table><br><br>
				<h3 style="font-family: Palatino Linotype; font-size: 13px; color: grey">
					Notes: <br>
					1. To add/update your email id,  please contact the customer service.<br>
					2. Please make sure the account number is correct.<br>
					3. Synergy Bank is not responsible for funds transferred to unintended recipient.<br>
					4. Before you proceed make sure you have entered all the details correctly.<br>					
					</h3>
					<br>
					<table>
					<tr>
						<td><input type="submit" value="Next" style="background: orange; font-family: Palatino Linotype; font-size: 17px;"/></td>
						<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
						<td><input type="submit" value="Back" style="background: orange; font-family: Palatino Linotype; font-size: 17px;"/></td>
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
