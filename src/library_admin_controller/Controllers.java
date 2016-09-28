package library_admin_controller;

public class Controllers {
	private static ProgramController programController;
	private static LoginController loginControlles;
	private static UserController userController;
	private static BookController bookController;
	private static AdminController adminController;
	private static LibCardController libCardController;
	private static GenreController genreController;

	public Controllers() {
		programController = new ProgramController();
		loginControlles = new LoginController();
		userController = new UserController();
		bookController = new BookController();
		adminController = new AdminController();
		libCardController = new LibCardController();
		genreController = new GenreController();

	}

	public static ProgramController getProgramController() {
		return programController;
	}

	public static LoginController getLoginControlles() {
		return loginControlles;
	}

	public static UserController getUserController() {
		return userController;
	}

	public static BookController getBookController() {
		return bookController;
	}

	public static AdminController getAdminController() {
		return adminController;
	}

	public static LibCardController getLibCardController() {
		return libCardController;
	}

	public static GenreController getGenreController() {
		return genreController;
	}

	
}
