package policy.insurance.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import policy.insurance.model.ClaimInsurance;
import policy.insurance.model.HealthInsurance;
//import layer.st.model.Student11;
import policy.insurance.model.Insurance;
import policy.insurance.model.TermLifeInsurance;
import policy.insurance.model.TravelInsurance;
import policy.insurance.model.VehicleInsurance;
import policy.insurance.model.WholeLifeInsurance;

public class InsDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/InsuranceManagement";
    private static final String USER = "root";
    private static final String PASSWORD = "Sumit@123";

   
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    
    
    //USER AUTHENTICATION
    
    public Boolean fetchUsers(String username, String password) throws SQLException {
    	String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
    	Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);

        
        ResultSet rs = ps.executeQuery();
        boolean status = false;
       
        if (rs.next()) {
            System.out.println("\n✅ Login successful! Welcome, " + username);
            status = true;
            
        } else {
            System.out.println("\n❌ Invalid username or password.\n");
            status = false;
        }
        
        return status;

    }
    
    
 // TERM LIFE INSURANCE
    
    
    public void InsertAllTlifeDATA(TermLifeInsurance in) throws SQLException {
  	  	 Connection conn = getConnection();
  	  	PreparedStatement pstmt = conn.prepareStatement("insert Into TermLifeInsurance(id,name,address,age,contact,salary,medical_status,Nominee_name,nominee_relation,Nominee_no,premium,duration) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

  	  	pstmt.setInt(1, in.getCustomer_id());
  	  	pstmt.setString(2, in.getCustomer_name());
  	  	pstmt.setString(3, in.getAddress());
  	  	pstmt.setInt(4, in.getCustomer_age());
  	  	pstmt.setLong(5, in.getContact_No());
  	  	pstmt.setLong(6, in.getSalary());
  	  	pstmt.setString(7, in.getMedical_status());
  	  	pstmt.setString(8, in.getNominee_name());
  	  	pstmt.setString(9, in.getNominee_relation());
  	  	pstmt.setLong(10, in.getNominee_No());
  	  	pstmt.setString(11, in.getPremium());
  	  	pstmt.setInt(12, in.getDuration());
  	  	
  	  	pstmt.executeUpdate();
  	  	System.out.println("\n🎉 Customer Registered Successfully! 🎉");
  	  }
  	   
  	   
  	   public List<TermLifeInsurance> getAllTLConsumersData() throws SQLException {
  	  	 List<TermLifeInsurance> insure = new ArrayList<>();
  	       String sql = "SELECT * FROM TermLifeInsurance";
  	       
  	       Connection conn = getConnection();
  	            Statement stmt = conn.createStatement();
  	            ResultSet rs = stmt.executeQuery(sql);
  	           
  	           while (rs.next()) {
  	               int Customer_id = rs.getInt(1);
  	               String Customer_Name = rs.getString(2);
  	               String Address = rs.getString(3);
  	               int age = rs.getInt(4);
  	               Long Contact_No = rs.getLong(5);
  	               String Medical_status = rs.getString(6);
  	               String Nominee_name = rs.getString(7);
  	               String nominee_relation = rs.getString(8);
  	               Long Nominee_no = rs.getLong(9);
  	               String premium = rs.getString(10);
  	               int duration = rs.getInt(11);
  	               Long salary = rs.getLong(12);
  	               
  	               
  	             TermLifeInsurance in1 = new TermLifeInsurance(Customer_id, Customer_Name, Address, age, Contact_No,
							salary,Medical_status, Nominee_name, nominee_relation, Nominee_no,
							premium, duration);
  	           insure.add(in1);
  	           }
  	       return insure;

  	  }

  	   public TermLifeInsurance getTLConsumerById(int id) throws SQLException{
  	   	Connection conn = getConnection();
  	   	Statement stmt = conn.createStatement();
  	       
  	   	ResultSet rs= stmt.executeQuery("Select * from TermLifeInsurance where id="+id+"");
  	   	
  	   	 while (rs.next()) {
  	   	int Customer_id = rs.getInt(1);
          String Customer_Name = rs.getString(2);
          String Address = rs.getString(3);
          int age = rs.getInt(4);
          Long Contact_No = rs.getLong(5);
          String Medical_status = rs.getString(6);
          String Nominee_name = rs.getString(7);
          String nominee_relation = rs.getString(8);
          Long Nominee_no = rs.getLong(9);
          String premium = rs.getString(10);
          int duration = rs.getInt(11);
          Long salary = rs.getLong(12);
           
           
         TermLifeInsurance in1 = new TermLifeInsurance(Customer_id, Customer_Name, Address, age, Contact_No,
					salary,Medical_status, Nominee_name, nominee_relation, Nominee_no,
					premium, duration);
         	return in1;
  	   }
  	   	 return null;
  	   }
  	   
  	   public String SetNomineeNameByID(String nominee_name,int id) throws SQLException {
  	   	String sql = "update TermLifeInsurance set nominee_name=? where id=?";
  	   	Connection conn = getConnection();
  	   	 PreparedStatement pstmt = conn.prepareStatement(sql);
  	        pstmt.setString(1,nominee_name);
  	        pstmt.setInt(2, id);
  	        pstmt.executeUpdate();
  	      
  	        return "✅ Dear Customer, your Nominee Name has been successfully Changed!";
  	   }
  	   
  	   public String DeleteTLConsumerByName(String name) throws SQLException {
  	   	String sql = "Delete from TermLifeInsurance where name=?";
  	   	Connection conn = getConnection();

  	   	 PreparedStatement pstmt = conn.prepareStatement(sql);
  	        pstmt.setString(1,name);
  	        pstmt.executeUpdate();
  	        
  	        return "";
  	   }
  	   
  	  public TermLifeInsurance getTLBillOf(int id) throws SQLException {
  		   Connection conn = getConnection();
  		   Statement stmt = conn.createStatement();
  	      
  	  	ResultSet rs= stmt.executeQuery("Select * from TermLifeInsurance where id="+id+"");
  	  	
  	   while (rs.next()) {
  		 int Customer_id = rs.getInt(1);
           String Customer_Name = rs.getString(2);
           String Address = rs.getString(3);
           int age = rs.getInt(4);
           Long Contact_No = rs.getLong(5);
           String Medical_status = rs.getString(6);
           String Nominee_name = rs.getString(7);
           String nominee_relation = rs.getString(8);
           Long Nominee_no = rs.getLong(9);
           String premium = rs.getString(10);
           int duration = rs.getInt(11);
           Long salary = rs.getLong(12);
         
         
       TermLifeInsurance in1 = new TermLifeInsurance(Customer_id, Customer_Name, Address, age, Contact_No,
					salary,Medical_status, Nominee_name, nominee_relation, Nominee_no,
					premium, duration);
       	return in1;
  	}
  	return null;
  	  }
  	  
  	  
  	  public ClaimInsurance CalculatePremium(int id,String name,Long MoNo,int duration,String premium,Float preAmount,LocalDate dateshow,LocalTime timeshow, String nominee) throws SQLException {
  		
  		Connection conn = getConnection();
  		ClaimInsurance in = new ClaimInsurance();
  		in.setDate(Date.valueOf(dateshow));
  	    in.setTime(Time.valueOf(timeshow));
//  	    in.setTotal(total);
  	    
//  	    TermLifeInsurance tmt = new TermLifeInsurance();
  	  	PreparedStatement pstmt = conn.prepareStatement("insert Into ClaimInsurance(id,name,contact,duration,premium,preAmount,dateshow,timeshow,nominee,total) values(?, ?, ?, ?, ?, ?, ?,?, ?,?)");

  	  	pstmt.setInt(1, id);
  	  	pstmt.setString(2, name);
  	  	pstmt.setLong(3, MoNo);
  	  	pstmt.setInt(4, duration);
  	  	pstmt.setString(5, premium);
  	  	pstmt.setFloat(6, preAmount);
  	  	pstmt.setDate(7, in.getDate());
  	  	pstmt.setTime(8, in.getTime());
  	  	pstmt.setString(9, nominee);
  	  	pstmt.setFloat(10,in.getTotal());
  	  	pstmt.executeUpdate();
  	  	
  	  	return in;
  	  }
  	  
  	  
  	  
  	  public ClaimInsurance getTLClaimOf(int id,String name,String nominee) throws SQLException {
  		
//  		  List<ClaimInsurance> insure = new ArrayList<>();  
  		Connection conn = getConnection();
  	   	Statement stmt = conn.createStatement();
//  	   	ClaimInsurance in = new ClaimInsurance();
//  	   	
//  	  PreparedStatement pstmt = conn.prepareStatement("insert Into ClaimedTLInsurance(id,name,contact,duration,premium,preAmount,dateshow,timeshow,nominee,total) values(?, ?, ?, ?, ?, ?, ?,?, ?,?)");
//
//	  	pstmt.setInt(1, in.getId());
//	  	pstmt.setString(2, name);
//	  	pstmt.setString(3, in.getMoNo());
//	  	pstmt.setInt(4, in.getDuration());
//	  	pstmt.setString(5, in.getPremium());
//	  	pstmt.setFloat(6, in.getPreAmount());
//	  	pstmt.setDate(7, in.getDate());
//	  	pstmt.setTime(8, in.getTime());
//	  	pstmt.setString(9, nominee);
//	  	pstmt.setFloat(10,in.getTotal());
//	  	pstmt.executeUpdate();
//	  	
//  	   	
//  	   	
  	   	
  	   	ResultSet rs= stmt.executeQuery("Select * from ClaimInsurance where id="+id+" and name='"+name+"' and nominee='"+nominee+"'");
  	   	
  	   	 while (rs.next()) {
  	   	  int id1 = rs.getInt(1);
          String name1 = rs.getString(2);
          String moNo = rs.getString(3);
          int duration = rs.getInt(4);
          String premium = rs.getString(5);
          Float preAmount = rs.getFloat(6);
          Date date = rs.getDate(7);
          Time time = rs.getTime(8);
          String nominee1 = rs.getString(9);
		 Float total = rs.getFloat(10);
         
           
		 ClaimInsurance in = new ClaimInsurance(id1, name1, moNo, duration, premium, preAmount, date, time,nominee1,total);
//         insure.add(in);
		 return in;
  		  
  	   	 }
  		  return null;
  		  
  	  }
     
     
  	  
  	  
  	  
  	  
//  	  Whole Life Insurance
  	  
  	  
  	  public void InsertAllWlifeDATA(WholeLifeInsurance in) throws SQLException {
   	  	 Connection conn = getConnection();
   	  	PreparedStatement pstmt = conn.prepareStatement("Insert Into WholeLifeInsurance(id,name,address,age,contact,medical_status,nominee_name,nominee_relation,nominee_no,premium,salary) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

   	  	pstmt.setInt(1, in.getCustomer_id());
   	  	pstmt.setString(2, in.getCustomer_name());
   	  	pstmt.setString(3, in.getAddress());
   	  	pstmt.setInt(4, in.getCustomer_age());
   	  	pstmt.setLong(5, in.getContact_No());
   	  	pstmt.setString(6, in.getMedical_status());
   	  	pstmt.setString(7, in.getNominee_name());
   	  	pstmt.setString(8, in.getNominee_relation());
   	  	pstmt.setLong(9, in.getNominee_No());
   	  	pstmt.setString(10, in.getPremium());
   	  	pstmt.setLong(11, in.getSalary());
   	  	
   	  	pstmt.executeUpdate();
   	  	System.out.println("\n🎉 Customer Registered Successfully! 🎉");
   	  }
   	   
   	   
   	   public List<WholeLifeInsurance> getAllWLConsumersData() throws SQLException {
   	  	 List<WholeLifeInsurance> insure = new ArrayList<>();
   	       String sql = "SELECT * FROM WholeLifeInsurance";
   	       
   	       Connection conn = getConnection();
   	            Statement stmt = conn.createStatement();
   	            ResultSet rs = stmt.executeQuery(sql);
   	           
   	           while (rs.next()) {
   	               int Customer_id = rs.getInt(1);
   	               String Customer_Name = rs.getString(2);
   	               String Address = rs.getString(3);
   	               int age = rs.getInt(4);
   	               Long Contact_No = rs.getLong(5);
   	               String Medical_status = rs.getString(6);
   	               String Nominee_name = rs.getString(7);
   	               String nominee_relation = rs.getString(8);
   	               Long Nominee_no = rs.getLong(9);
   	               String premium = rs.getString(10);
   	               Long salary = rs.getLong(11);
   	               
   	               
   	               
   	            WholeLifeInsurance in1 = new WholeLifeInsurance(Customer_id, Customer_Name, Address, age, Contact_No,
 							salary,Medical_status, Nominee_name, nominee_relation, Nominee_no,
 							premium);
   	           insure.add(in1);
   	           }
   	       return insure;

   	  }

   	   public WholeLifeInsurance getWLConsumerById(int id) throws SQLException{
   	   	Connection conn = getConnection();
   	   	Statement stmt = conn.createStatement();
   	       
   	   	ResultSet rs= stmt.executeQuery("Select * from WholeLifeInsurance where id="+id+"");
   	   	
   	   	 while (rs.next()) {
   	   	 int Customer_id = rs.getInt(1);
            String Customer_Name = rs.getString(2);
            String Address = rs.getString(3);
            int age = rs.getInt(4);
            Long Contact_No = rs.getLong(5);
            String Medical_status = rs.getString(6);
            String Nominee_name = rs.getString(7);
            String nominee_relation = rs.getString(8);
            Long Nominee_no = rs.getLong(9);
            String premium = rs.getString(10);
            Long salary = rs.getLong(11);
           
            
            
          WholeLifeInsurance in1 = new WholeLifeInsurance(Customer_id, Customer_Name, Address, age, Contact_No,
 					salary,Medical_status, Nominee_name, nominee_relation, Nominee_no,
 					premium);
          	return in1;
   	   }
   	   	 return null;
   	   }
   	   
   	   public String SetNomineesNameByID(String nominee_name,int id) throws SQLException {
   	   	String sql = "update WholeLifeInsurance set nominee_name=? where id=?";
   	   	Connection conn = getConnection();
   	   	 PreparedStatement pstmt = conn.prepareStatement(sql);
   	        pstmt.setString(1,nominee_name);
   	        pstmt.setInt(2, id);
   	        pstmt.executeUpdate();
   	      
   	        return "✅ Dear Customer, your Nominee Name has been successfully Changed!";
   	   }
   	   
   	   public String DeleteWLConsumerByName(String name) throws SQLException {
   	   	String sql = "Delete from WholeLifeInsurance where name=?";
   	   	Connection conn = getConnection();

   	   	 PreparedStatement pstmt = conn.prepareStatement(sql);
   	        pstmt.setString(1,name);
   	        pstmt.executeUpdate();
   	        
   	        return "";
   	   }
   	   
   	  public WholeLifeInsurance getWLBillOf(int id) throws SQLException {
   		   Connection conn = getConnection();
   		   Statement stmt = conn.createStatement();
   	      
   	  	ResultSet rs= stmt.executeQuery("Select * from WholeLifeInsurance where id="+id+"");
   	  	
   	   while (rs.next()) {
   		int Customer_id = rs.getInt(1);
           String Customer_Name = rs.getString(2);
           String Address = rs.getString(3);
           int age = rs.getInt(4);
           Long Contact_No = rs.getLong(5);
           String Medical_status = rs.getString(6);
           String Nominee_name = rs.getString(7);
           String nominee_relation = rs.getString(8);
           Long Nominee_no = rs.getLong(9);
           String premium = rs.getString(10);
           Long salary = rs.getLong(11);
          
          
        WholeLifeInsurance in1 = new WholeLifeInsurance(Customer_id, Customer_Name, Address, age, Contact_No,
 					salary,Medical_status, Nominee_name, nominee_relation, Nominee_no,
 					premium);
        	return in1;
   	}
   	return null;
   	  }
      
    
    
    
    //HOME INSURANCE
    
    public void InsertAll(Insurance in) throws SQLException {
    	 Connection conn = getConnection();
    	PreparedStatement pstmt = conn.prepareStatement("Insert Into HomeInsurance(id,name,address,OwnerName,propertyTYPE,yearBuilt,bank_AccountHolder,bank_AccountNumber,premium,age,contact,salary,nominee_name,nominee_no,duration) values(?, ?, ?, ?, ?, ?,?, ?, ?, ?,?,?,?,?,?)");
    	
    	pstmt.setLong(1, in.getCustomer_id());
    	pstmt.setString(2, in.getCustomer_name());
    	pstmt.setString(3, in.getAddress());
    	pstmt.setString(4, in.getOwnerName());
    	pstmt.setString(5, in.getPropertyType());
    	pstmt.setInt(6, in.getYearBuilt());
    	pstmt.setString(7, in.getBank_AccountHolder());
    	pstmt.setLong(8, in.getBank_AccountNumber());
    	pstmt.setString(9, in.getPremium());
    	pstmt.setInt(10, in.getCustomer_age());
    	pstmt.setLong(11, in.getContact_No());
    	pstmt.setLong(12, in.getSalary());
    	pstmt.setString(13, in.getNominee_name());
    	pstmt.setLong(14, in.getNominee_No());
    	pstmt.setInt(15, in.getDuration());
    	pstmt.executeUpdate();
    	System.out.println("\n🎉 Customer Registered Successfully! 🎉");
    }
    
    public List<Insurance> getAllData() throws SQLException {
    	 List<Insurance> insure = new ArrayList<>();
         String sql = "SELECT * FROM homeInsurance";
         
         Connection conn = getConnection();
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
             while (rs.next()) {
                 int Customer_id = rs.getInt(1);
                 String Customer_Name = rs.getString(2);
                 String Address = rs.getString(3);
                 String OwnerName = rs.getString(4);
                 String PropertyType = rs.getString(5);
//                 Long premium_price = rs.getLong(6);
                 int yearBuilt = rs.getInt(6);
                 String bank_AccountHolder = rs.getString(7);
                 Long bank_AccountNumber = rs.getLong(8);
                 String premium = rs.getString(9);
                 int age = rs.getInt(10);
                 Long Contact_No = rs.getLong(11);
                 Long salary = rs.getLong(12);
                 String Nominee_name = rs.getString(13);
                 Long Nominee_no = rs.getLong(14);
                 int duration = rs.getInt(15);
                 
                 Insurance in = new Insurance(Customer_id, Customer_Name, Address, OwnerName, PropertyType,
                		 yearBuilt, bank_AccountHolder, bank_AccountNumber, premium, age,Contact_No,salary,Nominee_name,Nominee_no,duration);
                 insure.add(in);
             }
         return insure;

    }
    
    public Insurance getCustomerDataById(int id) throws SQLException{
    	Connection conn = getConnection();
    	Statement stmt = conn.createStatement();
        
    	ResultSet rs= stmt.executeQuery("Select * from homeInsurance where id="+id+"");
    	
    	 while (rs.next()) {
             int Customer_id = rs.getInt(1);
             String Customer_Name = rs.getString(2);
             String Address = rs.getString(3);
             String OwnerName = rs.getString(4);
             String PropertyType = rs.getString(5);
//             Long premium_price = rs.getLong(6);
             int yearBuilt = rs.getInt(6);
             String bank_AccountHolder = rs.getString(7);
             Long bank_AccountNumber = rs.getLong(8);
             String premium = rs.getString(9);
             int age = rs.getInt(10);
             Long Contact_No = rs.getLong(11);
             Long salary = rs.getLong(12);
             String Nominee_name = rs.getString(13);
             Long Nominee_no = rs.getLong(14);
             int duration = rs.getInt(15);
             Insurance in = new Insurance(Customer_id, Customer_Name, Address, OwnerName, PropertyType,
            		  yearBuilt, bank_AccountHolder, bank_AccountNumber, premium, age,Contact_No,salary,Nominee_name,Nominee_no,duration);
             return in;
    }
    	 return null;
    }
    
    public String SetNameByID(String premium,int id) throws SQLException {
    	String sql = "update homeInsurance set premium=? where id=?";
    	Connection conn = getConnection();
    	 PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1,premium);
         pstmt.setInt(2, id);
         pstmt.executeUpdate();
        
         return "✅ Dear Customer, your premium Type has been successfully changed!";
    }
    
    public String DeleteCustomerByName(String name) throws SQLException {
    	String sql = "Delete from homeInsurance where name=?";
    	Connection conn = getConnection();

    	 PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1,name);
         pstmt.executeUpdate();
         
         return "";
    }
    
   public Insurance getSomeData(int id) throws SQLException {
	   Connection conn = getConnection();
	   Statement stmt = conn.createStatement();
       
   	ResultSet rs= stmt.executeQuery("Select * from homeInsurance where id="+id+"");
   	
    while (rs.next()) {
        int Customer_id = rs.getInt(1);
        String Customer_Name = rs.getString(2);
        String Address = rs.getString(3);
        String OwnerName = rs.getString(4);
        String PropertyType = rs.getString(5);
        int yearBuilt = rs.getInt(6);
        String bank_AccountHolder = rs.getString(7);
        Long bank_AccountNumber = rs.getLong(8);
        String premium = rs.getString(9);
        int age = rs.getInt(10);
        Long Contact_No = rs.getLong(11);
        Long salary = rs.getLong(12);
        String Nominee_name = rs.getString(13);
        Long Nominee_no = rs.getLong(14);
        int duration = rs.getInt(15);
        Insurance in = new Insurance(Customer_id, Customer_Name, Address, OwnerName, PropertyType,
       		  yearBuilt, bank_AccountHolder, bank_AccountNumber, premium, age,Contact_No,salary,Nominee_name,Nominee_no,duration);
        return in;
}
return null;
   }
   
   
   
   
   
   
   // VEHICLE/MOTOR INSURANCE
   
   
   public void InsertAllDATA(VehicleInsurance in) throws SQLException {
  	 Connection conn = getConnection();
  	PreparedStatement pstmt = conn.prepareStatement("Insert Into VehicleInsurance(id,name,address,contact,age,licenseNum,rcNumber,pucNumber,ownerName,bank_AcHolder,bank_AcNumber,Nominee_name,Nominee_no,premium,duration,salary,VehicleType) values(?, ?, ?, ?, ?, ?,?, ?, ?, ?,?,?,?,?,?,?,?)");
  	
//  	Customer_id,Customer_Name,Address,OwnerName,PropertyType,property_price,yearBuilt,bank_AccountHolder,bank_AccountNumber,premium,Customer_age
  	pstmt.setInt(1, in.getCustomer_id());
  	pstmt.setString(2, in.getCustomer_name());
  	pstmt.setString(3, in.getAddress());
  	pstmt.setLong(4, in.getContact_No());
  	pstmt.setInt(5, in.getCustomer_age());
  	pstmt.setString(6, in.getDV_lincenseNum());
  	pstmt.setString(7, in.getRC_num());
  	pstmt.setString(8, in.getPUC_num());
  	pstmt.setString(9, in.getOwnerName());
  	pstmt.setString(10, in.getBank_AccountHolder());
  	pstmt.setLong(11, in.getBank_AccountNumber());
  	pstmt.setString(12, in.getNominee_name());
  	pstmt.setLong(13, in.getNominee_No());
  	pstmt.setString(14, in.getPremium());
  	pstmt.setInt(15, in.getDuration());
  	pstmt.setLong(16, in.getSalary());
  	pstmt.setString(17, in.getVehicleType());
  
  	pstmt.executeUpdate();
  	System.out.println("\n🎉 Customer Registered Successfully! 🎉");
  }
   
   
   public List<VehicleInsurance> getAllCustomerData() throws SQLException {
  	 List<VehicleInsurance> insure = new ArrayList<>();
       String sql = "SELECT * FROM VehicleInsurance";
       
       Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
           
           while (rs.next()) {
               int Customer_id = rs.getInt(1);
               String Customer_Name = rs.getString(2);
               String Address = rs.getString(3);
               Long Contact_No = rs.getLong(4);
               int age = rs.getInt(5);
               String DV_lincenseNum = rs.getString(6);
               String RC_num = rs.getString(7);
               String PUC_num = rs.getString(8);
               String OwnerName = rs.getString(9);
               String bank_AccountHolder = rs.getString(10);
               Long bank_AccountNumber = rs.getLong(11);
               String Nominee_name = rs.getString(12);
               Long Nominee_no = rs.getLong(13);
               String premium = rs.getString(14);
               int duration = rs.getInt(15);
               Long salary = rs.getLong(16);
               String VehicleType = rs.getString(17);
               
               VehicleInsurance in = new VehicleInsurance(Customer_id, Customer_Name, Address, Contact_No, age,
            		   DV_lincenseNum, RC_num, PUC_num, OwnerName, bank_AccountHolder,bank_AccountNumber,Nominee_name,Nominee_no,premium,duration,salary,VehicleType);
               insure.add(in);
           }
       return insure;

  }

   public VehicleInsurance getCustomerById(int id) throws SQLException{
   	Connection conn = getConnection();
   	Statement stmt = conn.createStatement();
       
   	ResultSet rs= stmt.executeQuery("Select * from VehicleInsurance where id="+id+"");
   	
   	 while (rs.next()) {
   		 int Customer_id = rs.getInt(1);
         String Customer_Name = rs.getString(2);
         String Address = rs.getString(3);
         Long Contact_No = rs.getLong(4);
         int age = rs.getInt(5);
         String DV_lincenseNum = rs.getString(6);
         String RC_num = rs.getString(7);
         String PUC_num = rs.getString(8);
         String OwnerName = rs.getString(9);
         String bank_AccountHolder = rs.getString(10);
         Long bank_AccountNumber = rs.getLong(11);
         String Nominee_name = rs.getString(12);
         Long Nominee_no = rs.getLong(13);
         String premium = rs.getString(14);
         int duration = rs.getInt(15);
         Long salary = rs.getLong(16);
         String VehicleType = rs.getString(17);
         VehicleInsurance in = new VehicleInsurance(Customer_id, Customer_Name, Address, Contact_No, age,
      		   DV_lincenseNum, RC_num, PUC_num, OwnerName, bank_AccountHolder,bank_AccountNumber,Nominee_name,Nominee_no,premium,duration,salary,VehicleType);
         return in;
   }
   	 return null;
   }
   
   public String SetPremiumByID(String premium,int id) throws SQLException {
   	String sql = "update VehicleInsurance set premium=? where id=?";
   	Connection conn = getConnection();
   	 PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,premium);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
      
        return "✅ Dear Customer, your premium Type has been successfully changed!";
   }
   
   public String DeleteCustomersByName(String name) throws SQLException {
   	String sql = "Delete from VehicleInsurance where name=?";
   	Connection conn = getConnection();

   	 PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.executeUpdate();
        
        return "";
   }
   
  public VehicleInsurance getBillOf(int id) throws SQLException {
	   Connection conn = getConnection();
	   Statement stmt = conn.createStatement();
      
  	ResultSet rs= stmt.executeQuery("Select * from VehicleInsurance where id="+id+"");
  	
   while (rs.next()) {
	   int Customer_id = rs.getInt(1);
       String Customer_Name = rs.getString(2);
       String Address = rs.getString(3);
       Long Contact_No = rs.getLong(4);
       int age = rs.getInt(5);
       String DV_lincenseNum = rs.getString(6);
       String RC_num = rs.getString(7);
       String PUC_num = rs.getString(8);
       String OwnerName = rs.getString(9);
       String bank_AccountHolder = rs.getString(10);
       Long bank_AccountNumber = rs.getLong(11);
       String Nominee_name = rs.getString(12);
       Long Nominee_no = rs.getLong(13);
       String premium = rs.getString(14);
       int duration = rs.getInt(15);
       Long salary = rs.getLong(16);
       String VehicleType = rs.getString(17);
       VehicleInsurance in = new VehicleInsurance(Customer_id, Customer_Name, Address, Contact_No, age,
    		   DV_lincenseNum, RC_num, PUC_num, OwnerName, bank_AccountHolder,bank_AccountNumber,Nominee_name,Nominee_no,premium,duration,salary,VehicleType);
       return in;
}
return null;
  }
   
  
  
  
  		// HEALTH INSURANCE
  
  
  public void InsertAllHealthDATA(HealthInsurance in) throws SQLException {
	  	 Connection conn = getConnection();
	  	PreparedStatement pstmt = conn.prepareStatement("Insert Into HealthInsurance(id,name,address,age,salary,medical_status,blood_Group,Nominee_name,Nominee_no,contact,premium,duration) values(?, ?, ?, ?, ?, ?,?, ?, ?, ?,?,?)");
	  	

	  	pstmt.setInt(1, in.getCustomer_id());
	  	pstmt.setString(2, in.getCustomer_name());
	  	pstmt.setString(3, in.getAddress());
	  	pstmt.setInt(4, in.getCustomer_age());
	  	pstmt.setLong(5, in.getSalary());
	  	pstmt.setString(6, in.getMedical_Records());
	  	pstmt.setString(7, in.getBloodGroup());
	  	pstmt.setString(8, in.getNominee_name());
	  	pstmt.setLong(9, in.getNominee_No());
	  	pstmt.setLong(10, in.getContact_No());
	  	pstmt.setString(11, in.getPremium());
	  	pstmt.setInt(12, in.getDuration());
	  	
	  	pstmt.executeUpdate();
	  	System.out.println("\n🎉 Customer Registered Successfully! 🎉");
	  }
	   
	   
	   public List<HealthInsurance> getAllConsumersData() throws SQLException {
	  	 List<HealthInsurance> insure = new ArrayList<>();
	       String sql = "SELECT * FROM HealthInsurance";
	       
	       Connection conn = getConnection();
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	           
	           while (rs.next()) {
	               int Customer_id = rs.getInt(1);
	               String Customer_Name = rs.getString(2);
	               String Address = rs.getString(3);
	               int age = rs.getInt(4);
	               Long salary = rs.getLong(5);
	               String Medical_Records = rs.getString(6);
	               String BloodGroup = rs.getString(7);
	               String Nominee_name = rs.getString(8);
	               Long Nominee_no = rs.getLong(9);
	               Long Contact_No = rs.getLong(10);
	               String premium = rs.getString(11);
	               int duration = rs.getInt(12);
	               
	               
	               HealthInsurance in = new HealthInsurance(Customer_id, Customer_Name, Address, age, salary,
	       				Medical_Records, BloodGroup, Nominee_name, Nominee_no, Contact_No,
	       				duration,premium);
	               insure.add(in);
	           }
	       return insure;

	  }

	   public HealthInsurance getConsumerById(int id) throws SQLException{
	   	Connection conn = getConnection();
	   	Statement stmt = conn.createStatement();
	       
	   	ResultSet rs= stmt.executeQuery("Select * from HealthInsurance where id="+id+"");
	   	
	   	 while (rs.next()) {
	   		 int Customer_id = rs.getInt(1);
             String Customer_Name = rs.getString(2);
             String Address = rs.getString(3);
             int age = rs.getInt(4);
             Long salary = rs.getLong(5);
             String Medical_Records = rs.getString(6);
             String BloodGroup = rs.getString(7);
             String Nominee_name = rs.getString(8);
             Long Nominee_no = rs.getLong(9);
             Long Contact_No = rs.getLong(10);
             String premium = rs.getString(11);
             int duration = rs.getInt(12);
            
            
            HealthInsurance in = new HealthInsurance(Customer_id, Customer_Name, Address, age, salary,
    				Medical_Records, BloodGroup, Nominee_name, Nominee_no, Contact_No,
    				duration,premium);
            return in;
	   }
	   	 return null;
	   }
	   
	   public String SetBloodGroupByID(String premium,int id) throws SQLException {
	   	String sql = "update HealthInsurance set premium=? where id=?";
	   	Connection conn = getConnection();
	   	 PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1,premium);
	        pstmt.setInt(2, id);
	        pstmt.executeUpdate();
	        
	        return "✅ Dear Customer, your premium Type has been successfully changed!";
	   }
	   
	   public String DeleteConsumerByName(String name) throws SQLException {
	   	String sql = "Delete from HealthInsurance where name=?";
	   	Connection conn = getConnection();

	   	 PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1,name);
	        pstmt.executeUpdate();
	        
	        return "";
	   }
	   
	  public HealthInsurance getBillOff(int id) throws SQLException {
		   Connection conn = getConnection();
		   Statement stmt = conn.createStatement();
	      
	  	ResultSet rs= stmt.executeQuery("Select * from HealthInsurance where id="+id+"");
	  	
	   while (rs.next()) {
		   int Customer_id = rs.getInt(1);
           String Customer_Name = rs.getString(2);
           String Address = rs.getString(3);
           int age = rs.getInt(4);
           Long salary = rs.getLong(5);
           String Medical_Records = rs.getString(6);
           String BloodGroup = rs.getString(7);
           String Nominee_name = rs.getString(8);
           Long Nominee_no = rs.getLong(9);
           Long Contact_No = rs.getLong(10);
           String premium = rs.getString(11);
           int duration = rs.getInt(12);
           
           HealthInsurance in = new HealthInsurance(Customer_id, Customer_Name, Address, age, salary,
   				Medical_Records, BloodGroup, Nominee_name, Nominee_no, Contact_No,
   				duration,premium);
           return in;
	}
	return null;
	  }
   
   
   
	  
	// TRAVEL INSURANCE
	  
	  
	  public void InsertAllTravelDATA(TravelInsurance in) throws SQLException {
		  	 Connection conn = getConnection();
		  	PreparedStatement pstmt = conn.prepareStatement("Insert Into TravelInsurance(id,name,address,age,salary,contact,profile,BookingNo,StartFrom,EndTo,Nominee_name,Nominee_no,premium,duration) values(?, ?, ?, ?, ?, ?,?, ?, ?, ?,?,?,?,?)");
		  	
		  	pstmt.setInt(1, in.getCustomer_id());
		  	pstmt.setString(2, in.getCustomer_name());
		  	pstmt.setString(3, in.getAddress());
		  	pstmt.setInt(4, in.getCustomer_age());
		  	pstmt.setLong(5, in.getSalary());
		  	pstmt.setLong(6, in.getContact_No());
		  	pstmt.setString(7,in.getProfile());
		  	pstmt.setInt(8, in.getBookingNo());
		  	pstmt.setString(9, in.getStartFrom());
		  	pstmt.setString(10, in.getEndTo());
		  	pstmt.setString(11, in.getNominee_name());
		  	pstmt.setLong(12, in.getNominee_No());
		  	pstmt.setString(13, in.getPremium());
		  	pstmt.setInt(14, in.getDuration());
		  	
		  	pstmt.executeUpdate();
		  	System.out.println("\n🎉 Customer Registered Successfully! 🎉");
		  }
		   
		   
		   public List<TravelInsurance> getAllTravellerData() throws SQLException {
		  	 List<TravelInsurance> insure = new ArrayList<>();
		       String sql = "SELECT * FROM TravelInsurance";
		       
		       Connection conn = getConnection();
		            Statement stmt = conn.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		           
		           while (rs.next()) {
		        	 
		               int Customer_id = rs.getInt(1);
		               String Customer_Name = rs.getString(2);
		               String Address = rs.getString(3);
		               int age = rs.getInt(4);
		               Long salary = rs.getLong(5);
		               Long Contact_No = rs.getLong(6);
		               String profile = rs.getString(7);
		               int bookingNo = rs.getInt(8);
		               String startFrom = rs.getString(9);
		               String endTo = rs.getString(10);
		               String Nominee_name = rs.getString(11);
		               Long Nominee_no = rs.getLong(12);
		               String premium = rs.getString(13);
		               int duration = rs.getInt(14);
		               
		               
		               TravelInsurance in = new TravelInsurance(Customer_id, Customer_Name, Address,profile, age, salary,
								Contact_No, bookingNo, startFrom, endTo, Nominee_name,Nominee_no,
								 premium,duration);
		               insure.add(in);
		           }
		       return insure;

		  }

		   public TravelInsurance getTravellerById(int id) throws SQLException{
		   	Connection conn = getConnection();
		   	Statement stmt = conn.createStatement();
		       
		   	ResultSet rs= stmt.executeQuery("Select * from TravelInsurance where id="+id+"");
		   	
		   	 while (rs.next()) {
		   		int Customer_id = rs.getInt(1);
	               String Customer_Name = rs.getString(2);
	               String Address = rs.getString(3);
	               int age = rs.getInt(4);
	               Long salary = rs.getLong(5);
	               Long Contact_No = rs.getLong(6);
	               String profile = rs.getString(7);
	               int bookingNo = rs.getInt(8);
	               String startFrom = rs.getString(9);
	               String endTo = rs.getString(10);
	               String Nominee_name = rs.getString(11);
	               Long Nominee_no = rs.getLong(12);
	               String premium = rs.getString(13);
	               int duration = rs.getInt(14);
	               
	               
	               TravelInsurance in = new TravelInsurance(Customer_id, Customer_Name, Address,profile, age, salary,
							Contact_No, bookingNo, startFrom, endTo, Nominee_name,Nominee_no,
							 premium,duration);
	               return in;
		   }
		   	 return null;
		   }
		   
		   public String SetPremiumsByID(String premium,int id) throws SQLException {
		   	String sql = "update TravelInsurance set premium=? where id=?";
		   	Connection conn = getConnection();
		   	 PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1,premium);
		        pstmt.setInt(2, id);
		        pstmt.executeUpdate();
		      
		        return "✅ Dear Customer, your premium Type has been successfully changed!";
		   }
		   
		   public String DeleteTravellerByName(String name) throws SQLException {
		   	String sql = "Delete from TravelInsurance where name=?";
		   	Connection conn = getConnection();

		   	 PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1,name);
		        pstmt.executeUpdate();
		        
		        return "";
		   }
		   
		  public TravelInsurance getBilledOf(int id) throws SQLException {
			   Connection conn = getConnection();
			   Statement stmt = conn.createStatement();
		      
		  	ResultSet rs= stmt.executeQuery("Select * from TravelInsurance where id="+id+"");
		  	
		   while (rs.next()) {
			   int Customer_id = rs.getInt(1);
               String Customer_Name = rs.getString(2);
               String Address = rs.getString(3);
               int age = rs.getInt(4);
               Long salary = rs.getLong(5);
               Long Contact_No = rs.getLong(6);
               String profile = rs.getString(7);
               int bookingNo = rs.getInt(8);
               String startFrom = rs.getString(9);
               String endTo = rs.getString(10);
               String Nominee_name = rs.getString(11);
               Long Nominee_no = rs.getLong(12);
               String premium = rs.getString(13);
               int duration = rs.getInt(14);
               
               
               TravelInsurance in = new TravelInsurance(Customer_id, Customer_Name, Address,profile, age, salary,
						Contact_No, bookingNo, startFrom, endTo, Nominee_name,Nominee_no,
						 premium,duration);
               return in;
		}
		return null;
		  }
	   
	   
	  
}
