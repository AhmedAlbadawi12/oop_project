package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parsing {
    public static Date parseStringToDate(String dateString) {
        try {
            // Create a SimpleDateFormat with the desired date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");

            // Parse the string and convert it to a Date object
            return dateFormat.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }
}
