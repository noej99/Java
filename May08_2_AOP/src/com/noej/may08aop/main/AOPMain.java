package com.noej.may08aop.main;

import com.noej.may08aop.human.Human;

//	PP	: 절차지향프로그래밍
//		조건문, 반복문 최적으로 잘 써서
//		제발 실행되게 하자
//	----------------------------------------
//	OOP	: 객체지향프로그래밍
//		객체를 써서 실생활을 묘사해서
//		유지보수 좋게하자
//	----------------------------------------
//	AOP(Aspect Oriented P) : 관점지향프로그래밍
//		객체지향프로그래밍을 다른 관점에서 봐서
public class AOPMain {
	public static void main(String[] args) {
		Human h = new Human();

		h.goSchool();
		h.goMart();
		h.goPark();
	}
}
