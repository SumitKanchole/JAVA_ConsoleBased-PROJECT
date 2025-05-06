package policy.insurance.model;

public class VehicleInsurance {
	
	private int Customer_id;
	private String Customer_name;
	private String Address;
	private int Customer_age;
	private long salary;
	private String Nominee_name;
	private long Nominee_No;
	private String VehicleType;
	private String RC_num;
	private String PUC_num;
	private String DV_lincenseNum;
	private long Contact_No;
	private String bank_AccountHolder;
	private long bank_AccountNumber;
	private int duration;
	private String OwnerName;
	private String premium;
	
	public VehicleInsurance(int customer_id, String customer_name, String Address, long Contact_No,int Customer_age, String DV_lincenseNum,String RC_num, String PUC_num,String OwnerName,String bank_AccountHolder, long bank_AccountNumber,String Nominee_name,long Nominee_no,String premium,int duration,long salary,String VehicleType) {
		super();
		this.Customer_id = customer_id;
		this.Customer_name = customer_name;
		this.Address = Address;
		this.Customer_age = Customer_age;
		this.bank_AccountHolder = bank_AccountHolder;
		this.bank_AccountNumber = bank_AccountNumber;
		this.OwnerName = OwnerName;
		this.RC_num=RC_num;
		this.PUC_num=PUC_num;
		this.DV_lincenseNum=DV_lincenseNum;
		this.premium = premium;
		this.Contact_No=Contact_No;
		this.salary=salary;
		this.Nominee_name=Nominee_name;
		this.Nominee_No=Nominee_no;
		this.duration=duration;
		this.VehicleType =VehicleType;
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


	public String getVehicleType() {
		return VehicleType;
	}


	public void setVehicleType(String vehicleType) {
		VehicleType = vehicleType;
	}


	public String getRC_num() {
		return RC_num;
	}


	public void setRC_num(String rC_num) {
		RC_num = rC_num;
	}


	public String getPUC_num() {
		return PUC_num;
	}


	public void setPUC_num(String pUC_num) {
		PUC_num = pUC_num;
	}


	public String getDV_lincenseNum() {
		return DV_lincenseNum;
	}


	public void setDV_lincenseNum(String dV_lincenseNum) {
		DV_lincenseNum = dV_lincenseNum;
	}


	public long getContact_No() {
		return Contact_No;
	}


	public void setContact_No(long contact_No) {
		Contact_No = contact_No;
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


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public String getOwnerName() {
		return OwnerName;
	}


	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}


	public String getPremium() {
		return premium;
	}


	public void setPremium(String premium) {
		this.premium = premium;
	}
	
}
