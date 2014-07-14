<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>${initParam.pageTitle}</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/lstyle.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
  <link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
var ccontextPath="${pageContext.request.contextPath}";
	$(function() {
		$("input[type='text'][name='loginId']").keypress(
			     function() {
			    	 $("#errormessage").html("");
	    	 });
		
		$("input[type='password'][name='password']").keypress(
			     function() {
			    	 $("#errormessage").html("");
	     });
		
		$("#signid").click(
		     function(event) {
		    	 var gfound="nfound";
		    	 var login=$("input[type='text'][name='loginId']").val();
				if(login.length==0) {
					alert("Login id cannot be blank.");
					$("input[type='text'][name='loginId']").focus();
					event.preventDefault();
					return;
				}
				
				var password=$("input[type='password'][name='password']").val();
				if(password==0) {
					alert("Password cannot be blank.");
					$("input[type='password'][name='password']").focus();
					event.preventDefault();
					return;
				}
				
				/* $.ajax({url:ccontextPath+"/attendance/checLoginAndPassword",data:{plogin:login,ppassword:password},success:function(data) {
					gfound=data;
				    if(data=='found') {
						 document.forms[0].submit();
				    }else{
				    	 $("#errormessage").html("<h2>Login and password are not valid! , please try once again.</h2>");
				    	 $("input[type='password'][name='login']").focus();
				    	 event.preventDefault();
				    	 return;
				    }
  			  }
	  			 });    */
				 
				/* //preventing default click on image button
				 if(gfound!='found') {
				   	 	event.preventDefault();
			    		 return;
				    } */
				    
				 document.forms[0].submit();
		     });
	});
</script>
</head>
<body>
  <section class="container">
    <div class="login">
      <p align="center" style="color: black"><span id="errormessage">${param.error}</span></p>
     
    <img 	src="${pageContext.request.contextPath}/images/icon.jpg" alt=""
					border="0" />
					   <img 	src="${pageContext.request.contextPath}/images/icon.jpg" alt=""
					border="0" />
					   <img 	src="${pageContext.request.contextPath}/images/icon.jpg" alt=""
					border="0" />
      <h1>Login to Synergy Bank</h1><img alt="" src="${pageContext.request.contextPath}/images/sign1.jpg"  width="100" height="100"/>
        <p align="center" style="color: black">${applicationMessage}</p>
      <form method="post" action="${pageContext.request.contextPath}/bank/auth">
        <p><input type="text" name="login"  id="loginId" value="" placeholder="Bank userid"></p>
        <p><input type="password" id="password" name="password" value="" placeholder="Password"></p>
        <p class="submit">

     <!--   <input type="button" name="commit" style="background: url(images/logs.jpg); width:100px; height:35px;" />         -->
        <input type="image" src="${pageContext.request.contextPath}/images/logs.jpg" name="commit" value="Login" id="signid" width="100" height="35/">
         
        </p>
      </form>
    </div>

    <div class="login-help">
      Forgot your password? <a href="tlogin.jsp"><b>Click here to reset it</b></a>.
    </div>
  </section>

  
</body>
</html>
