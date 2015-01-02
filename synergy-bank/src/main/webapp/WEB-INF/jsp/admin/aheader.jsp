<style type="text/css">
.menu,
.menu ul,
.menu li,
.menu a {
    margin: 0;
    padding: 0;
    border: none;
    outline: none;
}
 
.menu {
    height: 40px;
    width: 892px;
 
    background: #4c4e5a;
    background: -webkit-linear-gradient(top, #4c4e5a 0%,#2c2d33 100%);
    background: -moz-linear-gradient(top, #4c4e5a 0%,#2c2d33 100%);
    background: -o-linear-gradient(top, #4c4e5a 0%,#2c2d33 100%);
    background: -ms-linear-gradient(top, #4c4e5a 0%,#2c2d33 100%);
    background: linear-gradient(top, #4c4e5a 0%,#2c2d33 100%);
 
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
}
 
.menu li {
    position: relative;
    list-style: none;
    float: left;
    display: block;
    height: 40px;
}

.menu li a {
    display: block;
    padding: 0 14px;
    margin: 6px 0;
    line-height: 28px;
    text-decoration: none;
 
    border-left: 1px solid #393942;
    border-right: 1px solid #4f5058;
 
    font-family: Helvetica, Arial, sans-serif;
    font-weight: bold;
    font-size: 13px;
 
    color: #f3f3f3;
    text-shadow: 1px 1px 1px rgba(0,0,0,.6);
 
    -webkit-transition: color .2s ease-in-out;
    -moz-transition: color .2s ease-in-out;
    -o-transition: color .2s ease-in-out;
    -ms-transition: color .2s ease-in-out;
    transition: color .2s ease-in-out;
}
 
.menu li:first-child a { border-left: none; }
.menu li:last-child a{ border-right: none; }
 
.menu li:hover > a { color: #8fde62; }


.menu ul {
    position: absolute;
    top: 40px;
    left: 0;
 
    opacity: 0;
    background: #1f2024;
 
    -webkit-border-radius: 0 0 5px 5px;
    -moz-border-radius: 0 0 5px 5px;
    border-radius: 0 0 5px 5px;
 
    -webkit-transition: opacity .25s ease .1s;
    -moz-transition: opacity .25s ease .1s;
    -o-transition: opacity .25s ease .1s;
    -ms-transition: opacity .25s ease .1s;
    transition: opacity .25s ease .1s;
}
 
.menu li:hover > ul { opacity: 1; }
 
.menu ul li {
    height: 0;
    overflow: hidden;
    padding: 0;
 
    -webkit-transition: height .25s ease .1s;
    -moz-transition: height .25s ease .1s;
    -o-transition: height .25s ease .1s;
    -ms-transition: height .25s ease .1s;
    transition: height .25s ease .1s;
}
 
.menu li:hover > ul li {
    height: 36px;
    overflow: visible;
    padding: 0;
}

.menu ul li a {
    width: 100px;
    padding: 4px 0 4px 40px;
    margin: 0;
 
    border: none;
    border-bottom: 1px solid #353539;
}
 
.menu ul li:last-child a { border: none; }


.menu a.documents { background: url(../img/docs.png) no-repeat 6px center; }
.menu a.messages { background: url(../img/bubble.png) no-repeat 6px center; }
.menu a.signout { background: url(../img/arrow.png) no-repeat 6px center; }

</style>
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
		<a href="index.html" class="logo"><img src="${pageContext.request.contextPath}/images/clogo.jpg" alt="setalpm" width="40" height="40" /></a>
		<span class="slogan">&nbsp;<font color="green"><b>&nbsp;&nbsp;Synergy Bank</b></font></span>
		<br/><br/><br/><br/>
		<ul class="menu">
		<li><a href="${pageContext.request.contextPath}/bank/homescreen.htm">Home</a>
        <ul>
            <li><a href="#" class="documents">Documents</a></li>
            <li><a href="#" class="messages">Messages</a></li>
            <li><a href="#" class="signout">Sign Out</a></li>
        </ul>
    </li>
 
    <li><a href="${pageContext.request.contextPath}/bank/customerInformation">Bank Customer</a></li>
    			<li><a href="${pageContext.request.contextPath}/bank/showPendingApprovalCustomerList">Approve Customer(s)</a></li>
			<li><a href="${pageContext.request.contextPath}/bank/blockCustomers">Block Customer(S)</a></li>
			<li><a href="#">Reset Password(s)</a></li>
			<li><a href="#">Reports</a></li>
			<li class="last"><a href="#">Profile</a></li>
			<li class="last"><a href="${pageContext.request.contextPath}/bank/logout">logout</a></li>
    
</ul>
	