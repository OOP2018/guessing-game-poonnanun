package applicationUI;

import game.NumberGame;
import game.OuGuessingGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainUIController {
	@FXML
	private Label guide;
	
	@FXML
	private Button play;
	
	@FXML
	private Button quit;
	
	@FXML
	private TextField number;
	
	private Counter counter;
	private NumberGame game;
	private static Alert error = new Alert(Alert.AlertType.WARNING);
	
	@FXML
	public void initialize(){
		counter = new Counter();
		guide.setText("What is your maximum number?");
		play.setText("Play");
		number.clear();
		
	}
	
	public void setCounter(Counter counter){
		this.counter = counter;
	}
	
	@FXML
	public void playClick(ActionEvent e){
		if(play.getText().equalsIgnoreCase("play")){
			String max = number.getText();
			if(max == null) {
				error.setHeaderText("Input the maximum number");
				error.show();
				return;
			}
			game = new OuGuessingGame(Integer.parseInt(max));
			guide.setText("Guess the secret number!!!");
			play.setText("Guess");
			counter.setMax(max);
			number.clear();
		}
		else if(play.getText().equalsIgnoreCase("guess")){
			counter.count();
			String guessNum = number.getText();
			
			if(guessNum == null) {
				error.setHeaderText("Input the maximum number");
				error.show();
				return;
			}
			
			int num = Integer.parseInt(number.getText());
			counter.setLast(num);
			number.clear();
			if(game.guess(num)){
				Main.finish(num);
				initialize();
			}
			else{
				System.out.println(game.getMessage());
				counter.setHint(game.getMessage());
				
			}
		}
	}
	
	@FXML
	public void quitGame(ActionEvent e){
		System.exit(1);
	}
}
