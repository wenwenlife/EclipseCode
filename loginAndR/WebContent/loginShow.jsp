<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<span style="color:red;font-size: 18px;">
  <%if(request.getAttribute("err")!=null){
	  out.println(request.getAttribute("err")+"<br/>");
  }  %>
</span>
<form method="post" action="loginin">
 账号: <input type="text" name="text" value=""/><br/>
 密码: <input type="password" name="password" value=""/><br/>
 <input type="submit" value="登录"/>
 自动登录:<input type="checkbox" name="auto">
 <a href="register.jsp"><input type="button" value="注册"/></a>
 </form>
</body>
</html>