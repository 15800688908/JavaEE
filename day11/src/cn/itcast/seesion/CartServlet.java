package cn.itcast.seesion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {

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
		/**
		 * 购物车Map<String,Integer> cart 把购物车存入session
		 * 先获取购物车，判断是否是第一次访问，
		 * 如果是，创建购物车，把商品名称和数量加入购物车，存入session
		 * 如果不是，通过名称判断是否包含该商品
		 * 如果包含，数量加1存入session
		 * 如果不包含，直接存入购物车存入session
		 * 继续购物或结算
		 */
	String id=request.getParameter("id");
	String[] names={"手電筒","冰箱","電視","洗衣機","電腦"};
	//把ID翻译成名称
	int idx=Integer.parseInt(id);
	String name=names[idx-1];
	//从session中获取购物车
	HttpSession session=request.getSession();
	Map<String,Integer> cart=(Map<String,Integer>)session.getAttribute("cart");
	if(cart==null){
		cart =new HashMap<String,Integer>();
		cart.put(name, 1);
		session.setAttribute("cart", cart);
	}else{
		if(cart.containsKey(name)){
			Integer count=cart.get(name);
			count++;
			cart.put("cart",count );
			session.setAttribute("cart", cart);
		}else{
			cart.put(name, 1);
			session.setAttribute("cart", cart);
		}
	}
	response.setContentType("text/html;charset=utf-8");
	response.getWriter().write("<h2><a href='/day11/session/cartList.jsp'>继续购物</a>|<a href='/day11/session/pay.jsp'>结算</a></h2>");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
