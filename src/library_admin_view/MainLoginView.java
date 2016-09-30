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

			System.out.print(
					"[1. 도서대출, 2. 도서반납, 3. 로그아웃 , 4. 관리자 탈퇴 , 5. 희망도서 관리, 6. 대출카드 관리, 7. 장르관리 , 8. 사용자관리, 9. 도서관리 0. 프로그램 종료] : ");

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
				Controllers.getLoginControlles().requestLogOut();
				break;
			case 4:
				System.out.println("관리자 가입");
				Controllers.getAdminController().requestRegister();
				break;
			case 5:
				System.out.println("희망도서 관리");
				Controllers.getSearchHopeBookController().requestSearchHopeBookMenu();
				break;
			case 6:
				System.out.println("대출카드");
				Controllers.getLibCardController().requestLibMenu();
				break;
			case 7:
				System.out.println("장르관리");
				Controllers.getGenreController().requestGenreMgm();
				break;
			case 8:
				System.out.println("사용자관리");
				Controllers.getUserController().requestUser();
				break;
			case 9:
				System.out.println("도서관리");
				Controllers.getBookController().requestBookManegement();
				break;
			case 0:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("메뉴를 다시 선택해 주세요.");
			}
		}

	}

}
