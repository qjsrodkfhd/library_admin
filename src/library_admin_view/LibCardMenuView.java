package library_admin_view;

import java.util.Scanner;

import library_admin_controller.Controllers;

public class LibCardMenuView {
	
	private Scanner keyboard;
	
	public LibCardMenuView()
	{
		keyboard = new Scanner(System.in);
	}

	public void menu() {
		System.out.println("대출카드메뉴");
		System.out.println("1.대출카드생성, 2.대출카드목록, 3.대출카드수정, 4.대출카드삭제, 5.메인메뉴");
		int libCardNumber = keyboard.nextInt();
		while(true)
		{
			if(libCardNumber == 1)
			{
				Controllers.getLibCardController().requestRegisterLibCard();
			}
			else if(libCardNumber == 2)
			{
				
			}
			else if(libCardNumber == 3)
			{
				
			}
			else if(libCardNumber == 4)
			{
				
			}
			else if(libCardNumber == 5)
			{
				
			}
			else
			{
				System.out.println("다시입력하세요");
			}
		}
		
	}

}
