package com.noej.may021ucc.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

//	Collection
//		List계열 : 가변사이즈 배열
//		Set계열	 : 중복자동제거, 순서?
//			기본형급(int, double, String,...)List의 중복 제거
//			기본형급 중복제거
//		Map계열(Python의  dict)	 : ?
public class UCCMain {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("ㅋ");
		hs.add("ㅋ");
		hs.add("ㅎ");
		hs.add("ㅎ");
		hs.add("ㄴ");
		hs.add("ㄴ");
		System.out.println(hs.size());

		// Set -> List
		ArrayList<String> al = new ArrayList<>(hs);
		for (String string : al) {
			System.out.println(string);
		}
		System.out.println("---------");

		HashSet<Coffee> coffees = new HashSet<>();
		coffees.add(new Coffee("아아", 3000));
		coffees.add(new Coffee("아아", 3000));
		coffees.add(new Coffee("아아", 3000));

		Coffee c = new Coffee("라떼", 4000);
		coffees.add(c);
		coffees.add(c);
		coffees.add(c);
		System.out.println(coffees.size());

		System.out.println("---------");
		// 중복이 있는
		// 기본형급(int, double, String ...) List
		// 의 중복 제거하려면
		ArrayList<Integer> al2 = new ArrayList<>();
		al2.add(10);
		al2.add(100);
		al2.add(1000);
		al2.add(10000);
		al2.add(10);
		al2.add(100);
		al2.add(1000);
		al2.add(10000);
		// List -> Set
		HashSet<Integer> hs2 = new HashSet<>(al2);
		al2 = new ArrayList<>(hs2);
		for (Integer integer : al2) {
			System.out.println(integer);
		}

		System.out.println("---------");
		// 로또번호자동생성기
		// 1 ~ 45 랜덤한 숫자 중복 안되게 6개, 오름차순 정렬
		Random r = new Random();
		HashSet<Integer> lotto = new HashSet<>(45);
		while (true) {
			lotto.add(r.nextInt(45) + 1);
			if (lotto.size() == 6) {
				break;
			}
		}
		ArrayList<Integer> lotto2 = new ArrayList<>(lotto);
		lotto2.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});

		for (Integer integer : lotto2) {
			System.out.println(integer);
		}
	}
}
