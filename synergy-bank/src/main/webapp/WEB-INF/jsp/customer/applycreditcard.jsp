<%@ taglib uri="http://www.springframework.org/tags/form" prefix="adi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.titlePage}</title>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
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
<body style="background-color:white;">
	
     			<a href="index.html" class="logo"><img src="${pageContext.request.contextPath}/images/clogo.jpg" alt="setalpm" width="40" height="40" /></a>
		<span class="slogan">&nbsp;<font color="green" size ="5"><b>&nbsp;&nbsp; Synergy Bank</b></font></span>
		<ul id="menu">
			<li><a href="${pageContext.request.contextPath}/bank/customerHome">Home</a></li>
			<li><a href="${pageContext.request.contextPath}/bank/addpayee.do">Add Payee</a></li>
			<li><a href="${pageContext.request.contextPath}/loan/loanForm.do">Loans</a></li>
			<li><a href="${pageContext.request.contextPath}/bank/selectPayee">Fund Transfer</a></li>
			<li><a href="${pageContext.request.contextPath}/bank/accountSummary">Account Summary</a></li>
			<li><a href="#">Accounts</a></li></ul>
			
		
		
		<br></br>
		<br></br>
		<br></br>
		<br></br>

		
	
<div><marquee behavior="scroll" direction="left" scrollamount="15">
<img src="${pageContext.request.contextPath}/images/ab.png" />
<img src="${pageContext.request.contextPath}/images/provogue.jpg"/>
<img src="${pageContext.request.contextPath}/images/syn.png"/>
<img src="${pageContext.request.contextPath}/images/golf.jpg"/>
</marquee></div>
<br></br>
		
			<h2><b>Please Fill In your Details</b></h2>
		
		<br></br>
		
	<div id="content" style="padding-left: 0px">
       <adi:form action="${pageContext.request.contextPath}/bank/apply" method="post" commandName="applycredit" enctype="multipart/form-data">
      <table align="center" width="147%" border="0" cellspacing="8" cellpadding="8"
					background="${pageContext.request.contextPath}/images/table-background.jpg">
            
           
            <tr>
						<td><b>Salutation:</b></td>
						<td><adi:select path="salutation" width="20">
								<adi:option value="Mr">Mr.</adi:option>
								<adi:option value="Mrs">Mrs.</adi:option>
								<adi:option value="Miss">Miss.</adi:option>
								<adi:option value="Mast">Mast.</adi:option>
							</adi:select></td>
					</tr>
					<tr>
						<td><b>First Name:</b></td>
						<td><adi:input path="firstName" size="60" /></td>
					</tr>
					<tr>
						<td><b>Middle Name:</b></td>
						<td><adi:input path="middleName" size="60" /></td>
					</tr>
					<tr>
						<td><b>Last Name:</b></td>
						<td><adi:input path="lastName" size="60" /></td>
					</tr>
					<tr>
						<td><b>Gender:</b></td>
						<td><p>
								<adi:select path="gender" width="20">
									<adi:option value="Male">Male</adi:option>
									<adi:option value="Female">Female</adi:option>
									<adi:option value="UnKnown">Unknown</adi:option>
								</adi:select>
							</p></td>
					</tr>
					<tr>
						<td><b>Marital Status:</b></td>
						<td><p>
								<adi:select path="maritalStatus" width="20">
									<adi:option value="Single">Single</adi:option>
									<adi:option value="Married">Married</adi:option>
										<adi:option value="Divorced">Divorced</adi:option>
									</adi:select>
							</p></td>
					</tr>
					<tr>
						<td><b>Date of Birth:</b></td>
						<td><adi:input path="dob" id ="dob" size="15"/></td>
 
					</tr>
					<tr>
						<td><b>Category:</b></td>

						<td><adi:select path="category" width="20">
								<adi:option value="GEN">GEN</adi:option>
								<adi:option value="OBC">OBC</adi:option>
								<adi:option value="Others">Others</adi:option>
							</adi:select></td>
					</tr>
					<tr>
						<td><b>Mother's Maiden Name:</b></td>
						<td><adi:input path="motherMaidenName" size="60" /></td>
					</tr>
					<tr>
						<td><b>Father's Name:</b></td>
						<td><adi:input path="fatherName" size="60" /></td>
					</tr>
					<tr>
						<td><b>Email:*</b></td>
						<td><adi:input path="email" size="60" /> <span
							id="emailerror"></span></td>
					</tr>
					<tr>
						<td><b>Mobile:</b></td>
						<td><adi:input path="mobile" size="60" /> <span
							id="phoneerror"></span></td>
					</tr>
					<tr>
						<td><b>SSN:</b></td>
						<td><adi:input path="ssn" size="60" /></td>
					</tr>
					<tr>
						<td><b>Occupation:</b></td>
						<td><adi:input path="occupation" size="60" /></td>
					</tr>
					<tr>
						<td><b>Company Name:</b></td>

						<td><adi:select path="company" width="20">
								<adi:option value="Govt">Govt</adi:option>
								<adi:option value="Private">Private</adi:option>
								<adi:option value="SemiGovt">SemiGovt</adi:option>
							</adi:select></td>
					</tr>
					
					
					
					<tr>
						<td><b>Education:</b></td>

						<td><adi:select path="education" width="20">
								
								<adi:option value="school CBSE">School CBSE</adi:option>
								<adi:option value="Graduate">Graduate</adi:option>
								<adi:option value="Post-Graduate">Post-Graduate</adi:option>
								<adi:option value="PHD">PHD</adi:option>
							</adi:select></td>
					</tr>
					<tr>
						<td><b>Gross Anual Income:</b></td>
						<td><adi:input path="grossAnualIncome" size="60" /></td>
					</tr>
					<tr>
						<td><b>Source of Funds:</b></td>
						<td><adi:input path="sourceOfFunds" size="60" /></td>
					</tr>

					<tr>
						<td><b>Photo:</b></td>
						<td><adi:input path="photo" type="file" value="Upload File" />
						</td>
					</tr>
					

			 
            <%--  <tr>
           		 <td colspan="3" style="background-color:#00A9FF">&nbsp;  
           		 <a href="${pageContext.request.contextPath}/frogs.do"><img alt="" src="${pageContext.request.contextPath}/froglogo.jpg" width="40">Show all Frogs</a>
           		 </td>
             </tr>  --%>
             <tr>
						<td><input type="submit" value="register" /></td>
					</tr>
				</table>
             
             
                      
      </adi:form>
     
			<br /> <br /> <br />

			<div id="blocks"></div>

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
	</div>
	<%@ include file="../common/footer.jsp"%>
            
            
       
</body>
</html>
