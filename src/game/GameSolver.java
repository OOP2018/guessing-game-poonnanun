package game;

/**
 * Automatically find the answer to any numbergame.
 * @author Poonnanun Poonnopathum
 */
public class GameSolver {
/**
 * Initialize the automatic solve the game.
 * @param game is NumberGame object.
 * @return correct secret number
 */
	public int play(NumberGame game){
		int upperBound = game.getUpperBound();
		int lowerBound = 1;
		int answer = guessNumber(upperBound, lowerBound, game);
		return answer;
	}
	/**
	 * This method have for for call itself until it gets the correct number.
	 * @param game is NumberGame object, upperBound is max value, lowerBound is lowest value.
	 * @return correct secret number or exit if get error.
	 */
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
			System.out.println("Something error please change message to small and large.");
			System.out.println("System terminated");
			System.exit(1);
			return 0;
		}
	}
}