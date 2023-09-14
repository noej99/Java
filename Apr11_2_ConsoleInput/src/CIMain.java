import java.util.Scanner;

public class CIMain {
	public static void main(String[] args) {
		// 키보드 입력받을 준비해서 k에 저장
		Scanner k = new Scanner(System.in);
		System.out.print("식당이름 : ");
		String name = k.next(); // 입력한 글자 받아와서 name에 저장
		
		System.out.print("테이블 : ");
		int table = k.nextInt(); // 입력한 정수 받아와서 table에 저장
		
		// 별점
		System.out.print("별점 : ");
		double star = k.nextDouble(); // 입력한 실수 받아와서 star에 저장
		
		// 예약
		System.out.print("예약가능 : ");
		boolean reservation = k.nextBoolean(); // 입력한 true/false ..

		System.out.println("-------------");
		System.out.printf("%s, %d자리\n",name , table);
		System.out.printf("%.1f, %b\n",star , reservation);
		
	}
	
}
