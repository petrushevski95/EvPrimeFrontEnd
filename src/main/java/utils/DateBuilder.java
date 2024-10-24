package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateBuilder {

    public static String currentTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd, MMMM, yyyy");
        return currentDateTime.format(formatter);
    }
}
