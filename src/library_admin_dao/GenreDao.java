package library_admin_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library_admin_domain.Genre;

public class GenreDao {

	//장르 추가
	public boolean insertGenre(Genre genre){
		
		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try{
			
			
		}
		//장르를 추가한다.
		//추가한 장르는 genre디비에 들어간다.
		//또한 추가한 장르는 장르관리DB인 genreMgm디비에도 들어간다.
		
		return success;
	}
	
	//장르 리스트
	//장르 수정
	
}
