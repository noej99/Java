// 상속 : 상위클래스의 기능 물려받고 + a 추가 
// 공식용어는 확장

// 지금은 Menu 그대로(확장안시킨) - 흔치 않은 상황
public class Water extends Menu {

	public Water() {
		// TODO Auto-generated constructor stub
	}

	public Water(String name, int price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
	}
}
