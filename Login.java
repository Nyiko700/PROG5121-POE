/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author nyiko
 */
import java.util.regex.Pattern;
import java.util.Scanner;

class Login {

    String username;
    String password;
    String cellPhoneNumber;
    String firstName;
    String lastName;

    public Login(String username, String password, String cellPhoneNumber, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Username validation
    public boolean checkUsername() {
        return username.contains("_") && username.length() <= 5;
    }

    public String registerUsername() {
        if (checkUsername()) {
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    }

    // Password validation
    public boolean checkPasswordComplexity() {

        boolean length = password.length() >= 8;
        boolean capital = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*[0-9].*");
        boolean special = password.matches(".*[^a-zA-Z0-9].*");

        return length && capital && number && special;
    }

    public String registerPassword() {
        if (checkPasswordComplexity()) {
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted, please ensure that your password contains 8 characters, a capital letter, a number, and a special character.";
        }
    }

    // Cell phone validation
    public boolean checkCellPhoneNumber() {
        String regex = "^\\+27[0-9]{9}$";
        return Pattern.matches(regex, cellPhoneNumber);
    }

    public String registerCellPhoneNumber() {
        if (checkCellPhoneNumber()) {
            return "Cell phone number successfully added.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain international code +27.";
        }
    }

    // Login validation
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }

    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Welcome " + firstName + ", " + lastName + " it is nice to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== REGISTRATION =====");

        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        System.out.print("Enter Cell Phone Number: ");
        String phone = input.nextLine();

        Login user = new Login(username, password, phone, firstName, lastName);

        // Registration feedback
        System.out.println(user.registerUsername());
        System.out.println(user.registerPassword());
        System.out.println(user.registerCellPhoneNumber());

        // Login only if valid
        if (user.checkUsername() && user.checkPasswordComplexity() && user.checkCellPhoneNumber()) {

            System.out.println("\n===== LOGIN =====");

            System.out.print("Enter Username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter Password: ");
            String loginPassword = input.nextLine();

            boolean loginStatus = user.loginUser(loginUsername, loginPassword);

            System.out.println(user.returnLoginStatus(loginStatus));

        } else {
            System.out.println("\nRegistration failed. Please try again!");
        }
    }
}
