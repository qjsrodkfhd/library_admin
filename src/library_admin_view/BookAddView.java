package library_admin_view;

import java.util.Scanner;

import library_admin_domain.Book;

public class BookAddView {

	private Scanner keyboard;

	public BookAddView() {

		keyboard = new Scanner(System.in);
	}

	public Book addBook() {

		System.out.println("[ * 도서 추가 페이지  * ]");
		System.out.println("[책 이름] :");
		String bookName = keyboard.next();
		System.out.println("[저자] : ");
		String bookAuthor = keyboard.next();
		System.out.println("[출판사] : ");
		String bookPublisher = keyboard.next();
		System.out.println("[장르 코드] : ");
		String genreCode = keyboard.next();

		Book book = new Book(bookName, bookAuthor, bookPublisher, genreCode);

		return book;
	}

}
