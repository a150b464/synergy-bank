 <header class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a id="logo" class="pull-left" href="index.html"></a>
                <div class="nav-collapse collapse pull-right">
                    <ul class="nav">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="about-us.html">About Us</a></li>
                        <li><a href="services.html">Services</a></li>
                        <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				    		Customers <i class="icon-angle-down"></i>
						</a>
                       		 <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/bank/addImagePortfolio">Bank Customers</a></li>
                                <li><a href="${pageContext.request.contextPath}/bank/portfolio">Approve Customer(s)</a></li>
                                <li><a href="${pageContext.request.contextPath}/bank/portfolio">Block Customer(s)</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            Miscellaneous <i class="icon-angle-down"></i>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="career.html">Reset Password</a></li>
                                <li><a href="blog-item.html">Security Questions</a></li>
                                <li><a href="faq.html">FAQ</a></li>
                                <li><a href="pricing.html">Profile</a></li>
                                <li><a href="404.html">404</a></li>
                                <li><a href="typography.html">Typography</a></li>
                                <li><a href="registration.html">Registration</a></li>
                                <li class="divider"></li>
                                <li><a href="privacy.html">Privacy Policy</a></li>
                                <li><a href="terms.html">Terms of Use</a></li>
                            </ul>
                        </li>
                        <li><a href="blog.html">Gallery</a></li> 
                        <li><a href="contact-us.html">Logout</a></li>
                        <li class="login">
                            <a data-toggle="modal" href="#loginForm"><i class="icon-lock"></i></a>
                        </li>
                    </ul>        
                </div><!--/.nav-collapse -->
            </div>
        </div>
    </header>