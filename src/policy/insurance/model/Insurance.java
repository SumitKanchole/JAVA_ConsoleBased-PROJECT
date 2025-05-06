package policy.insurance.model;

public class Insurance {
	private long Customer_id;
	private String Customer_name;
	private String Address;
	private int Customer_age;
	private long salary;
	private String Nominee_name;
	private long Nominee_No;
	private long Contact_No;
	private String bank_AccountHolder;
	private long bank_AccountNumber;
	private int duration;
	private String OwnerName;
	private String PropertyType;
	private int yearBuilt;
	private String premium;

	
	// Constructor for Home Insurance
	public Insurance(long customer_id, String customer_name, String Address, String OwnerName, String propertyType, int yearBuilt, String bank_AccountHolder, long bank_AccountNumber,String premium, int Customer_age,long Contact_No, long salary,String Nominee_name,long Nominee_no,int duration) {
		super();
		this.Customer_id = customer_id;
		this.Customer_name = customer_name;
		this.Address = Address;
		this.Customer_age = Customer_age;
		this.bank_AccountHolder = bank_AccountHolder;
		this.bank_AccountNumber = bank_AccountNumber;
		this.OwnerName = OwnerName;
		this.PropertyType = propertyType;
		this.yearBuilt = yearBuilt;
		this.premium = premium;
		this.Contact_No=Contact_No;
		this.salary=salary;
		this.Nominee_name=Nominee_name;
		this.Nominee_No=Nominee_no;
		this.duration=duration;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}


	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public long getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(long customer_id) {
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
	
	public String getBank_AccountHolder() {
		return bank_AccountHolder;
	}
	public void setBank_AccountHolder(String bank_AccountHolder) {
		this.bank_AccountHolder = bank_AccountHolder;
	}
	public long getBank_AccountNumber() {
		return bank_AccountNumber;
	}
	public void setBank_AccountNumber(long bank_AccountNumber) {
		this.bank_AccountNumber = bank_AccountNumber;
	}
	public String getOwnerName() {
		return OwnerName;
	}
	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}
	public String getPropertyType() {
		return PropertyType;
	}
	public void setPropertyType(String propertyType) {
		PropertyType = propertyType;
	}
	public int getYearBuilt() {
		return yearBuilt;
	}
	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}

	public long getContact_No() {
		return Contact_No;
	}

	public void setContact_No(long contact_No) {
		Contact_No = contact_No;
	}
	

}
