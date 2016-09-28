package library_admin_domain;

public class Admin {
	
	private String AdminId;
	private String AdminPw;
	private String AdminPos;
	private String AdminName;
	
	
	public Admin(String adminId, String adminPw, String adminPos, String adminName) 
	{
		this.AdminId = adminId;
		this.AdminPw = adminPw;
		this.AdminPos = adminPos;
		this.AdminName = adminName;
	}
	public String getAdminId() {
		return AdminId;
	}
	public void setAdminId(String adminId) {
		AdminId = adminId;
	}
	public String getAdminPw() {
		return AdminPw;
	}
	public void setAdminPw(String adminPw) {
		AdminPw = adminPw;
	}
	public String getAdminPos() {
		return AdminPos;
	}
	public void setAdminPos(String adminPos) {
		AdminPos = adminPos;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	
	

}
