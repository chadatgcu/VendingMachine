import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * Grand Canyon University
 * CST-135
 * Brandon Bass
 *
 * Daniel"Thad"Dittmer
 * Chad Wierick
 * David Pratt
 * Zachary Swoveland
 *
 * This is our main loader class.  This is how you would refill the machine.
 */



public class LoadMe extends Application {
    //all the buttons for later actions to be added
    Button a1 = new Button("A1");
    Button a2 = new Button("A2");
    Button a3 = new Button("A3");
    Button a4 = new Button("A4");
    Button a5 = new Button("A5");
    Button b1 = new Button("B1");
    Button b2 = new Button("B2");
    Button b3 = new Button("B3");
    Button b4 = new Button("B4");
    Button b5 = new Button("B5");
    Button c1 = new Button("C1");
    Button c2 = new Button("C2");
    Button c3 = new Button("C3");
    Button c4 = new Button("C4");
    Button c5 = new Button("C5");
    Button d1 = new Button("D1");
    Button d2 = new Button("D2");
    Button d3 = new Button("D3");
    Button d4 = new Button("D4");
    Button d5 = new Button("D5");
    Button e1 = new Button("E1");
    Button e2 = new Button("E2");
    Button e3 = new Button("E3");
    Button e4 = new Button("E4");
    Button e5 = new Button("E5");
    Button ok = new Button("Ok");
    Button cancel = new Button("Cancel");
    //all the images for the program because couldn't work animation with class call.  Note, in a future revision, we would like to somehow move the reference to this into the product class.
    ImageView nachoDorito = new ImageView("nachoDoritos.jpg");
    ImageView cheeto = new ImageView("Cheetos.jpg");
    ImageView hotCheeto = new ImageView("hotCheetos.jpg");
    ImageView classicLays = new ImageView("classicLays.jpg");
    ImageView lays = new ImageView("Lays.jpg");
    ImageView coolRanch = new ImageView("coolRanch.jpg");
    ImageView dorito = new ImageView("Doritos.jpg");
    ImageView coke = new ImageView("coke.jpg");
    ImageView fanta = new ImageView("fanta.jpg");
    ImageView powerade = new ImageView("powerade.jpg");
    ImageView gatorade = new ImageView("gatorade.jpg");
    ImageView monster = new ImageView("monster.jpg");
    ImageView sprite = new ImageView("sprite.jpg");
    ImageView water = new ImageView("water.jpg");
    ImageView extra = new ImageView("extra.jpg");
    ImageView five = new ImageView("five.jpg");
    ImageView hubba = new ImageView("hubbaBubba.jpg");
    ImageView orbit = new ImageView("orbit.jpg");
    ImageView trident = new ImageView("trident.jpg");
    ImageView reeses = new ImageView("reesesPieces.jpg");
    ImageView skittles = new ImageView("Skittles.jpg");
    ImageView snickers = new ImageView("Snickers.jpg");
    ImageView sourPatch = new ImageView("SourPatch.jpg");
    ImageView sourSkittle = new ImageView("sourSkittles.jpg");
    ImageView watermelon = new ImageView("watermelonPatch.jpg");
    ImageView basket = new ImageView("basket.jpg");
    GridPane pane = new GridPane();
    // so we can write info/feedback
    TextField info = new TextField();
    // controls for determining which items are selected.
    boolean choiceMade = false;
    int letterSelected = 0;
    int numberSelected = 0;

    public static void main(String[] args) {

        launch(args);
    }

    public HBox header() {//name of owner of vending machine or title of scene
        HBox top = new HBox();
        Label label = new Label("Select and item, and ok will add/cancel will remove");
        top.setStyle("-fx-background-color: gray");
        label.setTextFill(Color.BLACK);
        top.getChildren().add(label);
        top.setPadding(new Insets(10,10,10,10));
        top.setAlignment(Pos.CENTER);
        return top;
    }

