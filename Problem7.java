/*
 * Finds the ith prime.
 *
 * Written by: Sean Brown
*/

import java.util.Scanner;

public class Problem7 {
	
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
	
	public static int findPrime(int n) {
		int count = 0;
		int prime = 0;
		int primeValue = 0;
		
		while (count < n) {
			prime++;
			if (isPrime(prime)) {
				count++;
				primeValue = prime;
			}
		}
		return primeValue;
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int prime = 0;
		
		System.out.println("Please enter which prime to find: ");
		
		//enter number
		int num = in.nextInt();
		
		// find corresponding prime
		prime = findPrime(num);
		
		System.out.printf("The prime is: %d\n", prime);
		
	}
}