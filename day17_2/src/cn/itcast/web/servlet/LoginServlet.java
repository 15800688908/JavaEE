package cn.itcast.web.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.itcast.exception.LoginException;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
public class LoginServlet extends HttpServlet {
//使用preparedStatement解决sql注入问题
//如果使用大数据，setBinaryStream(int,InputStream,int)
	//File file=new File("");
	//FileInputStream fis=new FileInputStream(file);
	//setBinaryStream(1,fis,file.length())
//存储大文本用setCharacterStream()
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		UserService service=new UserService();
		User existUser=null;
		try{
			existUser=service.login(user);
			if(existUser==null){
				request.setAttribute("login.message", "error username");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}else{
				request.getSession().setAttribute("user", existUser);
				response.sendRedirect(request.getContextPath()+"/success.jsp");
				return;
			}
		}catch(LoginException e){
			request.setAttribute("login.message", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
