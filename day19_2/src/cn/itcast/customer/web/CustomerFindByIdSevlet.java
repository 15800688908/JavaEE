package cn.itcast.customer.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.customer.domain.Customer;
import cn.itcast.customer.service.CustomerService;

public class CustomerFindByIdSevlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");

		String id = req.getParameter("id");
		CustomerService service = new CustomerService();
		try {
			Customer c = service.findById(id);
			req.setAttribute("c", c);
			req.getRequestDispatcher("/customer.jsp").forward(req, resp);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("modify fail");
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
