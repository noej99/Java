package com.noej.apr211oa.avengers;

import com.noej.apr211oa.fly.Fly;
import com.noej.apr211oa.human.Human;

// 아이언맨 is a 어벤져스
// 아이언맨 is a 사람
// 아이언맨 is a 날아다니는 존재

// 다중상속 
//		Java를 비롯한 대부분의 언어들은 안됨
//		Python은 되는데

// 정식으로 다중상속은 안되는데 : 클래스 여러개로부터 상속은 못받음
// 마이너버전 다중상속은 가능 : 인터페이스 여러개는 가능

public class Ironman extends Avengers implements Human, Fly {

	private String ai;

	public Ironman() {
		// TODO Auto-generated constructor stub
	}

	public Ironman(String name, int age, String ai) {
		super(name, age);
		this.ai = ai;
	}

	public String getAi() {
		return ai;
	}

	public void setAi(String ai) {
		this.ai = ai;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(ai);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("빔 발사");
	}

	@Override
	public void eat() {
		System.out.println("냠");
	}

	@Override
	public void fly() {
		System.out.println("슝");
	}
}
