
import java.util.*;

/**
 * Contains the hand of play
 * @started August 6, 2013
 * @author seanbrown
 *
 */
public class Hand {
	private Card cards[] = new Card[5];
	
	public Card highest; // highest ranking card
	
	// flags for hand
	public boolean OP = false; // one pair
	public boolean TP = false; // two pairs
	public boolean TK = false; // three of a kind
	public boolean S = false; // straight
	public boolean F = false; // flush
	public boolean FH = false; // full house
	public boolean FK = false; // four of a kind
	public boolean SF = false; // straight flush
	public boolean RF = false; // royal flush
	
	// Hand storage
	public Card pair[] = null;
	public Card twoPairs[] = null;
	public Card threeKind[] = null;
	public Card straight[] = null;
	public Card flush[] = null;
	public Card fullHouse[] = null;
	public Card fourKind[] = null;
	public Card sFlush[] = null;
	public Card rFlush[] = null;
	
	/**
	 * Empty Constructor
	 */
	public Hand() {
		
	}
	
	/**
	 * Specific Constructor
	 * @param c1
	 * @param c2
	 * @param c3
	 * @param c4
	 * @param c5
	 */
	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
			cards[0] = c1;
			cards[1] = c2;
			cards[2] = c3;
			cards[3] = c4;
			cards[4] = c5;
			rateHand();
	}
	
	/**
	 * Array constructor
	 * @param h
	 */
	public Hand(Card h[]) {
		if(h.length == 5) {
			cards = h;
			rateHand();
		}
		else {
			System.out.println("Hand must contain 5 cards.");
		}
	}
	
	public Card[] getCards() {
		return cards;
	}
	
	/**
	 * rates the hand
	 */
	public void rateHand() {
		highest = selectionSort(cards)[4];
		pair = checkForPair(cards);
		twoPairs = checkForTwoPairs(cards);
		threeKind = checkForThreeOfAKind(cards);
		straight = checkForStraight(cards);
		flush = checkForFlush(cards);
		fullHouse = checkForFullHouse(cards);
		fourKind = checkForFourOfAKind(cards);
		sFlush = checkForStraightFlush(cards);
		rFlush = checkForRoyalFlush(cards);
	}
	
	/**
	 * Checks for pair
	 * @param ha
	 * @return
	 */
	public Card[] checkForPair(Card ha[]) {
		Card arr[] = new Card[2];
		Card cur = new Card();
		Card p = new Card();
		for(int i = 0; i < ha.length-1; i++) {
			cur = ha[i];
			for(int j = i+1; j < ha.length; j++) {
				p = ha[j];
				if(cur.getRank() == p.getRank()) {
					arr[0] = cur;
					arr[1] = p;
					OP = true;
					return arr;
				}
			}
		}
		return null;
	}
	
	/**
	 * Checks for two pairs
	 * @param ha
	 * @return
	 */
	public Card[] checkForTwoPairs(Card ha[]) {
		Card arr[] = new Card[4];
		Card temp[] = ha;
		Card firstPair[] = checkForPair(temp);
		if(firstPair == null) {
			return null;
		}

		Card secPair[] = new Card[2];
		temp = remove(temp, firstPair[0]);
		temp = remove(temp, firstPair[1]);
		secPair = checkForPair(temp);
		if(secPair == null) {
			return null;
		}
		
		arr[0] = firstPair[0];
		arr[1] = firstPair[1];
		arr[2] = secPair[0];
		arr[3] = secPair[1];
		TP = true;
		return arr;
	}
	
	/**
	 * checks for a three of a kind
	 * @param ha
	 * @return
	 */
	public Card[] checkForThreeOfAKind(Card ha[]) {
		Card arr[] = new Card[3];
		for(int i = 0; i < ha.length-2; i++) {
			
			for(int j = i+1; j < ha.length-1; j++) {
				if(ha[i].getRank() == ha[j].getRank()) {
					
					for(int k = j+1; k < ha.length; k++) {
						if(ha[j].getRank() == ha[k].getRank()) {
							arr[0] = ha[i];
							arr[1] = ha[j];
							arr[2] = ha[k];
							TK = true;
							return arr;
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * checks for straight
	 * @param ha
	 * @return
	 */
	public Card[] checkForStraight(Card ha[]) {
		Card sorted[] = selectionSort(ha);
		for(int i = 0; i < sorted.length-1; i++) {
			if(sorted[i+1].difference(sorted[i]) != 1) {
				return null;
			}
		}
		S = true;
		return sorted;
	}
	
	/**
	 * checks for a flush
	 * @param ha
	 * @return
	 */
	public Card[] checkForFlush(Card ha[]) {
		char suite = ha[0].getSuite();
		for(int i = 0; i < ha.length; i++) {
			if(suite != ha[i].getSuite()) {
				return null;
			}
		}
		F = true;
		return ha;
	}
	
	/**
	 * checks for a full house
	 * @param ha
	 * @return
	 */
	public Card[] checkForFullHouse(Card ha[]) {
		Card arr[] = new Card[5];
		Card temp[] = ha;
		Card three[] = checkForThreeOfAKind(temp);
		if(three == null) {
			return null;
		}
		temp = remove(temp, three[0]);
		temp = remove(temp, three[1]);
		temp = remove(temp, three[2]);
		Card two[] = checkForPair(temp);
		if(two == null) {
			return null;
		}
		arr[0] = three[0];
		arr[1] = three[1];
		arr[2] = three[2];
		arr[3] = two[0];
		arr[4] = two[1];
		FH = true;
		return arr;
	}
	
	/**
	 * checks for a four of a kind
	 * @param ha
	 * @return
	 */
	public Card[] checkForFourOfAKind(Card ha[]) {
		Card arr[] = new Card[4];
		for(int i = 0; i < ha.length-3; i++) {
			
			for(int j = i+1; j < ha.length-2; j++) {
				if(ha[i].getRank() == ha[j].getRank()) {
					
					for(int k = j+1; k < ha.length-1; k++) {
						if(ha[j].getRank() == ha[k].getRank()) {
							
							for(int l = k+1; l < ha.length; l++) {
								if(ha[k].getRank() == ha[l].getRank()) {
									arr[0] = ha[i];
									arr[1] = ha[j];
									arr[2] = ha[k];
									arr[3] = ha[l];
									FK = true;
									return arr;
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * checks for a straight flush
	 * @param ha
	 * @return
	 */
	public Card[] checkForStraightFlush(Card ha[]) {
		Card flush[] = checkForFlush(ha);
		Card straight[] = checkForStraight(ha);
		if(flush == null || straight == null) {
			return null;
		}
		SF = true;
		return flush;
	}
	
	/**
	 * checks for a royal flush
	 * @param ha
	 * @return
	 */
	public Card[] checkForRoyalFlush(Card ha[]) {
		Card sorted[] = selectionSort(ha);
		Card flush[] = checkForFlush(ha);
		if(flush == null) {
			return null;
		}
		for(int i = 0; i < 5; i++) {
			if(sorted[i].getIntRank() != 10+i) {
				return null;
			}
		}
		RF = true;
		return flush;
	}
	
	/**
	 * Sorts array of Cards
	 * @param ha
	 * @return
	 */
	public Card[] selectionSort(Card ha[]) {
		Card t[] = ha;
		int min;
		for(int i = 0; i < t.length-1; i++) {
			min = i;
			for(int j = i+1; j < t.length; j++) {
				if(t[j].compare(t[min]) == -1) {
					min = j;
				}
			}
			if(min != i) {
				Card temp = t[i];
				t[i] = t[min];
				t[min] = temp;
			}
		}
		return t;
	}
	
	/**
	 * removes all instances of a Card from an array
	 * @param main
	 * @param r
	 * @return
	 */
	public Card[] remove(Card main[], Card r) {
		ArrayList<Card> n = new ArrayList<Card>();
		for(int i = 0; i < main.length; i++) {
			if(!r.isEqual(main[i], r)) {
				n.add(main[i]);
			}
		}
		return n.toArray(new Card[main.length-1]);
	}
	
	public Card max(Card arr[]) {
		Card max = new Card();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].compare(max) == 1) {
				max = arr[i];
			}
		}
		return max;
	}
	
	/**
	 * returns a string of the hand
	 * displays as cards seperated by spaces ex) 3H 5D QH KC JH
	 */
	public String toString() {
		return new String(cards[0].toString() + " " + cards[1].toString() + " " + cards[2].toString() + " " + cards[3].toString() + " " + cards[4].toString());
	}
}
