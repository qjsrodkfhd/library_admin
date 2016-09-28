package library_admin_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library_admin_controller.Controllers;
import library_admin_domain.Genre;
import library_admin_domain.GenreMgm;
import library_admin_domain.Login;

public class GenreDao {

	//장르 추가
	public boolean insertGenre(Genre genre){

		boolean success = false;
		boolean success2 = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String adminId = null;
		int genreMgmNumber = 0;
		int result = 0;
		String sql = null;

		boolean findLogin = Controllers.getLoginControlles().requestLoginCheck();

		try{
			//관리자 아이디  받아오기
			if(findLogin){

				sql = "select AdminId from admin";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				rs = pstmt.executeQuery();

				if(rs.next()){

					adminId = rs.getString("AdminId");

				}
			}

			// 장르관리  넘버 1 증가
			sql = "select Max(GenreMgmNumber) + 1 as maxGemreMgmNumber from genremgm";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()){

				genreMgmNumber = rs.getInt("maxGemreMgmNumber");
				if(rs.wasNull()){
					genreMgmNumber = 1;
				}

			}

			genre.setGenreMgm(genreMgmNumber);

			//장르를 추가한다.
			//추가한 장르는 genre디비에 들어간다.
			sql = "insert into Genre values(? , ?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, genre.getGenreCode());
			pstmt.setString(2, genre.getGenreName());
			result = pstmt.executeUpdate();

			if (result != 0) {
				success = true;
			}

			if(success){

				//또한 추가한 장르는 장르관리DB인 GenreMgm디비에도 들어간다.
				sql = "insert into GenreMgm values(? , ? , ?)";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, genre.getGenreMgm());
				pstmt.setString(2, genre.getGenreCode());
				pstmt.setString(3, adminId);
				result = pstmt.executeUpdate();

				if(result != 0){
					success2 = true;
				}
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		return success2;
	}

	//장르 관리 리스트
	public ArrayList<GenreMgm> genreMgmList(){
		
		ArrayList<GenreMgm> genreMgmList = new ArrayList<GenreMgm>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int genreMgm = 0;
		String genreCode = null;
		Login login = Controllers.getLoginControlles().requestLoginInfo();
		String adminId = login.getLogin_Id();
		
		try{
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				GenreMgm genreMgmView = new GenreMgm();
				genreMgmView.setGenreMgmNumber(rs.getInt("GENREMGMNUMBER"));
				genreMgmView.setGenreCode(rs.getString("genrecode"));
				genreMgmView.setAdminId(rs.getString("adminId"));
				genreMgmList.add(genreMgmView);
			
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return genreMgmList;
	}
	//장르 리스트
	//장르 수정
	

}
