package library_admin_view;

import java.util.Scanner;

import library_admin_controller.Controllers;

public class BookManagementView {
	private Scanner keyboard;

	public BookManagementView() {

		keyboard = new Scanner(System.in);
	}

	public void getBookManageChoose() {
		System.out.println("[ * 도서관리 페이지 * ]");
		
		System.out.println("[1. 도서추가, 2.도서조회, 3.도서수정, 4. 메인 메뉴]");
		int selectMenu = keyboard.nextInt();
		
		switch(selectMenu){
		case 1:
			
			Controllers.getBookController().requestBookAdd();
			break;
			
		case 2:
			
			Controllers.getBookController().requestBookList();
			break;
			
		case 3:
			
			Controllers.getBookController().requestBookUpdate();
			break;
			
		case 4:
			
			Controllers.getLoginControlles().requestMainLogin();
			break;
			
		default:
			System.out.println("메뉴를 다시 선택해 주세요.");
		}

	}

}
