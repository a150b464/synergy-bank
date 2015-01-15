<%@ page import="java.sql.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%ResultSet resultset =null;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.titlePage}</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer-validations.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/updateLoginPwdvalidations.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/tinycarousel.css" type="text/css" media="screen"/>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.tinycarousel.js"></script>
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet"
     href="${pageContext.request.contextPath}/css/BeatPicker.css" type="text/css" media="all"/>
<link rel="stylesheet"
     href="${pageContext.request.contextPath}/css/jquery-ui.css" />
<%-- <link rel="stylesheet"
     href="${pageContext.request.contextPath}/css/jquery.ui.theme.css" /> --%>
     <link rel="stylesheet"
     href="${pageContext.request.contextPath}/css/datePickerStyle.css" type="text/css" media="all"/>	
	
<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" /> -->
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/customer-validations.js"></script> --%>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script> --%>
<script type="text/javascript"
     src="${pageContext.request.contextPath}/js/BeatPicker.js"></script>
<script type="text/javascript">
 $(document).ready(function() {
	 $("#dob").datepicker({
         dateFormat: 'yy-mm-dd',
         showOn: 'button',
         buttonImage: "${pageContext.request.contextPath}/images/datePickerPopup.gif",
         buttonImageOnly: true,
         showOtherMonths : true,
         selectOtherMonths : true,
         changeYear:true,
         yearRange: "c-50:c+0",
         showWeek: false
    }).next('button').text('').button({
       text: true
    });
 });	 
</script>	 
</head>
<body>
	<div>	<img src="${pageContext.request.contextPath}/images/bank_logo.jpg" alt="" width="192" height="63" />
		<img src="${pageContext.request.contextPath}/images/eligibility.jpeg" alt="" width="892" height="280" />
		
	</div>
	<br><br><br><br><br><br><br><br>

      
      
      <form action="${pageContext.request.contextPath}/eligibility">
      
            <table border="1" width="100%" height="400">
            <tr>
           		 <td colspan="2" style="background-color:#00A9FF;color:black">&nbsp;
           		 	
           		 </td>  
             </tr> 
            <tr>
           		 <td><b>Where do you live currently: </b></td>  
           		 <td>
           		 	<select name="live">
           		 	     <option>Fremont</option>
           		 	     <option>Sunnywale</option>
           		 	     <option>San Francisco</option>
           		 	     <option>San Jose</option>
           		 	     <option>Los Angeles</option>
           		 	</select>
           		 </td>
           		 <td></td>
             </tr>
             
             <tr>
           		 <td><b>When did you move to current city </b></td>  
           		 <td>
           		 	<select name="move">
           		 	     <option>Before 2010</option>
           		 	     <option>Before 2012</option>
           		 	     <option>Before 2014</option>
           		 	     <option>Just moved</option>
           		 	     
           		 	</select>
           		 </td>
           		 <td></td>
             </tr>
             
             <tr>
           		 <td><b>Residence Type </b></td>  
           		 <td>
           		 	<select name="residence">
           		 	     <option>Self-Owned</option>
           		 	     <option>Rented</option>
           		 	     <option>Sub-leased</option>
           		 	  </select>
           		 </td>
           		 <td></td>
             </tr>
              <tr>
						<td><b>Date of Birth:</b></td>
						<td><input name="dob" id ="dob" size="8"/></td>
 
					</tr>
             <tr>
           		 <td><b>Type of Employment </b></td>  
           		 <td>
           		 	<select name="employment">
           		 	     <option>Salaried-Full time employment</option>
           		 	     <option>Part time employment</option>
           		 	     <option>Student</option>
           		 	  </select>
           		 </td>
           		 <td></td>
             </tr>
          
             <tr>
						<td><b>Joining Date with Current Employer</b></td>
						<td><input name="jdate" id ="dob" size="8"/></td>
 
					</tr>
             <tr>
           		 <td><b> Monthly Take home Salary</b></td>  
           		 <td><input type="text" name="salary"/></td>
           		 <td></td>
             </tr> 
             <tr>
           		 <td><b> Total EMI you currently pay per month (if any)</b></td>  
           		 <td><input type="text" name="emi"/></td>
           		 <td></td>
             </tr> 
             <tr>
             <td><b> Is your Salary deposited into Synergistic Bank Account</b> </td>
             <td><b>Yes: </b><input type="radio" name="price" value="yes">   
             <b>No: </b> <input type="radio" name="price" value="no">    
      	
      			</td>
      </tr>
      <tr>
           		 <td></td>  
           		 <td><input type="button" value="Check for Eligibility" style="background-color:pink; font-size: 14px"></font></td>
           		 <td></td>
             </tr>
      </table>
      </form>
      
</body>
</html>
	
	
	
	<div id="content" style="width: 100%">
			<form name="customerHome" action="${pageContext.request.contextPath}/bank/auth" method="post" > 
				<table align=center width="60%" border="0" cellspacing="20" cellpadding="20" background = "${pageContext.request.contextPath}/images/table-background.jpg" >
			 	 <br/>	
			
			 
				<h3 style="color: blue">${applicationMessage}</h3>
		</table>
			
	</form> 
		<br/>

		<br/><br/>
		<div id="blocks">																																																																																																																													
			
		</div>
		<div id="info">
			<div>
				<img src="${pageContext.request.contextPath}/images/title5.gif" alt="" width="160" height="26" />
				<%-- <img src="${pageContext.request.contextPath}/images/jobseekers.jpg" alt="" width="160" height="160"/> --%>
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/images/title6.gif" alt="" width="160" height="26" />
					<%-- <img src="${pageContext.request.contextPath}/images/careerbuilder.jpg" alt="" width="160" height="160"/> --%>
				
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/images/title7.gif" alt="" width="160" height="26" />
				<%-- <img src="${pageContext.request.contextPath}/images/marketyour.jpg" alt="" width="160" height="160"/> --%>
				
			</div>
			<div>
				<img src="${pageContext.request.contextPath}/images/title8.gif" alt="" width="160" height="26" />
				<!--<img src="${pageContext.request.contextPath}/images/partner-site.jpg" alt="" width="160" height="160"/>-->
				
			</div>
			<br/>
			<br><br>
			<%@ include file="../common/footer.jsp" %>
		</div>
		
	</div>

</body>
</html>
