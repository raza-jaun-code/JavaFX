import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class RegisterView {
User currentUser;
	
	public RegisterView(User currentUser) {
		this.currentUser = currentUser;
	}
		
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public Scene showView(Stage stage){
		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setAlignment(Pos.CENTER);
		
		Label firstNameLabel= new Label("First Name");
		firstNameLabel.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 15));
	   	firstNameLabel.setStyle("-fx-text-fill: white;");
		TextField firstNameField = new TextField();
		root.add(firstNameLabel, 1, 1);
		root.add(firstNameField, 2, 1);
		
		Label lastNameLabel= new Label("Last Name");
		lastNameLabel.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 15));
	   	lastNameLabel.setStyle("-fx-text-fill: white;");
		TextField lastNameField = new TextField();
		root.add(lastNameLabel, 1, 2);
		root.add(lastNameField, 2, 2);
		
		Label usernameLabel= new Label("Username");
		usernameLabel.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 15));
	   	usernameLabel.setStyle("-fx-text-fill: white;");
		TextField usernameField = new TextField();
		usernameField.setTooltip(new Tooltip("Username can contain only lowercase letters"));
		root.add(usernameLabel, 1, 3);
		root.add(usernameField, 2, 3);
		
		Label passwordLabel = new Label("Password");
		passwordLabel.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 15));
	   	passwordLabel.setStyle("-fx-text-fill: white;");
		PasswordField passwordField= new PasswordField();
		root.add(passwordLabel, 1, 4);
		root.add(passwordField, 2, 4);
		
		Label verifyLabel = new Label("Verify Password");
		verifyLabel.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 15));
	   	verifyLabel.setStyle("-fx-text-fill: white;");
		PasswordField verifyField= new PasswordField();
		root.add(verifyLabel, 1, 5);
		root.add(verifyField, 2, 5);
		
		
		Label PhoneLabel= new Label("Phone");
		PhoneLabel.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 15));
	   	PhoneLabel.setStyle("-fx-text-fill: white;");
		root.add(PhoneLabel, 1, 6);
		TextField PhoneField= new TextField();
		PhoneField.setTooltip(new Tooltip("Phone number should be of the format 03XXXXXXXXX"));
		root.add(PhoneField, 2, 6);
		
		Label professionLabel= new Label("Profession");
		professionLabel.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 15));
	   	professionLabel.setStyle("-fx-text-fill: white;");
		root.add(professionLabel, 1, 7);
		@SuppressWarnings("rawtypes")
		ComboBox  professionDropDown= new ComboBox();
		professionDropDown.getItems().add("Cashier");
		root.add(professionDropDown, 2, 7);
		
		HBox hb= new HBox();
		Button signupButton= new Button("Add User");
		Button back = new Button("Back");
		signupButton.setFont(Font.font("Calibri", FontWeight.BOLD, 15));
	    signupButton.setTextFill(Color.GREEN);
	    back.setFont(Font.font("Calibri", FontWeight.BOLD, 15));
	    back.setTextFill(Color.WHITE);
	    back.setStyle("-fx-background-color: green;");
	    hb.setMargin(back, new Insets(0,10,0,10));
	    hb.getChildren().addAll(signupButton, back);
		root.add(hb, 2, 10);
		
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				AllEmployeeView aev = new AllEmployeeView(currentUser);
				Scene sc = aev.showView(stage);
				stage.setScene(sc);
			}
			
		});
		
		signupButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				String firstName= firstNameField.getText();
				String lastName= lastNameField.getText();
				String username= usernameField.getText();
				String password= passwordField.getText();
				String verifyPassword= verifyField.getText();
				String phone=PhoneField.getText();
				String profession = (String)professionDropDown.getValue();
				String salary ="";
				
				
				UserController uc= new UserController();
				if(username.matches("[_\\da-z]{3,}") && phone.matches("03[1-9]\\d{8}") && (!firstName.isEmpty()) && (!lastName.isEmpty()) && (!password.isEmpty()) && (!verifyPassword.isEmpty()) && (!phone.isEmpty()) && (!profession.isEmpty())) {
				boolean isRegistered = uc.signUp(firstName, lastName, username, password, verifyPassword, phone, profession, salary);
				if(isRegistered){
					Alert successAlert= new Alert(AlertType.CONFIRMATION);
					successAlert.setHeaderText("The user was registered successfully!");
					successAlert.showAndWait();
					AdministratorView lv= new AdministratorView(currentUser);
					
					stage.setScene(lv.showView(stage));
					successAlert.close();
				}
				else if(!password.equals(verifyPassword)) {
					
					Alert errorAlert= new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("Password should match!!");
					errorAlert.show();
				}
				}
				else{
					Alert errorAlert= new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("The user was not registered successfully!Make sure that the fields are not empty and the credentials match the format!!");
					errorAlert.show();
				}
			}
		
			
		});
		 root.setStyle("-fx-background-image: url('assets/green-stock.jpg'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-size: cover") ;
		
		Scene scene = new Scene(root, 480,500);
		stage.setTitle("Add Employee - UBIT Sports Shop");
		return scene;
	}

}
