package com.noej.apr24eh.calculator;

// OOP : 코드 재사용

// 동생의 요청으로 시작된 프로젝트
//	나누기 기능이 있는데 -> 다른 프로그램
//	챙겨두자 -> .jAR

// 예외처리
//		y에 0은 들어가면 안됨(수학이론)

// main은 개발팀장
// 클래스를 작업하게 될 신입 개발자
//		직접 처리 -> 책임지나
//		=> 대응은 개발팀장이

//		프로젝트가 달라지면 대응 방법도 달라져야 할텐데

public class Calculator {
//		1) 직접 처리 : try - catch - finally
	public static int divide(int x, int y) {
		try {
			return x / y;
		} catch (Exception e) {
			System.out.println("나누기 0이 어딨냐");
			return -999;
		} finally {
			System.out.println("어쨋든 계산 끝");
		}
	}

// 2) 미루기 : throws
//	divide2를 수행하다가 Arith...가 발생한거
//	divide2를 호출한쪽에서  처리해라
	public static int divide2(int x, int y) throws ArithmeticException {
		return x / y;
	}
}
