package com.noej.apr242.main;

import java.util.Scanner;

import com.noej.apr24eh.calculator.Calculator;

// 뭐가 위험한가 어떻게 아나
//		Java는 예외처리를 안하면 에러
//		하기싫어도 해야
public class EHMain {
	public static void main(String[] args) {
		
		Scanner k = new Scanner(System.in);
		System.out.print("가격 : ");
		int price = k.nextInt();
		System.out.print("수량 : ");
		int quantity = k.nextInt();
		System.out.println("--------");
		
//		2번 미루기(throws)사용
		try {
			System.out.print("개당 가격 : ");
			System.out.println(Calculator.divide2(price, quantity));
		} catch (Exception e) {
			System.out.println("나누기 0?");
		}
	}
}
