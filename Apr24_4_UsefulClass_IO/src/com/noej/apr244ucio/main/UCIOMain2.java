package com.noej.apr244ucio.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 이름 : 
// 생일(YYYYMMDD) :
// 국어 :
// 영어 :
// 수학 : 
// -----------> student.csv에 저장

// 인코딩방식이 여러종류
// ㅋ -encoding-> 10110 -decoding-> ㅋ

// 전세계적으로 가장 많이 : utf-8
// 국내 랭킹 2위 : euc-kr

// 표준을 안지키는 회사 : MS , Apple

// student.csv에 저장

// 확장자 : 윈도우 진여에만 있는 허상
//			뭔지 알기 편할 뿐
// .txt : 메모장에서 열면 잘 열리는 파일
// .hwp : 한글에서 열면 잘 열리는 파일
// .xls : 엑셀에서 열면 잘 열리는 파일

// .csv(comma separated value)
//		각 값들이 ,로 구분된 파일
//		규칙적이라서 엑셀에서 잘 여는데
//		엑셀이 utf-8인식 못함

public class UCIOMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("이름 : ");
		String name = k.next();
		System.out.print("생일(YYYYMMDD) : ");
		String birthday = k.next();
		System.out.print("국어 : ");
		int kor = k.nextInt();
		System.out.print("영어 : ");
		int eng = k.nextInt();
		System.out.print("수학 : ");
		int mat = k.nextInt();

		// Win : 경로에 대소문자 구별x
		// Linux : 구별
		BufferedWriter bw = null;
		try {
			FileOutputStream fos = new FileOutputStream("C:\\가마우지\\병아리\\student.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);

			String data = String.format("%s,%s,%d,%d,%d\r\n", name, birthday, kor, eng, mat);
			bw.write(data);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Stream -> R/W -> Buffered급
		// 아니 그럴거면 처움부터 Buffered급 쓰시지
		// 1) 안되니까
		// 2) 인코딩방식 지정처럼 일부러 낮출때도

	}
}
