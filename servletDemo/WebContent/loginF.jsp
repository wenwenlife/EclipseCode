<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>
<span style="color:red;font-size: 18px;">
  <%if(request.getAttribute("err")!=null){
	  out.println(request.getAttribute("err")+"<br/>");
  }  %>
  
请输入用户名和密码:
<form method="post" action="login">
 用户名:<input type="text" name="username"/><br/>
密&nbsp;&nbsp;码<input type="password" name="pass"/>
<input type="submit" value="登录"/>
</form>
</body>
</html>