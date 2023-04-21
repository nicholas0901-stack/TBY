;
public class Card {
	// variable
	private String suit;
	private int rank;
	private int value;
	private String[] rankNames = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	// Constructors
	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
		if (rank == 1) {
			this.value = 1; // Ace = value of 1
		} else if (rank > 1 && rank <= 10) {
			this.value = rank; // determine that face card has it own faced value from 2 - 9
		} else {
			this.value = 10; // determine Jack, Queen , King valued at 10
		}
	}

	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
	}

	// getter and setter
	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	// method to represent the card and using rankName to get the name of the rank
	public String toString() {
		String rankName = rankNames[rank - 1];
		return " <" + suit + " " + rankName + "> ";
	}
	public enum SuitRank {
		
	    CLUBS(1),
	    DIAMONDS(2),
	    HEARTS(3),
	    SPADES(4);
		private final int rank;
	    private SuitRank(int rank) {
	        this.rank = rank;
	    }

	    public int getRank() {
	        return rank;
	    }
	}

}
