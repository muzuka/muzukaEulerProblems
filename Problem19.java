

/**
 * Calculates the number of sundays that occur on the 1st of a month.
 * @author seanbrown
 *
 */
public class Problem19 {

	static int cday = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int sundays = 0;
		int lmonth = 0;
		//             0   1   2   3   4   5   6   7   8   9   10  11
		//             jan feb mar apr may jun jul aug sep oct nov dec
		int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String day[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		
		
		
		for(int y = 1900; y <= 2000; y++) {
			for(int m = 0; m < 12; m++) {
				if(isLeap(y) && m == 1) {
					lmonth = 29;
				}
				else {
					lmonth = month[m];
				}
				for(int d = 1; d <= lmonth; d++) {
					if(y == 1900) {
						nextDay();
					}
					else if(day[cday].equals("Sunday") && d == 1) {
						System.out.printf("Sunday found on: %d/%d/%d\n", d, m, y);
						sundays++;
						nextDay();
					}
					else {
						nextDay();
					}
				}
			}
		}
		
		System.out.printf("The number of sundays on the 1st of a month in 100 years was: %d\n", sundays);
	}

	/**
	 * 
	 */
	public static void nextDay() {
		if(cday == 6) {
			cday = 0;
		}
		else {
			cday++;
		}
	}
	
	/**
	 * Determines leap year by conditions stated
	 * @param year to test
	 * @return
	 */
	public static boolean isLeap(int year) {
		if(year % 400 == 0) {
			return true;
		}
		else if(year % 4 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
