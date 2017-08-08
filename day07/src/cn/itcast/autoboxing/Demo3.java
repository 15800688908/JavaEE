package cn.itcast.autoboxing;

public class Demo3 {
	public int sum(int a, int b) {
		return a + b;
	}
	//可变参数
	public int add(int ...nums){
		int sum=0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
		}
		return sum;
	}
}
