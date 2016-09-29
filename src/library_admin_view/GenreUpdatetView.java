package library_admin_view;

import java.util.Scanner;

import library_admin_domain.Genre;

public class GenreUpdatetView {
	
	private Scanner keyboard;
	
	public GenreUpdatetView()
	{
		keyboard = new Scanner(System.in);
	}

	public Genre getGenreInfo() {
		System.out.print("수정하실 장르코드를 입력하세요 : ");
		String genreCode = keyboard.next();
		System.out.print("수정하실 장르명을 입력하세요 : ");
		String genreName = keyboard.next();
		
		Genre genre = new Genre(genreCode,genreName);
		return genre;
	}

}
