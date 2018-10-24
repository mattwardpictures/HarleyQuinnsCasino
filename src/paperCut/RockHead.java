package paperCut;

// RockHead player always chooses rock
public class RockHead extends Player {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = "Batman";
	}

	@Override
	public Roshambo generateRoshambo() {

		return Roshambo.ROCK;
	}

}
