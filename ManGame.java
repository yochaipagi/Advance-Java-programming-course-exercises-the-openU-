import javax.swing.JOptionPane;
//this class will manage all the game turn , deal , war and will run in loop until the user want to stop playing
public class ManGame {
	
	final static int  NUM_CARDS_IN_WAR = 3;
	
	private final DeckOfCards player1;
	private final DeckOfCards player2;
	
	public ManGame() {
		player1 = new DeckOfCards();//crate player1 deck
		player2 = new DeckOfCards();//crate player2 deck		
	}
	//start a game of war
	public void play() {
		dealDecks();
		int continuePlay;
		while(true) {
			turn();//start the game
			if(player1.isEmpty()) {
	            continuePlay = JOptionPane.showConfirmDialog(null,"player 1 lost the game" , "Continue playing?", JOptionPane.YES_NO_OPTION);
	            if(continuePlay ==  JOptionPane.NO_OPTION) {
	                System.exit(0);
	                break;
	            }
			}
			else if(player2.isEmpty()){
	            continuePlay = JOptionPane.showConfirmDialog(null,"player 2 lost the game" , "Continue playing?", JOptionPane.YES_NO_OPTION);
	            if(continuePlay ==  JOptionPane.NO_OPTION) {
	                System.exit(0);
	                break;
	            }
			}
			
		}
	}
	
	//crate and shuffled a full deck and deal it to the 2 players
	private void dealDecks() {
		DeckOfCards deckToDeal = new DeckOfCards();
		deckToDeal.fillDeckOfCards();//now this deck is full 
		deckToDeal.shuffle();//now is shuffled
		//now we will deal this deck
		boolean dealTo = true;
		while(!deckToDeal.isEmpty()) {
			Card tempCard = deckToDeal.remove();
			if(dealTo) {
				player1.push(tempCard);
			}
			else {
				player2.push(tempCard);
			}
			dealTo = !dealTo;//next we will deal card to the other player
		}
	}

	//a simple turn
	public void turn(){
		Card card1 = player1.remove();
		Card card2 = player2.remove();
		if(card1.getCardValue() > card2.getCardValue()) {
			JOptionPane.showMessageDialog(null, "player 1 have a " + card1.toString() + " player 2 have a "+ card2.toString()+ " player 1 wins!");
			player1.push(card2);//player 1 wins the card
			player1.push(card1); //player1 gets his own card beck
		}
		else if(card1.getCardValue() < card2.getCardValue()) {
			JOptionPane.showMessageDialog(null, "player 1 have a " + card1.toString() + " player 2 have a "+ card2.toString()+ " player 2 wins!");
			player2.push(card1);//player 2 wins the card
			player2.push(card2); //player2 gets his own card beck
		}
		else if(!player1.isEmpty() && !player2.isEmpty()) {//if the cards are equal we go to war
			JOptionPane.showMessageDialog(null,"lest go to war");
			
            DeckOfCards warDeck1 = new DeckOfCards();
            warDeck1.push(card1);
            DeckOfCards warDeck2 = new DeckOfCards();
            warDeck2.push(card2);
            war(warDeck1, warDeck2);
		}
		else {
			JOptionPane.showMessageDialog(null,"lets call it a draw");
		}
	}
	//war when the cards in the last turn has the same value
	public void war(DeckOfCards warDeck1 , DeckOfCards warDeck2) {
		Card player1Card =this.player1.remove();
		Card player2Card = this.player2.remove();
		warDeck1.push(player1Card);
		String warCards1 = "first player war cards are: " + player1Card;
		warDeck2.push(player2Card);
		String warCards2 = "  second player war cards are: " + player2Card;
		for (int i  = 0 ; i < NUM_CARDS_IN_WAR-1 ; i++) {//create the cards for the war if a player have less then 3 cards he will play with the cards he have left
			if(player1.isEmpty() || player2.isEmpty()){
				break;//one of the players don't have enough cards so he will play with the cards he have
			}
			player1Card =this.player1.remove();//
			player2Card = this.player2.remove();
			warDeck1.push(player1Card);
			warCards1 += ", " + player1Card;
			warDeck2.push(player2Card);
			warCards2 += ", " + player2Card;
			
		}//in the end of the loop both players last card are in player1Card and player2Card

		if(player1Card.getCardValue() > player2Card.getCardValue()) {
			JOptionPane.showMessageDialog(null,warCards1+ warCards2 + " player 1 wins!");
			player1.addToButton(warDeck2);//player1 wins player2 war cards
			player1.addToButton(warDeck1);//player1 gets his war cards back
		}
		else if(player1Card.getCardValue() < player2Card.getCardValue()){
			JOptionPane.showMessageDialog(null,warCards1  + warCards2  + " player 2 wins!");
			player2.addToButton(warDeck1);//player2 wins player1 war cards
			player2.addToButton(warDeck2);//player2 gets his war cards back
		}
		else if(!player1.isEmpty() && !player2.isEmpty()) {//if the cards are equal we go to another war
			JOptionPane.showMessageDialog(null,"lest go to another war");
			war(warDeck1 , warDeck2);
		}
		else {
			JOptionPane.showMessageDialog(null,"lets call it a draw");//one of the have no cards left for another war
			player1.addToButton(warDeck1);//player1 gets his war cards beck
			player2.addToButton(warDeck2);//player2 gets his war cards back	
		}
	}
}
	