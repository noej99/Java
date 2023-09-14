package com.noej.apr216eh.calculator;

// 정상 : 7 - 8 - 13 - 14 - 9 
// y에 0: 7 - 8(AE) - 10 - 11 - 13 - 14 - 12
public class Calculator {
	public static int divide(int a, int b) {
		try {
			int c = a / b;
			return c;
		} catch (Exception e) {
			System.out.println("나누기 0?");
			return 404;
		} finally {
			System.out.println("ㅋ");
		}
	}
}
