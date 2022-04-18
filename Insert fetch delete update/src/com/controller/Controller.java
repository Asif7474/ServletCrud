package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.Bean;
import com.Dao.Dao;
import com.Dao.Daoimplement;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bean bean=new Bean();
		String id=request.getParameter("id");
		bean.setId(id);
		Dao d=new Daoimplement();
		d.delete(bean);
		response.sendRedirect("index.jsp"); 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bean bean=new Bean();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String surname=request.getParameter("surname");
		String btn=request.getParameter("submit");
		System.out.println(btn);
		
		bean.setId(id);
		bean.setName(name);
		bean.setSurname(surname);
		
		Dao d=new Daoimplement();
		if(btn.equals("save")) {
			d.insert(bean);
		}
		else if(btn.equals("update")) {
			d.update(bean);
			}
				response.sendRedirect("index.jsp");
	
	}

}