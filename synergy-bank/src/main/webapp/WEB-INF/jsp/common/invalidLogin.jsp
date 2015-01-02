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
<script type="text/javascript">
		function myfunc(){
			alert("Hello");
			var value = '<%=session.getAttribute("conditionCheck")%>';
			if(value.equals("check")){ 
				$("#changePassword").show();
				$("#changeQuestion").hide();
			}else{
				$("#changeQuestion").show();
				$("#changePassword").hide();
			}
		}
	</script>
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
		    	 var login=$("input[type='text'][name='j_username']").val();
				if(login.length==0) {
					alert("Login id cannot be blank.");
					$("input[type='text'][name='j_username']").focus();
					event.preventDefault();
					return;
				}
				
				var password=$("input[type='password'][name='j_password']").val();
				if(password==0) {
					alert("Password cannot be blank.");
					$("input[type='password'][name='j_password']").focus();
					event.preventDefault();
					return;
				} 
				// alert("__________Spring security_____");				    
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
      <h1>Error Page</h1><img alt="" src="${pageContext.request.contextPath}/images/invalidPassword.jpg"  width="100" height="100"/>
        <p align="center" style="color: red;">${applicationMessage}</p>
        						  
     
    </div>
    <div class="login-help" style="color: black">
     <a href="${pageContext.request.contextPath}" ><b>Click here to login page</b></a>.<br>
    </div>
  </section>

  
</body>
</html>
