package library_admin_view;

import library_admin_domain.User;

public class UserPrintOneView {

	public void printOneUser(User user) {
		System.out.println("사용자바코드번호\t사용자아이디\t사용자비밀번호\t사용자이름\t사용자주소\t사용자전화번호\t성별\t가입날따");

		System.out.print(user.getUserBarcode() + "\t");
		System.out.print(user.getUserId() + "\t");
		System.out.print(user.getUserPw() + "\t");
		System.out.print(user.getUserName() + "\t");
		System.out.print(user.getUserAddr() + "\t");
		System.out.print(user.getUserTel() + "\t");
		System.out.print(user.getUserGender() + "\t");			
		System.out.println(user.getUserRegDate());


	}

}
