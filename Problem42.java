
/*
 * This program is the solution to Euler problem #42
 *
 * Written by: Sean Brown
 *
 *
 */

import java.util.Map;
import java.util.HashMap;

public class Problem42 {
    public static void main(String args[]) {
	boolean check;

	/*String ex[] = "Hello".split("");
	for(int i = 0; i < ex.length; i++) {
	    System.out.println(ex[i]);
	    }*/

	String x = "APPLE";
	int count = wordCount(x);
	System.out.println(count);
    }

    /**
     * Determines whether a number is a triangle number.
     *
     * @param tri, integer to test
     * @returns isEqual, true if a triangle number, false otherwise
     *
     */
    public static boolean isTriangleNum(int tri) {
	int trinum = 0;
	int i = 1;
	boolean isEqual = false;
	while(trinum <= tri) {
	    trinum = (i*(i+1))/2;
	    System.out.println(trinum);
	    if(trinum == tri) {
		isEqual = true;
		break;
	    }
	    i++;
	}
	return isEqual;
    }

    /**
     * Counts the number a word is worth.
     * Follows A = 1, B = 2,...,Y = 25,Z = 26.
     * Ex) MAN = 13 + 1 + 14 = 28
     *
     * @param word, string to be evaluated
     * @returns answer, the number value of the string
     *
     */
    public static int wordCount(String word) {
	Integer answer = 0;
	String temp;
	String arr[] = word.split("");
	Map<String, Integer> dict = new HashMap<String, Integer>();
	String alpha[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	// fill dictionary
	for(int j = 0; j < 26; j++) {
	    dict.put(alpha[j], j+1);
	    System.out.println(dict.get(alpha[j]));
	}

	for(int i = 0; i < arr.length; i++) {
	    temp = arr[i];
	    System.out.println(arr[i]);
	    //System.out.println(dict.get(arr[i]));
	    answer += dict.get(arr[i]);
	    
	}
	return answer;
	
    }

}