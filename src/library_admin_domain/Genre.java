package library_admin_domain;

public class Genre {

	private String GenreCode = "g";
	private String GenreName;

	public Genre(String genreCode, String genreName) {

		GenreCode = genreCode;
		GenreName = genreName;

	}

	public String getGenreCode() {
		return GenreCode;
	}

	public void setGenreCode(String genreCode) {
		GenreCode = genreCode;
	}

	public String getGenreName() {
		return GenreName;
	}

	public void setGenreName(String genreName) {
		GenreName = genreName;
	}

}