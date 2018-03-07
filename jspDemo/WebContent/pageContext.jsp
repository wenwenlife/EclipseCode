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
 pageContext.setAttribute("page","page");
 request.setAttribute("request", "request");
 pageContext.setAttribute("session","session", pageContext.SESSION_SCOPE);
out.println("page范围内的值"+pageContext.getAttribute("page",pageContext.PAGE_SCOPE));
out.println("request范围内的值"+pageContext.getAttribute("request",pageContext.REQUEST_SCOPE));
out.println("session范围内的值"+pageContext.getAttribute("session",pageContext.SESSION_SCOPE));
%>
</body>
</html>