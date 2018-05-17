<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="com.asjy.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="AddUser">添加</a>
<table>
	<tr>
		<th>编号</th>
		<th>账号</th>
		<th>名称</th>
		<th>密码</th>
		<th>注册时间</th>
		<th>操作</th>
	</tr>
	<% List<User> list_user = (List<User>) request.getAttribute("list_user"); %>
		<% if(list_user != null && list_user.size() > 0){
			for(User user : list_user){
				
		%>
			<tr>
				<td><%=user.getId() %></td>
				<td><%=user.getUsername() %></td>
				<td><%=user.getUsercname() %></td>
				<td><%=user.getPassword() %></td>
				<td><%=user.getAddtime() %></td>
				<td>编辑 删除</td>
			</tr>
	<%}
			
		}%>
</table>
</body>
</html>