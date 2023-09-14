package com.noej.apr244ucio.main;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

// 입력/출력 : Stream이라는 통합된 시스템으로

// Stream급
// Reader/Writer급
// Buffered급

// 기본형
	// OutputStream : 프로그램 -> 장치(1byte)
	// OutputStreamWriter : 2byte
	// BufferedWriter : 줄 단위(1String)

	// InputStream : 장치 -> 프로그램(1byte)
	// IutputStreamWriter : 2byte
	// BufferedWriter : 엔터 나올때까지(1String)

// 개조형
	// FileReader : 파일처리하게 편하게 개조해놓은 ISR
	// PrintStream : 다양한 스타일로 넣게 개조해놓은 OS

// 키보드 입력
// 마우스 입력
// 옆사람 입력

// 콘솔출력
// 프린터출력
// 옆사람출력
public class UCIOMain {
	public static void main(String[] args) {
		// System.out : 프로그램 -> 콘솔
		PrintStream ps = System.out;
		ps.println("ㅋ");
		
		// System.in : 콘솔 ->프로그램
		InputStream is = System.in;
		// Java 1.5에 추가된
		// InputStream쓰기 편하게 해주는 객체
		Scanner k = new Scanner(System.in);
	}
}
