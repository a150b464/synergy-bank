<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Synergy Bank</title>
<link rel = "stylesheet" href = "${pageContext.request.contextPath}/css/slider.css">
<link rel = "stylesheet" href = "${pageContext.request.contextPath}/css/homePage.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/lstyle.css"> --%>

</head>
<body>
<div class = "wrapper">
	<img src="${pageContext.request.contextPath}/images/bank_logo.jpg" alt="" width="192" height="63" />
	<ul class="menu">
		<li><a href="${pageContext.request.contextPath}/home.jsp">Home</a></li>
 
    	<li><a href="${pageContext.request.contextPath}/index.jsp">Login</a></li>
	</ul>  
</div>  		
    
	
	<br />
	<br />
	

<div class = "wrapper">
		
	<div id = "slider">
		<img id = "1" src = "${pageContext.request.contextPath}/images/slider1.jpg">
		<img id = "2" src = "${pageContext.request.contextPath}/images/slider2.jpg">
		<img id = "3" src = "${pageContext.request.contextPath}/images/slider3.jpg">
		<img id = "4" src = "${pageContext.request.contextPath}/images/slider4.jpg">
		<img id = "5" src = "${pageContext.request.contextPath}/images/slider5.jpg">
		<img id = "6" src = "${pageContext.request.contextPath}/images/slider6.jpg">
		<img id = "7" src = "${pageContext.request.contextPath}/images/slider7.jpg">
		<img id = "8" src = "${pageContext.request.contextPath}/images/slider8.jpg">
	</div>
	
	<a href = "#" class = "left" onclick="prev(); return false;">Previous</a>
	<a href = "#" class = "right" onclick="next(); return false;">Next</a><br /><br /><br /><br /><br />
	
	<img src="${pageContext.request.contextPath}/images/registrationPic.png" alt="" width="892" height="280" /><br /><br /><br />
	
</div>

<div class="blocks" id = "blocks">
		<div id="info">
			<div>
				<img src="${pageContext.request.contextPath}/images/title5.gif"
					alt="" width="160" height="26" />
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
				<img src="${pageContext.request.contextPath}/images/title6.gif"
					alt="" width="160" height="26" />
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
				<img src="${pageContext.request.contextPath}/images/title7.gif"
					alt="" width="160" height="26" />
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
				<img src="${pageContext.request.contextPath}/images/title8.gif"
					alt="" width="160" height="26" />
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
	<%@ include file="../footer.jsp"%>


<script src = "${pageContext.request.contextPath}/js/jquery-2.1.3.min.js"></script>
<script src = "${pageContext.request.contextPath}/js/slider.js"></script>

</body>
</html>