package com.webtest.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PersonalInfo;
import bean.PersonalService;
import dao.JdbcLink;
import miaodiyun.IndustrySMS;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String usr ;
	Connection conn;
	String ide;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String method = request.getParameter("method");
    	
    	if("login".equals(method)){
		// TODO Auto-generated method stub
		usr = request.getParameter("username");
		String verify = request.getParameter("verification");
		boolean isValid = false;
		try{
		conn = new JdbcLink().getConn();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from person where account = "+"'"+usr+"'");
		if(rs.next())//查询语句
		{
			isValid = true;
		}	
		System.out.println(isValid);
		if(isValid){
			request.getSession().setAttribute("account",usr); 
			System.out.println(usr);
			//根据用户身份选择跳转
			response.sendRedirect("index.jsp");	
		}
		else{
			response.sendRedirect("login.html");	
		}
		}catch(SQLException e){e.printStackTrace();
		}
	}
	
	 if("alter".equals(method)){
		PersonalService pser = new PersonalService();
		String name = request.getParameter("name");
		String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
		String school = new String(request.getParameter("school").getBytes("iso-8859-1"),"utf-8");
		String major = new String(request.getParameter("major").getBytes("iso-8859-1"),"utf-8");
		String className  = new String(request.getParameter("className").getBytes("iso-8859-1"),"utf-8");	
		
		PersonalInfo pi = new PersonalInfo();
		pi.setUsername(usr);
		pi.setName(name);
		pi.setSex(sex);
		pi.setSchool(school);
		pi.setMajor(major);
		pi.setClassName(className);
		
		if(pser.updateInfo(pi)) {
			response.sendRedirect("index.jsp");
		}
			
	}
	
	if("alterphoto".equals(method)) {
		PersonalService pser = new PersonalService();
		String photoPath = request.getParameter("photopath");
		if(pser.updatePhoto(usr,photoPath)) {
			response.sendRedirect("index.jsp");
		}
	}
	
	}
}
