import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);

	}

	public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        
        primaryStage.setTitle("[MAD300 Java Lab 10]");
        primaryStage.setScene(new Scene(pane, 800, 600));
        primaryStage.show();
	}
}
