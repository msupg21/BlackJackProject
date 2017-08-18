package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cardDeck;

	public Deck() {
		cardDeck = new ArrayList<Card>();
	}

	//populates Arraylist with 52 card objects
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
}
