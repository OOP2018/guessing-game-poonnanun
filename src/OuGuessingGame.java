import java.util.Random;
/**
 * Class about manager of guessing game.
 * @author Poonnanun Poonnopathum
 *
 */
public class OuGuessingGame extends NumberGame{

	private int upperBound;
	private int secret;
	private int count = 0;
	
	/**
	 * Set upperBound to 100 if upperBound haven't set before.
	 */
	public OuGuessingGame(){
		this(100);
	}
	/**
	 * Random a secret number and set the message describe about the clue.
	 * @param upperBound is a maximum number that can random.
	 */
	public OuGuessingGame(int upperBound){
		this.upperBound = upperBound;
		Random rand = new Random();
		this.secret = rand.nextInt(this.upperBound) + 1;
		super.setMessage("Number is between 1-"+upperBound);
	}
	/**
	 * Compare the number that we guess to the secret number and display the hint message
	 * @param answer is the answer that player type.
	 * @return true if it's correct, false if it's wrong.
	 */
	@Override
	public boolean guess(int answer){
		if (answer == this.secret) {
			count++;
    		return true;
    	}
    	if (answer < 3*this.secret/4) {
    		setMessage("That is too small.");
    	}
    	else if (answer < this.secret) {
    		setMessage("Just a little bit more.");
    	}
    	else if (answer > this.secret*4/3) {
    		setMessage("That is too large.");
    	}
    	else /* if (number > this.secret) */ {
    		setMessage("Just a little bit less.");
    	}
    	count++;
    	return false;
	}
	
	public int getCount(){
		return count++;
	}
	public int getUpperBound(){
		return upperBound;
	}
	
	@Override
	public String toString(){
		return "Guess the number";
	}
	
	
}


