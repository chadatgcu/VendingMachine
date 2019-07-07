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
 * This class will offer the user the ability to input up to 3 CSV files, each for its own machine.
 * each array will be sorted by name, and then quantity.
 * now we will give the ability to search for an item name by text.  When found, it will be added to list
 * with the following data: name, qty, machine.
 */

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.stage.StageStyle;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import oracle.jrockit.jfr.events.DynamicValueDescriptor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;
import java.lang.String;
import java.lang.Long;


public class Global_Inventory_Management extends Application {
    final static Dispenser[] vendingMachines = new Dispenser[4];
    final static Dispenser thisMachine = new Dispenser();
    final static int[] itemCount = new int[4];
    final Button restockButton = new Button(); // to call the restock class.
    final Button okButton = new Button(); // the ok button
    final Button searchButton = new Button(); // a button used for searching
    final TextField fileName = new TextField(); // a text input area
    final TextArea instructions = new TextArea(); // an area for display - initially used for instructions
    String fileToRead = new String();
    int totalDispensers;
    int itemsAdded;
    int lowQuantity = 3; // used for restocking

    public static void main(String[] args) {
        launch(args);
    }

    public GridPane Global_Inventory_Management() {//holds the layout for entire scene to display later
        totalDispensers = 0;
        GridPane Global_Inventory_Management = new GridPane();
        Global_Inventory_Management.setPadding(new Insets(10, 10, 10, 10));
        Global_Inventory_Management.setVgap(5);
        Global_Inventory_Management.setHgap(5);


        fileName.setText("Enter a file name without the .csv extension");
        Global_Inventory_Management.setConstraints(fileName, 0, 1);
        Global_Inventory_Management.getChildren().add(fileName);

        okButton.setText("  OK  ");
        Global_Inventory_Management.setConstraints(okButton, 1,1);
        Global_Inventory_Management.getChildren().add(okButton);
        okButton.setOnAction((event) -> {
            fileToRead = "/" + fileName.getText() + ".csv";
            // if the fileToRead != null, pass to a method to read in
            itemsAdded = readFile(fileToRead, totalDispensers);
            totalDispensers++;
            instructions.setText(itemsAdded + " items added and sorted to vending machine" + totalDispensers + ".  You can now enter a name of an inventory file to be read or enter an item to search and click search instead.  By default, it is going to look in the root of your primary storage device and it will automatically add .csv for you.  So, if you want to open data.csv, just type data and click OK.  Note, we support a max of 3 machines, each with 25 items.  Click 'OK' when you are ready to proceed.");
            itemCount[(totalDispensers - 1)] = itemsAdded;
            searchButton.setDisable(false);
            restockButton.setDisable(false);
            fileName.setText("add a new machine file, or search term here.");
            if (totalDispensers == 3){
                okButton.setDisable(true);
                fileName.setText("Either enter a search term or restock.");
            }
        });

        searchButton.setText("Search");
        Global_Inventory_Management.setConstraints(searchButton, 1,2);
        searchButton.setDisable(true);
        Global_Inventory_Management.getChildren().add(searchButton);
        searchButton.setOnAction((event) -> {
            okButton.setDisable(true);
            restockButton.setDisable(false);
            instructions.setText(searchMachines(fileName.getText().toLowerCase(), totalDispensers));

        });

        restockButton.setText("Restock");
        Global_Inventory_Management.setConstraints(restockButton, 1,3);
        restockButton.setDisable(true);
        Global_Inventory_Management.getChildren().add(restockButton);
        restockButton.setOnAction((event) -> {
            okButton.setDisable(true);
            searchButton.setDisable(false);
            instructions.setText(restock.inventoryCheck(lowQuantity, totalDispensers));

        });


        instructions.setWrapText(true);
        instructions.setText("Enter a name of an inventory file to be read.  By default, it is going to look in the root of your primary storage device and the program will automatically add the .csv extension.  So, if you want to open data.csv, just type data and click OK.  Note, we support a max of 3 machines, each with 25 items.  Click 'OK' when you are ready to proceed.");
        Global_Inventory_Management.setConstraints(instructions, 0, 2);
        Global_Inventory_Management.getChildren().add(instructions);


        return Global_Inventory_Management;

    }

