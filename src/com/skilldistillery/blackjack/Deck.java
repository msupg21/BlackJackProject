package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;

	public Deck() {
		this.cards = new ArrayList<Card>();
	}

	// populates Arraylist with 52 card objects
	public void makeNewDeck() {
		for (Suit cardSuit : Suit.values()) {
			for (Rank cardRank : Rank.values()) {
				this.cards.add(new Card(cardSuit, cardRank));
			}
		}
	}

	public void shuffleDeck() {
		Collections.shuffle(cards);

	}

	// add to initial deck
	public void replaceCards(Deck putBack) {
		int replacedDeck = this.cards.size();
		
		for (int i = 0; i < replacedDeck; i++) {
			addCard(this.getCard(i));
		}

		// empty temp discard deck
		for (int i = 0; i < replacedDeck; i++) {
			this.removeCard(0);

		}
		this.cards = new ArrayList<Card>();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public String toString() {
		String hand = "";
		for (Card card : this.cards) {
			hand = hand + "\n" + card.toString();
		}
		return hand;
	}

	public void removeCard(int i) {
		this.cards.remove(i);
	}

	public Card getCard(int i) {
		return this.cards.get(i);
	}

	public void addCard(Card newCard) {
		this.cards.add(newCard);
	}

	// drawing form ArrayList at index and then removing it, will replace it later
	public void drawFromDeck(Deck drawing) {
		this.cards.add(drawing.getCard(0));
		drawing.removeCard(0);
	}

	public int deckSize() {
		return this.cards.size();
	}

	// returns the int value of boths cards
	public int cardValue() {
		int totalVal = 0;
		int aceVal = 0;

		for (Card cards : this.cards) {
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
