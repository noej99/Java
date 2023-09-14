
public class rice extends Menu {
	int spicyLevel;

	public rice() {
		// TODO Auto-generated constructor stub
	}

	public rice(String name, int price, int spicyLevel) {
		super(name, price);
		this.spicyLevel = spicyLevel;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(spicyLevel);
	}
}
