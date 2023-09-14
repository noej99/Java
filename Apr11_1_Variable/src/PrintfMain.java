// printf에서만 %기능사용가능

public class PrintfMain {
	public static void main(String[] args) {
		
		String name = "김밥천국";
		// %s : String값 들어올 자리
		System.out.printf("이름 : %s\n", name);

		int tableCount = 10;
		// %d : 정수값 들어올 자리 decimal(10진수)
		// %05d : 정수값 들어올 자리(5자리로 빈자리 0)
		System.out.printf("테이블수 : %d\n", tableCount);
		System.out.printf("테이블수 : %05d\n", tableCount);

		double star = 4.51555234;
		// %f : 실수값 들어올 자리 float
		// %.3f : 실수값 들어올 자리(소수점 이하 3자리로 반올림)
		System.out.printf("별점 : %f\n", star);
		System.out.printf("별점 : %.1f\n", star);

		boolean reservation = true; 
		// %b
		// 예약가능
		// 꽉 참
		System.out.printf("예약가능 : %b\n", reservation); // 안씀
		
		System.out.printf("%s, %d자리\n", name, tableCount);
		
		System.out.println("%");
		System.out.printf("%%");
	}
}