package library_admin_domain;

public class HopeBook {
	
	private int requestBookNumber;
	private String requestBookName;
	private String requestBookAuthor;
	private String requestBookPublusher;
	private int requestBookCountNumber;
	private int requestBookPrice;
	
	public HopeBook(){
		
	}

	public HopeBook(int requestBookNumber, String requestBookName, String requestBookAuthor,
			String requestBookPublusher, int requestBookCountNumber, int requestBookPrice) {
		
		this.requestBookNumber = requestBookNumber;
		this.requestBookName = requestBookName;
		this.requestBookAuthor = requestBookAuthor;
		this.requestBookPublusher = requestBookPublusher;
		this.requestBookCountNumber = requestBookCountNumber;
		this.requestBookPrice = requestBookPrice;
		
	}

	public int getRequestBookNumber() {
		return requestBookNumber;
	}

	public void setRequestBookNumber(int requestBookNumber) {
		this.requestBookNumber = requestBookNumber;
	}

	public String getRequestBookName() {
		return requestBookName;
	}

	public void setRequestBookName(String requestBookName) {
		this.requestBookName = requestBookName;
	}

	public String getRequestBookAuthor() {
		return requestBookAuthor;
	}

	public void setRequestBookAuthor(String requestBookAuthor) {
		this.requestBookAuthor = requestBookAuthor;
	}

	public String getRequestBookPublusher() {
		return requestBookPublusher;
	}

	public void setRequestBookPublusher(String requestBookPublusher) {
		this.requestBookPublusher = requestBookPublusher;
	}

	public int getRequestBookCountNumber() {
		return requestBookCountNumber;
	}

	public void setRequestBookCountNumber(int requestBookCountNumber) {
		this.requestBookCountNumber = requestBookCountNumber;
	}

	public int getRequestBookPrice() {
		return requestBookPrice;
	}

	public void setRequestBookPrice(int requestBookPrice) {
		this.requestBookPrice = requestBookPrice;
	}
	
}
