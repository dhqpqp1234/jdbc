package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
   
   //필드
   
   //생성자
   
   //메소드 gs
   
   //메소드 일반
   
   public void Inselt(String Title, String pubs, String pubDate, int authorId) {
      
      // 0. import java.sql.*;
      Connection conn = null;
      PreparedStatement pstmt = null;
      //ResultSet rs = null;
      try {
      // 1. JDBC 드라이버 (Oracle) 로딩
         Class.forName("oracle.jdbc.driver.OracleDriver");

      // 2. Connection 얻어오기
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         conn = DriverManager.getConnection(url, "webdb", "webdb");

      // 3. SQL문 준비 / 바인딩 / 실행
         //sql문 준비
         String query = "";
         query += " INSERT INTO book ";
         query += " VALUES (seq_book_id.nextval, ?, ?, ?, ?) ";
         
         //바인딩
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, Title);
         pstmt.setString(2, pubs);
         pstmt.setString(3, pubDate);
         pstmt.setInt(4, authorId);
         
         System.out.println(query);
         //실행
         int count = pstmt.executeUpdate();
         
      // 4.결과처리
         
         System.out.println(count + "건이 등록 되었습니다.");
      } catch (ClassNotFoundException e) {
      System.out.println("error: 드라이버 로딩 실패 - " + e);
      } catch (SQLException e) {
      System.out.println("error:" + e);
      } finally {
      // 5. 자원정리
      try {
      /*
      if (rs != null) {
      rs.close();
      } 
      */
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
   
   public int authorDelete(int bookId) {
      int count = -1;
      // 0. import java.sql.*;
      Connection conn = null;
      PreparedStatement pstmt = null;
      //ResultSet rs = null;
      try {
      // 1. JDBC 드라이버 (Oracle) 로딩
         Class.forName("oracle.jdbc.driver.OracleDriver");   
      // 2. Connection 얻어오기
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         conn = DriverManager.getConnection(url, "webdb", "webdb");

      // 3. SQL문 준비 / 바인딩 / 실행
         //sql문
         String query = "";
         query += " delete from book ";
         query += " where book_id =? ";
         System.out.println(query);
         //바인딩
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, bookId);
         //실행
          count = pstmt.executeUpdate();
         
      // 4.결과처리
         
         System.out.println(count + "건이 삭제 되었습니다.");
      } catch (ClassNotFoundException e) {
      System.out.println("error: 드라이버 로딩 실패 - " + e);
      } catch (SQLException e) {
      System.out.println("error:" + e);
      } finally {
      // 5. 자원정리
      try {
      /*
      if (rs != null) {
      rs.close();
      } 
      */
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

      return count;
   }
   
   public int bookUpdate ( String title, String pubs, String pubDate, int bookId) {
      int count = -1;
      // 0. import java.sql.*;
      Connection conn = null;
      PreparedStatement pstmt = null;
      //ResultSet rs = null;
      try {
      // 1. JDBC 드라이버 (Oracle) 로딩
         Class.forName("oracle.jdbc.driver.OracleDriver");
      // 2. Connection 얻어오기
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         conn = DriverManager.getConnection(url, "webdb", "webdb");

      // 3. SQL문 준비 / 바인딩 / 실행
         //sql문 준비
         String query ="";
         query += " update book ";
         query += " set title = ?, ";
         query += "     pubs = ?, ";
         query += "     pub_date = ? ";
         query += " where book_id = ? ";
         
         System.out.println(query);
         //바인딩
         pstmt = conn.prepareStatement(query);
         
         pstmt.setString(1, title);
         pstmt.setString(2, pubs);
         pstmt.setString(3, pubDate);
         pstmt.setInt(4, bookId);
         //실헹
          count = pstmt.executeUpdate();
         
      // 4.결과처리
         
         System.out.println(count + "건이 수정 되었습니다.");
      } catch (ClassNotFoundException e) {
      System.out.println("error: 드라이버 로딩 실패 - " + e);
      } catch (SQLException e) {
      System.out.println("error:" + e);
      } finally {
      // 5. 자원정리
      try {
      /*   
      if (rs != null) {
      rs.close();
      } 
      */
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

      return count;
   }
   
   //--book 전체리스트 가져오기 메소드
   public List<BooKVo> bookSelect() {
      //리스트로 만들기
	   List<BooKVo> bookList = new ArrayList<BooKVo>();
      
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
         //sql문 준비
         String query ="";
         query +=" select book_id, ";
         query +="       title, ";
         query +="       pubs, ";
         query +="       pub_date, ";
         query +="       author_name ";
         query +=" from book b, author a ";
         query +=" where a.author_id = b.author_id ";
         
         System.out.println(query);
         //바인딩
         pstmt = conn.prepareStatement(query);
         //실행
         //resultset 가져오기
         rs = pstmt.executeQuery();
         
      // 4.결과처리
        
         
         //반복문으로 Vo 만들기  list에 추가하기
         while(rs.next()) {
            int bookId = rs.getInt("book_id");
            String title = rs.getString("title");
            String pubs = rs.getString("pubs");
            java.sql.Date pubDate = rs.getDate("pub_date");
            String authorName = rs.getString("author_name");
            
            BooKVo bookVo = new BooKVo(bookId, title, pubs, pubDate, authorName);
            
            bookList.add(bookVo);
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
      return bookList;
   }
}