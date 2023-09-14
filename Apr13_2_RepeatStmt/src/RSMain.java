//	반복문
//				반복횟수	:	for
//				반복조건	:	while, do-while
//				

//	for (변수초기화[1]; 조건식[2,5]; 변수증감[4,7]) {
//			내용[조건식 만족하면[3,6]]
//}

import java.util.Iterator;

public class RSMain {
	public static void main(String[] args) {
		// ㅋ 5번
		for (int i = 0; i < 5; i++) {
			System.out.print("ㅋ");
		}	
		System.out.println("------------------------------");
			
		// 1 ~ 10출력
		for (int i = 1; i < 11; i++) {
			System.out.print(i);
		}
		System.out.println("------------------------------");
		//	10 ~ 1출력
		for (int i = 10; i > 0; i--) {
			System.out.print(i);
		}
		System.out.println("------------------------------");
		// 1 ~ 10 홀수만 출력
		for (int i = 1; i < 11 ; i+=2) {
			System.out.println(i);	
		}
		System.out.println("------------------------------");
		// -5 ~ 5 짝수는 숫자/홀수는 "홀"이라는 글자
		for (int i = -5; i < 6 ; i++) {
			System.out.println((i % 2 == 0 ) ? i : "홀");
//			if(i % 2 == 0) {
//				System.out.println(i);	
//				} else {
//					System.out.println("홀수");
//				}
			}
		System.out.println("------------------------------");
		
		//	반복문 속에서 변수 안만드는 쪽으로
		//	1 ~ 10까지 다 더하면
		int sum = 0;
		for (int i = 1; i < 11; i++) {
			sum += i;
			System.out.println(sum);
		}
		System.out.println("--------------------");
		
		//	5! = ?
		int fac = 1;
		for (int i = 1; i < 6; i++) {
			 fac *= i;
			System.out.println(fac);
		}
		System.out.println("--------------------");
		
		//	10 ~ 50 까지 짝수들만 다 더하면?
		int hab = 0;
		for (int i = 10; i < 51; i+=2) {
			hab += i ;
			System.out.println(hab);
		}
		System.out.println("--------------------");
		//	1 - 2 + 3 - 4 + 5 - ... - 50 = ?
		int result = 0;
		int n = 1;
		for (int i = 1; i < 51; i++) {
			result += (i*n);
			n *=-1;
		}
			System.out.println(result);
	}
}
