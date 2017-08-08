package cn.itcast.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeServlet extends HttpServlet {

	/**
	 * 在内存中生成图片，没有设置背景颜色，画填充的矩形
	 * 并且和纸的大小相同，矩形有颜色
	 * 获取笔的对象（设置颜色，设置字体，画字符串，画矩形）
	 * 先准备好数据，随机生成四个字符，把字符画到纸上
	 * 画干扰线
	 * 输出到客户端
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width=120;
		int height=30;
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g=(Graphics2D)image.getGraphics();
		g.setColor(Color.GRAY);
		//画填充矩形
		g.fillRect(0, 0, width, height);
		//设置颜色
		g.setColor(Color.YELLOW);
		//画边框
		g.drawRect(0, 0, width-1, height-1);
		//准备数据，随机获取四个字符
		String words="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		//生成的验证码存入到session中
		StringBuffer sb=new StringBuffer();
		g.setColor(Color.YELLOW);
		g.setFont(new Font("隶书",Font.BOLD,20));
		Random random=new Random();
		//void rotate(double theta,double x,double y);
		//jiaodu*pi/180
		
		int x=20;
		int y=20;
		for(int i=0;i<4;i++){
			//获取下标
			int jiaodu=random.nextInt(60)-30;
			double hudu=jiaodu*Math.PI/180;
			g.rotate(hudu,x,y);
			int index=random.nextInt(words.length());
			//返回指定下标位置的字符，随机获取下标
			char ch=words.charAt(index);
			//添加字符
			sb.append(ch);
			g.drawString(""+ch, 80, 80);
			g.rotate(-hudu,x,y);
			x+=20;
		}
		//存入session
		request.getSession().setAttribute("sessionCode", sb.toString());
		g.setColor(Color.BLUE);
		int x1,y1,x2,y2;
		for(int i=0;i<4;i++){
			x1=random.nextInt(width);
			y1=random.nextInt(height);
			x2=random.nextInt(width);
			y2=random.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		
		
		ImageIO.write(image,"jpg",response.getOutputStream());
		
		
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
public static void main(String[] args) {
	//常用汉字
	System.out.println("\u9fa5");
}
}
