package com.noej.may091jl.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.noej.may091jl.menu.Menu;
import com.noej.may091jl.restaurant.Restaurant;

public class ConsoleScreen {
	private Scanner inputSystem;

	public ConsoleScreen() {
		inputSystem = new Scanner(System.in);
	}

	public int showMainMenu() {
		System.out.println("1. 식당등록");
		System.out.println("2. 메뉴등록");
		System.out.println("3. 식당조회");
		System.out.println("4. 메뉴조회");
		System.out.println("...");
		System.out.println("10. 종료");
		System.out.println("-------------");
		System.out.println("뭐 : ");
		return inputSystem.nextInt();
	}

	public Restaurant showRegRestaurantMenu() {
		System.out.println("이름 : ");
		String n = inputSystem.next();

		System.out.println("시작일 : ");
		String s = inputSystem.next();

		System.out.println("주소 : ");
		String a = inputSystem.next();

		return new Restaurant(n, null, a, s);
	}

	public Menu showMenuReg() {
		System.out.println("메뉴명 : ");
		String n = inputSystem.next();

		System.out.println("가격 : ");
		int p = inputSystem.nextInt();

		System.out.println("판매식당명 : ");
		String rn = inputSystem.next();
		return new Menu(0, n, p, rn);
	}

	public int showGetPageNoMenu(int pageCount) {
		System.out.print("페이지(1 ~ " + pageCount + ") : ");
		return inputSystem.nextInt();
	}

	public int showGetPageNoRestaurant(int pageCount) {
		System.out.print("페이지(1 ~ " + pageCount + ") : ");
		return inputSystem.nextInt();
	}

	public void printMenus(ArrayList<Menu> menus) {
		for (Menu menu : menus) {
			System.out.println(menu.getNo());
			System.out.println(menu.getName());
			System.out.println(menu.getPrice());
			System.out.println(menu.getRestaurant());
			System.out.println("----------------");
		}
	}

	public void printRestaurants(ArrayList<Restaurant> restaurants) {
		for (Restaurant restaurant : restaurants) {
			System.out.println(restaurant.getName());
			System.out.println(restaurant.getSince());
			System.out.println(restaurant.getAddr());
			System.out.println("----------------");
		}
	}

	public void printResult(String result) {
		System.out.println(result);
		System.out.println("---------------");
	}

	public void bye() {
		inputSystem.close();
	}
}
