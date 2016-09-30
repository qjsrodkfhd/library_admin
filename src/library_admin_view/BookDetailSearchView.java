package library_admin_view;

import java.util.Scanner;

public class BookDetailSearchView {

	private Scanner keyboard;

	public BookDetailSearchView() {

		keyboard = new Scanner(System.in);

	}

	public int bookDetailInfo() {

		System.out.println("[바코드 번호] : ");
		int barcodeNumber = keyboard.nextInt();

		return barcodeNumber;
	}
}
