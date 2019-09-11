<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<tr>
<td><%=session.getAttribute("empid")
%></td>
<td><%=session.getAttribute("ename")
%></td>
<td><%=session.getAttribute("Dob")
%></td>
<td><%=session.getAttribute("sal")
%></td>



</table>

</body>
</html>