package com.skilldistillery.blackjack;

public enum Suit {
	SPADES('\u2764'), CLUBS('\u2663'), HEARTS('\u2666'), DIAMONDS('\u2660');
	
	
	char s1;
	char s2;
	char s3;
	char s4;

	private Suit(char s1) {
		this.s1 = s1;
		this.s2 = s1;
		this.s3 = s1;
		this.s4 = s1;
				;
	}
	

}