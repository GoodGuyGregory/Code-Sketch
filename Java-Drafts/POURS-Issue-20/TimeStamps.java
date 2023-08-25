import java.util.Date;
import java.time.*;

public class TimeStamps {

    
    public static void main(String args[]) {
        System.out.println("=================================================");
        // Standard Java Date
        Date today = new Date();
        System.out.println("Standard Java.Date: " + today.toString());
        System.out.println("=================================================");
        
        long millis = System.currentTimeMillis();
        java.sql.Date dateOfInitialPassword = new java.sql.Date(millis);
        System.out.println("SQL Date: " + dateOfInitialPassword);

        System.out.println("=================================================");
        // convert time to local date
        LocalDate ld = dateOfInitialPassword.toLocalDate();
        //  add six months to the password time
        LocalDate sixMonthsLater  = ld.plusMonths(6);
        // convert back to sql Date for storage in DB...
        java.sql.Date sqlDate = java.sql.Date.valueOf(sixMonthsLater);
        System.out.println("Java.time Conversion implementation: " + sqlDate);

    }
}
