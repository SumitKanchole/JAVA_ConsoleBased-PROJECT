package policy.insurance.main;

//import layer.st.model.Student11;
import policy.insurance.model.*;
import java.util.*;

import policy.insurance.services.InsService;

import java.sql.*;

public class MyApp {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		InsService running = new InsService();
		int decision = 1;
		do {
			try {
				 System.out.println("============== USER LOGIN ==============");
				    System.out.print("👤 Enter Username: ");
				    String username = sc.nextLine();

				    System.out.print("🔐 Enter Password: ");
				    String password = sc.nextLine();
				    Boolean login = running.AddUser(username,password);
				    
				    if(login==true){
				    
				System.out.println("\n=========================================================");
				System.out.println("      🚀 WELCOME TO - APNA SAPNA INSURANCE PVT. LTD. 🚀     ");
				System.out.println("=========================================================\n");
				boolean cond1 = true;
				while (cond1) {
					System.out.println("📌 Please Select Your Insurance Type:\n");
				    System.out.println("1.  LIFE INSURANCE  \t2.  GENERAL INSURANCE");
				   
				    System.out.print("\n🔹 Enter your choice: ");
					int choice = Integer.parseInt(sc.nextLine());

					switch (choice) {
					case 1:
						System.out.println("\n-----------------------------------------------------------");
						 System.out.println("----✅ Thank You for Choosing **Life Insurance** ✅----");
						 System.out.println("-----------------------------------------------------------\n");
				            System.out.println("\n💼 Please Select the Type of Life Insurance:");
						System.out.println("\n1. Term Life Insurance \t\t2. Whole Life Insurance");
						
						 System.out.print("\n🔹 Enter your choice: ");
						int choice1 = Integer.parseInt(sc.nextLine());
						
						
						
						// Term Life insurance started from here--------------
						
						if (choice1 == 1) {
							boolean cond2=true;
							while (cond2) {
								System.out.println("\n-----------------------------------------------------------");
								System.out.println("\t\t ----Term Life Insurance----");
								System.out.println("-----------------------------------------------------------\n");
								System.out.println(
										"1. ➕ Add New Customer \t\t2. 👀 View All Customers \t3. 🔎 Find Customer Details \n\n4. ✏️ Change Nominee Name \t5. 🚫 Cancel Premium \t\t6. 📄 Viewing Premium Details \n\n 7. 🚪 Exit \t8. Back");
								System.out.println("-----------------------------------------------------------\n");
								 System.out.print("\n🔹 Enter your choice: ");
								int choice3 = Integer.parseInt(sc.nextLine());
								switch (choice3) {
								case 1:
									 System.out.println("\n✅ * Personal Details * ✅\n");

								        System.out.print("📄 Enter Your ID Number: ");
								        int Customer_id = Integer.parseInt(sc.nextLine());

								        System.out.print("📝 Enter Your Name: ");
								        String Customer_Name = sc.nextLine();

								        System.out.print("🎂 Enter Your Age: ");
								        int age = Integer.parseInt(sc.nextLine());

								        System.out.print("📞 Enter Your Contact Number: ");
								        long Contact_No = Long.parseLong(sc.nextLine());

								        System.out.print("💸 Enter Your Salary: ");
								        long salary = Long.parseLong(sc.nextLine());

								        System.out.print("🏡 Enter Your Permanent Address: ");
								        String Address = sc.nextLine();

								        System.out.println("\n🩺 * Medical Details * 🩺\n");
								        System.out.print("💉 Enter Your Medical Status [Normal / Abnormal]: ");
								        String Medical_status = sc.nextLine();

								        System.out.println("\n👨‍👩‍👧 * Nominee Details * 👨‍👩‍👧\n");
								        System.out.print("💬 Enter Nominee Name: ");
								        String Nominee_name = sc.nextLine();

								        System.out.print("🔗 Enter Nominee Relation: ");
								        String nominee_relation = sc.nextLine();

								        System.out.print("📱 Enter Nominee Contact Number: ");
								        long Nominee_no = Long.parseLong(sc.nextLine());

								        System.out.println("\n💼 * Insurance Details * 💼\n");
								        System.out.print("🔐 Enter Your Premium Type [Level, Fixed, Single, Flexible]: ");
								        String premium = sc.nextLine();

								        System.out.print("⏳ Enter Your Insurance Duration (Min. 5 years): ");
								        int duration = Integer.parseInt(sc.nextLine());

									TermLifeInsurance in1 = new TermLifeInsurance(Customer_id, Customer_Name, Address, age, Contact_No,
											salary,Medical_status, Nominee_name, nominee_relation, Nominee_no,
											premium, duration);
									running.AddAllTermLifeRelatedData(in1);
									break;
								case 2:
									List<TermLifeInsurance> ensure = running.fetchAllTLCustomers();
									if (ensure.isEmpty()) {
										System.out.println("No data found");
									} else {
										System.out.println("\nCustomer Data:");
										System.out.println("----------------------------------------------------------------------------------------------------------");
										System.out.println("ID | Name | Contact | Address | Age | Salary | Medical Status | Nominee | Relation | Nominee No | Premium | Duration");
							            System.out.println("----------------------------------------------------------------------------------------------------------");
										for (TermLifeInsurance s : ensure) {
											System.out.println(s.getCustomer_id() + " | " + s.getCustomer_name() + " | "
													+ s.getContact_No() + " | " + s.getAddress() + " | "
													+ s.getCustomer_age() + " | " + s.getSalary() + " | "
													+ s.getMedical_status() + " | " + s.getNominee_name() + " | "
													+ s.getNominee_relation()+ " | "+ s.getNominee_No()+ " | "+ s.getPremium()
													+ " | "+ s.getDuration());
										}
									}
									break;

								case 3:
									System.out.print("Enter the ID : ");
									int id = Integer.parseInt(sc.nextLine());
									TermLifeInsurance s1 = running.findTLConsumerByID(id);

									System.out.println("\nCustomer Data:");
									System.out.println("----------------------------------------------------------------------------------------------------------");
									System.out.println("ID | Name | Contact | Address | Age | Salary | Medical Status | Nominee | Relation | Nominee No | Premium | Duration");
						            System.out.println("----------------------------------------------------------------------------------------------------------");
									System.out.println(s1.getCustomer_id() + " | " + s1.getCustomer_name() + " | "
											+ s1.getContact_No() + " | " + s1.getAddress() + " | "
											+ s1.getCustomer_age() + " | " + s1.getSalary() + " | "
											+ s1.getMedical_status() + " | " + s1.getNominee_name() + " | "
											+ s1.getNominee_relation()+ " | "+ s1.getNominee_No()+ " | "+ s1.getPremium()+ " | "+ s1.getDuration());
									break;

								case 4:
									System.out.print("Enter an ID Number : ");
									int id2 = Integer.parseInt(sc.nextLine());
									System.out.print("Enter New Nominee Name : ");
									String nomineeName = sc.nextLine();
									String s2 = running.updateNomineeNameByID(nomineeName, id2);
									System.out.println(s2);
									break;

								case 5:
									System.out.print("Enter Name : ");
									String name1 = sc.nextLine();
									String s3 = running.deleteTLConsumerDataByName(name1);
									System.out.println(s3);
									 System.out.println("✅ Dear " + name1 + ", your premium has been successfully cancelled!");
									break;

								case 6:
									
									System.out.println("Enter ID No. : ");
									int cust_id = Integer.parseInt(sc.nextLine());
									running.calculateTLPremium1(cust_id);
									break;
									

								case 7:
									 System.out.println("\n👋 Thank You for Using APNA SAPNA INSURANCE! Exiting...");
									sc.close();
									System.exit(0);
									break;
									
								case 8:
									cond2=false;
									break;
								
									
								}

							}
						}
							
						//Term Life Insurance ended here--------------
							
						//WHole life Insurance Started here-----------
							else if (choice1 == 2) {
								boolean status1 =true;
								while (status1) {
									System.out.println("\n-----------------------------------------------------------");
									System.out.println("\t\t ----Whole Life Insurance---- ");
									System.out.println("-----------------------------------------------------------\n");
									System.out.println(
											"1. ➕ Add New Customer \t\t2. 👀 View All Customers \t3. 🔎 Find Customer Details \n4. ✏️ Change Nominee Name \t5. 🚫 Cancel Premium \t\t6. 📄 Viewing Premium Details \n7. 🚪 Exit \t8. Back to Home");
									System.out.println("-----------------------------------------------------------\n"); 
									System.out.print("\n🔹 Enter your choice: ");
									int choice3 = Integer.parseInt(sc.nextLine());
									switch (choice3) {
									case 1:
										System.out.println("\n✅ * Personal Details * ✅\n");
										System.out.print("📄 Enter Your ID Number: ");
										int Customer_id = Integer.parseInt(sc.nextLine());

										System.out.print("📝 Enter Your Name: ");
										String Customer_Name = sc.nextLine();

										System.out.print("🎂 Enter Your Age: ");
										int age = Integer.parseInt(sc.nextLine());

										System.out.print("📞 Enter Your Contact Number: ");
										long Contact_No = Long.parseLong(sc.nextLine());

										System.out.print("💸 Enter Your Salary: ");
										long salary = Long.parseLong(sc.nextLine());

										System.out.print("🏡 Enter Your Permanent Address: ");
										String Address = sc.nextLine();

										System.out.println("\n🩺 * Medical Details * 🩺\n");
										System.out.print("💉 Enter Your Medical Status [Normal / Abnormal]: ");
										String Medical_status = sc.nextLine();

										System.out.println("\n👨‍👩‍👧 * Nominee Details * 👨‍👩‍👧\n");
										System.out.print("💬 Enter Nominee Name: ");
										String Nominee_name = sc.nextLine();

										System.out.print("🔗 Enter Nominee Relation: ");
										String nominee_relation = sc.nextLine();

										System.out.print("📱 Enter Nominee Contact Number: ");
										long Nominee_no = Long.parseLong(sc.nextLine());

										System.out.println("\n💼 * Insurance Details * 💼\n");
										System.out.print("🔐 Enter Your Premium Type [Level, Fixed or Flexible]: ");
										String premium = sc.nextLine();
										

										WholeLifeInsurance in1 = new WholeLifeInsurance(Customer_id,Customer_Name,Address,age,Contact_No,
												salary, Medical_status, Nominee_name, nominee_relation, Nominee_no,
												premium);
										running.AddAllWholeLifeRelatedData(in1);
										break;
									case 2:
										List<WholeLifeInsurance> ensure = running.fetchAllWLCustomers();
										if (ensure.isEmpty()) {
											System.out.println("No data found");
										} else {
											System.out.println("\nCustomer Data:");
											System.out.println("--------------------------------------------------------------------------------------------");
											System.out.println("ID | Name | Contact | Address | Age | Salary | Medical Status | Nominee | Nominee No | Relation | Premium");
								            System.out.println("--------------------------------------------------------------------------------------------");
											for (WholeLifeInsurance s : ensure) {
												System.out.println(s.getCustomer_id() + " | " + s.getCustomer_name() + " | "
														+ s.getContact_No() + " | " + s.getAddress() + " | "
														+ s.getCustomer_age() + " | " + s.getSalary() + " | "
														+ s.getMedical_status() + " | " + s.getNominee_name() + " | "
														+ s.getNominee_No()+ " | " + s.getNominee_relation()+ " | " + s.getPremium());
											}
										}
										break;

									case 3:
										System.out.print("Enter the ID : ");
										int id = Integer.parseInt(sc.nextLine());
										WholeLifeInsurance s = running.findWLConsumerByID(id);
										
										

										System.out.println("\nCustomer Data:");
										System.out.println("--------------------------------------------------------------------------------------------");
										System.out.println("ID | Name | Contact | Address | Age | Salary | Medical Status | Nominee | Nominee No | Relation | Premium");
							            System.out.println("--------------------------------------------------------------------------------------------");
										System.out.println(s.getCustomer_id() + " | " + s.getCustomer_name() + " | "
												+ s.getContact_No() + " | " + s.getAddress() + " | "
												+ s.getCustomer_age() + " | " + s.getSalary() + " | "
												+ s.getMedical_status() + " | " + s.getNominee_name() + " | "
												+ s.getNominee_No()+ " | " + s.getNominee_relation()+ " | " + s.getPremium());
										break;

									case 4:
										System.out.print("Enter Your ID : ");
										int id2 = Integer.parseInt(sc.nextLine());
										System.out.print("Enter New Nominee Name : ");
										String nomineeName = sc.nextLine();
										String s2 = running.updateNomineesNameByID(nomineeName, id2);
										System.out.println(s2);
										break;

									case 5:
										System.out.print("Enter Your Name : ");
										String name1 = sc.nextLine();
										String s3 = running.deleteWLConsumerDataByName(name1);
										System.out.println(s3);
										System.out.println("✅ Dear " + name1 + ", your premium has been successfully cancelled!");
										break;

									case 6:
										System.out.println("Enter Your ID : ");
										int cust_id = Integer.parseInt(sc.nextLine());
										running.calculateWLPremium1(cust_id);
										break;
										

									case 7:
										
										System.out.println("\n👋 Thank You for Using APNA SAPNA INSURANCE! Exiting...");
										sc.close();
										System.exit(0);
									
									case 8:
										status1=false;
										break;
										
									}

							
								}
							
						}
							
						//WHOLE Life Insurance Ended here----------------------
							else {
								System.out.println("\nWrong Choice here \n");
								
							}
						
						break;
					
						
						
						
				// Second Phase is starting from here :::
						
			   //  Here General Insurances are invites you!
						

					case 2:
						 System.out.println("\n✅ Thank You for Choosing **General Insurance** ✅\n\n");
						System.out.println(
								"💼 Select Your Insurance Type :\n  \n1. 🏠 Home Insurance \t\t2. 🚗 Vehicle/Motors Insurance \n\n3. 🏥 Health Insurance \t\t4. ✈️ Travel Insurance");
						 System.out.print("\n🔹 Enter your choice: ");
						int choice2 = Integer.parseInt(sc.nextLine());

						// home insurance started------------
						if (choice2 == 1) {
							boolean status1=true;
							while (status1) {
								System.out.println("\n-----------------------------------------------------------");
								System.out.println("\t\t ----Home Insurance---- ");
								System.out.println("-----------------------------------------------------------\n");
								System.out.println(
										"1. ➕ Add New Customer \t\t2. 👀 View All Customers \t3. 🔎 Find Customer Details \n4. ✏️ Change Premium Type \t5. 🚫 Cancel Premium \t\t6. 📄 Viewing Premium Details \n7. 🚪 Exit \t8. Back to Home");
								System.out.println("-----------------------------------------------------------\n");
								int choice3 = Integer.parseInt(sc.nextLine());
								switch (choice3) {
								case 1:
									
							        System.out.println("\n          🧑‍💼 * Personal Details * 🧑\n ‍💼");
							        
							        System.out.print("📄 Enter Your ID Number: ");
							        long Customer_id = Long.parseLong(sc.nextLine());

							        System.out.print("📝 Enter Your Name: ");
							        String Customer_Name = sc.nextLine();

							        System.out.print("🎂 Enter Your Age: ");
							        int age = Integer.parseInt(sc.nextLine());

							        System.out.print("📞 Enter Your Contact Number: ");
							        long Contact_No = Long.parseLong(sc.nextLine());

							        System.out.print("💸 Enter Your Salary: ");
							        long salary = Long.parseLong(sc.nextLine());

							        System.out.print("🏡 Enter Your Permanent Address: ");
							        String Address = sc.nextLine();

							        
							        System.out.println("\n          🏠 * Property Details * 🏠\n");

							        System.out.print("🧑‍💼 Enter the Property Owner Name: ");
							        String OwnerName = sc.nextLine();

							        System.out.print("🏘️ Enter the Property Type: ");
							        String PropertyType = sc.nextLine();

							        System.out.print("🗓️ Enter the Year Built: ");
							        int yearBuilt = Integer.parseInt(sc.nextLine());

							        System.out.println("\n          💳 * Bank Details * 💳\n");							   
							        System.out.print("🏦 Enter Account Holder Name: ");
							        String bank_AccountHolder = sc.nextLine();

							        System.out.print("💳 Enter Your Account Number: ");
							        long bank_AccountNumber = Long.parseLong(sc.nextLine());

							        System.out.println("\n        👨‍👩‍👧 * Nominee Details * 👨‍👩‍👧\n");
							        System.out.print("💬 Enter Nominee Name: ");
							        String Nominee_name = sc.nextLine();

							        System.out.print("📱 Enter Nominee Contact Number: ");
							        long Nominee_no = Long.parseLong(sc.nextLine());

							       
							        System.out.println("\n          💼 * Insurance Details * 💼\n");

							        System.out.print("⏳ Enter Your Insurance Duration [Choose 1, 5, or 10 years]: ");
							        int duration = Integer.parseInt(sc.nextLine());

							        System.out.print("🔐 Enter Your Premium Type [Level, Fixed, Single, Flexible]: ");
							        String premium = sc.nextLine();

									Insurance in = new Insurance(Customer_id, Customer_Name, Address, OwnerName,
											PropertyType, yearBuilt, bank_AccountHolder, bank_AccountNumber, premium,
											age, Contact_No, salary, Nominee_name, Nominee_no, duration);
									running.AddAll(in);
									break;
								case 2:
									List<Insurance> insure = running.fetchAllCustomer();
									if (insure.isEmpty()) {
										System.out.println("No data found");
									} else {
										System.out.println("\nCustomer Data:");
										System.out.println("-----------------------------------------------------------------------------------------------------------------------------"); 
										System.out.println("ID | Name | Contact | Address | Age | Salary | Owner | Property Type | Year Built | Bank Holder | Bank Acc No | Nominee | Nominee No | Duration");
								         System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
										for (Insurance s : insure) {
											System.out.println(s.getCustomer_id() + " | " + s.getCustomer_name() + " | "
													+ s.getContact_No() + " | " + s.getAddress() + " | "
													+ s.getCustomer_age()+ " | " + s.getSalary()  + " | " + s.getOwnerName() + " | "
													+ s.getPropertyType() + " | " + s.getYearBuilt() + " | "
													+ s.getBank_AccountHolder()+ " | " + s.getBank_AccountNumber()+ " | " 
													+ s.getNominee_name() + " | " + s.getNominee_No() + " | " + s.getDuration()  );
										}
									}
									break;

								case 3:
									System.out.print("Enter the ID : ");
									int id = Integer.parseInt(sc.nextLine());
									Insurance s = running.findCustomerByID(id);

									System.out.println("\nCustomer Data:");
									System.out.println("-----------------------------------------------------------------------------------------------------------------------------"); 
									System.out.println("ID | Name | Contact | Address | Age | Salary | Owner | Property Type | Year Built | Bank Holder | Bank Acc No | Nominee | Nominee No | Duration");
							         System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
									System.out.println(s.getCustomer_id() + " | " + s.getCustomer_name() + " | "
											+ s.getContact_No() + " | " + s.getAddress() + " | "
											+ s.getCustomer_age()+ " | " + s.getSalary()  + " | " + s.getOwnerName() + " | "
											+ s.getPropertyType() + " | " + s.getYearBuilt() + " | "
											+ s.getBank_AccountHolder()+ " | " + s.getBank_AccountNumber()+ " | " 
											+ s.getNominee_name() + " | " + s.getNominee_No() + " | " + s.getDuration()  );
									break;

								case 4:
									System.out.print("Enter (by) ID : ");
									int id2 = Integer.parseInt(sc.nextLine());
									System.out.print("Enter New Premium Type(level,fixed,single,flexible)* : ");
									String premium1 = sc.nextLine();
									String s2 = running.updateNameByID(premium1, id2);
									System.out.println(s2);
									break;

								case 5:
									System.out.print("Enter Name : ");
									String name1 = sc.nextLine();
									String s3 = running.deleteDataByName(name1);
									System.out.println(s3);
									System.out.println("✅ Dear " + name1 + ", your premium has been successfully cancelled!");
									break;

								case 6:
									System.out.println("Enter Your ID to calculate premium : ");
									int cust_id = Integer.parseInt(sc.nextLine());
									running.calculateEMI(cust_id);
									break;
									

								case 7:
									System.out.println("\n👋 Thank You for Using APNA SAPNA INSURANCE! Exiting...");
									sc.close();
									System.exit(0);
								
								case 8:
									status1=false;
									break;
									
								}
								

							}
						}
						// home insurance ended------------

						// vehicles insurance started----------
						else if (choice2 == 2) {
							boolean status1 =true;
							while (status1) {
								System.out.println("\n-----------------------------------------------------------");
								System.out.println("\t\t ----Vehicle Insurance----");
								System.out.println("-----------------------------------------------------------\n");
								System.out.println(
										"1. ➕ Add New Customer \t\t2. 👀 View All Customers \t3. 🔎 Find Customer Details \n4. ✏️ Change Premium Type \t5. 🚫 Cancel Premium \t\t6. 📄 View Premium Details \n7. 🚪 Exit \t8. Back to Home");
								System.out.println("-----------------------------------------------------------\n"); 
								System.out.print("\n🔹 Enter your choice: ");
								int choice3 = Integer.parseInt(sc.nextLine());
								switch (choice3) {
								case 1:
									System.out.println("\t🔹 * Personal Details * 🔹\n");
									System.out.print("🆔 Enter your ID Number >>> ");
									int Customer_id = Integer.parseInt(sc.nextLine());

									System.out.print("👤 Enter Your Name >>> ");
									String Customer_Name = sc.nextLine();

									System.out.print("🎂 Enter your AGE >>> ");
									int age = Integer.parseInt(sc.nextLine());

									System.out.print("📞 Enter Your Contact Number >>> ");
									long Contact_No = Long.parseLong(sc.nextLine());

									System.out.print("💰 Enter Your Salary >>> ");
									long salary = Long.parseLong(sc.nextLine());

									System.out.print("🏠 Enter Your Permanent Address >>> ");
									String Address = sc.nextLine();

									
									System.out.println("\n\t🚘 * Vehicle Details * 🚘\n");
									System.out.print("🚗 Enter the Vehicle Type >>> ");
									String VehicleType = sc.nextLine();

									System.out.print("👤 Enter the Vehicle Owner Name >>> ");
									String OwnerName = sc.nextLine();

									System.out.print("🪪 Enter Driving License Number >>> ");
									String DV_lincenseNum = sc.nextLine();

									System.out.print("📄 Enter RC Number >>> ");
									String RC_num = sc.nextLine();

									System.out.print("✅ Enter PUC Number >>> ");
									String PUC_num = sc.nextLine();

									
									System.out.println("\n\t🏦 * Bank Details * 🏦\n");
									System.out.print("👤 Enter Account Holder Name >>> ");
									String bank_AccountHolder = sc.nextLine();

									System.out.print("🏧 Enter Your Account Number >>> ");
									long bank_AccountNumber = Long.parseLong(sc.nextLine());

									
									System.out.println("\n\t👥 * Nominee Details * 👥\n");
									System.out.print("👤 Enter Nominee Name >>> ");
									String Nominee_name = sc.nextLine();

									System.out.print("📞 Enter Nominee Contact Number >>> ");
									long Nominee_no = Long.parseLong(sc.nextLine());

									
									System.out.println("\n\t🛡 * Insurance Details * 🛡\n");
									System.out.print("⏳ Enter your Insurance Duration (choose: 1, 3, or 5 years) >>> ");
									int duration = Integer.parseInt(sc.nextLine());

									System.out.print("💵 Enter Your Premium Type (level, fixed, single, flexible) >>> ");
									String premium = sc.nextLine();

									VehicleInsurance in1 = new VehicleInsurance(Customer_id, Customer_Name, Address,
											Contact_No, age, DV_lincenseNum, RC_num, PUC_num, OwnerName,
											bank_AccountHolder, bank_AccountNumber, Nominee_name, Nominee_no, premium,
											duration, salary, VehicleType);
									running.AddAllVehicleData(in1);
									break;
								case 2:
									List<VehicleInsurance> insure = running.fetchingAllCustomer();
									if (insure.isEmpty()) {
										System.out.println("No data found");
									} else {
										System.out.println("\nCustomer Data:");
										System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
										System.out.println("ID | Name | Contact | Address | Age | Salary | Owner | License No | Vehicle Type | RC No | PUC No | Bank Holder | Bank Acc No | Nominee | Nominee No | Premium | Duration");
							            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
										for (VehicleInsurance s : insure) {
											System.out.println(s.getCustomer_id() + " | " + s.getCustomer_name() + " | "
													+ s.getContact_No() + " | " + s.getAddress() + " | "
													+ s.getCustomer_age() + " | " + s.getSalary()+ " | " + s.getOwnerName() + " | "
													+ s.getDV_lincenseNum() + " | " + s.getVehicleType() + " | "
													+ s.getRC_num()+ " | " + s.getPUC_num()+ " | " + s.getBank_AccountHolder()
													+ " | " + s.getBank_AccountNumber()+ " | " + s.getNominee_name()+ " | "
													+ s.getNominee_No()+ " | " + s.getPremium()+ " | " + s.getDuration());
										}
									}
									break;

								case 3:
									System.out.print("Enter the ID : ");
									int id = Integer.parseInt(sc.nextLine());
									VehicleInsurance s = running.findCustomersByID(id);

									System.out.println("\nCustomer Data:");
									System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
									System.out.println("ID | Name | Contact | Address | Age | Salary | Owner | License No | Vehicle Type | RC No | PUC No | Bank Holder | Bank Acc No | Nominee | Nominee No | Premium | Duration");
						            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
									System.out.println(s.getCustomer_id() + " | " + s.getCustomer_name() + " | "
											+ s.getContact_No() + " | " + s.getAddress() + " | "
											+ s.getCustomer_age() + " | " + s.getSalary()+ " | " + s.getOwnerName() + " | "
											+ s.getDV_lincenseNum() + " | " + s.getVehicleType() + " | "
											+ s.getRC_num()+ " | " + s.getPUC_num()+ " | " + s.getBank_AccountHolder()
											+ " | " + s.getBank_AccountNumber()+ " | " + s.getNominee_name()+ " | "
											+ s.getNominee_No()+ " | " + s.getPremium()+ " | " + s.getDuration());
									break;

								case 4:
									System.out.print("Enter (by) ID : ");
									int id2 = Integer.parseInt(sc.nextLine());
									System.out.print("Set premium type (level,fixed,single, flexible) : ");
									String premium1 = sc.nextLine();
									String s2 = running.updateNamesByID(premium1, id2);
									System.out.println(s2);
									break;

								case 5:
									System.out.print("Enter Name : ");
									String name1 = sc.nextLine();
									String s3 = running.deleteByName(name1);
									System.out.println(s3);
									System.out.println("✅ Dear " + name1 + ", your premium has been successfully cancelled!");
									break;

								case 6:
									System.out.println("Enter Your ID : ");
									int cust_id = Integer.parseInt(sc.nextLine());
									running.calculatePremium(cust_id);
									break;

								case 7:
									System.out.println("\n👋 Thank You for Using APNA SAPNA INSURANCE! Exiting...");
									sc.close();
									System.exit(0);
									
								case 8:
									status1=false;
									break;
								}

							}
						}
						
						// vehicles insurance ended------------
						
					// Health insurance started from here--------------
						else if (choice2 == 3) {
							boolean status1= true;
							while (status1) {
								System.out.println("\n-----------------------------------------------------------");
								System.out.println(" \t\t----Health Insurance----");
								System.out.println("-----------------------------------------------------------\n");
								System.out.println(
										"1. ➕ Add New Customer \t\t2. 👀 View All Customers \t3. 🔎 Find Customer Details \n4. ✏️ Change Premium Type \t5. 🚫 Cancel Premium \t\t6. 📄 View Premium Details \n7. 🚪 Exit  \t8. Back to Home");
								System.out.println("-----------------------------------------------------------\n");
								System.out.print("\n🔹 Enter your choice: ");
								int choice3 = Integer.parseInt(sc.nextLine());
								switch (choice3) {
								case 1:
									System.out.println("\t🔹 * Personal Details * 🔹\n");
									System.out.print("🆔 Enter your ID Number >>> ");
									int Customer_id = Integer.parseInt(sc.nextLine());

									System.out.print("👤 Enter Your Name >>> ");
									String Customer_Name = sc.nextLine();

									System.out.print("🎂 Enter your AGE >>> ");
									int age = Integer.parseInt(sc.nextLine());

									System.out.print("📞 Enter Your Contact Number >>> ");
									long Contact_No = Long.parseLong(sc.nextLine());

									System.out.print("💰 Enter Your Salary >>> ");
									long salary = Long.parseLong(sc.nextLine());

									System.out.print("🏠 Enter Your Permanent Address >>> ");
									String Address = sc.nextLine();

									// 📌 Medical Details
									System.out.println("\n\t🏥 * Medical Details * 🏥\n");
									System.out.print("🩺 Enter Your Medical Status [Normal or Abnormal] >>> ");
									String Medical_Records = sc.nextLine();

									System.out.print("🩸 Enter Your Blood Group (A+, B+, O+, etc.) >>> ");
									String BloodGroup = sc.nextLine();

									// 📌 Nominee Details
									System.out.println("\n\t👥 * Nominee Details * 👥\n");
									System.out.print("👤 Enter Nominee Name >>> ");
									String Nominee_name = sc.nextLine();

									System.out.print("📞 Enter Nominee Contact Number >>> ");
									long Nominee_no = Long.parseLong(sc.nextLine());

									// 📌 Insurance Details
									System.out.println("\n\t🛡 * Insurance Details * 🛡\n");
									System.out.print("💵 Enter Your Premium Type (level, fixed, single, flexible) >>> ");
									String premium = sc.nextLine();

									System.out.print("⏳ Enter Your Insurance Duration (Choose: 1, 3, or 5 years) >>> ");
									int duration = Integer.parseInt(sc.nextLine());

									HealthInsurance in1 = new HealthInsurance(Customer_id, Customer_Name, Address, age, salary,
											Medical_Records, BloodGroup, Nominee_name, Nominee_no, Contact_No,
											duration,premium);
									running.AddAllHealthRelatedData(in1);
									break;
								case 2:
									List<HealthInsurance> ensure = running.fetchAllCustomers();
									if (ensure.isEmpty()) {
										System.out.println("No data found");
									} else {
										System.out.println("\nCustomer Data:");
										System.out.println("------------------------------------------------------------------------------------------------------------------------"); 
										System.out.println("ID | Name | Contact | Address | Age | Salary | Medical Records | Blood Group | Nominee | Nominee No | Duration | Premium");
								        System.out.println("------------------------------------------------------------------------------------------------------------------------");
										for (HealthInsurance s : ensure) {
											System.out.println(s.getCustomer_id() + " | " + s.getCustomer_name() + " | "
													+ s.getContact_No() + " | " + s.getAddress() + " | "
													+ s.getCustomer_age() + " | " + s.getSalary() + " | "
													+ s.getMedical_Records() + " | " + s.getBloodGroup() + " | "
													+ s.getNominee_name()+ " | " + s.getNominee_No()+ " | " + s.getDuration()+ " | " 
													+ s.getPremium());
										}
									}
									break;

								case 3:
									System.out.print("Enter the ID : ");
									int id = Integer.parseInt(sc.nextLine());
									HealthInsurance s = running.findConsumerByID(id);

									System.out.println("\nCustomer Data:");
									System.out.println("------------------------------------------------------------------------------------------------------------------------"); 
									System.out.println("ID | Name | Contact | Address | Age | Salary | Medical Records | Blood Group | Nominee | Nominee No | Duration | Premium");
							        System.out.println("------------------------------------------------------------------------------------------------------------------------");
									System.out.println(s.getCustomer_id() + " | " + s.getCustomer_name() + " | "
											+ s.getContact_No() + " | " + s.getAddress() + " | "
											+ s.getCustomer_age() + " | " + s.getSalary() + " | "
											+ s.getMedical_Records() + " | " + s.getBloodGroup() + " | "
											+ s.getNominee_name()+ " | " + s.getNominee_No()+ " | " + s.getDuration()+ " | " 
											+ s.getPremium());
									break;

								case 4:
									System.out.print("Enter Your ID : ");
									int id2 = Integer.parseInt(sc.nextLine());
									System.out.print("Set Premium TYPE : ");
									String premium1 = sc.nextLine();
									String s2 = running.updateBloodGroupByID(premium1, id2);
									System.out.println(s2);
									
									break;

								case 5:
									System.out.print("Enter Your Name : ");
									String name1 = sc.nextLine();
									String s3 = running.deleteConsumerDataByName(name1);
									System.out.println(s3);
									System.out.println("✅ Dear " + name1 + ", your premium has been successfully cancelled!");
									break;

								case 6:
									System.out.println("Enter Your ID : ");
									int cust_id = Integer.parseInt(sc.nextLine());
									running.calculatePremium1(cust_id);
									break;

								case 7:
									System.out.println("\n👋 Thank You for Using APNA SAPNA INSURANCE! Exiting...");
									sc.close();
									System.exit(0);
									
								case 8:
									status1=false;
									break;
								}

							}
						}
						
					
			//Health Insurance ended here--------------
						
						
			//Travel Insurance Started here--------------
						
						else if (choice2 == 4) {
							boolean status1=true;
							while (status1) {
								System.out.println("\n-----------------------------------------------------------");
								System.out.println(" \t\t----Travel Insurance---- ");
								System.out.println("\n-----------------------------------------------------------");
								System.out.println(
										"1. ➕ Add New Customer \t\t2. 👀 View All Customers \t3. 🔎 Find Customer Details \n4. ✏️ Change Premium Type \t5. 🚫 Cancel Premium \t\t6. 📄 View Premium Details \n7. 🚪 Exit  \t8. Back to Home");
								System.out.println("-----------------------------------------------------------\n"); 
								System.out.print("\n🔹 Enter your choice: ");
								int choice3 = Integer.parseInt(sc.nextLine());
								switch (choice3) {
								case 1:
									System.out.println("\t🔹 * Personal Details * 🔹\n");
									System.out.print("🆔 Enter your ID Number >>> ");
									int Customer_id = Integer.parseInt(sc.nextLine());

									System.out.print("👤 Enter Your Name >>> ");
									String Customer_Name = sc.nextLine();

									System.out.print("🎂 Enter your AGE >>> ");
									int age = Integer.parseInt(sc.nextLine());

									System.out.print("📞 Enter Your Contact Number >>> ");
									long Contact_No = Long.parseLong(sc.nextLine());

									System.out.print("💰 Enter Your Salary >>> ");
									long salary = Long.parseLong(sc.nextLine());

									System.out.print("🏠 Enter Your Permanent Address >>> ");
									String Address = sc.nextLine();

									System.out.print("🎓 Enter Your Profile (e.g., Student, Employee, etc.) >>> ");
									String profile = sc.nextLine();

									// 📌 Traveling Details
									System.out.println("\n\t✈️ * Traveling Details * ✈️\n");
									System.out.print("📄 Enter Your Booking Number >>> ");
									int bookingNo = Integer.parseInt(sc.nextLine());

									System.out.print("📍 Enter Your Source Location >>> ");
									String startFrom = sc.nextLine();

									System.out.print("🎯 Enter Your Destination >>> ");
									String endTo = sc.nextLine();

									// 📌 Nominee Details
									System.out.println("\n\t👥 * Nominee Details * 👥\n");
									System.out.print("👤 Enter Nominee Name >>> ");
									String Nominee_name = sc.nextLine();

									System.out.print("📞 Enter Nominee Contact Number >>> ");
									long Nominee_no = Long.parseLong(sc.nextLine());

									// 📌 Insurance Details
									System.out.println("\n\t🛡 * Insurance Details * 🛡\n");
									System.out.print("💵 Enter Your Premium Type (Single Trip, Multi Trip, Annual) >>> ");
									String premium = sc.nextLine();

									System.out.print("⏳ Enter Your Insurance Duration (Choose: 1, 3, or 5 years) >>> ");
									int duration = Integer.parseInt(sc.nextLine());

									TravelInsurance in1= new TravelInsurance(Customer_id, Customer_Name, Address,profile, age, salary,
											Contact_No, bookingNo, startFrom, endTo, Nominee_name,Nominee_no,
											 premium,duration);
									running.AddAllTravelRelatedData(in1);
									break;
								case 2:
									List<TravelInsurance> insure = running.fetchAllTravellerDetail();
									if (insure.isEmpty()) {
										System.out.println("No data found");
									} else {
										System.out.println("\nCustomer Data:");
										System.out.println("-------------------------------------------------------------------------------------------------------------------------------------"); 
										System.out.println("ID | Name | Contact | Address | Age | Profile | Salary | Booking No | Start From | End To | Nominee | Nominee No | Premium | Duration");
										System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
										for (TravelInsurance s : insure) {
											System.out.println(s.getCustomer_id() + " | " + s.getCustomer_name() + " | "
													+ s.getContact_No() + " | " + s.getAddress() + " | "
													+ s.getCustomer_age() + " | " + s.getProfile() + " | "
													+ s.getSalary() + " | " + s.getBookingNo() + " | "
													+ s.getStartFrom() + " | " + s.getEndTo() + " | " + s.getNominee_name() + " | " + s.getNominee_No() + " | " + s.getPremium() + " | " + s.getDuration());
										}
									}
									break;

								case 3:
									System.out.print("Enter the ID : ");
									int id = Integer.parseInt(sc.nextLine());
									TravelInsurance s = running.findTravellerByID(id);

									System.out.println("\nCustomer Data:");
									System.out.println("-------------------------------------------------------------------------------------------------------------------------------------"); 
									System.out.println("ID | Name | Contact | Address | Age | Profile | Salary | Booking No | Start From | End To | Nominee | Nominee No | Premium | Duration");
									System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
									System.out.println(s.getCustomer_id() + " | " + s.getCustomer_name() + " | "
											+ s.getContact_No() + " | " + s.getAddress() + " | "
											+ s.getCustomer_age() + " | " + s.getProfile() + " | "
											+ s.getSalary() + " | " + s.getBookingNo() + " | "
											+ s.getStartFrom() + " | " + s.getEndTo() + " | " + s.getNominee_name()
											+ " | " + s.getNominee_No() + " | " + s.getPremium() + " | " + s.getDuration());
									break;

								case 4:
									System.out.print("Enter Your ID : ");
									int id2 = Integer.parseInt(sc.nextLine());
									System.out.print("Set premium type (Single trip,Multi trip,annual) : ");
									String premium1 = sc.nextLine();
									String s2 = running.updatePremiumsByID(premium1, id2);
									System.out.println(s2);
									break;

								case 5:
									System.out.print("Enter Your Name for Cancel Premium : ");
									String name1 = sc.nextLine();
									String s3 = running.deleteTravellerByName(name1);
									System.out.println(s3);
									 System.out.println("✅ Dear " + name1 + ", your premium has been successfully cancelled!");
									break;

								case 6:
									System.out.println("Enter Your ID to calculate premium : ");
									int cust_id = Integer.parseInt(sc.nextLine());
									running.calculatePremium2(cust_id);
									break;

								case 7:
									System.out.println("\n👋 Thank You for Using APNA SAPNA INSURANCE! Exiting...");
									sc.close();
									System.exit(0);
									
								case 8:
									status1=false;
									break;
									
								}

							}
						}	
					
				//Travel Insurance Ended Here----------------
						
				//if type wrong input------------------
						
					default:
						 System.out.println("\n❌ Invalid Choice! Please enter a valid option (1 or 2).\n");
						break;
					}
				}

				}

				    
		
			} catch (Exception ss) {
				System.out.println("Incorrect Type! Please try again.");
//				ss.printStackTrace();
				System.out.println("Are you want restart : 1. Yes \t2. No");
				decision = Integer.parseInt(sc.nextLine());
			}
		} while (decision == 1);

	}

}
