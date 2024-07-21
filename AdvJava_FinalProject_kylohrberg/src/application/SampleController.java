package application;

import gameOfPig.AIPlayer;
import gameOfPig.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController {
	
	Player player1;
	AIPlayer aiPlayer1;
	Player currentPlayer;
	@FXML
	TextField playerNameText;
	@FXML
	TextField playerTurnTotalText;
	@FXML
	TextField playerGameTotalText;
	@FXML
	TextField enterPlayerNameText;
	@FXML
	TextField computerNameText;
	@FXML
	TextField computerTurnTotalText;
	@FXML
	TextField computerGameTotalText;
	@FXML
	TextArea gameLogText;
	@FXML
	TextArea gameHistoryRecordsText;
	@FXML
	Button startNewGame;
	@FXML
	Button rollDice;
	@FXML
	Button hold;

	@FXML
	public void startNewGameBtnClicked() {
		player1 = new Player(enterPlayerNameText.getText());
		aiPlayer1 = new AIPlayer("Robo Bob");
		currentPlayer = player1;
		gameLogText.appendText(player1.getName() + " has started the game. \n");
		gameLogText.appendText("Please Click on Roll to begin \n");
		playerNameText.setText(player1.getName());
		computerNameText.setText(aiPlayer1.getName());
	}	
	@FXML
	public void rollDiceBtnClicked() {
		int roll = currentPlayer.rollDice();
		gameLogText.appendText(currentPlayer.getName() + " rolled a " + roll + "\n");
		if (currentPlayer == player1) {
			playerTurnTotalText.setText(String.valueOf(player1.getTurnScore()));
			if (roll == 1) {
				gameLogText.appendText("Oh no! " + player1.getName() + " rolled a 1.. No points this turn..\n");
				switchTurns();
			} else {
				computerTurnTotalText.setText(String.valueOf(aiPlayer1.getTurnScore()));
				if (roll == 1) {
					gameLogText.appendText("Oh no! " + aiPlayer1.getName() + "rolled a 1.. No points this turn \n");
					switchTurns();
				}
			}
		}
	}	
	@FXML
	public void holdBtnClicked() {
		currentPlayer.hold();		
		if (currentPlayer == player1) {
			gameLogText.appendText(player1.getName() + "'s new Total Score is: " + player1.getTotalScore() + "\n");
			playerGameTotalText.setText(String.valueOf(player1.getTotalScore()));
		} else {
			gameLogText.appendText(aiPlayer1.getName() + "'s new Total Score is: " + aiPlayer1.getTotalScore() + "\n");
			computerGameTotalText.setText(String.valueOf(aiPlayer1.getTotalScore()));
		}		
		switchTurns();
	}
	public void switchTurns() {
		currentPlayer = (currentPlayer == aiPlayer1) ? player1 : aiPlayer1;
		gameLogText.appendText("It's now " + currentPlayer.getName() + "'s turn. \n");
		if (currentPlayer == aiPlayer1) {
			while (!aiPlayer1.shouldHold()) {
				int aiRoll = aiPlayer1.rollDice();
				gameLogText.appendText(currentPlayer.getName() + " rolled a " + aiRoll + "\n");
				if (aiRoll == 1) {
					gameLogText.appendText("Oh no! " + aiPlayer1.getName() + "rolled a 1.. No points this turn \n");
					aiPlayer1.resetTurnScore();
					break;
				}
			}
			if (aiPlayer1.shouldHold()) {	
				gameLogText.appendText(currentPlayer.getName() + " decides to hold with a score of " + aiPlayer1.getTurnScore() + "\n");
				aiPlayer1.hold();
				computerGameTotalText.setText(String.valueOf(aiPlayer1.getTotalScore()));
			}
			currentPlayer = player1;
			gameLogText.appendText("It's now " + currentPlayer.getName() + "'s turn. \n");
		} 
		updateScores();
	}
	public void updateScores() {
		playerTurnTotalText.setText(String.valueOf(player1.getTurnScore())); 
		computerTurnTotalText.setText(String.valueOf(aiPlayer1.getTurnScore()));
	}
	public void gameLogTabClicked() {
		
	}
	public void gameHistoryRecordsTabClicked() {
		
	}
}
