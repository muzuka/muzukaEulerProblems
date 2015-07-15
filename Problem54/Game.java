
/**
 * Manages a game between hands.
 * @started August 6, 2013
 * @author seanbrown
 *
 */
public class Game {
	private Hand player1;
	private Hand player2;
	
	/**
	 * empty constructor
	 */
	public Game() {
		
	}
	
	/**
	 * Hand constructor
	 * @param p1
	 * @param p2
	 */
	public Game(Hand p1, Hand p2) {
		this.player1 = p1;
		this.player2 = p2;
	}
	
	/**
	 * Determines winner by highest card rank
	 * @return
	 */
	public int tiebreaker() {
		Card sorted1[] = player1.selectionSort(player1.getCards());
		Card sorted2[] = player2.selectionSort(player2.getCards());
		for(int i = sorted1.length-1; i >= 0; i--) {
			if(sorted1[i].getIntRank() > sorted2[i].getIntRank()) {
				return 1;
			}
			else if(sorted1[i].getIntRank() < sorted2[i].getIntRank()) {
				return 2;
			}
		}
		return 0;
	}
	
	/**
	 * Determines the winning poker hand
	 * @return
	 */
	public int versus() {
		if(player1.RF || player2.RF) {
			print("royal flush");
			if(player1.RF && !player2.RF) {
				return 1;
			}
			else if(!player1.RF && player2.RF) {
				return 2;
			}
			else {
				return 0;
			}
		}
		else if(player1.SF || player2.SF) {
			print("straight flush");
			if(player1.SF && !player2.SF) {
				return 1;
			}
			else if(!player1.SF && player2.SF) {
				return 2;
			}
			else {
				if(player1.max(player1.sFlush).getIntRank() > player2.max(player2.sFlush).getIntRank()) {
					return 1;
				}
				else if(player1.max(player1.sFlush).getIntRank() < player2.max(player2.sFlush).getIntRank()) {
					return 2;
				}
				else {
					return tiebreaker();
				}
			}
		}
		else if(player1.FK || player2.FK) {
			print("four of a kind");
			if(player1.FK && !player2.FK) {
				return 1;
			}
			else if(!player1.FK && player2.FK) {
				return 2;
			}
			else {
				if(player1.fourKind[0].compare(player2.fourKind[0]) == 0){
					return tiebreaker();
				}
				else if(player1.fourKind[0].compare(player2.fourKind[0]) == 1) {
					return 1;
				}
				else {
					return 2;
				}
			}
		}
		else if(player1.FH || player2.FH) {
			print("full house");
			if(player1.FH && !player2.FH) {
				return 1;
			}
			else if(!player1.FH && player2.FH) {
				return 2;
			}
			else {
				// if player1 3Kind is better than pair
				if(player1.fullHouse[0].getIntRank() > player1.fullHouse[3].getIntRank()) {
					// if player2 3Kind is better than pair
					if(player2.fullHouse[0].getIntRank() > player2.fullHouse[3].getIntRank()) {
						// if player1 3Kind is better than player2 3Kind
						if(player1.fullHouse[0].getIntRank() > player2.fullHouse[0].getIntRank()) {
							return 1;
						}
						// if player2 3Kind is better than player1 3Kind
						else if(player1.fullHouse[0].getIntRank() < player2.fullHouse[0].getIntRank()) {
							return 2;
						}
						// else both 3Kind are equal
						else {
							// if player1 pair is better than player2 pair
							if(player1.fullHouse[3].getIntRank() > player2.fullHouse[3].getIntRank()) {
								return 1;
							}
							// if player2 pair is better than player1 pair
							else if(player1.fullHouse[3].getIntRank() < player2.fullHouse[3].getIntRank()) {
								return 2;
							}
							// else both pairs are equal
							else {
								return tiebreaker();
							}
						}
					}
					// if player2 pair is better than 3Kind
					else if(player2.fullHouse[0].getIntRank() < player2.fullHouse[3].getIntRank()) {
						// if player1 pair is better than player2 pair
						if(player1.fullHouse[3].getIntRank() > player2.fullHouse[3].getIntRank()) {
							return 1;
						}
						// if player2 pair is better than player1 pair
						else if(player1.fullHouse[3].getIntRank() < player2.fullHouse[3].getIntRank()) {
							return 2;
						}
						// else both pairs are equal
						else {
							// if player1 3Kind is better than player2 3Kind
							if(player1.fullHouse[0].getIntRank() > player2.fullHouse[0].getIntRank()) {
								return 1;
							}
							// if player2 3Kind is better than player1 3Kind
							else if(player1.fullHouse[0].getIntRank() < player2.fullHouse[0].getIntRank()) {
								return 2;
							}
							// else both 3Kind are equal
							else {
								return tiebreaker();
							}
						}
					}
					// else both player2 3Kind and pair are equal
					else {
						return tiebreaker();
					}
				}
				// if player1 pair is better than 3Kind
				else if(player1.fullHouse[0].getIntRank() < player1.fullHouse[3].getIntRank()) {
					// if player2 3Kind is better than player2 pair
					if(player2.fullHouse[0].getIntRank() > player2.fullHouse[3].getIntRank()) {
						// if player1 pair is better than player2 3Kind
						if(player1.fullHouse[3].getIntRank() > player2.fullHouse[0].getIntRank()) {
							return 1;
						}
						// if player2 3Kind is better than player1 pair
						else if(player1.fullHouse[3].getIntRank() < player2.fullHouse[0].getIntRank()) {
							return 2;
						}
						// else player2 3Kind and player1 pair are equal
						else {
							if(player1.fullHouse[0].getIntRank() > player2.fullHouse[3].getIntRank()) {
								return 1;
							}
							else if(player1.fullHouse[0].getIntRank() < player2.fullHouse[3].getIntRank()) {
								return 2;
							}
							else {
								return tiebreaker();
							}
						}
					}
					// if player2 pair is better than player2 3Kind
					else if(player2.fullHouse[0].getIntRank() < player2.fullHouse[3].getIntRank()) {
						// if player1 pair is better than player2 pair
						if(player1.fullHouse[3].getIntRank() > player2.fullHouse[3].getIntRank()) {
							return 1;
						}
						// if player2 pair is better than player1 pair
						else if(player1.fullHouse[3].getIntRank() < player2.fullHouse[3].getIntRank()) {
							return 2;
						}
						// else player1 pair is equal to player2 pair
						else {
							if(player1.fullHouse[0].getIntRank() > player2.fullHouse[0].getIntRank()) {
								return 1;
							}
							else if(player1.fullHouse[0].getIntRank() < player2.fullHouse[0].getIntRank()) {
								return 2;
							}
							else {
								return tiebreaker();
							}
						}
					}
					// else player2 pair and 3Kind are equal
					else {
						return tiebreaker();
					}
				}
				// else both player1 pair and 3Kind are equal
				else {
					return tiebreaker();
				}
			}
		}
		else if(player1.F || player2.F) {
			print("flush");
			if(player1.F && !player2.F) {
				return 1;
			}
			else if(!player1.F && player2.F) {
				return 2;
			}
			else {
				return tiebreaker();
			}
		}
		else if(player1.S || player2.S) {
			print("straight");
			if(player1.S && !player2.S) {
				return 1;
			}
			else if(!player1.S && player2.S) {
				return 2;
			}
			else {
				return tiebreaker();
			}
		}
		else if(player1.TK || player2.TK) {
			print("three of a kind");
			if(player1.TK && !player2.TK) {
				return 1;
			}
			else if(!player1.TK && player2.TK) {
				return 2;
			}
			else {
				if(player1.threeKind[0].getIntRank() > player2.threeKind[0].getIntRank()) {
					return 1;
				}
				else if(player1.threeKind[0].getIntRank() < player2.threeKind[0].getIntRank()) {
					return 2;
				}
				else {
					return tiebreaker();
				}
			}
		}
		else if(player1.TP || player2.TP) {
			print("two pairs");
			if(player1.TP && !player2.TP) {
				return 1;
			}
			else if(!player1.TP && player2.TP) {
				return 2;
			}
			else {
				if(player1.twoPairs[0].getIntRank() > player1.twoPairs[2].getIntRank()) {
					if(player2.twoPairs[0].getIntRank() > player2.twoPairs[2].getIntRank()) {
						if(player1.twoPairs[0].getIntRank() > player2.twoPairs[0].getIntRank()) {
							return 1;
						}
						else if(player1.twoPairs[0].getIntRank() < player2.twoPairs[0].getIntRank()) {
							return 2;
						}
						else {
							if(player1.twoPairs[2].getIntRank() > player2.twoPairs[2].getIntRank()) {
								return 1;
							}
							else if(player1.twoPairs[2].getIntRank() < player2.twoPairs[2].getIntRank()) {
								return 2;
							}
							else {
								return tiebreaker();
							}
						}
					}
					else if(player2.twoPairs[0].getIntRank() < player2.twoPairs[2].getIntRank()) {
						if(player1.twoPairs[0].getIntRank() > player2.twoPairs[2].getIntRank()) {
							return 1;
						}
						else if(player1.twoPairs[0].getIntRank() < player2.twoPairs[2].getIntRank()) {
							return 2;
						}
						else {
							if(player1.twoPairs[2].getIntRank() > player2.twoPairs[0].getIntRank()) {
								return 1;
							}
							else if(player1.twoPairs[2].getIntRank() < player2.twoPairs[0].getIntRank()) {
								return 2;
							}
							else {
								return tiebreaker();
							}
						}
					}
					else {
						return tiebreaker();
					}
				}
				else if(player1.twoPairs[0].getIntRank() < player1.twoPairs[2].getIntRank()) {
					if(player2.twoPairs[0].getIntRank() > player2.twoPairs[2].getIntRank()) {
						if(player1.twoPairs[2].getIntRank() > player2.twoPairs[0].getIntRank()) {
							return 1;
						}
						else if(player1.twoPairs[2].getIntRank() < player2.twoPairs[0].getIntRank()) {
							return 2;
						}
						else {
							if(player1.twoPairs[0].getIntRank() > player2.twoPairs[2].getIntRank()) {
								return 1;
							}
							else if(player1.twoPairs[0].getIntRank() < player2.twoPairs[2].getIntRank()) {
								return 2;
							}
							else {
								return tiebreaker();
							}
						}
					}
					else if(player2.twoPairs[0].getIntRank() < player2.twoPairs[2].getIntRank()) {
						if(player1.twoPairs[2].getIntRank() > player2.twoPairs[2].getIntRank()) {
							return 1;
						}
						else if(player1.twoPairs[2].getIntRank() < player2.twoPairs[2].getIntRank()) {
							return 2;
						}
						else {
							if(player1.twoPairs[0].getIntRank() > player2.twoPairs[0].getIntRank()) {
								return 1;
							}
							else if(player1.twoPairs[0].getIntRank() < player2.twoPairs[0].getIntRank()) {
								return 2;
							}
							else {
								return tiebreaker();
							}
						}
					}
					else {
						return tiebreaker();
					}
				}
				else {
					return tiebreaker();
				}
			}
		}
		else if(player1.OP || player2.OP) {
			print("pair");
			if(player1.OP && !player2.OP) {
				return 1;
			}
			else if(!player1.OP && player2.OP) {
				return 2;
			}
			else {
				if(player1.pair[0].compare(player2.pair[0]) == 0){
					return tiebreaker();
				}
				else if(player1.pair[0].compare(player2.pair[0]) == 1) {
					return 1;
				}
				else {
					return 2;
				}
			}
		}
		else {
			print("highest");
			return tiebreaker();
		}
	}
	
	public void print(String message) {
		System.out.println(message);
	}
	
	/**
	 * Returns string representation of a game of Poker
	 * Player 1's hand + Player 2's hand
	 */
	public String toString() {
		return player1.toString() + " " + player2.toString();
	}
}
