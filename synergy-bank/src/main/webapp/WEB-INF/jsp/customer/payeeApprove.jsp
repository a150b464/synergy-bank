<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${pageContext.request.contextPath}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
</head>

<body onload="javascript:breadcrumbs()">
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
		<img src="${pageContext.request.contextPath}/images/AABanking.jpg" width="892" height="190" />
	</div>
	
	<div id="content">
			<h1>Approve Payee</h1> 
			<br/>
			<ff:form action="${pageContext.request.contextPath}/bank/confirmpayee.do" method="post" commandName="confirmPayeeCommand">
				<table align="center" border="2" cellspacing="10" cellpadding="10" width="90%" style="color: green">
		<thead>
			<tr>
				<td>
				<input type="hidden" name="payeeAccountNo" value="${payeeDetailsForm.payeeAccountNo}"/>
				<b>User ID</b></td>	 <td><b>Payee Account No.</b></td>	<td><b>Payee Name</b></td>
				<td><b>Status</b></td>
			</tr>
		</thead>
		<tbody>
				<tr>
	    			<td>${payeeDetailsForm.userid}</td>
	    			<td>${payeeDetailsForm.payeeAccountNo}</td>
	    			<td>${payeeDetailsForm.payeeName}</td>
	    			<td>${payeeDetailsForm.status}</td>
	    		</tr>
			
		
		</tbody>
		</table>
		<br>	
				<h3 style="font-family: Palatino Linotype; font-size: 13px; color: grey">
					Notes: <br>
					1. As per Synergy Bank circular dated June 2014, transfer of funds through electronic mode will take 1 business days.<br>
					2. Please make sure the account number is correct.<br>
					3. Synergy Bank is not responsible for funds transferred to unintended recipient.<br>
					4. Before you proceed make sure you have entered all the details correctly.<br>					
					</h3>
					<br>
					
					<table>
					<tr>
						<td style="font-family: Palatino Linotype; font-size: 15px; color: red">Enter The Verification Code</td>
						<td>&nbsp;</td>
						<td><input type="text" name="verificationCode" size="16" style="background:#D0F5A9;font-family: Palatino Linotype"/></td>
						<td>&nbsp;</td><td>&nbsp;</td>
						<td colspan="3" align="right"><input type="submit" value="Approve" style="background: orange; font-family: Palatino Linotype; font-size: 17px;"/></td>
						<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					</table>
		<table>
		<tr>
		<td style="font-family: Palatino Linotype; font-size: 20px; color: red">
		${errormessage}
		</td>
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
