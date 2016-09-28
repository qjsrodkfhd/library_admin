package library_admin_controller;

import library_admin_dao.UserDao;

public class UserController {

	private UserDao userDao;

	public UserController() {

		userDao = new UserDao();

	}

}
