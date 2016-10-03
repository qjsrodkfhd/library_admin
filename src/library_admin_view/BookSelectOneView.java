package library_admin_view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import library_admin_domain.BookDetail;

public class BookSelectOneView {

	public void outputOneBook(BookDetail bookInfo) {
		
		System.out.println("[  책이름  |  책저자  |  출판사  |  장르  |  대출여부  |  대출날짜  |  반납예정날짜  ]");

		System.out.print(bookInfo.getBookName() + "\t");
		System.out.print(bookInfo.getBookAuthor() + "\t");
		System.out.print(bookInfo.getBookPublisher() + "\t");
		System.out.print(bookInfo.getGenreName() + "\t");
		System.out.print(bookInfo.getBookLoanTF() + "\t");
		System.out.print(bookInfo.getBookLoanDate() + "\t");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(bookInfo.getBookLoanDate());
		cal.add(Calendar.DATE, 14);
		String loanDay = format.format(cal.getTime());
		System.out.println(loanDay);

	}
}
