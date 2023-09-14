package com.noej.ap243ucd.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UCDMain2 {
	public static void main(String[] args) {

		// 태어난 요일
		try {
			String bd = "19991121";
			SimpleDateFormat b = new SimpleDateFormat("yyyyMMdd");
			Date d = b.parse(bd);
			SimpleDateFormat b2 = new SimpleDateFormat("E");
			String yo = b2.format(d);
			System.out.println(yo);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("-----------");

		// 한국나이
		String bd2 = "19991121";
		String s = bd2.substring(0, 4);
		int birthYear = Integer.parseInt(s);
		Date date = new Date();
		SimpleDateFormat now = new SimpleDateFormat("yyyy");
		String y = now.format(date);
		int t = Integer.parseInt(y);

		int age = t - birthYear;

		System.out.println(age);

	}
}
