import java.util.HashSet;

public class TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("UC3 Track Unique Bogie IDs");

        HashSet<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");
        bogieIds.add("BG104");
        bogieIds.add("BG102");  

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogieIds);

        System.out.println("Note:");
        System.out.println("Duplicates are automatically ignored by HashSet.");

        System.out.println("UC3 uniqueness validation completed...");
    }
}