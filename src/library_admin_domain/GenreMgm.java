package library_admin_domain;

public class GenreMgm {

	private int genreMgmNumber;
	private String genreCode;
	private String adminId;
	
	public GenreMgm(){
		
	}

	public GenreMgm(int genreMgmNumber, String genreCode, String adminId) {

		this.genreMgmNumber = genreMgmNumber;
		this.genreCode = genreCode;
		this.adminId = adminId;

	}

	public int getGenreMgmNumber() {
		return genreMgmNumber;
	}

	public void setGenreMgmNumber(int genreMgmNumber) {
		this.genreMgmNumber = genreMgmNumber;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}



}
