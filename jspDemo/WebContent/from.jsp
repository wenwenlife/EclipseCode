<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form id="form1" method="post" action="request1.jsp" >
    用户名:
    <input type="text" name="name"/><br>
 性别:
    男:<input type="radio" name="gender" value="男"/>   
    女:<input type="radio" name="gender" value="女"/><br/>
喜欢的颜色:
    红色:<input type="checkbox" name="color" value="红色"/>   
    黄色:<input type="checkbox" name="color" value="黄色"/>   
    蓝色:<input type="checkbox" name="color" value="蓝色"/>   <br>
来自的国家:
    <select name="country">
       <option>中国</option>
       <option>巴基斯坦</option>
       <option>美国</option>
    </select>  
    <input type="submit" value="提交"/> 
    <input type="reset" value="重置"/> 
   </form>
</body>
</html>