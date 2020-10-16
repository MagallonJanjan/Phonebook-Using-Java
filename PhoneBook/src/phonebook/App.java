/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 2ndyrGroupB
 */
public class App {

    Scanner input = new Scanner(System.in);
    ArrayList<PhoneBook> phone = new ArrayList<>(); // Creating ArrayList for storing contacts

    public String choice() { // Method to show choices
        System.out.println("---------------------***--------------------------");
        System.out.println("|             1 - Add Contact                      |");
        System.out.println("|             2 - Update Contact                   |");
        System.out.println("|             3 - Delete Contact                   |");
        System.out.println("|             4 - Search Contact by ID             |");
        System.out.println("|             5 - Display All Contact              |");
        System.out.println("--------------------***---------------------------");
        System.out.print("Please Enter Your Choice: "); // Asking input choice
        String choice = input.nextLine();

        return choice;
    }
    // variable used to store regular expressions 
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean emailValidator(String email) { //Boolean method to validate Email Address

        if (email == null) {
            return false;
        }

        Matcher matcher = EMAIL_PATTERN.matcher(email); // Used to  match the email address if it is valid
        return matcher.matches();
    }

    public void addContact() { // Method to Add Contact List 
        PhoneBook phonebook = new PhoneBook(); // Creating phonebook object
        
        // Creatinf random object imported above
        Random random = new Random();
        int intRandom = random.nextInt(500);
        String randomNumber = Integer.toString(intRandom);
        
        phonebook.setId(randomNumber); // Setting random Id 

        // Asking inputs from the user to add
        System.out.print("ID: " + randomNumber + "\n");
        phonebook.setId(randomNumber);
        System.out.print("Last Name: ");
        phonebook.setLastName(input.nextLine());
        System.out.print("First Name: ");
        phonebook.setFirstName(input.nextLine());

        System.out.print("Phone Number: ");
        String phoneNumber = input.nextLine();

        while (!isPhoneNumberValidator(phoneNumber)) { // Loop to validate Phone Number until it is valid
            System.out.println("Invalid Phone Number! Try Again ");
            System.out.print("Phone Number: ");
            phoneNumber = input.nextLine();
        }
        phonebook.setPhoneNumber(phoneNumber);// setting phone number

        System.out.print("Email Address: ");
        String emailAddress = input.nextLine();

        while (!(emailValidator(emailAddress))) { // Loop to validate Email Address until it is valid
            System.out.println("Invalid Email Address! Please Try Again.");
            System.out.print("Enter another valid email address: ");
            emailAddress = input.nextLine();
        }
        phonebook.setEmail(emailAddress);

        System.out.print("Address: ");
        phonebook.setAddress(input.nextLine());
        System.out.println("Successfully Added!");
        phone.add(phonebook); // Adding all element into ArrayList
    }

