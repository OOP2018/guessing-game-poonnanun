import java.util.Scanner;

/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 * @author Poonnanun Poonnopathum
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		Scanner sc = new Scanner(System.in);
		System.out.print("Input the maximum number: ");// ask for the maximum number
		int upperBound = sc.nextInt();
		NumberGame game = new OuGuessingGame(upperBound); //Class guessing game
		GameConsole ui = new GameConsole( );
		//TODO Choose one of the result the ui one is play by player but Gameslover one is auto slove.
//		int result = ui.play( game );
		int result = GameSolver.play(game);
		System.out.println("Secret number is = "+result);
		System.out.println("Count: "+ game.getCount());
	}
}