    public VBox right() {//holds the right pane that holds selection() and other buttons to help with purchase
        VBox right = new VBox();
        right.setPadding(new Insets(10,10,10,0));
        HBox buttons = new HBox();
        buttons.setSpacing(10);

        ok.setOnAction((event) -> {
            if (choiceMade) {
                if(Dispenser.productGrid[letterSelected][numberSelected].getQuantity() > 0) {
                    info.setText("Item added");
                    Dispenser.productGrid[letterSelected][numberSelected].setQuantity((Dispenser.productGrid[letterSelected][numberSelected].getQuantity() + 1));


                    // reset
                    info.setText("Please come again!");
                } else {
                    info.setText("Empty!");
                }
                choiceMade = false;
            } else {
                info.setText("Nothing selected!");
            }
        });

        cancel.setOnAction((event) -> {
            if (choiceMade) {
                if(Dispenser.productGrid[letterSelected][numberSelected].getQuantity() >= 1){
                    info.setText("Item removed");
                    Dispenser.productGrid[letterSelected][numberSelected].setQuantity((Dispenser.productGrid[letterSelected][numberSelected].getQuantity() - 1));
                } else {
                    info.setText("Nothing to remove!");
                }
                choiceMade = false;
            } else {
                info.setText("Nothing selected!");
            }
        });

        buttons.getChildren().addAll(ok, cancel);

        right.getChildren().addAll(info, Selection(), buttons);
        return right;
    }

