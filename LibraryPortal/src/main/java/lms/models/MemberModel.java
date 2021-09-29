package lms.models;

public class MemberModel {
	int id;
	String name;
	String email;
	String password;
	int active_status;
	long mobile_no;
	
	public MemberModel(int id, String name, String email, String password, int active_status, long mobile_no) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.active_status = active_status;
		this.mobile_no = mobile_no;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", active_status=" + active_status + ", mobile_no=" + mobile_no + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getActive_status() {
		return active_status;
	}
	public void setActive_status(int active_status) {
		this.active_status = active_status;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	
}
