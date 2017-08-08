package cn.itcast.zq;

//装饰类与被装饰类要实现同一个接口，有一个被装饰类的引用，对方法进行增强
public class Demo2 {

}

interface Car {
	void run();
}

class Bmw implements Car {
	public void run() {

	}
}

class Benz implements Car {
	public void run() {

	}
}

class CarDerector implements Car {
	public Car car;

	public CarDerector(Car car) {
		this.car = car;
	}

	public void run() {
		car.run();
	}
}