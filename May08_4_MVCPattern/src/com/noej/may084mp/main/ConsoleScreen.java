package com.noej.may084mp.main;

import java.util.Scanner;

// 스캐너 한번 닫으면 못씀
public class ConsoleScreen {
	private Scanner inputSystem;

	public ConsoleScreen() {
		inputSystem = new Scanner(System.in);
	}

	public int getX() {
		// System.in : 콘솔 -> 프로그램 InputStream
		// Scanner : InputStream서포터
		System.out.println("x : ");
		return inputSystem.nextInt();
	}

	public int getY() {
		System.out.println("y : ");
		return inputSystem.nextInt();
	}

	public void print(CalcResult cr) {
		System.out.println(cr.getHab());
		System.out.println(cr.getCha());
		System.out.println(cr.getGob());
		System.out.println(cr.getMoks());
	}

	public void destroy() {
		inputSystem.close();
	}

}
