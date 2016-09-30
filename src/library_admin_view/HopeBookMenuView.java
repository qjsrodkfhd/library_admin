package library_admin_view;

import java.util.Scanner;

import library_admin_controller.Controllers;

public class HopeBookMenuView {
	
	private Scanner keyboard;
	
	public HopeBookMenuView(){
		
		keyboard = new Scanner(System.in);
		
	}

	public void hopeBookMenuList() {
		
		System.out.println("         [ 희망 도서 관리 ]        ");
		System.out.println("------------------------------");
		System.out.println("[ 1. 희망한 도서 정보 보기, 2. 메인 메뉴 ]");
		int selectedMenu = keyboard.nextInt();
		
		switch(selectedMenu){
		
		case 1: 
			System.out.println("희망 도서 정보 보기 페이지 입니다.");
			Controllers.getSearchHopeBookController().requestSearchHopeBookList();
			break;
			
		case 2:
			Controllers.getLoginControlles().requestMainLogin();
			break;
			
		default:
			System.out.println("메뉴를 다시 선택해 주세요.");	
		}
		
	}
	
	
}
