package gameOfPig;

import java.util.Random;
import java.util.Scanner;

public class Player {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int player1GameScore = 0;
        int player2GameScore = 0;
        int currentPlayer = 1;
        
        while (player1GameScore < 100 && player2GameScore < 100) {
            int turnScore = 0;
            boolean continueTurn = true;
            
            System.out.println("Player " + currentPlayer + "'s turn:");
            
            while (continueTurn) {
            	
            	//player decides what to do next
                System.out.print("Roll or Hold? (r/h): ");
                char choice = scanner.next().charAt(0);
                
                
                	//r = generate number 1-6
                	// public roll() {
                if (choice == 'r') {			
                    int roll = random.nextInt(6) + 1;
                    System.out.println("You rolled: " + roll);             
                    if (roll == 1) {				//1 = end turn
                        System.out.println("Rolled a 1! No points this turn.");
                        turnScore = 0;
                        continueTurn = false;
                    } else {						//2 - 6 = add to turnScore
                        turnScore += roll;
                        System.out.println("Turn score: " + turnScore);
                    }
                
                    
                  //h = add TurnScore to GameScore and end turn
                  // public hold() {
                } else if (choice == 'h') {		
                    if (currentPlayer == 1) {
                    	player1GameScore += turnScore;
                    } else {
                    	player2GameScore += turnScore;
                    }
                    continueTurn = false;
                 
                    
                  //catch all for bad inputs
                } else {   			
                    System.out.println("Invalid choice. Please enter 'r' to roll or 'h' to hold.");
                }
            }

            
            	//announce GameScores for both players
            	// public announce() {
            System.out.println("Player 1 Total Score: " + player1GameScore);
            System.out.println("Player 2 Total Score: " + player2GameScore);
            
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }
        
        
        	//if player's GameScore is 100 or above = they win
        if (player1GameScore >= 100) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
        
        scanner.close();
    }
}