<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>pageContext向其他域中存取值</h3>
<%pageContext.setAttribute("name","meimei");
pageContext.setAttribute("name","meimei",pageContext.PAGE_SCOPE);
request.setAttribute("name","xiaofeng");
pageContext.setAttribute("name","xiaofeng",pageContext.REQUEST_SCOPE);
pageContext.setAttribute("name","xiaocang",pageContext.SESSION_SCOPE);
pageContext.setAttribute("naem","xiaofang",pageContext.APPLICATION_SCOPE);

pageContext.getAttribute("name",pageContext.APPLICATION_SCOPE);
%>
<%=session.getAttribute("name") %>
${pageScope.name }
<%=request.getParameter("username") %>
</body>
</html>