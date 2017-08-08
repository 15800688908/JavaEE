package cn.itcast.enumtest;

public class Demo2 {
	public void run1(){
		Love girl=Love.GIRL;
		System.out.println(girl.name());
		System.out.println(girl.ordinal());
	}
	public void run2(){
		String name="READ";
		Love read=Enum.valueOf(Love.class,name);
		System.out.println(read.ordinal());
		
		Love read2=Love.valueOf(name);
		Love[] loves=Love.values();
		Love code=loves[2];
		String str=code.name();
	}
}
enum Love{
	GIRL,READ,CODING;
}