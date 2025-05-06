package policy.insurance.model;

public class HealthInsurance {
	private int Customer_id;
	private String Customer_name;
	private String Address;
	private int Customer_age;
	private long salary;
	private String Medical_Records;
	private String BloodGroup;
	private String Nominee_name;
	private long Nominee_No;
	private long Contact_No;
	private int duration;
	private String premium;
	
	//Constructor of health Insurance
	public HealthInsurance(int customer_id, String customer_name, String address, int customer_age, long salary,
			String medical_Records, String bloodGroup, String nominee_name, long nominee_No, long contact_No,
			int duration, String premium) {
		super();
		Customer_id = customer_id;
		Customer_name = customer_name;
		Address = address;
		Customer_age = customer_age;
		this.salary = salary;
		Medical_Records = medical_Records;
		BloodGroup = bloodGroup;
		Nominee_name = nominee_name;
		Nominee_No = nominee_No;
		Contact_No = contact_No;
		this.duration = duration;
		this.premium = premium;
	}
	
	
	//setter/getter of Health insurance
	
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
	public String getMedical_Records() {
		return Medical_Records;
	}
	public void setMedical_Records(String medical_Records) {
		Medical_Records = medical_Records;
	}
	public String getBloodGroup() {
		return BloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
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
	public long getContact_No() {
		return Contact_No;
	}
	public void setContact_No(long contact_No) {
		Contact_No = contact_No;
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
		
	
}
