//Import System class for input output
import java.util.Scanner;

public class TaskInputOutput {

	/* Declare variables */
	public int integerOne = 0, integerTwo = 0;
	
	public static void main(String[] args) {
		
		/* Create an object of the Scanner class */
		Scanner input = new Scanner(System.in);
		TaskInputOutput obj = new TaskInputOutput();
		
		System.out.println("This calculator takes two integers as input and returns the sum and product.\n");
		
		/* Integer one scanner input */
		System.out.print("Please enter integer one: ");
		obj.integerOne = input.nextInt();
		
		/* Integer two scanner input */
		System.out.print("Please enter integer two: ");
		obj.integerTwo = input.nextInt();
		
		input.close();
		
		/* Output print statements */
		System.out.println("\nOutput");
		System.out.println("The product of the two integers is " + (obj.integerOne * obj.integerTwo) + ".");
		System.out.println("The sum of the two integers is " + (obj.integerOne + obj.integerTwo) + ".");
		
	}

}
