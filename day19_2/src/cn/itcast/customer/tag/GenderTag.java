package cn.itcast.customer.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class GenderTag extends SimpleTagSupport {
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer buff = new StringBuffer();
		if ("男".equals(gender)) {
			buff.append("<input type='radio' name='gender' value='男'>");
		}
	}

}
