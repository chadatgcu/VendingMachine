import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class GUIDisp extends Application {
	Stage window;
	GUI gui = new GUI();
	Button DrinksButton = new Button("Drinks");
    Button SnacksButton = new Button("Snacks");
    Button homebot = new Button("Exit");
    Button bot = new Button("Back to Previous Screen");
    Button last = new Button("Back to Previous Screen");
    Button CokeButton = new Button("Coke");
    Button SpriteButton = new Button("Sprite");
    Button PoweradeButton = new Button("Powerade");
    Button ChipButton = new Button("Chips");
    Button CandyButton = new Button("Candies");
    Button GumButton = new Button("Gum");
    Button OrbitButton = new Button("Orbit");
    Button HubbaBubbaButton = new Button("HubbaBubba");
    Button TridentButton = new Button("Trident");
    Button SkittlesButton = new Button("Skittles");
    Button SnickersButton = new Button("Snickers");
    Button SourPatchButton = new Button("Sour Patch");
    Button DoritosButton = new Button("Doritos");
    Button LaysButton = new Button("Lays");
    Button CheetosButton = new Button("Cheetos");
    //-------------------------------------------------
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
    	
    	pane();
    
        SnacksButton.setOnAction(e -> {
        	
        	Scene scene2 = new Scene(SnacksPage(), 1000, 700);
            window.setScene(scene2);
        });

        DrinksButton.setOnAction(e -> {

            
            Scene scene2 = new Scene(DrinkPage(), 1000, 700);
            window.setScene(scene2);
        });
        ChipButton.setOnAction(e -> {

        	Scene scene3 = new Scene(ChipPage(), 1000, 700) ;//CheckoutLayout);
            window.setScene(scene3);
        });
        CandyButton.setOnAction(e -> {

        	Scene scene2 = new Scene(Candy(), 1000, 700);//CheckoutLayout);
            window.setScene(scene2);
        });
        GumButton.setOnAction(e -> {

        	Scene scene2 = new Scene(GumBoard(), 1000, 700);//CheckoutLayout);
            window.setScene(scene2);
        });
        bot.setOnAction(e -> {
			Scene scene = new Scene(homeWindow(), 1000, 700);
			window.setScene(scene);
		});
        last.setOnAction(e -> {
        	Scene scene2 = new Scene(SnacksPage(), 1000, 700);
            window.setScene(scene2);
        });

        Scene scene = new Scene(homeWindow(), 1000, 700);
        window.setTitle("Test");
        window.setScene(scene);
        window.show();
        homebot.setOnAction(e -> window.close());
        
    }
    //---------------------------------
    public GridPane pane() {
    	ImageView Snackspic = new ImageView("snacks.jpg");
        ImageView Drinkspic = new ImageView("drinks.jpg");
        Label info = new Label("Click to go to Snacks");
        Label info1 = new Label("Click to go to Drinks");
        

		 GridPane pane = new GridPane();
	        pane.setAlignment(Pos.CENTER);
	        pane.setPadding(new Insets(0));
	        pane.setVgap(10);
	        pane.setHgap(100);

	        pane.add(Snackspic, 1, 1);
	        pane.add(Drinkspic, 2, 1);
	        pane.add(info, 1, 2);
	        pane.add(info1, 2, 2);
	        pane.add(SnacksButton, 1, 3);
	        pane.add(DrinksButton, 2, 3);
	        pane.setHalignment(info, HPos.CENTER);
	        pane.setHalignment(info1, HPos.CENTER);
	        pane.setHalignment(SnacksButton, HPos.CENTER);
	        pane.setHalignment(DrinksButton, HPos.CENTER);
	        DrinksButton.setStyle("-fx-background-color: black; -fx-border-color: white");
			DrinksButton.setTextFill(Color.WHITE);
			SnacksButton.setStyle("-fx-background-color: black; -fx-border-color: white");
			SnacksButton.setTextFill(Color.WHITE);
	        
	        return pane;
    }
    //------------------------
    public BorderPane homeWindow() {
		BorderPane images = new BorderPane();
		images.setStyle("-fx-background-color: lightblue; -fx-border-color: black");
		images.setTop(top());
		images.setPadding(new Insets(50,50,50,50));
		images.setCenter(pane());
		images.setBottom(homeBot());
		return images;
	}
	public HBox top() {
		HBox top = new HBox();
		Label label =  new Label("Welcome to Consumer Machine!!");
		top.setStyle("-fx-background-color: lightblue;-fx-border-color: black");
		label.setTextFill(Color.BLACK);
		top.setPadding(new Insets(0,0,0,350));
		top.getChildren().add(label);
		return top;
	}
	public Button bot() {
		bot.setStyle("-fx-background-color: black; -fx-border-color: white");
		bot.setTextFill(Color.WHITE);
		return bot;
	}
	public Button last() {
		last.setStyle("-fx-background-color: black; -fx-border-color: white");
		last.setTextFill(Color.WHITE);
		return last;
	}
	public Button homeBot() {
		homebot.setStyle("-fx-background-color: black; -fx-border-color: white");
		homebot.setTextFill(Color.WHITE);
		return homebot;
	}
	//-----------------------------------

    public GridPane Drink() {
    	
    	
		GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0));
        pane.setVgap(10);
        pane.setHgap(100);

        Drink drink1 = new Drink();
		drink1.setName("Coke");
		Drink drink2 = new Drink();
		drink2.setName("Sprite");
		Drink drink3 = new Drink();
		drink3.setName("PowerAID");

        Label info = new Label(drink1.nameAndPrice());
        Label info1 = new Label(drink2.nameAndPrice());
        Label info3 = new Label(drink3.nameAndPrice());
        
        pane.add(gui.Coke(), 1, 1);
        pane.add(gui.Sprite(), 2, 1);
        pane.add(gui.Powerade(), 3, 1);
        pane.add(CokeButton, 1, 3);
        pane.add(SpriteButton, 2, 3);
        pane.add(PoweradeButton, 3, 3);
        pane.add(info, 1, 2);
        pane.add(info1, 2, 2);
        pane.add(info3,3, 2);
        pane.setHalignment(info, HPos.CENTER);
        pane.setHalignment(info1, HPos.CENTER);
        pane.setHalignment(info3, HPos.CENTER);
        pane.setHalignment(gui.Coke(), HPos.CENTER);
        pane.setHalignment(gui.Sprite(), HPos.CENTER);
        pane.setHalignment(gui.Powerade(), HPos.CENTER);
        pane.setHalignment(CokeButton, HPos.CENTER);
        pane.setHalignment(SpriteButton, HPos.CENTER);
        pane.setHalignment(PoweradeButton, HPos.CENTER);
        CokeButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		CokeButton.setTextFill(Color.WHITE);
		SpriteButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		SpriteButton.setTextFill(Color.WHITE);
		PoweradeButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		PoweradeButton.setTextFill(Color.WHITE);
       /* CokeButton.setOnAction(e -> {

        	Scene scene2 = new Scene();//CheckoutLayout);
            primaryStage.setScene(scene2);
        });
        SpriteButton.setOnAction(e -> {

        	Scene scene2 = new Scene();//CheckoutLayout);
            primaryStage.setScene(scene2);
        });
        PoweradeButton.setOnAction(e -> {

        	Scene scene2 = new Scene();//CheckoutLayout);
            primaryStage.setScene(scene2);
        });*/
		return pane;
	}
    public BorderPane DrinkPage() {
		BorderPane drinks = new BorderPane();
		drinks.setStyle("-fx-background-color: lightblue; -fx-border-color: black");
		drinks.setTop(DrinksPage());
		drinks.setPadding(new Insets(50,50,50,50));
		drinks.setCenter(Drink());
		drinks.setBottom(bot());
		return drinks;
	}
	public HBox DrinksPage() {
		HBox top = new HBox();
		Label drinks = new Label("Welcome to the Drink Selection!");
		top.setStyle("-fx-background-color: lightblue;-fx-border-color: black");
		drinks.setTextFill(Color.BLACK);
		top.setPadding(new Insets(0,0,0,350));
		top.getChildren().add(drinks);
		return top;
	}
	//-------
	public GridPane SnackPage() {
		GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0));
        pane.setVgap(10);
        pane.setHgap(100);
        Label info = new Label("Click to go to Chips");
        Label info1 = new Label("Click to go to Candy");
        Label info3 = new Label("Click to go to Gum");

        pane.add(gui.Chips(), 1, 1);
        pane.add(gui.Candies(), 2, 1);
        pane.add(gui.Gums(), 3, 1);
        pane.add(ChipButton, 1, 3);
        pane.add(CandyButton, 2, 3);
        pane.add(GumButton, 3, 3);
        pane.add(info, 1, 2);
        pane.add(info1, 2, 2);
        pane.add(info3,3, 2);
        pane.setHalignment(gui.Chips(), HPos.CENTER);
        pane.setHalignment(gui.Gums(), HPos.CENTER);
        pane.setHalignment(gui.Candies(), HPos.CENTER);
        pane.setHalignment(info, HPos.CENTER);
        pane.setHalignment(info1, HPos.CENTER);
        pane.setHalignment(info3, HPos.CENTER);
        pane.setHalignment(ChipButton, HPos.CENTER);
        pane.setHalignment(CandyButton, HPos.CENTER);
        pane.setHalignment(GumButton, HPos.CENTER);
        ChipButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		ChipButton.setTextFill(Color.WHITE);
		CandyButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		CandyButton.setTextFill(Color.WHITE);
		GumButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		GumButton.setTextFill(Color.WHITE);
       
		return pane;
	}
	public BorderPane SnacksPage() {
		BorderPane snacks = new BorderPane();
		snacks.setStyle("-fx-background-color: lightblue; -fx-border-color: black");
		snacks.setTop(SnacksHeader());
		snacks.setPadding(new Insets(50,50,50,50));
		snacks.setCenter(SnackPage());
		snacks.setBottom(bot());
		return snacks;
	}
	public HBox SnacksHeader() {
		HBox top = new HBox();
		Label snacks = new Label("Welcome to Snack Selection!!");
		top.setStyle("-fx-background-color: lightblue;-fx-border-color: black");
		snacks.setTextFill(Color.BLACK);
		top.setPadding(new Insets(0,0,0,350));
		top.getChildren().add(snacks);
		return top;
	}
	
    //-----
    public GridPane GumPage() {
    	GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0));
        pane.setVgap(10);
        pane.setHgap(100);
        Label info = new Label("Minty chewing gum, $1.50");
        Label info1 = new Label("Fun chewing gum, $2.00");
        Label info3 = new Label("Refreshing chewing gum, $2.50");

        pane.add(gui.Orbit(), 1, 1);
        pane.add(gui.HubbaBubba(), 2, 1);
        pane.add(gui.Trident(), 3, 1);
        pane.add(OrbitButton, 1, 3);
        pane.add(HubbaBubbaButton, 2, 3);
        pane.add(TridentButton, 3, 3);
        pane.add(info, 1, 2);
        pane.add(info1, 2, 2);
        pane.add(info3,3, 2);
        pane.setHalignment(gui.HubbaBubba(), HPos.CENTER);
        pane.setHalignment(gui.Orbit(), HPos.CENTER);
        pane.setHalignment(gui.Trident(), HPos.CENTER);
        pane.setHalignment(info, HPos.CENTER);
        pane.setHalignment(info1, HPos.CENTER);
        pane.setHalignment(info3, HPos.CENTER);
        pane.setHalignment(OrbitButton, HPos.CENTER);
        pane.setHalignment(HubbaBubbaButton, HPos.CENTER);
        pane.setHalignment(TridentButton, HPos.CENTER);
        OrbitButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		OrbitButton.setTextFill(Color.WHITE);
		HubbaBubbaButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		HubbaBubbaButton.setTextFill(Color.WHITE);
		TridentButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		TridentButton.setTextFill(Color.WHITE);
       /* CokeButton.setOnAction(e -> {

        	Scene scene2 = new Scene();//CheckoutLayout);
            primaryStage.setScene(scene2);
        });
        SpriteButton.setOnAction(e -> {

        	Scene scene2 = new Scene();//CheckoutLayout);
            primaryStage.setScene(scene2);
        });
        PoweradeButton.setOnAction(e -> {

        	Scene scene2 = new Scene();//CheckoutLayout);
            primaryStage.setScene(scene2);
        });*/
		return pane;
	}
	public BorderPane GumBoard() {
		BorderPane gum = new BorderPane();
		gum.setStyle("-fx-background-color: lightblue; -fx-border-color: black");
		gum.setTop(GumHeader());
		gum.setPadding(new Insets(50,50,50,50));
		gum.setCenter(GumPage());
		gum.setBottom(last());
		return gum;
	}
	public HBox GumHeader() {
		HBox top = new HBox();
		Label gum = new Label("Welcome to Gum Selction!!");
		top.setStyle("-fx-background-color: lightblue;-fx-border-color: black");
		gum.setTextFill(Color.BLACK);
		top.setPadding(new Insets(0,0,0,350));
		top.getChildren().add(gum);
		return top;
	}
	
	//------
	public GridPane CandiesPage() {
		GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0));
        pane.setVgap(10);
        pane.setHgap(100);
        Label info = new Label("Taste of Rainbow, $3.50");
        Label info1 = new Label("Chocolate goodnes, $4.00");
        Label info3 = new Label("Sour, sweet, $3.00");


        pane.add(gui.Skittles(), 1, 1);
        pane.add(gui.Snickers(), 2, 1);
        pane.add(gui.SourPatch(), 3, 1);
        pane.add(SkittlesButton, 1, 3);
        pane.add(SnickersButton, 2, 3);
        pane.add(SourPatchButton, 3, 3);
        pane.add(info, 1, 2);
        pane.add(info1, 2, 2);
        pane.add(info3,3, 2);
        pane.setHalignment(gui.SourPatch(), HPos.CENTER);
        pane.setHalignment(gui.Snickers(), HPos.CENTER);
        pane.setHalignment(gui.Skittles(), HPos.CENTER);
        pane.setHalignment(info, HPos.CENTER);
        pane.setHalignment(info1, HPos.CENTER);
        pane.setHalignment(info3, HPos.CENTER);
        pane.setHalignment(SkittlesButton, HPos.CENTER);
        pane.setHalignment(SnickersButton, HPos.CENTER);
        pane.setHalignment(SourPatchButton, HPos.CENTER);
        SkittlesButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		SkittlesButton.setTextFill(Color.WHITE);
		SourPatchButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		SourPatchButton.setTextFill(Color.WHITE);
		SnickersButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		SnickersButton.setTextFill(Color.WHITE);
       /* CokeButton.setOnAction(e -> {

        	Scene scene2 = new Scene();//CheckoutLayout);
            primaryStage.setScene(scene2);
        });
        SpriteButton.setOnAction(e -> {

        	Scene scene2 = new Scene();//CheckoutLayout);
            primaryStage.setScene(scene2);
        });
        PoweradeButton.setOnAction(e -> {

        	Scene scene2 = new Scene();//CheckoutLayout);
            primaryStage.setScene(scene2);
        });*/
		return pane;
	}
	public BorderPane Candy() {
		BorderPane candies = new BorderPane();
		candies.setStyle("-fx-background-color: lightblue; -fx-border-color: black");
		candies.setTop(CandyHeader());
		candies.setPadding(new Insets(50,50,50,50));
		candies.setCenter(CandiesPage());
		candies.setBottom(last());
		return candies;
	}
	public HBox CandyHeader() {
		HBox top = new HBox();
		Label candies = new Label("Welcome to Candy Selection!!");
		top.setStyle("-fx-background-color: lightblue;-fx-border-color: black");
		candies.setTextFill(Color.BLACK);
		top.setPadding(new Insets(0,0,0,350));
		top.getChildren().add(candies);
		return top;
	}
	
	//--------
	public GridPane Chip() {
		GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0));
        pane.setVgap(10);
        pane.setHgap(100);
        Label info = new Label("Nacho Cheese, $5.00");
        Label info1 = new Label("Classic, $4.50");
        Label info3 = new Label("Cheesy goodnes, $3.50");

        pane.add(gui.Doritos(), 1, 1);
        pane.add(gui.Lays(), 2, 1);
        pane.add(gui.Cheetos(), 3, 1);
        pane.add(DoritosButton, 1, 3);
        pane.add(LaysButton, 2, 3);
        pane.add(CheetosButton, 3, 3);
        pane.add(info, 1, 2);
        pane.add(info1, 2, 2);
        pane.add(info3,3, 2);
        pane.setHalignment(gui.Doritos(), HPos.CENTER);
        pane.setHalignment(gui.Lays(), HPos.CENTER);
        pane.setHalignment(gui.Cheetos(), HPos.CENTER);
        pane.setHalignment(info, HPos.CENTER);
        pane.setHalignment(info1, HPos.CENTER);
        pane.setHalignment(info3, HPos.CENTER);
        pane.setHalignment(DoritosButton, HPos.CENTER);
        pane.setHalignment(LaysButton, HPos.CENTER);
        pane.setHalignment(CheetosButton, HPos.CENTER);
        DoritosButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		DoritosButton.setTextFill(Color.WHITE);
		LaysButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		LaysButton.setTextFill(Color.WHITE);
		CheetosButton.setStyle("-fx-background-color: black; -fx-border-color: white");
		CheetosButton.setTextFill(Color.WHITE);
       /* CokeButton.setOnAction(e -> {

        	Scene scene2 = new Scene();//CheckoutLayout);
            primaryStage.setScene(scene2);
        });
        SpriteButton.setOnAction(e -> {

        	Scene scene2 = new Scene();//CheckoutLayout);
            primaryStage.setScene(scene2);
        });
        PoweradeButton.setOnAction(e -> {

        	Scene scene2 = new Scene();//CheckoutLayout);
            primaryStage.setScene(scene2);
        });*/
		return pane;
	}
	public BorderPane ChipPage() {
		BorderPane chips = new BorderPane();
		chips.setStyle("-fx-background-color: lightblue; -fx-border-color: black");
		chips.setTop(ChipsHeader());
		chips.setPadding(new Insets(50,50,50,50));
		chips.setCenter(Chip());
		chips.setBottom(last());
		return chips;
	}
	public HBox ChipsHeader() {
		HBox top = new HBox();
		Label chips = new Label("Welcome to Chips Selection!!");
		top.setStyle("-fx-background-color: lightblue;-fx-border-color: black");
		chips.setTextFill(Color.BLACK);
		top.setPadding(new Insets(0,0,0,350));
		top.getChildren().add(chips);
		return top;
	}
	
	
}
