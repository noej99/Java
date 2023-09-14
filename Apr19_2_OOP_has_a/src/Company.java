
public class Company {
	String name;
	int employeeCount;
	Human ceo;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String name, int worker, Human ceo) {
		super();
		this.name = name;
		this.employeeCount = worker;
		this.ceo = ceo;
	}
	
	public void info() {
		System.out.println(name);
		System.out.println(employeeCount);
		ceo.info();
	}
}
