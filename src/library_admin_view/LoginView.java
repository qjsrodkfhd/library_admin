package library_admin_view;

import java.util.Scanner;

import library_admin_domain.Login;




public class LoginView {
	
	private Scanner keyboard;
	
	public LoginView(){
		
		keyboard = new Scanner(System.in);
		
	}

	public Login getLoginInfo() {
		
		System.out.println("[ * 로그인 페이지 입니다. * ] ");
		System.out.println("[ ID를 입력하세요:        ] ");
		String login_Id = keyboard.next();
		System.out.println("[ PW를 입력하세요:        ] ");
		String login_pw = keyboard.next();
		
		Login login = new Login(login_Id, login_pw);
		
		return login;
	}

	
}
