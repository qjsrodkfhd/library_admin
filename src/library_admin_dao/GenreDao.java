package library_admin_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import library_admin_controller.Controllers;
import library_admin_domain.Genre;

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
<<<<<<< HEAD
		
		//장르를 추가한다.
		//추가한 장르는 genre디비에 들어간다.
		//또한 추가한 장르는 장르관리DB인 genreMgm디비에도 들어간다.
		
		return success;
=======

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

				//또한 추가한 장르는 장르관리DB인 genreMgm디비에도 들어간다.
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
>>>>>>> origin/master
	}

	//장르 리스트
	//장르 수정

}
