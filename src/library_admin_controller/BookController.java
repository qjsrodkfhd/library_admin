package library_admin_controller;

import java.util.ArrayList;

import library_admin_dao.BookDao;
import library_admin_domain.Book;
import library_admin_domain.BookLoan;
import library_admin_view.AlertView;
import library_admin_view.BookAddView;
import library_admin_view.BookLoanView;
import library_admin_view.BookManagementView;
import library_admin_view.BookReturnView;
import library_admin_view.LoanBookListView;

public class BookController {

	private BookDao bookDao;

	public BookController() {

		bookDao = new BookDao();

	}

	public void requestLoanBook() {
		BookLoanView bookLoanView = new BookLoanView();
		BookLoan bookLoanInfo = bookLoanView.getInfo();
		String adminId = Controllers.getLoginControlles().requestLoginInfo().getLogin_Id();
		bookLoanInfo.setAdminId(adminId);
		boolean success = bookDao.LoanBook(bookLoanInfo);
		AlertView alert = new AlertView();
		if (success) {
			alert.alert("도서대출 성공");

		} else {
			alert.alert("도서대출 실패");
		}

		Controllers.getLoginControlles().requestMainLogin();
	}

	public void requestReturnBook() {
		BookReturnView bookReturnView = new BookReturnView();
		int bookBarcode = bookReturnView.getInfo();

		boolean success = bookDao.returnBook(bookBarcode);
		Controllers.getLoginControlles().requestMainLogin();

	}

	public void requestPrintBookLoanList() {
		ArrayList<BookLoan> bookLoanList = bookDao.returnBook();
		LoanBookListView loanBookListView = new LoanBookListView();
		loanBookListView.printLoanBookList(bookLoanList);

		Controllers.getLoginControlles().requestMainLogin();

	}

	public void requestBookManegement() {

		BookManagementView bookManagementView = new BookManagementView();
		bookManagementView.getBookManageChoose();

	}

	public void requestBookAdd() {

		BookAddView bookAddView = new BookAddView();
		Book addBook = bookAddView.addBook();
		Book book = bookDao.generateinsert(addBook); // 바코드까지 완성된 book객체
		
		boolean bookList = bookDao.BookAdd(book);
		
		boolean success	= bookDao.insertBookmgm(book);

	}

	public void requestBookList() {
		System.out.println("도서 조회 ");

	}

	public void requestBookUpdate() {
		System.out.println("도서 수정 ");

	}

}
