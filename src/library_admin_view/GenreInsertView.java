package library_admin_view;

import java.util.Scanner;

import library_admin_domain.Genre;


public class GenreInsertView {
	
	private Scanner keyBoard;
	
	public GenreInsertView(){
		
		keyBoard = new Scanner(System.in);
		
	}

	public Genre insertGenre() {
		
		System.out.println("[ 장르 등록 페이지 ]");
		System.out.println("[장르코드] :  ");
		String genreCode = keyBoard.next();
		System.out.println("[장르명] :  ");
		String genreName = keyBoard.next();
		
		Genre genre = new Genre(genreCode, genreName);
		
		return genre;
		
	}
	
	
}
