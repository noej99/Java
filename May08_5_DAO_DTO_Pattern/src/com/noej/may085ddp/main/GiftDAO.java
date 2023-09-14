package com.noej.may085ddp.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import yoonho.noej.db.manager.NoejDBManager;

// MVC패턴
// DB에 연관된 작업을 하는 M을 DAO
// Data Access Object

// 일반개발자

// try-catch는 사수가 담당할 C쪽에 있는게 맞는데
//		1) MVC패턴 -> M의 결과가 V까지 가야
//		2) DB안되면 어차피 아무것도 안되는거 -> 대응방법이 어쩌고?
public class GiftDAO {
	public static String reg(Gift g) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = NoejDBManager.connect("jdbc:oracle:thin:@sdgn-djvemfu.tplinkdns.com:19195:xe", " noej", "1234");

			String sql = "insert into noej_may08_gift values(?,?)";

			pstmt = con.prepareStatement(sql); // 빼먹기 x
			pstmt.setString(1, g.getName());
			pstmt.setInt(2, g.getPrice());

			// insert는 1되거나 exception 둘 중에 하나 뿐인데
			// 근데 그걸 자바가 아나
			if (pstmt.executeUpdate() == 1) {
				return "성공";
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return "실패";
		} finally {
			NoejDBManager.close(con, pstmt, null);
		}
	}
}
