package com.asjy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget");
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost");
		//获取参数
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.println("名字："+name);
		System.out.println("年龄："+age);
		//传递参数
		req.setAttribute("name", name);
		req.setAttribute("age", age);
		//跳转页面     forward转发
		req.getRequestDispatcher("goto.jsp").forward(req, resp);
		
	}
	

}
