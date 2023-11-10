package com.myp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

public class MySQLConnectionTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "JDBC:MYSQL://localhost:3306/cuc_db?useSSL=false";
	private static final String USER = "root";
	private static final String PW = "20231004";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
			int num = insert(con, "111", "nampo", 30000);
			System.out.println(num+"개 행 삽입 완료");
			int id = 111;
			String name = selectName(con, id);
			System.out.println("id가 "+id+"인 행의 name은  "+name);
			num = delete(con, id);
			System.out.println(num+"개의 행이 삭제되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int insert(Connection con, String id, String name, int passenger) {
		final String SQL = "INSERT INTO stations(id, name, passenger) VALUES (?,?,?)";
		
		try(PreparedStatement pstml = (PreparedStatement) con.prepareStatement(SQL)) {
			pstml.setString(1, id);
			pstml.setString(2, name);
			pstml.setInt(3, passenger);
			return pstml.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("테이블에 행 삽입 실패");
			return 0;
		}
	}
	
	private static final String SQL2 = "SELECT name FROM stations WHERE id = ?";
	
	public String selectName(Connection con, Integer id) throws Exception {
		String result = null;
		try (java.sql.PreparedStatement pstmt = con.prepareStatement(SQL2)) {
			pstmt.setString(1, id.toString());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getString("name");
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	private static final String SQL3 = "DELETE FROM stations WHERE id = ?";
	
	public int delete(Connection con, Integer id) throws Exception {
		int result = 0;
		try (java.sql.PreparedStatement pstmt = con.prepareStatement(SQL3)) {
			pstmt.setString(1, id.toString());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
}
