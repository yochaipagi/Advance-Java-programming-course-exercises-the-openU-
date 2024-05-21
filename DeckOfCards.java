import java.security.SecureRandom;
import java.util.ArrayList;
//represent a deck of playing card
public class DeckOfCards {
	private static final SecureRandom rand = new SecureRandom();//our random numbers generator
	private ArrayList <Card> deck = new ArrayList<Card>();
	private final String [] cardFaces = {"Ace","Deuce","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	private final String [] cardSuits = {"Hearts" , "Diamonds" , "Clubs" , "Spades"};
	private final int DECK_BUTTON = 0;
	
	//the constructor crates empty deck of Cards
	public DeckOfCards() {
		this.deck = new ArrayList<Card>();
	}
	//fill a full deck without jokers
	public void fillDeckOfCards() {
		//now we create a full card deck
		for(int i = 0 ; i<cardSuits.length ; i++) {
			for(int j = 0 ; j<cardFaces.length ; j++) {
				Card cardToAdd = new Card(cardFaces[j] , cardSuits[i]);//generate a new card to add to the deck
				deck.add(cardToAdd);//create full deck of card
			}
		}
	}
	//shuffle deck of cards in place
	public void shuffle() {
		for(int i = 0 ; i<deck.size() ; i++) {
			int randomNum = rand.nextInt(deck.size());//randomize an index to swap with
			Card temp = deck.get(i);
			deck.set(i, deck.get(randomNum));
			deck.set(randomNum, temp);//swapping the cards
		}//now the deck is shuffled
	}
	//add card to the deck from the button
	public void push(Card card) {
		this.deck.add(new Card(card));//crate a Card with the copy constructor
	}
	//remove a card from a deck , and return the card that have been deleted
	public Card remove() {
		if(this.deck.isEmpty()) {
			return null;
		}
		return this.deck.remove(DECK_BUTTON);
	}
	// we use this when we want to add number of cards to another deck like in war situation
	public void addToButton(DeckOfCards otherDeck) {
		if(otherDeck!=null){
			while(!otherDeck.isEmpty()) {
				this.push(otherDeck.remove());
			}
		}
	}
	//check if deck is empty
	public  boolean isEmpty() {
		return this.deck.isEmpty();
	}
	//return a string for deck of cards
	public String toString() {
		String str = "";//will be the returned String
		if(deck.isEmpty()) {
			return "empty";
		}
		else {
			for(int i = 0; i<deck.size(); i++) {
				str += " " + deck.get(i).toString();
			}
		return str;
		}
	}
}
