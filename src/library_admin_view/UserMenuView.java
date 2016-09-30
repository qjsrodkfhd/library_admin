package library_admin_view;

import java.util.Scanner;

import library_admin_controller.Controllers;

public class UserMenuView {
	
	private Scanner keyboard;
	
	public UserMenuView()
	{
		keyboard = new Scanner(System.in);
	}

	public void showMenu() {
		System.out.println("1.회원가입, 2.회원조회, 3.회원수정  4.메인메뉴로 돌아가기");
		int number = keyboard.nextInt();
		
		if(number == 1)
		{
			Controllers.getUserController().requestRegisterUser();
		}
		else if(number == 2)
		{
			Controllers.getUserController().requestSelectAllUser();
		}
		else if(number == 3)
		{
			Controllers.getUserController().requestUpdateUser();
		}
		
	}

}
