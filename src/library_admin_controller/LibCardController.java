package library_admin_controller;

import java.util.ArrayList;

import library_admin_dao.LibDao;
import library_admin_domain.LibCard;
import library_admin_domain.LibCardDetailInfo;
import library_admin_view.LibCardMenuView;
import library_admin_view.LibCardPrintAllView;
import library_admin_view.LibCardPrintOneView;
import library_admin_view.LibCardView;

public class LibCardController {

	private LibDao libDao;

	public LibCardController()
	{
		libDao = new LibDao();
	}

	public void requestRegisterLibCard() 
	{
		LibCardView libCardView = new LibCardView();
		int userBarcode = libCardView.getUserbarcode();
		String adminId = Controllers.getLoginControlles().requestLoginInfo().getLogin_Id();
		LibCard libCard = new LibCard(userBarcode, adminId);
		boolean success = libDao.insertLibCard(libCard);
		this.requestLibMenu();

	}

	public void requestLibMenu() {
		LibCardMenuView libCardMenuView = new LibCardMenuView();
		libCardMenuView.menu();

	}

	public void requestPrintAllLibCard() {
		ArrayList<LibCard> libCards = new ArrayList<LibCard>();
		libCards = libDao.selectAllLibCard();
		LibCardPrintAllView libCardPrintAllView = new LibCardPrintAllView();
		libCardPrintAllView.printAllLibCard(libCards);
		libCardPrintAllView.showMenu();
		this.requestLibMenu();

	}

	public void requestPrintOneLibCard(int barcode) {

		LibCardDetailInfo libCardDetailInfo = new LibCardDetailInfo();
		libCardDetailInfo = libDao.selectOneLibCard(barcode);
		LibCardPrintOneView libCardPrintOneView = new LibCardPrintOneView();
		libCardPrintOneView.printOneLibCard(libCardDetailInfo);
		this.requestLibMenu();

	}

	public void requestPrintAllForLibCardDelete()
	{

		ArrayList<LibCard> libCards = new ArrayList<LibCard>();
		libCards = libDao.selectAllLibCard();
		LibCardPrintAllView libCardPrintAllView = new LibCardPrintAllView();
		libCardPrintAllView.printAllLibCard(libCards);
	}

	public void requestDeleteLibCard(int number) {
		boolean success = libDao.deleteLibCard(number);
		if(success)
		{
			System.out.println("삭제성공");
		}
		else
		{
			System.out.println("삭제실패");
		}
		this.requestLibMenu();


	}

}
