package cn.itcast.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagDemo1 extends SimpleTagSupport{
	private PageContext pc;
	@Override
	public void doTag() throws JspException, IOException {
		pc.getOut().write("hello");
	}
	/**
	 * 服务器默认先执行该方法
	 */
	@Override
	public void setJspContext(JspContext pc) {
		this.pc=(PageContext)pc;
		
	}

}
