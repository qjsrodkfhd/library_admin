package library_admin_view;

import java.util.Scanner;

import library_admin_controller.Controllers;

public class UserUpdateSelectView {

	private Scanner keyboard;
	
	public UserUpdateSelectView()
	{
		keyboard = new Scanner(System.in);
	}
	
	public void updateView(int getBarcode) {
		System.out.println("1.이름수정 , 2. 주소수정, 3.전화번호수정  4.메인페이지");
		int number = keyboard.nextInt();
		
		if(number == 1)
		{
			System.out.print("수정하실 이름을 입력하세요 : ");
			String updateName = keyboard.next();
			Controllers.getUserController().requestUpdateUserName(getBarcode, updateName);
		}
		else if(number == 2)
		{
			System.out.print("수정하실 주소을 입력하세요 : ");
			String updateAddr = keyboard.next();
			Controllers.getUserController().requestUpdateUserAddr(getBarcode, updateAddr);
		}
		else if(number == 3)
		{
			System.out.print("수정하실 전화번호를 입력하세요 : ");
			String updateTel = keyboard.next();
			Controllers.getUserController().requestUpdateUserTel(getBarcode, updateTel);
		}
		else
		{
			System.out.println("잘못입력하셨습니다.");
			Controllers.getLoginControlles().requestMainLogin();
		}
			
		
	}

}
