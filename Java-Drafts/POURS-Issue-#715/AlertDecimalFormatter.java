import java.text.DecimalFormat;

public class AlertDecimalFormatter {

    public static String decimalFormatter(Double priceProvided) {
        DecimalFormat poursDecFormatter = new DecimalFormat("#.######");

        String parsedPrice = poursDecFormatter.format(priceProvided);

        return parsedPrice;

    }

    public static void main(String[] args) {
        
        System.out.println(decimalFormatter(0.00069));
        System.out.println(decimalFormatter(0.0009));
    }
}