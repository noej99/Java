package com.noej.apr244ucio.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.noej.apr244ucio.student.Student;

// python : hYBRID한 OOP언어(자바랑 같은 포지션)
//			분석툴
//			객체

// 빅데이터분석과정 : 

// 1) 그 csv읽어서 콘솔출력
// 2) 뜯고
// 3) 학생객체
// 4) 정보출력
//		이름 : 
//		생일 : 
//		국어 :
//		영어 :
//		수학 :
//		평균 :
//		---------------
//		...
// --------------------전처리
// 5) 1등학생 정보출력
//		학생들
public class UCIOMain3 {
	public static void main(String[] args) {
		
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\가마우지\\병아리\\student.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			String l = null;
			Student s = null;
			// 5) Student[] students = new Student[];
			while ((l = br.readLine()) != null) {
				s = new Student(l);
				s.info();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