    public static String searchMachines(String objectName, int totalDispensers){
        String results = "";
        int i = 0;
        int j = 0;
        int k = 0;
        int counter = 0;;
        for(i=0; i<totalDispensers; i++) {
            counter = 0 ;
            results = results + "\nSearching vending machine " + (i + 1) + " of " + totalDispensers;
            for(j=0; j<5; j++){
                for(k=0; k<5; k++){
                    counter++; // protect against out of array issues
                    if (counter > itemCount[i]){
                        k = 5;
                        j = 5;
                    } else {
                        if (vendingMachines[i].productGrid[j][k].getName().toLowerCase().contains(objectName)) {
                            results = results + "\ncontains " + vendingMachines[i].productGrid[j][k].getQuantity();
                        }
                    }
                }
            }
        }
        return results;
    }

    public static int readFile(String fileName, int totalDispensers){
        BufferedReader br = null;
        String thisLine = "";
        String cellDelimter = ",";
        String[] name = new String[26];
        String brand ="default";
        float tempNumber = 0;
        int[] quantity;
        quantity = new int[26];
        int[] price;
        price = new int[26];
        String[] productID = new String[26];
        String[] type = new String[26];
        int counter = 0;
        int x = 0;
        int y = 0;

        try {

            br = new BufferedReader(new FileReader(fileName));
            Dispenser thisMachine = new Dispenser();

            // going to fill name, quantity, price, type, and productID arrays with contents from the csv file
            while ((thisLine = br.readLine()) != null) {

                String[] thisEntry = thisLine.split(cellDelimter);
                type[counter] = thisEntry[0];
                name[counter] = thisEntry[1];
                tempNumber = Float.parseFloat(thisEntry[2]);
                tempNumber = tempNumber * 100;
                price[counter] = (int) tempNumber;
                quantity[counter] = Integer.parseInt(thisEntry[3]);
                productID[counter] = thisEntry[4];


                counter++;

                // in the future we can make specific objects for the type.  For now protect product grid by ensuring 25 is the highest count.

                if (counter <= 25){
                } else {
                    System.out.println("too many items!  This machine only has 25 slots.");
                    counter = 25;
                }

            }


            // sort the arrays by name then quantity
            sortArrays(name, price, quantity, productID, counter);



            // now we can count up to counter
            for(int i=0; i<counter; i++) {
                x = (i / 5);
                y = (i % 5);
                vendingMachines[totalDispensers].productGrid[x][y] = new Product(name[i], "default", quantity[i], price[i], productID[i]);
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

    static void sortArrays(String[] name, int[] price, int[] quantity, String[] productID, int total){

        String tempName = "";
        int tempPrice = 0;
        int tempQuantity = 0;
        String tempProductID = "";
        int arraySize = total - 1;
        int comparison = 0;
        int changesMade = 0;
        if (total == 1) {
            return;
        }

        int counter = 0;

        while(counter<arraySize) {
            comparison = name[counter].compareToIgnoreCase(name[counter + 1]);

            if (comparison > 0) {
                changesMade++;
                tempName = name[counter];
                tempQuantity = quantity[counter];
                tempPrice = price[counter];
                tempProductID = productID[counter];

                name[counter] = name[counter + 1];
                price[counter] = price[counter + 1];
                quantity[counter] = quantity[counter + 1];
                productID[counter] = productID[counter + 1];

                name[counter + 1] = tempName;
                price[counter + 1] = tempPrice;
                quantity[counter + 1] = tempQuantity;
                productID[counter + 1] = tempProductID;

            } else {
                if (quantity[counter] > quantity[counter + 1] && comparison==0) {
                    // System.out.println(name[counter]);
                    changesMade++;
                    tempName = name[counter];
                    tempQuantity = quantity[counter];
                    tempPrice = price[counter];
                    tempProductID = productID[counter];

                    name[counter] = name[counter + 1];
                    price[counter] = price[counter + 1];
                    quantity[counter] = quantity[counter + 1];
                    productID[counter] = productID[counter + 1];

                    name[counter + 1] = tempName;
                    price[counter + 1] = tempPrice;
                    quantity[counter + 1] = tempQuantity;
                    productID[counter + 1] = tempProductID;
                }
            }
            counter++;
        }

        if(changesMade != 0) {
            sortArrays(name, price, quantity, productID, total);
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(Global_Inventory_Management(), 560, 200);
        primaryStage.setTitle("Vending Machine Manager");
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
