package library_admin_domain;

import java.sql.Date;

public class BookLoan {


	private int LoanNumber;
	private String BookLoanTF = "f";
	private Date BookLoanDate;
	private String AdminId;
	private int UserBarCode;
	private int BookBarCode;
	
	public BookLoan(int userBarcode2, int bookBarcode2) {
		UserBarCode = userBarcode2;
		BookBarCode = bookBarcode2;
	}
	public BookLoan() {
		// TODO Auto-generated constructor stub
	}

	public int getLoanNumber() {
		return LoanNumber;
	}
	public void setLoanNumber(int loanNumber) {
		LoanNumber = loanNumber;
	}
	public String getBookLoanTF() {
		return BookLoanTF;
	}
	public void setBookLoanTF(String bookLoanTF) {
		BookLoanTF = bookLoanTF;
	}
	public Date getBookLoanDate() {
		return BookLoanDate;
	}
	public void setBookLoanDate(Date bookLoanDate) {
		BookLoanDate = bookLoanDate;
	}
	public String getAdminId() {
		return AdminId;
	}
	public void setAdminId(String adminId) {
		AdminId = adminId;
	}
	public int getUserBarCode() {
		return UserBarCode;
	}
	public void setUserBarCode(int userBarCode) {
		UserBarCode = userBarCode;
	}
	public int getBookBarCode() {
		return BookBarCode;
	}
	public void setBookBarCode(int bookBarCode) {
		BookBarCode = bookBarCode;
	}
	
	

}
