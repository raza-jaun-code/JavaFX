import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AdministratorView{
	
	User currentUser;
	
	public AdministratorView(User currentUser) {
		this.currentUser = currentUser;
	}
		
		@SuppressWarnings("static-access")
		public Scene showView(Stage st) {
			
			BorderPane Pane = new BorderPane();
			
			Pane.setStyle("-fx-background-image: url('assets/goal-background.jpg'); " +
			           "-fx-background-position: center center; " +
			           "-fx-background-repeat: stretch;" +
			           "-fx-background-size: 800 639");
			
			MenuBar mBar = new MenuBar();
			mBar.setStyle("-fx-background-color: #90EE90;");
	
			Menu Employees = new Menu("Employees");
			
			MenuItem Add= new MenuItem("Add");
			Add.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					RegisterView sv = new RegisterView(currentUser);
					Scene sc = sv.showView(st);
					st.setScene(sc);
		
				}
				
			});
			
			
			Menu View= new Menu("View");
	
			MenuItem All= new MenuItem("View All Employees");
			
			All.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					AllEmployeeView aev = new AllEmployeeView(currentUser);
					Scene sc = aev.showView(st);
					st.setScene(sc);
				}
				
			});
			
			
			View.getItems().add(All)	;
			
			Employees.getItems().addAll(View, Add );
			
			
			mBar.getMenus().add(Employees);
			
			HBox h= new HBox();
			
			Button logout= new Button("Log Out");
			logout.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
			logout.setTextFill(Color.GREEN);
			Button cancel= new Button("Cancel");
			cancel.setStyle("-fx-background-color: green;");
			cancel.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
			cancel.setTextFill(Color.WHITE);
			
			h.getChildren().addAll(logout,cancel);
			h.setAlignment(Pos.BOTTOM_CENTER);
			h.setPadding(new Insets(20,20,20,20));
			h.setMargin(logout, new Insets(0,20,0,0));
		
			Pane.setTop(mBar);
			Pane.setBottom(h);
			
	
            logout.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					st.setScene(new LoginView().showView(st));
					
				}
           
            });
            
            cancel.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.exit(0);
					
				}
            	
            });
			
			
			
			Scene scene = new Scene(Pane,800,539);
			st.setScene(scene);
			st.setTitle("Admin - UBIT Sports Shop");
			st.show();
			return scene;
			
	
			
				}

	}
	