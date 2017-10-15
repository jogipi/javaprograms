/*Name: Jorge Sanchez
 * ID: 5213188
 * Project 2: Twenty One
 * Date: 6/28/2015
 * 
 * This program is a game of twenty one. The user is given the option of rolling two six sided dice to accumulate points as close to 21 as possible, however the user
 * may not pass 21. The user is competing against the computer who is programmed to continue rolling the dice until either it busts(meaning it passes 21 points) or has a closer number to twenty one
 * than the user.
 */


import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		final int DIE1_SIDES = 6;
		final int DIE2_SIDES = 6;
		char Answer = 'N';
		char secondAnswer = 'Y';
		int currentScore = 0;
		int firstPoint = 0;
		int secondPoint = 0;
		int thirdPoint = 0;
		int fourthPoint = 0;
		int compScore = 0;
		
		player challenger = new player(0);
		player dealer = new player(0);
		Scanner s = new Scanner(System.in);
		Die dice1 = new Die(DIE1_SIDES);
		Die dice2 = new Die(DIE2_SIDES);
		Die dice3 = new Die(DIE1_SIDES);
		Die dice4 = new Die(DIE2_SIDES);
		
		System.out.println("Would you like to play blackjack?");
		Answer = s.next().charAt(0);
		
		
		
		if(Answer == 'Y' || Answer == 'y')
		{
			while(secondAnswer == 'Y' || secondAnswer == 'y' && currentScore <= 21)
			{
				
			System.out.println("Your current number of points is " + currentScore + "\nWould you like to roll the dice?");
			secondAnswer = s.next().charAt(0);
				if (secondAnswer =='Y' || secondAnswer =='y')
				{
					dice1.roll();
					firstPoint = dice1.getValue();
					challenger.addPoints(firstPoint);
					dice2.roll();
					secondPoint = dice2.getValue();
					challenger.addPoints(secondPoint);
					currentScore = challenger.getPoints();
					
				}	
			
			}
			while(currentScore <= 21 && compScore <= currentScore)
			{
				dice3.roll();
				thirdPoint = dice3.getValue();
				dealer.addPoints(thirdPoint);
				dice4.roll();
				fourthPoint = dice4.getValue();
				dealer.addPoints(fourthPoint);
				compScore = dealer.getPoints();
				
			}

			if(compScore > currentScore && compScore <=21)
			{
				System.out.println("You Lose.");
				System.out.println("Your point value: " + currentScore);
				System.out.println("Dealer point value: " + compScore);
			}
			else if(compScore == 0)
			{
				System.out.println("Bust! You Lose.");
				System.out.println("Your point value: " + currentScore);
			}
				
			else
			{
				System.out.println("You Win!");
				System.out.println("Your point value: " + currentScore);
				System.out.println("Dealer point value: " + compScore);
			}
			
			
			
		}
		else
			System.out.println("Okay see you later!");

	}

}
