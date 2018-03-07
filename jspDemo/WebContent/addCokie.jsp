<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
  String name ="name";
  Cookie c=new Cookie("userName",name);
  c.setMaxAge(24*60*60);
  response.addCookie(c);
  request.getRequestDispatcher("readCookie.jsp").forward(request, response);
  %>
</body>
</html>