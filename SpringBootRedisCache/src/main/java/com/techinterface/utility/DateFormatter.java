package com.techinterface.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateFormatter {

    public static String getFormattedDate(LocalDateTime localDateTime){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = localDateTime.format(format);
        return formatDateTime;
    }
}
