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
 * this is called from the Global_Inventory_Management class.  It checks for any inventory that is 3 or less and reports.
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

public class restock {

    public static String inventoryCheck(int lowQuantity, int totalDispensers){
        String results = "";
        int i = 0;
        int j = 0;
        int k = 0;
        int counter = 0;
        int totalCost = 0;
        for(i=0; i<totalDispensers; i++) {
            counter = 0 ;
            results = results + "\nSearching vending machine " + (i + 1) + " of " + totalDispensers;
            for(j=0; j<5; j++){
                for(k=0; k<5; k++){
                    counter++; // protect against out of array issues
                    if (counter > Global_Inventory_Management.itemCount[i]){
                        k = 5;
                        j = 5;
                    } else {
                        if (Global_Inventory_Management.vendingMachines[i].productGrid[j][k].getQuantity() <= lowQuantity) {
                            results = results + "\n " + Global_Inventory_Management.vendingMachines[i].productGrid[j][k].getName();
                            results = results + " current count " + Global_Inventory_Management.vendingMachines[i].productGrid[j][k].getQuantity();
                            results = results + " current price " + Global_Inventory_Management.vendingMachines[i].productGrid[j][k].getPrice();
                            results = results + " cost to replace is  " + ((lowQuantity + 1 - Global_Inventory_Management.vendingMachines[i].productGrid[j][k].getQuantity()) * Global_Inventory_Management.vendingMachines[i].productGrid[j][k].getPrice()) + " cents.";
                            totalCost = totalCost + ((lowQuantity + 1 - Global_Inventory_Management.vendingMachines[i].productGrid[j][k].getQuantity()) * Global_Inventory_Management.vendingMachines[i].productGrid[j][k].getPrice());
                        }
                    }
                }
            }
        }
        results = results + "\n total cost for all items is " + totalCost + " cents.";
        return results;
    }

}
