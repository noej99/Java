package com.noej.may08aop.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import yoonho.noej.db.manager.NoejDBManager;

// 이름 : 
// 평균가
public class SelectMain2 {
	public static void main(String[] args) {
		Connection con = null;

		Scanner s = new Scanner(System.in);
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		try {
			// 연결
			con = NoejDBManager.connect("jdbc:oracle:thin:@195.168.9.61:1521:xe", "noej1", "j2527303");
			
			// 데이터확보
			System.out.println("이름 : ");
			String n = s.next();
			
			// SQL(미완성)
			String sql = "select avg(p_price) "
					+ "from may08_product "
					+ "where p_name like '%'||?||'%'";

			// 총괄객체
			pstmt = con.prepareStatement(sql);

			// SQL완성
			pstmt.setString(1, n);
			
			// 실행, 결과처리
			rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getDouble("avg(p_price)"));
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		NoejDBManager.close(con, pstmt, rs);
		s.close();
	}
}
