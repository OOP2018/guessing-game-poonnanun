import java.util.Scanner;

/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		Scanner sc = new Scanner(System.in);
		System.out.print("Input the maximum number: ");// ask for the maximum number
		int upperBound = sc.nextInt();
		NumberGame game = new OuGuessingGame(upperBound); //Class guessing game
		GameConsole ui = new GameConsole( );
		int[] result = ui.play( game );
		//TODO display the answer returned by play
		System.out.println("Secret number is = "+result[0]);
		System.out.println("Count: "+result[1]);
		//TODO display how many guesses the user made
	}
}
