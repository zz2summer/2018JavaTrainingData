package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

	public abstract class SuperServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SuperServlet() {
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
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request,response);
	}

	/**
	 * 
	 *�����û�����,���ж��Ƿ�Ϊ�Ϸ��û�,��Ϊ�Ϸ��û������û�����
	 * 
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo")==null&&(!request.getParameter("requestType").equals("adminLogin"))){
			
			request.getRequestDispatcher("../userView/login.jsp").forward(request,response);
		}else{
		toRequest(request,response);
		}
			
	}
	
	/**
	 * ������,����ʵ�����������������ҵ��
	 * @param request
	 * @param response
	 */
	public abstract void toRequest(HttpServletRequest request, HttpServletResponse response);
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
