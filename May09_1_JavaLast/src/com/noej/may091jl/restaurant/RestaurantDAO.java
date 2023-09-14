package com.noej.may091jl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.noej.may091jl.menu.Menu;

import yoonho.noej.db.manager.NoejDBManager;

// java.util.Date : 일반
// java.sql.Date : DB작업
//		1) MyBatis에서 java.util.Date씀
//		2) java.util.Date <-> java.sql.Date 자동 변환

// DAO는 객체를 만들게되어서 static사용 안함
public class RestaurantDAO {
	private int allRestaurantCount;
	private int restaurantPerPage = 2;
	
	private static final RestaurantDAO RDAO = new RestaurantDAO();
	
	private RestaurantDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static RestaurantDAO getRdao() {
		return RDAO;
	}
	
	public void setAllRestaurantCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = NoejDBManager.connect("jdbc:oracle:thin:@sdgn-djvemfu.tplinkdns.com:19195:xe", "noej", "1234");
			String sql = "select count(*) from noej_may09_restaurant";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allRestaurantCount = rs.getInt("count(*)");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			NoejDBManager.close(con, pstmt, rs);
		}
	}
	
	public int getAllPageCount() {
		int pageCount = (int)Math.ceil(allRestaurantCount / (double)restaurantPerPage);
		return pageCount;
	}
	
	public String reg(Restaurant r) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = NoejDBManager.connect("jdbc:oracle:thin:@sdgn-djvemfu.tplinkdns.com:19195:xe", "noej", "1234");
			
			String sql = "insert into noej_may09_restaurant values(?, to_date(?,'YYYYMMDD'), ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getSince2());
			pstmt.setString(3, r.getAddr());
			
			if (pstmt.executeUpdate() == 1) {
				allRestaurantCount++;
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
	
	public ArrayList<Restaurant> get(int pageNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = NoejDBManager.connect("jdbc:oracle:thin:@sdgn-djvemfu.tplinkdns.com:19195:xe", "noej", "1234");
			
			int start = (pageNo - 1) * restaurantPerPage + 1;
			int end = pageNo * restaurantPerPage;
			
			String sql =  "select * "
					+ "from ( "
					+ "	select rownum as rn, r_name, r_since, r_addr "
					+ "	from ( "
					+ "		select * "
					+ "		from noej_may09_restaurant "
					+ "		order by r_name "
					+ "	) "
					+ ") "
					+ "where rn >= ? and rn <= ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			// ResultSet -> ArrayList<자바빈>
			ArrayList<Restaurant> restaurants = new ArrayList<>();
			Restaurant r = null;
			while (rs.next()) {
				r = new Restaurant();
				r.setName(rs.getString("r_name"));
				r.setSince(rs.getDate("r_since"));
				r.setAddr(rs.getString("r_addr"));
				restaurants.add(r);
			}
			return restaurants;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			NoejDBManager.close(con, pstmt, rs);
		}
	}
}
