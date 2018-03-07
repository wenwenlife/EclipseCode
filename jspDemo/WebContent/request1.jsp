<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//获取所有请求头名字
Enumeration<String> headNames=request.getHeaderNames();
 while(headNames.hasMoreElements()){
	 String headername =headNames.nextElement();
	 //获取每个请求及其对应值
	 out.println(headername+"==="+request.getHeader(headername)+"<br/>");
 }
 out.println("<hr/>");
 
 //设置解码方式
  request.setCharacterEncoding("UTF-8");
 //依次获取表单域的值
  String name= request.getParameter("name");
 String gender =request.getParameter("gender");
 //如果某个请求参数有多个值,则采取下面方法获得
 String[] color =request.getParameterValues("color");
 String national =request.getParameter("country");
%>
<!-- 依次输出表单域的值 -->
您的名字 :<%=name%><hr/>
你的性别 :<%=gender%><hr/>
你喜欢的颜色:<% for(String colors:color){
	 out.println(colors+" ");}%><hr/>
你来自的国家:<%=national%><hr/>

</body>
</html>