package com.noej.apr211oa.main;

import com.noej.apr211oa.avengers.Avengers;
import com.noej.apr211oa.avengers.Herk;
import com.noej.apr211oa.avengers.Ironman;

// singleton, static - x 

// 어벤져스 게임 -> 뽑기 -> 캐릭터가 나옴
public class OMain {
	public static void main(String[] args) {
		// Java는 객체를 만들면서 클래스 만드는게 가능
		// 클래스명이 없는 Avengers의 하위 클래스
		// anonymous inner class
		Avengers a = new Avengers() {
			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("거미줄 발사");
			}
		};
		a.attack();

		System.out.println("---------");

		Ironman i = new Ironman("토니", 40, "자비스");
		i.printInfo();
		i.attack();

		System.out.println("---------");

		Herk h = new Herk("배너", 30, 90);
		h.printInfo();
		h.attack();
	}
}
