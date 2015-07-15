
/**
 * Contains Card data
 * @started August 6, 2013
 * @author seanbrown
 *
 */
public class Card {
	private char suite;
	private char rank;
	private int intRank;
	
	/**
	 * Empty constructor
	 */
	public Card() {
		
	}
	
	/**
	 * Constructor by individual characters
	 * @param r, character rank 2,3,4,5,6,7,8,9,T-10,J-jack,Q-queen,K-king,A-ace
	 * @param s, character suite C-club,S-spade,D-diamond,H-heart
	 */
	public Card(char r, char s) {
		this.suite = s;
		this.rank = r;
		this.intRank = findIntRank(r);
	}
	
	/**
	 * Constructor by whole string
	 * @param code
	 */
	public Card(String code) {
		this.rank = code.charAt(0);
		this.suite = code.charAt(1);
		this.intRank = findIntRank(code.charAt(0));
	}
	
	/**
	 * retrieves numerical rank
	 * @param c, character rank
	 * @return integer rank
	 */
	private int findIntRank(char c) {
		switch(c) {
		case 'A':
			return 14;
		case 'K':
			return 13;
		case 'Q':
			return 12;
		case 'J':
			return 11;
		case 'T':
			return 10;
		default:
			return Character.getNumericValue(c);
		}
	}
	
	/**
	 * compares a card to self
	 * @param b, second card
	 * @return true if equal, false otherwise
	 */
	public boolean isEqual(Card b) {
		if(this.rank == b.getRank() && this.suite == b.getSuite()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * compares two cards
	 * @param a, card 1
	 * @param b, card 2
	 * @return true if equal, false otherwise
	 */
	public boolean isEqual(Card a, Card b) {
		if(a.getRank() == b.getRank() && a.getSuite() == b.getSuite()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * returns difference between card ranks
	 * @param s, card to compare
	 * @return difference between rank
	 */
	public int difference(Card s) {
		return intRank - s.getIntRank();
	}
	
	/**
	 * Compares the rank of two cards
	 * @param s, card to compare
	 * @return 0 if equal, 1 if host is bigger, -1 if less
	 */
	public int compare(Card s) {
		if(intRank == s.getIntRank()) {
			return 0;
		}
		else if(intRank > s.getIntRank()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	/**
	 * get suite
	 * @return suite
	 */
	public char getSuite() {
		return suite;
	}
	
	/**
	 * get rank
	 * @return rank
	 */
	public char getRank() {
		return rank;
	}
	
	/**
	 * get integer rank
	 * @return intRank
	 */
	public int getIntRank() {
		return intRank;
	}
	
	/**
	 * returns string representation as rank and suite together
	 */
	public String toString() {
		return new String(Character.toString(rank) + Character.toString(suite));
	}
	
	public String toArrayString(Card arr[]) {
		String str = "";
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				str += "null ";
			}
			else {
				str += arr[i].toString();
				str += " ";
			}
		}
		return str;
	}
}
