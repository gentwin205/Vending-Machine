package com.techelevator.view;

import java.io.PrintWriter;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Logs {
    private String startLog(String condition, Items item, double start, double end){
        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        String date = String.valueOf(formatter);
        String formattedTime = LocalDateTime.now().format(formatter);
        NumberFormat formattedAmount = NumberFormat.getCurrencyInstance(Locale.US);
        String startBalance = formattedAmount.format(start);
        String endBalance = formattedAmount.format(end);

        return String.format(date, condition , startBalance, endBalance );
    }


}
