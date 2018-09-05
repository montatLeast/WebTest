package com.webtest.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PersonalService;
import miaodiyun.IndustrySMS;

/**
 * Servlet implementation class VerifyServlet
 */
@WebServlet("/VerifyServlet")
public class VerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyServlet() {
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
		response.setContentType("text/html;chatset=UTF-8");  
		response.setCharacterEncoding("utf-8");  

		PersonalService pService = new PersonalService();
		
        String name=request.getParameter("name");//获取ajax传过来的值  
        PrintWriter out = response.getWriter();  
        
        System.out.println("name=="+name+"\n");  
        
        String phoneNumber = pService.getPhoneNumber(name);
        System.out.println("phonenumber=="+phoneNumber+"\n");
        
		int x=9999;
		int y=1000;
		int num=(int)(Math.random() * (x - y + 1) + y); //生成的随机数
		IndustrySMS.execute(phoneNumber,""+num); //传入参数为String
		request.getSession().setAttribute("verifycode", num);
		System.out.println("num=="+num+"\n");  
		out.write(""+num);//参数应为String，否则出现乱码
        out.flush();  
        out.close();  
	}

}
