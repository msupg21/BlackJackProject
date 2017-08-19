package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cardDeck;

	public Deck() {
		cardDeck = new ArrayList<Card>();
	}

	// populates Arraylist with 52 card objects
	public void makeNewDeck() {
		for (Suit cardSuit : Suit.values()) {
			for (Rank cardRank : Rank.values()) {
				cardDeck.add(new Card(cardSuit, cardRank));
			}
		}
	}

	public void shuffleDeck() {
		ArrayList<Card> tempDeck = new ArrayList<Card>();
		Random r1 = new Random();
		int randomCard = 0;
		int deckOrig = cardDeck.size();
		for (int i = 0; i < deckOrig; i++) {
			randomCard = r1.nextInt((cardDeck.size() - 1 - 0) + 1);
			tempDeck.add(cardDeck.get(randomCard));

			// removing from the original deck
			cardDeck.remove(randomCard);

		}

		cardDeck = tempDeck;
	}
	// add to initial deck
	public void replaceCards(Deck putBack){
		int replacedDeck = this.cardDeck.size();
		for (int i = 0; i < replacedDeck; i++) {
			addCard(this.getCard(i));
		}
		
		//empty temp discard deck
		for (int i = 0; i < replacedDeck; i++) {
			this.removeCard(0);
			
		}
	}

	public String toString() {
		String hand = "";
		for (Card card : this.cardDeck) {
			hand = "\n" + card.toString();
		}
		return hand;
	}

	public void removeCard(int i) {
		cardDeck.remove(i);
	}

	public Card getCard(int i) {
		return cardDeck.get(i);
	}

	public void addCard(Card newCard) {
		cardDeck.add(newCard);
	}

	public void drawFromDeck(Deck drawing) {
		cardDeck.add(drawing.getCard(0));
		drawing.removeCard(0);
	}
	public int deckSize(){
		return cardDeck.size();
	}

	// returns the int value of boths cards
	public int cardValue() {
		int totalVal = 0;
		int aceVal = 0;

		for (Card cards : cardDeck) {
			switch (cards.getRank()) {
			case TWO:
				totalVal += 2;
				break;
			case THREE:
				totalVal += 3;
				break;
			case FOUR:
				totalVal += 4;
				break;
			case FIVE:
				totalVal += 5;
				break;
			case SIX:
				totalVal += 6;
				break;
			case SEVEN:
				totalVal += 7;
				break;
			case EIGHT:
				totalVal += 8;
				break;
			case NINE:
				totalVal += 9;
				break;
			case TEN:
				totalVal += 10;
				break;
			case JACK:
				totalVal += 10;
				break;
			case QUEEN:
				totalVal += 10;
				break;
			case KING:
				totalVal += 10;
				break;
			case ACE:
				aceVal += 1;
				break;
			default:
				break;

			}
		}

		// Checking for total val of aces to decide to play either 11 or 1
		for (int i = 0; i < aceVal; i++) {
			if (totalVal > 10) {
				totalVal += 1;
			} else {
				totalVal += 11;
			}

		}

		return totalVal;
	}
}
