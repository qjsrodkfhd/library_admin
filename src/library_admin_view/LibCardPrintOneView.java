package library_admin_view;

import java.sql.Date;

import library_admin_domain.LibCardDetailInfo;

public class LibCardPrintOneView {

	public void printOneLibCard(LibCardDetailInfo libCard) {
		if(libCard.getLibCardIssDate() == null)
		{
			System.out.println("조회실패");
		}
		else
		{
			System.out.println("대출카드바코드번호\t대출카드발급일\t대출카드만료일\t발급관리자\t유저바코드번호\t유저아이디\t유저패스워드\t유저이름\t유저주소\t유저전화번호\t유저성별\t유저가입일");

			System.out.print(libCard.getUserBarcode() + "\t");
			System.out.print(libCard.getLibCardIssDate()+ "\t");
			System.out.print(libCard.getLibCardExpDate()+ "\t");
			System.out.print(libCard.getAdminId()+ "\t");
			System.out.print(libCard.getUserBarcode()+ "\t");
			System.out.print(libCard.getUserName()+ "\t");
			System.out.print(libCard.getUserPw()+ "\t");
			System.out.print(libCard.getUserName()+ "\t");
			System.out.print(libCard.getUserAddr()+ "\t");
			System.out.print(libCard.getUserTel()+ "\t");
			System.out.print(libCard.getUserGender()+ "\t");
			System.out.println(libCard.getUserregdate()+ "\t");
		}

	}



}
