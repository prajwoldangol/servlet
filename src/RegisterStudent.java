
public class RegisterStudent {

	private int id ;
	private String fname;
	private String mname;
	private String lname;
	private String gender;
	private String dob ;
	private String phone ;
	private String email;
	private String adddress1;
	private String address2;
	private String state;
	public String city;
	private String zip;
	private String username;
	private String password;

	public RegisterStudent(int id, String fname, String mname, String lname, String gender, String phone, String email,String dob,
			String adddress1, String address2, String state, String city, String zip) {
		super();
		this.id = id;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.adddress1 = adddress1;
		this.address2 = address2;
		this.state = state;
		this.city = city;
		this.dob = dob ;
		this.zip = zip;
//		this.username = username;
//		this.password = password;
	}
	public RegisterStudent() {}

	public RegisterStudent(String fname, String mname, String lname, String gender, String phone, String email, String dob,
			String adddress1, String address2, String state, String city, String zip) {
		super();
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.dob = dob ;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.adddress1 = adddress1;
		this.address2 = address2;
		this.state = state;
		this.city = city;
		this.zip = zip;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdddress1() {
		return adddress1;
	}
	public void setAdddress1(String adddress1) {
		this.adddress1 = adddress1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
}
