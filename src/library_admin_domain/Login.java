package library_admin_domain;

public class Login {

	private String login_Id;
	private String login_Pw;

	public Login() {

	}

	public Login(String login_Id, String login_Pw) {

		this.login_Id = login_Id;
		this.login_Pw = login_Pw;

	}

	public String getLogin_Id() {
		return login_Id;
	}

	public void setLogin_Id(String login_Id) {
		this.login_Id = login_Id;
	}

	public String getLogin_Pw() {
		return login_Pw;
	}

	public void setLogin_Pw(String login_Pw) {
		this.login_Pw = login_Pw;
	}

}
