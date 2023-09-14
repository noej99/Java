
public class Milk extends Product {
	String expirationDate;

	public Milk() {
		// TODO Auto-generated constructor stub
	}

	public Milk(String name, int price, String expirationDate) {
		super(name, price);
		this.expirationDate = expirationDate;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(expirationDate);
	}

}
