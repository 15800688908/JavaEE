<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.itcast.myfn/1110" prefix="myfn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload="run()">
<%//URLDecoder解码
//编写自定义的EL函数
//${myfn:decode(cookie.username.value)}
%>
${fn:split(cookie.username.value,"-")[0] }
<form action="${pageContext.request.contextPath }/login">
输入姓名：<input type="text" id="nameId" name="${cookie.username.value }"/></br> 
输入密码：<input type="password" name="password"/></br> 
<input type="checkbox" name="remember" value="remember"/>
<input type="submit" value="denglu"/> 

</form>
</body>
<script type="text/javascript">
function run(){
var str="${cookie.username.vlaue}";
var newstr=username.decodeURI(str);
document.getElementById("nameId").value=newstr;
}
</script>
</html>