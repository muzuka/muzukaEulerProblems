import java.util.Scanner;

public class Problem17 {

	/**
	 * Solves Euler problem 17
	 * Counts number of letters in the word representation of numbers. 
	 * Specifically the sums of all numbers to a target number
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int next = 1;
		
		int sum = 0;
		for(int i = 1; i <= 1000; i++) {
			sum += countLetters(i);
		}
		
		System.out.println(sum);
		
	}
	
	public static int switchSingle(int num) {
		switch(num) {
		case 1: case 2: case 6: case 10:
			return 3;
		case 3: case 7: case 8:
			return 5;
		case 4: case 5: case 9:
			return 4;
		default:
			return 0;
		}
	}
	
	/**
	 * counts letters of number
	 * 
	 * @param num
	 * @return
	 */
	public static int countLetters(int num) {
		String number = new String();
		
		if(num <= 10) {
			return switchSingle(num);
		}
		else if(num > 10 && num < 20) {
			switch(num) {
			case 11: case 12:
				return 6;
			case 15: case 16:
				return 7;
			case 13: case 14: case 18: case 19:
				return 8;
			case 17:
				return 19;
			default:
				return 0;
			}
		}
		else if(num >= 20 && num < 30) {
			return switchSingle(num - 20) + 6;
		}
		else if(num >= 30 && num < 40) {
			return switchSingle(num - 30) + 6;
		}
		else if(num >= 40 && num < 50) {
			return switchSingle(num - 40) + 5;
		}
		else if(num >= 50 && num < 60) {
			return switchSingle(num - 50) + 5;
		}
		else if(num >= 60 && num < 70) {
			return switchSingle(num - 60) + 5;
		}
		else if(num >= 70 && num < 80) {
			return switchSingle(num - 70) + 7;
		}
		else if(num >= 80 && num < 90) {
			return switchSingle(num - 80) + 6;
		}
		else if(num >= 90 && num < 100) {
			return switchSingle(num - 90) + 6;
		}
		else if(num >= 100 && num < 1000) {
			number = Integer.toString(num);
			int first = switchSingle(Character.getNumericValue(number.charAt(0)));
			int second = Character.getNumericValue(number.charAt(1));
			int third = Character.getNumericValue(number.charAt(2));
			
			if(second == 0) {
				if(third == 0) {
					return first + 7;
				}
				else {
					return first + 10 + switchSingle(third);
				}
			}
			else {
				return first + 10 + countLetters(Integer.parseInt(number.substring(1)));
			}
		}
		else {
			return 11;
		}
	}
}
