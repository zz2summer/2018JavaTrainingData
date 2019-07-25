package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.swing.text.html.HTMLDocument.Iterator;
import java.util.*;

import beans.*;
import dao.*;

public class Index extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Index() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		doPost(request,response);
	}
	
	/**
	 * ���ڲ�ѯ���ݿ��е�������
	 * @param request
	 * @param response
	 */
	public void querryAllBooks(HttpServletRequest request, HttpServletResponse response){
		try{
		BookDAO bdao = new BookDAO();
		ArrayList al = bdao.querryAllBooks();
		request.setAttribute("allBooks", al);
		request.getRequestDispatcher("../userView/userpage.jsp").forward(request, response);
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	/**
	 * �û���½ʱ���û���ݵ���֤
	 * @param request
	 * @param response
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) {

		
		response.setContentType("UTF-8");
		HttpSession session;
		try {
		session = request.getSession();
		String username = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String password = request.getParameter("password");

		User u = new User();
		u.setName(username);
		u.setPass(password);
		UserDAO udao = new UserDAO();
	
			request.setCharacterEncoding("UTF-8");
			
			if (udao.userTest(u)) {
				
				User userInfo = udao.querryUseName(username);
				session.setAttribute("userInfo",userInfo);
				this.querryAllBooks(request, response);
			} else {
				request.getRequestDispatcher("../userView/login.jsp").forward(
						request,response);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * ���ܲ�ͬ����������Ӧ��ͬ�Ĺ���
	 */
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		if (request.getParameter("requestType").equals("login")) {

			login(request, response);
			
		}
		
		if(request.getParameter("requestType").equals("homePage")){
			this.querryAllBooks(request, response);
		}
		if(request.getParameter("requestType").equals("left")) {
			setCateBook(request,response);
		}
		
		if(request.getParameter("requestType").equals("right")) {
			setBook(request,response);
		}
		if(request.getParameter("requestType").equals("register")){
			
			register(request, response);
		}
	}
	
	/**
	 * ��ѯͼ���������µ��屾��
	 * @param request
	 * @param response
	 */
	public void setCateBook(HttpServletRequest request, HttpServletResponse response) {
		ArrayList categoryList;
		BookCategoryDAO bcdao = new BookCategoryDAO();
		categoryList = bcdao.querryCategory();
		request.setAttribute("category", categoryList);
	
		ArrayList bookList;
		BookDAO bookdao = new BookDAO();
		bookList = bookdao.querryAllBooks();
		request.setAttribute("books", bookList);
		
		try {
			request.getRequestDispatcher("../index.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ѯ���µ�5���鲢����ʾ����
	 * @param request
	 * @param response
	 */
	public void setBook(HttpServletRequest request, HttpServletResponse response) {
		ArrayList bookList;
		BookDAO bookdao = new BookDAO();
		bookList = bookdao.querryAllBooks();
		request.setAttribute("books", bookList);
		
		try {
			request.getRequestDispatcher("../index.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ���ڴ���һ���û���ע����Ϣ,����Ϣ���뵽���ݿ�
	 * @param request
	 * @param response
	 */
	public void register(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			//request.setCharacterEncoding("UTF-8");
			//response.setCharacterEncoding("UTF-8");
		//��JSP��ȡ���û�����Ϣ
		String name = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String pass =request.getParameter("password");
		String realName =new String(request.getParameter("realname").getBytes("ISO-8859-1"),"UTF-8");
		String sex = new String(request.getParameter("gender").getBytes("ISO-8859-1"),"UTF-8");
		String ag = "0";
		int age;
		if(request.getParameter("age")==null){
			
			age = 0;
		}else{
			
			age = Integer.parseInt(request.getParameter("age"));
		}
		
		String email = new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
		String phone = request.getParameter("connectnumber");
		String address = new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
		
		//��ϵͳ�л��ע������
		Calendar cal = Calendar.getInstance();
		Date registerDate = new Date(cal.get(Calendar.YEAR) - 1900, cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
		//ǿ�������û�����Ϊ�û���
		int role = 1;
		int id = 0;
		//���û���Ϣ��װ��USER����
		User user = new User(id,name,pass,sex,age,role,realName,phone,email,address,registerDate);
		//UserDAOʵ����
		UserDAO ud = new UserDAO();
		//�ж��û����Ƿ����
			if((ud.querryUseName(name))==null){
				ud.insertUser(user);	
				response.sendRedirect("/BookShop/userView/registSuccess.jsp");
			}else{
				String alert ="���û����Ѵ���";
				if(pass == null){
					alert = "���벻��Ϊ��";
					request.setAttribute("alert", alert);
				}
				//���û�������,���û���ʾ,FORWARD��ע��ҳ��
				
				request.setAttribute("alert", alert);
				request.getRequestDispatcher("../userView/register.jsp").forward(request, response);		
			}
		}catch(IOException e){
			e.printStackTrace();
		}catch(ServletException se){
			se.printStackTrace();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
