
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
			
			<img align="right" src="${pageContext.request.contextPath}/bank/findPhotoByUserId" width="50" height="50" style=" border-radius: 50%;"/><br><br>
		
		<a href="index.html" class="logo"><img src="${pageContext.request.contextPath}/images/clogo.jpg" alt="setalpm" width="40" height="40" /></a>
		<span class="slogan">&nbsp;<font color="green"><b>&nbsp;&nbsp;Synergy Bank</b></font></span>
		<ul id="menu">
			<li><a href="${pageContext.request.contextPath}/bank/customerHome">Home</a></li>
			    <c:if test="${sessionScope.userSessionData.approve!='no'}">
			<li><a href="${pageContext.request.contextPath}/bank/addpayee.do">Add Payee</a></li>
			<li><a href="${pageContext.request.contextPath}/bank/selectPayee">Fund Transfer</a></li>
			<li><a href="${pageContext.request.contextPath}/bank/accountSummary">Account Summary</a></li>
			<li><a href="#">Accounts</a></li>
			<li><a href="#">Credit Card</a></li>
			</c:if>
			
			<li><a href="${pageContext.request.contextPath}/bank/resetPasswordInit">Reset Password</a></li>
			
			<li class="last"><a href="${pageContext.request.contextPath}/bank/customerRegistration">Profile</a></li>
			<li class="last"><a href="${pageContext.request.contextPath}/bank/logout">logout</a></li>
		</ul>
	