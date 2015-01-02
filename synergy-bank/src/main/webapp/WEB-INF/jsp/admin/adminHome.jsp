<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.titlePage}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer-validations.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/tinycarousel.css" type="text/css" media="screen"/>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.tinycarousel.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#slider1').tinycarousel();
		});
	</script>

</head>
<body>
	<%@include file="aheader.jsp"%>
	<div>	<img src="${pageContext.request.contextPath}/images/bank_logo.jpg" alt="" width="192" height="63" />
		<img src="${pageContext.request.contextPath}/images/registrationPic.png" alt="" width="892" height="280" />
		
	</div>
	<div id="content" style="width: 100%">
			<form name="customerHome" action="${pageContext.request.contextPath}/bank/auth" method="post" > 
				<table align=center width="60%" border="0" cellspacing="20" cellpadding="20" background = "${pageContext.request.contextPath}/images/table-background.jpg" >
			 	 <br/>	
			<h3>Welcome to the Synergy-Bank!</h3> 
				<h3 style="color: blue">${msg}</h3>
		</table>
			
	</form> 
		<br/>
		
		<div id="slider1">
		<a class="buttons prev" href="#">&#60;</a>
		<div class="viewport">
			<ul class="overview">
				<li><img src="${pageContext.request.contextPath}/bank/findPhotoFromGallaryById?imageid=6"/></li>
				<li><img src="${pageContext.request.contextPath}/bank/findPhotoFromGallaryById?imageid=5"/></li>
				<li><img src="${pageContext.request.contextPath}/bank/findPhotoFromGallaryById?imageid=4"/></li>
				<li><img src="${pageContext.request.contextPath}/bank/findPhotoFromGallaryById?imageid=3"/></li>
				<li><img src="${pageContext.request.contextPath}/bank/findPhotoFromGallaryById?imageid=2"/></li>
				<li><img src="${pageContext.request.contextPath}/bank/findPhotoFromGallaryById?imageid=1"/></li>
			</ul>
		</div>
		<a class="buttons next" href="#">&#62;</a>
	</div>
		<br/><br/>
		<!-- <div id="blocks" style="width:100%">																																																																																																																													
			
		</div> -->
		<hr style="color: black"/>
		<hr style="color: red"/>
		<div id="info">
			<div>
				<img src="${pageContext.request.contextPath}/images/title5.gif" alt="" width="160" height="26" />
				<img src="${pageContext.request.contextPath}/images/jobseekers.jpg" alt="" width="160" height="160"/>
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/images/title6.gif" alt="" width="160" height="26" />
					<img src="${pageContext.request.contextPath}/images/careerbuilder.jpg" alt="" width="160" height="160"/>
				
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/images/title7.gif" alt="" width="160" height="26" />
				<img src="${pageContext.request.contextPath}/images/marketyour.jpg" alt="" width="160" height="160"/>
				
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/images/title8.gif" alt="" width="160" height="26" />
				<img src="${pageContext.request.contextPath}/images/site-partner.jpg" alt="" width="160" height="160"/>
				
			</div>
			
			<br/>
			<%@ include file="../common/footer.jsp" %>
		</div>
		
	</div>

</body>
</html>
