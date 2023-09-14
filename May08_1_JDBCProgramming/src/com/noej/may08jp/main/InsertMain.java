package com.noej.may08jp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) {
		Connection con = null;
		Scanner s = new Scanner(System.in);

		// SQL완성
		// SQL을 서버로 전송
		// 전송한거 원격실행
		// 결과 받아오기
		PreparedStatement pstmt = null; // DB관련 작업을 다 해주는 총괄매니저 객체

		try {
			// 연결(실패할수도)
			String addr = "jdbc:oracle:thin:@195.168.9.61:1521:xe";
			con = DriverManager.getConnection(addr, "noej1", "j2527303");

			// 데이터 확보
			System.out.print("제품명 : ");
			String n = s.next();
			System.out.print("가격 : ");
			int p = s.nextInt();

			// SQL(미완성)
			// 값 들어갈 자리에 ?(따옴표 빼고)
			// SQL자체에 있는 ;빼고
			String sql = "insert into may08_product values(?, ?)";

			// SQL완성, 전송, 결과처리 해주는 총괄매니저 객체
			pstmt = con.prepareStatement(sql);

			// SQL완성(?채우기)
			pstmt.setString(1, n); // pstmt.setxxx(번호, 값);
			pstmt.setInt(2, p);
			
			// 서버로 전송, 실행
			int row = pstmt.executeUpdate();
			
			if (row == 1) {
				System.out.println("성공");
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 닫는 순서 큰거는 나중으로
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
		
		s.close();
	}
}
