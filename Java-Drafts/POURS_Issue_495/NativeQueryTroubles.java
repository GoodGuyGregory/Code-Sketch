
import java.util.Scanner;

public class NativeQueryTroubles {

    public static void main(String[] args) {
        String partVersionJson = "'\"versionId\":";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the partVersion number");
        String partVersion = sc.nextLine();
        
        System.out.println(partVersionJson + partVersion + "\'");
    }

}
