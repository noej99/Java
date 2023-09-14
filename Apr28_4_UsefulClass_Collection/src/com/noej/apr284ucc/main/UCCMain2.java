package com.noej.apr284ucc.main;

import java.util.ArrayList;
import java.util.Comparator;

import com.noej.apr284ucc.student.Student;

// 학생 성적관리 : 
public class UCCMain2 {
	public static void main(String[] args) {
		// 홍길동, 100, 90, 80인 학생
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("홍길동", 100, 90, 80));
		students.add(new Student("김길동", 88, 56, 95));
		students.add(new Student("이길동", 78, 66, 91));
		students.add(new Student("강길동", 81, 45, 82));
		students.add(new Student("정길동", 53, 85, 43));
		students.add(new Student("신길동", 75, 77, 97));
		students.add(new Student("한길동", 12, 65, 100));
		students.add(new Student("박길동", 96, 52, 55));

		// 첫번째 학생의 국어 점수
		System.out.println(students.get(0).getKor());

		// 학생 총 몇명
		System.out.println(students.size());

		// 두번째 학생 수학점수 0점으로 수정
		students.get(1).setMat(0);
		System.out.println(students.get(1).getMat());

		// 이름 가나다 순 정렬
		Comparator<Student> c = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				String o1Name = o1.getName();
				String o2Name = o2.getName();
				return o1Name.compareTo(o2Name);
			}
		};
		students.sort(c);

		// 전체 학생 정보출력
		for (Student student : students) {
			student.printInfo();
		}

		// 1등 학생 정보출력
		students.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				Integer o1Sum = o1.getKor() + o1.getEng() + o1.getMat();
				Integer o2Sum = o2.getKor() + o2.getEng() + o2.getMat();
				return o2Sum.compareTo(o1Sum);
			}
		});
		students.get(0).printInfo();
	}
}
