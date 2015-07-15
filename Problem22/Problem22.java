
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Problem22 {

	static char letters[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			scan = new Scanner(new File("names.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		TreeMap<Character, Integer> letterMap = new TreeMap<Character, Integer>();
		for(int i = 1; i <= 26; i++) {
			letterMap.put(new Character(letters[i-1]), new Integer(i));
		}
		
		int nameScores[] = new int[5000];
		String names[] = new String[5000];
		String nameLine = scan.next();
		names = nameLine.split(",");
		names = quickSort(names);
		long total = 0L;
		for(int i = 0; i < 5000; i++) {
			//System.out.printf("%d: " + names[i] + " ", i+1);
			nameScores[i] = getScore(names[i], letterMap) * (i+1);
			total += nameScores[i];
			//System.out.println(nameScores[i]);
		}
		
		System.out.println(total);
		
	}
	
	public static int getScore(String name, TreeMap<Character, Integer> dict) {
		int score = 0;
		for(int i = 0; i < name.length(); i++) {
			if(dict.containsKey(name.charAt(i))) {
				score += dict.get(name.charAt(i));
			}
		}
		return score;
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static String[] quickSort(String array[]) {
		if (array.length <= 1) {
			return array;
		}
		int pivot = 0;
		ArrayList<String> empty = new ArrayList<String>();
		ArrayList<String> greater = new ArrayList<String>();
		ArrayList<String> lesser = new ArrayList<String>();
		for(int i = 0; i < array.length; i++) {
			int com = compare(array[i], array[pivot]);
			if(com == 1) {
				greater.add(array[i]);
			}
			else if(com == -1) {
				lesser.add(array[i]);
			}
		}
		empty.addAll(toArrayList(quickSort(lesser.toArray(new String[lesser.size()]))));
		empty.add(array[pivot]);
		empty.addAll(toArrayList(quickSort(greater.toArray(new String[greater.size()]))));
		return empty.toArray(new String[empty.size()]);
	}
	
	public static String toString(String a[]) {
		String string = "[";
		for(int i = 0; i < a.length; i++) {
			string += a[i];
			string += " ";
		}
		string += "]";
		return string;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public static ArrayList<String> toArrayList(String list[]) {
		ArrayList<String> s = new ArrayList<String>();
		for(int i = 0; i < list.length; i++) {
			s.add(list[i]);
		}
		return s;
	}
	
	/**
	 * compares a to b
	 * @param a
	 * @param b
	 * @return a>b returns 1, a==b returns 0, a<b returns -1
	 */
	public static int compare(String a, String b) {
		if(a.length() > b.length()) {
			try {
				for(int i = 0; i < a.length();i++) {
					if(a.charAt(i) > b.charAt(i)) {
						return 1;
					}
					else if(a.charAt(i) < b.charAt(i)) {
						return -1;
					}
				}
				return 1;
			}
			catch(StringIndexOutOfBoundsException e) {
				return 1;
			}
		}
		else if(b.length() > a.length()) {
			try {
				for(int i = 0; i < b.length();i++) {
					if(a.charAt(i) > b.charAt(i)) {
						return 1;
					}
					else if(a.charAt(i) < b.charAt(i)) {
						return -1;
					}
				}
				return -1;
			}
			catch(StringIndexOutOfBoundsException e) {
				return -1;
			}
		}
		else {
			try {
				for(int i = 0; i < b.length();i++) {
					if(a.charAt(i) > b.charAt(i)) {
						return 1;
					}
					else if(a.charAt(i) < b.charAt(i)) {
						return -1;
					}
				}
				return 0;
			}
			catch(StringIndexOutOfBoundsException e) {
				return 0;
			}
		}
	}

}
