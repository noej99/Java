package com.noej.may091jl.menu;

public class Menu {
	private int no;
	private String name;
	private int price;
	private String restaurant;
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	public Menu(int no, String name, int price, String restaurant) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.restaurant = restaurant;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
}
