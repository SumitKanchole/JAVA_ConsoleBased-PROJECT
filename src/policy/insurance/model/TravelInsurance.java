package policy.insurance.model;

public class TravelInsurance {
	
	private int Customer_id;
	private String Customer_name;
	private String Address;
	private int Customer_age;
	private long salary;
	private long Contact_No;
	private int BookingNo;
	private String StartFrom;
	private String EndTo;
	private String Nominee_name;
	private long Nominee_No;
	private int duration;
	private String premium;
	private String profile;
	
	
	
	public TravelInsurance(int customer_id, String customer_name, String address, String profile, int customer_age, long salary,
			long contact_No, int bookingNo, String startFrom, String endTo, String nominee_name, long nominee_No,
			 String premium,int duration) {
		super();
		Customer_id = customer_id;
		Customer_name = customer_name;
		Address = address;
		Customer_age = customer_age;
		this.salary = salary;
		Contact_No = contact_No;
		BookingNo = bookingNo;
		StartFrom = startFrom;
		EndTo = endTo;
		Nominee_name = nominee_name;
		Nominee_No = nominee_No;
		this.duration = duration;
		this.premium = premium;
		this.profile = profile;
	}
	public int getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getCustomer_age() {
		return Customer_age;
	}
	public void setCustomer_age(int customer_age) {
		Customer_age = customer_age;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public long getContact_No() {
		return Contact_No;
	}
	public void setContact_No(long contact_No) {
		Contact_No = contact_No;
	}
	public int getBookingNo() {
		return BookingNo;
	}
	public void setBookingNo(int bookingNo) {
		BookingNo = bookingNo;
	}
	public String getStartFrom() {
		return StartFrom;
	}
	public void setStartFrom(String startFrom) {
		StartFrom = startFrom;
	}
	public String getEndTo() {
		return EndTo;
	}
	public void setEndTo(String endTo) {
		EndTo = endTo;
	}
	public String getNominee_name() {
		return Nominee_name;
	}
	public void setNominee_name(String nominee_name) {
		Nominee_name = nominee_name;
	}
	public long getNominee_No() {
		return Nominee_No;
	}
	public void setNominee_No(long nominee_No) {
		Nominee_No = nominee_No;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
	}
