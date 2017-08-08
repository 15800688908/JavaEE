<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cn.itcast.vo.User" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int a=10;
pageContext.setAttribute("name","10",pageContext.REQUEST_SCOPE);

%>
<%
User user=new User();
user.setUsername("meimei");
user.setPassword("123");
request.setAttribute("user",user);
%>
${user.username }
<c:set var="i" value="10" scope="request"></c:set>
${i }

<c:set target="${user}" property="username" value="xiaofeng"></c:set>
${user.username }
</body>
</html>