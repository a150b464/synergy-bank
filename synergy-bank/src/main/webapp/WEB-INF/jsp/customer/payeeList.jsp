<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.titlePage}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/jquery1.9.1.js" type="text/javascript"></script> --%>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" media="screen" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tableStyle.css" />
<script type="text/javascript" language="javascript">
  var ccontextPath="${pageContext.request.contextPath}";
  function deleteRowByAjax(uid){
	   //alert("uid = "+uid);
		$.ajax({
			url:"${pageContext.request.contextPath}/bank/ajaxDeleteRow",
			data:{userid:uid},
			success:function(data) {
		    if(data=='done') {
				 var cid="#"+uid;
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
          this.t = this.title;
          this.title = "";	
  	     var c = (this.t != "") ? "<br/>" + this.t : "";
           $("body").append("<p id='preview'><img src='"+ this.href +"' alt='Image preview' />"+ c +"</p>");								 
           $("#preview")
              .css("top",(e.pageY - xOffset) + "px")
              .css("left",(e.pageX + yOffset) + "px")
              .fadeIn("slow");
      },
  	
      function(){
          this.title = this.t;
          $("#preview").remove();

      });	
  	
      $("a.preview").mousemove(function(e){
          $("#preview")
              .css("top",(e.pageY - xOffset) + "px")
              .css("left",(e.pageX + yOffset) + "px");
      });			
  };
  </script>
</head>
<body>
	<%@include file="cheader.jsp"%>
		<img src="${pageContext.request.contextPath}/images/bigpicture.jpg" alt="" width="892" height="303" />
	</div>
	<div id="content">
			
		<br/> <h2 align="center">PAYEE DETAILS LIST:</h2>  <br/><br><br>
		<table align="center">
		<thead>
			<tr>
				<td><b>SNO</b></td>	
				<td><b>User ID</b></td>	 
				<td><b>Payee Account No.</b></td>	
				<td><b>Payee Name</b></td>
				<td><b>Payee Nick Name</b></td>		
				<td><b>Payee Mobile No.</b></td>  
				<td><b>Date of Entry</b></td>
				<td><b>Email</b></td>
				<td><b>Status</b></td>
				<td><b>Photo</b></td>
				<td><b>Edit</b></td>
				<td><b>Delete</b></td>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${showPayeeList}" var="item" varStatus="myIndex">		
				<tr>
	    			<td>${myIndex.count}</td>
	    			<td>${item.userid}</td>
	    			<td>${item.payeeAccountNo}</td>
	    			<td>${item.payeeName}</td>
	    			<td>${item.payeeNickName}</td>
	    			<td>${item.mobile}</td>
	    			<td>${item.doe}</td>
	    			<td>${item.email}</td>
	    			<td>${item.status}</td>
	    			<%-- <td><img src="${pageContext.request.contextPath}/bank/findPhotoByEmail?email=${item.email}" width = "15" height = "15"></td> --%>
	    			<td align="center">
						<a href="${pageContext.request.contextPath}/bank/findPhotoByEmail?email=${item.email}"  class="preview">
           		 		<img src="${pageContext.request.contextPath}/bank/findPhotoByEmail?email=${item.email}" width="20" height="20"/>
           				</a>
					</td>
	    			<td><a href="${pageContext.request.contextPath}/bank/editPayeeByEmail?email=${item.email}"><img src="${pageContext.request.contextPath}/images/edit.png" alt="" width="15" height="15" /></a></td>
	    			<td><a href="javascript:deleteRowByAjax(${item.userid});"><img src="${pageContext.request.contextPath}/images/delete.png" alt="" width="15" height="15" /></a></td>
	    		</tr>
			</c:forEach>
		
		</tbody>
		
		</table><br>	
			
			<div align = "center">			
			<h3>Download Excel: <a href="${pageContext.request.contextPath}/bank/downloadExcel"><img src = "${pageContext.request.contextPath}/images/excel.jpg" width = "20" height = "20"></a></h3>
  		    </div>
  		    <div align = "center">
  		    <h3>Download PDF: <a href="${pageContext.request.contextPath}/bank/downloadPDF"><img src = "${pageContext.request.contextPath}/images/pdf.jpg" width = "20" height = "20"></a></h3>
  		    </div>
			
			
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		
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
