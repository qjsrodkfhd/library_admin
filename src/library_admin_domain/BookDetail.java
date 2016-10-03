package library_admin_domain;

import java.sql.Date;

public class BookDetail {

	private String bookName; // 책이름
	private String bookAuthor; // 저자
	private String bookPublisher; // 출판사
	private String BookLoanTF = "f";
	private Date BookLoanDate;
	private String GenreName;

	public BookDetail() {

	}

	public BookDetail(String bookName, String bookAuthor, String bookPublisher, String bookLoanTF, Date bookLoanDate,
			String genreName) {

		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		BookLoanTF = bookLoanTF;
		BookLoanDate = bookLoanDate;
		GenreName = genreName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookLoanTF() {
		return BookLoanTF;
	}

	public void setBookLoanTF(String bookLoanTF) {
		BookLoanTF = bookLoanTF;
	}

	public Date getBookLoanDate() {
		return BookLoanDate;
	}

	public void setBookLoanDate(Date bookLoanDate) {
		BookLoanDate = bookLoanDate;
	}

	public String getGenreName() {
		return GenreName;
	}

	public void setGenreName(String genreName) {
		GenreName = genreName;
	}

}
