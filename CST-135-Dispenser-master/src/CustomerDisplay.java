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
 * This class will handle the animation of the customer facing environment.  It will work in conjunction with the ProcessCustomerQueue class.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.lang.Integer;
import java.lang.String;
import java.lang.Long;

public class CustomerDisplay extends Application {
	public static int queueSize = 0;
	public static int counter = 0;
	Button click = new Button("Help Customer");
	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		ProcessCustomerQueue.readInventory("loadmachine.csv");
		queueSize = ProcessCustomerQueue.readQueue("customers.csv");
		System.out.println(queueSize + " customers in the queue!");
		Scene scene = new Scene(home(), 1000, 750);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public HBox header() {
		HBox header = new HBox();
		Label top = new Label("Welcome to VendCo. Center!");
		header.setAlignment(Pos.CENTER);
		header.getChildren().add(top);
		return header;
	}
	public VBox customerLog() {
		VBox body = new VBox();
		Text log = new Text(200,200, "");
		log.setWrappingWidth(500);//changes wrap on text just adjust as needed
		log.setText("Test hellllllllo what supppppppppppp");
		body.getChildren().addAll(log, click);
		body.setAlignment(Pos.CENTER);
		return body;
	}

	public HBox bottom() {
		HBox bot = new HBox();
		HBox figure = new HBox();
		ImageView last = new ImageView("Standing.jpg");
		ImageView choosing = new ImageView("Choosing.jpg");
		ImageView vendingMachine = new ImageView("VendingMachine.jpg");
		
		click.setOnAction(e -> {

			if (queueSize != 0) {
				queueSize--;
				ProcessCustomerQueue.In(counter);
				counter++;
				System.out.println(queueSize + " customers remain in the queue!");
				TranslateTransition pt = new TranslateTransition();
				pt.setNode(last);
				pt.setDuration(Duration.seconds(3));
				pt.setToX(-175);
				pt.setCycleCount(1);
				pt.play();
				pt.setOnFinished(new EventHandler<ActionEvent>() {

									 @Override
									 public void handle(ActionEvent event) {

										 FadeTransition fade = new FadeTransition(Duration.seconds(2), last);
										 fade.setFromValue(1.0);
										 fade.setToValue(0.0);
										 fade.play();
										 fade.setOnFinished(new EventHandler<ActionEvent>() {

											 @Override
											 public void handle(ActionEvent event) {

												 TranslateTransition tt = new TranslateTransition(Duration.seconds(2), last);
												 tt.setToX(175);
												 tt.setCycleCount(1);
												 tt.play();
												 tt.setOnFinished(new EventHandler<ActionEvent>() {

													 @Override
													 public void handle(ActionEvent event) {

														 FadeTransition ft = new FadeTransition(Duration.seconds(3), last);
														 ft.setFromValue(0.0);
														 ft.setToValue(1.0);
														 ft.play();
													 }

												 });

											 }

										 });


									 }

									 ;
								 }
				);
			} else {
				System.out.println(ProcessCustomerQueue.isEmpty());
			}
		});
		
		figure.getChildren().addAll(choosing, last);
		figure.setAlignment(Pos.BOTTOM_CENTER);
		bot.getChildren().addAll(vendingMachine, figure);
		return bot;
	}
	
	public BorderPane home() {
		BorderPane home = new BorderPane();
		
		home.setTop(header());
		home.setCenter(customerLog());
		home.setBottom(bottom());
		return home;
	}






}

