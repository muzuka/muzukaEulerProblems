
/**
 * Finds the number of divisors a triangle number contains.
 * @author seanbrown
 *
 */

import java.util.Scanner;
import java.math.*;

public class Problem12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/*System.out.println("Please enter a number.");
		long number = scan.nextLong();
		long tri = findTriNum(number);
		long div = numOfDivisors(tri);
		System.out.printf("The triangle number equals:%d\nThe number of divisors = %d\n", tri, div);*/
		
		int i = 10;
		long tri = findTriNum(i);
		long div = numOfDivisors(tri);
		while(div <= 500) {
			tri = findTriNum(i);
			div = numOfDivisors(tri);
			i++;
		}
		System.out.println(tri);
		
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static long findTriNum(long num) {
		
		long tri = 0;
		
		for(long i = 1; i <= num; i++) {
			tri = tri + i;
		}
		
		return tri;
	}
	
	public static long numOfDivisors(long num) {
		
		long count = 0;
		
		for(long i = 0; i > Math.sqrt(num); i--) {
			if(num % i == 0) {
				count++;
			}
		}
		
		return count;
	}

}
