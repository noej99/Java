package com.noej.apr24eh.ehmain;

import java.util.Scanner;

import com.noej.apr24eh.calculator.Calculator;

public class EHMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("x : ");
		int x = k.nextInt();
		System.out.print("y : ");
		int y = k.nextInt();
		System.out.println("--------");
//		System.out.println(Calculator.divide(x, y));
		try {
			System.out.println(Calculator.divide2(x, y));
		} catch (Exception e) {
			System.out.println("나누기 0?");
		}
	}
}
