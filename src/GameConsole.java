import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 *  @param game is NumberGame object
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		int times = 0;
		// describe the game
		System.out.println( game.toString() );
		while(true){
			System.out.println( game.getMessage() );
			System.out.print("Your answer: ");
			int guess = console.nextInt();
			times ++;
			boolean correct = game.guess(guess);
			if(correct == true) {
				return guess;
			}
		}
	}
}
