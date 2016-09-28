package library_admin_domain;

import java.sql.Date;

public class User {

	private int userBarcode;
	private String userId;
	private String userPw;
	private String userName;
	private String userAddr;
	private String userTel;
	private String userGender;
	private Date UserRegDate;

	public User() {

	}

	public User(String userId, String userPw, String userName, String userAddr, String userTel, String userGender) {

		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAddr = userAddr;
		this.userTel = userTel;
		this.userGender = userGender;
	}

	public User(int barcodNumber, String userId, String userPw, String userName, String userAddr, String userTel,
			String userGender) {

		this.userBarcode = userBarcode;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAddr = userAddr;
		this.userTel = userTel;
		this.userGender = userGender;

	}

	public int getUserBarcode() {

		return userBarcode;

	}

	public void setUserBarcode(int userBarcode) {

		this.userBarcode = userBarcode;

	}

	public String getUserId() {

		return userId;

	}

	public void setUserId(String userId) {

		this.userId = userId;

	}

	public String getUserPw() {

		return userPw;

	}

	public void setUserPw(String userPw) {

		this.userPw = userPw;

	}

	public String getUserName() {

		return userName;

	}

	public void setUserName(String userName) {

		this.userName = userName;

	}

	public String getUserAddr() {

		return userAddr;

	}

	public void setUserAddr(String userAddr) {

		this.userAddr = userAddr;

	}

	public String getUserTel() {

		return userTel;

	}

	public void setUserTel(String userTel) {

		this.userTel = userTel;

	}

	public String getUserGender() {

		return userGender;

	}

	public void setUserGender(String userGender) {

		this.userGender = userGender;

	}

	public Date getUserRegDate() {

		return UserRegDate;

	}

	public void setUserRegDate(Date userRegDate) {

		UserRegDate = userRegDate;

	}

}
