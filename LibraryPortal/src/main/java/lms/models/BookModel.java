package lms.models;

public class BookModel {
	long isbn;
	String title;		
	int edition;
	int shelfNo;
	String authorName;
	String category;
	String status;
	public BookModel(long isbn,String title, int edition, int shelfNo, String authorName, String category, String status) {
		super();
		this.isbn=isbn;
		this.title = title;
		this.edition = edition;
		this.shelfNo = shelfNo;
		this.authorName = authorName;
		this.category = category;
		this.status = status;
	}
	
	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public int getShelfNo() {
		return shelfNo;
	}
	public void setShelfNo(int shelfNo) {
		this.shelfNo = shelfNo;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BookModel [title=" + title + ", edition=" + edition + ", shelfNo=" + shelfNo + ", authorName="
				+ authorName + ", category=" + category + ", status=" + status + "]";
	}
	
	
}
