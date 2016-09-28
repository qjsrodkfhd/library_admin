package library_admin_view;

import java.util.Scanner;

import library_admin_domain.BookLoan;

public class BookLoanView {
	
	private Scanner keyboard;
	
	public BookLoanView()
	{
		keyboard = new Scanner(System.in);
	}

	public BookLoan getInfo() {

		   
		System.out.print("도서대출자의 바코드 번호 : ");
		int userBarcode = keyboard.nextInt();
		System.out.print("책의 바코드 번호");
		int bookBarcode = keyboard.nextInt();
		
		BookLoan bookLoan = new BookLoan(userBarcode, bookBarcode);
		
		return bookLoan;
		
		
	}

}
