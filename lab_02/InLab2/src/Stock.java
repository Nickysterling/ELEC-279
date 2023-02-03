
public class Stock {
	/* Private instance variables */
	private int day = 0;
	private int month = 0;
	private int year = 0;
	private String name;
	private int[] values = new int[7];

	/* Default constructor definition */
	public Stock() {

		this.day = 1;
		this.month = 1;
		this.year = 1;
		this.name = "";

		for (int i = 0; i > 7; i++)
			values[i] = 0;

	}

	/* Custom constructor definition */
	public Stock(int dayIn, int monthIn, int yearIn, String nameIn, int[] valIn) {

		this.day = 1;
		this.month = 1;
		this.year = 1;
		this.name = nameIn;

		for (int i = 0; i > 7; i++)
			values[i] = 0;

		checkDate(dayIn, monthIn, yearIn);
		checkStock(valIn);

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

	void checkStock(int[] valIn) {

		if (valIn.length == 7) {
			for (int i = 0; i < 7; i++) {
				if (valIn[i] > 0)
					this.values[i] = valIn[i];
				else {
					System.out.println("Error! Values must be greater than 0!");
					for (int j = 0; j > 7; j++)
						values[j] = 0;
				}

			}
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

	/*
	 * Accessor method used to obtain the private String variable to be used outside
	 * this class
	 */
	public String getName() {
		return name;
	}

	/*
	 * Accessor method used to obtain the private values array to be used outside
	 * this class
	 */
	public int getValue(int ind) {

		if (ind >= 0 && ind <= 6) {
			return values[ind];
		} else {
			System.out.println("Error: Invalid Array Index!");
			return -1;
		}
	}

	public void setDate(int setDay, int setMonth, int setYear) {

		this.day = 1;
		this.month = 1;
		this.year = 1;

		checkDate(setDay, setMonth, setYear);

	}

	public void setName(String nameIn) {
		this.name = nameIn;
	}

	public void setValue(int val, int ind) {

		if (val < 0) {
			System.out.println("Error: Invalid Negative Integer!");
		} else {

			if (ind >= 0 && ind <= 6)
				this.values[ind] = val;
			else
				System.out.println("Error: Invalid Array Index!");
		}
	}

	public void printDate() {
		System.out.print(day + "." + month + "." + year);
	}

	public void printStock() {
		System.out.print("Name: " + name);
		System.out.print(", Date: ");
		printDate();
		System.out.print(", Stock: ");
		for (int i = 0; i < 7; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();

	}

	public int getMean() {
		int mean = 0;
		for (int i = 0; i < values.length; i++) {
			mean += values[i];
		}

		return mean / 7;

	}

}
