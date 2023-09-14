package com.noej.ap243ucd.main;

import java.util.Scanner;

// 숫자(x,y,z,...)
// -----------------
// 합계

public class UCDMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.println("숫자(x,y,...) : ");
		String data = k.next();

		String[] data2 = data.split(",");
		int sum = 0;
		for (String s : data2) {
			try {
				sum += Integer.parseInt(s);
			} catch (Exception e) {
			}
		}
		System.out.println(sum);
	}
}
