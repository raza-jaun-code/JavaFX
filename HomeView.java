import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HomeView  {
	
	@SuppressWarnings("static-access")
	public Scene showView(Stage St) {
		
		Button b1=new Button("Exit");
		Font font2 = Font.font("Arial", FontWeight.BOLD, 20);
		b1.setFont(font2);
		b1.setTextFill(Color.WHITE);
		b1.setStyle("-fx-background-color: green;");
		
		Button b2=new Button("Login");
		Font font4 = Font.font("Arial", FontWeight.BOLD, 20);
		b2.setFont(font4);
		b2.setTextFill(Color.GREEN);
		
		HBox hb= new HBox();
		hb.getChildren().addAll(b2 , b1);
		hb.setPadding(new Insets(5, 5, 5, 5));
		hb.setMargin(b2, new Insets(0, 30, 0, 20));
		hb.setAlignment(Pos.CENTER);
	
		VBox vb=new VBox();
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
		 
		Text t = new Text();
		t.setEffect(ds);
		t.setCache(true);
		t.setX(10.0f);
		t.setY(270.0f);
		t.setFill(Color.BLACK);
		t.setText("UBIT SPORTS SHOP");
		t.setFont(Font.font(null, FontWeight.BOLD, 50));
		
		Text t1 = new Text();
		t1.setFill(Color.BLACK);
		t1.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 22));
		t1.setText(" UBIT Sports Shop is a specialist sports shop."+ System.lineSeparator()
				+ " that caters to the needs of cricket and football enthusiasts" + System.lineSeparator()
				+ " The store boasts an impressive collection of high-quality cricket bats, "+ System.lineSeparator()
				+ " balls, and equipment from renowned brands."); 
		t1.setTextAlignment(TextAlignment.CENTER);
		vb.getChildren().addAll(t,t1,hb);
		vb.setSpacing(45);
		vb.setAlignment(Pos.CENTER);

		Scene sc=new Scene(vb,700,500);
		
		St.setScene(sc);
		St.setTitle("UBIT Sports Shop");
		St.getIcons().add(new Image("assets/sports_icon.jpg"));
	    vb.setStyle("-fx-background-image: url('assets/white-illustration.png'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: no-repeat;" +
		           "-fx-background-size: stretch;" +
				   "-fx-opacity: 0.67;");
	    St.setResizable(false);
	
		
		St.show();
		
		b2.setOnAction(new EventHandler<ActionEvent>( ) {
			public void handle (ActionEvent arg0) {
				St.setScene(new LoginView().showView(St));
			}
		});
		
	
		
		b1.setOnAction(new EventHandler<ActionEvent>( ) {
		public void handle (ActionEvent arg0) {
			System.exit(0);
		}
	});
		return sc;

}}
	
	