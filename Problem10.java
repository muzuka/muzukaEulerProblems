
/*
 * Finds the sum of the prime numbers below a given number
 *
 * Written by: Sean Brown
*/

import java.util.Scanner;

public class Problem10 {
	
	public static void main(String args[]) {
		
		System.out.println("Enter the max to calculate to: ");
		
		Scanner in = new Scanner(System.in);
		
		int maxVal = in.nextInt();
		long sum = 0L;
		
		for (int i = 0; i < maxVal; i++) {
			if (isPrime(i)) {
				sum = sum + i;
				System.out.printf("sum = %d\ni = %d\n", sum, i);
			}
		}
		System.out.printf("The sum of the prime numbers is: %d\n", sum);
		
	}

	public static boolean isPrime(int prime) {
		if (prime == 1) {
			return false;
		}
		else if(prime == 2) {
			return true;
		}
		else {
			for (int i = 2; i < prime; i++) {
				if (prime % i == 0) {
					return false;
				}
			}
			return true;
		}

	}
}