package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelect {

	public static void main(String[] args) {
		
		// 0. import java.sql.*;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					// 1. JDBC 드라이버 (Oracle) 로딩
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					// 2. Connection 얻어오기
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					conn = DriverManager.getConnection(url, "webdb", "webdb");

					// 3. SQL문 준비 / 바인딩 / 실행
					//SQL문 준비 
					String query ="";
					query += " select book_id, ";
					query += "        title, ";
					query += "        pubs, ";
					query += "        pub_date, ";
					query += "        author_id ";
					query += " from book ";
					
					//바인딩 
					pstmt = conn.prepareStatement(query);
					
					//실행
					rs = pstmt.executeQuery();
					
					// 4.결과처리
					while(rs.next()) {
						//int authorId = rs.getInt("author_id");
						//String authorName = rs.getString("author_name");
						//String authorDesc = rs.getString("author_desc");
						
						int bookId = rs.getInt(1);
						String title = rs.getString(2);
						String pubs = rs.getString(3);
						String pub_date = rs.getString(4);
						String author = rs.getString(5);
						
						System.out.println(bookId + ", " + title + ", " + pubs + "," +pub_date+","+author);
					}
					
				} catch (ClassNotFoundException e) {
					System.out.println("error: 드라이버 로딩 실패 - " + e);
				} catch (SQLException e) {
					System.out.println("error:" + e);
				} finally {

					// 5. 자원정리
					try {
						if (rs != null) {
							rs.close();
						}
						if (pstmt != null) {
							pstmt.close();
						}
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						System.out.println("error:" + e);
					}

				}
		
	}

}