    public VBox Basket() {//holds basket image
        VBox bot = new VBox();


        bot.getChildren().add(basket);
        bot.setAlignment(Pos.CENTER);
        bot.setPadding(new Insets(50,25,0,25));
        return bot;
    }
    public BorderPane VendingMachine() {//holds the layout for entire scene to display later
        BorderPane vendingMachine = new BorderPane();
        vendingMachine.setStyle("-fx-background-color: gray");
        vendingMachine.setTop(header());
        vendingMachine.setRight(right());
        vendingMachine.setCenter(Display());
        vendingMachine.setBottom(Basket());
        return vendingMachine;
    }
    public GridPane Display() {//creates vending machine display port with images and labels


        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0));
        pane.setHgap(50);
        //sets for all heights and widths outside of class because calling from class made animation break and not work.
        cheeto.setFitHeight(100);
        cheeto.setFitWidth(100);
        hotCheeto.setFitHeight(100);
        hotCheeto.setFitWidth(100);
        classicLays.setFitHeight(100);
        classicLays.setFitWidth(100);
        lays.setFitHeight(100);
        lays.setFitWidth(100);
        coolRanch.setFitHeight(100);
        coolRanch.setFitWidth(100);
        dorito.setFitHeight(100);
        dorito.setFitWidth(100);
        coke.setFitHeight(100);
        coke.setFitWidth(100);
        fanta.setFitHeight(100);
        fanta.setFitWidth(100);
        powerade.setFitHeight(100);
        powerade.setFitWidth(100);
        gatorade.setFitHeight(100);
        gatorade.setFitWidth(100);
        monster.setFitHeight(100);
        monster.setFitWidth(100);
        sprite.setFitHeight(100);
        sprite.setFitWidth(100);
        water.setFitHeight(100);
        water.setFitWidth(100);
        extra.setFitHeight(100);
        extra.setFitWidth(100);
        five.setFitHeight(100);
        five.setFitWidth(100);
        hubba.setFitHeight(100);
        hubba.setFitWidth(100);
        orbit.setFitHeight(100);
        orbit.setFitWidth(100);
        trident.setFitHeight(100);
        trident.setFitWidth(100);
        reeses.setFitHeight(100);
        reeses.setFitWidth(100);
        skittles.setFitHeight(100);
        skittles.setFitWidth(100);
        snickers.setFitHeight(100);
        snickers.setFitWidth(100);
        sourPatch.setFitHeight(100);
        sourPatch.setFitWidth(100);
        sourSkittle.setFitHeight(100);
        sourSkittle.setFitWidth(100);
        watermelon.setFitHeight(100);
        watermelon.setFitWidth(100);
        nachoDorito.setFitHeight(100);
        nachoDorito.setFitWidth(100);




        pane.add(cheeto, 1, 0);
        pane.add(classicLays, 2, 0);
        pane.add(dorito, 3, 0);
        pane.add(coolRanch, 4, 0);
        pane.add(hotCheeto, 5, 0);

        pane.add(new Label("A1"), 1, 1);
        pane.add(new Label("A2"), 2, 1);
        pane.add(new Label("A3"), 3, 1);
        pane.add(new Label("A4"), 4, 1);
        pane.add(new Label("A5"), 5, 1);

        pane.add(lays, 1, 2);
        pane.add(reeses, 2, 2);
        pane.add(skittles, 3, 2);
        pane.add(nachoDorito, 4, 2);
        pane.add(snickers, 5, 2);

        pane.add(new Label("B1"), 1, 3);
        pane.add(new Label("B2"), 2, 3);
        pane.add(new Label("B3"), 3, 3);
        pane.add(new Label("B4"), 4, 3);
        pane.add(new Label("B5"), 5, 3);

        pane.add(sourPatch, 1, 4);
        pane.add(sourSkittle, 2, 4);
        pane.add(watermelon, 3, 4);
        pane.add(extra, 4, 4);
        pane.add(hubba, 5, 4);

        pane.add(new Label("C1"), 1, 5);
        pane.add(new Label("C2"), 2, 5);
        pane.add(new Label("C3"), 3, 5);
        pane.add(new Label("C4"), 4, 5);
        pane.add(new Label("C5"), 5, 5);

        pane.add(orbit, 1, 6);
        pane.add(trident, 2, 6);
        pane.add(five, 3, 6);
        pane.add(water, 4, 6);
        pane.add(coke, 5, 6);

        pane.add(new Label("D1"), 1, 7);
        pane.add(new Label("D2"), 2, 7);
        pane.add(new Label("D3"), 3, 7);
        pane.add(new Label("D4"), 4, 7);
        pane.add(new Label("D5"), 5, 7);

        pane.add(fanta, 1, 8);
        pane.add(gatorade, 2, 8);
        pane.add(monster, 3, 8);
        pane.add(powerade, 4, 8);
        pane.add(sprite, 5, 8);

        pane.add(new Label("E1"), 1, 9);
        pane.add(new Label("E2"), 2, 9);
        pane.add(new Label("E3"), 3, 9);
        pane.add(new Label("E4"), 4, 9);
        pane.add(new Label("E5"), 5, 9);



        return pane;
    }

    public GridPane Selection() {//creates button grid for selection

        GridPane panel = new GridPane();
        panel.setPadding(new Insets(0));

        panel.add(a1, 1, 0);
        a1.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[0][0].nameAndPriceOneLine());
            letterSelected = 0;
            numberSelected = 0;
            choiceMade = true;
        });
        panel.add(a2, 2, 0);
        a2.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[1][0].nameAndPriceOneLine());
            letterSelected = 0;
            numberSelected = 1;
            choiceMade = true;
        });
        panel.add(a3, 3, 0);
        a3.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[2][0].nameAndPriceOneLine());
            letterSelected = 0;
            numberSelected = 2;
            choiceMade = true;
        });
        panel.add(a4, 4, 0);
        a4.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[3][0].nameAndPriceOneLine());
            letterSelected = 0;
            numberSelected = 3;
            choiceMade = true;
        });
        panel.add(a5, 5, 0);
        a5.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[4][0].nameAndPriceOneLine());
            choiceMade = true;
            letterSelected = 0;
            numberSelected = 4;
        });

        panel.add(b1, 1, 1);
        b1.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[0][1].nameAndPriceOneLine());
            letterSelected = 1;
            numberSelected = 0;
            choiceMade = true;
        });
        panel.add(b2, 2, 1);
        b2.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[1][1].nameAndPriceOneLine());
            letterSelected = 1;
            numberSelected = 1;
            choiceMade = true;
        });
        panel.add(b3, 3, 1);
        b3.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[2][1].nameAndPriceOneLine());
            letterSelected = 1;
            numberSelected = 2;
            choiceMade = true;
        });
        panel.add(b4, 4, 1);
        b4.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[3][1].nameAndPriceOneLine());
            letterSelected = 1;
            numberSelected = 3;
            choiceMade = true;
        });
        panel.add(b5, 5, 1);
        b5.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[4][1].nameAndPriceOneLine());
            letterSelected = 1;
            numberSelected = 4;
            choiceMade = true;
        });

        panel.add(c1, 1, 2);
        c1.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[0][2].nameAndPriceOneLine());
            letterSelected = 2;
            numberSelected = 0;
            choiceMade = true;
        });
        panel.add(c2, 2, 2);
        c2.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[1][2].nameAndPriceOneLine());
            letterSelected = 2;
            numberSelected = 1;
            choiceMade = true;
        });
        panel.add(c3, 3, 2);
        c3.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[2][2].nameAndPriceOneLine());
            letterSelected = 2;
            numberSelected = 2;
            choiceMade = true;
        });
        panel.add(c4, 4, 2);
        c4.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[3][2].nameAndPriceOneLine());
            letterSelected = 2;
            numberSelected = 3;
            choiceMade = true;
        });
        panel.add(c5, 5, 2);
        c5.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[4][2].nameAndPriceOneLine());
            letterSelected = 2;
            numberSelected = 4;
            choiceMade = true;
        });

        panel.add(d1, 1, 3);
        d1.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[0][3].nameAndPriceOneLine());
            letterSelected = 3;
            numberSelected = 0;
            choiceMade = true;
        });
        panel.add(d2, 2, 3);
        d2.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[1][3].nameAndPriceOneLine());
            letterSelected = 3;
            numberSelected = 1;
            choiceMade = true;
        });
        panel.add(d3, 3, 3);
        d3.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[2][3].nameAndPriceOneLine());
            letterSelected = 3;
            numberSelected = 2;
            choiceMade = true;
        });
        panel.add(d4, 4, 3);
        d4.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[3][3].nameAndPriceOneLine());
            letterSelected = 3;
            numberSelected = 3;
            choiceMade = true;
        });
        panel.add(d5, 5, 3);
        d5.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[4][3].nameAndPriceOneLine());
            letterSelected = 3;
            numberSelected = 4;
            choiceMade = true;
        });

        panel.add(e1, 1, 4);
        e1.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[0][4].nameAndPriceOneLine());
            letterSelected = 4;
            numberSelected = 0;
            choiceMade = true;
        });
        panel.add(e2, 2, 4);
        e2.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[1][4].nameAndPriceOneLine());
            letterSelected = 4;
            numberSelected = 1;
            choiceMade = true;
        });
        panel.add(e3, 3, 4);
        e3.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[2][4].nameAndPriceOneLine());
            letterSelected = 4;
            numberSelected = 2;
            choiceMade = true;
        });
        panel.add(e4, 4, 4);
        e4.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[3][4].nameAndPriceOneLine());
            letterSelected = 4;
            numberSelected = 3;
            choiceMade = true;
        });
        panel.add(e5, 5, 4);
        e5.setOnAction((event) -> {
            info.setText(Dispenser.productGrid[4][4].nameAndPriceOneLine());
            letterSelected = 4;
            numberSelected = 4;
            choiceMade = true;
        });

        return panel;
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        Dispenser.fillDispenser();
        Scene scene = new Scene(VendingMachine(), 1000, 950);
        primaryStage.setTitle("VendingMachineTest");
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
