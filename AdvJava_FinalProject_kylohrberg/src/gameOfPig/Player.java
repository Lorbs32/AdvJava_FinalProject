package gameOfPig;

import java.util.Random;
import java.util.Scanner;

public class Player {
	private String name;
	private int totalScore;
	private int turnScore;
	private Random random;
	
	public Player(String name) {
		this.name = name;
		this.totalScore = 0;
		this.turnScore = 0;
		this.random = new Random();
	}
		
	@Override
	public String toString() {
		return "Player [name=" + name + ", totalScore=" + totalScore + ", turnScore=" + turnScore + ", random=" + random
				+ "]";
	}
	
	public int rollDice() {
		int roll = random.nextInt(6) + 1;
		if (roll == 1) {
			turnScore = 0;
		} else {
			turnScore += roll;
		}
		return roll;
	}
	
	public void hold() {
		totalScore += turnScore;
		turnScore = 0;
	}
	
	public String displayTurnScore() {
		return "Turn Score: " + turnScore;
	}
	
	public String displayTotalScore() {
		return "Total Score: " + totalScore;
	}
	
	public void resetTurnScore() {
		turnScore = 0;
	}
	
	public int getTurnScore() {
		return turnScore;
	}

	public int getTotalScore() {
		return totalScore;
	}
	
	public String getName() {
		return name;
	}
}