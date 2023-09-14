// member variable : 객체의 속성
//		초기값 있음
//			숫자계열 : 0
//			참조형 : null
// method parameter : 그 메소드 수행하는데 필요한 재료
//		초기값 없음 ->호출할때 어차피 넣음
// local variable : 그 메소드 수행하는 동안만 쓰고 버리는 임시 변수
//		초기값 없음 -> 초기화 하고 써야
public class Calculator {
	int price; // int price = 5000; -> 초기값 주는걸 쓰레기 코드라고 함
	
	public void printSum(int x, int y) {
		// int a;   에러
		// System.out.println(a);
		int sum = x + y;
		System.out.println(sum);
	}
}
