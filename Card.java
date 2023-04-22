
public class Card {
	// variable
	private String suit;
	private int rank;
	private int value;
	private String[] rankNames = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	public enum SuitRank { CLUBS, DIAMONDS, HEARTS, SPADES;
	private SuitRank suits;
	
	}
	// Constructors
	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
		if (rank == 1) {
		    this.value = 1; // Ace = value of 1
		} else if (rank >= 2 && rank <= 10) {
		    this.value = rank; // determine that face card has it own faced value from 2 - 10
		} else if (rank >= 11 && rank <= 13) {
		    this.value = 10; // Jack, Queen, and King valued at 10
		} else {
		    this.value = 0; // invalid rank
		}
	}

	public Card(int value, String suit, int rank) {
		this.value = value;
		this.suit = suit;
        this.rank = rank;

        switch (suit) {
            case "Spades":
                this.value = 4;
                break;
            case "Hearts":
                this.value = 3;
                break;
            case "Diamonds":
                this.value = 2;
                break;
            case "Clubs":
                this.value = 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid suit: " + suit);
        }
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
	public SuitRank getSuitRank() {
	    switch (suit) {
	        case "clubs":
	            return SuitRank.CLUBS;
	        case "diamonds":
	            return SuitRank.DIAMONDS;
	        case "hearts":
	            return SuitRank.HEARTS;
	        case "spades":
	            return SuitRank.SPADES;
	        default:
	            return null;}
	    }
	

	        // compare the suits based on the priority given in the prompt
	   
	public int compareSuit(Card otherCard) {
        return Integer.compare(this.value, otherCard.value);
    }
	    
}

	    
