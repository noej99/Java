// 노트북 is a 상품
// 노트북 is a 컴퓨터
// 다단상속
public class Laptop extends Computer {
	double weight;

	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	public Laptop(String name, int price, String cpu, int ram, int hdd, double weight) {
		super(name, price, cpu, ram, hdd);
		this.weight = weight;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(weight);
	}
}
