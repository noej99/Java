package com.noej.apr211oa.avengers;

public class Herk extends Avengers {
	private int pantSize;

	public Herk() {
		// TODO Auto-generated constructor stub
	}

	public Herk(String name, int age, int pantSize) {
		super(name, age);
		this.pantSize = pantSize;
	}

	public int getPantSize() {
		return pantSize;
	}

	public void setPantSize(int pantSize) {
		this.pantSize = pantSize;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(pantSize);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("주먹질");
	}
}
