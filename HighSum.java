import java.util.ArrayList;
import java.util.Scanner;

public class HighSum {
	private Deck deck;
	private ArrayList<Card> GameCards;
	
	public int playerpot = 100;
	public int dealerpot = 100;
	public int minbet = 10;
	private static String username = "jack";
	static String password = "mypassword";
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("HighSum GAME");
		System.out.println("================================================================================");
		login();
		
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
		System.out.println("Dealer's cards: <Hidden Card>" + GameCards.get(3));
		System.out.println();
		System.out.println("Your cards: " + GameCards.get(0) + " " + GameCards.get(2));
		System.out.println("Total value : " + (playerFirstCard + playerSecondCard));
		// condition to check if player 2nd card is larger then dealer second card
		rnd1Chker();

		// -------------------------------------------------------------------------------
		// ROUND 2
		// -------------------------------------------------------------------------------//
		// Deal two cards to each player, alternating between player and dealer
		for (int i = 0; i < 2; i++) {
			GameCards.add(deck.drawCard()); // deal cards rnd2
		}
		int playerThirdCard = GameCards.get(4).getValue();
		int dealerThirdCard = GameCards.get(5).getValue();
		System.out.println("Round 2");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Dealer's cards: <Hidden Card> " + GameCards.get(3) + " " + GameCards.get(5));
		System.out.println();
		System.out.println("your cards :" + GameCards.get(0) + " " + GameCards.get(2) + " " + GameCards.get(4));
		System.out.println("Total Card value: " + (playerFirstCard + playerSecondCard + playerThirdCard));
		System.out.println("--------------------------------------------------------------------------------");
		rnd2Chker();

		// -------------------------------------------------------------------------------
		// ROUND 3
		// -------------------------------------------------------------------------------//
		// Deal two cards to each player, alternating between player and dealer
		for (int i = 0; i < 2; i++) {
			GameCards.add(deck.drawCard()); // deal cards rnd3
		}
		int playerFourthCard = GameCards.get(6).getValue();
		int dealerFourthCard = GameCards.get(7).getValue();
		System.out.println("Round 3");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(
				"Dealer's cards: <Hidden Card> " + GameCards.get(3) + " " + GameCards.get(5) + GameCards.get(7));
		System.out.println();
		System.out.println(
				"your cards :" + GameCards.get(0) + " " + GameCards.get(2) + " " + GameCards.get(4) + GameCards.get(6));
		System.out.println("Value : " + (playerFirstCard + playerSecondCard + playerThirdCard + playerFourthCard));
		System.out.println("--------------------------------------------------------------------------------");
		rnd3Chker();

