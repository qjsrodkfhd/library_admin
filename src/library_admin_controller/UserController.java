package library_admin_controller;

import java.util.ArrayList;

import library_admin_dao.UserDao;
import library_admin_domain.User;
import library_admin_view.AlertView;
import library_admin_view.UserMenuView;
import library_admin_view.UserPrintAllView;
import library_admin_view.UserPrintOneView;
import library_admin_view.UserRegisterInfoView;
import library_admin_view.UserUpdateSelectView;
import library_admin_view.UserUpdateView;

public class UserController {

	private UserDao userDao;

	public UserController() {

		userDao = new UserDao();

	}

	public void requestUser() {
		ArrayList<User> users = userDao.selectAllUser();
		UserPrintAllView UserPrintAllView = new UserPrintAllView();
		UserPrintAllView.printAllUser(users);
		UserMenuView userMenuView = new UserMenuView();
		userMenuView.showMenu();
		
		
	}
	
	public void requestRegisterUser()
	{
		UserRegisterInfoView userRegisterInfoView = new UserRegisterInfoView();
		User user = userRegisterInfoView.getInfo();
		
		User user2 = userDao.generateinsert(user);
		boolean success = userDao.insertUser(user2);
		
		if (success) {
			System.out.println("회원가입 성공!");
		} else {
			System.out.println("중복된 아이디가 있습니다.");
		}
	}

	public void requestSelectAllUser() {
		ArrayList<User> users = userDao.selectAllUser();
		UserPrintAllView UserPrintAllView = new UserPrintAllView();
		UserPrintAllView.printAllUser(users);
		this.requestUser();
		
	}

	public void requestUpdateUser() {
		UserUpdateView userUpdateView = new UserUpdateView();
		int getBarcode = userUpdateView.getUpdateInfo();
		User user = userDao.selectOneUser(getBarcode);
		UserPrintOneView userPrintOneView = new UserPrintOneView();
		userPrintOneView.printOneUser(user);
		UserUpdateSelectView userUpdateSelectView = new UserUpdateSelectView();
		userUpdateSelectView.updateView(getBarcode);
		
	}

	public void requestUpdateUserName(int getBarcode, String updateName) {
		boolean success = userDao.updateUserName(getBarcode, updateName);
		if(success)
		{
			AlertView alertView = new AlertView();
			alertView.alert("이름수정성공");
		}
		
	}

	public void requestUpdateUserAddr(int getBarcode, String updateAddr) {
		boolean success = userDao.updateUserAddr(getBarcode, updateAddr);
		if(success)
		{
			AlertView alertView = new AlertView();
			alertView.alert("주소수정성공");
		}
		
	}

	public void requestUpdateUserTel(int getBarcode, String updateTel) {
		boolean success = userDao.updateUserTel(getBarcode, updateTel);
		if(success)
		{
			AlertView alertView = new AlertView();
			alertView.alert("전화번호 수정성공");
		}
		
	}

}
