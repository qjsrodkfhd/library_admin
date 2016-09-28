package library_admin_controller;

import java.util.ArrayList;

import library_admin_dao.GenreDao;
import library_admin_domain.Genre;
import library_admin_domain.GenreMgm;
import library_admin_view.AlertView;
import library_admin_view.GenreInsertView;
import library_admin_view.GenreMainPage;
import library_admin_view.GenreMgmListView;

public class GenreController {

	private GenreDao daoGenre;

	public GenreController(){

		daoGenre = new GenreDao();

	}

	//장르 관리 페이지
	public void requestGenreMgm(){

		GenreMainPage genreMainPage = new GenreMainPage();
		genreMainPage.genreMenu();

	}

	//장르 추가
	public void requestInsertGenre(){

		GenreInsertView genreInsertView = new GenreInsertView();
		Genre genre = genreInsertView.insertGenre();
		boolean success = daoGenre.insertGenre(genre);

		if(success){
			new AlertView().alert("장르 추가 성공");
			requestGenreMgm();
		}else{
			new AlertView().alert("장르 추가 실패");
			requestGenreMgm();
		}

	}
	
	//장르 관리 리스트
	public void requestGenreMgmList(){
		
		ArrayList<GenreMgm> genreMgm = daoGenre.genreMgmList();
		GenreMgmListView genreMgmListView = new GenreMgmListView();
		genreMgmListView.genreMgmList(genreMgm);
		
	}
	//장르 리스트
	//장르 수정
}
