// 멤버 변수 없음 -> 저장할게 없음
// -> 굳이 객체만들게 해놓으면
// -> stack영역을 괜히 쓰게 되니

// => static메소드 기반으로
public class Calculator {

	public static void printSum(int a, int b) {
		System.out.println(a + b);
	}
}
