package library_admin_domain;

public class Book {

	private int bookBarcode; // 대출현황바코드
	private String bookName; // 책이름
	private String bookAuthor; // 저자
	private String bookPublisher; // 출판사
	private String genreCode; // 분야
	

	public Book() {
	}


	public int getBookBarcode() {
		return bookBarcode;
	}


	public void setBookBarcode(int bookBarcode) {
		this.bookBarcode = bookBarcode;
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


	public String getGenreCode() {
		return genreCode;
	}


	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}
	
	

}
