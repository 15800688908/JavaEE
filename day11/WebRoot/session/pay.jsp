<%@page import="java.util.Map" %>
<%@page import="java.util.Set" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>结算页面</h3>

<%
Map<String,Integer>cart=(Map<String,Integer>)request.getSession().getAttribute("cart");
if(cart!=null){
Set<String> keys=cart.keySet();
for(String key:keys){

%>
<h3>buy<%=key%>,<%=cart.get(key) %></h3>
<%
}
}else{
%>
<h3>please buy<a href="/day11/session/cartList.jsp"></a></h3>
<% 
}
 %>
</body>
</html>