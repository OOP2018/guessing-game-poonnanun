import java.util.Random;

public class OuGuessingGame extends NumberGame{

	private int upperBound;
	private int secret;
	
	public OuGuessingGame(){
		this(100);
	}
	
	public OuGuessingGame(int upperBound){
		this.upperBound = upperBound;
		Random rand = new Random();
		this.secret = rand.nextInt(this.upperBound) + 1;
	}
	@Override
	public boolean guess(int answer){
		if (answer == this.secret) {
    		setMessage("Correct! The secret value is "+secret);
    		return true;
    	}
    	if (answer < 3*this.secret/4) {
    		setMessage("Woah! Your answer is WAY too small.");
    	}
    	else if (answer < this.secret) {
    		setMessage("Your answer is too small.");
    	}
    	else if (answer > this.secret*4/3) {
    		setMessage("No way! Your answer is WAY too large.");
    	}
    	else /* if (number > secret) */ {
    		setMessage("Your answer is too large.");
    	}
    	return false;
	}
	
	public int getUpperBound(){
		return upperBound;
	}
	
	@Override
	public String toString(){
		return null;
	}
	
	
}


