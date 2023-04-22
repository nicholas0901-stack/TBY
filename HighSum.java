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
		
		//------------------------------------------------------------------------------- ROUND 2 -------------------------------------------------------------------------------//
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
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Total Card value: " + (playerFirstCard + playerSecondCard + playerThirdCard));
		rnd2Chker();	
		
		//------------------------------------------------------------------------------- ROUND 3 -------------------------------------------------------------------------------//
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
		
		//------------------------------------------------------------------------------- ROUND 4 -------------------------------------------------------------------------------//
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
		System.out.println("Dealer Value : " + (dealerFirstCard + dealerSecondCard + dealerThirdCard + dealerFourthCard + dealerFifthCard));
		System.out.println("--------------------------------------------------------------------------------");
		rnd4Chker();
		System.out.println();
		System.out.println("your cards :" + GameCards.get(0) + " " + GameCards.get(2) + " " + GameCards.get(4)
		+ GameCards.get(6) + GameCards.get(8));
		System.out.println("Player Value : " + (playerFirstCard + playerSecondCard + playerThirdCard + playerFourthCard + playerFifthCard));
		System.out.println("--------------------------------------------------------------------------------");
		rnd4Chker();
		// game Round ends here
		// dealerCards.add(deck.drawCard());
		if (playerFifthCard > dealerFifthCard) {
		    System.out.println("Jack Won the game, 40 Chips from pot");
		    System.out.println("Jack, Total chips: 140 Chips");
		    System.out.println("Dealer shuffles used cards and places them behind the deck");
		    gameEnd();
		} else if (playerFifthCard < dealerFifthCard) {
		    System.out.println("Dealer Won the game, 40 Chips from pot");
		    System.out.println("Jack, Total chips: 60 Chips");
		    System.out.println("Dealer shuffles used cards and places them behind the deck");
		    gameEnd();
		} else {
		    System.out.println("The game is a tie");
		    System.out.println("Jack, Total chips: 100 Chips");
		    System.out.println("Dealer shuffles used cards and places them behind the deck");
		    gameEnd();
		}

			
	}
	

	
	

	public void rnd4Chker() {

		int playerFifthCard = GameCards.get(8).getValue();
		int dealerFourthCard = GameCards.get(9).getValue();
			while (playerFifthCard > dealerFourthCard) {
				System.out.println("You have the highest Fourth card. How much do you want to bet?");
				String minbet = scanner.next();
				if (minbet.equalsIgnoreCase("10")) {
					playerpot = playerpot - 10;// get player's bet from input
					dealerpot = dealerpot - 10;
					int tablepot = 80;
					System.out.println("Jack, You left with " + playerpot + " Chips");
					System.out.println("total pot on table " + tablepot + " Chips");
					System.out.println(
							"--------------------------------------------------------------------------------");
					break; // exit the loop if the condition is met
				} else {
					System.out.println("Invalid chips please try again only can bet 10 chips");
				}
			while (dealerFourthCard > playerFifthCard) {
			System.out.println(
					"Dealer has the highest Fourth card. Dealer call bet : [10 chips],  [F] to follow, [N]o to Quit : ");
			String F = scanner.next();
			playerpot = playerpot - 10;// get player's bet from input
			dealerpot = dealerpot - 10;
			int tablepot = 80;
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
				System.out.println("Dealer have won the game with winning : " + tablepot + " Chips from Total pot");
				System.exit(0);

			}
		}
			}
	}
	public void rnd1Chker() {
		int playerSecondCard = GameCards.get(2).getValue();
		int dealerSecondCard = GameCards.get(3).getValue();
		while (playerSecondCard > dealerSecondCard) {
			System.out.println("You have the highest Second card. Player Call to bet");
			String minbet = scanner.next();
			if (minbet.equalsIgnoreCase("10")) {
				playerpot = playerpot - 10; // get player's bet from input
				dealerpot = dealerpot - 10;
				System.out.println("you are left with " + playerpot + " chips");
				System.out.println("total pot on table : " + 20 + " Chips");
				System.out.println("--------------------------------------------------------------------------------");
				break;
			} else {
				System.out.println("Invalid amount.");
			}
		}
		while (dealerSecondCard > playerSecondCard) {
			System.out.println(
					"Dealer has the highest second card. Dealer call bet : [10 chips]  You need to [F]ollow the dealer call. ");
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
				break;
			} else {
				System.out.println("Players can only follow in the first round please try again.");

			}
		}
	}
	public void rnd2Chker() {
		int playerThirdCard = GameCards.get(4).getValue();
		int dealerThirdCard = GameCards.get(5).getValue();
		while (playerThirdCard > dealerThirdCard) {
			System.out.println("You have the highest Third card. How much do you want to bet?");
			String minbet = scanner.next();
			if (minbet.equalsIgnoreCase("10")) {
				playerpot = playerpot - 10;// get player's bet from input
				dealerpot = dealerpot - 10;
				int tablepot = 40;
				System.out.println("Jack, You left with " + playerpot + " Chips");
				System.out.println("total pot on table " + tablepot + " Chips");
				System.out.println("--------------------------------------------------------------------------------");
				// exit the loop if the condition is met
				break;
			} else {
				System.out.println("Invalid chips please try again only can bet 10 chips");
			}
		}
			while (dealerThirdCard > playerThirdCard) {
				System.out.println(
						"Dealer has the highest Third card. Dealer call bet : [10 chips],  [F] to follow, [N]o to Quit : ");
				String F = scanner.next();
				playerpot = playerpot - 10;// get player's bet from input
				dealerpot = dealerpot - 10;
				int tablepot = 40;
				if (F.equalsIgnoreCase("F")) {
					// advance to next round ;
					System.out.println("Jack, You left with " + playerpot + " Chips");
					System.out.println("total pot on table " + tablepot + " Chips");
					System.out.println("Continue to next Round");
					System.out.println(
							"--------------------------------------------------------------------------------");
					break;
					// End game Round 2
				} else {
					System.out.println("You have left the game");
					System.out.println("Dealer have won the game with winning : " + 20 + " Chips from the pot");
					System.exit(0);
					
				}
			}
		}

	
	public void rnd3Chker() {
		int playerFourthCard = GameCards.get(6).getValue();
		int dealerFourthCard = GameCards.get(7).getValue();
		if (playerFourthCard > dealerFourthCard) {
			while (true) {
				System.out.println("You have the highest Fourth card. How much do you want to bet?");
				String minbet = scanner.next();
				if (minbet.equalsIgnoreCase("10")) {
					playerpot = playerpot - 10;// get player's bet from input
					dealerpot = dealerpot - 10;
					int tablepot = 60;
					System.out.println("Jack, You left with " + playerpot + " Chips");
					System.out.println("total pot on table " + tablepot + " Chips");
					System.out.println(
							"--------------------------------------------------------------------------------");
					break; // exit the loop if the condition is met
				} else {
					System.out.println("Invalid chips please try again only can bet 10 chips");
				}
			}
		} else {
			System.out.println(
					"Dealer has the highest Fourth card. Dealer call bet : [10 chips],  [F] to follow, [N]o to Quit : ");
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
				System.out.println("Dealer have won the game with winning : " + tablepot + " Chips from Total pot");
				System.exit(0);

			}
		}

	}
	public static void login(){	
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
		            game.game();
		        } else {
		            System.out.println("Invalid user, Please try again");
		        }
		    }
		    scanner.close();
		}
	public void gameEnd () {
		    HighSum game = new HighSum();
		    System.out.println("--------------------------------------------------------------------------------");
		    System.out.println("Start a new game ? [Y]es or [N]o");
		    String Y = scanner.next();
		    if (playerpot > dealerpot) {
		        System.out.println("You won the game , 40 Chips from pot");
		        playerpot += 40;
		    } else if (dealerpot > playerpot) {
		        System.out.println("Dealer Won the game , 40 Chips from pot");
		        dealerpot += 40;
		        System.out.println("dealer shuffles used card and place behind the deck");
		        deck.shuffle();
		    }
		    System.out.println("--------------------------------------------------------------------------------");
		    if (Y.equalsIgnoreCase("Y")) {
		        game.game();
		    } else {
		        System.out.println("You have exited the game");
		        System.exit(0);
		   }

	}

}
		

