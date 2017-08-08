package cn.itcast.test;

import cn.itcast.dao.StuDao;
import cn.itcast.domain.Student;

public class StuTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student stu=new Student("007","bande","tegong");
		StuDao dao=new StuDao();
		dao.addStu(stu);
	}

}
