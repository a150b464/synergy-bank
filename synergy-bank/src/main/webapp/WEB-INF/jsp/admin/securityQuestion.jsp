<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Portfolio | Nova</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sl-slide.css">

    <script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-57-precomposed.png">
    
    <style type="text/css">
    	.input-large {
  			width: 410px;
 			 height: 24px !important;
  			margin-bottom: 10px !important;
 					 line-height: 30px !important;
  padding: 11px 19px !important;
  font-size: 17.5px !important;
  -webkit-border-radius: 6px;
     -moz-border-radius: 6px;
          border-radius: 6px;
}

.input-large[class=input-large] {
    width: 400px;
}
    
    </style>
  
</head>

<body>

    <!--Header-->
      <%@include file="/aheader.jsp" %>
    <!-- /header -->

    <section class="title">
        <div class="container">
            <div class="row-fluid">
                <div class="span6">
                    <h1>Portfolio</h1>
                </div>
                <div class="span6">
                    <ul class="breadcrumb pull-right">
                        <li><a href="index.html">Home</a> <span class="divider">/</span></li>
                        <li><a href="#">Pages</a> <span class="divider">/</span></li>
                        <li class="active">Portfolio</li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <!-- / .title -->     

    <section id="portfolio" class="container main"> 
    <ff:form id="securityQuestionForm"	method="post" commandName="securityQuestionsForm">   
    		<h3>Add Security Questions</h3>
    	    <table class="table">
        <tbody>
            <tr>
                <td>QuestionID </td>
                <td style="height: 20px;"> <input type="text"  style="width:320px;height:1px;" name="questionId"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text"  name="description" style="width:620px;height:1px;"></td>
            </tr>
            
             <tr>
                <td>&nbsp;</td>
                <td>
              <button type="button" id="securityButtonId" class="btn btn-primary btn-sm">Add Question</button>
                <td>
            </tr>
        </tbody>
    </table>
    </ff:form>
        <ul class="gallery col-4">
            
            <!--Item 9-->
            <li>
                <div class="preview">
                    <img alt=" " src="${pageContext.request.contextPath}/images/portfolio/thumb/item1.jpg">
                    <div class="overlay">
                    </div>
                    <div class="links">
                        <a data-toggle="modal" href="#modal-9"><i class="icon-eye-open"></i></a><a href="#"><i class="icon-link"></i></a>                                
                    </div>
                </div>
                <div class="desc">
                    <h5>Lorem ipsum dolor sit amet</h5>
                    <small>Portfolio item short description</small>
                </div>
                <div id="modal-9" class="modal hide fade">
                    <a class="close-modal" href="javascript:;" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></a>
                    <div class="modal-body">
                        <img src="${pageContext.request.contextPath}/images/portfolio/full/item1.jpg" alt=" " width="100%" style="max-height:400px">
                    </div>
                </div>                 
            </li>
            <!--/Item 9--> 

            <!--Item 10-->
            <li>
                <div class="preview">
                    <img alt=" " src="${pageContext.request.contextPath}/images/portfolio/thumb/item2.jpg">
                    <div class="overlay">
                    </div>
                    <div class="links">
                        <a data-toggle="modal" href="#modal-10"><i class="icon-eye-open"></i></a><a href="#"><i class="icon-link"></i></a>                                
                    </div>
                </div>
                <div class="desc">
                    <h5>Lorem ipsum dolor sit amet</h5>
                    <small>Portfolio item short description</small>
                </div>
                <div id="modal-10" class="modal hide fade">
                    <a class="close-modal" href="javascript:;" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></a>
                    <div class="modal-body">
                        <img src="${pageContext.request.contextPath}/images/portfolio/full/item2.jpg" alt=" " width="100%" style="max-height:400px">
                    </div>
                </div>                 
            </li>
            <!--/Item 10-->

            <!--Item 11-->
            <li>
                <div class="preview">
                    <img alt=" " src="${pageContext.request.contextPath}/images/portfolio/thumb/item3.jpg">
                    <div class="overlay">
                    </div>
                    <div class="links">
                        <a data-toggle="modal" href="#modal-11"><i class="icon-eye-open"></i></a><a href="#"><i class="icon-link"></i></a>                                
                    </div>
                </div>
                <div class="desc">
                    <h5>Lorem ipsum dolor sit amet</h5>
                    <small>Portfolio item short description</small>
                </div>
                <div id="modal-11" class="modal hide fade">
                    <a class="close-modal" href="javascript:;" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></a>
                    <div class="modal-body">
                        <img src="${pageContext.request.contextPath}/images/portfolio/full/item3.jpg" alt=" " width="100%" style="max-height:400px">
                    </div>
                </div>                 
            </li>
            <!--/Item 11--> 

            <!--Item 12-->
            <li>
                <div class="preview">
                    <img alt=" " src="${pageContext.request.contextPath}/images/portfolio/thumb/item4.jpg">
                    <div class="overlay">
                    </div>
                    <div class="links">
                        <a data-toggle="modal" href="#modal-12"><i class="icon-eye-open"></i></a><a href="#"><i class="icon-link"></i></a>                                
                    </div>
                </div>
                <div class="desc">
                    <h5>Lorem ipsum dolor sit amet</h5>
                    <small>Portfolio item short description</small>
                </div>
                <div id="modal-12" class="modal hide fade">
                    <a class="close-modal" href="javascript:;" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></a>
                    <div class="modal-body">
                        <img src="${pageContext.request.contextPath}/images/portfolio/full/item4.jpg" alt=" " width="100%" style="max-height:400px">
                    </div>
                </div>                 
            </li>
            <!--/Item 12-->                

        </ul>
        
    </section>

    <!--Bottom-->
   <%@include file="/abottom.jsp" %>
<!--/bottom-->

<!--Footer-->
 <%@include file="/afooter.jsp" %>
<!--/Footer-->

<!--  Login form -->
<div class="modal hide fade in" id="loginForm" aria-hidden="false">
    <div class="modal-header">
        <i class="icon-remove" data-dismiss="modal" aria-hidden="true"></i>
        <h4>Login Form</h4>
    </div>
    <!--Modal Body-->
    <div class="modal-body">
        <form class="form-inline" action="index.html" method="post" id="form-login">
            <input type="text" class="input-small" placeholder="Email">
            <input type="password" class="input-small" placeholder="Password">
            <label class="checkbox">
                <input type="checkbox"> Remember me
            </label>
            <button type="submit"  class="btn btn-primary">Sign in</button>
        </form>
        <a href="#">Forgot your password?</a>
    </div>
    <!--/Modal Body-->
</div>
<!--  /Login form -->

<script src="${pageContext.request.contextPath}/js/vendor/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/vendor/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
 <script type="text/javascript">
   $(function() {
		alert('-3-3-3-3-');
		
		$("#securityButtonId").click(
			function(){
				var form = $('#securityQuestionForm');
			    $.ajax( {
			      type: "POST",
			      url:"${pageContext.request.contextPath}/bank/addSecuirtyQuestions",
			      data: form.serialize(),
			      success: function( response ) {
			    	if(response=="done"){
			    		alert("Security Question is added...");
			    	}  
			        //console.log( response );
			      }
			    } );
		});
		
	});
   </script> 

</body>
</html>
