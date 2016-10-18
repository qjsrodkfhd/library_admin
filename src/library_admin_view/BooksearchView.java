package library_admin_view;

import java.util.ArrayList;
import java.util.Scanner;

import library_admin_controller.Controllers;
import library_admin_domain.Book;

public class BooksearchView {
	private Scanner keyboard;

	public BooksearchView() {

		keyboard = new Scanner(System.in);
	}

	public void searchedBookList(ArrayList<Book> bookList) {

		if (bookList.size() == 0) {

			System.out.println("찾으시는  책이 없습니다.");

		} else {

			System.out.println("[ 바코드 번호    |  책이름    |  저자    |  출판사    |  장르 ]");

			for (int i = 0; i < bookList.size(); i++) {

				System.out.print(" " + " " + bookList.get(i).getBookBarcode() + "\t");
				System.out.print(" " + bookList.get(i).getBookName() + "\t");
				System.out.print(" " + bookList.get(i).getBookAuthor() + "\t");
				System.out.print(" " + bookList.get(i).getBookPublisher() + "\t");
				System.out.println(" " + bookList.get(i).getGenreCode() + "\t");

			}
			System.out.println("[ 1.상세조회, 0. 메인페이지 ]");
			int number = keyboard.nextInt();

			if (number == 1) {
				System.out.println("상세조회");
				Controllers.getBookController().requestBookDetailSeacrch();
			} else if (number == 0) {
				Controllers.getLoginControlles().requestMainLogin();
			} else {
				System.out.println("메뉴를 다시 골라주세요.");
			}

		}
	}


}
