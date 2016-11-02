import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		// Create the initial BorderPane
		BorderPane formpane = new BorderPane();
		// Create a form title
		Text title = new Text("Flying Club Form");
		// Create a subtitle
		Text subTitle = new Text("Join the Flying Club today!\n" + "Fill out the form below:");
		// Create an VBox for the title
		VBox titleBox = new VBox();
		// Check if there is an image file, if so create it, if not then add something in as a default value
		if (new File("./images/skydiving_gregpalmer_flickr.jpg").isFile()) {
			ImageView mainImage = new ImageView(new Image("file:./images/skydiving_gregpalmer_flickr.jpg"));
			mainImage.setPreserveRatio(true);
			mainImage.setFitHeight(300);
			mainImage.setFitWidth(400);
			titleBox.getChildren().addAll(title, mainImage, subTitle);
		} else {
			Text mainImage = new Text("FLYING IS FUN!");
			titleBox.getChildren().addAll(title, mainImage, subTitle);
		}
		/* END OF TITLE */

		/* PERSONAL INFORMATION */
		// Get the student's basic information
		Text personalinfoText = new Text("Please enter your personal information:");
		TextField firstName = new TextField();
		TextField lastName = new TextField();
		TextField studentNumber = new TextField();
		TextField email = new TextField();
		TextField phoneNumber = new TextField();
		firstName.setPromptText("First Name");
		firstName.setMaxWidth(200);
		lastName.setPromptText("Last Name");
		lastName.setMaxWidth(200);
		studentNumber.setPromptText("Student #");
		studentNumber.setMaxWidth(200);
		// Get the student's contact information
		Text contactText = new Text("Please enter your contact information (Information will be kept confidential):");
		email.setPromptText("Prefered Email Address");
		email.setMinWidth(300);
		phoneNumber.setPromptText("Phone Number Ex: (555) 555-5555");
		phoneNumber.setMinWidth(300);
		// Create the boxes to store the sets of Texts and TextFields
		HBox personalinfoRow1 = new HBox();
		HBox personalinfoRow2 = new HBox();
		personalinfoRow1.getChildren().addAll(firstName, lastName, studentNumber);
		personalinfoRow2.getChildren().addAll(email, phoneNumber);
		VBox personalinfoBox = new VBox();
		personalinfoBox.getChildren().addAll(personalinfoText, personalinfoRow1, contactText, personalinfoRow2);
		/* END OF PERSONAL INFORMATION */

		/* YEAR OF ENROLLMENT BUTTON */
		// Create the text for the radio group
		Text buttonGroupText = new Text("Select your current year of enrollment or if you are a faculty member:");
		// Create new radio button group
		ToggleGroup radioButtonGroup = new ToggleGroup();
		// Create the radio buttons
		ArrayList<RadioButton> buttons = new ArrayList<RadioButton>(4);
		for (int i = 0; i < 3; i++) {
			buttons.add(new RadioButton("Year " + (i + 1)));
		}
		buttons.add(new RadioButton("Faculty"));
		// Assign the buttons to the toggle group
		// Create HBox to store the buttons
		HBox buttonBox = new HBox();
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setToggleGroup(radioButtonGroup);
			buttonBox.getChildren().add(buttons.get(i));
		}
		// Create a VBox to store the buttons and button heading
		VBox studentYearBox = new VBox();
		// Add the button group to the VBox
		studentYearBox.getChildren().addAll(buttonGroupText, buttonBox);
		/* END OF YEAR OF ENROLLMENT */

		/* EXPERIENCE SECTION */
		Text listText = new Text("Select your amount of flying experience:");
		ListView<String> list = new ListView<>();
		list.getItems().addAll("Less than 1 year", "1-2 years", "3-4 years", "5-6 years", "7+ years");
		list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		list.setMaxSize(150, 150);
		VBox listBox = new VBox();
		listBox.getChildren().addAll(listText, list);
		/* END OF EXPERIENCE */

		/* INTERESTS, HOBBIES, AND REASON TO JOIN */
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
		/* END OF INTERESTS, HOBBIES, REASON */

		/* CLEAR AND SUBMIT BUTTONS */
		Button clear = new Button("CLEAR");
		Button submit = new Button("SUBMIT");
		HBox submitBox = new HBox();

		/**
		 * 
		 * Plays a sound when the user submits the form
		 * @author Nicholas Allaire <nicholas.allaire85@stclairconnect.ca>
		 * @author Brandon Brown <brandon.brown22@stclairconnect.ca>
		 * @version 1.0
		 * @param	EventHandler containing the handle method that creates the Media,
		 * 			MediaPlayer and then plays the audio file for the user.
		 * 
		 * 			After the sound plays, the form is "submitted" and a new line is
		 * 			added to the output file with the form's contents.
		 * 
		 */
		submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	// TODO: swap in a different audio file unless team likes this one
            	Media media = new Media(new File("./audio/submitsound.wav").toURI().toString());
        		MediaPlayer soundplayer = new MediaPlayer(media);
        		soundplayer.play();
        		
        		ArrayList<String> submissionArray = new ArrayList<String>();
        		String selectedButton = "";
        		for (int i = 0; i < buttons.size(); i++) if (buttons.get(i).isSelected()) selectedButton = buttons.get(i).getText();
        		String selectedItem = "";
        		if (list.getSelectionModel().getSelectedItem() == null) {
        			selectedItem = "";
        		} else {
        			selectedItem = list.getSelectionModel().getSelectedItem();
        		}
        		submissionArray.add(firstName.getText());
        		submissionArray.add(lastName.getText());
        		submissionArray.add(studentNumber.getText());
        		submissionArray.add(email.getText());
        		submissionArray.add(phoneNumber.getText());
        		submissionArray.add(selectedButton);
        		submissionArray.add(selectedItem);
        		submissionArray.add(interestsArea.getText());
        		submissionArray.add(whyJoinArea.getText());
        		
        		OutputCSV out = new OutputCSV(submissionArray, ",", "output.csv");
        		out.writeArrayToFile();
        		
        		submissionArray.clear();
        		
        		firstName.setText("");
        		lastName.setText("");
        		studentNumber.setText("");
        		email.setText("");
        		phoneNumber.setText("");
        		for (int i = 0; i < buttons.size(); i++) {
        			if (buttons.get(i).isSelected()) {
        				buttons.get(i).setSelected(false);
        			}
        		}
        		list.getSelectionModel().clearSelection();
        		interestsArea.setText("");
        		whyJoinArea.setText("");
            }
        });
		clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	// TODO: swap in a different audio file unless team likes this one
            	Media media = new Media(new File("./audio/submitsound.wav").toURI().toString());
        		MediaPlayer soundplayer = new MediaPlayer(media);
        		soundplayer.play();
        		
        		
        		
        		
        		firstName.setText("");
        		lastName.setText("");
        		studentNumber.setText("");
        		email.setText("");
        		phoneNumber.setText("");
        		for (int i = 0; i < buttons.size(); i++) {
        			if (buttons.get(i).isSelected()) {
        				buttons.get(i).setSelected(false);
        			}
        		}
        		list.getSelectionModel().clearSelection();
        		interestsArea.setText("");
        		whyJoinArea.setText("");
            }
        });
		// clear.setOnMouseClicked(playSound());
		submitBox.getChildren().addAll(clear, submit);
		/* END OF CLEAR AND SUBMIT BUTTONS */

		// Create a VBox to store the form and submit/clear buttons
		VBox formBox = new VBox();
		// Add the form nodes to the form box
		formBox.getChildren().addAll(personalinfoBox, studentYearBox, listBox, interestsBox, whyJoinBox, submitBox);

		// Create credits and copyright info text nodes
		Text credits = new Text("Form created by Brandon Brown, Tyler Mackenzie, and Nicholas Allaire");
		Text copyrightInfo = new Text("Copyright� 2016 - Brandon Brown, Tyler Mackenzie, Nicholas Allaire");
		// Create a VBox to store the copyright and text info nodes
		VBox footerBox = new VBox();
		footerBox.getChildren().addAll(credits, copyrightInfo);

		formpane.setTop(titleBox);
		formpane.setCenter(formBox);
		formpane.setBottom(footerBox);

		primaryStage.setTitle("[MAD300 Java Lab 10]");
		primaryStage.setScene(new Scene(formpane, 800, 900));
		primaryStage.show();
	}
	
	/**
	 * 
	 * Creates a FadeTransition and applies it to a TextArea, the in playes
	 * the transition
	 * @author Nicholas Allaire <nicholas.allaire85@stclairconnect.ca>
	 * @version 1.0
	 * @param	TextArea to apply the FadeTransition to
	 * 
	 */
	public static void textareaFade(TextArea textarea) {
		FadeTransition ft = new FadeTransition(Duration.millis(3000), textarea);
		ft.setFromValue(1.0);
		ft.setToValue(0);
		ft.setAutoReverse(false);
		ft.play();
	}
	/**
	 * 
	 * Creates a FadeTransition and applies it to a TextField, the in playes
	 * the transition
	 * @author Nicholas Allaire <nicholas.allaire85@stclairconnect.ca>
	 * @version 1.0
	 * @param	TextField to apply the FadeTransition to
	 * 
	 */
	public static void textfieldFade(TextField textfield) {
		FadeTransition ft = new FadeTransition(Duration.millis(3000), textfield);
		ft.setFromValue(1.0);
		ft.setToValue(0);
		ft.setAutoReverse(false);
		ft.play();
	}
	
}
