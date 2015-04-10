<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.titlePage}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tableStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery1.9.1.js"></script>
<script type="text/javascript">
		
	$(document).ready(function(){	
	
	$("#checkAll").change(function () {
        if ($("#checkAll").is(':checked')) {
            
            $(".chkbox").prop("checked", true);

        } else {

            $(".chkbox").prop("checked", false);
        }
    }); 
 
  });

</script>
<style type="text/css">

#submitBtn{
	
	background-color: #04B45F; 
	padding: 5px; 
	margin-top: 5px; 
	font-weight: bold;
}


</style>


</head>
<body>
		<%@include file="aheader.jsp"%>
	<div id="content">
			
		<br/> <h3 align="center">Change Image PHOTO</h3>  <br/>
		<p align="center"><h5>${msg}</h5></p>		
		<ff:form id="imageNewUploadForm" method="post" action="${pageContext.request.contextPath}/bank/uploadNewPhoto.do" commandName="gallaryPhotoForm" enctype="multipart/form-data">
			<table align="center" id="tab1">
				<tbody>		
				
						<input type="text" name="path" value="${param.imageName}">
						<tr>
			    			<td>Old Image</td>
			    			<td><img src="${pageContext.request.contextPath}/images/${param.imageName}"/></td>
			    		</tr>
			    		
			    		<tr>
			    			<td>New Image</td>
			    			<td><input type="file" name="image"/>
			    			
			    			</td>
			    		</tr>
			    		
				</tbody>
			</table>	
				
			<div align="right"><input type="submit"  value="Upload New Photo" id="submitBtn" /></div>
				
		</ff:form>	
			
			

		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		
		<div id="blocks">																																																																																																																													
			
		</div>
	
	</div>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>
