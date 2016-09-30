package library_admin_view;

import java.util.ArrayList;
import java.util.Scanner;

import library_admin_controller.Controllers;
import library_admin_domain.LibCard;

public class LibCardPrintAllView {

	private Scanner keyboard;
	
	public LibCardPrintAllView()
	{
		keyboard = new Scanner(System.in);
	}
	
	public void printAllLibCard(ArrayList<LibCard> libCards) {
		System.out.println("대출카드바코드번호\t대출카드발급일\t대출카드만료일\t발급관리자\t유저바코드번호");
		for(int i = 0; i < libCards.size(); i++)
		{
			System.out.print(libCards.get(i).getLibCardBarcode() + "\t");
			System.out.print(libCards.get(i).getLibCardIssDate()+ "\t");
			System.out.print(libCards.get(i).getLibCardExpDate()+ "\t");
			System.out.print(libCards.get(i).getAdminId()+ "\t");
			System.out.println(libCards.get(i).getUserBarcode());
		}
		
	}

	public void showMenu() {
		System.out.println("1.상세조회  2.대출카드메뉴로");
		int number = keyboard.nextInt();
		
		if(number == 1)
		{
			System.out.print("조회할 대출카드바코드번호 : ");
			int barcode = keyboard.nextInt();
			Controllers.getLibCardController().requestPrintOneLibCard(barcode);
		}
		else if(number == 2)
		{
			Controllers.getLibCardController().requestLibMenu();
		}
		else
		{
			System.out.println("잘못입력하셨습니다.");
			Controllers.getLibCardController().requestLibMenu();
		}
		
	}

}
