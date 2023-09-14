
public class OMain2 {
	public static void main(String[] args) {
		Milk m = new Milk("서울우유", 3000, "2023/04/20");
		m.printInfo();
		System.out.println("------------");
		Computer c = new Computer("매직스테이션", 700000, "i7-1234", 16, 500);
		c.printInfo();
		System.out.println("------------");
		Laptop l = new Laptop("그램1234", 1500000, "i5-1233", 16, 250, 5);
		l.printInfo();
	}
}
