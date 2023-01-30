
public class Activity {
	
	/* Private instance variables */
	private int day = 0;
	private int month = 0;
	private int year = 0;

	/* Constructor definition */
	public Activity() {
		
		this.day = 1;
		this.month = 1;
		this.year = 1;
		
	}

	public Activity(int dayIn, int monthIn, int yearIn) {
		
		boolean date = false;
		date = checkDate(dayIn, monthIn, yearIn);
		
		if(date == true) {

			this.day = dayIn;
			this.month = monthIn;
			this.year = yearIn;

		} else
			System.out.println("Error!");
		
	}
	
	boolean checkDate(int day, int month, int year) {
		/* Check if there is a leap year */
		boolean leapYear = false;
		boolean validDate = false;
		
		/* Check if year is divisible by 4 */
		if(year % 4 == 0) {
			
			/* Check if year is divisible by 100 (century) */
			if(year % 100 == 0) {
				
				/* If the year is divisible by 4, 100, and 400, leap = true */
				if(year % 400 == 0) {
					leapYear = true;
				} else {
					leapYear = false;
				}
			
			} else
				leapYear = true;
			
		} else
			leapYear = false;
		
		if(year > 0) {
			if(month > 0 && month <= 12) {
				
				switch(month) {
				  case 1:
					  if(day > 0 && day <= 31)
						  validDate = true;
					  break;
				  case 2:
					  if(leapYear == true) {
						  if(day > 0 && day <= 29) {
							  validDate = true;
						  }
					  } else if(day > 0 && day <= 28) {
						  validDate = true;
					  }
					  break;
				  case 3:
					  if(day > 0 && day <= 31)
						  validDate = true;
					    break;
				  case 4:
					  if(day > 0 && day <= 30)
						  validDate = true;
					    break;
				  case 5:
					  if(day > 0 && day <= 31)
						  validDate = true;
					    break;
				  case 6:
					  if(day > 0 && day <= 30)
						  validDate = true;
					    break;
				  case 7:
					  if(day > 0 && day <= 31)
						  validDate = true;
					    break;
				  case 8:
					  if(day > 0 && day <= 31)
						  validDate = true;
					    break;
				  case 9:
					  if(day > 0 && day <= 30)
						  validDate = true;
					    break;
				  case 10:
					  if(day > 0 && day <= 31)
						  validDate = true;
					    break;
				  case 11:
					  if(day > 0 && day <= 30)
						  validDate = true;
					    break;
				  case 12:
					  if(day > 0 && day <= 30)
						  validDate = true;
					    break;
				  default:
					  System.out.println("Error!");
				}
			}
		}
		
		
		return validDate;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
	
	public void setDate(int setDay, int setMonth, int setYear) {
		
		boolean date = false;
		date = checkDate(setDay, setMonth, setYear);
		
		if(date == true) {

			this.day = setDay;
			this.month = setMonth;
			this.year = setYear;

		} else
			System.out.println("Error!");
		
	}
	
	public void printDate() {
		System.out.println(day + "." + month + "." + year);
	}
	
}
