package utils;

import java.util.Date;

public class Validation {

    public static boolean isValidDate(Date expiryDate) {

    }

    //-----------------------------------------------------------------------//

    public static boolean isValidEmail(String email) {
        // Split email at the "@" into array parts
        String[] parts = email.split("@");

        // Check if the parts are only 2 (if there is only one @)
        if (parts.length == 2) {
            // assign the parts to username and domain
            String username = parts[0];
            String domain = parts[1];

            // Check if the username and domain are not empty
            if (!username.isEmpty() && !domain.isEmpty()) {
                // Initialize a variable to store how many points in domain
                int numOfPoints = 0;
                // Loop over every character in the domain
                for (char c : domain.toCharArray()) {
                    // If the character is a "."
                    if (String.valueOf(c).equals(".")) {
                        // Add 1 to the numOfPoints variable
                        numOfPoints++;
                    }
                }

                // If there is only 1 point, return true
                return numOfPoints == 1;
            }
        }
        // If all conditions are not met, return false
        return false;
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                containsDigit(password) &&
                containsLowerCase(password) &&
                containsUpperCase(password) &&
                containsSpecialCharacter(password);
    }

    private static boolean containsDigit(String pass) {
        // Check if the string contains at least one digit
        for (char c : pass.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsUpperCase(String pass) {
        // Check if the string contains at least one digit
        for (char c : pass.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLowerCase(String pass) {
        // Check if the string contains at least one digit
        for (char c : pass.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSpecialCharacter(String pass) {
        // Check if the string contains at least one special character
        String specialCharacters = "!@#$%^&*()-_=+{};:,<.>/?";
        for (char c : pass.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}
