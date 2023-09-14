// 기존의 Random객체는 홀+짝 다 나오니 못쓰겠다
// 랜덤한 정수(홀수만) 구하는 기능

// 키보드로 정수(짝수만) 입력받기 -> final클래스라서 상속 안됨(String도 final클래스)
public class TIOMain {
	public static void main(String[] args) {

		OddRandom od = new OddRandom();
		int n = od.nextInt(10);
		System.out.println(n);
		System.out.println("---------");

	}
}
