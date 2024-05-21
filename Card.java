//this class represent a playing card
public class Card {
	private final String face;
	private final String suit;
	private final int value;
	
	public Card(String cardFace , String cardSuit) {
		this.face = cardFace;
		this.suit = cardSuit;
		switch(cardFace) {//give a numeric value to card by his face
			case "Ace":
				this.value = 14;
				break;
			case "Deuce":
				this.value = 2;
				break;
			case "Three":
				this.value = 3;
				break;
			case "Four":
				this.value = 4;
				break;
			case "Five":
				this.value = 5;
				break;
			case "Six":
				this.value = 6;
				break;
			case "Seven":
				this.value = 7;
				break;
			case "Eight":
				this.value = 8;
				break;
			case "Nine":
				this.value = 9;
				break;
			case "Ten":
				this.value = 10;
				break;
			case "Jack":
				this.value = 11;
				break;
			case "Queen":
				this.value = 12;
				break;
			case "King":
				this.value = 13;
				break;
			default:
				this.value = -1;
				break;
		}
	}
	//copy constructor
	public Card(Card otherCard) { 
		this.face = otherCard.face;
		this.suit = otherCard.suit;
		this.value = otherCard.getCardValue();
	}
	
	public String toString() {
		return this.face + " of " + this.suit;
	}
	//gets the card value
	public int getCardValue() {
		return this.value;
	}
}
