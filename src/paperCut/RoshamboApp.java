package paperCut;

import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Declare/initialize variables.
		Player user = new Human();
		Player opponent = null;
		Roshambo userMove;
		Roshambo opponentMove;
		String userName;
		int userScore = 0;
		int opponentScore = 0;
		int numberOfGames = 0;
		String continuePlaying;

		System.out.println("=======================");
		System.out.println("       Welcome to      ");
		System.out.println(" HARLEY QUINN'S CASINO ");
		System.out.println("=======================");
		System.out.println("");
		System.out.println("Throw down against the meanest motherf***ers \nin the city, county, and state of Gotham!");
		System.out.println("");

		// Prompt user to enter name. Validate input.
		userName = Validator.getString(scan, "Please enter your name: ");
		user.setName(userName);

		do {
			// Prompt user to select opponent. Validate input.
			String userChoice = Validator.getString(scan,
					"Would you like to play against Batman or The Joker? (b/j)\n");
			if (userChoice.equalsIgnoreCase("b")) {
				opponent = new RockHead();
				opponent.setName("Batman");
			} else if (userChoice.equalsIgnoreCase("j")) {
				opponent = new Smart();
				opponent.setName("Joker");
			} else {
				System.out.println("Please enter b or j\n");
			}
			// Prompt user to select rock, paper, or scissors. Validate input.
			userMove = user.generateRoshambo();
			// Display opponent's choice.
			opponentMove = opponent.generateRoshambo();
			System.out.println(opponent.getName() + " threw " + opponentMove);
			// Display user's choice.
			System.out.println(userName + " threw " + userMove + "\n");
			// Display results of match. Write a separate method.
			int game = userMove.compareMoves(opponentMove);
			switch (game) {
			case 0:
				System.out.println("TIE!");
				break;
			case 1:
				System.out.println(userMove + " beats " + opponentMove + ". \n" + userName + " wins!\n");
				userScore++;
				break;
			case -1:
				System.out.println(
						opponentMove + " beats " + userMove + ". \n" + opponent.getName() + " wins! You lost.\n");
				opponentScore++;
				break;
			}
			numberOfGames++;
			System.out.println("Next Round? (y/n)");
			continuePlaying = scan.next();
		} while (continuePlaying.charAt(0) == 'y');
		System.out.println("\nGAME STATS");
		System.out.println("");
		System.out.printf("%-15s %-15s %-15s", "Games", "Home Team", "Opponent");
		System.out.println("");
		System.out.println("=============================================");
		System.out.printf("%-15s %-15s %-15s", numberOfGames, userScore, opponentScore);

		// Prompt user to continue. Validate input.

		scan.close();

	}

}
