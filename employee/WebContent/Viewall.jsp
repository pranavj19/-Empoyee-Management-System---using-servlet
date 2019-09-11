
<%@page import="com.Employee.model.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2px">
<tr>
<th>Empid</th>
<th>Name</th>
<th>Dob</th>
<th>sal</th>
</tr>

<c:forEach items="${list}" var="emp">
<tbody><tr>
 <td>${emp.empId}</td>
     <td>${emp.name}</td>
     <td>${emp.dob}</td>
     <td>${emp.salary}</td>
</tr>
</tbody>
</c:forEach>

</table>

 


</form>

</body>
</html>