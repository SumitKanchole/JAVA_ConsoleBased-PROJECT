package policy.insurance.services;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import policy.insurance.Dao.*;
import policy.insurance.model.ClaimInsurance;
import policy.insurance.model.HealthInsurance;
import policy.insurance.model.Insurance;
import policy.insurance.model.TermLifeInsurance;
import policy.insurance.model.TravelInsurance;
import policy.insurance.model.VehicleInsurance;
import policy.insurance.model.WholeLifeInsurance;

	
public class InsService {
	
	 LocalDate date = LocalDate.now();
     LocalTime time = LocalTime.now();
     
     
	
	InsDAO processing;
	
	public InsService() throws SQLException {
	processing= new InsDAO();
	}
	
	
	//User Authentication
	
	
	public Boolean AddUser(String username,String password) throws SQLException {
		return processing.fetchUsers(username,password);
	}
	
	//Term Life Insurance 
	
		public void AddAllTermLifeRelatedData(TermLifeInsurance in) throws SQLException {
			processing.InsertAllTlifeDATA(in);
		}
		
		
		
		public List <TermLifeInsurance> fetchAllTLCustomers() throws SQLException {
			return processing.getAllTLConsumersData();
		}
		
		public TermLifeInsurance findTLConsumerByID(int ins) throws SQLException{
			return processing.getTLConsumerById(ins);
		}
		
		public String updateNomineeNameByID(String nName,int id) throws SQLException {
			return processing.SetNomineeNameByID(nName,id);
		}
		
		public String deleteTLConsumerDataByName(String name) throws SQLException {
			return processing.DeleteTLConsumerByName(name);
		}
		
		public TermLifeInsurance calculateTLPremium1(int id) throws SQLException {
			TermLifeInsurance l = processing.getTLBillOf(id);
			Float s = null;
			if(l.getPremium().equalsIgnoreCase("level")) {
				s =  ((l.getSalary()*30/100) * 1.8f * (l.getDuration()*12))/100;
				
				System.out.println("\t|============================================================|");
				System.out.println("\t|\tYour Yearly Premium Amount : \t"+s+"rs.");
				System.out.println("\t|------------------------------------------------------------|");
				
			}
			else if(l.getPremium().equalsIgnoreCase("fixed")) {
				s =  ((l.getSalary()*30/100) * 1.2f * l.getDuration())/100;
				System.out.println("\t|============================================================|");
				System.out.println("\t|\tYour Monthly Premium : \t"+s+"rs.");
				System.out.println("\t|------------------------------------------------------------|");
			}
			else if(l.getPremium().equalsIgnoreCase("single")) {
				s =  ((l.getSalary()*30/100)*12 * 1.5f * (l.getDuration()*12))/100;
				System.out.println("\t|============================================================|");
				System.out.println("\t|\tYour Total Premium Amount : \t"+s+"rs.");
				System.out.println("\t|------------------------------------------------------------|");
			}
			else if(l.getPremium().equalsIgnoreCase("flexible")) {
				s =  ((l.getSalary()*30/100) * 2.5f * l.getDuration())/100;
				System.out.println("\t|============================================================|");
				System.out.println("\t|\tYour Premium Amount : \t"+s+"rs.");
				System.out.println("\t|------------------------------------------------------------|");
				
			}
			System.out.println("\t|\tYour ID :\t"+l.getCustomer_id());
			System.out.println("\t|------------------------------------------------------------|");
			System.out.println("\t|\tYour Name :\t"+l.getCustomer_name());
			System.out.println("\t|------------------------------------------------------------|");
			System.out.println("\t|\tYour Contact No. :\t"+l.getContact_No());
			System.out.println("\t|------------------------------------------------------------|");
			System.out.println("\t|\tYour Premium Duration :\t"+l.getDuration());
			System.out.println("\t|------------------------------------------------------------|");
			System.out.println("\t|\tYour Premium Type :\t"+l.getPremium());
			System.out.println("\t|------------------------------------------------------------|");
			System.out.println("\t|\tDate: " + date);
			System.out.println("\t|------------------------------------------------------------|");
		     System.out.println("\t|\tTime: " + time);
			System.out.println("\t|============================================================|");
//			ClaimInsurance clc = new ClaimInsurance();
			 processing.CalculatePremium(l.getCustomer_id(),l.getCustomer_name(),l.getContact_No(),l.getDuration(),l.getPremium(),s,date,time,l.getNominee_name());
			
			 return l;
		}
		
		
		public ClaimInsurance ClaimedInsurancebyNominee(int id,String name,String nominee,int month) throws SQLException {
			return processing.getTLClaimOf(id,name,nominee);

		}
		
		
		
		
	

