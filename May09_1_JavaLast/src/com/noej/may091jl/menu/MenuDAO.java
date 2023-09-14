package com.noej.may091jl.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import yoonho.noej.db.manager.NoejDBManager;
// 페이지 나누기 -> 총 페이지 수 필요 -> 총 데이터 갯수
// 총 데이터 갯수는 처음 한번만 세어놓자
// 데이터 추가되면 +1, 삭제되면 -1

// 이제는 static메소드 사용 불가
// 모든 메소드에 static이 다 지워져야

// 멤버변수가 없다 : static메소드 기반
// 멤버변수가 있다
//		객체가 하나 필요 : singleton
//		객체가 여러개 필요 
//			대량 자동생산 : factory
//			일반

// => DAO 
//		: 페이지 나누기 기능이 있게 되고 
//		-> 전체 데이터 수를 멤버변수로 저장하게 되고 
//		-> 객체는 만들어야 하는데
//		-> 하나만 필요
//		-> singleton패턴
public class MenuDAO {
	private int allMenuCount;
	private int menuPerPage = 3;
	
	// 2. 내부에서 하나 만들어 놓고
	private static final MenuDAO MDAO = new MenuDAO();

	// 1. 객체 외부에서 못만들게 - private
	private MenuDAO() {
		// TODO Auto-generated constructor stub
	}

	// 3. 그 하나 만들어놓은거 외부에서 쓸 수 있게
	public static MenuDAO getMdao() {
		return MDAO;
	}

	public void setAllMenuCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = NoejDBManager.connect("jdbc:oracle:thin:@sdgn-djvemfu.tplinkdns.com:19195:xe", "noej", "1234");
			String sql = "select count(*) from noej_may09_menu";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allMenuCount = rs.getInt("count(*)");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			NoejDBManager.close(con, pstmt, rs);
		}
	}

	public int getAllPageCount() {
		// 전체 : 14
		// 한 페이지당 3개
		// 14/3 = 4.? -> 올림
		// allMenuCount / menuPerPage : 4
		// allMenuCount / (double)menuPerPage : 4.666
		// Math.ceil(allMenuCount / (double)menuPerPage) : 5.0
		// (int)Math.ceil(allMenuCount / (double)menuPerPage) : 5
		int pageCount = (int) Math.ceil(allMenuCount / (double) menuPerPage);
		return pageCount;
	}

	public ArrayList<Menu> get(int pageNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = NoejDBManager.connect("jdbc:oracle:thin:@sdgn-djvemfu.tplinkdns.com:19195:xe", "noej", "1234");
			// p1 : 1 2 3
			// p2 : 4 5 6
			// p3 : 7 8 9
			// p4 : 10 11 12

			int start = (pageNo - 1) * menuPerPage + 1;
			// int end = (pageNo == pageCount)? allMenuCount : (pageNo * menuPerPage);
			int end = pageNo * menuPerPage;
			
			String sql = "select * "
					+ "from ( "
					+ "	select rownum as rn, m_no, m_name, m_price, m_r_name "
					+ "	from ( "
					+ "		select * "
					+ "		from noej_may09_menu "
					+ "		order by m_r_name, m_name "
					+ "	) "
					+ ") "
					+ "where rn >= ? and rn <= ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			// ResultSet -> ArrayList<자바빈>
			ArrayList<Menu> menus = new ArrayList<>();
			Menu m = null;
			while (rs.next()) {
				m = new Menu();
				m.setNo(rs.getInt("m_no"));
				m.setName(rs.getString("m_name"));
				m.setPrice(rs.getInt("m_price"));
				m.setRestaurant(rs.getString("m_r_name"));
				menus.add(m);
			}
			return menus;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			NoejDBManager.close(con, pstmt, rs);
		}
	}

	public String reg(Menu m) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = NoejDBManager.connect("jdbc:oracle:thin:@sdgn-djvemfu.tplinkdns.com:19195:xe", "noej", "1234");

			String sql = "insert into noej_may09_menu values(noej_may09_menu_seq.nextval, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setInt(2, m.getPrice());
			pstmt.setString(3, m.getRestaurant());

			if (pstmt.executeUpdate() == 1) {
				allMenuCount++;
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
