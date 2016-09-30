package library_admin_domain;

import java.sql.Date;
public class LibCardDetailInfo {
	
	private int LibCardBarcode;
	private Date LibCardIssDate;
	private Date LibCardExpDate;
	private String AdminId;
	private int UserBarcode;
	private String userId;	
	private String userPw;
	private String UserName;
	private String userAddr;
	private String userTel;
	private String userGender;
	private Date userregdate;
	
	
	public int getLibCardBarcode() {
		return LibCardBarcode;
	}
	public void setLibCardBarcode(int libCardBarcode) {
		LibCardBarcode = libCardBarcode;
	}
	public Date getLibCardIssDate() {
		return LibCardIssDate;
	}
	public void setLibCardIssDate(Date libCardIssDate) {
		LibCardIssDate = libCardIssDate;
	}
	public Date getLibCardExpDate() {
		return LibCardExpDate;
	}
	public void setLibCardExpDate(Date libCardExpDate) {
		LibCardExpDate = libCardExpDate;
	}
	public String getAdminId() {
		return AdminId;
	}
	public void setAdminId(String adminId) {
		AdminId = adminId;
	}
	public int getUserBarcode() {
		return UserBarcode;
	}
	public void setUserBarcode(int userBarcode) {
		UserBarcode = userBarcode;
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
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
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
	public Date getUserregdate() {
		return userregdate;
	}
	public void setUserregdate(Date userregdate) {
		this.userregdate = userregdate;
	}

}
