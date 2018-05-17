package com.asjy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asjy.model.User;
import com.asjy.service.IUserService;
import com.asjy.service.impl.UserServiceImpl;

@WebServlet("/DoAddUser")
public class DoAddUserServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取参数
		String username = req.getParameter("username");
		String usercname = req.getParameter("usercname");
		String password = req.getParameter("password");
		String password02 = req.getParameter("password02");
		User user = new User();
		user.setPassword(password);
		user.setUsercname(usercname);
		user.setUsername(username);
		IUserService userService = new UserServiceImpl();
		userService.add(user);
		List<User> list_user = userService.findAll();
		req.setAttribute("list_user", list_user);
		//跳转添加页
		req.getRequestDispatcher("showuser.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}
