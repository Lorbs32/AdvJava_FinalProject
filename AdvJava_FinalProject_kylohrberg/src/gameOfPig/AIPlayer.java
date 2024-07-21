package gameOfPig;

public class AIPlayer  extends Player {
	
	public AIPlayer(String name) {
		super("Robo Bob");
	}
	
	public boolean shouldHold() {
		return getTurnScore() >= 15;
	}

}
