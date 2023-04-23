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
	    } else if (rank >= 2 && rank <= 10) {
	        this.value = rank; // numbered cards have their face value
	    } else if (rank >= 11 && rank <= 12) {
	        this.value = 10; // Jack and Queen have a value of 10
	    } else if (rank == 13) {
	        this.value = 10; // King has a value of 10
	    } else {
	        // handle invalid rank
	    }
	}
	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
	}

	// getter and setter
	public SuitRank getSuitRank() {
	    switch (this.suit) {
	        case "CLUBS":
	            return SuitRank.CLUBS;
	        case "DIAMONDS":
	            return SuitRank.DIAMONDS;
	        case "HEARTS":
	            return SuitRank.HEARTS;
	        case "SPADES":
	            return SuitRank.SPADES;
	        default:
	            throw new IllegalArgumentException("Invalid suit: " + this.suit);
	    }
	}
	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getRank() {
		  switch (rank) {
	        case 10: // Jack
	            return 11;
	        case 12: // Queen
	            return 12;
	        case 13: // King
	            return 13;
	        default:
	            return rank;
	    }
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

	
		public int compareTo(Card other) {
		    if (this.rank != other.rank) { // Different face values
		        return Integer.compare(this.rank, other.rank);
		    } else { // Same face value
		        return this.getSuitRank().getRank() - other.getSuitRank().getRank();
		    }
		}
}
