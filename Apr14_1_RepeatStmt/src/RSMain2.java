import java.util.Random;
import java.util.Scanner;

//	반복문 제어
//		break : 반복문 종료
//		continue : 강제 턴 종료
//		
public class RSMain2 {
	public static void main(String[] args) {
		for (int i = 1; i < 11; i++) {
			if (i % 3 == 0) {
				// break;
				continue; // 여기서 바로 for문으로 이동
			}
			System.out.println(i);
		}
		System.out.println("----------------");

		// while문 구조상 조건식 쓰기가 애매
		// 랜덤을 9가 나올때까지 계속뽑기
		Random r = new Random();
		int d;
		// do-while
		while (true) {
			d = r.nextInt(10);
			System.out.println(d);

			if (d == 9) {
				break;
			}
		}
		System.out.println("---------------");

		// 나이 계속 입력받기
		Scanner k = new Scanner(System.in);
		int age;
		while (true) { // 조건식 자리에 true넣어서 무한반복시키고 while문 작업공간에서 조건문 넣기
			System.out.println("나이 : ");
			age = k.nextInt();

			if (age >= 20) {
				System.out.println("어서오세요");
			} else if (age >= 0) {
				System.out.println("나가");
			} else if (age == -1) {
				break;
			}
		}
		System.out.println("---------------");

		// 자바 1.5부터
		// 조건문/반복문에 이름 붙이기 가능
		a : for (int i = 1; i < 4; i++) {
			b : for (int j = 1; j < 4; j++) {
				if (j == 3) {
					// break; // 가까운거(j for문)
					break a;
				}
				System.out.print(i);
				System.out.println(j);
			}
		}
	}
}
