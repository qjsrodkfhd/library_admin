package library_admin_view;

import java.util.Scanner;

public class UserUpdateView {
	
	private Scanner keyboard;
	
	public UserUpdateView()
	{
		keyboard = new Scanner(System.in);
	}

	public int getUpdateInfo() {
		System.out.print("사용자바코드번호 : ");
		int number = keyboard.nextInt();
		
		return number;
		
	}

}
