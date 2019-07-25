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

import beans.*;
import dao.*;
/**
 * 
 * @author Cute code
 *
 */
public class Admin extends SuperServlet {

	/**
	 * Constructor of the object.
	 */
	public Admin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	/**
	 * ʵ�ָ���ķ���,��������ͬ��ҵ������
	 */
	public void toRequest(HttpServletRequest request, HttpServletResponse response){
		
		
		if(request.getParameter("requestType").equals("adminLogin")){
			this.setAdmin(request, response);
		}
		if(request.getParameter("requestType").equals("deleteBook")){
			System.out.println(request.getParameter("requestType"));
			System.out.println(request.getParameter("ID"));
			this.deleteBook(request, response);
		}
		
		if(request.getParameter("requestType").equals("sales")){
			this.setAttribute(request, response);
		}
		
		if(request.getParameter("requestType").equals("addCategory")) {
			this.addCategory(request,response);
		}
		if(request.getParameter("requestType").equals("modifyCategory")) {
			this.modifyCategory(request,response);
		}
		
		if(request.getParameter("requestType").equals("addBook")) {
	 		this.addBook(request, response);
		}
		if(request.getParameter("requestType").equals("modifyBook")) {
	 		this.modifyBook(request, response);
		}
		if(request.getParameter("requestType").equals("logout")){
			
			this.logout(request, response);
		}
		if(request.getParameter("requestType").equals("query")) {
			this.query(request, response);
		}
		if (request.getParameter("requestType").equals("delete")) {

			deleteCategory(request, response);
			
		}
	}
	
