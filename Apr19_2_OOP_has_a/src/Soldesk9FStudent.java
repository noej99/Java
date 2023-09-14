
public class Soldesk9FStudent {
	String name;
	int age;
	// 강의실올때 타는 엘리베이터
	static Elevator ev = new Elevator("현대");
	
	public Soldesk9FStudent() {
		// TODO Auto-generated constructor stub
	}

	public Soldesk9FStudent(String name, int age, Elevator ev) {
		super();
		this.name = name;
		this.age = age;
		this.ev = ev;
	}
}
