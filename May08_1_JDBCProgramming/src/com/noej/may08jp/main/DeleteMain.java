package com.noej.may08jp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import yoonho.noej.db.manager.NoejDBManager;

public class DeleteMain {
	public static void main(String[] args) {
		Connection con = null;
		Scanner s = new Scanner(System.in);
		
		PreparedStatement pstmt = null;
		
		try {
			// 연결
			con = NoejDBManager.connect("jdbc:oracle:thin:@195.168.9.61:1521:xe", "noej1", "j2527303");
			
			// 데이터확보
			System.out.print("제품명 : ");
			String n = s.next();
			
			// Java 에서 %가...
			// %d
			// %s
			// SQL(미완성)
			String sql = "delete from may08_product\r\n "
					+ "where p_name like '%'||?||'%'" ;

			// 총괄객체
			pstmt = con.prepareStatement(sql);

			// SQL완성
			pstmt.setString(1, n); // pstmt.setxxx(번호, 값);
			
			// 실행, 결과처리
			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제성공");
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		NoejDBManager.close(con, pstmt, null);
		s.close();
	}
}
