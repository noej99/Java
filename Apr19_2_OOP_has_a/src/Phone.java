
public class Phone {
	String name;
	int price;
	Company maker;
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}

	public Phone(String name, int price, Company madeBy) {
		super();
		this.name = name;
		this.price = price;
		this.maker = madeBy;
	}
	
	public void info() {
		System.out.println(name);
		System.out.println(price);
		maker.info();
	}
}
