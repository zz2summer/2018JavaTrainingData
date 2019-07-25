package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import beans.*;

public class user extends SuperServlet {

	/**
	 * Constructor of the object.
	 */
	public user() {
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
	 * 根据用户不同的请求进行不同的回应
	 */
	public void toRequest(HttpServletRequest request, HttpServletResponse response){
		try{
			
		if(request.getParameter("requestType").equals("addBasket")){
			
			addBasket(request,response);
		}else if(request.getParameter("requestType").equals("insertBasket")){
			
			insertBasket(request,response);
		}else if(request.getParameter("requestType").equals("payBook")){
			
			payBook(request,response);
		}else if(request.getParameter("requestType").equals("showBasket")){
			
			showBasket(request,response);
		}else if(request.getParameter("requestType").equals("deleteBook")){
			
			deleteBook(request,response);
		}
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 在购物车中删除一本书.
	 * @param request
	 * @param response
	 */
	public void deleteBook(HttpServletRequest request, HttpServletResponse response){
		
			String id  =request.getParameter("bookId");
			BasketDAO bDAO = new BasketDAO();
			bDAO.deleteBasket(id);
			showBasket(request,response);
		
	}
	/**
	 * 用户结帐时对数据库进行相应的操作
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void payBook(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		HttpSession session = request.getSession();
		String userName = ((User)session.getAttribute("userInfo")).getName();
		BasketDAO bDAO = new BasketDAO();
		Basket basket = new Basket();
		BookDAO bookDAO = new BookDAO();
		ArrayList al = bDAO.querryBasket(userName);
		Iterator iter= al.iterator();
		TradeRecordDAO trDAO = new TradeRecordDAO();
		int userId = ((User)(session.getAttribute("userInfo"))).getId();
		int bookId;
		int tradeNum;
		double sum;
		while(iter.hasNext()){
			
			basket = (Basket)iter.next();
			bookId = basket.getBookId();
			tradeNum = basket.getNumber();
			sum = basket.getTotalPrice();
			TradeRecord td = new TradeRecord();
			td.setBookId(bookId);
			td.setUserId(userId);
			td.setSum(sum);
			td.setTradeNum(tradeNum);
			trDAO.insertRecord(td);
			bookDAO.updateNum(bookId, tradeNum);
		}
		bDAO.deleteBasket("");
		
		response.sendRedirect("/BookShop/servlet/Index?requestType=homePage");
		
	}
	/**
	 * 显示用户购物车中的内容
	 * @param request
	 * @param response
	 */
	public void showBasket(HttpServletRequest request, HttpServletResponse response){
		
		
		BasketDAO bDAO = new BasketDAO();
		HttpSession session = request.getSession();
		String userName = ((User)session.getAttribute("userInfo")).getName();
		ArrayList al = bDAO.querryBasket(userName);
		Iterator iter = al.iterator();
		try{
			
		request.setAttribute("basket", al);
		request.getRequestDispatcher("../userView/basket.jsp").forward(request, response);
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	/**
	 * 用户加入购物车后对数据库的操作
	 * @param request
	 * @param response
	 */
	public void insertBasket(HttpServletRequest request, HttpServletResponse response){
		
		try{
			float num = Integer.parseInt(request.getParameter("number"));
			float unitPrice=Float.parseFloat(request.getParameter("unitPrice"));
		HttpSession session = request.getSession();
		String userName = ((User)session.getAttribute("userInfo")).getName();
		Basket basket = new Basket();
		basket.setBookId(Integer.parseInt(request.getParameter("bookId")));
		basket.setUserName(userName);
		basket.setName(request.getParameter("bookName"));
		basket.setNumber(Integer.parseInt(request.getParameter("number")));
		basket.setUnitPrice(Float.parseFloat(request.getParameter("unitPrice")));
		basket.setTotalPrice(num*unitPrice);
		Calendar calendar =Calendar.getInstance();
		Date date = new Date(calendar.get(Calendar.YEAR)-1900,calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE));
		basket.setAddDate(date);
		BasketDAO bDAO = new BasketDAO();
		bDAO.insertBasket(basket);
		showBasket(request,response);
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 响应用户加入购物车请求,并到相应的页面接受购买参数
	 * @param request
	 * @param response
	 */
	public void addBasket(HttpServletRequest request, HttpServletResponse response){
		
		try{
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookDAO bookdao = new BookDAO();
		Book book = bookdao.querryUseId(bookId);
		request.setAttribute("addBook", book);
		request.getRequestDispatcher("../userView/addBasket.jsp").forward(request, response);
		}catch(Exception e){
			
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
