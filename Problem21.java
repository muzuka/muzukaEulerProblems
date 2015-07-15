
import java.util.*;

public class Problem21 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int limit;

		System.out.println("Enter a number:");
		limit = scan.nextInt();
		
		int sum = 0;
		
		for(int i = 1; i < limit; i++) {
			if(isAmicable(i)) {
				System.out.println(i);
				sum += i;
			}
		}
		
		System.out.println(sum);
	}
	
	public static boolean isAmicable(int a) {
		int sum1 = getSumOfDivisors(a);
		if(getSumOfDivisors(sum1) == a && sum1 != a) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int getSumOfDivisors(int a) {
		int sum = 0;
		for(int i = 1; i < a; i++) {
			if(a % i == 0) {
				sum += i;
			}
		}
		return sum;
	}

}
