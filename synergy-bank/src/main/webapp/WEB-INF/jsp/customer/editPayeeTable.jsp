<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="r"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<r:form action="${pageContext.request.contextPath}/bank/updatePayee" method = "post" commandName="EditPayeeForm" enctype="multipart/form-data">
<%-- <input type = "hidden" value = "${EditPayeeForm.userid}" name = "imageid"> --%>
<%-- User ID: <input type = "text" value = "${EditPayeeForm.userid}" name = "userid" readonly="readonly"><br>
Payee Account No: <input type = "text" value = "${EditPayeeForm.payeeAccountNo}" name = "payeeAccountNo"><br> --%>
Payee Name: <input type = "text" value = "${EditPayeeForm.payeeName}" name = "payeeName"><br>
Payee Nick Name: <input type = "text" value = "${EditPayeeForm.payeeNickName}" name = "payeeNickName"><br>
Mobile: <input type = "text" value = "${EditPayeeForm.mobile}" name = "mobile"><br>
<%-- Date and Time: <input type = "text" value = "${EditPayeeForm.doe}" name = "doe"><br>
Email: <input type = "text" value = "${EditPayeeForm.email}" name = "email"><br>
Status: <input type = "text" value = "${EditPayeeForm.status}" name = "status"><br> --%>
Photo: <input type = "file" name = "photo"><br>


<input type = "submit" name = "Update">

</r:form>

</body>
</html>