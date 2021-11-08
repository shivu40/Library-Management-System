package lms.models;

public class CheckedOutBooks {
	int borrow_id;
	String title;
	long isbn;
	String author_name;
	String issue_date;
	String due_date;
	String return_date;
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public int getBorrow_id() {
		return borrow_id;
	}
	public void setBorrow_id(int borrow_id) {
		this.borrow_id = borrow_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public CheckedOutBooks(int borrow_id, String title, long isbn, String author_name, String issue_date,
			String due_date) {
		super();
		this.borrow_id = borrow_id;
		this.title = title;
		this.isbn = isbn;
		this.author_name = author_name;
		this.issue_date = issue_date;
		this.due_date = due_date;
	}
	
	
	
}
