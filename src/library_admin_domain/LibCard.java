package library_admin_domain;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LibCard {

	private int LibCardBarcode;
	private Date LibCardIssDate;
	private String LibCardExpDate;
	private String AdminId;
	private int UserBarcode;
	
	public LibCard(int userBarcode, String adminId) 
	{
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new Date(utilDate.getTime());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sqlDate);
		cal.add(Calendar.DATE, 14);
		
		LibCardIssDate = sqlDate;
		LibCardExpDate = format.format(cal.getTime());
		this.AdminId = adminId;
		this.UserBarcode = userBarcode;
	}

	public LibCard() {
		// TODO Auto-generated constructor stub
	}

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

	public String getLibCardExpDate() {
		return LibCardExpDate;
	}

	public void setLibCardExpDate(String libCardExpDate) {
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
	
	

}
