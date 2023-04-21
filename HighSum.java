import java.util.ArrayList;
import java.util.Scanner;

public class HighSum {
	private Deck deck;
	private ArrayList<Card> GameCards;
	
	public int playerpot = 100;
	public int dealerpot = 100;
	public int minbet = 10;
	static String username = "jack";
	static String password = "mypassword";
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		HighSum game = new HighSum();
		Scanner scanner = new Scanner(System.in);
		boolean isLoggedIn = false;

		while (!isLoggedIn) {
			System.out.println("Enter login: ");
			String inputUsername = scanner.nextLine();
			System.out.println("Enter password: ");
			String inputPassword = scanner.nextLine();

			if (inputUsername.equals(username) && inputPassword.equals(password)) {
				isLoggedIn = true;
				game.game(); // Start Game if user enter correct credentials
			} else {
				System.out.println("Invalid user, Please try again");
				main(args);
			}
		}
		scanner.close();
	}

	public HighSum() {
		deck = new Deck();
		GameCards = new ArrayList<Card>();

	}

	public void game() {
		HighSum game = new HighSum();
		System.out.println("Welcome to the game!");
		System.out.println("================================================================================");
		System.out.println("Jack, you have " + playerpot + " Chips");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Game Starts Dealer shuffling deck");
		System.out.println("--------------------------------------------------------------------------------");
		// Shuffle the deck
		deck.shuffle();        

		// Deal two cards to each player, alternating between player and dealer
		for (int i = 0; i < 2; i++) {
			GameCards.add(deck.drawCard()); // rnd1
			GameCards.add(deck.drawCard()); // rnd2
		}
		// Round 1
		System.out.println("Round 1");
		System.out.println("--------------------------------------------------------------------------------");
		// extract card value from players and dealer hand
		int playerFirstCard = GameCards.get(0).getValue();
		int dealerFirstCard = GameCards.get(1).getValue();
		int playerSecondCard = GameCards.get(2).getValue();
		int dealerSecondCard = GameCards.get(3).getValue();
		System.out.println("Dealer's cards: <Hidden Card>"+  GameCards.get(3));
		System.out.println("Total value  : "
				+  dealerSecondCard );
		System.out.println();
		System.out.println("Your cards: " + GameCards.get(0) + " " + GameCards.get(2));
		System.out.println("Total value : " + (playerFirstCard + playerSecondCard ));
		// condition to check if player 2nd card is larger then dealer second card
		if (playerSecondCard > dealerSecondCard) {
			System.out.println("You have the highest Second card. Player Call to bet");
			String minbet = scanner.next();
			if (minbet.equals("10")) {
				playerpot = playerpot - 10; // get player's bet from input
				dealerpot = dealerpot - 10;
				System.out.println("you are left with " + playerpot + " chips");
				System.out.println("total pot on table : " + 20 + " Chips");
				System.out.println("--------------------------------------------------------------------------------");
			} else {
				System.exit(0);
				System.out.println("Invalid amount. Please enter 10 chips.");
			}
		} else if (dealerSecondCard > playerSecondCard) {
			System.out.println(
					"Dealer has the highest second card. Dealer call bet : [10 chips]  You need to follow the dealer call. [F] to follow");
			String F = scanner.next(); // get player bet from input
			dealerpot = dealerpot - 10;
			playerpot = playerpot - 10;
			int tablepot = 20;
			if (F.equalsIgnoreCase("F")) {
				// advance to next round ;
				System.out.println("Jack, You left with " + playerpot + " Chips");
				System.out.println("total pot on table : " + tablepot + " Chips");
				System.out.println("Continue to next Round");
				System.out.println("--------------------------------------------------------------------------------");
			} else {
				System.out.println("Rules dosen't apply");
				System.exit(0);
			}
		}

		// ROUND 2
		// Deal two cards to each player, alternating between player and dealer
				for (int i = 0; i < 2; i++) {
					GameCards.add(deck.drawCard()); // rnd1
					GameCards.add(deck.drawCard()); // rnd2
				}
		int playerThirdCard = GameCards.get(4).getValue();
		int dealerThirdCard = GameCards.get(5).getValue();
		System.out.println("Round 2");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Dealer's cards: <Hidden Card> "  + GameCards.get(3) + " " + GameCards.get(5));
		System.out.println("Total value  : "
				+  (dealerSecondCard + dealerThirdCard ));
		System.out.println();
		System.out.println("your cards :" + GameCards.get(0) + " " + GameCards.get(2) + " " + GameCards.get(4));
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Total Card value: " + (playerFirstCard + playerSecondCard + playerThirdCard));
		if (playerThirdCard > dealerThirdCard) {
			System.out.println("You have the highest Third card. How much do you want to bet?");
			String minbet = scanner.next();
			playerpot = playerpot - 10;// get player's bet from input
			dealerpot = dealerpot - 10;
			int tablepot = 40;
			System.out.println("Jack, You left with " + playerpot + " Chips");
			System.out.println("total pot on table " + tablepot + " Chips");
			System.out.println("--------------------------------------------------------------------------------");

		} else {
			System.out.println(
					"Dealer has the highest second card. Dealer call bet : [10 chips],  [F] to follow, [N]o to Quit : ");
			String F = scanner.next();
			playerpot = playerpot - 10;// get player's bet from input
			dealerpot = dealerpot - 10;
			int tablepot = 40;
			if (F.equals("F")) {
				// advance to next round ;
				System.out.println("Jack, You left with " + playerpot + " Chips");
				System.out.println("total pot on table " + tablepot + " Chips");
				System.out.println("Continue to next Round");
				System.out.println("--------------------------------------------------------------------------------");
				// End game Round 2
			} else {
				System.out.println("You have left the game");
				System.out.println("Dealer have won the game with winning : " + 20 + " Chips from the pot");
				System.exit(0);

			}
		}

		// round 3
		// Deal two cards to each player, alternating between player and dealer
				for (int i = 0; i < 2; i++) {
					GameCards.add(deck.drawCard()); // rnd1
					GameCards.add(deck.drawCard()); // rnd2
				}
		int playerFourthCard = GameCards.get(6).getValue();
		int dealerFourthCard = GameCards.get(7).getValue();
		System.out.println("Round 3");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(
				"Dealer's cards: <Hidden Card> " +  GameCards.get(3) + " " + GameCards.get(5) + GameCards.get(7));
		System.out.println("Total value  : "
				+ ( dealerSecondCard + dealerThirdCard + dealerFourthCard ));
		System.out.println();
		System.out.println("your cards :" + GameCards.get(0) + " " + GameCards.get(2) + " " + GameCards.get(4)
				+ GameCards.get(6));
		System.out.println("Value : " + (playerFirstCard + playerSecondCard + playerThirdCard + playerFourthCard));
		System.out.println("--------------------------------------------------------------------------------");
		if (playerFourthCard > dealerFourthCard) {
			
			System.out.println("You have the highest Fourth card. How much do you want to bet?");
			String minbet = scanner.next();
			playerpot = playerpot - 10;// get player's bet from input
			dealerpot = dealerpot - 10;
			int tablepot = 60;
			System.out.println("Jack, You left with " + playerpot);
			System.out.println("total bet on table " + tablepot);
		} else {
			System.out.println(
					"\"Dealer has the highest Fourth card. Dealer call bet : [10 chips]  You need to follow the dealer call. [F] to follow, [N]o to Quit ");
			String F = scanner.next();
			playerpot = playerpot - 10;// get player's bet from input
			dealerpot = dealerpot - 10;
			int tablepot = 60;
			if (F.equals("F")) {
				// advance to next round ;
				System.out.println("Jack, You left with " + playerpot);
				System.out.println("total bet on table " + tablepot);
				System.out.println("Continue to next Round");
				System.out.println("--------------------------------------------------------------------------------");
				// End game Round 3
			} else {
				System.out.println("You have left the game");
				dealerpot = tablepot + dealerpot;
				System.out.println("Dealer have won the game with winning : " + tablepot + " Chips from the pot");
				System.exit(0);

			}
		}

		// round 4
		// Deal two cards to each player, alternating between player and dealer
				for (int i = 0; i < 2; i++) {
					GameCards.add(deck.drawCard()); // rnd1
					GameCards.add(deck.drawCard()); // rnd2
				}
		int playerFifthCard = GameCards.get(8).getValue();
		int dealerFifthCard = GameCards.get(9).getValue();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Round 4");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Dealer's cards: <Hidden Card>"  + GameCards.get(3) + " " + GameCards.get(5)
				+ GameCards.get(7) + GameCards.get(9));
		System.out.println();
		System.out.println("your cards :" + GameCards.get(0) + " " + GameCards.get(2) + " " + GameCards.get(4)
				+ GameCards.get(6) + GameCards.get(8));
		if (playerFifthCard > dealerFifthCard) {
			System.out.println("You have the highest Fifth card. How much do you want to bet?");
			String minbet = scanner.next();
			playerpot = playerpot - 10;// get player's bet from input
			dealerpot = dealerpot - 10;
			int tablepot = 80;
			System.out.println("Jack, You left with " + playerpot);
			System.out.println("total bet on table " + tablepot);
		} else {
			System.out.println(
					"Dealer has the highest Fifth card. Dealer call bet : [10 chips]  You need to follow the dealer call. [F] to follow, [N]o to Quit ");
			String F = scanner.next();
			playerpot = playerpot - 10;// get player's bet from input
			dealerpot = dealerpot - 10;
			int tablepot = 80;
			if (F.equals("F")) {
				// advance to next round ;
				System.out.println("Jack, You left with " + playerpot);
				System.out.println("total bet on table " + tablepot);
				System.out.println("Continue to next Round");
				// End game Round 3
			} else {
				System.out.println("You have left the game");
				dealerpot = tablepot + dealerpot;
				System.out.println("Dealer have won the game with winning : " + tablepot + " Chips from the pot");
				System.exit(0);
			}
		}

		// game Round ends here
		//dealerCards.add(deck.drawCard());
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Round End Dealer reveals cards");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Dealer's cards:" + GameCards.get(1) + GameCards.get(3) + " " + GameCards.get(5)
				+ GameCards.get(7) + GameCards.get(9));
		System.out.println("Total value  : "
				+ (dealerFirstCard+ dealerSecondCard + dealerThirdCard + dealerFourthCard + dealerFifthCard));
		System.out.println();
		System.out.println("your cards :" );
		System.out.println(GameCards.get(0) + " " + GameCards.get(2) + " " + GameCards.get(4)
		+ GameCards.get(6) + GameCards.get(8));
		System.out.println("Total value : "
				+ (playerFirstCard + playerSecondCard + playerThirdCard + playerFourthCard + playerFifthCard));
		System.out.println();
		if (playerFirstCard + playerSecondCard + playerThirdCard + playerFourthCard + playerFifthCard > dealerFirstCard + dealerSecondCard + dealerThirdCard + dealerFourthCard + dealerFifthCard) {
			System.out.println("Jack Won the game , 40 Chips from pot");
			System.out.println("Jack,Total chips : 140 Chips");
			System.out.println("dealer shuffles used card and place behind the deck");
			deck.shuffle();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Start a new game ? [Y]es or [N]o");
			String Y = scanner.next();
			if (Y.equalsIgnoreCase("Y")){
				game.game();;
			}
			else {
				System.out.println("You have exited the game");
				System.exit(0);
			}
		}
		else {
			System.out.println("Dealer Won the game , 40 Chips from pot");
			System.out.println("dealer shuffles used card and place behind the deck");
			deck.shuffle();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Start a new game ? [Y]es or [N]o");
			String Y = scanner.next();
			if (Y.equalsIgnoreCase("Y")){
				game.game();;
			}
			else {
				System.out.println("You have exited the game");
				System.exit(0);
			}
		}
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);
		boolean continuePlaying = true;

		while (continuePlaying) {
			// game logic here
			System.out.println("Do you want to continue playing? (y/n)");
			String input = scanner.nextLine();
			if (input.equals("n")) {
				continuePlaying = false;
			}
		}
		System.out.println("Thanks for playing!");
	}
}

