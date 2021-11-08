package lms.models;

public class Fine {
	int borrow_id;
	String title;
	long isbn;
	String issue_date;
	String due_date;
	String return_date;
	int amount;
	public Fine(int borrow_id, String title, long isbn, String issue_date, String due_date, String return_date,
			int amount) {
		super();
		this.borrow_id = borrow_id;
		this.title = title;
		this.isbn = isbn;
		this.issue_date = issue_date;
		this.due_date = due_date;
		this.return_date = return_date;
		this.amount = amount;
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
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
