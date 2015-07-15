
import java.util.Scanner;
import java.io.*;

/**
 * Runs program
 * @started August 6, 2013
 * @author seanbrown
 *
 */
public class Problem54 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner fileReader = new Scanner(System.in);
		try {
			fileReader = new Scanner(new File("poker.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		String card;
		int p1tally = 0;
		int p2tally = 0;
		int result;
		Card p1[] = new Card[5];
		Card p2[] = new Card[5];
		Hand player1;
		Hand player2;
		Game pokerGame;
		
		for(int j = 0; j < 1000; j++) {
			for(int i = 0; i < 10; i++) {
				// player 2
				if(i > 4 && i < 10) {
					card = fileReader.next();
					p2[i-5] = new Card(card);
				
				}
				// player 1
				else if(i <= 4 && i >= 0) {
					card = fileReader.next();
					p1[i] = new Card(card);
				}
			}
			player1 = new Hand(p1);
			player2 = new Hand(p2);
			pokerGame = new Game(player1, player2);
			result = pokerGame.versus();
			if(result == 1) {
				p1tally++;
			}
			else {
				p2tally++;
			}
		}
		System.out.println(p1tally);
		System.out.println(p2tally);
	}
}
