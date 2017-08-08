<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'success.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
function del(id){
var flag=window.confirm("sure?");
if(flag){
location.href="${pageContext.request.contextPath}/delById?id="+id;

}
function change(){
var main=document.getElementById("main");
var flag=main.checked;
var cks=document.getElementByName("ck");
for(var i=0;i<cks.length;i++){
cks[i].checked=flag;
}
}


function sendDel(){
 document.getElementById("f").submit();
 var cks=document.getElementByName("ck");
 var url="${}/delSelect?";
for(var i=0;i<cks.length;i++){
if(cks[i].checked){
	var id=cks[i].value;
	url+="id="+id+"&";
}
}
}
</script>
	</head>

	<body>
		<c:if test="${empty cs}">
    无客户信息
    </c:if>
		<c:if test="${not empty cs}">
			<table>
				<tr>
					<td></td>
				</tr>
			</table>
		</c:if>
		<c:forEach items="${cs}" var="c">
			<td>
				${c.id}
			</td>
			<tr>
				<a href="${pageContext.request.contextPath }/delByid?id=${c.id }"></a>
			</tr>
			<td>
				<a href=""></a>
			</td>
			<a href="javascript:void(0)" onclick="del('${c.id }')"></a>
		</c:forEach>

		<c:if test="${c.gender=='男'}">
			<input type="radio" name="gender" value="男" checked="checked">
		</c:if>
		<a href="" /del href="javascript:void(0)" onclick="sendDel();">删除选中</a>
		<a href="" /add></a>

		<form id="f">
			<td>
				<input type="checkbox" id="main" onclick="change();">
			<td name="checkbox" name="ck" value="${c.id }"></td>
		</form>

		<div>
			<form action="${ }/simpleSelect">
				<select name="s">
					<option>
						select
					</option>
					<option value="name">
						name
					</option>
					<option value="sex">
						sex
					</option>
				</select>
				<input type="text" name="msg">
				<input type="submit" value="search">
			</form>
		</div>
	</body>
</html>
