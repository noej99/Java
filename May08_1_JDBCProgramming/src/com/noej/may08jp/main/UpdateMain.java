package com.noej.may08jp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

// 이름 : 상품권
// 가격 : -500
// 성공

public class UpdateMain {
	public static void main(String[] args) {
		Connection con = null;
		Scanner s = new Scanner(System.in);
		
		PreparedStatement pstmt = null;
		
		try {
			// 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@195.168.9.61:1521:xe", "noej1", "j2527303");
			// 데이터확보
			System.out.print("제품명 : ");
			String n = s.next();
			System.out.println("얼마 : ");
			int p = s.nextInt();
			
			// SQL(미완성)
			String sql = "update may08_product\r\n "
					+ "set p_price = p_price-?\r\n "
					+ "where p_name = ?";

			// 총괄객체
			pstmt = con.prepareStatement(sql);

			// SQL완성
			pstmt.setInt(1, p);
			pstmt.setString(2, n); // pstmt.setxxx(번호, 값);
			
			// 실행, 결과처리
			if (pstmt.executeUpdate() == 1) {
				System.out.println("성공");
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
		
		s.close();
	}
}
