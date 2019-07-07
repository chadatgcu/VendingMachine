import java.awt.LayoutManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.JPanel;



public class GUIDispenser extends Application implements EventHandler<ActionEvent> {

	
	Button aBtn;
	Button bBtn;
	Button cBtn;
	Button dBtn;
	Button eBtn;
	Button oneBtn;
	Button twoBtn;
	Button threeBtn;
	Button fourBtn;
	Button fiveBtn;
	Button OKBtn;
	Button drinksBtn;
	Button gumBtn;
	Button candyBtn;
	Button chipsBtn;
	Button snacksBtn;
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage window) throws Exception {
		window.setTitle("Yellow Raptor Co. Dispenser");
		
		StackPane layout = new StackPane();
		Text guidanceBar = new Text("Please Make a Selection");
		layout.getChildren().add(guidanceBar);
		
		aBtn = new Button();
		aBtn.setText("A");
		aBtn.setOnAction(this);
		aBtn.setPadding(new Insets(5, 5, 5, 5));
		
		bBtn = new Button();
		bBtn.setText("B");
		bBtn.setPadding(new Insets(5, 5, 5, 5));
		bBtn.setOnAction(this);
		
		cBtn = new Button();
		cBtn.setText("C");
		cBtn.setPadding(new Insets(5, 5, 5, 5));
		cBtn.setOnAction(this);
		
		dBtn = new Button();
		dBtn.setText("D");
		dBtn.setPadding(new Insets(5, 5, 5, 5));
		dBtn.setOnAction(this);
		
		eBtn = new Button();
		eBtn.setText("E");
		eBtn.setPadding(new Insets(5, 5, 5, 5));
		eBtn.setOnAction(this);
		

	
		
		
		oneBtn = new Button();
		oneBtn.setText("1");
		oneBtn.setPadding(new Insets(5, 5, 5, 5));
		oneBtn.setOnAction(this);
		
		twoBtn = new Button();
		twoBtn.setText("2");
		twoBtn.setPadding(new Insets(5, 5, 5, 5));
		twoBtn.setOnAction(this);
		
		threeBtn = new Button();
		threeBtn.setText("3");
		threeBtn.setPadding(new Insets(5, 5, 5, 5));
		threeBtn.setOnAction(this);
		
		fourBtn = new Button();
		fourBtn.setText("4");
		fourBtn.setPadding(new Insets(5, 5, 5, 5));
		fourBtn.setOnAction(this);
		
		fiveBtn = new Button();
		fiveBtn.setText("5");
		fiveBtn.setPadding(new Insets(5, 5, 5, 5));
		fiveBtn.setOnAction(this);
		
		Button OKBtn = new Button();
		OKBtn.setText("OK");
		OKBtn.setPadding(new Insets(5, 5, 5, 5));
		OKBtn.setOnAction(this);
		
		
		VBox lettersAndNumbers = new VBox();
		lettersAndNumbers.getChildren().add(aBtn);
		lettersAndNumbers.getChildren().add(bBtn);
		lettersAndNumbers.getChildren().add(cBtn);
		lettersAndNumbers.getChildren().add(dBtn);
		lettersAndNumbers.getChildren().add(eBtn);
		lettersAndNumbers.getChildren().add(oneBtn);
		lettersAndNumbers.getChildren().add(twoBtn);
		lettersAndNumbers.getChildren().add(threeBtn);
		lettersAndNumbers.getChildren().add(fourBtn);
		lettersAndNumbers.getChildren().add(fiveBtn);
		lettersAndNumbers.getChildren().add(OKBtn);
		layout.getChildren().add(lettersAndNumbers);
		
		
		
		drinksBtn = new Button();
		drinksBtn.setText("Drinks");
		drinksBtn.setPadding(new Insets(5, 5, 5, 5));
		drinksBtn.setOnAction(this);
		
		gumBtn = new Button();
		gumBtn.setText("Gum");
		gumBtn.setPadding(new Insets(5, 5, 5, 5));
		gumBtn.setOnAction(this);
		
		candyBtn = new Button();
		candyBtn.setText("Candy");
		candyBtn.setPadding(new Insets(5, 5, 5, 5));
		candyBtn.setOnAction(this);
		
		chipsBtn = new Button();
		chipsBtn.setText("Chips");
		chipsBtn.setPadding(new Insets(5, 5, 5, 5));
		chipsBtn.setOnAction(this);
		
		snacksBtn = new Button();
		snacksBtn.setText("Snacks");
		snacksBtn.setPadding(new Insets(5, 5, 5, 5));
		snacksBtn.setOnAction(this);
		
		HBox productType = new HBox();
		productType.getChildren().add(drinksBtn);
		productType.getChildren().add(gumBtn);
		productType.getChildren().add(candyBtn);
		productType.getChildren().add(chipsBtn);
		productType.getChildren().add(snacksBtn);
		layout.getChildren().add(productType);
		
		
		Scene scene = new Scene(layout, 640, 480);
		
		window.setScene(scene);
		window.setResizable(false);
		window.setFullScreen(true);
		// this is for utility/kiosk mode
		// window.initStyle(StageStyle.UNDECORATED);
		
		window.show();
	}

	@Override
	public void handle(ActionEvent event) {
		// Handle button clicks
		if(event.getSource() == aBtn) {
			System.out.println("a");
		}
		
		if(event.getSource() == bBtn) {
			System.out.println("b");
		}
		
		if(event.getSource() == cBtn) {
			System.out.println("c");
		}
		
		if(event.getSource() == dBtn) {
			System.out.println("d");
		}
		
		if(event.getSource() == dBtn) {
			System.out.println("d");
		}
		
		if(event.getSource() == eBtn) {
			System.out.println("e");
		}
		
		if(event.getSource() == oneBtn) {
			System.out.println("1");
		}
		
		if(event.getSource() == twoBtn) {
			System.out.println("2");
		}
		
		if(event.getSource() == threeBtn) {
			System.out.println("3");
		}
		
		if(event.getSource() == fourBtn) {
			System.out.println("4");
		}
		
		if(event.getSource() == fiveBtn) {
			System.out.println("5");
		}
		
		if(event.getSource() == OKBtn) {
			System.out.println("OK!");
		}
		
	}
	
		
}
