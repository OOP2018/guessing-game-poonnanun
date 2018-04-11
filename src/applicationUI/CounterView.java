package applicationUI;

import java.util.Observable;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CounterView implements java.util.Observer{

	private Stage stage;
	private Label label;
	private Counter counter;
	
	public CounterView(Counter counter){
		this.counter = counter;
		
		// Create Stage
		stage = new Stage();
		FlowPane root = new FlowPane();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		
		Label message = new Label("Total Guess : ");
		message.setFont(new Font("Arial", 20.0));
		message.setAlignment(Pos.CENTER);
		
		label = new Label();
		label.setFont(new Font("Arial", 50.0));
		label.setText("0");
		label.setAlignment(Pos.CENTER);
		
		root.getChildren().add(message);
		root.getChildren().add(label);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Counter");
		stage.sizeToScene();	
	}
	
	@Override
	public void update(Observable o, Object arg) {
		label.setText(String.valueOf(counter.getCount()));
	}
	
	public void run(){
		stage.show();
	}
	
	public void stop(){
		stage.close();
	}
	

}
