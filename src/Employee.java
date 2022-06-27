import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Employee extends MessageBox implements Employeee{
	
	private String firstLine;
	private String User_Name;
    private String Password;
   

    Scanner sc = new Scanner(System.in);
    BufferedWriter br = null;  
    BufferedReader BR = null;
    FileWriter fw = null;
    FileReader fr = null;
   
    PrintWriter pw = null;
    
public Employee() {
		super();
		User_Name = null;
		Password = null;

	}
	
void Fields() {
	
	Message("Username :  ");
	User_Name = sc.next().trim();
	Message("Password :  ");
	Password = sc.next().trim();
	
	Verification();
}	
public void Verification() {
	

			if ((User_Name.equals("Employee") && Password.equals("*****"))) {
				Message("You have Successfully Logged In....");

				Message("***************************************************\n\n ");
				Message("( 1 ) See All The ITEMS.");
				Message("( 2 ) Availability. Search the box..."); // to check if it is available in order to borrow it.
				Message("( 3 ) Borrow the item.");
				
				Message("***************************************************\n\n ");
				Message("Choose The Operation Number You Want To Do...\n ");
				
				// getting the user input operation

				int choice = sc.nextInt();
				switch (choice) {

				case 1:
					Items();
					break;
				case 2:
					Message("Enter The Name of The Item TO SEARCH....");
					String e = (sc.next()).trim();
					Search(e);
					break;
				case 3:
					Message("ENTER THE NAME OF THE ITEM TO BORROW.....");
					String b = (sc.next()).trim();
					Borrow(b);
					break;
				default:
					Message("Wrong Input...Try Again...");

				}

		

			}

	
		
	}
/////////////////////////////////// BORROW   /////////////////////////////////////////////////////////////////

private void Borrow(String b) {
	if( b.isEmpty() || b.length() >10) {
		Message("Wrong Input...");
	    return;
	}
	try {
		Message("Enter your name: ");
		String Name = sc.next();		
		fw = new FileWriter("item_borrowed.txt",true);
		br = new BufferedWriter(fw);
		pw = new PrintWriter(br);
		
		Message("*** YOU HAVE SUCCESSFULLY BORROWED "+b+" *** \n\n");
		
		Message("|ITEM NAME |   BORROWER\n\n");
		Message(b + "         " + Name);
		pw.print("\n"+b + "         "+ Name);
		pw.flush();
		fw.close();
		br.close();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}

/////////////////////////////////// see all available books with their description /////////////////////////////

public void Items() {
	try {
		Message("|ITEM NAME |\t\t| BRAND |\t\t| P.Date |\t\t| QUANTITY |\t\t| CATAGORY |\t\t| Disctioption on return |\n"+ "");
		fr =  new FileReader("Stack.txt");
		BR = new BufferedReader(fr);
		
		firstLine = BR.readLine();
		if (firstLine == null)
			Message("Sorry... no available item..");
		while(firstLine != null) {
			
		    Message(" | "+firstLine+" | ");
			firstLine = BR.readLine();
			
		}
	} catch (IOException e) {
		Message("Error..Can't read the file....");
		e.printStackTrace();
	}
	
		
}
//////////////////////////////////////////////////////////Search Particular Book /////////////////////////////////		


public void Search(String item) {
	
	try {
		Message("|ITEM NAME |\t\t| BRAND |\t\t| P.Date |\t\t| QUANTITY |\t\t| CATAGORY |\t\t| Disctioption on return |\n"+ "");
		BR = new BufferedReader(new FileReader("Stack.txt"));
	     String line;
	     boolean counter = false;
		line = BR.readLine();
		while(line != null ) {
		    StringTokenizer st = new StringTokenizer(line);
		    if ((st.nextToken()).equals(item))
		    {
		     
		    	Message(line);
		    	counter = true;
		    }
		        
		     line = BR.readLine();
		}
		if (counter == true)
			Message("Item Found...");
		if (counter == false)
			Message("Sorry ..Item Not Available....");
		   
		    
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	

}


/////////////////////////////////////////   Line Break   ////////////////////////////////////////////////////


	
}
