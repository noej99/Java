import java.util.Random;
import java.util.Scanner;

// UpDown
// 컴이 1 ~ 10000사이의 랜덤한 숫자
// 뭐 : 8000
// DOWN
// ------------------
// .....
// ?번만에 정답

// 1. 설계
// 2. 자바로 번역(직역)
// 3. 다듬기
public class RSMain3 {
	public static int pickGameAns() {
		Random r = new Random();
		return r.nextInt(10000) + 1;
	}
	
	public static int tell() {
		Scanner k = new Scanner(System.in);
		System.out.println("정답은? : ");
		int userAns = k.nextInt();
		return (userAns < 1 || userAns>10000) ? tell() : userAns;
	}
	
	// 그만해야하나 판단하는 함수
	public static boolean judge(int gameAns, int userAns) {
		
		if (userAns > gameAns) {
			System.out.println("DOWN");
		} else if (userAns < gameAns) {
			System.out.println("UP");
		} else {
			return true;
		}
		return false;
	}
	
	public static void printResult(int turn) {
		System.out.printf("%d턴만에 정답\n",turn);
	}
	
	public static void main(String[] args) {

		// 1~ 10000사이의 답 뽑기
		// 정답 나올때까지 반복
		// 답 말하기
		// 판정
		// for문이었으면 turn이 자동...
		// for문 쓸 상황은 아니고...
		
		// for문 겸, while문 겸
		int gameAns = pickGameAns();
		System.out.println(gameAns);
		int userAns;
//		int turn = 0;
//		while (true) {
//			turn++;
		for (int turn = 1; true ; turn++) {
			userAns = tell();
			// ==true는 생략가능
			// ==false는 !값 형태로
			if (judge(gameAns, userAns)) {
				printResult(turn);
				break;
			}
		}
	}
}


