package com.skilldistillery.blackjack;

import java.util.Scanner;

public class GameEngine {

	public void runGame() {
		Scanner kb = new Scanner(System.in);
		Player p1 = new Player();
		Deck playingDeck = new Deck();
		Deck playerDeck = new Deck();
		Deck dealerDeck = new Deck();
		int playerWallet;

		// gives player their money for the table
		playerWallet = p1.getFunds();

		while (playerWallet <= 0) {
			System.out.print("$" + playerWallet + " in chips, place your wager: ");
			int wager = kb.nextInt();
			if (wager > playerWallet) {
				System.out.println("Sorry we don't accepts IOU's here");
				runGame();
			}

			boolean roundOver = false;

			// deals out hands to player and dealer
			for (int i = 0; i < 2; i++) {
				playerDeck.drawFromDeck(playerDeck);
				for (int j = 1; j < 1; j++) {
					dealerDeck.drawFromDeck(dealerDeck);
				}
			}

			// summary of each turn for both player hand and dealer hand
			while (true) {
				System.out.println("Your hand: ");
				System.out.println(playerDeck.toString());
				System.out.println("You have: " + playerDeck.cardValue());
				System.out.println("Deal showing: " + dealerDeck.getCard(0).toString() + "\t\uD83C\uDCA0");

				System.out.println("(1) HIT or (2) STAY");
				int decision = kb.nextInt();

				// on a hit
				if (decision == 1) {
					playerDeck.drawFromDeck(playerDeck);
					System.out.println("You now have: " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
					if (playerDeck.cardValue() > 21) {
						System.out.println(playerDeck.cardValue() + "\tYou have busted! You have lost $" + wager);
						playerWallet -= wager;
						roundOver = true;
						break;
					}
				}
				if (decision == 2) {
					break;
				}
			}

			// dealers turn
			System.out.println("Dealer showing: " + dealerDeck.toString());
			if ((dealerDeck.cardValue() > playerDeck.cardValue()) && roundOver != true) {
				System.out.println("You lost to the dealer...");
				playerWallet -= wager;
				roundOver = true;
			}
			// Dealers specific hit and stay rules
			while ((dealerDeck.cardValue() < 17) && roundOver != true) {
				dealerDeck.drawFromDeck(playingDeck);
				System.out.println("Dealer showing: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
			}

			System.out.println("Dealer has: " + dealerDeck.cardValue());
			if ((dealerDeck.cardValue() > 21) && roundOver != true) {
				System.out.println("Dealer has busted!!");
				System.out.println("You win hand, collect $" + wager);
				playerWallet += wager;

			}
			// for a dealer push
			if (playerDeck.cardValue() == dealerDeck.cardValue() && roundOver != true) {
				System.out.println("Push");
				System.out.println("You have been credited back $" + wager);
				roundOver = true;
			}

			// check how player won
			if ((playerDeck.cardValue() > dealerDeck.cardValue()) && roundOver != true) {
				System.out.println("You won hand!!! You have won $" + wager);
				playerWallet += wager;
				roundOver = true;
			} else if (roundOver != true) {
				System.out.println("Deal won, you lose $" + wager);
				playerWallet -= wager;
				roundOver = true;

			}

			playerDeck.replaceCards(playingDeck);
			dealerDeck.replaceCards(playingDeck);

		}

		System.out.println("You have a gambling problem! You're now broke!");
	}

}
