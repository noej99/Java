package com.noej.may083mp.model;

// Model : 비즈니스로직(실제계산하고...)
//		back-end개발자 + 고객
public class M {
	public static String judge(int n) {
		return (n % 2 == 1) ? "홀" : "짝";
	}
}