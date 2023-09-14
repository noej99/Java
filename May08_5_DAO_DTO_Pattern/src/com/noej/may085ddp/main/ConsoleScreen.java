package com.noej.may085ddp.main;

import java.util.Scanner;

public class ConsoleScreen {
	private Scanner inputSystemScanner;

	public ConsoleScreen() {
		inputSystemScanner = new Scanner(System.in);
	}

	public Gift getInput() {
		System.out.println("이름 : ");
		String n = inputSystemScanner.next();

		System.out.println("가격 : ");
		int p = inputSystemScanner.nextInt();
		
		return new Gift(n,p);
	}

	public void print(String result) {
		System.out.println(result);
	}
	
	public void bye() {
		inputSystemScanner.close();
	}
}
