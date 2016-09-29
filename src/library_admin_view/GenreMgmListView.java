package library_admin_view;

import java.util.ArrayList;

import library_admin_domain.GenreMgm;

public class GenreMgmListView {

	public void genreMgmList(ArrayList<GenreMgm> genreMgm) {
		
		System.out.println("[ 장르 관리 페이지 ]");
		System.out.println("[ 장르관리번호  \t 장르코드 \t 관리자ID ]");
		
		for(int i = 0; i < genreMgm.size(); i++){
			
			System.out.print("\t");
			System.out.print(genreMgm.get(i).getGenreMgmNumber() + "\t");
			System.out.print(genreMgm.get(i).getGenreCode() + "\t");
			System.out.println(genreMgm.get(i).getAdminId());
			
		}
		
	}
	
	
}
