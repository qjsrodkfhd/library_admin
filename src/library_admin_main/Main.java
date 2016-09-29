package library_admin_main;

import library_admin_controller.Controllers;
import library_admin_controller.LoginController;

public class Main {

	public static void main(String[] args) {
		
		new Controllers();
		LoginController loginController = Controllers.getLoginControlles();
		//loginController.requestMainLogin();
		loginController.requestLogin();

	}

}
