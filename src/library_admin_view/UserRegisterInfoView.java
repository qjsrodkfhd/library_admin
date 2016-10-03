package library_admin_view;

import java.util.Scanner;

import library_admin_domain.User;


public class UserRegisterInfoView {
	
	private Scanner keyboard;
	
	public UserRegisterInfoView()
	{
		keyboard = new Scanner(System.in);
	}

	public User getInfo() {
		User user = null;
		System.out.println("[회원가입 페이지 접속]");
		while (true) {

			System.out.print("[ID] : ");
			String userId = keyboard.next();
			System.out.print("[[PW] : ");
			String userPw = keyboard.next();
			System.out.print("[회원이름] : ");
			String userName = keyboard.next();
			System.out.print("[주소] : ");
			String userAddr = keyboard.next();
			System.out.print("[전화번호] : ");
			String userTel = keyboard.next();
			System.out.print("[성별 M/F] : ");
			String userGender = keyboard.next();

			if (userGender.equals("M") || userGender.equals("F")) {
				user = new User(userId, userPw, userName, userAddr, userTel, userGender);
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}
		return user;
		
	}

}
