<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JOB Portal</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript" src="validations.js"></script>
</head>

<body>
	<div class="meta">
		<div class="metalinks">
			<a href="#"><img src="images/meta1.gif" alt="" width="15" height="14" /></a>
			<a href="#"><img src="images/meta2.gif" alt="" width="17" height="14" /></a>
			<a href="#"><img src="images/meta3.gif" alt="" width="17" height="14" /></a>
			<a href="#"><img src="images/meta4.gif" alt="" width="15" height="14" /></a>
		</div>
		<p>Recruiters: <a href="#">Log in</a> or <a href="#">Find out more</a></p>																																															
	</div>
	<div id="header">
		<a href="index.html" class="logo"><img src="images/clogo.jpg" alt="setalpm" width="50" height="50" /></a>
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
		<embed width ="892" height="303" src ="transfer_money3.swf">
	</div>
	<div id="content">
			
			 <br/>
			<h1>Payee Details</h1> 
			<br/>
			<ff:form action="addpayee.do" method="post" commandName="addPayeeCommand">
				<table align="left" width="80%" border="0" cellspacing="3" cellpadding="3">
					<tr>
						<td>
						<ff:hidden path=""/>
						<b>Payee Account Number</b></td>
						<td><ff:input path="payeeAccountNumber" size="40" style="background:orange; font-family: Palatino Linotype"/></td>
					</tr>
					<tr>
						<td><b>Re-enter Account Number</b></td>
						<td><ff:input  path="payeeReAccountNumber" size="40" style="background:orange;font-family: Palatino Linotype"/></td>
					</tr>
					<tr>
						<td><b>Account Type</b></td>
						<td>
						<ff:select path="payeeAccountType" style="background:#FFF380;" width="20">
						<ff:options items="${acclist}"/>
						</ff:select>
						</td>
					</tr>	
					<tr>
						<td><b>Payee Name</b></td>
						<td><ff:input path="payeeName" size="40" style="background:orange;font-family: Palatino Linotype"/></td>
					</tr>
					<tr>
						<td><b>Payee Nickname</b></td>
						<td><ff:input path="payeeNickName" size="40" style="background:orange;font-family: Palatino Linotype"/></td>
					</tr>
					<tr>
						<td><b>Payee Registration alert to be sent on email.</b></td>
						<td><ff:input path="payeeEmailId" size="40" style="background:orange;font-family: Palatino Linotype"/></td>
					</tr>
							
				</table><br><br><br><br><br><br><br><br><br><br><br><br>
				<h3 style="font-family: Palatino Linotype; font-size: 13px; color: grey">
					Notes: <br>
					1. To add/update your email id,  please contact the customer service.<br>
					2. Please make sure the account number is correct.<br>
					3. Synergy Bank is not responsible for funds transferred to unintended recipient.<br>
					4. Before you proceed make sure you have entered all the detials corrrectly.<br>					
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
				<img src="images/title5.gif" alt="" width="160" height="26" />
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
				<img src="images/title6.gif" alt="" width="160" height="26" />
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
				<img src="images/title7.gif" alt="" width="160" height="26" />
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
				<img src="images/title8.gif" alt="" width="160" height="26" />
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
