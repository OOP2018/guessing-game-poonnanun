import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {

	/** play the game. */
	public int[] play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		int over = 0;
		int times = 0;
		int[] result = new int[2];
		// describe the game
		System.out.println( game.toString() );
		while(over == 0){
			System.out.println( game.getMessage() );
			System.out.print("Your answer: ");
			int guess = console.nextInt();
			times ++;
			boolean correct = game.guess(guess);
			if(correct == true) {
				over = 1;
				result[0] = guess;
				result[1] = times;
				return result;
			}
		}
		return result;
	}
	
}
