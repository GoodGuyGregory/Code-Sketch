import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupEmails {
    public Map<String, List<String>> connections = new HashMap<String, List<String>>();
    public List<String> friends = new ArrayList<String>();

    public static void main(String[] args) {
        GroupEmails testObject = new GroupEmails();

        testObject.friends.add("Kit");
        testObject.friends.add("Jeff");
        testObject.friends.add("Matt");
        testObject.friends.add("Angie");
        testObject.friends.add("Jordan");
        testObject.friends.add("Evan");

        testObject.connections.put("Greggo", testObject.friends);

        // attempt to iterate through these objects
        for (String friend : testObject.connections.get("Greggo")) {
            System.out.println(friend);
        }
    }
}
