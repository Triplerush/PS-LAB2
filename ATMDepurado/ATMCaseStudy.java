// ATMCaseSTudy.java
// Driver program for the ATM case study
package ATMCaseStudy;

public class ATMCaseStudy {
	public static void main(String[] args) {
		try{
			ATM theATM = new ATM();
			theATM.run();
		}
		catch(Exception e){
			System.out.println("Error, exited the program....");
		}
	}
}
