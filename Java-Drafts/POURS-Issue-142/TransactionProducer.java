// Java Program to Write into a File
// using FileWriterClass
 
// Importing required classes
import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.Instant;
import java.util.Calendar;

 
// Main class
public class TransactionProducer {
 
    // Main driver method
    public static void main(String[] args)
    {
 
        DateFormat RECEIPT_DATE_FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
        
        String localTimeZoneDate = RECEIPT_DATE_FORMAT.format(Calendar.getInstance().getTime());
        
        // System.out.println(localTimeZoneDate);
        // Instant localTimeZone = Instant.now();

        // String localTimeZoneDate = localTimeZone.toString();
        

        
        try {
            Timestamp timestampForBackendDB = new Timestamp(RECEIPT_DATE_FORMAT.parse(localTimeZoneDate).getTime());
              //  appended content to file.
            String inputDate = String.valueOf(timestampForBackendDB);
            System.out.println(inputDate);

            
        // // Try block to check if exception occurs
        // try {
 
        //     // Create a FileWriter object
        //     // to write in the file
        //     FileWriter fWriter = new FileWriter(
        //         "/c/Users/058620/Github/Code-Sketch/Java-Drafts/POURS-Issue-142/date-db.txt");
 
        //     // Writing into file
        //     // Note: The content taken above inside the
        //     // string
        //     fWriter.write(text);
 
        //     // Printing the contents of a file
        //     System.out.println(text);
 
        //     // Closing the file writing connection
        //     fWriter.close();
 
        //     // Display message for successful execution of
        //     // program on the console
        //     System.out.println(
        //         "File is created successfully with the content.");
        // }
 
        // // Catch block to handle if exception occurs
        // catch (IOException e) {
 
        //     // Print the exception
        //     System.out.print(e.getMessage());
        // }

        } catch (ParseException e) {

            e.printStackTrace();
        }

    } // main
}// class