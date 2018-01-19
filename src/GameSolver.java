import java.util.Random;

/**
 * Automatically find the answer to any numbergame.
 * @param game is NumberGame object.
 * @author Poonnanun Poonnopathum
 * @return correct secret number
 */
public class GameSolver {
	
	public int play(NumberGame game){
		int upperBound = game.getUpperBound();
		int lowerBound = 1;
		int answer = guessNumber(upperBound, lowerBound, game);
		return answer;
	}
	
	private int guessNumber(int upperBound, int lowerBound, NumberGame game){
		int num = lowerBound+(upperBound-lowerBound)/2;
		if(game.guess(num)){
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
