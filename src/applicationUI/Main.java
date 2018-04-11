package applicationUI;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;


public class Main extends Application {
	private static CounterView counterView;
	private static LastGuessView lastGuessView;
	
	@Override
	public void start(Stage primaryStage) {
		Counter counter = new Counter();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainUI.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			MainUIController controller = loader.getController();
			controller.setCounter(counter);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		counterView = new CounterView(counter);
		counter.addObserver(counterView);
		
		lastGuessView = new LastGuessView(counter);
		counter.addObserver(lastGuessView);
		
		counterView.run();
		lastGuessView.run();
		
	}
	
	public static void finish(int number){
		counterView.stop();
		lastGuessView.stop();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