		//Whole life Insurance 
//		
			public void AddAllWholeLifeRelatedData(WholeLifeInsurance in) throws SQLException {
				processing.InsertAllWlifeDATA(in);
			}
			
			
			
			public List <WholeLifeInsurance> fetchAllWLCustomers() throws SQLException {
				return processing.getAllWLConsumersData();
			}
			
			public WholeLifeInsurance findWLConsumerByID(int ins) throws SQLException{
				return processing.getWLConsumerById(ins);
			}
			
			public String updateNomineesNameByID(String nName,int id) throws SQLException {
				return processing.SetNomineesNameByID(nName,id);
			}
			
			public String deleteWLConsumerDataByName(String name) throws SQLException {
				return processing.DeleteWLConsumerByName(name);
			}
			
			public WholeLifeInsurance calculateWLPremium1(int id) throws SQLException {
				WholeLifeInsurance l = processing.getWLBillOf(id);
				Float s = null;
				if(l.getPremium().equalsIgnoreCase("level")) {
					s =  ((l.getSalary()*30/100)*12 * 1.8f * 12)/100;
					
					System.out.println("\t|============================================================|");
					System.out.println("\t|\tYour Annual Premium Amount : \t"+s+"rs.");
					System.out.println("\t|------------------------------------------------------------|");
					
				}
				else if(l.getPremium().equalsIgnoreCase("fixed")) {
					s = ((l.getSalary()*30/100) * 1.2f * 12)/100;
					System.out.println("\t|============================================================|");
					System.out.println("\t|\tYour Monthly Premium : \t"+s+"rs.");
					System.out.println("\t|------------------------------------------------------------|");
				}
				
				else if(l.getPremium().equalsIgnoreCase("flexible")) {
					s =   ((l.getSalary()*30/100) * 2.5f * 12)/100;
					System.out.println("\t|============================================================|");
					System.out.println("\t|\tYour Premium Amount : \t"+s+"rs.");
					System.out.println("\t|------------------------------------------------------------|");
					
				}
				System.out.println("\t|\tYour ID :\t"+l.getCustomer_id());
				System.out.println("\t|------------------------------------------------------------|");
				System.out.println("\t|\tYour Name :\t"+l.getCustomer_name());
				System.out.println("\t|------------------------------------------------------------|");
				System.out.println("\t|\tYour Contact No. :\t"+l.getContact_No());
				System.out.println("\t|------------------------------------------------------------|");
//				System.out.println("\t|\tYour Premium Duration :\t"+l.getDuration());
//				System.out.println("\t|------------------------------------------------------------|");
				System.out.println("\t|\tYour Premium Type :\t"+l.getPremium());
				System.out.println("\t|------------------------------------------------------------|");
				System.out.println("\t|\tDate: " + date);
				System.out.println("\t|------------------------------------------------------------|");
			     System.out.println("\t|\tTime: " + time);
				System.out.println("\t|============================================================|");
				return null;
			}
			
		
		
	
	
	
	//Home Insurance
	
	public void AddAll(Insurance in) throws SQLException {
		processing.InsertAll(in);
	}
	
	public List <Insurance> fetchAllCustomer() throws SQLException {
		return processing.getAllData();
	}
	
	public Insurance findCustomerByID(int ins) throws SQLException{
		return processing.getCustomerDataById(ins);
	}
	
	public String updateNameByID(String premium,int id) throws SQLException {
		return processing.SetNameByID(premium,id);
	}
	
