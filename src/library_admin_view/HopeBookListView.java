package library_admin_view;

import java.util.ArrayList;
import java.util.Scanner;

import library_admin_controller.Controllers;
import library_admin_domain.HopeBook;

public class HopeBookListView {

	private Scanner keyboard;

	public HopeBookListView(){

		keyboard = new Scanner(System.in);

	}

	public void hopeBookList(ArrayList<HopeBook> hopeBookList) {

		System.out.println("                   [ 희망 도서 목록 ]                   ");
		System.out.println("---------------------------------------------------");

		if(hopeBookList.size() == 0){
			System.out.println("찾으시는 제품이 없습니다.");
		}else{

			System.out.println("[ 번호   |  책 이름   |  저자   |  출판사   |  개수    |  가격  ]");
			for(int i = 0; i < hopeBookList.size(); i++){

				System.out.print(hopeBookList.get(i).getRequestBookNumber() + "\t");
				System.out.print(hopeBookList.get(i).getRequestBookName() + "\t");
				System.out.print(hopeBookList.get(i).getRequestBookAuthor() + "\t");
				System.out.print(hopeBookList.get(i).getRequestBookPublusher() + "\t");
				System.out.print(hopeBookList.get(i).getRequestBookCountNumber() + "\t");
				System.out.println(hopeBookList.get(i).getRequestBookPrice());

			}

			hopeBookMenu();
		}
	}
	
	public void hopeBookMenu(){

		System.out.println("[ 1. 희망도서 구매, 2. 희망도서 삭제, 3. 구매내역리스트, 4. 메인메뉴 ]");
		int selectedMenu = keyboard.nextInt();

		switch(selectedMenu){
		case 1:
			System.out.println("희망도서 구매 페이지 입니다.");
			
			System.out.println("[구매하실려는 '번호'를 선택해주세요] : ");
			int buyBookNumber = keyboard.nextInt();
			Controllers.getSearchHopeBookController().requesHopeBookBuy(buyBookNumber);
			break;
			
		case 2:
			System.out.println("희망도서 삭제 페이지 입니다.");
			
			System.out.println("[삭제하실 '번호'를 입력하세요] : ");
			int deleteNumber = keyboard.nextInt();
			Controllers.getSearchHopeBookController().requestHopeBookDelete(deleteNumber);
			break;
			
		case 3:
			System.out.println("구매내역 리스트 페이지 입니다");
			break;
			
		case 4:
			Controllers.getLoginControlles().requestMainLogin();
			break;
			
		default:
			System.out.println("메뉴를 다시 선택해 주세요.");
		}

	}

}


