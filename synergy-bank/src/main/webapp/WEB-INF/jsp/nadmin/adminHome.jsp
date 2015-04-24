<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
      <%@include file="/adminImport.jsp" %>
</head>

<body>

    <!--Header-->
      <%@include file="/aheader.jsp" %>
    <!-- /header -->

    <section class="title">
        <div class="container">
            <div class="row-fluid">
                <div class="span6">
                    <h1>Admin Home</h1>
                </div>
                <div class="span6">
                    <ul class="breadcrumb pull-right">
                        <li><a href="index.html">Home</a> <span class="divider">/</span></li>
                        <li><a href="#">Pages</a> <span class="divider">/</span></li>
                        <li class="active">Admin Home</li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <!-- / .title -->     

    <section id="portfolio" class="container main">    
        <ul class="gallery col-4">
            <!--Item 1-->
            
            <c:forEach items="${tportfolioFormsList}" var="item" varStatus="sno">
            <li>
                <div class="preview">
                    <img alt=" " src="${pageContext.request.contextPath}/${item.thumbUrl}">
                    <div class="overlay">
                    </div>
                    <div class="links">
                        <a data-toggle="modal" href="#modal-${sno.count}"><i class="icon-eye-open"></i></a><a href="#"><i class="icon-link"></i></a>                                
                    </div>
                </div>
                <div class="desc">
                    <h5>${item.imageTitle}</h5>
                    <small>${item.description}</small>
                </div>
                <div id="modal-${sno.count}" class="modal hide fade">
                    <a class="close-modal" href="javascript:;" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></a>
                    <div class="modal-body">
                        <img src="${pageContext.request.contextPath}/${item.imageUrl}" alt=" " width="100%" style="max-height:400px">
                    </div>
                </div>                 
            </li>
            </c:forEach>
            <!--/Item 4--> 

            <!--Item 5-->
            <li>
                <div class="preview">
                    <img alt=" " src="${pageContext.request.contextPath}/images/portfolio/thumb/item5.jpg">
                    <div class="overlay">
                    </div>
                    <div class="links">
                        <a data-toggle="modal" href="#modal-5"><i class="icon-eye-open"></i></a><a href="#"><i class="icon-link"></i></a>                                
                    </div>
                </div>
                <div class="desc">
                    <h5>Lorem ipsum dolor sit amet</h5>
                    <small>Portfolio item short description</small>
                </div>
                <div id="modal-5" class="modal hide fade">
                    <a class="close-modal" href="javascript:;" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></a>
                    <div class="modal-body">
                        <img src="${pageContext.request.contextPath}/images/portfolio/full/item5.jpg" alt=" " width="100%" style="max-height:400px">
                    </div>
                </div>                 
            </li>
            <!--/Item 5--> 

            <!--Item 6-->
            <li>
                <div class="preview">
                    <img alt=" " src="${pageContext.request.contextPath}/images/portfolio/thumb/item6.jpg">
                    <div class="overlay">
                    </div>
                    <div class="links">
                        <a data-toggle="modal" href="#modal-6"><i class="icon-eye-open"></i></a><a href="#"><i class="icon-link"></i></a>                                
                    </div>
                </div>
                <div class="desc">
                    <h5>Lorem ipsum dolor sit amet</h5>
                    <small>Portfolio item short description</small>
                </div>
                <div id="modal-6" class="modal hide fade">
                    <a class="close-modal" href="javascript:;" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></a>
                    <div class="modal-body">
                        <img src="${pageContext.request.contextPath}/images/portfolio/full/item6.jpg" alt=" " width="100%" style="max-height:400px">
                    </div>
                </div>                 
            </li>
            <!--/Item 6-->                 

            <!--Item 7-->
            <li>
                <div class="preview">
                    <img alt=" " src="${pageContext.request.contextPath}/images/portfolio/thumb/item1.jpg">
                    <div class="overlay">
                    </div>
                    <div class="links">
                        <a data-toggle="modal" href="#modal-7"><i class="icon-eye-open"></i></a><a href="#"><i class="icon-link"></i></a>                                
                    </div>
                </div>
                <div class="desc">
                    <h5>Lorem ipsum dolor sit amet</h5>
                    <small>Portfolio item short description</small>
                </div>
                <div id="modal-1" class="modal hide fade">
                    <a class="close-modal" href="javascript:;" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></a>
                    <div class="modal-body">
                        <img src="${pageContext.request.contextPath}/images/portfolio/full/item1.jpg" alt=" " width="100%" style="max-height:400px">
                    </div>
                </div>                 
            </li>
            <!--/Item 7-->

            <!--Item 8-->
            <li>
                <div class="preview">
                    <img alt=" " src="${pageContext.request.contextPath}/images/portfolio/thumb/item5.jpg">
                    <div class="overlay">
                    </div>
                    <div class="links">
                        <a data-toggle="modal" href="#modal-8"><i class="icon-eye-open"></i></a><a href="#"><i class="icon-link"></i></a>                                
                    </div>
                </div>
                <div class="desc">
                    <h5>Lorem ipsum dolor sit amet</h5>
                    <small>Portfolio item short description</small>
                </div>
                <div id="modal-8" class="modal hide fade">
                    <a class="close-modal" href="javascript:;" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></a>
                    <div class="modal-body">
                        <img src="${pageContext.request.contextPath}/images/portfolio/full/item5.jpg" alt=" " width="100%" style="max-height:400px">
                    </div>
                </div>                 
            </li>
            <!--/Item 8-->
            
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
            <button type="submit" class="btn btn-primary">Sign in</button>
        </form>
        <a href="#">Forgot your password?</a>
    </div>
    <!--/Modal Body-->
</div>
<!--  /Login form -->

<script src="${pageContext.request.contextPath}/js/vendor/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/vendor/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>
</html>
