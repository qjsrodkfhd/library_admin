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
		System.out.println("1.대출카드생성, 2.대출카드목록, 3.대출카드삭제, 0.메인메뉴");
		int libCardNumber = keyboard.nextInt();
		while(true)
		{
			if(libCardNumber == 1)
			{
				Controllers.getLibCardController().requestRegisterLibCard();
			}
			else if(libCardNumber == 2)
			{
				Controllers.getLibCardController().requestPrintAllLibCard();
			}
			else if(libCardNumber == 3)
			{
				Controllers.getLibCardController().requestPrintAllForLibCardDelete();
				System.out.println("삭제할 대출카드의 바코드번호를 입력하세요");
				int number = keyboard.nextInt();
				Controllers.getLibCardController().requestDeleteLibCard(number);
			}
			else if(libCardNumber == 0)
			{
				Controllers.getLoginControlles().requestMainLogin();
			}
			else
			{
				System.out.println("다시입력하세요");
				this.menu();
			}
		}
		
	}

}
