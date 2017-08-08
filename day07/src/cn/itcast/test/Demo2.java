package cn.itcast.test;
import java.util.Arrays;
public class Demo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] arr=new int[]{10,20,30,40};
		int idx=Arrays.binarySearch(arr,30);
		System.out.println(Arrays.toString(arr));
	}

}
