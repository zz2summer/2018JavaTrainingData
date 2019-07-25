package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=GBK");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n<html>\r\n");
      book.bk cart = null;
      synchronized (_jspx_page_context) {
        cart = (book.bk) _jspx_page_context.getAttribute("cart", PageContext.PAGE_SCOPE);
        if (cart == null){
          cart = new book.bk();
          _jspx_page_context.setAttribute("cart", cart, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');

String book_id = request.getParameter("book_id");
String sql = "select book_id from orders where book_id="+book_id+" and user_name='"+session.getAttribute("username")+"'";
ResultSet rs = cart.executeQuery(sql);
int rowscount = 0;
try{
	while(rs.next()){
		rowscount++;
	}
}catch(Exception e){
	e.printStackTrace();
}
if(rowscount==0){
	String sqlBook1 = "select * from books where id = "+book_id;
	ResultSet rsBook1 = cart.executeQuery(sqlBook1);
	while(rsBook1.next()){
		String sqlCart = "insert into orders(user_name,book_id,book_number,goods_price) values ('"
	+session.getAttribute("username")+"',"+book_id+",1,"+rsBook1.getDouble("price")+")";
		cart.executeUpdate(sqlCart);
	}
}
else{
	String sqlBook2 = "select book_number from orders where book_id = "+book_id+" and user_name = '"+session.getAttribute("username")+"'";
	ResultSet rsBook2 = cart.executeQuery(sqlBook2);
	while(rsBook2.next()){
		int i = rsBook2.getInt("book_number");
		System.out.println(i);
		int count=1+rowscount;
		String sqlCart = "update orders set book_number="+count;
		System.out.println(sqlCart);
		cart.executeUpdate(sqlCart);
	}
}
response.sendRedirect("shopcart.jsp");

      out.write("\r\n<head>\r\n<title>\r\ncart\r\n</title>\r\n</head>\r\n<body bgcolor=\"#ffffff\">\r\n\r\n</body>\r\n</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
