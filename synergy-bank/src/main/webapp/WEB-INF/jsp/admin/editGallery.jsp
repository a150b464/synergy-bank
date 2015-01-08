<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="r"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <%String s = request.getParameter("imageid"); %> --%>


<r:form action="${pageContext.request.contextPath}/bank/updateGallery" method = "post" commandName="EditForm" enctype="multipart/form-data">
<%-- <input type = "hidden" value = "${EditForm.imageid}" name = "imageid"> --%>
Image ID: <input type = "text" value = "${EditForm.imageid}" name = "imageid" readonly="readonly"><br>
Image: <input type = "file" name = "image"><br>
Path: <input type = "text" value = "${EditForm.path}" name = "path"><br>


<input type = "submit" name = "Update">

</r:form>
</body>
</html>