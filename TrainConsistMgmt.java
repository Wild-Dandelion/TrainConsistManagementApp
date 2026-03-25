import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Map;

public class TrainConsistMgmt {
    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("UC6 Map Bogie to Capacity");
        System.out.println("================================\n");

        LinkedHashSet<String> train = new LinkedHashSet<>();

        HashMap<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);
        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("Cargo", 120);

        System.out.println("Bogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}