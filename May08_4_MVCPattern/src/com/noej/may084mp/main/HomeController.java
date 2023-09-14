package com.noej.may084mp.main;

// 프로그램의 시작점 역할하는 C
// HomeController/MainController
public class HomeController {
	public static void main(String[] args) {
		ConsoleScreen cs = new ConsoleScreen();
		int x = cs.getX();
		int y = cs.getY();
		CalcResult cr = Calculator.calculate(x, y);
		cs.print(cr);
		cs.destroy();
	}
}
