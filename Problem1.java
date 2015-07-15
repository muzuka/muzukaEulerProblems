/******
First Euler problem

Objective: Find the sum of all the multiples of 3 and 5 below 1000.
Objective Complete!!!!
 ******/

public class Problem1 {

    public static void main(String[] args) {
		int i; 
		int sumThree = 0;
		int sumFive = 0;
		int sumFinal;

		sumFinal = multipleSum(3, 5, 1000); 

		System.out.printf("The Sum is: %d\n", sumFinal);
    }

    public static int multipleSum(int mulOne, int mulTwo, int limit) {
		int sumOne = 0;
		int sumTwo = 0;
		int i = 1;
		int j = 1;

		while(mulOne*i < limit) {

		    if((mulOne*i) % mulTwo == 0) {
				sumOne = sumOne - (mulOne*i);
		    }
		    sumOne = sumOne + mulOne*i;
		    i++;
		    
		}
		
		while(mulTwo*j < limit) {
		    sumTwo = sumTwo + mulTwo*j;
		    j++;
		}
		return sumOne + sumTwo;
    }

}

