package lms.models;

public class BookModel {
	
	String title;		
	int edition;
	int shelfNo;
	String authorName;
	String category;
	String status;
	public BookModel(String title, int edition, int shelfNo, String authorName, String category, String status) {
		super();
		this.title = title;
		this.edition = edition;
		this.shelfNo = shelfNo;
		this.authorName = authorName;
		this.category = category;
		this.status = status;
	}
	@Override
	public String toString() {
		return "BookModel [title=" + title + ", edition=" + edition + ", shelfNo=" + shelfNo + ", authorName="
				+ authorName + ", category=" + category + ", status=" + status + "]";
	}
	
	
}
