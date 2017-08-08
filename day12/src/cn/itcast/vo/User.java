package cn.itcast.vo;

import java.util.Date;

public class User {
private String username;
private String password;
private double money;
private Date birthday;
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public double getMoney() {
	return money;
}
public void setMoney(double money) {
	this.money = money;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getInfo(){
	return "";
}
}
