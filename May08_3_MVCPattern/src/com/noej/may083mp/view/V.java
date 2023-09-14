package com.noej.may083mp.view;

import java.util.Scanner;

// View : 사용자한테 보여짐, 입력받고 출력하기
//		front-end개발자 + 디자이너 
public class V {
	public static int getNo() {
		Scanner s = new Scanner(System.in);
		System.out.println("뭐 : ");
		return s.nextInt();
	}
	
	public static void print(String s) {
		System.out.println(s);
	}
}
