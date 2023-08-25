import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class EmailDuplicate {

    public static Boolean checkingforpeanutButter(String maybePb) {
        return maybePb.equals("peanutbutter");
    }

    public static List<String> secondWayDuplicate(List<String> duplicateList) {
        List<String> listWithoutDuplicates = duplicateList.stream()
        .filter(EmailDuplicate::checkingforpeanutButter)
        .collect(Collectors.toList());
        return listWithoutDuplicates;
    }
    
    public static List<String> removeDuplicated(List<String> duplicateList) {
        List<String> listWithoutDuplicates = duplicateList.stream()
        .distinct()
        .collect(Collectors.toList());
        return listWithoutDuplicates;
    }

    public static void main(String[] args) {

        // create duplicate list
        List<String> goodFood = new ArrayList<String>();

        goodFood.add("peanutbutter");
        goodFood.add("oatmeal");
        goodFood.add("banananas");
        goodFood.add("strawberries");
        goodFood.add("bread");
        goodFood.add("peanutbutter");


        System.out.println(secondWayDuplicate(goodFood));
    }

}
