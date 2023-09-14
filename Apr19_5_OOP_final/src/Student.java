
public class Student extends Human {
	String school;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, String school) {
		super(name, age);
		this.school = school;
	}

	@Override
	public void introduce() {
		// TODO Auto-generated method stub
		super.introduce();
		System.out.println(school);
	}

}
