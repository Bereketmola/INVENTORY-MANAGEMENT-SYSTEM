import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Admin implements Administrator{
	private String firstLine;
	private String User_Name;
    private String Password;

   
    Scanner sc = new Scanner(System.in); 
    BufferedWriter br = null; 
    BufferedReader BR = null;
    FileWriter fw = null;
    FileReader fr = null;
   
    PrintWriter pw = null;
    

   
    
   //////////////////////////////////// Line break /////////////////////////////////////////////
    
	public Admin() {
		super();
		User_Name = "Empty";
		Password = "Empty";
	
		
	 
		
	}
/////////////////////////////////////////   Username and password fields   ////////////////////////////////////////////////////

public void Fields() {

System.out.println("Username :  ");

User_Name = sc.next().trim();
System.out.println("Password :  ");
Password = sc.next().trim();

Verification();
}
	
	//////////////////////////////////// Verification for username and password ///////////////////////
	
	public void Verification() {
	

		
				if ((User_Name.equals("Admin") && Password.equals("*****"))) {
				 System.out.print("You have Successfully Logged In....");

				 System.out.print("***************************************************\n\n ");
				 System.out.print("( 1 ) Add New Stock or Item.\n");
				 System.out.print("( 2 ) Delete an existing Item.\n");
				 System.out.print("( 3 ) Search a Stock / if available.\n");
				 System.out.print("( 4 ) All the stock in the store.\n");
				 System.out.print("( 5 ) See all rented Stocks.\n");

				 System.out.print("***************************************************\n\n ");
				 System.out.print("Choose The Operation Number You Want To Do...\n ");
					// getting the user input operation

					int choice = sc.nextInt();

					switch (choice) {

					case 1:
						AddStock();
						break;
					case 2:
					 System.out.print("Enter the Name of the Item to delete..");
						String d = (sc.next()).trim();

						DeleteItem(d);
						break;
					case 3:
					 System.out.print("Enter the Name of the Item to search..");
						String e = (sc.next()).trim();
						Search(e);
						break;
					case 4:
						Items();
						break;
					case 5:
						RentedItems();
						break;
					default:
						System.out.print("INCORRECT ATTEMPT...TRY AGAIN");

					}
				} else {
					System.out.print("Wrong UserName or Password....");
				} 
				
		
			
		}




	
	/////////////////////////////////// see all available ITEMSs with their discription //////////////////////
	
	public void Items() {
		try {
		 System.out.print("|ITEM NAME |\t\t| BRAND |\t\t| P.Date |\t\t| QUANTITY |\t\t| CATAGORY |\t\t| Disctioption on return |\n"+ "");
			fr =  new FileReader("Stack.txt");
			BR = new BufferedReader(fr);
			
			firstLine = BR.readLine();
			if (firstLine == null)
				System.out.print("Sorry... no available item..");
			while(firstLine != null) {
				
			 System.out.print(" | "+firstLine+" | ");
				firstLine = BR.readLine();
				
			}
		} catch (IOException e) {
		 System.out.print("Error..Can't read the file....");
			e.printStackTrace();
		}
		
			
	}
	
	//////////////////////////////// see all rented ITEMSs in the library with the renter's ID /////////////
	
	public void RentedItems() {
		
		try {
		 System.out.print("|ITEM NAME |\t| BORROWER\n\n");
			fr =  new FileReader("Item_borrowed.txt");
			BR = new BufferedReader(fr);
			
			firstLine = BR.readLine();
			while(firstLine != null) {
				
			 System.out.print(" | "+firstLine+" | ");
				firstLine = BR.readLine();
				
			}
		}
		catch(FileNotFoundException fnfe) {
			System.out.print("Error..Can't Find the File Specified....");
		}
		
		catch (IOException e) {
		System.out.print("Error..Can't read the file....");
			e.printStackTrace();
		}
			
		
		}
		
		
		
	
	
	///////////////////////////////// delete a particular ITEMS  /////////////////////////////////////
	public void Writer() {
		try {
			 BR = new BufferedReader(new FileReader("DeletedItems.txt"));     
			 br = new BufferedWriter(new FileWriter("Stack.txt"));

		    String line = BR.readLine();
		    while(line != null) {
		      br.write(line);
		      br.newLine();
		      line = BR.readLine();
		      
		     
		    }
		   System.out.print("Item has been successfully removed from the cataloge..");
		  } catch (IOException e) {
		    System.out.println("Error copying files");
		  }

		  if (br != null) {try {br.close();} catch(IOException e) {}}
		  if (br != null) {try {br.close();} catch(IOException e) {}}
		}

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void DeleteItem(String title) {
		boolean a = true;
	
		    try {
			    BR = new BufferedReader(new FileReader("Stack.txt"));
				br = new BufferedWriter(new FileWriter("DeletedItems.txt"));
				
				
				String line = BR.readLine();
			    while(line != null ) {
			    StringTokenizer st = new StringTokenizer(line);
			    if ((st.nextToken()).equals(title))
			    	line = BR.readLine();
			         a = false;
			     
			     br.write(line);
			     br.newLine();
			     line = BR.readLine();
			    
			   
			    }
			    
			  } catch (Exception e) {
			   
			  }

			  if (br != null) {try {br.close();} catch(IOException e) {}}
			  if (br != null) {try {br.close();} catch(IOException e) {}}
		if (a == false)
			Writer();	///re-writing the file.
		else
			System.out.print("Item Not Found.");
			
	}
	     

				
///////////////////////////////// search a particular ITEMS  /////////////////////////////////////
	
public void Search(String item) {
	
	try {
	 System.out.print("|ITEM NAME |\t\t| BRAND |\t\t| P.Date |\t\t| QUANTITY |\t\t| CATAGORY |\t\t| Disctioption on return |\n"+ "");
		BR = new BufferedReader(new FileReader("Stack.txt"));
	     String line;
	     boolean counter = false;
		line = BR.readLine();
		while(line != null ) {
		    StringTokenizer st = new StringTokenizer(line);
		    if ((st.nextToken()).equals(item))
		    {
		     System.out.print(line);
		    	counter = true;
		    }
		        
		     line = BR.readLine();
		}
		if (counter == false)
		 System.out.print("ITEM NOT AVAILABLE....");
		   
		    
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	

}
	
///////////////////////////////// Add a new ITEMS  /////////////////////////////////////
	
public void AddStock() {
	

	try {
		fw = new FileWriter("Stack.txt",true);
		br = new BufferedWriter(fw);
		pw = new PrintWriter(br);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
System.out.print("Please provide the information of the Item as mentioned by the labels...\n");
 
try {
 System.out.print("* NAME * :\t\t");
	String Name = sc.next().toUpperCase(); 
	pw.print(Name+"\t\t\t");
	
	///////////////////////
	
 System.out.print("* BRAND * :\t\t");
	String Brand = sc.next().toUpperCase(); 	
    pw.print(Brand+"\t\t\t");
	
	///////////////////////
    
System.out.print("* Production Date * :\t\t");
 String P_Date = sc.next().toUpperCase();        //publication date 
 pw.print(P_Date+"\t\t\t");
	 
	///////////////////////
 
System.out.print("* QUANTITY * :\t\t");
 int quantity = sc.nextInt();
 pw.print(quantity+"\t\t\t");
 
System.out.print("* Catagory * :\t\t");
System.out.print("* Non-refundable or Refundable ? R / NR* :\t\n");






String s  = sc.next();	
	if (s.equals("R")) {

		pw.print(s + "\t\t\t");
	} else if (s.equals("NR")) {

		pw.print(s + "\t\t\t");
	} else {
		System.out.println("Wrong catagory.....");
	    return;
	}
	

System.out.print("* Discription on Rent* :\t\t ( USE '-' AS A SEPARATOR.)");
String Discription = sc.next();
 Discription.strip().toUpperCase();
 pw.print(Discription+"\n");

	 
	 
 pw.flush();  //////////making all the changes permanent.
System.out.print("\n The Item has successfully been submitted.\n");
         

 fr.close();
 br.close();
 
 

	} catch (Exception io) {
	
	
}
}
}