    public void updateContact() { // Method to Update Contacts
        

        if (phone.isEmpty()) {
            System.out.println("Please Add Contact Details First");
        } else {
            System.out.print("Please Enter ID:");
            String id = input.nextLine();
            String message = "";

            OUTER:
            for (PhoneBook phone1 : phone) {
                if (id.equals(phone1.getId())) {
                    System.out.println("---------------------***--------------------------");
                    System.out.println("|              1. Last Name:                         |");
                    System.out.println("|              2. First Name:                        |");
                    System.out.println("|              3. Phone Number:                      |");
                    System.out.println("|              4. Email Address:                     |");
                    System.out.println("|              5.  Address:                          |");
                    System.out.println("---------------------***--------------------------");
                    System.out.print("What Field Do You Want to Update?: ");
                    String fieldToEdit = input.nextLine();
                    switch (fieldToEdit) {
                        case "1":
                            System.out.print(" New Last Name: ");
                            phone1.setLastName(input.nextLine());
                            System.out.println("Updated Successfully!");
                            break;
                        case "2":
                            System.out.print(" New First Name: ");
                            phone1.setFirstName(input.nextLine());
                            System.out.println("Updated Successfully!");
                            break;
                        case "3":
                            System.out.print(" New Phone Number: ");
                            String phoneNumber = input.nextLine();
                            while (!isPhoneNumberValidator(phoneNumber)) {
                                System.out.println("Invalid Phone Number! Try Again ");
                                System.out.print("Phone Number: ");
                                phoneNumber = input.nextLine();
                            }
                            phone1.setPhoneNumber(phoneNumber);
                            System.out.println("Updated Successfully!");
                            break;
                        case "4":
                            System.out.print("New Email Address: ");
                            String newEmailAddress = input.nextLine();
                            while (!(emailValidator(newEmailAddress))) {
                                System.out.print("Enter another valid email address: ");
                                newEmailAddress = input.nextLine();
                            }
                            phone1.setEmail(newEmailAddress);
                            System.out.println("Updated Successfully!");
                            break;
                        case "5":
                            System.out.print(" New Address: ");
                            phone1.setAddress(input.nextLine());
                            System.out.println("Updated Successfully!");
                            break;
                        default:
                            System.out.println("Invalid Choice!");
                            break OUTER;
                    }
                }
            }

        }

    }

    public void deleteContact() {
        if (phone.isEmpty()) {  //Condition to check f the list is empty
            System.out.println("Please Add Contact Details First");
        } else {
            System.out.print("Please Enter ID:"); // Asking Id to be remove
            String id = input.nextLine();
            String message = "";
            for (int i = 0; i < phone.size(); i++) {  // Looping to check every element in  the ArrayList
                if (id.equals(phone.get(i).getId())) { // Checking if the Id inputted is equal to the Id stored
                    phone.remove(phone.get(i)); // Method used to remove specific element in the list
                    message = " Successfully deleted!";
                } else {
                    message = "Not found!";
                }
            }
            System.out.println(message);
        }

    }

    public void searchByID() {
        if (phone.isEmpty()) { //Condition to check if the list is empty
            System.out.println("Please Add Contact First");
        } else {
            System.out.print("Please Enter ID:"); //Asking Card Id to view
            String id = input.nextLine();
            String message = "";

            for (PhoneBook phone1 : phone) {
                // Looping to check every element in  the ArrayList
                if (!id.equals(phone1.getId())) {
                    message = "Not found!";
                } else {
                    // Condition to check if the Id inputted is equal to Id already stored
                    message = "ID: " + phone1.getId() + " " + " Name: " + phone1.getLastName() + " " + phone1.getFirstName() + " " + "Phone Number: " + phone1.getPhoneNumber() + "\nEmail Address : " + phone1.getEmail() + " " + "Address: " + phone1.getAddress();
                    break;
                }
            }
            System.out.println(message);

        }
    }

    public void displayAll() {
        if (phone.isEmpty()) { //Condition to check if the list is empty
            System.out.println("Please Add Contact First");
        } else {
            String message = "";
            Collections.sort(phone);
            for (PhoneBook phone1 : phone) {
                message = "ID: " + phone1.getId() + " " + " Name: " + phone1.getLastName() + " " + phone1.getFirstName() + " " + "Phone Number: " + phone1.getPhoneNumber() + "\nEmail Address : " + phone1.getEmail() + " " + "Address: " + phone1.getAddress();
                System.out.println(message);
            }

        }

    }

    private boolean isNumeric(String contactNumber) {
        try {
            Long.parseLong(contactNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isPhoneNumberValidator(String contactNumber) {
        boolean exist = true;
        if (!isNumeric(contactNumber)) {
            return false;
        }
        for (PhoneBook phone1 : phone) {
            if (phone1.getPhoneNumber().equals(contactNumber)) {
                System.out.println("Phone Number Already exists");
                exist = false;
                break;
            }
        }
        return exist;
    }
}
