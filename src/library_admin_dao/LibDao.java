package library_admin_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import library_admin_controller.Controllers;
import library_admin_domain.LibCard;
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

}
