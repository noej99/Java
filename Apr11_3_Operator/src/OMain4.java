import java.util.Scanner;

// 한국어로 설계 - 번역(개발)-> 			.java
// .java				 -번역(compile)->	.class
// .class			 -압축->					.jar(Java ARchive

// 실행 : cmd 가서
//			java  -jar 파일명
//		실행 편하게 하려면 .bat파일 만들어주면 됨
// AI
//
public class OMain4 {
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
