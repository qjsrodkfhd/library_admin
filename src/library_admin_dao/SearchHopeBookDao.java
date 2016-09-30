package library_admin_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library_admin_controller.Controllers;
import library_admin_domain.Book;
import library_admin_domain.HopeBook;

public class SearchHopeBookDao {

	//희망 도서 정보 리스트
	public ArrayList<HopeBook> searchHopeBookList() {

		HopeBook hopeBook = null;
		ArrayList<HopeBook> hopeBookList = new ArrayList<HopeBook>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try{
			sql = "select * from REQUESTBOOK";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				hopeBook = new HopeBook();
				hopeBook.setRequestBookNumber(rs.getInt("REQUESTBOOKNUMBER"));
				hopeBook.setRequestBookName(rs.getString("REQUESTBOOKNAME"));
				hopeBook.setRequestBookAuthor(rs.getString("REQUESTBOOKAUTHOR"));
				hopeBook.setRequestBookPublusher(rs.getString("REQUESTBOOKPUBLISHER"));
				hopeBook.setRequestBookCountNumber(rs.getInt("REQUESTBOOKCOUNTNUMBER"));
				hopeBook.setRequestBookPrice(rs.getInt("REQUESTBOOKPRICE"));
				hopeBookList.add(hopeBook);
			}

		} catch(SQLException e){

			e.printStackTrace();

		}finally{
			if(rs != null){
				try{
					rs.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}

		return hopeBookList;
	}

	//희망 도서 삭제
	public boolean hopeBookDelete(int deleteNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = null;

		try{
			sql = "delete REQUESTBOOK where REQUESTBOOKNUMBER = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, deleteNumber);

			result = pstmt.executeUpdate();

			if(result != 0){

				success = true;

			}

		} catch(SQLException e){
			e.printStackTrace();
		}finally {
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

	//희망 도서 구매
	public boolean hopeBookBuy(int buyBookNumber) {
		
		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int bookNumber = 0;
		String bookName = null;
		String bookAuthor = null;
		String bookPublisher = null;
		int bookCountNumber = 0;
		int bookPrice = 0;
		Book book = new Book();
//		Book book = Controllers.getBookController().requestRandom();
		
		try{
			sql = "select * from REQUESTBOOK where REQUESTBOOKNUMBER = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, buyBookNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				bookNumber = rs.getInt(buyBookNumber);
				bookName = rs.getString("REQUESTBOOKNAME");
				bookAuthor = rs.getString("REQUESTBOOKAUTHOR");
				bookPublisher = rs.getString("REQUESTBOOKPUBLISHER");
				bookCountNumber = rs.getInt("REQUESTBOOKCOUNTNUMBER");
				bookPrice = rs.getInt("REQUESTBOOKPRICE");
				
				
			}
			
			//---------- 미구현 
			sql = "insert into book values(? ,? ,? ,?, ?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, 4);
			pstmt.setString(2, bookName);
			pstmt.setString(3, bookAuthor);
			pstmt.setString(4, bookPublisher);
			pstmt.setString(5, "123");
			
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				
				success = true;
				//구매한 도서 정보를 구매이력 테이블로 이동
				Controllers.getSearchHopeBookController().requesIntoCart();
				//희망 도서 테이블에서 선택한 도서 삭제
				hopeBookDelete(buyBookNumber);
				
			}
			
		}catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
		return success;
	}

	//구매한 도서 정보를 구매이력 테이블로 이동
	public boolean hopeBookIntoCart(){
		
		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int bookNumber = 0;
		String bookName = null;
		String bookAuthor = null;
		String bookPublisher = null;
		int bookCountNumber = 0;
		int bookPrice = 0;
		
		try{
			sql = "select * from REQUESTBOOK";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				bookNumber = rs.getInt("REQUESTBOOKNUMBER");
				bookName = rs.getString("REQUESTBOOKNAME");
				bookAuthor = rs.getString("REQUESTBOOKAUTHOR");
				bookPublisher = rs.getString("REQUESTBOOKPUBLISHER");
				bookCountNumber = rs.getInt("REQUESTBOOKCOUNTNUMBER");
				bookPrice = rs.getInt("REQUESTBOOKPRICE");
				
			}
			
			sql = "insert into CARTBOOK values(?, ?, ?, ?, ?, ?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, bookNumber);
			pstmt.setString(2, bookName);
			pstmt.setString(3, bookAuthor);
			pstmt.setString(4, bookPublisher);
			pstmt.setInt(5, bookCountNumber);
			pstmt.setInt(6, bookPrice);
			
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				success = true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		
		return success;
	}

}
