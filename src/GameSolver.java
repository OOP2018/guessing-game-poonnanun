import java.util.Random;

/**
 * Automatically find the answer to any numbergame.
 * @author Poonnanun Poonnopathum
 */
public class GameSolver {
	
	public static int play(NumberGame game){
		Random rand = new Random();
		int answer = 0;
		int upperBound = game.getUpperBound();
		int lowerBound = upperBound - game.getUpperBound()/10;
		for(int z = 1; z<=9; z++){
			lowerBound = upperBound - game.getUpperBound()/10;
			answer = lowerBound;
			if(game.guess(answer)==false){
				String temp = game.getMessage();
				if(temp.contains("small")){
					answer = scopeRandom(upperBound, lowerBound, game);
					break;
				}
				else if(temp.contains("large")){
					upperBound -= game.getUpperBound()/10;
					continue;
				}
			}
			else{
				break;
			}
		}
		answer = scopeRandom(upperBound, lowerBound, game);
		return answer;
	}
	
	public static int scopeRandom(int upperBound, int lowerBound, NumberGame game){
		int answer = 0;
		Random rand = new Random();
		while(true){
			answer = rand.nextInt(upperBound)+lowerBound;
			if(game.guess(answer)==false){
				if(game.getMessage().contains("small")){
					lowerBound = answer;
				}
				else if(game.getMessage().contains("large")){
					upperBound = answer;
				}
			}
			else{
				return answer;
			}
		}
	}
	
}
