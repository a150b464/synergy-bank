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
<script type="text/javascript" src="${pageContext.request.contextPath}/WEB-INF/js/jquery1.9.1.js"></script>
<script type="text/javascript">
	
	

	/* function checkAll() {
	    
		if(document.getElementById('checkAll').checked){
			
			var checkboxes = new Array();
		    checkboxes = document.getElementsByTagName('input');
		    for (var i = 0; i < checkboxes.length; i++) {
		        if (checkboxes[i].type == 'checkbox') {
		            checkboxes[i].setAttribute('checked', true)
		        }
		    }
		}
		else{
			var checkboxes = new Array();
		    checkboxes = document.getElementsByTagName('input');
		    for (var i = 0; i < checkboxes.length; i++) {
		        if (checkboxes[i].type == 'checkbox') {
		            checkboxes[i].setAttribute('checked', false)
		        }
		    }
		}
	} */
	
	
	$(document).ready(function(){	
	
	$("#checkAll").change(function () {
        if ($("#checkAll").is(':checked')) {
            
            $(".chkbox").prop("checked", true);

        } else {

            $(".chkbox").prop("checked", false);
        }
    }); 
	
	 
	/*  $("#checkAll").change(function() {

	     if (this.checked) {
	    	$(".chkbox").prop("checked", true);
	    }
	    	
	    else {
	    	$(".chkbox").prop("checked", false);
	    } 
	});  */
 
  });

</script>



</head>
<body>
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
		<a href="index.html" class="logo"><img src="${pageContext.request.contextPath}/images/clogo.jpg" alt="setalpm" width="50" height="50" /></a>
		<span class="slogan">&nbsp;<font color="green"><b>&nbsp;&nbsp;Synergy Bank</b></font></span>
		<ul id="menu">
			<li><a href="#">Home</a></li>
			<li><a href="#">Employer</a></li>
			<li><a href="#">Personal Bank</a></li>
			<li><a href="#">Loan</a></li>
			<li><a href="#">Credit Card</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Help</a></li>
			<li class="last"><a href="#">Register</a></li>
		</ul>
		<img src="${pageContext.request.contextPath}/images/bigpicture.jpg" alt="" width="892" height="303" />
	</div>
	<div id="content">
			
		<br/> <h2 align="center">PENDING APPROVAL CUSTOMER LIST:</h2>  <br/>
		
		<ff:form name="pendingApprovalForm" method="post" action="approvePendingCustomers" commandName="approvePendingCustomerCommand" >
		<table align="center" id="tab1">
		<thead>
			<tr>
				<td><b>SNO</b></td>	<td><b>Customer Name</b></td>	 <td><b>Email ID</b></td>	<td><b>Mobile No.</b></td>
				<td><b>Photo</b></td>		<td><b>Approve</b> &nbsp; <input type="checkbox" onchange="checkAll()" id="checkAll" value="All"/>(All) </td>
			</tr>
		</thead>
		<tbody>
			
				<c:forEach items="${pendingCustomerList}" var="item" varStatus="myIndex">		
					<tr>
		    			<td>${myIndex.count}</td>
		    			<td>${item.firstName} ${item.middleName} ${item.lastName}</td>
		    			<td>${item.email}</td>
		    			<td>${item.mobile}</td>
		    			<td>${photo}</td>
		    			<td><input type="checkbox" class="chkbox" value="${item.userId}"/>  </td>
		    		</tr>
				</c:forEach>
				
		</tbody>
		
		</table>	
			
		<input type="submit"  value="Approve"/>
				
		</ff:form>	
			
			
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