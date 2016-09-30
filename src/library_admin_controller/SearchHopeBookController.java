package library_admin_controller;

import java.util.ArrayList;

import library_admin_dao.SearchHopeBookDao;
import library_admin_domain.HopeBook;
import library_admin_view.AlertView;
import library_admin_view.HopeBookListView;
import library_admin_view.HopeBookMenuView;

public class SearchHopeBookController {
	
	private SearchHopeBookDao searchHopeBookDao;
	
	public SearchHopeBookController(){
		
		searchHopeBookDao = new SearchHopeBookDao();
		
	}
	
	//희망 도서 정보 메인 페이지
	public void requestSearchHopeBookMenu(){
		
		HopeBookMenuView hopeBookMenuView = new HopeBookMenuView();
		hopeBookMenuView.hopeBookMenuList();
		
	}
	
	//희망 도서 리스트뷰
	public void requestSearchHopeBookList(){
		
		ArrayList<HopeBook> hopeBookList = searchHopeBookDao.searchHopeBookList();
		HopeBookListView hopeBookListView = new HopeBookListView();
		hopeBookListView.hopeBookList(hopeBookList);
	}
	
	//희망 도서 삭제
	public void requestHopeBookDelete(int deleteNumber){
		
		boolean success = searchHopeBookDao.hopeBookDelete(deleteNumber);
		
		if(success){
			new AlertView().alert("희망 도서 삭제 성공");
		}else{
			new AlertView().alert("희망 도서 삭제 실패");
		}
		
	}
	
	//희망 도서 구매
	public void requesHopeBookBuy(int buyBookNumber) {
		
		boolean success = searchHopeBookDao.hopeBookBuy(buyBookNumber);
		
		if(success){
			new AlertView().alert("희망 도서 구매 성공");
		}else{
			new AlertView().alert("희망 도서 구매 실패");
		}
	}
	
	public void requesIntoCart(){
		
		boolean success = searchHopeBookDao.hopeBookIntoCart();
		
		if(success){
			new AlertView().alert("구매내역 테이블로 이동 성공");
		}else{
			new AlertView().alert("실패");
		}
	}
	
	//구매이력 리스트 -- 미구현
	
}
