package cn.itcast.customer.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import cn.itcast.customer.domain.PageBean;

public class PageTag extends SimpleTagSupport {
	private PageBean pb;

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer buffer = new StringBuffer();
		int totalPage = pb.getTotalPage();
		int pageNum = pb.getPageNum();
		if (pageNum >= 5) {

		} else {

		}
		// 进行分页时候的显示多少问题
		for (int i = 0; i < totalPage; i++) {
			if (i + 1 == pb.getPageNum())
				buffer.append("<a href='?pageNum=" + (i + 1) + "&currentPage="
						+ pb.getCurrentPage() + "'><font color='green>"
						+ (i + 1) + "</font></a>");
		}
		this.getJspContext().getOut().write(buffer.toString());
	}

}
