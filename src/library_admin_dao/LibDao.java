package library_admin_dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import library_admin_controller.Controllers;
import library_admin_domain.LibCard;
import library_admin_domain.LibCardDetailInfo;
import library_admin_domain.User;



public class LibDao {

	public boolean insertLibCard(LibCard libCard) {
		Random r = new Random();// 랜덤함수 생성
		int LibCardBarcode = r.nextInt(899999) + 100000; // 10000~999999까지
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ArrayList<LibCard> LibCardBarcodeList = new ArrayList<LibCard>();
		boolean duplicatedLibBarcode = false;
		boolean success = false;
		boolean getRandomLibBarcode = false;
		
		try 
		{
			String sql = "select LibCardBarcode from LibCard ";
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) 
			{

				LibCard tempLibCard = new LibCard();
				tempLibCard.setLibCardBarcode(rs.getInt("LibCardBarcode"));
				LibCardBarcodeList.add(tempLibCard);// 1-3
			}

			while (true) 
			{
				for (int i = 0; i < LibCardBarcodeList.size(); i++) 
				{

					if (LibCardBarcode == LibCardBarcodeList.get(i).getLibCardBarcode()) 
					{
						duplicatedLibBarcode = true;// userList에서 중복을 검사함.
					}

				}
				if (duplicatedLibBarcode == true) 
				{
					LibCardBarcode = r.nextInt(899999) + 100000;// 다시 바코드번호 부여
				} 
				else 
				{
					libCard.setLibCardBarcode(LibCardBarcode);
					getRandomLibBarcode = true;
					break;
				}

			}
			
			if(getRandomLibBarcode == true)
			{

				sql = "insert into LibCard(LibCardBarcode, LibCardIssDate, LibCardExpDate, AdminId, UserBarcode) values(?,?,?,?,?) ";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, libCard.getLibCardBarcode());
				pstmt.setDate(2, libCard.getLibCardIssDate());
				pstmt.setString(3, libCard.getLibCardExpDate());
				pstmt.setString(4, libCard.getAdminId());
				pstmt.setInt(5, libCard.getUserBarcode());
				int result = pstmt.executeUpdate();

				if (result != 0) {
					success = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public ArrayList<LibCard> selectAllLibCard() {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<LibCard> libCards = new ArrayList<LibCard>();

		try {

			
			String sql = "select * from LibCard";
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			   
			while (rs.next()) {
				LibCard libCard = new LibCard();
				libCard.setLibCardBarcode(rs.getInt("LibCardBarcode"));
				libCard.setLibCardIssDate(rs.getDate("LibCardIssDate"));				
				libCard.setLibCardExpDate(rs.getString("LibCardExpDate"));
				libCard.setAdminId(rs.getString("AdminId"));
				libCard.setUserBarcode(rs.getInt("UserBarcode"));				
				libCards.add(libCard);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

		return libCards;
	}

	public LibCardDetailInfo selectOneLibCard(int barcode) {
		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LibCardDetailInfo libCardDetailInfo = new LibCardDetailInfo();
		try {

			String sql = "select * from LibCard, userInfo where userInfo.userbarcode = libCard.userbarcode and LibCardbarcode = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, barcode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				libCardDetailInfo.setLibCardBarcode(rs.getInt("LibCardBarcode"));
				libCardDetailInfo.setLibCardIssDate(rs.getDate("LibCardIssDate"));
				libCardDetailInfo.setLibCardExpDate(rs.getDate("LibCardExpDate"));
				libCardDetailInfo.setAdminId(rs.getString("AdminId"));
				libCardDetailInfo.setUserBarcode(rs.getInt("UserBarcode"));
				libCardDetailInfo.setUserId(rs.getString("userId"));
				libCardDetailInfo.setUserPw(rs.getString("userPw"));
				libCardDetailInfo.setUserName(rs.getString("userName"));
				libCardDetailInfo.setUserAddr(rs.getString("userAddr"));
				libCardDetailInfo.setUserTel(rs.getString("userTel"));
				libCardDetailInfo.setUserGender(rs.getString("userGender"));
				libCardDetailInfo.setUserregdate(rs.getDate("userregdate"));
				
				
			}

		} catch (SQLException e) {
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

		return libCardDetailInfo;
	}

	public boolean deleteLibCard(int number) {
		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			String sql = "delete libCard where libCardBarcode = ? ";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, number);

			result = pstmt.executeUpdate();

			if (result != 0) {
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;
	}

}