	public String deleteDataByName(String name) throws SQLException {
		return processing.DeleteCustomerByName(name);
	}
	
	public Insurance calculateEMI(int id) throws SQLException {
		Insurance l = processing.getSomeData(id);
		Float s = null;
		if(l.getPremium().equalsIgnoreCase("level")) {
			s =  ((l.getSalary()*30/100) * 1.8f * (l.getDuration()*12))/100;
			
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Yearly Premium Amount : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
			
		}
		else if(l.getPremium().equalsIgnoreCase("fixed")) {
			s =  ((l.getSalary()*30/100) * 1.2f * l.getDuration())/100;
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Monthly Premium : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
		}
		else if(l.getPremium().equalsIgnoreCase("single")) {
			s =  ((l.getSalary()*30/100)*12 * 1.5f * (l.getDuration()*12))/100;
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Total Premium Amount : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
		}
		else if(l.getPremium().equalsIgnoreCase("flexible")) {
			s =  ((l.getSalary()*30/100) * 2.5f * l.getDuration())/100;
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Premium Amount : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
			
		}
		System.out.println("\t|\tYour ID :\t"+l.getCustomer_id());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Name :\t"+l.getCustomer_name());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Contact No. :\t"+l.getContact_No());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Premium Duration :\t"+l.getDuration());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Premium Type :\t"+l.getPremium());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tDate: " + date);
		System.out.println("\t|------------------------------------------------------------|");
	     System.out.println("\t|\tTime: " + time);
		System.out.println("\t|============================================================|");
		return null;
	}
	
	
	
	
	// Vehicle/ Motors Insurance :-
	
	
	public void AddAllVehicleData(VehicleInsurance in) throws SQLException {
		processing.InsertAllDATA(in);
	}
	
	
	
	public List <VehicleInsurance> fetchingAllCustomer() throws SQLException {
		return processing.getAllCustomerData();
	}
	
	public VehicleInsurance findCustomersByID(int ins) throws SQLException{
		return processing.getCustomerById(ins);
	}
	
	public String updateNamesByID(String premium,int id) throws SQLException {
		return processing.SetPremiumByID(premium,id);
	}
	
	public String deleteByName(String name) throws SQLException {
		return processing.DeleteCustomersByName(name);
	}
	
	public VehicleInsurance calculatePremium(int id) throws SQLException {
		VehicleInsurance l = processing.getBillOf(id);
		Float s = null;
		if(l.getPremium().equalsIgnoreCase("level")) {
			s =  ((l.getSalary()*30/100) * 1.0f * (l.getDuration()*12))/100;
			
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Yearly Premium Amount : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
			
		}
		else if(l.getPremium().equalsIgnoreCase("fixed")) {
			s = ((l.getSalary()*30/100) * 0.8f * l.getDuration())/100;
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Monthly Premium : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
		}
		else if(l.getPremium().equalsIgnoreCase("single")) {
			s =  ((l.getSalary()*30/100)*12 * 0.5f * (l.getDuration()*12))/100;
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Total Premium Amount : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
		}
		else if(l.getPremium().equalsIgnoreCase("flexible")) {
			s =   ((l.getSalary()*30/100) * 0.4f * l.getDuration())/100;
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Premium Amount : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
			
		}
		System.out.println("\t|\tYour ID :\t"+l.getCustomer_id());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Name :\t"+l.getCustomer_name());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Contact No. :\t"+l.getContact_No());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Premium Duration :\t"+l.getDuration());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Premium Type :\t"+l.getPremium());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tDate: " + date);
		System.out.println("\t|------------------------------------------------------------|");
	     System.out.println("\t|\tTime: " + time);
		System.out.println("\t|============================================================|");
		return null;
	}
	
	
	
	
	//Health Insurance 
	
	public void AddAllHealthRelatedData(HealthInsurance in) throws SQLException {
		processing.InsertAllHealthDATA(in);
	}
	
	
	
	public List <HealthInsurance> fetchAllCustomers() throws SQLException {
		return processing.getAllConsumersData();
	}
	
	public HealthInsurance findConsumerByID(int ins) throws SQLException{
		return processing.getConsumerById(ins);
	}
	
	public String updateBloodGroupByID(String premium,int id) throws SQLException {
		return processing.SetBloodGroupByID(premium,id);
	}
	
	public String deleteConsumerDataByName(String name) throws SQLException {
		return processing.DeleteConsumerByName(name);
	}
	
	public HealthInsurance calculatePremium1(int id) throws SQLException {
		HealthInsurance l = processing.getBillOff(id);
		Float s = null;
		if(l.getPremium().equalsIgnoreCase("level")) {
			s =  ((l.getSalary()*30/100) * 1.8f * (l.getDuration()*12))/100;
			
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Yearly Premium Amount : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
			
		}
		else if(l.getPremium().equalsIgnoreCase("fixed")) {
			s =  ((l.getSalary()*30/100) * 1.2f * l.getDuration())/100;
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Monthly Premium : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
		}
		else if(l.getPremium().equalsIgnoreCase("single")) {
			s =  ((l.getSalary()*30/100)*12 * 1.5f * (l.getDuration()*12))/100;
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Total Premium Amount : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
		}
		else if(l.getPremium().equalsIgnoreCase("flexible")) {
			s =  ((l.getSalary()*30/100) * 2.5f * l.getDuration())/100;
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Premium Amount : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
			
		}
		System.out.println("\t|\tYour ID :\t"+l.getCustomer_id());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Name :\t"+l.getCustomer_name());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Contact No. :\t"+l.getContact_No());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Premium Duration :\t"+l.getDuration());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Premium Type :\t"+l.getPremium());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tDate: " + date);
		System.out.println("\t|------------------------------------------------------------|");
	     System.out.println("\t|\tTime: " + time);
		System.out.println("\t|============================================================|");
		return null;
	}
	
	
	
	
	
			//Travel Insurance––
	
	
	public void AddAllTravelRelatedData(TravelInsurance in) throws SQLException {
		processing.InsertAllTravelDATA(in);
	}
	
	
	
	public List <TravelInsurance> fetchAllTravellerDetail() throws SQLException {
		return processing.getAllTravellerData();
	}
	
	public TravelInsurance findTravellerByID(int ins) throws SQLException{
		return processing.getTravellerById(ins);
	}
	
	public String updatePremiumsByID(String premium,int id) throws SQLException {
		return processing.SetPremiumsByID(premium,id);
	}
	
	public String deleteTravellerByName(String name) throws SQLException {
		return processing.DeleteTravellerByName(name);
	}
	
	public TravelInsurance calculatePremium2(int id) throws SQLException {
		TravelInsurance l = processing.getBilledOf(id);
		Float s = null;
		if(l.getPremium().equalsIgnoreCase("annual")) {
			s =  ((l.getSalary()*20/100) * 1.8f * (l.getDuration()*12))/100;
			
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Annual Trip Premium Amount : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
			
		}
		else if(l.getPremium().equalsIgnoreCase("multi trip")) {
			s = ((l.getSalary()*20/100) * 1.2f * l.getDuration())/100;
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Multi Trip Premium : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
		}
		else if(l.getPremium().equalsIgnoreCase("single trip")) {
			s =  ((l.getSalary()*20/100)*12 * 2.5f * (l.getDuration()*12))/100;
			System.out.println("\t|============================================================|");
			System.out.println("\t|\tYour Single Trip Premium Amount : \t"+s+"rs.");
			System.out.println("\t|------------------------------------------------------------|");
		}
		
		System.out.println("\t|\tYour ID :\t"+l.getCustomer_id());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Name :\t"+l.getCustomer_name());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Contact No. :\t"+l.getContact_No());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Premium Duration :\t"+l.getDuration());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tYour Premium Type :\t"+l.getPremium());
		System.out.println("\t|------------------------------------------------------------|");
		System.out.println("\t|\tDate: " + date);
		System.out.println("\t|------------------------------------------------------------|");
	     System.out.println("\t|\tTime: " + time);
		System.out.println("\t|============================================================|");
		return null;
	}
	
	
	
	
}
