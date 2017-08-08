<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script>
function changeCurrentPage(value){
location.href="?currentPage="+value;
}
</script>
	</head>
	<body>
		<a
			href="/day19_1/findAllByPage?PageNumber=1&currentPage=${pb.currentPage }"></a>
		<c:if test="${pb.pageNum==1 }">
		上一页
		</c:if>
		<a
			href="/day19_1/findAllByPage?PageNumber=${pb.pageNum-1}&currentPage=${pb.currentPage } "></a>
		<c:if test="${pb.totalPage}">
		下一页
		</c:if>
		<a href="/day19_1/findAllByPage?PageNumber=${pb.pageNum+1}"></a>
		<a href="/day19_1/findAllByPage?PageNumber=${pb.totalPage }"></a>

		<select name="currentPage" onchange="changeCurrentPage(this.value);">
			<option value="5">
				5
			</option>
			<option value="3">
				3
			</option>
		</select>

		<tr>
			<c:forEach begin="1" end="${pb.totalPage }" var="n" step="1">
				<c:if test="${n==pb.PageNum }"
					<a
					href="/day19_1/findAllByPage?pageNum=${n}&currentPage=${pb.currentPage } }"><font color="red">第${n
					}页</font></a></c:if>
			</c:forEach>
		</tr>
		<tr>
			<td>
				<my:page pb="${pb }" />
			</td>
		</tr>
	</body>
</html>