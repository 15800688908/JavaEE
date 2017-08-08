<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function run(){
	var username=document.form1.username.value;
	if(username==""||username.length==0){
	alert("yonghumingcuowu");
	return false;
	}
	var password=document.form1.password.value;
	if(password==""||password.length<6){
	alert("yonghumingcuowu");
	return false;
	}
	var repassword=document.form1.repassword.value;
	if(repassword==""||repassword!=password){
	alert("yonghumingcuowu");
	return false;
	}
	var nickname=document.form1.nickname.value;
	if(nickname==""||nickname.length<0){
	alert("yonghumingcuowu");
	return false;
	}
	var email=document.form1.email.value;
	//正則匹配
	if(email==""||email.length<0){
	alert("yonghumingcuowu");
	return false;
	}
	}
</script>
</head>
<body>
<!-- return false 防止#，因為href最后执行 -->
<font color="red">${requestScope.msg }</font>
<form name="form1" action="${pageContext.request.contextPath }/reg"method="POST" onsubmit="return run()">
<table border="1" width="60%">
<tr><td>用户名</td><td><input type="text" name="username"/></td></tr>
<tr><td>密码</td><td><input type="password" name="password"/></td></tr>
<tr><td>确认密码</td><td><input type="password" name="repassword"/></td></tr>
<tr><td>昵称</td><td><input type="text" name="nickname"/></td></tr>
<tr><td>邮箱</td><td><input type="text" name="email"/></td></tr>
<tr><td>验证码</td><td><input type="text" name="code"/>
<a href="#" onclick="show();return false;"><img alt="" id="imgId" src="${pageContext.request.contextPath }/checkcode"/></a>
</td></tr>
<tr><td colspan="2"><input type="submit" value="注册"/></td></tr>
</table>
</form>
</body>
<script type="text/javascript">
function show(){
var image=document.getElementById("imgId");
image.sr="${pageContext.request.contextPaht}/checkcode"+new Date().getTime();
}
</script>
</html>