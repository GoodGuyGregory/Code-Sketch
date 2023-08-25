import java.util.Calendar;

public class Issue {
    public static void main(String[] args) {
        Calendar currentTime = Calendar.getInstance();
        int currentDate = currentTime.get(Calendar.YEAR);
        System.out.println(currentDate);
    }
}