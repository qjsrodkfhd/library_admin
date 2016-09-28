package library_admin_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library_admin_controller.Controllers;
import library_admin_domain.Book;
import library_admin_domain.BookLoan;




public class BookDao {
	//책 찾기
	public Book searchBook(String searchBookName) {

		//boolean success = false;
		Book searchedBookName = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try{
			sql = "select * from Book where BookName like '%' || ? || '%'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchBookName);
			rs = pstmt.executeQuery();

			if(rs.next()){
				searchedBookName = new Book();
				searchedBookName.setBookBarcode(rs.getInt("bookBarcode"));				
				searchedBookName.setBookName(rs.getString("bookName"));
				searchedBookName.setBookAuthor(rs.getString("bookAuthor"));
				searchedBookName.setBookPublisher(rs.getString("bookPublisher"));
				searchedBookName.setGenreCode(rs.getString("genreCode"));

			}

		}catch(SQLException e){
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
		try 
		{
			// 회원의 아이디 중복 체크
			String sql = "select LoanNumber from BookLoan where UserBarCode = ? and BookLoanTF = 'f'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, bookLoanInfo.getUserBarCode());
			rs = pstmt.executeQuery();

			int loanCount = 0;
			while(rs.next())
			{
				loanCount = loanCount + 1;
			}
			rs.close();
			pstmt.close();

			if(loanCount < 3)
			{
				sql = "select max(LoanNumber) + 1 as maxLoanNumber from BookLoan";
				stmt = Controllers.getProgramController().getConnection().createStatement();
				rs = stmt.executeQuery(sql);

				if (rs.next()) 
				{
					nextLoanNumber = rs.getInt("maxLoanNumber");
					if (rs.wasNull()) 
					{ // 최초로 회원을 등록할 때
						nextLoanNumber = 1;
					}
				}
				bookLoanInfo.setLoanNumber(nextLoanNumber);

				sql = "select * from BookLoan where BookBarCode = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, bookLoanInfo.getBookBarCode());
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					loanTf = rs.getString("BookLoanTF");
				}

				System.out.println(loanTf);

				if(loanTf != null)
				{

					if(loanTf.equals("f"))
					{
						success = false;
					}
					else
					{
						System.out.println("123");
						// 회원 가입
						sql = "insert into BookLoan(LoanNumber, BookLoanTF,AdminId,UserBarCode, BookBarCode) values(?, ?, ?, ?, ?)";
						pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
						pstmt.setInt(1, bookLoanInfo.getLoanNumber());
						pstmt.setString(2, "f");
						pstmt.setString(3, bookLoanInfo.getAdminId());
						pstmt.setInt(4, bookLoanInfo.getUserBarCode());
						pstmt.setInt(5, bookLoanInfo.getBookBarCode());
						int result = pstmt.executeUpdate(); // 1 : 회원 테이블에 insert 성공, 0
						// : 실패

						if (result != 0) 
						{
							success = true;
						}
					}


				}
				else
				{

					// 회원 가입
					sql = "insert into BookLoan (LoanNumber,AdminId,UserBarCode, BookBarCode) values(?, ?, ?, ?)";
					pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
					pstmt.setInt(1, bookLoanInfo.getLoanNumber());
					pstmt.setString(2, bookLoanInfo.getAdminId());
					pstmt.setInt(3, bookLoanInfo.getUserBarCode());
					pstmt.setInt(4, bookLoanInfo.getBookBarCode());
					int result = pstmt.executeUpdate(); // 1 : 회원 테이블에 insert 성공, 0
					// : 실패

					if (result != 0) 
					{
						success = true;
					}
				}
			}

		} catch (SQLException e) {
			System.out.println("회원 등록 시에 예외가 발생했습ㄴ니다.");
			e.printStackTrace();
		} 
		finally 
		{

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
			if (rs.next()) 
			{
				isFind = true;
			}

			if(isFind)
			{
				sql = "update BookLoan set BookLoanTF = 't' where bookbarcode =? ";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, bookBarcode);
				int result = pstmt.executeUpdate();

				if (result == 1) {
					success = true;
				}
			}
			else
			{

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
		try{
			String sql = "select * from BookLoan";
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				BookLoan tempBookLoan = new BookLoan();
				tempBookLoan.setLoanNumber(rs.getInt("loannumber"));
				tempBookLoan.setUserBarCode(rs.getInt("userbarcode"));
				tempBookLoan.setBookBarCode(rs.getInt("bookbarcode"));
				tempBookLoan.setBookLoanTF(rs.getString("bookloantf"));
				tempBookLoan.setBookLoanDate(rs.getDate("bookloandate"));
				tempBookLoan.setAdminId(rs.getString("adminid"));
				loanList.add(tempBookLoan);
			}
		}
		catch (SQLException e) {
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
}
