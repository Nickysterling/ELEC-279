
// name: Nicholas Seegobin
// student_number: 20246787
// date_of_submission: 02/15/2023

/* Import statements */
import java.util.Scanner;

public class Date
{
	/* Instance variables */
    private String month;
    private int day;
    private int year;

	/* Default constructor */
    public Date( )
    {
        month = "January";
        day = 1;
        year = 1000;
    }

	/* Constructor that calls the setDate function with the int, int, int arguments */
    public Date(int monthInt, int day, int year)
    {
        setDate(monthInt, day, year);
    }

    /* Constructor that calls the setDate function with the String, int, int arguments */
    public Date(String monthString, int day, int year)
    {
        setDate(monthString, day, year);
    }

    /* Constructor that calls the setDate function with the int, int, int arguments */
    public Date(int year)
    {
        setDate(1, 1, year);
    }

	/* Constructor that takes a Date class instance (aDate) as input */
    public Date(Date aDate)
    {
		/* Checks for invalid date */
        if (aDate == null)
        {
             System.out.println("Fatal Error.");
             System.exit(0);
        }

        /*
         * Sets instance variables from aDate class instance equal to current class
         * instance variables
         */
        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }
    
	/* 
	 * Constructor that accepts a date in string format: "mm/dd/yyyy", 
	 * parses it to an int and calls the setDate function 
	 */
    public Date (String strDate) 
    {
		/* Stores each element as a string by splitting at the '/' */
    	String[] elements = strDate.split("/");
    	
		/* Creates an array to hold the parsed string elements */
    	int[] intElements = new int[elements.length];
    	
		/* Loop to parse and store the integer elements */
    	for(int i = 0; i < elements.length; i++)
    		intElements[i] = Integer.parseInt(elements[i]);
    	
		/*
		 * setDate function call to check date validity and assign values to instance
		 * variables
		 */
    	setDate(intElements[0], intElements[1], intElements[2]);
    	
    }
    
	/* Function that is used to assign values to instance variables;
	 * accepts three integer values as input 
	 */
    public void setDate(int monthInt, int day, int year)
    {
		/* Checks validity of date using dateOK function */
    	if (dateOK(monthInt, day, year))
        {
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

	/* Function that is used to assign values to instance variables;
	 * accepts one string and two integer values as input 
	 */
    public void setDate(String monthString, int day, int year)
    {
        if (dateOK(monthString, day, year))
        {
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

	/* Function that is used to assign values to instance variables;
	 * accepts one integer value for the year as input 
	 */
    public void setDate(int year)
    {
        setDate(1, 1, year);
    }

    /* Mutator function used to assign value to year instance variable */
    public void setYear(int year)
    {
		/* Check year validity */
        if ( (year < 1000) || (year > 9999) )
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
			/* Assign instance year equal to year parameter */
            this.year = year;
    }
    
    /* Mutator function used to assign value to month instance variable */
    public void setMonth(int monthNumber)
    {
		/* Check month validity */
        if ((monthNumber <= 0) || (monthNumber > 12))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
        	/* Assign instance month equal to month parameter */
            month = monthString(monthNumber);
    }

    /* Mutator function used to assign value to day instance variable */
    public void setDay(int day)
    {
    	/* Check day validity */
        if ((day <= 0) || (day > 31))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
        	/* Assign instance day equal to day parameter */
            this.day = day;
    }

	/* Accessor function used to return an integer representing the month */
    public int getMonth( )
    {
        if (month.equals("January"))
            return 1;
        else if (month.equals("February"))
            return 2;
        else if (month.equalsIgnoreCase("March"))
            return 3;
        else if (month.equalsIgnoreCase("April"))
            return 4;
        else if (month.equalsIgnoreCase("May"))
            return 5;
        else if (month.equals("June"))
            return 6;
        else if (month.equalsIgnoreCase("July"))
            return 7;
        else if (month.equalsIgnoreCase("August"))
            return 8;
        else if (month.equalsIgnoreCase("September"))
            return 9;
        else if (month.equalsIgnoreCase("October"))
            return 10;
        else if (month.equals("November"))
            return 11;
        else if (month.equals("December"))
            return 12;
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
            return 0; //Needed to keep the compiler happy
        }
    }

	/* Accessor to return the day */
    public int getDay( )
    {
        return day;
    }

	/* Accessor to return the year */
    public int getYear( )
    {
        return year;
    }

	/* Returns the date in a string form */
    public String toString( )
    {
        return (month + " " + day + ", " + year);
    }

	/*
	 * Checks if the date instance variables of the current Date object is equal to
	 * the instance variables of another Date object
	 */
    public boolean equals(Date otherDate)
	{
	    if (otherDate == null)
	        return false;
	    else
	        return ((month.equals(otherDate.month)) &&
	            (day == otherDate.day) && (year == otherDate.year) );
    }

	/*
	 * Checks if the date instance variables of the current Date object precede
	 * the instance variables of another Date object
	 */
    public boolean precedes(Date otherDate)
    {
        return ( (year < otherDate.year) ||
           (year == otherDate.year && getMonth( ) < otherDate.getMonth( )) ||
           (year == otherDate.year && month.equals(otherDate.month)
                                         && day < otherDate.day) );
    }

	/* Function to check for date input */
    public void readInput( )
    {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain)
        {
            System.out.println("Enter month, day, and year.");
              System.out.println("Do not use a comma.");
            String monthInput = keyboard.next( );
            int dayInput = keyboard.nextInt( );
            int yearInput = keyboard.nextInt( );
            if (dateOK(monthInput, dayInput, yearInput) )
            {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date. Reenter input.");
         }
        
        keyboard.close();
        
    }

	/* Function that is used to check if a date is valid;
	 * accepts three integer values as input 
	 */
    private boolean dateOK(int monthInt, int dayInt, int yearInt)
    {
        return ( (monthInt >= 1) && (monthInt <= 12) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

	/* Function that is used to check if a date is valid;
	 * accepts one string and two integer values as input 
	 */
    private boolean dateOK(String monthString, int dayInt, int yearInt)
    {
        return ( monthOK(monthString) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

	/* Function that is used to check if an entered month is valid;
	 * accepts one string value as input 
	 */
    private boolean monthOK(String month)
    {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December") );
    }

	/* Takes an integer as input and returns a string for the month */
    private String monthString(int monthNumber)
    {
        switch (monthNumber)
        {
        case 1:
            return "January";
        case 2:
            return "February";
        case 3:
            return "March";
        case 4:
            return "April";
        case 5:
            return "May";
        case 6:
            return "June";
        case 7:
            return "July";
        case 8:
            return "August";
        case 9:
            return "September";
        case 10:
            return "October";
        case 11:
            return "November";
        case 12:
            return "December";
        default:
            System.out.println("Fatal Error");
            System.exit(0);
            return "Error"; //to keep the compiler happy
        }
    }
}
