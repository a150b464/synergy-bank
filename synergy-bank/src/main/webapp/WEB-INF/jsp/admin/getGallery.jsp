<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery1.9.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tableStyle.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<script src="<%=request.getContextPath() %>/js/controller.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gallery Management</title>
<script src="${pageContext.request.contextPath}/js/jquery1.9.1.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" media="screen" >
<!-- <script type="text/javascript">
function deleteRow(imageid){
	var val=confirm("Are you sure you want to delete?");
	if(val==true)
		window.location.href = "${pageContext.request.contextPath}/Delete?sid="+imageid;
		
}

</script> -->
<script type="text/javascript" language="javascript">
  var ccontextPath="${pageContext.request.contextPath}";
  function deleteImageByAjax(iid){
	   //alert("iid = "+iid);
		$.ajax({
			url:"${pageContext.request.contextPath}/bank/ajaxDeleteImage",
			data:{imageid:iid},
			success:function(data) {
		    if(data=='done') {
				 var cid="#"+iid;
				 $(cid).remove();
				 removeToken("count"+rownum);
				 for(var row=1;row<=len;row++){
					 $("#"+idTokens[row-1]).html("<b>"+row+"</b>");
				 }
		    }else{
		    	 
		    }
		  }
		});
	}
  
  
//Kick off the jQuery with the document ready function on page load
  $(document).ready(function(){
  	imagePreview();
  });

  // Configuration of the x and y offsets
  this.imagePreview = function(){	
  		xOffset = -1;
  		yOffset = 0;		
  		
      $("a.preview").hover(function(e){
    	 //	 alert("e.pageY = "+e.pageY);
          this.t = this.title;
          this.title = "";	
  	     var c = (this.t != "") ? "<br/>" + this.t : "";
           $(this).append("<p id='preview'><img src='"+ this.href +"' alt='Image preview' />"+ c +"</p>");								 
           $("#preview")
              .css("top",(e.pageY - xOffset-400) + "px")
              .css("left",(e.pageX + yOffset) + "px").fadeIn("slow");
      },
  	
      function(){
          this.title = this.t;
          $("#preview").remove();

      });	
  	
     /*  $("a.preview").mousemove(function(e){
    	 // alert("e.pageY = "+e.pageY);
          $("#preview")
              .css("top","100px")
              .css("left",(e.pageX + yOffset) + "px");
      });	 */		
  };
  
  
  
  </script>
</head>
<body>
<sql:setDataSource var="datasource" driver="com.mysql.jdbc.Driver"  url="jdbc:mysql://localhost/synergy_bank_db" 
user="root" password="root" scope="session"/>

<sql:query var="query" dataSource="${datasource}">
select * from image_galary_tbl

</sql:query>
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
	<%-- 	<a href="index.html" class="logo"><img src="${pageContext.request.contextPath}/images/clogo.jpg" alt="setalpm" width="40" height="40" /></a>
	 --%>	
	 <span class="slogan">&nbsp;<font color="green"><b>&nbsp;&nbsp;Synergy Bank</b></font></span>
		<ul id="menu">
			<li><a href="#">Home			</a></li>
			<li><a href="#">Employer		</a></li>
			<li><a href="#">Personal Bank	</a></li>
			<li><a href="#">Loan			</a></li>
			<li><a href="#">Credit Card		</a></li>
			<li><a href="#">About Us		</a></li>
			<li><a href="#">Help			</a></li>
			<li class="last"><a href="#">Register</a></li>
			<li class="last"><a href="${pageContext.request.contextPath}/bank/logout">logout</a></li>
		</ul>
<%-- 		<img src="${pageContext.request.contextPath}/images/bank_logo.jpg" alt="" width="192" height="63" />
 --%>		<img src="${pageContext.request.contextPath}/images/registrationPic.png" alt="" width="892" height="280" />
		
	</div>


<!-- <a href = "AddUser.jsp">Add User</a> -->
<table align="center" width="100%" border="0" cellspacing="20" cellpadding="20" id="galleryTable">
	<thead>
	<tr>
		<td>Image ID</td>
		<td>Image</td>
		<td>Path</td>
		<td>Edit</td>
		<td>Delete</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="item" items="${query.rows}">
	<tr>
		<td><c:out value = "${item.imageid}"/> </td>
		<%-- <td><img src = "${pageContext.request.contextPath}/bank/findImageFilePathById?imageid=${item.imageid}" width="30" height = "30"> </td>   --%>
        <td align="center">
			<a href="${pageContext.request.contextPath}/bank/findImageFilePathById?imageid=${item.imageid}"  class="preview">
           	<img src="${pageContext.request.contextPath}/bank/findImageFilePathById?imageid=${item.imageid}" width="20" height="20"/>
           	</a>
		</td>
        <td><c:out value = "${item.path}"/> </td>
        <td><a href="${pageContext.request.contextPath}/bank/editGalleryById?imageid=${item.imageid}"><img src="${pageContext.request.contextPath}/images/edit.png"></a></td>
        <%-- <td><img src="${pageContext.request.contextPath}/images/delete.png" onclick="deleteRow(${item.sid});"></td> --%>
        <td><a href="javascript:deleteImageByAjax(${item.imageid});"><img src="${pageContext.request.contextPath}/images/delete.png"/></a></td>
		
	</tr>
	</c:forEach>
	</tbody>

</table>
<div id="showImage">
</div>
<div id="blocks">																																																																																																																													
			
</div>


<div id="info">
			<div>
				<img src="${pageContext.request.contextPath}/images/title5.gif" alt="" width="160" height="26" />
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
				<img src="${pageContext.request.contextPath}/images/title6.gif" alt="" width="160" height="26" />
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
				<img src="${pageContext.request.contextPath}/images/title7.gif" alt="" width="160" height="26" />
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
				<img src="${pageContext.request.contextPath}/images/title8.gif" alt="" width="160" height="26" />
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
	<%@ include file="../common/footer.jsp" %>	

</body>
</html>