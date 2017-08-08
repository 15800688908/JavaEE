<%@ page import="cn.itcast.utils.MyCookieUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.img1{
width:100px;
height:90px
}
</style>
</head>

<body>
<img  class="img1" src="/day11/img/1.jpg"><a href="/day11/product?id=1">手电筒</a>
<img  class="img1" src="/day11/img/2.jpg"><a href="/day11/product?id=2">电视</a><br>
<img  class="img1" src="/day11/img/3.jpg"><a href="/day11/product?id=3">iPhone</a>
<img class="img1" src="/day11/img/4.jpg"><a href="/day11/product?id=4">iPad</a>

<h3>浏览记录</h3>
<h3><a href="/day11/remove">清除记录</a></h3>
<%Cookie[] cookies=request.getCookies(); 
Cookie cookie=MyCookieUtil.getCookieByName(cookies,"produt");
if(cookie!=null){
String value=cookie.getValue();
String[] ids=value.split(",");
for(String id:ids){
%>
<img  class="img2" src="/day11/img/<%=id %>.jpg">
<% }
}

%>
</body>
</html>