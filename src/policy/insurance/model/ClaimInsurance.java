package policy.insurance.model;

import java.sql.Date;
import java.sql.Time;
//import java.time.LocalDate;
//import java.time.LocalTime;

public class ClaimInsurance {
	
	
//	 LocalDate date1 = LocalDate.now();
//     LocalTime time1 = LocalTime.now();

	int id;
	String name;
	String MoNo;
	int duration;
	String premium;
	Float preAmount;
	Date date;
	Time time;
	String nominee;
	Float total;
	public ClaimInsurance(int id, String name, String moNo2, int duration, String premium, Float preAmount, Date date, Time time,String nominee,Float total) {
		super();
		this.id = id;
		this.name = name;
		MoNo = moNo2;
		this.duration = duration;
		this.premium = premium;
		this.preAmount=preAmount;
		this.date = date;
		this.time = time;
		this.nominee=nominee;
		this.total=total;
	}
	
	
	
	
	
	
	public ClaimInsurance() {
		super();
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
	public String getMoNo() {
		return MoNo;
	}
	public void setMoNo(String moNo) {
		MoNo = moNo;
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
		
	public Float getPreAmount() {
		return preAmount;
	}

	public void setPreAmount(Float preAmount) {
		this.preAmount = preAmount;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}


	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
	
	
	
}
