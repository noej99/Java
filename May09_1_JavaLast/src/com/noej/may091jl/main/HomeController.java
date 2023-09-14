package com.noej.may091jl.main;

import java.util.ArrayList;

import com.noej.may091jl.menu.Menu;
import com.noej.may091jl.menu.MenuDAO;
import com.noej.may091jl.restaurant.Restaurant;
import com.noej.may091jl.restaurant.RestaurantDAO;

// 웹사이트 : 동시에 여러명이
//		DB계정 하나를 같이 쓰게 되는거
//		계정 하나당 동시에 접속할 수 있는 수 제한되어있고
//		=> 작업 하나 해야할 떼마다 연결해서 처리하고 바로 끊어야

// Java
// OracleDB
// JDBC(Java + DB)
// ------- <-
// HTML
// CSS
// -------
// JSP
public class HomeController {
	public static void main(String[] args) {

		ConsoleScreen cs = new ConsoleScreen();
		Restaurant r = null;
		String result = null;
		Menu m = null;
		int menu = 0;
		ArrayList<Menu> menus = null;
		ArrayList<Restaurant> restaurants = null;
		MenuDAO.getMdao().setAllMenuCount();
		RestaurantDAO.getRdao().setAllRestaurantCount();
		int pageCount = 0;
		int pageNo = 0;
		while (true) {
			menu = cs.showMainMenu();
			if (menu == 10) {
				break;
			} else if (menu == 1) {
				r = cs.showRegRestaurantMenu();
				result = RestaurantDAO.getRdao().reg(r);
				cs.printResult(result);
			} else if (menu == 2) {
				pageCount = RestaurantDAO.getRdao().getAllPageCount();
				pageNo = cs.showGetPageNoRestaurant(pageCount);
				restaurants = RestaurantDAO.getRdao().get(pageNo);
				cs.printRestaurants(restaurants);

				m = cs.showMenuReg();
				result = MenuDAO.getMdao().reg(m);
				cs.printResult(result);
			} else if (menu == 3) {
				pageCount = RestaurantDAO.getRdao().getAllPageCount();
				pageNo = cs.showGetPageNoRestaurant(pageCount);
				restaurants = RestaurantDAO.getRdao().get(pageNo);
				cs.printRestaurants(restaurants);
			} else if (menu == 4) {
				pageCount = MenuDAO.getMdao().getAllPageCount();
				pageNo = cs.showGetPageNoMenu(pageCount);
				menus = MenuDAO.getMdao().get(pageNo);
				cs.printMenus(menus);
			}
		}
		cs.bye();
	}
}
