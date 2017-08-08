<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=request.getParameter("username") %>
<%int a=10;
if(a>=10){
}else if(a<10){
}else{out.print("other");}%>


<c:set var="i" value="10" scope="page"></c:set>
<c:choose>

<c:when test="${i ge 10}">
i>=10
</c:when>
<c:when test="${i lt 10}">
i<10
</c:when>
<c:otherwise>
otherwise
</c:otherwise>
</c:choose>
</body>
</html>