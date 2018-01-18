import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 *  @param game is NumberGame object.
 *  @retrun the correct answer.
 *  @author Poonnanun Poonnopathum
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		// describe the game
		System.out.println( game.toString() );
		while(true){
			System.out.println( game.getMessage() );
			System.out.print("Your answer: ");
			int guess = console.nextInt();
			boolean correct = game.guess(guess);
			if(correct == true) {
				return guess;
			}
		}
	}
}
