import java.util.Random;

/**
 * Automatically find the answer to any numbergame.
 * @author Poonnanun Poonnopathum
 */
public class GameSolver {
	
	public static int play(NumberGame game){
		int upperBound = game.getUpperBound();
		int lowerBound = 1;
		int answer = guessNumber(upperBound, lowerBound, game);
		return answer;
	}
	
	
	private static int guessNumber(int upperBound, int lowerBound, NumberGame game){
		int num = lowerBound+(upperBound-lowerBound)/2;
		if(game.guess(num)==true){
			return num;
		}
		else if(game.getMessage().contains("small")){
			return guessNumber(upperBound, num, game);
		}
		else if(game.getMessage().contains("large")){
			return guessNumber(num, lowerBound, game);
		}
		else{
			return 0;
		}
	}
}