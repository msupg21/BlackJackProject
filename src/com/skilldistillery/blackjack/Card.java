package com.skilldistillery.blackjack;

public class Card {

	// each card has a suit and rank
	private Suit suit;
	private Rank rank;

	public Card(Suit s, Rank r) {
		this.suit = s;
		this.rank = r;
	}

	public String toString() {
		return (this.rank.toString() + " of " + this.suit.toString());

	}

	public Rank getRank() {
		return this.rank;
	}

}
