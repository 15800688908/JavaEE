<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
      <%@ page import="cn.itcast.vo.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String[] arrs={"meimei","xiaofeng","furong"};
request.setAttribute("arrs",arrs);
%>
<!-- for(String s:arrs) -->
<c:forEach var="s" items="${arrs}">
${s }
</c:forEach>

<%List<String> list=new ArrayList<String>();
list.add("meimei");
request.setAttribute("list",list);
%>
<c:forEach var="s" item="${list}">
${s }
</c:forEach>

<%Map<String,String> map=new HashMap<String,String>();
map.put("aa","meimei");
request.setAttribute("map",map);
%>
<c:forEach var="entry" item="${map}">
${entry.key }---${entry.value }
</c:forEach>

<%List<User> uList=new ArrayList<User>();
uList.add(new User("meimei","123"));
request.setAttribute("uList",uList);

%>
<c:forEach var="user" items="${uList}">
${user.username }----${user.password }
</c:forEach>


<c:forEach   var="i" begin="1" end="10" step="1">
${i }
</c:forEach>

<c:set var="sum" value="0" scope="page"></c:set>
<c:forEach var="i" begin="1" end="100" step="1" varStatus="status">
<c:set var="sum" value="${sum+i}"></c:set>
</c:forEach>
${sum }


<c:forEach var="i" begin="10" end="100" step="2" varStatus="status">

<c:choose>
<c:when test="${status.first}">
<font color="blue">${i }</font>
</c:when>
<c:when test="${status.count%3 eq 0}">
<font color="red">${i }</font>
</c:when>
<c:otherwise>${i }</c:otherwise>
</c:choose>
</c:forEach>
</body>
</html>