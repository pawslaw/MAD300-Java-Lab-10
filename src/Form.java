import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
		
		// Create the text for the radio group
		Text buttonGroupText = new Text("Select your current year of enrollment or if you are a faculty member:");
		// Create new radio button group
		ToggleGroup radioButtonGroup = new ToggleGroup();
		// Create the radio buttons
		RadioButton firstyearButton = new RadioButton("1st Year");
		firstyearButton.setUserData("1st Year");
		RadioButton secondyearButton = new RadioButton("2nd Year");
		secondyearButton.setUserData("2nd Year");
		RadioButton thirdyearButton = new RadioButton("3rd Year");
		thirdyearButton.setUserData("3rd Year");
		RadioButton facultyButton = new RadioButton("Faculty");
		facultyButton.setUserData("Faculty");
		// Assign the buttons to the toggle group
		firstyearButton.setToggleGroup(radioButtonGroup);
		firstyearButton.setSelected(true);
		secondyearButton.setToggleGroup(radioButtonGroup);
		thirdyearButton.setToggleGroup(radioButtonGroup);
		facultyButton.setToggleGroup(radioButtonGroup);
		
		
		
		
		
		
		
		
		
		
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
