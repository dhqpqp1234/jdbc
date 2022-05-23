package com.javaex.ex02;

import java.util.List;

public class BookApp {

   public static void main(String[] args) {
      
      BookDao bookDao = new BookDao();
      
      /*
      bookDao.Inselt("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
      bookDao.Inselt("삼국지", "민음사", "2002-03-01", 1);
      bookDao.Inselt("토지", "마로니에북스", "2012-08-15", 2);
      bookDao.Inselt("자바프로그래밍 입문", "위키북스", "2015-04-01", 3);
      bookDao.Inselt("패션왕", "중앙북스(books)", "2012-02-22", 4);
      bookDao.Inselt("순정만화", "재미주의", "2011-08-03", 5);
      bookDao.Inselt("오직두사람", "문학동네", "2017-05-04", 6);
      bookDao.Inselt("26년", "재미주의", "2012-02-04", 5);
      bookDao.Inselt("발렌타인 24년", "샷잔", "2022-05-23", 7);
      */
      
      //bookDao.bookUpdate( "사파이어블루", "레몬", "2018-09-18", 9);
      
      //bookDao.authorDelete(9);
      
      List <BooKVo> bookList = bookDao.bookSelect();
      for(int i=0; i<bookList.size(); i++) {
    	  
    	  BooKVo bookVo = bookList.get(i);
    	  System.out.println(bookVo.getTitle()+","+bookVo.getPubs()+","
    			  			+bookVo.getPubDate()+","+bookVo.getAuthorName());
      }
   }

}