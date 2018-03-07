<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<span style="color:red;font-size: 17px;">
  <%if(request.getAttribute("err")!=null){
	  out.println(request.getAttribute("err")+"<br/>");
  }  %>
</span>
<form method="post" action="registerin">
姓名:&nbsp;<input type="text" name="username" value=""/><br/>
密码:&nbsp;<input type="password" name="password1" value=""/><br/>
确认密码:&nbsp;<input type="password" name="password2" value=""/><br/>
Email:&nbsp;<input type="text" name="email" value=""/><br/>
生日:&nbsp;<input type="text" name="birthday" value=""/><br/>
  <input type="submit" value="提交">
</form>
</body>
</html>