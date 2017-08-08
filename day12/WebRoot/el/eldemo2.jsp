<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setAttribute("n1",10);
request.setAttribute("n2",20);
%>
${n1+n2 }
${n1>n2 }   ${n1 gt n2 }
${n1<n2 }   ${n1 lt n2 }
${n1==n2 }   ${n1 eq n2 }
${n1!=n2 }   ${n1 ne n2 }
${n1>=n2 }   ${n1 ge n2 }
${n1<=n2 }   ${n1 le n2 }

${n1>n2 &&n3>n4 }   ${n1>n2 and n3>n4 }
${n1>n2 || n3>n4 }   ${n1>n2 or n3>n4 }
${!(n1>n2)}   ${ not (n1>n2)}
</body>
</html>