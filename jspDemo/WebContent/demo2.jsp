<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<%
  Date date =new Date();
  out.println(date);
%>

<% 
for(int i=0;i<10;i++){ 
%>
  <tr>
  <td>i的值</td>
  <td><%=i %></td>
  <%} %>
  </tr>
</body>
</html>