		// -------------------------------------------------------------------------------
		// ROUND 4
		// -------------------------------------------------------------------------------//
		// Deal two cards to each player, alternating between player and dealer
		for (int i = 0; i < 2; i++) {
			GameCards.add(deck.drawCard());
		} //
		int playerFifthCard = GameCards.get(8).getValue();
		int dealerFifthCard = GameCards.get(9).getValue();
		System.out.println("Round 4");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Dealer's cards: <Hidden Card>" + GameCards.get(3) + " " + GameCards.get(5)
				+ GameCards.get(7) + GameCards.get(9));
		System.out.println();
		System.out.println("your cards :" + GameCards.get(0) + " " + GameCards.get(2) + " " + GameCards.get(4)
				+ GameCards.get(6) + GameCards.get(8));
		System.out.println("Player Value : "
				+ (playerFirstCard + playerSecondCard + playerThirdCard + playerFourthCard + playerFifthCard));
		System.out.println("--------------------------------------------------------------------------------");
		rnd4Chker();

		// game Round ends here
		System.out.println("Card end game card reveals");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Dealer's cards: " + GameCards.get(1) + GameCards.get(3) + " " + GameCards.get(5)
				+ GameCards.get(7) + GameCards.get(9));
		System.out.println("Dealer Value : "
				+ (dealerFirstCard + dealerSecondCard + dealerThirdCard + dealerFourthCard + dealerFifthCard));
		System.out.println();
		System.out.println("your cards :" + GameCards.get(0) + " " + GameCards.get(2) + " " + GameCards.get(4)
				+ GameCards.get(6) + GameCards.get(8));
		System.out.println("Player Value : "
				+ (playerFirstCard + playerSecondCard + playerThirdCard + playerFourthCard + playerFifthCard));
		System.out.println("--------------------------------------------------------------------------------");
		while (playerFirstCard + playerSecondCard + playerThirdCard + playerFourthCard
				+ playerFifthCard > dealerFirstCard + dealerSecondCard + dealerThirdCard + dealerFourthCard
						+ dealerFifthCard) {
			System.out.println("Player won the game , win 40 Chips from pot");
			System.out.println("Player left with " + 140);
			break;

		}
		while (dealerFirstCard + dealerSecondCard + dealerThirdCard + dealerFourthCard
				+ dealerFifthCard > playerFirstCard + playerSecondCard + playerThirdCard + playerFourthCard
						+ playerFifthCard) {
			System.out.println("Dealer Won the game , win 40 Chips from pot");
			System.out.println("dealer left with" + 140);
			System.out.println("dealer shuffles used card and place behind the deck");
			break;
		}
		while (dealerFirstCard + dealerSecondCard + dealerThirdCard + dealerFourthCard
				+ dealerFifthCard == playerFirstCard + playerSecondCard + playerThirdCard + playerFourthCard
						+ playerFifthCard) {
			System.out.println("games is a tied");
			System.out.println("player get back his pots at " + 40 + " Chips");
			System.out.println("dealer get back his pots at " + 40 + " Chips");
			break;
		}
		System.out.println("--------------------------------------------------------------------------------");
		String Y;
		do {
			Y = Keyboard.readString("Start a new game? [Y]es or [N]o: ");
			if (Y.equalsIgnoreCase("Y")) {
				game.game();
			} else if (Y.equalsIgnoreCase("N")) {
				System.out.println("You have exited the game");
				main(null);
			} else {
				System.out.println("Invalid input. Please enter [Y]es or [N]o.");
			}
		} while (!Y.equalsIgnoreCase("Y") && !Y.equalsIgnoreCase("N"));
	}

	public void rnd1Chker() {
		int playerSecondCard = GameCards.get(2).getValue();
		int dealerSecondCard = GameCards.get(3).getValue();
	
		while (playerSecondCard > dealerSecondCard) {
			String C = Keyboard.readString(
					"You have the highest Second card. Player Call to bet, Do you want to [C]all or [Q]uit?:");
			if (C.equalsIgnoreCase("C")) {
				int betAmount;
				do {
					betAmount = Keyboard.readInt("Enter bet amount (must be 10 chips): ");
					if (betAmount != 10) {
						System.out.println("Invalid bet amount. Please try again with 10 chips.");
					}
				} while (betAmount != 10);
				playerpot = playerpot - 10;
				dealerpot = dealerpot - 10;
				int tablepot = 20;
				System.out.println("Jack, You left with " + playerpot + " Chips");
				System.out.println("Total pot on table " + tablepot + " Chips");
				System.out.println("--------------------------------------------------------------------------------");
				break;
			} else {
				System.out
						.println("Invalid input, please enter only can choose to [[C]all,  please try again");
			}
		}

		while (dealerSecondCard > playerSecondCard) {
			System.out.println("Dealer has the highest Second card and Dealer call, state bet : " + minbet);
			String F = Keyboard.readString("[F]ollow to follow the dealer call. ");
			playerpot = playerpot - 10;// get player's bet from input
			dealerpot = dealerpot - 10;
			int tablepot = 20;
			if (F.equalsIgnoreCase("F")) {
				// advance to next round ;
				System.out.println("Jack, You left with " + playerpot);
				System.out.println("total bet on table " + tablepot);
				System.out.println("Continue to next Round");
				System.out.println("--------------------------------------------------------------------------------");
				break;
				// End game Round 3
			} else {
				System.out.println("Invalid input, please enter only can choose to [F]ollow");
			}
		}
	}

	public void rnd2Chker() {
		int playerThirdCard = GameCards.get(4).getValue();
		int dealerThirdCard = GameCards.get(5).getValue();
		while (playerThirdCard > dealerThirdCard) {
			String C = Keyboard.readString(
					"You have the highest Third card. How much do you want to bet, Do you want to [C]all or [Q]uit?:");
			if (C.equalsIgnoreCase("C")) {
				int betAmount;
				do {
					betAmount = Keyboard.readInt("Enter bet amount (must be 10 chips): ");
					if (betAmount != 10) {
						System.out.println("Invalid bet amount. Please try again with 10 chips.");
					}
				} while (betAmount != 10);
				playerpot = playerpot - 10;
				int tablepot = 40;
				System.out.println("Jack, You left with " + playerpot + " Chips");
				System.out.println("Total pot on table " + tablepot + " Chips");
				System.out.println("--------------------------------------------------------------------------------");
				break;
			} else if (C.equalsIgnoreCase("Q")) {
				int tablepot = 40;
				System.out.println("Quit option selected. player have quitted");
				System.out.println("Dealer have won the game with winning : " + tablepot + " Chips from Total pot");
				main(null);
			}
		}
		while (dealerThirdCard > playerThirdCard) {
			System.out.println("Dealer has the highest Third card and Dealer call, state bet : " + minbet);
			String F = Keyboard.readString("Do you want to [F] ollow or [Q]uit : ");
			int tablepot = 40;
			if (F.equalsIgnoreCase("F")) {
				playerpot = playerpot - 10;
				// advance to next round ;
				System.out.println("Jack, You left with " + playerpot);
				System.out.println("total bet on table " + tablepot);
				System.out.println("Continue to next Round");
				System.out.println("--------------------------------------------------------------------------------");
				break;
				// End game Round 3
			} else if (F.equalsIgnoreCase("Q")) {
				System.out.println("You have left the game");
				dealerpot = tablepot + dealerpot;
				System.out.println("Dealer have won the game with winning : " + tablepot + " Chips from Total pot");
				main(null);
			} else {
				System.out.println("Invalid input, please enter only can choose to [F]ollow, or [Q]uit.");
			}
		}
	}

	public void rnd3Chker() {
		int playerFourthCard = GameCards.get(6).getValue();
		int dealerFourthCard = GameCards.get(7).getValue();

		while (playerFourthCard > dealerFourthCard) {
			String C = Keyboard.readString("\"You have the highest Third card, Do you want to [C]all or [Q]uit?:");
			if (C.equalsIgnoreCase("C")) {
				int betAmount = Keyboard.readInt("Enter bet amount (must be 10 chips): ");
				if (betAmount == 10) {
					playerpot = playerpot - 10;
					dealerpot = playerpot - 10;
					int tablepot = 60;
					System.out.println("Jack, You left with " + playerpot + " Chips");
					System.out.println("Total pot on table " + tablepot + " Chips");
					System.out.println(
							"--------------------------------------------------------------------------------");
					break;
				} else {
					System.out.println("Invalid bet amount. Please try again with 10 chips.");
				}
			} else if (C.equalsIgnoreCase("Q")) {
				int tablepot = 60;
				System.out.println("Quit option selected. player have quitted");
				System.out.println("Dealer have won the game with winning : " + tablepot + " Chips from Total pot");
				System.exit(0);
			} else {
				System.out.println("Invalid input, please enter only can choose to [C]all or [Q]uit.");
			}
		}

		while (dealerFourthCard > playerFourthCard) {
			System.out.println("Dealer has the highest Fourth card and Dealer call, state bet : " + minbet);
			String F = Keyboard.readString("Do you want to [F]ollow or [Q]uit : ");
			playerpot = playerpot - 10;// get player's bet from input
			dealerpot = dealerpot - 10;
			int tablepot = 60;
			if (F.equalsIgnoreCase("F")) {
				// advance to next round ;
				System.out.println("Jack, You left with " + playerpot);
				System.out.println("total bet on table " + tablepot);
				System.out.println("Continue to next Round");
				System.out.println("--------------------------------------------------------------------------------");
				break;
				// End game Round 3
			} else if (F.equalsIgnoreCase("Q")) {
				System.out.println("You have left the game");
				dealerpot = tablepot + dealerpot;
				System.out.println("Dealer have won the game with winning : " + tablepot + " Chips from Total pot");
				main(null);
			} else {
				System.out.println("Invalid input, please enter only can choose to [F]ollow, or [Q]uit.");
			}
		}
	}

	public void rnd4Chker() {
		int playerFifthCard = GameCards.get(8).getValue();
		int dealerFifthCard = GameCards.get(9).getValue();
		playerpot = playerpot - 10;
		dealerpot = dealerpot - 10;
		int tablepot = 80;
		while (playerFifthCard > dealerFifthCard) {
			String C = Keyboard.readString(
					"You have the highest Fifth card. Player Call to bet, Do you want to [C]all or [Q]uit?:");
			if (C.equalsIgnoreCase("C")) {
				int betAmount;
				do {
					betAmount = Keyboard.readInt("Enter bet amount (must be 10 chips): ");
					if (betAmount != 10) {
						System.out.println("Invalid bet amount. Please try again with 10 chips.");
					}
				} while (betAmount != 10);

				System.out.println("Jack, You left with " + playerpot + " Chips");
				System.out.println("Total pot on table " + tablepot + " Chips");
				System.out.println("--------------------------------------------------------------------------------");
				break;
				// exit the loop if the condition is met
			} else if (C.equalsIgnoreCase("Q")) {
				System.out.println("Quit option selected. player have quitted");
				System.out.println("Dealer have won the game with winning : " + tablepot + " Chips from Total pot");
				main(null);
			} else {
				System.out
						.println("Invalid input, please enter only can choose to [[C]all or [Q]uit?: please try again");
			}
		}

		while (dealerFifthCard > playerFifthCard) {
			System.out.println("Dealer has the highest Second card and Dealer call, state bet : " + minbet);
			String F = Keyboard.readString("Do you want to [F] ollow or [Q]uit : ");
			if (F.equalsIgnoreCase("F")) {
				// advance to next round ;
				System.out.println("Jack, You left with " + playerpot);
				System.out.println("total bet on table " + tablepot);
				System.out.println("Continue to next Round");
				System.out.println("--------------------------------------------------------------------------------");
				break;
			} else if (F.equalsIgnoreCase("Q")) {
				System.out.println("You have left the game");
				dealerpot = tablepot + dealerpot;
				System.out.println("Dealer have won the game with winning : " + tablepot + " Chips from Total pot");
				main(null);
			} else {
				System.out.println("Invalid input, please enter only can choose to [F]ollow, or [Q]uit.");
			}
		}
	}

	public static void login() {
		HighSum game = new HighSum();
		Scanner scanner = new Scanner(System.in);
		boolean isLoggedIn = false;

		while (!isLoggedIn) {

			String inputUsername = Keyboard.readString("Enter login: ");
			String inputPassword = Keyboard.readString("Enter password: ");

			if (inputUsername.equals(username) && inputPassword.equals(password)) {
				isLoggedIn = true;
				game.game();
			} else {
				System.out.println("Invalid user, Please try again");
			}
		}
		scanner.close();
	}

}
