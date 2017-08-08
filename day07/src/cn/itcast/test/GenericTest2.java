package cn.itcast.test;

import java.util.Arrays;

public class GenericTest2 {
	public void run1() {
		Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
		change(arr, 1, 3);
		System.out.println(Arrays.toString(arr));

//		String[] strarr = new String[] { "aa", "bb", "cc", "dd" };
//		change(arr, 1, 3);
//		System.out.println(Arrays.toString(strarr));
	}

//	public void change(int[] arr, int idx1, int idx2) {
//		int temp = arr[idx1];
//		arr[idx1] = arr[idx2];
//		arr[idx2] = temp;
//	}
//
//	public void change(String[] strarr, int idx1, int idx2) {
//		String temp = strarr[idx1];
//		strarr[idx1] = strarr[idx2];
//		strarr[idx2] = temp;
//	}
	public <T> void change(T[] strarr, int idx1, int idx2){
		T temp = strarr[idx1];
		strarr[idx1] = strarr[idx2];
		strarr[idx2] = temp;
	}
	public void run2(){
		String[] strarr = new String[] { "aa", "bb", "cc", "dd" };
		reset(strarr);
	}
	public <T> void reset(T[] arr){
		for(int i=0;i<arr.length/2;i++){
			T temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
	}
}
