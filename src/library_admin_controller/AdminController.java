package library_admin_controller;

import library_admin_dao.AdminDao;
import library_admin_domain.Admin;
import library_admin_view.AdminRegisterView;
import library_admin_view.AlertView;

public class AdminController {
	
	private AdminDao adminDao;

	public AdminController() {

		adminDao = new AdminDao();

	}

	public void requestRegister() {
		AdminRegisterView adminRegisterView = new AdminRegisterView();
		Admin adminInfo = adminRegisterView.getAdminInfo();
		
		boolean success = adminDao.insertAdmin(adminInfo);
		AlertView alertView = new AlertView();
		if(success)
		{
			alertView.alert("회원가입 성공");
		}
		else
		{
			alertView.alert("회원가입 실패");
		}
		
		Controllers.getLoginControlles().requestMainLogin();
	}

}
