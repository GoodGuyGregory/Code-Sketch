
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Issue {
    // Date string for filename needs to be in the following format
    // <EEE>_<LLL>_<dd>_<hh>-<mm>-<ss>_<zzz>_<YYYY>.xml
    private static final DateTimeFormatter dtfDateTime = DateTimeFormatter.ofPattern("EEE_LLL_DD_HH-mm-ss_zzz_YYYY");

    public static void main(String[] args) {
        Instant now = Instant.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println(zonedDateTime.format(dtfDateTime));

    }

}
