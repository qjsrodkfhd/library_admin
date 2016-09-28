package library_admin_view;

import java.util.Scanner;

import library_admin_controller.Controllers;

public class MainLoginView {

	private Scanner keyboard;

	public MainLoginView() {

		keyboard = new Scanner(System.in);

	}

	public void showMainPage() {

		while (true) {

			boolean success = Controllers.getLoginControlles().requestLoginCheck();

			if(!success){
				System.out.print("[1. 도서대출, 2. 도서반납, 3. 로그인, 4. 관리자 가입 , 5. 도서반납예정날짜 테스트, 6. 대출카드생성, 0. 프로그램 종료] : ");
			}else{
				System.out.print("[1. 도서대출, 2. 도서반납, 3. 로그아웃 , 4. 관리자 탈퇴 , 5. 도서반납예정날짜 테스트,, 6. 대출카드생성,  0. 프로그램 종료] : ");
			}


			int selectedMenu = keyboard.nextInt();

			switch (selectedMenu) {
			case 1:
				System.out.println("도서대출 페이지 입니다.");
				Controllers.getBookController().requestLoanBook();
				break;
			case 2:
				System.out.println("도서반납 페이지 입니다.");
				Controllers.getBookController().requestReturnBook();
				break;
			case 3:
				if (!success) {
					Controllers.getLoginControlles().requestLogin();
				} else {
					Controllers.getLoginControlles().requestLogOut();
				}
				break;
			case 4:
				System.out.println("관리자 가입");
				Controllers.getAdminController().requestRegister();
				System.exit(0);
			case 5:
				System.out.println("대출내역 + 반납예정날짜 출력");
				Controllers.getBookController().requestPrintBookLoanList();
				System.exit(0);
			case 6:
				System.out.println("대출카드");
				Controllers.getLibCardController().requestRegisterLibCard();
				System.exit(0);
			case 0:
				System.out.println("프로그램 종료");
				System.exit(0);
			default:
				System.out.println("메뉴를 다시 선택해 주세요.");
			}
		}

	}

}
