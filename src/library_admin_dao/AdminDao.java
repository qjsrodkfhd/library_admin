package library_admin_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library_admin_controller.Controllers;
import library_admin_domain.Admin;

public class AdminDao {

	public boolean insertAdmin(Admin adminInfo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean success = false;
		int barcodNumber = 0;

		try {
//			AdminId varchar2(50) primary key,
//			   AdminPw varchar2(50) not null,
//			   AdminPos varchar2(50) not null,
//			   AdminName varchar2(50) not null

			String sql = "insert into admin(AdminId, AdminPw, AdminPos, AdminName) values(?,?,?,?) ";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, adminInfo.getAdminId());
			pstmt.setString(2, adminInfo.getAdminPw());
			pstmt.setString(3, adminInfo.getAdminPos());
			pstmt.setString(4, adminInfo.getAdminName());

			int result = pstmt.executeUpdate();

			if (result != 0) {
				success = true;
			}

		} catch (

		SQLException e) {
			//System.out.println("");
			//e.printStackTrace();
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

}
