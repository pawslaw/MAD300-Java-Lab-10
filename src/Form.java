import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Form extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage primaryStage) {
		// Create the initial StackPane
		StackPane pane = new StackPane();
		// Create a form title
		Text title = new Text("Flying Club Form");
		// Create a subtitle
		Text subTitle = new Text("Join the Flying Club today!\n"
							+"Fill out the form below:");
		// Create an VBox for the title
		VBox titleBox = new VBox();
		titleBox.getChildren().addAll(title, subTitle);
		
		
		
		
		
		pane.getChildren().add(titleBox);
		
		primaryStage.setTitle("[MAD300 Java Lab 10]");
        primaryStage.setScene(new Scene(pane, 800, 600));
        primaryStage.show();
	}
	
}
