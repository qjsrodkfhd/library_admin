package library_admin_view;

import java.util.Scanner;

import library_admin_domain.Admin;

public class AdminRegisterView {
	
	private Scanner keyboard;
	
	public AdminRegisterView()
	{
		keyboard = new Scanner(System.in);
	}

	public Admin getAdminInfo() {
		System.out.print("관리자 아이디를 입력 하세요 : ");
		String adminId = keyboard.next();
		System.out.print("관리자 비밀번호를 입력 하세요 : ");
		String adminPw = keyboard.next();
		System.out.print("관리자 직급을 입력하세요 : ");
		String adminPos = keyboard.next();
		System.out.print("관리자 이름을 입력하세요 : ");
		String adminName = keyboard.next();
		
		Admin admin = new Admin(adminId, adminPw, adminPos, adminName);
		
		return admin;
		
		
	}

}
