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
		//��ȡ����
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.println("���֣�"+name);
		System.out.println("���䣺"+age);
		//���ݲ���
		req.setAttribute("name", name);
		req.setAttribute("age", age);
		//��תҳ��     forwardת��
		req.getRequestDispatcher("goto.jsp").forward(req, resp);
		
	}
	

}
