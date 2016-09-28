package library_admin_view;

import java.util.Scanner;

import library_admin_controller.Controllers;

public class GenreMainPage {

	private Scanner keyBoard;

	public GenreMainPage(){

		keyBoard = new Scanner(System.in);

	}

	public void genreMenu() {

		boolean success = Controllers.getLoginControlles().requestLoginCheck();
		
		if(!success){
			System.out.println(" 로그인을 먼저 시도하세요. ");
			Controllers.getLoginControlles().requestMainLogin();
		}else{
			//장르 리스트 뿌려주기
			System.out.print("[1. 장르추가, 2. 장르 리스트, 3. 장르수정 , 4. 장르 관리 테이블, 5. 메인페이지] : ");
		}
		
		int selectedMenu = keyBoard.nextInt();
		
		switch (selectedMenu) {
		
		case 1:
			System.out.println("장르추가 페이지 입니다.");
			Controllers.getGenreController().requestInsertGenre();
			break;
		case 2:
			System.out.println("장르 리스트  페이지 입니다.");
			
			break;
		case 3:
			System.out.println("장르 수정 페이지 입니다.");
			break;
		case 4:
			System.out.println("장르 관리 테이블 페이지 입니다.");
			Controllers.getGenreController().requestGenreMgmList();
			break;
		case 5:
			System.out.println("메인페이지 입니다.");
			Controllers.getLoginControlles().requestMainLogin();
		default:
			System.out.println("메뉴를 다시 선택해 주세요.");
			genreMenu();
		}

	}

}
