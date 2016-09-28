package library_admin_view;

import java.util.Scanner;

import library_admin_domain.BookLoan;

public class BookReturnView {
	
	private Scanner keyboard;

	public BookReturnView()
	{
		keyboard = new Scanner(System.in);
	}
	
	public int getInfo() {
		
		System.out.print("도서바코드번호 : ");
		int bookBarcode = keyboard.nextInt();
		
		return bookBarcode;
	}

}
