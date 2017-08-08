package cn.itcast.JUnitTest;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitTest {
	@BeforeClass
	public static void beforeClass(){
		//类似与缓存
		System.out.println("beforeClass...");
	}
	@Before
	public void before(){
		System.out.println("before ....");
	}
	@Test
	public void eat() {
		System.out.println("eat ....");
	}
	@Ignore
	public void run() {
		System.out.println("run ....");
	}
	@After
	public void after(){
		System.out.println("after ....");
	}
}
