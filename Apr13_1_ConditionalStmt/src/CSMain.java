import java.util.Scanner;

//	조건문
//			if

public class CSMain {
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = k.nextInt();
		System.out.println("------------------------------");
		System.out.println(age);
		
		
		//	if (조건식A) {
		//			조건식A가 맞으면 할 작업
		//	} else 	if ( 조건식	B){
		//			A는 땡, B가 맞으면 할 작업
		//	} else if (조건식C) {
		//			A,B는 땡, C가 맞으면 할 작업
		//	} ...
		//	} else {
		//			위에 맞는거 하나도 없으면
		//	}
		
		//	나이가 80이상이며 어서오십시오 어르신 출력
		//	80은 안되는데, 20은 넘었으면 어서와요
		//	20은 안되지만, 10은 넘었으면 어서와
		if (age >= 80) {
			System.out.println("어서오십시오 어르신");
		} else if (age >= 20) {
			System.out.println("어서와요");
		} else if (age >=10){
			System.out.println("어서와");
		} else {
			System.out.println("나가");
		}
		
//		if (age >=80) {
//			System.out.println("어서오십시오 어르신");
//		} else {
//			if (age >= 20) {
//				System.out.println("어서와요");
//			} else { 
//				if (age >= 10 ) {
//					System.out.println("어서와");
//				}
//			}
//		}
	}
}
