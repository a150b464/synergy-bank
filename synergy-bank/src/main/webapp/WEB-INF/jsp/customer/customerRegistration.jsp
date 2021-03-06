<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<body>
	<img src="${pageContext.request.contextPath}/images/bank_logo.jpg"
		alt="" width="192" height="63" />
	<img
		src="${pageContext.request.contextPath}/images/registrationPic.png"
		alt="" width="892" height="280" />
	<div id="left_section">
		<div class="title">
			<b>Welcome to Customer Registration</b>
		</div>
		<div class="text_content">
			<br /> <br />
			<marquee> <img src="${pageContext.request.contextPath}/images/bank_logo.jpg" alt="" />
			<b>The Worlds Local Bank!</b> </marquee>
		</div>

		<div id="content" style="padding-left: 0px">

			<h2 style="color: blue">${msg}</h2>
			<ff:form name="customerRegistration"
				action="${pageContext.request.contextPath}/bank/customerRegistration"
				method="post" commandName="customerForm"  enctype="multipart/form-data">
				<table align="center" width="147%" border="0" cellspacing="8" cellpadding="8"
					background="${pageContext.request.contextPath}/images/table-background.jpg">


					<tr>
						<td><b>Salutation:</b></td>
						<td><ff:select path="salutation" width="20">
								<ff:option value="Mr">Mr.</ff:option>
								<ff:option value="Mrs">Mrs.</ff:option>
								<ff:option value="Miss">Miss.</ff:option>
								<ff:option value="Mast">Mast.</ff:option>
							</ff:select></td>
					</tr>
					<tr>
						<td><b>First Name:</b></td>
						<td><ff:input path="firstName" size="60" /></td>
					</tr>
					<tr>
						<td><b>Middle Name:</b></td>
						<td><ff:input path="middleName" size="60" /></td>
					</tr>
					<tr>
						<td><b>Last Name:</b></td>
						<td><ff:input path="lastName" size="60" /></td>
					</tr>
					<tr>
						<td><b>Gender:</b></td>
						<td><p>
								<ff:select path="gender" width="20">
									<ff:option value="Male">Male</ff:option>
									<ff:option value="Female">Female</ff:option>
									<ff:option value="Event">Event</ff:option>
								</ff:select>
							</p></td>
					</tr>
					<tr>
						<td><b>Marital Status:</b></td>
						<td><p>
								<ff:select path="maritalStatus" width="20">
									<ff:option value="Single">Single</ff:option>
									<ff:option value="Married">Married</ff:option>
									<ff:option value="Divorced">Divorced</ff:option>
								</ff:select>
							</p></td>
					</tr>
					<tr>
						<td><b>Date of Birth:</b></td>
						<td><ff:input path="dob" id ="dob" size="8"/></td>
 
					</tr>
					<tr>
						<td><b>Category:</b></td>

						<td><ff:select path="category" width="20">
								<ff:option value="GEN">GEN</ff:option>
								<ff:option value="OBC">OBC</ff:option>
								<ff:option value="Others">Others</ff:option>
							</ff:select></td>
					</tr>
					<tr>
						<td><b>Mother's Maiden Name:</b></td>
						<td><ff:input path="motherMaidenName" size="60" /></td>
					</tr>
					<tr>
						<td><b>Father's Name:</b></td>
						<td><ff:input path="fatherName" size="60" /></td>
					</tr>
					<tr>
						<td><b>Email:*</b></td>
						<td><ff:input path="email" size="60" /> <span
							id="emailerror"></span></td>
					</tr>
					<tr>
						<td><b>Mobile:</b></td>
						<td><ff:input path="mobile" size="60" /> <span
							id="phoneerror"></span></td>
					</tr>
					<tr>
						<td><b>SSN:</b></td>
						<td><ff:input path="ssn" size="60" /></td>
					</tr>
					<tr>
						<td><b>Occupation:</b></td>
						<td><ff:input path="occupation" size="60" /></td>
					</tr>
					<tr>
						<td><b>Occupation Type:</b></td>
						<td><ff:input path="occupationType" size="60" /></td>
					</tr>
					<tr>
						<td><b>Education:</b></td>
						<td><ff:input path="education" size="60" /></td>
					</tr>
					<tr>
						<td><b>Gross Anual Income:</b></td>
						<td><ff:input path="grossAnualIncome" size="60" /></td>
					</tr>
					<tr>
						<td><b>Source of Funds:</b></td>
						<td><ff:input path="sourceOfFunds" size="60" /></td>
					</tr>

					<tr>
						<td><b>Photo:</b></td>
						<td><ff:input path="photo" type="file" value="Upload File" />
						</td>
					</tr>

					<c:forEach var="questionEnity" items="${customerForm.questionList}"
						varStatus="i">
						<tr>
							<td><b>${questionEnity.description}</b></td>
							<td><ff:input type="input"
									name="customerForm.questionList[${i.index}].answer"
									path="questionList[${i.index}].answer" size="60" /> 
								<ff:input
									type="hidden"
									name="customerForm.questionList[${i.index}].questionId"
									path="questionList[${i.index}].questionId" size="60" /> 
								<ff:input
									type="hidden"
									name="customerForm.questionList[${i.index}].description"
									path="questionList[${i.index}].description" size="60" /> 
						</tr>
					</c:forEach>


					<tr>
						<td><b>Description:</b></td>
						<td><ff:input path="description" size="60" /></td>
	
					</tr>
					<tr>
						<td><input type="submit" value="register" /></td>
					</tr>
				</table>

			</ff:form>

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
