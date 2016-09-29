package library_admin_controller;

import library_admin_dao.LibDao;
import library_admin_domain.LibCard;
import library_admin_view.LibCardMenuView;
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
		Controllers.getLoginControlles().requestMainLogin();
		
	}

	public void requestLibMenu() {
		LibCardMenuView libCardMenuView = new LibCardMenuView();
		libCardMenuView.menu();
		
	}

}
