package com.bridgelabz.opencsvgson;

import com.opencsv.bean.CsvBindByName;
/*
 *@desc :  Represents a User with attributes such as name, email, phone number, and country.
 * Utilizes OpenCSV annotations for CSV binding.
 */

public class User {
    @CsvBindByName(column = "name")
    private String name;
    @CsvBindByName(column = "email" , required = true)
    private String email;
    @CsvBindByName(column = "phone")
    private String phoneNo;
    @CsvBindByName(column = "country")
    private String country;

    /*
     * Default constructor for User class.
     */
    public User() {
        // Default constructor code
    }
    /*
     * @desc : Constructs a User with the specified attributes.
     * @param name User's name.
     * @param email User's email.
     * @param phoneNo User's phone number.
     * @param country User's country.
     */

    public User(String name, String email, String phoneNo, String country) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
    }
    /*
     * @desc :Getter for name.
     * @params : no params
     * @return The name.
     */
    public String getName() {
        return name;
    }
    /*
     * @desc :Setter for name.
     * @param name The new value for the name.
     * @return: void
     */
    public void setName(String name) {
        this.name = name;
    }
    /*
     * @desc :Getter for email.
     * @params : no params
     * @return The email.
     */
    public String getEmail() {
        return email;
    }
    /*
     * @desc :Setter for email.
     * @param email The new value for the email.
     * @return: void
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /*
     * @desc :Getter for phoneNo.
     * @params : no params
     * @return The phoneNo.
     */
    public String getPhoneNo() {
        return phoneNo;
    }
    /*
     * @desc :Setter for phoneNo.
     * @param name The new value for the phoneNo.
     * @return: void
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    /*
     * @desc :Getter for country.
     * @params : no params
     * @return The country.
     */
    public String getCountry() {
        return country;
    }
    /*
     * @desc :Setter for country.
     * @param name The new value for the country.
     * @return: void
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /*
     * @desc : Checks if this User is equal to another object.
     * @param o The object to compare.
     * @return True if the objects are equal, false otherwise.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && email.equals(user.email) && phoneNo.equals(user.phoneNo) && country.equals(user.country);
    }
    /*
     * @desc : Gets a formatted string of User attributes in the order: name, email, phoneNo, country.
     * @params : no params
     * @return Formatted string.
     */
public String getOrderedString(){
        return ""+name+","+email+","+phoneNo+","+country;
}
    /*
     * @desc : Default toString method providing a string representation of the User object.
     * @params : no params
     * @return String representation of the User.
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
