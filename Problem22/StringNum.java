
public class StringNum {
	String number;
	int[] digits;
	
	public StringNum() {
		this.number = "";
		this.digits = new int[0];
	}
	
	public StringNum(String num) {
		this.number = num;
		this.digits = numberToArray(num);
	}
	
	public StringNum(int num) {
		this.number = Integer.toString(num);
		this.digits = numberToArray(number);
	}
	
	public StringNum(int nums[]) {
		this.digits = nums;
		this.number = intToString(nums);
	}
	
	/**
	 * converts an array of integers into a string.
	 * @param nums, array of integers under 10
	 * @return
	 */
	public String intToString(int nums[]) {
		String empty = "";
		for(int i = nums.length-1; i >= 0; i--) {
			empty += Integer.toString(nums[(nums.length-1) - i]);
		}
		return empty;
	}
	
	/**
	 * Converts a string of numbers into a array of integers.
	 * @param n, String of numbers
	 * @return
	 */
	public int[] numberToArray(String n) {
		int arr[] = new int[n.length()];
		for(int i = 0; i < n.length(); i++) {
			arr[i] = Character.getNumericValue(n.charAt(i));
		}
		return arr;
	}
	
	/**
	 * Adds n1 and n2
	 * @param n1, first addition
	 * @param n2, second addition
	 * @return
	 */
	public StringNum add(StringNum n1, StringNum n2) {
		int emptyArr[];
		try {
			String addends[] = {n1.getNumber(), n2.getNumber()};
			if(n1.getNumber().length() > n2.getNumber().length()) {
				emptyArr = new int[n1.getNumber().length()];
				int j = 0;
				for(int i = n1.getNumber().length()-1; i >= 0; i--) {
					emptyArr[i] = getSumOfCol(addends, j);
					if(i < n1.getNumber().length()-1) {
						emptyArr[i] += emptyArr[i+1]/10;
						String ans = Integer.toString(emptyArr[i+1]);
						emptyArr[i+1] = Character.getNumericValue(ans.charAt(ans.length()-1));
					}
					j++;
				}
			}
			else if(n2.getNumber().length() > n1.getNumber().length()) {
				emptyArr = new int[n2.getNumber().length()];
				int j = 0;
				for(int i = n2.getNumber().length()-1; i >= 0; i--) {
					emptyArr[i] = getSumOfCol(addends, j);
					if(i < n2.getNumber().length()-1) {
						emptyArr[i] += emptyArr[i+1]/10;
						String ans = Integer.toString(emptyArr[i+1]);
						emptyArr[i+1] = Character.getNumericValue(ans.charAt(ans.length()-1));
					}
					j++;
				}
			}
			else {
				emptyArr = new int[n2.getNumber().length()+1];
				int j = 0;
				for(int i = n2.getNumber().length()-1; i >= 0; i--) {
					emptyArr[i+1] = getSumOfCol(addends, j);
					if(i < n2.getNumber().length()-1) {
						emptyArr[i+1] += emptyArr[i+2]/10;
						String ans = Integer.toString(emptyArr[i+2]);
						emptyArr[i+2] = Character.getNumericValue(ans.charAt(ans.length()-1));
					}
					j++;
				}
			}
		}
		catch(NullPointerException e) {
			return new StringNum();
		}
		return stripLeadingZeros(new StringNum(emptyArr));
	}
	
	/**
	 * multiplies n1 by n2
	 * @param n1, first multiplicand
	 * @param n2, second multiplicand
	 * @return
	 */
	public StringNum slowMultiply(StringNum n1, StringNum n2) {
		StringNum product;
		try {
			if(n1.getNumber().length() > n2.getNumber().length()) {
				product = new StringNum(0);
				for(int i = 0; new StringNum().isLessThan(new StringNum(i), n2); i++) {
					product = product.add(product, n1);
				}
			}
			else {
				product = new StringNum(0);
				for(int i = 0; new StringNum().isLessThan(new StringNum(i), n1); i++) {
					product = product.add(product, n2);
				}
			}
		}
		catch(NullPointerException e) {
			return new StringNum();
		}
		return product;
	}
	
	/**
	 * a^b
	 * @param a
	 * @param b
	 * @return
	 */
	public StringNum power(StringNum a, StringNum b) {
		StringNum product = new StringNum(1);
		try {
			for(int i = 0; a.isLessThan(new StringNum(i), b); i++) {
				product = a.slowMultiply(product, a);
			}
		}
		catch(NullPointerException e) {
			return new StringNum();
		}
		return product;
	}
	
	/**
	 * Sums the numbers in a specified column of a list of strings
	 * @param l, list of strings where all characters are numbers
	 * @param n, column to sum
	 * @return
	 */
	public int getSumOfCol(String l[], int n) {
		int sum = 0;
		for(int i = 0; i < l.length; i++) {
			try {
				sum += Character.getNumericValue(l[i].charAt((l[i].length()-1)-n));
			}
			catch(StringIndexOutOfBoundsException e) {
				sum += 0;
			}
		}
		return sum;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public int[] getArray() {
		return this.digits;
	}
	
	/**
	 * Is a less than b?
	 * @param a, first number
	 * @param b, second number
	 * @return
	 */
	public boolean isLessThan(StringNum a, StringNum b) {
		if(a.getNumber().length() > b.getNumber().length()) {
			return false;
		}
		else if(a.getNumber().length() < b.getNumber().length()) {
			return true;
		}
		else {
			for(int i = 0; i < a.getNumber().length(); i++) {
				if(Character.getNumericValue(a.getNumber().charAt(i)) < Character.getNumericValue(b.getNumber().charAt(i))) {
					return true;
				}
				else if(Character.getNumericValue(a.getNumber().charAt(i)) > Character.getNumericValue(b.getNumber().charAt(i))) {
					return false;
				}
			}
			return false;
		}
	}
	
	public StringNum stripLeadingZeros(StringNum a) {
		String num = a.getNumber();
		int i = 0;
		if(a.getNumber().charAt(0) != '0') {
			return a;
		}
		while(num.charAt(i) != '0') {
			i++;
		}
		return new StringNum(num.substring(i+1));
	}
	
	/**
	 * Is this equal to a?
	 * @param a
	 * @return
	 */
	public boolean isEqual(StringNum a) {
		if(this.getNumber().equalsIgnoreCase(a.getNumber())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Is a equal to b?
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean isEqual(StringNum a, StringNum b) {
		if(a.getNumber().equalsIgnoreCase(b.getNumber())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Obligatory toString function
	 */
	public String toString() {
		return number;
	}
}
