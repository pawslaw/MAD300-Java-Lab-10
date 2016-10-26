import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Form extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		
		primaryStage.setTitle("[MAD300 Java Lab 10]");
        primaryStage.setScene(new Scene(pane, 800, 600));
        primaryStage.show();
	}
	
}
