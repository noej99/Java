
public class Human {
	
	String name;
	String address;
	Dog pet;
	Human son;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public Human(String name, String address, Human son) {
		super();
		this.name = name;
		this.address = address;
		this.son = son;
	}

	public void info() {
		System.out.println(name);
		System.out.println(address);
		if (son != null) {
			son.info();
		}
	}
}
