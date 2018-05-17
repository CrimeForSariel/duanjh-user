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

@WebServlet("/ShowUser")
public class ShowUserServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IUserService userService = new UserServiceImpl();
		List<User> list_user = userService.findAll();
		System.out.println(list_user.size());
		req.setAttribute("list_user", list_user);
		req.getRequestDispatcher("showuser.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}
