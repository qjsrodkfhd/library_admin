package library_admin_view;

import java.util.Scanner;

public class LibCardView {
	
	private Scanner keyboard;
	
	public LibCardView()
	{
		keyboard = new Scanner(System.in);
	}

	public int getUserbarcode() {
		System.out.print("대출카드에 등록할 유저 바코드번호를 입력 : ");
		int userBarcode = keyboard.nextInt();
		return userBarcode;
	}

}
