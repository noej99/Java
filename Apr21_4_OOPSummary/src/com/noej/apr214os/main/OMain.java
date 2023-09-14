package com.noej.apr214os.main;

import com.noej.apr214os.hero.Ironman;
import com.noej.apr214os.human.Human;
import com.noej.apr214os.planet.Planet;

// part 1 : PP
// part 2 : OOP
// part 3 : 유용한 내장 클래스 소개

// Java
// JSP(Java + HTML + CSS)
// Spring(JSP를 유지보수하기 좋게)
public class OMain {
	public static void main(String[] args) {

		Planet p = new Planet("지구"); // 이름이 지구인 별

		Human h = new Human("홍길동"); // 이름이 홍길동인 사람

		p.add(h); // 저 별에 저 사람을 등록

		// 영웅들은 공격하기를 반드시 할 줄 알아야[사수]
		// 반드시 -> 추상메소드 -> 추상클래스/인터페이스 중에 골라야
		// 추상클래스는 상속라인을 막으니 -> 인터페이스 만들자

		Ironman i = new Ironman(); // 영웅인 아이언맨
		
		h.pick(i);	// 저사람이 자기 전담영웅으로 아이언맨을 찜
		
		h.help();	// 저 사람이 도움요청
		
		p.setSize(100); // 그 별 크기 100
		p.setVisible(true); // 그 별 보인다

	}
}
