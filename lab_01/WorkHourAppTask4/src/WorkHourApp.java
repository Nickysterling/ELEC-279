//Import System class for input output
import java.util.Scanner;

public class WorkHourApp {

	public int hoursPerDay = 0, numDays = 0;
	
	public static void main(String[] args) {

		/* Create an object of the Scanner class */
		Scanner input = new Scanner(System.in);
		WorkHourApp obj = new WorkHourApp();
		
		/* Input for hours worked per day scanner input */
		System.out.print("Please enter the hours worked per day: ");
		obj.hoursPerDay = input.nextInt();
		
		/* Scanner input for number of days worked */
		System.out.print("Please enter the number of days worked: ");
		obj.numDays = input.nextInt();
		
		input.close();
		
		for(int count = 1; count <= obj.numDays; count++) {
			System.out.println("Day " + count + ", Total hours worked: " + (count * obj.hoursPerDay));
		}
	}

}
