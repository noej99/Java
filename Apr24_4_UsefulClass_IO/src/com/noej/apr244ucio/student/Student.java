package com.noej.apr244ucio.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private String name;
	private Date birthday;
	private int korScore;
	private int engScore;
	private int mathScore;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd(E)");

	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String l) throws ParseException {
		String[] l2 = l.split(",");
		name = l2[0];
		birthday = sdf.parse(l2[1]);
		korScore = Integer.parseInt(l2[2]); 
		engScore = Integer.parseInt(l2[3]);
		mathScore = Integer.parseInt(l2[4]);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	
	
	public void info() {
		System.out.printf("아룸 : %s\n",name);
		System.out.printf("생일 : %s\n",sdf2.format(birthday));
		System.out.printf("국어 : %d\n",korScore);
		System.out.printf("영어 : %d\n",engScore);
		System.out.printf("수학 : %s\n",mathScore);
		double avg = (korScore + engScore + mathScore) / 3;
		System.out.printf("평균 : %.1f\n",avg);
		System.out.println("--------------------");
	}
}
