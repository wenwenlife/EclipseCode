<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="getsession.jsp">
	书籍:<input type="checkbox" name="item" value="book"/>
	电脑:<input type="checkbox" name="item" value="computer"/>
	汽车:<input type="checkbox" name="item" value="car"/>
	<input type="submit" value="提交"/>
	</form>
</body>
</html>