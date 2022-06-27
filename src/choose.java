import java.util.Scanner;

public class choose {
	   
	Scanner user = new Scanner(System.in);
	private boolean Go = true;
	
	void WelcomeMessage() {
		
		// Display welcome message and let the user to choose who he/she is
		
		System.out.println("||| **** ||| WELCOME TO DU SUPERMARKET MANAGEMENT SYSTEM ||| **** |||");  // SUPERMARKET IS ONE KIND OF INVENTORY IN REAL LIFE PROBLEM.
		System.out.printf("\n\t\t ADMINISTRATOR \t or \t EMPLOYEE \n");
	}
	public void getChoice() {// getting who is the user
	
		Employee logins = new Employee();
		Admin logint = new Admin();
		MessageBox messagebox = new MessageBox();		
			int attempt = 5;
			do {
				String P = user.next();
				P = P.toUpperCase().trim();
				
				if (P.equals("ADMIN")) {
				
					logint.Fields();
				} else if (P.equals("EMPLOYEE")) {
					logins.Fields();
				} else {

					messagebox.Message("Wrong Choice...Try Again..");
					messagebox.Message("want to try ?? Y/N");
					
					String temp = user.next();
					if (temp.toUpperCase().equals("N"))
							Go = false;
					attempt -=1;
					messagebox.Message("ATTEMPTS REMAINING  --->  " + attempt);
					messagebox.Message("Employee\t\t\t or \t\t\t Admin");
					if (attempt ==0) {
						messagebox.Message("You have finished Your attempts. Try again later...");
					    Go = false;
					}
				} 
				
			} while (Go); 
		
	}
}
