package lms.models;

public class BookDetails {
	long isbn;
	String title;
	int copies_owned;
	int edition;
	String publisher_name;
	int price;
	int shelf_no;
	String author_name;
	String category;
	public BookDetails(long isbn, String title, int copies_owned, int edition, String publisher_name, int price,
			int shelf_no, String author_name, String category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.copies_owned = copies_owned;
		this.edition = edition;
		this.publisher_name = publisher_name;
		this.price = price;
		this.shelf_no = shelf_no;
		this.author_name = author_name;
		this.category = category;
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
	public int getCopies_owned() {
		return copies_owned;
	}
	public void setCopies_owned(int copies_owned) {
		this.copies_owned = copies_owned;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getShelf_no() {
		return shelf_no;
	}
	public void setShelf_no(int shelf_no) {
		this.shelf_no = shelf_no;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "BookDetails [isbn=" + isbn + ", title=" + title + ", copies_owned=" + copies_owned + ", edition="
				+ edition + ", publisher_name=" + publisher_name + ", price=" + price + ", shelf_no=" + shelf_no
				+ ", author_name=" + author_name + ", category=" + category + "]";
	}
	
	
}
