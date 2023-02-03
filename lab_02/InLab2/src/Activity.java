
public class Activity {

	/* Private instance variables */
	private int day = 0;
	private int month = 0;
	private int year = 0;

	/* Default constructor definition */
	public Activity() {

		this.day = 1;
		this.month = 1;
		this.year = 1;

	}

	/* Custom constructor definition */
	public Activity(int dayIn, int monthIn, int yearIn) {

		this.day = 1;
		this.month = 1;
		this.year = 1;

		checkDate(dayIn, monthIn, yearIn);

	}

	/* Function to check if a valid date is entered */
	void checkDate(int day, int month, int year) {

		/* Check if there is a leap year */
		boolean leapYear = false;

		/* Check if year is divisible by 4 */
		if (year % 4 == 0) {

			/* Check if year is divisible by 100 (century) */
			if (year % 100 == 0) {

				/* If the year is divisible by 4, 100, and 400, leap = true */
				if (year % 400 == 0) {
					leapYear = true;
				} else {
					leapYear = false;
				}
			} else
				leapYear = true;

		} else
			leapYear = false;

		/* Check if a valid year is entered */
		if (year > 0) {
			/* If year entered is valid, set it equal to the private variable */
			this.year = year;

		} else {
			System.out.println("Error: Invalid Year Detected!");
		}

		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {

			/* If month entered is valid, set it equal to the private variable */
			this.month = month;

			/* If day entered is valid, set it equal to the private variable */
			if (day > 0 && day <= 31)
				this.day = day;
			else
				System.out.println("Error: Invalid Day Detected!");

		} else if (month == 2) {

			/* If month entered is valid, set it equal to the private variable */
			this.month = month;

			/* If day entered is valid, set it equal to the private variable */
			if (day > 0 && day <= 28)
				this.day = day;
			else if (day > 0 && day <= 29 && leapYear)
				this.day = day;
			else
				System.out.println("Error: Invalid Day Detected!");

		} else if (month == 4 || month == 6 || month == 9 || month == 11) {

			/* If month entered is valid, set it equal to the private variable */
			this.month = month;

			/* If day entered is valid, set it equal to the private variable */
			if (day > 0 && day <= 30)
				this.day = day;
			else
				System.out.println("Error: Invalid Day Detected!");

		} else {

			System.out.println("Error: Invalid Month Detected!");

			/* If day entered is valid, set it equal to the private variable */
			if (day > 0 && day <= 31)
				this.day = day;
			else
				System.out.println("Error: Invalid Day Detected!");

		}
	}

	/*
	 * Accessor method used to obtain the private day variable to be used outside
	 * this class
	 */
	public int getDay() {
		return day;
	}

	/*
	 * Accessor method used to obtain the private month variable to be used outside
	 * this class
	 */
	public int getMonth() {
		return month;
	}

	/*
	 * Accessor method used to obtain the private year variable to be used outside
	 * this class
	 */
	public int getYear() {
		return year;
	}

	public void setDate(int setDay, int setMonth, int setYear) {

		this.day = 1;
		this.month = 1;
		this.year = 1;

		checkDate(setDay, setMonth, setYear);

	}

	public void printDate() {
		System.out.println(day + "." + month + "." + year);
	}

}