	/**
	 * ����Ա�˳�ʱ��ռ�¼
	 * @param request
	 * @param response
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		session.invalidate();
		try{
			response.sendRedirect("/BookShop/index.jsp");
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	/**
	 * �����޸�һ����Ļ�����Ϣ
	 * @param request
	 * @param response
	 */
public void modifyBook(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");	
		int categoryId =Integer.parseInt(request.getParameter("categoryId"));
		float price = Float.parseFloat(request.getParameter("price"));		
		String author = request.getParameter("author");
		String bookman = request.getParameter("bookman");
		int onSaleNum =Integer.parseInt(request.getParameter("onSaleNum"));
		int remainNum =Integer.parseInt(request.getParameter("remainNum"));
		Date onSaleDate = Date.valueOf(request.getParameter("onSaleDate"));
		String introduction = request.getParameter("introduction");
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookDAO bookdao = new BookDAO();
		Book book = bookdao.querryUseId(bookId);
		
		book.setName(name);
		book.setAuthor(author);
		book.setBookman(bookman);
		book.setOnSaleNum(onSaleNum);
		book.setRemainNum(remainNum);
		book.setPrice(price);
		book.setCategoryId(categoryId);
		book.setIntroduction(introduction);
		book.setOnSaleDate(onSaleDate);		
			
		bookdao.update(book);
		
		try{		
			response.sendRedirect("/BookShop/managerView/bookInfoManage.jsp");
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	/**
	 * ��������һ����
	 * @param request
	 * @param response
	 */
	public void addBook(HttpServletRequest request, HttpServletResponse response) {
		
		//��JSP�����л����Ϣ
		String name = request.getParameter("name");	
		int categoryId =Integer.parseInt(request.getParameter("categoryId"));
		float price = Float.parseFloat(request.getParameter("price"));		
		String author = request.getParameter("author");
		String bookman = request.getParameter("bookman");
		int onSaleNum =Integer.parseInt(request.getParameter("onSaleNum"));
		int remainNum =Integer.parseInt(request.getParameter("remainNum"));
		Date onSaleDate = Date.valueOf(request.getParameter("onSaleDate"));
		String introduction = request.getParameter("introduction");
		
		BookDAO bookdao = new BookDAO();		
		Book book = new Book();
		book.setId(0);		
		book.setName(name);
		book.setAuthor(author);
		book.setBookman(bookman);
		book.setOnSaleNum(onSaleNum);
		book.setRemainNum(remainNum);
		book.setPrice(price);
		book.setCategoryId(categoryId);
		book.setIntroduction(introduction);
		book.setOnSaleDate(onSaleDate);		
		
		bookdao.insert(book);		
		
		try{		
			response.sendRedirect("/BookShop/managerView/bookInfoManage.jsp");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ����Ա��½ʱ���ڶ���ݵ���֤
	 * @param request
	 * @param response
	 */
	public void setAdmin(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		//��JSP�����л����Ϣ
		String name = request.getParameter("name");
		String password = request.getParameter("password");	
		//����userDAO��ʵ��
		UserDAO userdao = new UserDAO();

		//�жϹ���Ա�ʺ���Ϣ 
		try{
			if(userdao.adminTest(name, password)){
				User user = new User();
				user.setName(name);
				user.setPass(password);
				session.setAttribute("userInfo",user);
			request.getRequestDispatcher("../managerView/adminMain.jsp").forward(request,response);
			
		}
		else{
			request.getRequestDispatcher("../managerView/adminLogin.jsp").forward(request,response);
			
		}
		}catch(IOException e){
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �����ݿ���ȡ�����ۼ�¼
	 * @param request
	 * @param response
	 */
	public void setAttribute(HttpServletRequest request,
			HttpServletResponse response) {
		ArrayList records;
		TradeRecordDAO trdao = new TradeRecordDAO();
		records = trdao.querryRecord();
		request.setAttribute("records", records);

		try {
			request.getRequestDispatcher("../managerView/salesInfo.jsp").forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �����޸�һ��ͼ�������Ϣ
	 * @param request
	 * @param response
	 */
	public void modifyCategory(HttpServletRequest request, HttpServletResponse response) {
		String categoryName = request.getParameter("categoryName");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		BookCategoryDAO bcdao = new BookCategoryDAO();
		
		BookCategory bc = bcdao.querryUseName(categoryName);		
		BookCategory bcNew = bcdao.querry(categoryId);
		bcNew.setName(categoryName);
		
		bcdao.update(bcNew);
		
		try {
			response.sendRedirect("../managerView/categoryManage.jsp");
		} catch(Exception e) {
			e.printStackTrace();			
		}
	}
	
	/**
	 * ��������һ��ͼ�������Ϣ
	 * @param request
	 * @param response
	 */
	public void addCategory(HttpServletRequest request, HttpServletResponse response) {
		String categoryName = request.getParameter("categoryName");
			
		BookCategoryDAO bcdao = new BookCategoryDAO();		 
		BookCategory bc = bcdao.querryUseName(categoryName);
		
		
		if(bc.getName()==null) {
			bc=new BookCategory();
			bc.setName(categoryName);
			bcdao.insert(bc);
		}
		try {
			response.sendRedirect("../managerView/categoryManage.jsp");
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * ���������ݿ�������һ����
	 * @param request
	 * @param response
	 */
	public void setBook(HttpServletRequest request, HttpServletResponse response) {
		
		//��JSP�����л����Ϣ
		String name = request.getParameter("name");
	
		int categoryId =Integer.parseInt("categoryId");
		float price = Float.parseFloat(request.getParameter("price"));
		
		String author = request.getParameter("author");
		String bookman = request.getParameter("bookman");
		int onSaleNum =Integer.parseInt(request.getParameter("onSaleNum"));
		int remainNum =Integer.parseInt(request.getParameter("remainNum"));
		Date onSaleDate = Date.valueOf(request.getParameter("onSaleDate"));
		String introduction = request.getParameter("introduction");
		//
		Book book = new Book();
		//
		book.setName(name);
		book.setAuthor(author);
		book.setBookman(bookman);
		book.setOnSaleNum(onSaleNum);
		book.setRemainNum(remainNum);
		book.setPrice(price);
		book.setCategoryId(categoryId);
		book.setIntroduction(introduction);
		book.setOnSaleDate(onSaleDate);
	
		//
		BookDAO bookdao = new BookDAO();
		try{
			bookdao.insert(book);
			response.sendRedirect("/BookShop/managerView/bookInfoManage.jsp");
		}catch(IOException e){
			e.printStackTrace();
		}
}
	
	/**
	 * ����ɾ�����ݿ���һ����
	 * @param request
	 * @param response
	 */
	public void deleteBook(HttpServletRequest request, HttpServletResponse response){
		int  id = Integer.valueOf((String) request.getParameter("ID")).intValue();
		BookDAO bdao = new BookDAO();
		bdao.delete(id);
		try {
			request.getRequestDispatcher("../managerView/bookInfoManage.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	/**
	 * ���ڲ�ѯһ�������ϸ��Ϣ
	 * @param request
	 * @param response
	 */
	private void query(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
		int id = Integer.valueOf(request.getParameter("ID")).intValue();
		
		BookDAO bookDAO = new BookDAO();
		Book book= (Book)bookDAO.querryUseId(id);
		BookCategoryDAO bcdao = new BookCategoryDAO();
		BookCategory bc = bcdao.querry(book.getCategoryId());

		request.setAttribute("categoryName", bc.getName());
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("../managerView/infor.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/**
	 * ����ɾ��һ��ͼ�����
	 * @param request
	 * @param response
	 */
	public void deleteCategory(HttpServletRequest request,
			HttpServletResponse response){
		String id = request.getParameter("categoryId");
		BookDAO bdao = new BookDAO();
		BookCategoryDAO bcdao = new BookCategoryDAO();
		bdao.delete(Integer.valueOf(id).intValue());
		bcdao.delete(Integer.valueOf(id).intValue());
		try {
			request.getRequestDispatcher("../managerView/categoryManage.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
