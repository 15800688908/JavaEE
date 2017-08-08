<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List" %>
     <%@page import="java.util.ArrayList" %>
      <%@page import="java.util.Map" %>
     <%@page import="java.util.HashMap" %>
      <%@page import="cn.itcast.vo.User2" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setAttribute("name","meimei"); 
pageContext.setAttribute("name","meimei");%>
${requestScope.name }


<%String[] arrs={"meimei","bobo","dongdong"}; 
request.setAttribute("arrs",arrs);%>
${arrs[0] }


<%List<String> list=new ArrayList<String>(); 
list.add("meimei");
request.setAttribute("list",list);
%>
${list[1] }

<%Map<String,String> map=new HashMap<String,String>();
map.put("aa.bb","meme");
map.put("cc","neieni");
request.setAttribute("map",map);
%>
${map["aa.bb"] }
${map.cc }

<%List<User2> uList=new ArrayList<User2>(); 
uList.add(new User2("meimei","123"));
request.setAttribute("uList",uList);

%>
${uList[0].username }
</body>
</html>