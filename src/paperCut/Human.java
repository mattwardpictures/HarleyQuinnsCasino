package paperCut;

import java.util.Scanner;

public class Human extends Player {

	private Scanner scan;

	@Override
	public Roshambo generateRoshambo() {
		scan = new Scanner(System.in);
		String userInput = Validator.getString(scan, "Rock, paper, or scissors? (R, P, or S)\n");
		if (userInput.equalsIgnoreCase("R")) {
			return Roshambo.ROCK;
		} else if (userInput.equalsIgnoreCase("P")) {
			return Roshambo.PAPER;
		} else if (userInput.equalsIgnoreCase("S")) {
			return Roshambo.SCISSORS;
		} else {
			return null;
		}
	}

}
