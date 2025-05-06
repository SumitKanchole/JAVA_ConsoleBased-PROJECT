package policy.insurance.model;

public class TermLifeInsurance {
		
	private int Customer_id;
	private String Customer_name;
	private String Address;
	private int Customer_age;
	private long Contact_No;
	private long salary;
	private String Medical_status;
	private String Nominee_name;
	private String Nominee_relation;
	private long Nominee_No;
	private String premium;
	private int duration;
	public TermLifeInsurance(int customer_id, String customer_name, String address, int customer_age, long contact_No,
			long salary, String medical_status, String nominee_name, String nominee_relation, long nominee_No,
			String premium, int duration) {
		super();
		Customer_id = customer_id;
		Customer_name = customer_name;
		Address = address;
		Customer_age = customer_age;
		Contact_No = contact_No;
		this.salary = salary;
		Medical_status = medical_status;
		Nominee_name = nominee_name;
		Nominee_relation = nominee_relation;
		Nominee_No = nominee_No;
		this.premium = premium;
		this.duration = duration;
	}
	
	public TermLifeInsurance() {
		setNominee_name(Nominee_name);
		
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
	public long getContact_No() {
		return Contact_No;
	}
	public void setContact_No(long contact_No) {
		Contact_No = contact_No;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getMedical_status() {
		return Medical_status;
	}
	public void setMedical_status(String medical_status) {
		Medical_status = medical_status;
	}
	public String getNominee_name() {
		return Nominee_name;
	}
	public void setNominee_name(String nominee_name) {
		Nominee_name = nominee_name;
	}
	public String getNominee_relation() {
		return Nominee_relation;
	}
	public void setNominee_relation(String nominee_relation) {
		Nominee_relation = nominee_relation;
	}
	public long getNominee_No() {
		return Nominee_No;
	}
	public void setNominee_No(long nominee_No) {
		Nominee_No = nominee_No;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	
}
