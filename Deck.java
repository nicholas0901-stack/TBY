
import java.util.ArrayList; 
import java.util.Collections; 
 
public class Deck { 
 private ArrayList<Card> cards; 
 private final int DECK_SIZE = 52;
 
 public Deck() { 
	 
  cards = new ArrayList<Card>(DECK_SIZE); 
  for (int rank = 1; rank <= 13; rank++) { 
   for (String suit : new String[] { "SPADES", "HEARTS", "DIAMONDS", "CLUBS" }) { 
    Card card = new Card(suit, rank); 
    cards.add(card); 
   } 
  } 
 } 
 
 // method to shuffle card 
 public void shuffle() { 
  Collections.shuffle(cards); 
 } 
 
 // method to draw card 
 public Card drawCard() { 
  if (cards.isEmpty()) { 
   return null; 
  } 
  return cards.remove(0); 
 } 
 
 // method to to return card size 
 public int size() { 
  return cards.size(); 
 } 
  
}
