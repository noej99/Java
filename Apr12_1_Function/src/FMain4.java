import java.util.Scanner;
// 키 : 함수 -> recursive
// 이름
//	비만도 검사

//	공부 방법
//			1) 저게 뭔데 강사가 저기다 써놓았는가 : 파악
//			2) 지우고 다시(1번의 판단을 본인이 다시)
//			3) 추가 , 문제 내보기

public class FMain4 {
	//								결과 나올게 없어서 : void
	//	통일성
	public static String getName() {
		Scanner k = new Scanner(System.in);
		System.out.print("이름 : ");
		return k.next();
	}
	
	
	public static void main(String[] args) {
		Scanner w = new Scanner(System.in); // 키보드 입력 받을준비

		System.out.print("이름 : ");
		String name = w.next(); // 이름 입력받기

		System.out.print("키 : ");
		double height = w.nextDouble(); // 키 입력받기

		System.out.print("몸무게 : ");
		double weight = w.nextDouble(); // 몸무게 입력받기

		System.out.println("------------------------");

		double a = (height - 100) * 0.9; // 표준체중계산
		double b = (weight / a) * 100; // 비만도 계산

		String result = (b > 120) ? "비만" : "정상"; // 비만도가 120초과시 비만

		System.out.printf("표준체중 : %s\n", a);
		System.out.printf("비만도 : %.1f%%\n", b);
		System.out.printf("%s씨는 %s\n", name, result);

		System.out.print("종료하려면 뭐라도 써");
		String s = w.next();

	}

}
