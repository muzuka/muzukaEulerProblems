
public class Problem52 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		for(int i = 10; i <= 1000000; i++) {
			two = i * 2;
			three = i * 3;
			four = i * 4;
			five = i * 5;
			six = i * 6;
			if(multipleShareDigits(i, two, three, four, five, six)) {
				System.out.println(i);
			}
		}

	}
	
	// tests whether all arguments share the same digits
	public static boolean multipleShareDigits(int ... tests) {
		for(int i = 0; i < tests.length-1; i++) {
			if(!sharesAllDigits(tests[i], tests[i+1])) {
				return false;
			}
		}
		return true;
	}
	
	// tests whether two numbers share the same digits
	public static boolean sharesAllDigits(int first, int second) {
		String fir = Integer.toString(first);
		String sec = Integer.toString(second);
		if(fir.length() - sec.length() != 0) {
			return false;
		}
		else {
			for(int i = 0; i < fir.length(); i++) {
				for(int j = 0; j < sec.length(); j++) {
					if(fir.charAt(i) == sec.charAt(j)) {
						sec = sec.substring(0, j) + sec.substring(j+1);
						break;
					}
				}
			}
			if(sec.length() == 0) {
				return true;
			}
			else {
				return false;
			}
		}
	}

}
