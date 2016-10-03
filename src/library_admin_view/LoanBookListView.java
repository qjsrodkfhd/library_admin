package library_admin_view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import library_admin_domain.BookLoan;

public class LoanBookListView {

	public void printLoanBookList(ArrayList<BookLoan> bookLoanList) {

		System.out.println("대출번호\t유저바코드번호\t책바코드번호\t대출여부\t관리자아이디\t대출일\t대출예정일짜");
		for(int i = 0; i < bookLoanList.size(); i++)
		{
			System.out.print(bookLoanList.get(i).getLoanNumber() + "\t");
			System.out.print(bookLoanList.get(i).getUserBarCode() + "\t\t");
			System.out.print(bookLoanList.get(i).getBookBarCode() + "\t");
			System.out.print(bookLoanList.get(i).getBookLoanTF() + "\t");
			System.out.print(bookLoanList.get(i).getAdminId() + "\t");
			System.out.print(bookLoanList.get(i).getBookLoanDate() + "\t");
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(bookLoanList.get(i).getBookLoanDate());
			cal.add(Calendar.DATE, 14);
			String loanDay = format.format(cal.getTime());
			
			System.out.println(loanDay);
		}
		
	}

}
