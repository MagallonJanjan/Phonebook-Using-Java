/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.util.*;

/**
 *
 * @author 2ndyrGroupB
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        App app = new App(); // Initializing app

        while (true) { //Loop to ask input forever
            switch (app.choice()) { // A selection control
                case "1":
                case "Add Contact":
                    app.addContact(); // Calling the addContact method
                    break;
                case "2":
                case "Edit Contact":
                    app.updateContact(); // Calling the updateContact method
                    break;
                case "3":
                case "Delete Contact":
                    app.deleteContact(); //Calling the deleteContact method
                    break;
                case "4":
                case "Search Contact by ID":
                    app.searchByID(); //Calling the searchByID method
                    break;
                case "5":
                case "Display All Contact":
                    app.displayAll(); //Calling the displayAll method
                default:
                    break;
            }
        }
    }

}
