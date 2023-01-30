
import java.util.Date;

public class DateApptask {

	public static void main(String[] args) {
		
		/* Task 2, Part 2: Create an object of the Date class */
		Date todaysdate = new Date();
		
		/* Prints the present date */
		System.out.println(todaysdate);
		
		/* Task 3, Part 1: Initializing variables */
		int min = 10, max = 20, average = 5;
		String myRole = "Driver";
		byte myFirstByte = 22;
		double pi = 3.14159;
		char myChar = 'N';
		
		/* Task 3, Part 2: Print the variables */
		System.out.println("\nI am now the " + myRole);
		System.out.println("Our minimum score is " + min);
		System.out.println("We have a byte " + myFirstByte);
		System.out.println("And double type is " + pi);
		System.out.println("A char looks like " + myChar + "\n");
		
		/* Task 3, Part 3: While loop */
		int count = 1;
		while(count <= 10) {
			System.out.println(todaysdate);
			count++;
		}
		
		/* Task 3, Part 4: For loop */
		for(count = 1; count <= 25; count++) {
			System.out.println(todaysdate);
		}
	
		/* Task 3, Part 5: Nested for loop */
		for(int row = 1; row <= 5; row++) {
			for(int column = 1; column <= 10; column++) {
				System.out.print(row * column + "\t");
			}
			
			/* New row in the table */
			System.out.println();	
		}
		
	}

}
