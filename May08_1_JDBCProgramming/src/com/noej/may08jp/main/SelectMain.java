package com.noej.may08jp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {
	public static void main(String[] args) {
		Connection con = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		try {
			// 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@195.168.9.61:1521:xe", "noej1", "j2527303");
			
			// 데이터확보
			
			// SQL(미완성)
			String sql = "select * from may08_product";

			// 총괄객체
			pstmt = con.prepareStatement(sql);

			// SQL완성
			
			// 실행, 결과처리
			//		CUD : 영향받은 데이터 수
			// int row = pstmt.executeUpdate();
			//		R : 데이터
			rs = pstmt.executeQuery();
			
			// rs.next()
			//		다음 데이터로
			//		갔는데 없으면 false
			while (rs.next()) {
				// rs.getxxx("필드명"); : 지금 보고있는 데이터의 그 필드 값 꺼내기
				System.out.println(rs.getString("p_name"));
				System.out.println(rs.getInt("p_price"));
				System.out.println("-------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {rs.close();} catch (SQLException e) {}
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
	}
}
