/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

/**
 *
 * @author 2ndyrGroupB
 */
public class PhoneBook implements Comparable<PhoneBook> { // Comparable implementation to sort  last name in ascending order
    
    //Initializing varibales needed for Phone Book
    public String id; 
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;
    private String address;

    
    // Getters and Setters for the variables above
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @param t
     * @return
     */
    @Override
    public int compareTo(PhoneBook t) { // Method to compare all the last name for sorting. 
        return this.getLastName().compareTo(t.getLastName());
    }
}
