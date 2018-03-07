<%@ page language="java" import="java.util.*,java.sql.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
            //加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取与数据库的连接
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/day01", "root","123");
			// 建立搬运工Statement
			Statement statement = connection.createStatement();
			// sql语句
			String sql = "SELECT *FROM student";
			// 执行sql语句
			ResultSet executeQuery = statement.executeQuery(sql);
%>

<%
            //遍历打印查询到的结果
			while (executeQuery.next()) 
			{%>

				<tr>
			    <td><%=executeQuery.getInt(1)%> </td>
			    <td><%=executeQuery.getString(2)%> </td>
			    <td><%=executeQuery.getInt(3)%> </td>
			    <td><%=executeQuery.getDouble(4)%> </td>
			    <td><%=executeQuery.getString(5)%> </td>
				</tr>
				
			<%} %>
</body>
</html>