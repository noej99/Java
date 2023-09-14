
public class LikeFirst extends Menu{
	// 멤버변수(메뉴명, 가격) 상속됨
	double alcohol;
	
	public LikeFirst() {
		// TODO Auto-generated constructor stub
	}

	public LikeFirst(String name, int price, double alcohol) {
		super(name, price);
		this.alcohol = alcohol;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(alcohol);
	}
}
