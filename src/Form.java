import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
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
		// Create the initial BorderPane
		BorderPane formpane = new BorderPane();
		// Create a form title
		Text title = new Text("Flying Club Form");
		// Create the Image file
		// TODO: DETECT IF THERE IS A PHOTO, IF THERE ISN'T, PUT SOMETHING IN AS DEFAULT
		ImageView mainImage = new ImageView(new Image("file:./images/skydiving_gregpalmer_flickr.jpg"));
		// TODO: DETECT ASPECT RATIO OF IMAGE BEFORE SIZING AND SCALE PROPORTIONALLY
		mainImage.setFitWidth(300);
		mainImage.setFitHeight(200);
		// Create a subtitle
		Text subTitle = new Text("Join the Flying Club today!\n"
							+"Fill out the form below:");
		// Create an VBox for the title
		VBox titleBox = new VBox();
		titleBox.getChildren().addAll(title, mainImage, subTitle);
		
		
		
		
		
		
		
		
		
		
		
		// Create credits and copyright info text nodes
		Text credits = new Text("Form created by Brandon Brown, Tyler Mackenzie, and Nicholas Allaire");
		Text copyrightInfo = new Text("Copyright © 2016 - Brandon Brown, Tyler Mackenzie, Nicholas Allaire");
		// Create a VBox to store the copyright and text info nodes
		VBox footerBox = new VBox();
		footerBox.getChildren().addAll(credits, copyrightInfo);
		
		
		formpane.setTop(titleBox);
		formpane.setBottom(footerBox);
		
		primaryStage.setTitle("[MAD300 Java Lab 10]");
        primaryStage.setScene(new Scene(formpane, 800, 600));
        primaryStage.show();
	}
	
}
