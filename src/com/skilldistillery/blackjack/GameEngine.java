package com.skilldistillery.blackjack;

import java.io.IOException;
import java.util.Scanner;

public class GameEngine {
	private int decision;

	public void runGame(Player p1) {
		Scanner kb = new Scanner(System.in);

		Deck d1 = new Deck();
		d1.makeNewDeck();
		d1.shuffleDeck();

		Deck playerHand = new Deck();
		Deck dealerHand = new Deck();

		// gives player their money for the table
		double playerWallet = p1.getFunds();
		boolean roundOver = false;
		boolean gameOver = checkForBroke(playerWallet);
		if (gameOver != true)
			roundOver = true;
		// checks for valid wager
		while (roundOver == true) {
			System.out.println();
			System.out.println("Best of luck " + p1.getName());
			System.out.println("*****************************");
			System.out.print("$" + playerWallet + " in chips, place your wager: ");
			int wager = kb.nextInt();
			if (wager > playerWallet) {
				System.out.println("Sorry we don't accepts IOU's here");
				break;
			}

			// deals out hands to player and dealer
			playerHand.drawFromDeck(d1);
			playerHand.drawFromDeck(d1);

			dealerHand.drawFromDeck(d1);
			dealerHand.drawFromDeck(d1);
			// summary of each turn for both player hand and dealer hand
			while (true) {
				System.out.println();
				System.out.println("You drew: " + playerHand.toString());
				System.out.println("You have: " + playerHand.cardValue());
				System.out.println();

				System.out.println("Dealer draws: " + dealerHand.getCard(0).toString() + " &  " + "\uD83C\uDCA0");
				if (playerHand.getCards().size() == 2 && playerHand.cardValue() == 21 && dealerHand.cardValue() != 21) {
					System.out.println("BLACKJACK!!!");
					System.out.println("You win hand, collect $" + (wager * 1.5));
					playerWallet += (wager * 1.5);
					roundOver = true;
					break;
				} else {
					if (playerHand.cardValue() != 21) {
						System.out.println("(1) HIT or (2) STAY");
						decision = kb.nextInt();
					} else {
						break;
					}
				}

				// on a hit
				if (decision == 1) {
					playerHand.drawFromDeck(d1);
					System.out.println("You drew : " + playerHand.getCard(playerHand.deckSize() - 1).toString());
					if (playerHand.cardValue() > 21) {
						System.out.println(
								"You have: " + playerHand.cardValue() + "\nYou have busted! You have lost $" + wager);
						System.out.println("\nDealers hand: " + dealerHand.toString());
						System.out.println("\nDealer had: " + dealerHand.cardValue());
						playerWallet -= wager;
						roundOver = true;
						break;
					}
				}
				if (decision == 2) {
					break;
				}
			}

			// dealers turn ***********************************8
			if ((dealerHand.cardValue() > playerHand.cardValue()) && roundOver != true) {
				System.out.println("You drew: " + playerHand.toString());
				System.out.println();
				System.out.println("Dealers hand: " + dealerHand.toString());
				System.out.println("Dealer had: " + dealerHand.cardValue());
				System.out.println("Dealer won, you lost $" + wager);
				playerWallet -= wager;
				roundOver = true;
			}
			// Dealers specific hit and stay rules
			while ((dealerHand.cardValue() < 17) && roundOver != true) {
				dealerHand.drawFromDeck(d1);
				System.out.println("Dealer drew: " + dealerHand.getCard(dealerHand.deckSize() - 1) + "\nDealers hand: "
						+ dealerHand.toString());
			}

			if ((dealerHand.cardValue() > 21) && roundOver != true) {
				System.out.println("Dealer lost!!!");
				System.out.println("\nDealer had: " + dealerHand.cardValue());
				System.out.println("Dealers hand: " + dealerHand.toString());
				System.out.println("You won hand!!! Collect $" + wager);
				playerWallet += wager;
				roundOver = true;

			}
			// for a dealer push
			if ((playerHand.cardValue() == dealerHand.cardValue()) && (roundOver != true || roundOver == true)) {
				System.out.println(dealerHand.toString());
				System.out.println("\nDealer had: " + dealerHand.cardValue());
				System.out.println("**** PUSH ****");
				System.out.println("You have been credited back $" + wager);
				roundOver = true;
			}

			// check how player won **********************************
			if ((playerHand.cardValue() > dealerHand.cardValue()) && roundOver != true) {
				System.out.println("Dealer lost!!!");
				System.out.println("\nDealer had: " + dealerHand.cardValue());
				System.out.println("You won hand!!! Collect $" + wager);
				playerWallet += wager;
				roundOver = true;
			} else if (roundOver != true) {
				System.out.println("Your hand: " + playerHand.toString());
				System.out.println("Dealers hand: " + dealerHand.toString());
				System.out.println("Dealer had: " + dealerHand.cardValue());
				System.out.println("Dealer won, you lost $" + wager);
				playerWallet -= wager;
				roundOver = true;

			}

			playerHand.replaceCards(d1);
			dealerHand.replaceCards(d1);
			System.out.println(playerWallet);
			gameOver = checkForBroke(playerWallet);
			if (gameOver != true) {
				roundOver = true;
			}
			else{
				roundOver = false;
			}
		}

	}

	private boolean checkForBroke(double pw) {
		boolean over = false;
		if (pw <= 0) {
			System.out.println("You have a gambling problem! You're now broke!");
			over = true;
		}
		if (pw > 5000) {
			System.out.println("Ok time to move to the a higher stakes table!");
			over = true;
		}
		return over;
	}

	public static void clearScreen() {
	}

}
