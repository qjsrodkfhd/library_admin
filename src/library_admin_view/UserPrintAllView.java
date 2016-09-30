package library_admin_view;

import java.util.ArrayList;

import library_admin_domain.User;

public class UserPrintAllView {
	
	public void printAllUser(ArrayList<User> users) {
		System.out.println("사용자바코드번호\t사용자아이디\t사용자비밀번호\t사용자이름\t사용자주소\t사용자전화번호\t성별\t가입날따");
		for(int i = 0; i <users.size(); i++)
		{
			System.out.print(users.get(i).getUserBarcode() + "\t");
			System.out.print(users.get(i).getUserId() + "\t");
			System.out.print(users.get(i).getUserPw() + "\t");
			System.out.print(users.get(i).getUserName() + "\t");
			System.out.print(users.get(i).getUserAddr() + "\t");
			System.out.print(users.get(i).getUserTel() + "\t");
			System.out.print(users.get(i).getUserGender() + "\t");			
			System.out.println(users.get(i).getUserRegDate());
		}
		
	}

}
