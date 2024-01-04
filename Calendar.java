/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
		int debugDaysCounter = 0; 
		int selectedYear = Integer.parseInt(args[0]);
		String answer = "";
		while (year != selectedYear || month != 1 || dayOfMonth != 1) {
			advance();
		}
	 	while (year != selectedYear + 1 || month != 1 || dayOfMonth != 1) {
	 		answer = (dayOfMonth + "/" + month + "/" + year);
			if (dayOfWeek == 1){
				answer += (" Sunday");
			}
			System.out.println(answer);
			
	 		advance();
	 		debugDaysCounter++;
	 		//// If you want to stop the loop after n days, replace the condition of the
	 		//// if statement with the condition (debugDaysCounter == n)
	 		if (debugDaysCounter == 999999) { 
				System.out.println("Failed loop, debug activated");
	 			break;
	 		}
        }
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		if (dayOfWeek == 7){
			dayOfWeek = 1;
		}
		else{
			dayOfWeek++;
		}
		if (nDaysInMonth(month,year) == dayOfMonth ){
			if (month == 12){
				year++;
				month = 1;
			}
			else{
				month++;
			}
			dayOfMonth = 1;
			nDaysInMonth = nDaysInMonth(month,year);
		}
		else{
			dayOfMonth++;
		}
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		if (year % 4 == 0){
			if (year % 400 != 0 && year % 100 == 0){
				return false;
			}
			else{
			return true;
			}
		}
		return false;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		switch (month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				return  isLeapYear(year) ? 29 : 28; 
			default:
				return 0;
	}
    }   
}
