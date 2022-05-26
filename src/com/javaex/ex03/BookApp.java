package com.javaex.ex03;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		
		BookDao bookDao = new BookDao();
		/*
		BookVo v01 = new BookVo("우리들의 일그러진 영웅","다림","1998-02-22","이문열"); 
		BookVo v02 = new BookVo("삼국지","민음사","2002-03-01","이문열"); 
		BookVo v03 = new BookVo("토지","마로니에북스","2012-08-15","박경리"); 
		BookVo v04 = new BookVo("자바프로그래밍 입문","위키북스","2015-04-01","이고잉"); 
		BookVo v05 = new BookVo("패션왕","중앙북스(books)","2012-02-22","기안84"); 
		BookVo v06 = new BookVo("순정만화","재미주의","2011-08-03","강풀"); 
		BookVo v07 = new BookVo("오직두사람","문학동네","2017-05-04","김영하"); 
		BookVo v08 = new BookVo("26년", "재미주의", "2012-08-04", "강풀"); 
		BookVo v09 = new BookVo("수박마시쪄","수박띄","2012-05-24","정수박"); 
		
		bookDao.bookInsert(v01);
		bookDao.bookInsert(v02);
		bookDao.bookInsert(v03);
		bookDao.bookInsert(v04);
		bookDao.bookInsert(v05);
		bookDao.bookInsert(v06);
		bookDao.bookInsert(v07);
		bookDao.bookInsert(v08);
		bookDao.bookInsert(v09);
		
		BookVo uVo = new BookVo("딸기마시쪄","딸기띄","2012-05-25","정딸기",9);
		bookDao.bookUpdate(uVo);
		
		int dCount = bookDao.bookDelete(9);
		System.out.println("삭제건수:" + dCount );
		*/ 
		
		List<BookVo> bookList = bookDao.bookSelect();
		for(int i=0; i<bookList.size(); i++) {
			
			BookVo bookVo = bookList.get(i);
			System.out.println(bookVo.getBookId() + ", " + 
			                   bookVo.getTitle() + ", " +
			                   bookVo.getPubs() + ", " +
			                   bookVo.getPubDate() + ", " +
					           bookVo.getAuthorName() );
			if(bookList.get(i).toString().contains("삼국지")) {
				System.out.println("반복문 탈출 :"+bookList.get(i).toString());
			}
		}
	}
}
