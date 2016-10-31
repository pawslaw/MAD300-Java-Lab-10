import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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
		/* TITLE */
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
		/* END OF TITLE */
		
		
		/* PERSONAL INFORMATION */
		
		
		/* YEAR OF ENROLLMENT BUTTON */
		// Create the text for the radio group
		Text buttonGroupText = new Text("Select your current year of enrollment or if you are a faculty member:");
		// Create new radio button group
		ToggleGroup radioButtonGroup = new ToggleGroup();
		// Create the radio buttons
		ArrayList<RadioButton> buttons = new ArrayList<RadioButton>(4);
		for (int i = 0; i < 3; i++) {buttons.add(new RadioButton("Year "+(i+1)));}
		buttons.add(new RadioButton("Faculty"));
		// Assign the buttons to the toggle group
		// Create HBox to store the buttons
		HBox buttonBox = new HBox();
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setToggleGroup(radioButtonGroup);
			buttonBox.getChildren().add(buttons.get(i));
		}
		// Create a VBox to store the buttons and button heading
		VBox headingWithButtons = new VBox();
		// Add the button group to the VBox
		headingWithButtons.getChildren().addAll(buttonGroupText, buttonBox);
		/* END OF YEAR OF ENROLLMENT */
		
		// Create the interests portion of the form
		Text interestsText = new Text("Tell us some of your interests or hobbies:");
		TextArea interestsArea = new TextArea();
		interestsArea.setMaxSize(450, 100);
		interestsArea.setEditable(true);
		interestsArea.setWrapText(true);
		VBox interestsBox = new VBox();
		interestsBox.getChildren().addAll(interestsText, interestsArea);
		
		// Create the Why Are you Joining form
		Text whyJoinText = new Text("Tell us why you would like to join the Flying Club:");
		TextArea whyJoinArea = new TextArea();
		whyJoinArea.setMaxSize(450, 100);
		whyJoinArea.setEditable(true);
		whyJoinArea.setWrapText(true);
		VBox whyJoinBox = new VBox();
		whyJoinBox.getChildren().addAll(whyJoinText, whyJoinArea);
		
		
		
		//Create a VBox to store the form and submit buttons
		VBox formBox = new VBox();
		// Add the form nodes to the form box
		formBox.getChildren().addAll(headingWithButtons,interestsBox,whyJoinBox);
		
		// Create credits and copyright info text nodes
		Text credits = new Text("Form created by Brandon Brown, Tyler Mackenzie, and Nicholas Allaire");
		Text copyrightInfo = new Text("Copyright© 2016 - Brandon Brown, Tyler Mackenzie, Nicholas Allaire");
		// Create a VBox to store the copyright and text info nodes
		VBox footerBox = new VBox();
		footerBox.getChildren().addAll(credits, copyrightInfo);
		
		formpane.setTop(titleBox);
		formpane.setCenter(formBox);
		formpane.setBottom(footerBox);
		
		primaryStage.setTitle("[MAD300 Java Lab 10]");
        primaryStage.setScene(new Scene(formpane, 800, 1000));
        primaryStage.show();
	}
	
}
