<%@page language="java" contentType="text/html; charSet=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员添加</title>
</head>
<body>
	<center>
		<h1>添加管理员</h1>
		<hr>
		<form action="<%=basePath%>/AddUserServlet" method="post" onsubmit="return validateCode()">
			<table width="300px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" placeholder="用户名为3-12位字母数字或下划线组合" pattern="[0-9_a-zA-Z]{3,12}" ></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td><input type="password" name="password" placeholder="密码长度为5-12位字母数字或下划线组合" pattern="[0-9_a-zA-Z]{5,12}" ></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="添加">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>