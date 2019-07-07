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

public class ProcessCustomerQueue {

    public static int queueLength = 0;
    public static String[] name = new String[26];
    public static String[] buying = new String[26];

    public static String[] item = new String[26];

    public static void First(){
        // this is not used in our implementation - we control this through the CustomerDisplay.java file
    }

    public static String isEmpty(){
        return "Nobody in the queue, just people looking at the machine.";
    }

    public static int Length(){
        System.out.println(queueLength);
        return queueLength;
    }

    public static void In(int Number){
        System.out.println(name[Number] + " wants to buy " + buying[Number]);
        // animation is controlled through the CustomerDisplay class.  this is a stub to meet project requirements.
    }

    public static void Out(int Number){
        // animation is controlled through the CustomerDisplay class.  this is a stub to meet project requirements.
    }


    public static int readInventory(String fileName){
        BufferedReader br = null;
        String thisLine = "";
        String cellDelimter = ",";

        int counter = 0;
        try {

            br = new BufferedReader(new FileReader(fileName));

            while ((thisLine = br.readLine()) != null) {

                String[] thisEntry = thisLine.split(cellDelimter);
                item[counter] = thisEntry[0];
                counter++;

                if (counter <= 25){
                } else {
                    System.out.println("too many items!  This machine only has 25 slots.");
                    counter = 25;
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return counter;
    }

    public static int readQueue(String fileName){
        BufferedReader br = null;
        String thisLine = "";
        String cellDelimter = ",";

        int counter = 0;
        try {

            br = new BufferedReader(new FileReader(fileName));

            while ((thisLine = br.readLine()) != null) {

                String[] thisEntry = thisLine.split(cellDelimter);
                name[counter] = thisEntry[0];
                buying[counter] = thisEntry[1];
                counter++;

                if (counter <= 25){
                } else {
                    System.out.println("too many items!  This machine only has 25 slots.");
                    counter = 25;
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return counter;
    }

    public static void main(String[] args){
        queueLength=readInventory("loadmachine.csv");
        queueLength=readQueue("customers.csv");
        System.out.println(Length());
    }


}
