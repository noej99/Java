// 상속
//		A is a B

// 생성자 - x
public class OMain {
	public static void main(String[] args) {

		Pen pe = new Pen();
		pe.name = "모나미123";
		pe.price = 500;
		pe.color = "검정";
		pe.printInfo();
		System.out.println("-----------");

		Milk m = new Milk();
		m.name = "서울우유";
		m.price = 3000;
		m.expirationDate = "2023/05/01";
		m.printInfo();
		System.out.println("-----------");

		Computer c = new Computer();
		c.name = "매직스테이션123";
		c.price = 700000;
		c.cpu = "i7-1234";
		c.ram = 16;
		c.hdd = 500;
		c.printInfo();
		System.out.println("-----------");

		Laptop l = new Laptop();
		l.name = "그램1234";
		l.price = 1500000;
		l.cpu = "i5-1233";
		l.ram = 16;
		l.hdd = 250;
		l.weight = 5;
		l.printInfo();

	}
}
