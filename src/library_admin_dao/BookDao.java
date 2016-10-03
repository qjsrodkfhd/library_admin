package library_admin_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import library_admin_controller.Controllers;
import library_admin_domain.Book;
import library_admin_domain.BookDetail;
import library_admin_domain.BookLoan;

public class BookDao {
	//책 찾기
	public Book searchBook(String searchBookName) {

		Book searchedBookName = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			sql = "select * from Book where BookName like '%' || ? || '%'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchBookName);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				searchedBookName = new Book();
				searchedBookName.setBookBarcode(rs.getInt("bookBarcode"));
				searchedBookName.setBookName(rs.getString("bookName"));
				searchedBookName.setBookAuthor(rs.getString("bookAuthor"));
				searchedBookName.setBookPublisher(rs.getString("bookPublisher"));
				searchedBookName.setGenreCode(rs.getString("genreCode"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return searchedBookName;
	}
	//책 대출
	public boolean LoanBook(BookLoan bookLoanInfo) {
		int nextLoanNumber = 0;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		String loanTf = null;
		try {
			// 회원의 아이디 중복 체크
			String sql = "select LoanNumber from BookLoan where UserBarCode = ? and BookLoanTF = 'f'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, bookLoanInfo.getUserBarCode());
			rs = pstmt.executeQuery();

			int loanCount = 0;
			while (rs.next()) {
				loanCount = loanCount + 1;
			}
			
			rs.close();
			pstmt.close();

			if (loanCount < 3) {
				sql = "select max(LoanNumber) + 1 as maxLoanNumber from BookLoan";
				stmt = Controllers.getProgramController().getConnection().createStatement();
				rs = stmt.executeQuery(sql);
				

				if (rs.next()) {
					nextLoanNumber = rs.getInt("maxLoanNumber");
					if (rs.wasNull()) { // 최초로 회원을 등록할 때
						nextLoanNumber = 1;
					}
				}
				bookLoanInfo.setLoanNumber(nextLoanNumber);

				sql = "select * from BookLoan where BookBarCode = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, bookLoanInfo.getBookBarCode());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					loanTf = rs.getString("BookLoanTF");
				}

				System.out.println(loanTf);

				if (loanTf != null) {

					if (loanTf.equals("f")) {
						success = false;
					} else {
						// 회원 가입
						sql = "insert into BookLoan(LoanNumber, BookLoanTF,AdminId,UserBarCode, BookBarCode) values(?, ?, ?, ?, ?)";
						pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
						pstmt.setInt(1, bookLoanInfo.getLoanNumber());
						pstmt.setString(2, "f");
						pstmt.setString(3, bookLoanInfo.getAdminId());
						pstmt.setInt(4, bookLoanInfo.getUserBarCode());
						pstmt.setInt(5, bookLoanInfo.getBookBarCode());
						int result = pstmt.executeUpdate(); // 1 : 회원 테이블에
															// insert 성공, 0
						// : 실패

						if (result != 0) {
							success = true;
						}
					}

				} else {

					// 회원 가입
					sql = "insert into BookLoan (LoanNumber,AdminId,UserBarCode, BookBarCode) values(?, ?, ?, ?)";
					pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
					pstmt.setInt(1, bookLoanInfo.getLoanNumber());
					pstmt.setString(2, bookLoanInfo.getAdminId());
					pstmt.setInt(3, bookLoanInfo.getUserBarCode());
					pstmt.setInt(4, bookLoanInfo.getBookBarCode());
					int result = pstmt.executeUpdate(); // 1 : 회원 테이블에 insert
														// 성공, 0
					// : 실패

					if (result != 0) {
						success = true;
					}
				}
			}

		} catch (SQLException e) {
			System.out.println("회원 등록 시에 예외가 발생했습ㄴ니다.");
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return success;
	}

	public boolean returnBook(int bookBarcode) {
		boolean success = false;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean isFind = false;

		try {

			String sql = "select * from BookLoan where bookbarcode = ? ";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, bookBarcode);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				isFind = true;
			}

			if (isFind) {
				sql = "update BookLoan set BookLoanTF = 't' where bookbarcode =? ";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, bookBarcode);
				int result = pstmt.executeUpdate();

				if (result == 1) {
					success = true;
				}
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return success;
	}

	public ArrayList<BookLoan> returnBook() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<BookLoan> loanList = new ArrayList<BookLoan>();

		try {
			String sql = "select * from BookLoan";
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BookLoan tempBookLoan = new BookLoan();
				tempBookLoan.setLoanNumber(rs.getInt("loannumber"));
				tempBookLoan.setUserBarCode(rs.getInt("userbarcode"));
				tempBookLoan.setBookBarCode(rs.getInt("bookbarcode"));
				tempBookLoan.setBookLoanTF(rs.getString("bookloantf"));
				tempBookLoan.setBookLoanDate(rs.getDate("bookloandate"));
				tempBookLoan.setAdminId(rs.getString("adminid"));
				loanList.add(tempBookLoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return loanList;

	}

	public boolean BookAdd(Book addBook) {

		boolean success = false;
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into book(bookbarcode, bookname, bookauthor, bookpublisher , genrecode) values(?,?,?,?,?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, addBook.getBookBarcode());
			pstmt.setString(2, addBook.getBookName());
			pstmt.setString(3, addBook.getBookAuthor());
			pstmt.setString(4, addBook.getBookPublisher());
			pstmt.setString(5, addBook.getGenreCode());

			int result = pstmt.executeUpdate();

			if (result != 0) {
				success = true;
			}
		} catch (SQLException e) {
			System.out.println("제품 등록 중 예외가 발생했습니다.");
			e.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return success;

	}

	public Book generateinsert(Book book) {

		Random r = new Random();// 랜덤함수 생성
		int barcodNumber = r.nextInt(899999) + 100000; // 10000~999999까지
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ArrayList<Book> books = new ArrayList<Book>();
		boolean success = false;

		try {
			String sql = "select bookbarcode from book ";
			stmt = Controllers.getProgramController().getConnection().createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				Book tempBook = new Book();// 1-1 객체생성을 해서 barcodeNumber를 리스트에
											// 저장한거.
				tempBook.setBookBarcode(rs.getInt("bookbarcode"));// 1-2
				books.add(tempBook);// 1-3
			}

			while (true) {
				for (int i = 0; i < books.size(); i++) {

					if (barcodNumber == books.get(i).getBookBarcode()) {
						success = true;// userList에서 중복을 검사함.
					}

				}
				if (success == true) {
					barcodNumber = r.nextInt(899999) + 100000;// 다시 바코드번호 부여
				} else {

					book.setBookBarcode(barcodNumber);// 그 바코드 번호를 user객체에 set
					break;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;

	}

	public boolean insertBookmgm(Book book) {
		boolean success = false;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String adminid = library_admin_repository.LoginRepository.getLogin().getLogin_Id();
		int bookMgmNumber = 0;
		try {
			
			String sql = "select max(bookmgmnumber) + 1 as bookmgmnumber from bookmgm ";
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				
				bookMgmNumber = rs.getInt("bookmgmnumber");
				if(rs.wasNull()){
					bookMgmNumber = 1;
				}
			}
			
			sql = "insert into bookmgm(bookmgmnumber,adminid, bookbarcode) values (?,?,?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);

			pstmt.setInt(1,bookMgmNumber);
			pstmt.setString(2, adminid);
			pstmt.setInt(3,book.getBookBarcode());
			

			int result = pstmt.executeUpdate();

			if (result != 0) {
				success = true;
			}
		} catch (SQLException e) {
			System.out.println("제품 등록 중 예외가 발생했습니다.");
			e.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return success;

	}
	public BookDetail searchDetailBook(int barcodeNumber) {
		BookDetail bookInfo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select bookname,bookauthor,bookpublisher,genrename,bookloantf, bookloandate from book,genre,bookloan where book.bookbarcode = bookloan.bookbarcode and book.genrecode = genre.genrecode and book.bookbarcode = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, barcodeNumber);
			rs = pstmt.executeQuery();
			int lineCount = 0;
			while (rs.next()) {

				lineCount = lineCount + 1;

			}

			if (lineCount > 0) {
				sql = "select bookname,bookauthor,bookpublisher,genrename,bookloantf, bookloandate from book,genre,bookloan where book.bookbarcode = bookloan.bookbarcode and book.genrecode = genre.genrecode and book.bookbarcode = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, barcodeNumber);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bookInfo = new BookDetail();
					bookInfo.setBookName(rs.getString("bookname"));
					bookInfo.setBookAuthor(rs.getString("bookauthor"));
					bookInfo.setBookPublisher(rs.getString("bookpublisher"));
					bookInfo.setGenreName(rs.getString("genrename"));
					bookInfo.setBookLoanTF(rs.getString("bookloantf"));
					bookInfo.setBookLoanDate(rs.getDate("bookloandate"));
				}

			} else {
				// 쿼리 날린 결과가 없다.
				sql = "select bookname,bookauthor,bookpublisher,genrename from book, genre where book.genrecode = genre.genrecode and book.bookbarcode = ? ";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, barcodeNumber);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bookInfo = new BookDetail();
					bookInfo.setBookName(rs.getString("bookname"));
					bookInfo.setBookAuthor(rs.getString("bookauthor"));
					bookInfo.setBookPublisher(rs.getString("bookpublisher"));
					bookInfo.setGenreName(rs.getString("genrename"));
					bookInfo.setBookLoanTF("t");
				}

			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return bookInfo;

	}
	public ArrayList<Book> bookList() {

		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Book> bookList = new ArrayList<Book>();
		try {

			String sql = "select * from book";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Book book = new Book();
				book.setBookBarcode(rs.getInt("bookBarcode"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookPublisher(rs.getString("bookPublisher"));
				book.setGenreCode(rs.getString("genreCode"));
				bookList.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return bookList;
	}


}
