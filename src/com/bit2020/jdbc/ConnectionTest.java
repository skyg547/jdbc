package com.bit2020.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection connection =null;
		Statement stmt = null;
			// 1. jdbc 라이브러리 로딩 Driver loading -> mariaDB
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/webdb?characterEncoding=utf8";
			//2. db 연결하기
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			System.out.println("연결 성공");
			//3. statement 객체 생성
			
			stmt = connection.createStatement();
			// sql 문 작성
			String firstName = "하";
			String lastName = "성호";
			String email = "skyg@gmail.com";
			String sql = "Insert into emaillist values(null, '"+firstName+"', '"+lastName+"','"+email+"')";
			int count = stmt.executeUpdate(sql);
			if(count == 1) {
				System.out.println("성공");
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if(stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
