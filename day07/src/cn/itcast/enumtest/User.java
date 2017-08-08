package cn.itcast.enumtest;

public class User {
	private int id;
	private String name;
	private int role;
	private Role2 role2;
	private Role3 role3;
	public void run() {
		User user = new User();
		user.id = 1;
		user.name = "meimei";
		//user.role = Role.BOSS;
		user.role3=Role3.BOSS;
	}
}

enum Role3{
	BOSS,HR,WORKER;
}
class Role2{
	private Role2(){}
	public static final Role2 BOSS=new Role2();
	public static final Role2 HR=new Role2();
	public static final Role2 WORKER=new Role2();
}
class Role{
	public static final int BOSS=0;
	public static final int HR=1;
	public static final int WORKER=2;
	
}