package com.skilldistillery.blackjack;

public class Player {
	private String name;
	private int funds;

	// each player has a name and a bank account

	public Player(String name, int funds) {
		super();
		this.name = name;
		this.funds = funds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFunds() {
		return funds;
	}

	public void setFunds(int funds) {
		this.funds = funds;
	}
}
