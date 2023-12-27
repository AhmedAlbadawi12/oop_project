package utils;

public class Validation {
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
}
