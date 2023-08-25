import java.util.Random; 
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeneratePassword {
    
    private String password;

// No Argument Constructor
    GeneratePassword() {
       this.password = "";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String generateRandomPassword() {
        String RandomChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int number = new Random().nextInt(RandomChars.length());
            char c = RandomChars.charAt(number);
            password.append(c);
        }

        System.out.println("Randomly Generated Password: " + password.toString());
        return password.toString();
    }

    public String generateSHA() throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-512");

//        Generate a Random String of Numbers and Letters.
        String tempPassword = this.generateRandomPassword();
        // System.out.println(tempPassword);

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        byte[] passwordHash =  md.digest(tempPassword.getBytes(StandardCharsets.UTF_8));

        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, passwordHash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
        System.out.println("Hashed Password: " + hexString.toString());
        return hexString.toString();
    }

    
    public static void main(String[] args) {
        //  Step 1: Random Password generation:

        // create test one class.
        GeneratePassword stepOne = new GeneratePassword();
        //  Store Hashed password
        StringBuilder hashPassword = new StringBuilder();

        String password = stepOne.generateRandomPassword();
        hashPassword.append(password);

        stepOne.setPassword(hashPassword.toString());
        System.out.println(stepOne.getPassword());

        // Step 2: Check Password Hash and Original Password..
        
        GeneratePassword stepTwo = new GeneratePassword();

        try {
            System.out.println("Testing Hashing Functionality:");
            System.out.println("===================================");
            System.out.println(stepTwo.generateSHA());
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println("Threw Exception" + e);
        }

    }
}
