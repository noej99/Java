import java.util.Scanner;

//	조건문
//			if	-	else if	-	else
//			switch	-	case

public class CSMain5 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("나이 : ");
		int age = k.nextInt();
		System.out.println("-----------------");
		System.out.println(age);
		
//		switch (대상) {
//		case valueA(값):
//						대상이 값 A면 할 일 
//			break;
//		case valueB(값):
//						대상이 값 B면 할 일 
//			break;
//				...
//			break;
//
//		default:
//				위에 해당하는 값이 없을 때 할 일		
//			break;
		
		//	가독성이 이상
		//	조건식 못 씀
		//	=>	if문보다 하위호환같은데..
		switch (age) {
		case 80:
			System.out.println("어서오십시오 어르신");
			//	break;
		case 20:
			System.out.println("어서와요");
			break;

		default:
			System.out.println("가");
			break;
		}
		}
	}

