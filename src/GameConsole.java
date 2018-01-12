import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		int over = 0;
		// describe the game
		System.out.println( game.toString() );
		while(over == 0){
			System.out.println( game.getMessage() );
			System.out.print("Your answer: ");
			int guess = console.nextInt();
			boolean correct = game.guess(guess);
			System.out.println( game.getMessage() );
			if(correct == true) {
				over = 1;
				return guess;
			}
		}
		return 0;
	}
	
}
