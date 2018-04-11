package applicationUI;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LastGuessView implements Observer{
	
	private Stage stage;
	private Label hint;
	private Label lastGuess;
	private Counter counter;
	
	public LastGuessView(Counter counter){
		this.counter = counter;
		
		stage = new Stage();
		VBox root = new VBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		
		Label message = new Label("LastGuess");
		message.setFont(new Font("Arial", 20.0));
		message.setAlignment(Pos.CENTER);
		
		hint = new Label();
		hint.setFont(new Font("Arial", 20.0));
		hint.setAlignment(Pos.CENTER);
		
		
		lastGuess = new Label("0");
		lastGuess.setFont(new Font("Arial", 50.0));
		lastGuess.setAlignment(Pos.CENTER);
		
		root.getChildren().add(message);
		root.getChildren().add(lastGuess);
		root.getChildren().add(hint);
		
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.setTitle("LastGuess");
		
	}
	@Override
	public void update(Observable o, Object arg) {
		hint.setText(counter.getHint());
		lastGuess.setText(String.valueOf(counter.getLast()));
	}
	
	public void run(){
		stage.show();
	}
	
	public void stop(){
		stage.close();
	}
	

}
