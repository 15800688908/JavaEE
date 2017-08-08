package cn.itcast.JUnitTest;

import org.junit.Assert;
import org.junit.Test;

public class Demo1 {
	public int add(int x, int y) {
		return x + y;
	}

	@Test
	public void test() {
		int sum = add(4, 5);
		Assert.assertEquals(9, sum);

	}
}
