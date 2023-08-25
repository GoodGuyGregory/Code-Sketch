import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

import java.util.Scanner;

public class Issue {

    public static Double determinePrice(Float price, int supplierDecimal) {
        String floatPrice = Float.toString(price);
        return Double.parseDouble(floatPrice.substring(0, supplierDecimal + 2));
    }

    private static Double determinePrice(Double price, int supplierDecimal) {
        String strPrice = Double.toString(price);
        if (strPrice.contains(".")) {
            String[] decimalPrice = strPrice.split("\\.");
            String dollarAmount = decimalPrice[0];
            if (decimalPrice[1].length() >= supplierDecimal) {
                String cents = decimalPrice[1].substring(0, supplierDecimal);
                return Double.parseDouble(dollarAmount + "." + cents);
            } else {
                return price;
            }
        } else {
            return price;
        }
    }

    public static void main(String args[]) {
        Scanner keyBoard = new Scanner(System.in);
        // read the price....
        System.out.println("What is the decimal value for price?");
        Double price = keyBoard.nextDouble();
        // determine the decimal value of the supplier....
        System.out.println("What is the decimal value for the Supplier?");
        int decimalCount = keyBoard.nextInt();
        keyBoard.close();
        System.out.println("Reduced decimal Value for price: " + determinePrice(price, decimalCount));

    }
}
