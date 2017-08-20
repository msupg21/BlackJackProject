package com.skilldistillery.blackjack;

import java.util.Scanner;

public class PlayBlackJack {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("\t\t\t\t" + '\u2764' + "\t\t" + '\u2663' + "\t\t" + '\u2666' + "\t\t" + '\u2660');
		System.out.println("\t\t\t\t" + '\u2663' + "\t    WELCOME TO MY BLACKJACK GAME" + "\t\t" + '\u2666');
		System.out.println("\t\t\t\t" + '\u2660' + "\t\t" + '\u2666' + "\t\t" + '\u2663' + "\t\t" + '\u2764');

		Player p1 = createProfile();
		GameEngine run = new GameEngine();
		run.runGame(p1);

	}

	public static Player createProfile() {
		Scanner kb = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println("Before you play, would you like to see the basic rules of BlackJack \"21\"?");
		System.out.println();
		System.out.println("If so, simply type yes or no...");
		String rules = kb.next();
		if (rules.equalsIgnoreCase("yes")) {
			System.out.println("Yea, I am not trying to type out ALL the rules..");
			System.out.println("But feel free to visit this website to https://www.pagat.com/banking/blackjack.html");
		}
		System.out.println();
		System.out.println("Enter player name: ");
		String name = kb.next();
		System.out.println("Have a seat " + name + " :)");
		System.out.println("Are you a high roller or balling on a budget tonight?");
		System.out.println();
		System.out.println("(1) high roller" + "\t\uD83D\uDCB8" + "\uD83D\uDCB8" + " \uD83D\uDCB8");
		System.out.println("(2) balling on a budget" + "\t\uD83D\uDCB8");
		int choice = kb.nextInt();
		Player p1;
		if (choice == 1) {
			p1 = new Player(name, 750);
			System.out.println("Welcome back " + p1.getName() + "!");
			System.out.println("You've earned a 50% of coupon for our buffet for choosing us again!");
			System.out.println("Today's special is our prime rib " + "\uD83C\uDF56\n");
			System.out.println("Change in $" + p1.getFunds() + "!");
			System.out.println("You now have $" + p1.getFunds() + " in chips " + p1.getName() + " :)");
		} else {
			p1 = new Player(name, 250);
			System.out.println("Change in $" + p1.getFunds() + "!");
			System.out.println("You now have $" + p1.getFunds() + " in chips " + p1.getName() + " :)");

		}
		
		return p1;
	}
}
